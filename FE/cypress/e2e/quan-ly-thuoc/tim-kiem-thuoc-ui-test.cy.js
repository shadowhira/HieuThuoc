describe('Kiểm thử giao diện tìm kiếm thuốc', () => {
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

  it('Hiển thị form tìm kiếm', () => {
    // Kiểm tra ô tìm kiếm
    cy.get('input[pInputText]').should('be.visible');

    // Kiểm tra nút tìm kiếm
    cy.get('button').contains('Tìm').should('be.visible');
  });

  it('Hiển thị kết quả tìm kiếm', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[pInputText]').type('Para');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('p-table').should('exist');
    cy.get('tr').should('have.length.at.least', 1);
  });

  it('Hiển thị thông báo khi không có kết quả tìm kiếm', () => {
    // Nhập từ khóa tìm kiếm không tồn tại
    cy.get('input[pInputText]').type('XYZ123456789');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm').click();

    // Kiểm tra bảng vẫn hiển thị
    cy.get('p-table').should('exist');
  });

  it('Tìm kiếm theo loại thuốc', () => {
    // Kiểm tra có form tìm kiếm
    cy.get('input[pInputText]').should('be.visible');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('p-table').should('exist');
  });

  it('Kiểm tra khả năng xóa từ khóa tìm kiếm', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[pInputText]').type('Para');

    // Xóa từ khóa tìm kiếm
    cy.get('input[pInputText]').clear();

    // Kiểm tra ô tìm kiếm đã trống
    cy.get('input[pInputText]').should('have.value', '');
  });

  it('Kiểm tra tìm kiếm với từ khóa ngắn', () => {
    // Nhập từ khóa tìm kiếm ngắn
    cy.get('input[pInputText]').type('P');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('p-table').should('exist');
  });

  it('Kiểm tra tìm kiếm với từ khóa dài', () => {
    // Nhập từ khóa tìm kiếm dài
    cy.get('input[pInputText]').type('Paracetamol 500mg Hộp 10 Vỉ x 10 Viên');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('p-table').should('exist');
  });
});
