package com.example.hieuthuoc.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.NhomQuyenDTO;

@ExtendWith(MockitoExtension.class)
public class NhomQuyenValidatorTest {

    @InjectMocks
    private NhomQuyenValidator nhomQuyenValidator;

    private NhomQuyenDTO nhomQuyenDTO;

    @BeforeEach
    void setUp() {
        nhomQuyenValidator = new NhomQuyenValidator();
        
        nhomQuyenDTO = new NhomQuyenDTO();
        nhomQuyenDTO.setTenNhomQuyen("Quản lý kho");
        nhomQuyenDTO.setMoTa("Nhóm quyền dành cho quản lý kho");
        
        List<ChucNangDTO> chucNangDTOs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ChucNangDTO chucNangDTO = new ChucNangDTO();
            chucNangDTO.setId(i);
            chucNangDTO.setTenChucNang("Chức năng " + i);
            chucNangDTO.setMoTa("Mô tả chức năng " + i);
            chucNangDTOs.add(chucNangDTO);
        }
        nhomQuyenDTO.setChucNangs(chucNangDTOs);
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_VALIDATOR_001: Kiểm thử validate tên nhóm quyền hợp lệ")
    void testValidateTenNhomQuyen_WithValidName_ShouldReturnTrue() {
        // Arrange
        nhomQuyenDTO.setTenNhomQuyen("ADMIN_ROLE");
        
        // Act
        boolean result = nhomQuyenValidator.validateTenNhomQuyen(nhomQuyenDTO);
        
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_VALIDATOR_002: Kiểm thử validate tên nhóm quyền không hợp lệ - quá ngắn")
    void testValidateTenNhomQuyen_WithShortName_ShouldReturnFalse() {
        // Arrange
        nhomQuyenDTO.setTenNhomQuyen("A");
        
        // Act
        boolean result = nhomQuyenValidator.validateTenNhomQuyen(nhomQuyenDTO);
        
        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_VALIDATOR_003: Kiểm thử validate tên nhóm quyền không hợp lệ - chứa ký tự đặc biệt")
    void testValidateTenNhomQuyen_WithSpecialCharacters_ShouldReturnFalse() {
        // Arrange
        nhomQuyenDTO.setTenNhomQuyen("ADMIN@ROLE");
        
        // Act
        boolean result = nhomQuyenValidator.validateTenNhomQuyen(nhomQuyenDTO);
        
        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_VALIDATOR_004: Kiểm thử validate danh sách chức năng hợp lệ")
    void testValidateChucNangs_WithValidList_ShouldReturnTrue() {
        // Act
        boolean result = nhomQuyenValidator.validateChucNangs(nhomQuyenDTO);
        
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("UT_NHOMQUYEN_VALIDATOR_005: Kiểm thử validate danh sách chức năng không hợp lệ - danh sách rỗng")
    void testValidateChucNangs_WithEmptyList_ShouldReturnFalse() {
        // Arrange
        nhomQuyenDTO.setChucNangs(new ArrayList<>());
        
        // Act
        boolean result = nhomQuyenValidator.validateChucNangs(nhomQuyenDTO);
        
        // Assert
        assertFalse(result);
    }
}
