package com.daddyrusher.kafka.consumer.config;

import com.daddyrusher.common.dto.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    private static final String DTO_PACKAGE = "com.daddyrusher.common.dto";
    private static final String GROUP_CONFIG_ID = "consuming";
    private static final String TRUSTED_PACKAGES = "*";

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public ConsumerFactory<String, Data> consumerFactory() {
        var config = new HashMap<String, Object>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_CONFIG_ID);

        var typeMapper = new DefaultJackson2JavaTypeMapper();
        var classMap = new HashMap<String, Class<?>>();
        classMap.put(DTO_PACKAGE, Data.class);
        typeMapper.setIdClassMapping(classMap);
        typeMapper.addTrustedPackages(TRUSTED_PACKAGES);

        var jsonDeserializer = new JsonDeserializer<>(Data.class);
        jsonDeserializer.setTypeMapper(typeMapper);
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Data> kafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Data>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
