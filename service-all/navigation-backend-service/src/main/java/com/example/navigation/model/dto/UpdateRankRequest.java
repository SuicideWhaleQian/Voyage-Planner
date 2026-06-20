package com.example.navigation.model.dto;

import lombok.Data;

@Data
public class UpdateRankRequest {
    private String currentRank;
    private String targetRank;
}