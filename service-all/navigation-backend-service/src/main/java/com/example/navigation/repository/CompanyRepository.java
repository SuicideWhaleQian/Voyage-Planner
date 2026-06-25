package com.example.navigation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.user.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{

    Optional<Company> findByCompanyAccountAndPassword(String companyAccount,String password);

    Optional<Company> findByCompanyName(String companyName);
    
}
