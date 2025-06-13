# Tóm tắt hệ thống kiểm thử hiệu năng chức năng báo cáo doanh thu

## Tổng quan

Hệ thống kiểm thử hiệu năng này được thiết kế để đánh giá hiệu năng của chức năng thống kê báo cáo doanh thu trong hệ thống quản lý hiệu thuốc. Hệ thống bao gồm các công cụ và script để thực hiện kiểm thử hiệu năng, thu thập dữ liệu và phân tích kết quả.

## Các thành phần chính

### 1. Script kiểm thử hiệu năng
- **`run_performance_test.py`**: Script Python chính để kiểm thử hiệu năng với nhiều thread
- **`demo_test.py`**: Script demo để kiểm thử nhanh với ít request
- **`quick_performance_test.sh`**: Script bash để kiểm thử nhanh bằng curl

### 2. Công cụ JMeter
- **`revenue-report-performance-test.jmx`**: Test plan cho Apache JMeter

### 3. Script phân tích
- **`analyze_results.py`**: Script phân tích kết quả và tạo biểu đồ

### 4. Dữ liệu mẫu
- **`sample_performance_results.csv`**: Dữ liệu mẫu chi tiết
- **`sample_summary_results.csv`**: Dữ liệu mẫu tổng hợp

### 5. Script hỗ trợ
- **`run_performance_test.bat`**: Script batch cho Windows
- **`run_demo.bat`**: Script demo cho Windows

## Các API endpoints được kiểm thử

1. **`/baocao/doanhthutheongay`** - Báo cáo doanh thu theo ngày
   - Tham số: `ngay` (format: YYYY-MM-DD)
   - Mục đích: Lấy dữ liệu doanh thu theo giờ trong ngày

2. **`/baocao/doanhthutheothang`** - Báo cáo doanh thu theo tháng
   - Tham số: `nam`, `thang`
   - Mục đích: Lấy dữ liệu doanh thu theo ngày trong tháng

3. **`/baocao/doanhthutheonam`** - Báo cáo doanh thu theo năm
   - Tham số: `nam`
   - Mục đích: Lấy dữ liệu doanh thu theo tháng trong năm

## Các chỉ số hiệu năng được đo

### 1. Chỉ số cơ bản
- **Response Time**: Thời gian phản hồi (milliseconds)
- **Throughput**: Số request/giây
- **Success Rate**: Tỷ lệ request thành công
- **Error Rate**: Tỷ lệ request thất bại

### 2. Chỉ số thống kê
- **Min/Max Response Time**: Thời gian phản hồi tối thiểu/tối đa
- **Average Response Time**: Thời gian phản hồi trung bình
- **Median Response Time**: Thời gian phản hồi trung vị
- **Standard Deviation**: Độ lệch chuẩn
- **P95/P99 Response Time**: Percentile 95/99

## Tiêu chí đánh giá hiệu năng

### Mức độ hiệu năng
- **TỐT**: Response time < 2000ms, Success rate > 95%
- **TRUNG BÌNH**: Response time 2000-5000ms, Success rate 90-95%
- **CHẬM**: Response time > 5000ms, Success rate < 90%

### Yêu cầu theo SRS
- Thời gian tạo báo cáo không quá 5 giây cho báo cáo đơn giản
- Thời gian tạo báo cáo không quá 10 giây cho báo cáo phức tạp

## Cách sử dụng

### 1. Kiểm thử nhanh (Demo)
```bash
# Windows
run_demo.bat

# Linux/Mac
python demo_test.py
```

### 2. Kiểm thử đầy đủ
```bash
# Windows
run_performance_test.bat

# Linux/Mac
python run_performance_test.py
```

### 3. Phân tích kết quả
```bash
python analyze_results.py [file_csv]
```

## Kết quả đầu ra

### 1. File CSV
- **File chi tiết**: `revenue_report_performance_test_YYYYMMDD_HHMMSS.csv`
- **File tổng hợp**: `revenue_report_summary_YYYYMMDD_HHMMSS.csv`

### 2. Biểu đồ
- **Performance Analysis**: Biểu đồ phân tích hiệu năng tổng hợp
- **Response Time Trend**: Biểu đồ xu hướng thời gian phản hồi

### 3. Báo cáo
- **Analysis Report**: Báo cáo phân tích chi tiết với khuyến nghị

## Cấu hình kiểm thử

### Script Python
- **num_threads**: 20 (số thread đồng thời)
- **iterations_per_thread**: 10 (số lần lặp mỗi thread)
- **timeout**: 30 giây (thời gian chờ tối đa)

### JMeter
- **Thread Group**: 50 users
- **Ramp-up**: 10 seconds
- **Loop Count**: 10 iterations

## Xử lý lỗi và troubleshooting

### Lỗi thường gặp
1. **Connection refused**: Server không chạy
2. **Timeout**: Server quá tải hoặc mạng chậm
3. **404 Not Found**: Sai endpoint URL
4. **500 Internal Server Error**: Lỗi server

### Giải pháp
- Kiểm tra logs server
- Giảm tải kiểm thử
- Kiểm tra cấu hình database
- Xác minh API endpoints

## Kết quả mẫu

### Dữ liệu mẫu từ file CSV
- **Doanh Thu Theo Ngay**: 256.78ms trung bình, 100% thành công
- **Doanh Thu Theo Thang**: 415.67ms trung bình, 100% thành công  
- **Doanh Thu Theo Nam**: 689.45ms trung bình, 100% thành công

### Đánh giá hiệu năng
- ✅ Tất cả các API đều có hiệu năng TỐT
- ✅ Thời gian phản hồi đều dưới 2000ms
- ✅ Tỷ lệ thành công 100%

## Khuyến nghị cải thiện

### Nếu hiệu năng chưa tốt
1. **Tối ưu hóa database queries**
2. **Sử dụng caching cho dữ liệu thống kê**
3. **Tối ưu hóa cấu hình server**
4. **Kiểm tra và tối ưu hóa indexes**

### Monitoring liên tục
1. **Thiết lập monitoring tự động**
2. **Đặt cảnh báo khi hiệu năng giảm**
3. **Theo dõi xu hướng hiệu năng theo thời gian**

## Lưu ý quan trọng

1. **Đảm bảo server đang chạy** trước khi kiểm thử
2. **Kiểm tra dữ liệu test** có đủ để tạo báo cáo có ý nghĩa
3. **Theo dõi tài nguyên hệ thống** trong quá trình kiểm thử
4. **Lưu trữ kết quả** để so sánh hiệu năng theo thời gian
5. **Chạy kiểm thử trong môi trường tương tự production**

## Kết luận

Hệ thống kiểm thử hiệu năng này cung cấp một bộ công cụ toàn diện để đánh giá hiệu năng của chức năng báo cáo doanh thu. Với các script tự động, phân tích chi tiết và báo cáo trực quan, hệ thống giúp đảm bảo chất lượng hiệu năng của ứng dụng và cung cấp cơ sở để cải thiện liên tục. 