package com.example.navigation.entity.Recruitment;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.certificate.CertificateEntityType;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.ship.ShipType;
import com.example.navigation.entity.ship.WorkArea;
import com.example.navigation.entity.user.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_recruitment")
@Comment("招聘表")
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("招聘id")
    private Integer recruitmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    @Comment("隶属公司")
    private Company company;

    @Comment("招聘标题")
    private String title;

    @JoinColumn(name = "position_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("招聘岗位")
    private PositionLevel positionLevel;

    @Comment("招聘人数")
    private Integer recruitCount;

    @Comment("最低薪资")
    private Integer salaryMin;

    @Comment("最高薪资")
    private Integer salaryMax;

    @Comment("船支类型")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_type_id", nullable = false)
    private ShipType shipType;

    @Comment("航线")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_area_id")
    private WorkArea workArea;

    @ManyToMany
    @JoinTable(name = "recruitment_certificate", joinColumns = @JoinColumn(name = "recruitment_id"), inverseJoinColumns = @JoinColumn(name = "certificate_id"))
    @Comment("所需证书")
    private List<CertificateEntityType> certificateTypes;

    @Comment("0.招聘中 1.已结束")
    private Integer status;

    @Comment("发布时间")
    private LocalDate publishTime;

    @Comment("截至日期")
    private LocalDate deadline;

    protected Recruitment() {
    }

    public Recruitment(Company company, String title, PositionLevel positionLevel,
            Integer recruitCount, Integer salaryMin, Integer salaryMax, ShipType shipType, WorkArea workArea,
            List<CertificateEntityType> certificateTypes, Integer status) {
        this.company = company;
        this.title = title;
        this.positionLevel = positionLevel;
        this.recruitCount = recruitCount;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.shipType = shipType;
        this.workArea = workArea;
        this.certificateTypes = certificateTypes;
        this.status = status;
    }

    public Integer getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Integer recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PositionLevel getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(PositionLevel positionLevel) {
        this.positionLevel = positionLevel;
    }

    public Integer getRecruitCount() {
        return recruitCount;
    }

    public void setRecruitCount(Integer recruitCount) {
        this.recruitCount = recruitCount;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }

    public void setWorkArea(WorkArea workArea) {
        this.workArea = workArea;
    }

    public List<CertificateEntityType> getCertificateTypes() {
        return certificateTypes;
    }

    public void setCertificateTypes(List<CertificateEntityType> certificateTypes) {
        this.certificateTypes = certificateTypes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDate publishTime) {
        this.publishTime = publishTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

}
