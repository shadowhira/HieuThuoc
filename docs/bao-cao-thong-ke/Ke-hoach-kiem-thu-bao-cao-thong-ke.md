# Kế hoạch kiểm thử hộp đen cho chức năng Báo cáo thống kê

## 1. Tổng quan

### 1.1. Mục đích
Tài liệu này mô tả kế hoạch kiểm thử hộp đen chi tiết cho chức năng Báo cáo thống kê của hệ thống quản lý hiệu thuốc. Mục đích của kiểm thử là đảm bảo chức năng Báo cáo thống kê hoạt động chính xác, hiển thị dữ liệu đúng và xử lý các trường hợp đặc biệt một cách phù hợp.

### 1.2. Phạm vi
Kiểm thử sẽ tập trung vào các thành phần sau của chức năng Báo cáo thống kê:
- Giao diện người dùng (UI)
- Bộ lọc thời gian (ngày, tháng, năm)
- Hiển thị dữ liệu tổng quan (hóa đơn, đơn hàng trả lại, doanh thu)
- Biểu đồ doanh thu
- Tương tác với API
- Xử lý các trường hợp đặc biệt và ngoại lệ

### 1.3. Môi trường kiểm thử
- **Trình duyệt**: Chrome, Firefox, Edge
- **Công cụ kiểm thử**: Cypress
- **Môi trường**: Development/Test
- **Tài khoản kiểm thử**: Admin (username: admin, password: 123456)

## 2. Chiến lược kiểm thử

### 2.1. Phương pháp kiểm thử
- **Kiểm thử hộp đen**: Tập trung vào chức năng và kết quả đầu ra mà không quan tâm đến cấu trúc bên trong của hệ thống.
- **Kiểm thử giao diện người dùng**: Kiểm tra tính đúng đắn và tính nhất quán của giao diện người dùng.
- **Kiểm thử chức năng**: Kiểm tra các chức năng của hệ thống có hoạt động đúng như mong đợi không.
- **Kiểm thử tương thích**: Kiểm tra hệ thống có hoạt động đúng trên các trình duyệt khác nhau không.
- **Kiểm thử API**: Kiểm tra các API có trả về dữ liệu đúng không.

### 2.2. Tiêu chí đánh giá
- Tất cả các test case phải được thực hiện.
- Tất cả các lỗi nghiêm trọng và cao phải được sửa.
- Tỷ lệ test case pass phải đạt ít nhất 90%.

## 3. Kế hoạch kiểm thử chi tiết

### 3.1. Kiểm thử giao diện người dùng

#### 3.1.1. Kiểm tra tổng thể giao diện
- Kiểm tra màu nền, màu chữ, kích thước chữ trên màn hình
- Kiểm tra bố cục giao diện
- Kiểm tra thứ tự di chuyển trỏ khi nhấn Tab
- Kiểm tra thứ tự di chuyển trỏ khi nhấn Shift-Tab
- Kiểm tra giao diện khi thu nhỏ, phóng to
- Kiểm tra khi nhấn icon reload trên trình duyệt

#### 3.1.2. Kiểm tra hiển thị thông tin tổng quan
- Kiểm tra hiển thị thẻ thông tin Hóa đơn
- Kiểm tra hiển thị thẻ thông tin Đơn hàng trả lại
- Kiểm tra hiển thị thẻ thông tin Doanh thu
- Kiểm tra định dạng số và đơn vị tiền tệ

#### 3.1.3. Kiểm tra hiển thị biểu đồ
- Kiểm tra hiển thị container biểu đồ
- Kiểm tra hiển thị trục X và trục Y
- Kiểm tra hiển thị tooltip khi hover vào cột biểu đồ
- Kiểm tra hiển thị tiêu đề biểu đồ

### 3.2. Kiểm thử bộ lọc thời gian

#### 3.2.1. Kiểm tra hiển thị bộ lọc
- Kiểm tra hiển thị tùy chọn "Theo ngày"
- Kiểm tra hiển thị tùy chọn "Theo tháng"
- Kiểm tra hiển thị tùy chọn "Theo năm"
- Kiểm tra hiển thị dropdown chọn ngày, tháng, năm

#### 3.2.2. Kiểm tra chức năng bộ lọc
- Kiểm tra chọn loại báo cáo "Theo ngày"
- Kiểm tra chọn loại báo cáo "Theo tháng"
- Kiểm tra chọn loại báo cáo "Theo năm"
- Kiểm tra thay đổi ngày trong báo cáo "Theo ngày"
- Kiểm tra thay đổi tháng trong báo cáo "Theo tháng"
- Kiểm tra thay đổi năm trong báo cáo "Theo năm"

### 3.3. Kiểm thử hiển thị dữ liệu

#### 3.3.1. Kiểm tra hiển thị dữ liệu tổng quan
- Kiểm tra hiển thị số lượng hóa đơn
- Kiểm tra hiển thị số lượng đơn hàng trả lại
- Kiểm tra hiển thị tổng doanh thu
- Kiểm tra định dạng số và đơn vị tiền tệ

#### 3.3.2. Kiểm tra hiển thị biểu đồ doanh thu
- Kiểm tra hiển thị biểu đồ doanh thu theo ngày
- Kiểm tra hiển thị biểu đồ doanh thu theo tháng
- Kiểm tra hiển thị biểu đồ doanh thu theo năm
- Kiểm tra hiển thị tooltip khi hover vào cột biểu đồ

### 3.4. Kiểm thử tương tác với API

#### 3.4.1. Kiểm tra gọi API
- Kiểm tra gọi API doanh thu theo ngày
- Kiểm tra gọi API doanh thu theo tháng
- Kiểm tra gọi API doanh thu theo năm
- Kiểm tra tham số gửi lên API

#### 3.4.2. Kiểm tra xử lý dữ liệu từ API
- Kiểm tra xử lý dữ liệu từ API doanh thu theo ngày
- Kiểm tra xử lý dữ liệu từ API doanh thu theo tháng
- Kiểm tra xử lý dữ liệu từ API doanh thu theo năm
- Kiểm tra tính toán tổng doanh thu

### 3.5. Kiểm thử trường hợp đặc biệt và ngoại lệ

#### 3.5.1. Kiểm tra xử lý khi không có dữ liệu
- Kiểm tra hiển thị khi không có dữ liệu doanh thu theo ngày
- Kiểm tra hiển thị khi không có dữ liệu doanh thu theo tháng
- Kiểm tra hiển thị khi không có dữ liệu doanh thu theo năm

#### 3.5.2. Kiểm tra xử lý khi API trả về lỗi
- Kiểm tra xử lý khi API doanh thu theo ngày trả về lỗi
- Kiểm tra xử lý khi API doanh thu theo tháng trả về lỗi
- Kiểm tra xử lý khi API doanh thu theo năm trả về lỗi

#### 3.5.3. Kiểm tra xử lý dữ liệu đặc biệt
- Kiểm tra xử lý khi dữ liệu có giá trị âm
- Kiểm tra xử lý khi dữ liệu có giá trị rất lớn
- Kiểm tra xử lý khi dữ liệu không hợp lệ

## 4. Danh sách test case

Danh sách test case chi tiết sẽ được lưu trong file CSV với định dạng sau:
- Mã kiểm thử
- Mục đích kiểm thử
- Các bước thực hiện
- Dữ liệu kiểm thử
- Kết quả mong muốn
- Test Result
- Ngày thực hiện
- Tester
- Note

## 5. Lịch trình kiểm thử

- **Chuẩn bị kiểm thử**: 1 ngày
- **Thực hiện kiểm thử**: 2-3 ngày
- **Báo cáo kết quả**: 1 ngày

## 6. Tài nguyên

- **Nhân sự**: 1-2 tester
- **Công cụ**: Cypress, trình duyệt web
- **Môi trường**: Môi trường test với dữ liệu đầy đủ

## 7. Rủi ro và giảm thiểu

- **Rủi ro**: Thiếu dữ liệu test, môi trường không ổn định
- **Giảm thiểu**: Chuẩn bị dữ liệu test đầy đủ, đảm bảo môi trường ổn định trước khi kiểm thử
