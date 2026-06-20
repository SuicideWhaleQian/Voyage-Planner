package com.example.navigation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_certificate_type")
public class CertificateType {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @Column(name = "type_name", nullable = false, length = 50)
    private String typeName;
}
