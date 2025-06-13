// cypress/e2e/thong-ke/responsive-tests.cy.js
// Test kiểm thử tính responsive của trang báo cáo thống kê

describe('Kiểm thử tính responsive của báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê
    cy.visitThongKe();
  });

  it('UI-10: Kiểm tra tính responsive của giao diện trên desktop', () => {
    // Kiểm tra trên màn hình desktop
    cy.viewport(1920, 1080);
    
    // Kiểm tra hiển thị các thành phần chính
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra layout
    cy.get('.card-animate').should('have.length', 3);
    cy.get('.card-animate').eq(0).should('be.visible');
    cy.get('.card-animate').eq(1).should('be.visible');
    cy.get('.card-animate').eq(2).should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('responsive-desktop');
  });

  it('UI-10: Kiểm tra tính responsive của giao diện trên tablet', () => {
    // Kiểm tra trên màn hình tablet
    cy.viewport(768, 1024);
    
    // Kiểm tra hiển thị các thành phần chính
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra layout
    cy.get('.card-animate').should('have.length', 3);
    cy.get('.card-animate').eq(0).should('be.visible');
    cy.get('.card-animate').eq(1).should('be.visible');
    cy.get('.card-animate').eq(2).should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('responsive-tablet');
  });

  it('UI-10: Kiểm tra tính responsive của giao diện trên mobile', () => {
    // Kiểm tra trên màn hình mobile
    cy.viewport(375, 667);
    
    // Kiểm tra hiển thị các thành phần chính
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra layout
    cy.get('.card-animate').should('have.length', 3);
    cy.get('.card-animate').eq(0).should('be.visible');
    cy.get('.card-animate').eq(1).should('be.visible');
    cy.get('.card-animate').eq(2).should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('responsive-mobile');
  });

  it('UI-10: Kiểm tra tính responsive của giao diện khi thay đổi kích thước', () => {
    // Kiểm tra khi thay đổi kích thước từ lớn đến nhỏ
    
    // Desktop
    cy.viewport(1920, 1080);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('responsive-resize-desktop');
    
    // Tablet
    cy.viewport(768, 1024);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('responsive-resize-tablet');
    
    // Mobile
    cy.viewport(375, 667);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('responsive-resize-mobile');
  });

  it('UI-10: Kiểm tra tính responsive của biểu đồ', () => {
    // Kiểm tra biểu đồ trên các kích thước màn hình khác nhau
    
    // Desktop
    cy.viewport(1920, 1080);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.get('#container').screenshot('chart-desktop');
    
    // Tablet
    cy.viewport(768, 1024);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.get('#container').screenshot('chart-tablet');
    
    // Mobile
    cy.viewport(375, 667);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.get('#container').screenshot('chart-mobile');
  });

  it('UI-10: Kiểm tra tính responsive của bộ lọc', () => {
    // Kiểm tra bộ lọc trên các kích thước màn hình khác nhau
    
    // Desktop
    cy.viewport(1920, 1080);
    cy.wait(1000);
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');
    cy.screenshot('filters-desktop');
    
    // Tablet
    cy.viewport(768, 1024);
    cy.wait(1000);
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');
    cy.screenshot('filters-tablet');
    
    // Mobile
    cy.viewport(375, 667);
    cy.wait(1000);
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');
    cy.screenshot('filters-mobile');
  });

  it('UI-32: Kiểm tra hiển thị khi phóng to/thu nhỏ trang (zoom)', () => {
    // Kiểm tra với các mức zoom khác nhau
    
    // Zoom 75%
    cy.viewport(1280 * 0.75, 720 * 0.75);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('zoom-75-percent');
    
    // Zoom 100%
    cy.viewport(1280, 720);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('zoom-100-percent');
    
    // Zoom 125%
    cy.viewport(1280 * 1.25, 720 * 1.25);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('zoom-125-percent');
    
    // Zoom 150%
    cy.viewport(1280 * 1.5, 720 * 1.5);
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('zoom-150-percent');
  });
});
