package com.notificationprovider.ordersapi.service;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.OrderPublicationEvent;
import com.notificationprovider.ordersapi.domain.mapper.EventResultMapper;
import com.notificationprovider.ordersapi.domain.mapper.OrderPublicationMapper;
import com.notificationprovider.ordersapi.producer.OrderPublicationProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService implements OrderPublicationService<OrderDto> {

    private final OrderPublicationProducer producer;
    private final OrderPublicationMapper orderPublicationMapper;
    private final EventResultMapper eventResultMapper;

    @Override
    public NotFinishedProcessDto publishOrder(OrderDto orderDto, Integer storeId) {
        //TODO Validator
        OrderPublicationEvent eventObject = orderPublicationMapper.toEventObject(orderDto, storeId);
        EventResult eventResult = producer.sendEvent(eventObject);
        return eventResultMapper.toNotFinishedProcessDto(eventResult);
    }
}
