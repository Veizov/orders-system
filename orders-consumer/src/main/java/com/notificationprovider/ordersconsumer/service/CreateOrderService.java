package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.event.PublishedOrder;
import com.notificationprovider.ordersconsumer.mapper.core_event.CEventPublishedOrderMapper;
import com.notificationprovider.ordersconsumer.service.db.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderService {

    private final CEventPublishedOrderMapper publishedOrderMapper;
    private final OrderService orderService;

    //TODO
    @Transactional
    public void create(PublishedOrder publishedOrder) {
        OrderCore orderCore = publishedOrderMapper.toCore(publishedOrder);
        orderService.create(orderCore);
    }

}
