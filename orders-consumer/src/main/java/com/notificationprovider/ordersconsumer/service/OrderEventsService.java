package com.notificationprovider.ordersconsumer.service;

import com.notificationprovider.ordersconsumer.domain.event.published.PublishedOrder;

public interface OrderEventsService extends CreatableEventService<PublishedOrder>, IgnorableMessageService {

}
