package com.notificationprovider.ordersapi.domain.dto;

import java.math.BigDecimal;

public interface SellableDto {

    Integer getId();

    String getName();

    String getDescription();

    BigDecimal getPrice();

    Integer getQuantity();
}