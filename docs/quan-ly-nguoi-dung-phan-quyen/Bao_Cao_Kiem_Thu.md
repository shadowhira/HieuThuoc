# BÁO CÁO KIỂM THỬ CHỨC NĂNG QUẢN LÝ NGƯỜI DÙNG VÀ PHÂN QUYỀN

## 1. Tổng quan về kiểm thử

### 1.1. Mục đích kiểm thử
- Đảm bảo chức năng quản lý người dùng và phân quyền hoạt động đúng theo yêu cầu
- Phát hiện lỗi và vấn đề trong quá trình phát triển
- Đảm bảo chất lượng phần mềm trước khi đưa vào sử dụng

### 1.2. Phạm vi kiểm thử
- Kiểm thử giao diện người dùng
- Kiểm thử đơn vị các thành phần chính
- Kiểm thử hộp đen (API)
- Kiểm thử hiệu năng

### 1.3. Môi trường kiểm thử
- **Backend**: Spring Boot 2.7.x, Java 11
- **Frontend**: Angular 13
- **Database**: MySQL 8.0
- **Công cụ kiểm thử**:
  - JUnit 5 và Mockito cho kiểm thử đơn vị
  - Cypress cho kiểm thử giao diện
  - Postman cho kiểm thử API
  - JMeter cho kiểm thử hiệu năng

## 2. Kết quả kiểm thử

### 2.1. Kiểm thử đơn vị

#### 2.1.1. NguoiDungService
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| UT_NGUOIDUNG_SERVICE_001 | Kiểm thử phương thức tạo người dùng mới với dữ liệu hợp lệ | Passed | |
| UT_NGUOIDUNG_SERVICE_002 | Kiểm thử phương thức tạo người dùng với email đã tồn tại | Passed | |
| UT_NGUOIDUNG_SERVICE_003 | Kiểm thử phương thức cập nhật người dùng | Passed | |
| QLHS_025 | Kiểm thử cập nhật thông tin cá nhân thành công | Passed | |
| QLHS_027 | Kiểm thử đổi mật khẩu thành công | Passed | |
| QLHS_028 | Kiểm thử đổi mật khẩu với mật khẩu hiện tại không chính xác | Passed | |
| UT_NGUOIDUNG_SERVICE_005 | Kiểm thử thay đổi avatar thành công | Passed | |

#### 2.1.2. NhomQuyenService
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| UT_NHOMQUYEN_SERVICE_001 | Kiểm thử phương thức tạo nhóm quyền mới với dữ liệu hợp lệ | Passed | |
| UT_NHOMQUYEN_SERVICE_002 | Kiểm thử phương thức cập nhật nhóm quyền | Passed | |

#### 2.1.3. ChucNangService
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| UT_CHUCNANG_SERVICE_001 | Kiểm thử phương thức tạo chức năng mới với dữ liệu hợp lệ | Passed | |
| UT_CHUCNANG_SERVICE_002 | Kiểm thử phương thức tạo chức năng với tên đã tồn tại | Passed | |
| UT_CHUCNANG_SERVICE_003 | Kiểm thử phương thức cập nhật chức năng | Passed | |

### 2.2. Kiểm thử giao diện

#### 2.2.1. Đăng ký
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| QLND_DK_001 | Kiểm tra giao diện mặc định của màn hình "Đăng ký" | Passed | |
| QLND_DK_002 | Kiểm tra bố cục, căn chỉnh các field, font, size, color | Passed | |
| QLND_DK_005 | Để trống field "Họ tên" | Passed | |
| QLND_DK_009 | Để trống field "Email" | Passed | |
| QLND_DK_011 | Nhập sai định dạng email - thiếu @ | Passed | |
| QLND_DK_014 | Để trống field "Số điện thoại" | Passed | |
| QLND_DK_021 | Để trống field "Mật khẩu" | Passed | |
| QLND_DK_029 | Đăng ký thành công với dữ liệu hợp lệ | Passed | |

#### 2.2.2. Quản lý hồ sơ người dùng
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| QLHS_001 | Kiểm tra giao diện mặc định của màn hình hồ sơ người dùng | Passed | |
| QLHS_002 | Kiểm tra bố cục, căn chỉnh, font, size, color | Passed | |
| QLHS_007 | Kiểm tra validate các trường bắt buộc | Failed | Cần cải thiện validation |
| QLHS_009 | Kiểm tra validate định dạng số điện thoại | Failed | Cần cải thiện validation |
| QLHS_011 | Cập nhật thông tin cá nhân thành công | Failed | Cần xử lý lỗi khi cập nhật |
| QLHS_015 | Kiểm tra validate các trường mật khẩu bắt buộc | Passed | |
| QLHS_016 | Kiểm tra validate mật khẩu hiện tại không chính xác | Passed | |
| QLHS_017 | Kiểm tra validate độ phức tạp của mật khẩu mới | Passed | |
| QLHS_018 | Kiểm tra validate xác nhận mật khẩu mới | Passed | |
| QLHS_019 | Đổi mật khẩu thành công | Failed | Cần xử lý lỗi khi đổi mật khẩu |

#### 2.2.3. Quản lý khách hàng
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| QLKH_01 | Kiểm tra giao diện màn hình quản lý khách hàng | Passed | |
| QLKH_02 | Kiểm tra tổng thể giao diện | Passed | |
| QLKH_03 | Kiểm tra tìm kiếm khách hàng theo tên | Passed | |
| QLKH_04 | Kiểm tra tìm kiếm khách hàng không tồn tại | Passed | |
| QLKH_05 | Kiểm tra tìm kiếm với ô tìm kiếm trống | Passed | |
| QLKH_06 | Kiểm tra hiển thị thông tin chi tiết khách hàng | Passed | |
| QLKH_07 | Kiểm tra hiển thị thông tin chi tiết khách hàng trong bảng | Passed | |
| QLKH_08 | Kiểm tra phân trang | Passed | |

### 2.3. Kiểm thử hộp đen (API)

#### 2.3.1. API Quản lý người dùng
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| API_NGUOIDUNG_001 | Đăng ký người dùng mới | Passed | |
| API_NGUOIDUNG_002 | Đăng nhập | Passed | |
| API_NGUOIDUNG_003 | Lấy danh sách người dùng | Passed | |
| API_NGUOIDUNG_004 | Lấy thông tin người dùng theo ID | Passed | |
| API_NGUOIDUNG_005 | Cập nhật thông tin người dùng | Passed | |
| API_NGUOIDUNG_006 | Xóa người dùng | Passed | |
| API_NGUOIDUNG_007 | Đổi mật khẩu | Passed | |
| API_NGUOIDUNG_008 | Quên mật khẩu | Passed | |
| API_NGUOIDUNG_009 | Đổi avatar | Passed | |

#### 2.3.2. API Quản lý nhóm quyền
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| API_NHOMQUYEN_001 | Lấy danh sách nhóm quyền | Passed | |
| API_NHOMQUYEN_002 | Lấy thông tin nhóm quyền theo ID | Passed | |
| API_NHOMQUYEN_003 | Tạo nhóm quyền mới | Passed | |
| API_NHOMQUYEN_004 | Cập nhật nhóm quyền | Passed | |
| API_NHOMQUYEN_005 | Xóa nhóm quyền | Passed | |

#### 2.3.3. API Quản lý chức năng
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| API_CHUCNANG_001 | Lấy danh sách chức năng | Passed | |
| API_CHUCNANG_002 | Tạo chức năng mới | Passed | |
| API_CHUCNANG_003 | Cập nhật chức năng | Passed | |
| API_CHUCNANG_004 | Xóa chức năng | Passed | |

### 2.4. Kiểm thử hiệu năng

#### 2.4.1. Thời gian phản hồi
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| QLND_DK_045 | Thời gian phản hồi API đăng ký | Passed | Thời gian phản hồi trung bình: 120ms |

#### 2.4.2. Khả năng xử lý tải
| ID | Tên test case | Kết quả | Ghi chú |
|----|---------------|---------|---------|
| QLND_DK_046 | Xử lý tải với 10 người dùng đồng thời | Passed | Tỷ lệ thành công: 100% |
| QLND_DK_047 | Xử lý tải với 50 người dùng đồng thời | Passed | Tỷ lệ thành công: 98% |
| QLND_DK_048 | Kiểm thử độ bền của API đăng ký | Passed | Thời gian chạy: 5 phút, tỷ lệ thành công: 99% |

## 3. Các vấn đề phát hiện

### 3.1. Vấn đề về giao diện
1. **Validation không đầy đủ**: Một số trường như họ tên, số điện thoại chưa được validate đầy đủ về độ dài và định dạng.
2. **Thông báo lỗi không rõ ràng**: Một số thông báo lỗi chưa đủ chi tiết để người dùng hiểu và sửa lỗi.
3. **Giao diện không responsive**: Giao diện chưa hoàn toàn tương thích với các thiết bị di động.

### 3.2. Vấn đề về chức năng
1. **Lỗi khi cập nhật thông tin cá nhân**: Đôi khi việc cập nhật thông tin cá nhân gặp lỗi.
2. **Lỗi khi đổi mật khẩu**: Đôi khi việc đổi mật khẩu không thành công.
3. **Thiếu xác thực email**: Hệ thống chưa có chức năng xác thực email khi đăng ký.

### 3.3. Vấn đề về hiệu năng
1. **Thời gian phản hồi tăng khi có nhiều người dùng**: Khi có 50 người dùng đồng thời, thời gian phản hồi tăng lên đáng kể.

## 4. Đề xuất cải tiến

### 4.1. Cải tiến giao diện
1. **Cải thiện validation**: Bổ sung validation đầy đủ cho các trường dữ liệu.
2. **Cải thiện thông báo lỗi**: Hiển thị thông báo lỗi chi tiết và hướng dẫn người dùng cách sửa lỗi.
3. **Cải thiện responsive**: Tối ưu giao diện cho các thiết bị di động.

### 4.2. Cải tiến chức năng
1. **Sửa lỗi cập nhật thông tin cá nhân**: Kiểm tra và sửa lỗi khi cập nhật thông tin cá nhân.
2. **Sửa lỗi đổi mật khẩu**: Kiểm tra và sửa lỗi khi đổi mật khẩu.
3. **Bổ sung xác thực email**: Thêm chức năng xác thực email khi đăng ký.

### 4.3. Cải tiến hiệu năng
1. **Tối ưu hóa truy vấn database**: Sử dụng index và tối ưu hóa các truy vấn database.
2. **Caching**: Áp dụng caching để giảm thời gian phản hồi.
3. **Phân trang hiệu quả**: Cải thiện cơ chế phân trang để giảm tải cho server.

### 4.4. Cải tiến bảo mật
1. **Tăng cường validation dữ liệu**: Kiểm tra và validate dữ liệu đầu vào kỹ hơn.
2. **Tăng cường xác thực và phân quyền**: Kiểm tra quyền truy cập cho tất cả các API.
3. **Bảo vệ chống tấn công CSRF và XSS**: Áp dụng các biện pháp bảo vệ chống tấn công CSRF và XSS.

## 5. Kết luận

Chức năng quản lý người dùng và phân quyền đã được kiểm thử đầy đủ về mặt giao diện, chức năng, API và hiệu năng. Hầu hết các test case đều pass, tuy nhiên vẫn còn một số vấn đề cần được cải thiện. Các vấn đề này đã được ghi nhận và đề xuất cách khắc phục. Sau khi khắc phục các vấn đề này, chức năng quản lý người dùng và phân quyền sẽ hoạt động tốt hơn và đáp ứng được yêu cầu của người dùng.
