package com.example.navigation.dto.response;

import java.util.List;

public record PositionLevelInfo(
    Integer positionLevelId,
    String positionLevelName,
    List<CertificateTypeInfo> certificateTypeInfos
)
{
    
}
