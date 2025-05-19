# KẾ HOẠCH KIỂM THỬ PHÂN HỆ BÁO CÁO VÀ THỐNG KÊ

## 1. Giới thiệu về phân hệ Báo cáo và Thống kê

### 1.1. Mô tả tổng quan

Phân hệ Báo cáo và Thống kê trong hệ thống quản lý hiệu thuốc là một thành phần quan trọng, cung cấp các công cụ để phân tích dữ liệu kinh doanh, theo dõi tồn kho và đưa ra các quyết định kinh doanh dựa trên dữ liệu. Phân hệ này bao gồm các chức năng chính sau:

1. **Báo cáo doanh thu**: Cho phép xem và phân tích doanh thu theo các khoảng thời gian khác nhau (ngày, tháng, năm). Dữ liệu được hiển thị dưới dạng biểu đồ trực quan và bảng chi tiết.

2. **Báo cáo tồn kho**: Cung cấp thông tin về số lượng thuốc còn trong kho, bao gồm các cảnh báo về thuốc sắp hết hàng hoặc sắp hết hạn sử dụng.

3. **Báo cáo thuốc bán chạy**: Hiển thị danh sách các thuốc được bán nhiều nhất trong một khoảng thời gian, giúp phân tích xu hướng tiêu dùng.

4. **Xuất báo cáo**: Cho phép xuất các báo cáo ra các định dạng phổ biến như PDF, Excel để lưu trữ hoặc chia sẻ.

### 1.2. Tầm quan trọng của phân hệ

Phân hệ Báo cáo và Thống kê đóng vai trò quan trọng trong việc:
- Cung cấp thông tin để đưa ra quyết định kinh doanh
- Theo dõi hiệu quả hoạt động của hiệu thuốc
- Quản lý tồn kho hiệu quả, tránh tình trạng hết hàng hoặc thuốc hết hạn
- Phân tích xu hướng tiêu dùng để điều chỉnh chiến lược kinh doanh

## 2. Phạm vi kiểm thử

### 2.1. Các chức năng cần kiểm thử

#### 2.1.1. Báo cáo doanh thu
- Xem báo cáo doanh thu theo ngày
- Xem báo cáo doanh thu theo tháng
- Xem báo cáo doanh thu theo năm
- Hiển thị biểu đồ doanh thu
- Hiển thị bảng dữ liệu chi tiết
- Lọc và tìm kiếm dữ liệu báo cáo

#### 2.1.2. Báo cáo tồn kho
- Xem báo cáo tồn kho hiện tại
- Lọc báo cáo theo tên thuốc, loại thuốc, nhà sản xuất
- Hiển thị cảnh báo thuốc sắp hết hàng
- Hiển thị cảnh báo thuốc sắp hết hạn

#### 2.1.3. Báo cáo thuốc bán chạy
- Xem danh sách thuốc bán chạy
- Lọc theo khoảng thời gian
- Hiển thị biểu đồ thuốc bán chạy
- Hiển thị bảng dữ liệu chi tiết

#### 2.1.4. Xuất báo cáo
- Xuất báo cáo doanh thu ra file Excel
- Xuất báo cáo doanh thu ra file PDF
- Xuất báo cáo tồn kho ra file Excel
- Xuất báo cáo tồn kho ra file PDF
- Xuất báo cáo thuốc bán chạy ra file Excel
- Xuất báo cáo thuốc bán chạy ra file PDF

### 2.2. Các thành phần cần kiểm thử

#### 2.2.1. Backend
- BaoCaoController
- DonHangRepo (các query báo cáo doanh thu)
- ChiTietDonHangRepo (query thuốc bán chạy)
- TonKhoService và TonKhoController

#### 2.2.2. Frontend
- ThongKeComponent
- BaoCaoService
- Các component hiển thị biểu đồ và bảng dữ liệu

## 3. Chiến lược kiểm thử

### 3.1. Kiểm thử đơn vị (Unit Testing)
- Kiểm thử các phương thức trong BaoCaoController
- Kiểm thử các query trong DonHangRepo và ChiTietDonHangRepo
- Kiểm thử các phương thức trong BaoCaoService (Frontend)

### 3.2. Kiểm thử tích hợp (Integration Testing)
- Kiểm thử tương tác giữa BaoCaoController và DonHangRepo
- Kiểm thử tương tác giữa BaoCaoService và API endpoints
- Kiểm thử tương tác giữa các component Frontend

### 3.3. Kiểm thử giao diện (UI Testing)
- Kiểm thử hiển thị biểu đồ doanh thu
- Kiểm thử hiển thị bảng dữ liệu
- Kiểm thử các form lọc và tìm kiếm
- Kiểm thử responsive design

### 3.4. Kiểm thử hộp đen (Black Box Testing)
- Kiểm thử chức năng báo cáo doanh thu
- Kiểm thử chức năng báo cáo tồn kho
- Kiểm thử chức năng báo cáo thuốc bán chạy
- Kiểm thử chức năng xuất báo cáo

### 3.5. Kiểm thử hiệu năng (Performance Testing) - Tùy chọn
- Kiểm thử thời gian phản hồi của API báo cáo
- Kiểm thử thời gian tải trang báo cáo
- Kiểm thử hiệu năng với dữ liệu lớn

### 3.6. Kiểm thử tự động (Automated Testing) - Tùy chọn
- Sử dụng Selenium WebDriver để tự động hóa kiểm thử giao diện
- Sử dụng JUnit và Mockito để tự động hóa kiểm thử đơn vị
- Sử dụng Jasmine và Karma để tự động hóa kiểm thử frontend

### 3.7. Áp dụng công cụ AI vào kiểm thử - Tùy chọn
- Sử dụng công cụ AI để tự động tạo test case
- Sử dụng công cụ AI để phân tích kết quả kiểm thử
- Sử dụng công cụ AI để dự đoán các khu vực có khả năng lỗi cao

## 4. Môi trường kiểm thử

### 4.1. Yêu cầu phần cứng
- CPU: Intel Core i5 hoặc tương đương
- RAM: Tối thiểu 8GB
- Ổ cứng: SSD với ít nhất 20GB không gian trống

### 4.2. Yêu cầu phần mềm
- Hệ điều hành: Windows 10/11 hoặc macOS
- JDK 17 hoặc cao hơn
- Maven 3.8.x hoặc cao hơn
- PostgreSQL 14.x hoặc cao hơn
- Node.js 16.x hoặc cao hơn
- Angular CLI 15.x hoặc cao hơn
- Trình duyệt: Chrome, Firefox, Edge
- Công cụ kiểm thử: JUnit, Mockito, Jasmine, Karma
- Công cụ kiểm thử UI: Selenium WebDriver
- Công cụ báo cáo: Allure Report

### 4.3. Dữ liệu kiểm thử
- Dữ liệu mẫu cho đơn hàng (ít nhất 100 đơn hàng)
- Dữ liệu mẫu cho thuốc (ít nhất 50 loại thuốc)
- Dữ liệu mẫu cho tồn kho
- Dữ liệu mẫu cho người dùng với các vai trò khác nhau

## 5. Lịch trình kiểm thử

| STT | Hoạt động | Thời gian bắt đầu | Thời gian kết thúc | Người thực hiện |
|-----|-----------|-------------------|-------------------|-----------------|
| 1 | Review tài liệu đặc tả | 01/06/2024 | 03/06/2024 | [Tên người thực hiện] |
| 2 | Review code | 04/06/2024 | 06/06/2024 | [Tên người thực hiện] |
| 3 | Thiết kế test case | 07/06/2024 | 10/06/2024 | [Tên người thực hiện] |
| 4 | Chuẩn bị môi trường kiểm thử | 11/06/2024 | 12/06/2024 | [Tên người thực hiện] |
| 5 | Thực hiện kiểm thử đơn vị | 13/06/2024 | 15/06/2024 | [Tên người thực hiện] |
| 6 | Thực hiện kiểm thử tích hợp | 16/06/2024 | 18/06/2024 | [Tên người thực hiện] |
| 7 | Thực hiện kiểm thử giao diện | 19/06/2024 | 21/06/2024 | [Tên người thực hiện] |
| 8 | Thực hiện kiểm thử hộp đen | 22/06/2024 | 24/06/2024 | [Tên người thực hiện] |
| 9 | Thực hiện kiểm thử hiệu năng (tùy chọn) | 25/06/2024 | 26/06/2024 | [Tên người thực hiện] |
| 10 | Phân tích kết quả và báo cáo lỗi | 27/06/2024 | 29/06/2024 | [Tên người thực hiện] |
| 11 | Lập báo cáo kiểm thử | 30/06/2024 | 02/07/2024 | [Tên người thực hiện] |

## 6. Các test case chi tiết

### 6.1. Kiểm thử Báo cáo doanh thu

#### TC_BC_001: Xem báo cáo doanh thu theo ngày
- **Mã test case**: TC_BC_001
- **Mô tả**: Kiểm tra chức năng xem báo cáo doanh thu theo ngày
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Cao
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong ngày cần báo cáo
- **Dữ liệu đầu vào**: Ngày cần báo cáo (ví dụ: 15/06/2024)
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo ngày"
  3. Nhập ngày cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo giờ trong ngày
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Giờ, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong ngày
- **Trạng thái**: Chưa thực hiện

#### TC_BC_002: Xem báo cáo doanh thu theo tháng
- **Mã test case**: TC_BC_002
- **Mô tả**: Kiểm tra chức năng xem báo cáo doanh thu theo tháng
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Cao
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong tháng cần báo cáo
- **Dữ liệu đầu vào**: Tháng và năm cần báo cáo (ví dụ: 06/2024)
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo tháng"
  3. Chọn tháng và năm cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo ngày trong tháng
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Ngày, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong tháng
- **Trạng thái**: Chưa thực hiện

#### TC_BC_003: Xem báo cáo doanh thu theo năm
- **Mã test case**: TC_BC_003
- **Mô tả**: Kiểm tra chức năng xem báo cáo doanh thu theo năm
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Cao
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong năm cần báo cáo
- **Dữ liệu đầu vào**: Năm cần báo cáo (ví dụ: 2024)
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo năm"
  3. Chọn năm cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo tháng trong năm
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Tháng, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong năm
- **Trạng thái**: Chưa thực hiện

#### TC_BC_004: Xuất báo cáo doanh thu ra Excel
- **Mã test case**: TC_BC_004
- **Mô tả**: Kiểm tra chức năng xuất báo cáo doanh thu ra file Excel
- **Loại kiểm thử**: Kiểm thử hộp đen
- **Mức độ ưu tiên**: Trung bình
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Đã xem báo cáo doanh thu
- **Dữ liệu đầu vào**: Báo cáo doanh thu đang xem
- **Các bước thực hiện**:
  1. Xem báo cáo doanh thu (theo ngày, tháng hoặc năm)
  2. Nhấn nút "Xuất Excel"
- **Kết quả mong đợi**:
  1. Hệ thống tạo và tải xuống file Excel
  2. File Excel chứa đầy đủ dữ liệu báo cáo đang xem
  3. File Excel có định dạng đúng (tiêu đề, header, footer)
- **Trạng thái**: Chưa thực hiện

#### TC_BC_005: Xuất báo cáo doanh thu ra PDF
- **Mã test case**: TC_BC_005
- **Mô tả**: Kiểm tra chức năng xuất báo cáo doanh thu ra file PDF
- **Loại kiểm thử**: Kiểm thử hộp đen
- **Mức độ ưu tiên**: Trung bình
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Đã xem báo cáo doanh thu
- **Dữ liệu đầu vào**: Báo cáo doanh thu đang xem
- **Các bước thực hiện**:
  1. Xem báo cáo doanh thu (theo ngày, tháng hoặc năm)
  2. Nhấn nút "Xuất PDF"
- **Kết quả mong đợi**:
  1. Hệ thống tạo và tải xuống file PDF
  2. File PDF chứa đầy đủ dữ liệu báo cáo đang xem
  3. File PDF có định dạng đúng (tiêu đề, header, footer)
- **Trạng thái**: Chưa thực hiện

### 6.2. Kiểm thử Báo cáo tồn kho

#### TC_BC_006: Xem báo cáo tồn kho
- **Mã test case**: TC_BC_006
- **Mô tả**: Kiểm tra chức năng xem báo cáo tồn kho
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Cao
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Có dữ liệu tồn kho
- **Dữ liệu đầu vào**: Không có
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Tồn kho"
  2. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị bảng dữ liệu tồn kho với các cột: Mã thuốc, Tên thuốc, Số lượng tồn, Đơn vị, Hạn sử dụng, Trạng thái
  2. Các thuốc sắp hết hàng (số lượng dưới ngưỡng cảnh báo) được đánh dấu màu vàng
  3. Các thuốc sắp hết hạn (trong vòng 30 ngày) được đánh dấu màu đỏ
- **Trạng thái**: Chưa thực hiện

#### TC_BC_007: Lọc báo cáo tồn kho theo tên thuốc
- **Mã test case**: TC_BC_007
- **Mô tả**: Kiểm tra chức năng lọc báo cáo tồn kho theo tên thuốc
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Trung bình
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Đã xem báo cáo tồn kho
- **Dữ liệu đầu vào**: Tên thuốc cần lọc (ví dụ: "Paracetamol")
- **Các bước thực hiện**:
  1. Xem báo cáo tồn kho
  2. Nhập tên thuốc vào ô tìm kiếm
  3. Nhấn nút "Tìm kiếm"
- **Kết quả mong đợi**:
  1. Hiển thị danh sách thuốc có tên chứa từ khóa tìm kiếm
  2. Không hiển thị các thuốc không liên quan
- **Trạng thái**: Chưa thực hiện

#### TC_BC_008: Xuất báo cáo tồn kho ra Excel
- **Mã test case**: TC_BC_008
- **Mô tả**: Kiểm tra chức năng xuất báo cáo tồn kho ra file Excel
- **Loại kiểm thử**: Kiểm thử hộp đen
- **Mức độ ưu tiên**: Trung bình
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Đã xem báo cáo tồn kho
- **Dữ liệu đầu vào**: Báo cáo tồn kho đang xem
- **Các bước thực hiện**:
  1. Xem báo cáo tồn kho
  2. Nhấn nút "Xuất Excel"
- **Kết quả mong đợi**:
  1. Hệ thống tạo và tải xuống file Excel
  2. File Excel chứa đầy đủ dữ liệu báo cáo đang xem
  3. File Excel có định dạng đúng (tiêu đề, header, footer)
- **Trạng thái**: Chưa thực hiện

### 6.3. Kiểm thử Báo cáo thuốc bán chạy

#### TC_BC_009: Xem báo cáo thuốc bán chạy
- **Mã test case**: TC_BC_009
- **Mô tả**: Kiểm tra chức năng xem báo cáo thuốc bán chạy
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Cao
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Có dữ liệu đơn hàng
- **Dữ liệu đầu vào**: Khoảng thời gian cần báo cáo (ví dụ: tháng hiện tại)
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Thuốc bán chạy"
  2. Chọn khoảng thời gian cần báo cáo
  3. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ top 10 thuốc bán chạy nhất
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Mã thuốc, Tên thuốc, Số lượng bán, Doanh thu
  3. Danh sách được sắp xếp theo thứ tự giảm dần về số lượng bán
- **Trạng thái**: Chưa thực hiện

#### TC_BC_010: Lọc báo cáo thuốc bán chạy theo loại thuốc
- **Mã test case**: TC_BC_010
- **Mô tả**: Kiểm tra chức năng lọc báo cáo thuốc bán chạy theo loại thuốc
- **Loại kiểm thử**: Kiểm thử hộp đen, Kiểm thử giao diện
- **Mức độ ưu tiên**: Trung bình
- **Điều kiện tiên quyết**:
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Đã xem báo cáo thuốc bán chạy
- **Dữ liệu đầu vào**: Loại thuốc cần lọc (ví dụ: "Kháng sinh")
- **Các bước thực hiện**:
  1. Xem báo cáo thuốc bán chạy
  2. Chọn loại thuốc từ dropdown
  3. Nhấn nút "Lọc"
- **Kết quả mong đợi**:
  1. Hiển thị danh sách thuốc thuộc loại đã chọn
  2. Không hiển thị các thuốc không thuộc loại đã chọn
  3. Biểu đồ được cập nhật theo dữ liệu đã lọc
- **Trạng thái**: Chưa thực hiện

## 7. Quy trình báo cáo lỗi và theo dõi

### 7.1. Quy trình báo cáo lỗi
1. Phát hiện lỗi trong quá trình kiểm thử
2. Ghi lại thông tin chi tiết về lỗi:
   - Mã test case
   - Mô tả lỗi
   - Các bước tái hiện lỗi
   - Môi trường kiểm thử
   - Ảnh chụp màn hình (nếu có)
3. Phân loại mức độ nghiêm trọng của lỗi:
   - Critical: Lỗi gây crash hệ thống, mất dữ liệu
   - Major: Lỗi ảnh hưởng đến chức năng chính
   - Minor: Lỗi nhỏ, không ảnh hưởng nhiều đến chức năng
   - Cosmetic: Lỗi giao diện, hiển thị
4. Báo cáo lỗi cho team phát triển

### 7.2. Quy trình theo dõi lỗi
1. Team phát triển tiếp nhận báo cáo lỗi
2. Phân tích và xác nhận lỗi
3. Sửa lỗi
4. Thông báo đã sửa lỗi
5. Kiểm thử lại để xác nhận lỗi đã được sửa
6. Cập nhật trạng thái lỗi

### 7.3. Công cụ quản lý lỗi
- Sử dụng GitHub Issues để theo dõi và quản lý lỗi
- Mỗi lỗi được tạo thành một issue với các thông tin:
  - Tiêu đề: Mô tả ngắn gọn về lỗi
  - Mô tả: Chi tiết về lỗi, các bước tái hiện, ảnh chụp màn hình
  - Labels: Phân loại lỗi (critical, major, minor, cosmetic)
  - Assignee: Người phụ trách sửa lỗi
  - Milestone: Sprint hoặc phiên bản sẽ sửa lỗi
- Sử dụng các trạng thái issue để theo dõi tiến độ:
  - Open: Lỗi mới được báo cáo
  - In Progress: Đang sửa lỗi
  - Review: Đã sửa xong, đang chờ review
  - Closed: Lỗi đã được sửa và kiểm thử lại

## 8. Tiêu chí đánh giá (Pass/Fail Criteria)

### 8.1. Tiêu chí đánh giá cho test case
- **Pass**: Test case thực hiện thành công, kết quả thực tế khớp với kết quả mong đợi
- **Fail**: Test case thực hiện không thành công, kết quả thực tế không khớp với kết quả mong đợi
- **Blocked**: Không thể thực hiện test case do lỗi hoặc thiếu điều kiện tiên quyết

### 8.2. Tiêu chí đánh giá cho phân hệ
- **Pass**: Tất cả các test case quan trọng (critical và major) đều pass
- **Conditional Pass**: Có một số test case minor hoặc cosmetic fail, nhưng không ảnh hưởng đến chức năng chính
- **Fail**: Có ít nhất một test case critical hoặc major fail

### 8.3. Tiêu chí chấp nhận
- Không có lỗi critical
- Không quá 2 lỗi major
- Không quá 5 lỗi minor
- Thời gian phản hồi của các API báo cáo không quá 3 giây
- Thời gian tải trang báo cáo không quá 5 giây
- Dữ liệu báo cáo chính xác 100% so với dữ liệu gốc
