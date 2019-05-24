package com.daddyrusher.consumer.config;

import com.daddyrusher.consumer.service.DataService;
import com.daddyrusher.dto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageListener {

    @Autowired
    private DataService dataService;

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(Data data) {
        System.out.println("Recieved message: " + data);
        dataService.saveMessage(data);
    }
}
