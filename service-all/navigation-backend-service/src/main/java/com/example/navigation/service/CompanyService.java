package com.example.navigation.service;

import java.util.List;

import com.example.navigation.dto.request.SaveCompanyRequest;
import com.example.navigation.dto.response.CompanyInfo;

public interface CompanyService {

    CompanyInfo saveCompany(SaveCompanyRequest entity);

    List<CompanyInfo> findAllCompany();
    
}
