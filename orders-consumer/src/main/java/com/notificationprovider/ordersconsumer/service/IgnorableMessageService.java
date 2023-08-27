package com.notificationprovider.ordersconsumer.service;


public interface IgnorableMessageService {

    boolean ignoreMessage(String eventType, String json);

}
