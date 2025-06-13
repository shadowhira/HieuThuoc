// ***********************************************************
// This example support/e2e.js is processed and
// loaded automatically before your test files.
//
// This is a great place to put global configuration and
// behavior that modifies Cypress.
//
// You can change the location of this file or turn off
// automatically serving support files with the
// 'supportFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/configuration
// ***********************************************************

// Import commands.js using ES2015 syntax:
import './commands';
import './commands-thongke';
import './session-commands';

// Alternatively you can use CommonJS syntax:
// require('./commands')

// Xử lý ngoại lệ không bắt được từ ứng dụng
Cypress.on('uncaught:exception', (err, runnable) => {
  // Trả về false để ngăn Cypress fail test khi có lỗi không bắt được từ ứng dụng
  console.log('Uncaught exception:', err.message);
  return false;
});

// Hide fetch/XHR requests in the command log
const app = window.top;
if (!app.document.head.querySelector('[data-hide-command-log-request]')) {
  const style = app.document.createElement('style');
  style.innerHTML =
    '.command-name-request, .command-name-xhr { display: none }';
  style.setAttribute('data-hide-command-log-request', '');
  app.document.head.appendChild(style);
}
