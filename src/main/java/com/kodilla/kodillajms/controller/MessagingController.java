package com.kodilla.kodillajms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessagingController {

    @GetMapping(path = "/process")
    public void processMessage(@RequestParam String message) {
        System.out.println("Message: " + message);
    }

}