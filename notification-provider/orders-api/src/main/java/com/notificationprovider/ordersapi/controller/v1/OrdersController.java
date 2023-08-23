package com.notificationprovider.ordersapi.controller.v1;

import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "ORDERS")
@RequestMapping("/v1")
public class OrdersController {

    @ApiOperation("Create order")
    @PostMapping({"/{storeId}/orders"})
    public Object createOrder(@PathVariable String storeId, @RequestBody OrderDto orderDto) {
        //TODO
        return null;
    }
}
