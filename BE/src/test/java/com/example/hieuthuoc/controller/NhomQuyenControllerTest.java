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
import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchDTO;
import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.service.NhomQuyenService;

/**
 * Kiểm thử Controller cho NhomQuyenController
 * Sử dụng @SpringBootTest để kiểm thử controller
 * và mock các service
 */
@SpringBootTest
@ActiveProfiles("test")
@Import(TestConfig.class)
public class NhomQuyenControllerTest {

    @Autowired
    private NhomQuyenController nhomQuyenController;

    @MockBean
    private NhomQuyenService nhomQuyenService;

    private NhomQuyenDTO nhomQuyenDTO;
    private NhomQuyen nhomQuyen;
    private ResponseDTO<NhomQuyen> responseDTO;
    private ResponseDTO<PageDTO<List<NhomQuyen>>> pageResponseDTO;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setTenNhomQuyen("Quản lý kho");
        nhomQuyenDTO.setMoTa("Nhóm quyền dành cho quản lý kho");

        List<ChucNangDTO> chucNangDTOs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ChucNangDTO chucNangDTO = new ChucNangDTO();
            chucNangDTO.setId(i);
            chucNangDTO.setTenChucNang("Chức năng " + i);
            chucNangDTO.setMoTa("Mô tả chức năng " + i);
            chucNangDTOs.add(chucNangDTO);
        }
        nhomQuyenDTO.setChucNangs(chucNangDTOs);

        nhomQuyen = new NhomQuyen();
        nhomQuyen.setId(1);
        nhomQuyen.setTenNhomQuyen("Quản lý kho");
        nhomQuyen.setMoTa("Nhóm quyền dành cho quản lý kho");

        List<ChucNang> chucNangs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ChucNang chucNang = new ChucNang();
            chucNang.setId(i);
            chucNang.setTenChucNang("Chức năng " + i);
            chucNang.setMoTa("Mô tả chức năng " + i);
            chucNangs.add(chucNang);
        }
        nhomQuyen.setChucNangs(chucNangs);

        responseDTO = ResponseDTO.<NhomQuyen>builder()
                .status(201)
                .msg("Tạo nhóm quyền thành công")
                .data(nhomQuyen)
                .build();

        // Tạo dữ liệu cho pageResponseDTO
        List<NhomQuyen> nhomQuyenList = new ArrayList<>();
        nhomQuyenList.add(nhomQuyen);

        PageDTO<List<NhomQuyen>> pageDTO = new PageDTO<>();
        pageDTO.setTotalElements(1L);
        pageDTO.setTotalPages(1);
        pageDTO.setData(nhomQuyenList);

        pageResponseDTO = ResponseDTO.<PageDTO<List<NhomQuyen>>>builder()
                .status(200)
                .msg("Thành công")
                .data(pageDTO)
                .build();
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_CONTROLLER_001: Kiểm thử API tạo nhóm quyền mới với dữ liệu hợp lệ")
    void testCreateNhomQuyen_WithValidData_ShouldReturn201() {
        // Arrange
        when(nhomQuyenService.create(any())).thenReturn(responseDTO);

        // Act
        ResponseDTO<NhomQuyen> result = nhomQuyenController.create(nhomQuyenDTO);

        // Assert
        assertNotNull(result);
        assertEquals(201, result.getStatus());
        assertEquals("Tạo nhóm quyền thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý kho", result.getData().getTenNhomQuyen());
        assertEquals(3, result.getData().getChucNangs().size());
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_CONTROLLER_002: Kiểm thử API cập nhật nhóm quyền với dữ liệu hợp lệ")
    void testUpdateNhomQuyen_WithValidData_ShouldReturn200() {
        // Arrange
        nhomQuyenDTO.setId(1);
        nhomQuyenDTO.setTenNhomQuyen("Quản lý kho Updated");

        ResponseDTO<NhomQuyen> updateResponseDTO = ResponseDTO.<NhomQuyen>builder()
                .status(200)
                .msg("Cập nhật nhóm quyền thành công")
                .data(nhomQuyen)
                .build();

        when(nhomQuyenService.update(any())).thenReturn(updateResponseDTO);

        // Act
        ResponseDTO<NhomQuyen> result = nhomQuyenController.update(nhomQuyenDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Cập nhật nhóm quyền thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_CONTROLLER_003: Kiểm thử API lấy thông tin nhóm quyền theo ID")
    void testGetNhomQuyenById_ShouldReturn200() {
        // Arrange
        ResponseDTO<NhomQuyen> getResponseDTO = ResponseDTO.<NhomQuyen>builder()
                .status(200)
                .msg("Thành công")
                .data(nhomQuyen)
                .build();

        when(nhomQuyenService.getById(anyInt())).thenReturn(getResponseDTO);

        // Act
        ResponseDTO<NhomQuyen> result = nhomQuyenController.getById(1);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý kho", result.getData().getTenNhomQuyen());
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_CONTROLLER_004: Kiểm thử API lấy danh sách nhóm quyền theo tên")
    void testGetByTenNhomQuyen_ShouldReturn200() {
        // Arrange
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setKeyWord("Quản lý");
        searchDTO.setCurrentPage(0);
        searchDTO.setSize(10);

        when(nhomQuyenService.getByTenNhomQuyen(any())).thenReturn(pageResponseDTO);

        // Act
        ResponseDTO<PageDTO<List<NhomQuyen>>> result = nhomQuyenController.getByTenNhomQuyen(searchDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertEquals(1, result.getData().getTotalElements());
        assertEquals(1, result.getData().getTotalPages());
        assertEquals(1, result.getData().getData().size());
        assertEquals("Quản lý kho", result.getData().getData().get(0).getTenNhomQuyen());
    }
}
