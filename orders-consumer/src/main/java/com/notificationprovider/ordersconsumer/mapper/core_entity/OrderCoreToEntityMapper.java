package com.notificationprovider.ordersconsumer.mapper.core_entity;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.entity.OrderEntity;
import com.notificationprovider.ordersconsumer.domain.entity.ProductEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring", uses = {StoreCoreToEntityMapper.class, ProductCoreToEntityMapper.class})
public abstract class OrderCoreToEntityMapper extends BaseCoreToEntityMapper<OrderEntity, OrderCore> {

    @AfterMapping
    public void afterToEntity(OrderCore source, @MappingTarget OrderEntity target) {
        setProductsData(target);
        setCreatedDate(target);
    }

    private static void setProductsData(OrderEntity target) {
        List<ProductEntity> products = target.getProducts();
        if (Objects.isNull(products)) {
            target.setProducts(new ArrayList<>());
        } else {
            products.forEach(p -> p.setOrder(target));
        }
    }

    private static void setCreatedDate(OrderEntity target) {
        if (Objects.isNull(target.getDateCreated())) {
            LocalDateTime dateCreated = LocalDateTime.now();
            target.setDateCreated(dateCreated);
            if (!CollectionUtils.isEmpty(target.getProducts())) {
                target.getProducts().forEach(p -> p.setDateCreated(dateCreated));
            }
        }
    }

}
