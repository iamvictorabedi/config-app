package com.kyosk.config.web;

import java.util.List;

import com.kyosk.config.service.ConfigService;
import com.kyosk.config.service.dto.ConfigRequestDto;
import com.kyosk.config.service.dto.ConfigResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "configs", produces = APPLICATION_JSON_VALUE)
public class ConfigurationController {

    private final ConfigService service;

    @GetMapping(path = "{name}")
    @ApiOperation("Get existing Configuration by name")
    public List<ConfigResponseDto> getConfig(@PathVariable final String name) {
        log.debug("Request initiated to get a list of existing configurations");
        return service.getConfigByName(name);
    }

    @GetMapping
    @ApiOperation("Get a List of existing Configurations")
    public List<ConfigResponseDto> getConfigurations() {
        log.debug("Request initiated to get a list of existing configurations");
        return service.getConfigurations();
    }

    @PostMapping
    @ApiOperation("Create Configuration")
    public List<ConfigResponseDto> createConfig(@RequestBody final ConfigRequestDto configRequestDto) {
        log.debug("Request to process config: {} ", configRequestDto.toString());
        return service.createConfig(configRequestDto);
    }

    @PutMapping(path = "{name}")
    @ApiOperation("Update existing Configurations")
    public List<ConfigResponseDto> updateConfiguration(@PathVariable final String name,
                                                       @RequestBody final ConfigRequestDto configRequestDto) {
        log.debug("Request to update config: {} has being received", name);
        return service.updateConfig(name, configRequestDto);
    }

    @DeleteMapping(path = "{name}")
    @ApiOperation("Delete existing Configuration")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeConfiguration(@PathVariable final String name) {
        log.debug("Request to delete config: {} has being received", name);
        service.removeConfig(name);
    }
}
