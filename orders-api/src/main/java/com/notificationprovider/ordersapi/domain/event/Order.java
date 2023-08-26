package com.notificationprovider.ordersapi.domain.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class Order {

    private Long id;
    private Integer storeId;
    private LocalDateTime orderDate;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private List<Product> products;

}