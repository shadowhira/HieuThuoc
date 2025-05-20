-- Test data for revenue reporting and statistics functionality
-- This script adds additional transaction records with varied dates, products, and amounts
-- to properly test revenue reports across different periods (daily, monthly, yearly)

-- Insert additional orders with varied dates throughout 2024
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES 
-- January 2024
(15, '2024-01-05 10:15:00', '2024-01-05 10:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-01-07 14:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 12500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(16, '2024-01-12 09:30:00', '2024-01-12 09:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-01-15 11:45:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 18700, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(17, '2024-01-20 14:20:00', '2024-01-20 14:20:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-01-23 16:00:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 9800, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(18, '2024-01-28 11:10:00', '2024-01-28 11:10:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-01-30 13:20:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 14200, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),

-- February 2024
(19, '2024-02-03 08:45:00', '2024-02-03 08:45:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-02-05 10:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 7600, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(20, '2024-02-10 13:25:00', '2024-02-10 13:25:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-02-12 15:40:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 22300, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(21, '2024-02-17 16:50:00', '2024-02-17 16:50:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-02-19 18:15:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 16800, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(22, '2024-02-24 10:05:00', '2024-02-24 10:05:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-02-26 12:20:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 11400, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),

-- March 2024 (higher volume month)
(23, '2024-03-02 09:15:00', '2024-03-02 09:15:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-03-04 11:30:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 19500, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(24, '2024-03-05 14:40:00', '2024-03-05 14:40:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-03-07 16:55:00', 'CHUYEN_KHOAN', '0987654330', 'Bùi Văn Tiêu', 8900, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(25, '2024-03-09 11:25:00', '2024-03-09 11:25:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-03-11 13:40:00', 'THE_NGAN_HANG', '0987654326', 'Hoàng Văn Khách', 27600, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(26, '2024-03-12 16:50:00', '2024-03-12 16:50:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-03-14 19:05:00', 'VI_DIEN_TU', '0987654327', 'Ngô Thị Hàng', 13200, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(27, '2024-03-16 10:35:00', '2024-03-16 10:35:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-03-18 12:50:00', 'TIEN_MAT', '0987654328', 'Vũ Văn Mua', 15700, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(28, '2024-03-19 15:20:00', '2024-03-19 15:20:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-03-21 17:35:00', 'CHUYEN_KHOAN', '0987654329', 'Đặng Thị Sắm', 9300, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(29, '2024-03-23 12:05:00', '2024-03-23 12:05:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-03-25 14:20:00', 'THE_NGAN_HANG', '0987654330', 'Bùi Văn Tiêu', 21400, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(30, '2024-03-26 17:30:00', '2024-03-26 17:30:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-03-28 19:45:00', 'VI_DIEN_TU', '0987654326', 'Hoàng Văn Khách', 18200, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(31, '2024-03-30 11:15:00', '2024-03-30 11:15:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-04-01 13:30:00', 'TIEN_MAT', '0987654327', 'Ngô Thị Hàng', 16500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5);

-- Insert order details for the new orders
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Order 15 details (January)
(17, 5000, 1, 15, 9),
(18, 4000, 1, 15, 10),
(19, 3500, 1, 15, 13),

-- Order 16 details (January)
(20, 5500, 2, 16, 11),
(21, 3800, 2, 16, 14),

-- Order 17 details (January)
(22, 4000, 1, 17, 15),
(23, 5800, 1, 17, 16),

-- Order 18 details (January)
(24, 5000, 1, 18, 9),
(25, 4600, 2, 18, 12),

-- Order 19 details (February)
(26, 3800, 2, 19, 13),

-- Order 20 details (February)
(27, 5500, 2, 20, 11),
(28, 5000, 1, 20, 9),
(29, 3200, 2, 20, 14),

-- Order 21 details (February)
(30, 4000, 2, 21, 10),
(31, 4400, 2, 21, 15),

-- Order 22 details (February)
(32, 5700, 2, 22, 16),

-- Order 23 details (March)
(33, 5000, 2, 23, 9),
(34, 4800, 2, 23, 12),

-- Order 24 details (March)
(35, 4500, 1, 24, 11),
(36, 4400, 1, 24, 15),

-- Order 25 details (March)
(37, 5000, 2, 25, 9),
(38, 4000, 2, 25, 10),
(39, 4800, 2, 25, 12),

-- Order 26 details (March)
(40, 3600, 2, 26, 13),
(41, 3000, 2, 26, 14),

-- Order 27 details (March)
(42, 5500, 1, 27, 11),
(43, 5100, 2, 27, 16),

-- Order 28 details (March)
(44, 4700, 1, 28, 15),
(45, 4600, 1, 28, 12),

-- Order 29 details (March)
(46, 5000, 2, 29, 9),
(47, 4000, 1, 29, 10),
(48, 3700, 2, 29, 13),

-- Order 30 details (March)
(49, 4800, 2, 30, 12),
(50, 4300, 2, 30, 14),

-- Order 31 details (March)
(51, 5500, 1, 31, 11),
(52, 5500, 2, 31, 16);

-- Insert additional data for specific product performance analysis
-- These records will help analyze which products are best-selling
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Additional sales for product 9 (Azithromycin) - making it a best seller
(53, 5000, 3, 15, 9),
(54, 5000, 2, 16, 9),
(55, 5000, 4, 20, 9),
(56, 5000, 3, 23, 9),
(57, 5000, 5, 25, 9),
(58, 5000, 2, 29, 9),

-- Additional sales for product 11 (Levofloxacin) - making it another best seller
(59, 5500, 3, 17, 11),
(60, 5500, 2, 19, 11),
(61, 5500, 4, 21, 11),
(62, 5500, 3, 24, 11),
(63, 5500, 2, 27, 11),
(64, 5500, 3, 31, 11),

-- Additional sales for product 16 (Atorvastatin) - making it a third best seller
(65, 5500, 2, 18, 16),
(66, 5500, 3, 22, 16),
(67, 5500, 2, 26, 16),
(68, 5500, 4, 28, 16),
(69, 5500, 3, 30, 16);

-- Update the total amounts in the orders to reflect the additional items
UPDATE public.don_hang SET tong_tien = 27500 WHERE id = 15;
UPDATE public.don_hang SET tong_tien = 29700 WHERE id = 16;
UPDATE public.don_hang SET tong_tien = 26300 WHERE id = 17;
UPDATE public.don_hang SET tong_tien = 25600 WHERE id = 18;
UPDATE public.don_hang SET tong_tien = 18600 WHERE id = 19;
UPDATE public.don_hang SET tong_tien = 42300 WHERE id = 20;
UPDATE public.don_hang SET tong_tien = 38800 WHERE id = 21;
UPDATE public.don_hang SET tong_tien = 28200 WHERE id = 22;
UPDATE public.don_hang SET tong_tien = 35500 WHERE id = 23;
UPDATE public.don_hang SET tong_tien = 25900 WHERE id = 24;
UPDATE public.don_hang SET tong_tien = 47600 WHERE id = 25;
UPDATE public.don_hang SET tong_tien = 24200 WHERE id = 26;
UPDATE public.don_hang SET tong_tien = 27200 WHERE id = 27;
UPDATE public.don_hang SET tong_tien = 31300 WHERE id = 28;
UPDATE public.don_hang SET tong_tien = 31400 WHERE id = 29;
UPDATE public.don_hang SET tong_tien = 34700 WHERE id = 30;
UPDATE public.don_hang SET tong_tien = 38500 WHERE id = 31;
