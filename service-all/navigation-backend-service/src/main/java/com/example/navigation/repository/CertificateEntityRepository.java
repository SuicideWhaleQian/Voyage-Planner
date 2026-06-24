package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.certificate.CertificateEntity;

public interface CertificateEntityRepository extends JpaRepository<CertificateEntity,Integer>{
    
}
