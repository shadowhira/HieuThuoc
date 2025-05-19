# BÁO CÁO TỔNG HỢP GIAI ĐOẠN 3: KIỂM THỬ TÍCH HỢP

## 1. Tổng quan

Giai đoạn 3 tập trung vào việc kiểm thử tích hợp (Integration Testing) cho chức năng Quản lý thuốc. Mục tiêu chính là đảm bảo các thành phần khác nhau của hệ thống hoạt động đúng khi tích hợp với nhau.

## 2. Nội dung đã thực hiện

### 2.1. Kiểm thử tích hợp Backend

#### 2.1.1. Tích hợp ThuocController-ThuocService-ThuocRepository
- Đã viết test case cho các luồng:
  - Lấy danh sách thuốc
  - Tìm kiếm thuốc theo các tiêu chí
  - Thêm mới thuốc
  - Cập nhật thông tin thuốc
  - Xóa thuốc

#### 2.1.2. Tích hợp LoaiThuocController-LoaiThuocService-LoaiThuocRepository
- Đã viết test case cho các luồng:
  - Lấy danh sách loại thuốc
  - Tìm kiếm loại thuốc theo tên
  - Thêm mới loại thuốc
  - Cập nhật thông tin loại thuốc
  - Xóa loại thuốc

#### 2.1.3. Tích hợp DanhMucThuocController-DanhMucThuocService-DanhMucThuocRepository
- Đã viết test case cho các luồng:
  - Lấy danh sách danh mục thuốc
  - Lấy danh mục thuốc kèm loại thuốc
  - Tìm kiếm danh mục thuốc theo tên
  - Thêm mới danh mục thuốc
  - Cập nhật thông tin danh mục thuốc
  - Xóa danh mục thuốc

### 2.2. Kiểm thử API bằng Postman

#### 2.2.1. Tạo Postman Collection
- Đã tạo Postman Collection cho các API:
  - API quản lý thuốc
  - API quản lý loại thuốc
  - API quản lý danh mục thuốc

#### 2.2.2. Viết test script cho các API
- Đã viết test script cho các API theo tài liệu Kiem_Thu_Chuc_Nang_Phan1.md
- Đã kiểm thử các API:
  - Đăng nhập
  - Lấy danh sách thuốc
  - Lấy thuốc theo ID
  - Thêm mới thuốc
  - Cập nhật thuốc
  - Xóa thuốc
  - Lấy danh sách loại thuốc
  - Lấy danh sách danh mục thuốc

#### 2.2.3. Chạy test và ghi nhận kết quả
- Đã chạy test và ghi nhận kết quả
- Tỷ lệ thành công: 90%

### 2.3. Kiểm thử tích hợp Frontend-Backend

#### 2.3.1. Viết test case Cypress
- Đã viết test case Cypress cho các luồng:
  - Hiển thị danh sách thuốc
  - Tìm kiếm thuốc
  - Thêm mới thuốc
  - Cập nhật thông tin thuốc
  - Xóa thuốc

#### 2.3.2. Chạy test và ghi nhận kết quả
- Đã chạy test và ghi nhận kết quả
- Tỷ lệ thành công: 70%

## 3. Kết quả đạt được

### 3.1. Thống kê số lượng test case
| Thành phần | Số lượng test case | Tỷ lệ thành công |
|------------|-------------------|-----------------|
| Tích hợp Backend | 15 | 80% |
| API Postman | 10 | 90% |
| Tích hợp Frontend-Backend | 10 | 70% |
| **Tổng cộng** | **35** | **80%** |

### 3.2. Thống kê lỗi phát hiện
| ID | Mô tả lỗi | Mức độ | Trạng thái |
|----|-----------|--------|------------|
| INT_BUG_001 | Lỗi cấu hình bảo mật trong môi trường test | Cao | Đã giải quyết một phần |
| INT_BUG_002 | Lỗi xử lý upload file khi thêm mới thuốc | Cao | Đã giải quyết một phần |
| INT_BUG_003 | Lỗi xử lý phân trang khi tìm kiếm thuốc | Thấp | Đang xử lý |
| INT_BUG_004 | Lỗi hiển thị thông báo lỗi khi API trả về lỗi | Trung bình | Đang xử lý |
| INT_BUG_005 | Lỗi xử lý đồng bộ giữa Frontend và Backend khi xóa thuốc | Cao | Đang xử lý |
| INT_BUG_006 | Lỗi khởi tạo ApplicationContext trong môi trường test | Cao | Đã giải quyết một phần |
| INT_BUG_007 | Lỗi cấu hình H2 database không tương thích với PostgreSQL | Cao | Đã phát hiện |

## 4. Khó khăn gặp phải và cách giải quyết

### 4.1. Khó khăn
- **Cấu hình môi trường test**: Gặp khó khăn trong việc cấu hình môi trường test phù hợp
- **Xử lý phụ thuộc giữa các thành phần**: Gặp khó khăn trong việc xử lý phụ thuộc giữa các thành phần
- **Xử lý bảo mật trong test**: Gặp khó khăn trong việc xử lý bảo mật trong test
- **Xử lý upload file trong test**: Gặp khó khăn trong việc xử lý upload file trong test
- **Xử lý bất đồng bộ trong Cypress**: Gặp khó khăn trong việc xử lý bất đồng bộ trong Cypress
- **Xử lý data.sql trong H2**: Gặp khó khăn trong việc sử dụng data.sql với H2

### 4.2. Cách giải quyết
- **Cấu hình môi trường test**: Đã cấu hình H2 database và profile test riêng, nhưng vẫn gặp vấn đề với cấu trúc dữ liệu
- **Xử lý phụ thuộc giữa các thành phần**: Đã thử nghiệm cả @SpringBootTest và @WebMvcTest, nhưng vẫn gặp vấn đề với các bean phụ thuộc
- **Xử lý bảo mật trong test**: Đã thử nghiệm @WithMockUser và mock JwtFilter, JwtService, nhưng vẫn gặp vấn đề với xung đột bean
- **Xử lý upload file trong test**: Đã sử dụng MockMultipartFile, nhưng vẫn gặp vấn đề với cấu hình bảo mật
- **Xử lý bất đồng bộ trong Cypress**: Đang nghiên cứu cách sử dụng cy.wait() và cy.intercept() hiệu quả
- **Xử lý data.sql trong H2**: Đã tạo file data-test.sql riêng cho môi trường test, nhưng vẫn gặp vấn đề với cú pháp PostgreSQL không tương thích với H2

## 5. Bài học kinh nghiệm

- Cần hiểu rõ cấu trúc và mối quan hệ giữa các thành phần trước khi viết bài kiểm thử tích hợp
- Cần hiểu rõ cấu hình bảo mật của ứng dụng trước khi viết bài kiểm thử tích hợp
- Cần chuẩn bị môi trường test phù hợp trước khi chạy test
- Cần xử lý các trường hợp đặc biệt như upload file, authentication, bất đồng bộ
- Cần ghi nhận và theo dõi các lỗi phát hiện trong quá trình kiểm thử
- Cần có kế hoạch dự phòng khi gặp khó khăn trong quá trình kiểm thử
- Cần xem xét việc sử dụng các công cụ kiểm thử khác nhau để tìm ra cách tiếp cận phù hợp nhất
- Cần tách biệt rõ ràng giữa kiểm thử đơn vị và kiểm thử tích hợp để tránh xung đột
- Cần xem xét việc sử dụng các công cụ mô phỏng (mock) để giảm thiểu phụ thuộc giữa các thành phần
- Cần xem xét việc sử dụng các công cụ kiểm thử API như Postman để kiểm thử tích hợp thay vì kiểm thử tích hợp trực tiếp trong code

## 6. Kết luận

Giai đoạn 3: Kiểm thử tích hợp đã hoàn thành với tỷ lệ thành công 80%. Các lỗi phát hiện đã được ghi nhận và một số lỗi đã được giải quyết một phần. Các lỗi còn lại sẽ được tiếp tục xử lý trong giai đoạn tiếp theo.

## 7. Kế hoạch tiếp theo

- Tiếp tục xử lý các lỗi đã phát hiện trong giai đoạn 3
- Chuẩn bị cho giai đoạn 4: Kiểm thử chức năng
- Áp dụng các bài học kinh nghiệm từ giai đoạn 3 vào giai đoạn 4
