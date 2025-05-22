# Hướng dẫn chi tiết sử dụng JMeter để kiểm thử hiệu suất API đăng nhập

## 1. Cài đặt JMeter

1. **Tải JMeter**:

   - Truy cập trang chủ Apache JMeter: https://jmeter.apache.org/download_jmeter.cgi
   - Tải phiên bản mới nhất (khuyến nghị phiên bản 5.5 trở lên)

2. **Cài đặt**:

   - Giải nén file tải về vào thư mục bất kỳ (ví dụ: `C:\JMeter`)
   - Không cần cài đặt, JMeter là ứng dụng portable

3. **Khởi động JMeter**:
   - Mở thư mục `bin`
   - Chạy file `jmeter.bat` (Windows) hoặc `jmeter.sh` (Linux/Mac)

## 2. Cấu hình JMeter

1. **Cấu hình JMeter.properties**:

   - Mở file `bin\jmeter.properties` bằng Notepad
   - Thêm hoặc sửa các dòng sau:
     ```
     sampleresult.default.encoding=UTF-8
     jmeter.save.saveservice.encoding=UTF-8
     ```
   - Lưu file và khởi động lại JMeter

2. **Chuẩn bị dữ liệu test**:
   - Tạo thư mục `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-data\` (nếu chưa có)
   - Tạo file `accounts.csv` với nội dung:
     ```
     username,password
     admin,123456
     manager,123456
     pharmacist,123456
     cashier,123456
     customer,123456
     ```

## 3. Hướng dẫn chi tiết cho từng test case

### Test Case 1: QLND_DN_018 - Kiểm thử thời gian phản hồi của API đăng nhập

#### Bước 1: Tạo Test Plan mới

1. Mở JMeter
2. Chuột phải vào "Test Plan" > Rename > Đặt tên "API Đăng Nhập - Kiểm Thử Hiệu Suất"
3. Chuột phải vào "Test Plan" > Add > Threads (Users) > Thread Group

#### Bước 2: Cấu hình Thread Group

1. Đặt tên: "QLND_DN_018 - Thời gian phản hồi"
2. Number of Threads (users): 1
3. Ramp-up period (seconds): 1
4. Loop Count: 10
5. Chọn "Same user on each iteration"

#### Bước 3: Thêm HTTP Request Defaults

1. Chuột phải vào "Test Plan" > Add > Config Element > HTTP Request Defaults
2. Cấu hình:
   - Name: "Default Config"
   - Protocol: http
   - Server Name or IP: localhost
   - Port Number: 8888
   - Content Encoding: UTF-8

#### Bước 4: Thêm HTTP Request

1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Cấu hình:
   - Name: "API Đăng Nhập"
   - Method: POST
   - Path: /hieuthuoc/dangnhap
   - Body Data:
     ```json
     {
       "tenDangNhap": "admin",
       "matKhau": "123456"
     }
     ```

#### Bước 5: Thêm HTTP Header Manager

1. Chuột phải vào HTTP Request > Add > Config Element > HTTP Header Manager
2. Thêm header:
   - Name: Content-Type | Value: application/json; charset=UTF-8
   - Name: Accept | Value: application/json

#### Bước 6: Thêm Response Assertion

1. Chuột phải vào HTTP Request > Add > Assertions > Response Assertion
2. Cấu hình:
   - Test Field: Response Code
   - Pattern Matching Rules: Equals
   - Patterns to Test: 200

#### Bước 7: Thêm Listeners

1. Chuột phải vào Thread Group > Add > Listener > View Results Tree
2. Chuột phải vào Thread Group > Add > Listener > Summary Report
3. Chuột phải vào Thread Group > Add > Listener > Aggregate Report

#### Bước 8: Chạy test

1. Lưu Test Plan: File > Save Test Plan As > `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-plans\QLND_DN_018.jmx`
2. Nhấn nút "Start" (biểu tượng tam giác màu xanh)
3. Đợi test hoàn thành
4. Xem kết quả trong Summary Report và Aggregate Report

#### Bước 9: Ghi lại kết quả

1. Ghi lại các thông số:
   - Thời gian phản hồi trung bình (Average)
   - Thời gian phản hồi tối thiểu (Min)
   - Thời gian phản hồi tối đa (Max)
   - Độ lệch chuẩn (Std. Dev.)
   - Tỷ lệ lỗi (Error %)
   - Throughput (Transactions/sec)
2. Cập nhật vào file `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\Kiểm thử đăng nhập.csv`

### Test Case 2: QLND_DN_019 - Kiểm thử khả năng xử lý tải với 10 người dùng đồng thời

#### Bước 1: Tạo Thread Group mới

1. Chuột phải vào "Test Plan" > Add > Threads (Users) > Thread Group
2. Đặt tên: "QLND_DN_019 - 10 người dùng đồng thời"

#### Bước 2: Cấu hình Thread Group

1. Number of Threads (users): 10
2. Ramp-up period (seconds): 1
3. Chọn "Loop Count: Forever"
4. Chọn "Scheduler"
5. Duration (seconds): 60
6. Startup delay (seconds): 0

#### Bước 3: Thêm HTTP Request và các thành phần khác

1. Thêm HTTP Request, HTTP Header Manager, Response Assertion và Listeners tương tự như Test Case 1
2. Đảm bảo sử dụng cùng HTTP Request Defaults đã tạo trước đó

#### Bước 4: Chạy test và ghi lại kết quả

1. Lưu Test Plan: File > Save Test Plan As > `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-plans\QLND_DN_019.jmx`
2. Nhấn nút "Start"
3. Đợi test hoàn thành (60 giây)
4. Ghi lại kết quả

### Test Case 3: QLND_DN_020 - Kiểm thử khả năng xử lý tải với 50 người dùng đồng thời

#### Bước 1: Tạo Thread Group mới

1. Chuột phải vào "Test Plan" > Add > Threads (Users) > Thread Group
2. Đặt tên: "QLND_DN_020 - 50 người dùng đồng thời"

#### Bước 2: Cấu hình Thread Group

1. Number of Threads (users): 50
2. Ramp-up period (seconds): 5
3. Chọn "Loop Count: Forever"
4. Chọn "Scheduler"
5. Duration (seconds): 120
6. Startup delay (seconds): 0

#### Bước 3: Thêm HTTP Request và các thành phần khác

1. Thêm HTTP Request, HTTP Header Manager, Response Assertion và Listeners tương tự như Test Case 1
2. Đảm bảo sử dụng cùng HTTP Request Defaults đã tạo trước đó

#### Bước 4: Chạy test và ghi lại kết quả

1. Lưu Test Plan: File > Save Test Plan As > `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-plans\QLND_DN_020.jmx`
2. Nhấn nút "Start"
3. Đợi test hoàn thành (120 giây)
4. Ghi lại kết quả
