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

import com.example.hieuthuoc.dto.LoaiThuocDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.service.LoaiThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class LoaiThuocControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoaiThuocService loaiThuocService;

    @InjectMocks
    private LoaiThuocController loaiThuocController;

    private ObjectMapper objectMapper;
    private LoaiThuoc loaiThuoc;
    private LoaiThuocDTO loaiThuocDTO;
    private List<LoaiThuoc> loaiThuocList;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(loaiThuocController).build();
        objectMapper = new ObjectMapper();

        // Khởi tạo dữ liệu mẫu
        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Giảm đau không steroid");
        loaiThuoc.setMoTa("Nhóm giảm đau không steroid");

        loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setId(1);
        loaiThuocDTO.setTenLoai("Giảm đau không steroid");
        loaiThuocDTO.setMoTa("Nhóm giảm đau không steroid");
        loaiThuocDTO.setDanhMucThuocId(1);

        loaiThuocList = new ArrayList<>();
        loaiThuocList.add(loaiThuoc);
    }

    @Test
    void testGetAllLoaiThuocs_Success() throws Exception {
        // Arrange
        ResponseDTO<List<LoaiThuoc>> responseDTO = ResponseDTO.<List<LoaiThuoc>>builder()
                .status(200)
                .msg("Thành công")
                .data(loaiThuocList)
                .build();

        when(loaiThuocService.getAllLoaiThuocs()).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/loaithuoc/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].tenLoai").value("Giảm đau không steroid"));

        verify(loaiThuocService, times(1)).getAllLoaiThuocs();
    }

    @Test
    void testSearchByTenLoai_Success() throws Exception {
        // Arrange
        String tenLoai = "Giảm đau";
        ResponseDTO<List<LoaiThuoc>> responseDTO = ResponseDTO.<List<LoaiThuoc>>builder()
                .status(200)
                .msg("Thành công")
                .data(loaiThuocList)
                .build();

        when(loaiThuocService.searchByTenLoai(tenLoai)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/loaithuoc/search_by_ten_loai")
                .param("tenLoai", tenLoai)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].tenLoai").value("Giảm đau không steroid"));

        verify(loaiThuocService, times(1)).searchByTenLoai(tenLoai);
    }

    @Test
    void testCreate_Success() throws Exception {
        // Arrange
        ResponseDTO<LoaiThuoc> responseDTO = ResponseDTO.<LoaiThuoc>builder()
                .status(201)
                .msg("Tạo loại thuốc thành công")
                .data(loaiThuoc)
                .build();

        when(loaiThuocService.create(any(LoaiThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/loaithuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Tạo loại thuốc thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenLoai").value("Giảm đau không steroid"));

        verify(loaiThuocService, times(1)).create(any(LoaiThuocDTO.class));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Arrange
        ResponseDTO<LoaiThuoc> responseDTO = ResponseDTO.<LoaiThuoc>builder()
                .status(200)
                .msg("Cập nhật loại thuốc thành công")
                .data(loaiThuoc)
                .build();

        when(loaiThuocService.update(any(LoaiThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/loaithuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Cập nhật loại thuốc thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenLoai").value("Giảm đau không steroid"));

        verify(loaiThuocService, times(1)).update(any(LoaiThuocDTO.class));
    }

    @Test
    void testDelete_Success() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xóa loại thuốc thành công")
                .build();

        when(loaiThuocService.delete(1)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/loaithuoc/delete")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Xóa loại thuốc thành công"));

        verify(loaiThuocService, times(1)).delete(1);
    }
}
