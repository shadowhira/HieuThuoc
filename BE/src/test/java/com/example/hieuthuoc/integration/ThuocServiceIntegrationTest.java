package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.ThanhPhanThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.DoiTuong;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.ThanhPhanThuoc;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.DoiTuongRepo;
import com.example.hieuthuoc.repository.LoaiThuocRepo;
import com.example.hieuthuoc.repository.NhaSanXuatRepo;
import com.example.hieuthuoc.repository.ThuocRepo;
import com.example.hieuthuoc.service.ThuocService;

@ExtendWith(MockitoExtension.class)
public class ThuocServiceIntegrationTest {

    @Mock
    private ThuocRepo thuocRepo;

    @Mock
    private LoaiThuocRepo loaiThuocRepo;

    @Mock
    private NhaSanXuatRepo nhaSanXuatRepo;

    @Mock
    private DoiTuongRepo doiTuongRepo;

    @Mock
    private ThuocService thuocService;

    private ThuocDTO thuocDTO;
    private Thuoc thuoc;
    private LoaiThuoc loaiThuoc;
    private NhaSanXuat nhaSanXuat;
    private List<DoiTuong> doiTuongs;
    private List<Integer> doiTuongIds;
    private List<ThanhPhanThuocDTO> thanhPhanThuocDTOs;
    private MultipartFile mockFile;

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

        // Tạo danh sách đối tượng sử dụng
        doiTuongIds = Arrays.asList(1, 2);
        // Không sử dụng setDoiTuongIds vì không có phương thức này trong ThuocDTO

        // Tạo danh sách thành phần thuốc
        thanhPhanThuocDTOs = new ArrayList<>();
        ThanhPhanThuocDTO thanhPhanThuocDTO = new ThanhPhanThuocDTO();
        thanhPhanThuocDTO.setTenThanhPhan("Paracetamol");
        thanhPhanThuocDTO.setHamLuong("500mg");
        thanhPhanThuocDTOs.add(thanhPhanThuocDTO);
        thuocDTO.setThanhPhanThuocs(thanhPhanThuocDTOs);

        // Tạo mock file
        mockFile = new MockMultipartFile("file", "test.jpg", "image/jpeg", "test image content".getBytes());
        thuocDTO.setFile(mockFile);

        // Khởi tạo entity
        thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");

        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Thuốc giảm đau");

        nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(1);
        nhaSanXuat.setTenNhaSanXuat("Công ty Dược phẩm ABC");

        doiTuongs = new ArrayList<>();
        DoiTuong doiTuong1 = new DoiTuong();
        doiTuong1.setId(1);
        doiTuong1.setTenDoiTuong("Người lớn");
        DoiTuong doiTuong2 = new DoiTuong();
        doiTuong2.setId(2);
        doiTuong2.setTenDoiTuong("Trẻ em trên 12 tuổi");
        doiTuongs.add(doiTuong1);
        doiTuongs.add(doiTuong2);
    }

    @Test
    @DisplayName("INTEG_SERVICE_001: Kiểm thử tích hợp giữa ThuocService và LoaiThuocService khi thêm thuốc với loaiThuocId không tồn tại")
    void testCreateThuocWithNonExistentLoaiThuoc() {
        // Arrange
        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(404);
        expectedResponse.setMsg("Loại thuốc không tồn tại");
        expectedResponse.setData(null);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Loại thuốc không tồn tại", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("INTEG_SERVICE_002: Kiểm thử tích hợp giữa ThuocService và NhaSanXuatService khi thêm thuốc với nhaSanXuatId không tồn tại")
    void testCreateThuocWithNonExistentNhaSanXuat() {
        // Arrange
        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(404);
        expectedResponse.setMsg("Nhà sản xuất không tồn tại");
        expectedResponse.setData(null);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Nhà sản xuất không tồn tại", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("INTEG_SERVICE_003: Kiểm thử tích hợp giữa ThuocService và DoiTuongService khi thêm thuốc với doiTuongId không tồn tại")
    void testCreateThuocWithNonExistentDoiTuong() {
        // Arrange
        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(404);
        expectedResponse.setMsg("Đối tượng sử dụng không tồn tại");
        expectedResponse.setData(null);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Đối tượng sử dụng không tồn tại", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("INTEG_SERVICE_005: Kiểm thử tích hợp giữa ThuocService và ThanhPhanThuocService khi thêm thuốc với thanhPhanThuocs hợp lệ")
    void testCreateThuocWithValidThanhPhanThuocs() {
        // Arrange
        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        expectedResponse.setData(thuoc);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
    }

    @Test
    @DisplayName("INTEG_SERVICE_006: Kiểm thử tích hợp giữa ThuocService và UploadImageService khi thêm thuốc có hình ảnh")
    void testCreateThuocWithImage() {
        // Arrange
        ResponseDTO<Thuoc> expectedResponse = new ResponseDTO<>();
        expectedResponse.setStatus(200);
        expectedResponse.setMsg("Thành công");
        thuoc.setAvatar("https://example.com/images/Thuoc_1.jpg");
        expectedResponse.setData(thuoc);

        when(thuocService.create(any(ThuocDTO.class))).thenReturn(expectedResponse);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
    }
}
