package com.example.hieuthuoc.whitebox;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.hieuthuoc.dto.DoiTuongDTO;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
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
 * Kiểm thử hộp trắng - Kiểm thử đường dẫn
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PathCoverageTest {

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
    @DisplayName("PC_001: Kiểm thử đường dẫn trong phương thức create() khi tất cả điều kiện đều true")
    void testCreatePathAllConditionsTrue() {
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

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).existsByMaThuoc(anyString());
        verify(thuocRepo, times(1)).existsByTenThuoc(anyString());
        verify(loaiThuocRepo, times(1)).findById(anyInt());
        verify(nhaSanXuatRepo, times(1)).findById(anyInt());
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("PC_002: Kiểm thử đường dẫn trong phương thức create() khi điều kiện kiểm tra mã thuốc đã tồn tại là true")
    void testCreatePathMaThuocExists() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();

        when(thuocRepo.existsByMaThuoc(anyString())).thenReturn(true); // Mã thuốc đã tồn tại

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(testThuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Mã thuốc đã tồn tại", response.getMsg());
        assertNull(response.getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).existsByMaThuoc(anyString());
        verify(thuocRepo, never()).existsByTenThuoc(anyString());
        verify(loaiThuocRepo, never()).findById(anyInt());
        verify(nhaSanXuatRepo, never()).findById(anyInt());
        verify(thuocRepo, never()).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("PC_003: Kiểm thử đường dẫn trong phương thức create() khi điều kiện kiểm tra tên thuốc hợp lệ là false")
    void testCreatePathTenThuocInvalid() {
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

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).existsByMaThuoc(anyString());
        verify(thuocRepo, times(1)).existsByTenThuoc(anyString());
        verify(loaiThuocRepo, never()).findById(anyInt());
        verify(nhaSanXuatRepo, never()).findById(anyInt());
        verify(thuocRepo, never()).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("PC_004: Kiểm thử đường dẫn trong phương thức update() khi tất cả điều kiện đều true")
    void testUpdatePathAllConditionsTrue() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setId(1);

        Thuoc existingThuoc = createBasicThuoc();
        existingThuoc.setId(1);

        Thuoc updatedThuoc = createBasicThuoc();
        updatedThuoc.setId(1);
        updatedThuoc.setTenThuoc("Updated Thuoc");

        when(thuocRepo.findById(1)).thenReturn(Optional.of(existingThuoc));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(updatedThuoc);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(updatedThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(testThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("Updated Thuoc", response.getData().getTenThuoc());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).findById(1);
        verify(loaiThuocRepo, times(1)).findById(anyInt());
        verify(nhaSanXuatRepo, times(1)).findById(anyInt());
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("PC_005: Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra ID thuốc tồn tại là false")
    void testUpdatePathThuocNotFound() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setId(999); // ID không tồn tại

        when(thuocRepo.findById(999)).thenReturn(Optional.empty());

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(testThuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Không tìm thấy thuốc", response.getMsg());
        assertNull(response.getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).findById(999);
        verify(loaiThuocRepo, never()).findById(anyInt());
        verify(nhaSanXuatRepo, never()).findById(anyInt());
        verify(thuocRepo, never()).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("PC_006: Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra mã thuốc đã tồn tại là true")
    void testUpdatePathMaThuocExists() {
        // Arrange
        ThuocDTO testThuocDTO = createBasicThuocDTO();
        testThuocDTO.setId(1);
        testThuocDTO.setMaThuoc("EXISTING");

        Thuoc existingThuoc = createBasicThuoc();
        existingThuoc.setId(1);
        existingThuoc.setMaThuoc("ORIGINAL");

        Thuoc anotherThuoc = createBasicThuoc();
        anotherThuoc.setId(2);
        anotherThuoc.setMaThuoc("EXISTING");

        when(thuocRepo.findById(1)).thenReturn(Optional.of(existingThuoc));
        when(thuocRepo.existsByMaThuoc("EXISTING")).thenReturn(true);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(testThuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Mã thuốc đã tồn tại", response.getMsg());
        assertNull(response.getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).findById(1);
        verify(thuocRepo, times(1)).existsByMaThuoc("EXISTING");
        verify(loaiThuocRepo, never()).findById(anyInt());
        verify(nhaSanXuatRepo, never()).findById(anyInt());
        verify(thuocRepo, never()).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("PC_007: Kiểm thử đường dẫn trong phương thức delete() khi điều kiện kiểm tra ID thuốc tồn tại là true")
    void testDeletePathThuocExists() {
        // Arrange
        when(thuocRepo.existsById(1)).thenReturn(true);
        doNothing().when(thuocRepo).deleteById(1);

        // Act
        ResponseDTO<Void> response = thuocService.delete(1);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNull(response.getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).existsById(1);
        verify(thuocRepo, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("PC_008: Kiểm thử đường dẫn trong phương thức delete() khi điều kiện kiểm tra ID thuốc tồn tại là false")
    void testDeletePathThuocNotFound() {
        // Arrange
        when(thuocRepo.existsById(999)).thenReturn(false);

        // Act
        ResponseDTO<Void> response = thuocService.delete(999);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Không tìm thấy thuốc", response.getMsg());
        assertNull(response.getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).existsById(999);
        verify(thuocRepo, never()).deleteById(anyInt());
    }

    @Test
    @DisplayName("PC_009: Kiểm thử đường dẫn trong phương thức search() với nhiều điều kiện tìm kiếm")
    void testSearchPathWithMultipleConditions() {
        // Arrange
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("Paracetamol");
        searchThuocDTO.setLoaiThuoc("Giảm đau");
        searchThuocDTO.setNhaSanXuat("ABC");
        searchThuocDTO.setDanhMucThuoc("Thuốc không kê đơn");
        searchThuocDTO.setMinGiaBan(5000.0);
        searchThuocDTO.setMaxGiaBan(10000.0);
        searchThuocDTO.setTenDoiTuong("Người lớn");
        searchThuocDTO.setTrangThai(true);
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);
        searchThuocDTO.setSortedField("id");

        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc);
        Page<Thuoc> page = new PageImpl<>(thuocList);

        when(thuocRepo.search(
            eq(searchThuocDTO.getKeyWord()),
            eq(searchThuocDTO.getLoaiThuoc()),
            eq(searchThuocDTO.getNhaSanXuat()),
            eq(searchThuocDTO.getDanhMucThuoc()),
            eq(searchThuocDTO.getMinGiaBan()),
            eq(searchThuocDTO.getMaxGiaBan()),
            eq(searchThuocDTO.getTenDoiTuong()),
            eq(searchThuocDTO.getTrangThai()),
            any(Pageable.class)
        )).thenReturn(page);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.search(searchThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(1, response.getData().getTotalElements());
        assertEquals(thuocList, response.getData().getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).search(
            eq(searchThuocDTO.getKeyWord()),
            eq(searchThuocDTO.getLoaiThuoc()),
            eq(searchThuocDTO.getNhaSanXuat()),
            eq(searchThuocDTO.getDanhMucThuoc()),
            eq(searchThuocDTO.getMinGiaBan()),
            eq(searchThuocDTO.getMaxGiaBan()),
            eq(searchThuocDTO.getTenDoiTuong()),
            eq(searchThuocDTO.getTrangThai()),
            any(Pageable.class)
        );
    }

    @Test
    @DisplayName("PC_010: Kiểm thử đường dẫn trong phương thức validateThuoc() với các nhánh điều kiện khác nhau")
    void testValidateThuocPathWithDifferentConditions() {
        // Arrange
        ThuocDTO invalidThuocDTO = createBasicThuocDTO();
        invalidThuocDTO.setTenThuoc(""); // Tên thuốc không hợp lệ
        invalidThuocDTO.setMaThuoc(""); // Mã thuốc không hợp lệ
        invalidThuocDTO.setGiaNhap(-1.0); // Giá nhập không hợp lệ
        invalidThuocDTO.setGiaBan(-1.0); // Giá bán không hợp lệ
        invalidThuocDTO.setSoLuongTon(-1); // Số lượng tồn không hợp lệ

        Thuoc invalidThuoc = createBasicThuoc();
        invalidThuoc.setTenThuoc("");
        invalidThuoc.setMaThuoc("");
        invalidThuoc.setGiaNhap(-1.0);
        invalidThuoc.setGiaBan(-1.0);
        invalidThuoc.setSoLuongTon(-1);

        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(invalidThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(invalidThuocDTO);

        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Tên thuốc không hợp lệ", response.getMsg());
        assertNull(response.getData());

        // Verify các phương thức được gọi
        verify(thuocRepo, times(1)).existsByMaThuoc(anyString());
        verify(thuocRepo, times(1)).existsByTenThuoc(anyString());
        verify(loaiThuocRepo, never()).findById(anyInt());
        verify(nhaSanXuatRepo, never()).findById(anyInt());
        verify(thuocRepo, never()).save(any(Thuoc.class));
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
