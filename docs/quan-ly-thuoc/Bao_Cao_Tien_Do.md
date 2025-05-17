# BÁO CÁO TIẾN ĐỘ KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## GIAI ĐOẠN 1: CHUẨN BỊ (17/05/2025)

### 1. Mục tiêu
- Chuẩn bị môi trường kiểm thử
- Cài đặt các công cụ kiểm thử cần thiết
- Chuẩn bị dữ liệu kiểm thử

### 2. Công việc đã thực hiện

#### 2.1 Cài đặt JUnit và Mockito cho kiểm thử Backend
- Đã thêm dependency Mockito vào file `pom.xml`:
  ```xml
  <dependency>
      <groupId>org.mockito</groupId>
      <artifactId>mockito-core</artifactId>
      <version>5.3.1</version>
      <scope>test</scope>
  </dependency>

  <dependency>
      <groupId>org.mockito</groupId>
      <artifactId>mockito-junit-jupiter</artifactId>
      <version>5.3.1</version>
      <scope>test</scope>
  </dependency>
  ```
- Spring Boot Test đã có sẵn trong dự án

#### 2.2 Cài đặt Cypress cho kiểm thử Frontend
- Đã tạo cấu trúc thư mục Cypress:
  ```
  FE/cypress/
  ├── e2e/
  │   └── quan-ly-thuoc/
  ├── fixtures/
  │   └── thuoc.json
  └── support/
      ├── commands.js
      └── e2e.js
  ```
- Đã tạo file cấu hình Cypress `cypress.config.js`
- Đã tạo các custom commands cho kiểm thử

#### 2.3 Cài đặt Postman cho kiểm thử API
- Đã tạo collection Postman cho kiểm thử API quản lý thuốc
- Đã tạo các request mẫu cho các API chính: đăng nhập, lấy thuốc, tìm kiếm thuốc, thêm thuốc, cập nhật thuốc, xóa thuốc

#### 2.4 Chuẩn bị dữ liệu kiểm thử
- Đã tạo file `data-test.sql` chứa dữ liệu mẫu cho kiểm thử
- Đã tạo file `application-test.properties` cho môi trường kiểm thử
- Đã tạo file dữ liệu mẫu `thuoc.json` cho kiểm thử Frontend

### 3. Kết quả đạt được
- Đã hoàn thành 100% công việc của giai đoạn 1
- Môi trường kiểm thử đã được chuẩn bị đầy đủ
- Các công cụ kiểm thử đã được cài đặt và cấu hình
- Dữ liệu kiểm thử đã được chuẩn bị và đồng bộ với dữ liệu trong hệ thống

### 4. Khó khăn gặp phải
- Gặp một số vấn đề khi cài đặt Cypress thông qua npm, đã giải quyết bằng cách tạo cấu trúc thư mục và file cấu hình thủ công
- Đã tạo file package.cypress.json để hỗ trợ cài đặt Cypress trong tương lai

### 5. Kế hoạch tiếp theo
- Chuyển sang giai đoạn 2: Kiểm thử đơn vị
- Viết test case cho ThuocService, LoaiThuocService, DanhMucThuocService
- Viết test case cho ThuocController, LoaiThuocController, DanhMucThuocController
