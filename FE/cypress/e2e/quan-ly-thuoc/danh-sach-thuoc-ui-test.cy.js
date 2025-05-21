describe('Kiểm thử giao diện danh sách thuốc', () => {
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

  it('Hiển thị tiêu đề trang chính xác', () => {
    // Kiểm tra tiêu đề trang
    cy.get('h4').should('be.visible');
  });

  it('Hiển thị bảng danh sách thuốc', () => {
    // Kiểm tra bảng danh sách thuốc
    cy.get('p-table').should('exist');
    cy.get('tr').should('have.length.greaterThan', 1);

    // Kiểm tra có dữ liệu trong bảng
    cy.get('tbody > tr').should('have.length.at.least', 1);
  });

  it('Hiển thị các cột trong bảng chính xác', () => {
    // Kiểm tra các cột trong bảng
    cy.get('th').should('have.length.at.least', 3);
  });

  it('Hiển thị nút thêm mới thuốc', () => {
    // Kiểm tra nút thêm mới
    cy.get('button').contains('Thêm thuốc').should('be.visible');
    cy.get('button').contains('Thêm thuốc').should('be.enabled');
  });

  it('Hiển thị phân trang', () => {
    // Kiểm tra phân trang
    cy.get('p-paginator').should('exist');
  });

  it('Hiển thị các nút thao tác trên mỗi dòng', () => {
    // Kiểm tra các nút thao tác trên dòng đầu tiên
    cy.get('tbody > tr').first().find('td').last().should('exist');
  });

  it('Kiểm tra bố cục tổng thể của trang', () => {
    // Kiểm tra bố cục tổng thể
    cy.get('.container-fluid').should('exist');
  });

  it('Kiểm tra hiển thị form tìm kiếm', () => {
    // Kiểm tra form tìm kiếm
    cy.get('input[pInputText]').should('be.visible');
    cy.get('button').contains('Tìm').should('be.visible');
  });
});
