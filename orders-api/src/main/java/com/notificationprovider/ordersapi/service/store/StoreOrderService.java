package com.notificationprovider.ordersapi.service.store;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.store.StoreOrderDto;
import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.store.StoreOrderInitEvent;
import com.notificationprovider.ordersapi.domain.mapper.EventResultMapper;
import com.notificationprovider.ordersapi.domain.mapper.store.StoreOrderInitMapper;
import com.notificationprovider.ordersapi.producer.StoreOrderInitProducer;
import com.notificationprovider.ordersapi.service.OrderInitializationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreOrderService implements OrderInitializationService<StoreOrderDto> {

    private final StoreOrderInitProducer producer;
    private final StoreOrderInitMapper inputMapper;
    private final EventResultMapper outputMapper;

    @Override
    public NotFinishedProcessDto initializeOrder(StoreOrderDto orderDto, Integer storeId) {
        //TODO Validator
        StoreOrderInitEvent eventObject = inputMapper.toEventObject(orderDto, storeId);
        EventResult eventResult = producer.sendEvent(eventObject);
        return outputMapper.toNotFinishedProcessDto(eventResult);
    }
}
