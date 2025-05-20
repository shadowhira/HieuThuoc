@echo off
echo Running UI tests for Revenue Dashboard...
npx cypress run --spec "cypress/e2e/revenue-dashboard.cy.js"
echo Test execution completed.
pause
