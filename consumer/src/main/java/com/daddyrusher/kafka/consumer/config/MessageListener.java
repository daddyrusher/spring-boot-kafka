package com.daddyrusher.kafka.consumer.config;

import com.daddyrusher.common.dto.Data;
import com.daddyrusher.kafka.consumer.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageListener {
    private final DataService dataService;

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(Data data) {
        log.info("Received message: {}", data);
        dataService.saveMessage(data);
    }
}
