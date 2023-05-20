package com.kodilla.kodillajms.domain;

import org.springframework.jms.annotation.JmsListener;

import java.time.LocalDateTime;

public record OrderDto(LocalDateTime created, Long productId, Long quantity) {

}
