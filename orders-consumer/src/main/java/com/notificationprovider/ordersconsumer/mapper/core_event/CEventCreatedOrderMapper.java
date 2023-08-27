package com.notificationprovider.ordersconsumer.mapper.core_event;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.event.CreatedOrder;
import com.notificationprovider.ordersconsumer.domain.event.PublishedOrder;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//TODO Products and store data
@Mapper(componentModel = "spring")
public abstract class CEventCreatedOrderMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "databaseId", source = "id")
    @Mapping(target = "externalId", source = "externalId")
    @Mapping(target = "storeId", source = "store.id")
    @Mapping(target = "shopperEmail", source = "shopperEmail")
    @Mapping(target = "shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "shopperLastName", source = "shopperLastName")
    @Mapping(target = "dateCreated", source = "dateCreated")
    @Mapping(target = "dateOrdered", source = "dateOrdered")
    @Mapping(target = "products", source = "products")
    public abstract CreatedOrder toEventObject(OrderCore coreOrder);

}
