package com.notificationprovider.ordersconsumer.mapper.core_event;

import com.notificationprovider.ordersconsumer.domain.core.ProductCore;
import com.notificationprovider.ordersconsumer.domain.event.created.CreatedProduct;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CEventCreatedProductMapper.class})
public abstract class CEventCreatedProductMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "databaseId", source = "id")
    @Mapping(target = "externalId", source = "externalId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    public abstract CreatedProduct toEventObject(ProductCore productCore);

}
