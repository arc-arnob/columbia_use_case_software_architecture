package com.demo.blazeguard.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class AlertConsumer  {

    @KafkaListener(topics = "Wildfire_Alert", groupId = "my-group-1")
    public void consumeMessage(String message){

        System.out.println("Received alert message: "+message);
        AlertNotificationService.notify(message);
    }
}