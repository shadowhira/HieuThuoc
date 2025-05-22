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

// Thêm command tab để hỗ trợ kiểm tra tab navigation
Cypress.Commands.add('tab', { prevSubject: 'element' }, (subject, options = {}) => {
  const tabKey = options.shift ? '{shift}{tab}' : '{tab}';
  return cy.wrap(subject).type(tabKey);
});

// Thêm command để kiểm tra đăng nhập
Cypress.Commands.add('login', (username, password) => {
  cy.visit('/dang-nhap');
  cy.get('input[name="tenDangNhap"]').type(username);
  cy.get('input[name="matKhau"]').type(password);
  cy.get('button[type="submit"]').click();
});

// Thêm command để tạo tài khoản ngẫu nhiên
Cypress.Commands.add('createRandomAccount', () => {
  const randomNum = Math.floor(Math.random() * 10000);
  const username = `testuser${randomNum}`;
  const email = `test${randomNum}@example.com`;
  
  return {
    hoTen: 'Nguyễn Văn Test',
    email: email,
    soDienThoai: '0987654321',
    tenDangNhap: username,
    matKhau: 'password123'
  };
});
