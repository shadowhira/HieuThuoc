package com.example.hieuthuoc.integration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.hieuthuoc.controller.LoaiThuocController;
import com.example.hieuthuoc.dto.LoaiThuocDTO;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;

import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.service.LoaiThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test tích hợp cho LoaiThuocController
 */
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class LoaiThuocControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoaiThuocService loaiThuocService;

    @InjectMocks
    private LoaiThuocController loaiThuocController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(loaiThuocController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllLoaiThuocs_Success() throws Exception {
        // Arrange
        List<LoaiThuoc> loaiThuocList = new ArrayList<>();
        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Thuốc giảm đau");
        loaiThuoc.setMoTa("Thuốc giảm đau, hạ sốt");
        loaiThuocList.add(loaiThuoc);

        ResponseDTO<List<LoaiThuoc>> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(loaiThuocList);

        when(loaiThuocService.getAllLoaiThuocs()).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/loaithuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data[0].tenLoai").value("Thuốc giảm đau"))
                .andExpect(jsonPath("$.data[0].moTa").value("Thuốc giảm đau, hạ sốt"));
    }

    @Test
    public void testSearchByTenLoai_Success() throws Exception {
        // Arrange
        List<LoaiThuoc> loaiThuocList = new ArrayList<>();
        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Thuốc giảm đau");
        loaiThuoc.setMoTa("Thuốc giảm đau, hạ sốt");
        loaiThuocList.add(loaiThuoc);

        ResponseDTO<List<LoaiThuoc>> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(loaiThuocList);

        String tenLoai = "giảm đau";

        when(loaiThuocService.searchByTenLoai(anyString())).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/loaithuoc/search_by_ten_loai")
                .param("tenLoai", tenLoai))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data[0].tenLoai").value("Thuốc giảm đau"));
    }

    @Test
    public void testCreate_Success() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setTenLoai("Thuốc bổ");
        loaiThuocDTO.setMoTa("Thuốc bổ sung vitamin, khoáng chất");
        loaiThuocDTO.setDanhMucThuocId(2);

        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(3);
        loaiThuoc.setTenLoai("Thuốc bổ");
        loaiThuoc.setMoTa("Thuốc bổ sung vitamin, khoáng chất");

        ResponseDTO<LoaiThuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(loaiThuoc);

        when(loaiThuocService.create(any(LoaiThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(post("/loaithuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenLoai").value("Thuốc bổ"))
                .andExpect(jsonPath("$.data.moTa").value("Thuốc bổ sung vitamin, khoáng chất"));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setId(1);
        loaiThuocDTO.setTenLoai("Thuốc giảm đau Updated");
        loaiThuocDTO.setMoTa("Thuốc giảm đau, hạ sốt Updated");
        loaiThuocDTO.setDanhMucThuocId(2);

        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Thuốc giảm đau Updated");
        loaiThuoc.setMoTa("Thuốc giảm đau, hạ sốt Updated");

        ResponseDTO<LoaiThuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(loaiThuoc);

        when(loaiThuocService.update(any(LoaiThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(put("/loaithuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenLoai").value("Thuốc giảm đau Updated"))
                .andExpect(jsonPath("$.data.moTa").value("Thuốc giảm đau, hạ sốt Updated"));
    }

    @Test
    public void testDelete_Success() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");

        when(loaiThuocService.delete(anyInt())).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(delete("/loaithuoc/delete")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200));
    }
}
