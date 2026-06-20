package com.example.navigation.service;

import com.example.navigation.entity.CareerNode;
import com.example.navigation.entity.User;
import com.example.navigation.repository.CareerNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        // 如果用户有当前职位，从当前职位开始截取
        List<CareerNode> resultNodes = new ArrayList<>();

        boolean startAdding = false;

        for (CareerNode node : allNodes) {
            if (currentRank != null && !currentRank.isEmpty()) {
                if (currentRank.equals(node.getRankCode())) {
                    startAdding = true;
                }
                if (startAdding) {
                    resultNodes.add(node);
                }
            } else {
                resultNodes.add(node);
            }
        }

        // 兜底：如果没有匹配上，返回所有节点
        if (resultNodes.isEmpty()) {
            resultNodes = allNodes;
        }

        // 计算每个节点所需的年限（从上一个节点到当前节点需要几年）
        for (int i = 0; i < resultNodes.size(); i++) {
            CareerNode node = resultNodes.get(i);
            Integer requiredYears = null;
            if (i == 0) {
                // 第一个节点（当前职位），所需年限为0
                requiredYears = 0;
            } else {
                CareerNode prevNode = resultNodes.get(i - 1);
                if (prevNode.getMinYears() != null && node.getMinYears() != null) {
                    requiredYears = node.getMinYears() - prevNode.getMinYears();
                }
            }
            node.setRequiredYears(requiredYears);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("roadmap", resultNodes);

        // 追加用户基本信息
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", user.getName());
        userInfo.put("targetRank", user.getTargetRank());
        userInfo.put("currentRank", user.getCurrentRank());

        data.put("user", userInfo);

        return data;
    }
}