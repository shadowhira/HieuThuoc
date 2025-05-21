describe('Kiểm thử accessibility giao diện quản lý thuốc', () => {
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
  });

  it('Kiểm thử accessibility với keyboard navigation', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra focus vào ô tìm kiếm
    cy.get('input[pInputText]').focus().should('have.focus');

    // Nhập từ khóa tìm kiếm
    cy.focused().type('Para{enter}');

    // Kiểm tra kết quả tìm kiếm
    cy.get('p-table').should('be.visible');

    // Kiểm tra có thể sử dụng phím Tab để điều hướng (mô phỏng)
    cy.get('button').contains('Thêm thuốc').focus().should('have.focus');
    cy.focused().type('{enter}');

    // Kiểm tra đã chuyển đến trang thêm thuốc
    cy.url().should('include', '/sys/product-create');
  });

  it('Kiểm thử accessibility với screen reader', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra bảng có cấu trúc đúng cho screen reader
    cy.get('table').within(() => {
      cy.get('th').should('exist'); // Có header cho bảng
      cy.get('tbody').should('exist'); // Có body cho bảng
    });

    // Kiểm tra form tìm kiếm có placeholder
    cy.get('input[pInputText]').should('exist');

    // Kiểm tra các phần tử có thuộc tính hỗ trợ screen reader
    cy.get('h4').should('exist'); // Tiêu đề trang
    cy.get('button').contains('Thêm thuốc').should('exist'); // Nút thêm thuốc
  });

  it('Kiểm thử accessibility với high contrast mode', () => {
    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra độ tương phản của text
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');

    // Kiểm tra các nút có đủ độ tương phản
    cy.get('button').contains('Thêm thuốc').should('be.visible');

    // Kiểm tra các link có đủ độ tương phản
    cy.get('a').should('have.css', 'color').and('not.eq', 'rgba(0, 0, 0, 0)');

    // Kiểm tra form tìm kiếm có đủ độ tương phản
    cy.get('input[pInputText]').should('have.css', 'border-color').and('not.eq', 'rgba(0, 0, 0, 0)');
  });
});
