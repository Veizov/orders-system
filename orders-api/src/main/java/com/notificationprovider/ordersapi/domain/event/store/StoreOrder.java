package com.notificationprovider.ordersapi.domain.event.store;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class StoreOrder {

    private Long id;
    private LocalDateTime orderDate;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private List<StoreProduct> products;

}