/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.relationaldataaccess;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author suxiongye
 * @Package com.su.relationaldataaccess
 * @Description: 采用JdbcTemplate构建与SQL关系数据库交互的客户端
 * @date 2018/1/24 14:49
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    /**
     * 继承CommandLineRunner接口表示会在所有context加载后执行run方法
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    /**
     * 默认采用内存数据库引擎
     */
        JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // split up the array of whole names into an array of first/last name
        List<Object[]> splitUpNames =
            Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream().map(name -> name.split(" "))
                .collect(Collectors.toList());

        // 采用java8输出所有名字
        splitUpNames
            .forEach(name -> LOGGER.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // 采用jdbcTemplate的更新操作进行数据库操作
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        LOGGER.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate
            .query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] {"Josh"},
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
            .forEach(customer -> LOGGER.info(customer.toString()));
    }
}
