package com.notificationprovider.ordersconsumer.listener;

import com.notificationprovider.ordersconsumer.domain.event.PublishedOrderEvent;
import com.notificationprovider.ordersconsumer.enums.EventType;
import com.notificationprovider.ordersconsumer.utils.json.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class PublishedOrdersListener {

    private final JsonUtils jsonUtils;

    @KafkaListener(
            topics = "#{'${kafka.order.topic.published-order.name}'}",
            groupId = "#{'${kafka.order.group}'}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listenForPublishedOrders(
            @Payload String data,
            @Header(KafkaHeaders.OFFSET) Long offset,
            @Header("X-Event-Type") String eventType,
            Acknowledgment acknowledgment
    ) {
        if (!isValidEventType(eventType)) {
            return;
        }
        log.info("[PUBLISHED ORDER] Message received! Event type: {} Offset: {}, Data: {}", eventType, offset, data);
        PublishedOrderEvent publishedOrder = jsonUtils.readJson(data, PublishedOrderEvent.class);
        processEvent(publishedOrder);
        acknowledgment.acknowledge();
    }

    private void processEvent(PublishedOrderEvent publishedOrder) {
        //TODO Implement processing logic
    }

    private boolean isValidEventType(String eventType) {
        return Objects.nonNull(eventType) && eventType.equalsIgnoreCase(EventType.PUBLISHED_ORDER.getCode());
    }
}
