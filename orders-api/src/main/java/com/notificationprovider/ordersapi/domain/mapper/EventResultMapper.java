package com.notificationprovider.ordersapi.domain.mapper;

import com.notificationprovider.ordersapi.domain.dto.NotFinishedProcessDto;
import com.notificationprovider.ordersapi.domain.event.EventResult;
import com.notificationprovider.ordersapi.utils.endpoint.EndpointUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public abstract class EventResultMapper {

    @Mapping(target = "createdDate", source = "createdDate")
    public abstract NotFinishedProcessDto toNotFinishedProcessDto(EventResult dto);

    @AfterMapping
    public void afterToNotFinishedProcessDto(EventResult source, @MappingTarget NotFinishedProcessDto target) {
        target.setCheckStatusEndpoint(EndpointUtils.buildOrderStatusEndpoint(source.getTopic(), source.getPartition(), source.getOffset()));
    }
}
