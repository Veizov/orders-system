package com.notificationprovider.ordersapi.validator;

import com.notificationprovider.ordersapi.domain.dto.ProductDto;
import com.notificationprovider.ordersapi.validator.base.ValidationError;
import com.notificationprovider.ordersapi.validator.base.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProductValidator implements Validator<ProductDto> {

    @Override
    public List<ValidationError> validate(ProductDto obj, Object... args) {
        List<ValidationError> errors = new ArrayList<>();

        Integer index = getIndex(args);

        rejectIfEmpty(errors, obj.getId(), indexPointer("id", index));
        rejectIfEmptyString(errors, obj.getName(), indexPointer("name", index));
        rejectIfEmpty(errors, obj.getPrice(), indexPointer("price", index));
        rejectIfNegativeNumber(errors, obj.getPrice(), indexPointer("price", index), "v.number.negativeValue");
        rejectIfEmpty(errors, obj.getQuantity(), indexPointer("quantity", index));
        rejectIfNegativeNumber(errors, obj.getQuantity(), indexPointer("quantity", index), "v.number.negativeValue");

        return errors;
    }

    private Integer getIndex(Object[] args) {
        try {
            return (Integer) args[0];
        } catch (Exception e) {
            return null;
        }
    }

    private String indexPointer(String pointer, Integer index) {
        if (Objects.isNull(index)) {
            return pointer;
        }

        return "product" + index + "." + pointer;
    }
}
