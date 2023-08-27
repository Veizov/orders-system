package com.notificationprovider.ordersconsumer.exception;

public class InsertRecordException extends RuntimeException {

    public InsertRecordException(String message) {
        super(message);
    }

    public InsertRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
