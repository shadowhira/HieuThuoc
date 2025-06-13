-- Script để tạo tài khoản admin với mật khẩu 123456
-- Mật khẩu: 123456 (đã được mã hóa bằng BCrypt)

-- Thêm người dùng mới
INSERT INTO nguoi_dung (ten_dang_nhap, mat_khau, ho_ten, email, dia_chi, so_dien_thoai, avatar, trang_thai, created_at, update_at) 
VALUES ('admin', '$2a$10$yfq2uYQKSqwSzYjBoiTBZ.4XRMYpOXhPbqx6hBb.0FNpxUHbBYdnW', 'Admin System', 'admin@pharmacy.com', 'Hà Nội', '0987654321', 'avatar1.jpg', true, NOW(), NOW());

-- Lấy ID của người dùng vừa tạo
DO $$
DECLARE
    new_user_id INT;
BEGIN
    SELECT id INTO new_user_id FROM nguoi_dung WHERE ten_dang_nhap = 'admin';
    
    -- Thêm quyền admin cho người dùng mới
    INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id) VALUES (new_user_id, 1); -- 1 là ID của nhóm quyền ADMIN
END $$;
