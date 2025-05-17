# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ HỆ THỐNG (SYSTEM TESTING)
## CHỨC NĂNG QUẢN LÝ THUỐC

## 1. GIỚI THIỆU

### 1.1 Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử hệ thống cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

### 1.2 Phạm vi
Tài liệu bao gồm hướng dẫn kiểm thử hệ thống cho:
- Kiểm thử luồng nghiệp vụ từ đầu đến cuối (End-to-End Testing)
- Kiểm thử hiệu năng (Performance Testing)
- Kiểm thử giao diện người dùng (UI Testing)
- Kiểm thử tương thích (Compatibility Testing)

### 1.3 Công cụ và môi trường
- End-to-End Testing: Selenium, Cypress
- Performance Testing: JMeter, Chrome DevTools
- UI Testing: Selenium, Cypress
- Compatibility Testing: BrowserStack, CrossBrowserTesting
- IDE: IntelliJ IDEA, Visual Studio Code
- Trình duyệt: Chrome, Firefox, Edge, Safari

## 2. KIỂM THỬ LUỒNG NGHIỆP VỤ (END-TO-END TESTING)

### 2.1 Chuẩn bị môi trường

#### 2.1.1 Cài đặt Cypress
```bash
cd FE
npm install cypress --save-dev
```

#### 2.1.2 Cấu hình Cypress
Tạo file `cypress.config.js`:
```javascript
const { defineConfig } = require('cypress')

module.exports = defineConfig({
  e2e: {
    baseUrl: 'http://localhost:4200',
    specPattern: 'cypress/e2e/**/*.cy.{js,jsx,ts,tsx}',
    supportFile: 'cypress/support/e2e.js',
  },
})
```

#### 2.1.3 Cấu trúc thư mục kiểm thử
```
FE/cypress/
├── e2e/
│   └── quan-ly-thuoc/
│       ├── them-thuoc.cy.js
│       ├── sua-thuoc.cy.js
│       ├── xoa-thuoc.cy.js
│       └── tim-kiem-thuoc.cy.js
├── fixtures/
│   └── thuoc.json
└── support/
    ├── commands.js
    └── e2e.js
```

### 2.2 Viết test case cho các luồng nghiệp vụ

#### 2.2.1 Luồng thêm thuốc mới
Tạo file `cypress/e2e/quan-ly-thuoc/them-thuoc.cy.js`:
```javascript
describe('Thêm thuốc mới', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();
    
    // Chuyển đến trang quản lý thuốc
    cy.visit('/admin/thuoc');
  });
  
  it('Thêm thuốc mới thành công', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();
    
    // Điền thông tin thuốc
    cy.get('input[name="tenThuoc"]').type('Vitamin D3 1000IU');
    cy.get('input[name="maThuoc"]').type('VITD1000');
    
    // Chọn loại thuốc
    cy.get('select[name="loaiThuocId"]').select('Vitamin và khoáng chất');
    
    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuatId"]').select('Công ty Dược phẩm ABC');
    
    // Điền các thông tin khác
    cy.get('input[name="donVi"]').type('Viên');
    cy.get('input[name="giaNhap"]').type('8000');
    cy.get('input[name="giaBan"]').type('12000');
    cy.get('input[name="soLuongTon"]').type('100');
    cy.get('input[name="nguongCanhBao"]').type('20');
    
    // Điền thông tin mô tả
    cy.get('textarea[name="congDung"]').type('Bổ sung vitamin D3');
    cy.get('textarea[name="huongDanSuDung"]').type('Uống 1 viên mỗi ngày');
    
    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();
    
    // Kiểm tra thông báo thành công
    cy.contains('Thành công').should('be.visible');
    
    // Kiểm tra thuốc mới đã được thêm vào danh sách
    cy.get('input[placeholder="Tìm kiếm..."]').type('Vitamin D3');
    cy.get('button').contains('Tìm kiếm').click();
    cy.contains('Vitamin D3 1000IU').should('be.visible');
  });
  
  it('Thêm thuốc với mã thuốc đã tồn tại', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();
    
    // Điền thông tin thuốc với mã thuốc đã tồn tại
    cy.get('input[name="tenThuoc"]').type('Vitamin E 400IU');
    cy.get('input[name="maThuoc"]').type('PARA500'); // Mã thuốc đã tồn tại
    
    // Điền các thông tin khác
    // ...
    
    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();
    
    // Kiểm tra thông báo lỗi
    cy.contains('Mã thuốc đã tồn tại').should('be.visible');
  });
});
```

#### 2.2.2 Luồng sửa thông tin thuốc
Tạo file `cypress/e2e/quan-ly-thuoc/sua-thuoc.cy.js`:
```javascript
describe('Sửa thông tin thuốc', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();
    
    // Chuyển đến trang quản lý thuốc
    cy.visit('/admin/thuoc');
  });
  
  it('Sửa thông tin thuốc thành công', () => {
    // Tìm kiếm thuốc cần sửa
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Nhấn nút sửa
    cy.get('button[title="Sửa"]').first().click();
    
    // Sửa thông tin thuốc
    cy.get('input[name="giaBan"]').clear().type('8000');
    cy.get('textarea[name="congDung"]').clear().type('Giảm đau, hạ sốt, giảm viêm');
    
    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();
    
    // Kiểm tra thông báo thành công
    cy.contains('Thành công').should('be.visible');
    
    // Kiểm tra thông tin đã được cập nhật
    cy.get('button[title="Xem chi tiết"]').first().click();
    cy.contains('8,000đ').should('be.visible');
    cy.contains('Giảm đau, hạ sốt, giảm viêm').should('be.visible');
  });
});
```

#### 2.2.3 Luồng xóa thuốc
Tạo file `cypress/e2e/quan-ly-thuoc/xoa-thuoc.cy.js`:
```javascript
describe('Xóa thuốc', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();
    
    // Chuyển đến trang quản lý thuốc
    cy.visit('/admin/thuoc');
  });
  
  it('Xóa thuốc thành công', () => {
    // Tìm kiếm thuốc cần xóa
    cy.get('input[placeholder="Tìm kiếm..."]').type('Vitamin D3');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Lưu số lượng thuốc ban đầu
    cy.get('table tbody tr').then(($rows) => {
      const initialCount = $rows.length;
      
      // Nhấn nút xóa
      cy.get('button[title="Xóa"]').first().click();
      
      // Xác nhận xóa
      cy.get('button').contains('Có').click();
      
      // Kiểm tra thông báo thành công
      cy.contains('Xóa thành công').should('be.visible');
      
      // Kiểm tra số lượng thuốc đã giảm
      cy.get('table tbody tr').should('have.length', initialCount - 1);
    });
  });
  
  it('Xóa thuốc đã có trong đơn hàng', () => {
    // Tìm kiếm thuốc đã có trong đơn hàng
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Nhấn nút xóa
    cy.get('button[title="Xóa"]').first().click();
    
    // Xác nhận xóa
    cy.get('button').contains('Có').click();
    
    // Kiểm tra thông báo lỗi
    cy.contains('Không thể xóa thuốc đã có trong đơn hàng').should('be.visible');
  });
});
```

#### 2.2.4 Luồng tìm kiếm thuốc
Tạo file `cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc.cy.js`:
```javascript
describe('Tìm kiếm thuốc', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();
    
    // Chuyển đến trang quản lý thuốc
    cy.visit('/admin/thuoc');
  });
  
  it('Tìm kiếm thuốc theo tên', () => {
    // Tìm kiếm thuốc theo tên
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Kiểm tra kết quả tìm kiếm
    cy.contains('Paracetamol').should('be.visible');
  });
  
  it('Tìm kiếm thuốc theo loại thuốc', () => {
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Kiểm tra kết quả tìm kiếm
    cy.contains('Paracetamol').should('be.visible');
  });
  
  it('Tìm kiếm thuốc theo nhà sản xuất', () => {
    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').select('Công ty Dược phẩm ABC');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length.greaterThan', 0);
  });
  
  it('Tìm kiếm thuốc với nhiều tiêu chí', () => {
    // Nhập tên thuốc
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');
    
    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').select('Công ty Dược phẩm ABC');
    
    // Tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();
    
    // Kiểm tra kết quả tìm kiếm
    cy.contains('Paracetamol').should('be.visible');
  });
  
  it('Tìm kiếm thuốc không tồn tại', () => {
    // Tìm kiếm thuốc không tồn tại
    cy.get('input[placeholder="Tìm kiếm..."]').type('XYZ123');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Kiểm tra thông báo không tìm thấy
    cy.contains('Không có dữ liệu').should('be.visible');
  });
});
```

### 2.3 Chạy kiểm thử End-to-End
```bash
cd FE
npx cypress open
```

Hoặc chạy headless:
```bash
cd FE
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/**/*.cy.js"
```

## 3. KIỂM THỬ HIỆU NĂNG (PERFORMANCE TESTING)

### 3.1 Chuẩn bị môi trường

#### 3.1.1 Cài đặt JMeter
1. Tải JMeter từ https://jmeter.apache.org/download_jmeter.cgi
2. Giải nén và chạy `bin/jmeter.bat` (Windows) hoặc `bin/jmeter.sh` (Linux/Mac)

#### 3.1.2 Cấu trúc test plan
```
Test Plan
├── Thread Group (Quản lý thuốc)
│   ├── HTTP Request (Đăng nhập)
│   ├── HTTP Request (Lấy danh sách thuốc)
│   ├── HTTP Request (Tìm kiếm thuốc)
│   ├── HTTP Request (Thêm thuốc mới)
│   ├── HTTP Request (Cập nhật thuốc)
│   └── HTTP Request (Xóa thuốc)
├── Summary Report
└── View Results Tree
```

### 3.2 Tạo test plan trong JMeter

#### 3.2.1 Tạo Thread Group
1. Chuột phải vào Test Plan > Add > Threads (Users) > Thread Group
2. Cấu hình Thread Group:
   - Number of Threads (users): 10
   - Ramp-up period (seconds): 5
   - Loop Count: 5

#### 3.2.2 Tạo HTTP Request cho API đăng nhập
1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Cấu hình HTTP Request:
   - Name: Đăng nhập
   - Method: POST
   - Protocol: http
   - Server Name: localhost
   - Port Number: 8080
   - Path: /api/auth/login
   - Body Data: `{"username":"admin","password":"admin123"}`
   - Content Type: application/json

3. Thêm JSON Extractor để lấy token:
   - Chuột phải vào HTTP Request > Add > Post Processors > JSON Extractor
   - Names of created variables: token
   - JSON Path expressions: $.token

#### 3.2.3 Tạo HTTP Request cho API lấy danh sách thuốc
1. Chuột phải vào Thread Group > Add > Sampler > HTTP Request
2. Cấu hình HTTP Request:
   - Name: Lấy danh sách thuốc
   - Method: POST
   - Protocol: http
   - Server Name: localhost
   - Port Number: 8080
   - Path: /thuoc/search
   - Body Data: `{"keyWord":"","currentPage":0,"size":10}`
   - Content Type: application/json

3. Thêm HTTP Header Manager:
   - Chuột phải vào HTTP Request > Add > Config Element > HTTP Header Manager
   - Add Header:
     - Name: Authorization
     - Value: Bearer ${token}

#### 3.2.4 Tạo HTTP Request cho các API khác
Tương tự, tạo các HTTP Request cho:
- Tìm kiếm thuốc
- Thêm thuốc mới
- Cập nhật thuốc
- Xóa thuốc

#### 3.2.5 Thêm Listener
1. Chuột phải vào Test Plan > Add > Listener > Summary Report
2. Chuột phải vào Test Plan > Add > Listener > View Results Tree

### 3.3 Chạy kiểm thử hiệu năng
1. Lưu Test Plan
2. Nhấn nút "Start" để chạy kiểm thử
3. Xem kết quả trong Summary Report và View Results Tree

### 3.4 Phân tích kết quả
1. Thời gian phản hồi trung bình (Average Response Time)
2. Thông lượng (Throughput)
3. Tỷ lệ lỗi (Error Rate)
4. Thời gian phản hồi tối đa (Max Response Time)

## 4. KIỂM THỬ GIAO DIỆN NGƯỜI DÙNG (UI TESTING)

### 4.1 Kiểm thử giao diện bằng Cypress

#### 4.1.1 Kiểm tra hiển thị danh sách thuốc
```javascript
describe('Kiểm tra giao diện danh sách thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.visit('/admin/thuoc');
  });
  
  it('Hiển thị đúng cấu trúc bảng danh sách thuốc', () => {
    // Kiểm tra tiêu đề trang
    cy.contains('Quản lý thuốc').should('be.visible');
    
    // Kiểm tra các thành phần tìm kiếm
    cy.get('input[placeholder="Tìm kiếm..."]').should('be.visible');
    cy.get('select[name="loaiThuoc"]').should('be.visible');
    cy.get('select[name="nhaSanXuat"]').should('be.visible');
    cy.get('button').contains('Tìm kiếm').should('be.visible');
    cy.get('button').contains('Thêm mới').should('be.visible');
    
    // Kiểm tra cấu trúc bảng
    cy.get('table thead th').should('have.length.at.least', 6);
    cy.contains('th', 'Mã thuốc').should('be.visible');
    cy.contains('th', 'Tên thuốc').should('be.visible');
    cy.contains('th', 'Loại thuốc').should('be.visible');
    cy.contains('th', 'Giá bán').should('be.visible');
    cy.contains('th', 'Số lượng tồn').should('be.visible');
    cy.contains('th', 'Thao tác').should('be.visible');
    
    // Kiểm tra dữ liệu trong bảng
    cy.get('table tbody tr').should('have.length.at.least', 1);
  });
  
  it('Hiển thị đúng phân trang', () => {
    // Kiểm tra phân trang
    cy.get('.p-paginator').should('be.visible');
    cy.get('.p-paginator-current').should('be.visible');
  });
});
```

#### 4.1.2 Kiểm tra hiển thị form thêm/sửa thuốc
```javascript
describe('Kiểm tra giao diện form thêm/sửa thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.visit('/admin/thuoc');
  });
  
  it('Hiển thị đúng form thêm thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();
    
    // Kiểm tra tiêu đề form
    cy.contains('Thêm mới thuốc').should('be.visible');
    
    // Kiểm tra các trường nhập liệu
    cy.get('input[name="tenThuoc"]').should('be.visible');
    cy.get('input[name="maThuoc"]').should('be.visible');
    cy.get('select[name="loaiThuocId"]').should('be.visible');
    cy.get('select[name="nhaSanXuatId"]').should('be.visible');
    cy.get('input[name="donVi"]').should('be.visible');
    cy.get('input[name="giaNhap"]').should('be.visible');
    cy.get('input[name="giaBan"]').should('be.visible');
    cy.get('input[name="soLuongTon"]').should('be.visible');
    cy.get('input[name="nguongCanhBao"]').should('be.visible');
    cy.get('textarea[name="congDung"]').should('be.visible');
    cy.get('textarea[name="huongDanSuDung"]').should('be.visible');
    
    // Kiểm tra các nút
    cy.get('button').contains('Lưu').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });
  
  it('Hiển thị đúng form sửa thuốc', () => {
    // Tìm kiếm thuốc
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();
    
    // Nhấn nút sửa
    cy.get('button[title="Sửa"]').first().click();
    
    // Kiểm tra tiêu đề form
    cy.contains('Cập nhật thuốc').should('be.visible');
    
    // Kiểm tra các trường nhập liệu đã được điền
    cy.get('input[name="tenThuoc"]').should('have.value', 'Paracetamol 500mg');
    cy.get('input[name="maThuoc"]').should('have.value', 'PARA500');
    
    // Kiểm tra các nút
    cy.get('button').contains('Lưu').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });
});
```

### 4.2 Kiểm thử tương thích (Compatibility Testing)

#### 4.2.1 Cấu hình BrowserStack
1. Đăng ký tài khoản BrowserStack
2. Cài đặt BrowserStack CLI:
```bash
npm install -g browserstack-cypress-cli
```

3. Cấu hình BrowserStack:
```bash
browserstack-cypress init
```

4. Chỉnh sửa file `browserstack.json`:
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
      "versions": ["latest", "latest-1"]
    },
    {
      "browser": "firefox",
      "os": "Windows 10",
      "versions": ["latest"]
    },
    {
      "browser": "edge",
      "os": "Windows 10",
      "versions": ["latest"]
    },
    {
      "browser": "safari",
      "os": "OS X Monterey",
      "versions": ["latest"]
    }
  ],
  "run_settings": {
    "cypress_config_file": "cypress.config.js",
    "project_name": "Quản lý thuốc",
    "build_name": "Kiểm thử tương thích",
    "specs": ["cypress/e2e/quan-ly-thuoc/**/*.cy.js"]
  }
}
```

#### 4.2.2 Chạy kiểm thử tương thích
```bash
browserstack-cypress run
```

## 5. THỰC HÀNH KIỂM THỬ HỆ THỐNG

### 5.1 Bài tập thực hành
1. Viết test case end-to-end cho luồng quản lý loại thuốc
2. Viết test case hiệu năng cho API tìm kiếm thuốc với nhiều tiêu chí
3. Viết test case giao diện cho trang chi tiết thuốc

### 5.2 Checklist kiểm thử hệ thống
- [ ] Đã kiểm thử end-to-end cho luồng thêm thuốc
- [ ] Đã kiểm thử end-to-end cho luồng sửa thuốc
- [ ] Đã kiểm thử end-to-end cho luồng xóa thuốc
- [ ] Đã kiểm thử end-to-end cho luồng tìm kiếm thuốc
- [ ] Đã kiểm thử hiệu năng cho các API chính
- [ ] Đã kiểm thử giao diện người dùng
- [ ] Đã kiểm thử tương thích trên các trình duyệt khác nhau
- [ ] Đã kiểm thử các trường hợp thành công
- [ ] Đã kiểm thử các trường hợp thất bại
- [ ] Đã kiểm thử các trường hợp ngoại lệ

## 6. KẾT LUẬN

Kiểm thử hệ thống là bước quan trọng để đảm bảo toàn bộ hệ thống hoạt động đúng theo yêu cầu. Việc triển khai kiểm thử hệ thống cho chức năng Quản lý thuốc giúp phát hiện các vấn đề về luồng nghiệp vụ, hiệu năng, giao diện người dùng và tương thích trên các trình duyệt khác nhau.

Tài liệu này đã cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử hệ thống cho chức năng Quản lý thuốc, bao gồm kiểm thử end-to-end, kiểm thử hiệu năng, kiểm thử giao diện người dùng và kiểm thử tương thích. Bằng cách tuân theo hướng dẫn này, bạn có thể đảm bảo rằng chức năng Quản lý thuốc hoạt động đúng và đáp ứng các yêu cầu về chất lượng.
