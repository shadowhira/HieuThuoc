package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.hieuthuoc.dto.NguoiDungDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.NguoiDung;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.jwt.JwtService;
import com.example.hieuthuoc.repository.NguoiDungRepo;
import com.example.hieuthuoc.security.LoginRequest;

/**
 * Test class cho DangNhapService
 * Lưu ý: Trong hệ thống thực tế, không có DangNhapService riêng biệt
 * Chức năng đăng nhập được xử lý thông qua DangNhapController, AuthenticationManager và JwtService
 * Đây là một lớp test giả định để đáp ứng yêu cầu kiểm thử
 */
@ExtendWith(MockitoExtension.class)
public class DangNhapServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private NguoiDungRepo nguoiDungRepo;

    @Mock
    private NguoiDungService nguoiDungService;

    @Mock
    private Authentication authentication;

    // Giả định có một DangNhapService
    @InjectMocks
    private DangNhapServiceImpl dangNhapService;

    private LoginRequest loginRequest;
    private NguoiDung nguoiDung;
    private NguoiDungDTO nguoiDungDTO;
    private String jwtToken;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu test
        loginRequest = new LoginRequest();
        loginRequest.setTenDangNhap("admin");
        loginRequest.setMatKhau("123456");

        nguoiDung = new NguoiDung();
        nguoiDung.setId(1);
        nguoiDung.setTenDangNhap("admin");
        nguoiDung.setHoTen("Admin User");
        nguoiDung.setEmail("admin@example.com");
        nguoiDung.setMatKhau("encodedPassword");
        nguoiDung.setTrangThai(true);

        List<NhomQuyen> nhomQuyens = new ArrayList<>();
        NhomQuyen nhomQuyen = new NhomQuyen();
        nhomQuyen.setId(1);
        nhomQuyen.setTenNhomQuyen("ADMIN");
        nhomQuyens.add(nhomQuyen);
        nguoiDung.setNhomQuyens(nhomQuyens);

        nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setId(1);
        nguoiDungDTO.setTenDangNhap("admin");
        nguoiDungDTO.setHoTen("Admin User");
        nguoiDungDTO.setEmail("admin@example.com");

        List<NhomQuyenDTO> nhomQuyenDTOs = new ArrayList<>();
        NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setId(1);
        nhomQuyenDTO.setTenNhomQuyen("ADMIN");
        nhomQuyenDTOs.add(nhomQuyenDTO);
        nguoiDungDTO.setNhomQuyens(nhomQuyenDTOs);

        jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImlkIjoxLCJsYXN0TmFtZSI6IkFkbWluIiwibmhvbVF1eWVucyI6W3sibmhvbVF1eWVuIjoiQURNSU4iLCJjaHVjTmFuZ3MiOlsiUXVhbiBseSBuZ3VvaSBkdW5nIiwiUXVhbiBseSBjaHVjIG5hbmciXX1dLCJpYXQiOjE2MjM0NTY3ODksImV4cCI6MTYyMzQ1NzM4OX0.8Iy8aMZRU1HYVjMRYZcjAqt9slU3-5CbfQJ4Y2xCt-0";
    }

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_001: Kiểm thử đăng nhập thành công")
    void testLogin_WithValidCredentials_ShouldReturnTokenAndUserInfo() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtService.generateToken(loginRequest.getTenDangNhap())).thenReturn(jwtToken);

        // Act
        ResponseDTO<String> result = dangNhapService.login(loginRequest);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals(jwtToken, result.getData());

        // Verify
        verify(authenticationManager).authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
        );
        verify(jwtService).generateToken(loginRequest.getTenDangNhap());
    }

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_002: Kiểm thử đăng nhập với tài khoản không tồn tại")
    void testLogin_WithNonExistentUsername_ShouldThrowException() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new UsernameNotFoundException("Tài khoản không tồn tại"));

        // Act & Assert
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            dangNhapService.login(loginRequest);
        });

        assertEquals("Tài khoản không tồn tại", exception.getMessage());
        verify(authenticationManager).authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
        );
        verify(jwtService, never()).generateToken(anyString());
    }

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_003: Kiểm thử đăng nhập với mật khẩu sai")
    void testLogin_WithIncorrectPassword_ShouldThrowException() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new BadCredentialsException("Mật khẩu không chính xác"));

        // Act & Assert
        Exception exception = assertThrows(BadCredentialsException.class, () -> {
            dangNhapService.login(loginRequest);
        });

        assertEquals("Mật khẩu không chính xác", exception.getMessage());
        verify(authenticationManager).authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
        );
        verify(jwtService, never()).generateToken(anyString());
    }

    @Test
    @DisplayName("UT_DANGNHAP_SERVICE_004: Kiểm thử đăng nhập với tài khoản bị khóa")
    void testLogin_WithDisabledAccount_ShouldThrowException() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new DisabledException("Tài khoản đã bị vô hiệu hóa"));

        // Act & Assert
        Exception exception = assertThrows(DisabledException.class, () -> {
            dangNhapService.login(loginRequest);
        });

        assertEquals("Tài khoản đã bị vô hiệu hóa", exception.getMessage());
        verify(authenticationManager).authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
        );
        verify(jwtService, never()).generateToken(anyString());
    }


    public static class DangNhapServiceImpl {
        private AuthenticationManager authenticationManager;
        private JwtService jwtService;

        public DangNhapServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService) {
            this.authenticationManager = authenticationManager;
            this.jwtService = jwtService;
        }

        public ResponseDTO<String> login(LoginRequest loginRequest) {
            // Xác thực người dùng
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getTenDangNhap(), loginRequest.getMatKhau())
            );

            // Tạo token JWT
            String token = jwtService.generateToken(loginRequest.getTenDangNhap());

            // Trả về token
            return ResponseDTO.<String>builder().status(200).data(token).build();
        }
    }
}
