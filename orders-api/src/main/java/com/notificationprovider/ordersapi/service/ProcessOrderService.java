package com.notificationprovider.ordersapi.service;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.OrderableDto;

public interface ProcessOrderService<T extends OrderableDto> {

    NotFinishedProcessDto processOrder(T orderDto, Integer id);

}
