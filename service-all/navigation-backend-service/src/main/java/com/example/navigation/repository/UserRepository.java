package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.user.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
