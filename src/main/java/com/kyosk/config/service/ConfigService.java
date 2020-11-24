package com.kyosk.config.service;

import java.util.List;

import com.kyosk.config.service.dto.ConfigRequestDto;
import com.kyosk.config.service.dto.ConfigResponseDto;

public interface ConfigService {
    List<ConfigResponseDto> getConfigurations();

    List<ConfigResponseDto> createConfig(final ConfigRequestDto configRequestDto);
    

    List<ConfigResponseDto> updateConfig(final String name, final ConfigRequestDto configRequestDto);

    List<ConfigResponseDto> removeConfig(String name);

    List<ConfigResponseDto> getConfigByName(final String name);
}
