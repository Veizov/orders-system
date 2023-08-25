package com.notificationprovider.ordersapi.domain.event.store;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessStoreOrderEvent {
    private Integer storeId;
    private StoreOrder order;
}