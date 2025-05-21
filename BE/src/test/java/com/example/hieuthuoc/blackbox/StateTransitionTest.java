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
 * Kiểm thử hộp đen - Kiểm thử trạng thái
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class StateTransitionTest {

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
    @DisplayName("ST_001: Kiểm thử chuyển trạng thái thuốc từ 'Còn hàng' sang 'Sắp hết hàng' khi số lượng < nguongCanhBao")
    void testTransitionFromInStockToLowStock() {
        // Arrange
        Thuoc thuocInStock = createBasicThuoc();
        thuocInStock.setId(1);
        thuocInStock.setSoLuongTon(100);
        thuocInStock.setNguongCanhBao(20);
        thuocInStock.setTrangThai(true); // Còn hàng

        ThuocDTO thuocUpdateDTO = createBasicThuocDTO();
        thuocUpdateDTO.setId(1);
        thuocUpdateDTO.setSoLuongTon(15); // Số lượng < ngưỡng cảnh báo
        thuocUpdateDTO.setNguongCanhBao(20);

        Thuoc thuocLowStock = createBasicThuoc();
        thuocLowStock.setId(1);
        thuocLowStock.setSoLuongTon(15);
        thuocLowStock.setNguongCanhBao(20);
        thuocLowStock.setTrangThai(true); // Vẫn còn hàng nhưng sắp hết

        when(thuocRepo.findById(1)).thenReturn(Optional.of(thuocInStock));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(thuocLowStock);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuocLowStock);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocUpdateDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(15, response.getData().getSoLuongTon());
        assertTrue(response.getData().getTrangThai()); // Vẫn còn hàng

        // Verify cảnh báo được tạo
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("ST_002: Kiểm thử chuyển trạng thái thuốc từ 'Sắp hết hàng' sang 'Hết hàng' khi số lượng = 0")
    void testTransitionFromLowStockToOutOfStock() {
        // Arrange
        Thuoc thuocLowStock = createBasicThuoc();
        thuocLowStock.setId(1);
        thuocLowStock.setSoLuongTon(15); // Sắp hết hàng
        thuocLowStock.setNguongCanhBao(20);
        thuocLowStock.setTrangThai(true); // Còn hàng

        ThuocDTO thuocUpdateDTO = createBasicThuocDTO();
        thuocUpdateDTO.setId(1);
        thuocUpdateDTO.setSoLuongTon(0); // Hết hàng
        thuocUpdateDTO.setNguongCanhBao(20);

        Thuoc thuocOutOfStock = createBasicThuoc();
        thuocOutOfStock.setId(1);
        thuocOutOfStock.setSoLuongTon(0);
        thuocOutOfStock.setNguongCanhBao(20);
        thuocOutOfStock.setTrangThai(false); // Hết hàng

        when(thuocRepo.findById(1)).thenReturn(Optional.of(thuocLowStock));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(thuocOutOfStock);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuocOutOfStock);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocUpdateDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(0, response.getData().getSoLuongTon());
        assertFalse(response.getData().getTrangThai()); // Hết hàng

        // Verify cảnh báo được tạo
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("ST_003: Kiểm thử chuyển trạng thái thuốc từ 'Hết hàng' sang 'Còn hàng' khi nhập thêm hàng")
    void testTransitionFromOutOfStockToInStock() {
        // Arrange
        Thuoc thuocOutOfStock = createBasicThuoc();
        thuocOutOfStock.setId(1);
        thuocOutOfStock.setSoLuongTon(0); // Hết hàng
        thuocOutOfStock.setNguongCanhBao(20);
        thuocOutOfStock.setTrangThai(false); // Hết hàng

        ThuocDTO thuocUpdateDTO = createBasicThuocDTO();
        thuocUpdateDTO.setId(1);
        thuocUpdateDTO.setSoLuongTon(50); // Nhập thêm hàng
        thuocUpdateDTO.setNguongCanhBao(20);

        Thuoc thuocInStock = createBasicThuoc();
        thuocInStock.setId(1);
        thuocInStock.setSoLuongTon(50);
        thuocInStock.setNguongCanhBao(20);
        thuocInStock.setTrangThai(true); // Còn hàng

        when(thuocRepo.findById(1)).thenReturn(Optional.of(thuocOutOfStock));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(thuocInStock);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuocInStock);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocUpdateDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(50, response.getData().getSoLuongTon());
        assertTrue(response.getData().getTrangThai()); // Còn hàng

        // Verify cập nhật được thực hiện
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("ST_004: Kiểm thử chuyển trạng thái thuốc từ 'Còn hạn' sang 'Sắp hết hạn' khi còn 30 ngày")
    void testTransitionFromValidToNearExpiry() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 60); // Còn hạn (60 ngày)
        Date validDate = calendar.getTime();

        Thuoc thuocValid = createBasicThuoc();
        thuocValid.setId(1);
        thuocValid.setHanSuDung(validDate);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 25); // Sắp hết hạn (25 ngày)
        Date nearExpiryDate = calendar2.getTime();

        ThuocDTO thuocUpdateDTO = createBasicThuocDTO();
        thuocUpdateDTO.setId(1);
        thuocUpdateDTO.setHanSuDung(nearExpiryDate);

        Thuoc thuocNearExpiry = createBasicThuoc();
        thuocNearExpiry.setId(1);
        thuocNearExpiry.setHanSuDung(nearExpiryDate);

        when(thuocRepo.findById(1)).thenReturn(Optional.of(thuocValid));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(thuocNearExpiry);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuocNearExpiry);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocUpdateDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(nearExpiryDate, response.getData().getHanSuDung());

        // Verify cảnh báo được tạo
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("ST_005: Kiểm thử chuyển trạng thái thuốc từ 'Sắp hết hạn' sang 'Hết hạn' khi đến ngày hết hạn")
    void testTransitionFromNearExpiryToExpired() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 15); // Sắp hết hạn (15 ngày)
        Date nearExpiryDate = calendar.getTime();

        Thuoc thuocNearExpiry = createBasicThuoc();
        thuocNearExpiry.setId(1);
        thuocNearExpiry.setHanSuDung(nearExpiryDate);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 0); // Hết hạn (ngày hiện tại)
        Date expiredDate = calendar2.getTime();

        ThuocDTO thuocUpdateDTO = createBasicThuocDTO();
        thuocUpdateDTO.setId(1);
        thuocUpdateDTO.setHanSuDung(expiredDate);

        Thuoc thuocExpired = createBasicThuoc();
        thuocExpired.setId(1);
        thuocExpired.setHanSuDung(expiredDate);

        when(thuocRepo.findById(1)).thenReturn(Optional.of(thuocNearExpiry));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(thuocExpired);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuocExpired);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocUpdateDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(expiredDate, response.getData().getHanSuDung());

        // Verify cảnh báo được tạo
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    @DisplayName("ST_006: Kiểm thử chuyển trạng thái thuốc từ 'Hết hạn' sang 'Còn hạn' khi cập nhật hạn sử dụng mới")
    void testTransitionFromExpiredToValid() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // Hết hạn (1 ngày trước)
        Date expiredDate = calendar.getTime();

        Thuoc thuocExpired = createBasicThuoc();
        thuocExpired.setId(1);
        thuocExpired.setHanSuDung(expiredDate);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.YEAR, 1); // Còn hạn (1 năm sau)
        Date validDate = calendar2.getTime();

        ThuocDTO thuocUpdateDTO = createBasicThuocDTO();
        thuocUpdateDTO.setId(1);
        thuocUpdateDTO.setHanSuDung(validDate);

        Thuoc thuocValid = createBasicThuoc();
        thuocValid.setId(1);
        thuocValid.setHanSuDung(validDate);

        when(thuocRepo.findById(1)).thenReturn(Optional.of(thuocExpired));
        when(modelMapper.map(any(ThuocDTO.class), eq(Thuoc.class))).thenReturn(thuocValid);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuocValid);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocUpdateDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(validDate, response.getData().getHanSuDung());

        // Verify cập nhật được thực hiện
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
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
