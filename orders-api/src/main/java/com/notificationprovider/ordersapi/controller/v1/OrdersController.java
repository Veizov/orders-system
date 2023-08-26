package com.notificationprovider.ordersapi.controller.v1;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.dto.OrderDto;
import com.notificationprovider.ordersapi.service.OrderPublicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "Stores")
@RequestMapping("/v1/")
@RequiredArgsConstructor
public class OrdersController {

    private final OrderPublicationService orderPublicationService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Publish order")
    @PostMapping({"/{storeId}/orders"})
    public NotFinishedProcessDto publish(@PathVariable Integer storeId, @RequestBody OrderDto orderDto) {
        return orderPublicationService.publishOrder(orderDto, storeId);
    }
}
