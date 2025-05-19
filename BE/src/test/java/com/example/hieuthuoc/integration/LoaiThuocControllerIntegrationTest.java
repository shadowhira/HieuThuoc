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

import com.example.hieuthuoc.dto.LoaiThuocDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class LoaiThuocControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetAll_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/loaithuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(8));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSearchByTenLoai_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/loaithuoc/search_by_ten_loai")
                .param("tenLoai", "Kháng sinh"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(3));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSearchByTenLoai_NoResults() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/loaithuoc/search_by_ten_loai")
                .param("tenLoai", "Không tồn tại"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(0));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_Success() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setTenLoai("Thuốc chống dị ứng");
        loaiThuocDTO.setMoTa("Nhóm thuốc điều trị các phản ứng dị ứng");
        loaiThuocDTO.setDanhMucThuocId(2);

        // Act & Assert
        mockMvc.perform(post("/loaithuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(201))
                .andExpect(jsonPath("$.data.tenLoai").value("Thuốc chống dị ứng"))
                .andExpect(jsonPath("$.data.moTa").value("Nhóm thuốc điều trị các phản ứng dị ứng"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_DuplicateName() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setTenLoai("Kháng sinh beta-lactam"); // Tên đã tồn tại
        loaiThuocDTO.setMoTa("Nhóm kháng sinh beta-lactam");
        loaiThuocDTO.setDanhMucThuocId(1);

        // Act & Assert
        mockMvc.perform(post("/loaithuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(409))
                .andExpect(jsonPath("$.msg").value("Loại thuốc đã tồn tại"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_InvalidDanhMucThuoc() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setTenLoai("Thuốc chống dị ứng");
        loaiThuocDTO.setMoTa("Nhóm thuốc điều trị các phản ứng dị ứng");
        loaiThuocDTO.setDanhMucThuocId(999); // ID không tồn tại

        // Act & Assert
        mockMvc.perform(post("/loaithuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdate_Success() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setId(1);
        loaiThuocDTO.setTenLoai("Kháng sinh beta-lactam Updated");
        loaiThuocDTO.setMoTa("Nhóm kháng sinh beta-lactam đã cập nhật");
        loaiThuocDTO.setDanhMucThuocId(1);

        // Act & Assert
        mockMvc.perform(put("/loaithuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenLoai").value("Kháng sinh beta-lactam Updated"))
                .andExpect(jsonPath("$.data.moTa").value("Nhóm kháng sinh beta-lactam đã cập nhật"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdate_NotFound() throws Exception {
        // Arrange
        LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
        loaiThuocDTO.setId(999);
        loaiThuocDTO.setTenLoai("Loại thuốc không tồn tại");
        loaiThuocDTO.setMoTa("Mô tả loại thuốc không tồn tại");
        loaiThuocDTO.setDanhMucThuocId(1);

        // Act & Assert
        mockMvc.perform(put("/loaithuoc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loaiThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy loại thuốc"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDelete_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/loaithuoc/delete")
                .param("id", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200));

        // Verify loại thuốc đã bị xóa
        mockMvc.perform(get("/loaithuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(7));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDelete_NotFound() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/loaithuoc/delete")
                .param("id", "999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy loại thuốc"));
    }
}
