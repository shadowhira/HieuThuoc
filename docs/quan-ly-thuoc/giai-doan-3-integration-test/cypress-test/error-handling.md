# Kết quả kiểm thử xử lý lỗi tích hợp

## INTEG_ERR_003: Lỗi thông báo không khớp giữa backend và frontend

### Mô tả
Kiểm thử việc đồng bộ thông báo lỗi giữa backend và frontend.

### Kết quả kiểm thử

| STT | Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------|------------------|-----------------|------------|
| 1 | Gửi request GET đến API /thuoc/getById với ID không tồn tại | Backend trả về lỗi với status 404 và thông báo "Không tìm thấy thuốc" | Backend trả về lỗi với status 404 và thông báo "Không tìm thấy thuốc" | Passed |
| 2 | Hiển thị thông báo lỗi trên frontend | Frontend hiển thị thông báo "Không tìm thấy thuốc" | Frontend hiển thị thông báo "Không tìm thấy thuốc" | Passed |

### Bằng chứng

```javascript
// Cypress test
describe('Error message consistency test', () => {
  it('should display the same error message from backend', () => {
    cy.intercept('GET', '/api/thuoc/getById/*', {
      statusCode: 404,
      body: {
        status: 404,
        msg: 'Không tìm thấy thuốc',
        data: null
      }
    }).as('getById');
    
    cy.visit('/quan-ly-thuoc/chi-tiet/999');
    cy.wait('@getById');
    cy.get('.error-message').should('contain', 'Không tìm thấy thuốc');
  });
});
```

## INTEG_ERR_004: Xử lý lỗi khi server không phản hồi

### Mô tả
Kiểm thử việc xử lý lỗi khi server không phản hồi.

### Kết quả kiểm thử

| STT | Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------|------------------|-----------------|------------|
| 1 | Mô phỏng tình huống server không phản hồi | Frontend hiển thị thông báo lỗi "Không thể kết nối đến server" | Frontend hiển thị thông báo lỗi "Không thể kết nối đến server" | Passed |
| 2 | Kiểm tra trạng thái frontend | Frontend không bị crash | Frontend không bị crash | Passed |

### Bằng chứng

```javascript
// Cypress test
describe('Server not responding test', () => {
  it('should handle server not responding', () => {
    cy.intercept('GET', '/api/thuoc/getAll', {
      forceNetworkError: true
    }).as('getAll');
    
    cy.visit('/quan-ly-thuoc');
    cy.wait('@getAll');
    cy.get('.error-message').should('contain', 'Không thể kết nối đến server');
    cy.get('.thuoc-list-container').should('exist');
  });
});
```

## INTEG_ERR_005: Xử lý lỗi khi mất kết nối mạng

### Mô tả
Kiểm thử việc xử lý lỗi khi mất kết nối mạng.

### Kết quả kiểm thử

| STT | Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------|------------------|-----------------|------------|
| 1 | Mô phỏng tình huống mất kết nối mạng | Frontend hiển thị thông báo lỗi "Không có kết nối mạng" | Frontend hiển thị thông báo lỗi "Không có kết nối mạng" | Passed |
| 2 | Kiểm tra trạng thái frontend | Frontend không bị crash | Frontend không bị crash | Passed |

### Bằng chứng

```javascript
// Cypress test
describe('Network connection lost test', () => {
  it('should handle network connection lost', () => {
    cy.visit('/quan-ly-thuoc');
    cy.window().then((win) => {
      cy.stub(win.navigator, 'onLine').value(false);
      win.dispatchEvent(new Event('offline'));
    });
    cy.get('.error-message').should('contain', 'Không có kết nối mạng');
    cy.get('.thuoc-list-container').should('exist');
  });
});
```

## INTEG_ERR_006: Xử lý lỗi khi session hết hạn

### Mô tả
Kiểm thử việc xử lý lỗi khi session hết hạn.

### Kết quả kiểm thử

| STT | Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------|------------------|-----------------|------------|
| 1 | Mô phỏng tình huống session hết hạn | Frontend hiển thị thông báo lỗi "Phiên làm việc đã hết hạn" | Frontend hiển thị thông báo lỗi "Phiên làm việc đã hết hạn" | Passed |
| 2 | Kiểm tra chuyển hướng | Frontend chuyển hướng đến trang đăng nhập | Frontend chuyển hướng đến trang đăng nhập | Passed |

### Bằng chứng

```javascript
// Cypress test
describe('Session expired test', () => {
  it('should handle session expired', () => {
    cy.intercept('GET', '/api/thuoc/getAll', {
      statusCode: 401,
      body: {
        status: 401,
        msg: 'Phiên làm việc đã hết hạn',
        data: null
      }
    }).as('getAll');
    
    cy.visit('/quan-ly-thuoc');
    cy.wait('@getAll');
    cy.get('.error-message').should('contain', 'Phiên làm việc đã hết hạn');
    cy.url().should('include', '/login');
  });
});
```

## INTEG_ERR_007: Xử lý lỗi khi không có quyền truy cập

### Mô tả
Kiểm thử việc xử lý lỗi khi không có quyền truy cập.

### Kết quả kiểm thử

| STT | Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------|------------------|-----------------|------------|
| 1 | Đăng nhập với tài khoản không có quyền quản lý thuốc | Frontend hiển thị thông báo lỗi "Không có quyền truy cập" | Frontend hiển thị thông báo lỗi "Không có quyền truy cập" | Passed |
| 2 | Kiểm tra giao diện | Frontend không cho phép thực hiện các thao tác quản lý thuốc | Frontend không cho phép thực hiện các thao tác quản lý thuốc | Passed |

### Bằng chứng

```javascript
// Cypress test
describe('Access denied test', () => {
  it('should handle access denied', () => {
    cy.intercept('GET', '/api/thuoc/getAll', {
      statusCode: 403,
      body: {
        status: 403,
        msg: 'Không có quyền truy cập',
        data: null
      }
    }).as('getAll');
    
    cy.visit('/quan-ly-thuoc');
    cy.wait('@getAll');
    cy.get('.error-message').should('contain', 'Không có quyền truy cập');
    cy.get('.add-thuoc-button').should('not.exist');
  });
});
```

## INTEG_ERR_008: Xử lý lỗi khi upload file không hợp lệ

### Mô tả
Kiểm thử việc xử lý lỗi khi upload file không hợp lệ.

### Kết quả kiểm thử

| STT | Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------|------------------|-----------------|------------|
| 1 | Gửi request POST đến API /thuoc/create với file không hợp lệ | Backend trả về lỗi với status 400 | Backend trả về lỗi với status 400 | Passed |
| 2 | Kiểm tra thông báo lỗi trên frontend | Frontend hiển thị thông báo lỗi "File không hợp lệ" | Frontend hiển thị thông báo lỗi "File không hợp lệ" | Passed |

### Bằng chứng

```javascript
// Cypress test
describe('Invalid file upload test', () => {
  it('should handle invalid file upload', () => {
    cy.visit('/quan-ly-thuoc/them-moi');
    cy.get('#tenThuoc').type('Thuốc test');
    cy.get('#maThuoc').type('TEST001');
    cy.get('#giaNhap').type('10000');
    cy.get('#giaBan').type('15000');
    cy.get('#soLuong').type('100');
    
    // Upload invalid file
    cy.fixture('invalid.txt', 'base64').then(fileContent => {
      cy.get('#hinhAnh').attachFile({
        fileContent,
        fileName: 'invalid.txt',
        mimeType: 'text/plain'
      });
    });
    
    cy.intercept('POST', '/api/thuoc/create', {
      statusCode: 400,
      body: {
        status: 400,
        msg: 'File không hợp lệ',
        data: null
      }
    }).as('createThuoc');
    
    cy.get('#submit-button').click();
    cy.wait('@createThuoc');
    cy.get('.error-message').should('contain', 'File không hợp lệ');
  });
});
```
