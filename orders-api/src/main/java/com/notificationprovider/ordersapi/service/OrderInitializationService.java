package com.notificationprovider.ordersapi.service;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.OrderableDto;

public interface OrderInitializationService<T extends OrderableDto> {

    NotFinishedProcessDto initializeOrder(T orderDto, Integer id);

}
