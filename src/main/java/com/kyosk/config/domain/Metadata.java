package com.kyosk.config.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Contains Configuration metadata properties
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Metadata {
    Monitoring monitoring;
    Limit limits;
}
