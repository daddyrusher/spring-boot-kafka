package com.daddyrusher.consumer.service;

import com.daddyrusher.dto.Data;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    private DataRepository repository;

    public DataServiceImpl(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Data saveMessage(Data data) {
        return repository.save(data);
    }
}
