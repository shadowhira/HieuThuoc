// cypress/e2e/simple-test.cy.js

describe('Simple Test', () => {
  it('Visits the app root url', () => {
    cy.visit('/');
    cy.contains('h1', 'Welcome').should('be.visible');
  });
});
