package com.kodilla.kodillajms.controller;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}