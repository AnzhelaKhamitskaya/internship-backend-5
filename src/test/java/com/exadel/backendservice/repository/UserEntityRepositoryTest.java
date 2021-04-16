package com.exadel.backendservice.repository;

import com.exadel.backendservice.config.AbstractTestConfig;
import com.exadel.backendservice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

@SpringBootTest
@Testcontainers
@DirtiesContext(classMode = BEFORE_CLASS)
class UserEntityRepositoryTest extends AbstractTestConfig {

    @Autowired
    private UserEntityRepository repository;

    @Test
    void findByLogin() {
        User userFromDb = repository.findByLogin("test1-superadmin");
        assertEquals(999990, userFromDb.getId());
    }

    @Test
    void findAll() {
        var list = repository.findAll();
        assertEquals(11, list.size());
    }

    @Test
    void findAllByRoleEntity_Name() {
        var list = repository.findAllByRoleEntity_Name("ROLE_ADMIN");
        assertEquals(4, list.size());
    }

}