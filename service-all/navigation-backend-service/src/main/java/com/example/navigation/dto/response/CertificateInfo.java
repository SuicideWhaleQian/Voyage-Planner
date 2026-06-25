package com.example.navigation.dto.response;

public record CertificateInfo(
                Integer userId,
                CertificateTypeInfo certificateInfo,
                String certificateImageUrl) {
}
