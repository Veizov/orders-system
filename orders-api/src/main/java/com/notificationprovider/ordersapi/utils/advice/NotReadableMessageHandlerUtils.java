package com.notificationprovider.ordersapi.utils.advice;

import com.notificationprovider.ordersapi.domain.dto.MessageDto;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;

public class NotReadableMessageHandlerUtils {

    private static final String DEFAULT_MESSAGE = "Cannot read message. Please check request JSON for syntactic errors !";
    private static final String DATETIME_PARSE_MESSAGE = "Some of the DateTime fields are in a wrong format. Valid format: dd.MM.yyyy HH:mm:ss";
    private static final String DATETIME_CHECK_CASE_MESSAGE = "Cannot deserialize value of type `java.time.LocalDateTime`";

    public static MessageDto createResponseMessage(HttpMessageNotReadableException ex) {
        MessageDto message = MessageDto.newInstance(DEFAULT_MESSAGE);
        if (StringUtils.hasText(ex.getMessage())) {
            if (ex.getMessage().contains(DATETIME_CHECK_CASE_MESSAGE)) {
                message = MessageDto.newInstance(DATETIME_PARSE_MESSAGE);
            }
        }
        return message;
    }
}
