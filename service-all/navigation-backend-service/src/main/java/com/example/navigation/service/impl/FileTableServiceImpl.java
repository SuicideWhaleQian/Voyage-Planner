package com.example.navigation.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.navigation.config.FilesServerConfig;
import com.example.navigation.entity.FileTable;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.FileTableRepository;
import com.example.navigation.service.FileTableService;

@Service
public class FileTableServiceImpl implements FileTableService {
    private final FileTableRepository fileTableRepository;
    private final FilesServerConfig filesServerConfig;

    public FileTableServiceImpl(FileTableRepository fileTableRepository, FilesServerConfig filesServerConfig) {
        this.fileTableRepository = fileTableRepository;
        this.filesServerConfig = filesServerConfig;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BusinessException(403, "上传的文件不能为空");
        }

        // 获取文件原名称
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.trim().isEmpty()) {
            throw new BusinessException(403, "文件名称不能为空");
        }

        int lastDotIndexOf = originalFilename.lastIndexOf(".");
        if (lastDotIndexOf == -1 || lastDotIndexOf == originalFilename.length() - 1) {
            throw new BusinessException(403, "文件格式不正确");
        }

        // 获取文件后缀
        String suffix = originalFilename.substring(lastDotIndexOf);
        // 新的文件名称
        String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;

        try {
            // 上传的文件路径
            Path uploadDir = Paths.get(filesServerConfig.uploadPath())
                    .toAbsolutePath()
                    .normalize();
            Files.createDirectories(uploadDir);
            Path destPath = uploadDir.resolve(newFileName);

            if (destPath == null) {
                throw new BusinessException(500, "文件上传路径不存在");
            }

            file.transferTo(destPath);
            String networkPath = filesServerConfig.networkPath() + "/" + newFileName;

            FileTable fileTable = new FileTable(
                    null,
                    networkPath,
                    destPath.toString(),
                    suffix);
            fileTableRepository.save(fileTable);

            return networkPath;
        } catch (IllegalStateException | IOException e) {
            throw new BusinessException(500, "文件保存失败" + e);
        }
    }

}
