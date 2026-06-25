package com.example.navigation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigation.dto.Result;
import com.example.navigation.dto.request.UserUploadCertificateRequest;
import com.example.navigation.dto.response.CertificateInfo;
import com.example.navigation.service.CertificateEntityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/certificate")
public class CertificateEntityController {
    private final CertificateEntityService certificateEntityService;

    public CertificateEntityController(CertificateEntityService certificateEntityService) {
        this.certificateEntityService = certificateEntityService;
    }

    @PostMapping("/upload")
    public Result<CertificateInfo> upload(@RequestBody UserUploadCertificateRequest entity) {
        CertificateInfo uploadCertificate = certificateEntityService.uploadCertificate(entity);
        return Result.success(uploadCertificate);
    }

    @GetMapping("/get")
    public Result<List<CertificateInfo>> getAllByUser(@RequestParam Integer uid) {
        List<CertificateInfo> allCertificateByUser = certificateEntityService.findAllCertificateByUser(uid);
        return Result.success(allCertificateByUser);
    }

}
