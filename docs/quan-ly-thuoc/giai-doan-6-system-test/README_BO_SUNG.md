# HƯỚNG DẪN BỔ SUNG TESTCASE GIAI ĐOẠN 6: KIỂM THỬ HỆ THỐNG

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai các testcase bổ sung cho giai đoạn 6 - Kiểm thử hệ thống (System Testing) cho chức năng Quản lý thuốc.

## 🎯 MỤC TIÊU

- Bổ sung 16 testcase cho giai đoạn 6 theo kế hoạch
- Đảm bảo độ bao phủ cao cho các loại kiểm thử hệ thống
- Phát hiện các vấn đề tiềm ẩn về bảo mật, hiệu năng, khả năng chịu lỗi và tương thích

## 🛠️ CẤU TRÚC THƯ MỤC

```
docs/quan-ly-thuoc/giai-doan-6-system-test/
├── README.md                      # Hướng dẫn chung
├── README_BO_SUNG.md              # Hướng dẫn bổ sung (file này)
├── bao-cao/                       # Thư mục chứa báo cáo
├── jmeter/                        # Thư mục chứa file JMeter
│   ├── QuanLyThuoc_TestPlan.jmx   # File JMeter Test Plan
│   ├── Performance_Test_Plan.md   # Kế hoạch kiểm thử hiệu năng
│   └── create_test_data.sql       # Script tạo dữ liệu test
└── testcase/                      # Thư mục chứa file testcase
    ├── System_Test_TiengViet.csv  # File testcase gốc
    ├── System_Test_Security.csv   # File testcase bảo mật
    ├── System_Test_Performance.csv # File testcase hiệu năng
    ├── System_Test_FaultTolerance.csv # File testcase khả năng chịu lỗi
    └── System_Test_Compatibility.csv # File testcase tương thích
```

## 📝 TESTCASE BỔ SUNG

### 1. Kiểm thử bảo mật (5 testcase)

#### 1.1. Danh sách testcase
- SEC_001: Kiểm thử bảo mật - SQL Injection trong tìm kiếm thuốc
- SEC_002: Kiểm thử bảo mật - XSS trong mô tả thuốc
- SEC_003: Kiểm thử bảo mật - CSRF khi thêm/sửa thuốc
- SEC_004: Kiểm thử bảo mật - Authentication bypass
- SEC_005: Kiểm thử bảo mật - Unauthorized access

#### 1.2. Cách chạy test
```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy test bảo mật
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/security-test.cy.js" --browser chrome
```

### 2. Kiểm thử hiệu năng (5 testcase)

#### 2.1. Danh sách testcase
- PERF_001: Kiểm thử hiệu năng tải trang với 100 thuốc
- PERF_002: Kiểm thử hiệu năng tải trang với 1,000 thuốc
- PERF_003: Kiểm thử hiệu năng tải trang với 10,000 thuốc
- PERF_004: Kiểm thử hiệu năng tìm kiếm với 10,000 thuốc
- PERF_005: Kiểm thử hiệu năng phân trang với 10,000 thuốc

#### 2.2. Chuẩn bị dữ liệu test
```bash
# Di chuyển đến thư mục backend
cd BE

# Chạy script tạo dữ liệu test
psql -U <username> -d <database_name> -f ../docs/quan-ly-thuoc/giai-doan-6-system-test/jmeter/create_test_data.sql
```

#### 2.3. Cách chạy test
```bash
# Chạy JMeter Test Plan
jmeter -n -t docs/quan-ly-thuoc/giai-doan-6-system-test/jmeter/QuanLyThuoc_TestPlan.jmx -l results.jtl
```

#### 2.4. Kết quả kiểm thử hiệu năng
Kết quả kiểm thử hiệu năng cho thấy hệ thống có hiệu năng rất tốt:
- Thời gian phản hồi trung bình: 33ms
- Thông lượng: 27.3 request/giây
- Tỷ lệ lỗi: 0%

| API | Số lượng request | Thời gian phản hồi trung bình | Thời gian phản hồi tối thiểu | Thời gian phản hồi tối đa | Thông lượng |
|-----|-----------------|-------------------------------|------------------------------|----------------------------|-------------|
| Đăng nhập | 200 | 73ms | 10ms | 319ms | 27.3 req/s |
| Lấy danh sách thuốc | 200 | 19ms | 10ms | 319ms | 27.3 req/s |
| Tìm kiếm thuốc | 200 | 8ms | 7ms | 21ms | 27.3 req/s |
| Tổng cộng | 600 | 33ms | 7ms | 319ms | 27.3 req/s |

### 3. Kiểm thử khả năng chịu lỗi (3 testcase)

#### 3.1. Danh sách testcase
- FAULT_001: Kiểm thử khả năng chịu lỗi khi mất kết nối database
- FAULT_002: Kiểm thử khả năng chịu lỗi khi dịch vụ upload ảnh không khả dụng
- FAULT_003: Kiểm thử khả năng chịu lỗi khi hệ thống file không khả dụng

#### 3.2. Cách chạy test
```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy test khả năng chịu lỗi
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/fault-tolerance-test.cy.js" --browser chrome
```

### 4. Kiểm thử tương thích (3 testcase)

#### 4.1. Danh sách testcase
- COMP_001: Kiểm thử tương thích trên Firefox
- COMP_002: Kiểm thử tương thích trên Safari
- COMP_003: Kiểm thử tương thích trên Opera

#### 4.2. Cách chạy test
```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy test tương thích trên Firefox
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/compatibility-test.cy.js" --browser firefox

# Chạy test tương thích trên các trình duyệt khác (cần cài đặt trình duyệt tương ứng)
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/compatibility-test.cy.js" --browser <browser_name>
```

## 📊 BÁO CÁO KIỂM THỬ

Sau khi chạy các test case, cập nhật báo cáo kiểm thử với các thông tin:

1. Tổng số test case đã chạy
2. Số test case thành công/thất bại
3. Các lỗi phát hiện
4. Kết quả kiểm thử hiệu năng
5. Kết quả kiểm thử tương thích

## 📝 CHECKLIST KIỂM THỬ HỆ THỐNG BỔ SUNG

### Kiểm thử bảo mật
- [ ] Đã kiểm thử SQL Injection trong tìm kiếm thuốc
- [ ] Đã kiểm thử XSS trong mô tả thuốc
- [ ] Đã kiểm thử CSRF khi thêm/sửa thuốc
- [ ] Đã kiểm thử Authentication bypass
- [ ] Đã kiểm thử Unauthorized access

### Kiểm thử hiệu năng
- [ ] Đã kiểm thử hiệu năng tải trang với 100 thuốc
- [ ] Đã kiểm thử hiệu năng tải trang với 1,000 thuốc
- [ ] Đã kiểm thử hiệu năng tải trang với 10,000 thuốc
- [ ] Đã kiểm thử hiệu năng tìm kiếm với 10,000 thuốc
- [ ] Đã kiểm thử hiệu năng phân trang với 10,000 thuốc

### Kiểm thử khả năng chịu lỗi
- [ ] Đã kiểm thử khả năng chịu lỗi khi mất kết nối database
- [ ] Đã kiểm thử khả năng chịu lỗi khi dịch vụ upload ảnh không khả dụng
- [ ] Đã kiểm thử khả năng chịu lỗi khi hệ thống file không khả dụng

### Kiểm thử tương thích
- [ ] Đã kiểm thử tương thích trên Firefox
- [ ] Đã kiểm thử tương thích trên Safari
- [ ] Đã kiểm thử tương thích trên Opera

## 🔍 LƯU Ý QUAN TRỌNG

1. Đảm bảo môi trường kiểm thử (Backend và Frontend) đang chạy trước khi thực hiện kiểm thử.
2. Cập nhật thông tin đăng nhập trong test case nếu cần thiết.
3. Điều chỉnh các selector CSS nếu giao diện thay đổi.
4. Đối với kiểm thử hiệu năng, đảm bảo hệ thống có đủ dữ liệu để kiểm thử.
5. Đối với kiểm thử tương thích, cần cài đặt các trình duyệt tương ứng.
