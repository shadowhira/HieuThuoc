package com.example.hieuthuoc.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@TestConfiguration
@EnableWebSecurity
@org.springframework.test.context.ActiveProfiles("test")
public class TestSecurityConfig {

    @Bean
    @Primary
    public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
        // Cấu hình bảo mật đơn giản cho môi trường kiểm thử
        http.authorizeHttpRequests(config -> config.anyRequest().permitAll())
            .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
