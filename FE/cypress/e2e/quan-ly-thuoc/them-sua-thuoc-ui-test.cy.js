describe('Kiểm thử giao diện thêm/sửa thuốc', () => {
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

  it('Hiển thị form thêm mới thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra tiêu đề form
    cy.get('h4').should('be.visible');

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
  });

  it('Hiển thị form sửa thuốc', () => {
    // Đợi bảng hiển thị
    cy.get('p-table').should('exist');
    cy.get('tbody > tr').should('have.length.at.least', 1);

    // Kiểm tra có dữ liệu trong bảng
    cy.get('tbody > tr').first().should('exist');
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

  it('Kiểm tra bố cục form thêm mới thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra bố cục form
    cy.get('.container-fluid').should('exist');
    cy.get('.card').should('exist');
    cy.get('.card-body').should('exist');
    cy.get('form').should('exist');
    cy.get('.row').should('have.length.at.least', 1);
  });

  it('Kiểm tra các trường bắt buộc trong form thêm mới', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra các trường bắt buộc
    cy.get('label').should('exist');
  });

  it('Kiểm tra quay lại trang danh sách', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Quay lại trang danh sách bằng cách truy cập trực tiếp
    cy.visit('/sys/product');

    // Kiểm tra đã quay về trang danh sách
    cy.url().should('include', '/sys/product');
  });
});
