package com.example.PaymentService.consumer;

import com.example.PaymentService.dto.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// Listens to payment.queue which is bound to order.direct.excahnge
// with exact routing key "order.created"
// this consumer is triggered only when order-service publishes
// a message with routing key = "order.created" to the direct exchange
@Component
public class PaymentConsumer {
    @RabbitListener(queues = "payment.queue")
    public void processPayment(OrderCreatedEvent event){
        System.out.println("[DIRECT] Processing Payment for Order: "+event.getOrderId());
        System.out.println("[DIRECT] Amount: "+event.getAmount());
        System.out.println("[DIRECT} Payment Successful");
    }
}
