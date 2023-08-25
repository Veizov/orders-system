package com.notificationprovider.ordersapi.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotFinishedProcessDto {

    private String checkStatusEndpoint;
    private LocalDateTime createdDate;

}
