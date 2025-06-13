package com.example.hieuthuoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.hieuthuoc.dto.DoanhThuDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.repository.DonHangRepo;

/**
 * Unit tests for BaoCaoController
 */
public class BaoCaoControllerTest {

    @Mock
    private DonHangRepo donHangRepo;

    @InjectMocks
    private BaoCaoController baoCaoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for doanhThuTheoNgay method with data
     * TC-BE-BC-001: Kiểm tra phương thức trả về dữ liệu doanh thu theo ngày thành công
     */
    @Test
    public void testDoanhThuTheoNgay_Success() {
        // Arrange
        Date ngay = new Date();
        List<DoanhThuDTO> expectedData = Arrays.asList(
                new DoanhThuDTO(8, 25000.0, 1L, 0L),
                new DoanhThuDTO(10, 15000.0, 1L, 0L),
                new DoanhThuDTO(14, 30000.0, 1L, 0L),
                new DoanhThuDTO(16, 12000.0, 1L, 0L),
                new DoanhThuDTO(19, 25000.0, 1L, 0L),
                new DoanhThuDTO(21, 16000.0, 1L, 0L),
                new DoanhThuDTO(23, 24000.0, 1L, 0L));

        when(donHangRepo.doanhThuTheoNgay(ngay)).thenReturn(expectedData);

        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoNgay(ngay);

        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoNgay(ngay);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }

    /**
     * Test case for doanhThuTheoNgay method with empty data
     * TC-BE-BC-002: Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu
     */
    @Test
    public void testDoanhThuTheoNgay_EmptyData() {
        // Arrange
        Date ngay = new Date();
        List<DoanhThuDTO> expectedData = Collections.emptyList();

        when(donHangRepo.doanhThuTheoNgay(ngay)).thenReturn(expectedData);

        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoNgay(ngay);

        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoNgay(ngay);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }

    /**
     * Test case for doanhThuTheoThang method with data
     * TC-BE-BC-004: Kiểm tra phương thức trả về dữ liệu doanh thu theo tháng thành công
     */
    @Test
    public void testDoanhThuTheoThang_Success() {
        // Arrange
        int nam = 2024;
        int thang = 1;
        List<DoanhThuDTO> expectedData = Arrays.asList(
                new DoanhThuDTO(5, 25000.0, 1L, 0L),
                new DoanhThuDTO(10, 15000.0, 1L, 0L),
                new DoanhThuDTO(12, 30000.0, 1L, 0L),
                new DoanhThuDTO(15, 12000.0, 1L, 0L),
                new DoanhThuDTO(20, 25000.0, 1L, 0L),
                new DoanhThuDTO(25, 16000.0, 1L, 0L),
                new DoanhThuDTO(30, 24000.0, 1L, 0L));

        when(donHangRepo.doanhThuTheoThang(nam, thang)).thenReturn(expectedData);

        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoThang(nam, thang);

        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoThang(nam, thang);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }

    /**
     * Test case for doanhThuTheoThang method with empty data
     * TC-BE-BC-005: Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu
     */
    @Test
    public void testDoanhThuTheoThang_EmptyData() {
        // Arrange
        int nam = 2024;
        int thang = 1;
        List<DoanhThuDTO> expectedData = Collections.emptyList();

        when(donHangRepo.doanhThuTheoThang(nam, thang)).thenReturn(expectedData);

        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoThang(nam, thang);

        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoThang(nam, thang);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }

    /**
     * Test case for doanhThuTheoNam method with data
     * TC-BE-BC-007: Kiểm tra phương thức trả về dữ liệu doanh thu theo năm thành công
     */
    @Test
    public void testDoanhThuTheoNam_Success() {
        // Arrange
        int nam = 2024;
        List<DoanhThuDTO> expectedData = Arrays.asList(
                new DoanhThuDTO(1, 147000.0, 7L, 0L),
                new DoanhThuDTO(2, 95000.0, 5L, 1L),
                new DoanhThuDTO(3, 210000.0, 10L, 0L),
                new DoanhThuDTO(4, 180000.0, 8L, 2L),
                new DoanhThuDTO(5, 250000.0, 12L, 1L),
                new DoanhThuDTO(6, 160000.0, 7L, 0L));

        when(donHangRepo.doanhThuTheoNam(nam)).thenReturn(expectedData);

        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoNam(nam);

        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoNam(nam);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }

    /**
     * Test case for doanhThuTheoNam method with empty data
     * TC-BE-BC-008: Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu
     */
    @Test
    public void testDoanhThuTheoNam_EmptyData() {
        // Arrange
        int nam = 2024;
        List<DoanhThuDTO> expectedData = Collections.emptyList();

        when(donHangRepo.doanhThuTheoNam(nam)).thenReturn(expectedData);

        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoNam(nam);

        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoNam(nam);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }
}
