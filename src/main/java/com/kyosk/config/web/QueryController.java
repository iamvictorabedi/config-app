package com.kyosk.config.web;

import java.util.List;

import com.kyosk.config.service.ConfigService;
import com.kyosk.config.service.dto.ConfigRequestDto;
import com.kyosk.config.service.dto.ConfigResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("search")
public class QueryController {

    private final ConfigService service;

    @GetMapping
    @ApiOperation("Search based on properties")
    public List<ConfigResponseDto> queryProperties(final ConfigRequestDto configRequestDto) {
        log.debug("Request to query config: {} has being received ", configRequestDto.toString());
        return service.queryProperties(configRequestDto);
    }

}
