// Import tất cả các test case End-to-End
import './e2e-them-thuoc.cy.js';
import './e2e-sua-thuoc.cy.js';
import './e2e-xoa-thuoc.cy.js';

// Import tất cả các test case bảo mật
import './security-test.cy.js';

// Import tất cả các test case khả năng chịu lỗi
import './fault-tolerance-test.cy.js';

// Import tất cả các test case tương thích
import './compatibility-test.cy.js';

describe('Chạy tất cả các test case kiểm thử hệ thống', () => {
  it('Chạy tất cả các test case', () => {
    // Test case này chỉ để gom nhóm tất cả các test case khác
    cy.log('Đã chạy tất cả các test case kiểm thử hệ thống');
  });
});
