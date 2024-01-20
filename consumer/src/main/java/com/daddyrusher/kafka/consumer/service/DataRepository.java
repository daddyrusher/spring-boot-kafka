package com.daddyrusher.kafka.consumer.service;

import com.daddyrusher.common.dto.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, String> {
}
