package com.example.navigation.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddCertificateRequest {
    private Long userId;        // 用户ID
    private Integer typeId;     // 证书类型ID
    private String image;       // 证书图片URL
    private LocalDate startDate; // 发证日期
}
