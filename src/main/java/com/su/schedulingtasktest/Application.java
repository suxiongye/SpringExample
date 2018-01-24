/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.schedulingtasktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author suxiongye
 * @Package com.su.schedulingtasktest
 * @Description: 定时调度功能
 * @date 2018/1/23 12:00
 */

@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
