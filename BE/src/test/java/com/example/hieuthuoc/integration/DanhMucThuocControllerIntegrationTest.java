package com.example.hieuthuoc.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hieuthuoc.dto.DanhMucThuocDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DanhMucThuocControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetAll_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(5));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetDanhMucAnhLoaiThuoc_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/get_danh_muc_and_loai_thuoc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(5))
                .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kháng sinh"))
                .andExpect(jsonPath("$.data[0].loaiThuocs").isArray());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSearchByTenDanhMuc_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/search_by_ten_danh_muc")
                .param("tenDanhMuc", "kháng sinh"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(1))
                .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kháng sinh"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSearchByTenDanhMuc_NoResults() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/search_by_ten_danh_muc")
                .param("tenDanhMuc", "Không tồn tại"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(0));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_Success() throws Exception {
        // Arrange
        DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setTenDanhMuc("Thuốc bổ");
        danhMucThuocDTO.setMoTa("Các loại thuốc bổ");

        // Act & Assert
        mockMvc.perform(post("/danhmucthuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(201))
                .andExpect(jsonPath("$.data.tenDanhMuc").value("Thuốc bổ"))
                .andExpect(jsonPath("$.data.moTa").value("Các loại thuốc bổ"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_DuplicateName() throws Exception {
        // Arrange
        DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setTenDanhMuc("Thuốc kháng sinh"); // Tên đã tồn tại
        danhMucThuocDTO.setMoTa("Các loại thuốc kháng sinh");

        // Act & Assert
        mockMvc.perform(post("/danhmucthuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(409))
                .andExpect(jsonPath("$.msg").value("Danh mục thuốc đã tồn tại"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdate_Success() throws Exception {
        // Arrange
        DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setId(1);
        danhMucThuocDTO.setTenDanhMuc("Thuốc kháng sinh Updated");
        danhMucThuocDTO.setMoTa("Các loại thuốc kháng sinh đã cập nhật");

        // Act & Assert
        mockMvc.perform(put("/danhmucthuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenDanhMuc").value("Thuốc kháng sinh Updated"))
                .andExpect(jsonPath("$.data.moTa").value("Các loại thuốc kháng sinh đã cập nhật"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdate_NotFound() throws Exception {
        // Arrange
        DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
        danhMucThuocDTO.setId(999);
        danhMucThuocDTO.setTenDanhMuc("Danh mục thuốc không tồn tại");
        danhMucThuocDTO.setMoTa("Mô tả danh mục thuốc không tồn tại");

        // Act & Assert
        mockMvc.perform(put("/danhmucthuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy danh mục thuốc"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDelete_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/danhmucthuoc/delete")
                .param("id", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200));

        // Verify danh mục thuốc đã bị xóa
        mockMvc.perform(get("/danhmucthuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(4));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDelete_NotFound() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/danhmucthuoc/delete")
                .param("id", "999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy danh mục thuốc"));
    }
}
