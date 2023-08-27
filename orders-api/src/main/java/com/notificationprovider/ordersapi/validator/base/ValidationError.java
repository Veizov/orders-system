package com.notificationprovider.ordersapi.validator.base;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ValidationError {

    private final String pointer;
    private final String message;

}