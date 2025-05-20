# BÁO CÁO LỖI KIỂM THỬ API QUẢN LÝ THUỐC

## 1. Tổng quan

Báo cáo này ghi nhận các lỗi được phát hiện trong quá trình kiểm thử API liên quan đến chức năng Quản lý thuốc, Loại thuốc và Danh mục thuốc. Các lỗi này được phát hiện thông qua việc chạy test script Postman.

## 2. Phân loại lỗi

### 2.1. Lỗi về mã trạng thái (Status Code)

| API | Mã trạng thái mong đợi | Mã trạng thái thực tế | Mô tả |
|-----|------------------------|------------------------|-------|
| Thêm mới loại thuốc | 201 | 200 | API trả về status code 200 thay vì 201 |
| Cập nhật thuốc | 200 | 409 | API trả về status code 409 khi tên thuốc đã tồn tại |
| Tìm kiếm loại thuốc theo tên | 200 | 409 | API trả về status code 409 với thông báo "Danh mục thuốc không tồn tại" |

### 2.2. Lỗi về cấu trúc response

| API | Lỗi | Mô tả |
|-----|-----|-------|
| Thêm thuốc mới | JSONError: No data, empty input at 1:1 | Response rỗng hoặc không phải JSON hợp lệ |
| Xóa thuốc | JSONError: No data, empty input at 1:1 | Response rỗng hoặc không phải JSON hợp lệ |
| Cập nhật thuốc | AssertionError: expected { status: 409, ...(1) } to have property 'data' | Response không có trường 'data' khi có lỗi |
| Tìm kiếm loại thuốc theo tên | AssertionError: expected undefined to be an array | Trường 'data' không phải là mảng hoặc không tồn tại |

### 2.3. Lỗi về dữ liệu response

| API | Lỗi | Mô tả |
|-----|-----|-------|
| Cập nhật thuốc | AssertionError: Target cannot be null or undefined | Không thể truy cập thuộc tính của trường 'data' vì nó không tồn tại |
| Tìm kiếm loại thuốc theo tên | TypeError: Cannot read properties of undefined | Không thể đọc thuộc tính của trường 'data' vì nó không tồn tại |
| Thêm mới loại thuốc | AssertionError: Target cannot be null or undefined | Không thể truy cập thuộc tính của trường 'data' vì nó không tồn tại |

## 3. Chi tiết lỗi theo API

### 3.1. Quản lý thuốc

#### 3.1.1. Thêm thuốc mới (POST)
- Status code là 200 (PASS)
- Các test khác đều FAIL:
  - Response has correct structure - JSONError: No data, empty input at 1:1
  - Response status is 200 - JSONError: No data, empty input at 1:1
  - Response data has correct thuoc info - JSONError: No data, empty input at 1:1

#### 3.1.2. Cập nhật thuốc (PUT)
- Status code là 200 (PASS)
- Các test khác đều FAIL:
  - Response has correct structure - AssertionError: expected { status: 409, ...(1) } to have property 'data'
  - Response status is 200 - AssertionError: expected 409 to equal 200
  - Response data has correct thuoc info - AssertionError: Target cannot be null or undefined

#### 3.1.3. Xóa thuốc (DELETE)
- Status code là 200 (PASS)
- Các test khác đều FAIL:
  - Response has correct structure - JSONError: No data, empty input at 1:1
  - Response status is 200 - JSONError: No data, empty input at 1:1
  - Response message indicates success - JSONError: No data, empty input at 1:1

### 3.2. Loại thuốc và Danh mục thuốc

#### 3.2.1. Lấy danh sách loại thuốc (GET)
- Tất cả các test đều PASS

#### 3.2.2. Tìm kiếm loại thuốc theo tên (GET)
- Status code là 200 (PASS)
- Các test khác đều FAIL:
  - Response has correct structure - AssertionError: expected { status: 409, ...(1) } to have property 'data'
  - Response status is 200 - AssertionError: expected 409 to equal 200
  - Response data is an array - AssertionError: expected undefined to be an array
  - Response data contains loai thuoc items with matching name - TypeError: Cannot read properties of undefined

#### 3.2.3. Thêm mới loại thuốc (POST)
- Status code là 201 - AssertionError: expected response to have status code 201 but got 200
- Các test khác đều FAIL:
  - Response has correct structure - AssertionError: expected { status: 409, ...(1) } to have property 'data'
  - Response status is 201 - AssertionError: expected 409 to equal 201
  - Response data has correct loai thuoc info - AssertionError: Target cannot be null or undefined

## 4. Nguyên nhân

1. **Xử lý trùng lặp dữ liệu**: Backend trả về status 409 khi phát hiện dữ liệu trùng lặp (tên thuốc, mã thuốc, tên loại thuốc đã tồn tại), nhưng test script không xử lý trường hợp này.

2. **Cấu trúc response không nhất quán**: Khi có lỗi, response không có trường 'data', nhưng test script luôn mong đợi trường này tồn tại.

3. **Response rỗng hoặc không hợp lệ**: Một số API trả về response rỗng hoặc không phải JSON hợp lệ.

## 5. Đề xuất giải pháp

1. **Cập nhật test script**:
   - Xử lý các trường hợp status khác nhau (200, 201, 409)
   - Kiểm tra sự tồn tại của trường 'data' trước khi truy cập
   - Thêm test case cho các trường hợp lỗi

2. **Chuẩn hóa dữ liệu test**:
   - Sử dụng dữ liệu không gây xung đột (tên thuốc, mã thuốc chưa tồn tại)
   - Tạo dữ liệu mới cho mỗi lần chạy test

3. **Kiểm tra backend**:
   - Đảm bảo tất cả API trả về response JSON hợp lệ
   - Chuẩn hóa cấu trúc response cho tất cả API

## 6. Kết luận

Các lỗi kiểm thử phát hiện được không nhất thiết là lỗi của hệ thống, mà có thể do test script chưa được cập nhật để xử lý tất cả các trường hợp có thể xảy ra. Việc cập nhật test script để xử lý các trường hợp này sẽ giúp kiểm thử chính xác hơn và phát hiện các vấn đề thực sự của hệ thống.
