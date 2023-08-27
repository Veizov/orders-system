package com.notificationprovider.ordersconsumer.enums;

import lombok.Getter;

@Getter
public enum EventType {
    PUBLISHED_ORDER("orders/published"),
    CREATED_ORDER("orders/created");

    private final String code;

    EventType(String code) {
        this.code = code;
    }
}
