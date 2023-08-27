package com.notificationprovider.ordersconsumer.producer;

import com.notificationprovider.ordersconsumer.domain.event.created.CreatedOrder;
import com.notificationprovider.ordersconsumer.domain.event.EventResult;
import com.notificationprovider.ordersconsumer.domain.enums.EventType;
import com.notificationprovider.ordersconsumer.exception.KafkaSendEventException;
import com.notificationprovider.ordersconsumer.property.KafkaProperties;
import com.notificationprovider.ordersconsumer.utils.json.JsonUtils;
import com.notificationprovider.ordersconsumer.utils.kafka.KafkaMessageCreator;
import com.notificationprovider.ordersconsumer.utils.kafka.KafkaMessageKeyCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatedOrdersProducer {

    private final KafkaMessageKeyCreator messageKeyCreator;
    private final KafkaMessageCreator<String, CreatedOrder> messageCreator;
    private final KafkaTemplate<String, CreatedOrder> kafkaTemplate;
    private final KafkaProperties kafkaProperties;
    private final JsonUtils jsonUtils;

    public EventResult sendEvent(CreatedOrder order) {
        try {
            String topic = kafkaProperties.getCreatedOrderTopic();
            String key = messageKeyCreator.createOrderKey(order.getStoreId());
            ProducerRecord<String, CreatedOrder> message = messageCreator.create(topic, key, order, EventType.CREATED_ORDER);
            SendResult<String, CreatedOrder> sendResult = kafkaTemplate.send(message).get(2L, TimeUnit.SECONDS);
            log.info("[CreatedOrderEvent] New event has been created!\n {}", jsonUtils.createJson(order));
            log.info(sendResult.toString());
            return EventResult.newInstance(sendResult.getRecordMetadata());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new KafkaSendEventException(e.getMessage(), e);
        }
    }
}