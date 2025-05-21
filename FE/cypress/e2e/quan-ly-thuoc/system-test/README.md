# HƯỚNG DẪN KIỂM THỬ HỆ THỐNG TRÊN EDGE

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách chạy kiểm thử hệ thống trên trình duyệt Microsoft Edge cho chức năng Quản lý thuốc.

## 🛠️ YÊU CẦU

1. Đã cài đặt Microsoft Edge trên máy tính
2. Đã cài đặt Node.js và npm
3. Đã cài đặt Cypress

## 🚀 HƯỚNG DẪN CHẠY TEST

### 1. Chuẩn bị môi trường

1. Đảm bảo Backend đang chạy:
```bash
cd BE
./mvnw spring-boot:run
```

2. Đảm bảo Frontend đang chạy:
```bash
cd FE
npm start
```

### 2. Chạy test trên Edge

#### Cách 1: Sử dụng script tự động

```bash
cd FE/cypress/e2e/quan-ly-thuoc/system-test
chmod +x run-edge-tests.sh
./run-edge-tests.sh
```

#### Cách 2: Chạy lệnh Cypress trực tiếp

```bash
# Di chuyển đến thư mục gốc của dự án
cd FE

# Chạy tất cả các test case End-to-End trên Edge
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/e2e-*.cy.js" --browser edge

# Chạy tất cả các test case UI trên Edge
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/*-ui-test.cy.js" --browser edge
```

#### Cách 3: Sử dụng Cypress Test Runner

```bash
# Di chuyển đến thư mục gốc của dự án
cd FE

# Mở Cypress Test Runner
npx cypress open --config-file cypress/e2e/quan-ly-thuoc/system-test/edge-config.js
```

Sau khi Cypress Test Runner mở, chọn "E2E Testing", sau đó chọn trình duyệt Edge và chọn các test case để chạy.

## 📊 KẾT QUẢ KIỂM THỬ

Sau khi chạy test, kết quả sẽ được hiển thị trong terminal hoặc Cypress Test Runner. Các báo cáo chi tiết và ảnh chụp màn hình (nếu có) sẽ được lưu trong thư mục `cypress/screenshots` và `cypress/videos`.

## 🔍 XỬ LÝ SỰ CỐ

1. **Lỗi không tìm thấy trình duyệt Edge**:
   - Đảm bảo đã cài đặt Microsoft Edge
   - Kiểm tra đường dẫn đến Edge trong cấu hình Cypress

2. **Lỗi kết nối đến ứng dụng**:
   - Đảm bảo Backend và Frontend đang chạy
   - Kiểm tra URL cấu hình trong `cypress.config.js`

3. **Test case thất bại**:
   - Kiểm tra ảnh chụp màn hình và video trong thư mục `cypress/screenshots` và `cypress/videos`
   - Kiểm tra lỗi trong terminal hoặc Cypress Test Runner
