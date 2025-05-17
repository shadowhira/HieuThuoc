# KẾ HOẠCH KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## 1. GIỚI THIỆU

### 1.1 Mục đích
- Tài liệu này được xây dựng nhằm mục đích phân tích và lập kế hoạch kiểm thử chi tiết cho chức năng "Quản lý thuốc" trong dự án "Hệ thống web bán và quản lý hiệu thuốc".
- Tài liệu này được dùng làm cơ sở để thực hiện các hoạt động kiểm thử, đánh giá chất lượng và đảm bảo chức năng Quản lý thuốc đáp ứng các yêu cầu đã đề ra.

### 1.2 Phạm vi
Tài liệu đặc tả kế hoạch kiểm thử cho chức năng Quản lý thuốc bao gồm:
- Kiểm thử các chức năng thêm, sửa, xóa, tìm kiếm thuốc
- Kiểm thử quản lý loại thuốc
- Kiểm thử quản lý danh mục thuốc
- Kiểm thử hiển thị và tìm kiếm thuốc theo các tiêu chí khác nhau

### 1.3 Tài liệu tham khảo
- Tài liệu thiết kế hệ thống web bán và quản lý hiệu thuốc
- Tài liệu đặc tả yêu cầu phần mềm
- Kế hoạch kiểm thử tổng thể (Test_Plan.md)
- Hướng dẫn sử dụng và chức năng hệ thống

## 2. PHÂN TÍCH CHỨC NĂNG QUẢN LÝ THUỐC

### 2.1 Mô tả chức năng
Chức năng Quản lý thuốc là một trong những chức năng cốt lõi của hệ thống hiệu thuốc, cho phép người dùng thực hiện các thao tác:
- Xem danh sách thuốc với các bộ lọc và tìm kiếm
- Thêm mới thuốc với đầy đủ thông tin
- Cập nhật thông tin thuốc
- Xóa thuốc
- Quản lý loại thuốc và danh mục thuốc
- Quản lý thông tin chi tiết thuốc (thành phần, công dụng, chỉ định, chống chỉ định)

### 2.2 Các thành phần liên quan
#### 2.2.1 Backend
- Controller: `ThuocController`, `LoaiThuocController`, `DanhMucThuocController`
- Service: `ThuocService`, `LoaiThuocService`, `DanhMucThuocService`
- Repository: `ThuocRepo`, `LoaiThuocRepo`, `DanhMucThuocRepo`, `ThanhPhanThuocRepo`
- Entity: `Thuoc`, `LoaiThuoc`, `DanhMucThuoc`, `ThanhPhanThuoc`, `DoiTuong`
- DTO: `ThuocDTO`, `LoaiThuocDTO`, `DanhMucThuocDTO`, `SearchThuocDTO`

#### 2.2.2 Frontend
- Component: `ThuocComponent`, `ThuocCreatementComponent`, `LoaiThuocComponent`, `DanhMucThuocComponent`, `ThuocChiTietComponent`, `ThuocTuLoaiThuocComponent`
- Service: `ThuocService`, `LoaithuocService`, `DanhmucThuocService`
- Model: `Thuoc`, `LoaiThuoc`, `DanhMucThuoc`, `ThanhPhanThuoc`

## 3. CHIẾN LƯỢC KIỂM THỬ

### 3.1 Kiểm thử đơn vị (Unit Testing)
#### 3.1.1 Backend
- Kiểm thử các phương thức trong `ThuocService`:
  - `create(ThuocDTO thuocDTO)`
  - `update(ThuocDTO thuocDTO)`
  - `delete(Integer id)`
  - `getById(Integer id)`
  - `search(SearchThuocDTO searchThuocDTO)`
  - `getThuocBanChay(SearchDTO searchDTO)`

- Kiểm thử các phương thức trong `LoaiThuocService`:
  - `getAllLoaiThuocs()`
  - `create(LoaiThuocDTO loaiThuocDTO)`
  - `update(LoaiThuocDTO loaiThuocDTO)`
  - `delete(Integer id)`
  - `searchByTenLoai(String tenLoai)`

- Kiểm thử các phương thức trong `DanhMucThuocService`:
  - `getAll()`
  - `getDanhMucAnhLoaiThuoc()`
  - `searchByTenDanhMuc(String tenDanhMuc)`
  - `create(DanhMucThuocDTO danhMucThuocDTO)`
  - `update(DanhMucThuocDTO danhMucThuocDTO)`
  - `delete(Integer id)`

#### 3.1.2 Frontend
- Kiểm thử các component:
  - `ThuocComponent`
  - `ThuocCreatementComponent`
  - `LoaiThuocComponent`
  - `DanhMucThuocComponent`

- Kiểm thử các service:
  - `ThuocService.getProductLst()`
  - `ThuocService.getProduct()`
  - `ThuocService.createProduct()`
  - `ThuocService.updateProduct()`
  - `ThuocService.deleteProduct()`

### 3.2 Kiểm thử tích hợp (Integration Testing)
- Kiểm thử tích hợp giữa `ThuocController` và `ThuocService`
- Kiểm thử tích hợp giữa `LoaiThuocController` và `LoaiThuocService`
- Kiểm thử tích hợp giữa `DanhMucThuocController` và `DanhMucThuocService`
- Kiểm thử tích hợp giữa các service và repository tương ứng
- Kiểm thử tích hợp giữa frontend và backend thông qua API

### 3.3 Kiểm thử hệ thống (System Testing)
- Kiểm thử luồng nghiệp vụ quản lý thuốc từ đầu đến cuối
- Kiểm thử luồng nghiệp vụ quản lý loại thuốc từ đầu đến cuối
- Kiểm thử luồng nghiệp vụ quản lý danh mục thuốc từ đầu đến cuối
- Kiểm thử tìm kiếm và lọc thuốc theo các tiêu chí khác nhau
- Kiểm thử hiển thị thuốc theo loại thuốc, danh mục thuốc

### 3.4 Kiểm thử giao diện (UI Testing)
- Kiểm thử giao diện danh sách thuốc
- Kiểm thử giao diện thêm/sửa thuốc
- Kiểm thử giao diện chi tiết thuốc
- Kiểm thử giao diện quản lý loại thuốc
- Kiểm thử giao diện quản lý danh mục thuốc

## 4. KẾ HOẠCH THỰC HIỆN KIỂM THỬ

### 4.1 Chuẩn bị môi trường kiểm thử
- Cài đặt môi trường phát triển: Visual Studio Code, IntelliJ IDEA
- Cài đặt các công cụ kiểm thử: JUnit, Jest, Postman
- Chuẩn bị dữ liệu kiểm thử: Dữ liệu thuốc, loại thuốc, danh mục thuốc

### 4.2 Thiết kế test case
#### 4.2.1 Test case cho chức năng thêm thuốc
1. **TC_ADD_THUOC_001**: Thêm thuốc với đầy đủ thông tin hợp lệ
2. **TC_ADD_THUOC_002**: Thêm thuốc với mã thuốc đã tồn tại
3. **TC_ADD_THUOC_003**: Thêm thuốc với tên thuốc đã tồn tại
4. **TC_ADD_THUOC_004**: Thêm thuốc với thông tin bắt buộc bị thiếu
5. **TC_ADD_THUOC_005**: Thêm thuốc với giá bán nhỏ hơn giá nhập
6. **TC_ADD_THUOC_006**: Thêm thuốc với hạn sử dụng trong quá khứ
7. **TC_ADD_THUOC_007**: Thêm thuốc với loại thuốc không tồn tại
8. **TC_ADD_THUOC_008**: Thêm thuốc với nhà sản xuất không tồn tại
9. **TC_ADD_THUOC_009**: Thêm thuốc với file hình ảnh hợp lệ
10. **TC_ADD_THUOC_010**: Thêm thuốc với file hình ảnh không hợp lệ

#### 4.2.2 Test case cho chức năng sửa thuốc
1. **TC_UPDATE_THUOC_001**: Cập nhật thuốc với đầy đủ thông tin hợp lệ
2. **TC_UPDATE_THUOC_002**: Cập nhật thuốc với mã thuốc đã tồn tại
3. **TC_UPDATE_THUOC_003**: Cập nhật thuốc với tên thuốc đã tồn tại
4. **TC_UPDATE_THUOC_004**: Cập nhật thuốc với thông tin bắt buộc bị thiếu
5. **TC_UPDATE_THUOC_005**: Cập nhật thuốc với giá bán nhỏ hơn giá nhập
6. **TC_UPDATE_THUOC_006**: Cập nhật thuốc với hạn sử dụng trong quá khứ
7. **TC_UPDATE_THUOC_007**: Cập nhật thuốc không tồn tại
8. **TC_UPDATE_THUOC_008**: Cập nhật thành phần thuốc
9. **TC_UPDATE_THUOC_009**: Cập nhật đối tượng sử dụng thuốc
10. **TC_UPDATE_THUOC_010**: Cập nhật hình ảnh thuốc

#### 4.2.3 Test case cho chức năng xóa thuốc
1. **TC_DELETE_THUOC_001**: Xóa thuốc tồn tại
2. **TC_DELETE_THUOC_002**: Xóa thuốc không tồn tại
3. **TC_DELETE_THUOC_003**: Xóa thuốc đã có trong đơn hàng

#### 4.2.4 Test case cho chức năng tìm kiếm thuốc
1. **TC_SEARCH_THUOC_001**: Tìm kiếm thuốc theo tên
2. **TC_SEARCH_THUOC_002**: Tìm kiếm thuốc theo mã
3. **TC_SEARCH_THUOC_003**: Tìm kiếm thuốc theo loại thuốc
4. **TC_SEARCH_THUOC_004**: Tìm kiếm thuốc theo nhà sản xuất
5. **TC_SEARCH_THUOC_005**: Tìm kiếm thuốc theo danh mục thuốc
6. **TC_SEARCH_THUOC_006**: Tìm kiếm thuốc theo khoảng giá
7. **TC_SEARCH_THUOC_007**: Tìm kiếm thuốc theo đối tượng sử dụng
8. **TC_SEARCH_THUOC_008**: Tìm kiếm thuốc với nhiều tiêu chí kết hợp
9. **TC_SEARCH_THUOC_009**: Tìm kiếm thuốc không tồn tại
10. **TC_SEARCH_THUOC_010**: Phân trang kết quả tìm kiếm

### 4.3 Thực hiện kiểm thử
#### 4.3.1 Kiểm thử đơn vị
- Viết các unit test cho các phương thức trong service
- Sử dụng JUnit cho backend và Jest cho frontend
- Sử dụng mock object để giả lập các dependency

#### 4.3.2 Kiểm thử tích hợp
- Sử dụng Postman để kiểm thử API
- Kiểm thử tích hợp giữa các thành phần

#### 4.3.3 Kiểm thử hệ thống
- Kiểm thử các luồng nghiệp vụ từ đầu đến cuối
- Kiểm thử giao diện người dùng

### 4.4 Báo cáo kết quả kiểm thử
- Tổng hợp kết quả kiểm thử
- Phân tích các lỗi phát hiện
- Đề xuất cải tiến

## 5. LỊCH TRÌNH THỰC HIỆN

| STT | Công việc | Thời gian | Người thực hiện |
|-----|-----------|-----------|-----------------|
| 1 | Chuẩn bị môi trường kiểm thử | Ngày 1 | Tester |
| 2 | Thiết kế test case | Ngày 1-2 | Tester |
| 3 | Kiểm thử đơn vị | Ngày 2-3 | Tester |
| 4 | Kiểm thử tích hợp | Ngày 3-4 | Tester |
| 5 | Kiểm thử hệ thống | Ngày 4-5 | Tester |
| 6 | Kiểm thử giao diện | Ngày 5 | Tester |
| 7 | Tổng hợp kết quả và báo cáo | Ngày 6 | Tester |

## 6. CHECKLIST KIỂM THỬ

### 6.1 Checklist kiểm thử chức năng
- [ ] Thêm thuốc mới thành công
- [ ] Cập nhật thông tin thuốc thành công
- [ ] Xóa thuốc thành công
- [ ] Tìm kiếm thuốc theo các tiêu chí khác nhau
- [ ] Phân trang danh sách thuốc
- [ ] Sắp xếp danh sách thuốc theo các tiêu chí
- [ ] Hiển thị chi tiết thuốc
- [ ] Quản lý loại thuốc (thêm, sửa, xóa)
- [ ] Quản lý danh mục thuốc (thêm, sửa, xóa)
- [ ] Quản lý thành phần thuốc
- [ ] Quản lý đối tượng sử dụng thuốc

### 6.2 Checklist kiểm thử giao diện
- [ ] Hiển thị đúng thông tin thuốc
- [ ] Hiển thị đúng thông tin loại thuốc
- [ ] Hiển thị đúng thông tin danh mục thuốc
- [ ] Các trường nhập liệu có validation phù hợp
- [ ] Hiển thị thông báo lỗi rõ ràng
- [ ] Responsive trên các thiết bị khác nhau
- [ ] Các nút chức năng hoạt động đúng

### 6.3 Checklist kiểm thử hiệu năng
- [ ] Thời gian phản hồi khi tải danh sách thuốc
- [ ] Thời gian phản hồi khi tìm kiếm thuốc
- [ ] Thời gian phản hồi khi thêm/sửa/xóa thuốc
- [ ] Tải trang chi tiết thuốc nhanh chóng

## 7. KẾT LUẬN VÀ ĐỀ XUẤT

Kế hoạch kiểm thử này đã đưa ra một cách tiếp cận có hệ thống để kiểm thử chức năng Quản lý thuốc trong hệ thống hiệu thuốc. Việc thực hiện đầy đủ các bước kiểm thử sẽ giúp đảm bảo chất lượng của chức năng này.

Một số đề xuất để cải thiện quá trình kiểm thử:
- Tự động hóa các test case để có thể chạy regression test nhanh chóng
- Sử dụng công cụ CI/CD để tích hợp kiểm thử vào quy trình phát triển
- Thực hiện kiểm thử bảo mật cho chức năng Quản lý thuốc
- Thực hiện kiểm thử hiệu năng với dữ liệu lớn
