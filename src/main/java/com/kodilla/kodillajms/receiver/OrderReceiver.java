package com.kodilla.kodillajms.receiver;

import com.kodilla.kodillajms.domain.OrderDto;
import org.springframework.jms.annotation.JmsListener;

public class OrderReceiver {

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-order")
    public void receive(OrderDto orderDto) {

        System.out.println("Received the message: " + orderDto.toString());

    }
}
