package com.example.hieuthuoc.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.hieuthuoc.dto.NhomQuyenDTO;

@Component
public class NhomQuyenValidator {
    
    private static final String NHOMQUYEN_NAME_REGEX = "^[a-zA-Z0-9_]{3,50}$";
    
    public boolean validateTenNhomQuyen(NhomQuyenDTO nhomQuyenDTO) {
        if (nhomQuyenDTO.getTenNhomQuyen() == null || nhomQuyenDTO.getTenNhomQuyen().isEmpty()) {
            return false;
        }
        return Pattern.compile(NHOMQUYEN_NAME_REGEX).matcher(nhomQuyenDTO.getTenNhomQuyen()).matches();
    }
    
    public boolean validateChucNangs(NhomQuyenDTO nhomQuyenDTO) {
        return nhomQuyenDTO.getChucNangs() != null && !nhomQuyenDTO.getChucNangs().isEmpty();
    }
}
