package com.notificationprovider.ordersapi.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto implements SellableDto {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
