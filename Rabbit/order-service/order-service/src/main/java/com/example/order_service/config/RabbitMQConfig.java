package com.example.order_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String DIRECT_EXCHANGE = "order.direct.exchange";
    public static  final String PAYMENT_QUEUE = "payment.queue";
    public static final String DIRECT_ROUTING_KEY = "order.created";
//    direct exchange routes messages using exact routing key matching
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE);
    }

//    Queue that payment-service listens to for order payment processing
    @Bean
    public Queue paymentQueue(){
        return new Queue(PAYMENT_QUEUE);
    }
//    Bind payment.queue to direct exchange with exact key "order.created"
//    Only messages with routing key "order.created" will reach this queue
    @Bean
    public  Binding directBinding(){
        return BindingBuilder
                .bind(paymentQueue())
                .to(directExchange())
                .with(DIRECT_ROUTING_KEY);

    }
    //converts java object to json
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

//    Topic exchange

    public static final String TOPIC_EXCHANGE = "order.topic.excahnge";
    public static  final  String ORDER_INDIA_QUEUE = "order.india.queue";
    public  static  final  String ORDER_USA_QUEUE = "order.usa.queue";
    public  static  final String TOPIC_ROUTING_INDIA= "order.india";
    public  static  final  String TOPIC_ROUTING_USA = "order.usa";


    @Bean
    public  TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue orderIndiaQueue(){
        return  new Queue(ORDER_INDIA_QUEUE);
    }
    @Bean
    public  Queue orderUsaQueue(){
        return  new Queue(ORDER_USA_QUEUE);
    }

    @Bean
    public  Binding topicIndiaBinding(){
        return  BindingBuilder
                .bind(orderIndiaQueue())
                .to(topicExchange())
                .with(TOPIC_ROUTING_INDIA);
    }
    @Bean Binding topicUsaBinding(){
        return  BindingBuilder
                .bind(orderUsaQueue())
                .to(topicExchange())
                .with(TOPIC_ROUTING_USA);
    }

}
