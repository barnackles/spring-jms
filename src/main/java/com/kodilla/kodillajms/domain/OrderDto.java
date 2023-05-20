package com.kodilla.kodillajms.domain;

import org.springframework.jms.annotation.JmsListener;

import java.time.LocalDateTime;

public record OrderDto(LocalDateTime created, Long productId, Long quantity) {

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-order")
    public void receive(OrderDto orderDto) {

        System.out.println("Received the message: " + orderDto.toString());

    }

}
