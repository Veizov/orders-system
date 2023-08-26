package com.notificationprovider.ordersapi.producer;

import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.store.StoreOrderInitEvent;
import com.notificationprovider.ordersapi.exception.KafkaSendEventException;
import com.notificationprovider.ordersapi.property.KafkaProperties;
import com.notificationprovider.ordersapi.utils.json.JsonUtils;
import com.notificationprovider.ordersapi.utils.message.MessageKeyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreOrderInitProducer {

    private final KafkaTemplate<String, StoreOrderInitEvent> kafkaTemplate;
    private final KafkaProperties kafkaProperties;
    private final JsonUtils jsonUtils;

    public EventResult sendEvent(StoreOrderInitEvent order) {
        try {
            String topic = kafkaProperties.getInitOrderTopic();
            String key = MessageKeyUtils.createStoreOrderMessageKey(order.getStoreId());

            SendResult<String, StoreOrderInitEvent> sendResult = kafkaTemplate
                    .send(topic, key, order)
                    .get(2L, TimeUnit.SECONDS);

            log.info("[Initialize store order event] New event has been created!\n {}", jsonUtils.createJson(order));
            log.info(sendResult.toString());
            return EventResult.newInstance(sendResult.getRecordMetadata());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new KafkaSendEventException(e.getMessage(), e);
        }
    }
}