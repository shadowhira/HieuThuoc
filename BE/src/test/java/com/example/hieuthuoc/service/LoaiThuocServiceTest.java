package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.hieuthuoc.dto.LoaiThuocDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.repository.DanhMucThuocRepo;
import com.example.hieuthuoc.repository.LoaiThuocRepo;

@ExtendWith(MockitoExtension.class)
public class LoaiThuocServiceTest {

    @Mock
    private LoaiThuocRepo loaiThuocRepo;

    @Mock
    private DanhMucThuocRepo danhMucThuocRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private LoaiThuocServiceImpl loaiThuocService;

    private LoaiThuoc loaiThuoc;
    private LoaiThuocDTO loaiThuocDTO;
    private DanhMucThuoc danhMucThuoc;
    private List<LoaiThuoc> loaiThuocList;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho các test case
        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Giảm đau không steroid");
        loaiThuoc.setMoTa("Nhóm giảm đau không steroid");

        loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setId(1);
        loaiThuocDTO.setTenLoai("Giảm đau không steroid");
        loaiThuocDTO.setMoTa("Nhóm giảm đau không steroid");
        loaiThuocDTO.setDanhMucThuocId(1);

        danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc giảm đau");
        danhMucThuoc.setMoTa("Các loại thuốc giảm đau");

        loaiThuoc.setDanhMucThuoc(danhMucThuoc);

        loaiThuocList = new ArrayList<>();
        loaiThuocList.add(loaiThuoc);
    }

    @Test
    void testGetAllLoaiThuocs_Success() {
        // Arrange
        when(loaiThuocRepo.findAll()).thenReturn(loaiThuocList);

        // Act
        ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.getAllLoaiThuocs();

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertEquals(loaiThuocList, response.getData());
        verify(loaiThuocRepo, times(1)).findAll();
    }

    @Test
    void testGetAllLoaiThuocs_EmptyList() {
        // Arrange
        when(loaiThuocRepo.findAll()).thenReturn(new ArrayList<>());

        // Act
        ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.getAllLoaiThuocs();

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertTrue(response.getData().isEmpty());
        verify(loaiThuocRepo, times(1)).findAll();
    }

    @Test
    void testSearchByTenLoai_Success() {
        // Arrange
        String tenLoai = "Giảm đau";
        when(loaiThuocRepo.searchByTenLoai(tenLoai)).thenReturn(loaiThuocList);

        // Act
        ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.searchByTenLoai(tenLoai);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertEquals(loaiThuocList, response.getData());
        verify(loaiThuocRepo, times(1)).searchByTenLoai(tenLoai);
    }

    @Test
    void testSearchByTenLoai_NotFound() {
        // Arrange
        String tenLoai = "Không tồn tại";
        when(loaiThuocRepo.searchByTenLoai(tenLoai)).thenReturn(new ArrayList<>());

        // Act
        ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.searchByTenLoai(tenLoai);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Danh mục thuốc không tồn tại", response.getMsg());
        assertNull(response.getData());
        verify(loaiThuocRepo, times(1)).searchByTenLoai(tenLoai);
    }

    @Test
    void testCreate_Success() {
        // Arrange
        when(loaiThuocRepo.existsByTenLoai(loaiThuocDTO.getTenLoai())).thenReturn(false);
        when(danhMucThuocRepo.findById(loaiThuocDTO.getDanhMucThuocId())).thenReturn(Optional.of(danhMucThuoc));
        when(modelMapper.map(loaiThuocDTO, LoaiThuoc.class)).thenReturn(loaiThuoc);
        when(loaiThuocRepo.save(loaiThuoc)).thenReturn(loaiThuoc);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.create(loaiThuocDTO);

        // Assert
        assertEquals(201, response.getStatus());
        assertEquals("Tạo loại thuốc thành công", response.getMsg());
        assertEquals(loaiThuoc, response.getData());
        verify(loaiThuocRepo, times(1)).existsByTenLoai(loaiThuocDTO.getTenLoai());
        verify(danhMucThuocRepo, times(1)).findById(loaiThuocDTO.getDanhMucThuocId());
        verify(loaiThuocRepo, times(1)).save(loaiThuoc);
    }

    @Test
    void testCreate_DuplicateTenLoai() {
        // Arrange
        when(loaiThuocRepo.existsByTenLoai(loaiThuocDTO.getTenLoai())).thenReturn(true);
        when(modelMapper.map(loaiThuocDTO, LoaiThuoc.class)).thenReturn(loaiThuoc);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.create(loaiThuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Loại thuốc đã tồn tại", response.getMsg());
        assertNull(response.getData());
        verify(loaiThuocRepo, times(1)).existsByTenLoai(loaiThuocDTO.getTenLoai());
        verify(danhMucThuocRepo, times(0)).findById(anyInt());
        verify(loaiThuocRepo, times(0)).save(any(LoaiThuoc.class));
    }

    @Test
    void testUpdate_Success() {
        // Arrange
        when(loaiThuocRepo.findById(loaiThuocDTO.getId())).thenReturn(Optional.of(loaiThuoc));
        when(modelMapper.map(loaiThuocDTO, LoaiThuoc.class)).thenReturn(loaiThuoc);
        when(loaiThuocRepo.save(loaiThuoc)).thenReturn(loaiThuoc);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.update(loaiThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Cập nhật loại thuốc thành công", response.getMsg());
        assertEquals(loaiThuoc, response.getData());
        verify(loaiThuocRepo, times(1)).findById(loaiThuocDTO.getId());
        verify(loaiThuocRepo, times(1)).save(loaiThuoc);
    }

    @Test
    void testUpdate_NotFound() {
        // Arrange
        when(loaiThuocRepo.findById(loaiThuocDTO.getId())).thenReturn(Optional.empty());
        when(modelMapper.map(loaiThuocDTO, LoaiThuoc.class)).thenReturn(loaiThuoc);

        // Act
        ResponseDTO<LoaiThuoc> response = loaiThuocService.update(loaiThuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Không tìm thấy loại thuốc", response.getMsg());
        assertNull(response.getData());
        verify(loaiThuocRepo, times(1)).findById(loaiThuocDTO.getId());
        verify(danhMucThuocRepo, times(0)).findById(anyInt());
        verify(loaiThuocRepo, times(0)).save(any(LoaiThuoc.class));
    }

    @Test
    void testDelete_Success() {
        // Arrange
        when(loaiThuocRepo.existsById(1)).thenReturn(true);
        doNothing().when(loaiThuocRepo).deleteById(1);

        // Act
        ResponseDTO<Void> response = loaiThuocService.delete(1);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Xóa loại thuốc thành công", response.getMsg());
        assertNull(response.getData());
        verify(loaiThuocRepo, times(1)).existsById(1);
        verify(loaiThuocRepo, times(1)).deleteById(1);
    }

    @Test
    void testDelete_NotFound() {
        // Arrange
        when(loaiThuocRepo.existsById(1)).thenReturn(false);

        // Act
        ResponseDTO<Void> response = loaiThuocService.delete(1);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Không tìm thấy loại thuốc để xóa", response.getMsg());
        assertNull(response.getData());
        verify(loaiThuocRepo, times(1)).existsById(1);
        verify(loaiThuocRepo, times(0)).deleteById(1);
    }
}
