package com.example.hieuthuoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.example.hieuthuoc.config.TestConfig;

import com.example.hieuthuoc.dto.NguoiDungDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.NguoiDung;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.service.NguoiDungService;

/**
 * Kiểm thử Controller cho NguoiDungController
 * Sử dụng @SpringBootTest để kiểm thử controller
 * và mock các service
 */
@SpringBootTest
@ActiveProfiles("test")
@Import(TestConfig.class)
public class NguoiDungControllerTest {

    @Autowired
    private NguoiDungController nguoiDungController;

    @MockBean
    private NguoiDungService nguoiDungService;

    private NguoiDungDTO nguoiDungDTO;
    private NguoiDung nguoiDung;
    private ResponseDTO<NguoiDung> responseDTO;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setHoTen("Nguyễn Văn A");
        nguoiDungDTO.setTenDangNhap("nguyenvana");
        nguoiDungDTO.setEmail("nguyenvana@example.com");
        nguoiDungDTO.setSoDienThoai("0987654321");
        nguoiDungDTO.setMatKhau("Password123@");

        nguoiDung = new NguoiDung();
        nguoiDung.setId(1);
        nguoiDung.setHoTen("Nguyễn Văn A");
        nguoiDung.setTenDangNhap("nguyenvana");
        nguoiDung.setEmail("nguyenvana@example.com");
        nguoiDung.setSoDienThoai("0987654321");
        nguoiDung.setTrangThai(true);

        List<NhomQuyen> nhomQuyens = new ArrayList<>();
        NhomQuyen nhomQuyen = new NhomQuyen();
        nhomQuyen.setId(1);
        nhomQuyen.setTenNhomQuyen("KHACH_HANG");
        nhomQuyens.add(nhomQuyen);
        nguoiDung.setNhomQuyens(nhomQuyens);

        responseDTO = ResponseDTO.<NguoiDung>builder()
                .status(200)
                .msg("Thành công")
                .data(nguoiDung)
                .build();
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_CONTROLLER_001: Kiểm thử API tạo người dùng mới với dữ liệu hợp lệ")
    void testCreateNguoiDung_WithValidData_ShouldReturn200() throws Exception {
        // Arrange
        when(nguoiDungService.create(any())).thenReturn(responseDTO);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungController.create(nguoiDungDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
        assertEquals("Nguyễn Văn A", result.getData().getHoTen());
        assertEquals("nguyenvana", result.getData().getTenDangNhap());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_CONTROLLER_002: Kiểm thử API cập nhật người dùng với dữ liệu hợp lệ")
    void testUpdateNguoiDung_WithValidData_ShouldReturn200() throws Exception {
        // Arrange
        nguoiDungDTO.setId(1);
        nguoiDungDTO.setHoTen("Nguyễn Văn A Updated");

        when(nguoiDungService.update(any())).thenReturn(responseDTO);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungController.update(nguoiDungDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_CONTROLLER_003: Kiểm thử API lấy thông tin người dùng theo ID")
    void testGetNguoiDungById_ShouldReturn200() throws Exception {
        // Arrange
        when(nguoiDungService.getById(anyInt())).thenReturn(responseDTO);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungController.getById(1);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
        assertEquals("Nguyễn Văn A", result.getData().getHoTen());
        assertEquals("nguyenvana", result.getData().getTenDangNhap());
    }
}
