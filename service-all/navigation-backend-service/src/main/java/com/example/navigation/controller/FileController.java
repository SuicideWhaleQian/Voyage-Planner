package com.example.navigation.controller;

import com.example.navigation.model.dto.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Value("${file.upload.dir:uploads}")
    private String uploadDir;

    @Value("${file.upload.base-url:https://deepdistillation.xyz:8081}")
    private String baseUrl;

    // 允许的文件类型
    private static final String[] ALLOWED_TYPES = {
            "image/jpeg", "image/png", "image/gif", "image/webp",
            "application/pdf",
            "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
    };

    // 最大文件大小：5MB
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

    @PostMapping("/upload")
    public Result<Map<String, Object>> upload(@RequestParam("file") MultipartFile file) {
        // 1. 检查文件是否为空
        if (file.isEmpty()) {
            return Result.error(400, "文件不能为空");
        }

        // 2. 检查文件大小
        if (file.getSize() > MAX_FILE_SIZE) {
            return Result.error(400, "文件大小不能超过5MB");
        }

        // 3. 检查文件类型
        String contentType = file.getContentType();
        if (!isAllowedType(contentType)) {
            return Result.error(400, "不支持的文件类型，仅支持：图片、PDF、Word、Excel");
        }

        try {
            // 4. 构建存储路径：uploads/日期/UUID_原文件名
            String datePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            String originalFilename = file.getOriginalFilename();
            String baseName = originalFilename;
            String extension = "";

            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                baseName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            }

            String newFileName = baseName + "_" + System.currentTimeMillis() + extension;
            if (newFileName.length() > 100) {
                newFileName = newFileName.substring(0, 100);
            }

            String relativePath = datePath + "/" + newFileName;
            String fullPath = uploadDir + File.separator + relativePath;

            // 5. 创建目录并保存文件
            Path path = Paths.get(fullPath);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            // 6. 返回访问URL
            String url = baseUrl + "/uploads/" + relativePath.replace("\\", "/");

            Map<String, Object> data = new HashMap<>();
            data.put("url", url);
            data.put("size", file.getSize());
            data.put("type", contentType);
            data.put("filename", newFileName);

            return Result.success( data);

        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(500, "文件保存失败：" + e.getMessage());
        }
    }

    private boolean isAllowedType(String contentType) {
        if (contentType == null) return false;
        for (String allowed : ALLOWED_TYPES) {
            if (allowed.equals(contentType)) {
                return true;
            }
        }
        return false;
    }
}