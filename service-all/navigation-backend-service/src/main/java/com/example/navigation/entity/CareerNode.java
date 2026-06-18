package com.example.navigation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_career_node")
public class CareerNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rank_code", nullable = false, length = 20)
    private String rankCode;

    @Column(name = "rank_name", nullable = false, length = 50)
    private String rankName;

    @Column(nullable = false, length = 50)
    private String duration;

    @Column(name = "core_cert", nullable = false, length = 100)
    private String coreCert;

    @Column(name = "min_years")
    private Integer minYears;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @Column(name = "is_active")
    private Integer isActive = 1;
}