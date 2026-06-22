package com.example.navigation.controller;

import com.example.navigation.entity.Certificate;
import com.example.navigation.model.dto.AddCertificateRequest;
import com.example.navigation.model.dto.Result;
import com.example.navigation.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    /**
     * 用户添加证书
     */
    @PostMapping
    public Result<Certificate> addCertificate(@RequestBody AddCertificateRequest request) {
        Certificate certificate = certificateService.addCertificate(request);
        return Result.success(certificate);
    }
}