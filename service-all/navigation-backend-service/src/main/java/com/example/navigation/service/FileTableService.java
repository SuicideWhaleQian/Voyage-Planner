package com.example.navigation.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileTableService {
    String uploadFile(MultipartFile file);
}
