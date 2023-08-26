package com.notificationprovider.ordersapi.service;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.OrderableDto;

public interface OrderPublicationService<T extends OrderableDto> {

    NotFinishedProcessDto publishOrder(T orderDto, Integer id);

}
