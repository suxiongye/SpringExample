/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.authenticatingladp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author suxiongye
 * @Package com.su.authenticatingladp
 * @Description: 采用ldap验证机制控制访问权限
 * @date 2018/1/26 10:14
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
