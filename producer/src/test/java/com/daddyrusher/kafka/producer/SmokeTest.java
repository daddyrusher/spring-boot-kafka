package com.daddyrusher.kafka.producer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration",
        "kafka.local-mode=true"
})
public class SmokeTest {

    @Test
    public void contextLoads() {
    }
}
