package com.notificationprovider.ordersapi.service;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.Order;
import com.notificationprovider.ordersapi.domain.mapper.EventResultMapper;
import com.notificationprovider.ordersapi.domain.mapper.OrderMapper;
import com.notificationprovider.ordersapi.producer.PublishedOrderProducer;
import com.notificationprovider.ordersapi.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService implements OrderPublicationService<OrderDto> {

    private final OrderMapper orderMapper;
    private final EventResultMapper eventResultMapper;
    private final PublishedOrderProducer producer;
    private final OrderValidator orderValidator;

    @Override
    public NotFinishedProcessDto publishOrder(OrderDto orderDto, Integer storeId) {
        orderValidator.validateAndThrow(orderDto);

        Order eventObject = orderMapper.toEventObject(orderDto, storeId);
        EventResult eventResult = producer.sendEvent(eventObject);
        return eventResultMapper.toNotFinishedProcessDto(eventResult);
    }
}
