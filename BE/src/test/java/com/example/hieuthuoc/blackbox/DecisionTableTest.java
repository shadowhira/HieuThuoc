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
 * Kiểm thử hộp đen - Bảng quyết định
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DecisionTableTest {

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
    @DisplayName("DT_001: Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithAllValidInputs() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        Thuoc testThuoc = createBasicThuoc();

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
    }

    @Test
    @DisplayName("DT_002: Kiểm thử thêm thuốc với (tên không hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithInvalidTenThuoc() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc(""); // Tên thuốc không hợp lệ

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc("");

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Tên thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("DT_003: Kiểm thử thêm thuốc với (tên hợp lệ, mã không hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithInvalidMaThuoc() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setMaThuoc(""); // Mã thuốc không hợp lệ

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setMaThuoc("");

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Mã thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("DT_004: Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập không hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithInvalidGiaNhap() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaNhap(-1.0); // Giá nhập không hợp lệ

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
    @DisplayName("DT_005: Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán không hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithInvalidGiaBan() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaBan(-1.0); // Giá bán không hợp lệ

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setGiaBan(-1.0);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Giá bán không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("DT_006: Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng không hợp lệ)")
    void testCreateWithInvalidHanSuDung() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(yesterday); // Hạn sử dụng không hợp lệ (quá khứ)

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
    @DisplayName("DT_007: Kiểm thử thêm thuốc với (tên không hợp lệ, mã không hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithInvalidTenAndMaThuoc() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc(""); // Tên thuốc không hợp lệ
        testThuocDTO.setMaThuoc(""); // Mã thuốc không hợp lệ

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc("");
        testThuoc.setMaThuoc("");

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Tên thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("DT_008: Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập không hợp lệ, giá bán không hợp lệ, hạn sử dụng hợp lệ)")
    void testCreateWithInvalidGiaNhapAndGiaBan() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setGiaNhap(-1.0); // Giá nhập không hợp lệ
        testThuocDTO.setGiaBan(-1.0); // Giá bán không hợp lệ

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setGiaNhap(-1.0);
        testThuoc.setGiaBan(-1.0);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Giá nhập không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("DT_009: Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng không hợp lệ, loại thuốc không tồn tại)")
    void testCreateWithInvalidHanSuDungAndLoaiThuoc() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setHanSuDung(yesterday); // Hạn sử dụng không hợp lệ (quá khứ)
        testThuocDTO.setLoaiThuocId(999); // Loại thuốc không tồn tại

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setHanSuDung(yesterday);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);
        when(loaiThuocRepo.findById(999)).thenReturn(Optional.empty());

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Hạn sử dụng không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    @DisplayName("DT_010: Kiểm thử thêm thuốc với (tên không hợp lệ, mã không hợp lệ, giá nhập không hợp lệ, giá bán không hợp lệ, hạn sử dụng không hợp lệ)")
    void testCreateWithAllInvalidInputs() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setTenThuoc(""); // Tên thuốc không hợp lệ
        testThuocDTO.setMaThuoc(""); // Mã thuốc không hợp lệ
        testThuocDTO.setGiaNhap(-1.0); // Giá nhập không hợp lệ
        testThuocDTO.setGiaBan(-1.0); // Giá bán không hợp lệ
        testThuocDTO.setHanSuDung(yesterday); // Hạn sử dụng không hợp lệ (quá khứ)

        Thuoc testThuoc = createBasicThuoc();
        testThuoc.setTenThuoc("");
        testThuoc.setMaThuoc("");
        testThuoc.setGiaNhap(-1.0);
        testThuoc.setGiaBan(-1.0);
        testThuoc.setHanSuDung(yesterday);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(testThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Tên thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
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
