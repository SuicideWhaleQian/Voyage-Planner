package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.position.PositionLevelRequirement;


import java.util.List;

public interface PositionLevelRequirementRepository extends JpaRepository<PositionLevelRequirement,Integer>{


    // 根据职位ID查询所有证书要求
    List<PositionLevelRequirement> findByPositionLevel_PositionId(Integer positionId);


}
