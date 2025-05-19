package com.example.hieuthuoc.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.hieuthuoc.dto.DanhMucThuocDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.service.DanhMucThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class DanhMucThuocControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DanhMucThuocService danhMucThuocService;

    @InjectMocks
    private DanhMucThuocController danhMucThuocController;

    private ObjectMapper objectMapper;
    private DanhMucThuoc danhMucThuoc;
    private DanhMucThuocDTO danhMucThuocDTO;
    private List<DanhMucThuoc> danhMucThuocList;
    private List<LoaiThuoc> loaiThuocList;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(danhMucThuocController).build();
        objectMapper = new ObjectMapper();

        // Khởi tạo dữ liệu mẫu
        danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc giảm đau");
        danhMucThuoc.setMoTa("Các loại thuốc giảm đau");

        danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setId(1);
        danhMucThuocDTO.setTenDanhMuc("Thuốc giảm đau");
        danhMucThuocDTO.setMoTa("Các loại thuốc giảm đau");

        loaiThuocList = new ArrayList<>();
        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Giảm đau không steroid");
        loaiThuoc.setMoTa("Nhóm giảm đau không steroid");
        loaiThuoc.setDanhMucThuoc(danhMucThuoc);
        loaiThuocList.add(loaiThuoc);

        danhMucThuoc.setLoaiThuocs(loaiThuocList);

        danhMucThuocList = new ArrayList<>();
        danhMucThuocList.add(danhMucThuoc);
    }

    @Test
    void testGetAll_Success() throws Exception {
        // Arrange
        ResponseDTO<List<DanhMucThuoc>> responseDTO = ResponseDTO.<List<DanhMucThuoc>>builder()
                .status(200)
                .msg("Thành công")
                .data(danhMucThuocList)
                .build();

        when(danhMucThuocService.getAll()).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/danhmucthuoc/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].tenDanhMuc").value("Thuốc giảm đau"));

        verify(danhMucThuocService, times(1)).getAll();
    }

    @Test
    void testGetDanhMucAnhLoaiThuoc_Success() throws Exception {
        // Arrange
        ResponseDTO<List<DanhMucThuoc>> responseDTO = ResponseDTO.<List<DanhMucThuoc>>builder()
                .status(200)
                .msg("Thành công")
                .data(danhMucThuocList)
                .build();

        when(danhMucThuocService.getDanhMucAnhLoaiThuoc()).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/danhmucthuoc/get_danh_muc_and_loai_thuoc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].tenDanhMuc").value("Thuốc giảm đau"));

        verify(danhMucThuocService, times(1)).getDanhMucAnhLoaiThuoc();
    }

    @Test
    void testSearchByTenDanhMuc_Success() throws Exception {
        // Arrange
        String tenDanhMuc = "Giảm đau";
        ResponseDTO<List<DanhMucThuoc>> responseDTO = ResponseDTO.<List<DanhMucThuoc>>builder()
                .status(200)
                .msg("Thành công")
                .data(danhMucThuocList)
                .build();

        when(danhMucThuocService.searchByTenDanhMuc(tenDanhMuc)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/danhmucthuoc/search_by_ten_danh_muc")
                .param("tenDanhMuc", tenDanhMuc)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].tenDanhMuc").value("Thuốc giảm đau"));

        verify(danhMucThuocService, times(1)).searchByTenDanhMuc(tenDanhMuc);
    }

    @Test
    void testCreate_Success() throws Exception {
        // Arrange
        ResponseDTO<DanhMucThuoc> responseDTO = ResponseDTO.<DanhMucThuoc>builder()
                .status(201)
                .msg("Tạo danh mục thuốc thành công")
                .data(danhMucThuoc)
                .build();

        when(danhMucThuocService.create(any(DanhMucThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/danhmucthuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Tạo danh mục thuốc thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenDanhMuc").value("Thuốc giảm đau"));

        verify(danhMucThuocService, times(1)).create(any(DanhMucThuocDTO.class));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Arrange
        ResponseDTO<DanhMucThuoc> responseDTO = ResponseDTO.<DanhMucThuoc>builder()
                .status(200)
                .msg("Cập nhật danh mục thuốc thành công")
                .data(danhMucThuoc)
                .build();

        when(danhMucThuocService.update(any(DanhMucThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/danhmucthuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Cập nhật danh mục thuốc thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenDanhMuc").value("Thuốc giảm đau"));

        verify(danhMucThuocService, times(1)).update(any(DanhMucThuocDTO.class));
    }

    @Test
    void testDelete_Success() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xóa danh mục thuốc thành công")
                .build();

        when(danhMucThuocService.delete(1)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/danhmucthuoc/delete")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Xóa danh mục thuốc thành công"));

        verify(danhMucThuocService, times(1)).delete(1);
    }
}
