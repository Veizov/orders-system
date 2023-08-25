package com.notificationprovider.ordersapi.utils.endpoint;

import org.springframework.util.StringUtils;

import java.util.Objects;

public class EndpointUtils {

    private static final String ORDER_STATUS_ENDPOINT_TEMPLATE = "/v1/orders/statuses?topic={topic}&partition={partition}&offset={offset}";

    public static String buildOrderStatusEndpoint(String topic, Integer partition, Long offset) {
        if (!StringUtils.hasText(topic) || Objects.isNull(partition) || Objects.isNull(offset)) {
            return null;
        }

        return ORDER_STATUS_ENDPOINT_TEMPLATE
                .replace("{topic}", topic)
                .replace("{partition}", String.valueOf(partition))
                .replace("{offset}", String.valueOf(offset));
    }

}
