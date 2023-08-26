package com.notificationprovider.ordersconsumer.mapper.core_entity;

import com.notificationprovider.ordersconsumer.domain.core.StoreCore;
import com.notificationprovider.ordersconsumer.domain.entity.StoreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StoreCoreToEntityMapper extends BaseCoreToEntityMapper<StoreEntity, StoreCore> {

}
