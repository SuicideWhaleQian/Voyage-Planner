package com.example.navigation.service.impl;

import com.example.navigation.dto.request.UserRegisterRequest;
import com.example.navigation.dto.response.UserRegisterResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.navigation.dto.request.UserLoginRequest;
import com.example.navigation.dto.response.CertificateTypeInfo;
import com.example.navigation.dto.response.PositionLevelInfo;
import com.example.navigation.dto.response.UserInfo;
import com.example.navigation.entity.certificate.CertificateEntityType;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.user.User;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.UserRepository;
import com.example.navigation.service.UserService;
import com.example.navigation.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
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
        if (positionLevel == null) {
            return new UserInfo(user.getUserId(),
                    user.getUserName(),
                    user.getUserAccount(),
                    user.getAvatarUrl(),
                    null);
        }

        PositionLevelInfo positionLevelInfo = positionLevelEntityTransformToPositionLevelInfo(positionLevel);

        return new UserInfo(user.getUserId(),
                user.getUserName(),
                user.getUserAccount(),
                user.getAvatarUrl(),
                positionLevelInfo);
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest request) {
        // 1. 参数校验
        if (request.getUserName() == null || request.getUserName().trim().isEmpty()) {
            throw new BusinessException(402, "用户名称不能为空");
        }

        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new BusinessException(402, "密码不能为空");
        }

        // 2. 检查用户名是否已存在
        if (userRepository.existsByUserName(request.getUserName())) {
            throw new BusinessException(402, "用户名称已存在");
        }

        // 3. 创建新用户

        // 随机账号
        String account = UserUtil.generateAccount("3304");

        User newUser = new User();
        newUser.setUserName(request.getUserName());
        newUser.setUserAccount(account);
        newUser.setPassword(request.getPassword());
        newUser.setAvatarUrl(null);
        newUser.setPositionLevel(null);

        // 4. 保存用户
        User savedUser = userRepository.save(newUser);

        // 5. 返回注册结果
        return new UserRegisterResponse(
                savedUser.getUserId(),
                savedUser.getUserName(),
                account);

    }

    private PositionLevelInfo positionLevelEntityTransformToPositionLevelInfo(PositionLevel positionLevel) {
        List<CertificateEntityType> certificates = positionLevel.getCertificates();
        // 拿到职位需求证书类型
        if (certificates == null) {
            certificates = new ArrayList<>();
        }
        List<CertificateTypeInfo> list = certificates.stream()
                .map(this::certificateTransformToCertificateInfo)
                .toList();

        return new PositionLevelInfo(
                positionLevel.getPositionId(),
                positionLevel.getPositionName(),
                list);
    }

    private CertificateTypeInfo certificateTransformToCertificateInfo(CertificateEntityType certificateType) {
        return new CertificateTypeInfo(
                certificateType.getCertificateTypeId(),
                certificateType.getCertificateTypeName());
    }
}
