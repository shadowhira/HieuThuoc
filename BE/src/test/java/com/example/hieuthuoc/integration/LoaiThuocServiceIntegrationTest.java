package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hieuthuoc.dto.LoaiThuocDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.service.LoaiThuocService;

@ExtendWith(MockitoExtension.class)
public class LoaiThuocServiceIntegrationTest {

    @Mock
    private LoaiThuocService loaiThuocService;

    private LoaiThuocDTO loaiThuocDTO;
    private LoaiThuoc loaiThuoc;
    private DanhMucThuoc danhMucThuoc;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu test
        loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setId(1);
        loaiThuocDTO.setTenLoai("Thuốc giảm đau");
        loaiThuocDTO.setDanhMucThuocId(1);

        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Thuốc giảm đau");

        danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc không kê đơn");
    }

    @Test
    @DisplayName("INTEG_SERVICE_004: Kiểm thử tích hợp giữa LoaiThuocService và DanhMucThuocService khi thêm loại thuốc với danhMucThuocId không tồn tại")
    void testCreateLoaiThuocWithNonExistentDanhMucThuoc() {
        // Arrange
        ResponseDTO<LoaiThuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(404);
        expectedResponse.setMsg("Danh mục thuốc không tồn tại");
        expectedResponse.setData(null);

        when(loaiThuocService.create(any(LoaiThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.create(loaiThuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Danh mục thuốc không tồn tại", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("Kiểm thử tích hợp giữa LoaiThuocService và DanhMucThuocService khi thêm loại thuốc với danhMucThuocId hợp lệ")
    void testCreateLoaiThuocWithValidDanhMucThuoc() {
        // Arrange
        ResponseDTO<LoaiThuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(201);
        expectedResponse.setMsg("Tạo loại thuốc thành công");
        expectedResponse.setData(loaiThuoc);

        when(loaiThuocService.create(any(LoaiThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.create(loaiThuocDTO);

        // Assert
        assertEquals(201, response.getStatus());
        assertNotNull(response.getData());
        assertEquals("Tạo loại thuốc thành công", response.getMsg());
    }

    @Test
    @DisplayName("Kiểm thử tích hợp giữa LoaiThuocService và DanhMucThuocService khi thêm loại thuốc với tên đã tồn tại")
    void testCreateLoaiThuocWithExistingName() {
        // Arrange
        ResponseDTO<LoaiThuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(409);
        expectedResponse.setMsg("Loại thuốc đã tồn tại");
        expectedResponse.setData(null);

        when(loaiThuocService.create(any(LoaiThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.create(loaiThuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Loại thuốc đã tồn tại", response.getMsg());
        assertNull(response.getData());
    }
}
