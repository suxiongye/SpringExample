/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.authenticatingladp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suxiongye
 * @Package com.su
 * @Description: 欢迎界面
 * @date 2018/1/26 10:10
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page";
    }
}
