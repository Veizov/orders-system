package com.notificationprovider.ordersapi.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}