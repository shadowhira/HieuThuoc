package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.repository.ChucNangRepo;

@ExtendWith(MockitoExtension.class)
public class ChucNangServiceTest {

    @Mock
    private ChucNangRepo chucNangRepo;

    @InjectMocks
    private ChucNangServiceImpl chucNangService;

    private ChucNangDTO chucNangDTO;
    private ChucNang chucNang;

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
    }

    @Test
    @DisplayName("UT_CHUCNANG_SERVICE_001: Kiểm thử phương thức tạo chức năng mới với dữ liệu hợp lệ")
    void testCreateChucNang_WithValidData_ShouldReturnCreatedChucNang() {
        // Arrange
        when(chucNangRepo.existsByTenChucNang(anyString())).thenReturn(false);
        when(chucNangRepo.save(any(ChucNang.class))).thenReturn(chucNang);

        // Act
        ResponseDTO<ChucNang> result = chucNangService.create(chucNangDTO);

        // Assert
        assertNotNull(result);
        assertEquals(201, result.getStatus());
        assertEquals("Tạo chức năng thành công", result.getMsg());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý sản phẩm", result.getData().getTenChucNang());
        assertEquals("CRUD_PRODUCT", result.getData().getHanhDong());

        verify(chucNangRepo, times(1)).save(any(ChucNang.class));
    }

    @Test
    @DisplayName("UT_CHUCNANG_SERVICE_002: Kiểm thử phương thức tạo chức năng với tên đã tồn tại")
    void testCreateChucNang_WithExistingName_ShouldReturnError() {
        // Arrange
        when(chucNangRepo.existsByTenChucNang("Quản lý sản phẩm")).thenReturn(true);

        // Act
        ResponseDTO<ChucNang> result = chucNangService.create(chucNangDTO);

        // Assert
        assertNotNull(result);
        assertEquals(409, result.getStatus());
        assertEquals("Chức năng đã tồn tại", result.getMsg());
        assertNull(result.getData());

        verify(chucNangRepo, never()).save(any(ChucNang.class));
    }

    @Test
    @DisplayName("UT_CHUCNANG_SERVICE_003: Kiểm thử phương thức cập nhật chức năng")
    void testUpdateChucNang_WithValidData_ShouldReturnUpdatedChucNang() {
        // Arrange
        chucNangDTO.setId(1);
        chucNangDTO.setTenChucNang("Quản lý sản phẩm Updated");
        chucNangDTO.setMoTa("Mô tả đã cập nhật");

        ChucNang updatedChucNang = new ChucNang();
        updatedChucNang.setId(1);
        updatedChucNang.setTenChucNang("Quản lý sản phẩm Updated");
        updatedChucNang.setHanhDong("CRUD_PRODUCT");
        updatedChucNang.setMoTa("Mô tả đã cập nhật");

        when(chucNangRepo.findById(1)).thenReturn(Optional.of(chucNang));
        when(chucNangRepo.save(any(ChucNang.class))).thenReturn(updatedChucNang);

        // Act
        ResponseDTO<ChucNang> result = chucNangService.update(chucNangDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Cập nhật chức năng thành công", result.getMsg());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý sản phẩm Updated", result.getData().getTenChucNang());
        assertEquals("Mô tả đã cập nhật", result.getData().getMoTa());

        verify(chucNangRepo, times(1)).findById(1);
        verify(chucNangRepo, times(1)).save(any(ChucNang.class));
    }
}
