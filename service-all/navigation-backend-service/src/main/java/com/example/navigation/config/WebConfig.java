package com.example.navigation.config;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final FilesServerConfig filesServerConfig;

    public WebConfig(FilesServerConfig filesServerConfig) {
        this.filesServerConfig = filesServerConfig;
    }

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {

        String uploadPath = filesServerConfig.uploadPath();

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();

            if (!created) {
                throw new RuntimeException("上传目录创建失败：" + uploadDir.getAbsolutePath());
            }
        }

        System.out.println("上传文件保存目录:" + uploadDir.getAbsolutePath());
        System.out.println("网络资源地址：" + filesServerConfig.networkPath() + "/资源");
        registry.addResourceHandler(filesServerConfig.accessPath())
                .addResourceLocations("file:" + filesServerConfig.uploadPath());
    }
}
