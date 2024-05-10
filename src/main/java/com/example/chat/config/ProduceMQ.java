package com.example.chat.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProduceMQ {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("114.132.150.220"); // 设置RabbitMQ服务器主机
        connectionFactory.setPort(5672); // 设置RabbitMQ服务器端口
        connectionFactory.setUsername("Li_yuan"); // 设置RabbitMQ用户名
        connectionFactory.setPassword("123456"); // 设置RabbitMQ密码
        connectionFactory.setVirtualHost("/ly"); // 设置RabbitMQ虚拟主机

        return connectionFactory;
    }
}