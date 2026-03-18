package com.example.order_service.controller;

import com.example.order_service.dto.orderRequestDto;
import com.example.order_service.dto.orderResponseDto;
import com.example.order_service.service.orderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class orderController {
    public final orderService service;

    @PostMapping
    public orderResponseDto createOrder(@RequestBody orderRequestDto dto){
        return service.createOrder(dto);
    }

}
