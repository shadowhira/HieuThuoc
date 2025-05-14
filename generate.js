const fs = require('fs');

// This script generates additional SQL INSERT statements for your pharmacy database
// The output can be appended to your existing SQL file

// PostgreSQL uses standard ISO date format

// Generate additional medicine data
function generateMedicineData() {
  const medicines = [
    {
      name: 'Azithromycin 500mg',
      code: 'T016',
      barcode: 'B016',
      type: 3, // Macrolide
      manufacturer: 1,
      unit: 'Viên',
      form: 'Viên nén bao phim',
      packaging: 'Hộp 3 vỉ x 6 viên',
      regNumber: 'VD-12360',
      expiry: '2026-06-30',
      importPrice: 3000,
      sellPrice: 5000,
      stock: 300,
      threshold: 30,
      usage: 'Điều trị nhiễm khuẩn đường hô hấp, da và mô mềm',
      indication: 'Nhiễm khuẩn đường hô hấp trên và dưới, nhiễm khuẩn da và mô mềm',
      contraindication: 'Mẫn cảm với macrolide, suy gan nặng',
      instruction: 'Uống 1 viên/ngày, trong 3 ngày liên tiếp',
      description: 'Thuốc kháng sinh nhóm macrolide',
      avatar: 'azithromycin.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Cefixime 200mg',
      code: 'T017',
      barcode: 'B017',
      type: 2, // Cephalosporin
      manufacturer: 2,
      unit: 'Viên',
      form: 'Viên nang',
      packaging: 'Hộp 10 vỉ x 10 viên',
      regNumber: 'VD-12361',
      expiry: '2026-06-30',
      importPrice: 2500,
      sellPrice: 4000,
      stock: 500,
      threshold: 50,
      usage: 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu',
      indication: 'Nhiễm khuẩn đường hô hấp, tiết niệu, tai mũi họng',
      contraindication: 'Mẫn cảm với cephalosporin',
      instruction: 'Uống 1 viên/lần, ngày 2 lần, sau khi ăn',
      description: 'Thuốc kháng sinh nhóm cephalosporin thế hệ 3',
      avatar: 'cefixime.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Levofloxacin 500mg',
      code: 'T018',
      barcode: 'B018',
      type: 4, // Quinolone
      manufacturer: 3,
      unit: 'Viên',
      form: 'Viên nén bao phim',
      packaging: 'Hộp 1 vỉ x 10 viên',
      regNumber: 'VD-12362',
      expiry: '2026-06-30',
      importPrice: 3500,
      sellPrice: 5500,
      stock: 400,
      threshold: 40,
      usage: 'Điều trị nhiễm khuẩn đường hô hấp, tiết niệu, da',
      indication: 'Viêm phổi, viêm phế quản, nhiễm khuẩn tiết niệu, nhiễm khuẩn da',
      contraindication: 'Mẫn cảm với quinolone, trẻ em dưới 18 tuổi, phụ nữ có thai',
      instruction: 'Uống 1 viên/ngày, trong 7-14 ngày tùy theo mức độ nhiễm khuẩn',
      description: 'Thuốc kháng sinh nhóm quinolone',
      avatar: 'levofloxacin.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Diclofenac 50mg',
      code: 'T019',
      barcode: 'B019',
      type: 6, // NSAIDs
      manufacturer: 4,
      unit: 'Viên',
      form: 'Viên nén bao phim',
      packaging: 'Hộp 3 vỉ x 10 viên',
      regNumber: 'VD-12363',
      expiry: '2026-06-30',
      importPrice: 1000,
      sellPrice: 1800,
      stock: 600,
      threshold: 60,
      usage: 'Giảm đau, kháng viêm',
      indication: 'Đau nhức xương khớp, viêm khớp, đau lưng, đau đầu',
      contraindication: 'Loét dạ dày, tá tràng, suy thận, suy gan, phụ nữ có thai 3 tháng cuối',
      instruction: 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn',
      description: 'Thuốc kháng viêm không steroid',
      avatar: 'diclofenac.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Pantoprazole 40mg',
      code: 'T020',
      barcode: 'B020',
      type: 11, // Proton pump inhibitor
      manufacturer: 5,
      unit: 'Viên',
      form: 'Viên nén bao tan trong ruột',
      packaging: 'Hộp 3 vỉ x 10 viên',
      regNumber: 'VD-12364',
      expiry: '2026-06-30',
      importPrice: 2200,
      sellPrice: 3500,
      stock: 400,
      threshold: 40,
      usage: 'Điều trị loét dạ dày, tá tràng, trào ngược dạ dày thực quản',
      indication: 'Loét dạ dày, tá tràng, trào ngược dạ dày thực quản, hội chứng Zollinger-Ellison',
      contraindication: 'Mẫn cảm với pantoprazole',
      instruction: 'Uống 1 viên/ngày, trước bữa ăn sáng',
      description: 'Thuốc ức chế bơm proton',
      avatar: 'pantoprazole.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Metformin 500mg',
      code: 'T021',
      barcode: 'B021',
      type: 8, // Antidiabetic
      manufacturer: 1,
      unit: 'Viên',
      form: 'Viên nén bao phim',
      packaging: 'Hộp 3 vỉ x 10 viên',
      regNumber: 'VD-12365',
      expiry: '2026-06-30',
      importPrice: 1500,
      sellPrice: 2500,
      stock: 500,
      threshold: 50,
      usage: 'Điều trị đái tháo đường type 2',
      indication: 'Đái tháo đường type 2, hội chứng buồng trứng đa nang',
      contraindication: 'Suy thận, suy gan, nhiễm toan chuyển hóa, phụ nữ có thai',
      instruction: 'Uống 1 viên/lần, ngày 2-3 lần, sau khi ăn',
      description: 'Thuốc điều trị đái tháo đường',
      avatar: 'metformin.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Losartan 50mg',
      code: 'T022',
      barcode: 'B022',
      type: 7, // Antihypertensive
      manufacturer: 2,
      unit: 'Viên',
      form: 'Viên nén bao phim',
      packaging: 'Hộp 3 vỉ x 10 viên',
      regNumber: 'VD-12366',
      expiry: '2026-06-30',
      importPrice: 2000,
      sellPrice: 3200,
      stock: 400,
      threshold: 40,
      usage: 'Điều trị tăng huyết áp, suy tim',
      indication: 'Tăng huyết áp, suy tim, bảo vệ thận ở bệnh nhân đái tháo đường',
      contraindication: 'Phụ nữ có thai, suy gan nặng',
      instruction: 'Uống 1 viên/ngày, có thể uống cùng hoặc không cùng bữa ăn',
      description: 'Thuốc ức chế thụ thể angiotensin II',
      avatar: 'losartan.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    },
    {
      name: 'Atorvastatin 20mg',
      code: 'T023',
      barcode: 'B023',
      type: 9, // Lipid-lowering
      manufacturer: 3,
      unit: 'Viên',
      form: 'Viên nén bao phim',
      packaging: 'Hộp 3 vỉ x 10 viên',
      regNumber: 'VD-12367',
      expiry: '2026-06-30',
      importPrice: 2500,
      sellPrice: 4000,
      stock: 300,
      threshold: 30,
      usage: 'Điều trị tăng cholesterol máu',
      indication: 'Tăng cholesterol máu, dự phòng bệnh tim mạch',
      contraindication: 'Phụ nữ có thai, cho con bú, bệnh gan tiến triển',
      instruction: 'Uống 1 viên/ngày, vào buổi tối',
      description: 'Thuốc ức chế HMG-CoA reductase',
      avatar: 'atorvastatin.jpg',
      status: true,
      note: 'Bảo quản ở nhiệt độ dưới 30 độ C, tránh ánh sáng'
    }
  ];

  let sql = '-- Additional Medicine Data\n';

  // Generate INSERT statements for thuoc table
  medicines.forEach(med => {
    sql += `INSERT INTO thuoc (ten_thuoc, ma_thuoc, ma_vach, loai_thuoc_id, nha_san_xuat_id, don_vi, che_bao, quy_cach, so_dang_ky, han_su_dung, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, cong_dung, chi_dinh, chong_chi_dinh, huong_dan_su_dung, mo_ta_ngan, avatar, trang_thai, ghi_chu) VALUES
('${med.name}', '${med.code}', '${med.barcode}', ${med.type}, ${med.manufacturer}, '${med.unit}', '${med.form}', '${med.packaging}', '${med.regNumber}', '${med.expiry}', ${med.importPrice}, ${med.sellPrice}, ${med.stock}, ${med.threshold}, '${med.usage}', '${med.indication}', '${med.contraindication}', '${med.instruction}', '${med.description}', '${med.avatar}', ${med.status}, '${med.note}');\n`;
  });

  // Generate INSERT statements for thanh_phan_thuoc table
  sql += '\n-- Additional Medicine Components\n';
  sql += `INSERT INTO thanh_phan_thuoc (thuoc_id, ten_thanh_phan, ham_luong, don_vi) VALUES
(16, 'Azithromycin', '500', 'mg'),
(17, 'Cefixime', '200', 'mg'),
(18, 'Levofloxacin', '500', 'mg'),
(19, 'Diclofenac', '50', 'mg'),
(20, 'Pantoprazole', '40', 'mg'),
(21, 'Metformin', '500', 'mg'),
(22, 'Losartan', '50', 'mg'),
(23, 'Atorvastatin', '20', 'mg');\n`;

  // Generate INSERT statements for doi_tuong_sd_thuoc table
  sql += '\n-- Additional Medicine Target Groups\n';
  sql += `INSERT INTO doi_tuong_sd_thuoc (thuoc_id, doi_tuong_id) VALUES
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
(23, 3); -- Atorvastatin - Người cao tuổi\n`;

  // Generate INSERT statements for ton_kho table
  sql += '\n-- Additional Inventory Data\n';
  sql += `INSERT INTO ton_kho (thuoc_id, so_lo, han_su_dung, so_luong, vi_tri, created_at, update_at) VALUES
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
(23, 'LO046', '2026-03-31', 150, 'Kệ W2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);\n`;

  return sql;
}

// Generate additional import receipt data
function generateImportReceiptData() {
  let sql = '\n-- Additional Import Receipt Data\n';

  // Generate INSERT statements for phieu_nhap table
  sql += `INSERT INTO phieu_nhap (nha_cung_cap_id, nguoi_dung_id, tong_tien, created_at, update_at) VALUES
(1, 3, 2500000, '2024-01-15', '2024-01-15'),
(2, 4, 3000000, '2024-02-15', '2024-02-15'),
(3, 3, 2800000, '2024-03-15', '2024-03-15'),
(1, 4, 2200000, '2024-03-20', '2024-03-20'),
(2, 3, 1800000, '2024-03-25', '2024-03-25');\n`;

  // Generate INSERT statements for chi_tiet_phieu_nhap table
  sql += '\n-- Additional Import Receipt Details\n';
  sql += `INSERT INTO chi_tiet_phieu_nhap (phieu_nhap_id, thuoc_id, han_su_dung, so_luong, don_gia) VALUES
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
(10, 23, '2026-03-31', 150, 2500);\n`;

  return sql;
}

// Generate additional promotion data
function generatePromotionData() {
  let sql = '\n-- Additional Promotion Data\n';

  // Generate INSERT statements for khuyen_mai table
  sql += `INSERT INTO khuyen_mai (ten_chuong_trinh, mo_ta, ngay_bat_dau, ngay_ket_thuc, trang_thai) VALUES
('Khuyến mãi mùa hè 2024', 'Giảm giá các sản phẩm trong mùa hè 2024', '2024-06-01', '2024-08-31', true),
('Khuyến mãi khai trương chi nhánh mới', 'Giảm giá nhân dịp khai trương chi nhánh mới', '2024-04-01', '2024-04-30', true);\n`;

  // Generate INSERT statements for chi_tiet_khuyen_mai table
  sql += '\n-- Additional Promotion Details\n';
  sql += `INSERT INTO chi_tiet_khuyen_mai (khuyen_mai_id, thuoc_id, giam_gia) VALUES
(6, 16, 15),
(6, 17, 10),
(6, 18, 20),
(6, 19, 15),
(6, 20, 10),
(6, 21, 15),
(6, 22, 10),
(6, 23, 20),
(7, 1, 20),
(7, 2, 20),
(7, 3, 20),
(7, 4, 20),
(7, 5, 20),
(7, 21, 20),
(7, 22, 20),
(7, 23, 20);\n`;

  return sql;
}

// Generate additional order data
function generateOrderData() {
  let sql = '\n-- Additional Order Data\n';

  // Generate INSERT statements for don_hang table

  sql += `INSERT INTO don_hang (khach_hang_id, nguoi_dung_id, ten_khach_hang, so_dien_thoai, dia_chi, email, giam_gia, tong_tien, ngay_giao, trang_thai_giao_hang, phuong_thuc_thanh_toan, trang_thai_thanh_toan, created_at, update_at) VALUES
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 9500, '2024-02-23', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', '2024-02-15', '2024-02-20'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 12000, '2024-03-06', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', '2024-02-18', '2024-02-23'),
(8, 5, 'Vũ Văn Mua', '0987654328', 'Đà Nẵng', 'customer3@gmail.com', 0, 8500, '2024-02-15', 'DA_GIAO', 'THE_NGAN_HANG', 'DA_THANH_TOAN', '2024-02-20', '2024-02-25'),
(9, 5, 'Đặng Thị Sắm', '0987654329', 'Hải Phòng', 'customer4@gmail.com', 0, 10500, '2024-02-29', 'DANG_GIAO', 'VI_DIEN_TU', 'DA_THANH_TOAN', '2024-03-01', '2024-03-01'),
(10, 5, 'Bùi Văn Tiêu', '0987654330', 'Cần Thơ', 'customer5@gmail.com', 0, 15000, NULL, 'DANG_XU_LY', 'TIEN_MAT', 'CHUA_THANH_TOAN', '2024-03-10', '2024-03-10'),
(6, 5, 'Hoàng Văn Khách', '0987654326', 'Hà Nội', 'customer1@gmail.com', 0, 7500, '2024-03-20', 'DA_GIAO', 'TIEN_MAT', 'DA_THANH_TOAN', '2024-03-15', '2024-03-15'),
(7, 5, 'Ngô Thị Hàng', '0987654327', 'Hồ Chí Minh', 'customer2@gmail.com', 0, 9700, '2024-03-25', 'DA_GIAO', 'CHUYEN_KHOAN', 'DA_THANH_TOAN', '2024-03-18', '2024-03-18');\n`;

  // Generate INSERT statements for chi_tiet_don_hang table
  sql += '\n-- Additional Order Details\n';
  sql += `INSERT INTO chi_tiet_don_hang (don_hang_id, thuoc_id, so_luong, don_gia) VALUES
(11, 16, 1, 5000),
(11, 17, 1, 4000),
(11, 6, 1, 500),
(12, 18, 1, 5500),
(12, 19, 1, 1800),
(12, 20, 1, 3500),
(12, 2, 1, 1200),
(13, 3, 1, 3000),
(13, 4, 1, 2500),
(13, 16, 1, 3000),
(14, 17, 1, 4000),
(14, 18, 1, 5500),
(14, 5, 1, 1000),
(15, 19, 2, 1800),
(15, 20, 2, 3500),
(15, 1, 1, 1500),
(15, 2, 1, 1200),
(16, 21, 1, 2500),
(16, 22, 1, 3200),
(16, 23, 1, 1800),
(17, 21, 1, 2500),
(17, 22, 1, 3200),
(17, 23, 1, 4000);\n`;

  return sql;
}

// Generate additional review data
function generateReviewData() {
  let sql = '\n-- Additional Review Data\n';

  // Generate INSERT statements for danh_gia table
  sql += `INSERT INTO danh_gia (thuoc_id, nguoi_dung_id, danh_gia_id, diem_so, danh_gia, created_at, update_at) VALUES
(16, 6, NULL, 5, 'Thuốc rất hiệu quả, tôi đã khỏi viêm họng sau 3 ngày sử dụng.', '2024-02-25', '2024-02-25'),
(17, 7, NULL, 4, 'Thuốc tốt, con tôi đã khỏi viêm phổi sau một đợt điều trị.', '2024-02-28', '2024-02-28'),
(18, 8, NULL, 5, 'Thuốc trị viêm phổi rất hiệu quả, tôi đã khỏi bệnh sau 7 ngày.', '2024-03-05', '2024-03-05'),
(19, 9, NULL, 4, 'Thuốc giảm đau hiệu quả, nhưng hơi khó uống.', '2024-03-08', '2024-03-08'),
(20, 10, NULL, 5, 'Thuốc trị đau dạ dày rất tốt, tôi không còn đau sau 2 ngày sử dụng.', '2024-03-12', '2024-03-12'),
(16, 3, 6, NULL, 'Cảm ơn bạn đã đánh giá. Azithromycin là kháng sinh mạnh và hiệu quả với nhiều loại nhiễm khuẩn.', '2024-02-26', '2024-02-26'),
(17, 3, 7, NULL, 'Cảm ơn bạn đã đánh giá. Cefixime là lựa chọn tốt cho trẻ em vì có thể dùng đường uống và ít tác dụng phụ.', '2024-03-01', '2024-03-01'),
(18, 4, 8, NULL, 'Cảm ơn bạn đã đánh giá. Levofloxacin là kháng sinh phổ rộng hiệu quả với nhiều loại nhiễm khuẩn.', '2024-03-06', '2024-03-06'),
(19, 4, 9, NULL, 'Cảm ơn bạn đã đánh giá. Diclofenac có thể gây khó chịu dạ dày, nên uống sau khi ăn để giảm tác dụng phụ.', '2024-03-09', '2024-03-09'),
(20, 3, 10, NULL, 'Cảm ơn bạn đã đánh giá. Pantoprazole là thuốc ức chế bơm proton hiệu quả trong điều trị các bệnh lý dạ dày.', '2024-03-13', '2024-03-13');\n`;

  return sql;
}

// Generate additional drug interaction data
function generateDrugInteractionData() {
  let sql = '\n-- Additional Drug Interaction Data\n';

  // Generate INSERT statements for tuong_tac_thuoc table
  sql += `INSERT INTO tuong_tac_thuoc (hoat_chat1, hoat_chat2, co_che, hau_qua, xu_tri) VALUES
('Azithromycin', 'Warfarin', 'Azithromycin ức chế chuyển hóa warfarin', 'Tăng tác dụng chống đông của warfarin, tăng nguy cơ xuất huyết', 'Theo dõi INR chặt chẽ, điều chỉnh liều warfarin nếu cần'),
('Cefixime', 'Alcohol', 'Cefixime có thể gây phản ứng disulfiram khi uống cùng rượu', 'Đỏ bừng, buồn nôn, nôn, đau đầu, hạ huyết áp', 'Tránh uống rượu trong khi dùng cefixime và 3 ngày sau khi ngừng thuốc'),
('Levofloxacin', 'Theophylline', 'Levofloxacin ức chế chuyển hóa theophylline', 'Tăng nồng độ theophylline trong máu, tăng nguy cơ độc tính', 'Giảm liều theophylline, theo dõi nồng độ theophylline trong máu'),
('Diclofenac', 'Lithium', 'Diclofenac làm giảm thải trừ lithium qua thận', 'Tăng nồng độ lithium trong máu, tăng nguy cơ độc tính', 'Theo dõi nồng độ lithium trong máu, điều chỉnh liều lithium nếu cần'),
('Pantoprazole', 'Atazanavir', 'Pantoprazole làm giảm hấp thu atazanavir do tăng pH dạ dày', 'Giảm nồng độ atazanavir trong máu, giảm hiệu quả điều trị', 'Tránh phối hợp, thay thế pantoprazole bằng thuốc khác nếu có thể');\n`;

  return sql;
}

// Generate additional notification data
function generateNotificationData() {
  let sql = '\n-- Additional Notification Data\n';

  // Generate INSERT statements for thong_bao table
  sql += `INSERT INTO thong_bao (tieu_de, noi_dung, hinh_anh, link_lien_ket, loai_thong_bao, trang_thai, created_at, update_at) VALUES
('Cập nhật giá thuốc mới', 'Một số sản phẩm đã được cập nhật giá mới. Vui lòng kiểm tra!', 'price_update.jpg', '/medicines', 'HE_THONG', false, '2024-03-01', '2024-03-01'),
('Thuốc mới đã nhập kho', 'Các loại thuốc mới đã được nhập kho. Vui lòng kiểm tra!', 'new_medicine.jpg', '/inventory', 'GIAO_DICH', false, '2024-03-05', '2024-03-05'),
('Khuyến mãi khai trương chi nhánh mới', 'Chương trình khuyến mãi khai trương chi nhánh mới sẽ bắt đầu từ ngày 01/04/2024. Giảm giá lên đến 20%!', 'new_branch.jpg', '/promotions', 'KHUYEN_MAI', false, '2024-03-15', '2024-03-15');\n`;

  // Generate INSERT statements for nguoi_nhan_thong_bao table
  sql += '\n-- Additional Notification Recipients\n';
  sql += `INSERT INTO nguoi_nhan_thong_bao (thong_bao_id, nguoi_dung_id) VALUES
(7, 1),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(8, 1),
(8, 2),
(8, 3),
(8, 4),
(9, 1),
(9, 2),
(9, 3),
(9, 4),
(9, 5);\n`;

  return sql;
}

// Generate additional activity log data
function generateActivityLogData() {
  let sql = '\n-- Additional Activity Log Data\n';

  // Generate INSERT statements for lich_su_hoat_dong table
  sql += `INSERT INTO lich_su_hoat_dong (hanh_dong, mo_ta, nguoi_dung_id, created_at, update_at) VALUES
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
('CẬP NHẬT', 'Cập nhật thông tin tồn kho', 4, '2024-03-04 10:00:00', '2024-03-04 10:00:00');\n`;

  return sql;
}

// Generate all additional data
function generateAllAdditionalData() {
  let sql = '-- Additional data for pharmacy database\n\n';

  sql += generateMedicineData();
  sql += generateImportReceiptData();
  sql += generatePromotionData();
  sql += generateOrderData();
  sql += generateReviewData();
  sql += generateDrugInteractionData();
  sql += generateNotificationData();
  sql += generateActivityLogData();

  return sql;
}

// Generate and output the SQL
const additionalSql = generateAllAdditionalData();
fs.writeFileSync('seat.txt', additionalSql);
fs.writeFileSync('seat.sql', additionalSql);