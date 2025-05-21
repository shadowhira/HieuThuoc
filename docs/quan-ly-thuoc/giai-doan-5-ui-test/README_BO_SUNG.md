# HƯỚNG DẪN CHẠY TESTCASE BỔ SUNG CHO GIAI ĐOẠN 5: KIỂM THỬ GIAO DIỆN

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách chạy các testcase bổ sung cho giai đoạn 5 - Kiểm thử giao diện (UI Testing) cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

## 🎯 MỤC TIÊU

Bổ sung 10 testcase cho giai đoạn 5 - Kiểm thử giao diện, bao gồm:
- Kiểm thử responsive (3 testcase)
- Kiểm thử accessibility (3 testcase)
- Kiểm thử giao diện nâng cao (4 testcase)

## 🛠️ CÔNG CỤ VÀ MÔI TRƯỜNG

- **Framework kiểm thử**: Cypress
- **Trình duyệt**: Chrome, Edge
- **IDE**: Visual Studio Code
- **Hệ điều hành**: Windows/macOS/Linux

## 📝 DANH SÁCH TESTCASE BỔ SUNG

### 1. Kiểm thử responsive (3 testcase)
- UI-18: Kiểm thử responsive trên màn hình điện thoại (width < 576px)
- UI-19: Kiểm thử responsive trên màn hình tablet (width 768px - 992px)
- UI-20: Kiểm thử responsive trên màn hình desktop lớn (width > 1200px)

### 2. Kiểm thử accessibility (3 testcase)
- UI-21: Kiểm thử accessibility với keyboard navigation
- UI-22: Kiểm thử accessibility với screen reader
- UI-23: Kiểm thử accessibility với high contrast mode

### 3. Kiểm thử giao diện nâng cao (4 testcase)
- UI-24: Kiểm thử hiển thị thông báo lỗi inline
- UI-25: Kiểm thử hiển thị tooltip khi hover
- UI-26: Kiểm thử hiển thị loading spinner khi tải dữ liệu
- UI-27: Kiểm thử hiển thị modal xác nhận khi xóa

## 📝 HƯỚNG DẪN CHẠY TESTCASE

### 1. Chuẩn bị môi trường

#### 1.1. Cài đặt Cypress (nếu chưa cài đặt)

```bash
# Di chuyển đến thư mục frontend
cd FE

# Cài đặt Cypress
npm install cypress --save-dev
```

#### 1.2. Chuẩn bị Backend và Frontend

1. Khởi động Backend:
   ```bash
   cd BE
   ./mvnw spring-boot:run
   ```
2. Khởi động Frontend:
   ```bash
   cd FE
   npm start
   ```
3. Đảm bảo Backend đang chạy tại địa chỉ: http://localhost:8888/hieuthuoc
4. Đảm bảo Frontend đang chạy tại địa chỉ: http://localhost:4200

### 2. Chạy testcase

#### 2.1. Chạy tất cả các testcase

```bash
# Di chuyển đến thư mục frontend
cd FE

# Mở Cypress Test Runner
npx cypress open
```

1. Chọn E2E Testing
2. Chọn trình duyệt (Chrome, Firefox, Electron)
3. Chọn file test `quan-ly-thuoc/run-all-ui-tests.js` để chạy tất cả các testcase

#### 2.2. Chạy từng nhóm testcase

1. Kiểm thử responsive:
   ```bash
   npx cypress run --spec "cypress/e2e/quan-ly-thuoc/responsive-ui-test.cy.js"
   ```

2. Kiểm thử accessibility:
   ```bash
   npx cypress run --spec "cypress/e2e/quan-ly-thuoc/accessibility-ui-test.cy.js"
   ```

3. Kiểm thử giao diện nâng cao:
   ```bash
   npx cypress run --spec "cypress/e2e/quan-ly-thuoc/advanced-ui-test.cy.js"
   ```

## 📊 KẾT QUẢ KIỂM THỬ

Sau khi chạy các testcase, kết quả kiểm thử sẽ được hiển thị trong Cypress Test Runner hoặc trong terminal (nếu chạy bằng lệnh `cypress run`).

Các testcase đã được thiết kế để tự động kiểm tra các điều kiện và báo cáo kết quả. Nếu có lỗi, Cypress sẽ hiển thị thông báo lỗi và chụp ảnh màn hình tại thời điểm lỗi xảy ra.

## 📝 LƯU Ý

1. Các testcase đã được thiết kế để chạy trên môi trường phát triển. Nếu chạy trên môi trường khác, có thể cần điều chỉnh URL trong file `cypress.config.js`.
2. Một số testcase có thể cần điều chỉnh selector để phù hợp với cấu trúc HTML của ứng dụng.
3. Testcase accessibility với screen reader và high contrast mode chỉ kiểm tra các thuộc tính HTML, không kiểm tra trải nghiệm người dùng thực tế.
4. Nếu gặp lỗi "Uncaught exception", có thể bỏ qua vì đã được xử lý trong testcase.

## 🚀 TỔNG KẾT

Với việc bổ sung 10 testcase mới, giai đoạn 5 - Kiểm thử giao diện đã có tổng cộng 27 testcase, bao gồm:
- 17 testcase đã có
- 10 testcase bổ sung

Các testcase này giúp đảm bảo giao diện người dùng hoạt động đúng trên các kích thước màn hình khác nhau, hỗ trợ accessibility và có trải nghiệm người dùng tốt.
