package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
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
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchDTO;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.repository.NhomQuyenRepo;
import com.example.hieuthuoc.service.NhomQuyenService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class NhomQuyenIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NhomQuyenService nhomQuyenService;

    @Autowired
    private NhomQuyenRepo nhomQuyenRepo;

    @Test
    @DisplayName("IT_NHOMQUYEN_001: Kiểm thử tích hợp lấy thông tin nhóm quyền theo ID")
    public void testGetById_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/nhomquyen/get")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.tenNhomQuyen").value("ADMIN"));
    }

    @Test
    @DisplayName("IT_NHOMQUYEN_002: Kiểm thử tích hợp tạo nhóm quyền mới")
    public void testCreate_Success() throws Exception {
        // Arrange
        NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setTenNhomQuyen("QUAN_LY_KHO");
        nhomQuyenDTO.setMoTa("Quan ly kho hang");

        List<ChucNangDTO> chucNangDTOs = new ArrayList<>();
        ChucNangDTO chucNangDTO = new ChucNangDTO();
        chucNangDTO.setId(3); // Quản lý thuốc
        chucNangDTOs.add(chucNangDTO);
        nhomQuyenDTO.setChucNangs(chucNangDTOs);

        // Act & Assert
        mockMvc.perform(post("/nhomquyen/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nhomQuyenDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("IT_NHOMQUYEN_003: Kiểm thử tích hợp cập nhật thông tin nhóm quyền")
    public void testUpdate_Success() throws Exception {
        // Arrange
        NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setId(2);
        nhomQuyenDTO.setTenNhomQuyen("NHAN_VIEN");
        nhomQuyenDTO.setMoTa("Nhân viên bán hàng đã cập nhật");

        List<ChucNangDTO> chucNangDTOs = new ArrayList<>();
        ChucNangDTO chucNangDTO1 = new ChucNangDTO();
        chucNangDTO1.setId(3); // Quản lý thuốc
        chucNangDTOs.add(chucNangDTO1);

        ChucNangDTO chucNangDTO2 = new ChucNangDTO();
        chucNangDTO2.setId(1); // Quản lý người dùng
        chucNangDTOs.add(chucNangDTO2);

        nhomQuyenDTO.setChucNangs(chucNangDTOs);

        // Act & Assert
        mockMvc.perform(put("/nhomquyen/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nhomQuyenDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Cập nhật nhóm quyền thành công"))
                .andExpect(jsonPath("$.data.moTa").value("Nhân viên bán hàng đã cập nhật"));

        // Kiểm tra dữ liệu đã được cập nhật trong cơ sở dữ liệu
        NhomQuyen nhomQuyen = nhomQuyenRepo.findById(2).orElse(null);
        assertNotNull(nhomQuyen);
        assertEquals("Nhân viên bán hàng đã cập nhật", nhomQuyen.getMoTa());
        assertEquals(2, nhomQuyen.getChucNangs().size());
    }

    @Test
    @DisplayName("IT_NHOMQUYEN_004: Kiểm thử tích hợp xóa nhóm quyền")
    public void testDelete_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/nhomquyen/delete")
                .param("id", "3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Xóa nhóm quyền thành công"));

        // Kiểm tra nhóm quyền đã bị xóa khỏi cơ sở dữ liệu
        NhomQuyen nhomQuyen = nhomQuyenRepo.findById(3).orElse(null);
        assertNull(nhomQuyen);
    }

    @Test
    @DisplayName("IT_NHOMQUYEN_005: Kiểm thử tích hợp tìm kiếm nhóm quyền theo tên")
    public void testSearchByTenNhomQuyen_Success() throws Exception {
        // Arrange
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setKeyWord("ADMIN");
        searchDTO.setCurrentPage(0);
        searchDTO.setSize(10);

        // Act & Assert
        mockMvc.perform(post("/nhomquyen/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.data[0].tenNhomQuyen").value("ADMIN"));
    }
}
