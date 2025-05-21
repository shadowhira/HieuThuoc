package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.dto.ThanhPhanThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.DoiTuong;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.ThuocRepo;
import com.example.hieuthuoc.service.ThuocService;

@SpringBootTest
@ActiveProfiles("test")
public class ThuocDatabaseIntegrationTest {

    @MockBean
    private ThuocRepo thuocRepo;

    @MockBean
    private ThuocService thuocService;

    private ThuocDTO thuocDTO;
    private Thuoc thuoc;
    private LoaiThuoc loaiThuoc;
    private NhaSanXuat nhaSanXuat;
    private List<DoiTuong> doiTuongs;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu test
        // Tạo loại thuốc
        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Thuốc giảm đau test");

        // Tạo nhà sản xuất
        nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(1);
        nhaSanXuat.setTenNhaSanXuat("Công ty Dược phẩm ABC test");
        nhaSanXuat.setMaNSX("NSX001");
        nhaSanXuat.setDiaChi("Hà Nội");

        // Tạo đối tượng sử dụng
        doiTuongs = new ArrayList<>();
        DoiTuong doiTuong1 = new DoiTuong();
        doiTuong1.setId(1);
        doiTuong1.setTenDoiTuong("Người lớn test");
        doiTuongs.add(doiTuong1);

        DoiTuong doiTuong2 = new DoiTuong();
        doiTuong2.setId(2);
        doiTuong2.setTenDoiTuong("Trẻ em trên 12 tuổi test");
        doiTuongs.add(doiTuong2);

        // Tạo thuốc DTO
        thuocDTO = new ThuocDTO();
        thuocDTO.setTenThuoc("Paracetamol 500mg Test");
        thuocDTO.setMaThuoc("PARA500TEST");
        thuocDTO.setLoaiThuocId(loaiThuoc.getId());
        thuocDTO.setNhaSanXuatId(nhaSanXuat.getId());
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(5000.0);
        thuocDTO.setGiaBan(7000.0);
        thuocDTO.setSoLuongTon(100);
        thuocDTO.setNguongCanhBao(20);
        thuocDTO.setHanSuDung(new Date());
        thuocDTO.setCongDung("Giảm đau, hạ sốt");
        thuocDTO.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
        thuocDTO.setTrangThai(true);

        // Tạo danh sách thành phần thuốc
        List<ThanhPhanThuocDTO> thanhPhanThuocDTOs = new ArrayList<>();
        ThanhPhanThuocDTO thanhPhanThuocDTO = new ThanhPhanThuocDTO();
        thanhPhanThuocDTO.setTenThanhPhan("Paracetamol");
        thanhPhanThuocDTO.setHamLuong("500mg");
        thanhPhanThuocDTOs.add(thanhPhanThuocDTO);
        thuocDTO.setThanhPhanThuocs(thanhPhanThuocDTOs);

        // Tạo thuốc entity
        thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg Test");
        thuoc.setMaThuoc("PARA500TEST");
        thuoc.setLoaiThuoc(loaiThuoc);
        thuoc.setNhaSanXuat(nhaSanXuat);
        thuoc.setDonVi("Viên");
        thuoc.setGiaNhap(5000.0);
        thuoc.setGiaBan(7000.0);
        thuoc.setSoLuongTon(100);
        thuoc.setNguongCanhBao(20);
        thuoc.setHanSuDung(new Date());
        thuoc.setCongDung("Giảm đau, hạ sốt");
        thuoc.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
        thuoc.setTrangThai(true);
        thuoc.setDoiTuongs(doiTuongs);
    }

    @Test
    @DisplayName("INTEG_DB_001: Kiểm thử tích hợp với database khi thêm thuốc")
    void testCreateThuocWithDatabase() {
        // Arrange
        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        expectedResponse.setData(thuoc);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);
        when(thuocRepo.findById(anyInt())).thenReturn(Optional.of(thuoc));

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());

        // Kiểm tra dữ liệu trong database
        Thuoc savedThuoc = thuocRepo.findById(response.getData().getId()).orElse(null);
        assertNotNull(savedThuoc);
        assertEquals(thuocDTO.getTenThuoc(), savedThuoc.getTenThuoc());
        assertEquals(thuocDTO.getMaThuoc(), savedThuoc.getMaThuoc());
        assertEquals(thuocDTO.getGiaNhap(), savedThuoc.getGiaNhap());
        assertEquals(thuocDTO.getGiaBan(), savedThuoc.getGiaBan());
        assertEquals(thuocDTO.getSoLuongTon(), savedThuoc.getSoLuongTon());
    }

    @Test
    @DisplayName("INTEG_DB_002: Kiểm thử tích hợp với database khi cập nhật thuốc")
    void testUpdateThuocWithDatabase() {
        // Arrange
        ResponseDTO<Thuoc> createResponse = new ResponseDTO<>();
        createResponse.setStatus(200);
        createResponse.setMsg("Thành công");
        createResponse.setData(thuoc);

        Thuoc updatedThuoc = new Thuoc();
        updatedThuoc.setId(1);
        updatedThuoc.setTenThuoc("Paracetamol 500mg Updated");
        updatedThuoc.setMaThuoc("PARA500TEST");
        updatedThuoc.setGiaBan(8000.0);

        ResponseDTO<Thuoc> updateResponse = new ResponseDTO<>();
        updateResponse.setStatus(200);
        updateResponse.setMsg("Thành công");
        updateResponse.setData(updatedThuoc);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(createResponse);
        when(thuocService.update(any(ThuocDTO.class))).thenReturn(updateResponse);
        when(thuocRepo.findById(1)).thenReturn(Optional.of(updatedThuoc));

        // Cập nhật thông tin thuốc
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg Updated");
        thuocDTO.setGiaBan(8000.0);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());

        // Kiểm tra dữ liệu trong database
        Thuoc updatedThuocFromDb = thuocRepo.findById(1).orElse(null);
        assertNotNull(updatedThuocFromDb);
        assertEquals(thuocDTO.getTenThuoc(), updatedThuocFromDb.getTenThuoc());
        assertEquals(thuocDTO.getGiaBan(), updatedThuocFromDb.getGiaBan());
    }

    @Test
    @DisplayName("INTEG_DB_003: Kiểm thử tích hợp với database khi xóa thuốc")
    void testDeleteThuocWithDatabase() {
        // Arrange
        ResponseDTO<Thuoc> createResponse = new ResponseDTO<>();
        createResponse.setStatus(200);
        createResponse.setMsg("Thành công");
        createResponse.setData(thuoc);

        ResponseDTO<Void> deleteResponse = new ResponseDTO<>();
        deleteResponse.setStatus(200);
        deleteResponse.setMsg("Thành công");

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(createResponse);
        when(thuocService.delete(anyInt())).thenReturn(deleteResponse);
        when(thuocRepo.findById(1)).thenReturn(Optional.empty());

        // Act
        ResponseDTO<Void> response = thuocService.delete(1);

        // Assert
        assertEquals(200, response.getStatus());

        // Kiểm tra dữ liệu trong database
        Optional<Thuoc> deletedThuoc = thuocRepo.findById(1);
        assertFalse(deletedThuoc.isPresent());
    }

    @Test
    @DisplayName("INTEG_DB_004: Kiểm thử tích hợp với database khi tìm kiếm thuốc")
    void testSearchThuocWithDatabase() {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc);

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setData(thuocList);
        pageDTO.setTotalPages(1);
        pageDTO.setTotalElements(1);

        ResponseDTO<PageDTO<List<Thuoc>>> searchResponse = new ResponseDTO<>();
        searchResponse.setStatus(200);
        searchResponse.setMsg("Thành công");
        searchResponse.setData(pageDTO);

        // Tạo đối tượng tìm kiếm
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("Paracetamol");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);

        when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(searchResponse);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.search(searchThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertNotNull(response.getData().getData());
        assertFalse(response.getData().getData().isEmpty());
        assertEquals(1, response.getData().getData().size());
    }

    @Test
    @DisplayName("INTEG_DB_005: Kiểm thử tích hợp với database khi phân trang danh sách thuốc")
    void testPaginationThuocWithDatabase() {
        // Arrange
        List<Thuoc> thuocList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Thuoc t = new Thuoc();
            t.setId(i);
            t.setTenThuoc("Thuốc Test " + i);
            t.setMaThuoc("TEST" + i);
            thuocList.add(t);
        }

        PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
        pageDTO.setData(thuocList);
        pageDTO.setTotalPages(2);
        pageDTO.setTotalElements(10);

        ResponseDTO<PageDTO<List<Thuoc>>> searchResponse = new ResponseDTO<>();
        searchResponse.setStatus(200);
        searchResponse.setMsg("Thành công");
        searchResponse.setData(pageDTO);

        // Tạo đối tượng tìm kiếm với phân trang
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(5);

        when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(searchResponse);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.search(searchThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertNotNull(response.getData().getData());
        assertEquals(5, response.getData().getData().size());
        assertEquals(10, response.getData().getTotalElements());
        assertEquals(2, response.getData().getTotalPages());
    }
}
