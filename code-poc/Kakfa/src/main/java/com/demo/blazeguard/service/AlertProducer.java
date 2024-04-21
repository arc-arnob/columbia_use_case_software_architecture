package com.demo.blazeguard.service;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class AlertProducer {

    public static final String TOPIC = "Wildfire_Alert";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public AlertProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String  alertMessage){

        this.kafkaTemplate.send(TOPIC,alertMessage);
        System.out.println("Sent alert message: " + alertMessage);
    }

    @Bean
    public NewTopic createTopic(){

        return new NewTopic(TOPIC,2,(short) 1);
    }
}