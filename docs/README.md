# TÀI LIỆU HƯỚNG DẪN HỆ THỐNG QUẢN LÝ HIỆU THUỐC

## Giới thiệu

Đây là tài liệu hướng dẫn chi tiết về cách thiết lập, cài đặt, nhập dữ liệu mẫu, chạy ứng dụng và sử dụng các chức năng của hệ thống quản lý hiệu thuốc.

## Mục lục

1. [Hướng dẫn cài đặt](HUONG_DAN_CAI_DAT.md)
   - Yêu cầu hệ thống
   - Cài đặt và cấu hình cơ sở dữ liệu
   - Cài đặt và chạy Backend
   - Cài đặt và chạy Frontend
   - Xử lý sự cố thường gặp

2. [Hướng dẫn import dữ liệu mẫu](HUONG_DAN_IMPORT_DU_LIEU.md)
   - Chuẩn bị môi trường
   - Tạo dữ liệu mẫu (thư mục `generate-data`)
   - Import dữ liệu mẫu vào PostgreSQL
   - Kiểm tra dữ liệu đã import
   - Xử lý sự cố

3. [Hướng dẫn sử dụng](HUONG_DAN_SU_DUNG.md)
   - Các vai trò người dùng
   - Đăng nhập và đăng xuất
   - Quản lý thuốc
   - Quản lý kho
   - Quản lý đơn hàng
   - Quản lý khuyến mãi
   - Quản lý người dùng
   - Báo cáo và thống kê
   - Các chức năng khác

4. [Hướng dẫn chi tiết các chức năng](HUONG_DAN_CHUC_NANG.md)
   - Quản lý thuốc
   - Quản lý kho
   - Quản lý đơn hàng
   - Quản lý khuyến mãi
   - Quản lý người dùng
   - Báo cáo và thống kê
   - Các chức năng khác

## Tài khoản mặc định

Hệ thống có các tài khoản mặc định cho các vai trò khác nhau:

- **Admin** (Quản trị viên):
  - Tên đăng nhập: admin
  - Mật khẩu: 123123
  - Có toàn quyền trên hệ thống

- **Manager** (Quản lý):
  - Tên đăng nhập: manager
  - Mật khẩu: 123123
  - Có quyền quản lý hầu hết các chức năng

- **Pharmacist** (Dược sĩ):
  - Tên đăng nhập: pharmacist1
  - Mật khẩu: 123123
  - Có quyền quản lý thuốc, tư vấn

- **Cashier** (Thu ngân):
  - Tên đăng nhập: cashier1
  - Mật khẩu: 123123
  - Có quyền quản lý đơn hàng, bán hàng

- **Customer** (Khách hàng):
  - Tên đăng nhập: customer1
  - Mật khẩu: 123123
  - Có quyền xem thuốc, đặt hàng

## Liên hệ hỗ trợ

Nếu bạn gặp bất kỳ vấn đề nào trong quá trình cài đặt hoặc sử dụng hệ thống, vui lòng liên hệ với chúng tôi qua:

- Email: support@hieuthuoc.com
- Điện thoại: 0123 456 789
- Website: https://hieuthuoc.com/support
