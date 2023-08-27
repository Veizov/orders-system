package com.notificationprovider.ordersconsumer.service.db;

import com.notificationprovider.ordersconsumer.domain.event.Order;

public interface OrderService extends CrudService<Order, Long> {

    boolean isNewOrder(Integer storeId, Long externalId);

}
