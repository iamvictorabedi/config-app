package com.kyosk.config.service.mapper;

import java.util.List;
import java.util.Map;

import com.kyosk.config.domain.Config;
import com.kyosk.config.service.dto.ConfigResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 * This use mapstruct to convert our dto to entity class and vice versa
 * its make the code much clean.
 * With mapstruct this conventions happens at runtime hence
 * @see ConfigMapperImpl will be generated automatically
 */
@Mapper
public interface ConfigMapper {
    List<ConfigResponseDto> toConfigResponse(final List<Config> config);

    @Mapping(target = "metadata", source = "convertValue")
    @Mapping(target = "name", source = "name")
    Config toConfigEntity(String name, Map<String, ?> convertValue);
}
