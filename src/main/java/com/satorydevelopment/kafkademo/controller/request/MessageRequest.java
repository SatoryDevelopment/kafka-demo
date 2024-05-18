package com.satorydevelopment.kafkademo.controller.request;

import lombok.Data;

@Data
public class MessageRequest {
    private String senderUsername;
    private String receiverUsername;
    private String messageContent;
}
