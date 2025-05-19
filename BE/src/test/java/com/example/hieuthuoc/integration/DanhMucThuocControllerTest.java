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

import com.example.hieuthuoc.controller.DanhMucThuocController;
import com.example.hieuthuoc.dto.DanhMucThuocDTO;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;

import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.service.DanhMucThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test tích hợp cho DanhMucThuocController
 */
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class DanhMucThuocControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DanhMucThuocService danhMucThuocService;

    @InjectMocks
    private DanhMucThuocController danhMucThuocController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(danhMucThuocController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        // Arrange
        List<DanhMucThuoc> danhMucThuocList = new ArrayList<>();
        DanhMucThuoc danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc kê đơn");
        danhMucThuoc.setMoTa("Thuốc cần kê đơn của bác sĩ");
        danhMucThuocList.add(danhMucThuoc);

        ResponseDTO<List<DanhMucThuoc>> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(danhMucThuocList);

        when(danhMucThuocService.getAll()).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kê đơn"))
                .andExpect(jsonPath("$.data[0].moTa").value("Thuốc cần kê đơn của bác sĩ"));
    }

    @Test
    public void testSearchByTenDanhMuc_Success() throws Exception {
        // Arrange
        List<DanhMucThuoc> danhMucThuocList = new ArrayList<>();
        DanhMucThuoc danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc kê đơn");
        danhMucThuoc.setMoTa("Thuốc cần kê đơn của bác sĩ");
        danhMucThuocList.add(danhMucThuoc);

        ResponseDTO<List<DanhMucThuoc>> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(danhMucThuocList);

        String tenDanhMuc = "kê đơn";

        when(danhMucThuocService.searchByTenDanhMuc(anyString())).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/search_by_ten_danh_muc")
                .param("tenDanhMuc", tenDanhMuc))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kê đơn"));
    }

    @Test
    public void testCreate_Success() throws Exception {
        // Arrange
        DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setTenDanhMuc("Thuốc thực phẩm chức năng");
        danhMucThuocDTO.setMoTa("Thuốc bổ sung dinh dưỡng");

        DanhMucThuoc danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(3);
        danhMucThuoc.setTenDanhMuc("Thuốc thực phẩm chức năng");
        danhMucThuoc.setMoTa("Thuốc bổ sung dinh dưỡng");

        ResponseDTO<DanhMucThuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(danhMucThuoc);

        when(danhMucThuocService.create(any(DanhMucThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(post("/danhmucthuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenDanhMuc").value("Thuốc thực phẩm chức năng"))
                .andExpect(jsonPath("$.data.moTa").value("Thuốc bổ sung dinh dưỡng"));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        // Arrange
        DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setId(1);
        danhMucThuocDTO.setTenDanhMuc("Thuốc kê đơn Updated");
        danhMucThuocDTO.setMoTa("Thuốc cần kê đơn của bác sĩ Updated");

        DanhMucThuoc danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc kê đơn Updated");
        danhMucThuoc.setMoTa("Thuốc cần kê đơn của bác sĩ Updated");

        ResponseDTO<DanhMucThuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(danhMucThuoc);

        when(danhMucThuocService.update(any(DanhMucThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(put("/danhmucthuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenDanhMuc").value("Thuốc kê đơn Updated"))
                .andExpect(jsonPath("$.data.moTa").value("Thuốc cần kê đơn của bác sĩ Updated"));
    }

    @Test
    public void testDelete_Success() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");

        when(danhMucThuocService.delete(anyInt())).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(delete("/danhmucthuoc/delete")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200));
    }
}
