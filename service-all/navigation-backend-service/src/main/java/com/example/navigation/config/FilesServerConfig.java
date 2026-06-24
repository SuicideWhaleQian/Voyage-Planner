package com.example.navigation.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "files")
public record FilesServerConfig(
        String networkPath,
        String uploadPath,
        String accessPath,
        List<String> types) {
}
