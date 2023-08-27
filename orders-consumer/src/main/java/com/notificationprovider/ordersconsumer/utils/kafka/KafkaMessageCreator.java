package com.notificationprovider.ordersconsumer.utils.kafka;

import com.notificationprovider.ordersconsumer.domain.enums.EventType;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaMessageCreator<K, V> {

    public ProducerRecord<K, V> create(String topic, K key, V value, EventType eventType) {
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("X-Event-Type", eventType.getCode().getBytes()));
        return new ProducerRecord<>(topic, null, key, value, headers);
    }

}
