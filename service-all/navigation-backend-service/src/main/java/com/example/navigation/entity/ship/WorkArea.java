package com.example.navigation.entity.ship;

import org.hibernate.annotations.Comment;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class WorkArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("航区id")
    private Integer workAreaId;

    @Comment("航区名称")
    private String workAreaName;

}
