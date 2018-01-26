/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.accessingjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author suxiongye
 * @Package com.su.accessingjpa
 * @Description: TODO
 * @date 2018/1/26 17:38
 */
@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            repository.save(new Customer("Jack", "Bauer"));
            LOGGER.info("Customers found with findAll()");
            for (Customer bauer : repository.findByLastName("Bauer")){
                LOGGER.info(bauer.toString());
            }
            LOGGER.info("");
        };
    }
}
