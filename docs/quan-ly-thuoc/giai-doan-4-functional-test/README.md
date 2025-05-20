# GIAI ĐOẠN 4: KIỂM THỬ CHỨC NĂNG (FUNCTIONAL TESTING)

## 📋 TỔNG QUAN

Giai đoạn 4 tập trung vào việc kiểm thử chức năng (Functional Testing) cho chức năng Quản lý thuốc. Mục tiêu chính là đảm bảo các chức năng của hệ thống hoạt động đúng theo yêu cầu từ góc độ người dùng.

## 🗂️ CẤU TRÚC THƯ MỤC

```
giai-doan-4-functional-test/
├── README.md                                # Tài liệu tổng quan về giai đoạn 4
├── bao-cao/                                 # Báo cáo tiến độ và kết quả
│   └── Bao_Cao_Tien_Do_Giai_Doan_4.md       # Báo cáo tiến độ giai đoạn 4
├── postman-test/                            # Test case cho API bằng Postman
│   ├── Quan_Ly_Thuoc_Functional_Test.json   # Postman Collection cho kiểm thử chức năng
│   └── Huong_Dan_Import_Collection.md       # Hướng dẫn import collection
├── cypress-test/                            # Test case cho UI bằng Cypress
│   ├── create-thuoc-functional.cy.js        # Test case cho chức năng thêm thuốc
│   ├── update-thuoc-functional.cy.js        # Test case cho chức năng cập nhật thuốc
│   ├── delete-thuoc-functional.cy.js        # Test case cho chức năng xóa thuốc
│   └── search-thuoc-functional.cy.js        # Test case cho chức năng tìm kiếm thuốc
└── Bao_Cao_Tong_Hop_Giai_Doan_4.md          # Báo cáo tổng hợp giai đoạn 4
```

## 🚀 NỘI DUNG KIỂM THỬ

### 1. Kiểm thử chức năng thêm thuốc

- **Kiểm thử API thêm thuốc**: Kiểm thử API thêm thuốc bằng Postman
- **Kiểm thử giao diện thêm thuốc**: Kiểm thử giao diện thêm thuốc bằng Cypress
- **Kiểm thử các trường hợp đặc biệt**: Kiểm thử các trường hợp đặc biệt như dữ liệu không hợp lệ, trùng mã thuốc, v.v.

### 2. Kiểm thử chức năng cập nhật thuốc

- **Kiểm thử API cập nhật thuốc**: Kiểm thử API cập nhật thuốc bằng Postman
- **Kiểm thử giao diện cập nhật thuốc**: Kiểm thử giao diện cập nhật thuốc bằng Cypress
- **Kiểm thử các trường hợp đặc biệt**: Kiểm thử các trường hợp đặc biệt như dữ liệu không hợp lệ, thuốc không tồn tại, v.v.

### 3. Kiểm thử chức năng xóa thuốc

- **Kiểm thử API xóa thuốc**: Kiểm thử API xóa thuốc bằng Postman
- **Kiểm thử giao diện xóa thuốc**: Kiểm thử giao diện xóa thuốc bằng Cypress
- **Kiểm thử các trường hợp đặc biệt**: Kiểm thử các trường hợp đặc biệt như xóa thuốc đã có trong đơn hàng, thuốc không tồn tại, v.v.

### 4. Kiểm thử chức năng tìm kiếm thuốc

- **Kiểm thử API tìm kiếm thuốc**: Kiểm thử API tìm kiếm thuốc bằng Postman
- **Kiểm thử giao diện tìm kiếm thuốc**: Kiểm thử giao diện tìm kiếm thuốc bằng Cypress
- **Kiểm thử các trường hợp đặc biệt**: Kiểm thử các trường hợp đặc biệt như không có kết quả tìm kiếm, tìm kiếm với nhiều tiêu chí, v.v.

## 📝 HƯỚNG DẪN THỰC HIỆN

### Chuẩn bị môi trường

1. Đảm bảo đã cài đặt JDK 17 hoặc cao hơn
2. Đảm bảo đã cài đặt Maven
3. Đảm bảo đã cài đặt PostgreSQL và đã tạo database hieuthuoc
4. Đảm bảo đã cài đặt Node.js và npm
5. Đảm bảo đã cài đặt Postman
6. Đảm bảo đã cài đặt Cypress

### Chạy kiểm thử API bằng Postman

1. Import Postman Collection và Environment
2. Chạy Collection Runner

### Chạy kiểm thử giao diện bằng Cypress

```bash
cd FE
npm run cypress:open
```

## 📊 THEO DÕI TIẾN ĐỘ

| Công việc | Tiến độ | Ngày hoàn thành |
|-----------|---------|-----------------|
| Kiểm thử chức năng thêm thuốc | 100% | 20/05/2024 |
| Kiểm thử chức năng cập nhật thuốc | 100% | 20/05/2024 |
| Kiểm thử chức năng xóa thuốc | 100% | 20/05/2024 |
| Kiểm thử chức năng tìm kiếm thuốc | 100% | 20/05/2024 |
| Tổng hợp và báo cáo | 100% | 20/05/2024 |

## 🔍 TEST CASE QUAN TRỌNG

### Kiểm thử chức năng thêm thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|----------------------|-------------------|-----------------|
| TC_ADD_THUOC_001 | Thêm thuốc thành công | Kiểm tra chức năng thêm thuốc với dữ liệu hợp lệ | Đã đăng nhập với quyền admin | 1. Mở trang thêm thuốc<br>2. Nhập thông tin thuốc hợp lệ<br>3. Nhấn nút "Lưu" | 1. Hiển thị thông báo thành công<br>2. Thuốc mới được thêm vào danh sách |
| TC_ADD_THUOC_002 | Thêm thuốc với mã trùng | Kiểm tra chức năng thêm thuốc với mã thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có mã "PARA500" | 1. Mở trang thêm thuốc<br>2. Nhập thông tin thuốc với mã "PARA500"<br>3. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi<br>2. Thuốc không được thêm vào danh sách |
| TC_ADD_THUOC_003 | Thêm thuốc với dữ liệu không hợp lệ | Kiểm tra chức năng thêm thuốc với dữ liệu không hợp lệ | Đã đăng nhập với quyền admin | 1. Mở trang thêm thuốc<br>2. Nhập thông tin thuốc không hợp lệ (giá bán âm)<br>3. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi<br>2. Thuốc không được thêm vào danh sách |

### Kiểm thử chức năng cập nhật thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|----------------------|-------------------|-----------------|
| TC_UPDATE_THUOC_001 | Cập nhật thuốc thành công | Kiểm tra chức năng cập nhật thuốc với dữ liệu hợp lệ | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có ID 1 | 1. Mở trang danh sách thuốc<br>2. Nhấn nút "Sửa" cho thuốc có ID 1<br>3. Cập nhật thông tin thuốc<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo thành công<br>2. Thông tin thuốc được cập nhật |
| TC_UPDATE_THUOC_002 | Cập nhật thuốc với dữ liệu không hợp lệ | Kiểm tra chức năng cập nhật thuốc với dữ liệu không hợp lệ | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có ID 1 | 1. Mở trang danh sách thuốc<br>2. Nhấn nút "Sửa" cho thuốc có ID 1<br>3. Cập nhật thông tin thuốc không hợp lệ (giá bán âm)<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi<br>2. Thông tin thuốc không được cập nhật |
