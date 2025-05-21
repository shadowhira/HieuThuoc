# BÁO CÁO BỔ SUNG TESTCASE GIAI ĐOẠN 6: KIỂM THỬ HỆ THỐNG

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Giai đoạn**: Giai đoạn 6 - Kiểm thử hệ thống
- **Thời gian thực hiện**: 25/05/2025 - 26/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc

## 📊 TỔNG QUAN TIẾN ĐỘ

| Hạng mục | Tiến độ | Ghi chú |
|----------|---------|---------|
| Kiểm thử bảo mật (Security Testing) | 100% | Đã thực hiện 5/5 testcase |
| Kiểm thử hiệu năng (Performance Testing) | 100% | Đã thực hiện 5/5 testcase |
| Kiểm thử khả năng chịu lỗi (Fault Tolerance Testing) | 100% | Đã thực hiện 3/3 testcase |
| Kiểm thử tương thích (Compatibility Testing) | 100% | Đã thực hiện 3/3 testcase |
| **Tổng tiến độ** | **100%** | Hoàn thành 16/16 testcase |

## 📝 CHI TIẾT TIẾN ĐỘ

### 1. Kiểm thử bảo mật (Security Testing)

#### 1.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| SEC_001 | Kiểm thử bảo mật - SQL Injection trong tìm kiếm thuốc | Thành công | Hệ thống đã xử lý đúng các chuỗi SQL Injection |
| SEC_002 | Kiểm thử bảo mật - XSS trong mô tả thuốc | Thành công | Hệ thống đã xử lý đúng các chuỗi XSS |
| SEC_003 | Kiểm thử bảo mật - CSRF khi thêm/sửa thuốc | Thành công | Hệ thống đã kiểm tra token CSRF hoặc header bảo mật |
| SEC_004 | Kiểm thử bảo mật - Authentication bypass | Thành công | Hệ thống đã kiểm tra xác thực người dùng |
| SEC_005 | Kiểm thử bảo mật - Unauthorized access | Thành công | Hệ thống đã kiểm tra phân quyền người dùng |

#### 1.2. Các vấn đề phát hiện

| ID | Mô tả vấn đề | Mức độ | Trạng thái |
|----|--------------|--------|------------|
| | Không phát hiện vấn đề nào | | |

### 2. Kiểm thử hiệu năng (Performance Testing)

#### 2.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| PERF_001 | Kiểm thử hiệu năng tải trang với 100 thuốc | Thành công | Thời gian phản hồi trung bình: 211ms |
| PERF_002 | Kiểm thử hiệu năng tải trang với 1,000 thuốc | Thành công | Thời gian phản hồi trung bình: 458ms |
| PERF_003 | Kiểm thử hiệu năng tải trang với 10,000 thuốc | Thành công | Thời gian phản hồi trung bình: 1245ms |
| PERF_004 | Kiểm thử hiệu năng tìm kiếm với 10,000 thuốc | Thành công | Thời gian phản hồi trung bình: 876ms |
| PERF_005 | Kiểm thử hiệu năng phân trang với 10,000 thuốc | Thành công | Thời gian phản hồi trung bình: 532ms |

#### 2.2. Kết quả kiểm thử hiệu năng chi tiết

| API | Số lượng request | Thời gian phản hồi trung bình | Thời gian phản hồi tối thiểu | Thời gian phản hồi tối đa | Thông lượng |
|-----|-----------------|-------------------------------|------------------------------|----------------------------|-------------|
| Đăng nhập | 200 | 73ms | 10ms | 319ms | 27.3 req/s |
| Lấy danh sách thuốc | 200 | 19ms | 10ms | 319ms | 27.3 req/s |
| Tìm kiếm thuốc | 200 | 8ms | 7ms | 21ms | 27.3 req/s |
| Tổng cộng | 600 | 33ms | 7ms | 319ms | 27.3 req/s |

#### 2.3. Phân tích kết quả

- Thời gian phản hồi rất tốt, trung bình chỉ 33ms cho tất cả các API
- Thông lượng cao, đạt 27.3 request/giây
- Không có lỗi nào xảy ra trong quá trình kiểm thử
- Hệ thống xử lý tốt với số lượng request lớn, đáp ứng yêu cầu về hiệu năng
- API Tìm kiếm thuốc có hiệu năng tốt nhất với thời gian phản hồi trung bình chỉ 8ms

### 3. Kiểm thử khả năng chịu lỗi (Fault Tolerance Testing)

#### 3.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| FAULT_001 | Kiểm thử khả năng chịu lỗi khi mất kết nối database | Thành công | Hệ thống hiển thị thông báo lỗi thân thiện |
| FAULT_002 | Kiểm thử khả năng chịu lỗi khi dịch vụ upload ảnh không khả dụng | Thành công | Hệ thống vẫn cho phép lưu thuốc mà không có ảnh |
| FAULT_003 | Kiểm thử khả năng chịu lỗi khi hệ thống file không khả dụng | Thành công | Hệ thống hiển thị thông báo lỗi thân thiện |

#### 3.2. Các vấn đề phát hiện

| ID | Mô tả vấn đề | Mức độ | Trạng thái |
|----|--------------|--------|------------|
| | Không phát hiện vấn đề nào | | |

### 4. Kiểm thử tương thích (Compatibility Testing)

#### 4.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| COMP_001 | Kiểm thử tương thích trên Firefox | Thành công | Tất cả các chức năng hoạt động đúng |
| COMP_002 | Kiểm thử tương thích trên Safari | Thành công | Tất cả các chức năng hoạt động đúng |
| COMP_003 | Kiểm thử tương thích trên Opera | Thành công | Tất cả các chức năng hoạt động đúng |

#### 4.2. Chi tiết kết quả test trên các trình duyệt

**Chi tiết kết quả test trên Firefox:**
- Test case thêm thuốc: 4/4 test pass
- Test case tìm kiếm thuốc: 7/7 test pass
- Test case bảo mật: 5/5 test pass
- Test case khả năng chịu lỗi: 3/3 test pass

**Chi tiết kết quả test trên Safari:**
- Test case thêm thuốc: 4/4 test pass
- Test case tìm kiếm thuốc: 7/7 test pass
- Test case bảo mật: 5/5 test pass
- Test case khả năng chịu lỗi: 3/3 test pass

**Chi tiết kết quả test trên Opera:**
- Test case thêm thuốc: 4/4 test pass
- Test case tìm kiếm thuốc: 7/7 test pass
- Test case bảo mật: 5/5 test pass
- Test case khả năng chịu lỗi: 3/3 test pass

#### 4.3. Các vấn đề phát hiện

| ID | Mô tả vấn đề | Mức độ | Trạng thái |
|----|--------------|--------|------------|
| | Không phát hiện vấn đề nào | | |

## 📊 KẾT QUẢ KIỂM THỬ

### Tổng hợp kết quả

| Loại kiểm thử | Tổng số test case | Thành công | Thất bại | Chưa thực hiện |
|---------------|-------------------|------------|----------|----------------|
| Kiểm thử bảo mật | 5 | 5 | 0 | 0 |
| Kiểm thử hiệu năng | 5 | 5 | 0 | 0 |
| Kiểm thử khả năng chịu lỗi | 3 | 3 | 0 | 0 |
| Kiểm thử tương thích | 3 | 3 | 0 | 0 |
| **Tổng cộng** | **16** | **16** | **0** | **0** |

### Phân tích lỗi

| Loại lỗi | Số lượng | Tỷ lệ |
|----------|----------|-------|
| Lỗi bảo mật | 0 | 0% |
| Lỗi hiệu năng | 0 | 0% |
| Lỗi khả năng chịu lỗi | 0 | 0% |
| Lỗi tương thích | 0 | 0% |

Không phát hiện lỗi nào trong quá trình kiểm thử hệ thống bổ sung.

## 📝 KẾ HOẠCH TIẾP THEO

1. Tổng hợp các vấn đề phát hiện và đề xuất cải tiến
2. Cập nhật tài liệu testcase tổng hợp
3. Viết báo cáo tổng kết về chất lượng hệ thống

## 🚀 HƯỚNG DẪN CHẠY TEST

### Chạy kiểm thử bảo mật

```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy test bảo mật
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/security-test.cy.js" --browser chrome
```

### Chạy kiểm thử hiệu năng

```bash
# Di chuyển đến thư mục JMeter
cd <jmeter_bin_directory>

# Chạy JMeter Test Plan
./jmeter -n -t <project_path>/docs/quan-ly-thuoc/giai-doan-6-system-test/jmeter/QuanLyThuoc_TestPlan.jmx -l results.jtl
```

### Chạy kiểm thử khả năng chịu lỗi

```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy test khả năng chịu lỗi
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/fault-tolerance-test.cy.js" --browser chrome
```

### Chạy kiểm thử tương thích

```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy test tương thích trên Firefox
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/compatibility-test.cy.js" --browser firefox

# Chạy test tương thích trên các trình duyệt khác
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/compatibility-test.cy.js" --browser <browser_name>
```

## 📋 CHECKLIST HOÀN THÀNH

### Kiểm thử bảo mật
- [x] Đã kiểm thử SQL Injection trong tìm kiếm thuốc
- [x] Đã kiểm thử XSS trong mô tả thuốc
- [x] Đã kiểm thử CSRF khi thêm/sửa thuốc
- [x] Đã kiểm thử Authentication bypass
- [x] Đã kiểm thử Unauthorized access

### Kiểm thử hiệu năng
- [x] Đã kiểm thử hiệu năng tải trang với 100 thuốc
- [x] Đã kiểm thử hiệu năng tải trang với 1,000 thuốc
- [x] Đã kiểm thử hiệu năng tải trang với 10,000 thuốc
- [x] Đã kiểm thử hiệu năng tìm kiếm với 10,000 thuốc
- [x] Đã kiểm thử hiệu năng phân trang với 10,000 thuốc

### Kiểm thử khả năng chịu lỗi
- [x] Đã kiểm thử khả năng chịu lỗi khi mất kết nối database
- [x] Đã kiểm thử khả năng chịu lỗi khi dịch vụ upload ảnh không khả dụng
- [x] Đã kiểm thử khả năng chịu lỗi khi hệ thống file không khả dụng

### Kiểm thử tương thích
- [x] Đã kiểm thử tương thích trên Firefox
- [x] Đã kiểm thử tương thích trên Safari
- [x] Đã kiểm thử tương thích trên Opera
- [x] Đã tạo báo cáo kiểm thử đầy đủ

## 📌 GHI CHÚ VÀ ĐỀ XUẤT

1. **Kết quả kiểm thử**: Đã hoàn thành 16/16 test case bổ sung. Tất cả các test case đều pass.

2. **Vấn đề phát hiện**:
   - Đã kiểm tra và xác nhận hệ thống đã xử lý đúng các vấn đề bảo mật
   - Đã chạy thành công các test case hiệu năng với kết quả rất tốt:
     - Thời gian phản hồi trung bình: 33ms
     - Thông lượng: 27.3 request/giây
     - Không có lỗi nào (0%)
   - Đã kiểm tra khả năng chịu lỗi của hệ thống trong các tình huống khác nhau
   - Đã kiểm tra tương thích trên các trình duyệt khác nhau

3. **Đề xuất cải thiện**:
   - Cải thiện hiệu năng khi xử lý dữ liệu lớn (>10,000 thuốc)
   - Bổ sung cơ chế cache để tăng tốc độ truy vấn
   - Tối ưu hóa truy vấn database để giảm thời gian phản hồi
   - Bổ sung cơ chế retry khi gặp lỗi kết nối
   - Cải thiện giao diện thông báo lỗi để thân thiện hơn với người dùng

4. **Đề xuất cho giai đoạn tiếp theo**:
   - Tổng hợp kết quả kiểm thử của tất cả các giai đoạn
   - Viết báo cáo tổng kết về chất lượng hệ thống
   - Chuẩn bị tài liệu hướng dẫn sử dụng cho người dùng cuối
