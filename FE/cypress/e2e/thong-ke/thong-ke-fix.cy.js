// cypress/e2e/thong-ke/thong-ke-fix.cy.js
// Test kiểm thử giao diện tổng quan của trang báo cáo thống kê

describe('Kiểm thử giao diện tổng quan báo cáo thống kê', () => {
  beforeEach(() => {
    // Giả lập API đăng nhập thành công
    cy.intercept('POST', '**/auth/dangnhap', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Đăng nhập thành công',
        data: 'fake-token'
      }
    }).as('loginSuccess');

    // Giả lập API doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNgay');

    // Giả lập API doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 5, tongDoanhThu: 25000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 15, tongDoanhThu: 30000, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoThang');

    // Giả lập API doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 147000, tongDonHang: 7, tongDonHangTraLai: 0 },
          { thoiGian: 6, tongDoanhThu: 160000, tongDonHang: 7, tongDonHangTraLai: 0 },
          { thoiGian: 12, tongDoanhThu: 320000, tongDonHang: 16, tongDonHangTraLai: 2 }
        ]
      }
    }).as('getDoanhThuTheoNam');

    // Đăng nhập và truy cập trang thống kê
    cy.visit('/login');
    cy.get('#username').type('admin');
    cy.get('#password-input').type('123456');
    cy.get('button.btn-success').contains('Đăng nhập').click();
    cy.wait('@loginSuccess');
    
    // Truy cập trang thống kê
    cy.visit('/sys/thongke');
    cy.wait(['@getDoanhThuTheoThang', '@getDoanhThuTheoNgay'], { timeout: 10000 });
  });

  it('UI-01: Kiểm tra hiển thị tổng quan ban đầu của giao diện thống kê', () => {
    // Kiểm tra hiển thị 3 ô tổng quan
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');

    // Kiểm tra hiển thị biểu đồ doanh thu (sử dụng container thay vì highcharts-chart)
    cy.get('#container').should('be.visible');

    // Kiểm tra hiển thị các tab lọc
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Kiểm tra hiển thị dropdown chọn tháng và năm
    cy.get('select.form-select').should('have.length.at.least', 1);
  });

  it('UI-06: Kiểm tra hiển thị biểu đồ theo ngày', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn ngày hiện tại
    const today = new Date();
    const day = today.getDate().toString();
    cy.get('select.form-select').eq(0).select(day);
    cy.wait('@getDoanhThuTheoNgay');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');
    
    // Kiểm tra tiêu đề biểu đồ
    cy.contains('h4', 'Doanh thu').should('be.visible');
  });

  it('UI-07: Kiểm tra hiển thị biểu đồ theo tháng', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Chọn tháng 5 năm 2025
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThang');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');
  });

  it('UI-08: Kiểm tra hiển thị biểu đồ theo năm', () => {
    // Chọn tab "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Chọn năm 2024
    cy.get('select.form-select').eq(0).select('2024');
    cy.wait('@getDoanhThuTheoNam');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');
  });

  it('UI-20: Kiểm tra hiển thị với dữ liệu âm', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Tạo dữ liệu có giá trị âm
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 15000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 5, tongDoanhThu: -8000, tongDonHang: 0, tongDonHangTraLai: 1 },
          { thoiGian: 10, tongDoanhThu: 12000, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 15, tongDoanhThu: -5000, tongDonHang: 0, tongDonHangTraLai: 1 }
        ]
      }
    }).as('getDoanhThuTheoThangNegative');
    
    // Chọn tháng có dữ liệu âm
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThangNegative');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');
  });
});
