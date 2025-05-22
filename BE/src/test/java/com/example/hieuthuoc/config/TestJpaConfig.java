package com.example.hieuthuoc.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Cấu hình đơn giản cho môi trường kiểm thử
 * Không cấu hình JPA vì Spring Boot sẽ tự động cấu hình
 * thông qua @DataJpaTest
 */
@TestConfiguration
@Profile("test")
public class TestJpaConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
