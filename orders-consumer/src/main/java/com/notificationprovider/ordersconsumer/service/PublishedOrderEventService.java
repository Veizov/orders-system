package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;

public interface PublishedOrderEventService extends CreatableEventService<PublishedOrder>, IgnorableMessageService {

}
