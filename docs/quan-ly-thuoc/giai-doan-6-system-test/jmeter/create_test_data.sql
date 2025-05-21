-- Script tạo dữ liệu test cho kiểm thử hiệu năng

-- Xóa dữ liệu cũ (nếu cần)
-- TRUNCATE TABLE thuoc CASCADE;
-- TRUNCATE TABLE loai_thuoc CASCADE;
-- TRUNCATE TABLE danh_muc_thuoc CASCADE;
-- TRUNCATE TABLE nha_san_xuat CASCADE;
-- TRUNCATE TABLE doi_tuong_su_dung CASCADE;
-- TRUNCATE TABLE thanh_phan_thuoc CASCADE;

-- Tạo danh mục thuốc test
INSERT INTO danh_muc_thuoc (ten_danh_muc, mo_ta)
SELECT 
  'Danh mục test ' || i,
  'Mô tả danh mục test ' || i
FROM generate_series(1, 10) i
ON CONFLICT (ten_danh_muc) DO NOTHING;

-- Tạo loại thuốc test
INSERT INTO loai_thuoc (ten_loai, mo_ta, danh_muc_thuoc_id)
SELECT 
  'Loại thuốc test ' || i,
  'Mô tả loại thuốc test ' || i,
  (i % 10) + 1
FROM generate_series(1, 20) i
ON CONFLICT (ten_loai) DO NOTHING;

-- Tạo nhà sản xuất test
INSERT INTO nha_san_xuat (ten_nha_san_xuat, dia_chi, so_dien_thoai, email)
SELECT 
  'Nhà sản xuất test ' || i,
  'Địa chỉ test ' || i,
  '0123456' || LPAD(i::text, 3, '0'),
  'nsx' || i || '@test.com'
FROM generate_series(1, 10) i
ON CONFLICT (ten_nha_san_xuat) DO NOTHING;

-- Tạo đối tượng sử dụng test
INSERT INTO doi_tuong_su_dung (ten_doi_tuong, mo_ta)
SELECT 
  'Đối tượng test ' || i,
  'Mô tả đối tượng test ' || i
FROM generate_series(1, 5) i
ON CONFLICT (ten_doi_tuong) DO NOTHING;

-- Tạo thành phần thuốc test
INSERT INTO thanh_phan_thuoc (ten_thanh_phan, ham_luong, don_vi)
SELECT 
  'Thành phần test ' || i,
  (RANDOM() * 1000)::integer,
  CASE (i % 4)
    WHEN 0 THEN 'mg'
    WHEN 1 THEN 'g'
    WHEN 2 THEN 'ml'
    WHEN 3 THEN 'mcg'
  END
FROM generate_series(1, 30) i
ON CONFLICT (ten_thanh_phan) DO NOTHING;

-- Tạo 100 thuốc test
INSERT INTO thuoc (ten_thuoc, ma_thuoc, gia_nhap, gia_ban, so_luong, han_su_dung, loai_thuoc_id, nha_san_xuat_id, mo_ta, trang_thai, nguong_canh_bao)
SELECT 
  'Thuốc Test 100 - ' || i,
  'TEST100_' || LPAD(i::text, 5, '0'),
  (RANDOM() * 1000000)::integer,
  (RANDOM() * 2000000)::integer,
  (RANDOM() * 1000)::integer,
  CURRENT_DATE + (RANDOM() * 1000)::integer,
  (i % 20) + 1,
  (i % 10) + 1,
  'Mô tả thuốc test ' || i,
  CASE (i % 3)
    WHEN 0 THEN 'Còn hàng'
    WHEN 1 THEN 'Sắp hết hàng'
    WHEN 2 THEN 'Hết hàng'
  END,
  10
FROM generate_series(1, 100) i
ON CONFLICT (ma_thuoc) DO NOTHING;

-- Tạo 1,000 thuốc test
INSERT INTO thuoc (ten_thuoc, ma_thuoc, gia_nhap, gia_ban, so_luong, han_su_dung, loai_thuoc_id, nha_san_xuat_id, mo_ta, trang_thai, nguong_canh_bao)
SELECT 
  'Thuốc Test 1K - ' || i,
  'TEST1K_' || LPAD(i::text, 5, '0'),
  (RANDOM() * 1000000)::integer,
  (RANDOM() * 2000000)::integer,
  (RANDOM() * 1000)::integer,
  CURRENT_DATE + (RANDOM() * 1000)::integer,
  (i % 20) + 1,
  (i % 10) + 1,
  'Mô tả thuốc test ' || i,
  CASE (i % 3)
    WHEN 0 THEN 'Còn hàng'
    WHEN 1 THEN 'Sắp hết hàng'
    WHEN 2 THEN 'Hết hàng'
  END,
  10
FROM generate_series(1, 1000) i
ON CONFLICT (ma_thuoc) DO NOTHING;

-- Tạo 10,000 thuốc test
INSERT INTO thuoc (ten_thuoc, ma_thuoc, gia_nhap, gia_ban, so_luong, han_su_dung, loai_thuoc_id, nha_san_xuat_id, mo_ta, trang_thai, nguong_canh_bao)
SELECT 
  'Thuốc Test 10K - ' || i,
  'TEST10K_' || LPAD(i::text, 5, '0'),
  (RANDOM() * 1000000)::integer,
  (RANDOM() * 2000000)::integer,
  (RANDOM() * 1000)::integer,
  CURRENT_DATE + (RANDOM() * 1000)::integer,
  (i % 20) + 1,
  (i % 10) + 1,
  'Mô tả thuốc test ' || i,
  CASE (i % 3)
    WHEN 0 THEN 'Còn hàng'
    WHEN 1 THEN 'Sắp hết hàng'
    WHEN 2 THEN 'Hết hàng'
  END,
  10
FROM generate_series(1, 10000) i
ON CONFLICT (ma_thuoc) DO NOTHING;

-- Tạo liên kết giữa thuốc và đối tượng sử dụng
INSERT INTO thuoc_doi_tuong (thuoc_id, doi_tuong_id)
SELECT 
  t.id,
  (t.id % 5) + 1
FROM thuoc t
ON CONFLICT DO NOTHING;

-- Tạo liên kết giữa thuốc và thành phần thuốc
INSERT INTO thuoc_thanh_phan (thuoc_id, thanh_phan_id)
SELECT 
  t.id,
  (t.id % 30) + 1
FROM thuoc t
ON CONFLICT DO NOTHING;

-- Thêm một thành phần thuốc khác cho mỗi thuốc
INSERT INTO thuoc_thanh_phan (thuoc_id, thanh_phan_id)
SELECT 
  t.id,
  ((t.id + 1) % 30) + 1
FROM thuoc t
ON CONFLICT DO NOTHING;
