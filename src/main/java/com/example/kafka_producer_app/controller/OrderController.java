package com.example.kafka_producer_app.controller;

import com.example.kafka_producer_app.model.Order;
import com.example.kafka_producer_app.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public String createOrder(@RequestBody Order order) {
        String msg = orderService.addMsg(order);
        return msg;
    }
}
