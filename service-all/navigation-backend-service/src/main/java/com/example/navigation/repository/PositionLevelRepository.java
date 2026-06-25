package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.position.PositionLevel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionLevelRepository extends JpaRepository<PositionLevel, Integer> {

}
