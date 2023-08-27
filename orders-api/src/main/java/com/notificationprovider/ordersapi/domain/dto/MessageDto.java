package com.notificationprovider.ordersapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "newInstance")
public class MessageDto {
    private String message;
}
