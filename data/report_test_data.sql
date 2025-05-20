-- Test data for comprehensive reporting and statistics functionality
-- This script adds diverse data for testing various report types with different statuses
-- Date reference: Current date is 2025-05-20

-- 1. Add orders with different statuses for order status reporting
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES 
-- Current day (2025-05-20) - Different statuses
(41, '2025-05-20 08:15:00', '2025-05-20 08:15:00', 'Hà Nội', 'customer1@gmail.com', 0, NULL, 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 15500, 'DANG_XU_LY', 'CHUA_THANH_TOAN', 6, 5),
(42, '2025-05-20 09:30:00', '2025-05-20 09:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2025-05-20 14:00:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 18700, 'DANG_GIAO', 'DA_THANH_TOAN', 7, 5),
(43, '2025-05-20 10:45:00', '2025-05-20 10:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2025-05-20 15:30:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 12800, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(44, '2025-05-20 11:20:00', '2025-05-20 11:20:00', 'Hải Phòng', 'customer4@gmail.com', 0, NULL, 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 9500, 'DA_HUY', 'CHUA_THANH_TOAN', 9, 5),

-- Current week (2025-05-14 to 2025-05-20) - Including returned orders
(45, '2025-05-14 14:25:00', '2025-05-14 14:25:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2025-05-16 10:00:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 22300, 'TRA_HANG', 'DA_THANH_TOAN', 10, 5),
(46, '2025-05-15 16:40:00', '2025-05-15 16:40:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-05-17 11:15:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 16800, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(47, '2025-05-16 09:55:00', '2025-05-16 09:55:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2025-05-18 13:30:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 14200, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(48, '2025-05-17 13:10:00', '2025-05-17 13:10:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2025-05-19 15:45:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 19500, 'TRA_HANG', 'DA_THANH_TOAN', 8, 5),
(49, '2025-05-18 10:30:00', '2025-05-18 10:30:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2025-05-20 12:00:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 8900, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(50, '2025-05-19 15:20:00', '2025-05-19 15:20:00', 'Cần Thơ', 'customer5@gmail.com', 0, NULL, 'CHUYEN_KHOAN', '0987654330', 'Bùi Văn Tiêu', 27600, 'DANG_XU_LY', 'CHUA_THANH_TOAN', 10, 5),

-- Current month (May 2025) - Additional orders
(51, '2025-05-05 09:15:00', '2025-05-05 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-05-07 11:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 13200, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(52, '2025-05-08 14:40:00', '2025-05-08 14:40:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2025-05-10 16:55:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 15700, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(53, '2025-05-10 11:25:00', '2025-05-10 11:25:00', 'Đà Nẵng', 'customer3@gmail.com', 0, NULL, 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 9300, 'DA_HUY', 'CHUA_THANH_TOAN', 8, 5),
(54, '2025-05-12 16:50:00', '2025-05-12 16:50:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2025-05-14 19:05:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 21400, 'TRA_HANG', 'DA_THANH_TOAN', 9, 5),

-- Current quarter (Q2 2025: April-June) - Orders from April
(55, '2025-04-05 10:35:00', '2025-04-05 10:35:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2025-04-07 12:50:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 18200, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(56, '2025-04-12 15:20:00', '2025-04-12 15:20:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-04-14 17:35:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 16500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(57, '2025-04-18 12:05:00', '2025-04-18 12:05:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2025-04-20 14:20:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 23400, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(58, '2025-04-25 17:30:00', '2025-04-25 17:30:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2025-04-27 19:45:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 19800, 'TRA_HANG', 'DA_THANH_TOAN', 8, 5),

-- Current year (2025) - Orders from other months
(59, '2025-01-15 11:15:00', '2025-01-15 11:15:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2025-01-17 13:30:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 17500, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(60, '2025-02-20 13:25:00', '2025-02-20 13:25:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2025-02-22 15:40:00', 'CHUYEN_KHOAN', '0987654330', 'Bùi Văn Tiêu', 22300, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(61, '2025-03-10 16:50:00', '2025-03-10 16:50:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-03-12 19:05:00', 'THE_NGAN_HANG', '0987654326', 'Hoàng Văn Khách', 14800, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5);

-- 2. Add order details for the new orders
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Order 41 details (Current day - DANG_XU_LY)
(92, 5000, 2, 41, 9),
(93, 5500, 1, 41, 11),

-- Order 42 details (Current day - DANG_GIAO)
(94, 4000, 2, 42, 10),
(95, 3500, 3, 42, 13),

-- Order 43 details (Current day - DA_GIAO)
(96, 4000, 2, 43, 15),
(97, 4800, 1, 43, 12),

-- Order 44 details (Current day - DA_HUY)
(98, 5000, 1, 44, 9),
(99, 4500, 1, 44, 14),

-- Order 45 details (Current week - TRA_HANG)
(100, 5500, 2, 45, 11),
(101, 5000, 1, 45, 9),
(102, 3200, 2, 45, 14),

-- Order 46 details (Current week - DA_GIAO)
(103, 4000, 2, 46, 10),
(104, 4400, 2, 46, 15),

-- Order 47 details (Current week - DA_GIAO)
(105, 5700, 2, 47, 16),
(106, 2800, 1, 47, 12),

-- Order 48 details (Current week - TRA_HANG)
(107, 5000, 2, 48, 9),
(108, 4800, 2, 48, 12),

-- Order 49 details (Current week - DA_GIAO)
(109, 4500, 1, 49, 11),
(110, 4400, 1, 49, 15),

-- Order 50 details (Current week - DANG_XU_LY)
(111, 5000, 2, 50, 9),
(112, 4000, 2, 50, 10),
(113, 4800, 2, 50, 12),

-- Order 51 details (Current month - DA_GIAO)
(114, 3600, 2, 51, 13),
(115, 3000, 2, 51, 14),

-- Order 52 details (Current month - DA_GIAO)
(116, 5500, 1, 52, 11),
(117, 5100, 2, 52, 16),

-- Order 53 details (Current month - DA_HUY)
(118, 4700, 1, 53, 15),
(119, 4600, 1, 53, 12),

-- Order 54 details (Current month - TRA_HANG)
(120, 5000, 2, 54, 9),
(121, 4000, 1, 54, 10),
(122, 3700, 2, 54, 13),

-- Order 55 details (Current quarter - April - DA_GIAO)
(123, 4800, 2, 55, 12),
(124, 4300, 2, 55, 14),

-- Order 56 details (Current quarter - April - DA_GIAO)
(125, 5500, 1, 56, 11),
(126, 5500, 2, 56, 16),

-- Order 57 details (Current quarter - April - DA_GIAO)
(127, 5000, 2, 57, 9),
(128, 4000, 2, 57, 10),
(129, 5400, 1, 57, 16),

-- Order 58 details (Current quarter - April - TRA_HANG)
(130, 5000, 2, 58, 9),
(131, 4900, 2, 58, 11),

-- Order 59 details (Current year - January - DA_GIAO)
(132, 5000, 2, 59, 9),
(133, 3800, 2, 59, 13),

-- Order 60 details (Current year - February - DA_GIAO)
(134, 5500, 2, 60, 11),
(135, 5000, 1, 60, 9),
(136, 3200, 2, 60, 14),

-- Order 61 details (Current year - March - DA_GIAO)
(137, 4000, 2, 61, 10),
(138, 3400, 2, 61, 15);

-- 3. Add more data for best-selling products analysis
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Additional sales for product 9 (Azithromycin) - making it a best seller
(139, 5000, 3, 43, 9),
(140, 5000, 2, 46, 9),
(141, 5000, 4, 51, 9),
(142, 5000, 3, 55, 9),

-- Additional sales for product 11 (Levofloxacin) - making it another best seller
(143, 5500, 3, 47, 11),
(144, 5500, 2, 49, 11),
(145, 5500, 4, 52, 11),
(146, 5500, 3, 56, 11),

-- Additional sales for product 16 (Atorvastatin) - making it a third best seller
(147, 5500, 2, 48, 16),
(148, 5500, 3, 53, 16),
(149, 5500, 2, 57, 16),
(150, 5500, 4, 59, 16);

-- Update the total amounts in the orders to reflect all items
UPDATE public.don_hang SET tong_tien = 15500 WHERE id = 41;
UPDATE public.don_hang SET tong_tien = 18700 WHERE id = 42;
UPDATE public.don_hang SET tong_tien = 27800 WHERE id = 43; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 9500 WHERE id = 44;
UPDATE public.don_hang SET tong_tien = 22300 WHERE id = 45;
UPDATE public.don_hang SET tong_tien = 26800 WHERE id = 46; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 30700 WHERE id = 47; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 30500 WHERE id = 48; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 18900 WHERE id = 49; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 27600 WHERE id = 50;
UPDATE public.don_hang SET tong_tien = 28200 WHERE id = 51; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 37700 WHERE id = 52; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 20300 WHERE id = 53; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 21400 WHERE id = 54;
UPDATE public.don_hang SET tong_tien = 33200 WHERE id = 55; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 33000 WHERE id = 56; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 33400 WHERE id = 57; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 29800 WHERE id = 58; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 39500 WHERE id = 59; -- Updated with additional items
UPDATE public.don_hang SET tong_tien = 22300 WHERE id = 60;
UPDATE public.don_hang SET tong_tien = 14800 WHERE id = 61;
