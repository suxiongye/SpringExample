/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.consumingrestful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author suxiongye
 * @Package com.su.consumingrestful
 * @Description: 内置变量封装
 * @JsonIgnoreProperties 表示忽略接收的json中未匹配的字段
 * @date 2018/1/23 12:35
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    private Long id;
    private String quote;

    public Value() {

    }

    public String getQuote() {
        return quote;
    }

    public Long getId() {
        return id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Value{" + "id=" + id + ", quote='" + quote + "\'" + '}';
    }
}
