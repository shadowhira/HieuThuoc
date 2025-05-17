-- Dữ liệu mẫu cho danh_muc_thuoc
INSERT INTO danh_muc_thuoc (id, ten_danh_muc, mo_ta) VALUES
(1, 'Thuốc kháng sinh', 'Các loại thuốc kháng sinh'),
(2, 'Thuốc giảm đau', 'Các loại thuốc giảm đau'),
(3, 'Vitamin và khoáng chất', 'Các loại vitamin và khoáng chất'),
(4, 'Thuốc tim mạch', 'Các loại thuốc điều trị bệnh tim mạch'),
(5, 'Thuốc tiêu hóa', 'Các loại thuốc điều trị bệnh tiêu hóa');

-- Dữ liệu mẫu cho loai_thuoc
INSERT INTO loai_thuoc (id, ten_loai, mo_ta, danh_muc_thuoc_id) VALUES
(1, 'Kháng sinh beta-lactam', 'Nhóm kháng sinh beta-lactam', 1),
(2, 'Giảm đau không steroid', 'Nhóm giảm đau không steroid', 2),
(3, 'Vitamin D', 'Nhóm vitamin D', 3),
(4, 'Macrolide', 'Thuốc kháng sinh nhóm Macrolide', 1),
(5, 'Quinolone', 'Thuốc kháng sinh nhóm Quinolone', 1),
(6, 'NSAIDs', 'Thuốc kháng viêm không steroid', 2),
(7, 'Antihypertensive', 'Thuốc điều trị tăng huyết áp', 4),
(8, 'Proton pump inhibitor', 'Thuốc ức chế bơm proton', 5);

-- Dữ liệu mẫu cho nha_san_xuat
INSERT INTO nha_san_xuat (id, ten_nha_san_xuat, dia_chi, so_dien_thoai, email, website) VALUES
(1, 'Công ty Dược phẩm ABC', '123 Đường A, Quận B, TP.HCM', '0123456789', 'abc@example.com', 'https://abc.example.com'),
(2, 'Công ty Dược phẩm XYZ', '456 Đường C, Quận D, Hà Nội', '0987654321', 'xyz@example.com', 'https://xyz.example.com'),
(3, 'Công ty Dược phẩm Hà Nội', 'Hà Nội', '0987654322', 'contact@hanoi-pharma.com', 'https://hanoi-pharma.com'),
(4, 'Công ty Dược phẩm TP.HCM', 'TP.HCM', '0987654323', 'contact@hcm-pharma.com', 'https://hcm-pharma.com'),
(5, 'Công ty Dược phẩm Đà Nẵng', 'Đà Nẵng', '0987654324', 'contact@danang-pharma.com', 'https://danang-pharma.com');

-- Dữ liệu mẫu cho doi_tuong
INSERT INTO doi_tuong (id, ten_doi_tuong, mo_ta) VALUES
(1, 'Người lớn', 'Người từ 18 tuổi trở lên'),
(2, 'Trẻ em', 'Trẻ em từ 2-12 tuổi'),
(3, 'Người cao tuổi', 'Người từ 65 tuổi trở lên'),
(4, 'Phụ nữ có thai', 'Phụ nữ đang mang thai'),
(5, 'Phụ nữ cho con bú', 'Phụ nữ đang cho con bú'),
(6, 'Trẻ sơ sinh', 'Trẻ dưới 2 tuổi'),
(7, 'Thanh thiếu niên', 'Người từ 12-18 tuổi');

-- Dữ liệu mẫu cho thuoc
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai) VALUES
(1, 'Paracetamol 500mg', 'PARA500', '8936059580011', 2, 1, 'Viên', 'Viên nén bao phim', 'Hộp 10 vỉ x 10 viên', 'VD-12345', '2025-12-31', 5000, 7000, 100, 20, 'Giảm đau, hạ sốt', 'Đau đầu, đau răng, đau cơ, đau sau phẫu thuật, đau do chấn thương, đau kinh, sốt', 'Mẫn cảm với paracetamol, bệnh gan nặng', 'Người lớn: 1-2 viên/lần, 3-4 lần/ngày. Trẻ em trên 12 tuổi: 1 viên/lần, 3-4 lần/ngày', 'Thuốc giảm đau, hạ sốt thông dụng', 'paracetamol.jpg', true),
(2, 'Amoxicillin 500mg', 'AMOX500', '8936059580022', 1, 2, 'Viên', 'Viên nang cứng', 'Hộp 10 vỉ x 10 viên', 'VD-23456', '2025-12-31', 8000, 12000, 50, 10, 'Kháng sinh điều trị nhiễm khuẩn', 'Nhiễm khuẩn đường hô hấp, tiêu hóa, tiết niệu, da và mô mềm', 'Mẫn cảm với penicillin, bệnh bạch cầu đơn nhân nhiễm khuẩn', 'Người lớn: 1 viên/lần, 3 lần/ngày. Trẻ em trên 12 tuổi: 1 viên/lần, 3 lần/ngày', 'Kháng sinh nhóm beta-lactam', 'amoxicillin.jpg', true),
(3, 'Azithromycin 500mg', 'AZIT500', '8936059580033', 4, 3, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 6 viên', 'VD-12360', '2026-06-30', 3000, 5000, 300, 30, 'Điều trị nhiễm khuẩn đường hô hấp, da và mô mềm', 'Nhiễm khuẩn đường hô hấp trên và dưới, nhiễm khuẩn da và mô mềm', 'Mẫn cảm với macrolide, suy gan nặng', 'Uống 1 viên/ngày, trong 3 ngày liên tiếp', 'Thuốc kháng sinh nhóm macrolide', 'azithromycin.jpg', true),
(4, 'Levofloxacin 500mg', 'LEVO500', '8936059580044', 5, 4, 'Viên', 'Viên nén bao phim', 'Hộp 1 vỉ x 10 viên', 'VD-12362', '2026-06-30', 3500, 5500, 400, 40, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu, da', 'Viêm phổi, viêm phế quản, nhiễm khuẩn tiết niệu, nhiễm khuẩn da', 'Mẫn cảm với quinolone, trẻ em dưới 18 tuổi, phụ nữ có thai', 'Uống 1 viên/ngày, trong 7-14 ngày tùy theo mức độ nhiễm khuẩn', 'Thuốc kháng sinh nhóm quinolone', 'levofloxacin.jpg', true),
(5, 'Diclofenac 50mg', 'DICL050', '8936059580055', 6, 5, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12363', '2026-06-30', 1000, 1800, 600, 60, 'Giảm đau, kháng viêm', 'Đau nhức xương khớp, viêm khớp, đau lưng, đau đầu', 'Loét dạ dày, tá tràng, suy thận, suy gan, phụ nữ có thai 3 tháng cuối', 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn', 'Thuốc kháng viêm không steroid', 'diclofenac.jpg', true);

-- Dữ liệu mẫu cho doi_tuong_sd_thuoc
INSERT INTO doi_tuong_sd_thuoc (thuoc_id, doi_tuong_id) VALUES
(1, 1), -- Paracetamol cho người lớn
(1, 2), -- Paracetamol cho trẻ em
(1, 3), -- Paracetamol cho người cao tuổi
(2, 1), -- Amoxicillin cho người lớn
(2, 2), -- Amoxicillin cho trẻ em
(3, 1), -- Azithromycin cho người lớn
(3, 7), -- Azithromycin cho thanh thiếu niên
(4, 1), -- Levofloxacin cho người lớn
(4, 3), -- Levofloxacin cho người cao tuổi
(5, 1), -- Diclofenac cho người lớn
(5, 3); -- Diclofenac cho người cao tuổi
