package com.satorydevelopment.kafkademo.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satorydevelopment.kafkademo.controller.request.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = {"${kafka-demo.kafka.topic}"})
    private void processMessage(String messageRequest) {
        System.out.println("Received kafka message!");
        if (messageRequest != null) {
            try {
                MessageRequest message = objectMapper.readValue(messageRequest, MessageRequest.class);
                System.out.printf(
                        "%s send message to %s. Message content: %s",
                        message.getSenderUsername(),
                        message.getReceiverUsername(),
                        message.getMessageContent()
                );
            } catch (JsonProcessingException | NullPointerException e) {
                System.out.printf("Invalid data received in consumer. Exception: %s", e);
            }
        } else {
            System.out.println("Invalid message data!");
        }
    }

}
