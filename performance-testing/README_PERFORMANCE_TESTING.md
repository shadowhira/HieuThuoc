# Hướng dẫn Kiểm thử Hiệu năng cho Báo cáo Doanh thu

## Tổng quan

Thư mục này chứa các script và công cụ để kiểm thử hiệu năng của các API báo cáo doanh thu trong hệ thống HieuThuoc.

## Cấu trúc thư mục

```
performance-testing/
├── ket-qua-kiem-thu-hieu-nang-bao-cao-doanh-thu.csv    # File CSV ghi nhận kết quả kiểm thử
├── run_performance_test_updated.py                     # Script kiểm thử hiệu năng cơ bản
├── run_real_performance_test.py                        # Script kiểm thử hiệu năng thực tế
├── generate_sample_results.py                          # Script tạo dữ liệu mẫu
├── check_endpoints.py                                  # Script kiểm tra API endpoints
├── check_backend.py                                    # Script kiểm tra backend
├── requirements.txt                                    # Thư viện Python cần thiết
└── README_PERFORMANCE_TESTING.md                       # File hướng dẫn này
```

## Yêu cầu hệ thống

### Phần mềm cần thiết
- Python 3.7+
- pip (Python package manager)

### Thư viện Python
```bash
pip install -r requirements.txt
```

### Các thư viện chính:
- `requests`: Gửi HTTP requests
- `statistics`: Tính toán thống kê
- `concurrent.futures`: Xử lý đa luồng
- `csv`: Xử lý file CSV
- `datetime`: Xử lý thời gian

## Cách sử dụng

### 1. Kiểm tra API Endpoints

Trước khi chạy kiểm thử, hãy kiểm tra xem các API endpoints có hoạt động không:

```bash
python check_endpoints.py
```

### 2. Kiểm tra Backend

Kiểm tra backend server:

```bash
python check_backend.py
```

### 3. Chạy kiểm thử hiệu năng cơ bản

```bash
python run_performance_test_updated.py
```

### 4. Chạy kiểm thử hiệu năng thực tế (khuyến nghị)

```bash
python run_real_performance_test.py
```

### 5. Tạo dữ liệu mẫu

Nếu không có API endpoints thực tế, có thể tạo dữ liệu mẫu:

```bash
python generate_sample_results.py
```

## Cấu hình

### URLs mặc định
- Frontend: `http://localhost:4200`
- Backend: `http://localhost:8080`

### Thay đổi cấu hình
Chỉnh sửa các biến trong script:
```python
frontend_url = "http://localhost:4200"
backend_url = "http://localhost:8080"
```

## Các loại kiểm thử hiệu năng

### 1. Load Test (Tải nhẹ)
- Số request: 10
- Số thread: 5
- Mục tiêu: Kiểm tra hiệu năng cơ bản

### 2. Load Test (Tải trung bình)
- Số request: 50
- Số thread: 20
- Mục tiêu: Kiểm tra hiệu năng dưới tải trung bình

### 3. Load Test (Tải cao)
- Số request: 100
- Số thread: 50
- Mục tiêu: Kiểm tra hiệu năng dưới tải cao

### 4. Stress Test
- Số request: 500
- Số thread: 100
- Mục tiêu: Kiểm tra giới hạn của hệ thống

### 5. Endurance Test
- Số request: 1000
- Thời gian: 30 phút
- Mục tiêu: Kiểm tra hiệu năng trong thời gian dài

## API Endpoints được kiểm thử

### Báo cáo doanh thu theo ngày
- `/baocao/doanhthutheongay?ngay=YYYY-MM-DD`
- `/api/baocao/doanhthutheongay?ngay=YYYY-MM-DD`

### Báo cáo doanh thu theo tháng
- `/baocao/doanhthutheothang?nam=YYYY&thang=MM`
- `/api/baocao/doanhthutheothang?nam=YYYY&thang=MM`

### Báo cáo doanh thu theo năm
- `/baocao/doanhthutheonam?nam=YYYY`
- `/api/baocao/doanhthutheonam?nam=YYYY`

## Metrics được đo

### 1. Thời gian phản hồi (Response Time)
- Thời gian trung bình
- Thời gian tối thiểu
- Thời gian tối đa
- Thời gian trung vị

### 2. Tỷ lệ thành công (Success Rate)
- Số request thành công / Tổng số request
- Mục tiêu: ≥ 95% cho tải nhẹ và trung bình
- Mục tiêu: ≥ 90% cho tải cao

### 3. Kích thước dữ liệu (Data Size)
- Kích thước response trung bình
- Đơn vị: bytes

### 4. Thời gian thực hiện (Execution Time)
- Tổng thời gian chạy test case
- Đơn vị: milliseconds

## Tiêu chí đánh giá

### Passed (Đạt)
- Tỷ lệ thành công ≥ 95%
- Thời gian phản hồi < 2000ms (tải nhẹ)
- Thời gian phản hồi < 3000ms (tải trung bình)
- Thời gian phản hồi < 5000ms (tải cao)

### Failed (Không đạt)
- Tỷ lệ thành công < 95%
- Thời gian phản hồi vượt quá ngưỡng
- Có lỗi timeout hoặc connection error

## File kết quả

### ket-qua-kiem-thu-hieu-nang-bao-cao-doanh-thu.csv
File CSV chính chứa kết quả kiểm thử với các cột:
- ID: Mã test case
- Mô tả: Mô tả test case
- Các bước thực hiện: Các bước thực hiện test
- Dữ liệu đầu vào: Thông tin đầu vào
- Kết quả mong đợi: Kết quả mong đợi
- Kết quả thực tế: Kết quả thực tế
- Chi tiết lỗi: Chi tiết lỗi nếu có
- Trạng thái: Passed/Failed/N/A
- Thời gian thực hiện (ms): Thời gian thực hiện test
- Thời gian phản hồi (ms): Thời gian phản hồi trung bình
- Kích thước dữ liệu (bytes): Kích thước dữ liệu trả về
- Tỷ lệ thành công (%): Tỷ lệ request thành công
- Ghi chú: Ghi chú bổ sung

### ket-qua-kiem-thu-hieu-nang-thuc-te.csv
File CSV chứa kết quả kiểm thử thực tế khi có API endpoints hoạt động.

## Xử lý sự cố

### 1. Không thể kết nối đến server
- Kiểm tra server có đang chạy không
- Kiểm tra URL và port có đúng không
- Kiểm tra firewall

### 2. Tất cả test đều Failed
- Kiểm tra API endpoints có tồn tại không
- Kiểm tra tham số request có đúng không
- Kiểm tra server có trả về lỗi gì không

### 3. Thời gian phản hồi chậm
- Kiểm tra tài nguyên server (CPU, RAM, Disk)
- Kiểm tra database performance
- Kiểm tra network latency

### 4. Tỷ lệ thành công thấp
- Kiểm tra server có bị quá tải không
- Kiểm tra database connection pool
- Kiểm tra timeout settings

## Khuyến nghị

### 1. Trước khi chạy test
- Đảm bảo server đang chạy ổn định
- Kiểm tra database có đủ dữ liệu test
- Đóng các ứng dụng không cần thiết

### 2. Trong khi chạy test
- Theo dõi tài nguyên server
- Không chạy các tác vụ nặng khác
- Ghi lại thời gian chạy test

### 3. Sau khi chạy test
- Phân tích kết quả chi tiết
- So sánh với các lần test trước
- Đưa ra khuyến nghị cải thiện

## Liên hệ

Nếu có vấn đề hoặc câu hỏi, vui lòng liên hệ team phát triển.

---

**Lưu ý**: Các script này được thiết kế để kiểm thử hiệu năng của các API báo cáo doanh thu. Hãy đảm bảo có quyền truy cập vào hệ thống trước khi chạy test. 