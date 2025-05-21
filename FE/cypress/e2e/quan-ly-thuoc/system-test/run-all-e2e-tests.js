// Import tất cả các test case End-to-End
import './e2e-them-thuoc.cy.js';
import './e2e-sua-thuoc.cy.js';
import './e2e-xoa-thuoc.cy.js';

describe('Chạy tất cả các test case End-to-End', () => {
  it('Chạy tất cả các test case', () => {
    // Test case này chỉ để gom nhóm tất cả các test case khác
    cy.log('Đã chạy tất cả các test case End-to-End');
  });
});
