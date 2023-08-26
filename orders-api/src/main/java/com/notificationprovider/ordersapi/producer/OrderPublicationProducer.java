package com.notificationprovider.ordersapi.producer;

import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.Order;
import com.notificationprovider.ordersapi.enums.EventType;
import com.notificationprovider.ordersapi.exception.KafkaSendEventException;
import com.notificationprovider.ordersapi.property.KafkaProperties;
import com.notificationprovider.ordersapi.utils.json.JsonUtils;
import com.notificationprovider.ordersapi.utils.kafka.KafkaMessageCreator;
import com.notificationprovider.ordersapi.utils.kafka.KafkaMessageKeyCreator;
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
public class OrderPublicationProducer {

    private final KafkaMessageKeyCreator messageKeyCreator;
    private final KafkaMessageCreator<String, Order> messageCreator;
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final KafkaProperties kafkaProperties;
    private final JsonUtils jsonUtils;

    public EventResult sendEvent(Order order) {
        try {
            String topic = kafkaProperties.getPublishedOrderTopic();
            String key = messageKeyCreator.createOrderKey(order.getStoreId());
            ProducerRecord<String, Order> message = messageCreator.create(topic, key, order, EventType.PUBLISHED_ORDER);
            SendResult<String, Order> sendResult = kafkaTemplate.send(message).get(2L, TimeUnit.SECONDS);
            log.info("[OrderPublicationEvent] New event has been created!\n {}", jsonUtils.createJson(order));
            log.info(sendResult.toString());
            return EventResult.newInstance(sendResult.getRecordMetadata());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new KafkaSendEventException(e.getMessage(), e);
        }
    }
}