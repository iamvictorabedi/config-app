package com.kyosk.config.service.impl;

import java.util.List;

import com.kyosk.config.service.ConfigService;
import com.kyosk.config.service.dto.ConfigRequestDto;
import com.kyosk.config.service.dto.ConfigResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ConfigServiceImpl implements ConfigService {
    @Override
    public List<ConfigResponseDto> getConfigurations() {
        //add business logic
        return null;
    }

    @Override
    public List<ConfigResponseDto> createConfig(final ConfigRequestDto configRequestDto) {
        //add business logic
        return null;
    }

    @Override
    public List<ConfigResponseDto> getConfigByName(final String name) {
        //add business logic
        return null;
    }

    @Override
    public List<ConfigResponseDto> updateConfig(final String name, final ConfigRequestDto configRequestDto) {
        //add business logic
        return null;
    }

    @Override
    public List<ConfigResponseDto> removeConfig(final String name) {
        //add business logic
        return null;
    }
}
