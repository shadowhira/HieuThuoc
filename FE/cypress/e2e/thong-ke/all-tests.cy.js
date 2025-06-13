// cypress/e2e/thong-ke/all-tests.cy.js
// Test tổng hợp tất cả các test case cho trang báo cáo thống kê

describe('Kiểm thử tổng hợp báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê sử dụng session
    cy.visitThongKeWithSession();
  });

  it('UI-01: Kiểm tra hiển thị tổng quan ban đầu của giao diện thống kê', () => {
    // Kiểm tra hiển thị 3 ô tổng quan
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');

    // Kiểm tra hiển thị biểu đồ doanh thu
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra hiển thị các tab lọc
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Kiểm tra hiển thị dropdown chọn tháng và năm
    cy.get('select.form-select').should('have.length.at.least', 1);
  });

  it('UI-02: Kiểm tra hiển thị số liệu tổng quan', () => {
    // Kiểm tra hiển thị số lượng hóa đơn
    cy.get('.card-animate').eq(0).find('h4 span').should('be.visible');

    // Kiểm tra hiển thị số lượng đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('h4 span').should('be.visible');

    // Kiểm tra hiển thị tổng doanh thu
    cy.get('.card-animate').eq(2).find('h4 span').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', 'VNĐ');
  });

  it('UI-03: Kiểm tra chuyển đổi giữa các tab thời gian (ngày/tháng/năm)', () => {
    // Kiểm tra tab "Theo ngày" được chọn mặc định
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('be.checked');

    // Chuyển sang tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    cy.contains('label', 'Theo tháng').find('input[type="radio"]').should('be.checked');

    // Chuyển sang tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    cy.contains('label', 'Theo năm').find('input[type="radio"]').should('be.checked');

    // Chuyển lại tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('be.checked');
  });

  it('UI-04: Kiểm tra bộ lọc tháng', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 5
    cy.get('select.form-select').eq(0).select('5');
    cy.wait(1000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-05: Kiểm tra bộ lọc năm', () => {
    // Chọn tab "Theo năm"
    cy.contains('label', 'Theo năm').click();

    // Chọn năm 2024
    cy.get('select.form-select').eq(0).select('2024');
    cy.wait(1000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-06: Kiểm tra hiển thị biểu đồ theo ngày', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn ngày, tháng, năm
    cy.get('select.form-select').eq(0).select('15');
    cy.get('select.form-select').eq(1).select('5');
    cy.get('select.form-select').eq(2).select('2024');
    cy.wait(1000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-07: Kiểm tra hiển thị biểu đồ theo tháng', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 5 năm 2024
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2024');
    cy.wait(1000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-08: Kiểm tra hiển thị biểu đồ theo năm', () => {
    // Chọn tab "Theo năm"
    cy.contains('label', 'Theo năm').click();

    // Chọn năm 2024
    cy.get('select.form-select').eq(0).select('2024');
    cy.wait(1000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-10: Kiểm tra tính responsive của giao diện', () => {
    // Kiểm tra trên màn hình desktop
    cy.viewport(1920, 1080);
    cy.wait(1000);
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra trên màn hình tablet
    cy.viewport(768, 1024);
    cy.wait(1000);
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra trên màn hình mobile
    cy.viewport(375, 667);
    cy.wait(1000);
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-15: Kiểm tra hiển thị các icon trong ô tổng quan', () => {
    // Kiểm tra icon trong ô Hóa đơn
    cy.get('.card-animate').eq(0).find('.avatar-title i').should('be.visible');

    // Kiểm tra icon trong ô Đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('.avatar-title i').should('be.visible');

    // Kiểm tra icon trong ô Doanh thu
    cy.get('.card-animate').eq(2).find('.avatar-title i').should('be.visible');
  });
});
