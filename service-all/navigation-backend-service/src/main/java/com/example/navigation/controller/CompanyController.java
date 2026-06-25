package com.example.navigation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigation.dto.Result;
import com.example.navigation.dto.request.CompanyLoginRequest;
import com.example.navigation.dto.request.SaveCompanyRequest;
import com.example.navigation.dto.response.CompanyInfo;
import com.example.navigation.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    protected Result<CompanyInfo> save(@RequestBody SaveCompanyRequest entity) {
        CompanyInfo saveCompany = companyService.saveCompany(entity);
        return Result.success(saveCompany);
    }

    @PostMapping("/login")
    protected Result<CompanyInfo> login(@RequestBody CompanyLoginRequest entity) {
        CompanyInfo companyLogin = companyService.companyLogin(entity);
        return Result.success(companyLogin);
    }

}
