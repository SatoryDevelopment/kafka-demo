package com.satorydevelopment.kafkademo.service;

import com.satorydevelopment.kafkademo.controller.request.MessageRequest;

public interface MessageService {

    void send(MessageRequest message);

}
