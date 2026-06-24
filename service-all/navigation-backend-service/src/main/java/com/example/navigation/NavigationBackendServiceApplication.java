package com.example.navigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class NavigationBackendServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavigationBackendServiceApplication.class, args);
    }

}
