package com.notificationprovider.ordersconsumer.mapper.core_entity;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StoreCoreToEntityMapper.class, ProductCoreToEntityMapper.class})
public abstract class OrderCoreToEntityMapper extends BaseCoreToEntityMapper<OrderEntity, OrderCore> {

}
