package com.example.navigation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.user.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserAccount(String userAccount);

    Optional<User> findByUserAccountAndPassword(String userAccount, String password);

    // 检查用户名是否已存在
    boolean existsByUserName(String userName);

    // 根据用户名查找用户（可选，用于其他功能）
    User findByUserName(String userName);
}
