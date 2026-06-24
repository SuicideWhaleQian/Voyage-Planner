package com.example.navigation.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.navigation.dto.request.UserLoginRequest;
import com.example.navigation.dto.response.UserInfo;
import com.example.navigation.service.UserService;

@SpringBootTest
public class UserServiceImplTest {
    private final UserService userService;

    public UserServiceImplTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void testLogin() {
        
        UserInfo login = userService.login(new UserLoginRequest("admin", "123456"));
        
    }
}
