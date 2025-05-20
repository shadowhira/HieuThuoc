-- Dữ liệu bổ sung để kiểm thử chức năng báo cáo thống kê
-- Lưu ý: Không sửa đổi các thuộc tính trong file seat.sql

-- 1. Dữ liệu đơn hàng theo ngày (để kiểm thử báo cáo doanh thu theo ngày)
-- Đơn hàng hôm nay
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 15000, CURRENT_DATE, 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 18000, CURRENT_DATE, 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 12000, CURRENT_DATE, 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Chi tiết đơn hàng hôm nay
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 9, 2, 5000),
((SELECT MAX(id) FROM don_hang), 10, 1, 4000),
((SELECT MAX(id) FROM don_hang), 11, 1, 1000),
((SELECT MAX(id) - 1 FROM don_hang), 12, 3, 1800),
((SELECT MAX(id) - 1 FROM don_hang), 13, 2, 3500),
((SELECT MAX(id) - 1 FROM don_hang), 14, 1, 2500),
((SELECT MAX(id) - 2 FROM don_hang), 15, 2, 3200),
((SELECT MAX(id) - 2 FROM don_hang), 16, 1, 4000),
((SELECT MAX(id) - 2 FROM don_hang), 9, 1, 1600);

-- Đơn hàng hôm qua
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(9, 5, 'Đặng Thị Sắm', '0987654329', 'Hải Phòng', 'customer4@gmail.com', 0, 13500, CURRENT_DATE - INTERVAL '1 day', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', CURRENT_TIMESTAMP - INTERVAL '1 day', CURRENT_TIMESTAMP - INTERVAL '1 day'),
(10, 5, 'Bùi Văn Tiêu', '0987654330', 'Cần Thơ', 'customer5@gmail.com', 0, 16000, CURRENT_DATE - INTERVAL '1 day', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', CURRENT_TIMESTAMP - INTERVAL '1 day', CURRENT_TIMESTAMP - INTERVAL '1 day');

-- Chi tiết đơn hàng hôm qua
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 9, 1, 5000),
((SELECT MAX(id) FROM don_hang), 10, 1, 4000),
((SELECT MAX(id) FROM don_hang), 11, 1, 4500),
((SELECT MAX(id) - 1 FROM don_hang), 12, 2, 1800),
((SELECT MAX(id) - 1 FROM don_hang), 13, 2, 3500),
((SELECT MAX(id) - 1 FROM don_hang), 14, 1, 2500);

-- 2. Dữ liệu đơn hàng theo giờ (để kiểm thử báo cáo doanh thu theo giờ)
-- Sáng sớm (6-8h)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 9000, CURRENT_DATE, 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN',
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 06:30:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 06:30:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng sáng sớm
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 9, 1, 5000),
((SELECT MAX(id) FROM don_hang), 10, 1, 4000);

-- Buổi sáng (9-11h)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 10000, CURRENT_DATE, 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN',
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 10:15:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 10:15:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng buổi sáng
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 11, 1, 5500),
((SELECT MAX(id) FROM don_hang), 12, 2, 1800),
((SELECT MAX(id) FROM don_hang), 13, 1, 900);

-- Buổi trưa (12-14h)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 12000, CURRENT_DATE, 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN',
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 12:45:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 12:45:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng buổi trưa
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 14, 2, 2500),
((SELECT MAX(id) FROM don_hang), 15, 1, 3200),
((SELECT MAX(id) FROM don_hang), 16, 1, 3800);

-- Buổi chiều (15-17h)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(9, 5, 'Đặng Thị Sắm', '0987654329', 'Hải Phòng', 'customer4@gmail.com', 0, 15000, CURRENT_DATE, 'DA_GIAO', 'VI_DIEN_TU', 'DA_THANH_TOAN',
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 16:20:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 16:20:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng buổi chiều
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 9, 1, 5000),
((SELECT MAX(id) FROM don_hang), 10, 1, 4000),
((SELECT MAX(id) FROM don_hang), 11, 1, 5500),
((SELECT MAX(id) FROM don_hang), 12, 1, 500);

-- Buổi tối (18-22h)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(10, 5, 'Bùi Văn Tiêu', '0987654330', 'Cần Thơ', 'customer5@gmail.com', 0, 18000, CURRENT_DATE, 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN',
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 19:30:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') || ' 19:30:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng buổi tối
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 13, 2, 3500),
((SELECT MAX(id) FROM don_hang), 14, 2, 2500),
((SELECT MAX(id) FROM don_hang), 15, 1, 3200),
((SELECT MAX(id) FROM don_hang), 16, 1, 2800);

-- 3. Dữ liệu đơn hàng theo tháng (để kiểm thử báo cáo doanh thu theo tháng)
-- Tháng 1
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 25000, '2024-01-15', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN',
 TO_TIMESTAMP('2024-01-15 10:00:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP('2024-01-15 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng tháng 1
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 9, 3, 5000),
((SELECT MAX(id) FROM don_hang), 10, 2, 4000),
((SELECT MAX(id) FROM don_hang), 11, 1, 2000);

-- Tháng 2
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 30000, '2024-02-20', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN',
 TO_TIMESTAMP('2024-02-20 14:30:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP('2024-02-20 14:30:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng tháng 2
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 12, 5, 1800),
((SELECT MAX(id) FROM don_hang), 13, 3, 3500),
((SELECT MAX(id) FROM don_hang), 14, 2, 2500);

-- Tháng 3
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 35000, '2024-03-10', 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN',
 TO_TIMESTAMP('2024-03-10 09:15:00', 'YYYY-MM-DD HH24:MI:SS'),
 TO_TIMESTAMP('2024-03-10 09:15:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Chi tiết đơn hàng tháng 3
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 15, 4, 3200),
((SELECT MAX(id) FROM don_hang), 16, 3, 4000),
((SELECT MAX(id) FROM don_hang), 9, 2, 5000);

-- 4. Dữ liệu tồn kho (để kiểm thử báo cáo tồn kho)
-- Thuốc sắp hết hạn (trong vòng 1 tháng)
INSERT INTO ton_kho (thuoc_id, so_lo, han_su_dung, so_luong, vi_tri, created_at, update_at) VALUES
(9, 'LO047', CURRENT_DATE + INTERVAL '25 days', 50, 'Kệ X1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'LO048', CURRENT_DATE + INTERVAL '20 days', 30, 'Kệ X2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 'LO049', CURRENT_DATE + INTERVAL '15 days', 20, 'Kệ X3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Thuốc có số lượng dưới ngưỡng cảnh báo
UPDATE thuoc SET so_luong_ton = 25, nguong_canh_bao = 30 WHERE id = 12;
UPDATE thuoc SET so_luong_ton = 15, nguong_canh_bao = 20 WHERE id = 13;
UPDATE thuoc SET so_luong_ton = 10, nguong_canh_bao = 15 WHERE id = 14;

-- 5. Dữ liệu đánh giá (để kiểm thử báo cáo đánh giá sản phẩm)
INSERT INTO danh_gia (thuoc_id, nguoi_dung_id, danh_gia_id, diem_so, danh_gia, created_at, update_at) VALUES
(9, 6, NULL, 5, 'Thuốc rất hiệu quả, tôi đã khỏi viêm họng sau 3 ngày sử dụng.', CURRENT_TIMESTAMP - INTERVAL '10 days', CURRENT_TIMESTAMP - INTERVAL '10 days'),
(9, 7, NULL, 4, 'Thuốc tốt, nhưng hơi đắt.', CURRENT_TIMESTAMP - INTERVAL '9 days', CURRENT_TIMESTAMP - INTERVAL '9 days'),
(9, 8, NULL, 5, 'Thuốc rất hiệu quả, sẽ mua lại.', CURRENT_TIMESTAMP - INTERVAL '8 days', CURRENT_TIMESTAMP - INTERVAL '8 days'),
(10, 6, NULL, 4, 'Thuốc hiệu quả với viêm phổi của tôi.', CURRENT_TIMESTAMP - INTERVAL '7 days', CURRENT_TIMESTAMP - INTERVAL '7 days'),
(10, 7, NULL, 3, 'Thuốc có tác dụng nhưng hơi chậm.', CURRENT_TIMESTAMP - INTERVAL '6 days', CURRENT_TIMESTAMP - INTERVAL '6 days'),
(11, 8, NULL, 5, 'Thuốc trị viêm phổi rất hiệu quả, tôi đã khỏi bệnh sau 7 ngày.', CURRENT_TIMESTAMP - INTERVAL '5 days', CURRENT_TIMESTAMP - INTERVAL '5 days'),
(11, 9, NULL, 4, 'Thuốc tốt nhưng có một số tác dụng phụ nhẹ.', CURRENT_TIMESTAMP - INTERVAL '4 days', CURRENT_TIMESTAMP - INTERVAL '4 days'),
(12, 10, NULL, 5, 'Thuốc giảm đau rất hiệu quả.', CURRENT_TIMESTAMP - INTERVAL '3 days', CURRENT_TIMESTAMP - INTERVAL '3 days'),
(13, 6, NULL, 5, 'Thuốc trị đau dạ dày rất tốt, tôi không còn đau sau 2 ngày sử dụng.', CURRENT_TIMESTAMP - INTERVAL '2 days', CURRENT_TIMESTAMP - INTERVAL '2 days'),
(14, 7, NULL, 4, 'Thuốc điều trị đái tháo đường hiệu quả.', CURRENT_TIMESTAMP - INTERVAL '1 day', CURRENT_TIMESTAMP - INTERVAL '1 day');

-- 6. Dữ liệu nhập kho (để kiểm thử báo cáo nhập kho)
-- Nhập kho tháng hiện tại
INSERT INTO phieu_nhap (nha_cung_cap_id, nguoi_dung_id, tong_tien, created_at, update_at) VALUES
(1, 3, 3000000, CURRENT_DATE - INTERVAL '5 days', CURRENT_DATE - INTERVAL '5 days'),
(2, 4, 2500000, CURRENT_DATE - INTERVAL '3 days', CURRENT_DATE - INTERVAL '3 days');

-- Chi tiết phiếu nhập
INSERT INTO chi_tiet_phieu_nhap (phieu_nhap_id, thuoc_id, han_su_dung, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM phieu_nhap), 9, CURRENT_DATE + INTERVAL '2 years', 200, 3000),
((SELECT MAX(id) FROM phieu_nhap), 10, CURRENT_DATE + INTERVAL '2 years', 150, 2500),
((SELECT MAX(id) FROM phieu_nhap), 11, CURRENT_DATE + INTERVAL '2 years', 100, 3500),
((SELECT MAX(id) - 1 FROM phieu_nhap), 12, CURRENT_DATE + INTERVAL '2 years', 300, 1000),
((SELECT MAX(id) - 1 FROM phieu_nhap), 13, CURRENT_DATE + INTERVAL '2 years', 250, 2200),
((SELECT MAX(id) - 1 FROM phieu_nhap), 14, CURRENT_DATE + INTERVAL '2 years', 200, 1500);

-- 7. Dữ liệu khuyến mãi (để kiểm thử báo cáo khuyến mãi)
INSERT INTO khuyen_mai (ten_chuong_trinh, mo_ta, ngay_bat_dau, ngay_ket_thuc, trang_thai) VALUES
('Khuyến mãi tháng 4/2024', 'Giảm giá các sản phẩm trong tháng 4/2024', '2024-04-01', '2024-04-30', true),
('Khuyến mãi tháng 5/2024', 'Giảm giá các sản phẩm trong tháng 5/2024', '2024-05-01', '2024-05-31', true);

-- Chi tiết khuyến mãi
INSERT INTO chi_tiet_khuyen_mai (khuyen_mai_id, thuoc_id, giam_gia) VALUES
((SELECT MAX(id) FROM khuyen_mai), 9, 10),
((SELECT MAX(id) FROM khuyen_mai), 10, 15),
((SELECT MAX(id) FROM khuyen_mai), 11, 20),
((SELECT MAX(id) FROM khuyen_mai), 12, 10),
((SELECT MAX(id) FROM khuyen_mai), 13, 15),
((SELECT MAX(id) - 1 FROM khuyen_mai), 14, 20),
((SELECT MAX(id) - 1 FROM khuyen_mai), 15, 10),
((SELECT MAX(id) - 1 FROM khuyen_mai), 16, 15),
((SELECT MAX(id) - 1 FROM khuyen_mai), 9, 20),
((SELECT MAX(id) - 1 FROM khuyen_mai), 10, 10);

-- 8. Dữ liệu đơn hàng trả lại (để kiểm thử báo cáo đơn hàng trả lại)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 9000, CURRENT_DATE - INTERVAL '5 days', 'TRA_HANG', 'TIEN_MAT', 'DA_HOAN_TIEN',
 CURRENT_TIMESTAMP - INTERVAL '5 days', CURRENT_TIMESTAMP - INTERVAL '3 days'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 12000, CURRENT_DATE - INTERVAL '4 days', 'TRA_HANG', 'CHUYEN_KHOAN', 'DA_HOAN_TIEN',
 CURRENT_TIMESTAMP - INTERVAL '4 days', CURRENT_TIMESTAMP - INTERVAL '2 days');

-- Chi tiết đơn hàng trả lại
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
((SELECT MAX(id) FROM don_hang), 9, 1, 5000),
((SELECT MAX(id) FROM don_hang), 10, 1, 4000),
((SELECT MAX(id) - 1 FROM don_hang), 11, 1, 5500),
((SELECT MAX(id) - 1 FROM don_hang), 12, 2, 1800),
((SELECT MAX(id) - 1 FROM don_hang), 13, 1, 2900);
