package com.example.navigation.config;

import org.springframework.context.annotation.Configuration;
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
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("网络资源地址：" + filesServerConfig.networkPath() + "/资源");
        registry.addResourceHandler(filesServerConfig.accessPath())
                .addResourceLocations(filesServerConfig.uploadPath());
    }
}
