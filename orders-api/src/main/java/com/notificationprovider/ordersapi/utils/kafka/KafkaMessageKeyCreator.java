package com.notificationprovider.ordersapi.utils.kafka;

import com.notificationprovider.ordersapi.exception.MessageKeyCreationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class KafkaMessageKeyCreator {

    private static final String STORE_ORDER_MESSAGE_KEY_TEMPLATE = "store-{storeId}";

    public String createOrderKey(Integer storeId) {
        if (Objects.isNull(storeId)) {
            throw new MessageKeyCreationException("[Message key] Cannot create message key, because store identifier is empty! ");
        }

        return STORE_ORDER_MESSAGE_KEY_TEMPLATE.replace("{storeId}", String.valueOf(storeId));
    }

}
