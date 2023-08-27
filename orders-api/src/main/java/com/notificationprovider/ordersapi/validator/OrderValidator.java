package com.notificationprovider.ordersapi.validator;

import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import com.notificationprovider.ordersapi.domain.dto.ProductDto;
import com.notificationprovider.ordersapi.utils.regex.RegexUtils;
import com.notificationprovider.ordersapi.validator.base.ValidationError;
import com.notificationprovider.ordersapi.validator.base.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderValidator implements Validator<OrderDto> {

    private final ProductValidator productValidator;

    @Override
    public List<ValidationError> validate(OrderDto obj, Object... args) {
        List<ValidationError> errors = new ArrayList<>();

        rejectIfEmpty(errors, obj.getId(), "id");
        rejectIfEmpty(errors, obj.getCreatedDate(), "createdDate");
        rejectIfEmptyString(errors, obj.getShopperEmail(), "shopperEmail");
        rejectIfNotMatchRegex(errors, obj.getShopperEmail(), RegexUtils.EMAIL_REGEX, "shopperEmail", "v.invalid.value");
        rejectIfEmptyString(errors, obj.getShopperFirstName(), "shopperFirstName");
        rejectIfEmptyString(errors, obj.getShopperLastName(), "shopperLastName");

        validateOrderProducts(obj, errors);
        return errors;
    }

    private void validateOrderProducts(OrderDto obj, List<ValidationError> errors) {
        List<ProductDto> products = obj.getProducts();
        rejectIfEmptyCollection(errors, products, "products");
        if (!CollectionUtils.isEmpty(products)) {
            for (int i = 0; i < products.size(); i++) {
                List<ValidationError> productErrors = productValidator.validate(products.get(i), i);
                if (!CollectionUtils.isEmpty(productErrors)) {
                    errors.addAll(productErrors);
                }
            }
        }
    }
}
