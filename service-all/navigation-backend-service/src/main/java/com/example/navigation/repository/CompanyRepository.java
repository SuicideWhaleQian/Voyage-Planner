package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.user.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{
    
}
