package com.notificationprovider.ordersapi.domain.event;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPublicationEvent {

    private Integer storeId;
    private Order order;

}