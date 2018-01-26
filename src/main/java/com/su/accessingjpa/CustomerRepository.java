/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.accessingjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author suxiongye
 * @Package com.su.accessingjpa
 * @Description: TODO
 * @date 2018/1/26 17:37
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
