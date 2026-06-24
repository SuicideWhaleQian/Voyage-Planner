package com.example.navigation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/test1")
    public String getMethodName() {
        return "测试的接口";
    }

}
