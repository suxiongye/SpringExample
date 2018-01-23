/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.restfultest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author su
 * @Package com.su.restfultest
 * @Description: 直接内置方式启动Spring
 * @date 2018/1/22 上午11:34
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
