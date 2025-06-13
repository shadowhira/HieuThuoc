**HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG**  
**KHOA CÔNG NGHỆ THÔNG TIN**

**ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM**

# KẾ HOẠCH KIỂM THỬ HỘP ĐEN
**CHỨC NĂNG BÁO CÁO THỐNG KÊ DOANH THU**

**Giảng viên hướng dẫn:** Đỗ Thị Bích Ngọc  
**Nhóm SQA:** Huan-dev

**Hà Nội - 2024**

## 1. Giới thiệu

### 1.1. Mục đích tài liệu
Tài liệu này mô tả kế hoạch kiểm thử hộp đen (black-box testing) cho chức năng báo cáo thống kê doanh thu trong hệ thống hiệu thuốc. Tài liệu bao gồm các thông tin về phạm vi kiểm thử, phương pháp kiểm thử, môi trường kiểm thử, các test case, và tiêu chí đánh giá kết quả.

### 1.2. Phạm vi kiểm thử
Kiểm thử hộp đen tập trung vào chức năng báo cáo thống kê doanh thu, bao gồm:
- Giao diện tổng quan (hiển thị số liệu tổng hợp)
- Biểu đồ doanh thu
- Bộ lọc thời gian (theo ngày, theo tháng, theo năm)
- Tính chính xác của dữ liệu báo cáo
- Xử lý các trường hợp ngoại lệ

### 1.3. Tài liệu tham khảo
- Đặc tả yêu cầu dự án
- Tài liệu thiết kế hệ thống
- Tài liệu kiểm thử mẫu trong thư mục docs/Tham-khao

## 2. Môi trường kiểm thử

### 2.1. Phần cứng
- **Máy chủ:**
  - Hệ điều hành: Ubuntu 22.04 LTS
  - RAM: 8 GB trở lên
  - Vi xử lý: Intel Xeon / AMD Ryzen 5 trở lên
  - Bộ nhớ: SSD 100 GB trở lên

- **Máy khách:**
  - Hệ điều hành: Windows 10/11 hoặc macOS
  - RAM: 8 GB trở lên
  - Vi xử lý: Intel Core i5 / Apple M1 trở lên
  - Bộ nhớ: SSD 50 GB trở lên

### 2.2. Phần mềm
- Hệ quản trị cơ sở dữ liệu: MySQL
- Trình duyệt: Chrome, Firefox, Edge
- Công cụ kiểm thử: Cypress

### 2.3. Dữ liệu kiểm thử
- Dữ liệu mẫu về đơn hàng, doanh thu theo ngày/tháng/năm
- Dữ liệu đặc biệt: dữ liệu rỗng, dữ liệu lớn, dữ liệu âm, dữ liệu không hợp lệ

## 3. Phương pháp kiểm thử

### 3.1. Kỹ thuật kiểm thử
- **Kiểm thử chức năng (Functional Testing):** Kiểm tra các chức năng của hệ thống theo đặc tả yêu cầu
- **Kiểm thử giao diện người dùng (UI Testing):** Kiểm tra giao diện người dùng, bố cục, màu sắc, font chữ
- **Kiểm thử tương thích (Compatibility Testing):** Kiểm tra trên các trình duyệt và kích thước màn hình khác nhau
- **Kiểm thử biên (Boundary Testing):** Kiểm tra hệ thống với các giá trị biên
- **Kiểm thử trường hợp ngoại lệ (Exception Testing):** Kiểm tra hệ thống với các trường hợp đặc biệt

### 3.2. Công cụ kiểm thử
- **Cypress:** Công cụ kiểm thử tự động cho ứng dụng web
- **Postman:** Kiểm thử API
- **Chrome DevTools:** Kiểm tra giao diện, hiệu suất, và lỗi

## 4. Phân tích chức năng báo cáo thống kê doanh thu

### 4.1. Thành phần giao diện
Dựa trên hình ảnh và mã nguồn, giao diện báo cáo thống kê doanh thu bao gồm các thành phần sau:

1. **Phần tổng quan:**
   - Số lượng hóa đơn
   - Số lượng đơn hàng trả lại
   - Tổng doanh thu (VND)

2. **Biểu đồ doanh thu:**
   - Biểu đồ cột hiển thị doanh thu theo thời gian
   - Trục X: thời gian (giờ/ngày/tháng tùy theo loại báo cáo)
   - Trục Y: doanh thu (VND)

3. **Bộ lọc thời gian:**
   - Radio button chọn loại báo cáo: Theo ngày, Theo tháng, Theo năm
   - Dropdown chọn ngày (khi chọn Theo ngày)
   - Dropdown chọn tháng (khi chọn Theo ngày hoặc Theo tháng)
   - Dropdown chọn năm

### 4.2. Luồng xử lý chính
1. Người dùng truy cập trang báo cáo thống kê
2. Hệ thống hiển thị báo cáo mặc định (theo ngày hiện tại)
3. Người dùng chọn loại báo cáo (ngày/tháng/năm)
4. Người dùng chọn thời gian cụ thể
5. Hệ thống gọi API tương ứng để lấy dữ liệu
6. Hệ thống hiển thị dữ liệu tổng quan và biểu đồ

### 4.3. API sử dụng
- `/baocao/doanhthutheongay`: Lấy doanh thu theo ngày
- `/baocao/doanhthutheothang`: Lấy doanh thu theo tháng
- `/baocao/doanhthutheonam`: Lấy doanh thu theo năm

## 5. Các test case kiểm thử

### 5.1. Kiểm thử giao diện tổng quan

| Mã TC | Mục đích kiểm thử | Các bước thực hiện | Kết quả mong muốn |
|-------|-------------------|-------------------|-------------------|
| TC-TK-UI-01 | Kiểm tra hiển thị tổng quan ban đầu | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê | 1. Hiển thị 3 ô tổng quan: Hóa đơn, Đơn hàng trả lại, Doanh thu<br>2. Hiển thị biểu đồ doanh thu<br>3. Hiển thị các tab lọc: Theo ngày, Theo tháng, Theo năm<br>4. Hiển thị dropdown chọn thời gian |
| TC-TK-UI-02 | Kiểm tra hiển thị số liệu tổng quan | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê | 1. Hiển thị số lượng hóa đơn<br>2. Hiển thị số lượng đơn hàng trả lại<br>3. Hiển thị tổng doanh thu kèm đơn vị VNĐ |
| TC-TK-UI-03 | Kiểm tra hiển thị biểu tượng cho các thẻ thông tin | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê | 1. Biểu tượng thẻ Hóa đơn hiển thị đúng<br>2. Biểu tượng thẻ Đơn hàng trả lại hiển thị đúng<br>3. Biểu tượng thẻ Doanh thu hiển thị đúng |

### 5.2. Kiểm thử bộ lọc thời gian

| Mã TC | Mục đích kiểm thử | Các bước thực hiện | Kết quả mong muốn |
|-------|-------------------|-------------------|-------------------|
| TC-TK-FILTER-01 | Kiểm tra chuyển đổi giữa các tab thời gian | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chuyển đổi giữa các tab thời gian | 1. Tab Theo ngày được chọn mặc định<br>2. Khi chọn tab Theo tháng, hiển thị dropdown chọn tháng và năm<br>3. Khi chọn tab Theo năm, hiển thị dropdown chọn năm<br>4. Biểu đồ cập nhật khi chuyển đổi tab |
| TC-TK-FILTER-02 | Kiểm tra bộ lọc ngày | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo ngày<br>4. Chọn ngày, tháng, năm cụ thể | 1. Dropdown hiển thị đầy đủ các ngày trong tháng<br>2. Khi chọn ngày khác, biểu đồ và số liệu tổng quan cập nhật |
| TC-TK-FILTER-03 | Kiểm tra bộ lọc tháng | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo tháng<br>4. Chọn các tháng khác nhau trong dropdown | 1. Dropdown hiển thị đầy đủ 12 tháng<br>2. Khi chọn tháng khác, biểu đồ và số liệu tổng quan cập nhật |
| TC-TK-FILTER-04 | Kiểm tra bộ lọc năm | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo năm<br>4. Chọn các năm khác nhau trong dropdown | 1. Dropdown hiển thị đầy đủ các năm<br>2. Khi chọn năm khác, biểu đồ và số liệu tổng quan cập nhật |
| TC-TK-FILTER-05 | Kiểm tra hiển thị số ngày trong tháng khi chọn tháng khác nhau | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo ngày<br>4. Chọn các tháng khác nhau | 1. Tháng 2 năm 2024 (năm nhuận) hiển thị 29 ngày<br>2. Tháng 2 năm 2023 (năm không nhuận) hiển thị 28 ngày<br>3. Tháng 4 (30 ngày) hiển thị đúng<br>4. Tháng 5 (31 ngày) hiển thị đúng |

### 5.3. Kiểm thử biểu đồ doanh thu

| Mã TC | Mục đích kiểm thử | Các bước thực hiện | Kết quả mong muốn |
|-------|-------------------|-------------------|-------------------|
| TC-TK-CHART-01 | Kiểm tra hiển thị biểu đồ doanh thu theo ngày | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo ngày<br>4. Chọn ngày, tháng, năm cụ thể | 1. Biểu đồ hiển thị dữ liệu theo giờ trong ngày<br>2. Số liệu tổng quan cập nhật theo ngày đã chọn |
| TC-TK-CHART-02 | Kiểm tra hiển thị biểu đồ doanh thu theo tháng | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo tháng<br>4. Chọn tháng và năm cụ thể | 1. Biểu đồ hiển thị dữ liệu theo ngày trong tháng<br>2. Số liệu tổng quan cập nhật theo tháng đã chọn |
| TC-TK-CHART-03 | Kiểm tra hiển thị biểu đồ doanh thu theo năm | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo năm<br>4. Chọn năm cụ thể | 1. Biểu đồ hiển thị dữ liệu theo tháng trong năm<br>2. Số liệu tổng quan cập nhật theo năm đã chọn |
| TC-TK-CHART-04 | Kiểm tra tương tác với biểu đồ | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Di chuột qua các cột trong biểu đồ | 1. Khi di chuột qua các cột, hiển thị tooltip với thông tin chi tiết<br>2. Biểu đồ phản hồi khi tương tác |
| TC-TK-CHART-05 | Kiểm tra cập nhật biểu đồ khi thay đổi bộ lọc thời gian | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo tháng<br>4. Thay đổi tháng | 1. Biểu đồ cập nhật dữ liệu khi thay đổi bộ lọc<br>2. Số liệu tổng quan cập nhật |

### 5.4. Kiểm thử tính chính xác của dữ liệu

| Mã TC | Mục đích kiểm thử | Các bước thực hiện | Kết quả mong muốn |
|-------|-------------------|-------------------|-------------------|
| TC-TK-DATA-01 | Kiểm tra tính chính xác của dữ liệu tổng quan | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn thời gian có dữ liệu đã biết trước | 1. Số lượng hóa đơn hiển thị chính xác<br>2. Số lượng đơn hàng trả lại hiển thị chính xác<br>3. Tổng doanh thu hiển thị chính xác |
| TC-TK-DATA-02 | Kiểm tra tính chính xác của dữ liệu biểu đồ | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn thời gian có dữ liệu đã biết trước | 1. Dữ liệu trên biểu đồ hiển thị chính xác<br>2. Tổng doanh thu trên biểu đồ khớp với tổng doanh thu trong phần tổng quan |
| TC-TK-DATA-03 | Kiểm tra tính nhất quán của dữ liệu khi chuyển đổi giữa các loại báo cáo | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo ngày và ghi nhận dữ liệu<br>4. Chọn tab Theo tháng (cùng tháng với ngày đã chọn)<br>5. Chọn tab Theo năm (cùng năm với tháng đã chọn) | 1. Dữ liệu tổng quan nhất quán giữa các loại báo cáo<br>2. Tổng doanh thu theo ngày <= Tổng doanh thu theo tháng <= Tổng doanh thu theo năm |

### 5.5. Kiểm thử trường hợp ngoại lệ

| Mã TC | Mục đích kiểm thử | Các bước thực hiện | Kết quả mong muốn |
|-------|-------------------|-------------------|-------------------|
| TC-TK-EDGE-01 | Kiểm tra hiển thị khi không có dữ liệu | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn thời gian không có dữ liệu | 1. Biểu đồ hiển thị trống hoặc giá trị 0<br>2. Số liệu tổng quan hiển thị giá trị 0 |
| TC-TK-EDGE-02 | Kiểm tra hiển thị với dữ liệu lớn | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn thời gian có nhiều dữ liệu | 1. Biểu đồ hiển thị đúng với dữ liệu lớn<br>2. Thời gian tải trang không quá lâu<br>3. Không có lỗi hiển thị |
| TC-TK-EDGE-03 | Kiểm tra hiển thị với dữ liệu có giá trị chênh lệch lớn | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn thời gian có dữ liệu chênh lệch lớn | 1. Biểu đồ hiển thị đúng với dữ liệu chênh lệch lớn<br>2. Tỷ lệ biểu đồ hợp lý, không bị méo |
| TC-TK-EDGE-04 | Kiểm tra hiển thị khi API trả về lỗi | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Giả lập API trả về lỗi | 1. Hiển thị thông báo lỗi phù hợp<br>2. Giao diện không bị vỡ |
| TC-TK-EDGE-05 | Kiểm tra hiển thị khi chọn ngày trong tương lai | 1. Đăng nhập với tài khoản admin<br>2. Truy cập trang thống kê<br>3. Chọn tab Theo ngày<br>4. Chọn ngày trong tương lai | 1. Biểu đồ hiển thị trống hoặc giá trị 0<br>2. Số liệu tổng quan hiển thị giá trị 0 |

## 6. Tiêu chí đánh giá kết quả

### 6.1. Tiêu chí đạt
- Tất cả các test case đều pass
- Giao diện hiển thị đúng trên các trình duyệt và kích thước màn hình khác nhau
- Dữ liệu hiển thị chính xác và nhất quán
- Không có lỗi JavaScript trong console
- Thời gian tải trang và dữ liệu hợp lý

### 6.2. Tiêu chí không đạt
- Có test case fail
- Giao diện bị vỡ trên một số trình duyệt hoặc kích thước màn hình
- Dữ liệu hiển thị không chính xác hoặc không nhất quán
- Có lỗi JavaScript trong console
- Thời gian tải trang và dữ liệu quá lâu

## 7. Kết luận và đề xuất

Kế hoạch kiểm thử hộp đen này cung cấp một cách tiếp cận có hệ thống để kiểm tra chức năng báo cáo thống kê doanh thu trong hệ thống hiệu thuốc. Các test case được thiết kế để bao quát đầy đủ các chức năng, giao diện, và xử lý các trường hợp ngoại lệ.

Để đảm bảo chất lượng tốt nhất, đề xuất:
- Thực hiện kiểm thử tự động với Cypress để tăng hiệu quả và độ tin cậy
- Bổ sung dữ liệu kiểm thử đa dạng để bao quát nhiều trường hợp
- Thực hiện kiểm thử trên nhiều môi trường khác nhau
- Cập nhật kế hoạch kiểm thử khi có thay đổi về yêu cầu hoặc chức năng

## 8. Phụ lục

### 8.1. Danh sách test case chi tiết
Xem file CSV đính kèm: `ket-qua-kiem-thu-ui.csv`

### 8.2. Mã nguồn kiểm thử tự động
Xem thư mục: `FE/cypress/e2e/bao-cao-thong-ke/`
