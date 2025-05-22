-- Dữ liệu mẫu cho bảng chuc_nang
INSERT INTO "chuc_nang" ("id", "ten_chuc_nang", "hanh_dong", "mo_ta") VALUES
(1, 'Quan ly nguoi dung', 'CRUD_USER', 'Quan ly thong tin nguoi dung'),
(2, 'Quan ly nhom quyen', 'CRUD_ROLE', 'Quan ly thong tin nhom quyen'),
(3, 'Quan ly thuoc', 'CRUD_MEDICINE', 'Quan ly thong tin thuoc');

-- Dữ liệu mẫu cho bảng nhom_quyen
INSERT INTO "nhom_quyen" ("id", "ten_nhom_quyen", "mo_ta") VALUES
(1, 'ADMIN', 'Quan tri vien he thong'),
(2, 'NHAN_VIEN', 'Nhan vien ban hang'),
(3, 'KHACH_HANG', 'Khach hang');

-- Dữ liệu mẫu cho bảng chi_tiet_chuc_nang
INSERT INTO "chi_tiet_chuc_nang" ("id", "nhom_quyen_id", "chuc_nang_id") VALUES
(1, 1, 1), -- ADMIN có quyền quản lý người dùng
(2, 1, 2), -- ADMIN có quyền quản lý nhóm quyền
(3, 1, 3), -- ADMIN có quyền quản lý thuốc
(4, 2, 3); -- NHAN_VIEN có quyền quản lý thuốc

-- Dữ liệu mẫu cho bảng nguoi_dung
INSERT INTO "nguoi_dung" ("id", "ho_ten", "ten_dang_nhap", "mat_khau", "email", "so_dien_thoai", "dia_chi", "trang_thai") VALUES
(1, 'Admin', 'admin', '$2a$10$X7.H/dIHjh1QwJUPqU4kkOyz4gN5jRzQYZZOz6OmjPFJPYw0x9tIa', 'admin@example.com', '0123456789', 'Ha Noi', true),
(2, 'Nhan vien', 'nhanvien', '$2a$10$X7.H/dIHjh1QwJUPqU4kkOyz4gN5jRzQYZZOz6OmjPFJPYw0x9tIa', 'nhanvien@example.com', '0987654321', 'Ha Noi', true),
(3, 'Khach hang', 'khachhang', '$2a$10$X7.H/dIHjh1QwJUPqU4kkOyz4gN5jRzQYZZOz6OmjPFJPYw0x9tIa', 'khachhang@example.com', '0369852147', 'Ha Noi', true);

-- Dữ liệu mẫu cho bảng chi_tiet_nhom_quyen
INSERT INTO "chi_tiet_nhom_quyen" ("id", "nguoi_dung_id", "nhom_quyen_id") VALUES
(1, 1, 1), -- Admin thuộc nhóm ADMIN
(2, 2, 2), -- Nhân viên thuộc nhóm NHAN_VIEN
(3, 3, 3); -- Khách hàng thuộc nhóm KHACH_HANG
