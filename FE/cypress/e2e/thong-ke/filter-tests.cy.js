// cypress/e2e/thong-ke/filter-tests.cy.js
// Test kiểm thử bộ lọc của trang báo cáo thống kê

describe('Kiểm thử bộ lọc báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê
    cy.visitThongKe();
  });

  it('UI-03: Kiểm tra chuyển đổi giữa các tab thời gian (ngày/tháng/năm)', () => {
    // Kiểm tra tab "Theo ngày" được chọn mặc định
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('be.checked');
    
    // Kiểm tra hiển thị dropdown chọn ngày, tháng, năm
    cy.get('select.form-select').should('have.length.at.least', 3);
    
    // Chuyển sang tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    cy.contains('label', 'Theo tháng').find('input[type="radio"]').should('be.checked');
    
    // Kiểm tra hiển thị dropdown chọn tháng, năm
    cy.get('select.form-select').should('have.length.at.least', 2);
    
    // Chuyển sang tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    cy.contains('label', 'Theo năm').find('input[type="radio"]').should('be.checked');
    
    // Kiểm tra hiển thị dropdown chọn năm
    cy.get('select.form-select').should('have.length.at.least', 1);
    
    // Chuyển lại tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('be.checked');
  });

  it('UI-04: Kiểm tra bộ lọc tháng', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Giả lập API doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 5, tongDoanhThu: 25000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 15, tongDoanhThu: 30000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 20, tongDoanhThu: 12000, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoThang');
    
    // Kiểm tra tất cả các tháng trong dropdown
    for (let i = 1; i <= 12; i++) {
      cy.get('select.form-select').eq(0).select(i.toString());
      cy.wait('@getDoanhThuTheoThang');
      cy.get('highcharts-chart').should('be.visible');
    }
  });

  it('UI-05: Kiểm tra bộ lọc năm', () => {
    // Chọn tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Giả lập API doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 147000, tongDonHang: 7, tongDonHangTraLai: 0 },
          { thoiGian: 2, tongDoanhThu: 95000, tongDonHang: 5, tongDonHangTraLai: 1 },
          { thoiGian: 3, tongDoanhThu: 210000, tongDonHang: 10, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNam');
    
    // Kiểm tra tất cả các năm trong dropdown
    cy.get('select.form-select').eq(0).find('option').each(($option) => {
      const year = $option.val();
      cy.get('select.form-select').eq(0).select(year);
      cy.wait('@getDoanhThuTheoNam');
      cy.get('highcharts-chart').should('be.visible');
    });
  });

  it('UI-12: Kiểm tra chuyển đổi giữa các tab khi đã chọn bộ lọc', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Chọn tháng 5 năm 2024
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2024');
    cy.wait(1000);
    
    // Chuyển sang tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Kiểm tra tháng và năm đã chọn vẫn được giữ nguyên
    cy.get('select.form-select').eq(1).should('have.value', '5');
    cy.get('select.form-select').eq(2).should('have.value', '2024');
    
    // Chuyển sang tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Kiểm tra năm đã chọn vẫn được giữ nguyên
    cy.get('select.form-select').eq(0).should('have.value', '2024');
  });

  it('UI-28: Kiểm tra hiển thị khi chọn nhiều bộ lọc cùng lúc', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn ngày, tháng, năm cùng lúc
    cy.get('select.form-select').eq(0).select('15');
    cy.get('select.form-select').eq(1).select('6');
    cy.get('select.form-select').eq(2).select('2024');
    cy.wait(1000);
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('multiple-filters-day');
    
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Chọn tháng và năm cùng lúc
    cy.get('select.form-select').eq(0).select('7');
    cy.get('select.form-select').eq(1).select('2023');
    cy.wait(1000);
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('multiple-filters-month');
  });

  it('UI-29: Kiểm tra hiển thị khi không có quyền truy cập', () => {
    // Giả lập API trả về lỗi không có quyền truy cập
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 403,
      body: {
        status: 403,
        msg: 'Không có quyền truy cập.',
        data: null
      }
    }).as('getDoanhThuTheoNgayForbidden');
    
    // Tải lại trang
    cy.reload();
    cy.wait('@getDoanhThuTheoNgayForbidden');
    
    // Kiểm tra giao diện vẫn hiển thị
    cy.contains('h4', 'Doanh thu').should('be.visible');
    
    // Kiểm tra các thẻ thông tin vẫn hiển thị (có thể không có dữ liệu)
    cy.get('.card-animate').should('have.length', 3);
  });
});
