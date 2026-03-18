package com.example.order_service.dto;

import lombok.Data;

@Data
public class orderRequestDto {
    private String productName;
    private int quantity;
    private double price;
    private  String region;

}
