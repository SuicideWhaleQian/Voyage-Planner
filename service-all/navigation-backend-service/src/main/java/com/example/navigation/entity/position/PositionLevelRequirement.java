package com.example.navigation.entity.position;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.certificate.CertificateEntityType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_position_level_requirement")
@Comment("职位需求表")
public class PositionLevelRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("职位级别需求id")
    private Integer requirementId;

    @Comment("职位级别")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionLevel positionLevel;

    @Comment("职位证书类型需求")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_type_id", nullable = false)
    private CertificateEntityType certificate;

    protected PositionLevelRequirement() {

    }

    public PositionLevelRequirement(Integer requirementId, PositionLevel positionLevel,
            CertificateEntityType certificate) {
        this.requirementId = requirementId;
        this.positionLevel = positionLevel;
        this.certificate = certificate;
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public PositionLevel getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(PositionLevel positionLevel) {
        this.positionLevel = positionLevel;
    }

    public CertificateEntityType getCertificate() {
        return certificate;
    }

    public void setCertificate(CertificateEntityType certificate) {
        this.certificate = certificate;
    }

}
