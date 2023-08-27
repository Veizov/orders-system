package com.notificationprovider.ordersconsumer.repository;

import com.notificationprovider.ordersconsumer.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends BaseRepository<OrderEntity, Long> {

    @Query("SELECT e FROM OrderEntity e WHERE e.store.id = :storeId and e.externalId = :externalId")
    List<OrderEntity> selectByStoreIdAndExternalId(@Param("storeId") Integer storeId, @Param("externalId") Long externalId);

}
