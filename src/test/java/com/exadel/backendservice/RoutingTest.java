package com.exadel.backendservice;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class RoutingTest {

    @DynamicPropertySource
    static void registerDynamicProperties(DynamicPropertyRegistry registry, PostgreSQLContainer<?> postgreSQLContainer) {
        ApplicationTestPropertyValues.populateRegistryFromContainers(registry, postgreSQLContainer);
    }
}

