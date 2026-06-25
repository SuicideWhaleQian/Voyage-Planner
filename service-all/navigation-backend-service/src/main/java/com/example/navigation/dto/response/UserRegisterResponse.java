package com.example.navigation.dto.response;

public class UserRegisterResponse {

    private Integer userId;
    private String userName;
    private String account;

    public UserRegisterResponse() {
    }

    public UserRegisterResponse(Integer userId, String userName, String account) {
        this.userId = userId;
        this.userName = userName;
        this.account = account;
    }

    // Getter 和 Setter
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
