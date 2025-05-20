// cypress/e2e/thongke-dashboard.cy.js

// Custom command để đăng nhập
Cypress.Commands.add('login', (username, password) => {
  cy.visit('/login');
  cy.get('input[name="username"]').type(username);
  cy.get('input[name="password"]').type(password);
  cy.get('button[type="submit"]').click();
  // Đợi đăng nhập thành công
  cy.url().should('not.include', '/login');
});

// Custom command để kiểm tra tính chính xác của dữ liệu
Cypress.Commands.add('verifyRevenueData', (expectedHoaDon, expectedDonHangTraLai, expectedDoanhThu) => {
  // Kiểm tra số lượng hóa đơn
  if (expectedHoaDon !== null) {
    cy.get('.hoa-don-count').should('contain', expectedHoaDon);
  }

  // Kiểm tra số lượng đơn hàng trả lại
  if (expectedDonHangTraLai !== null) {
    cy.get('.don-hang-tra-lai-count').should('contain', expectedDonHangTraLai);
  }

  // Kiểm tra tổng doanh thu
  if (expectedDoanhThu !== null) {
    cy.get('.doanh-thu-value').should('contain', expectedDoanhThu);
  }
});

// Custom command để chọn loại báo cáo và thời gian
Cypress.Commands.add('selectReportType', (type, options = {}) => {
  // Chọn loại báo cáo (NGAY, THANG, NAM)
  cy.get(`[data-type="${type}"]`).click();

  // Chọn ngày nếu có
  if (options.ngay) {
    cy.get('select.ngay-select').select(options.ngay.toString());
  }

  // Chọn tháng nếu có
  if (options.thang) {
    cy.get('select.thang-select').select(options.thang.toString());
  }

  // Chọn năm nếu có
  if (options.nam) {
    cy.get('select.nam-select').select(options.nam.toString());
  }
});

describe('Báo cáo Doanh thu - Kiểm thử Giao diện', () => {
  beforeEach(() => {
    // Đăng nhập trước mỗi test case
    cy.login('admin', 'password'); // Thay đổi thông tin đăng nhập phù hợp
    cy.visit('/thongke'); // Đường dẫn đến trang báo cáo

    // Đợi cho trang tải xong
    cy.get('#container').should('be.visible');
  });

  describe('Kiểm tra Dashboard tổng quan', () => {
    it('Hiển thị đúng các thành phần tổng quan', () => {
      // Kiểm tra hiển thị số lượng hóa đơn
      cy.get('.hoa-don-count').should('be.visible');
      cy.get('.hoa-don-count').should('contain', '7');

      // Kiểm tra hiển thị số lượng đơn hàng trả lại
      cy.get('.don-hang-tra-lai-count').should('be.visible');
      cy.get('.don-hang-tra-lai-count').should('contain', '0');

      // Kiểm tra hiển thị tổng doanh thu
      cy.get('.doanh-thu-value').should('be.visible');
      cy.get('.doanh-thu-value').should('contain', '153,400');

      // Kiểm tra các biểu tượng
      cy.get('.hoa-don-icon').should('be.visible');
      cy.get('.don-hang-tra-lai-icon').should('be.visible');
      cy.get('.doanh-thu-icon').should('be.visible');
    });
  });

  describe('Kiểm tra biểu đồ doanh thu', () => {
    it('Hiển thị đúng biểu đồ doanh thu', () => {
      // Kiểm tra container biểu đồ hiển thị
      cy.get('#container').should('be.visible');

      // Kiểm tra các cột biểu đồ
      cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);

      // Kiểm tra trục X và Y
      cy.get('.highcharts-xaxis-labels').should('be.visible');
      cy.get('.highcharts-yaxis-labels').should('be.visible');
    });

    it('Hiển thị tooltip khi hover vào cột biểu đồ', () => {
      // Hover vào cột biểu đồ
      cy.get('.highcharts-column-series .highcharts-point').first().trigger('mouseover');

      // Kiểm tra tooltip hiển thị
      cy.get('.highcharts-tooltip').should('be.visible');
    });
  });

  describe('Kiểm tra chức năng chuyển đổi loại báo cáo', () => {
    it('Chuyển đổi giữa các loại báo cáo', () => {
      // Kiểm tra tab "Theo ngày"
      cy.get('[data-type="NGAY"]').click();
      cy.get('[data-type="NGAY"]').should('have.class', 'active');
      cy.get('#container').should('be.visible');

      // Kiểm tra tab "Theo tháng"
      cy.get('[data-type="THANG"]').click();
      cy.get('[data-type="THANG"]').should('have.class', 'active');
      cy.get('#container').should('be.visible');

      // Kiểm tra tab "Theo năm"
      cy.get('[data-type="NAM"]').click();
      cy.get('[data-type="NAM"]').should('have.class', 'active');
      cy.get('#container').should('be.visible');
    });
  });

  describe('Kiểm tra chức năng chọn thời gian', () => {
    it('Cập nhật biểu đồ khi chọn thời gian khác', () => {
      // Chọn báo cáo theo tháng
      cy.get('[data-type="THANG"]').click();

      // Chọn tháng khác
      cy.get('select.thang-select').select('2');

      // Kiểm tra biểu đồ được cập nhật
      cy.get('#container').should('be.visible');
      cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);

      // Chọn năm khác
      cy.get('select.nam-select').select('2023');

      // Kiểm tra biểu đồ được cập nhật
      cy.get('#container').should('be.visible');
      cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);
    });
  });

  describe('Kiểm tra tính responsive', () => {
    it('Hiển thị đúng trên màn hình desktop', () => {
      cy.viewport(1920, 1080);

      // Kiểm tra layout desktop
      cy.get('.dashboard-cards').should('have.css', 'flex-direction', 'row');
      cy.get('#container').should('be.visible');
    });

    it('Hiển thị đúng trên màn hình tablet', () => {
      cy.viewport(768, 1024);

      // Kiểm tra layout tablet
      cy.get('#container').should('be.visible');
      // Kiểm tra các thành phần được sắp xếp phù hợp
    });

    it('Hiển thị đúng trên màn hình mobile', () => {
      cy.viewport(375, 667);

      // Kiểm tra layout mobile
      cy.get('.dashboard-cards').should('have.css', 'flex-direction', 'column');
      cy.get('#container').should('be.visible');
    });
  });

  describe('Kiểm tra hiển thị khi không có dữ liệu', () => {
    it('Hiển thị đúng khi không có dữ liệu', () => {
      // Chọn năm không có dữ liệu
      cy.selectReportType('NAM', { nam: '2022' }); // Giả sử năm 2022 không có dữ liệu

      // Kiểm tra hiển thị khi không có dữ liệu
      cy.get('#container').should('be.visible');
      // Kiểm tra thông báo không có dữ liệu hoặc biểu đồ trống
      cy.verifyRevenueData(0, 0, 0); // Kỳ vọng tất cả đều là 0
    });
  });

  describe('Kiểm tra hiển thị với nhiều loại dữ liệu khác nhau', () => {
    it('Hiển thị đúng với dữ liệu theo giờ trong ngày', () => {
      // Chọn báo cáo theo ngày
      cy.selectReportType('NGAY', { ngay: '15', thang: '1', nam: '2024' });

      // Kiểm tra biểu đồ hiển thị dữ liệu theo giờ
      cy.get('#container').should('be.visible');
      cy.get('.highcharts-xaxis-labels').should('contain', '1');
      cy.get('.highcharts-xaxis-labels').should('contain', '12');
      cy.get('.highcharts-xaxis-labels').should('contain', '24');
    });

    it('Hiển thị đúng với dữ liệu nhiều ngày trong tháng', () => {
      // Chọn báo cáo theo tháng
      cy.selectReportType('THANG', { thang: '1', nam: '2024' });

      // Kiểm tra biểu đồ hiển thị dữ liệu theo ngày
      cy.get('#container').should('be.visible');
      cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);

      // Kiểm tra tooltip khi hover vào cột biểu đồ
      cy.get('.highcharts-column-series .highcharts-point').first().trigger('mouseover');
      cy.get('.highcharts-tooltip').should('be.visible');
    });

    it('Hiển thị đúng với dữ liệu không đồng đều', () => {
      // Chọn báo cáo theo năm
      cy.selectReportType('NAM', { nam: '2024' });

      // Kiểm tra biểu đồ hiển thị dữ liệu theo tháng
      cy.get('#container').should('be.visible');
      cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);

      // Kiểm tra tooltip khi hover vào cột biểu đồ
      cy.get('.highcharts-column-series .highcharts-point').first().trigger('mouseover');
      cy.get('.highcharts-tooltip').should('be.visible');
    });
  });

  describe('Kiểm tra hiệu suất tải trang', () => {
    it('Tải trang và biểu đồ trong thời gian hợp lý', () => {
      // Đo thời gian tải trang
      cy.window().then((win) => {
        const perfData = win.performance.timing;
        const pageLoadTime = perfData.loadEventEnd - perfData.navigationStart;
        expect(pageLoadTime).to.be.lessThan(3000); // Kỳ vọng tải trang trong vòng 3 giây
      });

      // Kiểm tra biểu đồ hiển thị
      cy.get('#container').should('be.visible');
    });
  });

  describe('Kiểm tra tính năng lọc dữ liệu (nếu có)', () => {
    it('Lọc dữ liệu hoạt động chính xác', () => {
      // Kiểm tra nếu có bộ lọc dữ liệu
      cy.get('body').then(($body) => {
        if ($body.find('.filter-container').length > 0) {
          // Nếu có bộ lọc, thử sử dụng
          cy.get('.filter-container select').first().select('1');

          // Kiểm tra biểu đồ được cập nhật
          cy.get('#container').should('be.visible');
        } else {
          // Nếu không có bộ lọc, bỏ qua test này
          cy.log('Không có bộ lọc dữ liệu');
        }
      });
    });
  });
});
