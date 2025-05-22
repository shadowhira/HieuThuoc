package com.example.hieuthuoc.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.example.hieuthuoc.entity.ChucNang;

@DataJpaTest
@ActiveProfiles("test")
public class ChucNangRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private ChucNangRepo chucNangRepo;
    
    private ChucNang chucNang;
    
    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        chucNang = new ChucNang();
        chucNang.setTenChucNang("Quản lý sản phẩm");
        chucNang.setHanhDong("CRUD_PRODUCT");
        chucNang.setMoTa("Chức năng quản lý sản phẩm");
        
        // Lưu vào cơ sở dữ liệu H2 in-memory
        entityManager.persist(chucNang);
        entityManager.flush();
    }
    
    @Test
    @DisplayName("UT_CHUCNANG_REPOSITORY_001: Kiểm thử phương thức findByTenChucNang")
    void testFindByTenChucNang_ShouldReturnChucNang() {
        // Act
        ChucNang result = chucNangRepo.findByTenChucNang("Quản lý sản phẩm");
        
        // Assert
        assertNotNull(result);
        assertEquals("Quản lý sản phẩm", result.getTenChucNang());
        assertEquals("CRUD_PRODUCT", result.getHanhDong());
        assertEquals("Chức năng quản lý sản phẩm", result.getMoTa());
    }
    
    @Test
    @DisplayName("UT_CHUCNANG_REPOSITORY_002: Kiểm thử phương thức existsByTenChucNang với tên tồn tại")
    void testExistsByTenChucNang_WithExistingName_ShouldReturnTrue() {
        // Act
        boolean result = chucNangRepo.existsByTenChucNang("Quản lý sản phẩm");
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    @DisplayName("UT_CHUCNANG_REPOSITORY_003: Kiểm thử phương thức existsByTenChucNang với tên không tồn tại")
    void testExistsByTenChucNang_WithNonExistingName_ShouldReturnFalse() {
        // Act
        boolean result = chucNangRepo.existsByTenChucNang("Chức năng không tồn tại");
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    @DisplayName("UT_CHUCNANG_REPOSITORY_004: Kiểm thử phương thức findById với ID tồn tại")
    void testFindById_WithExistingId_ShouldReturnChucNang() {
        // Act
        Optional<ChucNang> result = chucNangRepo.findById(chucNang.getId());
        
        // Assert
        assertTrue(result.isPresent());
        assertEquals("Quản lý sản phẩm", result.get().getTenChucNang());
        assertEquals("CRUD_PRODUCT", result.get().getHanhDong());
    }
    
    @Test
    @DisplayName("UT_CHUCNANG_REPOSITORY_005: Kiểm thử phương thức findById với ID không tồn tại")
    void testFindById_WithNonExistingId_ShouldReturnEmpty() {
        // Act
        Optional<ChucNang> result = chucNangRepo.findById(999);
        
        // Assert
        assertFalse(result.isPresent());
    }
}
