// cypress/e2e/thong-ke/truong-hop-dac-biet.cy.js
// Test kiểm thử các trường hợp đặc biệt của trang báo cáo thống kê

describe('Kiểm thử các trường hợp đặc biệt báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê
    cy.visitThongKe();
  });

  it('UI-21: Kiểm tra hiển thị khi chọn ngày trong tương lai', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Lấy ngày mai
    const tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    const tomorrowDay = tomorrow.getDate().toString();
    const tomorrowMonth = (tomorrow.getMonth() + 1).toString();
    const tomorrowYear = tomorrow.getFullYear().toString();
    
    // Giả lập API doanh thu theo ngày trả về mảng rỗng
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: []
      }
    }).as('getDoanhThuTheoNgayFuture');
    
    // Chọn ngày mai
    cy.get('select.form-select').eq(0).select(tomorrowDay);
    cy.get('select.form-select').eq(1).select(tomorrowMonth);
    cy.get('select.form-select').eq(2).select(tomorrowYear);
    cy.wait('@getDoanhThuTheoNgayFuture');
    
    // Kiểm tra biểu đồ hiển thị trống
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra các ô tổng quan hiển thị giá trị 0
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '0');
  });

  it('UI-22: Kiểm tra hiển thị khi chọn ngày không hợp lệ', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn tháng 2 năm 2023 (không nhuận)
    cy.get('select.form-select').eq(1).select('2');
    cy.get('select.form-select').eq(2).select('2023');
    
    // Kiểm tra dropdown ngày không có tùy chọn ngày 30 và 31
    cy.get('select.form-select').eq(0).find('option').should('have.length', 28);
    cy.get('select.form-select').eq(0).find('option[value="30"]').should('not.exist');
    cy.get('select.form-select').eq(0).find('option[value="31"]').should('not.exist');
  });

  it('UI-25: Kiểm tra hiển thị khi mất kết nối internet', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Giả lập API doanh thu theo tháng thành công
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
    }).as('getDoanhThuTheoThangSuccess');
    
    // Chọn tháng 5 năm 2025
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThangSuccess');
    
    // Giả lập mất kết nối internet
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      forceNetworkError: true
    }).as('getDoanhThuTheoThangError');
    
    // Chọn tháng 6 năm 2025
    cy.get('select.form-select').eq(0).select('6');
    cy.wait('@getDoanhThuTheoThangError');
    
    // Kiểm tra dữ liệu đã tải vẫn hiển thị
    cy.get('highcharts-chart').should('be.visible');
  });

  it('UI-29: Kiểm tra hiển thị khi không có quyền truy cập', () => {
    // Đăng xuất
    cy.clearCookies();
    cy.clearLocalStorage();
    
    // Đăng nhập với tài khoản không có quyền
    cy.loginUI('user', 'password');
    
    // Thử truy cập trang thống kê
    cy.visit('/sys/thongke', { failOnStatusCode: false });
    
    // Kiểm tra chuyển hướng đến trang lỗi hoặc trang đăng nhập
    cy.url().should('not.include', '/sys/thongke');
  });

  it('UI-34: Kiểm tra hiển thị khi có dữ liệu rất nhỏ', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Tạo dữ liệu có giá trị rất nhỏ
    const smallData = [
      { thoiGian: 1, tongDoanhThu: 100, tongDonHang: 1, tongDonHangTraLai: 0 },
      { thoiGian: 5, tongDoanhThu: 50, tongDonHang: 1, tongDonHangTraLai: 0 },
      { thoiGian: 10, tongDoanhThu: 75, tongDonHang: 1, tongDonHangTraLai: 0 },
      { thoiGian: 15, tongDoanhThu: 120, tongDonHang: 1, tongDonHangTraLai: 0 }
    ];
    
    // Giả lập API doanh thu theo tháng với dữ liệu nhỏ
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: smallData
      }
    }).as('getDoanhThuTheoThangSmall');
    
    // Chọn tháng có dữ liệu nhỏ
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThangSmall');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra tổng doanh thu
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '345');
  });

  it('UI-35: Kiểm tra hiển thị khi có dữ liệu rất lớn', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Tạo dữ liệu có giá trị rất lớn
    const largeData = [
      { thoiGian: 1, tongDoanhThu: 10000000, tongDonHang: 100, tongDonHangTraLai: 0 },
      { thoiGian: 5, tongDoanhThu: 15000000, tongDonHang: 150, tongDonHangTraLai: 0 },
      { thoiGian: 10, tongDoanhThu: 20000000, tongDonHang: 200, tongDonHangTraLai: 0 },
      { thoiGian: 15, tongDoanhThu: 25000000, tongDonHang: 250, tongDonHangTraLai: 0 }
    ];
    
    // Giả lập API doanh thu theo tháng với dữ liệu lớn
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: largeData
      }
    }).as('getDoanhThuTheoThangLarge');
    
    // Chọn tháng có dữ liệu lớn
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThangLarge');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra tổng doanh thu có định dạng số lớn
    cy.get('.card-animate').eq(2).find('h4 span').invoke('text').then((text) => {
      // Kiểm tra có dấu phân cách hàng nghìn
      expect(text).to.include(',');
    });
  });
});
