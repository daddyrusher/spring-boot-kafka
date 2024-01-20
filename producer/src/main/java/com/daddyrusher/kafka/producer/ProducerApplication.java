package com.daddyrusher.kafka.producer;

import com.daddyrusher.kafka.producer.config.MessageProducer;
import com.daddyrusher.kafka.producer.service.UserService;
import com.daddyrusher.kafka.producer.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProducerApplication.class, args);

        MessageProducer producer = context.getBean(MessageProducer.class);
        UserService service = context.getBean(UserServiceImpl.class);

        service.getData(3).forEach(producer::sendMessage);
    }
}
