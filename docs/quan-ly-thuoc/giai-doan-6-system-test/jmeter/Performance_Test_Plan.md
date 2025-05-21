# KẾ HOẠCH KIỂM THỬ HIỆU NĂNG

## 📋 TỔNG QUAN

Tài liệu này mô tả kế hoạch kiểm thử hiệu năng cho chức năng Quản lý thuốc, bao gồm các test case hiệu năng với số lượng dữ liệu lớn.

## 🎯 MỤC TIÊU

- Đánh giá hiệu năng của hệ thống khi xử lý số lượng lớn dữ liệu thuốc
- Xác định giới hạn của hệ thống
- Đảm bảo hệ thống đáp ứng yêu cầu về thời gian phản hồi và thông lượng

## 🛠️ CÔNG CỤ VÀ MÔI TRƯỜNG

- **Công cụ kiểm thử**: JMeter
- **Môi trường kiểm thử**: Môi trường test với cấu hình tương đương môi trường production
- **Cơ sở dữ liệu**: PostgreSQL với dữ liệu test được tạo tự động

## 📝 TEST CASE

### 1. Kiểm thử hiệu năng tải trang với 100 thuốc (PERF_001)

#### 1.1. Mô tả
Kiểm tra hiệu năng của API lấy danh sách thuốc khi có 100 thuốc trong database.

#### 1.2. Điều kiện tiên quyết
- Database có 100 thuốc
- Hệ thống đang chạy ổn định

#### 1.3. Các bước thực hiện
1. Chuẩn bị database với 100 thuốc
2. Sử dụng JMeter để tạo 10 request đồng thời đến API GET /thuoc/getAll
3. Đo thời gian phản hồi trung bình
4. Đo thông lượng
5. Đo tỷ lệ lỗi

#### 1.4. Kết quả mong đợi
- Thời gian phản hồi trung bình < 500ms
- Thông lượng > 10 req/s
- Tỷ lệ lỗi = 0%
- Tất cả request thành công với status code 200

### 2. Kiểm thử hiệu năng tải trang với 1,000 thuốc (PERF_002)

#### 2.1. Mô tả
Kiểm tra hiệu năng của API lấy danh sách thuốc khi có 1,000 thuốc trong database.

#### 2.2. Điều kiện tiên quyết
- Database có 1,000 thuốc
- Hệ thống đang chạy ổn định

#### 2.3. Các bước thực hiện
1. Chuẩn bị database với 1,000 thuốc
2. Sử dụng JMeter để tạo 10 request đồng thời đến API GET /thuoc/getAll
3. Đo thời gian phản hồi trung bình
4. Đo thông lượng
5. Đo tỷ lệ lỗi

#### 2.4. Kết quả mong đợi
- Thời gian phản hồi trung bình < 1000ms
- Thông lượng > 5 req/s
- Tỷ lệ lỗi = 0%
- Tất cả request thành công với status code 200

### 3. Kiểm thử hiệu năng tải trang với 10,000 thuốc (PERF_003)

#### 3.1. Mô tả
Kiểm tra hiệu năng của API lấy danh sách thuốc khi có 10,000 thuốc trong database.

#### 3.2. Điều kiện tiên quyết
- Database có 10,000 thuốc
- Hệ thống đang chạy ổn định

#### 3.3. Các bước thực hiện
1. Chuẩn bị database với 10,000 thuốc
2. Sử dụng JMeter để tạo 10 request đồng thời đến API GET /thuoc/getAll
3. Đo thời gian phản hồi trung bình
4. Đo thông lượng
5. Đo tỷ lệ lỗi

#### 3.4. Kết quả mong đợi
- Thời gian phản hồi trung bình < 3000ms
- Thông lượng > 2 req/s
- Tỷ lệ lỗi = 0%
- Tất cả request thành công với status code 200

### 4. Kiểm thử hiệu năng tìm kiếm với 10,000 thuốc (PERF_004)

#### 4.1. Mô tả
Kiểm tra hiệu năng của API tìm kiếm thuốc khi có 10,000 thuốc trong database.

#### 4.2. Điều kiện tiên quyết
- Database có 10,000 thuốc
- Hệ thống đang chạy ổn định

#### 4.3. Các bước thực hiện
1. Chuẩn bị database với 10,000 thuốc
2. Sử dụng JMeter để tạo 10 request đồng thời đến API GET /thuoc/search với các tiêu chí tìm kiếm khác nhau
3. Đo thời gian phản hồi trung bình
4. Đo thông lượng
5. Đo tỷ lệ lỗi

#### 4.4. Kết quả mong đợi
- Thời gian phản hồi trung bình < 2000ms
- Thông lượng > 3 req/s
- Tỷ lệ lỗi = 0%
- Tất cả request thành công với status code 200

### 5. Kiểm thử hiệu năng phân trang với 10,000 thuốc (PERF_005)

#### 5.1. Mô tả
Kiểm tra hiệu năng của API phân trang danh sách thuốc khi có 10,000 thuốc trong database.

#### 5.2. Điều kiện tiên quyết
- Database có 10,000 thuốc
- Hệ thống đang chạy ổn định

#### 5.3. Các bước thực hiện
1. Chuẩn bị database với 10,000 thuốc
2. Sử dụng JMeter để tạo 10 request đồng thời đến API GET /thuoc/getAll với các tham số phân trang khác nhau
3. Đo thời gian phản hồi trung bình
4. Đo thông lượng
5. Đo tỷ lệ lỗi

#### 5.4. Kết quả mong đợi
- Thời gian phản hồi trung bình < 1000ms
- Thông lượng > 5 req/s
- Tỷ lệ lỗi = 0%
- Tất cả request thành công với status code 200

## 📊 CÁCH THỰC HIỆN

### 1. Chuẩn bị dữ liệu test

#### 1.1. Tạo script tạo dữ liệu test
```sql
-- Script tạo 10,000 thuốc test
INSERT INTO thuoc (ten_thuoc, ma_thuoc, gia_nhap, gia_ban, so_luong, han_su_dung, loai_thuoc_id, nha_san_xuat_id)
SELECT 
  'Thuốc Test ' || i,
  'TEST' || LPAD(i::text, 5, '0'),
  RANDOM() * 1000000,
  RANDOM() * 2000000,
  FLOOR(RANDOM() * 1000),
  CURRENT_DATE + (RANDOM() * 1000)::integer,
  FLOOR(RANDOM() * 10) + 1,
  FLOOR(RANDOM() * 10) + 1
FROM generate_series(1, 10000) i;
```

#### 1.2. Tạo các môi trường test với số lượng dữ liệu khác nhau
- Môi trường 1: 100 thuốc
- Môi trường 2: 1,000 thuốc
- Môi trường 3: 10,000 thuốc

### 2. Cấu hình JMeter

#### 2.1. Tạo Thread Group
- Số lượng thread: 10
- Ramp-up period: 5 giây
- Loop count: 5

#### 2.2. Thêm HTTP Request Defaults
- Server: localhost
- Port: 8080
- Protocol: http

#### 2.3. Thêm HTTP Header Manager
- Content-Type: application/json
- Authorization: Bearer {{token}}

#### 2.4. Thêm các HTTP Request
- Đăng nhập
- Lấy danh sách thuốc
- Tìm kiếm thuốc
- Phân trang danh sách thuốc

#### 2.5. Thêm các Listener
- View Results Tree
- Summary Report
- Aggregate Report

### 3. Chạy test và phân tích kết quả

#### 3.1. Chạy test trên từng môi trường
```bash
jmeter -n -t docs/quan-ly-thuoc/giai-doan-6-system-test/jmeter/QuanLyThuoc_TestPlan.jmx -l results.jtl
```

#### 3.2. Phân tích kết quả
- So sánh thời gian phản hồi trung bình
- So sánh thông lượng
- So sánh tỷ lệ lỗi
- Xác định giới hạn của hệ thống

## 📝 BÁO CÁO KẾT QUẢ

Sau khi chạy test, tạo báo cáo kết quả với các thông tin:
- Thời gian phản hồi trung bình của từng API
- Thông lượng của từng API
- Tỷ lệ lỗi của từng API
- So sánh kết quả với yêu cầu
- Đề xuất cải thiện hiệu năng (nếu cần)
