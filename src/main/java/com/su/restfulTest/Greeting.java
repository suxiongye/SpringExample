/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.restfulTest;

/**
 * @author su
 * @Package com.su.restfulTest
 * @Description: 作为返回的json对象的POJO
 * @date 2018/1/22 上午11:24
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
