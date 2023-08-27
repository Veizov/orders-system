package com.notificationprovider.ordersconsumer.mapper;

import com.notificationprovider.ordersconsumer.domain.event.Store;
import com.notificationprovider.ordersconsumer.domain.entity.StoreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StoreMapper extends BaseMapper<StoreEntity, Store> {

}
