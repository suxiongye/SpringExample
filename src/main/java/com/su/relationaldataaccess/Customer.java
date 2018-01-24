/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.relationaldataaccess;

/**
 * @author suxiongye
 * @Package com.su.relationaldataaccess
 * @Description: 客户类
 * @date 2018/1/24 14:47
 */
public class Customer {
    private long id;
    private String firstName, lastName;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName,lastName);
    }
}
