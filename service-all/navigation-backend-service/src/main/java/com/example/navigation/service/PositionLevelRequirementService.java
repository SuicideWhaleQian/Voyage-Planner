package com.example.navigation.service;

import com.example.navigation.dto.response.PositionLevelRequirementInfo;

import java.util.List;

public interface PositionLevelRequirementService {

    // 查询所有职位及其证书
    List<PositionLevelRequirementInfo> findAllPositionsWithCertificates();
    
}
