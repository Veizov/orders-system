package com.notificationprovider.ordersapi.domain.event;

import com.notificationprovider.ordersapi.utils.date.TimestampUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor(staticName = "newInstance")
public class EventResult {

    private String topic;
    private Integer partition;
    private Long offset;
    private LocalDateTime createdDate;

    public static EventResult newInstance(RecordMetadata recordMetadata) {
        return newInstance(recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), TimestampUtils.toLocalDateTime(recordMetadata.timestamp()));
    }
}