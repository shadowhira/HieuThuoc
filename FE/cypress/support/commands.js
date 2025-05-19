// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************

// Lệnh đăng nhập
Cypress.Commands.add('login', (username, password) => {
  cy.visit('/login');
  cy.get('input#username').type(username);
  cy.get('input#password-input').type(password || '123456');
  cy.get('button[type="submit"]').click();
  cy.url().should('include', '/home');
});

// Lệnh chuyển đến trang quản lý thuốc
Cypress.Commands.add('navigateToThuocPage', () => {
  cy.visit('/admin/thuoc');
  cy.contains('Quản lý thuốc').should('be.visible');
});

// Lệnh kiểm tra thông báo
Cypress.Commands.add('checkToast', (message) => {
  cy.get('.p-toast-message').should('be.visible');
  cy.get('.p-toast-message').should('contain', message);
});

// Lệnh chờ API hoàn thành
Cypress.Commands.add('waitForApi', (method, url) => {
  cy.intercept(method, url).as('apiCall');
  cy.wait('@apiCall');
});
