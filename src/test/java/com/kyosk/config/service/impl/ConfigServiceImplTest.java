package com.kyosk.config.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyosk.config.domain.Config;
import com.kyosk.config.repository.ConfigRepository;
import com.kyosk.config.service.dto.ConfigRequestDto;
import com.kyosk.config.service.mapper.ConfigMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ConfigServiceImplTest {
    @Mock
    private ConfigRepository repository;
    @Mock
    private ConfigMapper mapper;
    @Mock
    private ObjectMapper objectMapper;

    private ConfigServiceImpl service;

    @BeforeEach
    void setUp() {
        this.service = new ConfigServiceImpl(repository, mapper, objectMapper);
    }

    @Test
    void canGetConfig() {
        service.getConfigurations();
        verify(mapper).toConfigResponse(repository.findAll());
    }


    @Test
    void canGetConfigByName() {
        final String name = "data-ae";
        service.getConfigByName(name);
        verify(mapper).toConfigResponse((singletonList(repository.findByName(name))));
    }


    private Config getExistingConfig() {
        final Config config = new Config();
        config.setName("data");
        return config;
    }


    private ConfigRequestDto getRequest() {
        final ConfigRequestDto configRequestDto = new ConfigRequestDto();
        configRequestDto.setName("data-centre-1a");
        return configRequestDto;
    }


}
