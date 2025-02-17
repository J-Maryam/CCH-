package com.cch.dtos.response;

import com.cch.entities.enums.StageType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record StageDTO(
        Long id,
        Integer number,
        String startLocation,
        String endLocation,
        LocalDate date,
        LocalTime startTime,
        StageType stageType
) {}