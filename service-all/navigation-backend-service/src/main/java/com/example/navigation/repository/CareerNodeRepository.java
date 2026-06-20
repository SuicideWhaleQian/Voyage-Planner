package com.example.navigation.repository;

import com.example.navigation.entity.CareerNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CareerNodeRepository extends JpaRepository<CareerNode, Integer> {
    List<CareerNode> findAllByOrderBySortOrderAsc();

    CareerNode findByRankCode(String currentRank);
}