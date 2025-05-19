package com.example.hieuthuoc.integration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hieuthuoc.controller.ThuocController;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.jwt.JwtFilter;
import com.example.hieuthuoc.jwt.JwtService;
import com.example.hieuthuoc.service.ThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ThuocController.class)
@ActiveProfiles("test")
public class ThuocControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ThuocService thuocService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private JwtFilter jwtFilter;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSearch_Success() throws Exception {
        // Arrange
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);

        List<Thuoc> thuocList = new ArrayList<>();

        Thuoc thuoc1 = new Thuoc();
        thuoc1.setId(1);
        thuoc1.setTenThuoc("Paracetamol 500mg");
        thuoc1.setMaThuoc("PARA500");

        Thuoc thuoc2 = new Thuoc();
        thuoc2.setId(2);
        thuoc2.setTenThuoc("Amoxicillin 500mg");
        thuoc2.setMaThuoc("AMOX500");

        thuocList.add(thuoc1);
        thuocList.add(thuoc2);

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setData(thuocList);
        pageDTO.setTotalPages(1);
        pageDTO.setTotalElements(2);

        ResponseDTO<PageDTO<List<Thuoc>>> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(pageDTO);

        when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(post("/thuoc/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.data").isArray())
                .andExpect(jsonPath("$.data.data.length()").value(2));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetById_Success() throws Exception {
        // Arrange
        Thuoc thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");

        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(thuoc);

        when(thuocService.getById(anyInt())).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/thuoc/get")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"))
                .andExpect(jsonPath("$.data.maThuoc").value("PARA500"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetById_NotFound() throws Exception {
        // Arrange
        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(404);
        responseDTO.setMsg("Không tìm thấy thuốc");

        when(thuocService.getById(999)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/thuoc/get")
                .param("id", "999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy thuốc"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_Success() throws Exception {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setTenThuoc("Vitamin C 500mg");
        thuocDTO.setMaThuoc("VITC500");
        thuocDTO.setLoaiThuocId(3);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(6000.0);
        thuocDTO.setGiaBan(9000.0);
        thuocDTO.setSoLuongTon(80);
        thuocDTO.setNguongCanhBao(15);
        thuocDTO.setCongDung("Bổ sung vitamin C");
        thuocDTO.setHuongDanSuDung("Uống 1 viên mỗi ngày");
        thuocDTO.setTrangThai(true);

        MockMultipartFile thuocDTOFile = new MockMultipartFile(
                "thuocDTO",
                "",
                "application/json",
                objectMapper.writeValueAsString(thuocDTO).getBytes()
        );

        MockMultipartFile imageFile = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image content".getBytes()
        );

        Thuoc thuoc = new Thuoc();
        thuoc.setId(3);
        thuoc.setTenThuoc("Vitamin C 500mg");
        thuoc.setMaThuoc("VITC500");

        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(thuoc);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(multipart("/thuoc/create")
                .file(thuocDTOFile)
                .file(imageFile))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenThuoc").value("Vitamin C 500mg"))
                .andExpect(jsonPath("$.data.maThuoc").value("VITC500"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreate_DuplicateMaThuoc() throws Exception {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setTenThuoc("Vitamin E 400IU");
        thuocDTO.setMaThuoc("PARA500"); // Mã thuốc đã tồn tại
        thuocDTO.setLoaiThuocId(3);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(10000.0);
        thuocDTO.setGiaBan(15000.0);
        thuocDTO.setSoLuongTon(80);
        thuocDTO.setNguongCanhBao(15);
        thuocDTO.setCongDung("Bổ sung vitamin E");
        thuocDTO.setHuongDanSuDung("Uống 1 viên mỗi ngày");
        thuocDTO.setTrangThai(true);

        MockMultipartFile thuocDTOFile = new MockMultipartFile(
                "thuocDTO",
                "",
                "application/json",
                objectMapper.writeValueAsString(thuocDTO).getBytes()
        );

        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(409);
        responseDTO.setMsg("Mã thuốc đã tồn tại");

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(multipart("/thuoc/create")
                .file(thuocDTOFile))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(409))
                .andExpect(jsonPath("$.msg").value("Mã thuốc đã tồn tại"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdate_Success() throws Exception {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg Updated");
        thuocDTO.setMaThuoc("PARA500");
        thuocDTO.setLoaiThuocId(2);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(5500.0);
        thuocDTO.setGiaBan(7500.0);
        thuocDTO.setSoLuongTon(120);
        thuocDTO.setNguongCanhBao(25);
        thuocDTO.setCongDung("Giảm đau, hạ sốt");
        thuocDTO.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
        thuocDTO.setTrangThai(true);

        MockMultipartFile thuocDTOFile = new MockMultipartFile(
                "thuocDTO",
                "",
                "application/json",
                objectMapper.writeValueAsString(thuocDTO).getBytes()
        );

        Thuoc thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg Updated");
        thuoc.setMaThuoc("PARA500");

        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(thuoc);

        when(thuocService.update(any(ThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(multipart("/thuoc/update")
                .file(thuocDTOFile)
                .with(request -> {
                    request.setMethod("PUT");
                    return request;
                }))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg Updated"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdate_NotFound() throws Exception {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setId(999);
        thuocDTO.setTenThuoc("Thuốc không tồn tại");
        thuocDTO.setMaThuoc("NOTFOUND");
        thuocDTO.setLoaiThuocId(2);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(5000.0);
        thuocDTO.setGiaBan(7000.0);
        thuocDTO.setSoLuongTon(100);
        thuocDTO.setNguongCanhBao(20);
        thuocDTO.setTrangThai(true);

        MockMultipartFile thuocDTOFile = new MockMultipartFile(
                "thuocDTO",
                "",
                "application/json",
                objectMapper.writeValueAsString(thuocDTO).getBytes()
        );

        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(404);
        responseDTO.setMsg("Không tìm thấy thuốc");

        when(thuocService.update(any(ThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(multipart("/thuoc/update")
                .file(thuocDTOFile)
                .with(request -> {
                    request.setMethod("PUT");
                    return request;
                }))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy thuốc"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDelete_Success() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");

        when(thuocService.delete(anyInt())).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(delete("/thuoc/delete")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDelete_NotFound() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(404);
        responseDTO.setMsg("Không tìm thấy thuốc");

        when(thuocService.delete(999)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(delete("/thuoc/delete")
                .param("id", "999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.msg").value("Không tìm thấy thuốc"));
    }
}
