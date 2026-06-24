package com.example.navigation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserAccount(String userAccount);

    Optional<User> findByUserAccountAndPassword(String userAccount, String password);
}
