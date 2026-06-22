package com.example.navigation.repository;

import com.example.navigation.entity.Certificate;
import com.example.navigation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

    /**
     * 根据用户查询证书列表
     */
    List<Certificate> findByUser(User user);


}