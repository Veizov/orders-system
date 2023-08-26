package com.notificationprovider.ordersconsumer.service.db;

import com.notificationprovider.ordersconsumer.domain.core.OrderCore;
import com.notificationprovider.ordersconsumer.domain.entity.OrderEntity;
import com.notificationprovider.ordersconsumer.mapper.core_entity.OrderCoreToEntityMapper;
import com.notificationprovider.ordersconsumer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService implements CrudService<OrderCore, Long> {

    private final OrderRepository repository;
    private final OrderCoreToEntityMapper mapper;

    @Override
    public OrderCore selectById(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }

        OrderEntity entity = repository.findById(id).orElse(null);
        return mapper.toCore(entity);
    }

    @Override
    @Transactional
    public OrderCore create(OrderCore order) {
        //TODO Validator
        OrderEntity entity = mapper.toEntity(order);
        return mapper.toCore(repository.save(entity));
    }

    @Override
    @Transactional
    public OrderCore update(OrderCore order) {
        //TODO Validator
        OrderEntity entity = mapper.toEntity(order);
        return mapper.toCore(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (Objects.isNull(id)) {
            return;
        }

        repository.deleteById(id);
    }

}
