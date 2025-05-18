# KẾ HOẠCH KIỂM THỬ HỆ THỐNG HIỆU THUỐC

|     |     |
| :-- | --- |

**HỆ THỐNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC**

**_Tài liệu kế hoạch kiểm thử_**

|  **Mã dự án**   | **HieuThuoc**    |
| :-------------: | :--------------- |
| **Mã tài liệu** | **HT_KHKT_v1.0** |
|    **Ngày**     | **15/07/2024**   |

**Hà Nội, ngày 15 tháng 07 năm 2024**

**NỘI DUNG SỬA ĐỔI**

\*M- Mới S – Sửa X - Xóa

|  **Ngày**  | **Mục sửa đổi**  | **M\*<br>S, X** | **Nội dung sửa đổi** | **Người sửa đổi** | **Lần sửa đổi** |
| :--------: | :--------------: | :-------------: | :------------------: | :---------------: | :-------------: |
| 15/07/2024 | Toàn bộ tài liệu |        M        |   Tạo mới tài liệu   |     Nhóm SQA      |        1        |

**TRANG KÝ**

**NGƯỜI LẬP:** Nhóm SQA 15/07/2024

**NGƯỜI KIỂM TRA:** Giảng viên 15/07/2024

**NGƯỜI PHÊ DUYỆT:** Giảng viên 15/07/2024

**MỤC LỤC**

[1. GIỚI THIỆU](#1-giới-thiệu)

[1.1. Mục đích tài liệu](#11-mục-đích-tài-liệu)

[1.2. Phạm vi hệ thống](#12-phạm-vi-hệ-thống)

[1.3. Định nghĩa thuật ngữ viết tắt](#13-định-nghĩa-thuật-ngữ-viết-tắt)

[1.4. Tài liệu tham khảo](#14-tài-liệu-tham-khảo)

[1.5. Mô tả tài liệu](#15-mô-tả-tài-liệu)

[2. TỔNG QUAN HỆ THỐNG](#2-tổng-quan-hệ-thống)

[2.1. Phát biểu bài toán](#21-phát-biểu-bài-toán)

[2.2. Mục tiêu hệ thống](#22-mục-tiêu-hệ-thống)

[2.3. Người sử dụng hệ thống](#23-người-sử-dụng-hệ-thống)

[3. CHIẾN LƯỢC KIỂM THỬ](#3-chiến-lược-kiểm-thử)

[3.1. Mục tiêu kiểm thử](#31-mục-tiêu-kiểm-thử)

[3.2. Phạm vi kiểm thử](#32-phạm-vi-kiểm-thử)

[3.3. Các loại kiểm thử](#33-các-loại-kiểm-thử)

[3.4. Tiêu chí đánh giá](#34-tiêu-chí-đánh-giá)

[4. KẾ HOẠCH KIỂM THỬ CHI TIẾT](#4-kế-hoạch-kiểm-thử-chi-tiết)

[4.1. Kiểm thử chức năng quản lý người dùng](#41-kiểm-thử-chức-năng-quản-lý-người-dùng)

[4.2. Kiểm thử chức năng quản lý sản phẩm (thuốc)](#42-kiểm-thử-chức-năng-quản-lý-sản-phẩm-thuốc)

[4.3. Kiểm thử chức năng đặt hàng và thanh toán](#43-kiểm-thử-chức-năng-đặt-hàng-và-thanh-toán)

[4.4. Kiểm thử chức năng quản lý đơn hàng](#44-kiểm-thử-chức-năng-quản-lý-đơn-hàng)

[4.5. Kiểm thử chức năng quản lý kho và báo cáo](#45-kiểm-thử-chức-năng-quản-lý-kho-và-báo-cáo)

[4.6. Kiểm thử chức năng quản lý tương tác thuốc](#46-kiểm-thử-chức-năng-quản-lý-tương-tác-thuốc)

[5. LỊCH TRÌNH KIỂM THỬ](#5-lịch-trình-kiểm-thử)

[6. NGUỒN LỰC KIỂM THỬ](#6-nguồn-lực-kiểm-thử)

[6.1. Nhân sự](#61-nhân-sự)

[6.2. Môi trường kiểm thử](#62-môi-trường-kiểm-thử)

[6.3. Công cụ kiểm thử](#63-công-cụ-kiểm-thử)

[7. RỦI RO VÀ GIẢM THIỂU](#7-rủi-ro-và-giảm-thiểu)

[8. BÁO CÁO VÀ THEO DÕI](#8-báo-cáo-và-theo-dõi)

# 1. GIỚI THIỆU

## 1.1. Mục đích tài liệu

- Tài liệu này được xây dựng nhằm mục đích phân tích và lập kế hoạch kiểm thử cho dự án "Hệ thống web bán và quản lý hiệu thuốc".
- Tài liệu này được dùng làm cơ sở để thực hiện các hoạt động kiểm thử, đảm bảo chất lượng phần mềm trước khi triển khai.
- Tài liệu cũng là căn cứ để đánh giá mức độ hoàn thiện của hệ thống dựa trên các yêu cầu đã đặt ra.

## 1.2. Phạm vi hệ thống

Tài liệu đặc tả kế hoạch kiểm thử cho hệ thống web bán và quản lý hiệu thuốc. Hệ thống gồm 2 phân hệ chính:

- Phân hệ Frontend: Giao diện người dùng cho khách hàng và nhân viên quản lý
- Phân hệ Backend: Xử lý nghiệp vụ và quản lý dữ liệu

## 1.3. Định nghĩa thuật ngữ viết tắt

| **STT** | **Nội dung** | **Ý nghĩa**                                                      |
| ------- | ------------ | ---------------------------------------------------------------- |
| 1       | SQA          | Software Quality Assurance - Đảm bảo chất lượng phần mềm         |
| 2       | UI           | User Interface - Giao diện người dùng                            |
| 3       | API          | Application Programming Interface - Giao diện lập trình ứng dụng |
| 4       | CRUD         | Create, Read, Update, Delete - Tạo, Đọc, Cập nhật, Xóa           |
| 5       | TC           | Test Case - Trường hợp kiểm thử                                  |

## 1.4. Tài liệu tham khảo

| **STT** | **Tên tài liệu**                                                                 |
| ------- | -------------------------------------------------------------------------------- |
| 1       | Tài liệu thiết kế hệ thống hiệu thuốc (Kien - Quang - Ky _ DATN _ Final.docx.md) |
| 2       | Template SRS (1.Template SRS.md)                                                 |
| 3       | Yêu cầu bài tập nhóm - Kiểm định (Yeu cau bai tap nhom - Kiem dinh.md)           |

## 1.5. Mô tả tài liệu

Nội dung tài liệu này bao gồm các phần:

1. Giới thiệu
2. Tổng quan hệ thống
3. Chiến lược kiểm thử
4. Kế hoạch kiểm thử chi tiết
5. Lịch trình kiểm thử
6. Nguồn lực kiểm thử
7. Rủi ro và giảm thiểu
8. Báo cáo và theo dõi

# 2. TỔNG QUAN HỆ THỐNG

## 2.1. Phát biểu bài toán

Hệ thống web bán và quản lý hiệu thuốc được thiết kế nhằm cung cấp một nền tảng tiện lợi, bảo mật và dễ dàng sử dụng cho các đối tượng người dùng khác nhau, bao gồm khách hàng, dược sĩ và quản trị viên. Các chức năng chính của hệ thống được phân chia rõ ràng, bao gồm các công cụ hỗ trợ tìm kiếm, đặt hàng thuốc, quản lý kho, theo dõi đơn hàng, và nhiều tính năng khác nhằm tối ưu hóa trải nghiệm người dùng.

Hiện trạng quản lý hiệu thuốc truyền thống gặp nhiều khó khăn trong việc quản lý hàng tồn kho, theo dõi đơn hàng, và cung cấp thông tin thuốc cho khách hàng. Việc triển khai hệ thống web bán và quản lý hiệu thuốc sẽ giúp:

- Tự động hóa quy trình quản lý kho, đặt hàng và bán hàng
- Cung cấp thông tin thuốc chính xác và đầy đủ cho khách hàng
- Theo dõi tương tác thuốc để đảm bảo an toàn cho người sử dụng
- Tạo báo cáo doanh thu và thống kê để hỗ trợ ra quyết định kinh doanh

## 2.2. Mục tiêu hệ thống

Xây dựng "Hệ thống web bán và quản lý hiệu thuốc" nhằm:

- Cung cấp nền tảng trực tuyến để khách hàng có thể tìm kiếm, xem thông tin và đặt mua thuốc
- Hỗ trợ dược sĩ và nhân viên trong việc quản lý kho, xử lý đơn hàng và tư vấn khách hàng
- Cung cấp công cụ quản lý toàn diện cho quản trị viên để theo dõi hoạt động kinh doanh
- Đảm bảo an toàn cho người dùng thông qua hệ thống cảnh báo tương tác thuốc
- Tạo báo cáo thống kê để phân tích doanh thu và xu hướng bán hàng

## 2.3. Người sử dụng hệ thống

| **Người sử dụng**     | **Mô tả**                                                                                                                                  |
| --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| Khách hàng            | Người dùng có thể đăng ký tài khoản, tìm kiếm thuốc, xem thông tin chi tiết, thêm vào giỏ hàng, đặt hàng và thanh toán, theo dõi đơn hàng. |
| Nhân viên             | Người dùng có quyền quản lý kho, tư vấn thuốc, cảnh báo tương tác thuốc, hỗ trợ quản lý đơn hàng.                                          |
| Quản trị viên (Admin) | Người dùng có quyền quản lý toàn bộ hệ thống, bao gồm quản lý người dùng, quản lý sản phẩm, quản lý đơn hàng, xem báo cáo và thống kê.     |

# 3. CHIẾN LƯỢC KIỂM THỬ

## 3.1. Mục tiêu kiểm thử

- Đảm bảo hệ thống đáp ứng đầy đủ các yêu cầu chức năng đã đặc tả
- Phát hiện và khắc phục các lỗi trước khi triển khai hệ thống
- Đảm bảo tính ổn định và hiệu năng của hệ thống
- Đảm bảo tính bảo mật và an toàn dữ liệu
- Đảm bảo trải nghiệm người dùng tốt trên các thiết bị và trình duyệt khác nhau

## 3.2. Phạm vi kiểm thử

Kiểm thử sẽ tập trung vào các chức năng chính của hệ thống:

1. Chức năng quản lý người dùng
2. Chức năng quản lý sản phẩm (thuốc)
3. Chức năng đặt hàng và thanh toán
4. Chức năng quản lý đơn hàng
5. Chức năng quản lý kho và báo cáo
6. Chức năng quản lý tương tác thuốc

## 3.3. Các loại kiểm thử

1. **Kiểm thử đơn vị (Unit Testing)**: Kiểm thử các thành phần nhỏ nhất của hệ thống như các hàm, phương thức.
2. **Kiểm thử tích hợp (Integration Testing)**: Kiểm thử sự tương tác giữa các module, các thành phần trong hệ thống.
3. **Kiểm thử hệ thống (System Testing)**: Kiểm thử toàn bộ hệ thống để đảm bảo đáp ứng các yêu cầu.
4. **Kiểm thử giao diện người dùng (UI Testing)**: Kiểm thử giao diện người dùng để đảm bảo tính thân thiện và dễ sử dụng.
5. **Kiểm thử chấp nhận (Acceptance Testing)**: Kiểm thử để xác nhận hệ thống đáp ứng các yêu cầu của người dùng.
6. **Kiểm thử hiệu năng (Performance Testing)**: Kiểm thử khả năng đáp ứng của hệ thống dưới tải trọng khác nhau.
7. **Kiểm thử bảo mật (Security Testing)**: Kiểm thử để phát hiện các lỗ hổng bảo mật trong hệ thống.

## 3.4. Tiêu chí đánh giá

1. **Độ bao phủ mã nguồn**: Tối thiểu 80% mã nguồn được kiểm thử.
2. **Tỷ lệ lỗi**: Không có lỗi nghiêm trọng, tối đa 5 lỗi trung bình và 10 lỗi nhỏ.
3. **Hiệu năng**: Thời gian phản hồi trung bình dưới 3 giây cho các thao tác thông thường.
4. **Tính ổn định**: Hệ thống hoạt động ổn định trong ít nhất 24 giờ liên tục.
5. **Tính tương thích**: Hệ thống hoạt động tốt trên các trình duyệt phổ biến (Chrome, Firefox, Safari, Edge).

# 4. KẾ HOẠCH KIỂM THỬ CHI TIẾT

## 4.1. Kiểm thử chức năng quản lý người dùng

### 4.1.1. Mục tiêu

Kiểm tra các chức năng liên quan đến quản lý người dùng, bao gồm đăng ký, đăng nhập, quản lý thông tin cá nhân, phân quyền người dùng.

### 4.1.2. Phạm vi

- Đăng ký tài khoản
- Đăng nhập và đăng xuất
- Quên mật khẩu và đổi mật khẩu
- Chỉnh sửa thông tin cá nhân
- Phân quyền người dùng

### 4.1.3. Các trường hợp kiểm thử

1. Kiểm thử đăng ký tài khoản với thông tin hợp lệ
2. Kiểm thử đăng ký tài khoản với email đã tồn tại
3. Kiểm thử đăng ký tài khoản với mật khẩu không đủ mạnh
4. Kiểm thử đăng nhập với thông tin đúng
5. Kiểm thử đăng nhập với thông tin sai
6. Kiểm thử chức năng quên mật khẩu
7. Kiểm thử đổi mật khẩu
8. Kiểm thử chỉnh sửa thông tin cá nhân
9. Kiểm thử phân quyền người dùng

## 4.2. Kiểm thử chức năng quản lý sản phẩm (thuốc)

### 4.2.1. Mục tiêu

Kiểm tra các chức năng liên quan đến quản lý sản phẩm, bao gồm thêm, sửa, xóa, tìm kiếm sản phẩm.

### 4.2.2. Phạm vi

- Thêm sản phẩm mới
- Chỉnh sửa thông tin sản phẩm
- Xóa sản phẩm
- Tìm kiếm và xem chi tiết sản phẩm

### 4.2.3. Các trường hợp kiểm thử

1. Kiểm thử thêm sản phẩm mới với thông tin hợp lệ
2. Kiểm thử thêm sản phẩm với tên đã tồn tại
3. Kiểm thử thêm sản phẩm với thông tin không hợp lệ (giá âm, số lượng âm)
4. Kiểm thử chỉnh sửa thông tin sản phẩm
5. Kiểm thử xóa sản phẩm
6. Kiểm thử tìm kiếm sản phẩm theo tên
7. Kiểm thử tìm kiếm sản phẩm theo loại
8. Kiểm thử xem chi tiết sản phẩm
9. Kiểm thử tìm kiếm với từ khóa không đầy đủ
10. Kiểm thử tìm kiếm với từ khóa không tồn tại

## 4.3. Kiểm thử chức năng đặt hàng và thanh toán

### 4.3.1. Mục tiêu

Kiểm tra các chức năng liên quan đến đặt hàng và thanh toán, bao gồm thêm sản phẩm vào giỏ hàng, đặt hàng, thanh toán.

### 4.3.2. Phạm vi

- Thêm sản phẩm vào giỏ hàng
- Chỉnh sửa số lượng sản phẩm trong giỏ hàng
- Xóa sản phẩm khỏi giỏ hàng
- Đặt hàng
- Thanh toán

### 4.3.3. Các trường hợp kiểm thử

1. Kiểm thử thêm sản phẩm vào giỏ hàng
2. Kiểm thử tăng/giảm số lượng sản phẩm trong giỏ hàng
3. Kiểm thử xóa sản phẩm khỏi giỏ hàng
4. Kiểm thử đặt hàng với thông tin hợp lệ
5. Kiểm thử đặt hàng với thông tin không hợp lệ
6. Kiểm thử thanh toán bằng tiền mặt
7. Kiểm thử thanh toán bằng chuyển khoản
8. Kiểm thử đặt hàng với số lượng sản phẩm vượt quá tồn kho
9. Kiểm thử cảnh báo tương tác thuốc khi đặt hàng
10. Kiểm thử hủy đơn hàng

## 4.4. Kiểm thử chức năng quản lý đơn hàng

### 4.4.1. Mục tiêu

Kiểm tra các chức năng liên quan đến quản lý đơn hàng, bao gồm xem danh sách đơn hàng, cập nhật trạng thái đơn hàng, xem chi tiết đơn hàng.

### 4.4.2. Phạm vi

- Xem danh sách đơn hàng
- Cập nhật trạng thái đơn hàng
- Xem chi tiết đơn hàng
- Hủy đơn hàng

### 4.4.3. Các trường hợp kiểm thử

1. Kiểm thử xem danh sách đơn hàng
2. Kiểm thử xem chi tiết đơn hàng
3. Kiểm thử cập nhật trạng thái đơn hàng từ "Đang xử lý" sang "Đã xác nhận"
4. Kiểm thử cập nhật trạng thái đơn hàng từ "Đã xác nhận" sang "Đang giao"
5. Kiểm thử cập nhật trạng thái đơn hàng từ "Đang giao" sang "Đã giao"
6. Kiểm thử hủy đơn hàng
7. Kiểm thử gửi thông báo cho khách hàng khi cập nhật trạng thái đơn hàng
8. Kiểm thử tìm kiếm đơn hàng theo mã đơn hàng
9. Kiểm thử tìm kiếm đơn hàng theo tên khách hàng
10. Kiểm thử lọc đơn hàng theo trạng thái

## 4.5. Kiểm thử chức năng quản lý kho và báo cáo

### 4.5.1. Mục tiêu

Kiểm tra các chức năng liên quan đến quản lý kho và báo cáo, bao gồm nhập kho, xuất kho, kiểm kê kho, xem báo cáo doanh thu, báo cáo tồn kho.

### 4.5.2. Phạm vi

- Nhập kho
- Xuất kho
- Kiểm kê kho
- Xem báo cáo doanh thu
- Xem báo cáo tồn kho

### 4.5.3. Các trường hợp kiểm thử

1. Kiểm thử tạo phiếu nhập kho với thông tin hợp lệ
2. Kiểm thử tạo phiếu nhập kho với thông tin không hợp lệ
3. Kiểm thử tạo phiếu xuất kho
4. Kiểm thử kiểm kê kho
5. Kiểm thử xem báo cáo doanh thu theo ngày
6. Kiểm thử xem báo cáo doanh thu theo tháng
7. Kiểm thử xem báo cáo doanh thu theo năm
8. Kiểm thử xem báo cáo tồn kho
9. Kiểm thử xuất báo cáo ra file Excel
10. Kiểm thử thêm nhiều thuốc vào phiếu nhập cùng lúc

## 4.6. Kiểm thử chức năng quản lý tương tác thuốc

### 4.6.1. Mục tiêu

Kiểm tra các chức năng liên quan đến quản lý tương tác thuốc, bao gồm thêm, sửa, xóa tương tác thuốc, cảnh báo tương tác thuốc khi bán hàng.

### 4.6.2. Phạm vi

- Thêm tương tác thuốc
- Chỉnh sửa tương tác thuốc
- Xóa tương tác thuốc
- Cảnh báo tương tác thuốc khi bán hàng

### 4.6.3. Các trường hợp kiểm thử

1. Kiểm thử thêm tương tác thuốc mới
2. Kiểm thử chỉnh sửa tương tác thuốc
3. Kiểm thử xóa tương tác thuốc
4. Kiểm thử cảnh báo tương tác thuốc khi thêm thuốc vào giỏ hàng
5. Kiểm thử cảnh báo tương tác thuốc khi đặt hàng
6. Kiểm thử tìm kiếm tương tác thuốc
7. Kiểm thử xem chi tiết tương tác thuốc
8. Kiểm thử cảnh báo tương tác thuốc khi bán hàng tại quầy

# 5. LỊCH TRÌNH KIỂM THỬ

| **STT** | **Hoạt động**                | **Thời gian bắt đầu** | **Thời gian kết thúc** | **Người thực hiện** |
| ------- | ---------------------------- | --------------------- | ---------------------- | ------------------- |
| 1       | Lập kế hoạch kiểm thử        | 15/07/2024            | 20/07/2024             | Nhóm SQA            |
| 2       | Thiết kế test case           | 21/07/2024            | 30/07/2024             | Nhóm SQA            |
| 3       | Chuẩn bị môi trường kiểm thử | 21/07/2024            | 25/07/2024             | Nhóm SQA            |
| 4       | Thực hiện kiểm thử           | 01/08/2024            | 15/08/2024             | Nhóm SQA            |
| 5       | Báo cáo và sửa lỗi           | 16/08/2024            | 25/08/2024             | Nhóm SQA            |
| 6       | Kiểm thử lại sau khi sửa lỗi | 26/08/2024            | 31/08/2024             | Nhóm SQA            |
| 7       | Tổng kết và đánh giá         | 01/09/2024            | 05/09/2024             | Nhóm SQA            |

# 6. NGUỒN LỰC KIỂM THỬ

## 6.1. Nhân sự

| **STT** | **Vai trò**      | **Số lượng** | **Trách nhiệm**                                      |
| ------- | ---------------- | ------------ | ---------------------------------------------------- |
| 1       | Quản lý kiểm thử | 1            | Lập kế hoạch, phân công, giám sát quá trình kiểm thử |
| 2       | Kiểm thử viên    | 3            | Thiết kế test case, thực hiện kiểm thử, báo cáo lỗi  |
| 3       | Lập trình viên   | 2            | Sửa lỗi, hỗ trợ kỹ thuật                             |

## 6.2. Môi trường kiểm thử

### 6.2.1. Phần cứng

- Máy chủ: CPU Intel Xeon, RAM 16GB, SSD 512GB
- Máy trạm: CPU Intel Core i5, RAM 8GB, SSD 256GB

### 6.2.2. Phần mềm

- Hệ điều hành: Windows 10, Ubuntu 20.04
- Trình duyệt: Chrome, Firefox, Safari, Edge
- Công cụ kiểm thử: Selenium, JUnit, Postman, JMeter

### 6.2.3. Dữ liệu kiểm thử

- Dữ liệu mẫu cho người dùng, sản phẩm, đơn hàng
- Dữ liệu tương tác thuốc
- Dữ liệu báo cáo

## 6.3. Công cụ kiểm thử

| **STT** | **Công cụ** | **Mục đích sử dụng**            |
| ------- | ----------- | ------------------------------- |
| 1       | Selenium    | Kiểm thử giao diện người dùng   |
| 2       | JUnit       | Kiểm thử đơn vị                 |
| 3       | Postman     | Kiểm thử API                    |
| 4       | JMeter      | Kiểm thử hiệu năng              |
| 5       | SonarQube   | Phân tích chất lượng mã nguồn   |
| 6       | JIRA        | Quản lý lỗi và theo dõi tiến độ |

# 7. RỦI RO VÀ GIẢM THIỂU

| **STT** | **Rủi ro**                        | **Mức độ ảnh hưởng** | **Khả năng xảy ra** | **Biện pháp giảm thiểu**                                                            |
| ------- | --------------------------------- | -------------------- | ------------------- | ----------------------------------------------------------------------------------- |
| 1       | Thiếu thời gian kiểm thử          | Cao                  | Trung bình          | Ưu tiên kiểm thử các chức năng quan trọng, tăng cường nhân lực                      |
| 2       | Môi trường kiểm thử không ổn định | Trung bình           | Thấp                | Chuẩn bị môi trường dự phòng, kiểm tra kỹ môi trường trước khi kiểm thử             |
| 3       | Thay đổi yêu cầu                  | Cao                  | Trung bình          | Quản lý thay đổi chặt chẽ, cập nhật kế hoạch kiểm thử kịp thời                      |
| 4       | Thiếu nhân lực                    | Trung bình           | Thấp                | Đào tạo chéo, chuẩn bị nhân sự dự phòng                                             |
| 5       | Lỗi không tái hiện được           | Thấp                 | Trung bình          | Ghi chép chi tiết các bước tái hiện lỗi, sử dụng công cụ ghi lại quá trình kiểm thử |

# 8. BÁO CÁO VÀ THEO DÕI

## 8.1. Báo cáo lỗi

Mỗi lỗi được phát hiện sẽ được báo cáo với các thông tin sau:

- Mã lỗi
- Mô tả lỗi
- Mức độ nghiêm trọng (Nghiêm trọng, Cao, Trung bình, Thấp)
- Các bước tái hiện lỗi
- Môi trường xảy ra lỗi
- Người phát hiện
- Ngày phát hiện
- Trạng thái (Mới, Đang xử lý, Đã sửa, Đã đóng)

## 8.2. Báo cáo tiến độ

Báo cáo tiến độ kiểm thử sẽ được thực hiện hàng tuần với các thông tin sau:

- Số lượng test case đã thực hiện
- Số lượng test case đã pass/fail
- Số lượng lỗi đã phát hiện (phân loại theo mức độ nghiêm trọng)
- Số lượng lỗi đã sửa
- Tiến độ thực hiện so với kế hoạch
- Các vấn đề phát sinh và giải pháp

## 8.3. Báo cáo tổng kết

Sau khi hoàn thành quá trình kiểm thử, báo cáo tổng kết sẽ được lập với các thông tin sau:

- Tổng quan về quá trình kiểm thử
- Kết quả kiểm thử (số lượng test case đã thực hiện, tỷ lệ pass/fail)
- Danh sách lỗi đã phát hiện và trạng thái xử lý
- Đánh giá chất lượng hệ thống
- Các bài học kinh nghiệm
- Đề xuất cải tiến
