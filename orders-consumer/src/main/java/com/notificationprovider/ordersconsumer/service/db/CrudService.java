package com.notificationprovider.ordersconsumer.service.db;

public interface CrudService<C, I> {

    C selectById(I id);

    C create(C core);

    C update(C core);

    void delete(I id);

}
