package com.example.hieuthuoc.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.hieuthuoc.dto.NguoiDungDTO;

@Component
public class NguoiDungValidator {
    
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    
    public boolean validateEmail(NguoiDungDTO nguoiDungDTO) {
        if (nguoiDungDTO.getEmail() == null || nguoiDungDTO.getEmail().isEmpty()) {
            return false;
        }
        return Pattern.compile(EMAIL_REGEX).matcher(nguoiDungDTO.getEmail()).matches();
    }
    
    public boolean validatePassword(NguoiDungDTO nguoiDungDTO) {
        if (nguoiDungDTO.getMatKhau() == null || nguoiDungDTO.getMatKhau().isEmpty()) {
            return false;
        }
        return Pattern.compile(PASSWORD_REGEX).matcher(nguoiDungDTO.getMatKhau()).matches();
    }
    
    public boolean validatePhoneNumber(NguoiDungDTO nguoiDungDTO) {
        if (nguoiDungDTO.getSoDienThoai() == null || nguoiDungDTO.getSoDienThoai().isEmpty()) {
            return false;
        }
        return Pattern.compile(PHONE_REGEX).matcher(nguoiDungDTO.getSoDienThoai()).matches();
    }
}
