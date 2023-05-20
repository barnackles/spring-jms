package com.kodilla.kodillajms.domain;

import org.springframework.jms.annotation.JmsListener;

import java.io.Serializable;
import java.time.LocalDateTime;

public record OrderDto(LocalDateTime created, Long productId, Long quantity) {

}
