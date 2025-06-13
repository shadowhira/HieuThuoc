// cypress/e2e/thong-ke/bo-loc.cy.js
// Test kiểm thử các bộ lọc thời gian của trang báo cáo thống kê

describe('Kiểm thử bộ lọc thời gian báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê
    cy.visitThongKe();
  });

  it('UI-03: Kiểm tra chuyển đổi giữa các tab thời gian (ngày/tháng/năm)', () => {
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

  it('UI-04: Kiểm tra bộ lọc tháng', () => {
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
    
    // Chọn tháng 1
    cy.get('select.form-select').eq(0).select('1');
    cy.wait('@getDoanhThuTheoThang');
    
    // Chọn tháng 5
    cy.get('select.form-select').eq(0).select('5');
    cy.wait('@getDoanhThuTheoThang');
    
    // Chọn tháng 12
    cy.get('select.form-select').eq(0).select('12');
    cy.wait('@getDoanhThuTheoThang');
  });

  it('UI-05: Kiểm tra bộ lọc năm', () => {
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
    
    // Chọn năm 2022
    cy.get('select.form-select').eq(0).select('2022');
    cy.wait('@getDoanhThuTheoNam');
    
    // Chọn năm 2023
    cy.get('select.form-select').eq(0).select('2023');
    cy.wait('@getDoanhThuTheoNam');
    
    // Chọn năm 2024
    cy.get('select.form-select').eq(0).select('2024');
    cy.wait('@getDoanhThuTheoNam');
    
    // Chọn năm 2025
    cy.get('select.form-select').eq(0).select('2025');
    cy.wait('@getDoanhThuTheoNam');
  });

  it('UI-12: Kiểm tra chuyển đổi giữa các tab khi đã chọn bộ lọc', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Chọn tháng 5 năm 2025
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    
    // Chuyển sang tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Kiểm tra năm vẫn là 2025
    cy.get('select.form-select').eq(0).should('have.value', '2025');
    
    // Quay lại tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Kiểm tra tháng vẫn là tháng 5 và năm vẫn là 2025
    cy.get('select.form-select').eq(0).should('have.value', '5');
    cy.get('select.form-select').eq(1).should('have.value', '2025');
  });

  it('UI-18: Kiểm tra hiển thị với tháng có 28/29/30/31 ngày', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn tháng 2 năm 2024 (tháng 2 năm nhuận có 29 ngày)
    cy.get('select.form-select').eq(1).select('2');
    cy.get('select.form-select').eq(2).select('2024');
    
    // Kiểm tra dropdown ngày có 29 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 29);
    
    // Chọn tháng 4 năm 2024 (tháng 4 có 30 ngày)
    cy.get('select.form-select').eq(1).select('4');
    
    // Kiểm tra dropdown ngày có 30 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 30);
    
    // Chọn tháng 5 năm 2024 (tháng 5 có 31 ngày)
    cy.get('select.form-select').eq(1).select('5');
    
    // Kiểm tra dropdown ngày có 31 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 31);
  });

  it('UI-19: Kiểm tra hiển thị khi chuyển đổi giữa các năm nhuận và không nhuận', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn tháng 2 năm 2024 (năm nhuận)
    cy.get('select.form-select').eq(1).select('2');
    cy.get('select.form-select').eq(2).select('2024');
    
    // Kiểm tra dropdown ngày có 29 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 29);
    
    // Chọn tháng 2 năm 2023 (năm không nhuận)
    cy.get('select.form-select').eq(2).select('2023');
    
    // Kiểm tra dropdown ngày có 28 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 28);
  });

  it('UI-23: Kiểm tra hiển thị khi chuyển đổi nhanh giữa các bộ lọc', () => {
    // Chọn nhanh giữa các tab
    cy.contains('label', 'Theo ngày').click();
    cy.contains('label', 'Theo tháng').click();
    cy.contains('label', 'Theo năm').click();
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn nhanh giữa các tháng
    cy.get('select.form-select').eq(1).select('1');
    cy.get('select.form-select').eq(1).select('5');
    cy.get('select.form-select').eq(1).select('12');
    
    // Chọn nhanh giữa các năm
    cy.get('select.form-select').eq(2).select('2022');
    cy.get('select.form-select').eq(2).select('2023');
    cy.get('select.form-select').eq(2).select('2024');
    cy.get('select.form-select').eq(2).select('2025');
    
    // Kiểm tra giao diện vẫn hiển thị đúng
    cy.get('.page-content').should('be.visible');
    cy.get('highcharts-chart').should('be.visible');
  });

  it('UI-28: Kiểm tra hiển thị khi chọn nhiều bộ lọc cùng lúc', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn ngày, tháng, năm cùng lúc
    cy.get('select.form-select').eq(0).select('15');
    cy.get('select.form-select').eq(1).select('5');
    cy.get('select.form-select').eq(2).select('2024');
    
    // Kiểm tra biểu đồ hiển thị đúng
    cy.get('highcharts-chart').should('be.visible');
  });
});
