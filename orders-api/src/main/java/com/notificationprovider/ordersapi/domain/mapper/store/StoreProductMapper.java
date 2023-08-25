package com.notificationprovider.ordersapi.domain.mapper.store;

import com.notificationprovider.ordersapi.domain.dto.store.StoreProductDto;
import com.notificationprovider.ordersapi.domain.event.store.StoreProduct;
import com.notificationprovider.ordersapi.domain.mapper.BaseDtoEventObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public abstract class StoreProductMapper extends BaseDtoEventObjectMapper<StoreProduct, StoreProductDto> {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    public abstract StoreProduct toEventObject(StoreProductDto dto);
}
