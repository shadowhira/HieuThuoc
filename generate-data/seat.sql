-- Additional data for pharmacy database

-- Base data for parent tables

-- Loại thuốc data
INSERT INTO loai_thuoc (id, ten_loai, mo_ta) VALUES
(1, 'Kháng sinh', 'Thuốc kháng sinh'),
(2, 'Cephalosporin', 'Thuốc kháng sinh nhóm Cephalosporin'),
(3, 'Macrolide', 'Thuốc kháng sinh nhóm Macrolide'),
(4, 'Quinolone', 'Thuốc kháng sinh nhóm Quinolone'),
(5, 'Penicillin', 'Thuốc kháng sinh nhóm Penicillin'),
(6, 'NSAIDs', 'Thuốc kháng viêm không steroid'),
(7, 'Antihypertensive', 'Thuốc điều trị tăng huyết áp'),
(8, 'Antidiabetic', 'Thuốc điều trị đái tháo đường'),
(9, 'Lipid-lowering', 'Thuốc hạ lipid máu'),
(10, 'Antihistamine', 'Thuốc kháng histamine'),
(11, 'Proton pump inhibitor', 'Thuốc ức chế bơm proton'),
(12, 'H2 blocker', 'Thuốc đối kháng thụ thể H2'),
(13, 'Bronchodilator', 'Thuốc giãn phế quản'),
(14, 'Antihistamine', 'Thuốc kháng histamine'),
(15, 'Multivitamin', 'Đa vitamin tổng hợp'),
(16, 'Vitamin C', 'Vitamin C'),
(17, 'Vitamin D', 'Vitamin D'),
(18, 'Corticosteroid', 'Thuốc corticosteroid'),
(19, 'Antifungal', 'Thuốc chống nấm');

-- Nhà sản xuất data
INSERT INTO nha_san_xuat (id, ten_nha_san_xuat, dia_chi, email, so_dien_thoai) VALUES
(1, 'Công ty Dược phẩm Hà Nội', 'Hà Nội', 'contact@hanoi-pharma.com', '0987654321'),
(2, 'Công ty Dược phẩm TP.HCM', 'TP.HCM', 'contact@hcm-pharma.com', '0987654322'),
(3, 'Công ty Dược phẩm Đà Nẵng', 'Đà Nẵng', 'contact@danang-pharma.com', '0987654323'),
(4, 'Công ty Dược phẩm Cần Thơ', 'Cần Thơ', 'contact@cantho-pharma.com', '0987654324'),
(5, 'Công ty Dược phẩm Hải Phòng', 'Hải Phòng', 'contact@haiphong-pharma.com', '0987654325'),
(6, 'GlaxoSmithKline', 'London, UK', 'contact@gsk.com', '+44123456789'),
(7, 'Bayer', 'Leverkusen, Germany', 'contact@bayer.com', '+49123456789'),
(8, 'Roche', 'Basel, Switzerland', 'contact@roche.com', '+41123456780'),
(9, 'AstraZeneca', 'Cambridge, UK', 'contact@astrazeneca.com', '+44123456780'),
(10, 'Johnson & Johnson', 'New Jersey, USA', 'contact@jnj.com', '+12123456780');

-- Nhà cung cấp data
INSERT INTO nha_cung_cap (id, ten_nha_cung_cap, dia_chi, email, so_dien_thoai) VALUES
(1, 'Công ty Phân phối Dược phẩm Hà Nội', 'Hà Nội', 'distribution@hanoi-pharma.com', '0987654331'),
(2, 'Công ty Phân phối Dược phẩm TP.HCM', 'TP.HCM', 'distribution@hcm-pharma.com', '0987654332'),
(3, 'Công ty Phân phối Dược phẩm Đà Nẵng', 'Đà Nẵng', 'distribution@danang-pharma.com', '0987654333');

-- Đối tượng data
INSERT INTO doi_tuong (id, ten_doi_tuong, mo_ta) VALUES
(1, 'Người lớn', 'Người từ 18 tuổi trở lên'),
(2, 'Trẻ em', 'Trẻ từ 2-12 tuổi'),
(3, 'Người cao tuổi', 'Người từ 65 tuổi trở lên'),
(4, 'Phụ nữ có thai', 'Phụ nữ đang mang thai'),
(5, 'Phụ nữ cho con bú', 'Phụ nữ đang cho con bú'),
(6, 'Trẻ sơ sinh', 'Trẻ dưới 2 tuổi'),
(7, 'Thanh thiếu niên', 'Người từ 12-18 tuổi');

-- Người dùng data
INSERT INTO nguoi_dung (id, ten_dang_nhap, mat_khau, ho_ten, email, so_dien_thoai, dia_chi, trang_thai, created_at, update_at) VALUES
(1, 'admin2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Admin 2', 'admin2@gmail.com', '0987654321', 'Hà Nội', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'manager2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Manager 2', 'manager2@gmail.com', '0987654322', 'Hà Nội', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'pharmacist2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Pharmacist 2', 'pharmacist2@gmail.com', '0987654323', 'Hà Nội', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'cashier2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Cashier 2', 'cashier2@gmail.com', '0987654324', 'Hà Nội', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'customer2', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Customer 2', 'customer2@gmail.com', '0987654325', 'Hà Nội', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'customer3', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Customer 3', 'customer3@gmail.com', '0987654326', 'Hà Nội', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'customer4', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Customer 4', 'customer4@gmail.com', '0987654327', 'Hồ Chí Minh', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'customer5', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Customer 5', 'customer5@gmail.com', '0987654328', 'Đà Nẵng', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'customer6', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Customer 6', 'customer6@gmail.com', '0987654329', 'Hải Phòng', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'customer7', '$2a$10$XRUv1H/KAordI8DUVV6ScORT2JnRg.heFhHpGPEr.UN9UAlpSiPBe', 'Customer 7', 'customer7@gmail.com', '0987654330', 'Cần Thơ', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Thuốc từ ID 1-15 (từ data.sql)
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(1, 'Amoxicillin 500mg', 'T001', 'B001', 1, 1, 'Viên', 'Viên nén', 'Hộp 10 vỉ x 10 viên', 'VD-12345', '2025-12-31', 1000, 1500, 1000, 100, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu, da và mô mềm', 'Nhiễm khuẩn đường hô hấp, tiết niệu, da và mô mềm', 'Mẫn cảm với penicillin, suy gan, suy thận nặng', 'Uống 1 viên/lần, ngày 3 lần, uống sau khi ăn', 'Thuốc kháng sinh nhóm beta-lactam', 'amoxicillin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(2, 'Paracetamol 500mg', 'T002', 'B002', 5, 2, 'Viên', 'Viên nén', 'Hộp 10 vỉ x 10 viên', 'VD-12346', '2025-12-31', 500, 800, 2000, 200, 'Giảm đau, hạ sốt', 'Đau nhẹ đến vừa, sốt', 'Mẫn cảm với paracetamol, suy gan nặng', 'Uống 1-2 viên/lần, cách nhau ít nhất 4 giờ, không quá 8 viên/ngày', 'Thuốc giảm đau, hạ sốt', 'paracetamol.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(3, 'Omeprazole 20mg', 'T003', 'B003', 11, 3, 'Viên', 'Viên nang', 'Hộp 3 vỉ x 10 viên', 'VD-12347', '2025-12-31', 2000, 3000, 500, 50, 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Mẫn cảm với omeprazole', 'Uống 1 viên/ngày, trước bữa ăn sáng', 'Thuốc ức chế bơm proton', 'omeprazole.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(4, 'Atenolol 50mg', 'T004', 'B004', 7, 4, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12348', '2025-12-31', 1500, 2500, 300, 30, 'Điều trị tăng huyết áp, đau thắt ngực', 'Tăng huyết áp, đau thắt ngực', 'Suy tim không kiểm soát được, nhịp tim chậm', 'Uống 1 viên/ngày, vào buổi sáng', 'Thuốc chẹn beta giao cảm', 'atenolol.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(5, 'Cetirizine 10mg', 'T005', 'B005', 14, 5, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12349', '2025-12-31', 1200, 2000, 400, 40, 'Điều trị các triệu chứng dị ứng', 'Viêm mũi dị ứng, mày đay', 'Mẫn cảm với cetirizine, suy thận nặng', 'Uống 1 viên/ngày, vào buổi tối', 'Thuốc kháng histamine', 'cetirizine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(6, 'Vitamin C 500mg', 'T006', 'B006', 16, 6, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12350', '2025-12-31', 800, 1200, 1000, 100, 'Bổ sung vitamin C', 'Thiếu vitamin C, tăng cường miễn dịch', 'Sỏi thận, tăng oxalat niệu', 'Uống 1 viên/ngày, sau bữa ăn', 'Vitamin C', 'vitaminc.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(7, 'Hydrocortisone 1%', 'T007', 'B007', 18, 7, 'Tuýp', 'Kem', 'Tuýp 10g', 'VD-12351', '2025-12-31', 3000, 5000, 200, 20, 'Điều trị viêm da, ngứa', 'Viêm da, ngứa, dị ứng da', 'Nhiễm khuẩn da, mụn trứng cá', 'Bôi lên vùng da bị bệnh, ngày 2-3 lần', 'Thuốc corticosteroid dạng bôi', 'hydrocortisone.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(8, 'Metformin 500mg', 'T008', 'B008', 8, 8, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12352', '2025-12-31', 1000, 1800, 500, 50, 'Điều trị đái tháo đường type 2', 'Đái tháo đường type 2', 'Suy thận, suy gan, nhiễm toan chuyển hóa', 'Uống 1 viên/lần, ngày 2 lần, sau bữa ăn', 'Thuốc điều trị đái tháo đường', 'metformin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(9, 'Losartan 50mg', 'T009', 'B009', 8, 9, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12353', '2025-12-31', 2000, 3500, 300, 30, 'Điều trị tăng huyết áp, suy tim', 'Tăng huyết áp, suy tim', 'Phụ nữ có thai, suy gan nặng', 'Uống 1 viên/ngày, vào buổi sáng', 'Thuốc ức chế thụ thể angiotensin II', 'losartan.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(10, 'Salbutamol 2mg', 'T010', 'B010', 13, 10, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12354', '2025-12-31', 1500, 2500, 400, 40, 'Điều trị hen phế quản, bệnh phổi tắc nghẽn mạn tính', 'Hen phế quản, bệnh phổi tắc nghẽn mạn tính', 'Tăng nhạy cảm với salbutamol', 'Uống 1 viên/lần, ngày 3-4 lần', 'Thuốc giãn phế quản', 'salbutamol.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(11, 'Ciprofloxacin 500mg', 'T011', 'B011', 4, 1, 'Viên', 'Viên nén', 'Hộp 1 vỉ x 10 viên', 'VD-12355', '2025-12-31', 2500, 4000, 300, 30, 'Điều trị nhiễm khuẩn đường tiết niệu, hô hấp, da', 'Nhiễm khuẩn đường tiết niệu, hô hấp, da', 'Mẫn cảm với quinolone, phụ nữ có thai', 'Uống 1 viên/lần, ngày 2 lần, cách nhau 12 giờ', 'Thuốc kháng sinh nhóm quinolone', 'ciprofloxacin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(12, 'Ibuprofen 400mg', 'T012', 'B012', 6, 2, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12356', '2025-12-31', 1200, 2000, 600, 60, 'Giảm đau, kháng viêm', 'Đau nhức, viêm khớp, đau kinh', 'Loét dạ dày, tá tràng, suy thận, suy gan', 'Uống 1 viên/lần, ngày 3 lần, sau khi ăn', 'Thuốc kháng viêm không steroid', 'ibuprofen.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(13, 'Ranitidine 150mg', 'T013', 'B013', 12, 3, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12357', '2025-12-31', 1500, 2500, 400, 40, 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Mẫn cảm với ranitidine', 'Uống 1 viên/lần, ngày 2 lần, sáng và tối', 'Thuốc đối kháng thụ thể H2', 'ranitidine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(14, 'Amlodipine 5mg', 'T014', 'B014', 9, 4, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12358', '2025-12-31', 1800, 3000, 300, 30, 'Điều trị tăng huyết áp, đau thắt ngực', 'Tăng huyết áp, đau thắt ngực', 'Hạ huyết áp, suy tim nặng', 'Uống 1 viên/ngày, vào buổi sáng', 'Thuốc chẹn kênh canxi', 'amlodipine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C'),
(15, 'Loratadine 10mg', 'T015', 'B015', 14, 5, 'Viên', 'Viên nén', 'Hộp 3 vỉ x 10 viên', 'VD-12359', '2025-12-31', 1000, 1800, 500, 50, 'Điều trị các triệu chứng dị ứng', 'Viêm mũi dị ứng, mày đay', 'Mẫn cảm với loratadine', 'Uống 1 viên/ngày', 'Thuốc kháng histamine', 'loratadine.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C');

-- Additional Medicine Data
-- Đảm bảo ID được chỉ định rõ ràng để tránh lỗi khóa ngoại
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(16, 'Azithromycin 500mg', 'T016', 'B016', 3, 1, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 6 viên', 'VD-12360', '2026-06-30', 3000, 5000, 300, 30, 'Điều trị nhiễm khuẩn đường hô hấp, da và mô mềm', 'Nhiễm khuẩn đường hô hấp trên và dưới, nhiễm khuẩn da và mô mềm', 'Mẫn cảm với macrolide, suy gan nặng', 'Uống 1 viên/ngày, trong 3 ngày liên tiếp', 'Thuốc kháng sinh nhóm macrolide', 'azithromycin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(17, 'Cefixime 200mg', 'T017', 'B017', 2, 2, 'Viên', 'Viên nang', 'Hộp 10 vỉ x 10 viên', 'VD-12361', '2026-06-30', 2500, 4000, 500, 50, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu', 'Nhiễm khuẩn đường hô hấp, tiết niệu, tai mũi họng', 'Mẫn cảm với cephalosporin', 'Uống 1 viên/lần, ngày 2 lần, sau khi ăn', 'Thuốc kháng sinh nhóm cephalosporin thế hệ 3', 'cefixime.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(18, 'Levofloxacin 500mg', 'T018', 'B018', 4, 3, 'Viên', 'Viên nén bao phim', 'Hộp 1 vỉ x 10 viên', 'VD-12362', '2026-06-30', 3500, 5500, 400, 40, 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu, da', 'Viêm phổi, viêm phế quản, nhiễm khuẩn tiết niệu, nhiễm khuẩn da', 'Mẫn cảm với quinolone, trẻ em dưới 18 tuổi, phụ nữ có thai', 'Uống 1 viên/ngày, trong 7-14 ngày tùy theo mức độ nhiễm khuẩn', 'Thuốc kháng sinh nhóm quinolone', 'levofloxacin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(19, 'Diclofenac 50mg', 'T019', 'B019', 6, 4, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12363', '2026-06-30', 1000, 1800, 600, 60, 'Giảm đau, kháng viêm', 'Đau nhức xương khớp, viêm khớp, đau lưng, đau đầu', 'Loét dạ dày, tá tràng, suy thận, suy gan, phụ nữ có thai 3 tháng cuối', 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn', 'Thuốc kháng viêm không steroid', 'diclofenac.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(20, 'Pantoprazole 40mg', 'T020', 'B020', 11, 5, 'Viên', 'Viên nén bao tan trong ruột', 'Hộp 3 vỉ x 10 viên', 'VD-12364', '2026-06-30', 2200, 3500, 400, 40, 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản', 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản, hội chứng Zollinger-Ellison', 'Mẫn cảm với pantoprazole', 'Uống 1 viên/ngày, trước bữa ăn sáng', 'Thuốc ức chế bơm proton', 'pantoprazole.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(21, 'Metformin 500mg', 'T021', 'B021', 8, 1, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12365', '2026-06-30', 1500, 2500, 500, 50, 'Điều trị đái tháo đường type 2', 'Đái tháo đường type 2, hội chứng buồng trứng đa nang', 'Suy thận, suy gan, nhiễm toan chuyển hóa, phụ nữ có thai', 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn', 'Thuốc điều trị đái tháo đường', 'metformin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(22, 'Losartan 50mg', 'T022', 'B022', 7, 2, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12366', '2026-06-30', 2000, 3200, 400, 40, 'Điều trị tăng huyết áp, suy tim', 'Tăng huyết áp, suy tim, bảo vệ thận ở bệnh nhân đái tháo đường', 'Phụ nữ có thai, suy gan nặng', 'Uống 1 viên/ngày, có thể uống cùng hoặc không cùng bữa ăn', 'Thuốc ức chế thụ thể angiotensin II', 'losartan.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
(23, 'Atorvastatin 20mg', 'T023', 'B023', 9, 3, 'Viên', 'Viên nén bao phim', 'Hộp 3 vỉ x 10 viên', 'VD-12367', '2026-06-30', 2500, 4000, 300, 30, 'Điều trị tăng cholesterol máu', 'Tăng cholesterol máu, dự phòng bệnh tim mạch', 'Phụ nữ có thai, cho con bú, bệnh gan tiến triển', 'Uống 1 viên/ngày, vào buổi tối', 'Thuốc ức chế HMG-CoA reductase', 'atorvastatin.jpg', true, 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng');

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
INSERT INTO phieu_nhap (id, nha_cung_cap_id, nguoi_dung_id, tong_tien, created_at, update_at) VALUES
(6, 1, 3, 2500000, '2024-01-15', '2024-01-15'),
(7, 2, 4, 3000000, '2024-02-15', '2024-02-15'),
(8, 3, 3, 2800000, '2024-03-15', '2024-03-15'),
(9, 1, 4, 2200000, '2024-03-20', '2024-03-20'),
(10, 2, 3, 1800000, '2024-03-25', '2024-03-25');

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
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 16, 15),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 17, 10),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 18, 20),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 19, 15),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 20, 10),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 21, 15),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 22, 10),
((SELECT COALESCE(MAX(id), 0) FROM khuyen_mai), 23, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 1, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 2, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 3, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 4, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 5, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 21, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 22, 20),
((SELECT COALESCE(MAX(id), 0) - 1 FROM khuyen_mai), 23, 20);

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
((SELECT COALESCE(MAX(id), 0) FROM don_hang), 16, 1, 5000),
((SELECT COALESCE(MAX(id), 0) FROM don_hang), 17, 1, 4000),
((SELECT COALESCE(MAX(id), 0) FROM don_hang), 6, 1, 500),
((SELECT COALESCE(MAX(id), 0) - 1 FROM don_hang), 18, 1, 5500),
((SELECT COALESCE(MAX(id), 0) - 1 FROM don_hang), 19, 1, 1800),
((SELECT COALESCE(MAX(id), 0) - 1 FROM don_hang), 20, 1, 3500),
((SELECT COALESCE(MAX(id), 0) - 1 FROM don_hang), 2, 1, 1200),
((SELECT COALESCE(MAX(id), 0) - 2 FROM don_hang), 3, 1, 3000),
((SELECT COALESCE(MAX(id), 0) - 2 FROM don_hang), 4, 1, 2500),
((SELECT COALESCE(MAX(id), 0) - 2 FROM don_hang), 16, 1, 3000),
((SELECT COALESCE(MAX(id), 0) - 3 FROM don_hang), 17, 1, 4000),
((SELECT COALESCE(MAX(id), 0) - 3 FROM don_hang), 18, 1, 5500),
((SELECT COALESCE(MAX(id), 0) - 3 FROM don_hang), 5, 1, 1000),
((SELECT COALESCE(MAX(id), 0) - 4 FROM don_hang), 19, 2, 1800),
((SELECT COALESCE(MAX(id), 0) - 4 FROM don_hang), 20, 2, 3500),
((SELECT COALESCE(MAX(id), 0) - 4 FROM don_hang), 1, 1, 1500),
((SELECT COALESCE(MAX(id), 0) - 4 FROM don_hang), 2, 1, 1200),
((SELECT COALESCE(MAX(id), 0) - 5 FROM don_hang), 21, 1, 2500),
((SELECT COALESCE(MAX(id), 0) - 5 FROM don_hang), 22, 1, 3200),
((SELECT COALESCE(MAX(id), 0) - 5 FROM don_hang), 23, 1, 1800),
((SELECT COALESCE(MAX(id), 0) - 6 FROM don_hang), 21, 1, 2500),
((SELECT COALESCE(MAX(id), 0) - 6 FROM don_hang), 22, 1, 3200),
((SELECT COALESCE(MAX(id), 0) - 6 FROM don_hang), 23, 1, 4000);

-- Additional Review Data
INSERT INTO danh_gia (thuoc_id, nguoi_dung_id, danh_gia_id, diem_so, danh_gia, created_at, update_at) VALUES
(16, 6, NULL, 5, 'Thuốc rất hiệu quả, tôi đã khỏi viêm họng sau 3 ngày sử dụng.', '2024-02-25', '2024-02-25'),
(17, 7, NULL, 4, 'Thuốc tốt, con tôi đã khỏi viêm phổi sau một đợt điều trị.', '2024-02-28', '2024-02-28'),
(18, 8, NULL, 5, 'Thuốc trị viêm phổi rất hiệu quả, tôi đã khỏi bệnh sau 7 ngày.', '2024-03-05', '2024-03-05'),
(19, 9, NULL, 4, 'Thuốc giảm đau hiệu quả, nhưng hơi khó uống.', '2024-03-08', '2024-03-08'),
(20, 10, NULL, 5, 'Thuốc trị đau dạ dày rất tốt, tôi không còn đau sau 2 ngày sử dụng.', '2024-03-12', '2024-03-12');

-- Additional Review Responses
INSERT INTO danh_gia (thuoc_id, nguoi_dung_id, danh_gia_id, diem_so, danh_gia, created_at, update_at) VALUES
(16, 3, (SELECT id FROM danh_gia WHERE thuoc_id = 16 AND nguoi_dung_id = 6 AND danh_gia_id IS NULL), NULL, 'Cảm ơn bạn đã đánh giá. Azithromycin là kháng sinh mạnh và hiệu quả với nhiều loại nhiễm khuẩn.', '2024-02-26', '2024-02-26'),
(17, 3, (SELECT id FROM danh_gia WHERE thuoc_id = 17 AND nguoi_dung_id = 7 AND danh_gia_id IS NULL), NULL, 'Cảm ơn bạn đã đánh giá. Cefixime là lựa chọn tốt cho trẻ em vì có thể dùng đường uống và ít tác dụng phụ.', '2024-03-01', '2024-03-01'),
(18, 4, (SELECT id FROM danh_gia WHERE thuoc_id = 18 AND nguoi_dung_id = 8 AND danh_gia_id IS NULL), NULL, 'Cảm ơn bạn đã đánh giá. Levofloxacin là kháng sinh phổ rộng hiệu quả với nhiều loại nhiễm khuẩn.', '2024-03-06', '2024-03-06'),
(19, 4, (SELECT id FROM danh_gia WHERE thuoc_id = 19 AND nguoi_dung_id = 9 AND danh_gia_id IS NULL), NULL, 'Cảm ơn bạn đã đánh giá. Diclofenac có thể gây khó chịu dạ dày, nên uống sau khi ăn để giảm tác dụng phụ.', '2024-03-09', '2024-03-09'),
(20, 3, (SELECT id FROM danh_gia WHERE thuoc_id = 20 AND nguoi_dung_id = 10 AND danh_gia_id IS NULL), NULL, 'Cảm ơn bạn đã đánh giá. Pantoprazole là thuốc ức chế bơm proton hiệu quả trong điều trị các bệnh lý dạ dày.', '2024-03-13', '2024-03-13');

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
((SELECT COALESCE(MAX(id), 0) FROM thong_bao), 1),
((SELECT COALESCE(MAX(id), 0) FROM thong_bao), 2),
((SELECT COALESCE(MAX(id), 0) FROM thong_bao), 3),
((SELECT COALESCE(MAX(id), 0) FROM thong_bao), 4),
((SELECT COALESCE(MAX(id), 0) FROM thong_bao), 5),
((SELECT COALESCE(MAX(id), 0) - 1 FROM thong_bao), 1),
((SELECT COALESCE(MAX(id), 0) - 1 FROM thong_bao), 2),
((SELECT COALESCE(MAX(id), 0) - 1 FROM thong_bao), 3),
((SELECT COALESCE(MAX(id), 0) - 1 FROM thong_bao), 4),
((SELECT COALESCE(MAX(id), 0) - 2 FROM thong_bao), 1),
((SELECT COALESCE(MAX(id), 0) - 2 FROM thong_bao), 2),
((SELECT COALESCE(MAX(id), 0) - 2 FROM thong_bao), 3),
((SELECT COALESCE(MAX(id), 0) - 2 FROM thong_bao), 4),
((SELECT COALESCE(MAX(id), 0) - 2 FROM thong_bao), 5);

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
