package com.example.navigation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "t_certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CertificateType type;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;




}
