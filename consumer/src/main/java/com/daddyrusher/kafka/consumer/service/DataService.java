package com.daddyrusher.kafka.consumer.service;

import com.daddyrusher.common.dto.Data;

public interface DataService {
    Data saveMessage(Data data);
}
