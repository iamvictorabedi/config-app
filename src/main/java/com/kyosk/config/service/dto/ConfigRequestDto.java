package com.kyosk.config.service.dto;

import com.kyosk.config.domain.Metadata;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConfigRequestDto {
    public String name;
    public Metadata metadata;
}
