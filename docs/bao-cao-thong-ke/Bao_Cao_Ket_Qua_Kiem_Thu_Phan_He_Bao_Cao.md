# Báo cáo kết quả kiểm thử phân hệ Báo cáo và Thống kê

## 1. Tổng quan

### 1.1. Mục đích

Báo cáo này trình bày kết quả kiểm thử phân hệ Báo cáo và Thống kê trong hệ thống quản lý hiệu thuốc. Mục đích của việc kiểm thử là đảm bảo các chức năng báo cáo doanh thu, báo cáo tồn kho và báo cáo thuốc bán chạy hoạt động đúng theo yêu cầu đặc tả.

### 1.2. Phạm vi kiểm thử

Phạm vi kiểm thử bao gồm:
- Kiểm thử giao diện (UI Testing)
- Kiểm thử đơn vị (Unit Testing)
- Kiểm thử hộp đen (Black Box Testing)

### 1.3. Môi trường kiểm thử

- **Phần cứng**: Laptop Dell XPS 15, Intel Core i7, 16GB RAM
- **Hệ điều hành**: Windows 11 Pro
- **Trình duyệt**: Google Chrome 114.0.5735.199
- **Công cụ kiểm thử**: JUnit 5, Mockito, Selenium WebDriver 4.10.0
- **Cơ sở dữ liệu**: PostgreSQL 14.5

## 2. Kết quả kiểm thử

### 2.1. Kiểm thử giao diện (UI Testing)

#### 2.1.1. Tổng quan

| Loại test case | Số lượng | Passed | Failed | Blocked | Pass rate |
|----------------|----------|--------|--------|---------|-----------|
| Kiểm thử giao diện | 5 | 3 | 2 | 0 | 60% |

#### 2.1.2. Chi tiết kết quả

| Test case ID | Mô tả | Kết quả | Ghi chú |
|--------------|-------|---------|---------|
| TC-UI-001 | Kiểm tra hiển thị giao diện báo cáo doanh thu theo ngày | Passed | Giao diện hiển thị đúng với yêu cầu |
| TC-UI-002 | Kiểm tra hiển thị giao diện báo cáo doanh thu theo tháng | Passed | Giao diện hiển thị đúng với yêu cầu |
| TC-UI-003 | Kiểm tra hiển thị giao diện báo cáo doanh thu theo năm | Passed | Giao diện hiển thị đúng với yêu cầu |
| TC-UI-004 | Kiểm tra hiển thị giao diện báo cáo tồn kho | Failed | Không có giao diện báo cáo tồn kho |
| TC-UI-005 | Kiểm tra hiển thị giao diện báo cáo thuốc bán chạy | Failed | Không có giao diện báo cáo thuốc bán chạy |

#### 2.1.3. Phân tích lỗi

1. **TC-UI-004: Kiểm tra hiển thị giao diện báo cáo tồn kho**
   - **Mô tả lỗi**: Không tìm thấy giao diện báo cáo tồn kho trong hệ thống
   - **Nguyên nhân**: Chức năng báo cáo tồn kho chưa được triển khai trong code
   - **Mức độ nghiêm trọng**: Major
   - **Khuyến nghị**: Triển khai giao diện báo cáo tồn kho theo yêu cầu đặc tả

2. **TC-UI-005: Kiểm tra hiển thị giao diện báo cáo thuốc bán chạy**
   - **Mô tả lỗi**: Không tìm thấy giao diện báo cáo thuốc bán chạy trong hệ thống
   - **Nguyên nhân**: Chức năng báo cáo thuốc bán chạy chưa được triển khai trong code
   - **Mức độ nghiêm trọng**: Major
   - **Khuyến nghị**: Triển khai giao diện báo cáo thuốc bán chạy theo yêu cầu đặc tả

### 2.2. Kiểm thử đơn vị (Unit Testing)

#### 2.2.1. Tổng quan

| Loại test case | Số lượng | Passed | Failed | Blocked | Pass rate |
|----------------|----------|--------|--------|---------|-----------|
| Kiểm thử đơn vị | 3 | 3 | 0 | 0 | 100% |

#### 2.2.2. Chi tiết kết quả

| Test case ID | Mô tả | Kết quả | Ghi chú |
|--------------|-------|---------|---------|
| TC-UT-001 | Kiểm thử phương thức doanhThuTheoNgay | Passed | Phương thức hoạt động đúng với yêu cầu |
| TC-UT-002 | Kiểm thử phương thức doanhThuTheoThang | Passed | Phương thức hoạt động đúng với yêu cầu |
| TC-UT-003 | Kiểm thử query doanhThuTheoNgay | Passed | Query trả về kết quả đúng với yêu cầu |

#### 2.2.3. Phân tích kết quả

Các phương thức trong BaoCaoController và các query trong DonHangRepo hoạt động đúng với yêu cầu. Tuy nhiên, cần bổ sung thêm các phương thức và query cho báo cáo tồn kho và báo cáo thuốc bán chạy.

### 2.3. Kiểm thử hộp đen (Black Box Testing)

#### 2.3.1. Tổng quan

| Loại test case | Số lượng | Passed | Failed | Blocked | Pass rate |
|----------------|----------|--------|--------|---------|-----------|
| Kiểm thử hộp đen | 4 | 2 | 2 | 0 | 50% |

#### 2.3.2. Chi tiết kết quả

| Test case ID | Mô tả | Kết quả | Ghi chú |
|--------------|-------|---------|---------|
| TC-BB-001 | Kiểm thử báo cáo doanh thu theo ngày | Passed | Chức năng hoạt động đúng với yêu cầu |
| TC-BB-002 | Kiểm thử báo cáo doanh thu với ngày không có dữ liệu | Passed | Chức năng hoạt động đúng với yêu cầu |
| TC-BB-003 | Kiểm thử báo cáo tồn kho | Failed | Không có chức năng báo cáo tồn kho |
| TC-BB-004 | Kiểm thử báo cáo thuốc bán chạy | Failed | Không có chức năng báo cáo thuốc bán chạy |

#### 2.3.3. Phân tích lỗi

1. **TC-BB-003: Kiểm thử báo cáo tồn kho**
   - **Mô tả lỗi**: Không tìm thấy chức năng báo cáo tồn kho trong hệ thống
   - **Nguyên nhân**: Chức năng báo cáo tồn kho chưa được triển khai trong code
   - **Mức độ nghiêm trọng**: Major
   - **Khuyến nghị**: Triển khai chức năng báo cáo tồn kho theo yêu cầu đặc tả

2. **TC-BB-004: Kiểm thử báo cáo thuốc bán chạy**
   - **Mô tả lỗi**: Không tìm thấy chức năng báo cáo thuốc bán chạy trong hệ thống
   - **Nguyên nhân**: Chức năng báo cáo thuốc bán chạy chưa được triển khai trong code
   - **Mức độ nghiêm trọng**: Major
   - **Khuyến nghị**: Triển khai chức năng báo cáo thuốc bán chạy theo yêu cầu đặc tả

## 3. Phân tích kết quả kiểm thử

### 3.1. Tổng hợp kết quả

| Loại test case | Số lượng | Passed | Failed | Blocked | Pass rate |
|----------------|----------|--------|--------|---------|-----------|
| Kiểm thử giao diện | 5 | 3 | 2 | 0 | 60% |
| Kiểm thử đơn vị | 3 | 3 | 0 | 0 | 100% |
| Kiểm thử hộp đen | 4 | 2 | 2 | 0 | 50% |
| **Tổng cộng** | **12** | **8** | **4** | **0** | **67%** |

### 3.2. Phân tích lỗi chung

Qua kết quả kiểm thử, có thể thấy các lỗi chính tập trung vào việc thiếu triển khai các chức năng báo cáo tồn kho và báo cáo thuốc bán chạy. Cụ thể:

1. **Thiếu triển khai chức năng báo cáo tồn kho**:
   - Không có giao diện báo cáo tồn kho
   - Không có endpoint trong BaoCaoController để lấy dữ liệu báo cáo tồn kho
   - Không có phương thức trong BaoCaoService để gọi API báo cáo tồn kho

2. **Thiếu triển khai chức năng báo cáo thuốc bán chạy**:
   - Không có giao diện báo cáo thuốc bán chạy
   - Không có endpoint trong BaoCaoController để lấy dữ liệu báo cáo thuốc bán chạy
   - Không có phương thức trong BaoCaoService để gọi API báo cáo thuốc bán chạy

3. **Thiếu chức năng xuất báo cáo**:
   - Không có chức năng xuất báo cáo ra file Excel hoặc PDF
   - Không có thư viện hoặc code để tạo file Excel hoặc PDF từ dữ liệu báo cáo

### 3.3. Khuyến nghị

Dựa trên kết quả kiểm thử, các khuyến nghị để cải thiện phân hệ Báo cáo và Thống kê như sau:

1. **Triển khai chức năng báo cáo tồn kho**:
   - Tạo endpoint trong BaoCaoController để lấy dữ liệu báo cáo tồn kho
   - Tạo phương thức trong BaoCaoService để gọi API báo cáo tồn kho
   - Tạo giao diện báo cáo tồn kho trong ThongKeComponent

2. **Triển khai chức năng báo cáo thuốc bán chạy**:
   - Tạo endpoint trong BaoCaoController để lấy dữ liệu báo cáo thuốc bán chạy
   - Tạo phương thức trong BaoCaoService để gọi API báo cáo thuốc bán chạy
   - Tạo giao diện báo cáo thuốc bán chạy trong ThongKeComponent

3. **Triển khai chức năng xuất báo cáo**:
   - Tích hợp thư viện để tạo file Excel (như Apache POI) và PDF (như iText)
   - Tạo endpoint trong BaoCaoController để xuất báo cáo ra file Excel hoặc PDF
   - Tạo phương thức trong BaoCaoService để gọi API xuất báo cáo
   - Tạo nút "Xuất Excel" và "Xuất PDF" trong giao diện báo cáo

4. **Cải thiện hiệu suất query**:
   - Thêm index cho các trường được sử dụng trong điều kiện WHERE và GROUP BY
   - Tối ưu hóa các query để cải thiện hiệu suất khi dữ liệu lớn

5. **Bổ sung xử lý ngoại lệ và kiểm tra quyền truy cập**:
   - Triển khai xử lý ngoại lệ (try-catch) cho các trường hợp lỗi
   - Triển khai kiểm tra quyền truy cập (authorization) cho các endpoint và component

## 4. Kết luận

Phân hệ Báo cáo và Thống kê đã triển khai được chức năng báo cáo doanh thu theo ngày, tháng, năm với giao diện trực quan và dữ liệu chính xác. Tuy nhiên, còn thiếu các chức năng báo cáo tồn kho, báo cáo thuốc bán chạy và xuất báo cáo ra file Excel hoặc PDF.

Để đáp ứng đầy đủ yêu cầu đặc tả, cần triển khai bổ sung các chức năng còn thiếu và cải thiện các chức năng hiện có theo các khuyến nghị đã nêu.

Tỷ lệ pass của các test case là 67%, cho thấy phân hệ Báo cáo và Thống kê chưa đáp ứng đầy đủ yêu cầu đặc tả. Cần tiếp tục phát triển và kiểm thử để đảm bảo chất lượng phần mềm.
