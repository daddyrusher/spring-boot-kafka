package com.daddyrusher.kafka.producer.service;

import com.daddyrusher.common.dto.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private static final String USERS_RESOURCE = "/users";
    private final RestClient restClient;

    @Value("${api_url}")
    private String apiUrl;

    @Override
    public List<Data> getData(Integer limit) {
        var builder = UriComponentsBuilder
                .fromUriString(apiUrl)
                .path(USERS_RESOURCE);

        return restClient.get()
                .uri(builder.toUriString())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}


