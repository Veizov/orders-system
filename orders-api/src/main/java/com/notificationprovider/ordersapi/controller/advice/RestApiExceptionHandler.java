package com.notificationprovider.ordersapi.controller.advice;

import com.notificationprovider.ordersapi.domain.dto.MessageDto;
import com.notificationprovider.ordersapi.domain.dto.ValidationErrorDto;
import com.notificationprovider.ordersapi.exception.ValidationErrorException;
import com.notificationprovider.ordersapi.utils.advice.NotReadableMessageHandlerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDto> handleGlobalException(Exception ex, WebRequest request) {
        HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        log.info("[500 INTERNAL_SERVER_ERROR [{} {}] {}", servletRequest.getMethod(), servletRequest.getRequestURI(), ex.getMessage());
        return new ResponseEntity<>(MessageDto.newInstance("Error occurred during operation"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDto> handleNotReadableMessageException(HttpMessageNotReadableException ex, WebRequest request) {
        HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        log.warn("[400 BAD_REQUEST [{} {}] {}", servletRequest.getMethod(), servletRequest.getRequestURI(), ex.getMessage());
        MessageDto message = NotReadableMessageHandlerUtils.createResponseMessage(ex);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationErrorException.class)
    public ResponseEntity<ValidationErrorDto> handleValidationErrorException(ValidationErrorException ex, WebRequest request) {
        HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        log.warn("[400 BAD_REQUEST [{} {}] {}", servletRequest.getMethod(), servletRequest.getRequestURI(), ex.getMessage());
        return new ResponseEntity<>(ValidationErrorDto.create(ex.getErrors()), HttpStatus.BAD_REQUEST);
    }
}