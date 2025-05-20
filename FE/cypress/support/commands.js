// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

// Custom command để đăng nhập
Cypress.Commands.add('login', (username, password) => {
  cy.visit('/login');
  cy.get('input[name="username"]').type(username);
  cy.get('input[name="password"]').type(password);
  cy.get('button[type="submit"]').click();
  // Đợi đăng nhập thành công
  cy.url().should('not.include', '/login');
});

// Custom command để kiểm tra tính chính xác của dữ liệu
Cypress.Commands.add('verifyRevenueData', (expectedHoaDon, expectedDonHangTraLai, expectedDoanhThu) => {
  // Kiểm tra số lượng hóa đơn
  if (expectedHoaDon !== null) {
    cy.get('.hoa-don-count').should('contain', expectedHoaDon);
  }
  
  // Kiểm tra số lượng đơn hàng trả lại
  if (expectedDonHangTraLai !== null) {
    cy.get('.don-hang-tra-lai-count').should('contain', expectedDonHangTraLai);
  }
  
  // Kiểm tra tổng doanh thu
  if (expectedDoanhThu !== null) {
    cy.get('.doanh-thu-value').should('contain', expectedDoanhThu);
  }
});

// Custom command để chọn loại báo cáo và thời gian
Cypress.Commands.add('selectReportType', (type, options = {}) => {
  // Chọn loại báo cáo (NGAY, THANG, NAM)
  cy.get(`[data-type="${type}"]`).click();
  
  // Chọn ngày nếu có
  if (options.ngay) {
    cy.get('select.ngay-select').select(options.ngay.toString());
  }
  
  // Chọn tháng nếu có
  if (options.thang) {
    cy.get('select.thang-select').select(options.thang.toString());
  }
  
  // Chọn năm nếu có
  if (options.nam) {
    cy.get('select.nam-select').select(options.nam.toString());
  }
});
