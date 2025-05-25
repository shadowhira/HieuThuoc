package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.hieuthuoc.dto.NguoiDungDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.SearchDTO;
import com.example.hieuthuoc.entity.GioHang;
import com.example.hieuthuoc.entity.NguoiDung;
import com.example.hieuthuoc.entity.NhomQuyen;
import com.example.hieuthuoc.repository.GioHangRepo;
import com.example.hieuthuoc.repository.NguoiDungRepo;
import com.example.hieuthuoc.repository.NhomQuyenRepo;
import com.example.hieuthuoc.service.UploadImageService;
import com.example.hieuthuoc.entity.ChucNang;

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
        nguoiDung.setId(14);
        nguoiDung.setHoTen("Nguyễn Văn A");
        nguoiDung.setTenDangNhap("nguyenvana");
        nguoiDung.setEmail("nguyenvana@example.com");
        nguoiDung.setSoDienThoai("0987654321");
        nguoiDung.setMatKhau("encodedPassword");
        nguoiDung.setTrangThai(true);

        // Tạo danh sách chức năng
        List<ChucNang> chucNangs = new ArrayList<>();
        ChucNang chucNang = new ChucNang();
        chucNang.setId(1);
        chucNang.setTenChucNang("XEM_DANH_SACH");
        chucNangs.add(chucNang);

        // Tạo nhóm quyền
        nhomQuyen = new NhomQuyen();
        nhomQuyen.setId(1);
        nhomQuyen.setTenNhomQuyen("KHACH_HANG");
        nhomQuyen.setMoTa("Nhóm quyền dành cho khách hàng");
        nhomQuyen.setChucNangs(chucNangs);

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

    @Test
    @DisplayName("QLHS_025: Kiểm thử cập nhật thông tin cá nhân thành công")
    void testUpdateProfile_Success() {
        // Arrange
        NguoiDungDTO updateDTO = new NguoiDungDTO();
        updateDTO.setId(14);
        updateDTO.setHoTen("Nguyễn Văn B");
        updateDTO.setSoDienThoai("0987654322");

        when(nguoiDungRepo.findById(14)).thenReturn(Optional.of(nguoiDung));
        when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(nguoiDung);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.update(updateDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công", result.getMsg());
        verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
    }

    @Test
    @DisplayName("QLHS_027: Kiểm thử đổi mật khẩu thành công")
    void testChangePassword_Success() {
        // Arrange
        NguoiDungDTO passwordDTO = new NguoiDungDTO();
        passwordDTO.setId(10);
        passwordDTO.setMatKhau("123456");
        passwordDTO.setMatKhauMoi("newpassword123");

        NguoiDung userForPasswordChange = new NguoiDung();
        userForPasswordChange.setId(10);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userForPasswordChange.setMatKhau(encoder.encode("123456"));

        when(nguoiDungRepo.findById(10)).thenReturn(Optional.of(userForPasswordChange));
        when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(userForPasswordChange);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.changeMatKhau(passwordDTO);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatus());
        assertEquals("Đổi mật khẩu thành công.", result.getMsg());
        verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
    }

    @Test
    @DisplayName("QLHS_028: Kiểm thử đổi mật khẩu với mật khẩu hiện tại không chính xác")
    void testChangePassword_WrongCurrentPassword() {
        // Arrange
        NguoiDungDTO passwordDTO = new NguoiDungDTO();
        passwordDTO.setId(10);
        passwordDTO.setMatKhau("wrongpassword");
        passwordDTO.setMatKhauMoi("newpassword123");

        NguoiDung userForPasswordChange = new NguoiDung();
        userForPasswordChange.setId(10);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userForPasswordChange.setMatKhau(encoder.encode("123456"));

        when(nguoiDungRepo.findById(10)).thenReturn(Optional.of(userForPasswordChange));

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.changeMatKhau(passwordDTO);

        // Assert
        assertNotNull(result);
        assertEquals(400, result.getStatus());
        assertEquals("Mật khẩu không chính xác.", result.getMsg());
        verify(nguoiDungRepo, never()).save(any(NguoiDung.class));
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_005: Kiểm thử thay đổi avatar thành công")
    void testChangeAvatar_Success() {
        // Arrange
        NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setId(14);
        
        // Tạo mock file ảnh
        MockMultipartFile file = new MockMultipartFile(
            "file",
            "test.jpg",
            "image/jpeg",
            "test image content".getBytes()
        );
        nguoiDungDTO.setFile(file);

        // Mock người dùng hiện tại với avatar cũ
        NguoiDung existingUser = new NguoiDung();
        existingUser.setId(14);
        existingUser.setAvatar("old_avatar_url");
        when(nguoiDungRepo.findById(14)).thenReturn(Optional.of(existingUser));

        // Mock xóa avatar cũ
        doNothing().when(uploadImageService).deleteImage(anyString());

        // Mock upload avatar mới
        String newAvatarUrl = "new_avatar_url";
        when(uploadImageService.uploadImage(any(MultipartFile.class), anyString()))
            .thenReturn(newAvatarUrl);

        // Mock lưu người dùng
        when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(existingUser);

        // Act
        ResponseDTO<NguoiDung> response = nguoiDungService.changeAvatar(nguoiDungDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công.", response.getMsg());
        
        // Verify các phương thức được gọi
        verify(uploadImageService, times(1)).deleteImage("old_avatar_url");
        verify(uploadImageService, times(1)).uploadImage(any(MultipartFile.class), eq("NguoiDung_14"));
        verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
        
        // Verify avatar mới được cập nhật
        assertEquals(newAvatarUrl, existingUser.getAvatar());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_004: Kiểm thử đăng ký tài khoản mới")
    void testRegister_WithValidData_ShouldCreateNewUser() {
        // Arrange
        when(nguoiDungRepo.findByTenDangNhap(any())).thenReturn(null);
        when(nguoiDungRepo.findByEmail(any())).thenReturn(null);
        when(nhomQuyenRepo.findByTenNhomQuyen("KHACH_HANG")).thenReturn(nhomQuyen);
        when(nguoiDungRepo.save(any())).thenReturn(nguoiDung);
        when(gioHangRepo.save(any())).thenReturn(new GioHang());

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.register(nguoiDungDTO);

        // Assert
        assertEquals(200, result.getStatus());
        assertNotNull(result.getData());
        verify(nguoiDungRepo).save(any());
        verify(gioHangRepo).save(any());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_005: Kiểm thử đổi mật khẩu")
    void testChangeMatKhau_WithValidData_ShouldUpdatePassword() {
        // Arrange
        String currentPassword = "Password123@";
        String newPassword = "NewPassword123@";
        nguoiDungDTO.setId(1);
        nguoiDungDTO.setMatKhau(currentPassword);
        nguoiDungDTO.setMatKhauMoi(newPassword);
        
        NguoiDung existingUser = new NguoiDung();
        existingUser.setId(1);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        existingUser.setMatKhau(encoder.encode(currentPassword));
        
        when(nguoiDungRepo.findById(1)).thenReturn(Optional.of(existingUser));
        when(nguoiDungRepo.save(any())).thenReturn(existingUser);

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.changeMatKhau(nguoiDungDTO);

        // Assert
        assertEquals(200, result.getStatus());
        verify(nguoiDungRepo).save(any());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_006: Kiểm thử quên mật khẩu")
    void testForgotMatKhau_WithValidEmail_ShouldResetPassword() {
        // Arrange
        String email = "nguyenvana@example.com";
        when(nguoiDungRepo.findByEmail(email)).thenReturn(nguoiDung);
        when(nguoiDungRepo.save(any())).thenReturn(nguoiDung);
        doNothing().when(emailService).sendEmail(anyString(), anyString(), anyString());

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.forgotMatKhau(email);

        // Assert
        assertEquals(200, result.getStatus());
        verify(emailService).sendEmail(anyString(), anyString(), anyString());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_007: Kiểm thử thay đổi avatar")
    void testChangeAvatar_WithValidData_ShouldUpdateAvatar() {
        // Arrange
        nguoiDungDTO.setId(1);
        MockMultipartFile mockFile = new MockMultipartFile(
            "avatar", 
            "avatar.jpg",
            "image/jpeg", 
            "test image content".getBytes()
        );
        nguoiDungDTO.setFile(mockFile);
        
        when(nguoiDungRepo.findById(1)).thenReturn(Optional.of(nguoiDung));
        when(nguoiDungRepo.save(any())).thenReturn(nguoiDung);
        when(uploadImageService.uploadImage(any(MultipartFile.class), anyString())).thenReturn("uploaded-avatar.jpg");

        // Act
        ResponseDTO<NguoiDung> result = nguoiDungService.changeAvatar(nguoiDungDTO);

        // Assert
        assertEquals(200, result.getStatus());
        verify(nguoiDungRepo).save(any());
        verify(uploadImageService).uploadImage(any(MultipartFile.class), anyString());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_008: Kiểm thử tìm kiếm người dùng theo tên")
    void testGetByHoTen_WithValidSearch_ShouldReturnPagedResult() {
        // Arrange
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setKeyWord("Nguyễn");
        searchDTO.setCurrentPage(0);
        searchDTO.setSize(10);

        List<NguoiDung> nguoiDungs = List.of(nguoiDung);
        Page<NguoiDung> page = new PageImpl<>(nguoiDungs);
        
        when(nguoiDungRepo.searchByName(anyString(), any(PageRequest.class))).thenReturn(page);

        // Act
        ResponseDTO<PageDTO<List<NguoiDungDTO>>> result = nguoiDungService.getByHoTen(searchDTO);

        // Assert
        assertEquals(200, result.getStatus());
        assertNotNull(result.getData());
        assertEquals(1, result.getData().getTotalElements());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_009: Kiểm thử xóa người dùng")
    void testDelete_WithValidId_ShouldDeleteUser() {
        // Arrange
        Integer userId = 1;
        doNothing().when(nguoiDungRepo).deleteById(userId);

        // Act
        ResponseDTO<Void> result = nguoiDungService.delete(userId);

        // Assert
        assertEquals(200, result.getStatus());
        verify(nguoiDungRepo).deleteById(userId);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_010: Kiểm thử loadUserByUsername")
    void testLoadUserByUsername_WithValidUsername_ShouldReturnUserDetails() {
        // Arrange
        String username = "nguyenvana";
        when(nguoiDungRepo.findByTenDangNhap(username)).thenReturn(nguoiDung);

        // Act
        UserDetails result = nguoiDungService.loadUserByUsername(username);

        // Assert
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertTrue(result.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("KHACH_HANG")));
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_SERVICE_011: Kiểm thử loadUserByUsername với username không tồn tại")
    void testLoadUserByUsername_WithInvalidUsername_ShouldThrowException() {
        // Arrange
        String username = "nonexistent";
        when(nguoiDungRepo.findByTenDangNhap(username)).thenReturn(null);

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            nguoiDungService.loadUserByUsername(username);
        });
    }
}
