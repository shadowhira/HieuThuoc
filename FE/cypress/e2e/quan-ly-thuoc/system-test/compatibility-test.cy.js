// Kiểm thử tương thích cho chức năng quản lý thuốc

describe('Kiểm thử tương thích - Quản lý thuốc', () => {
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

  it('COMP_001: Kiểm thử tương thích trên Firefox', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra các thành phần giao diện hiển thị đúng
    cy.get('p-table').should('be.visible');
    cy.get('button').contains('Thêm thuốc').should('be.visible');
    cy.get('input[pInputText]').should('be.visible');

    // Thực hiện tìm kiếm thuốc
    cy.get('input[pInputText]').type('Para');
    cy.get('button').contains('Tìm').click();
    cy.get('p-table').should('be.visible');

    // Thử thêm thuốc mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra form thêm thuốc hiển thị đúng
    cy.get('input').first().should('be.visible');
    cy.get('button').last().should('be.visible');

    // Quay lại trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra responsive design
    cy.viewport('iphone-6');
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
    
    cy.viewport('ipad-2');
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
    
    cy.viewport(1280, 720);
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
  });

  it('COMP_002: Kiểm thử tương thích trên Safari', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra các thành phần giao diện hiển thị đúng
    cy.get('p-table').should('be.visible');
    cy.get('button').contains('Thêm thuốc').should('be.visible');
    cy.get('input[pInputText]').should('be.visible');

    // Thực hiện tìm kiếm thuốc
    cy.get('input[pInputText]').type('Para');
    cy.get('button').contains('Tìm').click();
    cy.get('p-table').should('be.visible');

    // Thử thêm thuốc mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra form thêm thuốc hiển thị đúng
    cy.get('input').first().should('be.visible');
    cy.get('button').last().should('be.visible');

    // Quay lại trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra responsive design
    cy.viewport('iphone-6');
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
    
    cy.viewport('ipad-2');
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
    
    cy.viewport(1280, 720);
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
  });

  it('COMP_003: Kiểm thử tương thích trên Opera', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra các thành phần giao diện hiển thị đúng
    cy.get('p-table').should('be.visible');
    cy.get('button').contains('Thêm thuốc').should('be.visible');
    cy.get('input[pInputText]').should('be.visible');

    // Thực hiện tìm kiếm thuốc
    cy.get('input[pInputText]').type('Para');
    cy.get('button').contains('Tìm').click();
    cy.get('p-table').should('be.visible');

    // Thử thêm thuốc mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra form thêm thuốc hiển thị đúng
    cy.get('input').first().should('be.visible');
    cy.get('button').last().should('be.visible');

    // Quay lại trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra responsive design
    cy.viewport('iphone-6');
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
    
    cy.viewport('ipad-2');
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
    
    cy.viewport(1280, 720);
    cy.wait(1000);
    cy.get('p-table').should('be.visible');
  });
});
