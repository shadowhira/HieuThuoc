DO $$
DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public')
    LOOP
        EXECUTE 'TRUNCATE TABLE ' || quote_ident(r.tablename) || ' RESTART IDENTITY CASCADE';
    END LOOP;
END $$;


-- Seed data for chuc_nang (Functions)
INSERT INTO chuc_nang (ten_chuc_nang, hanh_dong, mo_ta) VALUES
('Quản lý người dùng', 'VIEW_USER', 'Xem danh sách người dùng'),
('Quản lý người dùng', 'CREATE_USER', 'Tạo mới người dùng'),
('Quản lý người dùng', 'UPDATE_USER', 'Cập nhật thông tin người dùng'),
('Quản lý người dùng', 'DELETE_USER', 'Xóa người dùng'),
('Quản lý thuốc', 'VIEW_MEDICINE', 'Xem danh sách thuốc'),
('Quản lý thuốc', 'CREATE_MEDICINE', 'Tạo mới thuốc'),
('Quản lý thuốc', 'UPDATE_MEDICINE', 'Cập nhật thông tin thuốc'),
('Quản lý thuốc', 'DELETE_MEDICINE', 'Xóa thuốc'),
('Quản lý đơn hàng', 'VIEW_ORDER', 'Xem danh sách đơn hàng'),
('Quản lý đơn hàng', 'CREATE_ORDER', 'Tạo mới đơn hàng'),
('Quản lý đơn hàng', 'UPDATE_ORDER', 'Cập nhật thông tin đơn hàng'),
('Quản lý đơn hàng', 'DELETE_ORDER', 'Xóa đơn hàng'),
('Quản lý nhập kho', 'VIEW_IMPORT', 'Xem danh sách phiếu nhập'),
('Quản lý nhập kho', 'CREATE_IMPORT', 'Tạo mới phiếu nhập'),
('Quản lý nhập kho', 'UPDATE_IMPORT', 'Cập nhật thông tin phiếu nhập'),
('Quản lý nhập kho', 'DELETE_IMPORT', 'Xóa phiếu nhập'),
('Quản lý khuyến mãi', 'VIEW_PROMOTION', 'Xem danh sách khuyến mãi'),
('Quản lý khuyến mãi', 'CREATE_PROMOTION', 'Tạo mới khuyến mãi'),
('Quản lý khuyến mãi', 'UPDATE_PROMOTION', 'Cập nhật thông tin khuyến mãi'),
('Quản lý khuyến mãi', 'DELETE_PROMOTION', 'Xóa khuyến mãi');

-- Seed data for nhom_quyen (Role Groups)
INSERT INTO nhom_quyen (ten_nhom_quyen, mo_ta) VALUES
('ADMIN', 'Quản trị viên hệ thống'),
('MANAGER', 'Quản lý cửa hàng'),
('PHARMACIST', 'Dược sĩ'),
('CASHIER', 'Thu ngân'),
('CUSTOMER', 'Khách hàng');

-- Seed data for chi_tiet_chuc_nang (Role-Function mapping)
-- Admin has all functions
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 1, id FROM chuc_nang;

-- Manager has most functions except user deletion
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 2, id FROM chuc_nang WHERE hanh_dong != 'DELETE_USER';

-- Pharmacist has medicine and inventory related functions
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 3, id FROM chuc_nang WHERE
    ten_chuc_nang = 'Quản lý thuốc' OR
    ten_chuc_nang = 'Quản lý nhập kho';

-- Cashier has order related functions
INSERT INTO chi_tiet_chuc_nang (nhom_quyen_id, chuc_nang_id)
SELECT 4, id FROM chuc_nang WHERE
    ten_chuc_nang = 'Quản lý đơn hàng';

-- Seed data for nguoi_dung (Users)
INSERT INTO nguoi_dung (ten_dang_nhap, mat_khau, ho_ten, email, dia_chi, so_dien_thoai, avatar, trang_thai, created_at, update_at) VALUES
('admin', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Admin System', 'admin@pharmacy.com', 'Hà Nội', '0987654321', 'avatar1.jpg', true, NOW(), NOW()),
('manager', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Nguyễn Văn Quản Lý', 'manager@pharmacy.com', 'Hồ Chí Minh', '0987654322', 'avatar2.jpg', true, NOW(), NOW()),
('pharmacist1', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Trần Thị Dược Sĩ', 'pharmacist1@pharmacy.com', 'Đà Nẵng', '0987654323', 'avatar3.jpg', true, NOW(), NOW()),
('pharmacist2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Lê Văn Dược', 'pharmacist2@pharmacy.com', 'Hải Phòng', '0987654324', 'avatar4.jpg', true, NOW(), NOW()),
('cashier1', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Phạm Thị Thu Ngân', 'cashier1@pharmacy.com', 'Cần Thơ', '0987654325', 'avatar5.jpg', true, NOW(), NOW()),
('customer1', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Hoàng Văn Khách', 'customer1@gmail.com', 'Hà Nội', '0987654326', 'avatar6.jpg', true, NOW(), NOW()),
('customer2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Ngô Thị Hàng', 'customer2@gmail.com', 'Hồ Chí Minh', '0987654327', 'avatar7.jpg', true, NOW(), NOW()),
('customer3', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Vũ Văn Mua', 'customer3@gmail.com', 'Đà Nẵng', '0987654328', 'avatar8.jpg', true, NOW(), NOW()),
('customer4', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Đặng Thị Sắm', 'customer4@gmail.com', 'Hải Phòng', '0987654329', 'avatar9.jpg', true, NOW(), NOW()),
('customer5', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Bùi Văn Tiêu', 'customer5@gmail.com', 'Cần Thơ', '0987654330', 'avatar10.jpg', true, NOW(), NOW());

-- Seed data for chi_tiet_nhom_quyen (User-Role mapping)
INSERT INTO chi_tiet_nhom_quyen (nguoi_dung_id, nhom_quyen_id) VALUES
(1, 1), -- admin is ADMIN
(2, 2), -- manager is MANAGER
(3, 3), -- pharmacist1 is PHARMACIST
(4, 3), -- pharmacist2 is PHARMACIST
(5, 4), -- cashier1 is CASHIER
(6, 5), -- customer1 is CUSTOMER
(7, 5), -- customer2 is CUSTOMER
(8, 5), -- customer3 is CUSTOMER
(9, 5), -- customer4 is CUSTOMER
(10, 5); -- customer5 is CUSTOMER

-- Seed data for danh_muc_thuoc (Medicine Categories)
INSERT INTO danh_muc_thuoc (ten_danh_muc, mo_ta) VALUES
('Thuốc kháng sinh', 'Các loại thuốc kháng sinh điều trị nhiễm khuẩn'),
('Thuốc giảm đau', 'Các loại thuốc giảm đau, hạ sốt'),
('Thuốc tim mạch', 'Các loại thuốc điều trị bệnh tim mạch'),
('Thuốc tiêu hóa', 'Các loại thuốc điều trị bệnh đường tiêu hóa'),
('Thuốc hô hấp', 'Các loại thuốc điều trị bệnh đường hô hấp'),
('Vitamin và khoáng chất', 'Các loại vitamin và khoáng chất bổ sung'),
('Thuốc da liễu', 'Các loại thuốc điều trị bệnh da liễu');

-- Seed data for loai_thuoc (Medicine Types)
INSERT INTO loai_thuoc (ten_loai, mo_ta, danh_muc_thuoc_id) VALUES
('Penicillin', 'Nhóm kháng sinh Penicillin', 1),
('Cephalosporin', 'Nhóm kháng sinh Cephalosporin', 1),
('Macrolide', 'Nhóm kháng sinh Macrolide', 1),
('Quinolone', 'Nhóm kháng sinh Quinolone', 1),
('Paracetamol', 'Thuốc giảm đau hạ sốt Paracetamol', 2),
('NSAIDs', 'Thuốc kháng viêm không steroid', 2),
('Beta-blocker', 'Thuốc chẹn beta giao cảm', 3),
('ACE inhibitor', 'Thuốc ức chế men chuyển', 3),
('Calcium channel blocker', 'Thuốc chẹn kênh canxi', 3),
('Antacid', 'Thuốc kháng acid', 4),
('Proton pump inhibitor', 'Thuốc ức chế bơm proton', 4),
('H2 blocker', 'Thuốc đối kháng thụ thể H2', 4),
('Bronchodilator', 'Thuốc giãn phế quản', 5),
('Antihistamine', 'Thuốc kháng histamine', 5),
('Multivitamin', 'Đa vitamin tổng hợp', 6),
('Vitamin C', 'Vitamin C', 6),
('Vitamin D', 'Vitamin D', 6),
('Corticosteroid', 'Thuốc corticosteroid', 7),
('Antifungal', 'Thuốc chống nấm', 7);

-- Seed data for nha_san_xuat (Manufacturers)
INSERT INTO nha_san_xuat (mansx, ten_nha_san_xuat, nuoc_san_xuat, dia_chi, so_dien_thoai, email) VALUES
('NSX001', 'Công ty Dược phẩm Hà Nội', 'Việt Nam', 'Hà Nội', '0243123456', 'contact@hanoidrug.com'),
('NSX002', 'Công ty Dược phẩm Hồ Chí Minh', 'Việt Nam', 'Hồ Chí Minh', '0283123456', 'contact@hcmdrug.com'),
('NSX003', 'Pfizer', 'Mỹ', 'New York, USA', '+12123456789', 'contact@pfizer.com'),
('NSX004', 'Novartis', 'Thụy Sĩ', 'Basel, Switzerland', '+41123456789', 'contact@novartis.com'),
('NSX005', 'Sanofi', 'Pháp', 'Paris, France', '+33123456789', 'contact@sanofi.com'),
('NSX006', 'GlaxoSmithKline', 'Anh', 'London, UK', '+44123456789', 'contact@gsk.com'),
('NSX007', 'Bayer', 'Đức', 'Leverkusen, Germany', '+49123456789', 'contact@bayer.com'),
('NSX008', 'Roche', 'Thụy Sĩ', 'Basel, Switzerland', '+41123456780', 'contact@roche.com'),
('NSX009', 'AstraZeneca', 'Anh', 'Cambridge, UK', '+44123456780', 'contact@astrazeneca.com'),
('NSX010', 'Johnson & Johnson', 'Mỹ', 'New Jersey, USA', '+12123456780', 'contact@jnj.com');

-- Seed data for nha_cung_cap (Suppliers)
INSERT INTO nha_cung_cap (mancc, ten_nha_cung_cap, dia_chi, so_dien_thoai, email) VALUES
('NCC001', 'Công ty Phân phối Dược phẩm Miền Bắc', 'Hà Nội', '0243123457', 'contact@northdrug.com'),
('NCC002', 'Công ty Phân phối Dược phẩm Miền Nam', 'Hồ Chí Minh', '0283123457', 'contact@southdrug.com'),
('NCC003', 'Công ty Phân phối Dược phẩm Miền Trung', 'Đà Nẵng', '0236123457', 'contact@centraldrug.com'),
('NCC004', 'Công ty Phân phối Dược phẩm Quốc tế', 'Hà Nội', '0243123458', 'contact@internationaldrug.com'),
('NCC005', 'Công ty Phân phối Dược phẩm Châu Á', 'Hồ Chí Minh', '0283123458', 'contact@asiadrug.com');

-- Seed data for doi_tuong (Target Groups)
INSERT INTO doi_tuong (ten_doi_tuong, mo_ta) VALUES
('Người lớn', 'Người từ 18 tuổi trở lên'),
('Trẻ em', 'Trẻ em từ 2-12 tuổi'),
('Người cao tuổi', 'Người từ 65 tuổi trở lên'),
('Phụ nữ có thai', 'Phụ nữ đang mang thai'),
('Phụ nữ cho con bú', 'Phụ nữ đang cho con bú'),
('Trẻ sơ sinh', 'Trẻ dưới 2 tuổi'),
('Thanh thiếu niên', 'Người từ 13-17 tuổi');

-- Seed data for thuoc (Medicines)
INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('Amoxicillin 500mg', 'T001', 'B001', 1, 1, 'Viên', 'Viên nén', 'Hộp 10 vỉ x 10 viên', 'VD-12345', '2025-12-31', 1000, 1500, 1000, 100, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu, da và mô mềm', 'Nhiễm khuẩn đường hô hấp, tiết niệu, da và mô mềm', 'Mẫn cảm với penicillin, suy gan, suy thận nặng', 'Uống 1 viên/lần, ngày 3 lần, uống sau khi ăn', 'Thuốc kháng sinh nhóm beta-lactam', 'amoxicillin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Paracetamol 500mg', 'T002', 'B002', 5, 2, 'Viên', 'Viên nén', 'Hộp 10 vỉ x 10 viên', 'VD-12346', '2025-12-31', 500, 800, 2000, 200, 'Giảm đau, hạ sốt', 'Đau nhẹ đến vừa, sốt', 'Mẫn cảm với paracetamol, suy gan nặng', 'Uống 1-2 viên/lần, cách nhau ít nhất 4 giờ, không quá 8 viên/ngày', 'Thuốc giảm đau, hạ sốt', 'paracetamol.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Omeprazole 20mg', 'T003', 'B003', 11, 3, 'Viên', 'Viên nang', 'Hộp 3 vỉ x 10 viên', 'VD-12347', '2025-12-31', 2000, 3000, 500, 50, 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Mẫn cảm với omeprazole', 'Uống 1 viên/ngày, trước bữa ăn sáng', 'Thuốc ức chế bơm proton', 'omeprazole.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Atenolol 50mg', 'T004', 'B004', 7, 4, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12348', '2025-12-31', 1500, 2500, 300, 30, 'Điều trị tăng huyết áp, đau thắt ngực', 'Tăng huyết áp, đau thắt ngực', 'Suy tim không kiểm soát được, nhịp tim chậm', 'Uống 1 viên/ngày, vào buổi sáng', 'Thuốc chẹn beta giao cảm', 'atenolol.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Cetirizine 10mg', 'T005', 'B005', 14, 5, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12349', '2025-12-31', 1200, 2000, 400, 40, 'Điều trị các triệu chứng dị ứng', 'Viêm mũi dị ứng, mày đay', 'Mẫn cảm với cetirizine, suy thận nặng', 'Uống 1 viên/ngày, vào buổi tối', 'Thuốc kháng histamine', 'cetirizine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Vitamin C 500mg', 'T006', 'B006', 16, 6, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12350', '2025-12-31', 800, 1200, 1000, 100, 'Bổ sung vitamin C', 'Thiếu vitamin C, tăng cường miễn dịch', 'Sỏi thận, tăng oxalat niệu', 'Uống 1 viên/ngày, sau bữa ăn', 'Vitamin C', 'vitaminc.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Hydrocortisone 1%', 'T007', 'B007', 18, 7, 'Tuýp', 'Kem', 'Tuýp 10g', 'VD-12351', '2025-12-31', 3000, 5000, 200, 20, 'Điều trị viêm da, ngứa', 'Viêm da, ngứa, dị ứng da', 'Nhiễm khuẩn da, mụn trứng cá', 'Bôi lên vùng da bị bệnh, ngày 2-3 lần', 'Thuốc corticosteroid dạng bôi', 'hydrocortisone.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Metformin 500mg', 'T008', 'B008', 8, 8, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12352', '2025-12-31', 1000, 1800, 500, 50, 'Điều trị đái tháo đường type 2', 'Đái tháo đường type 2', 'Suy thận, suy gan, nhiễm toan chuyển hóa', 'Uống 1 viên/lần, ngày 2 lần, sau bữa ăn', 'Thuốc điều trị đái tháo đường', 'metformin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Losartan 50mg', 'T009', 'B009', 8, 9, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12353', '2025-12-31', 2000, 3500, 300, 30, 'Điều trị tăng huyết áp, suy tim', 'Tăng huyết áp, suy tim', 'Phụ nữ có thai, suy gan nặng', 'Uống 1 viên/ngày, vào buổi sáng', 'Thuốc ức chế thụ thể angiotensin II', 'losartan.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Salbutamol 2mg', 'T010', 'B010', 13, 10, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12354', '2025-12-31', 1500, 2500, 400, 40, 'Điều trị hen phế quản, bệnh phổi tắc nghẽn mạn tính', 'Hen phế quản, bệnh phổi tắc nghẽn mạn tính', 'Tăng nhạy cảm với salbutamol', 'Uống 1 viên/lần, ngày 3-4 lần', 'Thuốc giãn phế quản', 'salbutamol.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Ciprofloxacin 500mg', 'T011', 'B011', 4, 1, 'Viên', 'Viên nén', 'Hộp 1 vỉ x 10 viên', 'VD-12355', '2025-12-31', 2500, 4000, 300, 30, 'Điều trị nhiễm khuẩn đường tiết niệu, hô hấp, da', 'Nhiễm khuẩn đường tiết niệu, hô hấp, da', 'Mẫn cảm với quinolone, phụ nữ có thai', 'Uống 1 viên/lần, ngày 2 lần, cách nhau 12 giờ', 'Thuốc kháng sinh nhóm quinolone', 'ciprofloxacin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Ibuprofen 400mg', 'T012', 'B012', 6, 2, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12356', '2025-12-31', 1200, 2000, 600, 60, 'Giảm đau, kháng viêm', 'Đau nhức, viêm khớp, đau kinh', 'Loét dạ dày, tá tràng, suy thận, suy gan', 'Uống 1 viên/lần, ngày 3 lần, sau khi ăn', 'Thuốc kháng viêm không steroid', 'ibuprofen.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Ranitidine 150mg', 'T013', 'B013', 12, 3, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12357', '2025-12-31', 1500, 2500, 400, 40, 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Mẫn cảm với ranitidine', 'Uống 1 viên/lần, ngày 2 lần, sáng và tối', 'Thuốc đối kháng thụ thể H2', 'ranitidine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Amlodipine 5mg', 'T014', 'B014', 9, 4, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12358', '2025-12-31', 1800, 3000, 300, 30, 'Điều trị tăng huyết áp, đau thắt ngực', 'Tăng huyết áp, đau thắt ngực', 'Hạ huyết áp, suy tim nặng', 'Uống 1 viên/ngày, vào buổi sáng', 'Thuốc chẹn kênh canxi', 'amlodipine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
('Loratadine 10mg', 'T015', 'B015', 14, 5, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12359', '2025-12-31', 1000, 1800, 500, 50, 'Điều trị các triệu chứng dị ứng', 'Viêm mũi dị ứng, mày đay', 'Mẫn cảm với loratadine', 'Uống 1 viên/ngày', 'Thuốc kháng histamine', 'loratadine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C');

-- Seed data for thanh_phan_thuoc (Medicine Components)
INSERT INTO thanh_phan_thuoc (thuoc_id, ten_thanh_phan, ham_luong, don_vi) VALUES
(1, 'Amoxicillin', '500', 'mg'),
(2, 'Paracetamol', '500', 'mg'),
(3, 'Omeprazole', '20', 'mg'),
(4, 'Atenolol', '50', 'mg'),
(5, 'Cetirizine', '10', 'mg'),
(6, 'Acid ascorbic', '500', 'mg'),
(7, 'Hydrocortisone', '1', '%'),
(8, 'Metformin', '500', 'mg'),
(9, 'Losartan', '50', 'mg'),
(10, 'Salbutamol', '2', 'mg'),
(11, 'Ciprofloxacin', '500', 'mg'),
(12, 'Ibuprofen', '400', 'mg'),
(13, 'Ranitidine', '150', 'mg'),
(14, 'Amlodipine', '5', 'mg'),
(15, 'Loratadine', '10', 'mg');

-- Seed data for doi_tuong_sd_thuoc (Medicine Target Groups)
INSERT INTO doi_tuong_sd_thuoc (thuoc_id, doi_tuong_id) VALUES
(1, 1), -- Amoxicillin - Người lớn
(1, 2), -- Amoxicillin - Trẻ em
(2, 1), -- Paracetamol - Người lớn
(2, 2), -- Paracetamol - Trẻ em
(2, 3), -- Paracetamol - Người cao tuổi
(3, 1), -- Omeprazole - Người lớn
(3, 3), -- Omeprazole - Người cao tuổi
(4, 1), -- Atenolol - Người lớn
(4, 3), -- Atenolol - Người cao tuổi
(5, 1), -- Cetirizine - Người lớn
(5, 2), -- Cetirizine - Trẻ em
(5, 7), -- Cetirizine - Thanh thiếu niên
(6, 1), -- Vitamin C - Người lớn
(6, 2), -- Vitamin C - Trẻ em
(6, 3), -- Vitamin C - Người cao tuổi
(6, 4), -- Vitamin C - Phụ nữ có thai
(6, 5), -- Vitamin C - Phụ nữ cho con bú
(7, 1), -- Hydrocortisone - Người lớn
(7, 2), -- Hydrocortisone - Trẻ em
(8, 1), -- Metformin - Người lớn
(8, 3), -- Metformin - Người cao tuổi
(9, 1), -- Losartan - Người lớn
(9, 3), -- Losartan - Người cao tuổi
(10, 1), -- Salbutamol - Người lớn
(10, 2), -- Salbutamol - Trẻ em
(10, 3), -- Salbutamol - Người cao tuổi
(11, 1), -- Ciprofloxacin - Người lớn
(12, 1), -- Ibuprofen - Người lớn
(12, 7), -- Ibuprofen - Thanh thiếu niên
(13, 1), -- Ranitidine - Người lớn
(13, 3), -- Ranitidine - Người cao tuổi
(14, 1), -- Amlodipine - Người lớn
(14, 3), -- Amlodipine - Người cao tuổi
(15, 1), -- Loratadine - Người lớn
(15, 2), -- Loratadine - Trẻ em
(15, 7); -- Loratadine - Thanh thiếu niên

-- Seed data for ton_kho (Inventory)
INSERT INTO ton_kho (thuoc_id, so_lo, han_su_dung, so_luong, vi_tri, created_at, update_at) VALUES
(1, 'LO001', '2025-12-31', 500, 'Kệ A1', NOW(), NOW()),
(1, 'LO002', '2025-06-30', 500, 'Kệ A2', NOW(), NOW()),
(2, 'LO003', '2025-12-31', 1000, 'Kệ B1', NOW(), NOW()),
(2, 'LO004', '2025-06-30', 1000, 'Kệ B2', NOW(), NOW()),
(3, 'LO005', '2025-12-31', 250, 'Kệ C1', NOW(), NOW()),
(3, 'LO006', '2025-06-30', 250, 'Kệ C2', NOW(), NOW()),
(4, 'LO007', '2025-12-31', 150, 'Kệ D1', NOW(), NOW()),
(4, 'LO008', '2025-06-30', 150, 'Kệ D2', NOW(), NOW()),
(5, 'LO009', '2025-12-31', 200, 'Kệ E1', NOW(), NOW()),
(5, 'LO010', '2025-06-30', 200, 'Kệ E2', NOW(), NOW()),
(6, 'LO011', '2025-12-31', 500, 'Kệ F1', NOW(), NOW()),
(6, 'LO012', '2025-06-30', 500, 'Kệ F2', NOW(), NOW()),
(7, 'LO013', '2025-12-31', 100, 'Kệ G1', NOW(), NOW()),
(7, 'LO014', '2025-06-30', 100, 'Kệ G2', NOW(), NOW()),
(8, 'LO015', '2025-12-31', 250, 'Kệ H1', NOW(), NOW()),
(8, 'LO016', '2025-06-30', 250, 'Kệ H2', NOW(), NOW()),
(9, 'LO017', '2025-12-31', 150, 'Kệ I1', NOW(), NOW()),
(9, 'LO018', '2025-06-30', 150, 'Kệ I2', NOW(), NOW()),
(10, 'LO019', '2025-12-31', 200, 'Kệ J1', NOW(), NOW()),
(10, 'LO020', '2025-06-30', 200, 'Kệ J2', NOW(), NOW()),
(11, 'LO021', '2025-12-31', 150, 'Kệ K1', NOW(), NOW()),
(11, 'LO022', '2025-06-30', 150, 'Kệ K2', NOW(), NOW()),
(12, 'LO023', '2025-12-31', 300, 'Kệ L1', NOW(), NOW()),
(12, 'LO024', '2025-06-30', 300, 'Kệ L2', NOW(), NOW()),
(13, 'LO025', '2025-12-31', 200, 'Kệ M1', NOW(), NOW()),
(13, 'LO026', '2025-06-30', 200, 'Kệ M2', NOW(), NOW()),
(14, 'LO027', '2025-12-31', 150, 'Kệ N1', NOW(), NOW()),
(14, 'LO028', '2025-06-30', 150, 'Kệ N2', NOW(), NOW()),
(15, 'LO029', '2025-12-31', 250, 'Kệ O1', NOW(), NOW()),
(15, 'LO030', '2025-06-30', 250, 'Kệ O2', NOW(), NOW());

-- Seed data for phieu_nhap (Import Receipts)
INSERT INTO phieu_nhap (nha_cung_cap_id, nguoi_dung_id, tong_tien, created_at, update_at) VALUES
(1, 3, 1500000, '2023-01-15', '2023-01-15'),
(2, 3, 2000000, '2023-02-15', '2023-02-15'),
(3, 4, 1800000, '2023-03-15', '2023-03-15'),
(4, 3, 2200000, '2023-04-15', '2023-04-15'),
(5, 4, 1700000, '2023-05-15', '2023-05-15');

-- Seed data for chi_tiet_phieu_nhap (Import Receipt Details)
INSERT INTO chi_tiet_phieu_nhap (phieu_nhap_id, thuoc_id, han_su_dung, so_luong, don_gia) VALUES
(1, 1, '2025-12-31', 200, 1000),
(1, 2, '2025-12-31', 300, 500),
(1, 3, '2025-12-31', 100, 2000),
(1, 4, '2025-12-31', 100, 1500),
(1, 5, '2025-12-31', 100, 1200),
(2, 6, '2025-12-31', 200, 800),
(2, 7, '2025-12-31', 100, 3000),
(2, 8, '2025-12-31', 150, 1000),
(2, 9, '2025-12-31', 100, 2000),
(2, 10, '2025-12-31', 150, 1500),
(3, 11, '2025-12-31', 100, 2500),
(3, 12, '2025-12-31', 200, 1200),
(3, 13, '2025-12-31', 150, 1500),
(3, 14, '2025-12-31', 100, 1800),
(3, 15, '2025-12-31', 150, 1000),
(4, 1, '2025-06-30', 200, 1000),
(4, 2, '2025-06-30', 300, 500),
(4, 3, '2025-06-30', 100, 2000),
(4, 4, '2025-06-30', 100, 1500),
(4, 5, '2025-06-30', 100, 1200),
(5, 6, '2025-06-30', 200, 800),
(5, 7, '2025-06-30', 100, 3000),
(5, 8, '2025-06-30', 150, 1000),
(5, 9, '2025-06-30', 100, 2000),
(5, 10, '2025-06-30', 150, 1500);

-- Seed data for khuyen_mai (Promotions)
INSERT INTO khuyen_mai (ten_chuong_trinh, mo_ta, ngay_bat_dau, ngay_ket_thuc, trang_thai) VALUES
('Khuyến mãi mùa hè', 'Giảm giá các sản phẩm trong mùa hè', '2023-06-01', '2023-08-31', true),
('Khuyến mãi mùa thu', 'Giảm giá các sản phẩm trong mùa thu', '2023-09-01', '2023-11-30', true),
('Khuyến mãi mùa đông', 'Giảm giá các sản phẩm trong mùa đông', '2023-12-01', '2024-02-28', true),
('Khuyến mãi mùa xuân', 'Giảm giá các sản phẩm trong mùa xuân', '2024-03-01', '2024-05-31', true),
('Khuyến mãi ngày lễ', 'Giảm giá các sản phẩm trong các ngày lễ', '2023-12-20', '2024-01-05', true);

-- Seed data for chi_tiet_khuyen_mai (Promotion Details)
INSERT INTO chi_tiet_khuyen_mai (khuyen_mai_id, thuoc_id, giam_gia) VALUES
(1, 1, 10),
(1, 2, 15),
(1, 3, 10),
(1, 4, 5),
(1, 5, 10),
(2, 6, 15),
(2, 7, 10),
(2, 8, 5),
(2, 9, 10),
(2, 10, 15),
(3, 11, 10),
(3, 12, 15),
(3, 13, 10),
(3, 14, 5),
(3, 15, 10),
(4, 1, 15),
(4, 2, 10),
(4, 3, 5),
(4, 4, 10),
(4, 5, 15),
(5, 6, 20),
(5, 7, 15),
(5, 8, 20),
(5, 9, 15),
(5, 10, 20);

-- Seed data for gio_hang (Shopping Carts)
INSERT INTO gio_hang (nguoi_dung_id, created_at, update_at) VALUES
(6, NOW(), NOW()),
(7, NOW(), NOW()),
(8, NOW(), NOW()),
(9, NOW(), NOW()),
(10, NOW(), NOW());

-- Seed data for chi_tiet_gio_hang (Shopping Cart Details)
INSERT INTO chi_tiet_gio_hang (gio_hang_id, thuoc_id, so_luong, don_gia) VALUES
(1, 1, 2, 1500),
(1, 2, 1, 800),
(1, 6, 1, 1200),
(2, 3, 1, 3000),
(2, 4, 2, 2500),
(3, 5, 1, 2000),
(3, 7, 1, 5000),
(4, 8, 2, 1800),
(4, 9, 1, 3500),
(5, 10, 1, 2500),
(5, 11, 2, 4000);

-- Seed data for don_hang (Orders)
INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 3800, '2023-06-15', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', '2023-06-10', '2023-06-15'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 8000, '2023-07-15', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', '2023-07-10', '2023-07-15'),
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 7000, '2023-08-15', 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN', '2023-08-10', '2023-08-15'),
(9, 5, 'Đặng Thị Sắm', '0987654329', 'Hải Phòng', 'customer4@gmail.com', 0, 7100, '2023-09-15', 'DA_GIAO', 'VI_DIEN_TU', 'DA_THANH_TOAN', '2023-09-10', '2023-09-15'),
(10, 5, 'Bùi Văn Tiêu', '0987654330', 'Cần Thơ', 'customer5@gmail.com', 0, 10500, '2023-10-15', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', '2023-10-10', '2023-10-15'),
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 5000, '2023-11-15', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', '2023-11-10', '2023-11-15'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 6000, '2023-12-15', 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN', '2023-12-10', '2023-12-15'),
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 4500, '2024-01-15', 'DANG_GIAO', 'VI_DIEN_TU', 'DA_THANH_TOAN', '2024-01-10', '2024-01-10'),
(9, 5, 'Đặng Thị Sắm', '0987654329', 'Hải Phòng', 'customer4@gmail.com', 0, 7500, '2024-02-15', 'DANG_XU_LY', 'TIEN_MAT', 'CHUA_THANH_TOAN', '2024-02-10', '2024-02-10'),
(10, 5, 'Bùi Văn Tiêu', '0987654330', 'Cần Thơ', 'customer5@gmail.com', 0, 8500, NULL, 'DANG_XU_LY', 'CHUYEN_KHOAN', 'CHUA_THANH_TOAN', '2024-02-12', '2024-02-12');

-- Seed data for chi_tiet_don_hang (Order Details)
INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
(1, 1, 2, 1500),
(1, 2, 1, 800),
(2, 3, 1, 3000),
(2, 4, 2, 2500),
(3, 5, 1, 2000),
(3, 7, 1, 5000),
(4, 8, 2, 1800),
(4, 9, 1, 3500),
(5, 10, 1, 2500),
(5, 11, 2, 4000),
(6, 12, 1, 2000),
(6, 13, 1, 2500),
(6, 6, 1, 500),
(7, 14, 2, 3000),
(8, 15, 1, 1800),
(8, 1, 1, 1500),
(8, 2, 1, 1200),
(9, 3, 1, 3000),
(9, 4, 1, 2500),
(9, 5, 1, 2000),
(10, 6, 1, 1200),
(10, 7, 1, 5000),
(10, 8, 1, 1800),
(10, 9, 1, 500);

-- Seed data for danh_gia (Reviews)
INSERT INTO danh_gia (thuoc_id, nguoi_dung_id, danh_gia_id, diem_so, danh_gia, created_at, update_at) VALUES
(1, 6, NULL, 5, 'Thuốc rất hiệu quả, tôi đã khỏi bệnh sau 3 ngày sử dụng.', '2023-06-20', '2023-06-20'),
(2, 7, NULL, 4, 'Thuốc giảm đau tốt, nhưng hơi chậm tác dụng.', '2023-07-20', '2023-07-20'),
(3, 8, NULL, 5, 'Thuốc trị đau dạ dày rất hiệu quả, tôi không còn cảm thấy khó chịu nữa.', '2023-08-20', '2023-08-20'),
(4, 9, NULL, 3, 'Thuốc có tác dụng nhưng gây buồn ngủ.', '2023-09-20', '2023-09-20'),
(5, 10, NULL, 4, 'Thuốc trị dị ứng tốt, không gây buồn ngủ như các loại khác.', '2023-10-20', '2023-10-20'),
(1, 3, 1, NULL, 'Cảm ơn bạn đã đánh giá. Thuốc này được nhiều người dùng đánh giá cao.', '2023-06-21', '2023-06-21'),
(2, 3, 2, NULL, 'Cảm ơn bạn đã đánh giá. Thuốc này cần uống đủ liều lượng để phát huy tác dụng tốt nhất.', '2023-07-21', '2023-07-21'),
(3, 4, 3, NULL, 'Cảm ơn bạn đã đánh giá. Rất vui khi thuốc đã giúp bạn khỏi bệnh.', '2023-08-21', '2023-08-21'),
(4, 4, 4, NULL, 'Cảm ơn bạn đã đánh giá. Thuốc này có thể gây buồn ngủ, nên tránh lái xe sau khi sử dụng.', '2023-09-21', '2023-09-21'),
(5, 3, 5, NULL, 'Cảm ơn bạn đã đánh giá. Đây là loại thuốc kháng histamine thế hệ mới nên ít gây buồn ngủ.', '2023-10-21', '2023-10-21');

-- Seed data for lich_su_hoat_dong (Activity Logs)
INSERT INTO lich_su_hoat_dong (hanh_dong, mo_ta, nguoi_dung_id, created_at, update_at) VALUES
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 1, '2023-06-01 08:00:00', '2023-06-01 08:00:00'),
('THÊM MỚI', 'Thêm mới thuốc Amoxicillin 500mg', 1, '2023-06-01 09:00:00', '2023-06-01 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin thuốc Paracetamol 500mg', 1, '2023-06-01 10:00:00', '2023-06-01 10:00:00'),
('XÓA', 'Xóa thuốc hết hạn', 1, '2023-06-01 11:00:00', '2023-06-01 11:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 2, '2023-06-02 08:00:00', '2023-06-02 08:00:00'),
('THÊM MỚI', 'Thêm mới nhà cung cấp', 2, '2023-06-02 09:00:00', '2023-06-02 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin nhà sản xuất', 2, '2023-06-02 10:00:00', '2023-06-02 10:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 3, '2023-06-03 08:00:00', '2023-06-03 08:00:00'),
('THÊM MỚI', 'Thêm mới phiếu nhập kho', 3, '2023-06-03 09:00:00', '2023-06-03 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin tồn kho', 3, '2023-06-03 10:00:00', '2023-06-03 10:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 4, '2023-06-04 08:00:00', '2023-06-04 08:00:00'),
('THÊM MỚI', 'Thêm mới phiếu nhập kho', 4, '2023-06-04 09:00:00', '2023-06-04 09:00:00'),
('CẬP NHẬT', 'Cập nhật thông tin tồn kho', 4, '2023-06-04 10:00:00', '2023-06-04 10:00:00'),
('ĐĂNG NHẬP', 'Đăng nhập vào hệ thống', 5, '2023-06-05 08:00:00', '2023-06-05 08:00:00'),
('THÊM MỚI', 'Thêm mới đơn hàng', 5, '2023-06-05 09:00:00', '2023-06-05 09:00:00'),
('CẬP NHẬT', 'Cập nhật trạng thái đơn hàng', 5, '2023-06-05 10:00:00', '2023-06-05 10:00:00');

-- Seed data for thong_bao (Notifications)
INSERT INTO thong_bao (tieu_de, noi_dung, hinh_anh, link_lien_ket, loai_thong_bao, trang_thai, created_at, update_at) VALUES
('Chào mừng bạn đến với hệ thống', 'Chào mừng bạn đến với hệ thống quản lý nhà thuốc. Hãy khám phá các tính năng mới!', 'welcome.jpg', '/dashboard', 'HE_THONG', false, '2023-06-01', '2023-06-01'),
('Cập nhật hệ thống', 'Hệ thống sẽ được bảo trì vào ngày 15/06/2023 từ 22:00 đến 23:00. Xin lỗi vì sự bất tiện này!', 'maintenance.jpg', '/notifications', 'HE_THONG', false, '2023-06-10', '2023-06-10'),
('Đơn hàng mới', 'Bạn có đơn hàng mới cần xử lý. Vui lòng kiểm tra!', 'new_order.jpg', '/orders', 'GIAO_DICH', false, '2023-06-15', '2023-06-15'),
('Khuyến mãi mùa hè', 'Chương trình khuyến mãi mùa hè đã bắt đầu. Giảm giá lên đến 20%!', 'summer_promo.jpg', '/promotions', 'KHUYEN_MAI', false, '2023-06-01', '2023-06-01'),
('Cảnh báo hết hàng', 'Một số sản phẩm sắp hết hàng. Vui lòng kiểm tra và nhập thêm!', 'stock_warning.jpg', '/inventory', 'CANH_BAO', false, '2023-07-01', '2023-07-01'),
('Thông báo cập nhật tài khoản', 'Thông tin tài khoản của bạn đã được cập nhật thành công!', 'account_update.jpg', '/profile', 'TAI_KHOAN', false, '2023-07-15', '2023-07-15');

-- Seed data for nguoi_nhan_thong_bao (Notification Recipients)
INSERT INTO nguoi_nhan_thong_bao (thong_bao_id, nguoi_dung_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(3, 5),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(6, 1);

-- Seed data for tuong_tac_thuoc (Drug Interactions)
INSERT INTO tuong_tac_thuoc (hoat_chat1, hoat_chat2, co_che, hau_qua, xu_tri) VALUES
('Amoxicillin', 'Probenecid', 'Probenecid làm giảm bài tiết amoxicillin qua ống thận', 'Tăng nồng độ và kéo dài tác dụng của amoxicillin', 'Giảm liều amoxicillin khi dùng đồng thời với probenecid'),
('Paracetamol', 'Alcohol', 'Alcohol cảm ứng enzym CYP2E1 chuyển hóa paracetamol thành chất chuyển hóa độc', 'Tăng độc tính gan của paracetamol', 'Tránh uống rượu khi dùng paracetamol'),
('Omeprazole', 'Clopidogrel', 'Omeprazole ức chế enzym CYP2C19 chuyển hóa clopidogrel thành chất chuyển hóa có hoạt tính', 'Giảm hiệu quả chống ngưng tập tiểu cầu của clopidogrel', 'Thay thế omeprazole bằng pantoprazole hoặc ranitidine'),
('Atenolol', 'Verapamil', 'Cộng hưởng tác dụng ức chế nút xoang và dẫn truyền nhĩ thất', 'Nhịp tim chậm, blốc nhĩ thất, hạ huyết áp', 'Tránh phối hợp, nếu cần thiết phải theo dõi chặt chẽ'),
('Ciprofloxacin', 'Calcium', 'Calcium tạo phức với ciprofloxacin làm giảm hấp thu', 'Giảm nồng độ và hiệu quả của ciprofloxacin', 'Uống ciprofloxacin trước hoặc sau khi uống calcium ít nhất 2 giờ'),
('Ibuprofen', 'Warfarin', 'Ibuprofen ức chế kết tập tiểu cầu và gây kích ứng dạ dày', 'Tăng nguy cơ xuất huyết', 'Tránh phối hợp, nếu cần thiết phải theo dõi chặt chẽ INR'),
('Metformin', 'Iodine contrast', 'Thuốc cản quang chứa iod làm giảm chức năng thận', 'Tăng nguy cơ toan lactic', 'Ngừng metformin trước và sau khi chụp X-quang có thuốc cản quang 48 giờ'),
('Losartan', 'Spironolactone', 'Cộng hưởng tác dụng giữ kali', 'Tăng kali máu', 'Theo dõi nồng độ kali máu'),
('Salbutamol', 'Propranolol', 'Đối kháng tác dụng tại thụ thể beta', 'Giảm hiệu quả của salbutamol', 'Tránh phối hợp, thay thế propranolol bằng thuốc chẹn beta chọn lọc'),
('Amlodipine', 'Simvastatin', 'Amlodipine ức chế enzym CYP3A4 chuyển hóa simvastatin', 'Tăng nồng độ simvastatin và nguy cơ độc tính cơ', 'Giảm liều simvastatin hoặc thay thế bằng statin khác');