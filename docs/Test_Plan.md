# KẾ HOẠCH KIỂM THỬ HỆ THỐNG HIỆU THUỐC

|||
| :- | - |

# HỆ THỐNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC

***Tài liệu kế hoạch kiểm thử phần mềm***

|**Mã dự án**|**PHARMACY-MANAGEMENT**|
| :-: | :- |
|**Mã tài liệu**|**TEST-PLAN_v1.0**|
|**Ngày**|**15/07/2024**|

**Hà Nội, tháng 7 năm 2024**

**NỘI DUNG SỬA ĐỔI**

\*M- Mới S – Sửa X - Xóa

|**Ngày**|**Mục sửa đổi**|**M\*<br>S, X**|**Nội dung sửa đổi**|**Người sửa đổi**|**Lần sửa đổi**|
| :-: | :-: | :-: | :-: | :-: | :-: |
|15/07/2024|Toàn bộ tài liệu|M|Tạo mới tài liệu|Nhóm SQA|1|

**TRANG KÝ**

**NGƯỜI LẬP:**		Nhóm SQA		           	15/07/2024

**NGƯỜI KIỂM TRA:**	Giảng viên		           	15/07/2024

**NGƯỜI PHÊ DUYỆT:**	Giảng viên		           	15/07/2024

# MỤC LỤC

[1. GIỚI THIỆU](#1-giới-thiệu)
  - [1.1 Mục đích](#11-mục-đích)
  - [1.2 Phạm vi](#12-phạm-vi)
  - [1.3 Tài liệu tham khảo](#13-tài-liệu-tham-khảo)
  - [1.4 Từ và thuật ngữ](#14-từ-và-thuật-ngữ)

[2. NỘI DUNG](#2-nội-dung)
  - [2.1 Yêu cầu kiểm thử](#21-yêu-cầu-kiểm-thử)
  - [2.2 Tiêu chí chấp nhận](#22-tiêu-chí-chấp-nhận)
  - [2.3 Chiến lược kiểm thử](#23-chiến-lược-kiểm-thử)
  - [2.4 Nguồn lực và tài nguyên hệ thống](#24-nguồn-lực-và-tài-nguyên-hệ-thống)
  - [2.5 Kế hoạch và tiến độ thực hiện](#25-kế-hoạch-và-tiến-độ-thực-hiện)
  - [2.6 Các tài liệu, báo cáo kiểm thử cần có](#26-các-tài-liệu-báo-cáo-kiểm-thử-cần-có)

[3. REVIEW CÁC CHIẾN LƯỢC KIỂM THỬ](#3-review-các-chiến-lược-kiểm-thử)
  - [3.1 Chiến lược kiểm thử đơn vị (Unit Testing)](#31-chiến-lược-kiểm-thử-đơn-vị-unit-testing)
  - [3.2 Chiến lược kiểm thử tích hợp (Integration Testing)](#32-chiến-lược-kiểm-thử-tích-hợp-integration-testing)
  - [3.3 Chiến lược kiểm thử hệ thống (System Testing)](#33-chiến-lược-kiểm-thử-hệ-thống-system-testing)

[4. CÁC LƯU Ý KHÁC](#4-các-lưu-ý-khác)

# 1. GIỚI THIỆU

## 1.1 Mục đích

- Tài liệu này được xây dựng nhằm mục đích phân tích và lập kế hoạch kiểm thử cho dự án "Hệ thống web bán và quản lý hiệu thuốc".
- Tài liệu này được dùng làm cơ sở để thực hiện các hoạt động kiểm thử, đánh giá chất lượng và đảm bảo hệ thống đáp ứng các yêu cầu đã đề ra.
- Tài liệu cũng là cơ sở để các bên liên quan hiểu rõ về quy trình kiểm thử, phạm vi và các kỳ vọng về chất lượng của hệ thống.

## 1.2 Phạm vi

Tài liệu đặc tả kế hoạch kiểm thử cho hệ thống web bán và quản lý hiệu thuốc. Phạm vi kiểm thử bao gồm toàn bộ hệ thống với 5 chức năng chính và các loại kiểm thử áp dụng cho từng chức năng.

### 1.2.1 Kiến trúc hệ thống

Hệ thống gồm 2 phân hệ chính:
- **Phân hệ Frontend**: Giao diện người dùng cho khách hàng và nhân viên quản lý, phát triển bằng Angular 13
- **Phân hệ Backend**: Xử lý nghiệp vụ và quản lý dữ liệu, phát triển bằng Spring Boot 2.6.7 và Java 11
- **Cơ sở dữ liệu**: PostgreSQL 14

### 1.2.2 Chức năng quản lý thuốc

**Mô tả**: Chức năng quản lý thông tin thuốc, loại thuốc và danh mục thuốc.

**Phân hệ con**:
- Quản lý thuốc: Thêm, sửa, xóa, tìm kiếm thuốc
- Quản lý loại thuốc: Thêm, sửa, xóa, tìm kiếm loại thuốc
- Quản lý danh mục thuốc: Thêm, sửa, xóa, tìm kiếm danh mục thuốc
- Quản lý thông tin chi tiết thuốc: Thành phần, công dụng, chỉ định, chống chỉ định

**Loại kiểm thử áp dụng**:
- Kiểm thử đơn vị: ThuocService, ThuocController, ThuocRepository, LoaiThuocService, DanhMucThuocService
- Kiểm thử tích hợp: Tích hợp giữa các service, controller và repository
- Kiểm thử chức năng: Các chức năng thêm, sửa, xóa, tìm kiếm
- Kiểm thử giao diện: Giao diện danh sách, thêm/sửa, chi tiết, tìm kiếm
- Kiểm thử hệ thống: Luồng nghiệp vụ quản lý thuốc
- Kiểm thử hộp đen và hộp trắng: Phân tích giá trị biên, phân vùng tương đương, bảng quyết định, phân tích đường dẫn

### 1.2.3 Chức năng quản lý nhập kho và tồn kho

**Mô tả**: Chức năng quản lý nhập kho, tồn kho và nhà cung cấp.

**Phân hệ con**:
- Quản lý phiếu nhập: Tạo phiếu nhập, cập nhật, hủy phiếu nhập
- Quản lý tồn kho: Cập nhật tồn kho, kiểm tra tồn kho, cảnh báo hết hàng
- Quản lý nhà cung cấp: Thêm, sửa, xóa, tìm kiếm nhà cung cấp
- Quản lý hạn sử dụng: Cảnh báo thuốc sắp hết hạn

**Loại kiểm thử áp dụng**:
- Kiểm thử đơn vị: PhieuNhapService, TonKhoService, NhaCungCapService
- Kiểm thử tích hợp: Tích hợp giữa PhieuNhapService và TonKhoService
- Kiểm thử chức năng: Các chức năng tạo phiếu nhập, quản lý tồn kho, cảnh báo hết hàng
- Kiểm thử giao diện: Giao diện phiếu nhập, tồn kho
- Kiểm thử hệ thống: Luồng nghiệp vụ nhập kho
- Kiểm thử hộp đen và hộp trắng: Phân tích giá trị biên, phân vùng tương đương, bảng quyết định, phân tích đường dẫn

### 1.2.4 Chức năng quản lý đơn hàng và giỏ hàng

**Mô tả**: Chức năng quản lý đơn hàng, giỏ hàng và thanh toán.

**Phân hệ con**:
- Quản lý đơn hàng: Tạo đơn hàng, cập nhật trạng thái, hủy đơn hàng
- Quản lý giỏ hàng: Thêm vào giỏ hàng, xóa khỏi giỏ hàng
- Quản lý thanh toán: Xử lý thanh toán
- Quản lý chi tiết đơn hàng: Thêm, sửa, xóa chi tiết đơn hàng

**Loại kiểm thử áp dụng**:
- Kiểm thử đơn vị: DonHangService, GioHangService, ThanhToanService
- Kiểm thử tích hợp: Tích hợp giữa DonHangService, GioHangService và TonKhoService
- Kiểm thử chức năng: Các chức năng tạo đơn hàng, cập nhật trạng thái, thanh toán
- Kiểm thử giao diện: Giao diện đơn hàng, giỏ hàng
- Kiểm thử hệ thống: Luồng nghiệp vụ đặt hàng
- Kiểm thử hộp đen và hộp trắng: Phân tích giá trị biên, phân vùng tương đương, bảng quyết định, phân tích đường dẫn

### 1.2.5 Chức năng quản lý người dùng và phân quyền

**Mô tả**: Chức năng quản lý người dùng, phân quyền và xác thực.

**Phân hệ con**:
- Quản lý người dùng: Đăng ký, cập nhật thông tin, xóa người dùng
- Quản lý phân quyền: Phân quyền cho người dùng
- Quản lý xác thực: Đăng nhập, đăng xuất, quên mật khẩu
- Quản lý thông tin cá nhân: Xem, cập nhật thông tin cá nhân

**Loại kiểm thử áp dụng**:
- Kiểm thử đơn vị: NguoiDungService, NhomQuyenService, DangNhapService
- Kiểm thử tích hợp: Tích hợp giữa NguoiDungService và NhomQuyenService
- Kiểm thử chức năng: Các chức năng đăng ký, đăng nhập, quản lý thông tin người dùng, phân quyền
- Kiểm thử giao diện: Giao diện đăng nhập, đăng ký, quản lý người dùng
- Kiểm thử bảo mật: Xác thực và phân quyền, bảo mật mật khẩu
- Kiểm thử hộp đen và hộp trắng: Phân tích giá trị biên, phân vùng tương đương, bảng quyết định, phân tích đường dẫn

### 1.2.6 Chức năng quản lý khuyến mãi, đánh giá và báo cáo

**Mô tả**: Chức năng quản lý khuyến mãi, đánh giá thuốc, tương tác thuốc và báo cáo thống kê.

**Phân hệ con**:
- Quản lý khuyến mãi: Tạo khuyến mãi, cập nhật, hủy khuyến mãi
- Quản lý đánh giá: Thêm, sửa, xóa đánh giá
- Quản lý tương tác thuốc: Kiểm tra tương tác thuốc
- Quản lý báo cáo thống kê: Tạo báo cáo thống kê

**Loại kiểm thử áp dụng**:
- Kiểm thử đơn vị: KhuyenMaiService, DanhGiaService, TuongTacThuocService, BaoCaoService
- Kiểm thử tích hợp: Tích hợp giữa KhuyenMaiService và DonHangService
- Kiểm thử chức năng: Các chức năng tạo khuyến mãi, đánh giá thuốc, kiểm tra tương tác thuốc, báo cáo thống kê
- Kiểm thử giao diện: Giao diện khuyến mãi, đánh giá, báo cáo
- Kiểm thử hệ thống: Luồng nghiệp vụ khuyến mãi
- Kiểm thử hộp đen và hộp trắng: Phân tích giá trị biên, phân vùng tương đương, bảng quyết định, phân tích đường dẫn

## 1.4 Từ và thuật ngữ

|**STT**|**Nội dung**|**Ý nghĩa**|
| - | - | - |
|1|SQA|Software Quality Assurance - Đảm bảo chất lượng phần mềm|
|2|UI|User Interface - Giao diện người dùng|
|3|API|Application Programming Interface - Giao diện lập trình ứng dụng|
|4|CRUD|Create, Read, Update, Delete - Các thao tác cơ bản với dữ liệu|
|5|TC|Test Case - Trường hợp kiểm thử|
|6|BE|Backend - Phần xử lý phía máy chủ|
|7|FE|Frontend - Phần giao diện người dùng|

## 1.3 Tài liệu tham khảo

|**STT**|**Tên tài liệu**|
| - | - |
|1|Tài liệu thiết kế hệ thống web bán và quản lý hiệu thuốc|
|2|Tài liệu đặc tả yêu cầu phần mềm|
|3|Yêu cầu bài tập nhóm - Kiểm định|



# 2. NỘI DUNG

## 2.1 Yêu cầu kiểm thử

Dựa trên tài liệu thiết kế hệ thống hiệu thuốc, các yêu cầu kiểm thử được phân chia theo từng phân hệ chức năng chính:

### 2.1.1 Phân hệ quản lý thuốc

1. **Kiểm thử đơn vị**:
   - Kiểm thử ThuocService: thêm, sửa, xóa, tìm kiếm thuốc
   - Kiểm thử ThuocController: xử lý request, response, validation
   - Kiểm thử ThuocRepository: truy vấn cơ sở dữ liệu
   - Kiểm thử LoaiThuocService và DanhMucThuocService
   - **Tiêu chí đánh giá**: Độ bao phủ mã nguồn > 90%, xử lý đúng các trường hợp ngoại lệ

2. **Kiểm thử tích hợp**:
   - Kiểm thử tích hợp giữa các service
   - Kiểm thử tích hợp giữa controller và service
   - Kiểm thử tích hợp với cơ sở dữ liệu
   - Kiểm thử tích hợp API
   - **Tiêu chí đánh giá**: Các thành phần tích hợp đúng, không có lỗi StackOverflowError, xử lý đúng multipart/form-data

3. **Kiểm thử chức năng**:
   - Kiểm thử chức năng thêm, sửa, xóa thuốc
   - Kiểm thử chức năng tìm kiếm nâng cao
   - Kiểm thử chức năng quản lý loại thuốc và danh mục thuốc
   - **Tiêu chí đánh giá**: Các chức năng hoạt động đúng theo yêu cầu, xử lý đúng các trường hợp đặc biệt

4. **Kiểm thử giao diện**:
   - Kiểm thử giao diện danh sách thuốc
   - Kiểm thử giao diện thêm/sửa thuốc
   - Kiểm thử giao diện chi tiết thuốc
   - Kiểm thử responsive
   - **Tiêu chí đánh giá**: Giao diện hiển thị đúng, responsive trên các thiết bị khác nhau

5. **Kiểm thử hệ thống**:
   - Kiểm thử luồng nghiệp vụ quản lý thuốc
   - Kiểm thử hiệu năng API quản lý thuốc
   - **Tiêu chí đánh giá**: Thời gian phản hồi < 3 giây, luồng nghiệp vụ hoạt động đúng

### 2.1.2 Phân hệ quản lý nhập kho và tồn kho

1. **Kiểm thử đơn vị**:
   - Kiểm thử PhieuNhapService: tạo phiếu nhập, cập nhật, hủy phiếu nhập
   - Kiểm thử TonKhoService: cập nhật tồn kho, kiểm tra tồn kho
   - Kiểm thử NhaCungCapService: thêm, sửa, xóa nhà cung cấp
   - **Tiêu chí đánh giá**: Độ bao phủ mã nguồn > 90%, xử lý đúng các trường hợp ngoại lệ

2. **Kiểm thử tích hợp**:
   - Kiểm thử tích hợp giữa PhieuNhapService và TonKhoService
   - Kiểm thử tích hợp với cơ sở dữ liệu
   - Kiểm thử tích hợp API
   - **Tiêu chí đánh giá**: Cập nhật tồn kho đúng sau khi nhập kho, xử lý đúng các trường hợp đặc biệt

3. **Kiểm thử chức năng**:
   - Kiểm thử chức năng tạo phiếu nhập
   - Kiểm thử chức năng quản lý tồn kho
   - Kiểm thử chức năng cảnh báo hết hàng
   - **Tiêu chí đánh giá**: Các chức năng hoạt động đúng theo yêu cầu, cảnh báo hết hàng chính xác

4. **Kiểm thử giao diện**:
   - Kiểm thử giao diện phiếu nhập
   - Kiểm thử giao diện tồn kho
   - **Tiêu chí đánh giá**: Giao diện hiển thị đúng, dễ sử dụng

5. **Kiểm thử hệ thống**:
   - Kiểm thử luồng nghiệp vụ nhập kho
   - Kiểm thử hiệu năng API quản lý kho
   - **Tiêu chí đánh giá**: Thời gian phản hồi < 3 giây, luồng nghiệp vụ hoạt động đúng

### 2.1.3 Phân hệ quản lý đơn hàng và giỏ hàng

1. **Kiểm thử đơn vị**:
   - Kiểm thử DonHangService: tạo đơn hàng, cập nhật trạng thái, hủy đơn hàng
   - Kiểm thử GioHangService: thêm vào giỏ hàng, xóa khỏi giỏ hàng
   - Kiểm thử ThanhToanService: xử lý thanh toán
   - **Tiêu chí đánh giá**: Độ bao phủ mã nguồn > 90%, xử lý đúng các trường hợp ngoại lệ

2. **Kiểm thử tích hợp**:
   - Kiểm thử tích hợp giữa DonHangService, GioHangService và TonKhoService
   - Kiểm thử tích hợp với cơ sở dữ liệu
   - Kiểm thử tích hợp API
   - **Tiêu chí đánh giá**: Cập nhật tồn kho đúng sau khi đặt hàng, xử lý đúng các trường hợp đặc biệt

3. **Kiểm thử chức năng**:
   - Kiểm thử chức năng tạo đơn hàng
   - Kiểm thử chức năng cập nhật trạng thái đơn hàng
   - Kiểm thử chức năng thanh toán
   - **Tiêu chí đánh giá**: Các chức năng hoạt động đúng theo yêu cầu, xử lý đúng các trường hợp đặc biệt

4. **Kiểm thử giao diện**:
   - Kiểm thử giao diện đơn hàng
   - Kiểm thử giao diện giỏ hàng
   - **Tiêu chí đánh giá**: Giao diện hiển thị đúng, dễ sử dụng

5. **Kiểm thử hệ thống**:
   - Kiểm thử luồng nghiệp vụ đặt hàng
   - Kiểm thử hiệu năng API đơn hàng
   - **Tiêu chí đánh giá**: Thời gian phản hồi < 3 giây, luồng nghiệp vụ hoạt động đúng

### 2.1.4 Phân hệ quản lý người dùng và phân quyền

1. **Kiểm thử đơn vị**:
   - Kiểm thử NguoiDungService: đăng ký, cập nhật thông tin, xóa người dùng
   - Kiểm thử NhomQuyenService: phân quyền
   - Kiểm thử DangNhapService: xác thực người dùng
   - **Tiêu chí đánh giá**: Độ bao phủ mã nguồn > 90%, xử lý đúng các trường hợp ngoại lệ

2. **Kiểm thử tích hợp**:
   - Kiểm thử tích hợp giữa NguoiDungService và NhomQuyenService
   - Kiểm thử tích hợp với cơ sở dữ liệu
   - Kiểm thử tích hợp API
   - **Tiêu chí đánh giá**: Xác thực và phân quyền hoạt động đúng, bảo mật thông tin người dùng

3. **Kiểm thử chức năng**:
   - Kiểm thử chức năng đăng ký, đăng nhập
   - Kiểm thử chức năng quản lý thông tin người dùng
   - Kiểm thử chức năng phân quyền
   - **Tiêu chí đánh giá**: Các chức năng hoạt động đúng theo yêu cầu, xử lý đúng các trường hợp đặc biệt

4. **Kiểm thử giao diện**:
   - Kiểm thử giao diện đăng nhập, đăng ký
   - Kiểm thử giao diện quản lý người dùng
   - **Tiêu chí đánh giá**: Giao diện hiển thị đúng, dễ sử dụng

5. **Kiểm thử bảo mật**:
   - Kiểm thử xác thực và phân quyền
   - Kiểm thử bảo mật mật khẩu
   - **Tiêu chí đánh giá**: Mật khẩu được mã hóa, phân quyền hoạt động đúng

### 2.1.5 Phân hệ quản lý khuyến mãi, đánh giá và báo cáo

1. **Kiểm thử đơn vị**:
   - Kiểm thử KhuyenMaiService: tạo khuyến mãi, cập nhật, hủy khuyến mãi
   - Kiểm thử DanhGiaService: thêm, sửa, xóa đánh giá
   - Kiểm thử TuongTacThuocService: kiểm tra tương tác thuốc
   - Kiểm thử BaoCaoService: tạo báo cáo thống kê
   - **Tiêu chí đánh giá**: Độ bao phủ mã nguồn > 90%, xử lý đúng các trường hợp ngoại lệ

2. **Kiểm thử tích hợp**:
   - Kiểm thử tích hợp giữa KhuyenMaiService và DonHangService
   - Kiểm thử tích hợp với cơ sở dữ liệu
   - Kiểm thử tích hợp API
   - **Tiêu chí đánh giá**: Áp dụng khuyến mãi đúng, tạo báo cáo chính xác

3. **Kiểm thử chức năng**:
   - Kiểm thử chức năng tạo khuyến mãi
   - Kiểm thử chức năng đánh giá thuốc
   - Kiểm thử chức năng kiểm tra tương tác thuốc
   - Kiểm thử chức năng báo cáo thống kê
   - **Tiêu chí đánh giá**: Các chức năng hoạt động đúng theo yêu cầu, xử lý đúng các trường hợp đặc biệt

4. **Kiểm thử giao diện**:
   - Kiểm thử giao diện khuyến mãi
   - Kiểm thử giao diện đánh giá
   - Kiểm thử giao diện báo cáo
   - **Tiêu chí đánh giá**: Giao diện hiển thị đúng, dễ sử dụng

5. **Kiểm thử hệ thống**:
   - Kiểm thử luồng nghiệp vụ khuyến mãi
   - Kiểm thử hiệu năng API báo cáo
   - **Tiêu chí đánh giá**: Thời gian phản hồi < 3 giây, luồng nghiệp vụ hoạt động đúng

## 2.2 Tiêu chí chấp nhận

Các tiêu chí để chấp nhận kết quả kiểm thử:

- **Độ bao phủ mã nguồn**: Tối thiểu 80% mã nguồn được kiểm thử
- **Tỷ lệ lỗi**: Không có lỗi nghiêm trọng, lỗi ảnh hưởng đến dữ liệu
- **Hiệu năng**: Thời gian phản hồi dưới 3 giây cho các thao tác thông thường
- **Tính sẵn sàng**: Hệ thống hoạt động ổn định trong 24 giờ liên tục
- **Bảo mật**: Không có lỗ hổng bảo mật nghiêm trọng
- **Giao diện người dùng**: Giao diện thân thiện, dễ sử dụng trên các trình duyệt phổ biến

## 2.3 Chiến lược kiểm thử

### 2.3.1 Các loại kiểm thử

#### 2.3.1.1 Kiểm thử đơn vị (Unit Testing)
- **Mục đích**: Kiểm thử các thành phần nhỏ nhất của hệ thống một cách độc lập
- **Kỹ thuật**:
  - Sử dụng mock object để giả lập các dependency
  - Kiểm thử các trường hợp thành công và thất bại
  - Kiểm thử xử lý ngoại lệ
  - Kiểm thử các điều kiện biên
- **Tiêu chí hoàn thành**:
  - Độ bao phủ mã nguồn > 90% cho các lớp service
  - Tất cả các testcase đều pass
  - Xử lý đúng các trường hợp ngoại lệ
- **Lưu ý**:
  - Tập trung vào các lớp service, controller và repository
  - Sử dụng mock để tách biệt các dependency

#### 2.3.1.2 Kiểm thử tích hợp (Integration Testing)
- **Mục đích**: Kiểm thử sự tương tác giữa các thành phần đã được kiểm thử đơn vị
- **Kỹ thuật**:
  - Sử dụng phương pháp kiểm thử từ dưới lên (Bottom-up)
  - Kiểm thử API với Postman
  - Kiểm thử tích hợp với cơ sở dữ liệu thực
- **Tiêu chí hoàn thành**:
  - Các thành phần tích hợp đúng
  - Không có lỗi StackOverflowError
  - Xử lý đúng multipart/form-data
- **Lưu ý**:
  - Kiểm thử tích hợp giữa các service
  - Kiểm thử tích hợp giữa controller và service
  - Kiểm thử tích hợp với cơ sở dữ liệu

#### 2.3.1.3 Kiểm thử chức năng (Functional Testing)
- **Mục đích**: Kiểm thử các chức năng của hệ thống theo yêu cầu
- **Kỹ thuật**:
  - Kiểm thử dựa trên trường hợp sử dụng (Use Case Testing)
  - Kiểm thử dựa trên bảng quyết định (Decision Table Testing)
  - Kiểm thử phân vùng tương đương (Equivalence Partitioning)
  - Kiểm thử phân tích giá trị biên (Boundary Value Analysis)
- **Tiêu chí hoàn thành**:
  - Các chức năng hoạt động đúng theo yêu cầu
  - Xử lý đúng các trường hợp đặc biệt
- **Lưu ý**:
  - Kiểm thử tất cả các chức năng chính của hệ thống
  - Kiểm thử xử lý lỗi

#### 2.3.1.4 Kiểm thử giao diện (UI Testing)
- **Mục đích**: Kiểm thử giao diện người dùng
- **Kỹ thuật**:
  - Kiểm thử giao diện người dùng
  - Kiểm thử responsive
  - Kiểm thử accessibility
- **Tiêu chí hoàn thành**:
  - Giao diện hiển thị đúng
  - Responsive trên các thiết bị khác nhau
  - Dễ sử dụng
- **Lưu ý**:
  - Kiểm thử trên các trình duyệt phổ biến
  - Kiểm thử trên các kích thước màn hình khác nhau

#### 2.3.1.5 Kiểm thử hệ thống (System Testing)
- **Mục đích**: Kiểm thử toàn bộ hệ thống đã tích hợp
- **Kỹ thuật**:
  - Kiểm thử end-to-end
  - Kiểm thử hiệu năng với JMeter
  - Kiểm thử tương thích trên các trình duyệt khác nhau
  - Kiểm thử bảo mật cơ bản
- **Tiêu chí hoàn thành**:
  - Thời gian phản hồi < 3 giây
  - Luồng nghiệp vụ hoạt động đúng
  - Tương thích với các trình duyệt phổ biến
- **Lưu ý**:
  - Kiểm thử các luồng nghiệp vụ chính
  - Kiểm thử hiệu năng với dữ liệu lớn

#### 2.3.1.6 Kiểm thử hộp đen và hộp trắng
- **Mục đích**: Kết hợp kiểm thử hộp đen và hộp trắng
- **Kỹ thuật**:
  - Kiểm thử phân tích giá trị biên (Boundary Value Analysis)
  - Kiểm thử phân vùng tương đương (Equivalence Partitioning)
  - Kiểm thử bảng quyết định (Decision Table Testing)
  - Kiểm thử trạng thái (State Transition Testing)
  - Kiểm thử phân tích đường dẫn (Path Analysis)
  - Kiểm thử bao phủ mã nguồn (Code Coverage Testing)
- **Tiêu chí hoàn thành**:
  - Xử lý đúng giá trị biên
  - Đường dẫn được bao phủ
  - Độ bao phủ mã nguồn > 90%
- **Lưu ý**:
  - Kết hợp cả hai phương pháp để đạt độ bao phủ tối đa
  - Sử dụng JaCoCo để đo độ bao phủ mã nguồn

### 2.3.2 Công cụ kiểm thử

| STT | Công cụ | Mục đích sử dụng | Phạm vi áp dụng |
| :---: | ----- | ----- | ----- |
| 1 | JUnit 5 | Kiểm thử đơn vị cho backend | Tất cả các service, controller, repository |
| 2 | Mockito 4.0 | Tạo mock object cho kiểm thử đơn vị | Tất cả các service, controller |
| 3 | Jest | Kiểm thử đơn vị cho frontend | Các component và service frontend |
| 4 | Spring Boot Test | Kiểm thử tích hợp | Tích hợp giữa các thành phần backend |
| 5 | Postman | Kiểm thử API | Tất cả các API endpoint |
| 6 | REST Assured | Kiểm thử API tự động | Tất cả các API endpoint |
| 7 | Cypress | Kiểm thử giao diện và end-to-end | Tất cả các giao diện và luồng nghiệp vụ |
| 8 | JMeter | Kiểm thử hiệu năng | API và trang web |
| 9 | JaCoCo | Đo độ bao phủ mã nguồn | Tất cả mã nguồn backend |
| 10 | Chrome DevTools | Kiểm thử hiệu năng frontend | Tất cả các trang web |
| 11 | Excel/CSV | Quản lý testcase | Tất cả các testcase |
| 12 | Markdown | Tạo tài liệu | Tất cả tài liệu kiểm thử |

## 2.4 Nguồn lực và tài nguyên hệ thống

### 2.4.1 Nhân sự
Nhóm kiểm thử gồm 5 thành viên với phân công nhiệm vụ kiểm thử cụ thể như sau:

1. **Thành viên 1**: Kiểm thử chức năng quản lý thuốc (thêm, sửa, xóa, tìm kiếm thuốc, quản lý loại thuốc, danh mục thuốc)

2. **Thành viên 2**: Kiểm thử chức năng quản lý nhập kho và tồn kho (tạo phiếu nhập, quản lý tồn kho, quản lý nhà cung cấp)

3. **Thành viên 3**: Kiểm thử chức năng quản lý đơn hàng và giỏ hàng (tạo đơn hàng, quản lý chi tiết đơn hàng, quản lý giỏ hàng, thanh toán)

4. **Thành viên 4**: Kiểm thử chức năng quản lý người dùng và phân quyền (đăng ký, đăng nhập, quản lý thông tin người dùng, phân quyền)

5. **Thành viên 5**: Kiểm thử chức năng quản lý khuyến mãi, đánh giá và báo cáo (quản lý khuyến mãi, đánh giá thuốc, tương tác thuốc, báo cáo thống kê)

### 2.4.2 Phần cứng
- Máy trạm kiểm thử: Laptop với hệ điều hành macOS hoặc Windows 11
- Cấu hình tối thiểu: 8GB RAM, CPU 2 cores, ổ cứng SSD

### 2.4.3 Phần mềm
- Hệ điều hành: macOS, Windows 11
- Trình duyệt: Chrome, Firefox, Edge, Safari
- Công cụ kiểm thử: Postman, JUnit, Jest
- Cơ sở dữ liệu: PostgreSQL
- Môi trường phát triển: Visual Studio Code, IntelliJ IDEA
- Công cụ quản lý mã nguồn: Git, GitHub

### 2.4.4 Môi trường kiểm thử phần mềm
- **Môi trường kiểm thử local**: Môi trường cục bộ trên máy của mỗi thành viên, sử dụng để phát triển và thực hiện tất cả các loại kiểm thử

### 2.4.5 Dữ liệu kiểm thử
- Dữ liệu mẫu bao trùm toàn bộ các model của dự án: Thuốc, Loại thuốc, Danh mục thuốc, Phiếu nhập, Tồn kho, Nhà cung cấp, Đơn hàng, Chi tiết đơn hàng, Giỏ hàng, Người dùng, Nhóm quyền, Khuyến mãi, Đánh giá, Tương tác thuốc, Báo cáo
- Dữ liệu biên và dữ liệu không hợp lệ để kiểm thử xử lý ngoại lệ
- Bộ dữ liệu mẫu cho các tình huống đặc biệt (ví dụ: tương tác thuốc, thuốc kê đơn)

## 2.5 Kế hoạch và tiến độ thực hiện

### 2.5.1 Tổng quan kế hoạch

| Giai đoạn | Thời gian | Hoạt động | Số lượng testcase |
|-----------|-----------|-----------|-------------------|
| Chuẩn bị | Ngày 1-2 | Lập kế hoạch kiểm thử, chuẩn bị môi trường, dữ liệu | - |
| Giai đoạn 2: Kiểm thử đơn vị | Ngày 3-10 | Kiểm thử các service, controller, repository | 150 |
| Giai đoạn 3: Kiểm thử tích hợp | Ngày 11-17 | Kiểm thử tích hợp giữa các thành phần, API | 95 |
| Giai đoạn 4: Kiểm thử chức năng | Ngày 18-24 | Kiểm thử các chức năng của hệ thống | 120 |
| Giai đoạn 5: Kiểm thử giao diện | Ngày 25-28 | Kiểm thử giao diện người dùng, responsive | 60 |
| Giai đoạn 6: Kiểm thử hệ thống | Ngày 29-32 | Kiểm thử end-to-end, hiệu năng, tương thích, bảo mật | 50 |
| Giai đoạn 7: Kiểm thử hộp đen và hộp trắng | Ngày 33-37 | Kiểm thử phân tích giá trị biên, phân vùng tương đương, bảng quyết định, kiểm thử trạng thái, phân tích đường dẫn | 51 |
| Tổng hợp và báo cáo | Ngày 38-40 | Tổng hợp kết quả, viết báo cáo, đề xuất cải tiến | - |
| **Tổng cộng** | 40 ngày | | **526** |

### 2.5.2 Phân công nhiệm vụ

| Thành viên | Phân hệ phụ trách | Số lượng testcase |
|------------|-------------------|-------------------|
| Thành viên 1 | Quản lý thuốc | 191 |
| Thành viên 2 | Quản lý nhập kho và tồn kho | 85 |
| Thành viên 3 | Quản lý đơn hàng và giỏ hàng | 95 |
| Thành viên 4 | Quản lý người dùng và phân quyền | 75 |
| Thành viên 5 | Quản lý khuyến mãi, đánh giá và báo cáo | 80 |

### 2.5.3 Chi tiết tiến độ thực hiện

#### 2.5.3.1 Quản lý thuốc (191 testcase)

##### Giai đoạn 2: Kiểm thử đơn vị (43 testcase)
- **Ngày 3-4**: Kiểm thử ThuocService (18 testcase)
- **Ngày 5**: Kiểm thử ThuocController (7 testcase)
- **Ngày 6**: Kiểm thử ThuocRepository (5 testcase)
- **Ngày 7**: Kiểm thử LoaiThuocService và DanhMucThuocService (13 testcase)

##### Giai đoạn 3: Kiểm thử tích hợp (27 testcase)
- **Ngày 11-12**: Kiểm thử tích hợp giữa các service (6 testcase)
- **Ngày 13**: Kiểm thử tích hợp với cơ sở dữ liệu (5 testcase)
- **Ngày 14**: Kiểm thử tích hợp API (4 testcase)
- **Ngày 15**: Kiểm thử tích hợp Frontend-Backend và lỗi tích hợp (12 testcase)

##### Giai đoạn 4: Kiểm thử chức năng (36 testcase)
- **Ngày 18**: Kiểm thử chức năng thêm thuốc (4 testcase)
- **Ngày 19**: Kiểm thử chức năng cập nhật và xóa thuốc (5 testcase)
- **Ngày 20-21**: Kiểm thử chức năng tìm kiếm nâng cao (12 testcase)
- **Ngày 22**: Kiểm thử quản lý loại thuốc, danh mục thuốc và lỗi chức năng (15 testcase)

##### Giai đoạn 5: Kiểm thử giao diện (20 testcase)
- **Ngày 25**: Kiểm thử giao diện danh sách thuốc (5 testcase)
- **Ngày 26**: Kiểm thử giao diện thêm/sửa thuốc (5 testcase)
- **Ngày 27**: Kiểm thử giao diện chi tiết thuốc (3 testcase)
- **Ngày 28**: Kiểm thử giao diện tìm kiếm thuốc và responsive (7 testcase)

##### Giai đoạn 6: Kiểm thử hệ thống (24 testcase)
- **Ngày 29-30**: Kiểm thử luồng nghiệp vụ (8 testcase)
- **Ngày 31**: Kiểm thử hiệu năng (6 testcase)
- **Ngày 32**: Kiểm thử tương thích và bảo mật (10 testcase)

##### Giai đoạn 7: Kiểm thử hộp đen và hộp trắng (41 testcase)
- **Ngày 33-34**: Kiểm thử phân tích giá trị biên (12 testcase)
- **Ngày 35**: Kiểm thử phân vùng tương đương (7 testcase)
- **Ngày 36**: Kiểm thử bảng quyết định và trạng thái (12 testcase)
- **Ngày 37**: Kiểm thử phân tích đường dẫn và bao phủ mã nguồn (10 testcase)

#### 2.5.3.2 Quản lý nhập kho và tồn kho (85 testcase)

##### Giai đoạn 2: Kiểm thử đơn vị (30 testcase)
- **Ngày 3-5**: Kiểm thử PhieuNhapService (12 testcase)
- **Ngày 6-7**: Kiểm thử TonKhoService (10 testcase)
- **Ngày 8**: Kiểm thử NhaCungCapService (8 testcase)

##### Giai đoạn 3: Kiểm thử tích hợp (20 testcase)
- **Ngày 11-13**: Kiểm thử tích hợp giữa các service (8 testcase)
- **Ngày 14-15**: Kiểm thử tích hợp API và cơ sở dữ liệu (12 testcase)

##### Giai đoạn 4-7: Kiểm thử chức năng, giao diện, hệ thống, hộp đen và hộp trắng (35 testcase)
- **Ngày 18-37**: Thực hiện các testcase còn lại theo kế hoạch

#### 2.5.3.3 Quản lý đơn hàng và giỏ hàng (95 testcase)
- **Ngày 3-37**: Thực hiện các testcase theo kế hoạch tương tự như trên

#### 2.5.3.4 Quản lý người dùng và phân quyền (75 testcase)
- **Ngày 3-37**: Thực hiện các testcase theo kế hoạch tương tự như trên

#### 2.5.3.5 Quản lý khuyến mãi, đánh giá và báo cáo (80 testcase)
- **Ngày 3-37**: Thực hiện các testcase theo kế hoạch tương tự như trên

#### 2.5.3.6 Tổng hợp và báo cáo
- **Ngày 38**: Tổng hợp kết quả kiểm thử
- **Ngày 39**: Viết báo cáo kiểm thử
- **Ngày 40**: Đề xuất cải tiến và hoàn thiện báo cáo

## 2.6 Các tài liệu, báo cáo kiểm thử cần có

### 2.6.1 Tài liệu kế hoạch kiểm thử
1. **Kế hoạch kiểm thử tổng thể**:
   - Kế hoạch kiểm thử tổng thể (Test_Plan.md)
   - Kế hoạch đảm bảo chất lượng phần mềm (SQA_Plan.md)

2. **Kế hoạch kiểm thử cho từng phân hệ**:
   - Kế hoạch kiểm thử quản lý thuốc (Ke_Hoach_Kiem_Thu_Quan_Ly_Thuoc.md)
   - Kế hoạch kiểm thử quản lý nhập kho và tồn kho (Ke_Hoach_Kiem_Thu_Quan_Ly_Kho.md)
   - Kế hoạch kiểm thử quản lý đơn hàng và giỏ hàng (Ke_Hoach_Kiem_Thu_Quan_Ly_Don_Hang.md)
   - Kế hoạch kiểm thử quản lý người dùng và phân quyền (Ke_Hoach_Kiem_Thu_Quan_Ly_Nguoi_Dung.md)
   - Kế hoạch kiểm thử quản lý khuyến mãi, đánh giá và báo cáo (Ke_Hoach_Kiem_Thu_Quan_Ly_Khuyen_Mai.md)

3. **Kế hoạch triển khai kiểm thử**:
   - Kế hoạch triển khai kiểm thử (Ke_Hoach_Trien_Khai_Kiem_Thu.md)
   - Kế hoạch bổ sung testcase (Ke_Hoach_Bo_Sung_Testcase.md)

### 2.6.2 Testcase
1. **Testcase cho từng phân hệ**:
   - Testcase quản lý thuốc (docs/quan-ly-thuoc/testcase)
   - Testcase quản lý nhập kho và tồn kho (docs/quan-ly-kho/testcase)
   - Testcase quản lý đơn hàng và giỏ hàng (docs/quan-ly-don-hang/testcase)
   - Testcase quản lý người dùng và phân quyền (docs/quan-ly-nguoi-dung/testcase)
   - Testcase quản lý khuyến mãi, đánh giá và báo cáo (docs/quan-ly-khuyen-mai/testcase)

2. **Testcase cho từng giai đoạn**:
   - Testcase giai đoạn 2: Kiểm thử đơn vị (docs/giai-doan-2/testcase)
   - Testcase giai đoạn 3: Kiểm thử tích hợp (docs/giai-doan-3/testcase)
   - Testcase giai đoạn 4: Kiểm thử chức năng (docs/giai-doan-4/testcase)
   - Testcase giai đoạn 5: Kiểm thử giao diện (docs/giai-doan-5/testcase)
   - Testcase giai đoạn 6: Kiểm thử hệ thống (docs/giai-doan-6/testcase)
   - Testcase giai đoạn 7: Kiểm thử hộp đen và hộp trắng (docs/giai-doan-7/testcase)

3. **Testcase tổng hợp**:
   - Testcase tổng hợp tất cả giai đoạn (docs/tong-hop/Testcase_Tong_Hop_Tat_Ca_Giai_Doan.csv)
   - Testcase tổng hợp theo phân hệ (docs/tong-hop/Testcase_Tong_Hop_Theo_Phan_He.csv)

### 2.6.3 Báo cáo kiểm thử
1. **Báo cáo kiểm thử theo giai đoạn**:
   - Báo cáo kiểm thử đơn vị (docs/giai-doan-2/bao-cao)
   - Báo cáo kiểm thử tích hợp (docs/giai-doan-3/bao-cao)
   - Báo cáo kiểm thử chức năng (docs/giai-doan-4/bao-cao)
   - Báo cáo kiểm thử giao diện (docs/giai-doan-5/bao-cao)
   - Báo cáo kiểm thử hệ thống (docs/giai-doan-6/bao-cao)
   - Báo cáo kiểm thử hộp đen và hộp trắng (docs/giai-doan-7/bao-cao)

2. **Báo cáo kiểm thử theo phân hệ**:
   - Báo cáo kiểm thử quản lý thuốc (docs/quan-ly-thuoc/bao-cao)
   - Báo cáo kiểm thử quản lý nhập kho và tồn kho (docs/quan-ly-kho/bao-cao)
   - Báo cáo kiểm thử quản lý đơn hàng và giỏ hàng (docs/quan-ly-don-hang/bao-cao)
   - Báo cáo kiểm thử quản lý người dùng và phân quyền (docs/quan-ly-nguoi-dung/bao-cao)
   - Báo cáo kiểm thử quản lý khuyến mãi, đánh giá và báo cáo (docs/quan-ly-khuyen-mai/bao-cao)

### 2.6.4 Báo cáo lỗi
1. **Danh sách lỗi phát hiện**:
   - Danh sách lỗi theo phân hệ (docs/loi/Danh_Sach_Loi_Theo_Phan_He.md)
   - Danh sách lỗi theo mức độ nghiêm trọng (docs/loi/Danh_Sach_Loi_Theo_Muc_Do.md)

2. **Phân tích lỗi**:
   - Phân tích nguyên nhân lỗi (docs/loi/Phan_Tich_Nguyen_Nhan_Loi.md)
   - Giải pháp khắc phục lỗi (docs/loi/Giai_Phap_Khac_Phuc_Loi.md)

### 2.6.5 Báo cáo tiến độ
1. **Báo cáo tiến độ theo giai đoạn**:
   - Tiến độ thực hiện kiểm thử (docs/tien-do/Tien_Do_Thuc_Hien.md)
   - Báo cáo tiến độ theo từng giai đoạn (docs/tien-do/Bao_Cao_Tien_Do_Theo_Giai_Doan.md)

2. **Báo cáo tiến độ theo thành viên**:
   - Báo cáo tiến độ của từng thành viên (docs/tien-do/Bao_Cao_Tien_Do_Theo_Thanh_Vien.md)

### 2.6.6 Báo cáo tổng kết
1. **Báo cáo tổng hợp**:
   - Báo cáo tổng hợp kiểm thử (docs/tong-hop/Bao_Cao_Tong_Hop.md)
   - Báo cáo kết quả kiểm thử theo phân hệ (docs/tong-hop/Bao_Cao_Ket_Qua_Theo_Phan_He.md)
   - Tài liệu kiểm thử tổng hợp (docs/tong-hop/Tai_Lieu_Kiem_Thu_Tong_Hop.md)

2. **Đề xuất cải tiến**:
   - Đề xuất cải tiến chất lượng phần mềm (docs/tong-hop/De_Xuat_Cai_Tien.md)
   - Đề xuất cải tiến quy trình kiểm thử (docs/tong-hop/De_Xuat_Cai_Tien_Quy_Trinh.md)

# 3. REVIEW CÁC CHIẾN LƯỢC KIỂM THỬ

## 3.1 Chiến lược kiểm thử đơn vị (Unit Testing)
- **Mô tả**: Kiểm thử các thành phần nhỏ nhất của hệ thống một cách độc lập
- **Công cụ**: JUnit 5, Mockito 4.0 cho backend và Jest cho frontend
- **Ưu điểm**: Phát hiện lỗi sớm, dễ dàng tự động hóa, hỗ trợ phát triển liên tục
- **Nhược điểm**: Không phát hiện lỗi tích hợp, cần nhiều thời gian để viết test case
- **Áp dụng**:
  - Kiểm thử các service: ThuocService, LoaiThuocService, DanhMucThuocService
  - Kiểm thử các controller: ThuocController, LoaiThuocController, DanhMucThuocController
  - Kiểm thử các repository: ThuocRepo, LoaiThuocRepo, DanhMucThuocRepo
- **Kết quả đạt được**:
  - Tổng số 43 testcase đã được triển khai
  - Độ bao phủ mã nguồn đạt trên 90% cho các lớp service
  - Phát hiện và khắc phục các lỗi xử lý đầu vào và xử lý ngoại lệ
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử đơn vị cho các chức năng được phân công

## 3.2 Chiến lược kiểm thử tích hợp (Integration Testing)
- **Mô tả**: Kiểm thử sự tương tác giữa các thành phần đã được kiểm thử đơn vị
- **Công cụ**: Spring Boot Test, Postman, REST Assured, Cypress
- **Ưu điểm**: Phát hiện lỗi tương tác giữa các module, kiểm tra luồng dữ liệu
- **Nhược điểm**: Phức tạp hơn kiểm thử đơn vị, cần môi trường tích hợp
- **Áp dụng**:
  - Kiểm thử tích hợp giữa các service (ThuocService, LoaiThuocService, DanhMucThuocService)
  - Kiểm thử tích hợp giữa controller và service
  - Kiểm thử tích hợp với cơ sở dữ liệu
  - Kiểm thử tích hợp API với Postman
  - Kiểm thử tích hợp Frontend-Backend
- **Kết quả đạt được**:
  - Tổng số 27 testcase đã được triển khai
  - Phát hiện và khắc phục lỗi StackOverflowError do quan hệ hai chiều
  - Phát hiện và khắc phục lỗi phương thức HTTP không đúng cho multipart/form-data
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử tích hợp cho các chức năng được phân công

## 3.3 Chiến lược kiểm thử chức năng (Functional Testing)
- **Mô tả**: Kiểm thử các chức năng của hệ thống theo yêu cầu
- **Công cụ**: Cypress, Postman
- **Ưu điểm**: Đảm bảo các chức năng hoạt động đúng theo yêu cầu
- **Nhược điểm**: Khó bao phủ tất cả các trường hợp sử dụng
- **Áp dụng**:
  - Kiểm thử chức năng thêm, sửa, xóa thuốc
  - Kiểm thử chức năng tìm kiếm nâng cao
  - Kiểm thử chức năng quản lý loại thuốc
  - Kiểm thử chức năng quản lý danh mục thuốc
- **Kết quả đạt được**:
  - Tổng số 36 testcase đã được triển khai
  - Phát hiện và khắc phục lỗi thông báo không khớp giữa backend và frontend
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử chức năng cho các chức năng được phân công

## 3.4 Chiến lược kiểm thử giao diện (UI Testing)
- **Mô tả**: Kiểm thử giao diện người dùng
- **Công cụ**: Cypress
- **Ưu điểm**: Đảm bảo giao diện người dùng hoạt động đúng và thân thiện
- **Nhược điểm**: Dễ bị ảnh hưởng bởi thay đổi giao diện
- **Áp dụng**:
  - Kiểm thử giao diện danh sách thuốc
  - Kiểm thử giao diện thêm/sửa thuốc
  - Kiểm thử giao diện chi tiết thuốc
  - Kiểm thử giao diện tìm kiếm thuốc
  - Kiểm thử responsive
- **Kết quả đạt được**:
  - Tổng số 20 testcase đã được triển khai
  - Phát hiện và khắc phục các vấn đề về responsive
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử giao diện cho các chức năng được phân công

## 3.5 Chiến lược kiểm thử hệ thống (System Testing)
- **Mô tả**: Kiểm thử toàn bộ hệ thống đã tích hợp
- **Công cụ**: Cypress, JMeter
- **Ưu điểm**: Phát hiện lỗi hệ thống, kiểm tra tính năng đầy đủ
- **Nhược điểm**: Tốn thời gian, khó tự động hóa hoàn toàn
- **Áp dụng**:
  - Kiểm thử end-to-end các luồng nghiệp vụ
  - Kiểm thử hiệu năng với JMeter
  - Kiểm thử tương thích trên các trình duyệt khác nhau
  - Kiểm thử bảo mật cơ bản
- **Kết quả đạt được**:
  - Tổng số 24 testcase đã được triển khai
  - Phát hiện và khắc phục vấn đề hiệu năng khi tải danh sách thuốc lớn
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử hệ thống cho các chức năng được phân công

## 3.6 Chiến lược kiểm thử hộp đen và hộp trắng
- **Mô tả**: Kết hợp kiểm thử hộp đen và hộp trắng
- **Công cụ**: JUnit, Cypress, JaCoCo
- **Ưu điểm**: Bao phủ toàn diện cả đầu vào/đầu ra và cấu trúc mã nguồn
- **Nhược điểm**: Tốn nhiều thời gian và công sức
- **Áp dụng**:
  - Kiểm thử hộp đen: Phân tích giá trị biên, phân vùng tương đương, bảng quyết định, kiểm thử trạng thái
  - Kiểm thử hộp trắng: Phân tích đường dẫn, bao phủ mã nguồn
- **Kết quả đạt được**:
  - Tổng số 41 testcase đã được triển khai
  - Phát hiện và khắc phục các lỗi xử lý giá trị biên và đường dẫn
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử hộp đen và hộp trắng cho các chức năng được phân công

**Lưu ý**: Tổng cộng 191 testcase đã được triển khai cho chức năng quản lý thuốc, đạt tỷ lệ thành công 97.9% (187/191 testcase).

# 4. CÁC LƯU Ý KHÁC

## 4.1 Lưu ý về môi trường kiểm thử
- Cần đảm bảo môi trường kiểm thử phản ánh chính xác môi trường thực tế
- Sử dụng cùng phiên bản cơ sở dữ liệu PostgreSQL 14 như môi trường thực tế
- Sử dụng cùng phiên bản Spring Boot 2.6.7 và Java 11 như môi trường thực tế
- Sử dụng cùng phiên bản Angular 13 như môi trường thực tế

## 4.2 Lưu ý về dữ liệu kiểm thử
- Chuẩn bị dữ liệu kiểm thử đa dạng, bao gồm dữ liệu hợp lệ và không hợp lệ
- Chuẩn bị dữ liệu biên để kiểm thử các trường hợp đặc biệt
- Chuẩn bị dữ liệu đủ lớn để kiểm thử hiệu năng
- Sử dụng dữ liệu thực tế hoặc gần với thực tế để kiểm thử

## 4.3 Lưu ý về thiết kế testcase
- Các trường hợp kiểm thử cần được thiết kế để bao phủ tất cả các tình huống có thể xảy ra
- Sử dụng các phương pháp kiểm thử hộp đen và hộp trắng để thiết kế testcase
- Đảm bảo mỗi testcase có mục đích rõ ràng và kết quả mong đợi cụ thể
- Tổ chức testcase theo các giai đoạn kiểm thử và chức năng

## 4.4 Lưu ý về yêu cầu đặc biệt
- Cần lưu ý đến các yêu cầu đặc biệt của hệ thống hiệu thuốc như bảo mật thông tin cá nhân, quản lý thuốc kê đơn
- Cần tuân thủ các quy định pháp lý về kinh doanh dược phẩm trong quá trình kiểm thử
- Đặc biệt chú ý đến các chức năng liên quan đến tương tác thuốc và chống chỉ định
- Đảm bảo tính chính xác của thông tin thuốc và liều lượng

## 4.5 Lưu ý về báo cáo kiểm thử
- Báo cáo kiểm thử cần chi tiết và đầy đủ
- Mỗi lỗi phát hiện cần được mô tả chi tiết, bao gồm nguyên nhân và giải pháp
- Cập nhật báo cáo tiến độ thường xuyên
- Tổng hợp kết quả kiểm thử và đề xuất cải tiến
