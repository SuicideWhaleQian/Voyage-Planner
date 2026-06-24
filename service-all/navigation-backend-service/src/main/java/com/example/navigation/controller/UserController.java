package com.example.navigation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigation.dto.Result;
import com.example.navigation.dto.request.UserLoginRequest;
import com.example.navigation.dto.response.UserInfo;
import com.example.navigation.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody UserLoginRequest uLoginRequest) {
        UserInfo login = userService.login(uLoginRequest);
        return Result.success(login);
    }

}
