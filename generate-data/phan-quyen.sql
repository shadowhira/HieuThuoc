-- File SQL để thêm dữ liệu phân quyền
-- Tạo bởi Augment Agent

-- Thêm dữ liệu cho bảng chuc_nang (nếu chưa có)
INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Quản lý người dùng', 'MANAGE_USER', 'Quản lý thông tin người dùng'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Quản lý người dùng');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Quản lý thuốc', 'MANAGE_MEDICINE', 'Quản lý thông tin thuốc'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Quản lý thuốc');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Quản lý nhập kho', 'MANAGE_IMPORT', 'Quản lý nhập kho thuốc'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Quản lý nhập kho');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Quản lý đơn hàng', 'MANAGE_ORDER', 'Quản lý đơn hàng'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Quản lý đơn hàng');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Quản lý khuyến mãi', 'MANAGE_PROMOTION', 'Quản lý khuyến mãi'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Quản lý khuyến mãi');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Quản lý nhóm quyền', 'MANAGE_ROLE', 'Quản lý nhóm quyền'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Quản lý nhóm quyền');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Xem báo cáo', 'VIEW_REPORT', 'Xem báo cáo thống kê'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Xem báo cáo');

INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta)
SELECT 'Xóa người dùng', 'DELETE_USER', 'Xóa người dùng khỏi hệ thống'
WHERE NOT EXISTS (SELECT 1 FROM chuc_nang WHERE ten_chuc_nang = 'Xóa người dùng');

-- Thêm dữ liệu cho bảng nhom_quyen (nếu chưa có)
INSERT INTO nhom_quyen (ten_nhom_quyen, mo_ta)
SELECT 'ADMIN', 'Quản trị viên hệ thống'
WHERE NOT EXISTS (SELECT 1 FROM nhom_quyen WHERE ten_nhom_quyen = 'ADMIN');

INSERT INTO nhom_quyen (ten_nhom_quyen, mo_ta)
SELECT 'MANAGER', 'Quản lý cửa hàng'
WHERE NOT EXISTS (SELECT 1 FROM nhom_quyen WHERE ten_nhom_quyen = 'MANAGER');

INSERT INTO nhom_quyen (ten_nhom_quyen, mo_ta)
SELECT 'PHARMACIST', 'Dược sĩ'
WHERE NOT EXISTS (SELECT 1 FROM nhom_quyen WHERE ten_nhom_quyen = 'PHARMACIST');

INSERT INTO nhom_quyen (ten_nhom_quyen, mo_ta)
SELECT 'CASHIER', 'Thu ngân'
WHERE NOT EXISTS (SELECT 1 FROM nhom_quyen WHERE ten_nhom_quyen = 'CASHIER');

INSERT INTO nhom_quyen (ten_nhom_quyen, mo_ta)
SELECT 'CUSTOMER', 'Khách hàng'
WHERE NOT EXISTS (SELECT 1 FROM nhom_quyen WHERE ten_nhom_quyen = 'CUSTOMER');

-- Thêm dữ liệu cho bảng chi_tiet_chuc_nang (nếu chưa có)
-- Admin có tất cả các chức năng
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 
    (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'ADMIN'), 
    chuc_nang.id
FROM chuc_nang
WHERE NOT EXISTS (
    SELECT 1 FROM chi_tiet_chuc_nang 
    WHERE nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'ADMIN')
    AND chuc_nang_id = chuc_nang.id
);

-- Manager có hầu hết các chức năng trừ xóa người dùng
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 
    (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'MANAGER'), 
    chuc_nang.id
FROM chuc_nang
WHERE hanh_dong != 'DELETE_USER'
AND NOT EXISTS (
    SELECT 1 FROM chi_tiet_chuc_nang 
    WHERE nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'MANAGER')
    AND chuc_nang_id = chuc_nang.id
);

-- Pharmacist có các chức năng liên quan đến thuốc và nhập kho
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 
    (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'PHARMACIST'), 
    chuc_nang.id
FROM chuc_nang
WHERE ten_chuc_nang IN ('Quản lý thuốc', 'Quản lý nhập kho')
AND NOT EXISTS (
    SELECT 1 FROM chi_tiet_chuc_nang 
    WHERE nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'PHARMACIST')
    AND chuc_nang_id = chuc_nang.id
);

-- Cashier có các chức năng liên quan đến đơn hàng
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 
    (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'CASHIER'), 
    chuc_nang.id
FROM chuc_nang
WHERE ten_chuc_nang = 'Quản lý đơn hàng'
AND NOT EXISTS (
    SELECT 1 FROM chi_tiet_chuc_nang 
    WHERE nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'CASHIER')
    AND chuc_nang_id = chuc_nang.id
);

-- Gán quyền ADMIN cho tài khoản admin2 (ID = 1)
INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id)
SELECT 1, (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'ADMIN')
WHERE NOT EXISTS (
    SELECT 1 FROM chi_tiet_nhom_quyen 
    WHERE nguoi_dung_id = 1 
    AND nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'ADMIN')
);

-- Gán quyền MANAGER cho tài khoản manager2 (ID = 2)
INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id)
SELECT 2, (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'MANAGER')
WHERE NOT EXISTS (
    SELECT 1 FROM chi_tiet_nhom_quyen 
    WHERE nguoi_dung_id = 2 
    AND nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'MANAGER')
);

-- Gán quyền PHARMACIST cho tài khoản pharmacist2 (ID = 3)
INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id)
SELECT 3, (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'PHARMACIST')
WHERE NOT EXISTS (
    SELECT 1 FROM chi_tiet_nhom_quyen 
    WHERE nguoi_dung_id = 3 
    AND nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'PHARMACIST')
);

-- Gán quyền CASHIER cho tài khoản cashier2 (ID = 4)
INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id)
SELECT 4, (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'CASHIER')
WHERE NOT EXISTS (
    SELECT 1 FROM chi_tiet_nhom_quyen 
    WHERE nguoi_dung_id = 4 
    AND nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'CASHIER')
);

-- Gán quyền CUSTOMER cho các tài khoản khách hàng (ID = 5-10)
INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id)
SELECT nguoi_dung.id, (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'CUSTOMER')
FROM nguoi_dung
WHERE nguoi_dung.id BETWEEN 5 AND 10
AND NOT EXISTS (
    SELECT 1 FROM chi_tiet_nhom_quyen 
    WHERE nguoi_dung_id = nguoi_dung.id 
    AND nhom_quyen_id = (SELECT id FROM nhom_quyen WHERE ten_nhom_quyen = 'CUSTOMER')
);
