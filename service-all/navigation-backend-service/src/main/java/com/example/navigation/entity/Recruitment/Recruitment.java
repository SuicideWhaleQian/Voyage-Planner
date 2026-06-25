package com.example.navigation.entity.Recruitment;

import java.util.List;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.certificate.CertificateEntityType;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.ship.ShipType;
import com.example.navigation.entity.ship.WorkArea;
import com.example.navigation.entity.user.Company;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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
    private PositionLevel position;

    @Comment("招聘人数")
    private Integer recruitCount;

    @Comment("最低薪资")
    private Integer salaryMin;

    @Comment("最高薪资")
    private Integer salaryMax;

    @Comment("船支类型")
    @ManyToOne(fetch = FetchType.LAZY)
    private ShipType shipType;

    @Comment("航线")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_area_id")
    private WorkArea workArea;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recruitment_certificate", joinColumns = @JoinColumn(name = "recruitment_id"), inverseJoinColumns = @JoinColumn(name = "certificate_id"))
    private List<CertificateEntityType> certificateTypes;

    @Comment("1.招聘中 2.已结束")
    private Integer status;

}
