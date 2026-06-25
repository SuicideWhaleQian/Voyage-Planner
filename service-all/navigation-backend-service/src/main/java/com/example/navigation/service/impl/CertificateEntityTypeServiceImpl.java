package com.example.navigation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.navigation.dto.response.CertificateTypeInfo;
import com.example.navigation.entity.certificate.CertificateEntityType;
import com.example.navigation.repository.CertificateEntityTypeRepository;
import com.example.navigation.service.CertificateEntityTypeService;

@Service
public class CertificateEntityTypeServiceImpl implements CertificateEntityTypeService {
    private final CertificateEntityTypeRepository certificateEntityTypeRepository;

    public CertificateEntityTypeServiceImpl(CertificateEntityTypeRepository certificateEntityTypeRepository) {
        this.certificateEntityTypeRepository = certificateEntityTypeRepository;
    }

    @Override
    public List<CertificateTypeInfo> getAllCertificateType() {
        return certificateEntityTypeRepository
                .findAll()
                .stream()
                .map(this::certificateEntityTypeTransformToCertificateTypeInfo)
                .toList();
    }

    private CertificateTypeInfo certificateEntityTypeTransformToCertificateTypeInfo(
            CertificateEntityType certificateEntityType) {
        return new CertificateTypeInfo(certificateEntityType.getCertificateTypeId(),
                certificateEntityType.getCertificateTypeName());
    }
}
