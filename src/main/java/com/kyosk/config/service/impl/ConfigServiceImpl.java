package com.kyosk.config.service.impl;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyosk.config.domain.Config;
import com.kyosk.config.repository.ConfigRepository;
import com.kyosk.config.service.ConfigService;
import com.kyosk.config.service.dto.ConfigRequestDto;
import com.kyosk.config.service.dto.ConfigResponseDto;
import com.kyosk.config.service.mapper.ConfigMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Collections.singletonList;

/**
 * @implNote This service class contains all business logic (crud) operations
 * to various configuration properties
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ConfigServiceImpl implements ConfigService {

    private final ConfigRepository repository;
    private final ConfigMapper mapper;
    private final ObjectMapper objectMapper;

    @Override
    public List<ConfigResponseDto> getConfigurations() {
        return mapper.toConfigResponse(repository.findAll());
    }

    @Override
    public List<ConfigResponseDto> createConfig(final ConfigRequestDto configRequestDto) {
        final Config newConfig = mapper.toConfigEntity(configRequestDto.getName(),
                objectMapper.convertValue(configRequestDto.metadata, Map.class));
        repository.save(newConfig);
        return mapper.toConfigResponse(singletonList(newConfig)) ;
    }

    @Override
    public List<ConfigResponseDto> getConfigByName(final String name) {
        return mapper.toConfigResponse(singletonList(repository.findByName(name)));
    }

    @Override
    public List<ConfigResponseDto> queryProperties(ConfigRequestDto configRequestDto) {
        return null;
    }

    @Override
    public List<ConfigResponseDto> updateConfig(final String name, final ConfigRequestDto configRequestDto) {
        final Config existingConfig = repository.findByName(name);
        existingConfig.update(mapper.toConfigEntity(configRequestDto.getName(),
                objectMapper.convertValue(configRequestDto.metadata, Map.class)));
        repository.saveAndFlush(existingConfig);
        return mapper.toConfigResponse(singletonList(existingConfig));
    }

    @Override
    public void removeConfig(String name) {
        repository.deleteByName(name);
    }
}
