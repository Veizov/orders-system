package com.notificationprovider.ordersconsumer.domain.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {

    private Integer id;
    private String name;
    private String description;
    private String reviewUrl;

}
