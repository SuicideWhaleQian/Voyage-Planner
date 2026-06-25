package com.example.navigation.dto.request;

public record SaveCompanyRequest(
                String companyLogoUrl,
                String companyName,
                String password,
                String businessLicense) {

}
