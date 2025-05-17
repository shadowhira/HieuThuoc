# TEST CASE CHI TIẾT CHO CHỨC NĂNG QUẢN LÝ THUỐC

## 1. TEST CASE THÊM THUỐC

### TC_ADD_THUOC_001: Thêm thuốc với đầy đủ thông tin hợp lệ

**Mô tả**: Kiểm tra chức năng thêm thuốc mới với đầy đủ thông tin hợp lệ.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn dữ liệu về loại thuốc và nhà sản xuất

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Thêm mới"
3. Nhập đầy đủ thông tin thuốc:
   - Tên thuốc: "Paracetamol 500mg"
   - Mã thuốc: "PARA500"
   - Loại thuốc: Chọn một loại thuốc có sẵn
   - Nhà sản xuất: Chọn một nhà sản xuất có sẵn
   - Đơn vị: "Viên"
   - Giá nhập: 5000
   - Giá bán: 7000
   - Hạn sử dụng: Chọn ngày trong tương lai
   - Số lượng tồn: 100
   - Ngưỡng cảnh báo: 20
   - Công dụng: "Giảm đau, hạ sốt"
   - Chỉ định: "Đau đầu, sốt, đau nhẹ"
   - Chống chỉ định: "Mẫn cảm với paracetamol"
   - Hướng dẫn sử dụng: "Uống 1-2 viên mỗi 4-6 giờ khi cần"
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo "Thành công"
- Thuốc mới được thêm vào danh sách thuốc
- Dữ liệu thuốc được lưu chính xác trong cơ sở dữ liệu

**Mức độ ưu tiên**: Cao

### TC_ADD_THUOC_002: Thêm thuốc với mã thuốc đã tồn tại

**Mô tả**: Kiểm tra hệ thống xử lý khi thêm thuốc với mã thuốc đã tồn tại.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn thuốc với mã "PARA500" trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Thêm mới"
3. Nhập thông tin thuốc với mã thuốc đã tồn tại:
   - Tên thuốc: "Paracetamol 650mg"
   - Mã thuốc: "PARA500" (mã đã tồn tại)
   - Điền các thông tin còn lại hợp lệ
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo lỗi "Mã thuốc đã tồn tại"
- Thuốc không được thêm vào hệ thống

**Mức độ ưu tiên**: Cao

### TC_ADD_THUOC_003: Thêm thuốc với tên thuốc đã tồn tại

**Mô tả**: Kiểm tra hệ thống xử lý khi thêm thuốc với tên thuốc đã tồn tại.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn thuốc với tên "Paracetamol 500mg" trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Thêm mới"
3. Nhập thông tin thuốc với tên thuốc đã tồn tại:
   - Tên thuốc: "Paracetamol 500mg" (tên đã tồn tại)
   - Mã thuốc: "PARA650" (mã mới)
   - Điền các thông tin còn lại hợp lệ
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo lỗi "Tên thuốc đã tồn tại"
- Thuốc không được thêm vào hệ thống

**Mức độ ưu tiên**: Cao

### TC_ADD_THUOC_004: Thêm thuốc với thông tin bắt buộc bị thiếu

**Mô tả**: Kiểm tra hệ thống xử lý khi thêm thuốc với thông tin bắt buộc bị thiếu.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Thêm mới"
3. Bỏ trống một số trường bắt buộc:
   - Tên thuốc: (để trống)
   - Mã thuốc: "PARA650"
   - Loại thuốc: Chọn một loại thuốc có sẵn
   - Nhà sản xuất: (để trống)
   - Điền các thông tin còn lại hợp lệ
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo lỗi về các trường bắt buộc bị thiếu
- Thuốc không được thêm vào hệ thống

**Mức độ ưu tiên**: Cao

### TC_ADD_THUOC_005: Thêm thuốc với giá bán nhỏ hơn giá nhập

**Mô tả**: Kiểm tra hệ thống xử lý khi thêm thuốc với giá bán nhỏ hơn giá nhập.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhấn nút "Thêm mới"
3. Nhập thông tin thuốc với giá bán nhỏ hơn giá nhập:
   - Tên thuốc: "Paracetamol 650mg"
   - Mã thuốc: "PARA650"
   - Giá nhập: 7000
   - Giá bán: 5000 (nhỏ hơn giá nhập)
   - Điền các thông tin còn lại hợp lệ
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo lỗi về giá bán phải lớn hơn giá nhập
- Thuốc không được thêm vào hệ thống

**Mức độ ưu tiên**: Trung bình

## 2. TEST CASE SỬA THUỐC

### TC_UPDATE_THUOC_001: Cập nhật thuốc với đầy đủ thông tin hợp lệ

**Mô tả**: Kiểm tra chức năng cập nhật thông tin thuốc với đầy đủ thông tin hợp lệ.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn thuốc "Paracetamol 500mg" trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Tìm thuốc "Paracetamol 500mg" và nhấn nút "Sửa"
3. Cập nhật thông tin thuốc:
   - Giá bán: 8000 (thay đổi từ 7000)
   - Công dụng: "Giảm đau, hạ sốt, giảm viêm" (thêm "giảm viêm")
   - Các thông tin khác giữ nguyên
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo "Thành công"
- Thông tin thuốc được cập nhật trong danh sách thuốc
- Dữ liệu thuốc được cập nhật chính xác trong cơ sở dữ liệu

**Mức độ ưu tiên**: Cao

### TC_UPDATE_THUOC_002: Cập nhật thuốc với mã thuốc đã tồn tại

**Mô tả**: Kiểm tra hệ thống xử lý khi cập nhật thuốc với mã thuốc đã tồn tại.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn thuốc "Paracetamol 500mg" với mã "PARA500" trong hệ thống
- Đã có sẵn thuốc "Ibuprofen 400mg" với mã "IBU400" trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Tìm thuốc "Ibuprofen 400mg" và nhấn nút "Sửa"
3. Cập nhật mã thuốc thành mã đã tồn tại:
   - Mã thuốc: "PARA500" (mã đã tồn tại của thuốc khác)
   - Các thông tin khác giữ nguyên
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo lỗi "Mã thuốc đã tồn tại"
- Thông tin thuốc không được cập nhật

**Mức độ ưu tiên**: Cao

## 3. TEST CASE XÓA THUỐC

### TC_DELETE_THUOC_001: Xóa thuốc tồn tại

**Mô tả**: Kiểm tra chức năng xóa thuốc đang tồn tại trong hệ thống.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn thuốc "Paracetamol 500mg" trong hệ thống
- Thuốc chưa được sử dụng trong bất kỳ đơn hàng nào

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Tìm thuốc "Paracetamol 500mg" và nhấn nút "Xóa"
3. Xác nhận xóa thuốc

**Kết quả mong đợi**:
- Hiển thị thông báo "Thành công"
- Thuốc bị xóa khỏi danh sách thuốc
- Dữ liệu thuốc bị xóa khỏi cơ sở dữ liệu

**Mức độ ưu tiên**: Cao

### TC_DELETE_THUOC_002: Xóa thuốc không tồn tại

**Mô tả**: Kiểm tra hệ thống xử lý khi xóa thuốc không tồn tại.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist

**Các bước thực hiện**:
1. Truy cập trực tiếp API xóa thuốc với ID không tồn tại
   - Gọi API: DELETE /thuoc/delete?id=9999

**Kết quả mong đợi**:
- Hệ thống trả về thông báo lỗi phù hợp
- Không có thay đổi trong cơ sở dữ liệu

**Mức độ ưu tiên**: Trung bình

## 4. TEST CASE TÌM KIẾM THUỐC

### TC_SEARCH_THUOC_001: Tìm kiếm thuốc theo tên

**Mô tả**: Kiểm tra chức năng tìm kiếm thuốc theo tên.

**Điều kiện tiên quyết**:
- Đã đăng nhập vào hệ thống
- Đã có sẵn thuốc "Paracetamol 500mg" trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhập "Paracetamol" vào ô tìm kiếm
3. Nhấn nút tìm kiếm hoặc nhấn Enter

**Kết quả mong đợi**:
- Hiển thị danh sách thuốc có tên chứa "Paracetamol"
- Thuốc "Paracetamol 500mg" xuất hiện trong kết quả tìm kiếm

**Mức độ ưu tiên**: Cao

### TC_SEARCH_THUOC_002: Tìm kiếm thuốc theo mã

**Mô tả**: Kiểm tra chức năng tìm kiếm thuốc theo mã.

**Điều kiện tiên quyết**:
- Đã đăng nhập vào hệ thống
- Đã có sẵn thuốc với mã "PARA500" trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Nhập "PARA500" vào ô tìm kiếm
3. Nhấn nút tìm kiếm hoặc nhấn Enter

**Kết quả mong đợi**:
- Hiển thị danh sách thuốc có mã chứa "PARA500"
- Thuốc với mã "PARA500" xuất hiện trong kết quả tìm kiếm

**Mức độ ưu tiên**: Cao

### TC_SEARCH_THUOC_003: Tìm kiếm thuốc theo loại thuốc

**Mô tả**: Kiểm tra chức năng tìm kiếm thuốc theo loại thuốc.

**Điều kiện tiên quyết**:
- Đã đăng nhập vào hệ thống
- Đã có sẵn loại thuốc "Giảm đau" và thuốc thuộc loại này

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh sách thuốc"
2. Chọn "Giảm đau" trong dropdown loại thuốc
3. Nhấn nút tìm kiếm

**Kết quả mong đợi**:
- Hiển thị danh sách thuốc thuộc loại "Giảm đau"
- Chỉ hiển thị thuốc thuộc loại đã chọn

**Mức độ ưu tiên**: Cao

## 5. TEST CASE QUẢN LÝ LOẠI THUỐC

### TC_LOAI_THUOC_001: Thêm loại thuốc mới

**Mô tả**: Kiểm tra chức năng thêm loại thuốc mới.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist
- Đã có sẵn danh mục thuốc trong hệ thống

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Loại thuốc"
2. Nhấn nút "Thêm mới"
3. Nhập thông tin loại thuốc:
   - Tên loại: "Thuốc kháng sinh"
   - Mô tả: "Các loại thuốc kháng sinh điều trị nhiễm khuẩn"
   - Danh mục thuốc: Chọn một danh mục có sẵn
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo "Thành công"
- Loại thuốc mới được thêm vào danh sách loại thuốc
- Dữ liệu loại thuốc được lưu chính xác trong cơ sở dữ liệu

**Mức độ ưu tiên**: Cao

## 6. TEST CASE QUẢN LÝ DANH MỤC THUỐC

### TC_DANH_MUC_THUOC_001: Thêm danh mục thuốc mới

**Mô tả**: Kiểm tra chức năng thêm danh mục thuốc mới.

**Điều kiện tiên quyết**:
- Đã đăng nhập với quyền Admin hoặc Pharmacist

**Các bước thực hiện**:
1. Truy cập menu "Thuốc" > "Danh mục thuốc"
2. Nhấn nút "Thêm mới"
3. Nhập thông tin danh mục thuốc:
   - Tên danh mục: "Thuốc điều trị tim mạch"
   - Mô tả: "Các loại thuốc điều trị bệnh tim mạch"
4. Nhấn nút "Lưu"

**Kết quả mong đợi**:
- Hiển thị thông báo "Thành công"
- Danh mục thuốc mới được thêm vào danh sách danh mục thuốc
- Dữ liệu danh mục thuốc được lưu chính xác trong cơ sở dữ liệu

**Mức độ ưu tiên**: Cao
