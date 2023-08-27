package com.notificationprovider.ordersconsumer.mapper.published;

import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {PublishedProductMapper.class})
public abstract class PublishedOrderMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "store.id", source = "storeId")
    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "shopperEmail", source = "shopperEmail")
    @Mapping(target = "shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "shopperLastName", source = "shopperLastName")
    @Mapping(target = "dateOrdered", source = "orderDate")
    @Mapping(target = "products", source = "products")
    public abstract Order toOrder(PublishedOrder publishedOrder);

}
