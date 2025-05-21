// Import tất cả các test case
import './danh-sach-thuoc-ui-test.cy.js';
import './them-sua-thuoc-ui-test.cy.js';
import './chi-tiet-thuoc-ui-test.cy.js';
import './tim-kiem-thuoc-ui-test.cy.js';
import './responsive-ui-test.cy.js';
import './accessibility-ui-test.cy.js';
import './advanced-ui-test.cy.js';

describe('Chạy tất cả các test case kiểm thử giao diện', () => {
  it('Chạy tất cả các test case', () => {
    // Test case này chỉ để gom nhóm tất cả các test case khác
    cy.log('Đã chạy tất cả các test case kiểm thử giao diện');
  });
});
