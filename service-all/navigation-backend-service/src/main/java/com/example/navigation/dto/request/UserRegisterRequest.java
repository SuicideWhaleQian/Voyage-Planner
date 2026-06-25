package com.example.navigation.dto.request;


public class UserRegisterRequest {

    private String userName;
    private String password;

    // 构造函数
    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getter 和 Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
