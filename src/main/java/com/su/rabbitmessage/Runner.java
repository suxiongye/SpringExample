/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.rabbitmessage;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author suxiongye
 * @Package com.su.rabbitmessage
 * @Description: 发送消息
 * @date 2018/1/26 13:29
 */
@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext configurableApplicationContext) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = configurableApplicationContext;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(Application.queueName, "Hello from RabbitMQ~");
        receiver.getLatch().await(10000, TimeUnit.MICROSECONDS);
        context.close();
    }
}
