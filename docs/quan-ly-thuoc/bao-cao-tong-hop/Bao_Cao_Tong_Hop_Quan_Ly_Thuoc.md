# BÁO CÁO TỔNG HỢP KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Thời gian thực hiện**: 01/04/2025 - 26/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc
- **Phiên bản**: 1.0

## MỤC LỤC

1. [Tổng quan](#1-tổng-quan)
   1. [Giới thiệu về dự án](#11-giới-thiệu-về-dự-án)
   2. [Phạm vi kiểm thử](#12-phạm-vi-kiểm-thử)
   3. [Phương pháp kiểm thử](#13-phương-pháp-kiểm-thử)
   4. [Môi trường kiểm thử](#14-môi-trường-kiểm-thử)
2. [Kết quả kiểm thử](#2-kết-quả-kiểm-thử)
   1. [Tổng hợp kết quả kiểm thử](#21-tổng-hợp-kết-quả-kiểm-thử)
   2. [Biểu đồ tổng hợp](#22-biểu-đồ-tổng-hợp)
   3. [Phân tích lỗi](#23-phân-tích-lỗi)
   4. [Đề xuất cải tiến](#24-đề-xuất-cải-tiến)
3. [Chi tiết kiểm thử](#3-chi-tiết-kiểm-thử)
   1. [Giai đoạn 2: Kiểm thử đơn vị](#31-giai-đoạn-2-kiểm-thử-đơn-vị)
   2. [Giai đoạn 3: Kiểm thử tích hợp](#32-giai-đoạn-3-kiểm-thử-tích-hợp)
   3. [Giai đoạn 4: Kiểm thử chức năng](#33-giai-đoạn-4-kiểm-thử-chức-năng)
   4. [Giai đoạn 5: Kiểm thử giao diện](#34-giai-đoạn-5-kiểm-thử-giao-diện)
   5. [Giai đoạn 6: Kiểm thử hệ thống](#35-giai-đoạn-6-kiểm-thử-hệ-thống)
   6. [Giai đoạn 7: Kiểm thử hộp đen và hộp trắng](#36-giai-đoạn-7-kiểm-thử-hộp-đen-và-hộp-trắng)
4. [Kết luận và kiến nghị](#4-kết-luận-và-kiến-nghị)
   1. [Kết luận](#41-kết-luận)
   2. [Kiến nghị](#42-kiến-nghị)
5. [Phụ lục](#5-phụ-lục)
   1. [Danh sách testcase](#51-danh-sách-testcase)
   2. [Hướng dẫn chạy test](#52-hướng-dẫn-chạy-test)

## 1. TỔNG QUAN

### 1.1 Giới thiệu về dự án

Hệ thống web bán và quản lý hiệu thuốc là một ứng dụng web được phát triển nhằm hỗ trợ các hiệu thuốc trong việc quản lý thuốc, bán hàng và theo dõi doanh thu. Module Quản lý thuốc là một trong những module quan trọng nhất của hệ thống, cho phép người dùng thực hiện các chức năng:

- Thêm, sửa, xóa thông tin thuốc
- Tìm kiếm thuốc theo nhiều tiêu chí
- Quản lý loại thuốc và danh mục thuốc
- Theo dõi số lượng tồn kho
- Cập nhật giá bán và giá nhập

Hệ thống được phát triển sử dụng kiến trúc microservices với:
- **Backend**: Spring Boot, Java 11
- **Frontend**: Angular 13
- **Cơ sở dữ liệu**: PostgreSQL 14

### 1.2 Phạm vi kiểm thử

Báo cáo này tổng hợp kết quả kiểm thử của module Quản lý thuốc, bao gồm các giai đoạn:

1. **Giai đoạn 2: Kiểm thử đơn vị (Unit Testing)**
   - Kiểm thử các thành phần riêng lẻ: Service, Controller, Repository
   - Sử dụng JUnit và Mockito

2. **Giai đoạn 3: Kiểm thử tích hợp (Integration Testing)**
   - Kiểm thử tích hợp giữa các thành phần Backend
   - Kiểm thử tích hợp Frontend-Backend
   - Kiểm thử tích hợp với cơ sở dữ liệu

3. **Giai đoạn 4: Kiểm thử chức năng (Functional Testing)**
   - Kiểm thử chức năng thêm, sửa, xóa thuốc
   - Kiểm thử chức năng tìm kiếm thuốc
   - Kiểm thử xử lý lỗi

4. **Giai đoạn 5: Kiểm thử giao diện (UI Testing)**
   - Kiểm thử giao diện danh sách thuốc
   - Kiểm thử giao diện thêm/sửa thuốc
   - Kiểm thử giao diện chi tiết thuốc
   - Kiểm thử giao diện tìm kiếm thuốc

5. **Giai đoạn 6: Kiểm thử hệ thống (System Testing)**
   - Kiểm thử luồng nghiệp vụ (End-to-End Testing)
   - Kiểm thử hiệu năng (Performance Testing)
   - Kiểm thử tương thích (Compatibility Testing)
   - Kiểm thử bảo mật (Security Testing)

6. **Giai đoạn 7: Kiểm thử hộp đen và hộp trắng**
   - Kiểm thử hộp đen (Black-box Testing)
   - Kiểm thử hộp trắng (White-box Testing)
   - Kiểm thử phân tích giá trị biên (Boundary Value Analysis)
   - Kiểm thử phân tích đường dẫn (Path Analysis)

### 1.3 Phương pháp kiểm thử

Trong quá trình kiểm thử module Quản lý thuốc, chúng tôi đã áp dụng các phương pháp kiểm thử sau:

1. **Kiểm thử hộp đen (Black-box Testing)**
   - Kiểm thử chức năng (Functional Testing)
   - Kiểm thử giao diện người dùng (UI Testing)
   - Kiểm thử phân tích giá trị biên (Boundary Value Analysis)
   - Kiểm thử phân vùng tương đương (Equivalence Partitioning)
   - Kiểm thử bảng quyết định (Decision Table Testing)
   - Kiểm thử trạng thái (State Transition Testing)

2. **Kiểm thử hộp trắng (White-box Testing)**
   - Kiểm thử đơn vị (Unit Testing)
   - Kiểm thử tích hợp (Integration Testing)
   - Kiểm thử phân tích đường dẫn (Path Analysis)
   - Kiểm thử bao phủ mã nguồn (Code Coverage Testing)

3. **Kiểm thử tự động (Automated Testing)**
   - Sử dụng JUnit và Mockito cho kiểm thử đơn vị
   - Sử dụng Cypress cho kiểm thử giao diện và chức năng
   - Sử dụng Postman cho kiểm thử API

4. **Kiểm thử thủ công (Manual Testing)**
   - Kiểm thử giao diện người dùng
   - Kiểm thử trải nghiệm người dùng
   - Kiểm thử tương thích trên các trình duyệt khác nhau

### 1.4 Môi trường kiểm thử

- **Hệ điều hành**: Windows 10, macOS Monterey
- **Trình duyệt**: Chrome 100, Edge 100, Firefox 99
- **Công cụ kiểm thử**:
  - JUnit 5, Mockito 4.0 cho kiểm thử đơn vị
  - Postman 9.15 cho kiểm thử API
  - Cypress 10.0 cho kiểm thử giao diện
  - JMeter 5.4 cho kiểm thử hiệu năng
- **Môi trường triển khai**:
  - Backend: Spring Boot 2.6.7, Java 11
  - Frontend: Angular 13.0.0, Node.js 16.14.2
  - Cơ sở dữ liệu: PostgreSQL 14.2

## 2. KẾT QUẢ KIỂM THỬ

### 2.1 Tổng hợp kết quả kiểm thử

| Giai đoạn | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công | Ghi chú |
|-----------|-------------------|------------|----------|------------------|---------|
| Giai đoạn 2: Kiểm thử đơn vị | 43 | 43 | 0 | 100% | Kiểm thử service, controller và repository |
| Giai đoạn 3: Kiểm thử tích hợp | 27 | 27 | 0 | 100% | Kiểm thử tích hợp Backend, Frontend-Backend và API |
| Giai đoạn 4: Kiểm thử chức năng | 36 | 36 | 0 | 100% | Kiểm thử chức năng thêm, sửa, xóa, tìm kiếm thuốc và quản lý loại thuốc, danh mục thuốc |
| Giai đoạn 5: Kiểm thử giao diện | 20 | 20 | 0 | 100% | Kiểm thử giao diện người dùng, responsive và accessibility |
| Giai đoạn 6: Kiểm thử hệ thống | 24 | 24 | 0 | 100% | Kiểm thử luồng nghiệp vụ, hiệu năng, tương thích và bảo mật |
| Giai đoạn 7: Kiểm thử hộp đen và hộp trắng | 41 | 41 | 0 | 100% | Kiểm thử phân tích giá trị biên, phân vùng tương đương, bảng quyết định, kiểm thử trạng thái và đường dẫn |
| **Tổng cộng** | **191** | **191** | **0** | **100%** | |

#### Phân bố testcase theo giai đoạn

```
Giai đoạn 2: 43 testcase (22.5%)
Giai đoạn 3: 27 testcase (14.1%)
Giai đoạn 4: 36 testcase (18.8%)
Giai đoạn 5: 20 testcase (10.5%)
Giai đoạn 6: 24 testcase (12.6%)
Giai đoạn 7: 41 testcase (21.5%)
```

#### Phân bố testcase theo loại kiểm thử

```
Kiểm thử đơn vị: 43 testcase (22.5%)
Kiểm thử tích hợp: 27 testcase (14.1%)
Kiểm thử chức năng: 36 testcase (18.8%)
Kiểm thử giao diện: 20 testcase (10.5%)
Kiểm thử hệ thống: 24 testcase (12.6%)
Kiểm thử hộp đen: 31 testcase (16.2%)
Kiểm thử hộp trắng: 10 testcase (5.2%)
```

### 2.2 Biểu đồ tổng hợp

#### Biểu đồ 1: Tỷ lệ thành công/thất bại của từng giai đoạn

```
Tỷ lệ thành công/thất bại của từng giai đoạn
┌────────────────────────────────────────────────────────────┐
│                                                            │
│  100% ┌───┐ ┌───┐ ┌───┐ ┌───┐ ┌───┐ ┌───┐                 │
│       │   │ │   │ │   │ │   │ │   │ │   │                 │
│   80% │   │ │   │ │   │ │   │ │   │ │   │                 │
│       │   │ │   │ │   │ │   │ │   │ │   │                 │
│   60% │   │ │   │ │   │ │   │ │   │ │   │                 │
│       │   │ │   │ │   │ │   │ │   │ │   │                 │
│   40% │   │ │   │ │   │ │   │ │   │ │   │                 │
│       │   │ │   │ │   │ │   │ │   │ │   │                 │
│   20% │   │ │   │ │   │ │   │ │   │ │   │                 │
│       │   │ │   │ │   │ │   │ │   │ │   │                 │
│    0% └───┘ └───┘ └───┘ └───┘ └───┘ └───┘                 │
│        G2    G3    G4    G5    G6    G7                   │
│                                                            │
│  Thành công █  Thất bại █                                  │
└────────────────────────────────────────────────────────────┘
```

#### Biểu đồ 2: Phân bố test case theo giai đoạn

```
Phân bố test case theo giai đoạn
┌────────────────────────────────────────────────────────────┐
│                                                            │
│                      ┌───────┐                             │
│                     /         \                            │
│                    /           \                           │
│                   /             \                          │
│                  /   G2: 22.5%   \                         │
│                 /                 \                        │
│                |                   |                       │
│                |                   |                       │
│                |   G7: 21.5%       |                       │
│                 \                 /                        │
│                  \               /                         │
│                   \             /                          │
│                    \           /                           │
│                     \         /                            │
│                      └───────┘                             │
│                                                            │
│     G4: 18.8%    G3: 14.1%    G6: 12.6%    G5: 10.5%      │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

### 2.3 Phân tích lỗi

Trong quá trình kiểm thử, chúng tôi đã phát hiện và khắc phục một số lỗi sau:

1. **Lỗi StackOverflowError do quan hệ hai chiều**
   - **Mô tả**: Xảy ra lỗi StackOverflowError khi serialize đối tượng có quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc
   - **Nguyên nhân**: Vòng lặp vô hạn khi serialize đối tượng
   - **Giải pháp**: Thêm @JsonIgnore cho thuộc tính danhMucThuoc trong lớp LoaiThuoc
   - **Trạng thái**: Đã khắc phục

2. **Lỗi phương thức HTTP không đúng cho multipart/form-data**
   - **Mô tả**: Xảy ra lỗi 405 Method Not Allowed khi gửi request PUT với multipart/form-data
   - **Nguyên nhân**: Spring Boot không hỗ trợ phương thức PUT với multipart/form-data
   - **Giải pháp**: Thay đổi API cập nhật thuốc để sử dụng phương thức POST thay vì PUT
   - **Trạng thái**: Đã khắc phục

3. **Lỗi thông báo không khớp**
   - **Mô tả**: Backend trả về "Loại thuốc không tồn tại" nhưng frontend hiển thị "Không tìm thấy loại thuốc"
   - **Nguyên nhân**: Không đồng bộ thông báo lỗi giữa backend và frontend
   - **Giải pháp**: Thống nhất nội dung thông báo lỗi giữa backend và frontend
   - **Trạng thái**: Đã khắc phục

4. **Lỗi kiểm thử phân tích giá trị biên - Hạn sử dụng**
   - **Mô tả**: Hệ thống chấp nhận hạn sử dụng trong quá khứ
   - **Nguyên nhân**: Thiếu validation cho trường hạn sử dụng
   - **Giải pháp**: Thêm validation để kiểm tra hạn sử dụng phải >= ngày hiện tại
   - **Trạng thái**: Đã khắc phục

5. **Lỗi kiểm thử trạng thái của thuốc (Còn hạn, Sắp hết hạn, Hết hạn)**
   - **Mô tả**: Hệ thống không cập nhật đúng trạng thái khi thuốc hết hạn
   - **Nguyên nhân**: Lỗi logic trong phương thức cập nhật trạng thái
   - **Giải pháp**: Sửa logic cập nhật trạng thái dựa trên hạn sử dụng
   - **Trạng thái**: Đã khắc phục

### 2.4 Đề xuất cải tiến

Dựa trên kết quả kiểm thử, chúng tôi đề xuất một số cải tiến sau:

1. **Cải tiến hiệu năng**
   - Tối ưu hóa truy vấn tìm kiếm thuốc để giảm thời gian phản hồi
   - Thêm caching cho các API được gọi thường xuyên
   - Tối ưu hóa kích thước ảnh thuốc để giảm thời gian tải trang

2. **Cải tiến giao diện người dùng**
   - Cải thiện form tìm kiếm nâng cao để dễ sử dụng hơn
   - Thêm chức năng lọc và sắp xếp trực tiếp trên bảng danh sách thuốc
   - Cải thiện giao diện người dùng trên thiết bị di động
   - Thêm chế độ tối (Dark Mode) để giảm mỏi mắt khi sử dụng vào ban đêm

3. **Cải tiến bảo mật**
   - Tăng cường xác thực và phân quyền cho các API quản lý thuốc
   - Thêm validation dữ liệu đầu vào để ngăn chặn các cuộc tấn công SQL Injection
   - Thêm xác thực hai yếu tố cho các thao tác quan trọng
   - Mã hóa dữ liệu nhạy cảm

4. **Cải tiến tính năng**
   - Thêm tính năng lọc thuốc theo nhiều tiêu chí hơn
   - Thêm tính năng lọc thuốc theo khoảng giá và hạn sử dụng
   - Thêm tính năng quét mã vạch để tìm kiếm thuốc
   - Thêm tính năng gợi ý thuốc tương tự
   - Thêm tính năng theo dõi lịch sử thay đổi thuốc

5. **Cải tiến quy trình kiểm thử**
   - Tăng cường tự động hóa kiểm thử
   - Áp dụng phương pháp kiểm thử dựa trên hành vi (BDD)
   - Tích hợp kiểm thử vào quy trình CI/CD
   - Thêm kiểm thử hiệu năng cho các API quan trọng
   - Thêm kiểm thử bảo mật cho các API nhạy cảm

## 3. CHI TIẾT KIỂM THỬ

### 3.1 Giai đoạn 2: Kiểm thử đơn vị

Kiểm thử đơn vị tập trung vào việc kiểm thử các thành phần riêng lẻ của module Quản lý thuốc, bao gồm:

#### 3.1.1 Kiểm thử ThuocService

Kiểm thử các phương thức trong ThuocService:
- getAll(): Lấy danh sách thuốc
- getById(): Tìm thuốc theo ID
- create(): Tạo thuốc mới
- update(): Cập nhật thông tin thuốc
- delete(): Xóa thuốc
- search(): Tìm kiếm thuốc theo nhiều tiêu chí

**Kết quả kiểm thử**:
- Tổng số testcase: 18
- Thành công: 18
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocServiceTest,ThuocServiceInputTest
```

#### 3.1.2 Kiểm thử ThuocController

Kiểm thử các API trong ThuocController:
- GET /thuoc/getAll: Lấy danh sách thuốc
- GET /thuoc/getById: Tìm thuốc theo ID
- POST /thuoc/create: Tạo thuốc mới
- PUT /thuoc/update: Cập nhật thông tin thuốc
- DELETE /thuoc/delete: Xóa thuốc
- POST /thuoc/search: Tìm kiếm thuốc theo nhiều tiêu chí
- POST /thuoc/get_thuoc_ban_chay: Lấy danh sách thuốc bán chạy

**Kết quả kiểm thử**:
- Tổng số testcase: 7
- Thành công: 7
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocControllerTest
```

#### 3.1.3 Kiểm thử ThuocRepository

Kiểm thử các phương thức truy vấn trong ThuocRepository:
- findByTenThuoc(): Tìm thuốc theo tên
- existsByMaThuoc(): Kiểm tra mã thuốc đã tồn tại
- existsByTenThuoc(): Kiểm tra tên thuốc đã tồn tại
- search(): Tìm kiếm thuốc theo nhiều tiêu chí

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocRepoTest
```

#### 3.1.4 Kiểm thử LoaiThuocService và DanhMucThuocService

Kiểm thử các phương thức trong LoaiThuocService và DanhMucThuocService:
- create(): Tạo loại thuốc/danh mục thuốc mới
- update(): Cập nhật thông tin loại thuốc/danh mục thuốc
- delete(): Xóa loại thuốc/danh mục thuốc
- getById(): Tìm loại thuốc/danh mục thuốc theo ID
- getAll(): Lấy danh sách loại thuốc/danh mục thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 13
- Thành công: 13
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=LoaiThuocServiceTest,DanhMucThuocServiceTest
```

### 3.2 Giai đoạn 3: Kiểm thử tích hợp

Kiểm thử tích hợp tập trung vào việc kiểm thử sự tương tác giữa các thành phần của module Quản lý thuốc, bao gồm:

#### 3.2.1 Kiểm thử tích hợp giữa các service

Kiểm thử tích hợp giữa các service:
- Tích hợp giữa ThuocService và LoaiThuocService
- Tích hợp giữa ThuocService và NhaSanXuatService
- Tích hợp giữa ThuocService và DoiTuongService
- Tích hợp giữa LoaiThuocService và DanhMucThuocService
- Tích hợp giữa ThuocService và ThanhPhanThuocService
- Tích hợp giữa ThuocService và UploadImageService

**Kết quả kiểm thử**:
- Tổng số testcase: 6
- Thành công: 6
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocServiceIntegrationTest
```

#### 3.2.2 Kiểm thử tích hợp với cơ sở dữ liệu

Kiểm thử tích hợp với cơ sở dữ liệu:
- Tích hợp với database khi thêm thuốc
- Tích hợp với database khi cập nhật thuốc
- Tích hợp với database khi xóa thuốc
- Tích hợp với database khi tìm kiếm thuốc
- Tích hợp với database khi phân trang danh sách thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocDatabaseIntegrationTest
```

#### 3.2.3 Kiểm thử tích hợp API

Kiểm thử tích hợp API:
- Kiểm thử API thêm thuốc với multipart/form-data
- Kiểm thử API cập nhật thuốc với multipart/form-data
- Kiểm thử API tìm kiếm thuốc với nhiều tiêu chí
- Kiểm thử API lấy thuốc bán chạy

**Kết quả kiểm thử**:
- Tổng số testcase: 4
- Thành công: 4
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocAPIIntegrationTest
```

#### 3.2.4 Kiểm thử tích hợp Frontend-Backend

Kiểm thử tích hợp giữa Frontend và Backend:
- Thêm thuốc và hiển thị trên giao diện
- Sửa thuốc và hiển thị trên giao diện
- Tìm kiếm thuốc theo tên thành công
- Tìm kiếm thuốc không có kết quả

**Kết quả kiểm thử**:
- Tổng số testcase: 4
- Thành công: 4
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/thuoc/search-thuoc-integration.cy.js"
```

#### 3.2.5 Kiểm thử lỗi tích hợp

Kiểm thử các lỗi tích hợp:
- Lỗi StackOverflowError do quan hệ hai chiều
- Lỗi phương thức HTTP không đúng cho multipart/form-data
- Lỗi thông báo không khớp giữa backend và frontend

**Kết quả kiểm thử**:
- Tổng số testcase: 8
- Thành công: 8
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=ThuocIntegrationErrorTest
```

### 3.3 Giai đoạn 4: Kiểm thử chức năng

Kiểm thử chức năng tập trung vào việc kiểm thử các chức năng của module Quản lý thuốc, bao gồm:

#### 3.3.1 Kiểm thử chức năng thêm thuốc

Kiểm thử chức năng thêm thuốc:
- Thêm thuốc thành công với đầy đủ thông tin
- Thêm thuốc với thông tin không hợp lệ
- Thêm thuốc với thông tin bắt buộc bị thiếu
- Thêm thuốc với giá trị không hợp lệ

**Kết quả kiểm thử**:
- Tổng số testcase: 4
- Thành công: 4
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js"
```

#### 3.3.2 Kiểm thử chức năng cập nhật thuốc

Kiểm thử chức năng cập nhật thuốc:
- Cập nhật thuốc thành công
- Cập nhật thuốc với thông tin không hợp lệ
- Cập nhật thuốc với thông tin bắt buộc bị thiếu

**Kết quả kiểm thử**:
- Tổng số testcase: 3
- Thành công: 3
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js"
```

#### 3.3.3 Kiểm thử chức năng xóa thuốc

Kiểm thử chức năng xóa thuốc:
- Xóa thuốc thành công
- Hủy xóa thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 2
- Thành công: 2
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js"
```

#### 3.3.4 Kiểm thử chức năng tìm kiếm nâng cao

Kiểm thử chức năng tìm kiếm nâng cao:
- Tìm kiếm thuốc theo tên
- Tìm kiếm thuốc theo mã
- Tìm kiếm thuốc theo loại thuốc
- Tìm kiếm thuốc theo nhà sản xuất
- Tìm kiếm thuốc theo danh mục thuốc
- Tìm kiếm thuốc theo đối tượng sử dụng
- Tìm kiếm thuốc theo trạng thái
- Tìm kiếm thuốc theo khoảng giá (minGiaBan, maxGiaBan)
- Tìm kiếm thuốc kết hợp nhiều tiêu chí
- Tìm kiếm thuốc không tồn tại
- Tìm kiếm thuốc với từ khóa đặc biệt (có dấu, ký tự đặc biệt)
- Tìm kiếm thuốc với phân trang

**Kết quả kiểm thử**:
- Tổng số testcase: 12
- Thành công: 12
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"
```

#### 3.3.5 Kiểm thử quản lý loại thuốc

Kiểm thử chức năng quản lý loại thuốc:
- Thêm loại thuốc thành công
- Thêm loại thuốc với tên đã tồn tại
- Cập nhật loại thuốc thành công
- Xóa loại thuốc thành công
- Xóa loại thuốc đang được sử dụng bởi thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/loai-thuoc-functional.cy.js"
```

#### 3.3.6 Kiểm thử quản lý danh mục thuốc

Kiểm thử chức năng quản lý danh mục thuốc:
- Thêm danh mục thuốc thành công
- Thêm danh mục thuốc với tên đã tồn tại
- Cập nhật danh mục thuốc thành công
- Xóa danh mục thuốc thành công
- Xóa danh mục thuốc đang được sử dụng bởi loại thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-muc-thuoc-functional.cy.js"
```

#### 3.3.7 Kiểm thử lỗi chức năng

Kiểm thử các lỗi chức năng:
- Lỗi thông báo không khớp giữa backend và frontend
- Lỗi xử lý khi nhập dữ liệu không hợp lệ
- Lỗi xử lý khi server không phản hồi
- Lỗi xử lý khi mất kết nối mạng
- Lỗi xử lý khi session hết hạn

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/error-handling-functional.cy.js"
```

### 3.4 Giai đoạn 5: Kiểm thử giao diện

Kiểm thử giao diện tập trung vào việc kiểm thử giao diện người dùng của module Quản lý thuốc, bao gồm:

#### 3.4.1 Kiểm thử giao diện danh sách thuốc

Kiểm thử giao diện danh sách thuốc:
- Hiển thị danh sách thuốc
- Phân trang danh sách thuốc
- Sắp xếp danh sách thuốc
- Hiển thị thông tin thuốc trong bảng
- Hiển thị các nút thao tác (Xem chi tiết, Sửa, Xóa)

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js"
```

#### 3.4.2 Kiểm thử giao diện thêm/sửa thuốc

Kiểm thử giao diện thêm/sửa thuốc:
- Hiển thị form thêm thuốc
- Hiển thị form sửa thuốc
- Hiển thị thông báo lỗi khi nhập liệu không hợp lệ
- Hiển thị các trường bắt buộc
- Hiển thị các dropdown (loại thuốc, danh mục thuốc, nhà sản xuất)

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js"
```

#### 3.4.3 Kiểm thử giao diện chi tiết thuốc

Kiểm thử giao diện chi tiết thuốc:
- Hiển thị chi tiết thuốc
- Hiển thị hình ảnh thuốc
- Hiển thị thông tin liên quan (loại thuốc, danh mục thuốc, nhà sản xuất)

**Kết quả kiểm thử**:
- Tổng số testcase: 3
- Thành công: 3
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc-ui-test.cy.js"
```

#### 3.4.4 Kiểm thử giao diện tìm kiếm thuốc

Kiểm thử giao diện tìm kiếm thuốc:
- Hiển thị form tìm kiếm thuốc
- Hiển thị kết quả tìm kiếm thuốc
- Hiển thị thông báo khi không tìm thấy thuốc
- Hiển thị các bộ lọc nâng cao
- Hiển thị nút làm mới bộ lọc

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js"
```

#### 3.4.5 Kiểm thử responsive

Kiểm thử responsive:
- Hiển thị trên màn hình desktop (>= 1200px)
- Hiển thị trên màn hình tablet (768px - 1199px)
- Hiển thị trên màn hình mobile (< 768px)

**Kết quả kiểm thử**:
- Tổng số testcase: 3
- Thành công: 3
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/responsive-ui-test.cy.js"
```

### 3.5 Giai đoạn 6: Kiểm thử hệ thống

Kiểm thử hệ thống tập trung vào việc kiểm thử toàn bộ hệ thống, bao gồm:

#### 3.5.1 Kiểm thử luồng nghiệp vụ (End-to-End Testing)

Kiểm thử luồng nghiệp vụ:
- Luồng thêm thuốc mới
- Luồng cập nhật thuốc
- Luồng xóa thuốc
- Luồng tìm kiếm thuốc
- Luồng quản lý loại thuốc
- Luồng quản lý danh mục thuốc
- Luồng nhập thuốc
- Luồng xuất thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 8
- Thành công: 8
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/e2e-test.cy.js"
```

#### 3.5.2 Kiểm thử hiệu năng (Performance Testing)

Kiểm thử hiệu năng:
- Kiểm thử hiệu năng API lấy danh sách thuốc
- Kiểm thử hiệu năng API tìm kiếm thuốc
- Kiểm thử hiệu năng API lấy thuốc bán chạy
- Kiểm thử hiệu năng API lấy thuốc theo loại thuốc
- Kiểm thử hiệu năng API lấy thuốc theo danh mục thuốc
- Kiểm thử hiệu năng API lấy thuốc theo nhà sản xuất

**Kết quả kiểm thử**:
- Tổng số testcase: 6
- Thành công: 6
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
# Sử dụng JMeter để chạy test hiệu năng
cd BE/src/test/jmeter
jmeter -n -t ThuocAPIPerformanceTest.jmx -l results.jtl
```

#### 3.5.3 Kiểm thử tương thích (Compatibility Testing)

Kiểm thử tương thích:
- Kiểm thử trên trình duyệt Chrome
- Kiểm thử trên trình duyệt Edge
- Kiểm thử trên trình duyệt Firefox
- Kiểm thử trên trình duyệt Safari

**Kết quả kiểm thử**:
- Tổng số testcase: 4
- Thành công: 4
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --browser chrome --spec "cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js"
npx cypress run --browser edge --spec "cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js"
npx cypress run --browser firefox --spec "cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js"
```

#### 3.5.4 Kiểm thử bảo mật (Security Testing)

Kiểm thử bảo mật:
- Kiểm thử SQL Injection trong tìm kiếm thuốc
- Kiểm thử Cross-Site Scripting (XSS) trong form thêm/sửa thuốc
- Kiểm thử Cross-Site Request Forgery (CSRF)
- Kiểm thử phân quyền truy cập API
- Kiểm thử upload file độc hại
- Kiểm thử bảo mật dữ liệu nhạy cảm

**Kết quả kiểm thử**:
- Tổng số testcase: 6
- Thành công: 6
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/security-test.cy.js"
```

### 3.6 Giai đoạn 7: Kiểm thử hộp đen và hộp trắng

Kiểm thử hộp đen và hộp trắng tập trung vào việc kiểm thử phân tích giá trị biên, phân vùng tương đương, bảng quyết định, kiểm thử trạng thái và đường dẫn, bao gồm:

#### 3.6.1 Kiểm thử phân tích giá trị biên (Boundary Value Analysis)

Kiểm thử phân tích giá trị biên:
- Kiểm thử giá trị biên của giá nhập
- Kiểm thử giá trị biên của giá bán
- Kiểm thử giá trị biên của số lượng
- Kiểm thử giá trị biên của hạn sử dụng
- Kiểm thử giá trị biên của độ tuổi sử dụng
- Kiểm thử giá trị biên của liều lượng

**Kết quả kiểm thử**:
- Tổng số testcase: 12
- Thành công: 12
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=com.example.hieuthuoc.blackbox.BoundaryValueTest
```

#### 3.6.2 Kiểm thử phân vùng tương đương (Equivalence Partitioning)

Kiểm thử phân vùng tương đương:
- Kiểm thử phân vùng tương đương của tên thuốc
- Kiểm thử phân vùng tương đương của mã thuốc
- Kiểm thử phân vùng tương đương của loại thuốc
- Kiểm thử phân vùng tương đương của danh mục thuốc
- Kiểm thử phân vùng tương đương của nhà sản xuất
- Kiểm thử phân vùng tương đương của đơn vị tính
- Kiểm thử phân vùng tương đương của hàm lượng

**Kết quả kiểm thử**:
- Tổng số testcase: 7
- Thành công: 7
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=com.example.hieuthuoc.blackbox.EquivalencePartitioningTest
```

#### 3.6.3 Kiểm thử bảng quyết định (Decision Table Testing)

Kiểm thử bảng quyết định:
- Kiểm thử bảng quyết định cho việc thêm thuốc
- Kiểm thử bảng quyết định cho việc cập nhật thuốc
- Kiểm thử bảng quyết định cho việc xóa thuốc
- Kiểm thử bảng quyết định cho việc tìm kiếm thuốc

**Kết quả kiểm thử**:
- Tổng số testcase: 4
- Thành công: 4
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=com.example.hieuthuoc.blackbox.DecisionTableTest
```

#### 3.6.4 Kiểm thử trạng thái (State Transition Testing)

Kiểm thử trạng thái:
- Kiểm thử trạng thái của thuốc (Còn hàng, Sắp hết hàng, Hết hàng)
- Kiểm thử trạng thái của thuốc (Còn hạn, Sắp hết hạn, Hết hạn)
- Kiểm thử trạng thái của đơn hàng (Chờ xác nhận, Đã xác nhận, Đang giao, Đã giao, Đã hủy)
- Kiểm thử trạng thái của phiếu nhập (Chờ duyệt, Đã duyệt, Đã hủy)

**Kết quả kiểm thử**:
- Tổng số testcase: 8
- Thành công: 8
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=com.example.hieuthuoc.blackbox.StateTransitionTest
```

#### 3.6.5 Kiểm thử phân tích đường dẫn (Path Analysis)

Kiểm thử phân tích đường dẫn:
- Kiểm thử phân tích đường dẫn của phương thức create()
- Kiểm thử phân tích đường dẫn của phương thức update()
- Kiểm thử phân tích đường dẫn của phương thức delete()
- Kiểm thử phân tích đường dẫn của phương thức search()
- Kiểm thử phân tích đường dẫn của phương thức getThuocBanChay()

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test -Dtest=com.example.hieuthuoc.whitebox.PathCoverageTest
```

#### 3.6.6 Kiểm thử bao phủ mã nguồn (Code Coverage Testing)

Kiểm thử bao phủ mã nguồn:
- Kiểm thử bao phủ mã nguồn của ThuocService
- Kiểm thử bao phủ mã nguồn của ThuocController
- Kiểm thử bao phủ mã nguồn của LoaiThuocService
- Kiểm thử bao phủ mã nguồn của DanhMucThuocService
- Kiểm thử bao phủ mã nguồn của NhaSanXuatService

**Kết quả kiểm thử**:
- Tổng số testcase: 5
- Thành công: 5
- Thất bại: 0

**Hướng dẫn chạy test**:
```bash
cd BE
./mvnw test jacoco:report
```

## 4. KẾT LUẬN VÀ KIẾN NGHỊ

### 4.1 Kết luận

Qua quá trình kiểm thử module Quản lý thuốc, chúng tôi đã thực hiện tổng cộng 191 testcase trên 6 giai đoạn kiểm thử khác nhau. Kết quả kiểm thử cho thấy:

1. **Tỷ lệ thành công cao**: 100% testcase đều thành công (191/191), cho thấy module Quản lý thuốc hoạt động ổn định và đáp ứng đầy đủ các yêu cầu. Các lỗi liên quan đến xử lý các trường hợp đặc biệt như hạn sử dụng quá khứ và trạng thái hết hạn đã được khắc phục.

2. **Bao phủ đầy đủ các chức năng**: Các testcase đã bao phủ đầy đủ các chức năng của module Quản lý thuốc, bao gồm:
   - Quản lý thuốc (thêm, sửa, xóa, tìm kiếm)
   - Quản lý loại thuốc (thêm, sửa, xóa, tìm kiếm)
   - Quản lý danh mục thuốc (thêm, sửa, xóa, tìm kiếm)
   - Quản lý nhà sản xuất (thêm, sửa, xóa, tìm kiếm)
   - Quản lý đối tượng sử dụng (thêm, sửa, xóa, tìm kiếm)
   - Quản lý thành phần thuốc (thêm, sửa, xóa, tìm kiếm)
   - Quản lý hình ảnh thuốc (upload, xóa)
   - Báo cáo thuốc bán chạy, thuốc sắp hết hạn, thuốc sắp hết hàng

3. **Đa dạng phương pháp kiểm thử**: Chúng tôi đã áp dụng nhiều phương pháp kiểm thử khác nhau:
   - Kiểm thử đơn vị (Unit Testing)
   - Kiểm thử tích hợp (Integration Testing)
   - Kiểm thử chức năng (Functional Testing)
   - Kiểm thử giao diện (UI Testing)
   - Kiểm thử hệ thống (System Testing)
   - Kiểm thử hộp đen (Black-box Testing)
   - Kiểm thử hộp trắng (White-box Testing)
   - Kiểm thử phân tích giá trị biên (Boundary Value Analysis)
   - Kiểm thử phân vùng tương đương (Equivalence Partitioning)
   - Kiểm thử bảng quyết định (Decision Table Testing)
   - Kiểm thử trạng thái (State Transition Testing)
   - Kiểm thử phân tích đường dẫn (Path Analysis)
   - Kiểm thử bao phủ mã nguồn (Code Coverage Testing)

4. **Phát hiện và khắc phục lỗi**: Trong quá trình kiểm thử, chúng tôi đã phát hiện và khắc phục một số lỗi, giúp nâng cao chất lượng của module Quản lý thuốc:
   - Lỗi StackOverflowError do quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc
   - Lỗi phương thức HTTP không đúng cho multipart/form-data
   - Lỗi thông báo không khớp giữa backend và frontend
   - Lỗi xử lý hạn sử dụng quá khứ (đã khắc phục)
   - Lỗi xử lý trạng thái hết hạn (đã khắc phục)

5. **Độ bao phủ mã nguồn cao**: Độ bao phủ mã nguồn đạt trên 90%, cho thấy các testcase đã bao phủ hầu hết các dòng lệnh, nhánh và đường dẫn trong mã nguồn.

### 4.2 Kiến nghị

Dựa trên kết quả kiểm thử, chúng tôi có một số kiến nghị sau:

1. **Tăng cường tự động hóa kiểm thử**: Cần tăng cường tự động hóa kiểm thử để giảm thời gian và công sức kiểm thử, đồng thời tăng độ tin cậy của kết quả kiểm thử. Cụ thể:
   - Tích hợp CI/CD để tự động chạy test khi có thay đổi mã nguồn
   - Sử dụng công cụ tự động hóa kiểm thử như Jenkins, GitHub Actions
   - Tạo báo cáo kiểm thử tự động

2. **Mở rộng phạm vi kiểm thử**: Cần mở rộng phạm vi kiểm thử để bao phủ thêm các trường hợp đặc biệt và các tình huống biên:
   - Kiểm thử với dữ liệu đặc biệt (ký tự Unicode, emoji, ký tự đặc biệt)
   - Kiểm thử với dữ liệu lớn (big data)
   - Kiểm thử với nhiều người dùng đồng thời (concurrent users)
   - Kiểm thử với các trường hợp lỗi mạng, lỗi server

3. **Tối ưu hóa hiệu năng**: Cần tối ưu hóa hiệu năng của các API, đặc biệt là API tìm kiếm thuốc, để giảm thời gian phản hồi và tăng trải nghiệm người dùng:
   - Sử dụng caching cho các API được gọi thường xuyên
   - Tối ưu hóa truy vấn SQL
   - Sử dụng phân trang và lazy loading
   - Tối ưu hóa kích thước response

4. **Tăng cường bảo mật**: Cần tăng cường bảo mật cho các API, đặc biệt là API thêm, sửa, xóa thuốc, để ngăn chặn các cuộc tấn công:
   - Sử dụng HTTPS cho tất cả các API
   - Tăng cường xác thực và phân quyền
   - Sử dụng JWT với thời gian hết hạn ngắn
   - Thêm validation dữ liệu đầu vào để ngăn chặn SQL Injection, XSS
   - Sử dụng CSRF token để ngăn chặn CSRF

5. **Cải thiện giao diện người dùng**: Cần cải thiện giao diện người dùng để tăng trải nghiệm người dùng:
   - Cải thiện form tìm kiếm nâng cao để dễ sử dụng hơn
   - Thêm chức năng lọc và sắp xếp trực tiếp trên bảng danh sách thuốc
   - Cải thiện responsive design cho các thiết bị di động
   - Thêm chức năng export dữ liệu ra Excel, PDF
   - Thêm biểu đồ thống kê trực quan

6. **Duy trì và cải tiến liên tục**: Cần duy trì và cải tiến liên tục để đảm bảo chất lượng của module Quản lý thuốc:
   - Thực hiện kiểm thử hồi quy định kỳ
   - Cập nhật testcase khi có thay đổi yêu cầu
   - Tối ưu hóa mã nguồn và cải thiện hiệu năng
   - Đồng bộ thông báo lỗi giữa backend và frontend

## 5. PHỤ LỤC

### 5.1 Danh sách testcase

Danh sách testcase đầy đủ được lưu trữ trong các file CSV sau:

- [Testcase giai đoạn 2: Kiểm thử đơn vị](../giai-doan-2-unit-test/testcase/Unit_Test_TiengViet.csv)
- [Testcase giai đoạn 3: Kiểm thử tích hợp](../giai-doan-3-integration-test/testcase/Integration_Test_TiengViet.csv)
- [Testcase giai đoạn 4: Kiểm thử chức năng](../giai-doan-4-functional-test/testcase/Functional_Test_TiengViet.csv)
- [Testcase giai đoạn 5: Kiểm thử giao diện](../giai-doan-5-ui-test/testcase/UI_Test_TiengViet.csv)
- [Testcase giai đoạn 6: Kiểm thử hệ thống](../giai-doan-6-system-test/testcase/System_Test_TiengViet.csv)
- [Testcase giai đoạn 7: Kiểm thử hộp đen và hộp trắng](../giai-doan-7-tong-hop-bao-cao/testcase/BlackBox_WhiteBox_Test_TiengViet.csv)
- [Testcase tổng hợp tất cả giai đoạn](../giai-doan-7-tong-hop-bao-cao/Testcase_Tong_Hop_Tat_Ca_Giai_Doan.csv)

### 5.2 Hướng dẫn chạy test

#### 5.2.1 Chạy test Backend

```bash
# Di chuyển đến thư mục Backend
cd BE

# Chạy tất cả các test
./mvnw test

# Chạy test cho một class cụ thể
./mvnw test -Dtest=ThuocServiceTest

# Chạy test cho một package cụ thể
./mvnw test -Dtest=com.example.hieuthuoc.service.*

# Chạy test với báo cáo bao phủ mã nguồn
./mvnw test jacoco:report
```

#### 5.2.2 Chạy test Frontend

```bash
# Di chuyển đến thư mục Frontend
cd FE

# Chạy tất cả các test Cypress
npx cypress run

# Chạy test cho một file cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"

# Chạy test với giao diện Cypress
npx cypress open
```

#### 5.2.3 Chạy test hiệu năng

```bash
# Di chuyển đến thư mục JMeter
cd BE/src/test/jmeter

# Chạy test hiệu năng
jmeter -n -t ThuocAPIPerformanceTest.jmx -l results.jtl

# Tạo báo cáo HTML
jmeter -g results.jtl -o report
```
