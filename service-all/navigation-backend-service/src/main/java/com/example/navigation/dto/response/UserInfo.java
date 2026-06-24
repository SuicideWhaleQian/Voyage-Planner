package com.example.navigation.dto.response;

public record UserInfo(
                Integer userId,
                String userName,
                String userAccount,
                String avatarUrl,
                PositionLevelInfo positionLevel) {
}
