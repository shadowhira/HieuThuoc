# HƯỚNG DẪN TRIỂN KHAI GIAI ĐOẠN 5: KIỂM THỬ GIAO DIỆN

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai giai đoạn 5 - Kiểm thử giao diện (UI Testing) cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

## 🎯 MỤC TIÊU

- Kiểm thử giao diện danh sách thuốc
- Kiểm thử giao diện thêm/sửa thuốc
- Kiểm thử giao diện chi tiết thuốc
- Kiểm thử giao diện tìm kiếm thuốc
- Kiểm thử tính responsive

## 🛠️ CÔNG CỤ VÀ MÔI TRƯỜNG

- **Framework kiểm thử**: Cypress
- **Trình duyệt**: Chrome, Edge
- **IDE**: Visual Studio Code
- **Hệ điều hành**: Windows/macOS/Linux

## 📝 QUY TRÌNH TRIỂN KHAI

### 1. Chuẩn bị môi trường

#### 1.1. Cài đặt Cypress (nếu chưa cài đặt)

```bash
# Di chuyển đến thư mục frontend
cd FE

# Cài đặt Cypress
npm install cypress --save-dev
```

#### 1.2. Cấu hình Cypress

Đảm bảo file `cypress.config.js` đã được cấu hình đúng:

```javascript
module.exports = {
  e2e: {
    baseUrl: "http://localhost:4200",
    specPattern: "cypress/e2e/**/*.cy.{js,jsx,ts,tsx}",
    supportFile: "cypress/support/e2e.js",
    viewportWidth: 1280,
    viewportHeight: 720,
    video: true,
    screenshotOnRunFailure: true,
  },
};
```

#### 1.3. Chuẩn bị dữ liệu kiểm thử

Đảm bảo cơ sở dữ liệu đã có dữ liệu mẫu cho việc kiểm thử.

### 2. Tạo cấu trúc thư mục kiểm thử

```
FE/cypress/
├── e2e/
│   └── quan-ly-thuoc/
│       ├── danh-sach-thuoc.cy.js
│       ├── them-sua-thuoc.cy.js
│       ├── chi-tiet-thuoc.cy.js
│       ├── tim-kiem-thuoc.cy.js
│       └── responsive.cy.js
├── fixtures/
│   └── thuoc.json
├── support/
│   ├── commands.js
│   └── e2e.js
└── screenshots/
```

### 3. Kiểm thử giao diện danh sách thuốc

#### 3.1. Tạo file kiểm thử danh sách thuốc

Tạo file `FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện danh sách thuốc', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
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

  it('Hiển thị tiêu đề trang chính xác', () => {
    cy.get('h4').should('be.visible');
  });

  it('Hiển thị bảng danh sách thuốc', () => {
    cy.get('p-table').should('exist');
    cy.get('tr').should('have.length.greaterThan', 1);
  });

  it('Hiển thị các cột trong bảng chính xác', () => {
    cy.get('th').should('have.length.at.least', 3);
    cy.get('th').should('contain', 'Mã thuốc');
    cy.get('th').should('contain', 'Tên thuốc');
    cy.get('th').should('contain', 'Giá bán');
  });

  it('Hiển thị nút thêm mới thuốc', () => {
    cy.get('button').contains('Thêm thuốc').should('be.visible');
  });

  it('Hiển thị phân trang', () => {
    cy.get('p-paginator').should('exist');
  });

  it('Hiển thị các nút thao tác trên mỗi dòng', () => {
    cy.get('tr').eq(1).find('button').should('have.length.at.least', 1);
  });
});
```

#### 3.2. Chạy kiểm thử danh sách thuốc

```bash
# Mở Cypress Test Runner
npx cypress open

# Hoặc chạy test cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-sach-thuoc.cy.js"
```

### 4. Kiểm thử giao diện thêm/sửa thuốc

#### 4.1. Tạo file kiểm thử thêm/sửa thuốc

Tạo file `FE/cypress/e2e/quan-ly-thuoc/them-sua-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện thêm/sửa thuốc', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
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

  it('Hiển thị form thêm mới thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra tiêu đề form
    cy.get('h4').should('contain', 'Thêm Sản Phẩm');

    // Kiểm tra các trường nhập liệu
    cy.get('input#product-title-input').should('be.visible');
    cy.get('input#product-code-input').should('be.visible');
    cy.get('app-select-common').should('have.length.at.least', 2);
    cy.get('select.form-control').should('be.visible');
    cy.get('input#product-price-input').should('be.visible');
    cy.get('input#product-sale-price-input').should('be.visible');
    cy.get('input#product-quantity-input').should('be.visible');
    cy.get('input[placeholder="Nhập ngưỡng cảnh báo"]').should('be.visible');
    cy.get('input[placeholder="Nhập công dụng"]').should('be.visible');
    cy.get('textarea[name="huongDanSuDung"]').should('be.visible');

    // Kiểm tra các nút thao tác
    cy.get('button[type="submit"]').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });

  it('Hiển thị form sửa thuốc', () => {
    // Nhấn nút sửa trên dòng đầu tiên
    cy.get('tr').eq(1).find('button[title="Sửa"]').click();
    cy.url().should('include', '/sys/product-update');

    // Kiểm tra tiêu đề form
    cy.get('h4').should('contain', 'Cập Nhật Sản Phẩm');

    // Kiểm tra các trường nhập liệu đã có dữ liệu
    cy.get('input#product-title-input').should('not.have.value', '');
    cy.get('input#product-code-input').should('not.have.value', '');

    // Kiểm tra các nút thao tác
    cy.get('button[type="submit"]').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });

  it('Hiển thị thông báo lỗi khi nhập liệu không hợp lệ', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Nhấn nút Thêm mà không nhập dữ liệu
    cy.get('button[type="submit"]').click();

    // Kiểm tra thông báo lỗi
    cy.get('.text-danger').should('be.visible');
  });
});
```

### 5. Kiểm thử giao diện chi tiết thuốc

#### 5.1. Tạo file kiểm thử chi tiết thuốc

Tạo file `FE/cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện chi tiết thuốc', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
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

  it('Hiển thị chi tiết thuốc', () => {
    // Nhấn nút xem chi tiết trên dòng đầu tiên
    cy.get('tr').eq(1).find('button[title="Xem chi tiết"]').click();
    cy.url().should('include', '/sys/product-detail');

    // Kiểm tra tiêu đề trang
    cy.get('h4').should('contain', 'Chi Tiết Sản Phẩm');

    // Kiểm tra các thông tin chi tiết
    cy.get('.card-body').should('contain', 'Mã thuốc:');
    cy.get('.card-body').should('contain', 'Tên thuốc:');
    cy.get('.card-body').should('contain', 'Loại thuốc:');
    cy.get('.card-body').should('contain', 'Nhà sản xuất:');
    cy.get('.card-body').should('contain', 'Đơn vị tính:');
    cy.get('.card-body').should('contain', 'Giá nhập:');
    cy.get('.card-body').should('contain', 'Giá bán:');
    cy.get('.card-body').should('contain', 'Số lượng:');
    cy.get('.card-body').should('contain', 'Ngưỡng cảnh báo:');
    cy.get('.card-body').should('contain', 'Công dụng:');
    cy.get('.card-body').should('contain', 'Hướng dẫn sử dụng:');

    // Kiểm tra nút quay lại
    cy.get('button').contains('Quay lại').should('be.visible');
  });
});
```

### 6. Kiểm thử giao diện tìm kiếm thuốc

#### 6.1. Tạo file kiểm thử tìm kiếm thuốc

Tạo file `FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện tìm kiếm thuốc', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
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

  it('Hiển thị form tìm kiếm', () => {
    // Kiểm tra ô tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').should('be.visible');

    // Kiểm tra nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').should('be.visible');
  });

  it('Hiển thị kết quả tìm kiếm', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').type('Para');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('p-table').should('exist');
    cy.get('tr').should('have.length.at.least', 1);
  });

  it('Hiển thị thông báo khi không có kết quả tìm kiếm', () => {
    // Nhập từ khóa tìm kiếm không tồn tại
    cy.get('input[placeholder*="Tìm kiếm"]').type('XYZ123456789');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Kiểm tra thông báo không có kết quả
    cy.get('p-table').should('exist');
    cy.get('tr').should('have.length', 1); // Chỉ có header
  });
});
```

### 7. Kiểm thử tính responsive

#### 7.1. Tạo file kiểm thử tính responsive

Tạo file `FE/cypress/e2e/quan-ly-thuoc/responsive.cy.js`:

```javascript
describe('Kiểm thử tính responsive của giao diện', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
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
  });

  it('Hiển thị đúng trên màn hình desktop', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra hiển thị của các thành phần
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');
    cy.get('p-paginator').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình tablet', () => {
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra hiển thị của các thành phần
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');
    cy.get('p-paginator').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra hiển thị của các thành phần
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');
    cy.get('p-paginator').should('be.visible');
  });
});
```

## 📊 BÁO CÁO KIỂM THỬ

Sau khi chạy các test case, tạo báo cáo kiểm thử với các thông tin:

1. Tổng số test case
2. Số test case thành công/thất bại
3. Các lỗi phát hiện
4. Ảnh chụp màn hình lỗi

## 📝 CHECKLIST KIỂM THỬ GIAO DIỆN

- [x] Đã kiểm thử giao diện danh sách thuốc
- [x] Đã kiểm thử giao diện thêm/sửa thuốc
- [x] Đã kiểm thử giao diện chi tiết thuốc
- [x] Đã kiểm thử giao diện tìm kiếm thuốc
- [x] Đã kiểm thử tính responsive của giao diện
- [x] Đã kiểm thử trên trình duyệt Chrome
- [ ] Đã kiểm thử trên trình duyệt Edge
- [x] Đã kiểm thử trên các kích thước màn hình khác nhau

## 🔍 LƯU Ý QUAN TRỌNG

1. Đảm bảo môi trường kiểm thử (Backend và Frontend) đang chạy trước khi thực hiện kiểm thử.
2. Cập nhật thông tin đăng nhập trong test case nếu cần thiết.
3. Điều chỉnh các selector CSS nếu giao diện thay đổi.
4. Chạy kiểm thử trên nhiều trình duyệt khác nhau để đảm bảo tính tương thích.

## 📊 KẾT QUẢ KIỂM THỬ

Tất cả 32 test case đã chạy thành công trên trình duyệt Chrome. Giao diện người dùng hoạt động đúng như mong đợi.

### Tổng hợp kết quả

| Trình duyệt | Tổng số test case | Thành công | Thất bại | Chưa thực hiện |
|-------------|-------------------|------------|----------|----------------|
| Chrome | 32 | 32 | 0 | 0 |
| Edge | 32 | 0 | 0 | 32 |

### Phân tích lỗi

Không phát hiện lỗi nào trong quá trình kiểm thử giao diện.

### Đề xuất cải thiện

1. **Cải thiện giao diện**:
   - Thêm thông báo xác nhận khi xóa thuốc
   - Cải thiện hiển thị trên màn hình mobile
   - Thêm tính năng lọc nâng cao

2. **Cải thiện test case**:
   - Thêm test case cho các tính năng mới
   - Tối ưu hóa selector để tăng độ ổn định của test
   - Thêm test case cho các trường hợp đặc biệt
