package com.notificationprovider.ordersapi.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto implements OrderableDto<ProductDto> {

    private Long id;
    private LocalDateTime createdDate;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private List<ProductDto> products;

}
