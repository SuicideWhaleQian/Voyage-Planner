package com.example.navigation.entity.certificate;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_certificate_types")
@Comment("证书类型表")
public class CertificateEntityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("证书类型Id")
    private Integer certificateTypeId;
    @Comment("证书类型名称")
    private String certificateTypeName;

    public CertificateEntityType(Integer certificateTypeId, String certificateTypeName) {
        this.certificateTypeId = certificateTypeId;
        this.certificateTypeName = certificateTypeName;
    }

    public Integer getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(Integer certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }

    public String getCertificateTypeName() {
        return certificateTypeName;
    }

    public void setCertificateTypeName(String certificateTypeName) {
        this.certificateTypeName = certificateTypeName;
    }

}
