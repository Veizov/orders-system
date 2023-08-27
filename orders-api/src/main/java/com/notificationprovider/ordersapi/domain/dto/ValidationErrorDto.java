package com.notificationprovider.ordersapi.domain.dto;

import com.notificationprovider.ordersapi.validator.base.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "create")
public class ValidationErrorDto {
    private List<ValidationError> validationErrors;
}