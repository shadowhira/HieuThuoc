# HƯỚNG DẪN CHẠY KIỂM THỬ TÍCH HỢP FRONTEND-BACKEND BẰNG CYPRESS

## 1. Mục tiêu

Hướng dẫn chi tiết cách chạy kiểm thử tích hợp Frontend-Backend bằng Cypress cho chức năng Quản lý thuốc.

## 2. Chuẩn bị môi trường

### 2.1. Cài đặt Cypress

1. Đảm bảo đã cài đặt Node.js và npm
2. Cài đặt Cypress:
   ```bash
   cd FE
   npm install cypress --save-dev
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

### 3.1. Tạo thư mục test

1. Tạo thư mục `FE/cypress/integration/thuoc`

### 3.2. Tạo file test

1. Tạo file `FE/cypress/integration/thuoc/list-thuoc.spec.js`:
   ```javascript
   describe('Hiển thị danh sách thuốc', () => {
     beforeEach(() => {
       // Đăng nhập
       cy.visit('/login');
       cy.get('input[name="username"]').type('admin');
       cy.get('input[name="password"]').type('admin123');
       cy.get('button[type="submit"]').click();
       cy.url().should('include', '/dashboard');

       // Truy cập trang danh sách thuốc
       cy.visit('/sys/product');
     });

     it('Hiển thị danh sách thuốc thành công', () => {
       // Kiểm tra tiêu đề trang
       cy.get('h4').should('contain', 'Danh sách thuốc');

       // Kiểm tra bảng danh sách thuốc
       cy.get('p-table').should('exist');
       cy.get('tr').should('have.length.greaterThan', 1);

       // Kiểm tra các cột trong bảng
       cy.get('th').should('contain', 'STT');
       cy.get('th').should('contain', 'Tên Thuốc');
       cy.get('th').should('contain', 'Mã Thuốc');
       cy.get('th').should('contain', 'Số Lượng Tồn');
       cy.get('th').should('contain', 'Giá Nhập');
       cy.get('th').should('contain', 'Trạng thái');

       // Kiểm tra dữ liệu trong bảng
       cy.get('tr').eq(1).should('contain', 'Paracetamol 500mg');
       cy.get('tr').eq(2).should('contain', 'Amoxicillin 500mg');
     });
   });
   ```

2. Tạo file `FE/cypress/integration/thuoc/search-thuoc.spec.js`:
   ```javascript
   describe('Tìm kiếm thuốc', () => {
     beforeEach(() => {
       // Đăng nhập
       cy.visit('/login');
       cy.get('input[name="username"]').type('admin');
       cy.get('input[name="password"]').type('admin123');
       cy.get('button[type="submit"]').click();
       cy.url().should('include', '/dashboard');

       // Truy cập trang danh sách thuốc
       cy.visit('/sys/product');
     });

     it('Tìm kiếm thuốc theo tên thành công', () => {
       // Nhập từ khóa tìm kiếm
       cy.get('input[pInputText]').type('Paracetamol');

       // Nhấn nút tìm kiếm
       cy.get('button').contains('Tìm kiếm').click();

       // Kiểm tra kết quả tìm kiếm
       cy.get('tr').should('have.length', 2); // 1 hàng tiêu đề + 1 hàng kết quả
       cy.get('tr').eq(1).should('contain', 'Paracetamol 500mg');
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
2. Chọn file test cần chạy:
   - `thuoc/list-thuoc.spec.js`
   - `thuoc/search-thuoc.spec.js`

### 4.2. Chạy kiểm thử bằng command line

1. Chạy tất cả các test:
   ```bash
   cd FE
   npx cypress run
   ```
2. Chạy test cụ thể:
   ```bash
   cd FE
   npx cypress run --spec "cypress/integration/thuoc/list-thuoc.spec.js"
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

### 6.2. Lỗi timeout

Nếu Cypress bị timeout, hãy tăng giá trị `defaultCommandTimeout`, `requestTimeout` và `responseTimeout` trong file `cypress.json`.

### 6.3. Lỗi CORS

Nếu gặp lỗi CORS, hãy đảm bảo Backend đã được cấu hình để cho phép truy cập từ Frontend.

## 7. Lưu ý

- Đảm bảo đã khởi động Backend và Frontend trước khi chạy kiểm thử
- Đảm bảo cơ sở dữ liệu đã có dữ liệu mẫu trước khi chạy kiểm thử
- Đảm bảo đã cấu hình Cypress đúng cách
- Đảm bảo selector trong test case phù hợp với cấu trúc HTML của ứng dụng
