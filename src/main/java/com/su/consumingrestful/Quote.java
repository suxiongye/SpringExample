/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.consumingrestful;

/**
 * @author suxiongye
 * @Package com.su.consumingrestful
 * @Description: 实现对接收对象的封装
 * @date 2018/1/23 12:14
 */
public class Quote {
    private String type;
    private Value value;

    public Quote() {

    }

    public String getType() {
        return type;
    }

    public Value getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" + "type='" + type + "\'" + ",value=" + value + "}";
    }
}
