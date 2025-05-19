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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.service.ThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ThuocControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ThuocService thuocService;

    @InjectMocks
    private ThuocController thuocController;

    private ObjectMapper objectMapper;
    private Thuoc thuoc;
    private ThuocDTO thuocDTO;
    private SearchThuocDTO searchThuocDTO;
    private SearchDTO searchDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(thuocController).build();
        objectMapper = new ObjectMapper();

        // Khởi tạo dữ liệu mẫu
        thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");

        thuocDTO = new ThuocDTO();
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg");
        thuocDTO.setMaThuoc("PARA500");

        searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("Paracetamol");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);

        searchDTO = new SearchDTO();
        searchDTO.setCurrentPage(0);
        searchDTO.setSize(10);
    }

    @Test
    void testGetById_Success() throws Exception {
        // Arrange
        ResponseDTO<Thuoc> responseDTO = ResponseDTO.<Thuoc>builder()
                .status(200)
                .msg("Thành công")
                .data(thuoc)
                .build();

        when(thuocService.getById(1)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/thuoc/get")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"));

        verify(thuocService, times(1)).getById(1);
    }

    @Test
    void testSearch_Success() throws Exception {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc);

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setTotalElements(1L);
        pageDTO.setTotalPages(1);
        pageDTO.setData(thuocList);

        ResponseDTO<PageDTO<List<Thuoc>>> responseDTO = ResponseDTO.<PageDTO<List<Thuoc>>>builder()
                .status(200)
                .msg("Thành công")
                .data(pageDTO)
                .build();

        when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/thuoc/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchThuocDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.totalElements").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.totalPages").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data[0].tenThuoc").value("Paracetamol 500mg"))
                .andReturn();

        verify(thuocService, times(1)).search(any(SearchThuocDTO.class));
    }

    @Test
    void testGetThuocBanChay_Success() throws Exception {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc);

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setTotalElements(1L);
        pageDTO.setTotalPages(1);
        pageDTO.setData(thuocList);

        ResponseDTO<PageDTO<List<Thuoc>>> responseDTO = ResponseDTO.<PageDTO<List<Thuoc>>>builder()
                .status(200)
                .msg("Thành công")
                .data(pageDTO)
                .build();

        when(thuocService.getThuocBanChay(any(SearchDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/thuoc/get_thuoc_ban_chay")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.totalElements").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.totalPages").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data[0].tenThuoc").value("Paracetamol 500mg"));

        verify(thuocService, times(1)).getThuocBanChay(any(SearchDTO.class));
    }

    @Test
    void testCreate_Success() throws Exception {
        // Arrange
        ResponseDTO<Thuoc> responseDTO = ResponseDTO.<Thuoc>builder()
                .status(200)
                .msg("Thành công")
                .data(thuoc)
                .build();

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(responseDTO);

        MockMultipartFile thuocDTOFile = new MockMultipartFile(
                "thuocDTO",
                "",
                "application/json",
                objectMapper.writeValueAsString(thuocDTO).getBytes());

        MockMultipartFile imageFile = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image content".getBytes());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.multipart("/thuoc/create")
                .file(thuocDTOFile)
                .file(imageFile))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"));

        verify(thuocService, times(1)).create(any(ThuocDTO.class));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Arrange
        ResponseDTO<Thuoc> responseDTO = ResponseDTO.<Thuoc>builder()
                .status(200)
                .msg("Thành công")
                .data(thuoc)
                .build();

        when(thuocService.update(any(ThuocDTO.class))).thenReturn(responseDTO);

        MockMultipartFile thuocDTOFile = new MockMultipartFile(
                "thuocDTO",
                "",
                "application/json",
                objectMapper.writeValueAsString(thuocDTO).getBytes());

        MockMultipartFile imageFile = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image content".getBytes());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.multipart("/thuoc/update")
                .file(thuocDTOFile)
                .file(imageFile)
                .with(request -> {
                    request.setMethod("PUT");
                    return request;
                }))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"));

        verify(thuocService, times(1)).update(any(ThuocDTO.class));
    }

    @Test
    void testDelete_Success() throws Exception {
        // Arrange
        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thành công")
                .build();

        when(thuocService.delete(1)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/thuoc/delete")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Thành công"));

        verify(thuocService, times(1)).delete(1);
    }
}
