/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.uploadingfiles.storage;

/**
 * @author suxiongye
 * @Package com.su.uploadingfiles.storage
 * @Description: 定义存储异常类
 * @date 2018/1/24 16:17
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
