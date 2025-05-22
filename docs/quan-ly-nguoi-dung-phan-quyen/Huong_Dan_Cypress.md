# Hướng dẫn sử dụng Cypress để tự động hóa kiểm thử chức năng đăng ký

## 1. Cài đặt Cypress

### 1.1. Cài đặt Node.js và npm
- Tải và cài đặt Node.js từ trang chủ: https://nodejs.org/
- Kiểm tra cài đặt thành công bằng lệnh:
  ```
  node -v
  npm -v
  ```

### 1.2. Cài đặt Cypress
- Mở terminal tại thư mục gốc của dự án (E:\SQA\HieuThuoc)
- Chạy lệnh sau để cài đặt Cypress:
  ```
  npm install cypress --save-dev
  ```

## 2. Cấu trúc thư mục Cypress

```
E:\SQA\HieuThuoc\
  ├── cypress/
  │   ├── e2e/
  │   │   └── dang-ky.cy.js     # File test case đăng ký
  │   ├── fixtures/             # Dữ liệu test
  │   ├── support/
  │   │   ├── commands.js       # Custom commands
  │   │   └── e2e.js            # Support file
  │   └── videos/               # Video ghi lại quá trình test
  ├── cypress.config.js         # File cấu hình Cypress
  └── ...
```

## 3. Chạy Cypress

### 3.1. Chạy Cypress Test Runner
- Mở terminal tại thư mục gốc của dự án (E:\SQA\HieuThuoc)
- Chạy lệnh sau để mở Cypress Test Runner:
  ```
  npx cypress open
  ```
- Chọn "E2E Testing"
- Chọn trình duyệt (Chrome, Firefox, Edge...)
- Chọn file test "dang-ky.cy.js" để chạy

### 3.2. Chạy Cypress từ command line
- Mở terminal tại thư mục gốc của dự án (E:\SQA\HieuThuoc)
- Chạy lệnh sau để chạy tất cả test case:
  ```
  npx cypress run
  ```
- Chạy lệnh sau để chạy test case cụ thể:
  ```
  npx cypress run --spec "cypress/e2e/dang-ky.cy.js"
  ```

## 4. Cập nhật kết quả vào file kiểm thử

### 4.1. Xem kết quả test
- Sau khi chạy test, Cypress sẽ hiển thị kết quả trên giao diện Test Runner
- Các test case pass sẽ hiển thị màu xanh, fail sẽ hiển thị màu đỏ
- Cypress cũng tạo ra video ghi lại quá trình test trong thư mục `cypress/videos/`

### 4.2. Cập nhật kết quả vào file kiểm thử
- Mở file `E:\SQA\HieuThuoc\docs\quan-ly-nguoi-dung-phan-quyen\Kiểm thử đăng ký.csv`
- Cập nhật cột "Current Output" với kết quả thực tế từ Cypress
- Cập nhật cột "Test Results" với "Passed" hoặc "Failed" tương ứng
- Thêm ghi chú vào cột "Notes" nếu cần

### 4.3. Ví dụ cập nhật kết quả

Ví dụ cho test case QLND_DK_001:

| ID | Summary | Steps | Expected Output | Current Output | Test Results | Notes |
|----|---------|-------|----------------|---------------|--------------|-------|
| QLND_DK_001 | Kiểm tra giao diện mặc định của màn hình "Đăng ký" | 1. Di chuyển đến màn hình "Đăng ký"<br>2. Kiểm tra giao diện mặc định của màn hình | - Hiển thị tiêu đề "Đăng ký"<br>- Hiển thị các trường nhập liệu: Họ tên, Email, Số điện thoại, Tên đăng nhập, Mật khẩu, Nhập lại mật khẩu<br>- Hiển thị button đăng ký<br>- Hiển thị link đến trang đăng nhập | - Hiển thị tiêu đề "Đăng ký"<br>- Hiển thị đầy đủ các trường nhập liệu<br>- Hiển thị button đăng ký<br>- Hiển thị link đến trang đăng nhập | Passed | |

## 5. Mở rộng test case

### 5.1. Thêm test case mới
- Mở file `cypress/e2e/dang-ky.cy.js`
- Thêm test case mới vào phần tương ứng
- Ví dụ:
  ```javascript
  it('QLND_DK_xxx - Mô tả test case', () => {
    // Code test case
  });
  ```

### 5.2. Thêm custom commands
- Mở file `cypress/support/commands.js`
- Thêm custom commands để tái sử dụng code
- Ví dụ:
  ```javascript
  Cypress.Commands.add('fillRegistrationForm', (userData) => {
    cy.get('input[name="hoTen"]').type(userData.hoTen);
    cy.get('input[name="email"]').type(userData.email);
    cy.get('input[name="soDienThoai"]').type(userData.soDienThoai);
    cy.get('input[name="tenDangNhap"]').type(userData.tenDangNhap);
    cy.get('input[name="matKhau"]').type(userData.matKhau);
    cy.get('input[name="nhapLaiMatKhau"]').type(userData.matKhau);
  });
  ```

## 6. Xử lý lỗi phổ biến

### 6.1. Element không tìm thấy
- Kiểm tra selector có chính xác không
- Tăng timeout cho command:
  ```javascript
  cy.get('selector', { timeout: 10000 })
  ```
- Sử dụng `cy.contains()` thay vì `cy.get()` nếu cần

### 6.2. Lỗi CORS
- Thêm cấu hình sau vào file `cypress.config.js`:
  ```javascript
  chromeWebSecurity: false
  ```

### 6.3. Lỗi không xử lý (Uncaught exceptions)
- Đã được xử lý trong file `cypress/support/e2e.js`
- Nếu cần xử lý thêm, thêm code sau:
  ```javascript
  Cypress.on('uncaught:exception', (err, runnable) => {
    console.log(err);
    return false;
  });
  ```
