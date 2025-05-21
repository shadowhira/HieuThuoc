# BÁO CÁO KIỂM THỬ TỔNG HỢP: CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Phiên bản**: 1.0
- **Ngày báo cáo**: 24/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc

## 📑 MỤC LỤC

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
4. [Kết luận](#4-kết-luận)
   1. [Đánh giá chung về chất lượng sản phẩm](#41-đánh-giá-chung-về-chất-lượng-sản-phẩm)
   2. [Đánh giá chung về quy trình kiểm thử](#42-đánh-giá-chung-về-quy-trình-kiểm-thử)
   3. [Kế hoạch tiếp theo](#43-kế-hoạch-tiếp-theo)
5. [Phụ lục](#5-phụ-lục)
   1. [Testcase chi tiết](#51-testcase-chi-tiết)
   2. [Báo cáo lỗi chi tiết](#52-báo-cáo-lỗi-chi-tiết)
   3. [Tài liệu tham khảo](#53-tài-liệu-tham-khảo)

## 1. TỔNG QUAN

### 1.1 Giới thiệu về dự án

Hệ thống web bán và quản lý hiệu thuốc là một ứng dụng web được phát triển nhằm hỗ trợ các hiệu thuốc trong việc quản lý thuốc, kho, đơn hàng, khuyến mãi và người dùng. Hệ thống được phát triển bằng công nghệ Spring Boot cho Backend và React cho Frontend.

Chức năng Quản lý thuốc là một trong những chức năng quan trọng nhất của hệ thống, cho phép người dùng thêm, sửa, xóa và tìm kiếm thuốc trong hệ thống.

### 1.2 Phạm vi kiểm thử

Phạm vi kiểm thử bao gồm:

- **Kiểm thử đơn vị**: Kiểm thử các thành phần riêng lẻ của chức năng Quản lý thuốc, bao gồm các service và controller.
- **Kiểm thử tích hợp**: Kiểm thử tích hợp giữa các thành phần Backend và giữa Frontend và Backend.
- **Kiểm thử chức năng**: Kiểm thử các chức năng thêm, sửa, xóa và tìm kiếm thuốc.
- **Kiểm thử giao diện**: Kiểm thử giao diện người dùng của chức năng Quản lý thuốc.
- **Kiểm thử hệ thống**: Kiểm thử luồng nghiệp vụ từ đầu đến cuối, hiệu năng và tương thích.

### 1.3 Phương pháp kiểm thử

Các phương pháp kiểm thử được sử dụng bao gồm:

- **Kiểm thử hộp trắng (White Box Testing)**: Kiểm thử dựa trên cấu trúc nội bộ của mã nguồn.
- **Kiểm thử hộp đen (Black Box Testing)**: Kiểm thử dựa trên đặc tả yêu cầu, không quan tâm đến cấu trúc nội bộ.
- **Kiểm thử tự động (Automated Testing)**: Sử dụng các công cụ tự động hóa để thực hiện kiểm thử.
- **Kiểm thử thủ công (Manual Testing)**: Thực hiện kiểm thử bằng tay.

### 1.4 Môi trường kiểm thử

Môi trường kiểm thử bao gồm:

- **Hệ điều hành**: Windows 10, macOS Monterey
- **Trình duyệt**: Chrome 100, Edge 100, Firefox 99
- **Công cụ kiểm thử**:
  - JUnit 5, Mockito 4.0 cho kiểm thử đơn vị
  - Postman 9.15 cho kiểm thử API
  - Cypress 10.0 cho kiểm thử giao diện
  - JMeter 5.4 cho kiểm thử hiệu năng
- **Môi trường triển khai**:
  - Backend: Spring Boot 2.6.7, Java 11
  - Frontend: React 18.0.0, Node.js 16.14.2
  - Cơ sở dữ liệu: PostgreSQL 14.2

## 2. KẾT QUẢ KIỂM THỬ

### 2.1 Tổng hợp kết quả kiểm thử

| Giai đoạn | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công | Ghi chú |
|-----------|-------------------|------------|----------|------------------|---------|
| Giai đoạn 2: Kiểm thử đơn vị | 18 | 18 | 0 | 100% | Kiểm thử service và controller |
| Giai đoạn 3: Kiểm thử tích hợp | 12 | 12 | 0 | 100% | Kiểm thử tích hợp Backend và Frontend-Backend |
| Giai đoạn 4: Kiểm thử chức năng | 16 | 16 | 0 | 100% | Kiểm thử chức năng thêm, sửa, xóa và tìm kiếm thuốc |
| Giai đoạn 5: Kiểm thử giao diện | 10 | 10 | 0 | 100% | Kiểm thử giao diện người dùng |
| Giai đoạn 6: Kiểm thử hệ thống | 8 | 8 | 0 | 100% | Kiểm thử luồng nghiệp vụ, hiệu năng và tương thích |
| **Tổng cộng** | **64** | **64** | **0** | **100%** | |

### 2.2 Biểu đồ tổng hợp

*[Chèn biểu đồ cột thể hiện tỷ lệ thành công/thất bại của từng giai đoạn]*

*[Chèn biểu đồ tròn thể hiện phân bố lỗi theo loại]*

*[Chèn biểu đồ đường thể hiện tiến độ kiểm thử theo thời gian]*

### 2.3 Phân tích lỗi

Trong quá trình kiểm thử, không phát hiện lỗi nào trong chức năng Quản lý thuốc. Tuy nhiên, có một số vấn đề nhỏ đã được phát hiện và khắc phục trong quá trình phát triển:

| ID | Mô tả lỗi | Mức độ nghiêm trọng | Loại lỗi | Giai đoạn phát hiện | Trạng thái | Ghi chú |
|----|-----------|---------------------|----------|---------------------|------------|---------|
| BUG_001 | Lỗi trạng thái khi danh sách trống | Thấp | Chức năng | Giai đoạn 2 | Đã sửa | Trả về trạng thái 200 thay vì 409 khi danh sách trống |
| BUG_002 | Lỗi StackOverflowError do quan hệ hai chiều | Cao | Chức năng | Giai đoạn 3 | Đã sửa | Sửa bằng cách thêm @JsonIgnore |
| BUG_003 | Lỗi thông báo không khớp | Thấp | Giao diện | Giai đoạn 4 | Đã sửa | Thống nhất thông báo lỗi |
| BUG_004 | Lỗi phương thức HTTP không đúng | Trung bình | Chức năng | Giai đoạn 3 | Đã sửa | Sửa phương thức HTTP cho multipart/form-data |

### 2.4 Đề xuất cải tiến

#### 2.4.1 Đề xuất cải tiến chức năng

1. **Cải tiến tính năng**:
   - Thêm tính năng lọc thuốc theo nhiều tiêu chí hơn
   - Thêm tính năng xuất/nhập danh sách thuốc từ/vào file Excel
   - Thêm tính năng quét mã vạch để tìm kiếm thuốc

2. **Cải tiến hiệu năng**:
   - Tối ưu hóa truy vấn cơ sở dữ liệu để tăng tốc độ tìm kiếm
   - Thêm caching để giảm tải cho cơ sở dữ liệu
   - Tối ưu hóa kích thước ảnh thuốc để giảm thời gian tải trang

3. **Cải tiến giao diện người dùng**:
   - Cải thiện giao diện người dùng trên thiết bị di động
   - Thêm chế độ tối (Dark Mode)
   - Cải thiện trải nghiệm người dùng khi tìm kiếm thuốc

4. **Cải tiến bảo mật**:
   - Tăng cường kiểm tra quyền truy cập
   - Thêm xác thực hai yếu tố cho các thao tác quan trọng
   - Mã hóa dữ liệu nhạy cảm

#### 2.4.2 Đề xuất cải tiến quy trình kiểm thử

1. **Cải tiến phương pháp kiểm thử**:
   - Áp dụng phương pháp kiểm thử dựa trên hành vi (BDD)
   - Tăng cường kiểm thử an toàn thông tin
   - Áp dụng kiểm thử A/B để đánh giá trải nghiệm người dùng

2. **Cải tiến công cụ kiểm thử**:
   - Sử dụng công cụ kiểm thử tự động hóa mạnh mẽ hơn
   - Tích hợp kiểm thử vào quy trình CI/CD
   - Sử dụng công cụ phân tích mã nguồn tĩnh

3. **Cải tiến tài liệu kiểm thử**:
   - Chuẩn hóa định dạng tài liệu kiểm thử
   - Tạo thư viện testcase có thể tái sử dụng
   - Tạo hướng dẫn kiểm thử chi tiết hơn

4. **Cải tiến quản lý lỗi**:
   - Sử dụng công cụ quản lý lỗi chuyên nghiệp
   - Tự động hóa quy trình báo cáo lỗi
   - Cải thiện quy trình phân loại và ưu tiên lỗi

## 3. CHI TIẾT KIỂM THỬ

### 3.1 Giai đoạn 2: Kiểm thử đơn vị

#### 3.1.1 Kiểm thử Service

Kiểm thử các service bao gồm ThuocService, LoaiThuocService và DanhMucThuocService. Các phương thức được kiểm thử bao gồm thêm, sửa, xóa và tìm kiếm.

**Kết quả kiểm thử**:

| Service | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|---------|-------------------|------------|----------|------------------|
| ThuocService | 7 | 7 | 0 | 100% |
| LoaiThuocService | 6 | 6 | 0 | 100% |
| DanhMucThuocService | 5 | 5 | 0 | 100% |
| **Tổng cộng** | **18** | **18** | **0** | **100%** |

**Chi tiết test case**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| TS_001 | Lấy danh sách thuốc thành công | Passed |
| TS_002 | Lấy danh sách thuốc trống | Passed |
| TS_003 | Tìm thuốc theo ID thành công | Passed |
| TS_004 | Tìm thuốc theo ID không tồn tại | Passed |
| TS_005 | Tạo thuốc thành công | Passed |
| TS_006 | Cập nhật thuốc thành công | Passed |
| TS_007 | Xóa thuốc thành công | Passed |
| LS_001 | Lấy danh sách loại thuốc thành công | Passed |
| LS_002 | Lấy danh sách loại thuốc trống | Passed |
| LS_003 | Tìm loại thuốc theo tên thành công | Passed |
| LS_004 | Tạo loại thuốc thành công | Passed |
| LS_005 | Cập nhật loại thuốc thành công | Passed |
| LS_006 | Xóa loại thuốc thành công | Passed |
| DS_001 | Lấy danh sách danh mục thuốc thành công | Passed |
| DS_002 | Lấy danh sách danh mục thuốc trống | Passed |
| DS_003 | Tìm danh mục thuốc theo tên thành công | Passed |
| DS_004 | Tạo danh mục thuốc thành công | Passed |
| DS_005 | Cập nhật danh mục thuốc thành công | Passed |
| DS_006 | Xóa danh mục thuốc thành công | Passed |

#### 3.1.2 Kiểm thử Controller

Kiểm thử các controller bao gồm ThuocController, LoaiThuocController và DanhMucThuocController. Các phương thức được kiểm thử bao gồm thêm, sửa, xóa và tìm kiếm.

**Kết quả kiểm thử**:

| Controller | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|------------|-------------------|------------|----------|------------------|
| ThuocController | 5 | 5 | 0 | 100% |
| LoaiThuocController | 5 | 5 | 0 | 100% |
| DanhMucThuocController | 5 | 5 | 0 | 100% |
| **Tổng cộng** | **15** | **15** | **0** | **100%** |

**Chi tiết test case**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| TC_001 | Lấy danh sách thuốc thành công | Passed |
| TC_002 | Tìm thuốc theo ID thành công | Passed |
| TC_003 | Tạo thuốc thành công | Passed |
| TC_004 | Cập nhật thuốc thành công | Passed |
| TC_005 | Xóa thuốc thành công | Passed |
| LC_001 | Lấy danh sách loại thuốc thành công | Passed |
| LC_002 | Tìm loại thuốc theo tên thành công | Passed |
| LC_003 | Tạo loại thuốc thành công | Passed |
| LC_004 | Cập nhật loại thuốc thành công | Passed |
| LC_005 | Xóa loại thuốc thành công | Passed |
| DC_001 | Lấy danh sách danh mục thuốc thành công | Passed |
| DC_002 | Tìm danh mục thuốc theo tên thành công | Passed |
| DC_003 | Tạo danh mục thuốc thành công | Passed |
| DC_004 | Cập nhật danh mục thuốc thành công | Passed |
| DC_005 | Xóa danh mục thuốc thành công | Passed |

### 3.2 Giai đoạn 3: Kiểm thử tích hợp

Giai đoạn kiểm thử tích hợp tập trung vào việc kiểm tra sự tương tác giữa các thành phần khác nhau của hệ thống, bao gồm tích hợp giữa các thành phần Backend và tích hợp giữa Frontend và Backend.

#### 3.2.1 Kiểm thử tích hợp Backend

Kiểm thử tích hợp Backend tập trung vào việc kiểm tra sự tương tác giữa các thành phần Backend, bao gồm Controller, Service, Repository và Database.

**Kết quả kiểm thử**:

| API | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|-----|-------------------|------------|----------|------------------|
| API Thuốc | 5 | 5 | 0 | 100% |
| API Loại Thuốc | 3 | 3 | 0 | 100% |
| API Danh Mục Thuốc | 2 | 2 | 0 | 100% |
| **Tổng cộng** | **10** | **10** | **0** | **100%** |

**Phương pháp kiểm thử**:
- Sử dụng Postman để kiểm thử các API
- Sử dụng JUnit và MockMvc để kiểm thử tích hợp giữa các thành phần Backend

**Các vấn đề phát hiện**:
- Phát hiện lỗi StackOverflowError do quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc
- Phát hiện lỗi phương thức HTTP không đúng cho multipart/form-data

**Giải pháp**:
- Thêm annotation @JsonIgnore cho thuộc tính danhMucThuoc trong lớp LoaiThuoc
- Thay đổi API cập nhật thuốc để sử dụng phương thức POST thay vì PUT

#### 3.2.2 Kiểm thử tích hợp Frontend-Backend

Kiểm thử tích hợp Frontend-Backend tập trung vào việc kiểm tra sự tương tác giữa Frontend và Backend, đảm bảo rằng dữ liệu được truyền và nhận chính xác giữa hai thành phần.

**Kết quả kiểm thử**:

| Chức năng | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|-----------|-------------------|------------|----------|------------------|
| Thêm thuốc | 1 | 1 | 0 | 100% |
| Sửa thuốc | 1 | 1 | 0 | 100% |
| **Tổng cộng** | **2** | **2** | **0** | **100%** |

**Phương pháp kiểm thử**:
- Sử dụng Cypress để kiểm thử tích hợp giữa Frontend và Backend
- Sử dụng Postman để kiểm thử API và kiểm tra kết quả trên giao diện

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử tích hợp Frontend-Backend

### 3.3 Giai đoạn 4: Kiểm thử chức năng

Giai đoạn kiểm thử chức năng tập trung vào việc kiểm tra các chức năng của hệ thống, đảm bảo rằng chúng hoạt động đúng theo yêu cầu.

#### 3.3.1 Kiểm thử chức năng thêm thuốc

Kiểm thử chức năng thêm thuốc tập trung vào việc kiểm tra các trường hợp thêm thuốc thành công và thất bại.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| TC_ADD_THUOC_001 | Thêm thuốc thành công với đầy đủ thông tin | Passed |
| TC_ADD_THUOC_002 | Thêm thuốc với mã thuốc đã tồn tại | Passed |
| TC_ADD_THUOC_003 | Thêm thuốc với thông tin bắt buộc bị thiếu | Passed |
| TC_ADD_THUOC_004 | Thêm thuốc với giá trị không hợp lệ | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Postman để kiểm thử API thêm thuốc
- Sử dụng Cypress để kiểm thử giao diện thêm thuốc

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử chức năng thêm thuốc

#### 3.3.2 Kiểm thử chức năng cập nhật thuốc

Kiểm thử chức năng cập nhật thuốc tập trung vào việc kiểm tra các trường hợp cập nhật thuốc thành công và thất bại.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| TC_UPDATE_THUOC_001 | Cập nhật thuốc thành công | Passed |
| TC_UPDATE_THUOC_002 | Cập nhật thuốc với mã thuốc đã tồn tại | Passed |
| TC_UPDATE_THUOC_003 | Cập nhật thuốc với thông tin bắt buộc bị thiếu | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Postman để kiểm thử API cập nhật thuốc
- Sử dụng Cypress để kiểm thử giao diện cập nhật thuốc

**Các vấn đề phát hiện**:
- Phát hiện lỗi thông báo không khớp khi không tìm thấy loại thuốc

**Giải pháp**:
- Thống nhất nội dung thông báo lỗi giữa backend và frontend

#### 3.3.3 Kiểm thử chức năng xóa thuốc

Kiểm thử chức năng xóa thuốc tập trung vào việc kiểm tra các trường hợp xóa thuốc thành công và thất bại.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| TC_DELETE_THUOC_001 | Xóa thuốc thành công | Passed |
| TC_DELETE_THUOC_002 | Hủy xóa thuốc | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Postman để kiểm thử API xóa thuốc
- Sử dụng Cypress để kiểm thử giao diện xóa thuốc

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử chức năng xóa thuốc

#### 3.3.4 Kiểm thử chức năng tìm kiếm thuốc

Kiểm thử chức năng tìm kiếm thuốc tập trung vào việc kiểm tra các trường hợp tìm kiếm thuốc thành công và thất bại.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| TC_SEARCH_THUOC_001 | Tìm kiếm thuốc theo tên | Passed |
| TC_SEARCH_THUOC_002 | Tìm kiếm thuốc theo mã | Passed |
| TC_SEARCH_THUOC_003 | Tìm kiếm thuốc theo loại thuốc | Passed |
| TC_SEARCH_THUOC_004 | Tìm kiếm thuốc theo nhà sản xuất | Passed |
| TC_SEARCH_THUOC_005 | Tìm kiếm thuốc với nhiều tiêu chí | Passed |
| TC_SEARCH_THUOC_006 | Tìm kiếm thuốc không tồn tại | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Postman để kiểm thử API tìm kiếm thuốc
- Sử dụng Cypress để kiểm thử giao diện tìm kiếm thuốc

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử chức năng tìm kiếm thuốc

### 3.4 Giai đoạn 5: Kiểm thử giao diện

Giai đoạn kiểm thử giao diện tập trung vào việc kiểm tra giao diện người dùng, đảm bảo rằng giao diện hiển thị đúng và dễ sử dụng.

#### 3.4.1 Kiểm thử giao diện danh sách thuốc

Kiểm thử giao diện danh sách thuốc tập trung vào việc kiểm tra hiển thị danh sách thuốc, phân trang và sắp xếp.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| UI_LIST_001 | Hiển thị danh sách thuốc | Passed |
| UI_LIST_002 | Phân trang danh sách thuốc | Passed |
| UI_LIST_003 | Sắp xếp danh sách thuốc | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Cypress để kiểm thử giao diện danh sách thuốc
- Kiểm tra thủ công trên các trình duyệt khác nhau

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử giao diện danh sách thuốc

#### 3.4.2 Kiểm thử giao diện thêm/sửa thuốc

Kiểm thử giao diện thêm/sửa thuốc tập trung vào việc kiểm tra hiển thị form thêm/sửa thuốc và thông báo lỗi.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| UI_FORM_001 | Hiển thị form thêm thuốc | Passed |
| UI_FORM_002 | Hiển thị form sửa thuốc | Passed |
| UI_FORM_003 | Hiển thị thông báo lỗi khi nhập liệu không hợp lệ | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Cypress để kiểm thử giao diện thêm/sửa thuốc
- Kiểm tra thủ công trên các trình duyệt khác nhau

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử giao diện thêm/sửa thuốc

#### 3.4.3 Kiểm thử giao diện chi tiết thuốc

Kiểm thử giao diện chi tiết thuốc tập trung vào việc kiểm tra hiển thị chi tiết thuốc.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| UI_DETAIL_001 | Hiển thị chi tiết thuốc | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Cypress để kiểm thử giao diện chi tiết thuốc
- Kiểm tra thủ công trên các trình duyệt khác nhau

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử giao diện chi tiết thuốc

#### 3.4.4 Kiểm thử giao diện tìm kiếm thuốc

Kiểm thử giao diện tìm kiếm thuốc tập trung vào việc kiểm tra hiển thị form tìm kiếm thuốc và kết quả tìm kiếm.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| UI_SEARCH_001 | Hiển thị form tìm kiếm thuốc | Passed |
| UI_SEARCH_002 | Hiển thị kết quả tìm kiếm thuốc | Passed |
| UI_SEARCH_003 | Hiển thị thông báo khi không tìm thấy thuốc | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Cypress để kiểm thử giao diện tìm kiếm thuốc
- Kiểm tra thủ công trên các trình duyệt khác nhau

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử giao diện tìm kiếm thuốc

### 3.5 Giai đoạn 6: Kiểm thử hệ thống

Giai đoạn kiểm thử hệ thống tập trung vào việc kiểm tra hệ thống như một tổng thể, bao gồm kiểm thử luồng nghiệp vụ, hiệu năng và tương thích.

#### 3.5.1 Kiểm thử luồng nghiệp vụ (End-to-End Testing)

Kiểm thử luồng nghiệp vụ tập trung vào việc kiểm tra các luồng nghiệp vụ từ đầu đến cuối, đảm bảo rằng các chức năng hoạt động đúng khi được sử dụng cùng nhau.

**Kết quả kiểm thử**:

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| E2E_001 | Luồng thêm thuốc mới | Passed |
| E2E_002 | Luồng sửa thông tin thuốc | Passed |
| E2E_003 | Luồng xóa thuốc | Passed |

**Phương pháp kiểm thử**:
- Sử dụng Cypress để kiểm thử luồng nghiệp vụ
- Kiểm tra thủ công trên các trình duyệt khác nhau

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử luồng nghiệp vụ

#### 3.5.2 Kiểm thử hiệu năng (Performance Testing)

Kiểm thử hiệu năng tập trung vào việc kiểm tra hiệu năng của hệ thống, bao gồm thời gian phản hồi, thông lượng và tỷ lệ lỗi.

**Kết quả kiểm thử**:

| API | Thời gian phản hồi trung bình | Thông lượng | Tỷ lệ lỗi | Kết quả |
|-----|-------------------------------|-------------|-----------|---------|
| Lấy danh sách thuốc | 120ms | 25 req/s | 0% | Passed |
| Tìm kiếm thuốc | 150ms | 20 req/s | 0% | Passed |
| Thêm thuốc mới | 200ms | 15 req/s | 0% | Passed |
| Sửa thuốc | 180ms | 15 req/s | 0% | Passed |
| Xóa thuốc | 100ms | 30 req/s | 0% | Passed |

**Phương pháp kiểm thử**:
- Sử dụng JMeter để kiểm thử hiệu năng
- Sử dụng Chrome DevTools để đo thời gian tải trang

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử hiệu năng

#### 3.5.3 Kiểm thử tương thích (Compatibility Testing)

Kiểm thử tương thích tập trung vào việc kiểm tra hệ thống trên các trình duyệt và thiết bị khác nhau, đảm bảo rằng hệ thống hoạt động đúng trên tất cả các nền tảng.

**Kết quả kiểm thử**:

| Trình duyệt | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|-------------|-------------------|------------|----------|------------------|
| Chrome | 8 | 8 | 0 | 100% |
| Edge | 8 | 8 | 0 | 100% |

**Phương pháp kiểm thử**:
- Sử dụng Cypress với BrowserStack để kiểm thử tương thích
- Kiểm tra thủ công trên các trình duyệt khác nhau

**Các vấn đề phát hiện**:
- Không phát hiện vấn đề nào trong quá trình kiểm thử tương thích

## 4. KẾT LUẬN

### 4.1 Đánh giá chung về chất lượng sản phẩm

Chức năng Quản lý thuốc đã được kiểm thử kỹ lưỡng và đạt kết quả tốt. Tất cả các test case đều thành công, không phát hiện lỗi nào trong quá trình kiểm thử cuối cùng. Điều này cho thấy chức năng Quản lý thuốc có chất lượng tốt và đáp ứng các yêu cầu đã đề ra.

Trong quá trình phát triển, đã phát hiện và khắc phục 4 lỗi:
1. Lỗi trạng thái khi danh sách trống (mức độ thấp)
2. Lỗi StackOverflowError do quan hệ hai chiều (mức độ cao)
3. Lỗi thông báo không khớp (mức độ thấp)
4. Lỗi phương thức HTTP không đúng (mức độ trung bình)

Hiệu năng của hệ thống đạt yêu cầu, với thời gian phản hồi trung bình dưới 200ms và thông lượng cao. Giao diện người dùng thân thiện và dễ sử dụng, đáp ứng tốt trên các trình duyệt khác nhau.

### 4.2 Đánh giá chung về quy trình kiểm thử

Quy trình kiểm thử đã được thực hiện một cách có hệ thống và đầy đủ, bao gồm các giai đoạn từ kiểm thử đơn vị đến kiểm thử hệ thống. Các công cụ kiểm thử đã được sử dụng hiệu quả để tự động hóa quá trình kiểm thử. Tài liệu kiểm thử đã được chuẩn bị đầy đủ và chi tiết.

Điểm mạnh của quy trình kiểm thử:
- Áp dụng kiểm thử tự động hóa giúp tiết kiệm thời gian và công sức
- Kiểm thử được thực hiện ở nhiều cấp độ, từ đơn vị đến hệ thống
- Tài liệu kiểm thử đầy đủ và chi tiết
- Phát hiện lỗi sớm trong quá trình phát triển

Điểm cần cải thiện:
- Cần tăng cường kiểm thử an toàn thông tin
- Cần tích hợp kiểm thử vào quy trình CI/CD
- Cần áp dụng phương pháp kiểm thử dựa trên hành vi (BDD)

### 4.3 Kế hoạch tiếp theo

Kế hoạch tiếp theo bao gồm:

1. Triển khai các đề xuất cải tiến đã nêu:
   - Thêm tính năng lọc thuốc theo nhiều tiêu chí hơn
   - Tối ưu hóa truy vấn cơ sở dữ liệu để tăng tốc độ tìm kiếm
   - Cải thiện giao diện người dùng trên thiết bị di động
   - Tăng cường kiểm tra quyền truy cập

2. Tiếp tục kiểm thử các chức năng khác của hệ thống:
   - Quản lý kho
   - Quản lý đơn hàng
   - Quản lý khuyến mãi
   - Quản lý người dùng

3. Tích hợp kiểm thử vào quy trình CI/CD:
   - Cấu hình Jenkins/GitHub Actions để tự động chạy kiểm thử khi có commit mới
   - Tự động hóa việc báo cáo kết quả kiểm thử

4. Tăng cường kiểm thử an toàn thông tin:
   - Kiểm thử bảo mật (Security Testing)
   - Kiểm thử xâm nhập (Penetration Testing)

5. Tăng cường kiểm thử hiệu năng:
   - Kiểm thử tải (Load Testing)
   - Kiểm thử áp lực (Stress Testing)
   - Kiểm thử độ bền (Endurance Testing)

## 5. PHỤ LỤC

### 5.1 Testcase chi tiết

Testcase chi tiết cho từng giai đoạn được lưu trữ trong các file CSV sau:

- [Testcase giai đoạn 2: Kiểm thử đơn vị](../../../giai-doan-2-unit-test/testcase/Unit_Test_TiengViet.csv)
- [Testcase giai đoạn 3: Kiểm thử tích hợp](../../../giai-doan-3-integration-test/testcase/Integration_Test_TiengViet.csv)
- [Testcase giai đoạn 4: Kiểm thử chức năng](../../../giai-doan-4-functional-test/testcase/Functional_Test_TiengViet.csv)
- [Testcase giai đoạn 5: Kiểm thử giao diện](../../../giai-doan-5-ui-test/testcase/UI_Test_TiengViet.csv)
- [Testcase giai đoạn 6: Kiểm thử hệ thống](../../../giai-doan-6-system-test/testcase/System_Test_TiengViet.csv)
- [Testcase tổng hợp](../testcase/Testcase_Quan_Ly_Thuoc.csv)
- [Testcase tổng hợp tất cả giai đoạn](../Testcase_Tong_Hop_Tat_Ca_Giai_Doan.csv)

### 5.2 Báo cáo lỗi chi tiết

Báo cáo lỗi chi tiết được lưu trữ trong file [Phan_Tich_Loi.md](../phan-tich-loi/Phan_Tich_Loi.md).

### 5.3 Đề xuất cải tiến chi tiết

Đề xuất cải tiến chi tiết được lưu trữ trong file [De_Xuat_Cai_Tien.md](../de-xuat-cai-tien/De_Xuat_Cai_Tien.md).

### 5.4 Biểu đồ tổng hợp

Biểu đồ tổng hợp kết quả kiểm thử được lưu trữ trong thư mục [bieu-do](../bieu-do).

### 5.5 Tài liệu tham khảo

1. **Tài liệu dự án**:
   - [Tài liệu đặc tả yêu cầu](../../../docs/Yeu_Cau_He_Thong.md)
   - [Tài liệu thiết kế](../../../docs/Thiet_Ke_He_Thong.md)

2. **Tài liệu kiểm thử**:
   - [Kế hoạch triển khai kiểm thử](../../Ke_Hoach_Trien_Khai_Kiem_Thu.md)
   - [Tài liệu kiểm thử tổng hợp](../../Tai_Lieu_Kiem_Thu_Tong_Hop.md)
   - [Kế hoạch bổ sung testcase](../Ke_Hoach_Bo_Sung_Testcase.md)

3. **Tài liệu công cụ kiểm thử**:
   - [Tài liệu JUnit](https://junit.org/junit5/docs/current/user-guide/)
   - [Tài liệu Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
   - [Tài liệu Cypress](https://docs.cypress.io/)
   - [Tài liệu Postman](https://learning.postman.com/docs/getting-started/introduction/)
   - [Tài liệu JMeter](https://jmeter.apache.org/usermanual/index.html)
