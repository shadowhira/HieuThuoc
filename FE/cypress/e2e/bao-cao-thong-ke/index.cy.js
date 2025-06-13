// cypress/e2e/bao-cao-thong-ke/index.cy.js
// Test tổng hợp cho trang báo cáo thống kê

describe('Báo cáo thống kê - Tổng hợp', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('Kiểm tra tất cả các thành phần chính hiển thị đúng', () => {
    // Kiểm tra tiêu đề trang
    cy.contains('h4', 'Doanh thu').should('be.visible');

    // Kiểm tra các thẻ thông tin tổng quan
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');

    // Kiểm tra bộ lọc thời gian
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Kiểm tra biểu đồ
    cy.get('#container').should('be.visible');
  });

  it('Kiểm tra luồng nghiệp vụ đầy đủ', () => {
    // Giả lập API doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 18500, tongDonHang: 1, tongDonHangTraLai: 0 }
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
          { thoiGian: 1, tongDoanhThu: 125000, tongDonHang: 5, tongDonHangTraLai: 1 },
          { thoiGian: 15, tongDoanhThu: 218500, tongDonHang: 8, tongDonHangTraLai: 0 }
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
          { thoiGian: 1, tongDoanhThu: 1250000, tongDonHang: 50, tongDonHangTraLai: 5 },
          { thoiGian: 2, tongDoanhThu: 1850000, tongDonHang: 70, tongDonHangTraLai: 8 }
        ]
      }
    }).as('getDoanhThuTheoNam');

    // Bước 1: Kiểm tra báo cáo theo ngày
    cy.contains('label', 'Theo ngày').click();
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra hiển thị thông tin tổng quan
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '3');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '43,500');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Bước 2: Chuyển sang báo cáo theo tháng
    cy.contains('label', 'Theo tháng').click();
    cy.wait('@getDoanhThuTheoThang');

    // Kiểm tra hiển thị thông tin tổng quan
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '13');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '1');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '343,500');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Bước 3: Chuyển sang báo cáo theo năm
    cy.contains('label', 'Theo năm').click();
    cy.wait('@getDoanhThuTheoNam');

    // Kiểm tra hiển thị thông tin tổng quan
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '120');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '13');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '3,100,000');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Bước 4: Thay đổi năm
    cy.get('select.form-select').eq(0).select('2023');
    cy.wait('@getDoanhThuTheoNam');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');
  });

  it('Chụp ảnh màn hình trang báo cáo thống kê', () => {
    // Chụp ảnh màn hình toàn bộ trang
    cy.screenshot('bao-cao-thong-ke-full');

    // Chụp ảnh màn hình phần biểu đồ
    cy.get('#container').screenshot('bao-cao-thong-ke-chart');
  });
});
