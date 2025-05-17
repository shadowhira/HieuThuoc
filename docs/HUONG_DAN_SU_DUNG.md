# HƯỚNG DẪN SỬ DỤNG HỆ THỐNG QUẢN LÝ HIỆU THUỐC

## Mục lục

1. [Giới thiệu](#1-giới-thiệu)
2. [Các vai trò người dùng](#2-các-vai-trò-người-dùng)
3. [Đăng nhập và đăng xuất](#3-đăng-nhập-và-đăng-xuất)
4. [Quản lý thuốc](#4-quản-lý-thuốc)
5. [Quản lý kho](#5-quản-lý-kho)
6. [Quản lý đơn hàng](#6-quản-lý-đơn-hàng)
7. [Quản lý khuyến mãi](#7-quản-lý-khuyến-mãi)
8. [Quản lý người dùng](#8-quản-lý-người-dùng)
9. [Báo cáo và thống kê](#9-báo-cáo-và-thống-kê)
10. [Các chức năng khác](#10-các-chức-năng-khác)

## 1. Giới thiệu

Hệ thống quản lý hiệu thuốc là một ứng dụng toàn diện giúp quản lý hiệu quả các hoạt động của hiệu thuốc, bao gồm quản lý thuốc, kho, đơn hàng, khuyến mãi, người dùng và báo cáo thống kê.

## 2. Các vai trò người dùng

Hệ thống có 5 vai trò chính:

### 2.1. Admin (Quản trị viên)
- Có toàn quyền trên hệ thống
- Quản lý người dùng và phân quyền
- Xem tất cả các báo cáo và thống kê

### 2.2. Manager (Quản lý)
- Quản lý thuốc, kho, đơn hàng, khuyến mãi
- Xem báo cáo và thống kê
- Không có quyền quản lý người dùng và phân quyền

### 2.3. Pharmacist (Dược sĩ)
- Quản lý thuốc và thông tin thuốc
- Tư vấn thuốc cho khách hàng
- Xem tồn kho và báo cáo liên quan đến thuốc

### 2.4. Cashier (Thu ngân)
- Quản lý đơn hàng và bán hàng
- Xem thông tin thuốc và tồn kho
- Xem báo cáo doanh thu

### 2.5. Customer (Khách hàng)
- Xem thông tin thuốc
- Đặt hàng và thanh toán
- Xem lịch sử đơn hàng cá nhân

## 3. Đăng nhập và đăng xuất

### 3.1. Đăng nhập
1. Truy cập trang đăng nhập: http://localhost:4200/login
2. Nhập tên đăng nhập và mật khẩu
3. Nhấn nút "Đăng nhập"

### 3.2. Đăng xuất
1. Nhấn vào biểu tượng người dùng ở góc trên bên phải
2. Chọn "Đăng xuất"

## 4. Quản lý thuốc

### 4.1. Xem danh sách thuốc
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Sử dụng bộ lọc để tìm kiếm thuốc theo tên, loại, nhà sản xuất...

### 4.2. Thêm thuốc mới
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Thêm mới"
3. Điền đầy đủ thông tin thuốc:
   - Tên thuốc
   - Loại thuốc
   - Nhà sản xuất
   - Đơn vị tính
   - Giá nhập
   - Giá bán
   - Hạn sử dụng
   - Mô tả
   - Hình ảnh (nếu có)
4. Nhấn nút "Lưu"

### 4.3. Sửa thông tin thuốc
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Sửa" bên cạnh thuốc cần sửa
3. Cập nhật thông tin thuốc
4. Nhấn nút "Lưu"

### 4.4. Xóa thuốc
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Xóa" bên cạnh thuốc cần xóa
3. Xác nhận xóa

### 4.5. Quản lý loại thuốc
1. Truy cập menu "Thuốc" > "Loại thuốc"
2. Thêm, sửa, xóa loại thuốc tương tự như quản lý thuốc

### 4.6. Quản lý nhà sản xuất
1. Truy cập menu "Thuốc" > "Nhà sản xuất"
2. Thêm, sửa, xóa nhà sản xuất tương tự như quản lý thuốc

## 5. Quản lý kho

### 5.1. Xem tồn kho
1. Truy cập menu "Kho" > "Tồn kho"
2. Sử dụng bộ lọc để tìm kiếm thuốc trong kho

### 5.2. Nhập kho
1. Truy cập menu "Kho" > "Phiếu nhập" > "Thêm mới"
2. Chọn nhà cung cấp
3. Thêm thuốc vào phiếu nhập:
   - Chọn thuốc
   - Nhập số lượng
   - Nhập giá nhập
   - Nhập hạn sử dụng
4. Nhấn nút "Thêm" để thêm thuốc vào phiếu
5. Lặp lại bước 3-4 để thêm nhiều thuốc
6. Nhấn nút "Lưu" để hoàn tất phiếu nhập

### 5.3. Xem lịch sử nhập kho
1. Truy cập menu "Kho" > "Phiếu nhập"
2. Sử dụng bộ lọc để tìm kiếm phiếu nhập theo ngày, nhà cung cấp...
3. Nhấn vào ID phiếu nhập để xem chi tiết

### 5.4. Kiểm kê kho
1. Truy cập menu "Kho" > "Kiểm kê"
2. Chọn ngày kiểm kê
3. Nhập số lượng thực tế của từng thuốc
4. Nhấn nút "Lưu" để hoàn tất kiểm kê

## 6. Quản lý đơn hàng

### 6.1. Xem danh sách đơn hàng
1. Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
2. Sử dụng bộ lọc để tìm kiếm đơn hàng theo ngày, trạng thái...

### 6.2. Tạo đơn hàng mới
1. Truy cập menu "Đơn hàng" > "Thêm mới"
2. Chọn khách hàng (hoặc tạo khách hàng mới)
3. Thêm thuốc vào đơn hàng:
   - Chọn thuốc
   - Nhập số lượng
   - Hệ thống sẽ tự động tính giá
4. Nhấn nút "Thêm" để thêm thuốc vào đơn hàng
5. Lặp lại bước 3-4 để thêm nhiều thuốc
6. Chọn phương thức thanh toán
7. Nhấn nút "Lưu" để hoàn tất đơn hàng

### 6.3. Xem chi tiết đơn hàng
1. Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
2. Nhấn vào ID đơn hàng để xem chi tiết

### 6.4. Cập nhật trạng thái đơn hàng
1. Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
2. Nhấn vào ID đơn hàng để xem chi tiết
3. Chọn trạng thái mới (Đang xử lý, Đã xác nhận, Đang giao hàng, Đã giao hàng, Đã hủy)
4. Nhấn nút "Cập nhật" để lưu thay đổi

### 6.5. Hủy đơn hàng
1. Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
2. Nhấn vào ID đơn hàng để xem chi tiết
3. Chọn trạng thái "Đã hủy"
4. Nhập lý do hủy
5. Nhấn nút "Cập nhật" để lưu thay đổi

## 7. Quản lý khuyến mãi

### 7.1. Xem danh sách khuyến mãi
1. Truy cập menu "Khuyến mãi" > "Danh sách khuyến mãi"
2. Sử dụng bộ lọc để tìm kiếm khuyến mãi theo tên, ngày...

### 7.2. Thêm khuyến mãi mới
1. Truy cập menu "Khuyến mãi" > "Thêm mới"
2. Điền thông tin khuyến mãi:
   - Tên khuyến mãi
   - Mô tả
   - Ngày bắt đầu
   - Ngày kết thúc
   - Loại khuyến mãi (Giảm giá theo %, Giảm giá theo số tiền, Mua X tặng Y...)
3. Thêm thuốc vào chương trình khuyến mãi:
   - Chọn thuốc
   - Nhập mức giảm giá
4. Nhấn nút "Thêm" để thêm thuốc vào chương trình
5. Lặp lại bước 3-4 để thêm nhiều thuốc
6. Nhấn nút "Lưu" để hoàn tất chương trình khuyến mãi

### 7.3. Sửa thông tin khuyến mãi
1. Truy cập menu "Khuyến mãi" > "Danh sách khuyến mãi"
2. Nhấn nút "Sửa" bên cạnh khuyến mãi cần sửa
3. Cập nhật thông tin khuyến mãi
4. Nhấn nút "Lưu"

### 7.4. Xóa khuyến mãi
1. Truy cập menu "Khuyến mãi" > "Danh sách khuyến mãi"
2. Nhấn nút "Xóa" bên cạnh khuyến mãi cần xóa
3. Xác nhận xóa

## 8. Quản lý người dùng

### 8.1. Xem danh sách người dùng
1. Truy cập menu "Người dùng" > "Danh sách người dùng"
2. Sử dụng bộ lọc để tìm kiếm người dùng theo tên, vai trò...

### 8.2. Thêm người dùng mới
1. Truy cập menu "Người dùng" > "Thêm mới"
2. Điền thông tin người dùng:
   - Tên đăng nhập
   - Mật khẩu
   - Họ tên
   - Email
   - Số điện thoại
   - Địa chỉ
   - Vai trò (Admin, Manager, Pharmacist, Cashier, Customer)
3. Nhấn nút "Lưu"

### 8.3. Sửa thông tin người dùng
1. Truy cập menu "Người dùng" > "Danh sách người dùng"
2. Nhấn nút "Sửa" bên cạnh người dùng cần sửa
3. Cập nhật thông tin người dùng
4. Nhấn nút "Lưu"

### 8.4. Xóa người dùng
1. Truy cập menu "Người dùng" > "Danh sách người dùng"
2. Nhấn nút "Xóa" bên cạnh người dùng cần xóa
3. Xác nhận xóa

### 8.5. Phân quyền người dùng
1. Truy cập menu "Người dùng" > "Phân quyền"
2. Chọn người dùng cần phân quyền
3. Chọn vai trò cho người dùng
4. Nhấn nút "Lưu"

## 9. Báo cáo và thống kê

### 9.1. Báo cáo doanh thu
1. Truy cập menu "Báo cáo" > "Doanh thu"
2. Chọn khoảng thời gian (ngày, tuần, tháng, năm)
3. Nhấn nút "Xem báo cáo"
4. Xem biểu đồ và bảng doanh thu
5. Xuất báo cáo (PDF, Excel) nếu cần

### 9.2. Báo cáo tồn kho
1. Truy cập menu "Báo cáo" > "Tồn kho"
2. Chọn ngày báo cáo
3. Nhấn nút "Xem báo cáo"
4. Xem danh sách thuốc tồn kho
5. Xuất báo cáo (PDF, Excel) nếu cần

### 9.3. Báo cáo thuốc bán chạy
1. Truy cập menu "Báo cáo" > "Thuốc bán chạy"
2. Chọn khoảng thời gian (ngày, tuần, tháng, năm)
3. Nhấn nút "Xem báo cáo"
4. Xem biểu đồ và bảng thuốc bán chạy
5. Xuất báo cáo (PDF, Excel) nếu cần

### 9.4. Báo cáo thuốc sắp hết hạn
1. Truy cập menu "Báo cáo" > "Thuốc sắp hết hạn"
2. Chọn khoảng thời gian (1 tháng, 3 tháng, 6 tháng)
3. Nhấn nút "Xem báo cáo"
4. Xem danh sách thuốc sắp hết hạn
5. Xuất báo cáo (PDF, Excel) nếu cần

## 10. Các chức năng khác

### 10.1. Quản lý thông tin cá nhân
1. Nhấn vào biểu tượng người dùng ở góc trên bên phải
2. Chọn "Thông tin cá nhân"
3. Cập nhật thông tin cá nhân
4. Nhấn nút "Lưu"

### 10.2. Đổi mật khẩu
1. Nhấn vào biểu tượng người dùng ở góc trên bên phải
2. Chọn "Đổi mật khẩu"
3. Nhập mật khẩu cũ
4. Nhập mật khẩu mới
5. Xác nhận mật khẩu mới
6. Nhấn nút "Lưu"

### 10.3. Thông báo
1. Nhấn vào biểu tượng thông báo ở góc trên bên phải
2. Xem danh sách thông báo
3. Nhấn vào thông báo để xem chi tiết

### 10.4. Tìm kiếm
1. Nhập từ khóa vào ô tìm kiếm ở thanh điều hướng
2. Nhấn Enter hoặc nhấn biểu tượng tìm kiếm
3. Xem kết quả tìm kiếm
