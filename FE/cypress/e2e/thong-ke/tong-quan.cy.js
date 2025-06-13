// cypress/e2e/thong-ke/tong-quan.cy.js
// Test kiểm thử giao diện tổng quan của trang báo cáo thống kê

describe('Kiểm thử giao diện tổng quan báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê sử dụng session
    cy.visitThongKeWithSession();
  });

  it('UI-01: Kiểm tra hiển thị tổng quan ban đầu của giao diện thống kê', () => {
    // Đợi cho trang tải hoàn toàn
    cy.get('.page-content', { timeout: 15000 }).should('be.visible');

    // Kiểm tra hiển thị 3 ô tổng quan
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');

    // Kiểm tra hiển thị biểu đồ doanh thu (sử dụng container thay vì highcharts-chart)
    cy.get('#container', { timeout: 15000 }).should('be.visible');

    // Kiểm tra hiển thị các tab lọc
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Kiểm tra hiển thị dropdown chọn tháng và năm
    cy.get('select.form-select').should('have.length.at.least', 1);
  });

  it('UI-02: Kiểm tra hiển thị số liệu tổng quan', () => {
    // Kiểm tra hiển thị số lượng hóa đơn
    cy.get('.card-animate').eq(0).find('h4 span').should('be.visible');

    // Kiểm tra hiển thị số lượng đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('h4 span').should('be.visible');

    // Kiểm tra hiển thị tổng doanh thu
    cy.get('.card-animate').eq(2).find('h4 span').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', 'VNĐ');
  });

  it('UI-15: Kiểm tra hiển thị các icon trong ô tổng quan', () => {
    // Kiểm tra icon trong ô Hóa đơn
    cy.get('.card-animate').eq(0).find('.avatar-title i')
      .should('have.class', 'bx-dollar-circle')
      .should('have.class', 'text-success');

    // Kiểm tra icon trong ô Đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('.avatar-title i')
      .should('have.class', 'bx-user-circle')
      .should('have.class', 'text-warning');

    // Kiểm tra icon trong ô Doanh thu
    cy.get('.card-animate').eq(2).find('.avatar-title i')
      .should('have.class', 'bx-wallet')
      .should('have.class', 'text-primary');
  });

  it('UI-09: Kiểm tra hiển thị khi không có dữ liệu', () => {
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

  it('UI-26: Kiểm tra màu sắc và độ tương phản của giao diện', () => {
    // Kiểm tra màu sắc của các thành phần giao diện
    cy.get('.card-animate').eq(0).find('.avatar-title').should('have.class', 'bg-soft-success');
    cy.get('.card-animate').eq(1).find('.avatar-title').should('have.class', 'bg-soft-warning');
    cy.get('.card-animate').eq(2).find('.avatar-title').should('have.class', 'bg-soft-primary');

    // Kiểm tra màu sắc của biểu đồ (sử dụng container thay vì highcharts-chart)
    cy.get('#container', { timeout: 15000 }).should('be.visible');
  });

  it('UI-16: Kiểm tra tính năng làm mới dữ liệu', () => {
    // Giả lập API doanh thu theo ngày với dữ liệu ban đầu
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNgayInitial');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgayInitial');

    // Lưu giá trị ban đầu (lưu cả giá trị doanh thu)
    cy.get('.card-animate').eq(0).find('h4 span').invoke('text').then((text) => {
      const initialOrders = text.trim();

      // Giả lập API doanh thu theo ngày với dữ liệu mới (thay đổi giá trị doanh thu)
      cy.intercept('GET', '**/baocao/doanhthutheongay*', {
        statusCode: 200,
        body: {
          status: 200,
          msg: 'Thành công.',
          data: [
            { thoiGian: 8, tongDoanhThu: 50000, tongDonHang: 5, tongDonHangTraLai: 1 }
          ]
        }
      }).as('getDoanhThuTheoNgayUpdated');

      // Làm mới trang
      cy.reload();
      cy.wait('@getDoanhThuTheoNgayUpdated');

      // Đợi cho dữ liệu cập nhật
      cy.wait(2000);

      // Kiểm tra dữ liệu số lượng hóa đơn đã được cập nhật
      cy.get('.card-animate').eq(0).find('h4 span').invoke('text').should((updatedText) => {
        const updatedOrders = updatedText.trim();
        // Kiểm tra giá trị đã thay đổi
        expect(updatedOrders).not.to.eq(initialOrders);
      });
    });
  });
});
