package com.notificationprovider.ordersconsumer.domain.event;

import lombok.*;

@Getter
@Setter
public class PublishedOrderEvent {

    private Integer storeId;
    private PublishedOrder order;

}