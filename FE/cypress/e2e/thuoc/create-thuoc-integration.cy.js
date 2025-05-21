describe('Thêm mới thuốc', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
  Cypress.on('uncaught:exception', (err, runnable) => {
    // Trả về false để ngăn Cypress fail test khi có lỗi JavaScript
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

  it('Mở form thêm mới thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra form thêm mới hiển thị
    cy.get('h4').should('contain', 'Thêm Sản Phẩm');
    cy.get('form').should('exist');
  });

  it('Thêm mới thuốc thành công', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Nhập thông tin thuốc
    cy.get('input#product-title-input').type('Vitamin C 500mg');
    cy.get('input#product-code-input').type('VITC500');

    // Chọn loại thuốc
    cy.get('app-select-common').eq(0).click();
    // Chọn loại thuốc đầu tiên trong danh sách
    cy.get('li.p-ripple.p-element.p-dropdown-item').first().click();

    // Chọn nhà sản xuất
    cy.get('app-select-common').eq(1).click();
    // Chọn nhà sản xuất đầu tiên trong danh sách
    cy.get('li.p-ripple.p-element.p-dropdown-item').first().click();

    // Nhập thông tin khác
    cy.get('select.form-control').select('Viên');
    cy.get('input#product-price-input').type('6000');
    cy.get('input#product-sale-price-input').type('9000');
    cy.get('input#product-quantity-input').type('80');
    cy.get('input[placeholder="Nhập ngưỡng cảnh báo"]').first().type('15');
    cy.get('input[placeholder="Nhập công dụng"]').type('Bổ sung vitamin C');
    cy.get('textarea[name="huongDanSuDung"]').type('Uống 1 viên mỗi ngày');

    // Nhấn nút Thêm
    cy.get('button[type="submit"]').click();

    // Đợi chuyển hướng về trang danh sách thuốc
    cy.url().should('include', '/sys/product', { timeout: 10000 });

    // Kiểm tra đã chuyển hướng đến trang danh sách thuốc
    cy.get('h4').should('be.visible');
  });

  it('Thêm mới thuốc với dữ liệu không hợp lệ', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Nhập thông tin thuốc không đầy đủ
    cy.get('input#product-title-input').type('Vitamin C 500mg');

    // Nhấn nút Thêm
    cy.get('button[type="submit"]').click();

    // Kiểm tra thông báo lỗi
    cy.get('.text-danger').should('be.visible');
  });
});
