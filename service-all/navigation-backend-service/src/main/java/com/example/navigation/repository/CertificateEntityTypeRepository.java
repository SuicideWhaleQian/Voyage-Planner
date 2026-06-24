package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.certificate.CertificateEntityType;

public interface CertificateEntityTypeRepository extends JpaRepository<CertificateEntityType,Integer> {

}
