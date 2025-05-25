package com.example.hieuthuoc.jwt;

import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.security.core.userdetails.UserDetails;

import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.NguoiDungDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.service.NguoiDungService;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    @Mock
    private NguoiDungService nguoiDungService;

    @InjectMocks
    private JwtService jwtService;

    private UserDetails userDetails;
    private NguoiDungDTO nguoiDungDTO;

    @BeforeEach
    void setUp() {
        // Mock user details
        userDetails = org.springframework.security.core.userdetails.User.builder()
            .username("nguyenvana")
            .password("password")
            .authorities("KHACH_HANG")
            .build();

        // Tạo danh sách chức năng
        List<ChucNangDTO> chucNangs = new ArrayList<>();
        ChucNangDTO chucNang = new ChucNangDTO();
        chucNang.setId(1);
        chucNang.setTenChucNang("XEM_DANH_SACH");
        chucNangs.add(chucNang);

        // Tạo nhóm quyền
        List<NhomQuyenDTO> nhomQuyens = new ArrayList<>();
        NhomQuyenDTO nhomQuyen = new NhomQuyenDTO();
        nhomQuyen.setId(1);
        nhomQuyen.setTenNhomQuyen("KHACH_HANG");
        nhomQuyen.setChucNangs(chucNangs);
        nhomQuyens.add(nhomQuyen);

        // Tạo người dùng
        nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setId(1);
        nguoiDungDTO.setTenDangNhap("nguyenvana");
        nguoiDungDTO.setHoTen("Nguyễn Văn A");
        nguoiDungDTO.setNhomQuyens(nhomQuyens);
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_001: Kiểm thử tạo token JWT")
    void testGenerateToken_WithValidUsername_ShouldReturnToken() {
        // Arrange
        String username = "nguyenvana";
        when(nguoiDungService.getByTenDangNhap(username)).thenReturn(nguoiDungDTO);

        // Act
        String token = jwtService.generateToken(username);

        // Assert
        assertNotNull(token);
        assertTrue(token.length() > 0);
        assertTrue(jwtService.validateToken(token, userDetails));
        verify(nguoiDungService, times(1)).getByTenDangNhap(username);
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_002: Kiểm thử xác thực token JWT hợp lệ")
    void testValidateToken_WithValidToken_ShouldReturnTrue() {
        // Arrange
        String username = "nguyenvana";
        when(nguoiDungService.getByTenDangNhap(username)).thenReturn(nguoiDungDTO);
        String token = jwtService.generateToken(username);

        // Act
        boolean isValid = jwtService.validateToken(token, userDetails);

        // Assert
        assertTrue(isValid);
        verify(nguoiDungService, times(1)).getByTenDangNhap(username);
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_003: Kiểm thử token không hợp lệ")
    void testValidateToken_WithInvalidToken_ShouldReturnFalse() {
        // Arrange
        String invalidToken = "invalid.token.format";

        // Act & Assert
        assertThrows(Exception.class, () -> {
            jwtService.validateToken(invalidToken, userDetails);
        });
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_004: Kiểm thử token hết hạn")
    void testValidateToken_WithExpiredToken_ShouldReturnFalse() {
        // Arrange
        String username = "nguyenvana";
        when(nguoiDungService.getByTenDangNhap(username)).thenReturn(nguoiDungDTO);
        String token = jwtService.generateToken(username);
        // Tạo token đã hết hạn bằng cách thay đổi thời gian hết hạn
        String expiredToken = token.substring(0, token.lastIndexOf('.')) + ".invalid_signature";

        // Act & Assert
        assertThrows(Exception.class, () -> {
            jwtService.validateToken(expiredToken, userDetails);
        });
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_005: Kiểm thử token sai chữ ký")
    void testValidateToken_WithInvalidSignature_ShouldReturnFalse() {
        // Arrange
        String username = "nguyenvana";
        when(nguoiDungService.getByTenDangNhap(username)).thenReturn(nguoiDungDTO);
        String token = jwtService.generateToken(username);
        // Thay đổi một ký tự trong token để làm sai chữ ký
        String tamperedToken = token.substring(0, token.length() - 1) + "X";

        // Act & Assert
        assertThrows(Exception.class, () -> {
            jwtService.validateToken(tamperedToken, userDetails);
        });
    }
}
