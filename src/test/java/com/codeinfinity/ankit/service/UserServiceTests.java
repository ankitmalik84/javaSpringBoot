package com.codeinfinity.ankit.service;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeinfinity.ankit.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName() {
        // assertEquals(4, 2 + 2);
        assertNotNull(userRepository.findByUserName("Ram"));

    }
}
