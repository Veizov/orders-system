package com.notificationprovider.ordersconsumer.service.db;

import com.notificationprovider.ordersconsumer.domain.entity.StoreEntity;
import com.notificationprovider.ordersconsumer.domain.event.Store;
import com.notificationprovider.ordersconsumer.domain.mapper.StoreMapper;
import com.notificationprovider.ordersconsumer.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {

    private final StoreRepository repository;
    private final StoreMapper mapper;

    @Override
    public Store selectById(Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }

        StoreEntity entity = repository.findById(id).orElse(null);
        return mapper.toEventObject(entity);
    }

}
