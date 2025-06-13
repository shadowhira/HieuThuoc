// cypress/e2e/thong-ke/index.cy.js
// Test tổng hợp tất cả các test case cho trang báo cáo thống kê

describe('Kiểm thử tổng hợp báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê
    cy.visitThongKe();
  });

  it('Kiểm tra tất cả các thành phần giao diện hiển thị đúng', () => {
    // Kiểm tra hiển thị 3 ô tổng quan
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');

    // Kiểm tra hiển thị biểu đồ doanh thu
    cy.get('highcharts-chart').should('be.visible');

    // Kiểm tra hiển thị các tab lọc
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Kiểm tra hiển thị dropdown chọn tháng và năm
    cy.get('select.form-select').should('have.length.at.least', 1);
  });

  it('Kiểm tra chuyển đổi giữa các tab thời gian hoạt động đúng', () => {
    // Kiểm tra tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('be.checked');
    cy.get('select.form-select').should('have.length.at.least', 2);
    
    // Kiểm tra tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    cy.contains('label', 'Theo tháng').find('input[type="radio"]').should('be.checked');
    cy.get('select.form-select').should('have.length', 2);
    
    // Kiểm tra tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    cy.contains('label', 'Theo năm').find('input[type="radio"]').should('be.checked');
    cy.get('select.form-select').should('have.length', 1);
  });

  it('Kiểm tra bộ lọc tháng hoạt động đúng', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Kiểm tra dropdown tháng hiển thị đầy đủ 12 tháng
    cy.get('select.form-select').eq(0).find('option').should('have.length', 12);
    
    // Giả lập API doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 5, tongDoanhThu: 25000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoThang');
    
    // Chọn tháng 5
    cy.get('select.form-select').eq(0).select('5');
    cy.wait('@getDoanhThuTheoThang');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
  });

  it('Kiểm tra bộ lọc năm hoạt động đúng', () => {
    // Chọn tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Kiểm tra dropdown năm hiển thị đầy đủ các năm
    cy.get('select.form-select').eq(0).find('option').should('have.length.at.least', 4);
    
    // Giả lập API doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 147000, tongDonHang: 7, tongDonHangTraLai: 0 },
          { thoiGian: 2, tongDoanhThu: 95000, tongDonHang: 5, tongDonHangTraLai: 1 }
        ]
      }
    }).as('getDoanhThuTheoNam');
    
    // Chọn năm 2024
    cy.get('select.form-select').eq(0).select('2024');
    cy.wait('@getDoanhThuTheoNam');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
  });

  it('Kiểm tra tính responsive của giao diện', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);
    
    // Kiểm tra hiển thị các thành phần trên desktop
    cy.get('.card-animate').should('have.length', 3);
    cy.get('highcharts-chart').should('be.visible');
    
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);
    
    // Kiểm tra hiển thị các thành phần trên tablet
    cy.get('.card-animate').should('have.length', 3);
    cy.get('highcharts-chart').should('be.visible');
    
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);
    
    // Kiểm tra hiển thị các thành phần trên mobile
    cy.get('.card-animate').should('have.length', 3);
    cy.get('highcharts-chart').should('be.visible');
  });
});
