package com.notificationprovider.ordersconsumer.listener;

import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;
import com.notificationprovider.ordersconsumer.service.OrderEventsService;
import com.notificationprovider.ordersconsumer.utils.json.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PublishedOrdersListener {

    private final JsonUtils jsonUtils;
    private final OrderEventsService orderEventsService;

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
        if (orderEventsService.ignoreMessage(eventType, data)) {
            return;
        }

        log.info("[PUBLISHED ORDER] Message received! Event type: {} Offset: {}, Data: {}", eventType, offset, data);
        PublishedOrder publishedOrder = jsonUtils.readJson(data, PublishedOrder.class);
        orderEventsService.create(publishedOrder);
        acknowledgment.acknowledge();
    }

}
