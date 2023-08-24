package com.notificationprovider.ordersapi.domain.event.store;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class StoreProduct {

    private String externalId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}