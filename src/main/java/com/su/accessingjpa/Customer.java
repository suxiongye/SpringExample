/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.accessingjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author suxiongye
 * @Package com.su.accessingjpa
 * @Description: TODO
 * @date 2018/1/26 17:33
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName = '%s']", id, firstName, lastName);
    }
}
