# Hướng dẫn kiểm thử hộp đen cho chức năng báo cáo thống kê doanh thu

## 1. Giới thiệu

Tài liệu này cung cấp hướng dẫn chi tiết để thực hiện kiểm thử hộp đen cho chức năng báo cáo thống kê doanh thu trong hệ thống hiệu thuốc. Kiểm thử hộp đen tập trung vào việc kiểm tra chức năng của hệ thống mà không cần biết cấu trúc bên trong của mã nguồn.

## 2. Chuẩn bị môi trường kiểm thử

### 2.1. Yêu cầu phần cứng và phần mềm

- **Máy tính** với cấu hình tối thiểu:
  - CPU: Intel Core i5 hoặc tương đương
  - RAM: 8GB trở lên
  - Ổ cứng: 50GB trống
  - Kết nối internet ổn định

- **Phần mềm cần thiết**:
  - Hệ điều hành: Windows 10/11, macOS, hoặc Linux
  - Trình duyệt: Chrome, Firefox, Edge (phiên bản mới nhất)
  - Node.js (phiên bản 14 trở lên)
  - npm (phiên bản 6 trở lên)
  - Cypress (phiên bản 10 trở lên)

### 2.2. Cài đặt môi trường

1. **Cài đặt Node.js và npm**:
   - Tải và cài đặt Node.js từ [nodejs.org](https://nodejs.org/)
   - Kiểm tra cài đặt bằng lệnh:
     ```
     node -v
     npm -v
     ```

2. **Cài đặt Cypress**:
   - Mở terminal/command prompt
   - Di chuyển đến thư mục dự án
   - Chạy lệnh:
     ```
     npm install cypress --save-dev
     ```

3. **Chuẩn bị dữ liệu kiểm thử**:
   - Đảm bảo cơ sở dữ liệu có dữ liệu mẫu về đơn hàng, doanh thu
   - Chuẩn bị dữ liệu đặc biệt: dữ liệu rỗng, dữ liệu lớn, dữ liệu âm

## 3. Thực hiện kiểm thử thủ công

### 3.1. Kiểm thử giao diện tổng quan

1. **Đăng nhập hệ thống**:
   - Truy cập trang đăng nhập
   - Nhập thông tin đăng nhập với tài khoản admin (username: admin, password: 123456)
   - Nhấn nút đăng nhập

2. **Truy cập trang báo cáo thống kê**:
   - Từ menu chính, chọn "Báo cáo"
   - Hoặc truy cập trực tiếp URL: `/sys/thongke`

3. **Kiểm tra hiển thị tổng quan**:
   - Xác nhận hiển thị 3 ô tổng quan: Hóa đơn, Đơn hàng trả lại, Doanh thu
   - Xác nhận hiển thị biểu đồ doanh thu
   - Xác nhận hiển thị các tab lọc: Theo ngày, Theo tháng, Theo năm
   - Xác nhận hiển thị dropdown chọn thời gian

4. **Kiểm tra hiển thị số liệu tổng quan**:
   - Xác nhận hiển thị số lượng hóa đơn
   - Xác nhận hiển thị số lượng đơn hàng trả lại
   - Xác nhận hiển thị tổng doanh thu kèm đơn vị VNĐ

5. **Kiểm tra hiển thị biểu tượng cho các thẻ thông tin**:
   - Xác nhận biểu tượng thẻ Hóa đơn hiển thị đúng
   - Xác nhận biểu tượng thẻ Đơn hàng trả lại hiển thị đúng
   - Xác nhận biểu tượng thẻ Doanh thu hiển thị đúng

### 3.2. Kiểm thử bộ lọc thời gian

1. **Kiểm tra chuyển đổi giữa các tab thời gian**:
   - Xác nhận tab Theo ngày được chọn mặc định
   - Chọn tab Theo tháng, xác nhận hiển thị dropdown chọn tháng và năm
   - Chọn tab Theo năm, xác nhận hiển thị dropdown chọn năm
   - Xác nhận biểu đồ cập nhật khi chuyển đổi tab

2. **Kiểm tra bộ lọc ngày**:
   - Chọn tab Theo ngày
   - Xác nhận dropdown hiển thị đầy đủ các ngày trong tháng
   - Chọn ngày khác, xác nhận biểu đồ và số liệu tổng quan cập nhật

3. **Kiểm tra bộ lọc tháng**:
   - Chọn tab Theo tháng
   - Xác nhận dropdown hiển thị đầy đủ 12 tháng
   - Chọn tháng khác, xác nhận biểu đồ và số liệu tổng quan cập nhật

4. **Kiểm tra bộ lọc năm**:
   - Chọn tab Theo năm
   - Xác nhận dropdown hiển thị đầy đủ các năm
   - Chọn năm khác, xác nhận biểu đồ và số liệu tổng quan cập nhật

5. **Kiểm tra hiển thị số ngày trong tháng khi chọn tháng khác nhau**:
   - Chọn tab Theo ngày
   - Chọn tháng 2 năm 2024, xác nhận hiển thị 29 ngày (năm nhuận)
   - Chọn tháng 2 năm 2023, xác nhận hiển thị 28 ngày (năm không nhuận)
   - Chọn tháng 4 năm 2024, xác nhận hiển thị 30 ngày
   - Chọn tháng 5 năm 2024, xác nhận hiển thị 31 ngày

### 3.3. Kiểm thử biểu đồ doanh thu

1. **Kiểm tra hiển thị biểu đồ doanh thu theo ngày**:
   - Chọn tab Theo ngày
   - Chọn ngày, tháng, năm cụ thể
   - Xác nhận biểu đồ hiển thị dữ liệu theo giờ trong ngày
   - Xác nhận số liệu tổng quan cập nhật theo ngày đã chọn

2. **Kiểm tra hiển thị biểu đồ doanh thu theo tháng**:
   - Chọn tab Theo tháng
   - Chọn tháng và năm cụ thể
   - Xác nhận biểu đồ hiển thị dữ liệu theo ngày trong tháng
   - Xác nhận số liệu tổng quan cập nhật theo tháng đã chọn

3. **Kiểm tra hiển thị biểu đồ doanh thu theo năm**:
   - Chọn tab Theo năm
   - Chọn năm cụ thể
   - Xác nhận biểu đồ hiển thị dữ liệu theo tháng trong năm
   - Xác nhận số liệu tổng quan cập nhật theo năm đã chọn

4. **Kiểm tra tương tác với biểu đồ**:
   - Di chuột qua các cột trong biểu đồ
   - Xác nhận hiển thị tooltip với thông tin chi tiết
   - Xác nhận biểu đồ phản hồi khi tương tác

### 3.4. Kiểm thử trường hợp ngoại lệ

1. **Kiểm tra hiển thị khi không có dữ liệu**:
   - Chọn thời gian không có dữ liệu
   - Xác nhận biểu đồ hiển thị trống hoặc giá trị 0
   - Xác nhận số liệu tổng quan hiển thị giá trị 0

2. **Kiểm tra hiển thị với dữ liệu lớn**:
   - Chọn thời gian có nhiều dữ liệu
   - Xác nhận biểu đồ hiển thị đúng với dữ liệu lớn
   - Xác nhận thời gian tải trang không quá lâu
   - Xác nhận không có lỗi hiển thị

3. **Kiểm tra hiển thị với dữ liệu có giá trị chênh lệch lớn**:
   - Chọn thời gian có dữ liệu chênh lệch lớn
   - Xác nhận biểu đồ hiển thị đúng với dữ liệu chênh lệch lớn
   - Xác nhận tỷ lệ biểu đồ hợp lý, không bị méo

4. **Kiểm tra hiển thị khi chọn ngày trong tương lai**:
   - Chọn tab Theo ngày
   - Chọn ngày trong tương lai
   - Xác nhận biểu đồ hiển thị trống hoặc giá trị 0
   - Xác nhận số liệu tổng quan hiển thị giá trị 0

## 4. Thực hiện kiểm thử tự động với Cypress

### 4.1. Chuẩn bị môi trường Cypress

1. **Mở Cypress**:
   - Mở terminal/command prompt
   - Di chuyển đến thư mục dự án
   - Chạy lệnh:
     ```
     npx cypress open
     ```

2. **Cấu hình Cypress**:
   - Chọn E2E Testing
   - Chọn trình duyệt (Chrome, Firefox, hoặc Edge)
   - Nhấn "Start E2E Testing"

### 4.2. Chạy test case tự động

1. **Chạy tất cả test case**:
   - Trong giao diện Cypress, chọn file `black-box-test.cy.js`
   - Cypress sẽ tự động chạy tất cả test case trong file

2. **Chạy test case cụ thể**:
   - Trong giao diện Cypress, chọn file `black-box-test.cy.js`
   - Nhấn vào test case cụ thể để chạy riêng test case đó

### 4.3. Phân tích kết quả kiểm thử

1. **Xem kết quả kiểm thử**:
   - Cypress hiển thị kết quả của từng test case (Pass/Fail)
   - Đối với test case fail, Cypress hiển thị thông tin chi tiết về lỗi

2. **Ghi nhận kết quả kiểm thử**:
   - Cập nhật file `test-case-kiem-thu-hop-den.csv` với kết quả kiểm thử
   - Ghi chú chi tiết lỗi nếu có

## 5. Báo cáo kết quả kiểm thử

### 5.1. Tổng hợp kết quả

1. **Thống kê số lượng test case**:
   - Tổng số test case
   - Số lượng test case pass
   - Số lượng test case fail
   - Tỷ lệ pass/fail

2. **Phân loại lỗi**:
   - Lỗi giao diện
   - Lỗi chức năng
   - Lỗi dữ liệu
   - Lỗi hiệu suất

### 5.2. Đánh giá kết quả

1. **Đánh giá theo tiêu chí**:
   - Đánh giá dựa trên tiêu chí đạt/không đạt đã định nghĩa trong kế hoạch kiểm thử
   - Xác định mức độ nghiêm trọng của các lỗi

2. **Đề xuất cải tiến**:
   - Đề xuất cách khắc phục lỗi
   - Đề xuất cải tiến chức năng

## 6. Tài liệu tham khảo

- Kế hoạch kiểm thử hộp đen: `docs/bao-cao-thong-ke/ke-hoach-kiem-thu-hop-den.md`
- Danh sách test case: `docs/bao-cao-thong-ke/test-case-kiem-thu-hop-den.csv`
- Mã nguồn kiểm thử tự động: `FE/cypress/e2e/bao-cao-thong-ke/black-box-test.cy.js`
