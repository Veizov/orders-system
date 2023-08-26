package com.notificationprovider.ordersconsumer.mapper.core_entity;

import com.notificationprovider.ordersconsumer.domain.core.ProductCore;
import com.notificationprovider.ordersconsumer.domain.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductCoreToEntityMapper extends BaseCoreToEntityMapper<ProductEntity, ProductCore> {

}
