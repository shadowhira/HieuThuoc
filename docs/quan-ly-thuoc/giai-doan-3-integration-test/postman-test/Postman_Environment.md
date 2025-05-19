# KIỂM THỬ API BẰNG POSTMAN - ENVIRONMENT

## 1. Mục tiêu

Tạo Postman Environment để cấu hình các biến môi trường cho việc kiểm thử API.

## 2. Phạm vi

- Cấu hình biến môi trường cho môi trường Local
- Cấu hình biến môi trường cho môi trường Test
- Cấu hình biến môi trường cho môi trường Production

## 3. Tạo Environment

### 3.1. Tạo Environment Local

1. Mở Postman
2. Nhấn nút "New" > "Environment"
3. Đặt tên Environment là "Local"
4. Thêm các biến sau:
   - `baseUrl`: http://localhost:8080
   - `token`: (để trống, sẽ được cập nhật sau khi đăng nhập)
5. Nhấn "Save"

### 3.2. Tạo Environment Test

1. Mở Postman
2. Nhấn nút "New" > "Environment"
3. Đặt tên Environment là "Test"
4. Thêm các biến sau:
   - `baseUrl`: http://test-server:8080
   - `token`: (để trống, sẽ được cập nhật sau khi đăng nhập)
5. Nhấn "Save"

### 3.3. Tạo Environment Production

1. Mở Postman
2. Nhấn nút "New" > "Environment"
3. Đặt tên Environment là "Production"
4. Thêm các biến sau:
   - `baseUrl`: http://production-server:8080
   - `token`: (để trống, sẽ được cập nhật sau khi đăng nhập)
5. Nhấn "Save"

## 4. Sử dụng Environment

### 4.1. Chọn Environment

1. Mở Postman
2. Chọn Environment từ dropdown ở góc trên bên phải
3. Chọn "Local" để sử dụng môi trường Local

### 4.2. Sử dụng biến Environment trong request

1. Sử dụng cú pháp `{{tên_biến}}` để sử dụng biến Environment trong request
2. Ví dụ: `{{baseUrl}}/api/auth/login`

### 4.3. Cập nhật biến Environment

1. Sử dụng script để cập nhật biến Environment
2. Ví dụ: Cập nhật biến `token` sau khi đăng nhập thành công
   ```javascript
   var jsonData = pm.response.json();
   if (jsonData.token) {
     pm.environment.set("token", jsonData.token);
   }
   ```

## 5. Xuất Environment

### 5.1. Xuất Environment Local

1. Nhấp chuột phải vào Environment "Local"
2. Chọn "Export"
3. Lưu file với tên "Local.postman_environment.json"

### 5.2. Xuất Environment Test

1. Nhấp chuột phải vào Environment "Test"
2. Chọn "Export"
3. Lưu file với tên "Test.postman_environment.json"

### 5.3. Xuất Environment Production

1. Nhấp chuột phải vào Environment "Production"
2. Chọn "Export"
3. Lưu file với tên "Production.postman_environment.json"

## 6. Import Environment

### 6.1. Import Environment

1. Mở Postman
2. Nhấn nút "Import"
3. Chọn file Environment (ví dụ: "Local.postman_environment.json")
4. Nhấn "Import"

## 7. Quản lý Environment

### 7.1. Xem và chỉnh sửa Environment

1. Nhấn nút "Environment" ở thanh bên trái
2. Chọn Environment cần xem hoặc chỉnh sửa
3. Chỉnh sửa các biến nếu cần
4. Nhấn "Save"

### 7.2. Xem giá trị hiện tại của biến Environment

1. Nhấn nút "Environment" ở góc trên bên phải
2. Xem giá trị hiện tại của các biến Environment

## 8. Sử dụng Environment trong Collection Runner

### 8.1. Chạy Collection với Environment cụ thể

1. Nhấp chuột phải vào Collection
2. Chọn "Run collection"
3. Chọn Environment từ dropdown "Environment"
4. Cấu hình các tùy chọn chạy
5. Nhấn "Run"

## 9. Sử dụng Environment trong Newman

### 9.1. Chạy Collection với Environment bằng Newman

```bash
newman run QuanLyThuoc.postman_collection.json -e Local.postman_environment.json
```

## 10. Các biến Environment khác

Ngoài các biến cơ bản, bạn có thể thêm các biến khác tùy theo nhu cầu:

- `username`: Tên đăng nhập
- `password`: Mật khẩu
- `thuocId`: ID của thuốc để sử dụng trong các request
- `loaiThuocId`: ID của loại thuốc để sử dụng trong các request
- `danhMucThuocId`: ID của danh mục thuốc để sử dụng trong các request
