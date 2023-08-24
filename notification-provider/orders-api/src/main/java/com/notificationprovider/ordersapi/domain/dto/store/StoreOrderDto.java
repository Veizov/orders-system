package com.notificationprovider.ordersapi.domain.dto.store;

import com.notificationprovider.ordersapi.domain.dto.OrderableDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class StoreOrderDto implements OrderableDto<StoreProductDto> {

    private LocalDateTime createdDate;
    private String shopperEmail;
    private String shopperFirstName;
    private String shopperLastName;
    private List<StoreProductDto> products;

}
