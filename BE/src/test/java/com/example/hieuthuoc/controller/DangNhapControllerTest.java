package com.example.hieuthuoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
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
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
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
    @DisplayName("UT_DANGNHAP_SERVICE_001: Kiểm thử đăng nhập thành công")
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

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_002: Kiểm thử đăng nhập với tài khoản không tồn tại")
    void testLogin_WithNonExistentUsername_ShouldThrowException() {
        // Arrange
        loginRequest.setTenDangNhap("nonexistent");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new BadCredentialsException("Tài khoản không tồn tại"));

        // Act & Assert
        Exception exception = assertThrows(BadCredentialsException.class, () -> {
            dangNhapController.login(loginRequest);
        });

        assertEquals("Tài khoản không tồn tại", exception.getMessage());
        verify(authenticationManager).authenticate(
            any(UsernamePasswordAuthenticationToken.class)
        );
        verify(jwtService, never()).generateToken(any());
    }

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_003: Kiểm thử đăng nhập với mật khẩu sai")
    void testLogin_WithIncorrectPassword_ShouldThrowException() {
        // Arrange
        loginRequest.setMatKhau("wrongpassword");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new BadCredentialsException("Mật khẩu không chính xác"));

        // Act & Assert
        Exception exception = assertThrows(BadCredentialsException.class, () -> {
            dangNhapController.login(loginRequest);
        });

        assertEquals("Mật khẩu không chính xác", exception.getMessage());
        verify(authenticationManager).authenticate(
            any(UsernamePasswordAuthenticationToken.class)
        );
        verify(jwtService, never()).generateToken(any());
    }

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_004: Kiểm thử đăng nhập với tài khoản bị khóa")
    void testLogin_WithDisabledAccount_ShouldThrowException() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new DisabledException("Tài khoản đã bị vô hiệu hóa"));

        // Act & Assert
        Exception exception = assertThrows(DisabledException.class, () -> {
            dangNhapController.login(loginRequest);
        });

        assertEquals("Tài khoản đã bị vô hiệu hóa", exception.getMessage());
        verify(authenticationManager).authenticate(
            any(UsernamePasswordAuthenticationToken.class)
        );
        verify(jwtService, never()).generateToken(any());
    }
}
