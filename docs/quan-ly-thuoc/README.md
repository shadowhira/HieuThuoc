# HƯỚNG DẪN KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc. Tài liệu được tổ chức theo quy trình kiểm thử, từ lập kế hoạch đến triển khai và báo cáo kết quả.

## 🗂️ CẤU TRÚC TÀI LIỆU

- **[Tai_Lieu_Kiem_Thu_Tong_Hop.md](./Tai_Lieu_Kiem_Thu_Tong_Hop.md)**: Tài liệu tổng hợp đầy đủ về kiểm thử chức năng Quản lý thuốc
- **[Ke_Hoach_Trien_Khai_Kiem_Thu.md](./Ke_Hoach_Trien_Khai_Kiem_Thu.md)**: Kế hoạch triển khai kiểm thử chi tiết
- **[Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)**: Hướng dẫn kiểm thử chức năng thêm thuốc
- **[Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)**: Hướng dẫn kiểm thử chức năng cập nhật và xóa thuốc
- **[Kiem_Thu_Chuc_Nang_Phan3.md](./Kiem_Thu_Chuc_Nang_Phan3.md)**: Hướng dẫn kiểm thử chức năng tìm kiếm thuốc
- **[giai-doan-2-unit-test](./giai-doan-2-unit-test)**: Tài liệu và test case giai đoạn 2 (Kiểm thử đơn vị)
  - **[README.md](./giai-doan-2-unit-test/README.md)**: Tổng quan về giai đoạn 2
  - **[bao-cao/Bao_Cao_Tien_Do_Giai_Doan_2.md](./giai-doan-2-unit-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_2.md)**: Báo cáo tiến độ giai đoạn 2
  - **[service-test/](./giai-doan-2-unit-test/service-test)**: Test case cho các service
  - **[controller-test/](./giai-doan-2-unit-test/controller-test)**: Test case cho các controller
- **[giai-doan-3-integration-test](./giai-doan-3-integration-test)**: Tài liệu và test case giai đoạn 3 (Kiểm thử tích hợp)
  - **[README.md](./giai-doan-3-integration-test/README.md)**: Tổng quan về giai đoạn 3
  - **[bao-cao/Bao_Cao_Tien_Do_Giai_Doan_3.md](./giai-doan-3-integration-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_3.md)**: Báo cáo tiến độ giai đoạn 3
  - **[backend-test/](./giai-doan-3-integration-test/backend-test)**: Test case cho tích hợp Backend
  - **[postman-test/](./giai-doan-3-integration-test/postman-test)**: Test case cho API bằng Postman
  - **[frontend-backend-test/](./giai-doan-3-integration-test/frontend-backend-test)**: Test case cho tích hợp Frontend-Backend
- **[giai-doan-4-functional-test](./giai-doan-4-functional-test)**: Tài liệu và test case giai đoạn 4 (Kiểm thử chức năng)
  - **[README.md](./giai-doan-4-functional-test/README.md)**: Tổng quan về giai đoạn 4
  - **[bao-cao/Bao_Cao_Tien_Do_Giai_Doan_4.md](./giai-doan-4-functional-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_4.md)**: Báo cáo tiến độ giai đoạn 4
  - **[postman-test/](./giai-doan-4-functional-test/postman-test)**: Test case cho API bằng Postman
  - **[cypress-test/](./giai-doan-4-functional-test/cypress-test)**: Test case cho giao diện bằng Cypress
- **[giai-doan-5-ui-test](./giai-doan-5-ui-test)**: Tài liệu và test case giai đoạn 5 (Kiểm thử giao diện)
  - **[README.md](./giai-doan-5-ui-test/README.md)**: Tổng quan về giai đoạn 5
  - **[bao-cao/Bao_Cao_Tien_Do_Giai_Doan_5.md](./giai-doan-5-ui-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_5.md)**: Báo cáo tiến độ giai đoạn 5
  - **[testcase/UI_TestCase_TiengViet.csv](./giai-doan-5-ui-test/testcase/UI_TestCase_TiengViet.csv)**: Test case văn bản cho kiểm thử giao diện

## 🚀 QUY TRÌNH TRIỂN KHAI KIỂM THỬ

### Giai đoạn 1: Chuẩn bị (Ngày 1)
- [x] **Đọc tài liệu**: Đọc [Tai_Lieu_Kiem_Thu_Tong_Hop.md](./Tai_Lieu_Kiem_Thu_Tong_Hop.md) (Phần 1-2) để hiểu tổng quan
- [x] **Chuẩn bị môi trường**:
  - [x] Cài đặt JUnit, Mockito cho kiểm thử Backend
  - [x] Cài đặt Cypress cho kiểm thử Frontend
  - [x] Cài đặt Postman cho kiểm thử API
  - [x] Chuẩn bị dữ liệu kiểm thử theo [Ke_Hoach_Trien_Khai_Kiem_Thu.md](./Ke_Hoach_Trien_Khai_Kiem_Thu.md)

### Giai đoạn 2: Kiểm thử đơn vị (Ngày 1-2)
- [x] **Kiểm thử Service**:
  - [x] ThuocService: Thêm, sửa, xóa, tìm kiếm
  - [x] LoaiThuocService: Thêm, sửa, xóa, tìm kiếm
  - [x] DanhMucThuocService: Thêm, sửa, xóa, tìm kiếm
- [x] **Kiểm thử Controller**:
  - [x] ThuocController: Thêm, sửa, xóa, tìm kiếm
  - [x] LoaiThuocController: Thêm, sửa, xóa, tìm kiếm
  - [x] DanhMucThuocController: Thêm, sửa, xóa, tìm kiếm

### Giai đoạn 3: Kiểm thử tích hợp (Ngày 2-3)
- [x] **Kiểm thử tích hợp Backend**:
  - [x] Kiểm thử tích hợp giữa các thành phần Backend
  - [x] Kiểm thử API bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)
- [x] **Kiểm thử tích hợp Frontend-Backend**:
  - [x] Kiểm thử tích hợp giữa Frontend và Backend

### Giai đoạn 4: Kiểm thử chức năng (Ngày 3-4)
- [x] **Kiểm thử chức năng thêm thuốc**:
  - [x] Kiểm thử API thêm thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)
  - [x] Kiểm thử chức năng thêm thuốc bằng Cypress
- [x] **Kiểm thử chức năng cập nhật thuốc**:
  - [x] Kiểm thử API cập nhật thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)
  - [x] Kiểm thử chức năng cập nhật thuốc bằng Cypress
- [x] **Kiểm thử chức năng xóa thuốc**:
  - [x] Kiểm thử API xóa thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)
  - [x] Kiểm thử chức năng xóa thuốc bằng Cypress
- [x] **Kiểm thử chức năng tìm kiếm thuốc**:
  - [x] Kiểm thử API tìm kiếm thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan3.md](./Kiem_Thu_Chuc_Nang_Phan3.md)
  - [x] Kiểm thử chức năng tìm kiếm thuốc bằng Cypress

### Giai đoạn 5: Kiểm thử giao diện (Ngày 4-5)
- [x] **Kiểm thử giao diện danh sách thuốc**
- [x] **Kiểm thử giao diện thêm/sửa thuốc**
- [x] **Kiểm thử giao diện chi tiết thuốc**
- [x] **Kiểm thử giao diện tìm kiếm thuốc**
- [x] **Kiểm thử tính responsive**

### Giai đoạn 6: Kiểm thử hệ thống (Ngày 5)
- [x] **Kiểm thử luồng nghiệp vụ (End-to-End Testing)**:
  - [x] Luồng thêm thuốc mới
  - [x] Luồng sửa thông tin thuốc
  - [x] Luồng xóa thuốc
- [x] **Kiểm thử hiệu năng (Performance Testing)**:
  - [x] Chuẩn bị JMeter Test Plan
  - [x] Chạy kiểm thử hiệu năng
- [x] **Kiểm thử tương thích (Compatibility Testing)**:
  - [x] Kiểm thử trên các trình duyệt khác nhau

### Giai đoạn 7: Tổng hợp và báo cáo (Ngày 6)
- [ ] **Tổng hợp kết quả kiểm thử**
- [ ] **Phân tích lỗi**
- [ ] **Đề xuất cải tiến**
- [ ] **Viết báo cáo kiểm thử**
- [ ] **Viết testcase bằng văn bản**:
  - [ ] Tạo file CSV/Excel theo mẫu testcase tiếng Việt
  - [ ] Viết testcase chi tiết cho từng chức năng theo cấu trúc sau:
    - **Thông tin chung**: Tên chức năng, kết quả kiểm thử trên các trình duyệt
    - **Mô tả**: Mô tả ngắn gọn về testcase
    - **Các bước thực hiện**: Liệt kê chi tiết từng bước thực hiện
    - **Kết quả mong đợi**: Mô tả kết quả mong đợi sau khi thực hiện
    - **Kết quả thực tế**: Ghi nhận kết quả thực tế trên từng trình duyệt
    - **Trạng thái**: Passed/Failed/Not Run/NA
    - **Ghi chú**: Thông tin bổ sung (nếu có)

Xem hướng dẫn chi tiết tại [giai-doan-7-tong-hop-bao-cao/README.md](./giai-doan-7-tong-hop-bao-cao/README.md)

## 📊 THEO DÕI TIẾN ĐỘ

| Giai đoạn | Tiến độ | Ngày hoàn thành |
|-----------|---------|-----------------|
| Giai đoạn 1: Chuẩn bị | 100% | 17/05/2025 |
| Giai đoạn 2: Kiểm thử đơn vị | 100% | 18/05/2025 |
| Giai đoạn 3: Kiểm thử tích hợp | 100% | 19/05/2025 |
| Giai đoạn 4: Kiểm thử chức năng | 100% | 20/05/2025 |
| Giai đoạn 5: Kiểm thử giao diện | 100% | 21/05/2025 |
| Giai đoạn 6: Kiểm thử hệ thống | 100% | 22/05/2025 |
| Giai đoạn 7: Tổng hợp và báo cáo | 100% | 24/05/2025 |
| - Tổng hợp kết quả kiểm thử | 100% | 23/05/2025 |
| - Phân tích lỗi | 100% | 23/05/2025 |
| - Đề xuất cải tiến | 100% | 23/05/2025 |
| - Viết báo cáo kiểm thử | 100% | 24/05/2025 |
| - Viết testcase bằng văn bản | 100% | 24/05/2025 |

## 🔍 TEST CASE QUAN TRỌNG

### Kết quả kiểm thử

| Chức năng | Chrome | Firefox |
|-----------|--------|---------|
| Tổng số test case | 43 | 43 |
| Đã chạy | 43 | 43 |
| Thành công | 43 | 43 |
| Thất bại | 0 | 0 |
| Không chạy | 0 | 0 |

### Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| **I. Kiểm thử Service** |
| **1. ThuocService** |
| TS_001 | Lấy danh sách thuốc thành công | 1. Mock repository trả về danh sách thuốc<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách thuốc | Thành công | |
| TS_002 | Lấy danh sách thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| TS_003 | Tìm thuốc theo ID thành công | 1. Mock repository trả về thuốc<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 200 và thông tin thuốc | Thành công | |
| TS_004 | Tìm thuốc theo ID không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| TS_005 | Tạo thuốc thành công | 1. Mock repository trả về thuốc đã tạo<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 201 và thông tin thuốc | Thành công | |
| TS_006 | Cập nhật thuốc thành công | 1. Mock repository trả về thuốc đã cập nhật<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 200 và thông tin thuốc | Thành công | |
| TS_007 | Xóa thuốc thành công | 1. Mock repository không ném exception<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 200 và thông báo thành công | Thành công | |
| **2. LoaiThuocService** |
| LS_001 | Lấy danh sách loại thuốc thành công | 1. Mock repository trả về danh sách loại thuốc<br>2. Gọi phương thức getAllLoaiThuocs() | Trả về ResponseDTO với status 200 và danh sách loại thuốc | Thành công | |
| LS_002 | Lấy danh sách loại thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getAllLoaiThuocs() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| LS_003 | Tìm loại thuốc theo tên thành công | 1. Mock repository trả về danh sách loại thuốc<br>2. Gọi phương thức searchByTenLoai() | Trả về ResponseDTO với status 200 và danh sách loại thuốc | Thành công | |
| LS_004 | Tạo loại thuốc thành công | 1. Mock repository trả về loại thuốc đã tạo<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 201 và thông tin loại thuốc | Thành công | |
| LS_005 | Cập nhật loại thuốc thành công | 1. Mock repository trả về loại thuốc đã cập nhật<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 200 và thông tin loại thuốc | Thành công | |
| LS_006 | Xóa loại thuốc thành công | 1. Mock repository không ném exception<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 200 và thông báo thành công | Thành công | |
| **3. DanhMucThuocService** |
| DS_001 | Lấy danh sách danh mục thuốc thành công | 1. Mock repository trả về danh sách danh mục thuốc<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách danh mục thuốc | Thành công | |
| DS_002 | Lấy danh sách danh mục thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| DS_003 | Tìm danh mục thuốc theo tên thành công | 1. Mock repository trả về danh sách danh mục thuốc<br>2. Gọi phương thức searchByTenDanhMuc() | Trả về ResponseDTO với status 200 và danh sách danh mục thuốc | Thành công | |
| DS_004 | Tạo danh mục thuốc thành công | 1. Mock repository trả về danh mục thuốc đã tạo<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 201 và thông tin danh mục thuốc | Thành công | |
| DS_005 | Cập nhật danh mục thuốc thành công | 1. Mock repository trả về danh mục thuốc đã cập nhật<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 200 và thông tin danh mục thuốc | Thành công | |
| DS_006 | Xóa danh mục thuốc thành công | 1. Mock repository không ném exception<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 200 và thông báo thành công | Thành công | |
| **II. Kiểm thử Controller** |
| **1. ThuocController** |
| TC_001 | Lấy danh sách thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /thuoc/getAll | Trả về status 200 và danh sách thuốc | Thành công | |
| TC_002 | Tìm thuốc theo ID thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /thuoc/getById | Trả về status 200 và thông tin thuốc | Thành công | |
| TC_003 | Tạo thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /thuoc/create | Trả về status 201 và thông tin thuốc | Thành công | |
| TC_004 | Cập nhật thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API PUT /thuoc/update | Trả về status 200 và thông tin thuốc | Thành công | |
| TC_005 | Xóa thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API DELETE /thuoc/delete | Trả về status 200 và thông báo thành công | Thành công | |
| **2. LoaiThuocController** |
| LC_001 | Lấy danh sách loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /loai-thuoc/getAll | Trả về status 200 và danh sách loại thuốc | Thành công | |
| LC_002 | Tìm loại thuốc theo tên thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /loai-thuoc/search | Trả về status 200 và danh sách loại thuốc | Thành công | |
| LC_003 | Tạo loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /loai-thuoc/create | Trả về status 201 và thông tin loại thuốc | Thành công | |
| LC_004 | Cập nhật loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API PUT /loai-thuoc/update | Trả về status 200 và thông tin loại thuốc | Thành công | |
| LC_005 | Xóa loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API DELETE /loai-thuoc/delete | Trả về status 200 và thông báo thành công | Thành công | |
| **3. DanhMucThuocController** |
| DC_001 | Lấy danh sách danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /danh-muc-thuoc/getAll | Trả về status 200 và danh sách danh mục thuốc | Thành công | |
| DC_002 | Tìm danh mục thuốc theo tên thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /danh-muc-thuoc/search | Trả về status 200 và danh sách danh mục thuốc | Thành công | |
| DC_003 | Tạo danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /danh-muc-thuoc/create | Trả về status 201 và thông tin danh mục thuốc | Thành công | |
| DC_004 | Cập nhật danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API PUT /danh-muc-thuoc/update | Trả về status 200 và thông tin danh mục thuốc | Thành công | |
| DC_005 | Xóa danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API DELETE /danh-muc-thuoc/delete | Trả về status 200 và thông báo thành công | Thành công | |
| **III. Các vấn đề phát hiện** |
| BUG_001 | Lỗi trạng thái khi danh sách trống | 1. Kiểm tra trạng thái trả về khi danh sách trống | Trạng thái 409 khi danh sách trống | Trạng thái 200 khi danh sách trống | Không nghiêm trọng, nhưng có thể gây nhầm lẫn cho frontend |
| BUG_002 | Lỗi StackOverflowError do quan hệ hai chiều | 1. Kiểm tra quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc | Không có lỗi | StackOverflowError do vòng lặp vô hạn khi gọi toString() | Gây crash ứng dụng khi serialize đối tượng |
| BUG_003 | Lỗi thông báo không khớp | 1. Kiểm tra thông báo lỗi khi không tìm thấy đối tượng | "Loại thuốc không tồn tại" | "Không tìm thấy loại thuốc" | Không nghiêm trọng, nhưng có thể gây nhầm lẫn cho người dùng |
| BUG_004 | Lỗi phương thức HTTP không đúng | 1. Kiểm tra phương thức HTTP cho multipart/form-data | Phương thức POST | Yêu cầu phương thức PUT | Gây lỗi 405 Method Not Allowed khi gọi API |

## 📝 LƯU Ý QUAN TRỌNG

1. **Ưu tiên theo chức năng**: Nếu thời gian hạn chế, hãy ưu tiên kiểm thử các chức năng quan trọng nhất (thêm, sửa, xóa, tìm kiếm thuốc) trước.

2. **Tự động hóa**: Tự động hóa càng nhiều kiểm thử càng tốt để tiết kiệm thời gian và đảm bảo tính nhất quán.

3. **Phát hiện lỗi sớm**: Cố gắng phát hiện lỗi càng sớm càng tốt trong quy trình kiểm thử, vì chi phí sửa lỗi sẽ tăng theo thời gian.

4. **Theo dõi lỗi**: Sử dụng công cụ quản lý lỗi để theo dõi các lỗi phát hiện và trạng thái xử lý.

5. **Cập nhật tài liệu**: Cập nhật tài liệu kiểm thử khi có thay đổi trong yêu cầu hoặc thiết kế.

6. **Kết hợp testcase văn bản và tự động**: Hoàn thiện các autotest trước, sau đó viết testcase bằng văn bản theo mẫu đã cung cấp để đảm bảo tính đầy đủ và chi tiết của quá trình kiểm thử.

## 📞 HỖ TRỢ

Nếu bạn gặp khó khăn trong quá trình triển khai kiểm thử, hãy liên hệ với:
- **Người phụ trách kiểm thử**: [Tên người phụ trách]
- **Email**: [Email người phụ trách]
- **Số điện thoại**: [Số điện thoại người phụ trách]
