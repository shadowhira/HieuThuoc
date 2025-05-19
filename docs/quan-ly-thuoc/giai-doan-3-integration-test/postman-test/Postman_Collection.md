# KIỂM THỬ API BẰNG POSTMAN - COLLECTION

## 1. Mục tiêu

Tạo Postman Collection để kiểm thử các API liên quan đến chức năng Quản lý thuốc.

## 2. Phạm vi

- Kiểm thử API quản lý thuốc
- Kiểm thử API quản lý loại thuốc
- Kiểm thử API quản lý danh mục thuốc

## 3. Chuẩn bị môi trường

### 3.1. Cài đặt Postman

1. Tải và cài đặt Postman từ trang chủ: https://www.postman.com/downloads/
2. Đăng nhập vào Postman (hoặc sử dụng không cần đăng nhập)

### 3.2. Chuẩn bị dữ liệu

1. Đảm bảo đã khởi động Backend
2. Đảm bảo đã có dữ liệu mẫu trong cơ sở dữ liệu

## 4. Tạo Postman Collection

### 4.1. Tạo Collection mới

1. Mở Postman
2. Nhấn nút "New" > "Collection"
3. Đặt tên Collection là "Quản lý thuốc"
4. Nhấn "Create"

### 4.2. Tạo thư mục con

1. Nhấp chuột phải vào Collection "Quản lý thuốc"
2. Chọn "Add Folder"
3. Tạo các thư mục con:
   - "Authentication": Chứa các request liên quan đến xác thực
   - "Thuoc": Chứa các request liên quan đến quản lý thuốc
   - "LoaiThuoc": Chứa các request liên quan đến quản lý loại thuốc
   - "DanhMucThuoc": Chứa các request liên quan đến quản lý danh mục thuốc

## 5. Tạo các request

### 5.1. Thư mục Authentication

#### 5.1.1. Request: Đăng nhập

1. Nhấp chuột phải vào thư mục "Authentication"
2. Chọn "Add Request"
3. Đặt tên request là "Đăng nhập"
4. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/api/auth/login
   - Body (raw, JSON):
     ```json
     {
       "username": "admin",
       "password": "admin123"
     }
     ```
5. Thêm script để lưu token:
   ```javascript
   var jsonData = pm.response.json();
   if (jsonData.token) {
     pm.environment.set("token", jsonData.token);
   }
   ```

### 5.2. Thư mục Thuoc

#### 5.2.1. Request: Lấy danh sách thuốc

1. Nhấp chuột phải vào thư mục "Thuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Lấy danh sách thuốc"
4. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/thuoc/search
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (raw, JSON):
     ```json
     {
       "keyWord": "",
       "currentPage": 0,
       "size": 10,
       "sortedField": ""
     }
     ```

#### 5.2.2. Request: Lấy thuốc theo ID

1. Nhấp chuột phải vào thư mục "Thuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Lấy thuốc theo ID"
4. Cấu hình request:
   - Method: GET
   - URL: {{baseUrl}}/thuoc/get
   - Headers:
     - Authorization: Bearer {{token}}
   - Params:
     - id: 1

#### 5.2.3. Request: Thêm mới thuốc

1. Nhấp chuột phải vào thư mục "Thuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Thêm mới thuốc"
4. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/thuoc/create
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (form-data):
     - thuocDTO (file): Chọn file JSON chứa thông tin thuốc
     - file (file): Chọn file hình ảnh thuốc (nếu có)

#### 5.2.4. Request: Cập nhật thuốc

1. Nhấp chuột phải vào thư mục "Thuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Cập nhật thuốc"
4. Cấu hình request:
   - Method: PUT
   - URL: {{baseUrl}}/thuoc/update
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (form-data):
     - thuocDTO (file): Chọn file JSON chứa thông tin thuốc
     - file (file): Chọn file hình ảnh thuốc (nếu có)

#### 5.2.5. Request: Xóa thuốc

1. Nhấp chuột phải vào thư mục "Thuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Xóa thuốc"
4. Cấu hình request:
   - Method: DELETE
   - URL: {{baseUrl}}/thuoc/delete
   - Headers:
     - Authorization: Bearer {{token}}
   - Params:
     - id: 1

### 5.3. Thư mục LoaiThuoc

#### 5.3.1. Request: Lấy danh sách loại thuốc

1. Nhấp chuột phải vào thư mục "LoaiThuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Lấy danh sách loại thuốc"
4. Cấu hình request:
   - Method: GET
   - URL: {{baseUrl}}/loaithuoc/list
   - Headers:
     - Authorization: Bearer {{token}}

#### 5.3.2. Request: Tìm kiếm loại thuốc theo tên

1. Nhấp chuột phải vào thư mục "LoaiThuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Tìm kiếm loại thuốc theo tên"
4. Cấu hình request:
   - Method: GET
   - URL: {{baseUrl}}/loaithuoc/search_by_ten_loai
   - Headers:
     - Authorization: Bearer {{token}}
   - Params:
     - tenLoai: Kháng sinh

#### 5.3.3. Request: Thêm mới loại thuốc

1. Nhấp chuột phải vào thư mục "LoaiThuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Thêm mới loại thuốc"
4. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/loaithuoc/create
   - Headers:
     - Authorization: Bearer {{token}}
     - Content-Type: application/json
   - Body (raw, JSON):
     ```json
     {
       "tenLoai": "Vitamin và khoáng chất",
       "moTa": "Nhóm vitamin và khoáng chất",
       "danhMucThuocId": 1
     }
     ```

### 5.4. Thư mục DanhMucThuoc

#### 5.4.1. Request: Lấy danh sách danh mục thuốc

1. Nhấp chuột phải vào thư mục "DanhMucThuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Lấy danh sách danh mục thuốc"
4. Cấu hình request:
   - Method: GET
   - URL: {{baseUrl}}/danhmucthuoc/list
   - Headers:
     - Authorization: Bearer {{token}}

#### 5.4.2. Request: Lấy danh mục thuốc kèm loại thuốc

1. Nhấp chuột phải vào thư mục "DanhMucThuoc"
2. Chọn "Add Request"
3. Đặt tên request là "Lấy danh mục thuốc kèm loại thuốc"
4. Cấu hình request:
   - Method: GET
   - URL: {{baseUrl}}/danhmucthuoc/get_danh_muc_and_loai_thuoc
   - Headers:
     - Authorization: Bearer {{token}}

## 6. Lưu và xuất Collection

### 6.1. Lưu Collection

1. Nhấp chuột phải vào Collection "Quản lý thuốc"
2. Chọn "Save"

### 6.2. Xuất Collection

1. Nhấp chuột phải vào Collection "Quản lý thuốc"
2. Chọn "Export"
3. Chọn định dạng "Collection v2.1"
4. Nhấn "Export"
5. Lưu file với tên "QuanLyThuoc.postman_collection.json"

## 7. Hướng dẫn sử dụng Collection

### 7.1. Import Collection

1. Mở Postman
2. Nhấn nút "Import"
3. Chọn file "QuanLyThuoc.postman_collection.json"
4. Nhấn "Import"

### 7.2. Chạy Collection

1. Nhấp chuột phải vào Collection "Quản lý thuốc"
2. Chọn "Run collection"
3. Cấu hình các tùy chọn chạy
4. Nhấn "Run Quản lý thuốc"
