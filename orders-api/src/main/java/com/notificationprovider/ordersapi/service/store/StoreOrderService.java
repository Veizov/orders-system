package com.notificationprovider.ordersapi.service.store;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.store.StoreOrderDto;
import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.domain.event.store.ProcessStoreOrderEvent;
import com.notificationprovider.ordersapi.domain.mapper.EventResultMapper;
import com.notificationprovider.ordersapi.domain.mapper.store.ProcessStoreOrderMapper;
import com.notificationprovider.ordersapi.producer.ProcessStoreOrderProducer;
import com.notificationprovider.ordersapi.service.ProcessOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreOrderService implements ProcessOrderService<StoreOrderDto> {

    private final ProcessStoreOrderProducer createOrderProducer;
    private final ProcessStoreOrderMapper processStoreOrderMapper;
    private final EventResultMapper eventResultMapper;

    @Override
    public NotFinishedProcessDto processOrder(StoreOrderDto orderDto, Integer storeId) {
        //TODO Validator
        ProcessStoreOrderEvent eventObject = processStoreOrderMapper.toEventObject(orderDto, storeId);
        EventResult eventResult = createOrderProducer.sendEvent(eventObject);
        return eventResultMapper.toNotFinishedProcessDto(eventResult);
    }
}
