package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;

import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.service.ThuocService;

@SpringBootTest
@ActiveProfiles("test")
public class ThuocAPIIntegrationTest {

    @MockBean
    private ThuocService thuocService;

    private ThuocDTO thuocDTO;
    private Thuoc thuoc;
    private SearchThuocDTO searchThuocDTO;
    private SearchDTO searchDTO;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu test
        thuocDTO = new ThuocDTO();
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg");
        thuocDTO.setMaThuoc("PARA500");
        thuocDTO.setLoaiThuocId(1);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(5000.0);
        thuocDTO.setGiaBan(7000.0);
        thuocDTO.setSoLuongTon(100);
        thuocDTO.setNguongCanhBao(20);
        thuocDTO.setHanSuDung(new Date());
        thuocDTO.setCongDung("Giảm đau, hạ sốt");
        thuocDTO.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
        thuocDTO.setTrangThai(true);

        thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");
        thuoc.setDonVi("Viên");
        thuoc.setGiaNhap(5000.0);
        thuoc.setGiaBan(7000.0);
        thuoc.setSoLuongTon(100);
        thuoc.setNguongCanhBao(20);
        thuoc.setHanSuDung(new Date());
        thuoc.setCongDung("Giảm đau, hạ sốt");
        thuoc.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
        thuoc.setTrangThai(true);

        searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("Paracetamol");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);
        searchThuocDTO.setLoaiThuoc("Thuốc giảm đau");
        searchThuocDTO.setNhaSanXuat("Công ty Dược phẩm ABC");
        searchThuocDTO.setMinGiaBan(5000.0);
        searchThuocDTO.setMaxGiaBan(10000.0);

        searchDTO = new SearchDTO();
        searchDTO.setKeyWord("");
        searchDTO.setCurrentPage(0);
        searchDTO.setSize(10);
    }

    @Test
    @DisplayName("INTEG_API_001: Kiểm thử tích hợp API thêm thuốc với multipart/form-data")
    void testCreateThuocWithMultipartFormData() {
        // Arrange
        MockMultipartFile imageFile = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image content".getBytes()
        );
        thuocDTO.setFile(imageFile);

        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        expectedResponse.setData(thuoc);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("Paracetamol 500mg", response.getData().getTenThuoc());
        assertEquals("PARA500", response.getData().getMaThuoc());
    }

    @Test
    @DisplayName("INTEG_API_002: Kiểm thử tích hợp API cập nhật thuốc với multipart/form-data")
    void testUpdateThuocWithMultipartFormData() {
        // Arrange
        MockMultipartFile imageFile = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image content".getBytes()
        );
        thuocDTO.setFile(imageFile);

        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        expectedResponse.setData(thuoc);

        when(thuocService.update(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("Paracetamol 500mg", response.getData().getTenThuoc());
        assertEquals("PARA500", response.getData().getMaThuoc());
    }

    @Test
    @DisplayName("INTEG_API_003: Kiểm thử tích hợp API tìm kiếm thuốc với nhiều tiêu chí")
    void testSearchThuocWithMultipleCriteria() {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc);

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setData(thuocList);
        pageDTO.setTotalPages(1);
        pageDTO.setTotalElements(1);

        ResponseDTO<PageDTO<List<Thuoc>>> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        expectedResponse.setData(pageDTO);

        when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.search(searchThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertNotNull(response.getData().getData());
        assertEquals(1, response.getData().getData().size());
        assertEquals("Paracetamol 500mg", response.getData().getData().get(0).getTenThuoc());
        assertEquals(1, response.getData().getTotalElements());
    }

    @Test
    @DisplayName("INTEG_API_004: Kiểm thử tích hợp API lấy thuốc bán chạy")
    void testGetThuocBanChay() {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc);

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setData(thuocList);
        pageDTO.setTotalPages(1);
        pageDTO.setTotalElements(1);

        ResponseDTO<PageDTO<List<Thuoc>>> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        expectedResponse.setData(pageDTO);

        when(thuocService.getThuocBanChay(any(SearchDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.getThuocBanChay(searchDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertNotNull(response.getData().getData());
        assertEquals(1, response.getData().getData().size());
        assertEquals("Paracetamol 500mg", response.getData().getData().get(0).getTenThuoc());
    }
}
