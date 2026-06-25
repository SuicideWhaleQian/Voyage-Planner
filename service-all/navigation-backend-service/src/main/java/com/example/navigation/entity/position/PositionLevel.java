package com.example.navigation.entity.position;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.Recruitment.Recruitment;
import com.example.navigation.entity.certificate.CertificateEntityType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_positions")
@Comment("职位表")
public class PositionLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("职位等级Id")
    private Integer positionId;

    @Comment("职位等级名称")
    private String positionName;

    @ManyToMany
    @JoinTable(name = "position_level_certificate_type", joinColumns = @JoinColumn(name = "position_level_id"), inverseJoinColumns = @JoinColumn(name = "certificate_type_id"))
    @Comment("职位等级需求证书")
    private List<CertificateEntityType> certificates = new ArrayList<>();

    @OneToMany(mappedBy = "positionLevel")
    private List<Recruitment> recruitments = new ArrayList<>();

    protected PositionLevel() {

    }

    public PositionLevel(String positionName, List<CertificateEntityType> certificates) {
        this.positionName = positionName;
        this.certificates = certificates;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<CertificateEntityType> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateEntityType> certificates) {
        this.certificates = certificates;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

}
