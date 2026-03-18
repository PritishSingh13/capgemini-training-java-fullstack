package com.example.PaymentService.dto;

import lombok.Data;

@Data
public class OrderCreatedEvent {
    private Long orderId;
    private   double amount;
}
