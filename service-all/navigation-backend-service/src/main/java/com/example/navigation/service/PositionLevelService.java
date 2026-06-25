package com.example.navigation.service;

import com.example.navigation.dto.response.PositionLevelInfo;

import java.util.List;

public interface PositionLevelService {

    // 查询所有岗位
    List<PositionLevelInfo> findAllPositionLevels();

    // 根据用户id查询岗位
    PositionLevelInfo findPositionLevelByUserId(Integer userId);

}
