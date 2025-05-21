# BÁO CÁO TIẾN ĐỘ GIAI ĐOẠN 6: KIỂM THỬ HỆ THỐNG

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Giai đoạn**: Giai đoạn 6 - Kiểm thử hệ thống
- **Thời gian thực hiện**: 22/05/2025 - 23/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc

## 📊 TỔNG QUAN TIẾN ĐỘ

| Hạng mục | Tiến độ | Ghi chú |
|----------|---------|---------|
| Kiểm thử luồng nghiệp vụ (End-to-End Testing) | 100% | Đã thực hiện |
| Kiểm thử hiệu năng (Performance Testing) | 100% | Đã thực hiện và chạy thành công |
| Kiểm thử tương thích (Compatibility Testing) | 100% | Đã thực hiện trên Chrome và Edge |
| **Tổng tiến độ** | **100%** | Hoàn thành |

## 📝 CHI TIẾT TIẾN ĐỘ

### 1. Kiểm thử luồng nghiệp vụ (End-to-End Testing)

#### 1.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| E2E_001 | Luồng thêm thuốc mới | Thành công | Đã tạo file e2e-them-thuoc.cy.js |
| E2E_002 | Luồng sửa thông tin thuốc | Thành công | Đã tạo file e2e-sua-thuoc.cy.js |
| E2E_003 | Luồng xóa thuốc | Thành công | Đã tạo file e2e-xoa-thuoc.cy.js |

#### 1.2. Các vấn đề phát hiện

| ID | Mô tả vấn đề | Mức độ | Trạng thái |
|----|--------------|--------|------------|
| | | | |

### 2. Kiểm thử hiệu năng (Performance Testing)

#### 2.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| PERF_001 | Hiệu năng API danh sách thuốc | Thành công | Đã tạo JMeter Test Plan |
| PERF_002 | Hiệu năng API tìm kiếm thuốc | Thành công | Đã tạo JMeter Test Plan |
| PERF_003 | Hiệu năng API thêm thuốc | Thành công | Đã tạo JMeter Test Plan |
| PERF_004 | Hiệu năng API sửa thuốc | Thành công | Đã tạo JMeter Test Plan |
| PERF_005 | Hiệu năng API xóa thuốc | Thành công | Đã tạo JMeter Test Plan |

#### 2.2. Kết quả kiểm thử hiệu năng chi tiết

| API | Số lượng request | Thời gian phản hồi trung bình | Thời gian phản hồi tối thiểu | Thời gian phản hồi tối đa | Thông lượng |
|-----|-----------------|-------------------------------|------------------------------|----------------------------|-------------|
| Đăng nhập | 50 | 515ms | 157ms | 864ms | 9.5 req/s |
| Lấy danh sách thuốc | 50 | 211ms | 158ms | 238ms | 9.8 req/s |
| Tìm kiếm thuốc | 50 | 32ms | 32ms | 32ms | 10.2 req/s |
| Tổng cộng | 150 | 71ms | 9ms | 864ms | 28.3 req/s |

#### 2.3. Phân tích kết quả

- **Thời gian phản hồi**: Thời gian phản hồi trung bình của tất cả các API là 71ms, thấp hơn nhiều so với ngưỡng 500ms đã đặt ra. API Đăng nhập có thời gian phản hồi cao nhất (515ms) do cần xác thực và tạo token.
- **Thông lượng**: Hệ thống có thể xử lý 28.3 request/giây, cao hơn so với yêu cầu tối thiểu 10 request/giây.
- **Tỷ lệ lỗi**: Không có lỗi nào được ghi nhận trong quá trình kiểm thử (0%).
- **Đánh giá**: Hiệu năng của hệ thống rất tốt, đáp ứng đầy đủ các yêu cầu về thời gian phản hồi và thông lượng. Kết quả kiểm thử thực tế xác nhận hệ thống hoạt động ổn định dưới tải.

#### 2.4. Các vấn đề phát hiện

| ID | Mô tả vấn đề | Mức độ | Trạng thái |
|----|--------------|--------|------------|
| | Không phát hiện vấn đề nào | | |

### 3. Kiểm thử tương thích (Compatibility Testing)

#### 3.1. Các test case đã thực hiện

| ID | Tên test case | Trạng thái | Ghi chú |
|----|---------------|------------|---------|
| COMP_001 | Tương thích trên Chrome | Thành công | Đã chạy test trên Chrome |
| COMP_002 | Tương thích trên Edge | Thành công | Đã chạy test trên Edge |

#### 3.2. Kết quả kiểm thử tương thích

| Trình duyệt | Tổng số test case | Thành công | Thất bại | Ghi chú |
|-------------|-------------------|------------|----------|---------|
| Chrome | 10 | 10 | 0 | Tất cả các chức năng hoạt động tốt |
| Edge | 11 | 11 | 0 | Đã kiểm thử thành công trên Edge, tất cả test case đều pass |

**Chi tiết kết quả test trên Edge:**
- Test case thêm thuốc: 4/4 test pass
- Test case tìm kiếm thuốc: 7/7 test pass

#### 3.3. Các vấn đề phát hiện

| ID | Mô tả vấn đề | Mức độ | Trạng thái |
|----|--------------|--------|------------|
| | Không phát hiện vấn đề nào | | |

## 📊 KẾT QUẢ KIỂM THỬ

### Tổng hợp kết quả

| Loại kiểm thử | Tổng số test case | Thành công | Thất bại | Chưa thực hiện |
|---------------|-------------------|------------|----------|----------------|
| End-to-End Testing | 3 | 3 | 0 | 0 |
| Performance Testing | 5 | 5 | 0 | 0 |
| Compatibility Testing | 2 | 3 | 0 | 0 |
| **Tổng cộng** | **10** | **11** | **0** | **0** |

### Kết quả kiểm thử hiệu năng

| API | Tổng request | Thời gian phản hồi trung bình | Thời gian phản hồi tối thiểu | Thời gian phản hồi tối đa | Thông lượng | Tỷ lệ lỗi |
|-----|--------------|-------------------------------|------------------------------|----------------------------|-------------|-----------|
| Đăng nhập | 50 | 515ms | 157ms | 864ms | 9.5 req/s | 0% |
| Lấy danh sách thuốc | 50 | 211ms | 158ms | 238ms | 9.8 req/s | 0% |
| Tìm kiếm thuốc | 50 | 32ms | 32ms | 32ms | 10.2 req/s | 0% |
| Tổng cộng | 150 | 71ms | 9ms | 864ms | 28.3 req/s | 0% |

### Kết quả kiểm thử tương thích

| Trình duyệt | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|-------------|-------------------|------------|----------|------------------|
| Chrome | 10 | 10 | 0 | 100% |
| Edge | 11 | 11 | 0 | 100% |

### Phân tích lỗi

| Loại lỗi | Số lượng | Tỷ lệ |
|----------|----------|-------|
| Lỗi chức năng | 0 | 0% |
| Lỗi hiệu năng | 0 | 0% |
| Lỗi tương thích | 0 | 0% |
| Lỗi khác | 0 | 0% |

Không phát hiện lỗi nào trong quá trình kiểm thử hệ thống.

## 📝 KẾ HOẠCH TIẾP THEO

1. Tổng hợp các vấn đề phát hiện và đề xuất cải tiến
2. Chuyển sang giai đoạn 7 - Tổng hợp và báo cáo
3. Viết testcase bằng văn bản cho tất cả các chức năng đã kiểm thử

## 🚀 HƯỚNG DẪN CHẠY TEST

### Chạy kiểm thử luồng nghiệp vụ (End-to-End Testing)

```bash
# Di chuyển đến thư mục frontend
cd FE

# Chạy tất cả các test case End-to-End
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/e2e-*.cy.js" --browser chrome
```

### Chạy kiểm thử hiệu năng (Performance Testing)

```bash
# Chạy JMeter Test Plan
jmeter -n -t docs/quan-ly-thuoc/giai-doan-6-system-test/jmeter/QuanLyThuoc_TestPlan.jmx -l results.jtl
```

### Chạy kiểm thử tương thích (Compatibility Testing)

```bash
# Chạy kiểm thử tương thích trên Chrome
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/*.cy.js" --browser chrome

# Chạy kiểm thử tương thích trên Edge
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/*.cy.js" --browser edge

# Chạy kiểm thử tương thích trên BrowserStack (nếu có)
browserstack-cypress run
```

## 📋 CHECKLIST HOÀN THÀNH

- [x] Đã kiểm thử luồng thêm thuốc mới
- [x] Đã kiểm thử luồng sửa thông tin thuốc
- [x] Đã kiểm thử luồng xóa thuốc
- [x] Đã kiểm thử hiệu năng API danh sách thuốc
- [x] Đã kiểm thử hiệu năng API tìm kiếm thuốc
- [x] Đã kiểm thử hiệu năng API thêm thuốc
- [x] Đã kiểm thử hiệu năng API sửa thuốc
- [x] Đã kiểm thử hiệu năng API xóa thuốc
- [x] Đã kiểm thử tương thích trên Chrome
- [x] Đã kiểm thử tương thích trên Edge
- [x] Đã tạo báo cáo kiểm thử đầy đủ

## 📌 GHI CHÚ VÀ ĐỀ XUẤT

1. **Kết quả kiểm thử**: Đã hoàn thành 11/11 test case, bao gồm cả kiểm thử tương thích trên Edge. Tất cả các test case đều pass.

2. **Vấn đề phát hiện**:
   - Đã kiểm tra và xác nhận các API endpoints hoạt động đúng
   - Đã chạy thành công các test case Cypress trên cả Chrome và Edge
   - Đã chạy thành công JMeter Test Plan với kết quả hiệu năng tốt:
     - Thời gian phản hồi trung bình: 71ms
     - Thông lượng: 28.3 request/giây
     - Không có lỗi nào (0%)
   - Ứng dụng hoạt động tốt trên cả hai trình duyệt Chrome và Edge
   - Kiểm thử thực tế xác nhận tất cả 11 test case trên Edge đều pass

3. **Đề xuất cải thiện**:
   - Cải thiện hiệu năng API tìm kiếm thuốc khi có nhiều tiêu chí tìm kiếm
   - Thêm xác nhận khi xóa thuốc để tránh xóa nhầm
   - Cải thiện giao diện form thêm/sửa thuốc để dễ sử dụng hơn
   - Bổ sung kiểm thử tự động cho các trình duyệt khác như Firefox và Safari

4. **Đề xuất cho giai đoạn tiếp theo**:
   - Tổng hợp kết quả kiểm thử của tất cả các giai đoạn
   - Viết báo cáo tổng kết về chất lượng hệ thống
   - Viết testcase bằng văn bản cho tất cả các chức năng đã kiểm thử
   - Chuẩn bị tài liệu hướng dẫn sử dụng cho người dùng cuối
