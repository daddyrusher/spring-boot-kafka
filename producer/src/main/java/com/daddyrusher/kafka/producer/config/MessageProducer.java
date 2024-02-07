package com.daddyrusher.kafka.producer.config;

import com.daddyrusher.common.dto.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {
    private final KafkaTemplate<String, Data> kafkaTemplate;
    @Value("${kafka.topic.name}")
    private String topicName;

    public void sendMessage(Data data) {
        kafkaTemplate
                .send(topicName, data)
                .whenComplete((result, throwable) -> {
                    if (throwable != null) {
                        log.error("Unable to send message = {} due to: {}", data, throwable.getMessage());
                    } else {
                        log.info("Sent Message = {} with offset = {}", data, result.getRecordMetadata().offset());
                    }
                });
    }
}
