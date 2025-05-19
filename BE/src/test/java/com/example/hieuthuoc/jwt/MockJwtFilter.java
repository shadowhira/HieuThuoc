package com.example.hieuthuoc.jwt;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

/**
 * Mock JwtFilter cho môi trường test
 * Luôn xác thực thành công với quyền ADMIN
 */
@Component
public class MockJwtFilter extends JwtFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            // Tạo một UserDetails giả với quyền ADMIN
            UserDetails userDetails = new User(
                "admin",
                "admin123",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );

            // Tạo authentication token
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
            );

            // Đặt authentication vào SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authToken);

            // Tiếp tục chuỗi filter
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            filterChain.doFilter(request, response);
        }
    }
}
