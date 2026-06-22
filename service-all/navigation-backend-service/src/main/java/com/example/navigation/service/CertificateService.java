package com.example.navigation.service;

import com.example.navigation.entity.Certificate;
import com.example.navigation.entity.CertificateType;
import com.example.navigation.entity.User;
import com.example.navigation.model.dto.AddCertificateRequest;
import com.example.navigation.repository.CertificateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CertificateTypeService certificateTypeService;

    /**
     * 为用户添加证书
     */
    @Transactional
    public Certificate addCertificate(AddCertificateRequest request) {
        // 1. 查询用户是否存在
        User user = userService.findById(request.getUserId());

        // 2. 查询证书类型是否存在
        CertificateType type = certificateTypeService.findById(request.getTypeId());

        // 3. 创建证书
        Certificate certificate = new Certificate();
        certificate.setUser(user);
        certificate.setType(type);
        certificate.setImage(request.getImage());
        certificate.setStartDate(request.getStartDate());

        // 4. 保存
        return certificateRepository.save(certificate);
    }
}
