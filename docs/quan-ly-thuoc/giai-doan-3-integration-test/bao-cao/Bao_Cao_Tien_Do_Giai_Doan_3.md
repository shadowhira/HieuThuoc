# BÁO CÁO TIẾN ĐỘ KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## GIAI ĐOẠN 3: KIỂM THỬ TÍCH HỢP (19/05/2025)

### 1. Mục tiêu
- Viết các test case tích hợp cho các thành phần Backend
- Kiểm thử API bằng Postman theo tài liệu Kiem_Thu_Chuc_Nang_Phan1.md
- Kiểm thử tích hợp giữa Frontend và Backend
- Phát hiện các lỗi tiềm ẩn trong quá trình tích hợp

### 2. Công việc đã thực hiện

#### 2.1 Kiểm thử tích hợp Backend
##### 2.1.1 Tích hợp ThuocController-ThuocService-ThuocRepository
- Đã viết test case cho các luồng:
  - Lấy danh sách thuốc
  - Tìm kiếm thuốc theo các tiêu chí
  - Thêm mới thuốc
  - Cập nhật thông tin thuốc
  - Xóa thuốc

##### 2.1.2 Tích hợp LoaiThuocController-LoaiThuocService-LoaiThuocRepository
- Đã viết test case cho các luồng:
  - Lấy danh sách loại thuốc
  - Tìm kiếm loại thuốc theo tên
  - Thêm mới loại thuốc
  - Cập nhật thông tin loại thuốc
  - Xóa loại thuốc

##### 2.1.3 Tích hợp DanhMucThuocController-DanhMucThuocService-DanhMucThuocRepository
- Đã viết test case cho các luồng:
  - Lấy danh sách danh mục thuốc
  - Lấy danh mục thuốc kèm loại thuốc
  - Tìm kiếm danh mục thuốc theo tên
  - Thêm mới danh mục thuốc
  - Cập nhật thông tin danh mục thuốc
  - Xóa danh mục thuốc

#### 2.2 Kiểm thử API bằng Postman
- Đã tạo Postman Collection cho các API:
  - API quản lý thuốc
  - API quản lý loại thuốc
  - API quản lý danh mục thuốc
- Đã viết test script cho các API theo tài liệu Kiem_Thu_Chuc_Nang_Phan1.md
- Đã chạy test và ghi nhận kết quả

#### 2.3 Kiểm thử tích hợp Frontend-Backend
- Đã viết test case Cypress cho các luồng:
  - Hiển thị danh sách thuốc
  - Tìm kiếm thuốc
  - Thêm mới thuốc
  - Cập nhật thông tin thuốc
  - Xóa thuốc
- Đã chạy test và ghi nhận kết quả

### 3. Kết quả đạt được

#### 3.1 Tổng quan
- Đã hoàn thành việc viết test case cho giai đoạn 3.1: Kiểm thử tích hợp Backend
- Đã hoàn thành việc tạo Postman Collection và test script cho giai đoạn 3.2: Kiểm thử API bằng Postman
- Đã hoàn thành việc viết test case Cypress cho giai đoạn 3.3: Kiểm thử tích hợp Frontend-Backend
- Đã viết tổng cộng 35 test case tích hợp
- Đã phát hiện một số vấn đề khi chạy test
- Đã giải quyết một phần vấn đề về cấu hình bảo mật trong môi trường test
- Đã giải quyết một phần vấn đề về khởi tạo ApplicationContext trong môi trường test
- Đã phát hiện vấn đề về cấu hình H2 database không tương thích với PostgreSQL

#### 3.2 Thống kê số lượng test case
| Thành phần | Số lượng test case | Tỷ lệ thành công |
|------------|-------------------|-----------------|
| Tích hợp Backend | 15 | 80% |
| API Postman | 10 | 0% |
| Tích hợp Frontend-Backend | 10 | 0% |
| **Tổng cộng** | **35** | **23%** |

#### 3.3 Thống kê lỗi phát hiện
| ID | Mô tả lỗi | Mức độ | Trạng thái |
|----|-----------|--------|------------|
| INT_BUG_001 | Lỗi cấu hình bảo mật trong môi trường test | Cao | Đã giải quyết một phần |
| INT_BUG_002 | Lỗi xử lý upload file khi thêm mới thuốc | Cao | Đã giải quyết một phần |
| INT_BUG_003 | Lỗi xử lý phân trang khi tìm kiếm thuốc | Thấp | Đang xử lý |
| INT_BUG_004 | Lỗi hiển thị thông báo lỗi khi API trả về lỗi | Trung bình | Đang xử lý |
| INT_BUG_005 | Lỗi xử lý đồng bộ giữa Frontend và Backend khi xóa thuốc | Cao | Đang xử lý |
| INT_BUG_006 | Lỗi khởi tạo ApplicationContext trong môi trường test | Cao | Đã giải quyết một phần |
| INT_BUG_007 | Lỗi cấu hình H2 database không tương thích với PostgreSQL | Cao | Đã phát hiện |

### 4. Khó khăn gặp phải và cách giải quyết
- **Cấu hình môi trường test**: Gặp khó khăn trong việc cấu hình môi trường test phù hợp
  - *Giải pháp*: Đã cấu hình H2 database và profile test riêng, nhưng vẫn gặp vấn đề với cấu trúc dữ liệu
- **Xử lý phụ thuộc giữa các thành phần**: Gặp khó khăn trong việc xử lý phụ thuộc giữa các thành phần
  - *Giải pháp*: Đã thử nghiệm cả @SpringBootTest và @WebMvcTest, nhưng vẫn gặp vấn đề với các bean phụ thuộc
- **Xử lý bảo mật trong test**: Gặp khó khăn trong việc xử lý bảo mật trong test
  - *Giải pháp*: Đã thử nghiệm @WithMockUser và mock JwtFilter, JwtService, nhưng vẫn gặp vấn đề với xung đột bean
- **Xử lý upload file trong test**: Gặp khó khăn trong việc xử lý upload file trong test
  - *Giải pháp*: Đã sử dụng MockMultipartFile, nhưng vẫn gặp vấn đề với cấu hình bảo mật
- **Xử lý bất đồng bộ trong Cypress**: Gặp khó khăn trong việc xử lý bất đồng bộ trong Cypress
  - *Giải pháp*: Đang nghiên cứu cách sử dụng cy.wait() và cy.intercept() hiệu quả
- **Xử lý data.sql trong H2**: Gặp khó khăn trong việc sử dụng data.sql với H2
  - *Giải pháp*: Đã tạo file data-test.sql riêng cho môi trường test, nhưng vẫn gặp vấn đề với cú pháp PostgreSQL không tương thích với H2

### 5. Kế hoạch tiếp theo
- Tiếp tục nghiên cứu và giải quyết các vấn đề gặp phải trong giai đoạn 3
- Tập trung vào việc giải quyết vấn đề cấu hình bảo mật trong môi trường test
- Xem xét việc sử dụng cách tiếp cận khác như:
  - Sử dụng TestRestTemplate thay vì MockMvc
  - Sử dụng cấu hình bảo mật đơn giản hơn cho môi trường test
  - Tạo một ứng dụng test riêng biệt với cấu hình tối thiểu
- Hoàn thiện việc chạy test và ghi nhận kết quả
- Xử lý các lỗi đã phát hiện
- Chuẩn bị cho giai đoạn 4: Kiểm thử chức năng

### 6. Hướng dẫn thực hiện test

#### 6.1 Chạy kiểm thử tích hợp Backend
```bash
cd BE
# Chạy tất cả các test tích hợp
mvn test -Dtest=com.example.hieuthuoc.integration.*

# Chạy test tích hợp cho ThuocController
mvn test -Dtest=com.example.hieuthuoc.integration.VerySimpleThuocControllerTest

# Chạy test tích hợp cho LoaiThuocController
mvn test -Dtest=com.example.hieuthuoc.integration.LoaiThuocControllerTest

# Chạy test tích hợp cho DanhMucThuocController
mvn test -Dtest=com.example.hieuthuoc.integration.DanhMucThuocControllerTest
```

#### 6.2 Chạy kiểm thử API bằng Postman
1. Import Postman Collection từ file `postman/QuanLyThuoc.postman_collection.json`
2. Import Postman Environment từ file `postman/Local.postman_environment.json`
3. Chạy Collection Runner

#### 6.3 Chạy kiểm thử tích hợp Frontend-Backend
```bash
cd FE
npm run cypress:open
```

### 7. Bài học kinh nghiệm
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
