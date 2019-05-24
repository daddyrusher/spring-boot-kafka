package com.daddyrusher.producer.config;

import com.daddyrusher.dto.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@NoArgsConstructor
@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, Data> kafkaTemplate;
    @Value("${kafka.topic.name}")
    private String topicName;


    public void sendMessage(Data data) {
        ListenableFuture<SendResult<String, Data>> future = kafkaTemplate.send(topicName, data);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Data>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message = {} dut to: {}", data, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Data> stringDataSendResult) {
                log.info("Sent Message = {} with offset = {}", data, stringDataSendResult.getRecordMetadata().offset());
            }
        });
    }
}
