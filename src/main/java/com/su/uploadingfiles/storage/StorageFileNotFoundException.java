/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.uploadingfiles.storage;

/**
 * @author suxiongye
 * @Package com.su.uploadingfiles.storage
 * @Description: 上传文件无法找到异常类
 * @date 2018/1/24 16:19
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
