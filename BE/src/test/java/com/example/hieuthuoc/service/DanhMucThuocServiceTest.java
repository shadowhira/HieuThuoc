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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import com.example.hieuthuoc.dto.DanhMucThuocDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.repository.DanhMucThuocRepo;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DanhMucThuocServiceTest {

    @Mock
    private DanhMucThuocRepo danhMucThuocRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DanhMucThuocServiceImpl danhMucThuocService;

    private DanhMucThuoc danhMucThuoc;
    private DanhMucThuocDTO danhMucThuocDTO;
    private List<DanhMucThuoc> danhMucThuocList;
    private List<LoaiThuoc> loaiThuocList;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho các test case
        danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc giảm đau");
        danhMucThuoc.setMoTa("Các loại thuốc giảm đau");

        danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setId(1);
        danhMucThuocDTO.setTenDanhMuc("Thuốc giảm đau");
        danhMucThuocDTO.setMoTa("Các loại thuốc giảm đau");

        // Tạo danh sách loại thuốc mà không thiết lập quan hệ hai chiều
        loaiThuocList = new ArrayList<>();
        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Giảm đau không steroid");
        loaiThuoc.setMoTa("Nhóm giảm đau không steroid");
        // Không thiết lập danhMucThuoc cho loaiThuoc để tránh vòng lặp vô hạn
        loaiThuocList.add(loaiThuoc);

        // Thiết lập danh sách loại thuốc cho danhMucThuoc
        danhMucThuoc.setLoaiThuocs(loaiThuocList);

        danhMucThuocList = new ArrayList<>();
        danhMucThuocList.add(danhMucThuoc);
    }

    @Test
    void testGetAll_Success() {
        // Arrange
        when(danhMucThuocRepo.findAll()).thenReturn(danhMucThuocList);

        // Act
        ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getAll();

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertEquals(danhMucThuocList, response.getData());
        verify(danhMucThuocRepo, times(1)).findAll();
    }

    @Test
    void testGetAll_EmptyList() {
        // Arrange
        when(danhMucThuocRepo.findAll()).thenReturn(new ArrayList<>());

        // Act
        ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getAll();

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertTrue(response.getData().isEmpty());
        verify(danhMucThuocRepo, times(1)).findAll();
    }

    @Test
    void testGetDanhMucAnhLoaiThuoc_Success() {
        // Arrange
        when(danhMucThuocRepo.findAllWithLoaiThuocs()).thenReturn(danhMucThuocList);

        // Act
        ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getDanhMucAnhLoaiThuoc();

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertEquals(danhMucThuocList, response.getData());
        verify(danhMucThuocRepo, times(1)).findAllWithLoaiThuocs();
    }

    @Test
    void testGetDanhMucAnhLoaiThuoc_EmptyList() {
        // Arrange
        when(danhMucThuocRepo.findAllWithLoaiThuocs()).thenReturn(new ArrayList<>());

        // Act
        ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getDanhMucAnhLoaiThuoc();

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertTrue(response.getData().isEmpty());
        verify(danhMucThuocRepo, times(1)).findAllWithLoaiThuocs();
    }

    @Test
    void testSearchByTenDanhMuc_Success() {
        // Arrange
        String tenDanhMuc = "Giảm đau";
        when(danhMucThuocRepo.searchByTenDanhMuc(tenDanhMuc)).thenReturn(danhMucThuocList);

        // Act
        ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.searchByTenDanhMuc(tenDanhMuc);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertEquals(danhMucThuocList, response.getData());
        verify(danhMucThuocRepo, times(1)).searchByTenDanhMuc(tenDanhMuc);
    }

    @Test
    void testSearchByTenDanhMuc_NotFound() {
        // Arrange
        String tenDanhMuc = "Không tồn tại";
        when(danhMucThuocRepo.searchByTenDanhMuc(tenDanhMuc)).thenReturn(new ArrayList<>());

        // Act
        ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.searchByTenDanhMuc(tenDanhMuc);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Danh mục thuốc không tồn tại", response.getMsg());
        assertNull(response.getData());
        verify(danhMucThuocRepo, times(1)).searchByTenDanhMuc(tenDanhMuc);
    }

    @Test
    void testCreate_Success() {
        // Arrange
        when(danhMucThuocRepo.existsByTenDanhMuc(danhMucThuocDTO.getTenDanhMuc())).thenReturn(false);
        when(modelMapper.map(danhMucThuocDTO, DanhMucThuoc.class)).thenReturn(danhMucThuoc);
        when(danhMucThuocRepo.save(any(DanhMucThuoc.class))).thenReturn(danhMucThuoc);

        // Act
        ResponseDTO<DanhMucThuoc> response = danhMucThuocService.create(danhMucThuocDTO);

        // Assert
        assertEquals(201, response.getStatus());
        assertEquals("Tạo danh mục thuốc thành công", response.getMsg());
        assertEquals(danhMucThuoc, response.getData());
        verify(danhMucThuocRepo, times(1)).existsByTenDanhMuc(danhMucThuocDTO.getTenDanhMuc());
        verify(danhMucThuocRepo, times(1)).save(any(DanhMucThuoc.class));
    }

    @Test
    void testCreate_DuplicateTenDanhMuc() {
        // Arrange
        when(danhMucThuocRepo.existsByTenDanhMuc(danhMucThuocDTO.getTenDanhMuc())).thenReturn(true);

        // Act
        ResponseDTO<DanhMucThuoc> response = danhMucThuocService.create(danhMucThuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Danh mục thuốc đã tồn tại", response.getMsg());
        assertNull(response.getData());
        verify(danhMucThuocRepo, times(1)).existsByTenDanhMuc(danhMucThuocDTO.getTenDanhMuc());
        verify(danhMucThuocRepo, times(0)).save(any(DanhMucThuoc.class));
    }

    @Test
    void testUpdate_Success() {
        // Arrange
        when(danhMucThuocRepo.findById(danhMucThuocDTO.getId())).thenReturn(Optional.of(danhMucThuoc));
        when(modelMapper.map(danhMucThuocDTO, DanhMucThuoc.class)).thenReturn(danhMucThuoc);
        when(danhMucThuocRepo.save(any(DanhMucThuoc.class))).thenReturn(danhMucThuoc);

        // Act
        ResponseDTO<DanhMucThuoc> response = danhMucThuocService.update(danhMucThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Cập nhật danh mục thuốc thành công", response.getMsg());
        assertEquals(danhMucThuoc, response.getData());
        verify(danhMucThuocRepo, times(1)).findById(danhMucThuocDTO.getId());
        verify(danhMucThuocRepo, times(1)).save(any(DanhMucThuoc.class));
    }

    @Test
    void testUpdate_NotFound() {
        // Arrange
        when(danhMucThuocRepo.findById(danhMucThuocDTO.getId())).thenReturn(Optional.empty());

        // Act
        ResponseDTO<DanhMucThuoc> response = danhMucThuocService.update(danhMucThuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Không tìm thấy danh mục thuốc", response.getMsg());
        assertNull(response.getData());
        verify(danhMucThuocRepo, times(1)).findById(danhMucThuocDTO.getId());
        verify(danhMucThuocRepo, times(0)).save(any(DanhMucThuoc.class));
    }

    @Test
    void testDelete_Success() {
        // Arrange
        when(danhMucThuocRepo.existsById(1)).thenReturn(true);
        doNothing().when(danhMucThuocRepo).deleteById(1);

        // Act
        ResponseDTO<Void> response = danhMucThuocService.delete(1);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Xóa danh mục thuốc thành công", response.getMsg());
        assertNull(response.getData());
        verify(danhMucThuocRepo, times(1)).existsById(1);
        verify(danhMucThuocRepo, times(1)).deleteById(1);
    }

    @Test
    void testDelete_NotFound() {
        // Arrange
        when(danhMucThuocRepo.existsById(1)).thenReturn(false);

        // Act
        ResponseDTO<Void> response = danhMucThuocService.delete(1);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Không tìm thấy danh mục thuốc để xóa", response.getMsg());
        assertNull(response.getData());
        verify(danhMucThuocRepo, times(1)).existsById(1);
        verify(danhMucThuocRepo, times(0)).deleteById(1);
    }
}
