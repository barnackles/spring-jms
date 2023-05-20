package com.kodilla.kodillajms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.kodillajms.domain.OrderDto;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessagingController {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    public MessagingController(JmsTemplate jmsTemplate, ObjectMapper mapper) {
        this.jmsTemplate = jmsTemplate;
        this.mapper = mapper;
    }

    @GetMapping(path = "/process")
    public void processMessage(@RequestParam String message) {
        System.out.println("Message: " + message);
        jmsTemplate.convertAndSend("queue-test", message);

    }

    @PostMapping("/order")
    public void processOrder(@RequestBody OrderDto orderDto) {

        System.out.println("Processing order " + orderDto.toString());
        String message = null;
        try {
            message = mapper.writeValueAsString(orderDto);
            jmsTemplate.convertAndSend("queue-order", message);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}