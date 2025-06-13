// cypress/e2e/bao-cao-thong-ke/overview.cy.js
// Test kiểm tra các thành phần tổng quan của trang báo cáo thống kê

describe('Báo cáo thống kê - Tổng quan', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('Hiển thị đúng các thẻ thông tin tổng quan', () => {
    // Kiểm tra thẻ thông tin Hóa đơn
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.get('.card-animate').eq(0).find('h4').should('be.visible');

    // Kiểm tra thẻ thông tin Đơn hàng trả lại
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4').should('be.visible');

    // Kiểm tra thẻ thông tin Doanh thu
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('contain', 'VNĐ');
  });

  it('Hiển thị đúng biểu tượng cho các thẻ thông tin', () => {
    // Kiểm tra biểu tượng thẻ Hóa đơn
    cy.get('.card-animate').eq(0).find('.avatar-title i').should('have.class', 'bx-dollar-circle');

    // Kiểm tra biểu tượng thẻ Đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('.avatar-title i').should('have.class', 'bx-user-circle');

    // Kiểm tra biểu tượng thẻ Doanh thu
    cy.get('.card-animate').eq(2).find('.avatar-title i').should('have.class', 'bx-wallet');
  });

  it('Hiển thị dữ liệu số lượng hóa đơn chính xác', () => {
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

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra hiển thị số lượng hóa đơn
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '3');
  });

  it('Hiển thị dữ liệu số lượng đơn hàng trả lại chính xác', () => {
    // Giả lập API doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 1 },
          { thoiGian: 10, tongDoanhThu: 18500, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNgay');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra hiển thị số lượng đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '1');
  });

  it('Hiển thị dữ liệu tổng doanh thu chính xác', () => {
    // Giả lập API doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 1 },
          { thoiGian: 10, tongDoanhThu: 18500, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNgay');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra hiển thị tổng doanh thu
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '43,500');
  });

  it('Hiển thị đúng khi không có dữ liệu', () => {
    // Giả lập API doanh thu theo ngày trả về mảng rỗng
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: []
      }
    }).as('getDoanhThuTheoNgayEmpty');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgayEmpty');

    // Kiểm tra hiển thị giá trị mặc định khi không có dữ liệu
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '0');
  });
});
