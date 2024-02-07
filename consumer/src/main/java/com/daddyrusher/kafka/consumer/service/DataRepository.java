package com.daddyrusher.kafka.consumer.service;

import com.daddyrusher.common.dto.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, String> {
}
