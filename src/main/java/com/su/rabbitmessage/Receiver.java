/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.rabbitmessage;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

/**
 * @author suxiongye
 * @Package com.su.rabbitmessage
 * @Description: 接收消息类
 * @date 2018/1/26 12:15
 */
@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received < " + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
