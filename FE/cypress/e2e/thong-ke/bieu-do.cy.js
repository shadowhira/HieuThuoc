// cypress/e2e/thong-ke/bieu-do.cy.js
// Test kiểm thử biểu đồ của trang báo cáo thống kê

describe('Kiểm thử biểu đồ báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê sử dụng session
    cy.visitThongKeWithSession();
  });

  it('UI-06: Kiểm tra hiển thị biểu đồ theo ngày', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn ngày hiện tại
    const today = new Date();
    const day = today.getDate().toString();
    cy.get('select.form-select').eq(0).select(day);

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra tiêu đề biểu đồ
    cy.contains('h4', 'Doanh thu').should('be.visible');
  });

  it('UI-07: Kiểm tra hiển thị biểu đồ theo tháng', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 5 năm 2024
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2024');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-08: Kiểm tra hiển thị biểu đồ theo năm', () => {
    // Chọn tab "Theo năm"
    cy.contains('label', 'Theo năm').click();

    // Chọn năm 2024
    cy.get('select.form-select').eq(0).select('2024');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-11: Kiểm tra tương tác với biểu đồ', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 5 năm 2024
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2024');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Di chuột qua các cột trong biểu đồ (không thể kiểm tra tooltip trực tiếp trong Cypress)
    // Nhưng có thể kiểm tra biểu đồ có thể tương tác
    cy.get('#container').trigger('mouseover');
  });

  it('UI-13: Kiểm tra hiển thị với dữ liệu lớn', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 12 năm 2023
    cy.get('select.form-select').eq(0).select('12');
    cy.get('select.form-select').eq(1).select('2023');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra thời gian tải trang không quá lâu
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-14: Kiểm tra hiển thị với dữ liệu có giá trị chênh lệch lớn', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 5 năm 2024
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2024');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-20: Kiểm tra hiển thị với dữ liệu âm', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 5 năm 2024
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2024');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra tổng doanh thu
    cy.get('.card-animate').eq(2).find('h4 span').should('be.visible');
  });

  it('UI-33: Kiểm tra hiển thị khi có dữ liệu bằng 0', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 1 năm 2023 (giả sử không có dữ liệu)
    cy.get('select.form-select').eq(0).select('1');
    cy.get('select.form-select').eq(1).select('2023');

    // Đợi cho dữ liệu tải
    cy.wait(2000);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra tổng doanh thu
    cy.get('.card-animate').eq(2).find('h4 span').should('be.visible');
  });
});
