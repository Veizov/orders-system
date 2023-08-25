package com.notificationprovider.ordersapi.producer;

import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.store.ProcessStoreOrderEvent;
import com.notificationprovider.ordersapi.exception.KafkaSendEventException;
import com.notificationprovider.ordersapi.property.KafkaProperties;
import com.notificationprovider.ordersapi.utils.date.TimestampUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessStoreOrderProducer {

    private final KafkaTemplate<String, ProcessStoreOrderEvent> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public EventResult sendEvent(ProcessStoreOrderEvent order) {
        try {
            SendResult<String, ProcessStoreOrderEvent> sendResult = kafkaTemplate.send(kafkaProperties.getProcessOrderTopic(), order).get(2L, TimeUnit.SECONDS);
            log.info("Create order {} event sent via Kafka", order);
            log.info(sendResult.toString());
            return EventResult.newInstance(sendResult.getRecordMetadata());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new KafkaSendEventException(e.getMessage(), e);
        }
    }
}