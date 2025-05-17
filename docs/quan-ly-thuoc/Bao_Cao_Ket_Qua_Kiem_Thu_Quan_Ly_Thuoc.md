# BÁO CÁO KẾT QUẢ KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## 1. TỔNG QUAN

### 1.1 Mục đích
Tài liệu này trình bày kết quả kiểm thử chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc. Báo cáo bao gồm kết quả kiểm thử các chức năng thêm, sửa, xóa, tìm kiếm thuốc và quản lý loại thuốc, danh mục thuốc.

### 1.2 Phạm vi
Báo cáo này bao gồm kết quả kiểm thử:
- Kiểm thử đơn vị (Unit Testing) cho các service và controller
- Kiểm thử tích hợp (Integration Testing) giữa các thành phần
- Kiểm thử giao diện người dùng (UI Testing)
- Kiểm thử chức năng (Functional Testing)

### 1.3 Tài liệu tham khảo
- Kế hoạch kiểm thử chức năng Quản lý thuốc
- Test case chi tiết cho chức năng Quản lý thuốc
- Mã nguồn kiểm thử tự động

## 2. KẾT QUẢ KIỂM THỬ

### 2.1 Tổng hợp kết quả

| Loại kiểm thử | Số lượng test case | Số lượng pass | Số lượng fail | Tỷ lệ pass |
|---------------|-------------------|--------------|--------------|------------|
| Kiểm thử đơn vị | 15 | 15 | 0 | 100% |
| Kiểm thử tích hợp | 10 | 9 | 1 | 90% |
| Kiểm thử giao diện | 8 | 7 | 1 | 87.5% |
| Kiểm thử chức năng | 20 | 18 | 2 | 90% |
| **Tổng cộng** | **53** | **49** | **4** | **92.5%** |

### 2.2 Kết quả kiểm thử đơn vị

#### 2.2.1 Kiểm thử ThuocService

| ID | Tên test case | Kết quả | Ghi chú |
|----|--------------|---------|---------|
| UT_TS_001 | testCreateThuoc_Success | Pass | Kiểm tra tạo thuốc thành công |
| UT_TS_002 | testCreateThuoc_MaThuocExists | Pass | Kiểm tra tạo thuốc với mã thuốc đã tồn tại |
| UT_TS_003 | testCreateThuoc_TenThuocExists | Pass | Kiểm tra tạo thuốc với tên thuốc đã tồn tại |
| UT_TS_004 | testGetById_Success | Pass | Kiểm tra lấy thông tin thuốc theo ID thành công |
| UT_TS_005 | testGetById_NotFound | Pass | Kiểm tra lấy thông tin thuốc không tồn tại |

#### 2.2.2 Kiểm thử ThuocController

| ID | Tên test case | Kết quả | Ghi chú |
|----|--------------|---------|---------|
| UT_TC_001 | testGetById_Success | Pass | Kiểm tra API lấy thông tin thuốc theo ID thành công |
| UT_TC_002 | testGetById_NotFound | Pass | Kiểm tra API lấy thông tin thuốc không tồn tại |
| UT_TC_003 | testSearch_Success | Pass | Kiểm tra API tìm kiếm thuốc thành công |
| UT_TC_004 | testDelete_Success | Pass | Kiểm tra API xóa thuốc thành công |
| UT_TC_005 | testGetThuocBanChay_Success | Pass | Kiểm tra API lấy danh sách thuốc bán chạy |

#### 2.2.3 Kiểm thử Frontend Component

| ID | Tên test case | Kết quả | Ghi chú |
|----|--------------|---------|---------|
| UT_FE_001 | should create | Pass | Kiểm tra khởi tạo component |
| UT_FE_002 | should load thuoc list on init | Pass | Kiểm tra tải danh sách thuốc khi khởi tạo |
| UT_FE_003 | should load loai thuoc list on init | Pass | Kiểm tra tải danh sách loại thuốc khi khởi tạo |
| UT_FE_004 | should load nha san xuat list on init | Pass | Kiểm tra tải danh sách nhà sản xuất khi khởi tạo |
| UT_FE_005 | should search thuoc | Pass | Kiểm tra chức năng tìm kiếm thuốc |

### 2.3 Kết quả kiểm thử tích hợp

| ID | Tên test case | Kết quả | Ghi chú |
|----|--------------|---------|---------|
| IT_001 | Tích hợp ThuocController và ThuocService | Pass | Kiểm tra tích hợp giữa controller và service |
| IT_002 | Tích hợp ThuocService và ThuocRepo | Pass | Kiểm tra tích hợp giữa service và repository |
| IT_003 | Tích hợp Frontend và Backend API | Pass | Kiểm tra tích hợp giữa frontend và backend |
| IT_004 | Tích hợp với LoaiThuocService | Pass | Kiểm tra tích hợp với service quản lý loại thuốc |
| IT_005 | Tích hợp với DanhMucThuocService | Pass | Kiểm tra tích hợp với service quản lý danh mục thuốc |
| IT_006 | Tích hợp với NhaSanXuatService | Pass | Kiểm tra tích hợp với service quản lý nhà sản xuất |
| IT_007 | Tích hợp với ThanhPhanThuocService | Pass | Kiểm tra tích hợp với service quản lý thành phần thuốc |
| IT_008 | Tích hợp với DoiTuongService | Pass | Kiểm tra tích hợp với service quản lý đối tượng |
| IT_009 | Tích hợp với UploadImageService | Pass | Kiểm tra tích hợp với service upload hình ảnh |
| IT_010 | Tích hợp với ChiTietDonHangService | Fail | Lỗi khi xóa thuốc đã có trong đơn hàng |

### 2.4 Kết quả kiểm thử giao diện

| ID | Tên test case | Kết quả | Ghi chú |
|----|--------------|---------|---------|
| UI_001 | Hiển thị danh sách thuốc | Pass | Kiểm tra hiển thị danh sách thuốc |
| UI_002 | Hiển thị form thêm thuốc | Pass | Kiểm tra hiển thị form thêm thuốc |
| UI_003 | Hiển thị form sửa thuốc | Pass | Kiểm tra hiển thị form sửa thuốc |
| UI_004 | Hiển thị chi tiết thuốc | Pass | Kiểm tra hiển thị chi tiết thuốc |
| UI_005 | Hiển thị thông báo lỗi | Pass | Kiểm tra hiển thị thông báo lỗi |
| UI_006 | Responsive trên desktop | Pass | Kiểm tra responsive trên desktop |
| UI_007 | Responsive trên tablet | Pass | Kiểm tra responsive trên tablet |
| UI_008 | Responsive trên mobile | Fail | Một số phần giao diện bị lỗi trên mobile |

### 2.5 Kết quả kiểm thử chức năng

| ID | Tên test case | Kết quả | Ghi chú |
|----|--------------|---------|---------|
| TC_ADD_THUOC_001 | Thêm thuốc với đầy đủ thông tin hợp lệ | Pass | Kiểm tra thêm thuốc thành công |
| TC_ADD_THUOC_002 | Thêm thuốc với mã thuốc đã tồn tại | Pass | Kiểm tra validation mã thuốc |
| TC_ADD_THUOC_003 | Thêm thuốc với tên thuốc đã tồn tại | Pass | Kiểm tra validation tên thuốc |
| TC_ADD_THUOC_004 | Thêm thuốc với thông tin bắt buộc bị thiếu | Pass | Kiểm tra validation thông tin bắt buộc |
| TC_ADD_THUOC_005 | Thêm thuốc với giá bán nhỏ hơn giá nhập | Pass | Kiểm tra validation giá bán |
| TC_UPDATE_THUOC_001 | Cập nhật thuốc với đầy đủ thông tin hợp lệ | Pass | Kiểm tra cập nhật thuốc thành công |
| TC_UPDATE_THUOC_002 | Cập nhật thuốc với mã thuốc đã tồn tại | Pass | Kiểm tra validation mã thuốc khi cập nhật |
| TC_UPDATE_THUOC_003 | Cập nhật thuốc với tên thuốc đã tồn tại | Pass | Kiểm tra validation tên thuốc khi cập nhật |
| TC_UPDATE_THUOC_004 | Cập nhật thuốc với thông tin bắt buộc bị thiếu | Pass | Kiểm tra validation thông tin bắt buộc khi cập nhật |
| TC_UPDATE_THUOC_005 | Cập nhật thuốc không tồn tại | Pass | Kiểm tra cập nhật thuốc không tồn tại |
| TC_DELETE_THUOC_001 | Xóa thuốc tồn tại | Pass | Kiểm tra xóa thuốc thành công |
| TC_DELETE_THUOC_002 | Xóa thuốc không tồn tại | Pass | Kiểm tra xóa thuốc không tồn tại |
| TC_DELETE_THUOC_003 | Xóa thuốc đã có trong đơn hàng | Fail | Chưa xử lý trường hợp xóa thuốc đã có trong đơn hàng |
| TC_SEARCH_THUOC_001 | Tìm kiếm thuốc theo tên | Pass | Kiểm tra tìm kiếm thuốc theo tên |
| TC_SEARCH_THUOC_002 | Tìm kiếm thuốc theo mã | Pass | Kiểm tra tìm kiếm thuốc theo mã |
| TC_SEARCH_THUOC_003 | Tìm kiếm thuốc theo loại thuốc | Pass | Kiểm tra tìm kiếm thuốc theo loại thuốc |
| TC_SEARCH_THUOC_004 | Tìm kiếm thuốc theo nhà sản xuất | Pass | Kiểm tra tìm kiếm thuốc theo nhà sản xuất |
| TC_SEARCH_THUOC_005 | Tìm kiếm thuốc theo khoảng giá | Pass | Kiểm tra tìm kiếm thuốc theo khoảng giá |
| TC_SEARCH_THUOC_006 | Tìm kiếm thuốc với nhiều tiêu chí kết hợp | Pass | Kiểm tra tìm kiếm thuốc với nhiều tiêu chí |
| TC_SEARCH_THUOC_007 | Tìm kiếm thuốc không tồn tại | Fail | Hiển thị thông báo không phù hợp khi không tìm thấy kết quả |

## 3. PHÂN TÍCH LỖI

### 3.1 Lỗi kiểm thử tích hợp

| ID | Mô tả lỗi | Nguyên nhân | Mức độ nghiêm trọng | Giải pháp đề xuất |
|----|-----------|------------|---------------------|-------------------|
| IT_010 | Lỗi khi xóa thuốc đã có trong đơn hàng | Chưa kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa | Cao | Thêm kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa và hiển thị thông báo phù hợp |

### 3.2 Lỗi kiểm thử giao diện

| ID | Mô tả lỗi | Nguyên nhân | Mức độ nghiêm trọng | Giải pháp đề xuất |
|----|-----------|------------|---------------------|-------------------|
| UI_008 | Giao diện bị lỗi trên mobile | Chưa tối ưu hóa responsive cho màn hình nhỏ | Trung bình | Cập nhật CSS để tối ưu hóa hiển thị trên màn hình nhỏ |

### 3.3 Lỗi kiểm thử chức năng

| ID | Mô tả lỗi | Nguyên nhân | Mức độ nghiêm trọng | Giải pháp đề xuất |
|----|-----------|------------|---------------------|-------------------|
| TC_DELETE_THUOC_003 | Lỗi khi xóa thuốc đã có trong đơn hàng | Chưa kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa | Cao | Thêm kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa và hiển thị thông báo phù hợp |
| TC_SEARCH_THUOC_007 | Hiển thị thông báo không phù hợp khi không tìm thấy kết quả | Chưa xử lý trường hợp không tìm thấy kết quả | Thấp | Cập nhật hiển thị thông báo phù hợp khi không tìm thấy kết quả |

## 4. ĐỀ XUẤT CẢI TIẾN

### 4.1 Cải tiến chức năng

1. **Xử lý xóa thuốc đã có trong đơn hàng**:
   - Thêm kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa
   - Hiển thị thông báo phù hợp khi không thể xóa thuốc đã có trong đơn hàng
   - Cân nhắc thêm chức năng vô hiệu hóa thuốc thay vì xóa hoàn toàn

2. **Cải thiện tìm kiếm thuốc**:
   - Thêm tìm kiếm theo thành phần thuốc
   - Thêm tìm kiếm theo công dụng
   - Cải thiện hiển thị kết quả tìm kiếm khi không tìm thấy

3. **Thêm chức năng quản lý thuốc hết hạn**:
   - Thêm cảnh báo thuốc sắp hết hạn
   - Thêm danh sách thuốc đã hết hạn
   - Thêm chức năng xử lý thuốc hết hạn

### 4.2 Cải tiến giao diện

1. **Tối ưu hóa responsive**:
   - Cập nhật CSS để tối ưu hóa hiển thị trên màn hình nhỏ
   - Thêm chế độ xem compact cho màn hình nhỏ

2. **Cải thiện trải nghiệm người dùng**:
   - Thêm preview hình ảnh thuốc khi thêm/sửa
   - Cải thiện form thêm/sửa thuốc với các trường thông tin được nhóm lại
   - Thêm chức năng drag-and-drop để upload hình ảnh

### 4.3 Cải tiến kiểm thử

1. **Tăng độ bao phủ kiểm thử**:
   - Thêm kiểm thử cho các trường hợp ngoại lệ
   - Thêm kiểm thử cho các trường hợp biên

2. **Tự động hóa kiểm thử**:
   - Tích hợp kiểm thử tự động vào quy trình CI/CD
   - Thêm kiểm thử end-to-end với Cypress hoặc Selenium

## 5. KẾT LUẬN

Qua quá trình kiểm thử chức năng Quản lý thuốc, chúng tôi đã phát hiện và ghi nhận 4 lỗi trong tổng số 53 test case, đạt tỷ lệ pass là 92.5%. Các lỗi chủ yếu liên quan đến việc xóa thuốc đã có trong đơn hàng và hiển thị giao diện trên thiết bị di động.

Chức năng Quản lý thuốc đã đáp ứng được hầu hết các yêu cầu đề ra, tuy nhiên vẫn cần cải tiến một số điểm để tăng tính ổn định và trải nghiệm người dùng. Các đề xuất cải tiến đã được nêu trong báo cáo này.

Chúng tôi đề xuất tiếp tục phát triển và cải tiến chức năng Quản lý thuốc theo các đề xuất đã nêu, đồng thời tăng cường kiểm thử tự động để đảm bảo chất lượng phần mềm.
