// cypress/e2e/bao-cao-thong-ke/responsive.cy.js
// Test kiểm tra tính responsive của trang báo cáo thống kê

describe('Báo cáo thống kê - Responsive', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('Hiển thị đúng trên màn hình desktop', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1920, 1080);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra các thẻ thông tin hiển thị theo hàng ngang
    cy.get('.card-animate').should('have.length', 3);

    // Chụp ảnh màn hình desktop
    cy.screenshot('desktop-view');
  });

  it('Hiển thị đúng trên màn hình tablet', () => {
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra các thẻ thông tin hiển thị phù hợp
    cy.get('.card-animate').should('have.length', 3);

    // Chụp ảnh màn hình tablet
    cy.screenshot('tablet-view');
  });

  it('Hiển thị đúng trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra các thẻ thông tin hiển thị phù hợp
    cy.get('.card-animate').should('have.length', 3);

    // Chụp ảnh màn hình mobile
    cy.screenshot('mobile-view');
  });

  it('Kiểm tra bộ lọc thời gian hiển thị đúng trên các kích thước màn hình', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1920, 1080);

    // Kiểm tra bộ lọc hiển thị
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);

    // Kiểm tra bộ lọc hiển thị
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);

    // Kiểm tra bộ lọc hiển thị
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');
  });

  it('Kiểm tra biểu đồ thay đổi kích thước phù hợp với màn hình', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1920, 1080);

    // Lấy kích thước biểu đồ trên desktop
    cy.get('#container').then(($container) => {
      const desktopWidth = $container.width();

      // Thiết lập kích thước màn hình tablet
      cy.viewport(768, 1024);

      // Lấy kích thước biểu đồ trên tablet
      cy.get('#container').then(($tabletContainer) => {
        const tabletWidth = $tabletContainer.width();

        // Kiểm tra kích thước biểu đồ trên tablet nhỏ hơn desktop
        expect(tabletWidth).to.be.lessThan(desktopWidth);

        // Thiết lập kích thước màn hình mobile
        cy.viewport(375, 667);

        // Lấy kích thước biểu đồ trên mobile
        cy.get('#container').then(($mobileContainer) => {
          const mobileWidth = $mobileContainer.width();

          // Kiểm tra kích thước biểu đồ trên mobile nhỏ hơn tablet
          expect(mobileWidth).to.be.lessThan(tabletWidth);
        });
      });
    });
  });
});
