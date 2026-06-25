package com.example.navigation.controller;

import com.example.navigation.dto.Result;
import com.example.navigation.dto.response.PositionLevelInfo;
import com.example.navigation.dto.response.PositionLevelRequirementInfo;
import com.example.navigation.service.PositionLevelRequirementService;
import com.example.navigation.service.PositionLevelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position/type")
public class PositionLevelRequirementController {


    private final PositionLevelRequirementService requirementService;

    public PositionLevelRequirementController(PositionLevelRequirementService requirementService) {
        this.requirementService = requirementService;
    }

    /**
     * 查询所有
     * GET /position/all
     */
    @GetMapping("/all")
    public Result<List<PositionLevelRequirementInfo>> findAllPositionRequirements() {
        List<PositionLevelRequirementInfo> requirementInfoList = requirementService.findAllPositionsWithCertificates();
        return Result.success(requirementInfoList);
    }


}
