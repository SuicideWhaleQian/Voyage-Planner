package com.example.navigation.controller;

import com.example.navigation.entity.User;
import com.example.navigation.model.dto.LoginRequest;
import com.example.navigation.model.dto.RegisterRequest;
import com.example.navigation.model.dto.Result;
import com.example.navigation.service.UserService;
import com.example.navigation.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    /**
     * 登录
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = userService.findByUsername(request.getUsername());

        if (userOpt.isEmpty()) {
            return Result.error(401, "用户名或密码错误");
        }

        User user = userOpt.get();
        if (!request.getPassword().equals(user.getPassword())) {
            return Result.error(401, "用户名或密码错误");
        }

        String token = jwtUtil.generateToken(user.getId().toString());

        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("username", user.getUsername());
        data.put("name", user.getName());

        return Result.success(data);
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @PostMapping("/register")
    public Result<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        // 1. 检查用户名是否已存在
        if (userService.findByUsername(request.getUsername()).isPresent()) {
            return Result.error(400, "用户名已存在");
        }

        // 2. 创建新用户
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());

        // 3. 保存
        User saved = userService.save(user);

        // 4. 返回结果
        Map<String, Object> data = new HashMap<>();
        data.put("id", saved.getId());
        data.put("username", saved.getUsername());
        data.put("name", saved.getName());

        return Result.success( data);
    }
}