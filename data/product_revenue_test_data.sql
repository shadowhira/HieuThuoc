-- Test data for product-specific revenue analysis and promotional impact
-- This script adds additional data to analyze product performance and promotion effectiveness

-- Add more promotions with different time periods to test promotional impact on revenue
INSERT INTO public.khuyen_mai (id, mo_ta, ngay_bat_dau, ngay_ket_thuc, ten_chuong_trinh, trang_thai)
VALUES
(3, 'Giảm giá đặc biệt cho các sản phẩm kháng sinh trong tháng 1/2024', '2024-01-01 00:00:00', '2024-01-31 00:00:00', 'Khuyến mãi kháng sinh tháng 1/2024', true),
(4, 'Giảm giá đặc biệt cho các sản phẩm tim mạch trong tháng 2/2024', '2024-02-01 00:00:00', '2024-02-29 00:00:00', 'Khuyến mãi tim mạch tháng 2/2024', true),
(5, 'Giảm giá đặc biệt cho tất cả các sản phẩm nhân dịp kỷ niệm thành lập', '2024-03-01 00:00:00', '2024-03-31 00:00:00', 'Khuyến mãi kỷ niệm thành lập tháng 3/2024', true);

-- Add promotion details for the new promotions
INSERT INTO public.chi_tiet_khuyen_mai (id, giam_gia, khuyen_mai_id, thuoc_id)
VALUES
-- January promotion (antibiotics)
(25, 25, 3, 9),  -- Azithromycin
(26, 20, 3, 10), -- Cefixime
(27, 25, 3, 11), -- Levofloxacin
(28, 15, 3, 12), -- Diclofenac

-- February promotion (cardiovascular)
(29, 15, 4, 15), -- Losartan
(30, 20, 4, 16), -- Atorvastatin

-- March promotion (all products)
(31, 30, 5, 9),  -- Azithromycin
(32, 25, 5, 10), -- Cefixime
(33, 30, 5, 11), -- Levofloxacin
(34, 20, 5, 12), -- Diclofenac
(35, 25, 5, 13), -- Pantoprazole
(36, 20, 5, 14), -- Metformin
(37, 25, 5, 15), -- Losartan
(38, 30, 5, 16); -- Atorvastatin

-- Add additional orders during promotional periods to analyze promotion effectiveness
INSERT INTO public.don_hang (id, created_at, update_at, dia_chi, email, giam_gia, ngay_giao, phuong_thuc_thanh_toan, so_dien_thoai, ten_khach_hang, tong_tien, trang_thai_giao_hang, trang_thai_thanh_toan, khach_hang_id, nguoi_dung_id)
VALUES 
-- January orders during antibiotic promotion
(32, '2024-01-10 10:15:00', '2024-01-10 10:15:00', 'Hà Nội', 'customer1@gmail.com', 25, '2024-01-12 14:30:00', 'TIEN_MAT', '0987654326', 'Hoàng Văn Khách', 15000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(33, '2024-01-15 09:30:00', '2024-01-15 09:30:00', 'Hồ Chí Minh', 'customer2@gmail.com', 20, '2024-01-17 11:45:00', 'CHUYEN_KHOAN', '0987654327', 'Ngô Thị Hàng', 12800, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(34, '2024-01-25 14:20:00', '2024-01-25 14:20:00', 'Đà Nẵng', 'customer3@gmail.com', 25, '2024-01-27 16:00:00', 'THE_NGAN_HANG', '0987654328', 'Vũ Văn Mua', 16500, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),

-- February orders during cardiovascular promotion
(35, '2024-02-08 11:10:00', '2024-02-08 11:10:00', 'Hải Phòng', 'customer4@gmail.com', 15, '2024-02-10 13:20:00', 'VI_DIEN_TU', '0987654329', 'Đặng Thị Sắm', 13600, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5),
(36, '2024-02-18 08:45:00', '2024-02-18 08:45:00', 'Cần Thơ', 'customer5@gmail.com', 20, '2024-02-20 10:30:00', 'TIEN_MAT', '0987654330', 'Bùi Văn Tiêu', 18900, 'DA_GIAO', 'DA_THANH_TOAN', 10, 5),

-- March orders during anniversary promotion
(37, '2024-03-05 13:25:00', '2024-03-05 13:25:00', 'Hà Nội', 'customer1@gmail.com', 30, '2024-03-07 15:40:00', 'CHUYEN_KHOAN', '0987654326', 'Hoàng Văn Khách', 21000, 'DA_GIAO', 'DA_THANH_TOAN', 6, 5),
(38, '2024-03-12 16:50:00', '2024-03-12 16:50:00', 'Hồ Chí Minh', 'customer2@gmail.com', 25, '2024-03-14 18:15:00', 'THE_NGAN_HANG', '0987654327', 'Ngô Thị Hàng', 19500, 'DA_GIAO', 'DA_THANH_TOAN', 7, 5),
(39, '2024-03-20 10:05:00', '2024-03-20 10:05:00', 'Đà Nẵng', 'customer3@gmail.com', 30, '2024-03-22 12:20:00', 'VI_DIEN_TU', '0987654328', 'Vũ Văn Mua', 24800, 'DA_GIAO', 'DA_THANH_TOAN', 8, 5),
(40, '2024-03-25 09:15:00', '2024-03-25 09:15:00', 'Hải Phòng', 'customer4@gmail.com', 20, '2024-03-27 11:30:00', 'TIEN_MAT', '0987654329', 'Đặng Thị Sắm', 17200, 'DA_GIAO', 'DA_THANH_TOAN', 9, 5);

-- Add order details for the promotional orders
INSERT INTO public.chi_tiet_don_hang (id, don_gia, so_luong, don_hang_id, thuoc_id)
VALUES
-- Order 32 details (January - antibiotic promotion)
(70, 3750, 2, 32, 9),  -- Azithromycin with 25% discount
(71, 3200, 2, 32, 10), -- Cefixime with 20% discount

-- Order 33 details (January - antibiotic promotion)
(72, 4125, 2, 33, 11), -- Levofloxacin with 25% discount
(73, 1530, 3, 33, 12), -- Diclofenac with 15% discount

-- Order 34 details (January - antibiotic promotion)
(74, 3750, 3, 34, 9),  -- Azithromycin with 25% discount
(75, 4125, 1, 34, 11), -- Levofloxacin with 25% discount

-- Order 35 details (February - cardiovascular promotion)
(76, 3400, 2, 35, 15), -- Losartan with 15% discount
(77, 3400, 2, 35, 15), -- Losartan with 15% discount

-- Order 36 details (February - cardiovascular promotion)
(78, 4400, 3, 36, 16), -- Atorvastatin with 20% discount
(79, 3400, 2, 36, 15), -- Losartan with 15% discount

-- Order 37 details (March - anniversary promotion)
(80, 3500, 2, 37, 9),  -- Azithromycin with 30% discount
(81, 3000, 2, 37, 10), -- Cefixime with 25% discount
(82, 3850, 2, 37, 11), -- Levofloxacin with 30% discount

-- Order 38 details (March - anniversary promotion)
(83, 1440, 3, 38, 12), -- Diclofenac with 20% discount
(84, 2625, 3, 38, 13), -- Pantoprazole with 25% discount
(85, 2000, 3, 38, 14), -- Metformin with 20% discount

-- Order 39 details (March - anniversary promotion)
(86, 2400, 3, 39, 15), -- Losartan with 25% discount
(87, 3500, 3, 39, 16), -- Atorvastatin with 30% discount
(88, 3500, 2, 39, 9),  -- Azithromycin with 30% discount

-- Order 40 details (March - anniversary promotion)
(89, 3000, 2, 40, 10), -- Cefixime with 25% discount
(90, 3850, 2, 40, 11), -- Levofloxacin with 30% discount
(91, 2625, 2, 40, 13); -- Pantoprazole with 25% discount
