package com.notificationprovider.ordersconsumer.mapper.core_event;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.event.PublishedOrder;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CEventPublishedProductMapper.class})
public abstract class CEventPublishedOrderMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "store.id", source = "storeId")
    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "shopperEmail", source = "shopperEmail")
    @Mapping(target = "shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "shopperLastName", source = "shopperLastName")
    @Mapping(target = "dateOrdered", source = "orderDate")
    @Mapping(target = "products", source = "products")
    public abstract OrderCore toCore(PublishedOrder eventObject);

}
