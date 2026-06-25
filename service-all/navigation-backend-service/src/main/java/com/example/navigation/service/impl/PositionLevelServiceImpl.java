package com.example.navigation.service.impl;

import com.example.navigation.dto.response.PositionLevelInfo;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.user.User;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.PositionLevelRepository;
import com.example.navigation.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.example.navigation.service.PositionLevelService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionLevelServiceImpl implements PositionLevelService {

    private final PositionLevelRepository positionLevelRepository;

    private final UserRepository userRepository;

    public PositionLevelServiceImpl(PositionLevelRepository positionLevelRepository, UserRepository userRepository) {
        this.positionLevelRepository = positionLevelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PositionLevelInfo> findAllPositionLevels() {

        List<PositionLevel> positionLevels = positionLevelRepository.findAll();

        if (positionLevels.isEmpty()) {
            return List.of();
        }

        return positionLevels.stream()
                .map(level -> new PositionLevelInfo(
                        level.getPositionId(),
                        level.getPositionName()))
                .collect(Collectors.toList());
    }

    @Override
    public PositionLevelInfo findPositionLevelByUserId(Integer userId) {
        if (userId == null) {
            throw new BusinessException(400, "用户ID不能为空");
        }

        // 根据用户ID查询用户信息（自动关联查询职位级别）
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(404, "用户不存在"));

        // 获取用户的职位级别
        PositionLevel positionLevel = user.getPositionLevel();
        if (positionLevel == null) {
            throw new BusinessException(404, "该用户未设置职位级别");
        }

        return new PositionLevelInfo(
                positionLevel.getPositionId(),
                positionLevel.getPositionName());
    }

}
