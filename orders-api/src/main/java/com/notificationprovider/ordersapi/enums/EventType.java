package com.notificationprovider.ordersapi.enums;

import lombok.Getter;

@Getter
public enum EventType {
    PUBLISHED_ORDER("orders/published");

    private final String code;

    EventType(String code) {
        this.code = code;
    }
}
