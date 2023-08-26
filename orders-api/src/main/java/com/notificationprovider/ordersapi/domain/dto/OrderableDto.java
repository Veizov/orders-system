package com.notificationprovider.ordersapi.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderableDto<P extends SellableDto> {

    Long getId();

    LocalDateTime getCreatedDate();

    String getShopperEmail();

    String getShopperFirstName();

    String getShopperLastName();

    List<P> getProducts();
}