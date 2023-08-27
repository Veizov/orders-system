package com.notificationprovider.ordersconsumer.mapper.core_event;

import com.notificationprovider.ordersconsumer.domain.core.ProductCore;
import com.notificationprovider.ordersconsumer.domain.event.published.PublishedProduct;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public abstract class CEventPublishedProductMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    public abstract ProductCore toCore(PublishedProduct eventObject);

}
