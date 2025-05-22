package com.example.hieuthuoc.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hieuthuoc.dto.NguoiDungDTO;

@ExtendWith(MockitoExtension.class)
public class NguoiDungValidatorTest {

    @InjectMocks
    private NguoiDungValidator nguoiDungValidator;

    private NguoiDungDTO nguoiDungDTO;

    @BeforeEach
    void setUp() {
        nguoiDungValidator = new NguoiDungValidator();
        
        nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setHoTen("Nguyễn Văn A");
        nguoiDungDTO.setTenDangNhap("nguyenvana");
        nguoiDungDTO.setEmail("nguyenvana@example.com");
        nguoiDungDTO.setSoDienThoai("0987654321");
        nguoiDungDTO.setMatKhau("Password123@");
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_VALIDATOR_001: Kiểm thử validate email hợp lệ")
    void testValidateEmail_WithValidEmail_ShouldReturnTrue() {
        // Arrange
        nguoiDungDTO.setEmail("valid@example.com");
        
        // Act
        boolean result = nguoiDungValidator.validateEmail(nguoiDungDTO);
        
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_VALIDATOR_002: Kiểm thử validate email không hợp lệ")
    void testValidateEmail_WithInvalidEmail_ShouldReturnFalse() {
        // Arrange
        nguoiDungDTO.setEmail("invalid-email");
        
        // Act
        boolean result = nguoiDungValidator.validateEmail(nguoiDungDTO);
        
        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_VALIDATOR_003: Kiểm thử validate mật khẩu hợp lệ")
    void testValidatePassword_WithValidPassword_ShouldReturnTrue() {
        // Arrange
        nguoiDungDTO.setMatKhau("Password123@");
        
        // Act
        boolean result = nguoiDungValidator.validatePassword(nguoiDungDTO);
        
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_VALIDATOR_004: Kiểm thử validate mật khẩu không hợp lệ - quá ngắn")
    void testValidatePassword_WithShortPassword_ShouldReturnFalse() {
        // Arrange
        nguoiDungDTO.setMatKhau("Pass1@");
        
        // Act
        boolean result = nguoiDungValidator.validatePassword(nguoiDungDTO);
        
        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_VALIDATOR_005: Kiểm thử validate số điện thoại hợp lệ")
    void testValidatePhoneNumber_WithValidPhoneNumber_ShouldReturnTrue() {
        // Arrange
        nguoiDungDTO.setSoDienThoai("0987654321");
        
        // Act
        boolean result = nguoiDungValidator.validatePhoneNumber(nguoiDungDTO);
        
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_VALIDATOR_006: Kiểm thử validate số điện thoại không hợp lệ")
    void testValidatePhoneNumber_WithInvalidPhoneNumber_ShouldReturnFalse() {
        // Arrange
        nguoiDungDTO.setSoDienThoai("abc123456");
        
        // Act
        boolean result = nguoiDungValidator.validatePhoneNumber(nguoiDungDTO);
        
        // Assert
        assertFalse(result);
    }
}
