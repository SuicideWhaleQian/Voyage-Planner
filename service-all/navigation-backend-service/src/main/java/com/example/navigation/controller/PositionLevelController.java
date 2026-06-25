package com.example.navigation.controller;

import com.example.navigation.dto.Result;
import com.example.navigation.dto.request.PositionLevelRequest;
import com.example.navigation.dto.response.PositionLevelInfo;
import com.example.navigation.service.PositionLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionLevelController {

    private final PositionLevelService positionLevelService;

    public PositionLevelController(PositionLevelService positionLevelService) {
        this.positionLevelService = positionLevelService;
    }

    /**
     * 查询所有职位级别
     * GET /position/all
     */
    @GetMapping("/all")
    public Result<List<PositionLevelInfo>> findAllPositionLevels() {
        List<PositionLevelInfo> positionLevels = positionLevelService.findAllPositionLevels();
        return Result.success(positionLevels);
    }

    /**
     * 根据用户ID查询职位级别
     * POST /position/find-by-user
     */
    @PostMapping("/find-by-user")
    public Result<PositionLevelInfo> findPositionLevelByUserId(@RequestBody PositionLevelRequest request) {
        PositionLevelInfo positionLevelInfo = positionLevelService.findPositionLevelById(request);
        return Result.success(positionLevelInfo);
    }



}
