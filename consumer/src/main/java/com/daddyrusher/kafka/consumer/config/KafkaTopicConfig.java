package com.daddyrusher.kafka.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
@Slf4j
public class KafkaTopicConfig {
    private static final short REPLICATION_FACTOR = 1;
    private static final int PARTITIONS = 1;

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    @Value(value = "${kafka.topic.name}")
    private String topicName;

    @Bean
    @ConditionalOnProperty(prefix = "kafka", name = "local-mode", havingValue = "false")
    public KafkaAdmin kafkaAdmin() {
        return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress));
    }

    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "kafka", name = "local-mode", havingValue = "true")
    public KafkaAdmin localKafkaAdmin() {
        return new KafkaAdmin(Map.of(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress,
                AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, 1,
                AdminClientConfig.DEFAULT_API_TIMEOUT_MS_CONFIG, 2));
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic(topicName, PARTITIONS, REPLICATION_FACTOR);
    }
}
