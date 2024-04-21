package com.demo.blazeguard.controller;


import com.demo.blazeguard.service.AlertProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {

    @Autowired
    AlertProducer producer;

    @PostMapping(value="/post")
    public void sendMessage(@RequestParam("msg") String msg) {
        producer.sendMessage(msg);
    }
}