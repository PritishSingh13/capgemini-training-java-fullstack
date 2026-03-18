package com.example.order_service.service;

import com.example.order_service.dto.orderResponseDto;
import com.example.order_service.dto.orderCreatedEvent;
import com.example.order_service.dto.orderRequestDto;
import com.example.order_service.entity.order;
import com.example.order_service.producer.orderProducer;
import com.example.order_service.repository.orderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class orderService {
    private  final orderRepository repository;
    //orderProducer handles all rabbitmq publishing -  keeps messaging logic out of here
    private  final orderProducer producer;

    public orderResponseDto createOrder(orderRequestDto dto){
        order o = new order();
        o.setProductName(dto.getProductName());
        o.setQuantity(dto.getQuantity());
        o.setPrice(dto.getPrice());
        o.setStatus("CREATED");
        order saved = repository.save(o);

        orderCreatedEvent event =  new orderCreatedEvent(saved.getId(),saved.getPrice());

        producer.sendToDirectExchange(event);
        producer.sendToTopicExchange(event,dto.getRegion());
        return  new orderResponseDto(saved.getId(),"ORDER_CREATED");
    }





}
