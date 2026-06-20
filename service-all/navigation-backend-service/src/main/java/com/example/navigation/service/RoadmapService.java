package com.example.navigation.service;

import com.example.navigation.entity.CareerNode;
import com.example.navigation.entity.User;
import com.example.navigation.repository.CareerNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoadmapService {

    @Autowired
    private CareerNodeRepository careerNodeRepository;

    public Map<String, Object> getRoadmap(User user) {
        List<CareerNode> allNodes = careerNodeRepository.findAllByOrderBySortOrderAsc();

        String currentRank = user.getCurrentRank();
        int progress = 0;

        // 计算进度
//        for (int i = 0; i < allNodes.size(); i++) {
//            if (currentRank != null && currentRank.equals(allNodes.get(i).getRankCode())) {
//                progress = (i + 1) * 100 / allNodes.size();
//                break;
//            }
//        }

        Map<String, Object> data = new HashMap<>();
        data.put("roadmap", allNodes);
        data.put("currentRank", currentRank);
        data.put("targetRank", user.getTargetRank());
        data.put("progress", progress);

        return data;
    }
}