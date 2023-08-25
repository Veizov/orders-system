package com.notificationprovider.ordersapi.service.store;

import com.notificationprovider.ordersapi.domain.dto.store.StoreOrderDto;
import com.notificationprovider.ordersapi.domain.event.store.ProcessStoreOrderEvent;
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
    private final ProcessStoreOrderMapper createStoreOrderMapper;

    @Override
    public void processOrder(StoreOrderDto orderDto, Integer storeId) {
        //TODO Validator
        ProcessStoreOrderEvent eventObject = createStoreOrderMapper.toEventObject(orderDto, storeId);
        createOrderProducer.sendEvent(eventObject);
    }
}
