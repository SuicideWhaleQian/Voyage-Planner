package com.example.navigation.entity.position;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    protected PositionLevel() {

    }

    public PositionLevel(Integer positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
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

}
