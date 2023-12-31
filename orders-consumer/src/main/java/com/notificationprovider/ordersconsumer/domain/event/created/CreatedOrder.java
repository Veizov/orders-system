package com.notificationprovider.ordersconsumer.domain.event.created;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreatedOrder {

    private Long databaseId;
    private Long externalId;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private LocalDateTime dateOrdered;
    private LocalDateTime dateCreated;
    private CreatedStore store;
    private List<CreatedProduct> products;

}
