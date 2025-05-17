# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ GIAO DIỆN (UI TESTING) - PHẦN 1
## CHỨC NĂNG QUẢN LÝ THUỐC

## 1. GIỚI THIỆU

### 1.1 Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử giao diện người dùng (UI Testing) cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

### 1.2 Phạm vi
Tài liệu bao gồm hướng dẫn kiểm thử giao diện cho:
- Giao diện danh sách thuốc
- Giao diện thêm/sửa thuốc
- Giao diện chi tiết thuốc
- Giao diện tìm kiếm thuốc
- Kiểm tra tính responsive của giao diện

### 1.3 Công cụ và môi trường
- Công cụ kiểm thử: Selenium WebDriver, Cypress
- Ngôn ngữ lập trình: JavaScript, TypeScript
- Framework: Cypress, Jest
- Trình duyệt: Chrome, Firefox, Edge, Safari
- IDE: Visual Studio Code

## 2. CHUẨN BỊ MÔI TRƯỜNG KIỂM THỬ

### 2.1 Cài đặt Cypress

Cypress là một công cụ kiểm thử giao diện người dùng hiện đại, dễ sử dụng và mạnh mẽ. Để cài đặt Cypress, thực hiện các bước sau:

#### 2.1.1 Cài đặt Node.js và npm
Trước khi cài đặt Cypress, bạn cần cài đặt Node.js và npm. Tải và cài đặt từ trang chủ: https://nodejs.org/

#### 2.1.2 Cài đặt Cypress
```bash
# Di chuyển đến thư mục dự án frontend
cd FE

# Cài đặt Cypress như một dependency phát triển
npm install cypress --save-dev
```

#### 2.1.3 Mở Cypress
```bash
# Mở Cypress Test Runner
npx cypress open
```

### 2.2 Cấu hình Cypress

#### 2.2.1 Tạo file cấu hình Cypress
Tạo file `cypress.config.js` trong thư mục gốc của dự án frontend:

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

#### 2.2.2 Tạo cấu trúc thư mục kiểm thử
```
FE/cypress/
├── e2e/
│   └── quan-ly-thuoc/
│       ├── danh-sach-thuoc.cy.js
│       ├── them-sua-thuoc.cy.js
│       ├── chi-tiet-thuoc.cy.js
│       └── tim-kiem-thuoc.cy.js
├── fixtures/
│   └── thuoc.json
├── support/
│   ├── commands.js
│   └── e2e.js
└── screenshots/
```

#### 2.2.3 Tạo dữ liệu mẫu
Tạo file `cypress/fixtures/thuoc.json`:

```json
{
  "danhSachThuoc": [
    {
      "id": 1,
      "tenThuoc": "Paracetamol 500mg",
      "maThuoc": "PARA500",
      "loaiThuoc": {
        "id": 1,
        "tenLoai": "Giảm đau không steroid"
      },
      "nhaSanXuat": {
        "id": 1,
        "tenNhaSanXuat": "Công ty Dược phẩm ABC"
      },
      "donVi": "Viên",
      "giaNhap": 5000,
      "giaBan": 7000,
      "soLuongTon": 100,
      "nguongCanhBao": 20,
      "congDung": "Giảm đau, hạ sốt",
      "huongDanSuDung": "Uống 1-2 viên mỗi 4-6 giờ khi cần",
      "trangThai": true
    },
    {
      "id": 2,
      "tenThuoc": "Amoxicillin 500mg",
      "maThuoc": "AMOX500",
      "loaiThuoc": {
        "id": 2,
        "tenLoai": "Kháng sinh"
      },
      "nhaSanXuat": {
        "id": 2,
        "tenNhaSanXuat": "Công ty Dược phẩm XYZ"
      },
      "donVi": "Viên",
      "giaNhap": 8000,
      "giaBan": 12000,
      "soLuongTon": 50,
      "nguongCanhBao": 10,
      "congDung": "Điều trị nhiễm khuẩn",
      "huongDanSuDung": "Uống 1 viên mỗi 8 giờ",
      "trangThai": true
    }
  ],
  "loaiThuocList": [
    {
      "id": 1,
      "tenLoai": "Giảm đau không steroid"
    },
    {
      "id": 2,
      "tenLoai": "Kháng sinh"
    },
    {
      "id": 3,
      "tenLoai": "Vitamin và khoáng chất"
    }
  ],
  "nhaSanXuatList": [
    {
      "id": 1,
      "tenNhaSanXuat": "Công ty Dược phẩm ABC"
    },
    {
      "id": 2,
      "tenNhaSanXuat": "Công ty Dược phẩm XYZ"
    }
  ]
}
```

#### 2.2.4 Tạo custom commands
Tạo file `cypress/support/commands.js`:

```javascript
// Lệnh đăng nhập
Cypress.Commands.add('login', (username, password) => {
  cy.visit('/login');
  cy.get('input[name="username"]').type(username);
  cy.get('input[name="password"]').type(password);
  cy.get('button[type="submit"]').click();
  cy.url().should('include', '/admin');
});

// Lệnh chuyển đến trang quản lý thuốc
Cypress.Commands.add('navigateToThuocPage', () => {
  cy.visit('/admin/thuoc');
  cy.contains('Quản lý thuốc').should('be.visible');
});

// Lệnh kiểm tra thông báo
Cypress.Commands.add('checkToast', (message) => {
  cy.get('.p-toast-message').should('be.visible');
  cy.get('.p-toast-message').should('contain', message);
});

// Lệnh chờ API hoàn thành
Cypress.Commands.add('waitForApi', (method, url) => {
  cy.intercept(method, url).as('apiCall');
  cy.wait('@apiCall');
});
```

## 3. KIỂM THỬ GIAO DIỆN DANH SÁCH THUỐC

### 3.1 Tạo test case cho giao diện danh sách thuốc

Tạo file `cypress/e2e/quan-ly-thuoc/danh-sach-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện danh sách thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
    
    // Giả lập API lấy danh sách thuốc
    cy.intercept('POST', '**/thuoc/search', { fixture: 'thuoc.json' }).as('searchThuoc');
    cy.wait('@searchThuoc');
  });
  
  it('Hiển thị đúng tiêu đề trang', () => {
    cy.get('h1').should('contain', 'Quản lý thuốc');
  });
  
  it('Hiển thị đúng các thành phần tìm kiếm', () => {
    // Kiểm tra ô tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').should('be.visible');
    
    // Kiểm tra dropdown loại thuốc
    cy.get('select[name="loaiThuoc"]').should('be.visible');
    
    // Kiểm tra dropdown nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').should('be.visible');
    
    // Kiểm tra nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').should('be.visible');
    
    // Kiểm tra nút thêm mới
    cy.get('button').contains('Thêm mới').should('be.visible');
  });
  
  it('Hiển thị đúng cấu trúc bảng danh sách thuốc', () => {
    // Kiểm tra tiêu đề các cột
    cy.get('table thead th').should('have.length.at.least', 6);
    cy.get('table thead th').eq(0).should('contain', 'STT');
    cy.get('table thead th').eq(1).should('contain', 'Mã thuốc');
    cy.get('table thead th').eq(2).should('contain', 'Tên thuốc');
    cy.get('table thead th').eq(3).should('contain', 'Loại thuốc');
    cy.get('table thead th').eq(4).should('contain', 'Giá bán');
    cy.get('table thead th').eq(5).should('contain', 'Số lượng tồn');
    cy.get('table thead th').eq(6).should('contain', 'Thao tác');
    
    // Kiểm tra dữ liệu trong bảng
    cy.get('table tbody tr').should('have.length', 2);
    
    // Kiểm tra dữ liệu dòng đầu tiên
    cy.get('table tbody tr').eq(0).within(() => {
      cy.get('td').eq(1).should('contain', 'PARA500');
      cy.get('td').eq(2).should('contain', 'Paracetamol 500mg');
      cy.get('td').eq(3).should('contain', 'Giảm đau không steroid');
      cy.get('td').eq(4).should('contain', '7,000');
      cy.get('td').eq(5).should('contain', '100');
    });
  });
  
  it('Hiển thị đúng các nút thao tác', () => {
    cy.get('table tbody tr').eq(0).within(() => {
      // Kiểm tra nút xem chi tiết
      cy.get('button[title="Xem chi tiết"]').should('be.visible');
      
      // Kiểm tra nút sửa
      cy.get('button[title="Sửa"]').should('be.visible');
      
      // Kiểm tra nút xóa
      cy.get('button[title="Xóa"]').should('be.visible');
    });
  });
  
  it('Hiển thị đúng phân trang', () => {
    // Kiểm tra phân trang
    cy.get('.p-paginator').should('be.visible');
    cy.get('.p-paginator-current').should('be.visible');
  });
  
  it('Hiển thị đúng khi không có dữ liệu', () => {
    // Giả lập API trả về danh sách rỗng
    cy.intercept('POST', '**/thuoc/search', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          data: [],
          totalElements: 0,
          totalPages: 0,
          currentPage: 0
        }
      }
    }).as('emptySearch');
    
    // Tìm kiếm với từ khóa không tồn tại
    cy.get('input[placeholder*="Tìm kiếm"]').clear().type('XYZ123');
    cy.get('button').contains('Tìm kiếm').click();
    cy.wait('@emptySearch');
    
    // Kiểm tra hiển thị thông báo không có dữ liệu
    cy.get('table tbody').should('contain', 'Không có dữ liệu');
  });
});
```

### 3.2 Chạy kiểm thử giao diện danh sách thuốc

```bash
# Chạy test case cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-sach-thuoc.cy.js"

# Hoặc mở Cypress Test Runner để chạy và xem kết quả trực quan
npx cypress open
```

## 4. KIỂM THỬ GIAO DIỆN THÊM/SỬA THUỐC

### 4.1 Tạo test case cho giao diện thêm/sửa thuốc

Tạo file `cypress/e2e/quan-ly-thuoc/them-sua-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện thêm/sửa thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
    
    // Giả lập API lấy danh sách thuốc
    cy.intercept('POST', '**/thuoc/search', { fixture: 'thuoc.json' }).as('searchThuoc');
    cy.wait('@searchThuoc');
    
    // Giả lập API lấy danh sách loại thuốc
    cy.intercept('GET', '**/loaithuoc/list', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: [
          { id: 1, tenLoai: "Giảm đau không steroid" },
          { id: 2, tenLoai: "Kháng sinh" },
          { id: 3, tenLoai: "Vitamin và khoáng chất" }
        ]
      }
    }).as('getLoaiThuoc');
    
    // Giả lập API lấy danh sách nhà sản xuất
    cy.intercept('GET', '**/nhasanxuat/list', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: [
          { id: 1, tenNhaSanXuat: "Công ty Dược phẩm ABC" },
          { id: 2, tenNhaSanXuat: "Công ty Dược phẩm XYZ" }
        ]
      }
    }).as('getNhaSanXuat');
  });
  
  it('Hiển thị đúng form thêm thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();
    
    // Kiểm tra tiêu đề form
    cy.get('.p-dialog-title').should('contain', 'Thêm mới thuốc');
    
    // Kiểm tra các trường nhập liệu
    cy.get('input[name="tenThuoc"]').should('be.visible').and('be.empty');
    cy.get('input[name="maThuoc"]').should('be.visible').and('be.empty');
    cy.get('select[name="loaiThuocId"]').should('be.visible');
    cy.get('select[name="nhaSanXuatId"]').should('be.visible');
    cy.get('input[name="donVi"]').should('be.visible').and('be.empty');
    cy.get('input[name="giaNhap"]').should('be.visible').and('be.empty');
    cy.get('input[name="giaBan"]').should('be.visible').and('be.empty');
    cy.get('input[name="soLuongTon"]').should('be.visible').and('be.empty');
    cy.get('input[name="nguongCanhBao"]').should('be.visible').and('be.empty');
    cy.get('textarea[name="congDung"]').should('be.visible').and('be.empty');
    cy.get('textarea[name="huongDanSuDung"]').should('be.visible').and('be.empty');
    
    // Kiểm tra các nút
    cy.get('button').contains('Lưu').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });
  
  it('Hiển thị đúng form sửa thuốc', () => {
    // Nhấn nút sửa thuốc đầu tiên
    cy.get('table tbody tr').eq(0).find('button[title="Sửa"]').click();
    
    // Giả lập API lấy chi tiết thuốc
    cy.intercept('GET', '**/thuoc/get?id=1', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          id: 1,
          tenThuoc: "Paracetamol 500mg",
          maThuoc: "PARA500",
          loaiThuocId: 1,
          nhaSanXuatId: 1,
          donVi: "Viên",
          giaNhap: 5000,
          giaBan: 7000,
          soLuongTon: 100,
          nguongCanhBao: 20,
          congDung: "Giảm đau, hạ sốt",
          huongDanSuDung: "Uống 1-2 viên mỗi 4-6 giờ khi cần",
          trangThai: true
        }
      }
    }).as('getThuocDetail');
    
    cy.wait('@getThuocDetail');
    
    // Kiểm tra tiêu đề form
    cy.get('.p-dialog-title').should('contain', 'Cập nhật thuốc');
    
    // Kiểm tra các trường nhập liệu đã được điền
    cy.get('input[name="tenThuoc"]').should('have.value', 'Paracetamol 500mg');
    cy.get('input[name="maThuoc"]').should('have.value', 'PARA500');
    cy.get('select[name="loaiThuocId"]').should('have.value', '1');
    cy.get('select[name="nhaSanXuatId"]').should('have.value', '1');
    cy.get('input[name="donVi"]').should('have.value', 'Viên');
    cy.get('input[name="giaNhap"]').should('have.value', '5000');
    cy.get('input[name="giaBan"]').should('have.value', '7000');
    cy.get('input[name="soLuongTon"]').should('have.value', '100');
    cy.get('input[name="nguongCanhBao"]').should('have.value', '20');
    cy.get('textarea[name="congDung"]').should('have.value', 'Giảm đau, hạ sốt');
    cy.get('textarea[name="huongDanSuDung"]').should('have.value', 'Uống 1-2 viên mỗi 4-6 giờ khi cần');
    
    // Kiểm tra các nút
    cy.get('button').contains('Lưu').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });
});
```

### 4.2 Chạy kiểm thử giao diện thêm/sửa thuốc

```bash
# Chạy test case cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/them-sua-thuoc.cy.js"

# Hoặc mở Cypress Test Runner để chạy và xem kết quả trực quan
npx cypress open
```
