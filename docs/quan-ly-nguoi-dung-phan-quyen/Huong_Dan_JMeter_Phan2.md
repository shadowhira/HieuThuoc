# Hướng dẫn chi tiết sử dụng JMeter để kiểm thử hiệu suất API đăng nhập (Phần 2)

## Test Case 4: QLND_DN_021 - Kiểm thử khả năng phục hồi sau tải cao

### Bước 1: Tạo Thread Group mới
1. Chuột phải vào "Test Plan" > Add > Threads (Users) > Thread Group
2. Đặt tên: "QLND_DN_021 - Phục hồi sau tải cao"

### Bước 2: Cấu hình Thread Group
1. Number of Threads (users): 100
2. Ramp-up period (seconds): 10
3. Loop Count: 1

### Bước 3: Thêm HTTP Request và các thành phần khác
1. Thêm HTTP Request, HTTP Header Manager, Response Assertion và Listeners tương tự như Test Case 1
2. Đảm bảo sử dụng cùng HTTP Request Defaults đã tạo trước đó

### Bước 4: Chạy test tải cao
1. Lưu Test Plan: File > Save Test Plan As > `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-plans\QLND_DN_021_1.jmx`
2. Nhấn nút "Start"
3. Đợi test hoàn thành

### Bước 5: Tạo Thread Group mới để kiểm tra phục hồi
1. Chuột phải vào "Test Plan" > Add > Threads (Users) > Thread Group
2. Đặt tên: "QLND_DN_021 - Kiểm tra phục hồi"
3. Number of Threads (users): 1
4. Ramp-up period (seconds): 1
5. Loop Count: 10

### Bước 6: Thêm HTTP Request và các thành phần khác
1. Thêm HTTP Request, HTTP Header Manager, Response Assertion và Listeners tương tự như Test Case 1

### Bước 7: Chạy test phục hồi và ghi lại kết quả
1. Lưu Test Plan: File > Save Test Plan As > `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-plans\QLND_DN_021_2.jmx`
2. Nhấn nút "Start"
3. Đợi test hoàn thành
4. Ghi lại kết quả và so sánh với kết quả của Test Case 1

## Test Case 5: QLND_DN_022 - Kiểm thử khả năng xử lý đăng nhập đồng thời với nhiều tài khoản khác nhau

### Bước 1: Tạo Thread Group mới
1. Chuột phải vào "Test Plan" > Add > Threads (Users) > Thread Group
2. Đặt tên: "QLND_DN_022 - Nhiều tài khoản đồng thời"

### Bước 2: Cấu hình Thread Group
1. Number of Threads (users): 20
2. Ramp-up period (seconds): 2
3. Chọn "Loop Count: Forever"
4. Chọn "Scheduler"
5. Duration (seconds): 60
6. Startup delay (seconds): 0

### Bước 3: Thêm CSV Data Set Config
1. Chuột phải vào Thread Group > Add > Config Element > CSV Data Set Config
2. Cấu hình:
   - Name: "Danh sách tài khoản"
   - Filename: `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-data\accounts.csv`
   - Variable Names: username,password
   - Delimiter (use '\t' for tab): ,
   - Allow quoted data?: True
   - Recycle on EOF?: True
   - Stop thread on EOF?: False
   - Sharing mode: All threads

### Bước 4: Thêm HTTP Request
1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Cấu hình:
   - Name: "API Đăng Nhập - Nhiều tài khoản"
   - Method: POST
   - Path: /hieuthuoc/dangnhap
   - Body Data:
     ```json
     {
       "tenDangNhap": "${username}",
       "matKhau": "${password}"
     }
     ```

### Bước 5: Thêm HTTP Header Manager, Response Assertion và Listeners
1. Thêm các thành phần tương tự như Test Case 1

### Bước 6: Chạy test và ghi lại kết quả
1. Lưu Test Plan: File > Save Test Plan As > `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\test-plans\QLND_DN_022.jmx`
2. Nhấn nút "Start"
3. Đợi test hoàn thành (60 giây)
4. Ghi lại kết quả

## Khắc phục lỗi phổ biến

### Lỗi IllegalCharsetNameException

Nếu gặp lỗi `Non HTTP response code: java.nio.charset.IllegalCharsetNameException`:

1. **Kiểm tra HTTP Header Manager**:
   - Đảm bảo Content-Type: `application/json; charset=UTF-8`
   - Thêm Accept: `application/json`

2. **Kiểm tra định dạng JSON**:
   - Sử dụng dấu nháy kép (") thay vì dấu nháy đơn (')
   - Không có ký tự đặc biệt không hợp lệ

3. **Thử sử dụng HTTP/2 Request**:
   - Chuột phải vào Thread Group > Add > Sampler > HTTP/2 Request
   - Cấu hình tương tự như HTTP Request

4. **Kiểm tra kết nối đến server**:
   - Đảm bảo server đang chạy (kiểm tra bằng trình duyệt)
   - Thử ping đến server: `ping localhost`

### Lỗi Connection Refused

Nếu gặp lỗi `Connection refused: connect`:

1. **Kiểm tra server**:
   - Đảm bảo server đang chạy
   - Kiểm tra port đúng (8888)

2. **Kiểm tra firewall**:
   - Tạm thời tắt firewall để kiểm tra
   - Thêm exception cho JMeter trong firewall

## Phân tích kết quả

Sau khi chạy các test case, phân tích kết quả dựa trên các tiêu chí sau:

1. **Thời gian phản hồi**:
   - Average: Thời gian phản hồi trung bình
   - Min: Thời gian phản hồi tối thiểu
   - Max: Thời gian phản hồi tối đa
   - 90% Line: 90% request có thời gian phản hồi dưới giá trị này

2. **Throughput**: Số lượng request/giây hệ thống xử lý được

3. **Tỷ lệ lỗi**: Phần trăm request thất bại

4. **Độ ổn định**: Độ lệch chuẩn của thời gian phản hồi

## Cập nhật kết quả vào file kiểm thử

Cập nhật kết quả vào file `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\Kiểm thử đăng nhập.csv`:

1. Mở file bằng Excel hoặc trình soạn thảo văn bản
2. Cập nhật cột "Current Output" với kết quả đã ghi lại
3. Cập nhật cột "Test Results" (Passed/Failed) dựa trên tiêu chí đánh giá
4. Thêm ghi chú vào cột "Notes" nếu cần
