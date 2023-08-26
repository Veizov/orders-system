package com.notificationprovider.ordersconsumer.domain.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PublishedOrder {

    private Long id;
    private LocalDateTime orderDate;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private List<PublishedProduct> products;

}