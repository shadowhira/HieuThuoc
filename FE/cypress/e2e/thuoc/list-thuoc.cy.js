describe('Hiển thị danh sách thuốc', () => {
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

  it('Hiển thị danh sách thuốc thành công', () => {
    // Kiểm tra tiêu đề trang
    cy.get('h4').should('be.visible');

    // Kiểm tra bảng danh sách thuốc
    cy.get('p-table').should('exist');
    cy.get('tr').should('have.length.greaterThan', 1);

    // Kiểm tra các cột trong bảng
    cy.get('th').should('have.length.at.least', 3);

    // Kiểm tra có dữ liệu trong bảng
    cy.get('tr').should('have.length.at.least', 1);
  });
});
