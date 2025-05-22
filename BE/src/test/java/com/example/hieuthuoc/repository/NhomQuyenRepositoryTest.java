package com.example.hieuthuoc.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.entity.NhomQuyen;

@DataJpaTest
@ActiveProfiles("test")
public class NhomQuyenRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private NhomQuyenRepo nhomQuyenRepo;
    
    private NhomQuyen nhomQuyen;
    private List<ChucNang> chucNangs;
    
    @BeforeEach
    void setUp() {
        // Khởi tạo dữ liệu mẫu cho kiểm thử
        chucNangs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ChucNang chucNang = new ChucNang();
            chucNang.setTenChucNang("Chức năng " + i);
            chucNang.setHanhDong("ACTION_" + i);
            chucNang.setMoTa("Mô tả chức năng " + i);
            chucNangs.add(entityManager.persist(chucNang));
        }
        
        nhomQuyen = new NhomQuyen();
        nhomQuyen.setTenNhomQuyen("ADMIN");
        nhomQuyen.setMoTa("Nhóm quyền quản trị viên");
        nhomQuyen.setChucNangs(chucNangs);
        
        // Lưu vào cơ sở dữ liệu H2 in-memory
        entityManager.persist(nhomQuyen);
        entityManager.flush();
    }
    
    @Test
    @DisplayName("UT_NHOMQUYEN_REPOSITORY_001: Kiểm thử phương thức findByTenNhomQuyen")
    void testFindByTenNhomQuyen_ShouldReturnNhomQuyen() {
        // Act
        NhomQuyen result = nhomQuyenRepo.findByTenNhomQuyen("ADMIN");
        
        // Assert
        assertNotNull(result);
        assertEquals("ADMIN", result.getTenNhomQuyen());
        assertEquals("Nhóm quyền quản trị viên", result.getMoTa());
        assertEquals(3, result.getChucNangs().size());
    }
    
    @Test
    @DisplayName("UT_NHOMQUYEN_REPOSITORY_002: Kiểm thử phương thức existsByTenNhomQuyen với tên tồn tại")
    void testExistsByTenNhomQuyen_WithExistingName_ShouldReturnTrue() {
        // Act
        boolean result = nhomQuyenRepo.existsByTenNhomQuyen("ADMIN");
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    @DisplayName("UT_NHOMQUYEN_REPOSITORY_003: Kiểm thử phương thức existsByTenNhomQuyen với tên không tồn tại")
    void testExistsByTenNhomQuyen_WithNonExistingName_ShouldReturnFalse() {
        // Act
        boolean result = nhomQuyenRepo.existsByTenNhomQuyen("NON_EXISTING");
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    @DisplayName("UT_NHOMQUYEN_REPOSITORY_004: Kiểm thử phương thức findById với ID tồn tại")
    void testFindById_WithExistingId_ShouldReturnNhomQuyen() {
        // Act
        Optional<NhomQuyen> result = nhomQuyenRepo.findById(nhomQuyen.getId());
        
        // Assert
        assertTrue(result.isPresent());
        assertEquals("ADMIN", result.get().getTenNhomQuyen());
        assertEquals("Nhóm quyền quản trị viên", result.get().getMoTa());
    }
    
    @Test
    @DisplayName("UT_NHOMQUYEN_REPOSITORY_005: Kiểm thử phương thức findById với ID không tồn tại")
    void testFindById_WithNonExistingId_ShouldReturnEmpty() {
        // Act
        Optional<NhomQuyen> result = nhomQuyenRepo.findById(999);
        
        // Assert
        assertFalse(result.isPresent());
    }
}
