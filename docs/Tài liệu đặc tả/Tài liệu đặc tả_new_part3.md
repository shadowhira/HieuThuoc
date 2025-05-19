## 3.5. Phân hệ quản lý người dùng

### 3.5.1. SREQ012 - Quản lý tài khoản

1. **Mô tả nghiệp vụ**

   Chức năng quản lý tài khoản cho phép quản trị viên quản lý các tài khoản người dùng trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép tạo tài khoản mới với các thông tin: tên đăng nhập, mật khẩu, họ tên, email, số điện thoại, địa chỉ, vai trò, trạng thái.
   - Hệ thống cho phép cập nhật thông tin tài khoản.
   - Hệ thống cho phép khóa/mở khóa tài khoản.
   - Hệ thống cho phép tìm kiếm tài khoản theo tên đăng nhập, họ tên, email.
   - Hệ thống hiển thị danh sách tài khoản với phân trang.
   - Hệ thống cho phép đặt lại mật khẩu cho tài khoản.
   - Hệ thống mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu.

### 3.5.2. SREQ013 - Quản lý phân quyền

1. **Mô tả nghiệp vụ**

   Chức năng quản lý phân quyền cho phép quản trị viên phân quyền cho các tài khoản người dùng trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép tạo vai trò mới với các thông tin: tên vai trò, mô tả, danh sách quyền.
   - Hệ thống cho phép cập nhật thông tin vai trò.
   - Hệ thống cho phép xóa vai trò.
   - Hệ thống cho phép tìm kiếm vai trò theo tên.
   - Hệ thống hiển thị danh sách vai trò với phân trang.
   - Hệ thống cho phép gán vai trò cho tài khoản.
   - Hệ thống kiểm tra quyền truy cập của người dùng khi thực hiện các chức năng.

### 3.5.3. SREQ014 - Quản lý khách hàng

1. **Mô tả nghiệp vụ**

   Chức năng quản lý khách hàng cho phép người dùng quản lý thông tin khách hàng trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép thêm mới khách hàng với các thông tin: mã khách hàng, họ tên, ngày sinh, giới tính, số điện thoại, email, địa chỉ, trạng thái.
   - Hệ thống cho phép cập nhật thông tin khách hàng.
   - Hệ thống cho phép xóa khách hàng (xóa logic).
   - Hệ thống cho phép tìm kiếm khách hàng theo tên, mã, số điện thoại, email.
   - Hệ thống hiển thị danh sách khách hàng với phân trang.
   - Hệ thống cho phép xem lịch sử mua hàng của khách hàng.

## 3.6. Phân hệ báo cáo và thống kê

### 3.6.1. SREQ015 - Báo cáo doanh thu

1. **Mô tả nghiệp vụ**

   Chức năng báo cáo doanh thu cho phép người dùng xem báo cáo doanh thu theo thời gian, sản phẩm, nhân viên.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép xem báo cáo doanh thu theo ngày, tuần, tháng, quý, năm.
   - Hệ thống cho phép xem báo cáo doanh thu theo sản phẩm.
   - Hệ thống cho phép xem báo cáo doanh thu theo nhân viên.
   - Hệ thống hiển thị biểu đồ doanh thu theo thời gian.
   - Hệ thống cho phép xuất báo cáo doanh thu ra file Excel, PDF.

### 3.6.2. SREQ016 - Báo cáo tồn kho

1. **Mô tả nghiệp vụ**

   Chức năng báo cáo tồn kho cho phép người dùng xem báo cáo tồn kho theo thời gian, sản phẩm, danh mục.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép xem báo cáo tồn kho theo thời gian.
   - Hệ thống cho phép xem báo cáo tồn kho theo sản phẩm.
   - Hệ thống cho phép xem báo cáo tồn kho theo danh mục.
   - Hệ thống hiển thị biểu đồ tồn kho theo thời gian.
   - Hệ thống cho phép xuất báo cáo tồn kho ra file Excel, PDF.

### 3.6.3. SREQ017 - Báo cáo lợi nhuận

1. **Mô tả nghiệp vụ**

   Chức năng báo cáo lợi nhuận cho phép người dùng xem báo cáo lợi nhuận theo thời gian, sản phẩm, danh mục.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép xem báo cáo lợi nhuận theo ngày, tuần, tháng, quý, năm.
   - Hệ thống cho phép xem báo cáo lợi nhuận theo sản phẩm.
   - Hệ thống cho phép xem báo cáo lợi nhuận theo danh mục.
   - Hệ thống hiển thị biểu đồ lợi nhuận theo thời gian.
   - Hệ thống cho phép xuất báo cáo lợi nhuận ra file Excel, PDF.

# 4. CÁC YÊU CẦU PHI CHỨC NĂNG

## 4.1. Yêu cầu bảo mật

Hệ thống đáp ứng các yêu cầu bảo mật sau:

- Mật khẩu người dùng phải được mã hóa trước khi lưu vào cơ sở dữ liệu.
- Hệ thống phải có cơ chế xác thực và phân quyền người dùng.
- Hệ thống phải có cơ chế bảo vệ thông tin cá nhân của khách hàng.
- Hệ thống phải có cơ chế bảo vệ thông tin thanh toán của khách hàng.
- Hệ thống phải có cơ chế bảo vệ dữ liệu khỏi các cuộc tấn công SQL Injection, XSS.
- Hệ thống phải có cơ chế ghi nhật ký hoạt động của người dùng.
- Hệ thống phải có cơ chế sao lưu và phục hồi dữ liệu.

## 4.2. Yêu cầu về tính sử dụng

Hệ thống đáp ứng các yêu cầu về tính sử dụng sau:

- Giao diện người dùng phải thân thiện, dễ sử dụng.
- Hệ thống phải có hướng dẫn sử dụng cho người dùng.
- Hệ thống phải có thông báo lỗi rõ ràng, dễ hiểu.
- Hệ thống phải có khả năng tùy chỉnh giao diện theo nhu cầu của người dùng.
- Hệ thống phải có khả năng hỗ trợ đa ngôn ngữ (tiếng Việt, tiếng Anh).
- Hệ thống phải có khả năng hỗ trợ người dùng khuyết tật.
- Thời gian đào tạo sử dụng hệ thống không quá 2 ngày cho người dùng bình thường và 5 ngày cho người quản trị hệ thống.

## 4.3. Yêu cầu về tính ổn định

Hệ thống đáp ứng các yêu cầu về tính ổn định sau:

- Hệ thống phải có khả năng hoạt động 24/7, với tỷ lệ sẵn sàng 99.9%.
- Thời gian trung bình giữa hai sự cố (MTBF) không dưới 720 giờ.
- Thời gian trung bình để sửa chữa (MTTR) không quá 4 giờ.
- Hệ thống phải có khả năng tự phục hồi sau sự cố.
- Hệ thống phải có cơ chế cảnh báo khi có sự cố xảy ra.
- Hệ thống phải có cơ chế giám sát hiệu suất hoạt động.
