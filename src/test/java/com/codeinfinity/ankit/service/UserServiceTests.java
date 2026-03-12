package com.codeinfinity.ankit.service;

import com.codeinfinity.ankit.entity.User;
import com.codeinfinity.ankit.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTests {

    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // no MockitoAnnotations.openMocks(this); Spring handles @MockBean
    }

    @Test
    void findByUserName_returnsUser() {
        User user = new User();
        user.setUserName("ram");
        user.setPassword("inrinrick");
        user.setRoles(new ArrayList<>());

        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(user);

        User result = userService.findByUserName("ram");

        assertNotNull(result);
    }
}