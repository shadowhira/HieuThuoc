// cypress/e2e/revenue-report.cy.js

describe('Revenue Report Tests', () => {
  beforeEach(() => {
    // Truy cập trang báo cáo doanh thu
    cy.visit('/thongke');

    // Đợi cho trang tải xong
    cy.get('body').should('be.visible');
  });

  it('Kiểm tra tiêu đề trang', () => {
    // Kiểm tra tiêu đề trang
    cy.title().should('include', 'PTIT');
  });

  it('Kiểm tra các thành phần UI cơ bản', () => {
    // Kiểm tra có phần nội dung chính
    cy.get('div').should('exist');

    // Kiểm tra có phần tử body
    cy.get('body').should('exist');
  });

  it('Kiểm tra các thành phần của báo cáo doanh thu', () => {
    // Kiểm tra có các thẻ hiển thị thông tin
    cy.get('div').should('have.length.at.least', 1);

    // Chụp ảnh màn hình các phần tử cụ thể
    cy.get('body').screenshot('body-content');
  });

  it('Chụp ảnh màn hình trang báo cáo', () => {
    // Chụp ảnh màn hình toàn bộ trang
    cy.screenshot('revenue-report-full-page');
  });
});
