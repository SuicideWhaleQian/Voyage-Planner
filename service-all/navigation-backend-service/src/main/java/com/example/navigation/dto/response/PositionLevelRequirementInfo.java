package com.example.navigation.dto.response;

import java.util.List;

public record PositionLevelRequirementInfo (
        Integer positionId,
        String positionName,
        List<CertificateTypeInfo> certificates
) {


}
