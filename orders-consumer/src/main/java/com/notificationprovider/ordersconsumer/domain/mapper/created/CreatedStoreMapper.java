package com.notificationprovider.ordersconsumer.domain.mapper.created;

import com.notificationprovider.ordersconsumer.domain.event.Store;
import com.notificationprovider.ordersconsumer.domain.event.created.CreatedStore;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CreatedStoreMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "reviewUrl", source = "reviewUrl")
    public abstract CreatedStore toCreatedStore(Store store);

}
