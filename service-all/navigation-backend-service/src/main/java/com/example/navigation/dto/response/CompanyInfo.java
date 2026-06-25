package com.example.navigation.dto.response;

public record CompanyInfo(
    Integer companyId,
    String companyName,
    String companyAccount,
    String companyLogo,
    String businessLicense
) {
    
}
