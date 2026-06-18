package com.example.navigation.controller;

import com.example.navigation.entity.User;
import com.example.navigation.model.dto.Result;
import com.example.navigation.service.RoadmapService;
import com.example.navigation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public Result<Map<String, Object>> getRoadmap() {
        // 写死用户ID = 1
        User user = userService.findById(1L);

        Map<String, Object> data = roadmapService.getRoadmap(user);

        // 追加用户基本信息
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", user.getName());
        userInfo.put("avatar", user.getAvatar());
        userInfo.put("targetRank", user.getTargetRank());

        data.put("user", userInfo);

        return Result.success(data);
    }
}