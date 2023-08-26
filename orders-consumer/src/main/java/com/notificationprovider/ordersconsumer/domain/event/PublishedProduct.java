package com.notificationprovider.ordersconsumer.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PublishedProduct {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}