package com.kyosk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ActiveProfiles("unittest")
@EnableTransactionManagement
public class TestDbConfig {
}
