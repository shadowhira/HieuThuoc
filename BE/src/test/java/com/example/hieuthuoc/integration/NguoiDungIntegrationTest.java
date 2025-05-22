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

import com.example.hieuthuoc.dto.NguoiDungDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchDTO;
import com.example.hieuthuoc.entity.NguoiDung;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.repository.NguoiDungRepo;
import com.example.hieuthuoc.repository.NhomQuyenRepo;
import com.example.hieuthuoc.service.NguoiDungService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class NguoiDungIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    @Autowired
    private NhomQuyenRepo nhomQuyenRepo;

    @Test
    @DisplayName("IT_NGUOIDUNG_001: Kiểm thử tích hợp lấy thông tin người dùng theo ID")
    public void testGetById_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/nguoidung/get")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.hoTen").value("Admin"))
                .andExpect(jsonPath("$.data.tenDangNhap").value("admin"));
    }

    @Test
    @DisplayName("IT_NGUOIDUNG_002: Kiểm thử tích hợp tạo người dùng mới")
    public void testCreate_Success() throws Exception {
        // Arrange
        NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setHoTen("Nguoi dung moi");
        nguoiDungDTO.setTenDangNhap("nguoidungmoi");
        nguoiDungDTO.setMatKhau("password123");
        nguoiDungDTO.setEmail("nguoidungmoi@example.com");
        nguoiDungDTO.setSoDienThoai("0123456789");
        nguoiDungDTO.setDiaChi("Ha Noi");
        nguoiDungDTO.setTrangThai(true);

        List<NhomQuyenDTO> nhomQuyenDTOs = new ArrayList<>();
        NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setId(3); // KHACH_HANG
        nhomQuyenDTOs.add(nhomQuyenDTO);
        nguoiDungDTO.setNhomQuyens(nhomQuyenDTOs);

        // Act & Assert
        mockMvc.perform(post("/nguoidung/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nguoiDungDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("IT_NGUOIDUNG_003: Kiểm thử tích hợp cập nhật thông tin người dùng")
    public void testUpdate_Success() throws Exception {
        // Arrange
        NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setId(2);
        nguoiDungDTO.setHoTen("Nhân viên đã cập nhật");
        nguoiDungDTO.setTenDangNhap("nhanvien");
        nguoiDungDTO.setEmail("nhanvien_updated@example.com");
        nguoiDungDTO.setSoDienThoai("0987654321");
        nguoiDungDTO.setDiaChi("Hà Nội");
        nguoiDungDTO.setTrangThai(true);

        List<NhomQuyenDTO> nhomQuyenDTOs = new ArrayList<>();
        NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setId(2); // NHAN_VIEN
        nhomQuyenDTOs.add(nhomQuyenDTO);
        nguoiDungDTO.setNhomQuyens(nhomQuyenDTOs);

        // Act & Assert
        mockMvc.perform(put("/nguoidung/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nguoiDungDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"))
                .andExpect(jsonPath("$.data.hoTen").value("Nhân viên đã cập nhật"))
                .andExpect(jsonPath("$.data.email").value("nhanvien_updated@example.com"));

        // Kiểm tra dữ liệu đã được cập nhật trong cơ sở dữ liệu
        NguoiDung nguoiDung = nguoiDungRepo.findById(2).orElse(null);
        assertNotNull(nguoiDung);
        assertEquals("Nhân viên đã cập nhật", nguoiDung.getHoTen());
        assertEquals("nhanvien_updated@example.com", nguoiDung.getEmail());
    }

    @Test
    @DisplayName("IT_NGUOIDUNG_004: Kiểm thử tích hợp xóa người dùng")
    public void testDelete_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/nguoidung/delete")
                .param("id", "3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Kiểm tra người dùng đã bị xóa khỏi cơ sở dữ liệu
        NguoiDung nguoiDung = nguoiDungRepo.findById(3).orElse(null);
        assertNull(nguoiDung);
    }

    @Test
    @DisplayName("IT_NGUOIDUNG_005: Kiểm thử tích hợp tìm kiếm người dùng theo họ tên")
    public void testSearchByHoTen_Success() throws Exception {
        // Arrange
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setKeyWord("Admin");
        searchDTO.setCurrentPage(0);
        searchDTO.setSize(10);

        // Act & Assert
        mockMvc.perform(post("/nguoidung/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"))
                .andExpect(jsonPath("$.data.data[0].hoTen").value("Admin"));
    }
}
