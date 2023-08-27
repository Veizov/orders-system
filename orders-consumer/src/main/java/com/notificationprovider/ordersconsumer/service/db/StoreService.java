package com.notificationprovider.ordersconsumer.service.db;

import com.notificationprovider.ordersconsumer.domain.event.Store;

public interface StoreService {

    Store selectById(Integer id);

}
