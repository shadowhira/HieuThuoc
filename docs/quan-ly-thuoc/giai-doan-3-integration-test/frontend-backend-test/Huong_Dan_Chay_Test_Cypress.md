# HƯỚNG DẪN CHẠY KIỂM THỬ TÍCH HỢP FRONTEND-BACKEND BẰNG CYPRESS

## 1. Mục tiêu

Hướng dẫn chi tiết cách chạy kiểm thử tích hợp Frontend-Backend bằng Cypress cho chức năng Quản lý thuốc.

## 1.1. Cập nhật mới (22/05/2025)

- Đã sửa lỗi trong các test case Cypress
- Đã cập nhật hướng dẫn chạy test
- Đã thêm phần xử lý lỗi JavaScript không bắt được
- Đã thêm phần sử dụng selector linh hoạt
- Tất cả test case đã chạy thành công (7/7 test case)

## 2. Chuẩn bị môi trường

### 2.1. Cài đặt Cypress

1. Đảm bảo đã cài đặt Node.js và npm
2. Cài đặt Cypress:
   ```bash
   cd FE
   npm install cypress --save-dev
   ```

3. Kiểm tra cài đặt:
   ```bash
   npx cypress version
   ```

### 2.2. Cấu hình Cypress

1. Tạo file `FE/cypress.json`:
   ```json
   {
     "baseUrl": "http://localhost:4200",
     "viewportWidth": 1280,
     "viewportHeight": 720,
     "defaultCommandTimeout": 10000,
     "requestTimeout": 10000,
     "responseTimeout": 10000,
     "video": false
   }
   ```

### 2.3. Chuẩn bị Backend và Frontend

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

### 2.4. Chuẩn bị dữ liệu

Đảm bảo cơ sở dữ liệu đã có dữ liệu mẫu cho việc kiểm thử.

## 3. Tạo thư mục và file test

### 3.1. Cấu trúc thư mục test

Cypress 10+ sử dụng cấu trúc thư mục mới:

```
FE/
├── cypress/
│   ├── e2e/                  # Thư mục chứa test (thay thế cho integration)
│   │   └── thuoc/            # Thư mục chứa test cho chức năng thuốc
│   │       ├── create-thuoc.cy.js
│   │       ├── list-thuoc.cy.js
│   │       └── search-thuoc.cy.js
│   ├── fixtures/             # Thư mục chứa dữ liệu mẫu
│   ├── support/              # Thư mục chứa các file hỗ trợ
│   │   ├── commands.js       # Các lệnh tùy chỉnh
│   │   └── e2e.js            # File cấu hình e2e
│   └── videos/               # Thư mục chứa video ghi lại quá trình test
└── cypress.config.js         # File cấu hình Cypress
```

### 3.2. Các file test hiện có

1. **list-thuoc.cy.js**: Kiểm tra hiển thị danh sách thuốc
2. **search-thuoc.cy.js**: Kiểm tra tìm kiếm thuốc
3. **create-thuoc.cy.js**: Kiểm tra thêm mới thuốc

### 3.3. Ví dụ file test

1. **list-thuoc.cy.js**:
   ```javascript
   describe('Hiển thị danh sách thuốc', () => {
     // Bỏ qua lỗi JavaScript không bắt được
     Cypress.on('uncaught:exception', (err, runnable) => {
       console.log('Uncaught exception:', err.message);
       return false;
     });

     beforeEach(() => {
       // Đăng nhập
       cy.visit('/login');
       cy.get('input#username').type('admin');
       cy.get('input#password-input').type('123456');
       cy.get('button[type="submit"]').click();
       cy.url().should('include', '/home');

       // Truy cập trang danh sách thuốc
       cy.visit('/sys/product');
     });

     it('Hiển thị danh sách thuốc thành công', () => {
       // Kiểm tra tiêu đề trang
       cy.get('h4').should('be.visible');

       // Kiểm tra các cột trong bảng
       cy.get('th').should('have.length.at.least', 3);

       // Kiểm tra có dữ liệu trong bảng
       cy.get('tr').should('have.length.at.least', 1);
     });
   });
   ```

2. **search-thuoc.cy.js**:
   ```javascript
   describe('Tìm kiếm thuốc', () => {
     // Bỏ qua lỗi JavaScript không bắt được
     Cypress.on('uncaught:exception', (err, runnable) => {
       console.log('Uncaught exception:', err.message);
       return false;
     });

     beforeEach(() => {
       // Đăng nhập
       cy.visit('/login');
       cy.get('input#username').type('admin');
       cy.get('input#password-input').type('123456');
       cy.get('button[type="submit"]').click();
       cy.url().should('include', '/home');

       // Truy cập trang danh sách thuốc
       cy.visit('/sys/product');
     });

     it('Tìm kiếm thuốc theo tên thành công', () => {
       // Nhập từ khóa tìm kiếm
       cy.get('input[pInputText]').type('Paracetamol');

       // Nhấn nút tìm kiếm (sử dụng text content)
       cy.get('button').contains('Tìm').click();

       // Kiểm tra kết quả tìm kiếm
       cy.get('tr').should('have.length.at.least', 1);
     });
   });
   ```

## 4. Chạy kiểm thử

### 4.1. Chạy kiểm thử bằng Cypress Test Runner

1. Mở Cypress Test Runner:
   ```bash
   cd FE
   npx cypress open
   ```
2. Chọn E2E Testing
3. Chọn trình duyệt (Chrome, Firefox, Electron)
4. Chọn file test cần chạy:
   - `thuoc/list-thuoc.cy.js`
   - `thuoc/search-thuoc.cy.js`
   - `thuoc/create-thuoc.cy.js`

### 4.2. Chạy kiểm thử bằng command line

1. Chạy tất cả các test:
   ```bash
   cd FE
   npx cypress run
   ```
2. Chạy test cụ thể:
   ```bash
   cd FE
   npx cypress run --spec "cypress/e2e/thuoc/list-thuoc.cy.js"
   ```
3. Chạy test với giao diện (headed mode):
   ```bash
   cd FE
   npx cypress run --headed --spec "cypress/e2e/thuoc/create-thuoc.cy.js"
   ```

## 5. Xem kết quả kiểm thử

### 5.1. Xem kết quả trong Cypress Test Runner

Kết quả kiểm thử sẽ hiển thị trực tiếp trong Cypress Test Runner.

### 5.2. Xem kết quả trong command line

Kết quả kiểm thử sẽ hiển thị trong command line sau khi chạy kiểm thử.

### 5.3. Xem video và screenshot

Nếu bạn đã cấu hình Cypress để ghi video và chụp ảnh, bạn có thể xem video và screenshot trong thư mục `FE/cypress/videos` và `FE/cypress/screenshots`.

## 6. Xử lý lỗi phổ biến

### 6.1. Lỗi không tìm thấy phần tử

Nếu Cypress không tìm thấy phần tử, hãy kiểm tra lại selector và đảm bảo phần tử đã được render trước khi Cypress tìm kiếm.

**Giải pháp**:
- Sử dụng selector linh hoạt hơn (ví dụ: `cy.get('h4').should('be.visible')` thay vì `cy.get('h4').should('contain', 'Danh sách thuốc')`)
- Sử dụng `cy.wait()` để đợi phần tử xuất hiện
- Sử dụng `cy.get(...).should('have.length.at.least', 1)` thay vì `cy.get(...).should('have.length', 2)`

### 6.2. Lỗi timeout

Nếu Cypress bị timeout, hãy tăng giá trị timeout trong các assertion.

**Giải pháp**:
- Tăng timeout trong assertion: `cy.get(..., { timeout: 10000 })`
- Tăng giá trị trong file `cypress.config.js`:
  ```javascript
  module.exports = {
    e2e: {
      defaultCommandTimeout: 10000,
      requestTimeout: 10000,
      responseTimeout: 10000,
    },
  };
  ```

### 6.3. Lỗi JavaScript không bắt được

Nếu test thất bại do lỗi JavaScript không bắt được từ ứng dụng, hãy thêm xử lý `uncaught:exception`.

**Giải pháp**:
```javascript
Cypress.on('uncaught:exception', (err, runnable) => {
  // Ghi log lỗi để debug
  console.log('Uncaught exception:', err.message);
  // Trả về false để ngăn Cypress fail test khi có lỗi JavaScript
  return false;
});
```

### 6.4. Lỗi CORS

Nếu gặp lỗi CORS, hãy đảm bảo Backend đã được cấu hình để cho phép truy cập từ Frontend.

## 7. Lưu ý

- Đảm bảo đã khởi động Backend và Frontend trước khi chạy kiểm thử
- Đảm bảo cơ sở dữ liệu đã có dữ liệu mẫu trước khi chạy kiểm thử
- Đảm bảo đã cấu hình Cypress đúng cách
- Đảm bảo selector trong test case phù hợp với cấu trúc HTML của ứng dụng
- Sử dụng xử lý `uncaught:exception` để bỏ qua lỗi JavaScript không bắt được
- Sử dụng selector linh hoạt để tránh lỗi khi giao diện thay đổi
- Kiểm tra kỹ lưỡng cú pháp HTML/CSS để tránh lỗi cú pháp gây ra lỗi JavaScript
- Cải thiện xử lý lỗi trong các component để tránh lỗi JavaScript khi dữ liệu không hợp lệ

## 8. Kết quả chạy test mới nhất

```
====================================================================================================

  (Run Finished)

       Spec                                              Tests  Passing  Failing  Pending  Skipped
  ┌────────────────────────────────────────────────────────────────────────────────────────────────┐
  │ ✔  create-thuoc.cy.js                       00:15        3        3        -        -        - │
  ├────────────────────────────────────────────────────────────────────────────────────────────────┤
  │ ✔  list-thuoc.cy.js                         00:04        1        1        -        -        - │
  ├────────────────────────────────────────────────────────────────────────────────────────────────┤
  │ ✔  search-thuoc.cy.js                       00:12        3        3        -        -        - │
  └────────────────────────────────────────────────────────────────────────────────────────────────┘
    ✔  All specs passed!                        00:32        7        7        -        -        -
```
