package com.notificationprovider.ordersapi.domain.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public abstract class BaseDtoEventObjectMapper<E, D> {

    public abstract D toDto(E e);

    @InheritConfiguration(name = "toDto")
    public abstract List<D> toDtoList(List<E> eList);

    @InheritInverseConfiguration(name = "toDto")
    public abstract E toEventObject(D d);

    @InheritInverseConfiguration(name = "toDtoList")
    public abstract List<E> toEventObjectList(List<D> dList);
}
