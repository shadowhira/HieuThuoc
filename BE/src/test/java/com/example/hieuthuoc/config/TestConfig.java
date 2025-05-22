package com.example.hieuthuoc.config;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.hieuthuoc.jwt.JwtFilter;
import com.example.hieuthuoc.jwt.JwtService;
import com.example.hieuthuoc.service.EmailService;
import com.example.hieuthuoc.service.UploadImageService;

/**
 * Cấu hình cho môi trường kiểm thử
 * Thay vì tạo bean passwordEncoder mới, chúng ta sẽ sử dụng @MockBean
 * để tránh xung đột với bean đã tồn tại trong SecurityConfiguration
 */
@TestConfiguration
public class TestConfig {

    // Mock các service không cần thiết cho kiểm thử
    @MockBean
    private EmailService emailService;

    @MockBean
    private UploadImageService uploadImageService;

    /**
     * Tạo một UserDetailsService giả để sử dụng trong kiểm thử
     * @return UserDetailsService giả
     */
    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        return Mockito.mock(UserDetailsService.class);
    }

    /**
     * Tạo một JwtService giả để sử dụng trong kiểm thử
     * @return JwtService giả
     */
    @Bean
    @Primary
    public JwtService jwtService() {
        return Mockito.mock(JwtService.class);
    }

    /**
     * Tạo một JwtFilter giả để sử dụng trong kiểm thử
     * @return JwtFilter giả
     */
    @Bean
    @Primary
    public JwtFilter jwtFilter() {
        return Mockito.mock(JwtFilter.class);
    }
}
