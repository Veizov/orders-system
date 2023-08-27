package com.notificationprovider.ordersconsumer.exception;

public class DeleteRecordException extends RuntimeException {

    public DeleteRecordException(String message) {
        super(message);
    }

    public DeleteRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}

