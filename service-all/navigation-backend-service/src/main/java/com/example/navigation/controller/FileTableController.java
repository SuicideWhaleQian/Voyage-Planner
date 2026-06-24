package com.example.navigation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.navigation.dto.Result;
import com.example.navigation.service.FileTableService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/files")
public class FileTableController {
    private final FileTableService fileTableService;

    public FileTableController(FileTableService fileTableService) {
        this.fileTableService = fileTableService;
    }

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        String uploadFile = fileTableService.uploadFile(file);
        return Result.success(uploadFile);
    }

}
