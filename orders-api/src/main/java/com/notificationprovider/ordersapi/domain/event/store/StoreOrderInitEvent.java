package com.notificationprovider.ordersapi.domain.event.store;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrderInitEvent {
    private Integer storeId;
    private StoreOrder order;
}