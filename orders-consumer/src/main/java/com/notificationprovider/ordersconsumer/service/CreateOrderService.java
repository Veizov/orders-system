package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;
import com.notificationprovider.ordersconsumer.mapper.created.CreatedOrderMapper;
import com.notificationprovider.ordersconsumer.mapper.published.PublishedOrderMapper;
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
    private final PublishedOrderMapper publishedOrderMapper;
    private final CreatedOrderMapper createdOrderMapper;
    private final OrderCrudService orderCrudService;

    @Transactional
    public void create(PublishedOrder publishedOrder) {
        Order savedOrder = orderCrudService.create(publishedOrderMapper.toOrder(publishedOrder));
        createdOrdersProducer.sendEvent(createdOrderMapper.toCreatedOrder(savedOrder));
    }

}
