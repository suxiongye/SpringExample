/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.uploadingfiles.storage;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author suxiongye
 * @Package com.su.uploadingfiles.storage
 * @Description: 定义存储服务接口
 * @date 2018/1/24 15:49
 */
public interface StorageService {
    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String fileName);

    Resource loadAsResource(String fileName);

    void deleteAll();
}
