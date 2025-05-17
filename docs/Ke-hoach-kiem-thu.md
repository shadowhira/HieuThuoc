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

Tài liệu đặc tả kế hoạch kiểm thử cho hệ thống web bán và quản lý hiệu thuốc. Hệ thống gồm 2 phân hệ chính:

- Phân hệ Frontend: Giao diện người dùng cho khách hàng và nhân viên quản lý
- Phân hệ Backend: Xử lý nghiệp vụ và quản lý dữ liệu

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

Dựa trên tài liệu thiết kế hệ thống hiệu thuốc, các yêu cầu kiểm thử bao gồm:

1. **Kiểm thử chức năng**:
   - Kiểm thử tất cả các chức năng cơ bản của hệ thống hiệu thuốc
   - Đảm bảo các luồng nghiệp vụ hoạt động đúng từ đầu đến cuối
   - Kiểm tra tính đúng đắn của dữ liệu đầu vào và đầu ra

2. **Kiểm thử giao diện người dùng**:
   - Kiểm tra giao diện trên các trình duyệt phổ biến
   - Đảm bảo tính thân thiện và dễ sử dụng của giao diện

3. **Kiểm thử hiệu năng**:
   - Kiểm tra thời gian phản hồi của hệ thống
   - Kiểm tra khả năng xử lý đồng thời nhiều người dùng

4. **Kiểm thử bảo mật**:
   - Kiểm tra cơ chế xác thực và phân quyền
   - Kiểm tra bảo mật dữ liệu và thông tin người dùng

5. **Kiểm thử tích hợp**:
   - Kiểm tra tích hợp giữa các module trong hệ thống
   - Kiểm tra tích hợp với các hệ thống bên ngoài (nếu có)

## 2.2 Tiêu chí chấp nhận

Các tiêu chí để chấp nhận kết quả kiểm thử:

- **Độ bao phủ mã nguồn**: Tối thiểu 80% mã nguồn được kiểm thử
- **Tỷ lệ lỗi**: Không có lỗi nghiêm trọng, lỗi ảnh hưởng đến dữ liệu
- **Hiệu năng**: Thời gian phản hồi dưới 3 giây cho các thao tác thông thường
- **Tính sẵn sàng**: Hệ thống hoạt động ổn định trong 24 giờ liên tục
- **Bảo mật**: Không có lỗ hổng bảo mật nghiêm trọng
- **Giao diện người dùng**: Giao diện thân thiện, dễ sử dụng trên các trình duyệt phổ biến

## 2.3 Chiến lược kiểm thử

### 2.3.1 Kiểm thử đơn vị (Unit Testing)
- Kiểm thử các thành phần nhỏ nhất của hệ thống
- Sử dụng các framework kiểm thử đơn vị như JUnit cho backend và Jest cho frontend
- Tập trung vào các lớp, phương thức và hàm quan trọng

### 2.3.2 Kiểm thử tích hợp (Integration Testing)
- Kiểm thử sự tương tác giữa các thành phần
- Sử dụng phương pháp kiểm thử từ dưới lên (Bottom-up)
- Kiểm tra tích hợp giữa các module và các hệ thống bên ngoài

### 2.3.3 Kiểm thử hệ thống (System Testing)
- Kiểm thử toàn bộ hệ thống
- Kiểm thử các luồng nghiệp vụ từ đầu đến cuối
- Kiểm tra hiệu năng và bảo mật của hệ thống

### 2.3.4 Kiểm thử chấp nhận (Acceptance Testing)
- Kiểm thử dựa trên các kịch bản sử dụng thực tế
- Đánh giá sự đáp ứng yêu cầu của người dùng
- Kiểm tra tính khả dụng của hệ thống

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

| Giai đoạn | Thời gian | Hoạt động |
|-----------|-----------|-----------|
| Chuẩn bị | Ngày 1 | Lập kế hoạch kiểm thử, chuẩn bị môi trường, dữ liệu |
| Kiểm thử đơn vị | Ngày 2 | Kiểm thử các thành phần riêng lẻ |
| Kiểm thử tích hợp | Ngày 3 | Kiểm thử tích hợp giữa các module |
| Kiểm thử hệ thống | Ngày 4 | Kiểm thử toàn bộ hệ thống |
| Kiểm thử chấp nhận | Ngày 5 | Kiểm thử với người dùng thực tế |
| Báo cáo và sửa lỗi | Ngày 6 | Tổng hợp kết quả, sửa lỗi và kiểm thử lại |

## 2.6 Các tài liệu, báo cáo kiểm thử cần có

1. **Kế hoạch kiểm thử**: Mô tả chi tiết về phạm vi, mục tiêu, và phương pháp kiểm thử
2. **Kịch bản kiểm thử**: Mô tả chi tiết các trường hợp kiểm thử
3. **Báo cáo lỗi**: Mô tả chi tiết các lỗi phát hiện trong quá trình kiểm thử
4. **Báo cáo tiến độ**: Cập nhật tiến độ kiểm thử theo từng giai đoạn
5. **Báo cáo tổng kết**: Tổng hợp kết quả kiểm thử và đề xuất cải tiến

# 3. REVIEW CÁC CHIẾN LƯỢC KIỂM THỬ

## 3.1 Chiến lược kiểm thử đơn vị (Unit Testing)
- **Mô tả**: Kiểm thử các thành phần nhỏ nhất của hệ thống một cách độc lập
- **Công cụ**: JUnit, Jest
- **Ưu điểm**: Phát hiện lỗi sớm, dễ dàng tự động hóa, hỗ trợ phát triển liên tục
- **Nhược điểm**: Không phát hiện lỗi tích hợp, cần nhiều thời gian để viết test case
- **Áp dụng**: Kiểm thử các controller, service, repository riêng lẻ
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử đơn vị cho các chức năng được phân công

## 3.2 Chiến lược kiểm thử tích hợp (Integration Testing)
- **Mô tả**: Kiểm thử sự tương tác giữa các thành phần đã được kiểm thử đơn vị
- **Công cụ**: Postman, REST Assured
- **Ưu điểm**: Phát hiện lỗi tương tác giữa các module, kiểm tra luồng dữ liệu
- **Nhược điểm**: Phức tạp hơn kiểm thử đơn vị, cần môi trường tích hợp
- **Áp dụng**: Kiểm thử API, tương tác giữa frontend và backend
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử tích hợp cho các chức năng được phân công

## 3.3 Chiến lược kiểm thử hệ thống (System Testing)
- **Mô tả**: Kiểm thử toàn bộ hệ thống đã tích hợp
- **Công cụ**: Selenium, Cypress
- **Ưu điểm**: Phát hiện lỗi hệ thống, kiểm tra tính năng đầy đủ
- **Nhược điểm**: Tốn thời gian, khó tự động hóa hoàn toàn
- **Áp dụng**: Kiểm thử end-to-end, kiểm thử hiệu năng, kiểm thử bảo mật
- **Yêu cầu bắt buộc**: Mỗi thành viên phải thực hiện kiểm thử hệ thống cho các chức năng được phân công

**Lưu ý**: Các loại kiểm thử khác như kiểm thử chấp nhận, kiểm thử hiệu năng, kiểm thử bảo mật là tùy chọn và có thể được thực hiện tùy theo mức độ chi tiết mà mỗi thành viên muốn thực hiện.

# 4. CÁC LƯU Ý KHÁC

- Cần đảm bảo môi trường kiểm thử phản ánh chính xác môi trường thực tế
- Các trường hợp kiểm thử cần được thiết kế để bao phủ tất cả các tình huống có thể xảy ra
- Cần lưu ý đến các yêu cầu đặc biệt của hệ thống hiệu thuốc như bảo mật thông tin cá nhân, quản lý thuốc kê đơn
- Cần tuân thủ các quy định pháp lý về kinh doanh dược phẩm trong quá trình kiểm thử
