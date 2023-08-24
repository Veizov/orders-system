package com.notificationprovider.ordersapi.exception;

public class KafkaSendEventException extends RuntimeException{

    public KafkaSendEventException(String message, Throwable cause) {
        super(message, cause);
    }

}
