/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.su.uploadingfiles;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.su.uploadingfiles.storage.StorageFileNotFoundException;
import com.su.uploadingfiles.storage.StorageService;

/**
 * @author suxiongye
 * @Package com.su.uploadingfiles
 * @Description: 文件上传控制类
 * @date 2018/1/24 15:48
 */
@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * 查看所有文件
     *
     * @param model
     *
     * @return
     *
     * @throws IOException
     */
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(path -> MvcUriComponentsBuilder
                                                                             .fromMethodName(FileUploadController.class,
                                                                                 "serveFile",
                                                                                 path.getFileName().toString()).build()
                                                                             .toString()).collect(Collectors.toList()));
        return "uploadForm";
    }

    /**
     * 获取文件
     *
     * @param fileName
     *
     * @return
     */
    @GetMapping("/files/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String fileName) {
        Resource file = storageService.loadAsResource(fileName);
        return ResponseEntity.ok()
                   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + file.getFilename() + "\"")
                   .body(file);
    }

    /**
     * 上传文件
     *
     * @param file
     * @param redirectAttributes
     *
     * @return
     */
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes
            .addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}