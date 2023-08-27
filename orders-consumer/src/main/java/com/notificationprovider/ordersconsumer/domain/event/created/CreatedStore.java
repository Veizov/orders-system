package com.notificationprovider.ordersconsumer.domain.event.created;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class CreatedStore {

    private Integer id;
    private String name;
    private String description;
    private String reviewUrl;

}
