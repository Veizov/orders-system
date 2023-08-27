package com.notificationprovider.ordersconsumer.domain.mapper;

import com.notificationprovider.ordersconsumer.domain.event.Product;
import com.notificationprovider.ordersconsumer.domain.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper extends BaseMapper<ProductEntity, Product> {

}
