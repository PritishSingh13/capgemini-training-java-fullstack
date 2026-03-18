package com.example.order_service.producer;

import com.example.order_service.config.RabbitMQConfig;
import com.example.order_service.dto.orderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class orderProducer {

    private  final RabbitTemplate rabbitTemplate;
    public void sendToDirectExchange(orderCreatedEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.DIRECT_EXCHANGE,
                RabbitMQConfig.DIRECT_ROUTING_KEY,
                event
        );
    }
    public  void sendToTopicExchange(orderCreatedEvent event,String region){
        String routingKey = "order."+region;
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.TOPIC_EXCHANGE,
                routingKey,
                event
        );
    }

}
