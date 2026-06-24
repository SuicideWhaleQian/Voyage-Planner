package com.example.navigation.entity.certificate;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "t_certificates")
@Comment("证书表")
public class CertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("证书id")
    private Integer certificateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_type_id")
    @Comment("证书类型")
    private CertificateEntityType certificateType;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("证书隶属用户")
    private User user;

    @Comment("证书照片地址")
    private String certificatePhotoUrl;

    public CertificateEntity(Integer certificateId, CertificateEntityType certificateType, User user,
            String certificatePhotoUrl) {
        this.certificateId = certificateId;
        this.certificateType = certificateType;
        this.user = user;
        this.certificatePhotoUrl = certificatePhotoUrl;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public CertificateEntityType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateEntityType certificateType) {
        this.certificateType = certificateType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCertificatePhotoUrl() {
        return certificatePhotoUrl;
    }

    public void setCertificatePhotoUrl(String certificatePhotoUrl) {
        this.certificatePhotoUrl = certificatePhotoUrl;
    }

}
