package com.example.hieuthuoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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
import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.service.ChucNangService;

/**
 * Kiểm thử Controller cho ChucNangController
 * Sử dụng @SpringBootTest để kiểm thử controller
 * và mock các service
 */
@SpringBootTest
@ActiveProfiles("test")
@Import(TestConfig.class)
public class ChucNangControllerTest {

    @Autowired
    private ChucNangController chucNangController;

    @MockBean
    private ChucNangService chucNangService;

    private ChucNangDTO chucNangDTO;
    private ChucNang chucNang;
    private ResponseDTO<ChucNang> responseDTO;
    private ResponseDTO<List<ChucNang>> listResponseDTO;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        chucNangDTO = new ChucNangDTO();
        chucNangDTO.setTenChucNang("Quản lý sản phẩm");
        chucNangDTO.setHanhDong("CRUD_PRODUCT");
        chucNangDTO.setMoTa("Chức năng quản lý sản phẩm");

        chucNang = new ChucNang();
        chucNang.setId(1);
        chucNang.setTenChucNang("Quản lý sản phẩm");
        chucNang.setHanhDong("CRUD_PRODUCT");
        chucNang.setMoTa("Chức năng quản lý sản phẩm");

        responseDTO = ResponseDTO.<ChucNang>builder()
                .status(201)
                .msg("Tạo chức năng thành công")
                .data(chucNang)
                .build();

        List<ChucNang> chucNangList = new ArrayList<>();
        chucNangList.add(chucNang);

        listResponseDTO = ResponseDTO.<List<ChucNang>>builder()
                .status(200)
                .msg("Thành công")
                .data(chucNangList)
                .build();
    }

    @Test
    @DisplayName("UT_CHUCNANG_CONTROLLER_001: Kiểm thử API tạo chức năng mới với dữ liệu hợp lệ")
    void testCreateChucNang_WithValidData_ShouldReturn201() {
        // Arrange
        when(chucNangService.create(any())).thenReturn(responseDTO);

        // Act
        ResponseDTO<ChucNang> result = chucNangController.create(chucNangDTO);

        // Assert
        assertNotNull(result);
        assertEquals(201, result.getStatus());
        assertEquals("Tạo chức năng thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý sản phẩm", result.getData().getTenChucNang());
        assertEquals("CRUD_PRODUCT", result.getData().getHanhDong());
    }

    @Test
    @DisplayName("UT_CHUCNANG_CONTROLLER_002: Kiểm thử API cập nhật chức năng với dữ liệu hợp lệ")
    void testUpdateChucNang_WithValidData_ShouldReturn200() {
        // Arrange
        chucNangDTO.setId(1);
        chucNangDTO.setTenChucNang("Quản lý sản phẩm Updated");

        ResponseDTO<ChucNang> updateResponseDTO = ResponseDTO.<ChucNang>builder()
                .status(200)
                .msg("Cập nhật chức năng thành công")
                .data(chucNang)
                .build();

        when(chucNangService.update(any())).thenReturn(updateResponseDTO);

        // Act
        ResponseDTO<ChucNang> result = chucNangController.update(chucNangDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Cập nhật chức năng thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
    }

    @Test
    @DisplayName("UT_CHUCNANG_CONTROLLER_003: Kiểm thử API lấy danh sách tất cả chức năng")
    void testGetAllChucNang_ShouldReturn200() {
        // Arrange
        when(chucNangService.getAllChucNangs()).thenReturn(listResponseDTO);

        // Act
        ResponseDTO<List<ChucNang>> result = chucNangController.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertEquals(1, result.getData().size());
        assertEquals("Quản lý sản phẩm", result.getData().get(0).getTenChucNang());
    }
}
