package com.example.hieuthuoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.jwt.JwtService;
import com.example.hieuthuoc.security.LoginRequest;

@ExtendWith(MockitoExtension.class)
public class DangNhapControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private DangNhapController dangNhapController;

    private LoginRequest loginRequest;
    private String jwtToken;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu test
        loginRequest = new LoginRequest();
        loginRequest.setTenDangNhap("admin");
        loginRequest.setMatKhau("admin123");

        jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImlkIjoxLCJsYXN0TmFtZSI6IkFkbWluIiwibmhvbVF1eWVucyI6W3sibmhvbVF1eWVuIjoiQURNSU4iLCJjaHVjTmFuZ3MiOlsiUXVhbiBseSBuZ3VvaSBkdW5nIiwiUXVhbiBseSBjaHVjIG5hbmciXX1dLCJpYXQiOjE2MjM0NTY3ODksImV4cCI6MTYyMzQ1NzM4OX0.8Iy8aMZRU1HYVjMRYZcjAqt9slU3-5CbfQJ4Y2xCt-0";
    }

    @Test
    @DisplayName("UT_DANGNHAP_CONTROLLER_001: Kiểm thử API đăng nhập với thông tin hợp lệ")
    void testLogin_WithValidCredentials_ShouldReturnJwtToken() {
        // Arrange
        when(jwtService.generateToken(loginRequest.getTenDangNhap())).thenReturn(jwtToken);

        // Act
        ResponseDTO<String> result = dangNhapController.login(loginRequest);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals(jwtToken, result.getData());
        
        // Verify that authentication was attempted
        verify(authenticationManager, times(1)).authenticate(
            any(UsernamePasswordAuthenticationToken.class)
        );
        
        // Verify that token was generated
        verify(jwtService, times(1)).generateToken(loginRequest.getTenDangNhap());
    }
}
