package com.example.hieuthuoc.jwt;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

/**
 * Mock JwtService cho môi trường test
 * Luôn trả về kết quả hợp lệ
 */
@Component
public class MockJwtService extends JwtService {

    /**
     * Tạo token giả
     */
    public String generateToken(String tenDangNhap) {
        return "mock-jwt-token-for-" + tenDangNhap;
    }

    /**
     * Trích xuất username từ token
     * Luôn trả về "admin"
     */
    public String extractUsername(String token) {
        return "admin";
    }

    /**
     * Trích xuất thông tin từ token
     * Không sử dụng trong test
     */
    public <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        throw new UnsupportedOperationException("Not implemented for test");
    }

    /**
     * Lấy thời gian hết hạn của token
     * Luôn trả về thời gian trong tương lai
     */
    public Date extractExpiration(String token) {
        return new Date(System.currentTimeMillis() + 3600000); // 1 giờ sau
    }

    /**
     * Kiểm tra tính hợp lệ của token
     * Luôn trả về true
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
