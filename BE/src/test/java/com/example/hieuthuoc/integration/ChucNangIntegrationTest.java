package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.repository.ChucNangRepo;
import com.example.hieuthuoc.service.ChucNangService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ChucNangIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ChucNangService chucNangService;

    @Autowired
    private ChucNangRepo chucNangRepo;

    @Test
    @DisplayName("IT_CHUCNANG_001: Kiểm thử tích hợp lấy danh sách tất cả chức năng")
    public void testGetAll_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/chucnang/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"))
                .andExpect(jsonPath("$.data.length()").value(3));
    }

    @Test
    @DisplayName("IT_CHUCNANG_002: Kiểm thử tích hợp tạo chức năng mới")
    public void testCreate_Success() throws Exception {
        // Arrange
        ChucNangDTO chucNangDTO = new ChucNangDTO();
        chucNangDTO.setTenChucNang("Quản lý đơn hàng");
        chucNangDTO.setHanhDong("CRUD_ORDER");
        chucNangDTO.setMoTa("Quản lý thông tin đơn hàng");

        // Act & Assert
        mockMvc.perform(post("/chucnang/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chucNangDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("IT_CHUCNANG_003: Kiểm thử tích hợp cập nhật thông tin chức năng")
    public void testUpdate_Success() throws Exception {
        // Arrange
        ChucNangDTO chucNangDTO = new ChucNangDTO();
        chucNangDTO.setId(1);
        chucNangDTO.setTenChucNang("Quản lý người dùng đã cập nhật");
        chucNangDTO.setHanhDong("CRUD_USER");
        chucNangDTO.setMoTa("Quản lý thông tin người dùng đã cập nhật");

        // Act & Assert
        mockMvc.perform(put("/chucnang/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chucNangDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Cập nhật chức năng thành công"))
                .andExpect(jsonPath("$.data.tenChucNang").value("Quản lý người dùng đã cập nhật"))
                .andExpect(jsonPath("$.data.moTa").value("Quản lý thông tin người dùng đã cập nhật"));

        // Kiểm tra dữ liệu đã được cập nhật trong cơ sở dữ liệu
        ChucNang chucNang = chucNangRepo.findById(1).orElse(null);
        assertNotNull(chucNang);
        assertEquals("Quản lý người dùng đã cập nhật", chucNang.getTenChucNang());
        assertEquals("Quản lý thông tin người dùng đã cập nhật", chucNang.getMoTa());
    }

    @Test
    @DisplayName("IT_CHUCNANG_004: Kiểm thử tích hợp xóa chức năng")
    public void testDelete_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/chucnang/delete")
                .param("id", "3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"));

        // Kiểm tra chức năng đã bị xóa khỏi cơ sở dữ liệu
        ChucNang chucNang = chucNangRepo.findById(3).orElse(null);
        assertNull(chucNang);
    }

    // Bỏ qua kiểm thử này vì không có endpoint /get
    // @Test
    // @DisplayName("IT_CHUCNANG_005: Kiểm thử tích hợp lấy thông tin chức năng theo ID")
    // public void testGetById_Success() throws Exception {
    //     // Act & Assert
    //     mockMvc.perform(get("/chucnang/get")
    //             .param("id", "1")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.data.id").value(1))
    //             .andExpect(jsonPath("$.data.tenChucNang").value("Quan ly nguoi dung"))
    //             .andExpect(jsonPath("$.data.hanhDong").value("CRUD_USER"));
    // }
}
