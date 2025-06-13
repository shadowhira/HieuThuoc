# BÁO CÁO ĐÁNH GIÁ KẾT QUẢ KIỂM THỬ
## Chức năng: Báo cáo thống kê doanh thu

---

### THÔNG TIN CHUNG
- **Dự án:** HieuThuoc
- **Chức năng kiểm thử:** Báo cáo thống kê doanh thu
- **Người thực hiện:** Nguyễn Văn Huân - B21DCCN404
- **Ngày thực hiện:** 12/06/2025
- **Phiên bản:** 1.0

---

## 1. TỔNG QUAN KẾT QUẢ KIỂM THỬ

### 1.1 Thống kê tổng hợp
| Loại kiểm thử | Số lượng test case | Passed | Failed | Tỷ lệ thành công |
|---------------|-------------------|--------|--------|------------------|
| **Kiểm thử đơn vị** | 17 | 17 | 0 | 100% |
| **Kiểm thử hiệu năng** | 15 | 12 | 3 | 80% |
| **Kiểm thử giao diện** | 35 | 35 | 0 | 100% |
| **Kiểm thử hộp đen** | 34 | 34 | 0 | 100% |
| **TỔNG CỘNG** | **101** | **98** | **3** | **97.03%** |

### 1.2 Phân loại theo phương pháp
- **Kiểm thử tự động:** Cypress, JUnit, Postman, JMeter
- **Kiểm thử thủ công:** UI test
- **Phân loại theo mục đích:** Kiểm thử đơn vị, hiệu năng, giao diện, hộp đen
- **Phân loại theo kỹ thuật:** Kiểm thử hộp đen, hộp trắng

---

## 2. CHI TIẾT KẾT QUẢ TỪNG LOẠI KIỂM THỬ

### 2.1 Kiểm thử đơn vị (Unit Testing)
**Tool sử dụng:** JUnit, Mockito
**Kết quả:** 17/17 test cases passed (100%)

#### Các test case chính:
- **Backend API Testing:**
  - TC-BE-BC-001: Kiểm tra phương thức trả về dữ liệu doanh thu theo ngày thành công
  - TC-BE-BC-002: Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu
  - TC-BE-BC-004: Kiểm tra phương thức trả về dữ liệu doanh thu theo tháng thành công
  - TC-BE-BC-005: Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu
  - TC-BE-BC-007: Kiểm tra phương thức trả về dữ liệu doanh thu theo năm thành công
  - TC-BE-BC-008: Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu

- **Frontend Service Testing:**
  - TC-FE-SV-001: Kiểm tra phương thức gọi API với tham số đúng
  - TC-FE-SV-002: Kiểm tra phương thức xử lý kết quả thành công
  - TC-FE-SV-003: Kiểm tra phương thức xử lý lỗi
  - TC-FE-SV-004: Kiểm tra phương thức gọi API với tham số đúng
  - TC-FE-SV-007: Kiểm tra phương thức gọi API với tham số đúng

- **Frontend Component Testing:**
  - TC-FE-COMP-001: Kiểm tra phương thức gọi service với tham số đúng
  - TC-FE-COMP-002: Kiểm tra phương thức xử lý kết quả thành công
  - TC-FE-COMP-003: Kiểm tra phương thức cập nhật biểu đồ
  - TC-FE-COMP-004: Kiểm tra phương thức gọi service với tham số đúng
  - TC-FE-COMP-007: Kiểm tra phương thức gọi service với tham số đúng
  - TC-FE-COMP-008: Kiểm tra phương thức xử lý dữ liệu rỗng

#### Đánh giá:
✅ **Điểm mạnh:**
- Tất cả các test case đều pass
- Bao phủ đầy đủ các chức năng chính: theo ngày, tháng, năm
- Kiểm tra cả trường hợp có dữ liệu và không có dữ liệu
- Test cả backend API và frontend service/component

### 2.2 Kiểm thử hiệu năng (Performance Testing)
**Tool sử dụng:** JMeter
**Kết quả:** 12/15 test cases passed (80%)

#### Các test case thành công:
- **Tải nhẹ (10 request):** 3/3 passed
  - PERF-TK-001: API doanh thu theo ngày - 245.67ms
  - PERF-TK-002: API doanh thu theo tháng - 415.67ms  
  - PERF-TK-003: API doanh thu theo năm - 689.45ms

- **Tải trung bình (50 request):** 3/3 passed
  - PERF-TK-004: API doanh thu theo ngày - 1250.34ms (98% success rate)
  - PERF-TK-005: API doanh thu theo tháng - 1850.67ms (96% success rate)
  - PERF-TK-006: API doanh thu theo năm - 2450.89ms (94% success rate)

- **Dữ liệu lớn (20 request):** 3/3 passed
  - PERF-TK-010: API doanh thu theo ngày - 1800.23ms
  - PERF-TK-011: API doanh thu theo tháng - 2200.56ms
  - PERF-TK-012: API doanh thu theo năm - 2800.89ms

- **Dữ liệu rỗng (10 request):** 3/3 passed
  - PERF-TK-013: API doanh thu theo ngày - 150.34ms
  - PERF-TK-014: API doanh thu theo tháng - 180.67ms
  - PERF-TK-015: API doanh thu theo năm - 220.12ms

#### Các test case thất bại:
- **Tải cao (100 request):** 0/3 passed
  - PERF-TK-007: API doanh thu theo ngày - 3500.12ms (85% success rate) - **FAILED**
  - PERF-TK-008: API doanh thu theo tháng - 4200.45ms (82% success rate) - **FAILED**
  - PERF-TK-009: API doanh thu theo năm - 4800.78ms (78% success rate) - **FAILED**

#### Đánh giá:
✅ **Điểm mạnh:**
- Hiệu năng tốt với tải nhẹ và trung bình
- Xử lý tốt với dữ liệu rỗng (thời gian phản hồi nhanh)
- Tỷ lệ thành công cao với tải trung bình

❌ **Vấn đề cần cải thiện:**
- Không đáp ứng được tải cao (100 request đồng thời)
- Tỷ lệ thành công giảm đáng kể khi tăng tải
- Có lỗi timeout và connection error ở tải cao

### 2.3 Kiểm thử giao diện (UI Testing)
**Tool sử dụng:** Cypress
**Kết quả:** 35/35 test cases passed (100%)

#### Các nhóm test case chính:

**1. Hiển thị tổng quan (UI-01 đến UI-03):**
- Kiểm tra hiển thị 3 ô tổng quan: Hóa đơn, Đơn hàng trả lại, Doanh thu
- Kiểm tra hiển thị biểu đồ doanh thu
- Kiểm tra hiển thị các tab lọc và dropdown

**2. Chức năng lọc (UI-03 đến UI-05):**
- Chuyển đổi giữa các tab thời gian (ngày/tháng/năm)
- Bộ lọc tháng và năm hoạt động đúng
- Hiển thị đúng số ngày trong các tháng khác nhau

**3. Biểu đồ (UI-06 đến UI-08):**
- Hiển thị biểu đồ theo ngày (theo giờ)
- Hiển thị biểu đồ theo tháng (theo ngày)
- Hiển thị biểu đồ theo năm (theo tháng)
- Tooltip hoạt động đúng

**4. Xử lý dữ liệu (UI-09, UI-13, UI-14):**
- Hiển thị đúng khi không có dữ liệu
- Xử lý tốt với dữ liệu lớn
- Xử lý tốt với dữ liệu có giá trị chênh lệch lớn

**5. Responsive và tương thích (UI-10, UI-17):**
- Giao diện responsive trên desktop, tablet, mobile
- Tương thích với các trình duyệt khác nhau

**6. Edge cases (UI-20 đến UI-25):**
- Xử lý dữ liệu âm
- Xử lý ngày trong tương lai
- Xử lý ngày không hợp lệ
- Xử lý khi mất kết nối internet

#### Đánh giá:
✅ **Điểm mạnh:**
- Tất cả test case đều pass
- Giao diện responsive và tương thích đa trình duyệt
- Xử lý tốt các trường hợp edge case
- Biểu đồ hiển thị chính xác và có tương tác tốt

### 2.4 Kiểm thử hộp đen (Black Box Testing)
**Tool sử dụng:** JUnit
**Kết quả:** 34/34 test cases passed (100%)

#### Các nhóm test case chính:

**1. Giao diện tổng quan (TC-TK-UI-01 đến TC-TK-UI-03):**
- Kiểm tra hiển thị các thành phần chính
- Kiểm tra số liệu tổng quan
- Kiểm tra biểu tượng

**2. Bộ lọc thời gian (TC-TK-FILTER-01 đến TC-TK-FILTER-05):**
- Chuyển đổi giữa các tab
- Bộ lọc ngày, tháng, năm
- Xử lý năm nhuận và không nhuận

**3. Biểu đồ (TC-TK-CHART-01 đến TC-TK-CHART-05):**
- Hiển thị biểu đồ theo các loại thời gian
- Tương tác với biểu đồ
- Cập nhật biểu đồ khi thay đổi bộ lọc

**4. Dữ liệu (TC-TK-DATA-01 đến TC-TK-DATA-03):**
- Tính chính xác của dữ liệu tổng quan
- Tính chính xác của dữ liệu biểu đồ
- Tính nhất quán giữa các loại báo cáo

**5. Edge cases (TC-TK-EDGE-01 đến TC-TK-EDGE-05):**
- Xử lý khi không có dữ liệu
- Xử lý với dữ liệu lớn
- Xử lý với dữ liệu chênh lệch lớn
- Xử lý khi API trả về lỗi
- Xử lý ngày trong tương lai

**6. Responsive và tương thích (TC-TK-RESP-01 đến TC-TK-COMP-03):**
- Responsive trên các thiết bị khác nhau
- Tương thích với các trình duyệt
- Kiểm tra hiệu năng

#### Đánh giá:
✅ **Điểm mạnh:**
- Tất cả test case đều pass
- Bao phủ đầy đủ các chức năng
- Kiểm tra kỹ lưỡng các trường hợp edge case
- Đảm bảo tính nhất quán của dữ liệu

---

## 3. CODE REVIEW VÀ GUI REVIEW

### 3.1 Code Review
**Kết quả:** Đạt (với một số đề xuất cải thiện)

#### Điểm mạnh:
- Code có cấu trúc rõ ràng và dễ đọc
- Tuân thủ chuẩn Java và TypeScript
- Tên biến, method, class có ý nghĩa rõ ràng
- Spring tự động quản lý memory và connection

#### Vấn đề cần cải thiện:
- Thiếu header và thông tin bản quyền
- Thiếu JavaDoc và comment cho nhiều method
- Thiếu try-catch và error handling trong controller
- Thiếu validation cho input parameters
- Query có thể chậm với dữ liệu lớn
- ThongKeComponent quá dài (525 lines)

#### Đề xuất:
1. Cải thiện error handling: Thêm try-catch và exception handling
2. Thêm validation: Kiểm tra input parameters
3. Tối ưu performance: Thêm index cho database, implement pagination
4. Refactor code: Tách ThongKeComponent thành các component nhỏ hơn
5. Thêm documentation: JavaDoc cho methods và classes
6. Thêm unit tests: Kiểm thử cho các business logic quan trọng

### 3.2 GUI Review
**Kết quả:** 32 OK, 7 NG, 10 N/A

#### Điểm mạnh:
- Chính tả và định vị nhãn đúng
- Màu font chữ và độ tương phản tốt
- Kiểu chữ và kích cỡ chữ nhất quán
- Tông màu tương thích xuyên suốt
- Giao diện đồ họa phù hợp với mục đích
- Thanh điều hướng hoạt động đúng

#### Vấn đề cần cải thiện:
- Biểu tượng lịch không có tooltip khi hover
- Không có phím tắt cho các biểu tượng
- Không thể sử dụng bàn phím để tương tác với biểu đồ
- Con trỏ không được đặt tự động vào ô chọn ngày khi tải lại màn hình
- Khi click vào ô chọn ngày dữ liệu không được chọn tự động

---

## 4. ĐÁNH GIÁ TỔNG THỂ

### 4.1 Điểm mạnh của hệ thống
1. **Chức năng hoạt động ổn định:** 97.03% test cases passed
2. **Giao diện người dùng tốt:** 100% UI test cases passed
3. **Kiểm thử đơn vị toàn diện:** 100% unit test cases passed
4. **Xử lý tốt các trường hợp edge case**
5. **Giao diện responsive và tương thích đa trình duyệt**
6. **Biểu đồ hiển thị chính xác và có tương tác tốt**

### 4.2 Vấn đề cần cải thiện
1. **Hiệu năng dưới tải cao:** Không đáp ứng được 100 request đồng thời
2. **Thiếu error handling:** Cần cải thiện xử lý lỗi trong controller
3. **Thiếu validation:** Cần kiểm tra input parameters
4. **Code documentation:** Cần thêm JavaDoc và comment
5. **Accessibility:** Cần cải thiện khả năng truy cập bằng bàn phím
6. **Performance optimization:** Cần tối ưu database query

### 4.3 Khuyến nghị
1. **Ưu tiên cao:**
   - Cải thiện error handling và validation
   - Tối ưu hiệu năng cho tải cao
   - Thêm index cho database

2. **Ưu tiên trung bình:**
   - Refactor code để tách component lớn
   - Thêm documentation
   - Cải thiện accessibility

3. **Ưu tiên thấp:**
   - Thêm tooltip cho biểu tượng
   - Cải thiện UX cho con trỏ tự động

---

## 5. KẾT LUẬN

Hệ thống báo cáo thống kê doanh thu đã được kiểm thử toàn diện với tỷ lệ thành công 97.03%. Các chức năng chính hoạt động ổn định, giao diện người dùng thân thiện và responsive. Tuy nhiên, cần cải thiện hiệu năng dưới tải cao và một số vấn đề về code quality để đảm bảo hệ thống hoạt động tốt trong môi trường production.

**Đánh giá tổng thể: TỐT** - Hệ thống sẵn sàng cho việc triển khai với một số cải thiện nhỏ.

---

*Báo cáo được tạo bởi: Nguyễn Văn Huân - B21DCCN404*  
*Ngày: 12/06/2025* 