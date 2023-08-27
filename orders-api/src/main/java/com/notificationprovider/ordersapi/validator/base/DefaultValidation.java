package com.notificationprovider.ordersapi.validator.base;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface DefaultValidation {

    default void reject(List<ValidationError> errors, String pointer, String message) {
        errors.add(ValidationError.builder().pointer(pointer).message(message).build());
    }

    default void rejectIfEmpty(List<ValidationError> errors, Object value, String pointer) {
        rejectIfEmpty(errors, value, pointer, "v.required.field");
    }

    default void rejectIfEmpty(List<ValidationError> errors, Object value, String pointer, String message) {
        if (Objects.isNull(value) || (value instanceof Optional<?> o && o.isEmpty())) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default void rejectIfEmptyString(List<ValidationError> errors, String value, String pointer) {
        rejectIfEmptyString(errors, value, pointer, "v.required.field");
    }

    default void rejectIfEmptyString(List<ValidationError> errors, String value, String pointer, String message) {
        if (!StringUtils.hasText(value)) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default void rejectIfNotMatchRegex(List<ValidationError> errors, String value, String regex, String pointer, String message) {
        if (StringUtils.hasText(value) && !value.matches(regex)) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default <E> void rejectIfEmptyCollection(List<ValidationError> errors, List<E> value, String pointer, String message) {
        if (CollectionUtils.isEmpty(value)) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default <E> void rejectIfEmptyCollection(List<ValidationError> errors, List<E> value, String pointer) {
        rejectIfEmptyCollection(errors, value, pointer, "v.required.field");
    }

    default void rejectIfExceededLength(List<ValidationError> errors, String value, int maxLength, String pointer) {
        if (StringUtils.hasText(value) && value.length() > maxLength) {
            errors.add(ValidationError.builder().pointer(pointer).message("v.exceeded.length." + maxLength).build());
        }
    }

    default void rejectIfExceededLength(List<ValidationError> errors, String value, int maxLength, String pointer, String message) {
        if (StringUtils.hasText(value) && value.length() > maxLength) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default void rejectIfNegativeNumber(List<ValidationError> errors, Integer value, String pointer, String message) {
        if (Objects.nonNull(value) && value < 0) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default void rejectIfNegativeNumber(List<ValidationError> errors, Long value, String pointer, String message) {
        if (Objects.nonNull(value) && value < 0) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

    default void rejectIfNegativeNumber(List<ValidationError> errors, BigDecimal value, String pointer, String message) {
        if (Objects.nonNull(value) && value.compareTo(BigDecimal.ZERO) < 0) {
            errors.add(ValidationError.builder().pointer(pointer).message(message).build());
        }
    }

}
