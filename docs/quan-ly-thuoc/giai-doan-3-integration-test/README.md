# GIAI ĐOẠN 3: KIỂM THỬ TÍCH HỢP (INTEGRATION TESTING)

## 📋 TỔNG QUAN

Giai đoạn 3 tập trung vào việc kiểm thử tích hợp (Integration Testing) cho chức năng Quản lý thuốc. Mục tiêu chính là đảm bảo các thành phần khác nhau của hệ thống hoạt động đúng khi tích hợp với nhau.

## 🗂️ CẤU TRÚC THƯ MỤC

```
giai-doan-3-integration-test/
├── README.md                                # Tài liệu tổng quan về giai đoạn 3
├── bao-cao/                                 # Báo cáo tiến độ và kết quả
│   └── Bao_Cao_Tien_Do_Giai_Doan_3.md       # Báo cáo tiến độ giai đoạn 3
├── backend-test/                            # Test case cho tích hợp Backend
│   ├── ThuocIntegrationTest.md              # Test case tích hợp cho Thuoc
│   ├── LoaiThuocIntegrationTest.md          # Test case tích hợp cho LoaiThuoc
│   └── DanhMucThuocIntegrationTest.md       # Test case tích hợp cho DanhMucThuoc
├── postman-test/                            # Test case cho API bằng Postman
│   ├── Postman_Collection.md                # Hướng dẫn tạo Postman Collection
│   ├── Postman_Environment.md               # Hướng dẫn cấu hình Postman Environment
│   └── Postman_Test_Script.md               # Hướng dẫn viết test script cho Postman
└── frontend-backend-test/                   # Test case cho tích hợp Frontend-Backend
    ├── ThuocComponentTest.md                # Test case tích hợp cho ThuocComponent
    ├── LoaiThuocComponentTest.md            # Test case tích hợp cho LoaiThuocComponent
    └── DanhMucThuocComponentTest.md         # Test case tích hợp cho DanhMucThuocComponent
```

## 🚀 NỘI DUNG KIỂM THỬ

### 1. Kiểm thử tích hợp Backend

- **Tích hợp Controller-Service-Repository**: Kiểm thử luồng dữ liệu từ Controller qua Service đến Repository và ngược lại
- **Tích hợp giữa các Service**: Kiểm thử sự tương tác giữa các Service với nhau
- **Tích hợp với Database**: Kiểm thử tương tác với cơ sở dữ liệu thực

### 2. Kiểm thử API bằng Postman

- **Kiểm thử API Thuoc**: Kiểm thử các API liên quan đến quản lý thuốc
- **Kiểm thử API LoaiThuoc**: Kiểm thử các API liên quan đến quản lý loại thuốc
- **Kiểm thử API DanhMucThuoc**: Kiểm thử các API liên quan đến quản lý danh mục thuốc
- **Kiểm thử luồng nghiệp vụ**: Kiểm thử các luồng nghiệp vụ liên quan đến quản lý thuốc

### 3. Kiểm thử tích hợp Frontend-Backend

- **Kiểm thử giao tiếp Frontend-Backend**: Kiểm thử sự tương tác giữa Frontend và Backend
- **Kiểm thử luồng dữ liệu**: Kiểm thử luồng dữ liệu từ Frontend đến Backend và ngược lại
- **Kiểm thử xử lý lỗi**: Kiểm thử cách Frontend xử lý lỗi từ Backend

## 📊 KẾ HOẠCH TRIỂN KHAI

### Giai đoạn 3.1: Kiểm thử tích hợp Backend (Ngày 1)

- Viết test case tích hợp cho ThuocController-ThuocService-ThuocRepository
- Viết test case tích hợp cho LoaiThuocController-LoaiThuocService-LoaiThuocRepository
- Viết test case tích hợp cho DanhMucThuocController-DanhMucThuocService-DanhMucThuocRepository
- Chạy test và báo cáo kết quả

### Giai đoạn 3.2: Kiểm thử API bằng Postman (Ngày 1-2)

- Tạo Postman Collection cho các API quản lý thuốc
- Viết test script cho các API
- Chạy test và báo cáo kết quả

### Giai đoạn 3.3: Kiểm thử tích hợp Frontend-Backend (Ngày 2)

- Viết test case Cypress cho tích hợp Frontend-Backend
- Chạy test và báo cáo kết quả

## 🛠️ CÔNG CỤ SỬ DỤNG

- **JUnit 5**: Framework kiểm thử cho Java
- **Spring Boot Test**: Công cụ kiểm thử tích hợp cho Spring Boot
- **Mockito**: Framework mock object cho Java
- **Postman**: Công cụ kiểm thử API
- **Cypress**: Framework kiểm thử End-to-End cho Frontend

## 📝 HƯỚNG DẪN THỰC HIỆN

### Chuẩn bị môi trường

1. Đảm bảo đã cài đặt JDK 17 hoặc cao hơn
2. Đảm bảo đã cài đặt Maven
3. Đảm bảo đã cài đặt PostgreSQL và đã tạo database hieuthuoc
4. Đảm bảo đã cài đặt Node.js và npm
5. Đảm bảo đã cài đặt Postman
6. Đảm bảo đã cài đặt Cypress

### Chạy kiểm thử tích hợp Backend

```bash
cd BE
mvn test -Dtest=com.example.hieuthuoc.integration.*
```

### Chạy kiểm thử API bằng Postman

1. Import Postman Collection và Environment
2. Chạy Collection Runner

### Chạy kiểm thử tích hợp Frontend-Backend

```bash
cd FE
npm run cypress:open
```

## 📊 THEO DÕI TIẾN ĐỘ

| Giai đoạn | Tiến độ | Ngày hoàn thành |
|-----------|---------|-----------------|
| Giai đoạn 3.1: Kiểm thử tích hợp Backend | 100% | 19/05/2025 |
| Giai đoạn 3.2: Kiểm thử API bằng Postman | 100% | 19/05/2025 |
| Giai đoạn 3.3: Kiểm thử tích hợp Frontend-Backend | 100% | 19/05/2025 |
| **Tổng cộng** | **100%** | 19/05/2025 |
