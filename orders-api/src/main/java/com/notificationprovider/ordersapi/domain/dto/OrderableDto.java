package com.notificationprovider.ordersapi.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderableDto<P extends SellableDto> {

    LocalDateTime getCreatedDate();

    String getShopperEmail();

    String getShopperFirstName();

    String getShopperLastName();

    List<P> getProducts();
}