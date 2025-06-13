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

// Custom command để đăng nhập bằng UI và truy cập trang thống kê
Cypress.Commands.add('loginUI', (username = 'admin', password = '123456') => {
  cy.visit('/login');
  cy.get('#username').should('be.visible').clear().type(username);
  cy.get('#password-input').should('be.visible').clear().type(password);
  cy.get('button.btn-success').contains('Đăng nhập').should('be.visible').click();
  cy.url().should('not.include', '/login');
  cy.wait(2000); // Đợi để đảm bảo đăng nhập hoàn tất
});

// Custom command để truy cập trang thống kê sau khi đăng nhập
Cypress.Commands.add('visitThongKe', () => {
  // Kiểm tra xem đã đăng nhập chưa
  cy.window().then((win) => {
    // Nếu chưa đăng nhập, thực hiện đăng nhập
    if (!win.localStorage.getItem('token')) {
      cy.loginUI();
    }
  });

  // Truy cập trang thống kê
  cy.visit('/sys/thongke');

  // Đợi cho trang tải xong
  cy.get('.page-content', { timeout: 10000 }).should('be.visible');
});
