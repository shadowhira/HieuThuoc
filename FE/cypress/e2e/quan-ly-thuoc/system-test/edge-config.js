// Cấu hình Cypress cho trình duyệt Edge
// File này được sử dụng để cấu hình Cypress chạy trên trình duyệt Edge

const { defineConfig } = require('cypress');

module.exports = defineConfig({
  e2e: {
    baseUrl: 'http://localhost:4200',
    specPattern: 'cypress/e2e/quan-ly-thuoc/**/*.cy.js',
    supportFile: 'cypress/support/e2e.js',
    viewportWidth: 1280,
    viewportHeight: 720,
    video: true,
    screenshotOnRunFailure: true,
    browser: 'edge',
  },
});
