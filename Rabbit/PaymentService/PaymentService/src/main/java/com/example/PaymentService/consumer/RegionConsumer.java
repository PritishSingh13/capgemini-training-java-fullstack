package com.example.PaymentService.consumer;

import com.example.PaymentService.dto.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RegionConsumer {

    @RabbitListener(queues = "order.india.queue")
    public  void handleIndiaOrder(OrderCreatedEvent event){
        System.out.println("[TOPIC - INDIA] Received ORder: "+event.getOrderId() );
        System.out.println("[TOPIC - INDIA] Amount: "+event.getAmount());
        System.out.println("TOPIC - INDIA] Applying INdia Region processing...");
    }

    @RabbitListener(queues = "order.usa.queue")
    public  void handleUSAOrder(OrderCreatedEvent event){
        System.out.println("[TOPIC - USA] Received ORder: "+event.getOrderId() );
        System.out.println("[TOPIC - USA] Amount: "+event.getAmount());
        System.out.println("TOPIC - USA] Applying USA Region processing...");
    }
}
