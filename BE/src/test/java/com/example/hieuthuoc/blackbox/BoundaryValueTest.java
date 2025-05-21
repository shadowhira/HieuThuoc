package com.example.hieuthuoc.blackbox;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import com.example.hieuthuoc.dto.DoiTuongDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.ThanhPhanThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.DoiTuong;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.ThanhPhanThuoc;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.DoiTuongRepo;
import com.example.hieuthuoc.repository.DoiTuongSdThuocRepo;
import com.example.hieuthuoc.repository.LoaiThuocRepo;
import com.example.hieuthuoc.repository.NhaSanXuatRepo;
import com.example.hieuthuoc.repository.ThanhPhanThuocRepo;
import com.example.hieuthuoc.repository.ThuocRepo;
import com.example.hieuthuoc.service.ThuocService;
import com.example.hieuthuoc.service.UploadImageService;

/**
 * Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BoundaryValueTest {

    @Mock
    private ThuocRepo thuocRepo;

    @Mock
    private LoaiThuocRepo loaiThuocRepo;

    @Mock
    private NhaSanXuatRepo nhaSanXuatRepo;

    @Mock
    private DoiTuongRepo doiTuongRepo;

    @Mock
    private ThanhPhanThuocRepo thanhPhanThuocRepo;

    @Mock
    private DoiTuongSdThuocRepo doiTuongSdThuocRepo;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UploadImageService uploadImageService;

    @Mock
    private ThuocService thuocService;

    private Thuoc thuoc;
    private ThuocDTO thuocDTO;
    private LoaiThuoc loaiThuoc;
    private NhaSanXuat nhaSanXuat;
    private List<DoiTuong> doiTuongs;
    private List<DoiTuongDTO> doiTuongDTOs;
    private List<ThanhPhanThuoc> thanhPhanThuocs;
    private List<ThanhPhanThuocDTO> thanhPhanThuocDTOs;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho các test case
        thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");
        thuoc.setMaVach("8936059580011");
        thuoc.setDonVi("Viên");
        thuoc.setCheBao("Viên nén bao phim");
        thuoc.setQuyCach("Hộp 10 vỉ x 10 viên");
        thuoc.setSoDangKy("VD-12345");
        thuoc.setHanSuDung(new Date());
        thuoc.setGiaNhap(5000.0);
        thuoc.setGiaBan(7000.0);
        thuoc.setSoLuongTon(100);
        thuoc.setNguongCanhBao(20);
        thuoc.setCongDung("Giảm đau, hạ sốt");
        thuoc.setChiDinh("Đau đầu, đau răng, đau cơ");
        thuoc.setChongChiDinh("Mẫn cảm với paracetamol");
        thuoc.setHuongDanSuDung("Uống 1-2 viên/lần, 3-4 lần/ngày");
        thuoc.setMoTaNgan("Thuốc giảm đau, hạ sốt thông dụng");
        thuoc.setAvatar("paracetamol.jpg");
        thuoc.setTrangThai(true);
        thuoc.setGhiChu("");

        thuocDTO = new ThuocDTO();
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg");
        thuocDTO.setMaThuoc("PARA500");
        thuocDTO.setMaVach("8936059580011");
        thuocDTO.setLoaiThuocId(1);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setCheBao("Viên nén bao phim");
        thuocDTO.setQuyCach("Hộp 10 vỉ x 10 viên");
        thuocDTO.setSoDangKy("VD-12345");
        thuocDTO.setHanSuDung(new Date());
        thuocDTO.setGiaNhap(5000.0);
        thuocDTO.setGiaBan(7000.0);
        thuocDTO.setSoLuongTon(100);
        thuocDTO.setNguongCanhBao(20);
        thuocDTO.setCongDung("Giảm đau, hạ sốt");
        thuocDTO.setChiDinh("Đau đầu, đau răng, đau cơ");
        thuocDTO.setChongChiDinh("Mẫn cảm với paracetamol");
        thuocDTO.setHuongDanSuDung("Uống 1-2 viên/lần, 3-4 lần/ngày");
        thuocDTO.setMoTaNgan("Thuốc giảm đau, hạ sốt thông dụng");
        thuocDTO.setAvatar("paracetamol.jpg");
        thuocDTO.setTrangThai(true);
        thuocDTO.setGhiChu("");

        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Giảm đau không steroid");
        loaiThuoc.setMoTa("Nhóm giảm đau không steroid");

        nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(1);
        nhaSanXuat.setTenNhaSanXuat("Công ty Dược phẩm ABC");

        doiTuongs = new ArrayList<>();
        DoiTuong doiTuong1 = new DoiTuong();
        doiTuong1.setId(1);
        doiTuong1.setTenDoiTuong("Người lớn");
        doiTuongs.add(doiTuong1);

        doiTuongDTOs = new ArrayList<>();
        DoiTuongDTO doiTuongDTO1 = new DoiTuongDTO();
        doiTuongDTO1.setId(1);
        doiTuongDTO1.setTenDoiTuong("Người lớn");
        doiTuongDTOs.add(doiTuongDTO1);

        thanhPhanThuocs = new ArrayList<>();
        ThanhPhanThuoc thanhPhanThuoc1 = new ThanhPhanThuoc();
        thanhPhanThuoc1.setId(1);
        thanhPhanThuoc1.setTenThanhPhan("Paracetamol");
        thanhPhanThuoc1.setHamLuong("500mg");
        thanhPhanThuoc1.setDonVi("mg");
        thanhPhanThuoc1.setThuoc(thuoc);
        thanhPhanThuocs.add(thanhPhanThuoc1);

        thanhPhanThuocDTOs = new ArrayList<>();
        ThanhPhanThuocDTO thanhPhanThuocDTO1 = new ThanhPhanThuocDTO();
        thanhPhanThuocDTO1.setId(1);
        thanhPhanThuocDTO1.setTenThanhPhan("Paracetamol");
        thanhPhanThuocDTO1.setHamLuong("500mg");
        thanhPhanThuocDTO1.setDonVi("mg");
        thanhPhanThuocDTO1.setThuocId(1);
        thanhPhanThuocDTOs.add(thanhPhanThuocDTO1);

        thuoc.setLoaiThuoc(loaiThuoc);
        thuoc.setNhaSanXuat(nhaSanXuat);
        thuoc.setDoiTuongs(doiTuongs);
        thuoc.setThanhPhanThuocs(thanhPhanThuocs);

        thuocDTO.setDoiTuongs(doiTuongDTOs);
        thuocDTO.setThanhPhanThuocs(thanhPhanThuocDTOs);

        // Cấu hình mock mặc định
        when(thuocRepo.existsByMaThuoc(anyString())).thenReturn(false);
        when(thuocRepo.existsByTenThuoc(anyString())).thenReturn(false);
        when(loaiThuocRepo.findById(anyInt())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(anyInt())).thenReturn(Optional.of(nhaSanXuat));
        when(doiTuongRepo.findById(anyInt())).thenReturn(Optional.of(doiTuongs.get(0)));
        when(modelMapper.map(any(ThanhPhanThuocDTO.class), eq(ThanhPhanThuoc.class))).thenReturn(thanhPhanThuocs.get(0));
    }

    @Test
    @DisplayName("BV_001: Kiểm thử thêm thuốc với tên thuốc = 1 ký tự (biên dưới)")
    void testCreateWithTenThuoc1Character() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc("A"); // 1 ký tự

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc("A");

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("A", response.getData().getTenThuoc());
    }

    @Test
    @DisplayName("BV_002: Kiểm thử thêm thuốc với tên thuốc = 2 ký tự (biên dưới + 1)")
    void testCreateWithTenThuoc2Characters() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc("AB"); // 2 ký tự

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc("AB");

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("AB", response.getData().getTenThuoc());
    }

    @Test
    @DisplayName("BV_003: Kiểm thử thêm thuốc với tên thuốc = 99 ký tự (biên trên - 1)")
    void testCreateWithTenThuoc99Characters() {
        // Arrange
        String tenThuoc99 = "A".repeat(99);
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc(tenThuoc99);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc(tenThuoc99);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(tenThuoc99, response.getData().getTenThuoc());
    }

    @Test
    @DisplayName("BV_004: Kiểm thử thêm thuốc với tên thuốc = 100 ký tự (biên trên)")
    void testCreateWithTenThuoc100Characters() {
        // Arrange
        String tenThuoc100 = "A".repeat(100);
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc(tenThuoc100);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc(tenThuoc100);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(tenThuoc100, response.getData().getTenThuoc());
    }

    @Test
    @DisplayName("BV_005: Kiểm thử thêm thuốc với tên thuốc = 101 ký tự (biên trên + 1)")
    void testCreateWithTenThuoc101Characters() {
        // Arrange
        String tenThuoc101 = "A".repeat(101);
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc(tenThuoc101);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc(tenThuoc101);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Tên thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("BV_006: Kiểm thử thêm thuốc với giá nhập = 0 (biên dưới)")
    void testCreateWithGiaNhap0() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaNhap(0.0);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setGiaNhap(0.0);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(0.0, response.getData().getGiaNhap());
    }

    @Test
    @DisplayName("BV_007: Kiểm thử thêm thuốc với giá nhập = -1 (biên dưới - 1)")
    void testCreateWithGiaNhapNegative() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaNhap(-1.0);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setGiaNhap(-1.0);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Giá nhập không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("BV_008: Kiểm thử thêm thuốc với giá nhập = 999999999 (biên trên)")
    void testCreateWithGiaNhapMax() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaNhap(999999999.0);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setGiaNhap(999999999.0);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(999999999.0, response.getData().getGiaNhap());
    }

    @Test
    @DisplayName("BV_009: Kiểm thử thêm thuốc với giá nhập = 1000000000 (biên trên + 1)")
    void testCreateWithGiaNhapOverMax() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaNhap(1000000000.0);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setGiaNhap(1000000000.0);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Giá nhập không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("BV_010: Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại (biên dưới)")
    void testCreateWithHanSuDungCurrentDay() {
        // Arrange
        Date currentDate = new Date();
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(currentDate);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setHanSuDung(currentDate);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(currentDate, response.getData().getHanSuDung());
    }

    @Test
    @DisplayName("BV_011: Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại - 1 ngày (biên dưới - 1)")
    void testCreateWithHanSuDungYesterday() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(yesterday);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setHanSuDung(yesterday);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Hạn sử dụng không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("BV_012: Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại + 1 ngày (biên dưới + 1)")
    void testCreateWithHanSuDungTomorrow() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date tomorrow = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(tomorrow);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setHanSuDung(tomorrow);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(tomorrow, response.getData().getHanSuDung());
    }

    @Test
    @DisplayName("BV_013: Kiểm thử thêm thuốc với hạn sử dụng = 10 năm sau (biên trên)")
    void testCreateWithHanSuDung10Years() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 10);
        Date tenYearsLater = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(tenYearsLater);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setHanSuDung(tenYearsLater);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(tenYearsLater, response.getData().getHanSuDung());
    }

    @Test
    @DisplayName("BV_014: Kiểm thử thêm thuốc với hạn sử dụng = 10 năm + 1 ngày sau (biên trên + 1)")
    void testCreateWithHanSuDung10YearsPlus1Day() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 10);
        calendar.add(Calendar.DATE, 1);
        Date tenYearsPlus1Day = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(tenYearsPlus1Day);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setHanSuDung(tenYearsPlus1Day);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Hạn sử dụng không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("BV_015: Kiểm thử thêm thuốc với số lượng = 2147483647 (Integer.MAX_VALUE)")
    void testCreateWithSoLuongMaxInteger() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setSoLuongTon(Integer.MAX_VALUE);

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setSoLuongTon(Integer.MAX_VALUE);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(Integer.MAX_VALUE, response.getData().getSoLuongTon());
    }

    // Helper methods
    private ThuocDTO createBasicThuocDTO() {
        ThuocDTO dto = new ThuocDTO();
        dto.setTenThuoc("Test Thuoc");
        dto.setMaThuoc("TEST001");
        dto.setLoaiThuocId(1);
        dto.setNhaSanXuatId(1);
        dto.setGiaNhap(5000.0);
        dto.setGiaBan(7000.0);
        dto.setSoLuongTon(100);
        dto.setHanSuDung(new Date());
        dto.setDoiTuongs(doiTuongDTOs);
        dto.setThanhPhanThuocs(thanhPhanThuocDTOs);
        return dto;
    }

    private Thuoc createBasicThuoc() {
        Thuoc t = new Thuoc();
        t.setTenThuoc("Test Thuoc");
        t.setMaThuoc("TEST001");
        t.setGiaNhap(5000.0);
        t.setGiaBan(7000.0);
        t.setSoLuongTon(100);
        t.setHanSuDung(new Date());
        t.setLoaiThuoc(loaiThuoc);
        t.setNhaSanXuat(nhaSanXuat);
        t.setDoiTuongs(doiTuongs);
        t.setThanhPhanThuocs(thanhPhanThuocs);
        return t;
    }
}
