package com.example.hieuthuoc.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.hieuthuoc.entity.DanhMucThuoc;
import com.example.hieuthuoc.entity.DoiTuong;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.ThanhPhanThuoc;
import com.example.hieuthuoc.entity.Thuoc;

/**
 * Kiểm thử đơn vị cho ThuocRepo
 */
public class ThuocRepoTest2 {

    @Mock
    private ThuocRepo thuocRepo;

    private Thuoc thuoc1;
    private Thuoc thuoc2;
    private LoaiThuoc loaiThuoc;
    private NhaSanXuat nhaSanXuat;
    private DanhMucThuoc danhMucThuoc;
    private DoiTuong doiTuong;
    private List<Thuoc> thuocList;
    private List<ThanhPhanThuoc> thanhPhanThuocs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Tạo danh mục thuốc
        danhMucThuoc = new DanhMucThuoc();
        danhMucThuoc.setId(1);
        danhMucThuoc.setTenDanhMuc("Thuốc kháng sinh");

        // Tạo loại thuốc
        loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(1);
        loaiThuoc.setTenLoai("Giảm đau không steroid");
        loaiThuoc.setDanhMucThuoc(danhMucThuoc);

        // Tạo nhà sản xuất
        nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(1);
        nhaSanXuat.setTenNhaSanXuat("Công ty Dược phẩm ABC");
        nhaSanXuat.setMaNSX("NSX001");

        // Tạo đối tượng sử dụng
        doiTuong = new DoiTuong();
        doiTuong.setId(1);
        doiTuong.setTenDoiTuong("Người lớn");

        // Tạo thuốc 1
        thuoc1 = new Thuoc();
        thuoc1.setId(1);
        thuoc1.setTenThuoc("Paracetamol 500mg");
        thuoc1.setMaThuoc("PARA500");
        thuoc1.setLoaiThuoc(loaiThuoc);
        thuoc1.setNhaSanXuat(nhaSanXuat);
        thuoc1.setDonVi("Viên");
        thuoc1.setGiaNhap(5000.0);
        thuoc1.setGiaBan(8000.0);
        thuoc1.setSoLuongTon(100);
        thuoc1.setNguongCanhBao(20);
        thuoc1.setHanSuDung(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000L)); // 1 năm sau
        thuoc1.setTrangThai(true);

        // Tạo thuốc 2
        thuoc2 = new Thuoc();
        thuoc2.setId(2);
        thuoc2.setTenThuoc("Amoxicillin 500mg");
        thuoc2.setMaThuoc("AMOX500");
        thuoc2.setLoaiThuoc(loaiThuoc);
        thuoc2.setNhaSanXuat(nhaSanXuat);
        thuoc2.setDonVi("Viên");
        thuoc2.setGiaNhap(6000.0);
        thuoc2.setGiaBan(10000.0);
        thuoc2.setSoLuongTon(80);
        thuoc2.setNguongCanhBao(15);
        thuoc2.setHanSuDung(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000L)); // 1 năm sau
        thuoc2.setTrangThai(true);
        
        thuocList = new ArrayList<>();
        thuocList.add(thuoc1);
        thuocList.add(thuoc2);
        
        // Tạo thành phần thuốc
        thanhPhanThuocs = new ArrayList<>();
        ThanhPhanThuoc thanhPhanThuoc = new ThanhPhanThuoc();
        thanhPhanThuoc.setId(1);
        thanhPhanThuoc.setTenThanhPhan("Paracetamol");
        thanhPhanThuoc.setHamLuong("500mg");
        thanhPhanThuoc.setDonVi("mg");
        thanhPhanThuoc.setThuoc(thuoc1);
        thanhPhanThuocs.add(thanhPhanThuoc);
        
        thuoc1.setThanhPhanThuocs(thanhPhanThuocs);
    }

    @Test
    @DisplayName("1. Kiểm thử findByTenThuoc() với tên thuốc tồn tại")
    void testFindByTenThuoc_WithExistingName() {
        // Arrange
        String tenThuoc = "Paracetamol 500mg";
        Pageable pageable = PageRequest.of(0, 10);
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc1);
        Page<Thuoc> expectedPage = new PageImpl<>(thuocList, pageable, 1);
        
        when(thuocRepo.findByTenThuoc(tenThuoc, pageable)).thenReturn(expectedPage);

        // Act
        Page<Thuoc> result = thuocRepo.findByTenThuoc(tenThuoc, pageable);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(tenThuoc, result.getContent().get(0).getTenThuoc());
    }

    @Test
    @DisplayName("2. Kiểm thử existsByMaThuoc() với mã thuốc tồn tại")
    void testExistsByMaThuoc_WithExistingCode() {
        // Arrange
        String maThuoc = "PARA500";
        when(thuocRepo.existsByMaThuoc(maThuoc)).thenReturn(true);

        // Act
        Boolean result = thuocRepo.existsByMaThuoc(maThuoc);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("3. Kiểm thử existsByMaThuoc() với mã thuốc không tồn tại")
    void testExistsByMaThuoc_WithNonExistingCode() {
        // Arrange
        String maThuoc = "NONEXIST";
        when(thuocRepo.existsByMaThuoc(maThuoc)).thenReturn(false);

        // Act
        Boolean result = thuocRepo.existsByMaThuoc(maThuoc);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("4. Kiểm thử existsByTenThuoc() với tên thuốc tồn tại")
    void testExistsByTenThuoc_WithExistingName() {
        // Arrange
        String tenThuoc = "Paracetamol 500mg";
        when(thuocRepo.existsByTenThuoc(tenThuoc)).thenReturn(true);

        // Act
        Boolean result = thuocRepo.existsByTenThuoc(tenThuoc);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("5. Kiểm thử search() với nhiều tiêu chí tìm kiếm")
    void testSearch_WithMultipleCriteria() {
        // Arrange
        String keyWord = "Para";
        String loaiThuoc = "Giảm đau";
        String nhaSanXuat = "ABC";
        String danhMucThuoc = "kháng sinh";
        Double minGiaBan = 7000.0;
        Double maxGiaBan = 9000.0;
        String tenDoiTuong = null;
        Boolean trangThai = true;
        Pageable pageable = PageRequest.of(0, 10);
        
        List<Thuoc> thuocList = new ArrayList<>();
        thuocList.add(thuoc1);
        Page<Thuoc> expectedPage = new PageImpl<>(thuocList, pageable, 1);
        
        when(thuocRepo.search(
            keyWord, loaiThuoc, nhaSanXuat, danhMucThuoc,
            minGiaBan, maxGiaBan, tenDoiTuong, trangThai, pageable
        )).thenReturn(expectedPage);

        // Act
        Page<Thuoc> result = thuocRepo.search(
            keyWord, loaiThuoc, nhaSanXuat, danhMucThuoc,
            minGiaBan, maxGiaBan, tenDoiTuong, trangThai, pageable
        );

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Paracetamol 500mg", result.getContent().get(0).getTenThuoc());
    }
}
