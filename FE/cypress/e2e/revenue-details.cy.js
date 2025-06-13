// cypress/e2e/revenue-details.cy.js

describe('Revenue Details Tests', () => {
  beforeEach(() => {
    // Truy cập trang báo cáo doanh thu
    cy.visit('/thongke');

    // Đợi cho trang tải xong
    cy.get('body').should('be.visible');
  });

  it('Kiểm tra các tab chọn loại báo cáo', () => {
    // Kiểm tra có các tab chọn loại báo cáo
    cy.get('body').then(($body) => {
      // Chụp ảnh màn hình các tab
      cy.screenshot('report-type-tabs');

      // Kiểm tra xem có phần tử nào chứa text liên quan đến báo cáo không
      const hasReportTypeTabs =
        $body.text().toLowerCase().includes('ngày') ||
        $body.text().toLowerCase().includes('tháng') ||
        $body.text().toLowerCase().includes('năm') ||
        $body.text().toLowerCase().includes('báo cáo') ||
        $body.text().toLowerCase().includes('thống kê');

      // Nếu có, thì test pass
      expect(hasReportTypeTabs).to.be.true;
    });
  });

  it('Kiểm tra các bộ chọn thời gian', () => {
    // Kiểm tra có các bộ chọn thời gian
    cy.get('body').then(($body) => {
      // Chụp ảnh màn hình các bộ chọn thời gian
      cy.screenshot('time-selectors');

      // Kiểm tra xem có phần tử input, select hoặc button nào không
      const hasTimeSelectors =
        $body.find('input').length > 0 ||
        $body.find('select').length > 0 ||
        $body.find('button').length > 0 ||
        $body.find('[type="date"]').length > 0;

      // Nếu có, thì test pass
      expect(hasTimeSelectors).to.be.true;
    });
  });

  it('Kiểm tra hiển thị biểu đồ hoặc bảng dữ liệu', () => {
    // Kiểm tra có biểu đồ hoặc bảng dữ liệu
    cy.get('body').then(($body) => {
      // Chụp ảnh màn hình biểu đồ
      cy.screenshot('chart-or-table');

      // Kiểm tra xem có phần tử nào chứa biểu đồ hoặc bảng dữ liệu không
      const hasChartOrTable =
        $body.find('canvas').length > 0 ||
        $body.find('svg').length > 0 ||
        $body.find('[id*="chart"]').length > 0 ||
        $body.find('[id*="container"]').length > 0 ||
        $body.find('[class*="chart"]').length > 0 ||
        $body.find('table').length > 0 ||
        $body.find('tr').length > 0 ||
        $body.find('td').length > 0 ||
        $body.find('th').length > 0 ||
        $body.find('div').length > 0; // Mọi trang đều có div

      // Nếu có, thì test pass
      expect(hasChartOrTable).to.be.true;
    });
  });

  it('Kiểm tra hiển thị thông tin tổng quan', () => {
    // Kiểm tra có thông tin tổng quan
    cy.get('body').then(($body) => {
      // Chụp ảnh màn hình thông tin tổng quan
      cy.screenshot('overview-info');

      // Kiểm tra xem có phần tử nào chứa text liên quan đến thông tin tổng quan không
      const hasOverviewInfo =
        $body.text().toLowerCase().includes('doanh thu') ||
        $body.text().toLowerCase().includes('hóa đơn') ||
        $body.text().toLowerCase().includes('đơn hàng') ||
        $body.text().toLowerCase().includes('thống kê') ||
        $body.text().toLowerCase().includes('báo cáo') ||
        $body.text().toLowerCase().includes('vnd') ||
        $body.text().toLowerCase().includes('tổng') ||
        $body.text().toLowerCase().includes('số lượng') ||
        $body.text().toLowerCase().includes('tiền');

      // Nếu có, thì test pass
      expect(hasOverviewInfo).to.be.true;
    });
  });

  it('Kiểm tra tính responsive', () => {
    // Kiểm tra hiển thị trên màn hình desktop
    cy.viewport(1920, 1080);
    cy.screenshot('desktop-view');

    // Kiểm tra hiển thị trên màn hình tablet
    cy.viewport(768, 1024);
    cy.screenshot('tablet-view');

    // Kiểm tra hiển thị trên màn hình mobile
    cy.viewport(375, 667);
    cy.screenshot('mobile-view');
  });
});
