-- Test data for comprehensive statistics reporting interface
-- This script adds diverse data across multiple years, months, and with various values
-- to properly test all aspects of the statistics reporting functionality

-- =============================================
-- 1. ORDERS FROM 2022 (HISTORICAL DATA)
-- =============================================

-- Q1 2022 (January-March)
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- January 2022 (Low revenue month)
(100, '2022-01-10 09:15:00', '2022-01-10 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2022-01-12 14:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 8500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(101, '2022-01-20 10:30:00', '2022-01-20 10:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2022-01-22 15:45:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 12000, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),

-- February 2022 (Medium revenue month)
(102, '2022-02-05 11:45:00', '2022-02-05 11:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2022-02-07 16:00:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 15500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(103, '2022-02-15 13:00:00', '2022-02-15 13:00:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2022-02-17 17:15:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 18000, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),

-- March 2022 (High revenue month)
(104, '2022-03-10 14:15:00', '2022-03-10 14:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2022-03-12 18:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 22500, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(105, '2022-03-25 15:30:00', '2022-03-25 15:30:00', 'Hà Nội', 'customer1@gmail.com', 0, '2022-03-27 19:45:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 25000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5);

-- Q2 2022 (April-June)
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- April 2022 (Medium revenue month)
(106, '2022-04-05 09:15:00', '2022-04-05 09:15:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2022-04-07 14:30:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 16800, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(107, '2022-04-20 10:30:00', '2022-04-20 10:30:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2022-04-22 15:45:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 19200, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),

-- May 2022 (High revenue month)
(108, '2022-05-10 11:45:00', '2022-05-10 11:45:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2022-05-12 16:00:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 23500, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(109, '2022-05-25 13:00:00', '2022-05-25 13:00:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2022-05-27 17:15:00', 'CHUYEN_KHOAN', '0987654330', 'Bùi Văn Tiêu', 27000, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),

-- June 2022 (Low revenue month with some returns)
(110, '2022-06-05 14:15:00', '2022-06-05 14:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2022-06-07 18:30:00', 'THE_NGAN_HANG', '0987654326', 'Hoàng Văn Khách', 9500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(111, '2022-06-15 15:30:00', '2022-06-20 15:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2022-06-17 19:45:00', 'VI_DIEN_TU', '0987654327', 'Ngô Thị Hàng', 13000, 'TRA_HANG', 'DA_THANH_TOAN', 7, 5);

-- =============================================
-- 2. ORDERS FROM 2023 (LAST YEAR)
-- =============================================

-- Q3 2023 (July-September)
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- July 2023 (High revenue month)
(112, '2023-07-10 09:15:00', '2023-07-10 09:15:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2023-07-12 14:30:00', 'TIEN_MAT', '0987654328', 'Vũ Văn Mua', 28500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(113, '2023-07-25 10:30:00', '2023-07-25 10:30:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2023-07-27 15:45:00', 'CHUYEN_KHOAN', '0987654329', 'Đặng Thị Sắm', 32000, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),

-- August 2023 (Medium revenue month with some returns)
(114, '2023-08-05 11:45:00', '2023-08-05 11:45:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2023-08-07 16:00:00', 'THE_NGAN_HANG', '0987654330', 'Bùi Văn Tiêu', 17500, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(115, '2023-08-20 13:00:00', '2023-08-25 13:00:00', 'Hà Nội', 'customer1@gmail.com', 0, '2023-08-22 17:15:00', 'VI_DIEN_TU', '0987654326', 'Hoàng Văn Khách', 21000, 'TRA_HANG', 'DA_THANH_TOAN', 6, 5),

-- September 2023 (Low revenue month)
(116, '2023-09-10 14:15:00', '2023-09-10 14:15:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2023-09-12 18:30:00', 'TIEN_MAT', '0987654327', 'Ngô Thị Hàng', 11500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(117, '2023-09-25 15:30:00', '2023-09-25 15:30:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2023-09-27 19:45:00', 'CHUYEN_KHOAN', '0987654328', 'Vũ Văn Mua', 14000, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5);

-- Q4 2023 (October-December)
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- October 2023 (Medium revenue month)
(118, '2023-10-05 09:15:00', '2023-10-05 09:15:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2023-10-07 14:30:00', 'THE_NGAN_HANG', '0987654329', 'Đặng Thị Sắm', 19800, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(119, '2023-10-20 10:30:00', '2023-10-20 10:30:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2023-10-22 15:45:00', 'VI_DIEN_TU', '0987654330', 'Bùi Văn Tiêu', 22200, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),

-- November 2023 (High revenue month - holiday season)
(120, '2023-11-10 11:45:00', '2023-11-10 11:45:00', 'Hà Nội', 'customer1@gmail.com', 0, '2023-11-12 16:00:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 33500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(121, '2023-11-25 13:00:00', '2023-11-25 13:00:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2023-11-27 17:15:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 37000, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),

-- December 2023 (Highest revenue month - year-end)
(122, '2023-12-05 14:15:00', '2023-12-05 14:15:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2023-12-07 18:30:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 42500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(123, '2023-12-20 15:30:00', '2023-12-20 15:30:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2023-12-22 19:45:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 45000, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5);

-- =============================================
-- 3. ORDERS FROM 2024 (CURRENT YEAR)
-- =============================================

-- Q1 2024 (January-March) - Add more detailed data for current year
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- January 2024 (Post-holiday decline)
(124, '2024-01-05 09:15:00', '2024-01-05 09:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-01-07 14:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 28500, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(125, '2024-01-10 10:30:00', '2024-01-10 10:30:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-01-12 15:45:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 25000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(126, '2024-01-15 11:45:00', '2024-01-15 11:45:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-01-17 16:00:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 22500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(127, '2024-01-20 13:00:00', '2024-01-25 13:00:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-01-22 17:15:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 18000, 'TRA_HANG', 'DA_THANH_TOAN', 8, 5),
(128, '2024-01-25 14:15:00', '2024-01-25 14:15:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-01-27 18:30:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 15500, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(129, '2024-01-30 15:30:00', '2024-01-30 15:30:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-02-01 19:45:00', 'CHUYEN_KHOAN', '0987654330', 'Bùi Văn Tiêu', 12000, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),

-- February 2024 (Gradual increase)
(130, '2024-02-05 09:15:00', '2024-02-05 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-02-07 14:30:00', 'THE_NGAN_HANG', '0987654326', 'Hoàng Văn Khách', 18500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(131, '2024-02-10 10:30:00', '2024-02-10 10:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-02-12 15:45:00', 'VI_DIEN_TU', '0987654327', 'Ngô Thị Hàng', 21000, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(132, '2024-02-15 11:45:00', '2024-02-15 11:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-02-17 16:00:00', 'TIEN_MAT', '0987654328', 'Vũ Văn Mua', 23500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(133, '2024-02-20 13:00:00', '2024-02-20 13:00:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-02-22 17:15:00', 'CHUYEN_KHOAN', '0987654329', 'Đặng Thị Sắm', 26000, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(134, '2024-02-25 14:15:00', '2024-02-25 14:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-02-27 18:30:00', 'THE_NGAN_HANG', '0987654330', 'Bùi Văn Tiêu', 28500, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),

-- March 2024 (Strong performance)
(135, '2024-03-05 09:15:00', '2024-03-05 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-03-07 14:30:00', 'VI_DIEN_TU', '0987654326', 'Hoàng Văn Khách', 31000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(136, '2024-03-10 10:30:00', '2024-03-10 10:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-03-12 15:45:00', 'TIEN_MAT', '0987654327', 'Ngô Thị Hàng', 33500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(137, '2024-03-15 11:45:00', '2024-03-15 11:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-03-17 16:00:00', 'CHUYEN_KHOAN', '0987654328', 'Vũ Văn Mua', 36000, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(138, '2024-03-20 13:00:00', '2024-03-20 13:00:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-03-22 17:15:00', 'THE_NGAN_HANG', '0987654329', 'Đặng Thị Sắm', 38500, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(139, '2024-03-25 14:15:00', '2024-03-30 14:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-03-27 18:30:00', 'VI_DIEN_TU', '0987654330', 'Bùi Văn Tiêu', 41000, 'TRA_HANG', 'DA_THANH_TOAN', 10, 5);

-- Q2 2024 (April-June)
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- April 2024 (Steady growth)
(140, '2024-04-05 09:15:00', '2024-04-05 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-04-07 14:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 32500, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(141, '2024-04-15 10:30:00', '2024-04-15 10:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-04-17 15:45:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 35000, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(142, '2024-04-25 11:45:00', '2024-04-25 11:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-04-27 16:00:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 37500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),

-- May 2024 (Peak season)
(143, '2024-05-05 13:00:00', '2024-05-05 13:00:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-05-07 17:15:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 42000, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(144, '2024-05-15 14:15:00', '2024-05-15 14:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-05-17 18:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 45500, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(145, '2024-05-25 15:30:00', '2024-05-25 15:30:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-05-27 19:45:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 48000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),

-- June 2024 (Some returns and varied statuses)
(146, '2024-06-05 09:15:00', '2024-06-05 09:15:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-06-07 14:30:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 39500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(147, '2024-06-15 10:30:00', '2024-06-20 10:30:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-06-17 15:45:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 36000, 'TRA_HANG', 'DA_THANH_TOAN', 8, 5),
(148, '2024-06-25 11:45:00', '2024-06-25 11:45:00', 'Hải Phòng', 'customer4@gmail.com', 0, NULL, 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 33500, 'DANG_XU_LY', 'CHUA_THANH_TOAN', 9, 5);

-- =============================================
-- 4. ORDER DETAILS FOR ALL ORDERS
-- =============================================

-- Add order details for 2022 orders (using thuoc_id values 9-16 as specified)
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Order 100 details (January 2022)
(200, 5000, 1, 100, 9),
(201, 3500, 1, 100, 13),

-- Order 101 details (January 2022)
(202, 4000, 2, 101, 10),
(203, 4000, 1, 101, 15),

-- Order 102 details (February 2022)
(204, 5500, 2, 102, 11),
(205, 4500, 1, 102, 16),

-- Order 103 details (February 2022)
(206, 4000, 2, 103, 10),
(207, 5000, 2, 103, 9),

-- Order 104 details (March 2022)
(208, 5500, 3, 104, 11),
(209, 3000, 2, 104, 14),

-- Order 105 details (March 2022)
(210, 5000, 3, 105, 9),
(211, 5000, 2, 105, 16);

-- Add order details for 2023 orders (Q3-Q4)
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Order 112 details (July 2023)
(212, 5000, 3, 112, 9),
(213, 4500, 3, 112, 11),

-- Order 113 details (July 2023)
(214, 4000, 4, 113, 10),
(215, 4000, 4, 113, 15),

-- Order 114 details (August 2023)
(216, 5500, 2, 114, 11),
(217, 3250, 2, 114, 13),

-- Order 115 details (August 2023 - returned)
(218, 5000, 3, 115, 9),
(219, 3000, 2, 115, 14),

-- Order 116 details (September 2023)
(220, 4000, 2, 116, 10),
(221, 3500, 1, 116, 13),

-- Order 117 details (September 2023)
(222, 4000, 2, 117, 15),
(223, 3000, 2, 117, 14);

-- Add order details for 2024 orders (Q1)
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- January 2024 orders
(224, 5000, 3, 124, 9),
(225, 4500, 3, 124, 11),
(226, 5000, 3, 125, 9),
(227, 5000, 2, 125, 16),
(228, 4500, 3, 126, 11),
(229, 4500, 2, 126, 16),
(230, 4000, 3, 127, 10),
(231, 3000, 2, 127, 14),
(232, 5500, 2, 128, 11),
(233, 4500, 1, 128, 16),
(234, 4000, 2, 129, 10),
(235, 4000, 1, 129, 15),

-- February 2024 orders
(236, 5000, 2, 130, 9),
(237, 4250, 2, 130, 13),
(238, 5500, 2, 131, 11),
(239, 5000, 2, 131, 16),
(240, 5000, 3, 132, 9),
(241, 4250, 2, 132, 13),
(242, 5500, 3, 133, 11),
(243, 4750, 2, 133, 16),
(244, 5000, 3, 134, 9),
(245, 4500, 3, 134, 11),

-- March 2024 orders
(246, 5000, 4, 135, 9),
(247, 5500, 2, 135, 11),
(248, 5500, 3, 136, 11),
(249, 5500, 3, 136, 16),
(250, 4000, 4, 137, 10),
(251, 5000, 4, 137, 9),
(252, 5500, 4, 138, 11),
(253, 5500, 3, 138, 16),
(254, 5000, 5, 139, 9),
(255, 4000, 4, 139, 10);

-- Add order details for 2024 orders (Q2)
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- April 2024 orders
(256, 5000, 4, 140, 9),
(257, 4500, 3, 140, 11),
(258, 5500, 4, 141, 11),
(259, 4500, 3, 141, 16),
(260, 5000, 5, 142, 9),
(261, 4500, 3, 142, 11),

-- May 2024 orders
(262, 5500, 4, 143, 11),
(263, 5000, 4, 143, 16),
(264, 5000, 5, 144, 9),
(265, 5500, 4, 144, 11),
(266, 5500, 5, 145, 11),
(267, 5500, 4, 145, 16),

-- June 2024 orders
(268, 5000, 4, 146, 9),
(269, 4875, 4, 146, 16),
(270, 4000, 5, 147, 10),
(271, 4000, 4, 147, 15),
(272, 5500, 3, 148, 11),
(273, 5500, 3, 148, 16);

-- =============================================
-- 5. ORDERS FROM 2025 (CURRENT YEAR IN SYSTEM)
-- =============================================

-- Q1-Q2 2025 (January-May)
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- January 2025
(149, '2025-01-10 09:15:00', '2025-01-10 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-01-12 14:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 35000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(150, '2025-01-25 10:30:00', '2025-01-25 10:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2025-01-27 15:45:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 38500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),

-- February 2025
(151, '2025-02-10 11:45:00', '2025-02-10 11:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2025-02-12 16:00:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 42000, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(152, '2025-02-25 13:00:00', '2025-02-25 13:00:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2025-02-27 17:15:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 45500, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),

-- March 2025
(153, '2025-03-10 14:15:00', '2025-03-10 14:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2025-03-12 18:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 49000, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(154, '2025-03-25 15:30:00', '2025-03-30 15:30:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-03-27 19:45:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 52500, 'TRA_HANG', 'DA_THANH_TOAN', 6, 5),

-- April 2025
(155, '2025-04-10 09:15:00', '2025-04-10 09:15:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2025-04-12 14:30:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 56000, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(156, '2025-04-25 10:30:00', '2025-04-25 10:30:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2025-04-27 15:45:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 59500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),

-- May 2025 (Current month)
(157, '2025-05-05 11:45:00', '2025-05-05 11:45:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2025-05-07 16:00:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 63000, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(158, '2025-05-10 13:00:00', '2025-05-10 13:00:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2025-05-12 17:15:00', 'CHUYEN_KHOAN', '0987654330', 'Bùi Văn Tiêu', 66500, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),
(159, '2025-05-15 14:15:00', '2025-05-15 14:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2025-05-17 18:30:00', 'THE_NGAN_HANG', '0987654326', 'Hoàng Văn Khách', 70000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(160, '2025-05-18 15:30:00', '2025-05-18 15:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, NULL, 'VI_DIEN_TU', '0987654327', 'Ngô Thị Hàng', 73500, 'DANG_XU_LY', 'CHUA_THANH_TOAN', 7, 5);

-- Add order details for 2025 orders
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- January 2025 orders
(274, 5000, 4, 149, 9),
(275, 5000, 3, 149, 16),
(276, 5500, 4, 150, 11),
(277, 5500, 3, 150, 16),

-- February 2025 orders
(278, 5000, 5, 151, 9),
(279, 5500, 3, 151, 11),
(280, 5500, 5, 152, 11),
(281, 5500, 3, 152, 16),

-- March 2025 orders
(282, 5000, 6, 153, 9),
(283, 5500, 4, 153, 11),
(284, 5500, 6, 154, 11),
(285, 5500, 4, 154, 16),

-- April 2025 orders
(286, 5000, 7, 155, 9),
(287, 5500, 4, 155, 11),
(288, 5500, 7, 156, 11),
(289, 5500, 4, 156, 16),

-- May 2025 orders (Current month)
(290, 5000, 8, 157, 9),
(291, 5500, 4, 157, 11),
(292, 5500, 8, 158, 11),
(293, 5500, 4, 158, 16),
(294, 5000, 9, 159, 9),
(295, 5500, 5, 159, 11),
(296, 5500, 9, 160, 11),
(297, 5500, 5, 160, 16);

-- =============================================
-- 6. ADDITIONAL DATA FOR SPECIFIC TESTING SCENARIOS
-- =============================================

-- Add some orders with specific dates for daily report testing
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- Today's orders (for daily report testing)
(161, CURRENT_DATE + '08:15:00'::time, CURRENT_DATE + '08:15:00'::time, 'Hà Nội', 'customer1@gmail.com', 0, CURRENT_DATE + '14:30:00'::time, 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 15000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(162, CURRENT_DATE + '10:30:00'::time, CURRENT_DATE + '10:30:00'::time, 'Hồ Chí Minh', 'customer2@gmail.com', 0, CURRENT_DATE + '16:45:00'::time, 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 18500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(163, CURRENT_DATE + '14:45:00'::time, CURRENT_DATE + '14:45:00'::time, 'Đà Nẵng', 'customer3@gmail.com', 0, CURRENT_DATE + '20:00:00'::time, 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 22000, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(164, CURRENT_DATE + '17:00:00'::time, CURRENT_DATE + '17:00:00'::time, 'Hải Phòng', 'customer4@gmail.com', 0, NULL, 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 25500, 'DANG_XU_LY', 'CHUA_THANH_TOAN', 9, 5);

-- Add order details for today's orders
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
(298, 5000, 2, 161, 9),
(299, 5000, 1, 161, 16),
(300, 5500, 2, 162, 11),
(301, 3750, 2, 162, 13),
(302, 5000, 3, 163, 9),
(303, 3500, 2, 163, 14),
(304, 5500, 3, 164, 11),
(305, 4500, 2, 164, 16);

-- =============================================
-- 7. RETURNED ORDERS FOR SPECIFIC TESTING
-- =============================================

-- Add more returned orders with different reasons for testing return reports
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES
-- Returned orders with different dates
(165, '2024-01-15 09:15:00', '2024-01-20 09:15:00', 'Hà Nội', 'customer1@gmail.com', 0, '2024-01-17 14:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 12500, 'TRA_HANG', 'DA_THANH_TOAN', 6, 5),
(166, '2024-02-15 10:30:00', '2024-02-20 10:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 0, '2024-02-17 15:45:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 15000, 'TRA_HANG', 'DA_THANH_TOAN', 7, 5),
(167, '2024-03-15 11:45:00', '2024-03-20 11:45:00', 'Đà Nẵng', 'customer3@gmail.com', 0, '2024-03-17 16:00:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 17500, 'TRA_HANG', 'DA_THANH_TOAN', 8, 5),
(168, '2024-04-15 13:00:00', '2024-04-20 13:00:00', 'Hải Phòng', 'customer4@gmail.com', 0, '2024-04-17 17:15:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 20000, 'TRA_HANG', 'DA_THANH_TOAN', 9, 5),
(169, '2024-05-15 14:15:00', '2024-05-20 14:15:00', 'Cần Thơ', 'customer5@gmail.com', 0, '2024-05-17 18:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 22500, 'TRA_HANG', 'DA_THANH_TOAN', 10, 5);

-- Add order details for returned orders
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
(306, 5000, 1, 165, 9),
(307, 3750, 2, 165, 13),
(308, 5000, 2, 166, 9),
(309, 5000, 1, 166, 16),
(310, 5500, 2, 167, 11),
(311, 3250, 2, 167, 13),
(312, 5000, 3, 168, 9),
(313, 5000, 1, 168, 16),
(314, 5500, 3, 169, 11),
(315, 3000, 2, 169, 14);

-- =============================================
-- 8. BEST-SELLING PRODUCTS DATA
-- =============================================

-- Add additional sales for specific products to create clear best-sellers
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Make product 9 (Azithromycin) a best-seller
(316, 5000, 5, 100, 9),
(317, 5000, 4, 105, 9),
(318, 5000, 6, 112, 9),
(319, 5000, 5, 124, 9),
(320, 5000, 7, 135, 9),
(321, 5000, 6, 140, 9),
(322, 5000, 8, 149, 9),
(323, 5000, 7, 157, 9),

-- Make product 11 (Levofloxacin) another best-seller
(324, 5500, 4, 102, 11),
(325, 5500, 5, 104, 11),
(326, 5500, 6, 114, 11),
(327, 5500, 5, 126, 11),
(328, 5500, 7, 136, 11),
(329, 5500, 6, 141, 11),
(330, 5500, 8, 150, 11),
(331, 5500, 7, 158, 11),

-- Make product 16 (Atorvastatin) a third best-seller
(332, 5500, 3, 103, 16),
(333, 5500, 4, 105, 16),
(334, 5500, 5, 115, 16),
(335, 5500, 4, 127, 16),
(336, 5500, 6, 137, 16),
(337, 5500, 5, 142, 16),
(338, 5500, 7, 151, 16),
(339, 5500, 6, 159, 16);

-- Update the total amounts in the orders to reflect the additional items
UPDATE public.don_hang SET tong_tien = tong_tien + 25000 WHERE id = 100;
UPDATE public.don_hang SET tong_tien = tong_tien + 20000 WHERE id = 105;
UPDATE public.don_hang SET tong_tien = tong_tien + 30000 WHERE id = 112;
UPDATE public.don_hang SET tong_tien = tong_tien + 25000 WHERE id = 124;
UPDATE public.don_hang SET tong_tien = tong_tien + 35000 WHERE id = 135;
UPDATE public.don_hang SET tong_tien = tong_tien + 30000 WHERE id = 140;
UPDATE public.don_hang SET tong_tien = tong_tien + 40000 WHERE id = 149;
UPDATE public.don_hang SET tong_tien = tong_tien + 35000 WHERE id = 157;

UPDATE public.don_hang SET tong_tien = tong_tien + 22000 WHERE id = 102;
UPDATE public.don_hang SET tong_tien = tong_tien + 27500 WHERE id = 104;
UPDATE public.don_hang SET tong_tien = tong_tien + 33000 WHERE id = 114;
UPDATE public.don_hang SET tong_tien = tong_tien + 27500 WHERE id = 126;
UPDATE public.don_hang SET tong_tien = tong_tien + 38500 WHERE id = 136;
UPDATE public.don_hang SET tong_tien = tong_tien + 33000 WHERE id = 141;
UPDATE public.don_hang SET tong_tien = tong_tien + 44000 WHERE id = 150;
UPDATE public.don_hang SET tong_tien = tong_tien + 38500 WHERE id = 158;

UPDATE public.don_hang SET tong_tien = tong_tien + 16500 WHERE id = 103;
UPDATE public.don_hang SET tong_tien = tong_tien + 22000 WHERE id = 105;
UPDATE public.don_hang SET tong_tien = tong_tien + 27500 WHERE id = 115;
UPDATE public.don_hang SET tong_tien = tong_tien + 22000 WHERE id = 127;
UPDATE public.don_hang SET tong_tien = tong_tien + 33000 WHERE id = 137;
UPDATE public.don_hang SET tong_tien = tong_tien + 27500 WHERE id = 142;
UPDATE public.don_hang SET tong_tien = tong_tien + 38500 WHERE id = 151;
UPDATE public.don_hang SET tong_tien = tong_tien + 33000 WHERE id = 159;
