package com.notificationprovider.ordersapi.domain.mapper;

import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import com.notificationprovider.ordersapi.domain.event.Order;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class OrderMapper {

    @Mapping(target = "storeId", expression = "java(storeId)")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "shopperLastName", source = "shopperLastName")
    @Mapping(target = "shopperEmail", source = "shopperEmail")
    @Mapping(target = "orderDate", source = "createdDate")
    @Mapping(target = "products", source = "products")
    public abstract Order toEventObject(OrderDto dto, @Context Integer storeId);
}
