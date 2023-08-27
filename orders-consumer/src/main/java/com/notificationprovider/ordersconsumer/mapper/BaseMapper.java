package com.notificationprovider.ordersconsumer.mapper;

import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public abstract class BaseMapper<E, C> {

    public abstract C toEventObject(E e);

    public abstract List<C> toEventObjects(List<E> eList);

    @InheritInverseConfiguration
    public abstract E toEntity(C c);

    @InheritInverseConfiguration
    public abstract List<E> toEntities(List<C> cList);
}
