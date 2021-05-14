package com.example.demo.service.impl;

import com.example.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerImpl implements KafkaProducerService {

    public static final String TOPIC = "my_topic";

    public KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void writeMessage(String message) {

        this.kafkaTemplate.send(TOPIC, message);
    }
}
