/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.redistest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author su
 * @Package com.su.redistest
 * @Description: 定义接收类
 * @date 2018/1/22 上午9:57
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received < " + message + ">");
        latch.countDown();
    }
}
