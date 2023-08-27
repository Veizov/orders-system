package com.notificationprovider.ordersconsumer.service;


import com.notificationprovider.ordersconsumer.domain.event.MessageIgnore;

public interface IgnorableMessageService {

    MessageIgnore ignoreMessage(String eventType, String json);

}
