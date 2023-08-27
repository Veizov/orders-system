package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.event.MessageIgnore;
import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;
import com.notificationprovider.ordersconsumer.domain.enums.EventType;
import com.notificationprovider.ordersconsumer.domain.mapper.created.CreatedOrderMapper;
import com.notificationprovider.ordersconsumer.domain.mapper.published.PublishedOrderMapper;
import com.notificationprovider.ordersconsumer.producer.CreatedOrdersProducer;
import com.notificationprovider.ordersconsumer.service.db.OrderService;
import com.notificationprovider.ordersconsumer.utils.json.JsonManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublishedOrderEventServiceImpl implements PublishedOrderEventService {

    private final CreatedOrdersProducer createdOrdersProducer;
    private final PublishedOrderMapper publishedOrderMapper;
    private final CreatedOrderMapper createdOrderMapper;
    private final OrderService orderService;

    @Transactional
    public void create(PublishedOrder publishedOrder) {
        Order savedOrder = orderService.insert(publishedOrderMapper.toOrder(publishedOrder));
        createdOrdersProducer.sendEvent(createdOrderMapper.toCreatedOrder(savedOrder));
    }

    @Override
    public MessageIgnore ignoreMessage(String eventType, String json) {
        if (!(Objects.nonNull(eventType) && eventType.equalsIgnoreCase(EventType.PUBLISHED_ORDER.getCode()))) {
            return MessageIgnore.ignore();
        }

        PublishedOrder publishedOrder = JsonManager.readJson(json, PublishedOrder.class);
        Integer storeId = publishedOrder.getStoreId();
        Long externalId = publishedOrder.getId();
        if (!(orderService.isNewOrder(storeId, externalId))) {
            log.warn("[PUBLISHED ORDER] Message is ignored, but will be marked as acknowledged, because it has already been inserted in the database! StoreId: {}, ExternalOrderId: {} ", storeId, externalId);
            return MessageIgnore.ignoreAndAcknowledge();
        }

        return MessageIgnore.proceed();
    }

}
