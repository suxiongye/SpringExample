/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.accessingjpa;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suxiongye
 * @Package com.su.accessingjpa
 * @Description:
 * @date 2018/1/26 17:47
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Customer> read() {
        return this.customerRepository.findByLastName("Bauer");
    }
}
