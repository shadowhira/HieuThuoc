# HƯỚNG DẪN TRIỂN KHAI GIAI ĐOẠN 6: KIỂM THỬ HỆ THỐNG

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai giai đoạn 6 - Kiểm thử hệ thống (System Testing) cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

## 🎯 MỤC TIÊU

- Kiểm thử luồng nghiệp vụ từ đầu đến cuối (End-to-End Testing)
- Kiểm thử hiệu năng (Performance Testing)
- Kiểm thử tương thích (Compatibility Testing)

## 🛠️ CÔNG CỤ VÀ MÔI TRƯỜNG

- **End-to-End Testing**: Cypress
- **Performance Testing**: JMeter, Chrome DevTools
- **Compatibility Testing**: Cypress với BrowserStack
- **Trình duyệt**: Chrome, Edge
- **IDE**: Visual Studio Code
- **Hệ điều hành**: Windows/macOS/Linux

## 📝 QUY TRÌNH TRIỂN KHAI

### 1. Kiểm thử luồng nghiệp vụ (End-to-End Testing)

#### 1.1. Chuẩn bị môi trường

1. Đảm bảo đã cài đặt Cypress:
```bash
# Di chuyển đến thư mục frontend
cd FE
npm install cypress --save-dev
```

2. Tạo cấu trúc thư mục kiểm thử:
```
FE/cypress/
├── e2e/
│   └── quan-ly-thuoc/
│       ├── e2e-them-thuoc.cy.js
│       ├── e2e-sua-thuoc.cy.js
│       └── e2e-xoa-thuoc.cy.js
├── fixtures/
│   └── thuoc.json
└── support/
    ├── commands.js
    └── e2e.js
```

#### 1.2. Viết test case cho luồng thêm thuốc mới

Tạo file `FE/cypress/e2e/quan-ly-thuoc/e2e-them-thuoc.cy.js`:

```javascript
describe('Kiểm thử luồng thêm thuốc mới', () => {
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

  it('Thêm thuốc mới thành công', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');
    
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');
    
    // Nhập thông tin thuốc mới
    cy.get('input[formcontrolname="tenThuoc"]').type('Vitamin E2 400IU');
    cy.get('input[formcontrolname="maThuoc"]').type('VTE400');
    
    // Chọn loại thuốc
    cy.get('p-dropdown[formcontrolname="loaiThuoc"]').click();
    cy.get('p-dropdownitem').contains('Vitamin').click();
    
    // Nhập thông tin khác
    cy.get('input[formcontrolname="nhaSanXuat"]').type('DHG Pharma');
    cy.get('input[formcontrolname="donViTinh"]').type('Viên');
    cy.get('input[formcontrolname="giaNhap"]').type('50000');
    cy.get('input[formcontrolname="giaBan"]').type('65000');
    cy.get('input[formcontrolname="soLuong"]').type('100');
    cy.get('input[formcontrolname="nguongCanhBao"]').type('10');
    cy.get('textarea[formcontrolname="congDung"]').type('Bổ sung Vitamin E, chống oxy hóa');
    cy.get('textarea[formcontrolname="huongDanSuDung"]').type('Uống 1 viên/ngày sau bữa ăn');
    
    // Nhấn nút thêm
    cy.get('button').contains('Thêm').click();
    
    // Kiểm tra thông báo thành công
    cy.get('.p-toast-message').should('be.visible');
    cy.get('.p-toast-message').should('contain', 'thành công');
    
    // Kiểm tra quay lại trang danh sách
    cy.url().should('include', '/sys/product');
    
    // Kiểm tra thuốc mới đã được thêm vào danh sách
    cy.get('input[placeholder*="Tìm kiếm"]').type('Vitamin E2 400IU');
    cy.get('button').contains('Tìm kiếm').click();
    cy.get('p-table').should('contain', 'Vitamin E2 400IU');
  });
});
```

#### 1.3. Viết test case cho luồng sửa thông tin thuốc

Tạo file `FE/cypress/e2e/quan-ly-thuoc/e2e-sua-thuoc.cy.js` với nội dung tương tự.

#### 1.4. Viết test case cho luồng xóa thuốc

Tạo file `FE/cypress/e2e/quan-ly-thuoc/e2e-xoa-thuoc.cy.js` với nội dung tương tự.

### 2. Kiểm thử hiệu năng (Performance Testing)

#### 2.1. Chuẩn bị môi trường

1. Tải và cài đặt JMeter từ https://jmeter.apache.org/download_jmeter.cgi
2. Tạo Test Plan cho API quản lý thuốc

#### 2.2. Tạo Test Plan trong JMeter

1. Mở JMeter
2. Tạo Thread Group:
   - Chuột phải vào Test Plan > Add > Threads (Users) > Thread Group
   - Đặt tên: "Quản lý thuốc"
   - Number of Threads: 10
   - Ramp-up period: 5
   - Loop Count: 5

3. Thêm HTTP Request Defaults:
   - Chuột phải vào Thread Group > Add > Config Element > HTTP Request Defaults
   - Server Name or IP: localhost
   - Port Number: 8080
   - Protocol: http

4. Thêm HTTP Header Manager:
   - Chuột phải vào Thread Group > Add > Config Element > HTTP Header Manager
   - Thêm header: Content-Type: application/json

5. Thêm HTTP Request cho API lấy danh sách thuốc:
   - Chuột phải vào Thread Group > Add > Sampler > HTTP Request
   - Đặt tên: "Lấy danh sách thuốc"
   - Method: GET
   - Path: /api/thuoc/getAll

6. Thêm các HTTP Request khác cho các API khác (thêm, sửa, xóa, tìm kiếm)

7. Thêm Listener:
   - Chuột phải vào Thread Group > Add > Listener > View Results Tree
   - Chuột phải vào Thread Group > Add > Listener > Summary Report

#### 2.3. Chạy Test Plan và phân tích kết quả

1. Lưu Test Plan
2. Nhấn nút "Start" để chạy kiểm thử
3. Phân tích kết quả trong View Results Tree và Summary Report

### 3. Kiểm thử tương thích (Compatibility Testing)

#### 3.1. Chuẩn bị môi trường

1. Đăng ký tài khoản BrowserStack (hoặc sử dụng tài khoản hiện có)
2. Cài đặt BrowserStack Cypress CLI:
```bash
npm install -g browserstack-cypress-cli
```

3. Khởi tạo cấu hình BrowserStack:
```bash
browserstack-cypress init
```

#### 3.2. Cấu hình BrowserStack

Chỉnh sửa file `browserstack.json`:
```json
{
  "auth": {
    "username": "your_username",
    "access_key": "your_access_key"
  },
  "browsers": [
    {
      "browser": "chrome",
      "os": "Windows 10",
      "versions": ["latest"]
    },
    {
      "browser": "edge",
      "os": "Windows 10",
      "versions": ["latest"]
    }
  ],
  "run_settings": {
    "cypress_config_file": "cypress.config.js",
    "project_name": "Quản lý thuốc",
    "build_name": "Kiểm thử tương thích",
    "specs": ["cypress/e2e/quan-ly-thuoc/*.cy.js"]
  }
}
```

#### 3.3. Chạy kiểm thử tương thích

```bash
browserstack-cypress run
```

## 📊 BÁO CÁO KIỂM THỬ

Sau khi chạy các test case, tạo báo cáo kiểm thử với các thông tin:

1. Tổng số test case
2. Số test case thành công/thất bại
3. Các lỗi phát hiện
4. Kết quả kiểm thử hiệu năng
5. Kết quả kiểm thử tương thích

## 📝 CHECKLIST KIỂM THỬ HỆ THỐNG

- [ ] Đã kiểm thử luồng thêm thuốc mới
- [ ] Đã kiểm thử luồng sửa thông tin thuốc
- [ ] Đã kiểm thử luồng xóa thuốc
- [ ] Đã kiểm thử hiệu năng API danh sách thuốc
- [ ] Đã kiểm thử hiệu năng API tìm kiếm thuốc
- [ ] Đã kiểm thử hiệu năng API thêm thuốc
- [ ] Đã kiểm thử hiệu năng API sửa thuốc
- [ ] Đã kiểm thử hiệu năng API xóa thuốc
- [ ] Đã kiểm thử tương thích trên Chrome
- [ ] Đã kiểm thử tương thích trên Edge

## 🔍 LƯU Ý QUAN TRỌNG

1. Đảm bảo môi trường kiểm thử (Backend và Frontend) đang chạy trước khi thực hiện kiểm thử.
2. Cập nhật thông tin đăng nhập trong test case nếu cần thiết.
3. Điều chỉnh các selector CSS nếu giao diện thay đổi.
4. Đối với kiểm thử hiệu năng, đảm bảo hệ thống có đủ dữ liệu để kiểm thử.
5. Đối với kiểm thử tương thích, cần có tài khoản BrowserStack hợp lệ.
