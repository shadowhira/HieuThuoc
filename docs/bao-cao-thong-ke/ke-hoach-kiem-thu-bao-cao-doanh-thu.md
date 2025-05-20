# KẾ HOẠCH KIỂM THỬ CHỨC NĂNG BÁO CÁO DOANH THU

## 1. TỔNG QUAN

### 1.1. Mục đích
Tài liệu này mô tả kế hoạch kiểm thử chi tiết cho chức năng Báo cáo Doanh thu trong hệ thống quản lý hiệu thuốc, bao gồm kiểm thử giao diện, kiểm thử đơn vị và kiểm thử hộp đen.

### 1.2. Phạm vi
Kiểm thử tập trung vào chức năng Báo cáo Doanh thu, bao gồm:
- Hiển thị tổng quan doanh thu (số lượng hóa đơn, đơn hàng trả lại, tổng doanh thu)
- Báo cáo doanh thu theo ngày
- Báo cáo doanh thu theo tháng
- Báo cáo doanh thu theo năm
- Biểu đồ thống kê doanh thu

### 1.3. Tài nguyên
- **Nhân sự**: 1 tester
- **Thời gian**: 3 ngày
- **Công cụ**:
  - Backend: JUnit, Mockito
  - Frontend: Jasmine, Karma
  - API Testing: Postman
  - UI Testing: Manual testing

### 1.4. Môi trường kiểm thử
- **Backend**: Spring Boot
- **Frontend**: Angular
- **Database**: MySQL
- **Browser**: Chrome, Firefox

## 2. CHIẾN LƯỢC KIỂM THỬ

### 2.1. Kiểm thử giao diện (UI Testing)
Kiểm thử giao diện người dùng để đảm bảo các thành phần hiển thị chính xác và hoạt động như mong đợi.

### 2.2. Kiểm thử đơn vị (Unit Testing)
Kiểm thử các thành phần riêng lẻ của hệ thống để đảm bảo chúng hoạt động chính xác.

### 2.3. Kiểm thử hộp đen (Black-box Testing)
Kiểm thử chức năng của hệ thống mà không quan tâm đến cấu trúc bên trong.

## 3. KIỂM THỬ GIAO DIỆN (UI TESTING)

### 3.1. Kiểm thử hiển thị Dashboard

#### TC-UI-001: Kiểm tra hiển thị tổng quan Dashboard
- **Mô tả**: Kiểm tra hiển thị các thành phần tổng quan trên Dashboard
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Kiểm tra hiển thị các thành phần tổng quan
- **Kết quả mong đợi**:
  1. Hiển thị số lượng hóa đơn (7 trong ảnh)
  2. Hiển thị số lượng đơn hàng trả lại (0 trong ảnh)
  3. Hiển thị tổng doanh thu (153,400 VND trong ảnh)
  4. Các thành phần được hiển thị với màu sắc và biểu tượng phù hợp

#### TC-UI-002: Kiểm tra hiển thị biểu đồ doanh thu
- **Mô tả**: Kiểm tra hiển thị biểu đồ doanh thu
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Kiểm tra hiển thị biểu đồ doanh thu
- **Kết quả mong đợi**:
  1. Biểu đồ doanh thu được hiển thị dạng cột
  2. Trục X hiển thị các ngày trong tháng
  3. Trục Y hiển thị doanh thu (VND)
  4. Các cột biểu đồ có màu xanh dương
  5. Có tooltip hiển thị chi tiết khi di chuột vào cột

#### TC-UI-003: Kiểm tra chức năng chuyển đổi loại báo cáo
- **Mô tả**: Kiểm tra chức năng chuyển đổi giữa các loại báo cáo (theo ngày, theo tháng, theo năm)
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Chọn loại báo cáo "Theo ngày"
  4. Kiểm tra hiển thị biểu đồ
  5. Chọn loại báo cáo "Theo tháng"
  6. Kiểm tra hiển thị biểu đồ
  7. Chọn loại báo cáo "Theo năm"
  8. Kiểm tra hiển thị biểu đồ
- **Kết quả mong đợi**:
  1. Khi chọn "Theo ngày", biểu đồ hiển thị doanh thu theo giờ trong ngày
  2. Khi chọn "Theo tháng", biểu đồ hiển thị doanh thu theo ngày trong tháng
  3. Khi chọn "Theo năm", biểu đồ hiển thị doanh thu theo tháng trong năm
  4. Dữ liệu biểu đồ được cập nhật tương ứng với loại báo cáo đã chọn

#### TC-UI-004: Kiểm tra chức năng chọn thời gian
- **Mô tả**: Kiểm tra chức năng chọn thời gian (ngày, tháng, năm) cho báo cáo
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Chọn loại báo cáo "Theo ngày"
  4. Chọn một ngày khác
  5. Kiểm tra hiển thị biểu đồ
  6. Chọn loại báo cáo "Theo tháng"
  7. Chọn một tháng khác
  8. Kiểm tra hiển thị biểu đồ
  9. Chọn loại báo cáo "Theo năm"
  10. Chọn một năm khác
  11. Kiểm tra hiển thị biểu đồ
- **Kết quả mong đợi**:
  1. Khi chọn ngày khác, biểu đồ được cập nhật với dữ liệu của ngày đã chọn
  2. Khi chọn tháng khác, biểu đồ được cập nhật với dữ liệu của tháng đã chọn
  3. Khi chọn năm khác, biểu đồ được cập nhật với dữ liệu của năm đã chọn
  4. Dữ liệu tổng quan (số lượng hóa đơn, đơn hàng trả lại, tổng doanh thu) được cập nhật tương ứng

### 3.2. Kiểm thử tính năng responsive

#### TC-UI-005: Kiểm tra hiển thị trên màn hình desktop
- **Mô tả**: Kiểm tra hiển thị trên màn hình desktop
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Kiểm tra hiển thị trên màn hình desktop (>= 1024px)
- **Kết quả mong đợi**:
  1. Tất cả các thành phần được hiển thị đầy đủ và rõ ràng
  2. Biểu đồ được hiển thị với kích thước phù hợp
  3. Không có thanh cuộn ngang

#### TC-UI-006: Kiểm tra hiển thị trên màn hình tablet
- **Mô tả**: Kiểm tra hiển thị trên màn hình tablet
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Kiểm tra hiển thị trên màn hình tablet (768px - 1023px)
- **Kết quả mong đợi**:
  1. Tất cả các thành phần được hiển thị đầy đủ và rõ ràng
  2. Biểu đồ được hiển thị với kích thước phù hợp
  3. Layout có thể thay đổi để phù hợp với kích thước màn hình

## 4. KIỂM THỬ ĐƠN VỊ (UNIT TESTING)

### 4.1. Kiểm thử Backend

#### TC-UT-001: Kiểm thử phương thức doanhThuTheoNgay trong BaoCaoController
- **Mô tả**: Kiểm thử phương thức doanhThuTheoNgay trong BaoCaoController
- **Các bước thực hiện**:
  1. Tạo mock object cho DonHangRepo
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức doanhThuTheoNgay với tham số ngày
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. Phương thức donHangRepo.doanhThuTheoNgay được gọi đúng 1 lần với tham số ngày
  2. Kết quả trả về là ResponseDTO với status 200, message "Thành công." và data là danh sách DoanhThuDTO

#### TC-UT-002: Kiểm thử phương thức doanhThuTheoThang trong BaoCaoController
- **Mô tả**: Kiểm thử phương thức doanhThuTheoThang trong BaoCaoController
- **Các bước thực hiện**:
  1. Tạo mock object cho DonHangRepo
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức doanhThuTheoThang với tham số năm và tháng
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. Phương thức donHangRepo.doanhThuTheoThang được gọi đúng 1 lần với tham số năm và tháng
  2. Kết quả trả về là ResponseDTO với status 200, message "Thành công." và data là danh sách DoanhThuDTO

#### TC-UT-003: Kiểm thử phương thức doanhThuTheoNam trong BaoCaoController
- **Mô tả**: Kiểm thử phương thức doanhThuTheoNam trong BaoCaoController
- **Các bước thực hiện**:
  1. Tạo mock object cho DonHangRepo
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức doanhThuTheoNam với tham số năm
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. Phương thức donHangRepo.doanhThuTheoNam được gọi đúng 1 lần với tham số năm
  2. Kết quả trả về là ResponseDTO với status 200, message "Thành công." và data là danh sách DoanhThuDTO

### 4.2. Kiểm thử Frontend

#### TC-UT-004: Kiểm thử phương thức getDoanhThuTheoNgay trong BaoCaoService
- **Mô tả**: Kiểm thử phương thức getDoanhThuTheoNgay trong BaoCaoService
- **Các bước thực hiện**:
  1. Tạo mock object cho HttpClient
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức getDoanhThuTheoNgay với tham số ngày
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. HttpClient.get được gọi đúng 1 lần với URL và tham số đúng
  2. Kết quả trả về là Observable với dữ liệu đúng

#### TC-UT-005: Kiểm thử phương thức getDoanhThuTheoThang trong BaoCaoService
- **Mô tả**: Kiểm thử phương thức getDoanhThuTheoThang trong BaoCaoService
- **Các bước thực hiện**:
  1. Tạo mock object cho HttpClient
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức getDoanhThuTheoThang với tham số năm và tháng
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. HttpClient.get được gọi đúng 1 lần với URL và tham số đúng
  2. Kết quả trả về là Observable với dữ liệu đúng

## 5. KIỂM THỬ HỘP ĐEN (BLACK-BOX TESTING)

### 5.1. Kiểm thử chức năng báo cáo doanh thu theo ngày

#### TC-BB-001: Kiểm tra báo cáo doanh thu với ngày có dữ liệu
- **Mô tả**: Kiểm tra báo cáo doanh thu với ngày có dữ liệu
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Chọn loại báo cáo "Theo ngày"
  4. Chọn ngày có dữ liệu (ví dụ: ngày hiện tại)
  5. Kiểm tra hiển thị biểu đồ và dữ liệu tổng quan
- **Kết quả mong đợi**:
  1. Biểu đồ hiển thị doanh thu theo giờ trong ngày
  2. Dữ liệu tổng quan (số lượng hóa đơn, đơn hàng trả lại, tổng doanh thu) được hiển thị chính xác
  3. Dữ liệu biểu đồ khớp với dữ liệu trong cơ sở dữ liệu

#### TC-BB-002: Kiểm tra báo cáo doanh thu với ngày không có dữ liệu
- **Mô tả**: Kiểm tra báo cáo doanh thu với ngày không có dữ liệu
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Chọn loại báo cáo "Theo ngày"
  4. Chọn ngày không có dữ liệu (ví dụ: ngày trong quá khứ xa)
  5. Kiểm tra hiển thị biểu đồ và dữ liệu tổng quan
- **Kết quả mong đợi**:
  1. Biểu đồ hiển thị không có dữ liệu hoặc tất cả các cột đều bằng 0
  2. Dữ liệu tổng quan hiển thị giá trị 0 cho số lượng hóa đơn, đơn hàng trả lại, tổng doanh thu
  3. Không có thông báo lỗi

### 5.2. Kiểm thử chức năng báo cáo doanh thu theo tháng

#### TC-BB-003: Kiểm tra báo cáo doanh thu với tháng có dữ liệu
- **Mô tả**: Kiểm tra báo cáo doanh thu với tháng có dữ liệu
- **Các bước thực hiện**:
  1. Đăng nhập vào hệ thống với quyền admin
  2. Truy cập vào trang Báo cáo
  3. Chọn loại báo cáo "Theo tháng"
  4. Chọn tháng có dữ liệu (ví dụ: tháng hiện tại)
  5. Kiểm tra hiển thị biểu đồ và dữ liệu tổng quan
- **Kết quả mong đợi**:
  1. Biểu đồ hiển thị doanh thu theo ngày trong tháng
  2. Dữ liệu tổng quan (số lượng hóa đơn, đơn hàng trả lại, tổng doanh thu) được hiển thị chính xác
  3. Dữ liệu biểu đồ khớp với dữ liệu trong cơ sở dữ liệu

## 6. LỊCH TRÌNH KIỂM THỬ

| STT | Công việc | Thời gian |
|-----|-----------|-----------|
| 1 | Chuẩn bị môi trường kiểm thử | 0.5 ngày |
| 2 | Kiểm thử giao diện | 0.5 ngày |
| 3 | Kiểm thử đơn vị | 1 ngày |
| 4 | Kiểm thử hộp đen | 0.5 ngày |
| 5 | Tổng hợp kết quả và viết báo cáo | 0.5 ngày |
| | **Tổng cộng** | **3 ngày** |

## 7. BÁO CÁO VÀ THEO DÕI LỖI

### 7.1. Mẫu báo cáo lỗi
- **ID lỗi**: BUG-XXX
- **Mô tả lỗi**: Mô tả chi tiết về lỗi
- **Bước tái hiện**: Các bước để tái hiện lỗi
- **Kết quả thực tế**: Kết quả thực tế khi thực hiện các bước
- **Kết quả mong đợi**: Kết quả mong đợi khi thực hiện các bước
- **Mức độ nghiêm trọng**: Critical/High/Medium/Low
- **Trạng thái**: Open/In Progress/Fixed/Closed
- **Người phát hiện**: Tên người phát hiện lỗi
- **Ngày phát hiện**: Ngày phát hiện lỗi
- **Người được giao**: Tên người được giao xử lý lỗi
- **Ngày sửa**: Ngày sửa lỗi
- **Phiên bản**: Phiên bản của hệ thống khi phát hiện lỗi

### 7.2. Công cụ theo dõi lỗi
- Sử dụng Excel để theo dõi lỗi
- Lưu trữ báo cáo lỗi trong thư mục docs/bao-cao-thong-ke/bugs
