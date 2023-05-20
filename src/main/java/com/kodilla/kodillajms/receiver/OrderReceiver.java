package com.kodilla.kodillajms.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.kodillajms.domain.OrderDto;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {

    private final ObjectMapper mapper;

    public OrderReceiver(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-order")
    public void receive(String message) {
        OrderDto orderDto = null;
        try {
            orderDto = mapper.readValue(message, OrderDto.class);
            System.out.println("Received the message: " + orderDto.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



    }
}
