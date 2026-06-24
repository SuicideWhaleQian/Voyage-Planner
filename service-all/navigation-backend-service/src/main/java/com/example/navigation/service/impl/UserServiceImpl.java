package com.example.navigation.service.impl;

import org.springframework.stereotype.Service;

import com.example.navigation.dto.request.UserLoginRequest;
import com.example.navigation.dto.response.PositionLevelInfo;
import com.example.navigation.dto.response.UserInfo;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.user.User;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.UserRepository;
import com.example.navigation.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo login(UserLoginRequest uLoginRequest) {
        if (uLoginRequest.account() == null || uLoginRequest.account().isEmpty()) {
            throw new BusinessException(200, "账号不能为空");
        }

        User user = userRepository.findByUserAccountAndPassword(
                uLoginRequest.account(),
                uLoginRequest.password())
                .orElseThrow(
                        () -> new BusinessException(
                                401,
                                "账号或密码错误"));

        PositionLevel positionLevel = user.getPositionLevel();

        PositionLevelInfo positionLevelInfo = positionLevel == null
                ? null
                : new PositionLevelInfo(
                        positionLevel.getPositionId(),
                        positionLevel.getPositionName());

        return new UserInfo(user.getUserId(),
                user.getUserName(),
                user.getUserAccount(),
                user.getAvatarUrl(),
                positionLevelInfo);
    }

}
