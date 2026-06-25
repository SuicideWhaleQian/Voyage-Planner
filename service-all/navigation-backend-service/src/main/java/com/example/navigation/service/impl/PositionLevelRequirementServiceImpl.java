package com.example.navigation.service.impl;

import com.example.navigation.dto.response.CertificateTypeInfo;
import com.example.navigation.dto.response.PositionLevelRequirementInfo;
import com.example.navigation.entity.position.PositionLevel;
import com.example.navigation.entity.position.PositionLevelRequirement;
import com.example.navigation.repository.PositionLevelRepository;
import com.example.navigation.repository.PositionLevelRequirementRepository;

import org.springframework.stereotype.Service;

import com.example.navigation.service.PositionLevelRequirementService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionLevelRequirementServiceImpl implements PositionLevelRequirementService {

    private final PositionLevelRequirementRepository positionLevelRequirementRepository;
    private final PositionLevelRepository positionLevelRepository;

    public PositionLevelRequirementServiceImpl(PositionLevelRequirementRepository positionLevelRequirementRepository,
            PositionLevelRepository positionLevelRepository) {
        this.positionLevelRequirementRepository = positionLevelRequirementRepository;
        this.positionLevelRepository = positionLevelRepository;
    }

    //通过职位ID获取职位需求

    @Override
    public List<PositionLevelRequirementInfo> findAllPositionsWithCertificates() {

        List<PositionLevel> positions = positionLevelRepository.findAll();

        List<PositionLevelRequirementInfo> result = new ArrayList<>();

        for (PositionLevel position : positions) {

            List<PositionLevelRequirement> requirements = positionLevelRequirementRepository
                    .findByPositionLevel_PositionId(position.getPositionId());

            List<CertificateTypeInfo> certificates = requirements.stream()
                    .map(req -> new CertificateTypeInfo(
                            req.getCertificate().getCertificateTypeId(),
                            req.getCertificate().getCertificateTypeName()))
                    .collect(Collectors.toList());

            PositionLevelRequirementInfo response = new PositionLevelRequirementInfo(
                    position.getPositionId(),
                    position.getPositionName(),
                    certificates);
            result.add(response);
        }

        return result;
    }

}
