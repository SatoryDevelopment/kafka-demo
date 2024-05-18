package com.satorydevelopment.kafkademo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satorydevelopment.kafkademo.controller.request.MessageRequest;
import com.satorydevelopment.kafkademo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Value("${kafka-demo.kafka.topic}")
    private String topicName;

    @Override
    public void send(MessageRequest message) {
        try {
            String kafkaMessageString = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(topicName, kafkaMessageString).thenAccept(System.out::println);
        } catch (JsonProcessingException e) {
            System.out.printf("Kafka topic: %s. Object mapping failed. Exception: %s", topicName, e);
        }
    }
}
