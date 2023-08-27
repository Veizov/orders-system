package com.notificationprovider.ordersconsumer.exception;

public class UpdateRecordException extends RuntimeException {

    public UpdateRecordException(String message) {
        super(message);
    }

    public UpdateRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}

