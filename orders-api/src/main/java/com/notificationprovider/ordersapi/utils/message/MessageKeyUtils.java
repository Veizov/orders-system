package com.notificationprovider.ordersapi.utils.message;

import com.notificationprovider.ordersapi.exception.MessageKeyCreationException;

import java.util.Objects;

public class MessageKeyUtils {

    private static final String STORE_ORDER_MESSAGE_KEY_TEMPLATE = "store-{storeId}";

    public static String createOrderKey(Integer storeId) {
        if (Objects.isNull(storeId)) {
            throw new MessageKeyCreationException("[Message key] Cannot create message key, because store identifier is empty! ");
        }

        return STORE_ORDER_MESSAGE_KEY_TEMPLATE.replace("{storeId}", String.valueOf(storeId));
    }

}
