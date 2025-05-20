# Kế hoạch kiểm thử chức năng - Quản lý thuốc

## 1. Giới thiệu

Tài liệu này trình bày kế hoạch kiểm thử chức năng (Functional Testing) cho module Quản lý thuốc của hệ thống Hiệu thuốc. Kiểm thử chức năng là giai đoạn 4 trong quy trình kiểm thử tổng thể, tập trung vào việc kiểm tra các chức năng của hệ thống có hoạt động đúng theo yêu cầu hay không.

## 2. Phạm vi kiểm thử

### 2.1. Các chức năng cần kiểm thử

1. **Thêm thuốc mới**
   - Thêm thuốc với dữ liệu hợp lệ
   - Kiểm tra xử lý lỗi khi thêm thuốc với mã trùng
   - Kiểm tra xử lý lỗi khi thêm thuốc với dữ liệu không hợp lệ (giá trị âm)

2. **Xóa thuốc**
   - Xóa thuốc thành công
   - Hủy xóa thuốc
   - Xóa thuốc đã có trong đơn hàng

3. **Tìm kiếm thuốc**
   - Tìm kiếm thuốc theo tên
   - Tìm kiếm thuốc theo loại thuốc
   - Tìm kiếm thuốc theo khoảng giá
   - Tìm kiếm thuốc không có kết quả
   - Tìm kiếm thuốc với nhiều tiêu chí

4. **Cập nhật thuốc**
   - Cập nhật thuốc với dữ liệu hợp lệ
   - Kiểm tra xử lý lỗi khi cập nhật thuốc với dữ liệu không hợp lệ
   - Cập nhật trạng thái thuốc
   - Hủy cập nhật thuốc

### 2.2. Các chức năng không nằm trong phạm vi kiểm thử

- Quản lý loại thuốc
- Quản lý nhà sản xuất
- Quản lý đơn hàng
- Quản lý người dùng

## 3. Chiến lược kiểm thử

### 3.1. Kiểm thử giao diện người dùng (UI Testing)

Sử dụng Cypress để kiểm thử giao diện người dùng và tương tác giữa frontend và backend:

- Mô phỏng hành vi người dùng thực tế
- Kiểm tra luồng làm việc end-to-end
- Chụp ảnh và quay video quá trình kiểm thử

### 3.2. Kiểm thử API (API Testing)

Sử dụng Postman để kiểm thử API:

- Kiểm tra các endpoint API của module Quản lý thuốc
- Xác minh dữ liệu trả về từ API
- Kiểm tra xử lý lỗi của API

## 4. Môi trường kiểm thử

### 4.1. Phần cứng

- Máy tính có cấu hình đủ để chạy các công cụ kiểm thử

### 4.2. Phần mềm

- Hệ điều hành: macOS hoặc Windows
- Trình duyệt: Chrome, Firefox, Edge
- Công cụ kiểm thử: Cypress, Postman
- Cơ sở dữ liệu: PostgreSQL

### 4.3. Dữ liệu kiểm thử

- Dữ liệu mẫu cho thuốc, loại thuốc, nhà sản xuất
- Dữ liệu đặc biệt cho các trường hợp biên và xử lý lỗi

## 5. Kế hoạch thực hiện

### 5.1. Lịch trình

| Giai đoạn | Hoạt động | Thời gian |
|-----------|-----------|-----------|
| 1 | Chuẩn bị môi trường và dữ liệu kiểm thử | 1 ngày |
| 2 | Phát triển test case Cypress | 2 ngày |
| 3 | Phát triển test case Postman | 1 ngày |
| 4 | Thực hiện kiểm thử | 1 ngày |
| 5 | Phân tích kết quả và báo cáo | 1 ngày |
| **Tổng cộng** | | **6 ngày** |

### 5.2. Vai trò và trách nhiệm

| Vai trò | Trách nhiệm |
|---------|-------------|
| Test Manager | Quản lý quá trình kiểm thử, phân công nhiệm vụ |
| Test Developer | Phát triển test case Cypress và Postman |
| Tester | Thực hiện kiểm thử, ghi nhận kết quả |
| Developer | Hỗ trợ kỹ thuật, sửa lỗi nếu cần |

## 6. Test case

### 6.1. Thêm thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|----------------------|-------------------|-----------------|
| TC-C-01 | Thêm thuốc thành công với dữ liệu hợp lệ | Kiểm tra việc thêm thuốc mới với dữ liệu hợp lệ | Đã đăng nhập với quyền admin | 1. Truy cập trang danh sách thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập thông tin thuốc hợp lệ<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo thành công<br>2. Thuốc mới được thêm vào danh sách |
| TC-C-02 | Không thể thêm thuốc với mã trùng | Kiểm tra xử lý lỗi khi thêm thuốc với mã đã tồn tại | Đã đăng nhập với quyền admin<br>Đã có thuốc với mã "PARA500" | 1. Truy cập trang danh sách thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập thông tin thuốc với mã "PARA500"<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi<br>2. Không thêm thuốc vào danh sách |
| TC-C-03 | Không thể thêm thuốc với giá trị âm | Kiểm tra xử lý lỗi khi thêm thuốc với giá trị âm | Đã đăng nhập với quyền admin | 1. Truy cập trang danh sách thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập thông tin thuốc với giá trị âm<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi<br>2. Không thêm thuốc vào danh sách |

### 6.2. Xóa thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|----------------------|-------------------|-----------------|
| TC-D-01 | Xóa thuốc thành công | Kiểm tra việc xóa thuốc khỏi hệ thống | Đã đăng nhập với quyền admin<br>Đã có thuốc trong danh sách | 1. Truy cập trang danh sách thuốc<br>2. Tìm kiếm thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo thành công<br>2. Thuốc bị xóa khỏi danh sách |
| TC-D-02 | Hủy xóa thuốc | Kiểm tra việc hủy xóa thuốc | Đã đăng nhập với quyền admin<br>Đã có thuốc trong danh sách | 1. Truy cập trang danh sách thuốc<br>2. Tìm kiếm thuốc<br>3. Nhấn nút "Xóa"<br>4. Hủy xác nhận xóa | 1. Không hiển thị thông báo<br>2. Thuốc vẫn còn trong danh sách |
| TC-D-03 | Xóa thuốc đã có trong đơn hàng | Kiểm tra xử lý khi xóa thuốc đã có trong đơn hàng | Đã đăng nhập với quyền admin<br>Đã có thuốc trong đơn hàng | 1. Truy cập trang danh sách thuốc<br>2. Tìm kiếm thuốc đã có trong đơn hàng<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo lỗi hoặc cảnh báo<br>2. Thuốc vẫn còn trong danh sách |

### 6.3. Tìm kiếm thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|----------------------|-------------------|-----------------|
| TC-S-01 | Tìm kiếm thuốc theo tên thành công | Kiểm tra việc tìm kiếm thuốc theo tên | Đã đăng nhập với quyền admin<br>Đã có thuốc "Paracetamol" trong danh sách | 1. Truy cập trang danh sách thuốc<br>2. Nhập "Paracetamol" vào ô tìm kiếm<br>3. Nhấn nút "Tìm" | 1. Hiển thị danh sách thuốc có tên chứa "Paracetamol" |
| TC-S-04 | Tìm kiếm thuốc không có kết quả | Kiểm tra xử lý khi không có kết quả tìm kiếm | Đã đăng nhập với quyền admin | 1. Truy cập trang danh sách thuốc<br>2. Nhập "Thuốc không tồn tại xyz123" vào ô tìm kiếm<br>3. Nhấn nút "Tìm" | 1. Hiển thị thông báo không tìm thấy kết quả |

### 6.4. Cập nhật thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|----------------------|-------------------|-----------------|
| TC-U-01 | Cập nhật thuốc thành công với dữ liệu hợp lệ | Kiểm tra việc cập nhật thông tin thuốc với dữ liệu hợp lệ | Đã đăng nhập với quyền admin<br>Đã có thuốc trong danh sách | 1. Truy cập trang danh sách thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin thuốc<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo thành công<br>2. Thông tin thuốc được cập nhật |
| TC-U-02 | Không thể cập nhật thuốc với dữ liệu không hợp lệ | Kiểm tra xử lý lỗi khi cập nhật thuốc với dữ liệu không hợp lệ | Đã đăng nhập với quyền admin<br>Đã có thuốc trong danh sách | 1. Truy cập trang danh sách thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin thuốc với giá trị âm<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi<br>2. Thông tin thuốc không được cập nhật |
| TC-U-04 | Hủy cập nhật thuốc | Kiểm tra việc hủy cập nhật thông tin thuốc | Đã đăng nhập với quyền admin<br>Đã có thuốc trong danh sách | 1. Truy cập trang danh sách thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin thuốc<br>5. Nhấn nút "Hủy" | 1. Quay về trang danh sách thuốc<br>2. Thông tin thuốc không thay đổi |

## 7. Tiêu chí đánh giá

- Tất cả các test case phải được thực hiện
- Tỷ lệ test case pass phải đạt ít nhất 90%
- Các lỗi nghiêm trọng phải được sửa trước khi kết thúc giai đoạn kiểm thử

## 8. Báo cáo và tài liệu

- Kế hoạch kiểm thử chức năng
- Báo cáo kết quả kiểm thử Cypress
- Báo cáo kết quả kiểm thử Postman
- Báo cáo tổng quan kiểm thử chức năng

## 9. Rủi ro và giảm thiểu

| Rủi ro | Mức độ ảnh hưởng | Khả năng xảy ra | Biện pháp giảm thiểu |
|--------|-----------------|----------------|---------------------|
| Thay đổi giao diện người dùng | Cao | Trung bình | Sử dụng các selector ổn định, ít phụ thuộc vào cấu trúc DOM |
| Thay đổi API | Cao | Thấp | Kiểm tra tài liệu API trước khi phát triển test case |
| Môi trường kiểm thử không ổn định | Trung bình | Trung bình | Chuẩn bị môi trường kiểm thử độc lập |
| Thiếu dữ liệu kiểm thử | Trung bình | Thấp | Chuẩn bị dữ liệu kiểm thử trước khi bắt đầu |

## 10. Phụ lục

### 10.1. Tài liệu tham khảo

- Tài liệu yêu cầu hệ thống
- Tài liệu thiết kế hệ thống
- Tài liệu API

### 10.2. Công cụ và tài nguyên

- Cypress: [https://www.cypress.io/](https://www.cypress.io/)
- Postman: [https://www.postman.com/](https://www.postman.com/)
