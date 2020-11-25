package com.kyosk.config.service.dto;

import com.kyosk.config.domain.Metadata;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ConfigRequestDto {
    public String name;
    public Metadata metadata;

    public ConfigRequestDto() {
    }
}
