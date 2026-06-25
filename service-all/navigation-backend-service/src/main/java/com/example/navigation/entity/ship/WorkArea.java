package com.example.navigation.entity.ship;

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
@Table(name = "t_work_area")
@Comment("航区表")
public class WorkArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("航区id")
    private Integer workAreaId;

    @Comment("航区名称")
    private String workAreaName;

    @OneToMany(mappedBy = "workArea")
    private List<Recruitment> recruitments = new ArrayList<>();

    protected WorkArea() {
    }

    public WorkArea(String workAreaName) {
        this.workAreaName = workAreaName;
    }

    public Integer getWorkAreaId() {
        return workAreaId;
    }

    public void setWorkAreaId(Integer workAreaId) {
        this.workAreaId = workAreaId;
    }

    public String getWorkAreaName() {
        return workAreaName;
    }

    public void setWorkAreaName(String workAreaName) {
        this.workAreaName = workAreaName;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

}
