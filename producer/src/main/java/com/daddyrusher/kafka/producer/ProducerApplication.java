package com.daddyrusher.kafka.producer;

import com.daddyrusher.kafka.producer.config.MessageProducer;
import com.daddyrusher.kafka.producer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ProducerApplication {

    private final MessageProducer producer;
    private final UserService service;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMessages() {
        log.info("Producer application is ready, sending message to Kafka");
        service.getData(3).forEach(producer::sendMessage);
    }
}
