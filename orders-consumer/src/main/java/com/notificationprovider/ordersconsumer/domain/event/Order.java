package com.notificationprovider.ordersconsumer.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {

    private Long id;
    private Store store;
    private Long externalId;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private LocalDateTime dateCreated;
    private LocalDateTime dateOrdered;
    private List<Product> products;

}
