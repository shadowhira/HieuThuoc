// cypress/support/session-commands.js
// Custom commands để lưu trữ session đăng nhập

// Cấu hình Cypress để lưu trữ session
Cypress.Commands.add('loginAndSaveSession', (username = 'admin', password = '123456') => {
  // Đăng nhập trực tiếp mà không sử dụng session
  cy.visit('/login');
  cy.get('#username').should('be.visible').clear().type(username);
  cy.get('#password-input').should('be.visible').clear().type(password);
  cy.get('button.btn-success').contains('Đăng nhập').should('be.visible').click();
  cy.url({ timeout: 10000 }).should('not.include', '/login');
  cy.wait(2000); // Đợi để đảm bảo đăng nhập hoàn tất
});

// Custom command để truy cập trang thống kê với đăng nhập
Cypress.Commands.add('visitThongKeWithSession', () => {
  // Đăng nhập
  cy.loginAndSaveSession();

  // Truy cập trang thống kê
  cy.visit('/sys/thongke', { timeout: 10000 });

  // Đợi cho trang tải xong
  cy.get('.page-content', { timeout: 15000 }).should('be.visible');

  // Thêm độ trễ để đảm bảo trang đã tải hoàn toàn
  cy.wait(2000);
});
