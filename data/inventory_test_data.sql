-- Test data for inventory and purchase records
-- This script adds additional inventory records to support revenue reporting and statistics

-- Insert additional import receipts with varied dates throughout 2024
INSERT INTO public.phieu_nhap (id, created_at, update_at, tong_tien, nguoi_dung_id, nha_cung_cap_id)
VALUES 
-- January 2024
(16, '2024-01-05 08:30:00', '2024-01-05 08:30:00', 1500000, 3, 1),
(17, '2024-01-15 09:45:00', '2024-01-15 09:45:00', 1800000, 4, 2),

-- February 2024
(18, '2024-02-05 10:15:00', '2024-02-05 10:15:00', 1650000, 3, 3),
(19, '2024-02-20 11:30:00', '2024-02-20 11:30:00', 1950000, 4, 1),

-- March 2024 (higher volume month)
(20, '2024-03-05 09:00:00', '2024-03-05 09:00:00', 2100000, 3, 2),
(21, '2024-03-12 10:30:00', '2024-03-12 10:30:00', 1750000, 4, 3),
(22, '2024-03-20 11:45:00', '2024-03-20 11:45:00', 2250000, 3, 1),
(23, '2024-03-28 13:15:00', '2024-03-28 13:15:00', 1900000, 4, 2);

-- Insert import receipt details for the new receipts
INSERT INTO public.chi_tiet_phieu_nhap (id, don_gia, han_su_dung, so_luong, phieu_nhap_id, thuoc_id)
VALUES
-- Receipt 16 details (January)
(79, 1000, '2026-06-30 00:00:00', 500, 16, 9),
(80, 2200, '2026-06-30 00:00:00', 300, 16, 10),
(81, 1000, '2026-06-30 00:00:00', 400, 16, 11),

-- Receipt 17 details (January)
(82, 500, '2026-06-30 00:00:00', 600, 17, 12),
(83, 2000, '2026-06-30 00:00:00', 400, 17, 13),
(84, 1500, '2026-06-30 00:00:00', 300, 17, 14),

-- Receipt 18 details (February)
(85, 1200, '2026-06-30 00:00:00', 500, 18, 15),
(86, 3000, '2026-03-31 00:00:00', 250, 18, 16),
(87, 2500, '2026-03-31 00:00:00', 300, 18, 9),

-- Receipt 19 details (February)
(88, 2500, '2026-03-31 00:00:00', 350, 19, 10),
(89, 2000, '2026-03-31 00:00:00', 400, 19, 11),
(90, 2500, '2026-03-31 00:00:00', 250, 19, 12),

-- Receipt 20 details (March)
(91, 1000, '2026-06-30 00:00:00', 700, 20, 9),
(92, 2200, '2026-06-30 00:00:00', 400, 20, 10),
(93, 1000, '2026-06-30 00:00:00', 500, 20, 11),

-- Receipt 21 details (March)
(94, 500, '2026-06-30 00:00:00', 800, 21, 12),
(95, 2000, '2026-06-30 00:00:00', 350, 21, 13),
(96, 1500, '2026-06-30 00:00:00', 400, 21, 14),

-- Receipt 22 details (March)
(97, 1200, '2026-06-30 00:00:00', 600, 22, 15),
(98, 3000, '2026-03-31 00:00:00', 300, 22, 16),
(99, 2500, '2026-03-31 00:00:00', 400, 22, 9),

-- Receipt 23 details (March)
(100, 2500, '2026-03-31 00:00:00', 350, 23, 10),
(101, 2000, '2026-03-31 00:00:00', 450, 23, 11),
(102, 2500, '2026-03-31 00:00:00', 300, 23, 12);

-- Update inventory records to reflect the new stock
INSERT INTO public.ton_kho (id, created_at, update_at, han_su_dung, so_lo, so_luong, vi_tri, thuoc_id)
VALUES
(9, '2024-01-05 08:30:00', '2024-01-05 08:30:00', '2026-06-30 00:00:00', 'LO039', 500, 'Kệ T1', 9),
(10, '2024-01-05 08:30:00', '2024-01-05 08:30:00', '2026-06-30 00:00:00', 'LO040', 300, 'Kệ T2', 10),
(11, '2024-01-05 08:30:00', '2024-01-05 08:30:00', '2026-06-30 00:00:00', 'LO041', 400, 'Kệ U1', 11),
(12, '2024-01-15 09:45:00', '2024-01-15 09:45:00', '2026-06-30 00:00:00', 'LO042', 600, 'Kệ U2', 12),
(13, '2024-01-15 09:45:00', '2024-01-15 09:45:00', '2026-06-30 00:00:00', 'LO043', 400, 'Kệ V1', 13),
(14, '2024-01-15 09:45:00', '2024-01-15 09:45:00', '2026-06-30 00:00:00', 'LO044', 300, 'Kệ V2', 14),
(15, '2024-02-05 10:15:00', '2024-02-05 10:15:00', '2026-06-30 00:00:00', 'LO045', 500, 'Kệ W1', 15),
(16, '2024-02-05 10:15:00', '2024-02-05 10:15:00', '2026-03-31 00:00:00', 'LO046', 250, 'Kệ W2', 16),
(17, '2024-02-05 10:15:00', '2024-02-05 10:15:00', '2026-03-31 00:00:00', 'LO047', 300, 'Kệ X1', 9),
(18, '2024-02-20 11:30:00', '2024-02-20 11:30:00', '2026-03-31 00:00:00', 'LO048', 350, 'Kệ X2', 10),
(19, '2024-02-20 11:30:00', '2024-02-20 11:30:00', '2026-03-31 00:00:00', 'LO049', 400, 'Kệ Y1', 11),
(20, '2024-02-20 11:30:00', '2024-02-20 11:30:00', '2026-03-31 00:00:00', 'LO050', 250, 'Kệ Y2', 12);

-- Update product quantities to reflect the new inventory and sales
UPDATE public.thuoc SET so_luong_ton = 1500 WHERE id = 9;  -- Azithromycin (best seller)
UPDATE public.thuoc SET so_luong_ton = 1200 WHERE id = 10; -- Cefixime
UPDATE public.thuoc SET so_luong_ton = 1350 WHERE id = 11; -- Levofloxacin (best seller)
UPDATE public.thuoc SET so_luong_ton = 1400 WHERE id = 12; -- Diclofenac
UPDATE public.thuoc SET so_luong_ton = 750 WHERE id = 13;  -- Pantoprazole
UPDATE public.thuoc SET so_luong_ton = 700 WHERE id = 14;  -- Metformin
UPDATE public.thuoc SET so_luong_ton = 1100 WHERE id = 15; -- Losartan
UPDATE public.thuoc SET so_luong_ton = 850 WHERE id = 16;  -- Atorvastatin (best seller)
