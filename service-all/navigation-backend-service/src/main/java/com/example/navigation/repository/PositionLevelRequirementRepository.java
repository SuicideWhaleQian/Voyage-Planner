package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.position.PositionLevelRequirement;

public interface PositionLevelRequirementRepository extends JpaRepository<PositionLevelRequirement,Integer>{
     
}
