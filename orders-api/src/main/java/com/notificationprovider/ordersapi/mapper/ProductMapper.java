package com.notificationprovider.ordersapi.mapper;

import com.notificationprovider.ordersapi.domain.dto.ProductDto;
import com.notificationprovider.ordersapi.domain.event.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public abstract class ProductMapper extends BaseMapper<Product, ProductDto> {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    public abstract Product toEventObject(ProductDto dto);
}
