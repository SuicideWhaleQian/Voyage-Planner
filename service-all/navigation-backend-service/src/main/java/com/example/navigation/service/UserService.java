package com.example.navigation.service;

import com.example.navigation.dto.request.UserLoginRequest;
import com.example.navigation.dto.request.UserRegisterRequest;
import com.example.navigation.dto.response.UserInfo;
import com.example.navigation.dto.response.UserRegisterResponse;

public interface UserService {
    UserInfo login(UserLoginRequest uLoginRequest);

    UserRegisterResponse register(UserRegisterRequest request);
}
