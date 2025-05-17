# HƯỚNG DẪN SỬ DỤNG CÁC CHỨC NĂNG CHÍNH

## Mục lục

1. [Quản lý thuốc](#1-quản-lý-thuốc)
2. [Quản lý kho](#2-quản-lý-kho)
3. [Quản lý đơn hàng](#3-quản-lý-đơn-hàng)
4. [Quản lý khuyến mãi](#4-quản-lý-khuyến-mãi)
5. [Quản lý người dùng](#5-quản-lý-người-dùng)
6. [Báo cáo và thống kê](#6-báo-cáo-và-thống-kê)
7. [Các chức năng khác](#7-các-chức-năng-khác)

## 1. Quản lý thuốc

### 1.1. Xem danh sách thuốc

**Mô tả**: Chức năng này cho phép xem danh sách tất cả các thuốc trong hệ thống, với các thông tin như tên thuốc, loại thuốc, nhà sản xuất, giá bán, tồn kho...

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Pharmacist
2. Truy cập menu "Thuốc" > "Danh sách thuốc"
3. Hệ thống hiển thị danh sách thuốc dưới dạng bảng
4. Sử dụng bộ lọc để tìm kiếm thuốc theo tên, loại, nhà sản xuất...
5. Nhấn vào tên thuốc để xem chi tiết

**Lưu ý**:
- Có thể sắp xếp danh sách theo các cột bằng cách nhấn vào tiêu đề cột
- Có thể phân trang danh sách nếu có nhiều thuốc
- Có thể xuất danh sách ra file Excel hoặc PDF

### 1.2. Thêm thuốc mới

**Mô tả**: Chức năng này cho phép thêm thuốc mới vào hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Pharmacist
2. Truy cập menu "Thuốc" > "Danh sách thuốc"
3. Nhấn nút "Thêm mới"
4. Điền đầy đủ thông tin thuốc:
   - Tên thuốc (bắt buộc)
   - Loại thuốc (bắt buộc)
   - Nhà sản xuất (bắt buộc)
   - Đơn vị tính (bắt buộc)
   - Giá nhập (bắt buộc)
   - Giá bán (bắt buộc)
   - Hạn sử dụng (bắt buộc)
   - Mô tả
   - Hình ảnh (nếu có)
   - Thành phần
   - Chỉ định
   - Chống chỉ định
   - Liều dùng
   - Tác dụng phụ
   - Lưu ý
5. Nhấn nút "Lưu" để hoàn tất

**Lưu ý**:
- Các trường bắt buộc phải được điền đầy đủ
- Giá bán phải lớn hơn giá nhập
- Hạn sử dụng phải lớn hơn ngày hiện tại
- Có thể tải lên nhiều hình ảnh cho một thuốc

### 1.3. Sửa thông tin thuốc

**Mô tả**: Chức năng này cho phép sửa thông tin của thuốc đã có trong hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Pharmacist
2. Truy cập menu "Thuốc" > "Danh sách thuốc"
3. Nhấn nút "Sửa" bên cạnh thuốc cần sửa
4. Cập nhật thông tin thuốc
5. Nhấn nút "Lưu" để hoàn tất

**Lưu ý**:
- Không thể sửa ID thuốc
- Các trường bắt buộc phải được điền đầy đủ
- Giá bán phải lớn hơn giá nhập
- Hạn sử dụng phải lớn hơn ngày hiện tại

### 1.4. Xóa thuốc

**Mô tả**: Chức năng này cho phép xóa thuốc khỏi hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin hoặc Manager
2. Truy cập menu "Thuốc" > "Danh sách thuốc"
3. Nhấn nút "Xóa" bên cạnh thuốc cần xóa
4. Xác nhận xóa trong hộp thoại hiện ra
5. Hệ thống xóa thuốc và hiển thị thông báo thành công

**Lưu ý**:
- Không thể xóa thuốc đã có trong đơn hàng, phiếu nhập hoặc khuyến mãi
- Chỉ Admin và Manager mới có quyền xóa thuốc
- Nên cân nhắc kỹ trước khi xóa thuốc

## 2. Quản lý kho

### 2.1. Xem tồn kho

**Mô tả**: Chức năng này cho phép xem tồn kho của tất cả các thuốc trong hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager, Pharmacist hoặc Cashier
2. Truy cập menu "Kho" > "Tồn kho"
3. Hệ thống hiển thị danh sách tồn kho dưới dạng bảng
4. Sử dụng bộ lọc để tìm kiếm thuốc trong kho

**Lưu ý**:
- Có thể sắp xếp danh sách theo các cột bằng cách nhấn vào tiêu đề cột
- Có thể phân trang danh sách nếu có nhiều thuốc
- Có thể xuất danh sách ra file Excel hoặc PDF
- Hệ thống sẽ hiển thị cảnh báo cho các thuốc sắp hết hàng hoặc sắp hết hạn

### 2.2. Nhập kho

**Mô tả**: Chức năng này cho phép tạo phiếu nhập kho để nhập thuốc vào kho.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Pharmacist
2. Truy cập menu "Kho" > "Phiếu nhập" > "Thêm mới"
3. Chọn nhà cung cấp từ danh sách hoặc tạo nhà cung cấp mới
4. Thêm thuốc vào phiếu nhập:
   - Chọn thuốc từ danh sách
   - Nhập số lượng
   - Nhập giá nhập
   - Nhập hạn sử dụng
   - Nhập số lô (nếu có)
5. Nhấn nút "Thêm" để thêm thuốc vào phiếu
6. Lặp lại bước 4-5 để thêm nhiều thuốc
7. Nhập ghi chú (nếu có)
8. Nhấn nút "Lưu" để hoàn tất phiếu nhập

**Lưu ý**:
- Phải chọn ít nhất một thuốc cho phiếu nhập
- Số lượng nhập phải là số dương
- Giá nhập phải là số dương
- Hạn sử dụng phải lớn hơn ngày hiện tại
- Hệ thống sẽ tự động cập nhật tồn kho sau khi lưu phiếu nhập

### 2.3. Xem lịch sử nhập kho

**Mô tả**: Chức năng này cho phép xem lịch sử nhập kho của tất cả các phiếu nhập.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Pharmacist
2. Truy cập menu "Kho" > "Phiếu nhập"
3. Hệ thống hiển thị danh sách phiếu nhập dưới dạng bảng
4. Sử dụng bộ lọc để tìm kiếm phiếu nhập theo ngày, nhà cung cấp...
5. Nhấn vào ID phiếu nhập để xem chi tiết

**Lưu ý**:
- Có thể sắp xếp danh sách theo các cột bằng cách nhấn vào tiêu đề cột
- Có thể phân trang danh sách nếu có nhiều phiếu nhập
- Có thể xuất danh sách ra file Excel hoặc PDF

## 3. Quản lý đơn hàng

### 3.1. Xem danh sách đơn hàng

**Mô tả**: Chức năng này cho phép xem danh sách tất cả các đơn hàng trong hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Cashier
2. Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
3. Hệ thống hiển thị danh sách đơn hàng dưới dạng bảng
4. Sử dụng bộ lọc để tìm kiếm đơn hàng theo ngày, trạng thái...
5. Nhấn vào ID đơn hàng để xem chi tiết

**Lưu ý**:
- Có thể sắp xếp danh sách theo các cột bằng cách nhấn vào tiêu đề cột
- Có thể phân trang danh sách nếu có nhiều đơn hàng
- Có thể xuất danh sách ra file Excel hoặc PDF

### 3.2. Tạo đơn hàng mới

**Mô tả**: Chức năng này cho phép tạo đơn hàng mới.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Cashier
2. Truy cập menu "Đơn hàng" > "Thêm mới"
3. Chọn khách hàng từ danh sách hoặc tạo khách hàng mới
4. Thêm thuốc vào đơn hàng:
   - Chọn thuốc từ danh sách
   - Nhập số lượng
   - Hệ thống sẽ tự động tính giá và áp dụng khuyến mãi (nếu có)
5. Nhấn nút "Thêm" để thêm thuốc vào đơn hàng
6. Lặp lại bước 4-5 để thêm nhiều thuốc
7. Chọn phương thức thanh toán
8. Nhập ghi chú (nếu có)
9. Nhấn nút "Lưu" để hoàn tất đơn hàng

**Lưu ý**:
- Phải chọn ít nhất một thuốc cho đơn hàng
- Số lượng đặt phải là số dương và không vượt quá số lượng tồn kho
- Hệ thống sẽ tự động cập nhật tồn kho sau khi lưu đơn hàng
- Hệ thống sẽ tự động áp dụng khuyến mãi nếu có

### 3.3. Cập nhật trạng thái đơn hàng

**Mô tả**: Chức năng này cho phép cập nhật trạng thái của đơn hàng.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Cashier
2. Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
3. Nhấn vào ID đơn hàng để xem chi tiết
4. Chọn trạng thái mới từ danh sách:
   - Đang xử lý
   - Đã xác nhận
   - Đang giao hàng
   - Đã giao hàng
   - Đã hủy
5. Nhập lý do (nếu cần)
6. Nhấn nút "Cập nhật" để lưu thay đổi

**Lưu ý**:
- Chỉ có thể cập nhật trạng thái theo thứ tự: Đang xử lý -> Đã xác nhận -> Đang giao hàng -> Đã giao hàng
- Có thể hủy đơn hàng ở bất kỳ trạng thái nào trước khi "Đã giao hàng"
- Khi hủy đơn hàng, hệ thống sẽ tự động cập nhật lại tồn kho

## 4. Quản lý khuyến mãi

### 4.1. Xem danh sách khuyến mãi

**Mô tả**: Chức năng này cho phép xem danh sách tất cả các chương trình khuyến mãi trong hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin hoặc Manager
2. Truy cập menu "Khuyến mãi" > "Danh sách khuyến mãi"
3. Hệ thống hiển thị danh sách khuyến mãi dưới dạng bảng
4. Sử dụng bộ lọc để tìm kiếm khuyến mãi theo tên, ngày...
5. Nhấn vào tên khuyến mãi để xem chi tiết

**Lưu ý**:
- Có thể sắp xếp danh sách theo các cột bằng cách nhấn vào tiêu đề cột
- Có thể phân trang danh sách nếu có nhiều khuyến mãi
- Có thể xuất danh sách ra file Excel hoặc PDF

### 4.2. Thêm khuyến mãi mới

**Mô tả**: Chức năng này cho phép thêm chương trình khuyến mãi mới vào hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin hoặc Manager
2. Truy cập menu "Khuyến mãi" > "Thêm mới"
3. Điền thông tin khuyến mãi:
   - Tên khuyến mãi (bắt buộc)
   - Mô tả
   - Ngày bắt đầu (bắt buộc)
   - Ngày kết thúc (bắt buộc)
   - Loại khuyến mãi (Giảm giá theo %, Giảm giá theo số tiền, Mua X tặng Y...)
4. Thêm thuốc vào chương trình khuyến mãi:
   - Chọn thuốc từ danh sách
   - Nhập mức giảm giá
5. Nhấn nút "Thêm" để thêm thuốc vào chương trình
6. Lặp lại bước 4-5 để thêm nhiều thuốc
7. Nhấn nút "Lưu" để hoàn tất chương trình khuyến mãi

**Lưu ý**:
- Các trường bắt buộc phải được điền đầy đủ
- Ngày kết thúc phải lớn hơn ngày bắt đầu
- Phải thêm ít nhất một thuốc vào chương trình khuyến mãi
- Mức giảm giá phải hợp lý (không vượt quá 100% nếu là giảm giá theo %)

## 5. Quản lý người dùng

### 5.1. Xem danh sách người dùng

**Mô tả**: Chức năng này cho phép xem danh sách tất cả người dùng trong hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin
2. Truy cập menu "Người dùng" > "Danh sách người dùng"
3. Hệ thống hiển thị danh sách người dùng dưới dạng bảng
4. Sử dụng bộ lọc để tìm kiếm người dùng theo tên, vai trò...
5. Nhấn vào tên người dùng để xem chi tiết

**Lưu ý**:
- Chỉ Admin mới có quyền xem danh sách người dùng
- Có thể sắp xếp danh sách theo các cột bằng cách nhấn vào tiêu đề cột
- Có thể phân trang danh sách nếu có nhiều người dùng
- Có thể xuất danh sách ra file Excel hoặc PDF

### 5.2. Thêm người dùng mới

**Mô tả**: Chức năng này cho phép thêm người dùng mới vào hệ thống.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin
2. Truy cập menu "Người dùng" > "Thêm mới"
3. Điền thông tin người dùng:
   - Tên đăng nhập (bắt buộc)
   - Mật khẩu (bắt buộc)
   - Họ tên (bắt buộc)
   - Email (bắt buộc)
   - Số điện thoại
   - Địa chỉ
   - Vai trò (Admin, Manager, Pharmacist, Cashier, Customer)
4. Nhấn nút "Lưu" để hoàn tất

**Lưu ý**:
- Các trường bắt buộc phải được điền đầy đủ
- Tên đăng nhập phải là duy nhất trong hệ thống
- Email phải là duy nhất trong hệ thống
- Mật khẩu phải đủ mạnh (ít nhất 6 ký tự)

## 6. Báo cáo và thống kê

### 6.1. Báo cáo doanh thu

**Mô tả**: Chức năng này cho phép xem báo cáo doanh thu theo thời gian.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin hoặc Manager
2. Truy cập menu "Báo cáo" > "Doanh thu"
3. Chọn khoảng thời gian (ngày, tuần, tháng, năm)
4. Nhấn nút "Xem báo cáo"
5. Hệ thống hiển thị báo cáo doanh thu dưới dạng biểu đồ và bảng
6. Có thể xuất báo cáo ra file Excel hoặc PDF

**Lưu ý**:
- Chỉ Admin và Manager mới có quyền xem báo cáo doanh thu
- Có thể lọc báo cáo theo nhiều tiêu chí khác nhau
- Có thể so sánh doanh thu giữa các khoảng thời gian

### 6.2. Báo cáo tồn kho

**Mô tả**: Chức năng này cho phép xem báo cáo tồn kho tại một thời điểm.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống với quyền Admin, Manager hoặc Pharmacist
2. Truy cập menu "Báo cáo" > "Tồn kho"
3. Chọn ngày báo cáo
4. Nhấn nút "Xem báo cáo"
5. Hệ thống hiển thị báo cáo tồn kho dưới dạng bảng
6. Có thể xuất báo cáo ra file Excel hoặc PDF

**Lưu ý**:
- Có thể lọc báo cáo theo nhiều tiêu chí khác nhau
- Báo cáo sẽ hiển thị cảnh báo cho các thuốc sắp hết hàng hoặc sắp hết hạn

## 7. Các chức năng khác

### 7.1. Quản lý thông tin cá nhân

**Mô tả**: Chức năng này cho phép người dùng xem và cập nhật thông tin cá nhân.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống
2. Nhấn vào biểu tượng người dùng ở góc trên bên phải
3. Chọn "Thông tin cá nhân"
4. Xem và cập nhật thông tin cá nhân
5. Nhấn nút "Lưu" để hoàn tất

**Lưu ý**:
- Không thể thay đổi tên đăng nhập
- Email phải là duy nhất trong hệ thống
- Có thể thay đổi ảnh đại diện

### 7.2. Đổi mật khẩu

**Mô tả**: Chức năng này cho phép người dùng đổi mật khẩu.

**Các bước thực hiện**:
1. Đăng nhập vào hệ thống
2. Nhấn vào biểu tượng người dùng ở góc trên bên phải
3. Chọn "Đổi mật khẩu"
4. Nhập mật khẩu cũ
5. Nhập mật khẩu mới
6. Xác nhận mật khẩu mới
7. Nhấn nút "Lưu" để hoàn tất

**Lưu ý**:
- Mật khẩu mới phải đủ mạnh (ít nhất 6 ký tự)
- Mật khẩu mới không được trùng với mật khẩu cũ
