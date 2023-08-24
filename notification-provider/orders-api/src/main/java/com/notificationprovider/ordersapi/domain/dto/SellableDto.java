package com.notificationprovider.ordersapi.domain.dto;

import java.math.BigDecimal;

public interface SellableDto {

    String getExternalId();

    String getName();

    String getDescription();

    BigDecimal getPrice();

    Integer getQuantity();
}