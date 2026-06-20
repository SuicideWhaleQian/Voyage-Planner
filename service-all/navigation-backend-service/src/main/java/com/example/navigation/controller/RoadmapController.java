package com.example.navigation.controller;

import com.example.navigation.entity.User;
import com.example.navigation.model.dto.Result;
import com.example.navigation.service.RoadmapService;
import com.example.navigation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/roadmap")
public class RoadmapController {

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Result<Map<String, Object>> getRoadmap(@PathVariable Long userId) {
        // 根据用户ID查询用户
        User user = userService.findById(userId);

        Map<String, Object> data = roadmapService.getRoadmap(user);

        return Result.success(data);
    }
}