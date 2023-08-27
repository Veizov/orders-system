package com.notificationprovider.ordersconsumer.service.db;

import com.notificationprovider.ordersconsumer.domain.event.Order;
import com.notificationprovider.ordersconsumer.domain.entity.OrderEntity;
import com.notificationprovider.ordersconsumer.mapper.OrderMapper;
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
public class OrderCrudService implements CrudService<Order, Long> {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Override
    public Order selectById(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }

        OrderEntity entity = repository.findById(id).orElse(null);
        return mapper.toEventObject(entity);
    }

    @Override
    @Transactional
    public Order create(Order order) {
        //TODO Validator
        OrderEntity entity = mapper.toEntity(order);
        return mapper.toEventObject(repository.save(entity));
    }

    @Override
    @Transactional
    public Order update(Order order) {
        //TODO Validator
        OrderEntity entity = mapper.toEntity(order);
        return mapper.toEventObject(repository.save(entity));
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
