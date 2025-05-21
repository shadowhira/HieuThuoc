describe('Kiểm thử tính responsive của giao diện', () => {
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

  it('Hiển thị đúng trên màn hình desktop', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra hiển thị của các thành phần
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');
    cy.get('p-paginator').should('be.visible');

    // Kiểm tra bố cục
    cy.get('body').should('exist');
  });

  it('Hiển thị đúng trên màn hình tablet', () => {
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra hiển thị của các thành phần
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');
    cy.get('p-paginator').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Kiểm tra hiển thị của các thành phần
    cy.get('h4').should('be.visible');
    cy.get('p-table').should('be.visible');
    cy.get('p-paginator').should('be.visible');
  });

  it('Kiểm tra form thêm mới thuốc trên màn hình desktop', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra hiển thị form
    cy.get('h4').should('be.visible');
    cy.get('form').should('be.visible');
    cy.get('input#product-title-input').should('be.visible');
  });

  it('Kiểm tra form thêm mới thuốc trên màn hình tablet', () => {
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra hiển thị form
    cy.get('h4').should('be.visible');
    cy.get('form').should('be.visible');
    cy.get('input#product-title-input').should('be.visible');
  });

  it('Kiểm tra form thêm mới thuốc trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');

    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm thuốc').click();
    cy.url().should('include', '/sys/product-create');

    // Kiểm tra hiển thị form
    cy.get('h4').should('be.visible');
    cy.get('form').should('be.visible');
    cy.get('input#product-title-input').should('be.visible');
  });

  it('Kiểm tra trang chi tiết thuốc trên các kích thước màn hình', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);

    // Truy cập trực tiếp trang chi tiết sản phẩm (giả định ID = 1)
    cy.visit('/sys/product-detail/1');

    // Kiểm tra hiển thị trang chi tiết
    cy.get('h4').should('be.visible');

    // Kiểm tra trên tablet
    cy.viewport(768, 1024);
    cy.get('h4').should('be.visible');

    // Kiểm tra trên mobile
    cy.viewport(375, 667);
    cy.get('h4').should('be.visible');
  });
});
