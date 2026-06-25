package com.example.navigation.entity.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.Recruitment.Recruitment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_companies")
@Comment("公司表")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("公司Id")
    private Integer companyId;

    @Comment(value = "公司名称")
    private String companyName;

    @Comment("公司账号")
    private String companyAccount;

    @Comment(value = "公司密码")
    private String password;

    @Comment("LOGO地址")
    private String avatarUrl;

    @Comment("营业执照")
    private String businessLicense;

    @OneToMany(mappedBy = "company")
    private List<Recruitment> recruitments = new ArrayList<>();

    protected Company() {

    }

    public Company(String companyName, String companyAccount, String password, String avatarUrl,
            String businessLicense) {
        this.companyName = companyName;
        this.companyAccount = companyAccount;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.businessLicense = businessLicense;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

}