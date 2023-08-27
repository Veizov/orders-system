package com.notificationprovider.ordersconsumer.domain.mapper.created;

import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.event.Store;
import com.notificationprovider.ordersconsumer.domain.event.created.CreatedOrder;
import com.notificationprovider.ordersconsumer.service.db.StoreService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {CreatedProductMapper.class, CreatedStoreMapper.class})
public abstract class CreatedOrderMapper {

    @Autowired
    private StoreService storeService;

    @Autowired
    private CreatedStoreMapper createdStoreMapper;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "databaseId", source = "id")
    @Mapping(target = "externalId", source = "externalId")
    @Mapping(target = "shopperEmail", source = "shopperEmail")
    @Mapping(target = "shopperFirstName", source = "shopperFirstName")
    @Mapping(target = "shopperLastName", source = "shopperLastName")
    @Mapping(target = "dateCreated", source = "dateCreated")
    @Mapping(target = "dateOrdered", source = "dateOrdered")
    @Mapping(target = "store", source = "store")
    @Mapping(target = "products", source = "products")
    public abstract CreatedOrder toCreatedOrder(Order order);

    @AfterMapping
    public void afterToEntity(Order source, @MappingTarget CreatedOrder target) {
        setStoreData(target);
    }

    private void setStoreData(CreatedOrder target) {
        Integer storeId = target.getStore().getId();
        if (Objects.nonNull(storeId)) {
            Store store = storeService.selectById(storeId);
            if (Objects.nonNull(store)) {
                target.setStore(createdStoreMapper.toCreatedStore(store));
            }
        }
    }

}
