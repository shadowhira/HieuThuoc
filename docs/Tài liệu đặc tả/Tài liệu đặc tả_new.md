# HT001: Tài liệu đặc tả yêu cầu phần mềm

# **HỆ THỐNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC**

***Tài liệu đặc tả yêu cầu phần mềm***

| **Mã dự án** | **HT001** |
| :-: | :- |
| **Mã tài liệu** | **HT001_SRS_v1.0** |
| **Ngày** | **15/05/2024** |

**Hà Nội, ngày 15 tháng 05 năm 2024**

## **NỘI DUNG SỬA ĐỔI**

*M- Mới S – Sửa X - Xóa

| **Ngày** | **Mục sửa đổi** | **M\*<br>S, X** | **Nội dung sửa đổi** | **Người sửa đổi** | **Lần sửa đổi** |
| :-: | :-: | :-: | :-: | :-: | :-: |
| 15/05/2024 | Toàn bộ tài liệu | M | Tạo mới tài liệu | Nhóm SQA | 1 |

## **TRANG KÝ**

**NGƯỜI LẬP:**		Nhóm SQA		           	15/05/2024

**NGƯỜI KIỂM TRA:**	Giảng viên		           	15/05/2024

**NGƯỜI PHÊ DUYỆT:**	Giảng viên		           	15/05/2024

## **MỤC LỤC**

[1. GIỚI THIỆU](#1-giới-thiệu)
  - [1.1. Mục đích tài liệu](#11-mục-đích-tài-liệu)
  - [1.2. Phạm vi hệ thống](#12-phạm-vi-hệ-thống)
  - [1.3. Định nghĩa thuật ngữ viết tắt](#13-định-nghĩa-thuật-ngữ-viết-tắt)
  - [1.4. Tài liệu tham khảo](#14-tài-liệu-tham-khảo)
  - [1.5. Mô tả tài liệu](#15-mô-tả-tài-liệu)

[2. TỔNG QUAN HỆ THỐNG](#2-tổng-quan-hệ-thống)
  - [2.1. Phát biểu bài toán](#21-phát-biểu-bài-toán)
  - [2.2. Mục tiêu hệ thống](#22-mục-tiêu-hệ-thống)
  - [2.3. Người sử dụng hệ thống](#23-người-sử-dụng-hệ-thống)

[3. ĐẶC TẢ YÊU CẦU CHỨC NĂNG](#3-đặc-tả-yêu-cầu-chức-năng)
  - [3.1. Phân hệ quản lý thuốc](#31-phân-hệ-quản-lý-thuốc)
  - [3.2. Phân hệ quản lý kho](#32-phân-hệ-quản-lý-kho)
  - [3.3. Phân hệ quản lý đơn hàng](#33-phân-hệ-quản-lý-đơn-hàng)
  - [3.4. Phân hệ quản lý khuyến mãi](#34-phân-hệ-quản-lý-khuyến-mãi)
  - [3.5. Phân hệ quản lý người dùng](#35-phân-hệ-quản-lý-người-dùng)
  - [3.6. Phân hệ báo cáo và thống kê](#36-phân-hệ-báo-cáo-và-thống-kê)

[4. CÁC YÊU CẦU PHI CHỨC NĂNG](#4-các-yêu-cầu-phi-chức-năng)
  - [4.1. Yêu cầu bảo mật](#41-yêu-cầu-bảo-mật)
  - [4.2. Yêu cầu về tính sử dụng](#42-yêu-cầu-về-tính-sử-dụng)
  - [4.3. Yêu cầu về tính ổn định](#43-yêu-cầu-về-tính-ổn-định)
  - [4.4. Yêu cầu về hiệu năng](#44-yêu-cầu-về-hiệu-năng)
  - [4.5. Yêu cầu về hỗ trợ](#45-yêu-cầu-về-hỗ-trợ)
  - [4.6. Các ràng buộc thiết kế](#46-các-ràng-buộc-thiết-kế)
  - [4.7. Yêu cầu về giao diện người dùng](#47-yêu-cầu-về-giao-diện-người-dùng)
  - [4.8. Yêu cầu về giao tiếp](#48-yêu-cầu-về-giao-tiếp)

# 1. GIỚI THIỆU

## 1.1. Mục đích tài liệu

- Tài liệu này được xây dựng nhằm mục đích phân tích và đặc tả các yêu cầu cho dự án "Xây dựng Web bán và quản lý hiệu thuốc", đồng thời là cơ sở để đàm phán với khách hàng về phạm vi của dự án.
- Tài liệu này được dùng làm đầu vào cho các quá trình thiết kế, xây dựng usecase, lập trình, và kiểm thử hệ thống.
- Tài liệu cũng là cơ sở để thực hiện việc đảm bảo chất lượng phần mềm trong quá trình phát triển.

## 1.2. Phạm vi hệ thống

Tài liệu đặc tả các chức năng cần thiết của hệ thống web bán và quản lý hiệu thuốc. Hệ thống gồm 2 phân hệ chính:

- Phân hệ Frontend: Giao diện người dùng cho khách hàng và nhân viên
- Phân hệ Backend: Xử lý nghiệp vụ và quản lý dữ liệu

Hệ thống bao gồm các chức năng chính:
- Quản lý thuốc và danh mục thuốc
- Quản lý nhập kho và tồn kho
- Quản lý đơn hàng và giỏ hàng
- Quản lý người dùng và phân quyền
- Quản lý khuyến mãi, đánh giá và báo cáo

## 1.3. Định nghĩa thuật ngữ viết tắt

| **STT** | **Nội dung** | **Ý nghĩa** |
| - | - | - |
| 1 | API | Application Programming Interface - Giao diện lập trình ứng dụng |
| 2 | CSDL | Cơ sở dữ liệu |
| 3 | UI | User Interface - Giao diện người dùng |
| 4 | UC | Use case - Trường hợp sử dụng |
| 5 | SRS | Software Requirements Specification - Đặc tả yêu cầu phần mềm |
| 6 | Frontend | Thành phần của trang web tương tác với người dùng |
| 7 | Backend | Thành phần của trang web xử lý dữ liệu |
| 8 | RESTful API | Representational State Transfer API - Kiểu thiết kế API sử dụng giao thức HTTP |
| 9 | COD | Cash On Delivery - Thanh toán khi nhận hàng |

## 1.4. Tài liệu tham khảo

| **STT** | **Tên tài liệu** |
| - | - |
| 1 | Template SRS.md |
| 2 | Tài liệu kiểm thử tổng hợp chức năng quản lý thuốc |

## 1.5. Mô tả tài liệu

Nội dung tài liệu này bao gồm các phần:

1. Giới thiệu
2. Tổng quan hệ thống
3. Đặc tả yêu cầu chức năng
4. Các yêu cầu phi chức năng

# 2. TỔNG QUAN HỆ THỐNG

## 2.1. Phát biểu bài toán

Hiện nay, việc quản lý hiệu thuốc thủ công gặp nhiều khó khăn trong việc theo dõi thuốc, quản lý kho, xử lý đơn hàng và báo cáo thống kê. Các hiệu thuốc cần một hệ thống quản lý toàn diện để nâng cao hiệu quả hoạt động, giảm thiểu sai sót và tăng doanh thu.

Hệ thống web bán và quản lý hiệu thuốc được phát triển nhằm đáp ứng nhu cầu quản lý hiệu quả các hoạt động của hiệu thuốc, từ quản lý thuốc, kho, đơn hàng đến quản lý khách hàng và báo cáo thống kê. Hệ thống cũng cung cấp giao diện bán hàng trực tuyến, giúp mở rộng kênh bán hàng và tăng khả năng tiếp cận khách hàng.

## 2.2. Mục tiêu hệ thống

Xây dựng "Hệ thống web bán và quản lý hiệu thuốc" nhằm:

- Quản lý thuốc và danh mục thuốc một cách hiệu quả
- Quản lý nhập kho, xuất kho và tồn kho chính xác
- Quản lý đơn hàng và thanh toán linh hoạt
- Quản lý khách hàng và chăm sóc khách hàng
- Quản lý khuyến mãi và marketing
- Báo cáo thống kê doanh thu, lợi nhuận
- Cung cấp giao diện bán hàng trực tuyến thân thiện với người dùng
- Đảm bảo an toàn và bảo mật thông tin

## 2.3. Người sử dụng hệ thống

Hệ thống phục vụ các đối tượng người dùng sau:

1. **Khách hàng**:
   - Tìm kiếm và mua thuốc trực tuyến
   - Xem thông tin chi tiết về thuốc
   - Quản lý giỏ hàng và đơn hàng
   - Đánh giá và bình luận về thuốc

2. **Nhân viên bán hàng**:
   - Xử lý đơn hàng tại quầy
   - Tìm kiếm thuốc
   - Tạo đơn hàng mới

3. **Nhân viên kho**:
   - Quản lý nhập kho
   - Kiểm tra tồn kho
   - Quản lý hạn sử dụng thuốc

4. **Quản lý**:
   - Quản lý nhân viên
   - Quản lý khuyến mãi
   - Xem báo cáo thống kê

5. **Quản trị viên**:
   - Quản lý toàn bộ hệ thống
   - Phân quyền người dùng
   - Cấu hình hệ thống

# 3. ĐẶC TẢ YÊU CẦU CHỨC NĂNG

## 3.1. Phân hệ quản lý thuốc

### 3.1.1. SREQ001 - Quản lý danh mục thuốc

1. **Mô tả nghiệp vụ**

   Chức năng quản lý danh mục thuốc cho phép người dùng quản lý các danh mục thuốc trong hệ thống, bao gồm thêm, sửa, xóa và tìm kiếm danh mục.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép thêm mới danh mục thuốc với các thông tin: mã danh mục, tên danh mục, mô tả, trạng thái.
   - Hệ thống cho phép cập nhật thông tin danh mục thuốc.
   - Hệ thống cho phép xóa danh mục thuốc (xóa logic).
   - Hệ thống cho phép tìm kiếm danh mục thuốc theo tên, mã.
   - Hệ thống hiển thị danh sách danh mục thuốc với phân trang.

### 3.1.2. SREQ002 - Quản lý thuốc

1. **Mô tả nghiệp vụ**

   Chức năng quản lý thuốc cho phép người dùng quản lý thông tin thuốc trong hệ thống, bao gồm thêm, sửa, xóa và tìm kiếm thuốc.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép thêm mới thuốc với các thông tin: mã thuốc, tên thuốc, danh mục, nhà sản xuất, thành phần, công dụng, chỉ định, chống chỉ định, liều dùng, giá bán, đơn vị tính, hình ảnh, trạng thái.
   - Hệ thống cho phép cập nhật thông tin thuốc.
   - Hệ thống cho phép xóa thuốc (xóa logic).
   - Hệ thống cho phép tìm kiếm thuốc theo tên, mã, danh mục.
   - Hệ thống hiển thị danh sách thuốc với phân trang.
   - Hệ thống cho phép xem chi tiết thông tin thuốc.
   - Hệ thống cho phép quản lý thông tin tương tác thuốc.

### 3.1.3. SREQ003 - Quản lý nhà sản xuất

1. **Mô tả nghiệp vụ**

   Chức năng quản lý nhà sản xuất cho phép người dùng quản lý thông tin nhà sản xuất thuốc trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép thêm mới nhà sản xuất với các thông tin: mã nhà sản xuất, tên nhà sản xuất, quốc gia, địa chỉ, số điện thoại, email, trạng thái.
   - Hệ thống cho phép cập nhật thông tin nhà sản xuất.
   - Hệ thống cho phép xóa nhà sản xuất (xóa logic).
   - Hệ thống cho phép tìm kiếm nhà sản xuất theo tên, mã.
   - Hệ thống hiển thị danh sách nhà sản xuất với phân trang.

*Xem tiếp tại file Tài liệu đặc tả_new_part2.md*
