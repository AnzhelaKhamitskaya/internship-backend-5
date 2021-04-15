package com.exadel.backendservice.repository;

import com.exadel.backendservice.ApplicationTestPropertyValues;
import com.exadel.backendservice.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
class RoleEntityRepositoryTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:12.6-alpine");

    @DynamicPropertySource
    static void registerDynamicProperties(DynamicPropertyRegistry registry) {
        ApplicationTestPropertyValues.populateRegistryFromPostgresContainer(registry, postgreSQLContainer);
    }

    @Autowired
    private RoleEntityRepository repository;

    @Test
    void findByName() {
        Role role_admin = repository.findByName("ROLE_ADMIN");
        assertEquals(1, role_admin.getId());

        Role role_tech = repository.findByName("ROLE_TECH");
        assertEquals(2, role_tech.getId());

        Role role_superadmin = repository.findByName("ROLE_SUPERADMIN");
        assertEquals(3, role_superadmin.getId());
    }

    @Test
    void findAll() {
        var list1 = repository.findAll();
        assertEquals(3, list1.size());
    }
}