package com.example.navigation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.navigation.dto.request.UserUploadCertificateRequest;
import com.example.navigation.dto.response.CertificateInfo;
import com.example.navigation.entity.certificate.CertificateEntity;
import com.example.navigation.entity.certificate.CertificateEntityType;
import com.example.navigation.entity.user.User;
import com.example.navigation.exception.BusinessException;
import com.example.navigation.repository.CertificateEntityRepository;
import com.example.navigation.repository.CertificateEntityTypeRepository;
import com.example.navigation.repository.UserRepository;
import com.example.navigation.service.CertificateEntityService;

@Service
public class CertificateEntityServiceImpl implements CertificateEntityService {
    private final CertificateEntityRepository certificateEntityRepository;
    private final CertificateEntityTypeRepository certificateEntityTypeRepository;
    private final UserRepository userRepository;

    public CertificateEntityServiceImpl(CertificateEntityRepository certificateEntityRepository,
            CertificateEntityTypeRepository certificateEntityTypeRepository, UserRepository userRepository) {
        this.certificateEntityRepository = certificateEntityRepository;
        this.certificateEntityTypeRepository = certificateEntityTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CertificateInfo uploadCertificate(UserUploadCertificateRequest uploadCertificateRequest) {
        Integer certificateTypeId = uploadCertificateRequest.certificateTypeId();
        if (certificateTypeId == null) {
            throw new BusinessException(401, "证书类型不能为空");
        }

        Integer userId = uploadCertificateRequest.userId();
        if (userId == null) {
            throw new BusinessException(401, "用户id不能为空");
        }

        String certificateImageUrl = uploadCertificateRequest.certificateImageUrl();

        if (certificateImageUrl == null || certificateImageUrl.isBlank()) {
            throw new BusinessException(401, "资源地址不能为空");
        }

        CertificateEntityType certificateType = certificateEntityTypeRepository.findById(certificateTypeId)
                .orElseThrow(() -> new BusinessException(400, "证书类型错误"));

        User user = userRepository.findById(certificateTypeId).orElseThrow(() -> new BusinessException(400, "不存在的用户"));

        CertificateEntity certificateEntity = new CertificateEntity(
                null,
                certificateType,
                user,
                certificateImageUrl);
        CertificateEntity save = certificateEntityRepository.save(certificateEntity);

        return new CertificateInfo(save.getCertificateType().getCertificateTypeName(), save.getCertificatePhotoUrl());

    }

    public List<CertificateInfo> findAllCertificateByUser(Integer userId) {
        if (userId == null) {
            throw new BusinessException(401, "请上传正确用户");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException(400, "用户不存在"));

        List<CertificateEntity> userCertificates = certificateEntityRepository.findAllByUser(user);

        List<CertificateInfo> certificateInfos = userCertificates.stream()
                .map(this::certificateEntityTransformToCertificateInfo)
                .toList();

        return certificateInfos;
    }

    private CertificateInfo certificateEntityTransformToCertificateInfo(CertificateEntity certificateEntity) {

        return new CertificateInfo(certificateEntity.getCertificateType().getCertificateTypeName(),
                certificateEntity.getCertificatePhotoUrl());
    }

}
