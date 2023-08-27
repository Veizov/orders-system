package com.notificationprovider.ordersconsumer.domain.mapper.created;

import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.event.created.CreatedOrder;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CreatedProductMapper.class, CreatedStoreMapper.class})
public abstract class CreatedOrderMapper {

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
    public abstract CreatedOrder toCreatedOrder(Order order);

}
