/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.uploadingfiles.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author suxiongye
 * @Package com.su.uploadingfiles.storage
 * @Description: 存储配置类
 * @date 2018/1/24 16:25
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * 定义存储路径
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
