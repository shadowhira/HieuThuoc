// cypress/e2e/revenue-dashboard.cy.js

describe('Revenue Dashboard Tests', () => {
  beforeEach(() => {
    // Giả lập đăng nhập thành công
    cy.intercept('POST', '**/auth/login', {
      statusCode: 200,
      body: {
        token: 'fake-jwt-token',
        user: {
          id: 1,
          username: 'admin',
          role: 'ADMIN'
        }
      }
    }).as('loginRequest');

    // Giả lập dữ liệu báo cáo doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 14, tongDoanhThu: 30000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 16, tongDoanhThu: 12000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 19, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 21, tongDoanhThu: 16000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 23, tongDoanhThu: 24000.0, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNgay');

    // Giả lập dữ liệu báo cáo doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 5, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 12, tongDoanhThu: 30000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 15, tongDoanhThu: 12000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 20, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 25, tongDoanhThu: 16000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 30, tongDoanhThu: 24000.0, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoThang');

    // Giả lập dữ liệu báo cáo doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 147000.0, tongDonHang: 7, tongDonHangTraLai: 0 },
          { thoiGian: 2, tongDoanhThu: 95000.0, tongDonHang: 5, tongDonHangTraLai: 1 },
          { thoiGian: 3, tongDoanhThu: 210000.0, tongDonHang: 10, tongDonHangTraLai: 0 },
          { thoiGian: 4, tongDoanhThu: 180000.0, tongDonHang: 8, tongDonHangTraLai: 2 },
          { thoiGian: 5, tongDoanhThu: 250000.0, tongDonHang: 12, tongDonHangTraLai: 1 },
          { thoiGian: 6, tongDoanhThu: 160000.0, tongDonHang: 7, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNam');

    // Truy cập trang đăng nhập
    cy.visit('/login');
    
    // Điền thông tin đăng nhập
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('password');
    cy.get('button[type="submit"]').click();
    
    // Đợi đăng nhập thành công
    cy.wait('@loginRequest');
    
    // Truy cập trang báo cáo
    cy.visit('/thongke');
  });

  it('Hiển thị đúng các thành phần tổng quan', () => {
    // Kiểm tra hiển thị số lượng hóa đơn
    cy.get('.hoa-don-count').should('be.visible');
    
    // Kiểm tra hiển thị số lượng đơn hàng trả lại
    cy.get('.don-hang-tra-lai-count').should('be.visible');
    
    // Kiểm tra hiển thị tổng doanh thu
    cy.get('.doanh-thu-value').should('be.visible');
  });

  it('Hiển thị đúng biểu đồ doanh thu', () => {
    // Kiểm tra container biểu đồ hiển thị
    cy.get('#container').should('be.visible');
    
    // Kiểm tra các cột biểu đồ
    cy.get('.highcharts-column-series .highcharts-point').should('have.length.greaterThan', 0);
    
    // Kiểm tra trục X và Y
    cy.get('.highcharts-xaxis-labels').should('be.visible');
    cy.get('.highcharts-yaxis-labels').should('be.visible');
  });

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

  it('Hiển thị đúng trên màn hình desktop', () => {
    cy.viewport(1920, 1080);
    
    // Kiểm tra layout desktop
    cy.get('#container').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình tablet', () => {
    cy.viewport(768, 1024);
    
    // Kiểm tra layout tablet
    cy.get('#container').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình mobile', () => {
    cy.viewport(375, 667);
    
    // Kiểm tra layout mobile
    cy.get('#container').should('be.visible');
  });
});
