# HƯỚNG DẪN CHẠY KIỂM THỬ API BẰNG POSTMAN

## 1. Mục tiêu

Hướng dẫn chi tiết cách chạy kiểm thử API bằng Postman cho chức năng Quản lý thuốc.

## 2. Chuẩn bị môi trường

### 2.1. Cài đặt Postman

1. Tải và cài đặt Postman từ trang chủ: https://www.postman.com/downloads/
2. Khởi động Postman

### 2.2. Chuẩn bị Backend

1. Đảm bảo đã khởi động Backend:
   ```bash
   cd BE
   ./mvnw spring-boot:run
   ```
2. Đảm bảo Backend đang chạy tại địa chỉ: http://localhost:8888/hieuthuoc

### 2.3. Chuẩn bị dữ liệu

Đảm bảo cơ sở dữ liệu đã có dữ liệu mẫu cho việc kiểm thử.

## 3. Import Collection và Environment

### 3.1. Import Collection

1. Mở Postman
2. Nhấn nút "Import" ở góc trên bên trái
3. Chọn tab "File"
4. Nhấn "Upload Files"
5. Chọn các file sau:
   - `docs/quan-ly-thuoc/postman/Quan_Ly_Thuoc_Collection.json`
   - `docs/quan-ly-thuoc/postman/LoaiThuoc_DanhMucThuoc_Collection.json`
6. Nhấn "Import"

### 3.2. Import Environment

1. Mở Postman
2. Nhấn nút "Import" ở góc trên bên trái
3. Chọn tab "File"
4. Nhấn "Upload Files"
5. Chọn file `docs/quan-ly-thuoc/postman/Local.postman_environment.json`
6. Nhấn "Import"

### 3.3. Chọn Environment

1. Chọn Environment "Local" từ dropdown ở góc trên bên phải

## 4. Chạy kiểm thử

### 4.1. Chạy kiểm thử đăng nhập

1. Mở Collection "Quản lý thuốc"
2. Chọn request "Đăng nhập"
3. Nhấn nút "Send"
4. Kiểm tra kết quả:
   - Status code: 200
   - Response body: Chứa token
   - Token đã được lưu vào biến môi trường

### 4.2. Chạy kiểm thử API quản lý thuốc

#### 4.2.1. Lấy danh sách thuốc

1. Mở Collection "Quản lý thuốc"
2. Chọn request "Tìm kiếm thuốc"
3. Nhấn nút "Send"
4. Kiểm tra kết quả:
   - Status code: 200
   - Response body: Chứa danh sách thuốc

#### 4.2.2. Lấy thuốc theo ID

1. Mở Collection "Quản lý thuốc"
2. Chọn request "Lấy thuốc theo ID"
3. Nhấn nút "Send"
4. Kiểm tra kết quả:
   - Status code: 200
   - Response body: Chứa thông tin thuốc

#### 4.2.3. Thêm mới thuốc

1. Mở Collection "Quản lý thuốc"
2. Chọn request "Thêm thuốc mới"
3. Nhấn nút "Send"
4. Kiểm tra kết quả:
   - Status code: 200
   - Response body: Chứa thông tin thuốc mới
   - ID thuốc mới đã được lưu vào biến môi trường

#### 4.2.4. Cập nhật thuốc

1. Mở Collection "Quản lý thuốc"
2. Chọn request "Cập nhật thuốc"
3. Nhấn nút "Send"
4. Kiểm tra kết quả:
   - Status code: 200
   - Response body: Chứa thông tin thuốc đã cập nhật

#### 4.2.5. Xóa thuốc

1. Mở Collection "Quản lý thuốc"
2. Chọn request "Xóa thuốc"
3. Thay đổi ID thuốc cần xóa (nếu cần)
4. Nhấn nút "Send"
5. Kiểm tra kết quả:
   - Status code: 200
   - Response body: Chứa thông báo thành công

### 4.3. Chạy kiểm thử API quản lý loại thuốc và danh mục thuốc

Thực hiện tương tự với Collection "Loại Thuốc và Danh Mục Thuốc".

### 4.4. Chạy toàn bộ Collection

#### 4.4.1. Chạy Collection "Quản lý thuốc"

1. Nhấp chuột phải vào Collection "Quản lý thuốc"
2. Chọn "Run collection"
3. Cấu hình các tùy chọn chạy:
   - Iterations: 1
   - Delay: 500 ms
   - Environment: Local
4. Nhấn "Run Quản lý thuốc"
5. Xem kết quả kiểm thử

#### 4.4.2. Chạy Collection "Loại Thuốc và Danh Mục Thuốc"

1. Nhấp chuột phải vào Collection "Loại Thuốc và Danh Mục Thuốc"
2. Chọn "Run collection"
3. Cấu hình các tùy chọn chạy:
   - Iterations: 1
   - Delay: 500 ms
   - Environment: Local
4. Nhấn "Run Loại Thuốc và Danh Mục Thuốc"
5. Xem kết quả kiểm thử

## 5. Xử lý lỗi phổ biến

### 5.1. Lỗi xác thực

Nếu gặp lỗi 401 Unauthorized, hãy thực hiện lại request "Đăng nhập" để lấy token mới.

### 5.2. Lỗi không tìm thấy tài nguyên

Nếu gặp lỗi 404 Not Found, hãy kiểm tra lại ID của tài nguyên cần truy cập.

### 5.3. Lỗi dữ liệu không hợp lệ

Nếu gặp lỗi 400 Bad Request, hãy kiểm tra lại dữ liệu gửi đi.

## 6. Kết quả kiểm thử

Sau khi chạy kiểm thử, bạn có thể xem kết quả kiểm thử trong tab "Run Results". Kết quả kiểm thử sẽ hiển thị số lượng test case đã chạy, số lượng test case thành công và số lượng test case thất bại.

## 7. Lưu ý

- Đảm bảo đã đăng nhập và lấy token trước khi chạy các request khác
- Đảm bảo đã chọn đúng Environment trước khi chạy kiểm thử
- Đảm bảo Backend đang chạy trước khi chạy kiểm thử
- Đảm bảo cơ sở dữ liệu đã có dữ liệu mẫu trước khi chạy kiểm thử
