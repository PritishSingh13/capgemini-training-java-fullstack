package com.example.order_service.producer;

import com.example.order_service.config.RabbitMQConfig;
import com.example.order_service.dto.orderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

// Dedicated producer class - responsible only for publishing messages to RabbitMq
//Keeping this separate from orderservice makes the code easier to understand
// orderService -> handles business logic (save order,build event)


@Component
@RequiredArgsConstructor
// TO HANDLE MESSAGING LOGIC ( which exchange which routing key)
public class orderProducer {

    // rabbittemplate is the core spring AMQP class used to send messages to RabbitMQ

    private  final RabbitTemplate rabbitTemplate;
    //publisher to DIRECT EEXCHANGE  with exact routing key "order.created"
    // ONly payment.queue receives this - exact key match required

    public void sendToDirectExchange(orderCreatedEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.DIRECT_EXCHANGE,  //target exchange
                RabbitMQConfig.DIRECT_ROUTING_KEY,  // exact routing key : "order.created"
                event                              // message payload
        );
    }
    public  void sendToTopicExchange(orderCreatedEvent event,String region){
        String routingKey = "order."+region; // dynamically build : "oorder.india" or "order.usa"
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.TOPIC_EXCHANGE,  //target exchange
                routingKey, // pattern based routing key
                event // message payload
        );
    }

}
