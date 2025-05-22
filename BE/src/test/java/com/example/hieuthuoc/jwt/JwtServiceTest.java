package com.example.hieuthuoc.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
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

    @Mock
    private UserDetails userDetails;

    @InjectMocks
    private JwtService jwtService;

    private NguoiDungDTO nguoiDungDTO;
    private String tenDangNhap;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu test
        tenDangNhap = "admin";

        nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setId(1);
        nguoiDungDTO.setHoTen("Admin");
        nguoiDungDTO.setTenDangNhap(tenDangNhap);
        nguoiDungDTO.setEmail("admin@example.com");

        // Tạo nhóm quyền và chức năng
        List<NhomQuyenDTO> nhomQuyens = new ArrayList<>();
        NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setId(1);
        nhomQuyenDTO.setTenNhomQuyen("ADMIN");

        List<ChucNangDTO> chucNangs = new ArrayList<>();
        ChucNangDTO chucNangDTO1 = new ChucNangDTO();
        chucNangDTO1.setId(1);
        chucNangDTO1.setTenChucNang("Quan ly nguoi dung");

        ChucNangDTO chucNangDTO2 = new ChucNangDTO();
        chucNangDTO2.setId(2);
        chucNangDTO2.setTenChucNang("Quan ly chuc nang");

        chucNangs.add(chucNangDTO1);
        chucNangs.add(chucNangDTO2);

        nhomQuyenDTO.setChucNangs(chucNangs);
        nhomQuyens.add(nhomQuyenDTO);

        nguoiDungDTO.setNhomQuyens(nhomQuyens);

        // Mock service
        lenient().when(nguoiDungService.getByTenDangNhap(anyString())).thenReturn(nguoiDungDTO);
        lenient().when(userDetails.getUsername()).thenReturn(tenDangNhap);
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_001: Kiểm thử phương thức generateToken")
    void testGenerateToken_ShouldReturnValidToken() {
        // Act
        String token = jwtService.generateToken(tenDangNhap);

        // Assert
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    @DisplayName("UT_JWT_SERVICE_002: Kiểm thử phương thức validateToken với token hợp lệ")
    void testValidateToken_WithValidToken_ShouldReturnTrue() {
        // Arrange
        String token = jwtService.generateToken(tenDangNhap);
        when(userDetails.getUsername()).thenReturn(tenDangNhap);

        // Act
        boolean isValid = jwtService.validateToken(token, userDetails);

        // Assert
        assertTrue(isValid);
    }
}
