package com.notificationprovider.ordersconsumer.domain.event.created;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreatedProduct {

    private Long databaseId;
    private Long externalId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
