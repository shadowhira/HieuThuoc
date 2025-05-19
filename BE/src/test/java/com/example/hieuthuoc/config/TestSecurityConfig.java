package com.example.hieuthuoc.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.hieuthuoc.jwt.JwtFilter;
import com.example.hieuthuoc.jwt.JwtService;
import com.example.hieuthuoc.jwt.MockJwtFilter;
import com.example.hieuthuoc.jwt.MockJwtService;

/**
 * Cấu hình bảo mật cho môi trường test
 */
@TestConfiguration
@EnableWebSecurity
public class TestSecurityConfig {

    /**
     * Cấu hình SecurityFilterChain cho môi trường test
     * Vô hiệu hóa CSRF và cho phép tất cả các request
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .addFilterBefore(mockJwtFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Mock JwtService cho môi trường test
     */
    @Bean
    @Primary
    public JwtService jwtService() {
        return new MockJwtService();
    }

    /**
     * Mock JwtFilter cho môi trường test
     */
    @Bean
    @Primary
    public JwtFilter mockJwtFilter() {
        return new MockJwtFilter();
    }

    /**
     * UserDetailsService cho môi trường test
     */
    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin123"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(admin);
    }

    /**
     * PasswordEncoder cho môi trường test
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
