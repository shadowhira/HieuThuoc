package com.example.hieuthuoc.integration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.hieuthuoc.controller.ThuocController;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.service.ThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test tích hợp đơn giản nhất cho ThuocController
 * Không sử dụng Spring Security
 */
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class VerySimpleThuocControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ThuocService thuocService;

    @InjectMocks
    private ThuocController thuocController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(thuocController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
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
                .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"))
                .andExpect(jsonPath("$.data.maThuoc").value("PARA500"));
    }

    @Test
    public void testSearch_Success() throws Exception {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        Thuoc thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");
        thuocList.add(thuoc);
        
        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setTotalElements(1L);
        pageDTO.setTotalPages(1);
        pageDTO.setData(thuocList);
        
        ResponseDTO<PageDTO<List<Thuoc>>> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(pageDTO);
        
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("Paracetamol");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);
        
        when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(responseDTO);
        
        // Act & Assert
        mockMvc.perform(post("/thuoc/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.totalElements").value(1))
                .andExpect(jsonPath("$.data.data[0].tenThuoc").value("Paracetamol 500mg"));
    }

    @Test
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
}
