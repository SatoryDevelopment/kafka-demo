package com.satorydevelopment.kafkademo.controller;

import com.satorydevelopment.kafkademo.controller.request.MessageRequest;
import com.satorydevelopment.kafkademo.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
@AllArgsConstructor
public class MessageController {

    private MessageService messageService;

    @PostMapping("send")
    public void send(@RequestBody MessageRequest messageRequest) {
        messageService.send(messageRequest);
    }

}
