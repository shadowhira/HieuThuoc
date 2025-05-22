# HƯỚNG DẪN CHẠY KIỂM THỬ HỆ THỐNG CHỨC NĂNG QUẢN LÝ NGƯỜI DÙNG VÀ PHÂN QUYỀN

## 1. TỔNG QUAN

### 1.1. Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách chạy kiểm thử hệ thống cho chức năng quản lý người dùng và phân quyền trong hệ thống web bán và quản lý hiệu thuốc. Kiểm thử hệ thống tập trung vào việc kiểm tra toàn bộ hệ thống hoạt động đúng theo yêu cầu, bao gồm các luồng nghiệp vụ từ đầu đến cuối, hiệu năng, bảo mật và tương thích.

### 1.2. Phạm vi
Tài liệu này áp dụng cho việc chạy kiểm thử hệ thống các chức năng:
- Luồng quản lý người dùng (thêm, sửa, xóa, tìm kiếm)
- Luồng quản lý nhóm quyền (thêm, sửa, xóa, tìm kiếm)
- Luồng phân quyền người dùng (gán quyền, thu hồi quyền, kiểm tra quyền)
- Kiểm thử hiệu năng
- Kiểm thử bảo mật
- Kiểm thử tương thích

## 2. CHUẨN BỊ MÔI TRƯỜNG

### 2.1. Yêu cầu phần cứng
- Máy tính có cấu hình tối thiểu: CPU Core i5, RAM 8GB, SSD 256GB
- Kết nối internet ổn định

### 2.2. Yêu cầu phần mềm
- Hệ điều hành: Windows 10/11, macOS, Linux
- JDK 17
- Node.js 16+
- npm 8+
- PostgreSQL 14+
- Git
- Trình duyệt: Chrome 90+, Firefox 88+, Edge 90+, Safari 14+
- Công cụ kiểm thử: Cypress, Postman, JMeter

### 2.3. Cài đặt công cụ kiểm thử

#### 2.3.1. Cài đặt Cypress
```bash
cd FE
npm install cypress --save-dev
```

#### 2.3.2. Cài đặt Postman
Tải và cài đặt Postman từ trang web chính thức: https://www.postman.com/downloads/

#### 2.3.3. Cài đặt JMeter
1. Tải JMeter từ trang web chính thức: https://jmeter.apache.org/download_jmeter.cgi
2. Giải nén vào thư mục mong muốn
3. Chạy JMeter bằng cách thực thi file `bin/jmeter.bat` (Windows) hoặc `bin/jmeter.sh` (Linux/Mac)

### 2.4. Chuẩn bị dự án

#### 2.4.1. Clone dự án
```bash
git clone <repository-url>
cd HieuThuoc
```

#### 2.4.2. Cài đặt dependencies Backend
```bash
cd BE
./mvnw clean install
```

#### 2.4.3. Cài đặt dependencies Frontend
```bash
cd FE
npm install
```

#### 2.4.4. Cấu hình cơ sở dữ liệu
1. Đảm bảo PostgreSQL đã được cài đặt và đang chạy
2. Tạo cơ sở dữ liệu `hieu_thuoc`
3. Cấu hình kết nối trong file `BE/src/main/resources/application.properties`

#### 2.4.5. Cấu hình Cypress
1. Tạo file `FE/cypress.config.js` với nội dung:
```javascript
const { defineConfig } = require('cypress')

module.exports = defineConfig({
  e2e: {
    baseUrl: 'http://localhost:4200',
    specPattern: 'cypress/e2e/**/*.cy.{js,jsx,ts,tsx}',
    supportFile: 'cypress/support/e2e.js',
    viewportWidth: 1280,
    viewportHeight: 720,
    video: true,
    screenshotOnRunFailure: true,
  },
})
```

2. Tạo file `FE/cypress/support/commands.js` với nội dung:
```javascript
// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************

// Command để đăng nhập
Cypress.Commands.add('login', (username, password) => {
  cy.visit('/login');
  cy.get('input[name="username"]').type(username);
  cy.get('input[name="password"]').type(password);
  cy.get('button[type="submit"]').click();
  
  // Đợi đăng nhập thành công
  cy.url().should('not.include', '/login');
});

// Command để đăng xuất
Cypress.Commands.add('logout', () => {
  cy.get('.user-menu').click();
  cy.get('button').contains('Đăng xuất').click();
  cy.url().should('include', '/login');
});
```

## 3. CHẠY KIỂM THỬ HỆ THỐNG

### 3.1. Khởi động Backend và Frontend

#### 3.1.1. Khởi động Backend
```bash
cd BE
./mvnw spring-boot:run
```

#### 3.1.2. Khởi động Frontend
Mở một terminal mới và chạy:
```bash
cd FE
npm start
```

### 3.2. Chạy kiểm thử luồng quản lý người dùng

#### 3.2.1. Tạo file kiểm thử Cypress
Tạo thư mục `FE/cypress/e2e/quan-ly-nguoi-dung` và tạo file `user-management.cy.js` với nội dung từ tài liệu [Kiem_Thu_He_Thong_Phan1.md](./Kiem_Thu_He_Thong_Phan1.md).

#### 3.2.2. Chạy kiểm thử Cypress
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/user-management.cy.js"
```

Hoặc để chạy với giao diện:
```bash
cd FE
npx cypress open
```
Sau đó chọn file `user-management.cy.js` để chạy.

### 3.3. Chạy kiểm thử luồng quản lý nhóm quyền

#### 3.3.1. Tạo file kiểm thử Cypress
Tạo file `FE/cypress/e2e/quan-ly-nguoi-dung/role-management.cy.js` với nội dung từ tài liệu [Kiem_Thu_He_Thong_Phan2.md](./Kiem_Thu_He_Thong_Phan2.md).

#### 3.3.2. Chạy kiểm thử Cypress
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/role-management.cy.js"
```

### 3.4. Chạy kiểm thử luồng phân quyền người dùng

#### 3.4.1. Tạo file kiểm thử Cypress
Tạo file `FE/cypress/e2e/quan-ly-nguoi-dung/permission-management.cy.js` với nội dung từ tài liệu [Kiem_Thu_He_Thong_Phan3.md](./Kiem_Thu_He_Thong_Phan3.md).

#### 3.4.2. Chạy kiểm thử Cypress
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/permission-management.cy.js"
```

### 3.5. Chạy kiểm thử hiệu năng

#### 3.5.1. Chuẩn bị JMeter Test Plan
1. Mở JMeter
2. Tạo Test Plan mới
3. Thêm Thread Group
4. Thêm HTTP Request cho các API cần kiểm thử
5. Thêm Summary Report và View Results Tree
6. Lưu Test Plan vào file `HieuThuoc/docs/quan-ly-nguoi-dung-phan-quyen/performance-test-plan.jmx`

#### 3.5.2. Chạy kiểm thử JMeter
```bash
cd HieuThuoc/docs/quan-ly-nguoi-dung-phan-quyen
jmeter -n -t performance-test-plan.jmx -l results.jtl -e -o report
```

### 3.6. Chạy kiểm thử bảo mật

#### 3.6.1. Tạo file kiểm thử Cypress
Tạo file `FE/cypress/e2e/quan-ly-nguoi-dung/security-testing.cy.js` với nội dung từ tài liệu [Kiem_Thu_He_Thong_Phan5.md](./Kiem_Thu_He_Thong_Phan5.md).

#### 3.6.2. Chạy kiểm thử Cypress
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/security-testing.cy.js"
```

### 3.7. Chạy kiểm thử tương thích

#### 3.7.1. Tạo file kiểm thử Cypress
Tạo file `FE/cypress/e2e/quan-ly-nguoi-dung/compatibility-testing.cy.js` với nội dung từ tài liệu [Kiem_Thu_He_Thong_Phan5.md](./Kiem_Thu_He_Thong_Phan5.md).

#### 3.7.2. Chạy kiểm thử Cypress trên nhiều trình duyệt
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/compatibility-testing.cy.js" --browser chrome
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/compatibility-testing.cy.js" --browser firefox
npx cypress run --spec "cypress/e2e/quan-ly-nguoi-dung/compatibility-testing.cy.js" --browser edge
```

## 4. XEM KẾT QUẢ KIỂM THỬ

### 4.1. Kết quả kiểm thử Cypress
Sau khi chạy kiểm thử Cypress, kết quả sẽ được hiển thị trong terminal. Ngoài ra, bạn có thể xem báo cáo chi tiết và video ghi lại quá trình kiểm thử trong thư mục:
- Video: `FE/cypress/videos`
- Screenshots (nếu có lỗi): `FE/cypress/screenshots`

### 4.2. Kết quả kiểm thử hiệu năng
Kết quả kiểm thử hiệu năng JMeter sẽ được lưu trong thư mục `HieuThuoc/docs/quan-ly-nguoi-dung-phan-quyen/report`. Mở file `index.html` trong thư mục này để xem báo cáo chi tiết.

## 5. XỬ LÝ LỖI THƯỜNG GẶP

### 5.1. Lỗi kết nối cơ sở dữ liệu
- Kiểm tra PostgreSQL đã được khởi động
- Kiểm tra thông tin kết nối trong file `application.properties`
- Kiểm tra cơ sở dữ liệu `hieu_thuoc` đã được tạo

### 5.2. Lỗi khi chạy Cypress
- Kiểm tra Frontend và Backend đã được khởi động
- Kiểm tra cấu hình Cypress trong file `cypress.config.js`
- Kiểm tra các selector trong test case có chính xác không

### 5.3. Lỗi khi chạy JMeter
- Kiểm tra JMeter đã được cài đặt đúng cách
- Kiểm tra Test Plan có chứa các HTTP Request đúng
- Kiểm tra Backend đã được khởi động
