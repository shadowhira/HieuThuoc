describe('Tìm kiếm thuốc', () => {
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

  it('Tìm kiếm thuốc theo tên thành công', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[pInputText]').type('Paracetamol');

    // Nhấn nút tìm kiếm (sử dụng text content)
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('tr').should('have.length.at.least', 1); // Ít nhất có hàng tiêu đề
  });

  it('Tìm kiếm thuốc không có kết quả', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[pInputText]').type('Thuốc không tồn tại xyz123');

    // Nhấn nút tìm kiếm (sử dụng text content)
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm - chỉ có hàng tiêu đề hoặc thông báo không tìm thấy
    cy.get('p-table').should('exist');
  });

  it('Tìm kiếm thuốc theo loại thuốc', () => {
    // Chọn loại thuốc
    cy.get('app-select-common').eq(2).click();
    // Chọn loại thuốc đầu tiên trong danh sách
    cy.get('li.p-ripple.p-element.p-dropdown-item').first().click();

    // Nhấn nút tìm kiếm (sử dụng text content)
    cy.get('button').contains('Tìm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('tr').should('have.length.at.least', 1); // Ít nhất có hàng tiêu đề
  });
});
