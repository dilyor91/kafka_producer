package com.example.kafka_producer_app.service;

import com.example.kafka_producer_app.constants.AppConstants;
import com.example.kafka_producer_app.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String addMsg(Order order) {

        //publish msg to kafka topic
        kafkaTemplate.send(AppConstants.TOPIC, order);

        return "Msg Published to Kafka Topic";
    }
}
