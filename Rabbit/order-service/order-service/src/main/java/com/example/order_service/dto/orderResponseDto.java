package com.example.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class orderResponseDto {
    private  Long orderId;
    private  String status;

}
