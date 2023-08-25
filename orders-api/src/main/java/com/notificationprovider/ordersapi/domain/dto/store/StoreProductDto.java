package com.notificationprovider.ordersapi.domain.dto.store;

import com.notificationprovider.ordersapi.domain.dto.SellableDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class StoreProductDto implements SellableDto {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
