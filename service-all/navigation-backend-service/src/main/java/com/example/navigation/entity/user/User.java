package com.example.navigation.entity.user;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.position.PositionLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "t_users")
@Comment("用户表")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "用户Id")
    private Integer userId;

    @Comment(value = "用户名称")
    private String userName;

    @Comment("用户账号")
    private String userAccount;

    @Comment(value = "用户密码")
    private String password;

    @Comment("头像地址")
    private String avatarUrl;

    @Comment("用户职位级别")
    @JoinColumn(name = "position_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PositionLevel positionLevel;

    protected User() {

    }

    public User(Integer userId, String userName, String userAccount, String password, String avatarUrl,
            PositionLevel positionLevel) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.positionLevel = positionLevel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public PositionLevel getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(PositionLevel positionLevel) {
        this.positionLevel = positionLevel;
    }

}
