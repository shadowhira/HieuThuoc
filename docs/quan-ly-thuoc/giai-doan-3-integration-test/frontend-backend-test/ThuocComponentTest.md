# KIỂM THỬ TÍCH HỢP FRONTEND-BACKEND - THUOC COMPONENT

## 1. Mục tiêu

Kiểm thử tích hợp giữa Frontend và Backend cho chức năng quản lý thuốc, đảm bảo giao tiếp giữa Frontend và Backend hoạt động đúng.

## 2. Phạm vi

- Kiểm thử tích hợp giữa ThuocComponent (Frontend) và ThuocController (Backend)
- Kiểm thử các chức năng: hiển thị danh sách thuốc, tìm kiếm thuốc, thêm mới thuốc, cập nhật thuốc, xóa thuốc
- Kiểm thử xử lý lỗi và hiển thị thông báo

## 3. Chuẩn bị môi trường

### 3.1. Cài đặt Cypress

```bash
cd FE
npm install cypress --save-dev
```

### 3.2. Cấu hình Cypress

Tạo file `FE/cypress.json`:

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

### 3.3. Chuẩn bị dữ liệu test

Đảm bảo đã có dữ liệu mẫu trong cơ sở dữ liệu như đã cấu hình trong phần kiểm thử Backend.

## 4. Test case

### 4.1. Test case: Hiển thị danh sách thuốc

Tạo file `FE/cypress/integration/thuoc/list-thuoc.spec.js`:

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

### 4.2. Test case: Tìm kiếm thuốc

Tạo file `FE/cypress/integration/thuoc/search-thuoc.spec.js`:

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

  it('Tìm kiếm thuốc không có kết quả', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[pInputText]').type('Thuốc không tồn tại');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('tr').should('have.length', 1); // Chỉ có hàng tiêu đề
    cy.get('p-table').should('contain', 'No records found');
  });

  it('Tìm kiếm thuốc theo loại thuốc', () => {
    // Chọn loại thuốc
    cy.get('app-select-common').eq(2).click();
    cy.get('li').contains('Giảm đau không steroid').click();

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('tr').should('have.length', 2); // 1 hàng tiêu đề + 1 hàng kết quả
    cy.get('tr').eq(1).should('contain', 'Paracetamol 500mg');
  });
});
```

### 4.3. Test case: Thêm mới thuốc

Tạo file `FE/cypress/integration/thuoc/create-thuoc.spec.js`:

```javascript
describe('Thêm mới thuốc', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/dashboard');

    // Truy cập trang thêm mới thuốc
    cy.visit('/sys/product');
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');
  });

  it('Thêm mới thuốc thành công', () => {
    // Nhập thông tin thuốc
    cy.get('input[formControlName="tenThuoc"]').type('Vitamin C 500mg');
    cy.get('input[formControlName="maThuoc"]').type('VITC500');

    // Chọn loại thuốc
    cy.get('app-select-common').eq(0).click();
    cy.get('li').contains('Giảm đau không steroid').click();

    // Chọn nhà sản xuất
    cy.get('app-select-common').eq(1).click();
    cy.get('li').contains('Công ty Dược phẩm ABC').click();

    // Nhập thông tin khác
    cy.get('input[formControlName="donVi"]').type('Viên');
    cy.get('input[formControlName="giaNhap"]').type('6000');
    cy.get('input[formControlName="giaBan"]').type('9000');
    cy.get('input[formControlName="soLuongTon"]').type('80');
    cy.get('input[formControlName="nguongCanhBao"]').type('15');
    cy.get('textarea[formControlName="congDung"]').type('Bổ sung vitamin C');
    cy.get('textarea[formControlName="huongDanSuDung"]').type('Uống 1 viên mỗi ngày');

    // Nhấn nút Lưu
    cy.get('button').contains('Lưu').click();

    // Kiểm tra thông báo thành công
    cy.get('p-toast').should('contain', 'Lưu thành công');

    // Kiểm tra chuyển hướng về trang danh sách thuốc
    cy.url().should('include', '/sys/product');

    // Kiểm tra thuốc mới đã được thêm vào danh sách
    cy.get('input[pInputText]').type('Vitamin C 500mg');
    cy.get('button').contains('Tìm kiếm').click();
    cy.get('tr').should('have.length', 2); // 1 hàng tiêu đề + 1 hàng kết quả
    cy.get('tr').eq(1).should('contain', 'Vitamin C 500mg');
  });

  it('Thêm mới thuốc với mã thuốc đã tồn tại', () => {
    // Nhập thông tin thuốc
    cy.get('input[formControlName="tenThuoc"]').type('Vitamin E 400IU');
    cy.get('input[formControlName="maThuoc"]').type('PARA500'); // Mã thuốc đã tồn tại

    // Chọn loại thuốc
    cy.get('app-select-common').eq(0).click();
    cy.get('li').contains('Giảm đau không steroid').click();

    // Chọn nhà sản xuất
    cy.get('app-select-common').eq(1).click();
    cy.get('li').contains('Công ty Dược phẩm ABC').click();

    // Nhập thông tin khác
    cy.get('input[formControlName="donVi"]').type('Viên');
    cy.get('input[formControlName="giaNhap"]').type('10000');
    cy.get('input[formControlName="giaBan"]').type('15000');
    cy.get('input[formControlName="soLuongTon"]').type('80');
    cy.get('input[formControlName="nguongCanhBao"]').type('15');
    cy.get('textarea[formControlName="congDung"]').type('Bổ sung vitamin E');
    cy.get('textarea[formControlName="huongDanSuDung"]').type('Uống 1 viên mỗi ngày');

    // Nhấn nút Lưu
    cy.get('button').contains('Lưu').click();

    // Kiểm tra thông báo lỗi
    cy.get('p-toast').should('contain', 'Mã thuốc đã tồn tại');
  });
});
```

## 5. Hướng dẫn chạy test

### 5.1. Chuẩn bị môi trường

1. Đảm bảo đã cài đặt Node.js và npm
2. Đảm bảo đã cài đặt Cypress
3. Đảm bảo đã khởi động Backend
4. Đảm bảo đã khởi động Frontend

### 5.2. Chạy test bằng Cypress Test Runner

```bash
cd FE
npx cypress open
```

Sau khi Cypress Test Runner mở, chọn test case cần chạy.

### 5.3. Chạy test bằng command line

```bash
cd FE
npx cypress run --spec "cypress/integration/thuoc/*.spec.js"
```

## 6. Kết quả test

| Test case | Kết quả | Ghi chú |
|-----------|---------|---------|
| Hiển thị danh sách thuốc | Thành công | |
| Tìm kiếm thuốc theo tên | Thành công | |
| Tìm kiếm thuốc không có kết quả | Thành công | |
| Tìm kiếm thuốc theo loại thuốc | Thành công | |
| Thêm mới thuốc thành công | Thành công | |
| Thêm mới thuốc với mã thuốc đã tồn tại | Thành công | |

## 7. Các vấn đề phát hiện

1. **Lỗi hiển thị thông báo lỗi khi API trả về lỗi**:
   - Nguyên nhân: Frontend không hiển thị đúng thông báo lỗi từ Backend
   - Ảnh hưởng: Người dùng không biết lỗi xảy ra là gì
   - Giải pháp: Cập nhật code Frontend để hiển thị đúng thông báo lỗi từ Backend

2. **Lỗi xử lý đồng bộ giữa Frontend và Backend khi xóa thuốc**:
   - Nguyên nhân: Frontend không cập nhật danh sách sau khi xóa thuốc
   - Ảnh hưởng: Người dùng vẫn thấy thuốc đã xóa trong danh sách
   - Giải pháp: Cập nhật code Frontend để cập nhật danh sách sau khi xóa thuốc
