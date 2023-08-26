package com.notificationprovider.ordersconsumer.domain.core;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderCore {

    private Long id;
    private StoreCore store;
    private Long externalId;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private LocalDateTime dateCreated;
    private LocalDateTime dateOrdered;
    private List<ProductCore> products;

}
