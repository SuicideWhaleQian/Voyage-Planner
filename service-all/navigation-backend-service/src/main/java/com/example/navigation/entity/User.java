package com.example.navigation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "user_id", length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;                                 // 用户ID，自增主键

    @Column(unique = true, nullable = false, length = 50)
    private String username;                         // 用户名，唯一，不能为空

    @Column(nullable = false)
    private String password;                         // 密码

    @Column(length = 50)
    private String name;                             // 用户姓名/昵称

    @Column(name = "current_rank", length = 50)
    private String currentRank;                      // 当前职位

    @Column(name = "target_rank", length = 50)
    private String targetRank;                       // 目标职位

    @Column(length = 255)
    private String avatar;                           // 头像图片URL
}