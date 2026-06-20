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

    @Column(name = "min_years")
    private Integer minYears;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @ManyToOne
    @JoinColumn(name = "certificate_type_id")
    private  CertificateType certificateType;



}