package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.user.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
