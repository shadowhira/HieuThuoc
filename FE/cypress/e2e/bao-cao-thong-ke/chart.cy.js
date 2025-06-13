// cypress/e2e/bao-cao-thong-ke/chart.cy.js
// Test kiểm tra biểu đồ doanh thu của trang báo cáo thống kê

describe('Báo cáo thống kê - Biểu đồ doanh thu', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();

    // Đợi cho biểu đồ hiển thị
    cy.get('#container').should('be.visible');
  });

  it('Hiển thị đúng biểu đồ doanh thu', () => {
    // Kiểm tra container biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra component highcharts hiển thị
    cy.get('.highcharts-container').should('be.visible');
  });

  it('Hiển thị đúng biểu đồ doanh thu theo ngày', () => {
    // Giả lập API doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 18500, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 14, tongDoanhThu: 30000, tongDonHang: 2, tongDonHangTraLai: 1 }
        ]
      }
    }).as('getDoanhThuTheoNgay');

    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra trục X hiển thị giờ trong ngày
    cy.get('.highcharts-xaxis-labels').should('exist');

    // Kiểm tra trục Y hiển thị giá trị doanh thu
    cy.get('.highcharts-yaxis-labels').should('exist');
  });

  it('Hiển thị đúng biểu đồ doanh thu theo tháng', () => {
    // Giả lập API doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 125000, tongDonHang: 5, tongDonHangTraLai: 1 },
          { thoiGian: 15, tongDoanhThu: 218500, tongDonHang: 8, tongDonHangTraLai: 0 },
          { thoiGian: 28, tongDoanhThu: 330000, tongDonHang: 12, tongDonHangTraLai: 2 }
        ]
      }
    }).as('getDoanhThuTheoThang');

    // Chọn loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoThang');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra trục X hiển thị ngày trong tháng
    cy.get('.highcharts-xaxis-labels').should('exist');

    // Kiểm tra trục Y hiển thị giá trị doanh thu
    cy.get('.highcharts-yaxis-labels').should('exist');
  });

  it('Hiển thị đúng biểu đồ doanh thu theo năm', () => {
    // Giả lập API doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 1250000, tongDonHang: 50, tongDonHangTraLai: 5 },
          { thoiGian: 2, tongDoanhThu: 1850000, tongDonHang: 70, tongDonHangTraLai: 8 },
          { thoiGian: 3, tongDoanhThu: 2100000, tongDonHang: 85, tongDonHangTraLai: 10 }
        ]
      }
    }).as('getDoanhThuTheoNam');

    // Chọn loại báo cáo "Theo năm"
    cy.contains('label', 'Theo năm').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNam');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');

    // Kiểm tra trục X hiển thị tháng trong năm
    cy.get('.highcharts-xaxis-labels').should('exist');

    // Kiểm tra trục Y hiển thị giá trị doanh thu
    cy.get('.highcharts-yaxis-labels').should('exist');
  });

  it('Cập nhật biểu đồ khi thay đổi bộ lọc thời gian', () => {
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

    // Chọn loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoThang');

    // Thay đổi tháng
    cy.get('select.form-select').eq(0).select('3');

    // Đợi API được gọi lại
    cy.wait('@getDoanhThuTheoThang');

    // Kiểm tra biểu đồ được cập nhật
    cy.get('#container').should('be.visible');
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

    // Kiểm tra biểu đồ vẫn hiển thị
    cy.get('#container').should('be.visible');
  });
});
