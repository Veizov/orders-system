package com.notificationprovider.ordersapi.controller.v1.store;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.store.StoreOrderDto;
import com.notificationprovider.ordersapi.service.OrderInitializationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "Stores")
@RequestMapping("/v1/stores")
@RequiredArgsConstructor
public class StoreOrdersController {

    private final OrderInitializationService storeOrderService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Initialize store order")
    @PostMapping({"/{storeId}/orders"})
    public NotFinishedProcessDto initializeOrder(@PathVariable Integer storeId, @RequestBody StoreOrderDto orderDto) {
        return storeOrderService.initializeOrder(orderDto, storeId);
    }
}
