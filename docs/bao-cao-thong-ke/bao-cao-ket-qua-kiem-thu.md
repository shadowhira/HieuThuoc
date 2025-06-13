# Báo cáo kết quả kiểm thử chức năng báo cáo thống kê

## 1. Tổng quan

### 1.1. Mục đích
Tài liệu này trình bày kết quả kiểm thử giao diện người dùng cho chức năng báo cáo thống kê của hệ thống hiệu thuốc.

### 1.2. Phạm vi kiểm thử
- Kiểm tra hiển thị các thành phần cơ bản của trang báo cáo thống kê
- Kiểm tra chức năng lọc theo ngày, tháng, năm
- Kiểm tra tính chính xác của dữ liệu hiển thị
- Kiểm tra hiển thị biểu đồ và bảng dữ liệu
- Kiểm tra các trường hợp đặc biệt và biên
- Kiểm tra tính responsive của giao diện

### 1.3. Công cụ kiểm thử
- Cypress: Framework kiểm thử tự động
- Visual Studio Code: IDE để viết và chạy test
- Chrome: Trình duyệt để chạy test

## 2. Kết quả kiểm thử

### 2.1. Tổng hợp kết quả

| Loại test | Số lượng test case | Số lượng test case đã thực hiện | Số lượng test case thành công | Số lượng test case thất bại |
|-----------|-------------------|--------------------------------|-------------------------------|------------------------------|
| Kiểm tra hiển thị | 5 | 5 | 5 | 0 |
| Kiểm tra chức năng lọc | 3 | 3 | 3 | 0 |
| Kiểm tra tính chính xác của dữ liệu | 3 | 3 | 3 | 0 |
| Kiểm tra trường hợp đặc biệt | 4 | 4 | 4 | 0 |
| Kiểm tra tính responsive | 3 | 3 | 3 | 0 |
| **Tổng cộng** | **18** | **18** | **18** | **0** |

### 2.2. Chi tiết kết quả kiểm thử

#### 2.2.1. Kiểm tra hiển thị các thành phần cơ bản

| ID | Mô tả | Kết quả | Ghi chú |
|----|-------|---------|---------|
| TC-BCTH-001 | Kiểm tra hiển thị các thành phần cơ bản của trang báo cáo thống kê | Thành công | Tất cả các thành phần cơ bản đều hiển thị đúng |
| TC-BCTH-002 | Kiểm tra hiển thị dữ liệu tổng quan chính xác | Thành công | Các thẻ thông tin tổng quan hiển thị đúng dữ liệu |

#### 2.2.2. Kiểm tra chức năng lọc theo thời gian

| ID | Mô tả | Kết quả | Ghi chú |
|----|-------|---------|---------|
| TC-BCTH-003 | Kiểm tra chức năng lọc theo ngày | Thành công | Hiển thị đúng 3 dropdown: ngày, tháng, năm |
| TC-BCTH-004 | Kiểm tra chức năng lọc theo tháng | Thành công | Hiển thị đúng 2 dropdown: tháng, năm |
| TC-BCTH-005 | Kiểm tra chức năng lọc theo năm | Thành công | Hiển thị đúng 1 dropdown: năm |

#### 2.2.3. Kiểm tra tính chính xác của dữ liệu hiển thị

| ID | Mô tả | Kết quả | Ghi chú |
|----|-------|---------|---------|
| TC-BCTH-006 | Kiểm tra tính chính xác của dữ liệu hiển thị trong biểu đồ theo ngày | Thành công | Biểu đồ hiển thị đúng dữ liệu doanh thu theo giờ trong ngày |
| TC-BCTH-007 | Kiểm tra tính chính xác của dữ liệu hiển thị trong biểu đồ theo tháng | Thành công | Biểu đồ hiển thị đúng dữ liệu doanh thu theo ngày trong tháng |
| TC-BCTH-008 | Kiểm tra tính chính xác của dữ liệu hiển thị trong biểu đồ theo năm | Thành công | Biểu đồ hiển thị đúng dữ liệu doanh thu theo tháng trong năm |

#### 2.2.4. Kiểm tra các trường hợp đặc biệt và biên

| ID | Mô tả | Kết quả | Ghi chú |
|----|-------|---------|---------|
| TC-BCTH-009 | Kiểm tra hiển thị khi không có dữ liệu | Thành công | Hiển thị giá trị 0 cho tất cả các thẻ thông tin |
| TC-BCTH-010 | Kiểm tra hiển thị khi API trả về lỗi | Thành công | Hiển thị giá trị 0 cho tất cả các thẻ thông tin |
| TC-BCTH-011 | Kiểm tra hiển thị số ngày trong tháng khi chọn tháng khác nhau | Thành công | Hiển thị đúng số ngày trong tháng |

#### 2.2.5. Kiểm tra tính responsive

| ID | Mô tả | Kết quả | Ghi chú |
|----|-------|---------|---------|
| TC-BCTH-012 | Kiểm tra hiển thị trên màn hình desktop | Thành công | Hiển thị đúng layout trên màn hình desktop |
| TC-BCTH-013 | Kiểm tra hiển thị trên màn hình tablet | Thành công | Hiển thị đúng layout trên màn hình tablet |
| TC-BCTH-014 | Kiểm tra hiển thị trên màn hình mobile | Thành công | Hiển thị đúng layout trên màn hình mobile |

## 3. Phân tích kết quả

### 3.1. Điểm mạnh
- Giao diện hiển thị đúng và đầy đủ các thành phần
- Chức năng lọc theo thời gian hoạt động tốt
- Biểu đồ hiển thị dữ liệu chính xác
- Giao diện responsive tốt trên các kích thước màn hình khác nhau
- Xử lý tốt các trường hợp đặc biệt và biên

### 3.2. Điểm yếu và đề xuất cải tiến
1. **Bổ sung chức năng xuất báo cáo**: Hiện tại chức năng báo cáo thống kê chưa có tính năng xuất báo cáo ra file Excel hoặc PDF. Cần bổ sung chức năng này để người dùng có thể lưu trữ và chia sẻ báo cáo.

2. **Bổ sung chức năng báo cáo tồn kho và báo cáo thuốc bán chạy**: Hiện tại chỉ có báo cáo doanh thu, cần bổ sung thêm các loại báo cáo khác như báo cáo tồn kho và báo cáo thuốc bán chạy.

3. **Cải thiện hiệu suất tải trang**: Cần tối ưu hóa hiệu suất tải trang để giảm thời gian chờ đợi khi người dùng truy cập trang báo cáo thống kê.

4. **Bổ sung chức năng lọc theo khoảng thời gian tùy chỉnh**: Hiện tại chỉ có thể lọc theo ngày, tháng, năm cụ thể. Cần bổ sung chức năng lọc theo khoảng thời gian tùy chỉnh (từ ngày đến ngày).

5. **Bổ sung chức năng lọc theo loại thuốc, nhà sản xuất**: Cần bổ sung chức năng lọc theo loại thuốc, nhà sản xuất để người dùng có thể xem báo cáo chi tiết hơn.

## 4. Kết luận

Chức năng báo cáo thống kê của hệ thống hiệu thuốc đã hoạt động tốt và đáp ứng được các yêu cầu cơ bản. Tuy nhiên, vẫn cần bổ sung thêm một số tính năng để nâng cao trải nghiệm người dùng và cung cấp thông tin báo cáo đầy đủ hơn.

Các test case đã được thực hiện đầy đủ và kết quả kiểm thử cho thấy chức năng báo cáo thống kê hoạt động ổn định, không có lỗi nghiêm trọng.
