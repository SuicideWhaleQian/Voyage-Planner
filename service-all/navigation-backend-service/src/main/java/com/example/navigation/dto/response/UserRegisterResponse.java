package com.example.navigation.dto.response;

public class UserRegisterResponse {

    private Integer userId;
    private String userName;


    public UserRegisterResponse() {
    }

    public UserRegisterResponse(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;

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


}
