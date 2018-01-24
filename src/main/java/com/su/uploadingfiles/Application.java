/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.uploadingfiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.su.uploadingfiles.storage.StorageProperties;
import com.su.uploadingfiles.storage.StorageService;

/**
 * @author suxiongye
 * @Package com.su.uploadingfiles
 * @Description: 采用Spring提供的MultipartFile接收上传文件
 * @EnableConfigurationProperties 声明让spring自己寻找注入方式
 * @date 2018/1/24 15:42
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}

