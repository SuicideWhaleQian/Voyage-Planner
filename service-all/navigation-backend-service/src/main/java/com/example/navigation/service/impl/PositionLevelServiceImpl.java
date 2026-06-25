package com.example.navigation.service.impl;

import com.example.navigation.dto.response.CertificateTypeInfo;
import com.example.navigation.dto.response.PositionLevelInfo;
import com.example.navigation.entity.certificate.CertificateEntityType;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.user.User;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.PositionLevelRepository;
import com.example.navigation.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.navigation.service.PositionLevelService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionLevelServiceImpl implements PositionLevelService {

    private final PositionLevelRepository positionLevelRepository;

    private final UserRepository userRepository;

    public PositionLevelServiceImpl(PositionLevelRepository positionLevelRepository, UserRepository userRepository) {
        this.positionLevelRepository = positionLevelRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PositionLevelInfo> findAllPositionLevels() {
        // 拿到所有职位信息
        List<PositionLevel> positionLevels = positionLevelRepository.findAll();

        if (positionLevels.isEmpty()) {
            return List.of();
        }

        List<PositionLevelInfo> list = positionLevels.stream()
                .map(this::positionLevelEntityTransformToPositionLevelInfo)
                .toList();

        return list;
    }

    @Override
    @Transactional(readOnly = true)
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

        return positionLevelEntityTransformToPositionLevelInfo(positionLevel);
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
