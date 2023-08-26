package com.notificationprovider.ordersconsumer.domain.core;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CProduct {

    private Long id;
    private Long externalId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime dateCreated;

}
