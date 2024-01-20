package com.daddyrusher.kafka.producer.service;

import com.daddyrusher.common.dto.Data;

import java.util.List;

public interface UserService {
    List<Data> getData(Integer limit);
}
