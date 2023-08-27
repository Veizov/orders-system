package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;
import com.notificationprovider.ordersconsumer.enums.EventType;
import com.notificationprovider.ordersconsumer.mapper.created.CreatedOrderMapper;
import com.notificationprovider.ordersconsumer.mapper.published.PublishedOrderMapper;
import com.notificationprovider.ordersconsumer.producer.CreatedOrdersProducer;
import com.notificationprovider.ordersconsumer.service.db.OrderService;
import com.notificationprovider.ordersconsumer.utils.json.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventsServiceImpl implements OrderEventsService {

    private final CreatedOrdersProducer createdOrdersProducer;
    private final PublishedOrderMapper publishedOrderMapper;
    private final CreatedOrderMapper createdOrderMapper;
    private final OrderService orderService;
    private final JsonUtils jsonUtils;

    @Transactional
    public void create(PublishedOrder publishedOrder) {
        Order savedOrder = orderService.insert(publishedOrderMapper.toOrder(publishedOrder));
        createdOrdersProducer.sendEvent(createdOrderMapper.toCreatedOrder(savedOrder));
    }

    @Override
    public boolean ignoreMessage(String eventType, String json) {
        if (!(Objects.nonNull(eventType) && eventType.equalsIgnoreCase(EventType.PUBLISHED_ORDER.getCode()))) {
            return true;
        }

        PublishedOrder publishedOrder = jsonUtils.readJson(json, PublishedOrder.class);
        Integer storeId = publishedOrder.getStoreId();
        Long externalId = publishedOrder.getId();
        if (!(orderService.isNewOrder(storeId, externalId))) {
            log.warn("[PUBLISHED ORDER] Message is ignored, because it has already been processed! StoreId: {}, ExternalOrderId: {} ", storeId, externalId);
            return true;
        }

        return false;
    }

}
