package com.example.navigation.service;

import java.util.List;

import com.example.navigation.dto.request.UserUploadCertificateRequest;
import com.example.navigation.dto.response.CertificateInfo;

public interface CertificateEntityService {
    CertificateInfo uploadCertificate(UserUploadCertificateRequest uploadCertificateRequest);

    List<CertificateInfo> findAllCertificateByUser(Integer userId);
}
