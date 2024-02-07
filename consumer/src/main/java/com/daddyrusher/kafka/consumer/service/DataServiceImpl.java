package com.daddyrusher.kafka.consumer.service;

import com.daddyrusher.common.dto.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataRepository repository;

    @Override
    public Data saveMessage(Data data) {
        return repository.save(data);
    }
}
