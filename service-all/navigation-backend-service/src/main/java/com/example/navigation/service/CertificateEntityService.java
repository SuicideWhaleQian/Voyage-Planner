package com.example.navigation.service;

import com.example.navigation.dto.request.UserUploadCertificateRequest;
import com.example.navigation.dto.response.CertificateInfo;

public interface CertificateEntityService {
    CertificateInfo uploadCertificate(UserUploadCertificateRequest uploadCertificateRequest);
}
