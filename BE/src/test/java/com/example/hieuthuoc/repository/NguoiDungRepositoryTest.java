package com.example.hieuthuoc.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.example.hieuthuoc.entity.NguoiDung;

/**
 * Kiểm thử Repository cho NguoiDungRepo
 * Sử dụng @DataJpaTest để cấu hình môi trường kiểm thử tự động
 */
@DataJpaTest
@ActiveProfiles("test")
public class NguoiDungRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    private NguoiDung nguoiDung;

    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        nguoiDung = new NguoiDung();
        nguoiDung.setHoTen("Nguyễn Văn A");
        nguoiDung.setTenDangNhap("nguyenvana");
        nguoiDung.setEmail("nguyenvana@example.com");
        nguoiDung.setSoDienThoai("0987654321");
        nguoiDung.setMatKhau("encodedPassword");
        nguoiDung.setTrangThai(true);

        // Lưu vào cơ sở dữ liệu H2 in-memory
        entityManager.persist(nguoiDung);
        entityManager.flush();
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_REPOSITORY_001: Kiểm thử phương thức findByEmail")
    void testFindByEmail_ShouldReturnNguoiDung() {
        // Act
        NguoiDung result = nguoiDungRepo.findByEmail("nguyenvana@example.com");

        // Assert
        assertNotNull(result);
        assertEquals("Nguyễn Văn A", result.getHoTen());
        assertEquals("nguyenvana", result.getTenDangNhap());
        assertEquals("0987654321", result.getSoDienThoai());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_REPOSITORY_002: Kiểm thử phương thức findByTenDangNhap")
    void testFindByTenDangNhap_ShouldReturnNguoiDung() {
        // Act
        NguoiDung result = nguoiDungRepo.findByTenDangNhap("nguyenvana");

        // Assert
        assertNotNull(result);
        assertEquals("Nguyễn Văn A", result.getHoTen());
        assertEquals("nguyenvana@example.com", result.getEmail());
        assertEquals("0987654321", result.getSoDienThoai());
    }

    @Test
    @DisplayName("UT_NGUOIDUNG_REPOSITORY_003: Kiểm thử phương thức findByEmail với email không tồn tại")
    void testFindByEmail_WithNonExistingEmail_ShouldReturnNull() {
        // Act
        NguoiDung result = nguoiDungRepo.findByEmail("nonexisting@example.com");

        // Assert
        assertNull(result);
    }
}
