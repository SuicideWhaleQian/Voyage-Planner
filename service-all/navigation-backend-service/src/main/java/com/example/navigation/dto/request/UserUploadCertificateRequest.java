package com.example.navigation.dto.request;

public record UserUploadCertificateRequest(
    Integer userId,
    Integer certificateTypeId,
    String certificateImageUrl
) {

}
