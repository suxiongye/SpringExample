/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.schedulingTaskTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author su
 * @Package com.su.schedulingTaskTest
 * @Description: Spring 定时调度功能
 * @date 2018/1/22 上午11:46
 */
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每隔5秒自动调用一次
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        LOGGER.info("The time is now {}", dateFormat.format(new Date()));
    }
}
