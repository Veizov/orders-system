package com.notificationprovider.ordersconsumer.service.db;

public interface CrudService<E, I> {

    E selectById(I id);

    E insert(E eventObject);

    E update(E eventObject);

    void delete(I id);

}
