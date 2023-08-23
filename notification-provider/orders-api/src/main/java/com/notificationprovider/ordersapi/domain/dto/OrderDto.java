package com.notificationprovider.ordersapi.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private LocalDateTime date;
    private String email;
    private String firstName;
    private String lastName;
    private List<ProductDto> products;

}
