package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.repository.ChucNangRepo;
import com.example.hieuthuoc.repository.NhomQuyenRepo;

@ExtendWith(MockitoExtension.class)
public class NhomQuyenServiceTest {

    @Mock
    private NhomQuyenRepo nhomQuyenRepo;

    @Mock
    private ChucNangRepo chucNangRepo;

    @InjectMocks
    private NhomQuyenServiceImpl nhomQuyenService;

    private NhomQuyenDTO nhomQuyenDTO;
    private NhomQuyen nhomQuyen;
    private List<ChucNang> chucNangs;

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

        chucNangs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ChucNang chucNang = new ChucNang();
            chucNang.setId(i);
            chucNang.setTenChucNang("Chức năng " + i);
            chucNang.setMoTa("Mô tả chức năng " + i);
            chucNangs.add(chucNang);
        }

        nhomQuyen.setChucNangs(chucNangs);
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_SERVICE_001: Kiểm thử phương thức tạo nhóm quyền mới với dữ liệu hợp lệ")
    void testCreateNhomQuyen_WithValidData_ShouldReturnCreatedNhomQuyen() {
        // Arrange
        when(nhomQuyenRepo.existsByTenNhomQuyen(anyString())).thenReturn(false);
        when(nhomQuyenRepo.save(any(NhomQuyen.class))).thenReturn(nhomQuyen);

        for (int i = 0; i < 3; i++) {
            when(chucNangRepo.findById(i + 1)).thenReturn(Optional.of(chucNangs.get(i)));
        }

        // Act
        ResponseDTO<NhomQuyen> result = nhomQuyenService.create(nhomQuyenDTO);

        // Assert
        assertNotNull(result);
        assertEquals(201, result.getStatus());
        assertEquals("Tạo nhóm quyền thành công", result.getMsg());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý kho", result.getData().getTenNhomQuyen());
        assertEquals("Nhóm quyền dành cho quản lý kho", result.getData().getMoTa());
        assertEquals(3, result.getData().getChucNangs().size());

        verify(nhomQuyenRepo, times(1)).save(any(NhomQuyen.class));
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_SERVICE_002: Kiểm thử phương thức cập nhật nhóm quyền")
    void testUpdateNhomQuyen_WithValidData_ShouldReturnUpdatedNhomQuyen() {
        // Arrange
        nhomQuyenDTO.setId(1);
        nhomQuyenDTO.setTenNhomQuyen("Quản lý kho Updated");
        nhomQuyenDTO.setMoTa("Mô tả đã cập nhật");

        NhomQuyen updatedNhomQuyen = new NhomQuyen();
        updatedNhomQuyen.setId(1);
        updatedNhomQuyen.setTenNhomQuyen("Quản lý kho Updated");
        updatedNhomQuyen.setMoTa("Mô tả đã cập nhật");
        updatedNhomQuyen.setChucNangs(chucNangs);

        when(nhomQuyenRepo.findById(1)).thenReturn(Optional.of(nhomQuyen));
        when(nhomQuyenRepo.save(any(NhomQuyen.class))).thenReturn(updatedNhomQuyen);

        for (int i = 0; i < 3; i++) {
            when(chucNangRepo.findById(i + 1)).thenReturn(Optional.of(chucNangs.get(i)));
        }

        // Act
        ResponseDTO<NhomQuyen> result = nhomQuyenService.update(nhomQuyenDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Cập nhật nhóm quyền thành công", result.getMsg());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getId());
        assertEquals("Quản lý kho Updated", result.getData().getTenNhomQuyen());
        assertEquals("Mô tả đã cập nhật", result.getData().getMoTa());

        verify(nhomQuyenRepo, times(1)).findById(1);
        verify(nhomQuyenRepo, times(1)).save(any(NhomQuyen.class));
    }
}
