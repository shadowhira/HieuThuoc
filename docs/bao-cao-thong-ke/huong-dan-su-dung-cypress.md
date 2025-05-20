# HƯỚNG DẪN SỬ DỤNG CYPRESS ĐỂ KIỂM THỬ GIAO DIỆN BÁO CÁO DOANH THU

## 1. Giới thiệu

Tài liệu này cung cấp hướng dẫn chi tiết về cách sử dụng Cypress để kiểm thử giao diện chức năng Báo cáo Doanh thu trong hệ thống quản lý hiệu thuốc.

## 2. Cài đặt và Cấu hình

### 2.1. Cài đặt Cypress

Cypress đã được cài đặt trong dự án. Nếu bạn cần cài đặt lại, hãy sử dụng lệnh sau:

```bash
# Sử dụng npm
npm install cypress --save-dev

# Hoặc sử dụng npx
npx cypress install
```

### 2.2. Cấu trúc thư mục Cypress

```
FE/cypress/
├── e2e/
│   ├── thongke-dashboard.cy.js  # File test cho dashboard
│   └── revenue-dashboard.cy.js  # File test cho báo cáo doanh thu
├── fixtures/
│   └── users.json               # Dữ liệu đăng nhập
└── support/
    ├── commands.js              # Custom commands
    └── e2e.js                   # Cấu hình e2e
```

### 2.3. File cấu hình Cypress

File `cypress.config.js` đã được cấu hình với các thiết lập sau:

```javascript
const { defineConfig } = require('cypress');

module.exports = defineConfig({
  e2e: {
    baseUrl: 'http://localhost:4200',
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    specPattern: 'cypress/e2e/**/*.cy.{js,jsx,ts,tsx}',
    viewportWidth: 1280,
    viewportHeight: 720,
    defaultCommandTimeout: 10000,
    requestTimeout: 10000,
    responseTimeout: 30000,
    video: true,
    screenshotOnRunFailure: true,
  },
});
```

## 3. Chạy Kiểm thử

### 3.1. Khởi động ứng dụng

Trước khi chạy kiểm thử, hãy đảm bảo ứng dụng đang chạy:

```bash
# Khởi động ứng dụng Angular
npm start
```

### 3.2. Mở Cypress

```bash
# Mở Cypress Test Runner
npm run cypress:open

# Hoặc sử dụng npx
npx cypress open
```

### 3.3. Chạy tất cả các test

```bash
# Chạy tất cả các test
npm run cypress:run

# Hoặc sử dụng npx
npx cypress run
```

### 3.4. Chạy một file test cụ thể

```bash
# Chạy một file test cụ thể
npx cypress run --spec "cypress/e2e/revenue-dashboard.cy.js"
```

## 4. Viết Test Case

### 4.1. Cấu trúc cơ bản của một test case

```javascript
describe('Tên nhóm test', () => {
  beforeEach(() => {
    // Các bước chuẩn bị trước mỗi test case
    cy.visit('/thongke');
  });

  it('Mô tả test case', () => {
    // Các bước kiểm thử
    cy.get('.selector').should('be.visible');
  });
});
```

### 4.2. Custom Commands

Các custom commands đã được định nghĩa trong file `cypress/support/commands.js`:

```javascript
// Đăng nhập
cy.login('admin', 'password');

// Kiểm tra dữ liệu doanh thu
cy.verifyRevenueData(7, 0, 153400);

// Chọn loại báo cáo và thời gian
cy.selectReportType('THANG', { thang: 1, nam: 2024 });
```

### 4.3. Giả lập API (Mocking)

Để giả lập API, sử dụng `cy.intercept()`:

```javascript
// Giả lập dữ liệu báo cáo doanh thu theo ngày
cy.intercept('GET', '**/baocao/doanhthutheongay*', {
  statusCode: 200,
  body: {
    status: 200,
    msg: 'Thành công.',
    data: [
      { thoiGian: 8, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
      // ...
    ]
  }
}).as('getDoanhThuTheoNgay');
```

## 5. Kiểm thử Giao diện

### 5.1. Kiểm tra Dashboard tổng quan

```javascript
it('Hiển thị đúng các thành phần tổng quan', () => {
  // Kiểm tra hiển thị số lượng hóa đơn
  cy.get('.hoa-don-count').should('be.visible');
  cy.get('.hoa-don-count').should('contain', '7');
  
  // Kiểm tra hiển thị số lượng đơn hàng trả lại
  cy.get('.don-hang-tra-lai-count').should('be.visible');
  cy.get('.don-hang-tra-lai-count').should('contain', '0');
  
  // Kiểm tra hiển thị tổng doanh thu
  cy.get('.doanh-thu-value').should('be.visible');
  cy.get('.doanh-thu-value').should('contain', '153,400');
});
```

### 5.2. Kiểm tra biểu đồ doanh thu

```javascript
it('Hiển thị đúng biểu đồ doanh thu', () => {
  // Kiểm tra container biểu đồ hiển thị
  cy.get('#container').should('be.visible');
  
  // Kiểm tra các cột biểu đồ
  cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);
  
  // Kiểm tra trục X và Y
  cy.get('.highcharts-xaxis-labels').should('be.visible');
  cy.get('.highcharts-yaxis-labels').should('be.visible');
});
```

### 5.3. Kiểm tra tính responsive

```javascript
it('Hiển thị đúng trên màn hình desktop', () => {
  cy.viewport(1920, 1080);
  cy.get('#container').should('be.visible');
});

it('Hiển thị đúng trên màn hình tablet', () => {
  cy.viewport(768, 1024);
  cy.get('#container').should('be.visible');
});

it('Hiển thị đúng trên màn hình mobile', () => {
  cy.viewport(375, 667);
  cy.get('#container').should('be.visible');
});
```

## 6. Xử lý Kết quả Kiểm thử

### 6.1. Xem báo cáo

Sau khi chạy kiểm thử, Cypress sẽ tạo báo cáo trong thư mục `cypress/videos` và `cypress/screenshots` (nếu có lỗi).

### 6.2. Ghi lại kết quả

Ghi lại kết quả kiểm thử vào file CSV `docs/bao-cao-thong-ke/ket-qua-kiem-thu-giao-dien.csv`.

## 7. Mẹo và Thủ thuật

### 7.1. Chụp ảnh màn hình

```javascript
// Chụp ảnh màn hình
cy.screenshot('dashboard-overview');
```

### 7.2. Kiểm tra hiệu suất

```javascript
// Đo thời gian tải trang
cy.window().then((win) => {
  const perfData = win.performance.timing;
  const pageLoadTime = perfData.loadEventEnd - perfData.navigationStart;
  expect(pageLoadTime).to.be.lessThan(3000); // Kỳ vọng tải trang trong vòng 3 giây
});
```

### 7.3. Xử lý các thành phần động

```javascript
// Đợi cho biểu đồ tải xong
cy.get('#container', { timeout: 10000 }).should('be.visible');
```

## 8. Tài liệu tham khảo

- [Tài liệu chính thức của Cypress](https://docs.cypress.io/)
- [Cypress API Reference](https://docs.cypress.io/api/table-of-contents)
- [Cypress Best Practices](https://docs.cypress.io/guides/references/best-practices)
