package com.kyosk.config.service.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConfigResponseDto {
    private final String name;

    private final Map<String, ?> metadata;
}
