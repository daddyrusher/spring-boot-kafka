package com.daddyrusher.producer.service;

import java.util.List;
import com.daddyrusher.dto.Data;

public interface ApiService {
    List<Data> getData(Integer limit);
}
