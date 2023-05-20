package com.kodilla.kodillajms.controller;

import com.kodilla.kodillajms.domain.OrderDto;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessagingController {

    private final JmsTemplate jmsTemplate;

    public MessagingController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping(path = "/process")
    public void processMessage(@RequestParam String message) {
        System.out.println("Message: " + message);
        jmsTemplate.convertAndSend("queue-test", message);

    }

    @PutMapping("/order")
    public void processOrder(@RequestBody OrderDto orderDto) {
        System.out.println(orderDto.toString());
        jmsTemplate.convertAndSend("queue-order", orderDto);

    }

}