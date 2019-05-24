package com.daddyrusher.consumer.service;

import com.daddyrusher.dto.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, String> {
}
