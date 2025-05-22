package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.hieuthuoc.dto.NguoiDungDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.GioHang;
import com.example.hieuthuoc.entity.NguoiDung;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.repository.GioHangRepo;
import com.example.hieuthuoc.repository.NguoiDungRepo;
import com.example.hieuthuoc.repository.NhomQuyenRepo;

@ExtendWith(MockitoExtension.class)
public class NguoiDungServiceTest {

    @Mock
    private NguoiDungRepo nguoiDungRepo;

    @Mock
    private NhomQuyenRepo nhomQuyenRepo;

    @Mock
    private GioHangRepo gioHangRepo;

    @Mock
    private EmailService emailService;

    @Mock
    private UploadImageService uploadImageService;

    // Không cần mock BCryptPasswordEncoder vì NguoiDungServiceImpl tạo instance mới

    @InjectMocks
    private NguoiDungServiceImpl nguoiDungService;

    private NguoiDungDTO nguoiDungDTO;
    private NguoiDung nguoiDung;
    private NhomQuyen nhomQuyen;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setHoTen("Nguyễn Văn A");
        nguoiDungDTO.setTenDangNhap("nguyenvana");
        nguoiDungDTO.setEmail("nguyenvana@example.com");
        nguoiDungDTO.setSoDienThoai("0987654321");
        nguoiDungDTO.setMatKhau("Password123@");

        nguoiDung = new NguoiDung();
        nguoiDung.setId(1);
        nguoiDung.setHoTen("Nguyễn Văn A");
        nguoiDung.setTenDangNhap("nguyenvana");
        nguoiDung.setEmail("nguyenvana@example.com");
        nguoiDung.setSoDienThoai("0987654321");
        nguoiDung.setMatKhau("encodedPassword");
        nguoiDung.setTrangThai(true);

        nhomQuyen = new NhomQuyen();
        nhomQuyen.setId(1);
        nhomQuyen.setTenNhomQuyen("KHACH_HANG");
        nhomQuyen.setMoTa("Nhóm quyền dành cho khách hàng");

        List<NhomQuyen> nhomQuyens = new ArrayList<>();
        nhomQuyens.add(nhomQuyen);
        nguoiDung.setNhomQuyens(nhomQuyens);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_001: Kiểm thử phương thức tạo người dùng mới với dữ liệu hợp lệ")
    void testCreateNguoiDung_WithValidData_ShouldReturnCreatedNguoiDung() {
        // Arrange
        List<Integer> nhomQuyenIds = new ArrayList<>();
        nhomQuyenIds.add(1);
        nguoiDungDTO.setNhomQuyenIds(nhomQuyenIds);

        when(nguoiDungRepo.findByTenDangNhap(anyString())).thenReturn(null);
        when(nguoiDungRepo.findByEmail(anyString())).thenReturn(null);
        when(nhomQuyenRepo.findById(1)).thenReturn(Optional.of(nhomQuyen));

        // Cấu hình mock để save() trả về đối tượng với ID đã được thiết lập
        when(nguoiDungRepo.save(any(NguoiDung.class))).thenAnswer(invocation -> {
            NguoiDung savedNguoiDung = invocation.getArgument(0);
            savedNguoiDung.setId(1); // Thiết lập ID cho đối tượng được lưu
            return savedNguoiDung;
        });

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.create(nguoiDungDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getId());
        assertEquals("Nguyễn Văn A", result.getData().getHoTen());
        assertEquals("nguyenvana", result.getData().getTenDangNhap());

        verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
        verify(gioHangRepo, times(1)).save(any(GioHang.class));
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_002: Kiểm thử phương thức tạo người dùng với email đã tồn tại")
    void testCreateNguoiDung_WithExistingEmail_ShouldReturnError() {
        // Arrange
        when(nguoiDungRepo.findByTenDangNhap(anyString())).thenReturn(null);
        when(nguoiDungRepo.findByEmail("nguyenvana@example.com")).thenReturn(nguoiDung);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.create(nguoiDungDTO);

        // Assert
        assertNotNull(result);
        assertEquals(400, result.getStatus());
        assertEquals("Email đã tồn tại.", result.getMsg());
        assertNull(result.getData());

        verify(nguoiDungRepo, never()).save(any(NguoiDung.class));
        verify(gioHangRepo, never()).save(any(GioHang.class));
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_003: Kiểm thử phương thức cập nhật người dùng")
    void testUpdateNguoiDung_WithValidData_ShouldReturnUpdatedNguoiDung() {
        // Arrange
        nguoiDungDTO.setId(1);
        nguoiDungDTO.setHoTen("Nguyễn Văn A Updated");
        nguoiDungDTO.setSoDienThoai("0987654322");

        NguoiDung updatedNguoiDung = new NguoiDung();
        updatedNguoiDung.setId(1);
        updatedNguoiDung.setHoTen("Nguyễn Văn A Updated");
        updatedNguoiDung.setTenDangNhap("nguyenvana");
        updatedNguoiDung.setEmail("nguyenvana@example.com");
        updatedNguoiDung.setSoDienThoai("0987654322");

        when(nguoiDungRepo.findById(1)).thenReturn(Optional.of(nguoiDung));
        when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(updatedNguoiDung);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.update(nguoiDungDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getId());
        assertEquals("Nguyễn Văn A Updated", result.getData().getHoTen());
        assertEquals("0987654322", result.getData().getSoDienThoai());

        verify(nguoiDungRepo, times(1)).findById(1);
        verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
    }
}
