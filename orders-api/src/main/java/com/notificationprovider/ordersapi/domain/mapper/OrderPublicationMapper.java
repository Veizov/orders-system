package com.notificationprovider.ordersapi.domain.mapper;

import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import com.notificationprovider.ordersapi.domain.event.OrderPublicationEvent;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class OrderPublicationMapper {

    @Mapping(target = "storeId", expression = "java(storeId)")
    @Mapping(target = "order.id", source = "id")
    @Mapping(target = "order.shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "order.shopperLastName", source = "shopperLastName")
    @Mapping(target = "order.shopperEmail", source = "shopperEmail")
    @Mapping(target = "order.orderDate", source = "createdDate")
    @Mapping(target = "order.products", source = "products")
    public abstract OrderPublicationEvent toEventObject(OrderDto dto, @Context Integer storeId);
}
