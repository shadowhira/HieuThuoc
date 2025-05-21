package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import com.example.hieuthuoc.dto.DoiTuongDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.ThanhPhanThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.entity.DoiTuong;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.ThanhPhanThuoc;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.DoiTuongRepo;
import com.example.hieuthuoc.repository.LoaiThuocRepo;
import com.example.hieuthuoc.repository.NhaSanXuatRepo;
import com.example.hieuthuoc.repository.ThanhPhanThuocRepo;
import com.example.hieuthuoc.repository.ThuocRepo;

/**
 * Kiểm thử đơn vị cho ThuocService - Xử lý đầu vào
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ThuocServiceInputTest {

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
    private ModelMapper modelMapper;

    @Mock
    private UploadImageService uploadImageService;

    @InjectMocks
    private ThuocServiceImpl thuocService;

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
    }

    @Test
    void testCreate_WithEmptyTenThuoc() {
        // Arrange
        ThuocDTO invalidThuocDTO = new ThuocDTO();
        invalidThuocDTO.setTenThuoc(""); // Tên thuốc trống
        invalidThuocDTO.setMaThuoc("TEST001");
        invalidThuocDTO.setLoaiThuocId(1);
        invalidThuocDTO.setNhaSanXuatId(1);
        invalidThuocDTO.setGiaNhap(5000.0);
        invalidThuocDTO.setGiaBan(7000.0);
        invalidThuocDTO.setSoLuongTon(100);
        invalidThuocDTO.setDoiTuongs(doiTuongDTOs);
        invalidThuocDTO.setThanhPhanThuocs(thanhPhanThuocDTOs);

        Thuoc invalidThuoc = new Thuoc();
        invalidThuoc.setTenThuoc("");
        invalidThuoc.setMaThuoc("TEST001");
        invalidThuoc.setGiaNhap(5000.0);
        invalidThuoc.setGiaBan(7000.0);
        invalidThuoc.setSoLuongTon(100);
        invalidThuoc.setLoaiThuoc(loaiThuoc);
        invalidThuoc.setNhaSanXuat(nhaSanXuat);
        invalidThuoc.setDoiTuongs(doiTuongs);
        invalidThuoc.setThanhPhanThuocs(thanhPhanThuocs);

        when(thuocRepo.existsByMaThuoc(anyString())).thenReturn(false);
        when(thuocRepo.existsByTenThuoc(anyString())).thenReturn(false);
        when(loaiThuocRepo.findById(anyInt())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(anyInt())).thenReturn(Optional.of(nhaSanXuat));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(invalidThuoc);
        when(modelMapper.map(any(ThanhPhanThuocDTO.class), eq(ThanhPhanThuoc.class))).thenReturn(thanhPhanThuocs.get(0));
        when(doiTuongRepo.findById(anyInt())).thenReturn(Optional.of(doiTuongs.get(0)));

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(invalidThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Tên thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    void testCreate_WithEmptyMaThuoc() {
        // Arrange
        ThuocDTO invalidThuocDTO = new ThuocDTO();
        invalidThuocDTO.setTenThuoc("Test Thuoc");
        invalidThuocDTO.setMaThuoc(""); // Mã thuốc trống
        invalidThuocDTO.setLoaiThuocId(1);
        invalidThuocDTO.setNhaSanXuatId(1);
        invalidThuocDTO.setGiaNhap(5000.0);
        invalidThuocDTO.setGiaBan(7000.0);
        invalidThuocDTO.setSoLuongTon(100);
        invalidThuocDTO.setDoiTuongs(doiTuongDTOs);
        invalidThuocDTO.setThanhPhanThuocs(thanhPhanThuocDTOs);

        Thuoc invalidThuoc = new Thuoc();
        invalidThuoc.setTenThuoc("Test Thuoc");
        invalidThuoc.setMaThuoc("");
        invalidThuoc.setGiaNhap(5000.0);
        invalidThuoc.setGiaBan(7000.0);
        invalidThuoc.setSoLuongTon(100);
        invalidThuoc.setLoaiThuoc(loaiThuoc);
        invalidThuoc.setNhaSanXuat(nhaSanXuat);
        invalidThuoc.setDoiTuongs(doiTuongs);
        invalidThuoc.setThanhPhanThuocs(thanhPhanThuocs);

        when(thuocRepo.existsByMaThuoc(anyString())).thenReturn(false);
        when(thuocRepo.existsByTenThuoc(anyString())).thenReturn(false);
        when(loaiThuocRepo.findById(anyInt())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(anyInt())).thenReturn(Optional.of(nhaSanXuat));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(invalidThuoc);
        when(modelMapper.map(any(ThanhPhanThuocDTO.class), eq(ThanhPhanThuoc.class))).thenReturn(thanhPhanThuocs.get(0));
        when(doiTuongRepo.findById(anyInt())).thenReturn(Optional.of(doiTuongs.get(0)));

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(invalidThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Mã thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    void testCreate_WithEmptyThanhPhanThuocs() {
        // Arrange
        ThuocDTO invalidThuocDTO = new ThuocDTO();
        invalidThuocDTO.setTenThuoc("Test Thuoc");
        invalidThuocDTO.setMaThuoc("TEST001");
        invalidThuocDTO.setLoaiThuocId(1);
        invalidThuocDTO.setNhaSanXuatId(1);
        invalidThuocDTO.setGiaNhap(5000.0);
        invalidThuocDTO.setGiaBan(7000.0);
        invalidThuocDTO.setSoLuongTon(100);
        invalidThuocDTO.setThanhPhanThuocs(new ArrayList<>()); // Danh sách thành phần thuốc rỗng
        invalidThuocDTO.setDoiTuongs(doiTuongDTOs);

        Thuoc invalidThuoc = new Thuoc();
        invalidThuoc.setTenThuoc("Test Thuoc");
        invalidThuoc.setMaThuoc("TEST001");
        invalidThuoc.setGiaNhap(5000.0);
        invalidThuoc.setGiaBan(7000.0);
        invalidThuoc.setSoLuongTon(100);
        invalidThuoc.setThanhPhanThuocs(new ArrayList<>());
        invalidThuoc.setLoaiThuoc(loaiThuoc);
        invalidThuoc.setNhaSanXuat(nhaSanXuat);
        invalidThuoc.setDoiTuongs(doiTuongs);

        when(thuocRepo.existsByMaThuoc(anyString())).thenReturn(false);
        when(thuocRepo.existsByTenThuoc(anyString())).thenReturn(false);
        when(loaiThuocRepo.findById(anyInt())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(anyInt())).thenReturn(Optional.of(nhaSanXuat));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(invalidThuoc);
        when(doiTuongRepo.findById(anyInt())).thenReturn(Optional.of(doiTuongs.get(0)));

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(invalidThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Danh sách thành phần thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }

    @Test
    void testCreate_WithEmptyDoiTuongs() {
        // Arrange
        ThuocDTO invalidThuocDTO = new ThuocDTO();
        invalidThuocDTO.setTenThuoc("Test Thuoc");
        invalidThuocDTO.setMaThuoc("TEST001");
        invalidThuocDTO.setLoaiThuocId(1);
        invalidThuocDTO.setNhaSanXuatId(1);
        invalidThuocDTO.setGiaNhap(5000.0);
        invalidThuocDTO.setGiaBan(7000.0);
        invalidThuocDTO.setSoLuongTon(100);
        invalidThuocDTO.setThanhPhanThuocs(thanhPhanThuocDTOs);
        invalidThuocDTO.setDoiTuongs(new ArrayList<>()); // Danh sách đối tượng sử dụng rỗng

        Thuoc invalidThuoc = new Thuoc();
        invalidThuoc.setTenThuoc("Test Thuoc");
        invalidThuoc.setMaThuoc("TEST001");
        invalidThuoc.setGiaNhap(5000.0);
        invalidThuoc.setGiaBan(7000.0);
        invalidThuoc.setSoLuongTon(100);
        invalidThuoc.setThanhPhanThuocs(thanhPhanThuocs);
        invalidThuoc.setDoiTuongs(new ArrayList<>());
        invalidThuoc.setLoaiThuoc(loaiThuoc);
        invalidThuoc.setNhaSanXuat(nhaSanXuat);

        when(thuocRepo.existsByMaThuoc(anyString())).thenReturn(false);
        when(thuocRepo.existsByTenThuoc(anyString())).thenReturn(false);
        when(loaiThuocRepo.findById(anyInt())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(anyInt())).thenReturn(Optional.of(nhaSanXuat));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(invalidThuoc);
        when(modelMapper.map(any(ThanhPhanThuocDTO.class), eq(ThanhPhanThuoc.class))).thenReturn(thanhPhanThuocs.get(0));

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(invalidThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Danh sách đối tượng sử dụng không hợp lệ", response.getMsg());
        assertNull(response.getData());
    }
}
