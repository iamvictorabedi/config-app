package com.kyosk.config.domain;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kyosk.config.commons.MapAttributeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class that contains Configurations properties.
 * This class cant be accessed directly by the service layer or controller layer
 * hence we use dtos to translate request to and fro to the entity class
 * @see com.kyosk.config.service.dto.ConfigRequestDto and
 * @see com.kyosk.config.service.dto.ConfigResponseDto
 */
@Entity
@Getter
@ToString
@Setter
@NoArgsConstructor
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "metadata", columnDefinition = "TEXT")
    @Convert(converter = MapAttributeConverter.class)
    private Map<String, ?> metadata = new HashMap<>();

    public void update(final Config configUpdate) {
        this.name = configUpdate.name;
        this.metadata = configUpdate.metadata;
    }
}
