package com.example.navigation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.certificate.CertificateEntity;
import com.example.navigation.entity.user.User;

public interface CertificateEntityRepository extends JpaRepository<CertificateEntity,Integer>{

    List<CertificateEntity> findAllByUser(User user);
    
}
