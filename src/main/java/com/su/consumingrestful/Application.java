/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.consumingrestful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author suxiongye
 * @Package com.su.consumingrestful
 * @Description: 采用Spring提供的RestTemple类，通过Restfull获取json，并封装打印
 * @date 2018/1/23 12:41
 */
@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        directRun();
        bootRun();
    }

    /**
     * 采用直接运行Application方式
     */
    private static void directRun() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        LOGGER.info(quote.toString());
    }

    /**
     * 采用Spring Boot运行
     */
    private static void bootRun() {
        SpringApplication.run(Application.class);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return arg->{
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            LOGGER.info(quote.toString());
        };
    }
}
