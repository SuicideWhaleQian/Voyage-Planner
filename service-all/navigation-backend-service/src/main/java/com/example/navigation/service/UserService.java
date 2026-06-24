package com.example.navigation.service;

import com.example.navigation.dto.request.UserLoginRequest;
import com.example.navigation.dto.response.UserInfo;

public interface UserService {
    UserInfo login(UserLoginRequest uLoginRequest);
}
