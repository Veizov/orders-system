package com.notificationprovider.ordersapi.service;

import com.notificationprovider.ordersapi.domain.dto.OrderableDto;

public interface ProcessOrderService<T extends OrderableDto> {

    void processOrder(T orderDto, Integer id);

}
