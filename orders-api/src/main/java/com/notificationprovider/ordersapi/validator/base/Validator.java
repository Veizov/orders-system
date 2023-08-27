package com.notificationprovider.ordersapi.validator.base;

import com.notificationprovider.ordersapi.exception.ValidationErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

public interface Validator<T> extends DefaultValidation {
    List<ValidationError> validate(T obj, Object... args);

    default void validateAndThrow(T obj, Object... args) {
        List<ValidationError> errors = validate(obj, args);
        if (!CollectionUtils.isEmpty(errors)) {
            throw new ValidationErrorException(errors);
        }
    }

}
