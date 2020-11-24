package com.kyosk.config.commons;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.Formatter;

/**
 * Custom converter for Profile type
 */
@Converter(autoApply = true)
public class MapAttributeConverter implements AttributeConverter<Map<String, ?>, String>, Formatter<Map<String, ?>> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, ?> map) {
        try {
            return map != null ? objectMapper.writeValueAsString(map) : null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, ?> convertToEntityAttribute(String str) {
        try {
            return StringUtils.isNotEmpty(str) ? objectMapper.readValue(str, Map.class) : null;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, ?> parse(String text, Locale locale) throws ParseException {
        return convertToEntityAttribute(text);
    }

    @Override
    public String print(Map<String, ?> object, Locale locale) {
        return convertToDatabaseColumn(object);
    }
}
