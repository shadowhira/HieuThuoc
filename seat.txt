-- Additional data for pharmacy database

-- Additional Medicine Data
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Azithromycin 500mg', 'T016', 'B016', 3, 1, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 6 viên', 'VD-12360', '2026-06-30', 3000, 5000, 300, 30, 'Điều trị nhiễm khuẩn đường hô hấp, da và mô mềm', 'Nhiễm khuẩn đường hô hấp trên và dưới, nhiễm khuẩn da và mô mềm', 'Mẫn cảm với macrolide, suy gan nặng', 'Uống 1 viên/ngày, trong 3 ngày liên tiếp', 'Thuốc kháng sinh nhóm macrolide', 'azithromycin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Cefixime 200mg', 'T017', 'B017', 2, 2, 'Viên', 'Viên nang', 'Hộp 10 vỉ x 10 viên', 'VD-12361', '2026-06-30', 2500, 4000, 500, 50, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu', 'Nhiễm khuẩn đường hô hấp, tiết niệu, tai mũi họng', 'Mẫn cảm với cephalosporin', 'Uống 1 viên/lần, ngày 2 lần, sau khi ăn', 'Thuốc kháng sinh nhóm cephalosporin thế hệ 3', 'cefixime.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Levofloxacin 500mg', 'T018', 'B018', 4, 3, 'Viên', 'Viên nén bao phim', 'Hộp 1 vỉ x 10 viên', 'VD-12362', '2026-06-30', 3500, 5500, 400, 40, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu, da', 'Viêm phổi, viêm phế quản, nhiễm khuẩn tiết niệu, nhiễm khuẩn da', 'Mẫn cảm với quinolone, trẻ em dưới 18 tuổi, phụ nữ có thai', 'Uống 1 viên/ngày, trong 7-14 ngày tùy theo mức độ nhiễm khuẩn', 'Thuốc kháng sinh nhóm quinolone', 'levofloxacin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Diclofenac 50mg', 'T019', 'B019', 6, 4, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12363', '2026-06-30', 1000, 1800, 600, 60, 'Giảm đau, kháng viêm', 'Đau nhức xương khớp, viêm khớp, đau lưng, đau đầu', 'Loét dạ dày, tá tràng, suy thận, suy gan, phụ nữ có thai 3 tháng cuối', 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn', 'Thuốc kháng viêm không steroid', 'diclofenac.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Pantoprazole 40mg', 'T020', 'B020', 11, 5, 'Viên', 'Viên nén bao tan trong ruột', 'Hộp 3 vỉ x 10 viên', 'VD-12364', '2026-06-30', 2200, 3500, 400, 40, 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản, hội chứng Zollinger-Ellison', 'Mẫn cảm với pantoprazole', 'Uống 1 viên/ngày, trước bữa ăn sáng', 'Thuốc ức chế bơm proton', 'pantoprazole.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Metformin 500mg', 'T021', 'B021', 8, 1, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12365', '2026-06-30', 1500, 2500, 500, 50, 'Điều trị đái tháo đường type 2', 'Đái tháo đường type 2, hội chứng buồng trứng đa nang', 'Suy thận, suy gan, nhiễm toan chuyển hóa, phụ nữ có thai', 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn', 'Thuốc điều trị đái tháo đường', 'metformin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Losartan 50mg', 'T022', 'B022', 7, 2, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12366', '2026-06-30', 2000, 3200, 400, 40, 'Điều trị tăng huyết áp, suy tim', 'Tăng huyết áp, suy tim, bảo vệ thận ở bệnh nhân đái tháo đường', 'Phụ nữ có thai, suy gan nặng', 'Uống 1 viên/ngày, có thể uống cùng hoặc không cùng bữa ăn', 'Thuốc ức chế thụ thể angiotensin II', 'losartan.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Atorvastatin 20mg', 'T023', 'B023', 9, 3, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12367', '2026-06-30', 2500, 4000, 300, 30, 'Điều trị tăng cholesterol máu', 'Tăng cholesterol máu, dự phòng bệnh tim mạch', 'Phụ nữ có thai, cho con bú, bệnh gan tiến triển', 'Uống 1 viên/ngày, vào buổi tối', 'Thuốc ức chế HMG-CoA reductase', 'atorvastatin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');

-- Additional Medicine Components
INSERT INTO thanh_phan_thuoc (thuoc_id, ten_thanh_phan, ham_luong, don_vi) VALUES
(16, 'Azithromycin', '500', 'mg'),
(17, 'Cefixime', '200', 'mg'),
(18, 'Levofloxacin', '500', 'mg'),
(19, 'Diclofenac', '50', 'mg'),
(20, 'Pantoprazole', '40', 'mg'),
(21, 'Metformin', '500', 'mg'),
(22, 'Losartan', '50', 'mg'),
(23, 'Atorvastatin', '20', 'mg');

-- Additional Medicine Target Groups
INSERT INTO doi_tuong_sd_thuoc (thuoc_id, doi_tuong_id) VALUES
(16, 1), -- Azithromycin - Người lớn
(16, 7), -- Azithromycin - Thanh thiếu niên
(17, 1), -- Cefixime - Người lớn
(17, 2), -- Cefixime - Trẻ em
(17, 7), -- Cefixime - Thanh thiếu niên
(18, 1), -- Levofloxacin - Người lớn
(18, 3), -- Levofloxacin - Người cao tuổi
(19, 1), -- Diclofenac - Người lớn
(19, 3), -- Diclofenac - Người cao tuổi
(20, 1), -- Pantoprazole - Người lớn
(20, 3), -- Pantoprazole - Người cao tuổi
(21, 1), -- Metformin - Người lớn
(21, 3), -- Metformin - Người cao tuổi
(22, 1), -- Losartan - Người lớn
(22, 3), -- Losartan - Người cao tuổi
(23, 1), -- Atorvastatin - Người lớn
(23, 3); -- Atorvastatin - Người cao tuổi

-- Additional Inventory Data
INSERT INTO ton_kho (thuoc_id, so_lo, han_su_dung, so_luong, vi_tri, created_at, update_at) VALUES
(16, 'LO031', '2026-06-30', 150, 'Kệ P1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(16, 'LO032', '2026-03-31', 150, 'Kệ P2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(17, 'LO033', '2026-06-30', 250, 'Kệ Q1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(17, 'LO034', '2026-03-31', 250, 'Kệ Q2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(18, 'LO035', '2026-06-30', 200, 'Kệ R1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(18, 'LO036', '2026-03-31', 200, 'Kệ R2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(19, 'LO037', '2026-06-30', 300, 'Kệ S1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(19, 'LO038', '2026-03-31', 300, 'Kệ S2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(20, 'LO039', '2026-06-30', 200, 'Kệ T1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(20, 'LO040', '2026-03-31', 200, 'Kệ T2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(21, 'LO041', '2026-06-30', 250, 'Kệ U1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(21, 'LO042', '2026-03-31', 250, 'Kệ U2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(22, 'LO043', '2026-06-30', 200, 'Kệ V1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(22, 'LO044', '2026-03-31', 200, 'Kệ V2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(23, 'LO045', '2026-06-30', 150, 'Kệ W1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(23, 'LO046', '2026-03-31', 150, 'Kệ W2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Additional Import Receipt Data
INSERT INTO phieu_nhap (nha_cung_cap_id, nguoi_dung_id, tong_tien, created_at, update_at) VALUES
(1, 3, 2500000, '2024-01-15', '2024-01-15'),
(2, 4, 3000000, '2024-02-15', '2024-02-15'),
(3, 3, 2800000, '2024-03-15', '2024-03-15'),
(1, 4, 2200000, '2024-03-20', '2024-03-20'),
(2, 3, 1800000, '2024-03-25', '2024-03-25');

-- Additional Import Receipt Details
INSERT INTO chi_tiet_phieu_nhap (phieu_nhap_id, thuoc_id, han_su_dung, so_luong, don_gia) VALUES
(6, 16, '2026-06-30', 150, 3000),
(6, 17, '2026-06-30', 250, 2500),
(6, 18, '2026-06-30', 200, 3500),
(7, 19, '2026-06-30', 300, 1000),
(7, 20, '2026-06-30', 200, 2200),
(7, 1, '2026-06-30', 300, 1000),
(7, 2, '2026-06-30', 400, 500),
(8, 3, '2026-06-30', 200, 2000),
(8, 4, '2026-06-30', 200, 1500),
(8, 5, '2026-06-30', 200, 1200),
(8, 16, '2026-03-31', 150, 3000),
(8, 17, '2026-03-31', 250, 2500),
(9, 21, '2026-06-30', 250, 1500),
(9, 22, '2026-06-30', 200, 2000),
(9, 23, '2026-06-30', 150, 2500),
(10, 21, '2026-03-31', 250, 1500),
(10, 22, '2026-03-31', 200, 2000),
(10, 23, '2026-03-31', 150, 2500);

-- Additional Promotion Data
INSERT INTO khuyen_mai (ten_chuong_trinh, mo_ta, ngay_bat_dau, ngay_ket_thuc, trang_thai) VALUES
('Khuyến mãi mùa hè 2024', 'Giảm giá các sản phẩm trong mùa hè 2024', '2024-06-01', '2024-08-31', true),
('Khuyến mãi khai trương chi nhánh mới', 'Giảm giá nhân dịp khai trương chi nhánh mới', '2024-04-01', '2024-04-30', true);

-- Additional Promotion Details
INSERT INTO chi_tiet_khuyen_mai (khuyen_mai_id, thuoc_id, giam_gia) VALUES
(6, 16, 15),
(6, 17, 10),
(6, 18, 20),
(6, 19, 15),
(6, 20, 10),
(6, 21, 15),
(6, 22, 10),
(6, 23, 20),
(7, 1, 20),
(7, 2, 20),
(7, 3, 20),
(7, 4, 20),
(7, 5, 20),
(7, 21, 20),
(7, 22, 20),
(7, 23, 20);

-- Additional Order Data
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 9500, '2024-02-23', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', '2024-02-15', '2024-02-20'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 12000, '2024-03-06', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', '2024-02-18', '2024-02-23'),
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 8500, '2024-02-15', 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN', '2024-02-20', '2024-02-25'),
(9, 5, 'Đặng Thị Sắm', '0987654329', 'Hải Phòng', 'customer4@gmail.com', 0, 10500, '2024-02-29', 'DANG_GIAO', 'VI_DIEN_TU', 'DA_THANH_TOAN', '2024-03-01', '2024-03-01'),
(10, 5, 'Bùi Văn Tiêu', '0987654330', 'Cần Thơ', 'customer5@gmail.com', 0, 15000, NULL, 'DANG_XU_LY', 'TIEN_MAT', 'CHUA_THANH_TOAN', '2024-03-10', '2024-03-10'),
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 7500, '2024-03-20', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', '2024-03-15', '2024-03-15'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 9700, '2024-03-25', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', '2024-03-18', '2024-03-18');

-- Additional Order Details
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
(11, 16, 1, 5000),
(11, 17, 1, 4000),
(11, 6, 1, 500),
(12, 18, 1, 5500),
(12, 19, 1, 1800),
(12, 20, 1, 3500),
(12, 2, 1, 1200),
(13, 3, 1, 3000),
(13, 4, 1, 2500),
(13, 16, 1, 3000),
(14, 17, 1, 4000),
(14, 18, 1, 5500),
(14, 5, 1, 1000),
(15, 19, 2, 1800),
(15, 20, 2, 3500),
(15, 1, 1, 1500),
(15, 2, 1, 1200),
(16, 21, 1, 2500),
(16, 22, 1, 3200),
(16, 23, 1, 1800),
(17, 21, 1, 2500),
(17, 22, 1, 3200),
(17, 23, 1, 4000);

-- Additional Review Data
INSERT INTO danh_gia (thuoc_id, nguoi_dung_id, danh_gia_id, diem_so, danh_gia, created_at, update_at) VALUES
(16, 6, NULL, 5, 'Thuốc rất hiệu quả, tôi đã khỏi viêm họng sau 3 ngày sử dụng.', '2024-02-25', '2024-02-25'),
(17, 7, NULL, 4, 'Thuốc tốt, con tôi đã khỏi viêm phổi sau một đợt điều trị.', '2024-02-28', '2024-02-28'),
(18, 8, NULL, 5, 'Thuốc trị viêm phổi rất hiệu quả, tôi đã khỏi bệnh sau 7 ngày.', '2024-03-05', '2024-03-05'),
(19, 9, NULL, 4, 'Thuốc giảm đau hiệu quả, nhưng hơi khó uống.', '2024-03-08', '2024-03-08'),
(20, 10, NULL, 5, 'Thuốc trị đau dạ dày rất tốt, tôi không còn đau sau 2 ngày sử dụng.', '2024-03-12', '2024-03-12'),
(16, 3, 6, NULL, 'Cảm ơn bạn đã đánh giá. Azithromycin là kháng sinh mạnh và hiệu quả với nhiều loại nhiễm khuẩn.', '2024-02-26', '2024-02-26'),
(17, 3, 7, NULL, 'Cảm ơn bạn đã đánh giá. Cefixime là lựa chọn tốt cho trẻ em vì có thể dùng đường uống và ít tác dụng phụ.', '2024-03-01', '2024-03-01'),
(18, 4, 8, NULL, 'Cảm ơn bạn đã đánh giá. Levofloxacin là kháng sinh phổ rộng hiệu quả với nhiều loại nhiễm khuẩn.', '2024-03-06', '2024-03-06'),
(19, 4, 9, NULL, 'Cảm ơn bạn đã đánh giá. Diclofenac có thể gây khó chịu dạ dày, nên uống sau khi ăn để giảm tác dụng phụ.', '2024-03-09', '2024-03-09'),
(20, 3, 10, NULL, 'Cảm ơn bạn đã đánh giá. Pantoprazole là thuốc ức chế bơm proton hiệu quả trong điều trị các bệnh lý dạ dày.', '2024-03-13', '2024-03-13');

-- Additional Drug Interaction Data
INSERT INTO tuong_tac_thuoc (hoat_chat1, hoat_chat2, co_che, hau_qua, xu_tri) VALUES
('Azithromycin', 'Warfarin', 'Azithromycin ức chế chuyển hóa warfarin', 'Tăng tác dụng chống đông của warfarin, tăng nguy cơ xuất huyết', 'Theo dõi INR chặt chẽ, điều chỉnh liều warfarin nếu cần'),
('Cefixime', 'Alcohol', 'Cefixime có thể gây phản ứng disulfiram khi uống cùng rượu', 'Đỏ bừng, buồn nôn, nôn, đau đầu, hạ huyết áp', 'Tránh uống rượu trong khi dùng cefixime và 3 ngày sau khi ngừng thuốc'),
('Levofloxacin', 'Theophylline', 'Levofloxacin ức chế chuyển hóa theophylline', 'Tăng nồng độ theophylline trong máu, tăng nguy cơ độc tính', 'Giảm liều theophylline, theo dõi nồng độ theophylline trong máu'),
('Diclofenac', 'Lithium', 'Diclofenac làm giảm thải trừ lithium qua thận', 'Tăng nồng độ lithium trong máu, tăng nguy cơ độc tính', 'Theo dõi nồng độ lithium trong máu, điều chỉnh liều lithium nếu cần'),
('Pantoprazole', 'Atazanavir', 'Pantoprazole làm giảm hấp thu atazanavir do tăng pH dạ dày', 'Giảm nồng độ atazanavir trong máu, giảm hiệu quả điều trị', 'Tránh phối hợp, thay thế pantoprazole bằng thuốc khác nếu có thể');

-- Additional Notification Data
INSERT INTO thong_bao (tieu_de, noi_dung, hinh_anh, link_lien_ket, loai_thong_bao, trang_thai, created_at, update_at) VALUES
('Cập nhật giá thuốc mới', 'Một số sản phẩm đã được cập nhật giá mới. Vui lòng kiểm tra!', 'price_update.jpg', '/medicines', 'HE_THONG', false, '2024-03-01', '2024-03-01'),
('Thuốc mới đã nhập kho', 'Các loại thuốc mới đã được nhập kho. Vui lòng kiểm tra!', 'new_medicine.jpg', '/inventory', 'GIAO_DICH', false, '2024-03-05', '2024-03-05'),
('Khuyến mãi khai trương chi nhánh mới', 'Chương trình khuyến mãi khai trương chi nhánh mới sẽ bắt đầu từ ngày 01/04/2024. Giảm giá lên đến 20%!', 'new_branch.jpg', '/promotions', 'KHUYEN_MAI', false, '2024-03-15', '2024-03-15');

-- Additional Notification Recipients
INSERT INTO nguoi_nhan_thong_bao (thong_bao_id, nguoi_dung_id) VALUES
(7, 1),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(8, 1),
(8, 2),
(8, 3),
(8, 4),
(9, 1),
(9, 2),
(9, 3),
(9, 4),
(9, 5);

-- Additional Activity Log Data
INSERT INTO lich_su_hoat_dong (hanh_dong, mo_ta, nguoi_dung_id, created_at, update_at) VALUES
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 1, '2024-03-01 08:00:00', '2024-03-01 08:00:00'),
('THÊM MỚI', 'Thêm mới thuốc Azithromycin 500mg', 1, '2024-03-01 09:00:00', '2024-03-01 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin thuốc Cefixime 200mg', 1, '2024-03-01 10:00:00', '2024-03-01 10:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 2, '2024-03-02 08:00:00', '2024-03-02 08:00:00'),
('THÊM MỚI', 'Thêm mới chương trình khuyến mãi', 2, '2024-03-02 09:00:00', '2024-03-02 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin nhà cung cấp', 2, '2024-03-02 10:00:00', '2024-03-02 10:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 3, '2024-03-03 08:00:00', '2024-03-03 08:00:00'),
('THÊM MỚI', 'Thêm mới phiếu nhập kho', 3, '2024-03-03 09:00:00', '2024-03-03 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin tồn kho', 3, '2024-03-03 10:00:00', '2024-03-03 10:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 4, '2024-03-04 08:00:00', '2024-03-04 08:00:00'),
('THÊM MỚI', 'Thêm mới phiếu nhập kho', 4, '2024-03-04 09:00:00', '2024-03-04 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin tồn kho', 4, '2024-03-04 10:00:00', '2024-03-04 10:00:00');
