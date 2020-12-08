package com.kyosk.config.service.mapper;

import com.kyosk.config.domain.Config;
import com.kyosk.config.service.dto.ConfigResponseDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-25T21:55:26+0300",
    comments = "version: 1.4.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.6.1.jar, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class ConfigMapperImpl implements ConfigMapper {

    @Override
    public List<ConfigResponseDto> toConfigResponse(List<Config> config) {
        if ( config == null ) {
            return null;
        }

        List<ConfigResponseDto> list = new ArrayList<ConfigResponseDto>( config.size() );
        for ( Config config1 : config ) {
            list.add( configToConfigResponseDto( config1 ) );
        }

        return list;
    }

    @Override
    public Config toConfigEntity(String name, Map<String, ?> convertValue) {
        if ( name == null && convertValue == null ) {
            return null;
        }

        Config config = new Config();

        if ( name != null ) {
            config.setName( name );
        }
        if ( convertValue != null ) {
            Map<String, ?> map = convertValue;
            if ( map != null ) {
                config.setMetadata( new HashMap<String, Object>( map ) );
            }
        }

        return config;
    }

    protected ConfigResponseDto configToConfigResponseDto(Config config) {
        if ( config == null ) {
            return null;
        }

        Map<String, ?> metadata = null;
        String name = null;

        Map<String, ?> map = config.getMetadata();
        if ( map != null ) {
            metadata = new HashMap<String, Object>( map );
        }
        name = config.getName();

        ConfigResponseDto configResponseDto = new ConfigResponseDto( name, metadata );

        return configResponseDto;
    }
}
