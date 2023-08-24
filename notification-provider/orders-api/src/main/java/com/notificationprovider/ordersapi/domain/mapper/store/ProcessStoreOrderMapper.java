package com.notificationprovider.ordersapi.domain.mapper.store;

import com.notificationprovider.ordersapi.domain.dto.store.StoreOrderDto;
import com.notificationprovider.ordersapi.domain.event.store.ProcessStoreOrderEvent;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {StoreProductMapper.class})
public abstract class ProcessStoreOrderMapper {

    @Mapping(target = "storeId", expression = "java(storeId)")
    @Mapping(target = "order.shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "order.shopperLastName", source = "shopperLastName")
    @Mapping(target = "order.shopperEmail", source = "shopperEmail")
    @Mapping(target = "order.orderDate", source = "createdDate")
    @Mapping(target = "order.products", source = "products")
    public abstract ProcessStoreOrderEvent toEventObject(StoreOrderDto dto, @Context Integer storeId);
}
