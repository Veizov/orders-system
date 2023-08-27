package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;
import com.notificationprovider.ordersconsumer.mapper.core_event.CEventCreatedOrderMapper;
import com.notificationprovider.ordersconsumer.mapper.core_event.CEventPublishedOrderMapper;
import com.notificationprovider.ordersconsumer.producer.CreatedOrdersProducer;
import com.notificationprovider.ordersconsumer.service.db.OrderCrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderService {

    private final CreatedOrdersProducer createdOrdersProducer;
    private final CEventPublishedOrderMapper publishedOrderMapper;
    private final CEventCreatedOrderMapper createdOrderMapper;
    private final OrderCrudService orderCrudService;

    @Transactional
    public void create(PublishedOrder publishedOrder) {
        OrderCore savedOrder = orderCrudService.create(publishedOrderMapper.toCore(publishedOrder));
        createdOrdersProducer.sendEvent(createdOrderMapper.toEventObject(savedOrder));
    }

}
