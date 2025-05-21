# HƯỚNG DẪN SỬ DỤNG JMETER CHO KIỂM THỬ HIỆU NĂNG

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách sử dụng JMeter để kiểm thử hiệu năng cho các API của chức năng Quản lý thuốc.

## 🛠️ CHUẨN BỊ MÔI TRƯỜNG

### 1. Cài đặt JMeter

1. Tải JMeter từ trang chủ: https://jmeter.apache.org/download_jmeter.cgi
2. Giải nén file tải về
3. Chạy JMeter:
   - Windows: Chạy file `bin/jmeter.bat`
   - macOS/Linux: Chạy file `bin/jmeter.sh`

### 2. Cấu hình JMeter

1. Tăng bộ nhớ cho JMeter (nếu cần):
   - Mở file `bin/jmeter.bat` (Windows) hoặc `bin/jmeter.sh` (macOS/Linux)
   - Tìm và sửa dòng `HEAP="-Xms1g -Xmx1g"` thành `HEAP="-Xms2g -Xmx2g"`

## 📝 TẠO TEST PLAN

### 1. Tạo Test Plan mới

1. Mở JMeter
2. Đổi tên Test Plan mặc định thành "Quản lý thuốc - Performance Test"

### 2. Thêm Thread Group

1. Chuột phải vào Test Plan > Add > Threads (Users) > Thread Group
2. Đặt tên: "Quản lý thuốc"
3. Cấu hình Thread Group:
   - Number of Threads (users): 10
   - Ramp-up period (seconds): 5
   - Loop Count: 5

### 3. Thêm HTTP Request Defaults

1. Chuột phải vào Thread Group > Add > Config Element > HTTP Request Defaults
2. Cấu hình HTTP Request Defaults:
   - Server Name or IP: localhost
   - Port Number: 8080
   - Protocol: http

### 4. Thêm HTTP Header Manager

1. Chuột phải vào Thread Group > Add > Config Element > HTTP Header Manager
2. Thêm header:
   - Name: Content-Type
   - Value: application/json

### 5. Thêm HTTP Request cho API lấy danh sách thuốc

1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Đặt tên: "Lấy danh sách thuốc"
3. Cấu hình HTTP Request:
   - Method: GET
   - Path: /api/thuoc/getAll

### 6. Thêm HTTP Request cho API tìm kiếm thuốc

1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Đặt tên: "Tìm kiếm thuốc"
3. Cấu hình HTTP Request:
   - Method: GET
   - Path: /api/thuoc/search
   - Parameters:
     - Name: keyword
     - Value: para
     - Encode: true

### 7. Thêm HTTP Request cho API thêm thuốc

1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Đặt tên: "Thêm thuốc mới"
3. Cấu hình HTTP Request:
   - Method: POST
   - Path: /api/thuoc/create
   - Body Data:
     ```json
     {
       "tenThuoc": "Vitamin C 500mg",
       "maThuoc": "VTC500",
       "loaiThuoc": {
         "id": 1,
         "tenLoai": "Vitamin"
       },
       "nhaSanXuat": "DHG Pharma",
       "donViTinh": "Viên",
       "giaNhap": 30000,
       "giaBan": 45000,
       "soLuong": 100,
       "nguongCanhBao": 10,
       "congDung": "Bổ sung Vitamin C, tăng cường miễn dịch",
       "huongDanSuDung": "Uống 1 viên/ngày sau bữa ăn"
     }
     ```

### 8. Thêm HTTP Request cho API sửa thuốc

1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Đặt tên: "Sửa thuốc"
3. Cấu hình HTTP Request:
   - Method: PUT
   - Path: /api/thuoc/update
   - Body Data:
     ```json
     {
       "id": 1,
       "tenThuoc": "Vitamin C 1000mg",
       "maThuoc": "VTC1000",
       "loaiThuoc": {
         "id": 1,
         "tenLoai": "Vitamin"
       },
       "nhaSanXuat": "DHG Pharma",
       "donViTinh": "Viên",
       "giaNhap": 50000,
       "giaBan": 75000,
       "soLuong": 50,
       "nguongCanhBao": 5,
       "congDung": "Bổ sung Vitamin C liều cao, tăng cường miễn dịch",
       "huongDanSuDung": "Uống 1 viên/ngày sau bữa ăn"
     }
     ```

### 9. Thêm HTTP Request cho API xóa thuốc

1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Đặt tên: "Xóa thuốc"
3. Cấu hình HTTP Request:
   - Method: DELETE
   - Path: /api/thuoc/delete
   - Parameters:
     - Name: id
     - Value: 1
     - Encode: true

### 10. Thêm Listener

1. Chuột phải vào Thread Group > Add > Listener > View Results Tree
2. Chuột phải vào Thread Group > Add > Listener > Summary Report
3. Chuột phải vào Thread Group > Add > Listener > Aggregate Report

## 📊 CHẠY TEST PLAN

### 1. Lưu Test Plan

1. File > Save Test Plan as
2. Đặt tên: "QuanLyThuoc_TestPlan.jmx"
3. Chọn thư mục lưu và nhấn Save

### 2. Chạy Test Plan

1. Nhấn nút "Start" (biểu tượng play màu xanh) trên thanh công cụ
2. Hoặc nhấn Ctrl+R (Windows) / Cmd+R (macOS)

### 3. Phân tích kết quả

1. Xem kết quả trong View Results Tree:
   - Kiểm tra các request thành công/thất bại
   - Xem thời gian phản hồi của từng request

2. Xem kết quả trong Summary Report:
   - Thời gian phản hồi trung bình (Average)
   - Thời gian phản hồi tối thiểu (Min)
   - Thời gian phản hồi tối đa (Max)
   - Thông lượng (Throughput)
   - Tỷ lệ lỗi (Error %)

3. Xem kết quả trong Aggregate Report:
   - Phân tích chi tiết hơn về hiệu năng của từng API

## 📝 TIÊU CHÍ ĐÁNH GIÁ HIỆU NĂNG

| API | Thời gian phản hồi trung bình | Thông lượng | Tỷ lệ lỗi |
|-----|-------------------------------|-------------|-----------|
| Lấy danh sách thuốc | < 500ms | > 10 req/s | 0% |
| Tìm kiếm thuốc | < 500ms | > 10 req/s | 0% |
| Thêm thuốc mới | < 1000ms | > 5 req/s | 0% |
| Sửa thuốc | < 1000ms | > 5 req/s | 0% |
| Xóa thuốc | < 1000ms | > 5 req/s | 0% |

## 🔍 LƯU Ý QUAN TRỌNG

1. Đảm bảo Backend đang chạy trước khi thực hiện kiểm thử hiệu năng.
2. Điều chỉnh số lượng Thread (users) tùy theo khả năng của máy tính.
3. Lưu ý rằng API thêm/sửa/xóa thuốc sẽ thay đổi dữ liệu trong cơ sở dữ liệu.
4. Nên sử dụng cơ sở dữ liệu test riêng cho kiểm thử hiệu năng.
5. Có thể sử dụng CSV Data Set Config để cung cấp dữ liệu đầu vào cho các request.
