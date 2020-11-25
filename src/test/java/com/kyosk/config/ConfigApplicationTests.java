package com.kyosk.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestDbConfig.class)
class ConfigApplicationTests {

    @Test
    void contextLoads() {
    }

}
