// cypress/e2e/bao-cao-thong-ke/black-box-test.cy.js
// Test kiểm thử hộp đen cho chức năng báo cáo thống kê doanh thu

describe('Báo cáo thống kê - Kiểm thử hộp đen', () => {
  beforeEach(() => {
    // Đăng nhập với tài khoản admin
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('123456');
    cy.get('button[type="submit"]').click();
    
    // Truy cập trang thống kê
    cy.visit('/sys/thongke');
    cy.url().should('include', '/sys/thongke');
  });

  // TC-TK-UI-01: Kiểm tra hiển thị tổng quan ban đầu của giao diện thống kê
  it('TC-TK-UI-01: Kiểm tra hiển thị tổng quan ban đầu của giao diện thống kê', () => {
    // Kiểm tra hiển thị 3 ô tổng quan
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');

    // Kiểm tra hiển thị biểu đồ doanh thu
    cy.get('#container').should('be.visible');

    // Kiểm tra hiển thị các tab lọc
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');

    // Kiểm tra hiển thị dropdown chọn thời gian
    cy.get('select.form-select').should('be.visible');
  });

  // TC-TK-UI-02: Kiểm tra hiển thị số liệu tổng quan
  it('TC-TK-UI-02: Kiểm tra hiển thị số liệu tổng quan', () => {
    // Kiểm tra hiển thị số lượng hóa đơn
    cy.get('.card-animate').eq(0).find('h4').should('be.visible');

    // Kiểm tra hiển thị số lượng đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('h4').should('be.visible');

    // Kiểm tra hiển thị tổng doanh thu kèm đơn vị VNĐ
    cy.get('.card-animate').eq(2).find('h4').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('contain', 'VNĐ');
  });

  // TC-TK-UI-03: Kiểm tra hiển thị biểu tượng cho các thẻ thông tin
  it('TC-TK-UI-03: Kiểm tra hiển thị biểu tượng cho các thẻ thông tin', () => {
    // Kiểm tra biểu tượng thẻ Hóa đơn
    cy.get('.card-animate').eq(0).find('.avatar-title i').should('have.class', 'bx-dollar-circle');

    // Kiểm tra biểu tượng thẻ Đơn hàng trả lại
    cy.get('.card-animate').eq(1).find('.avatar-title i').should('have.class', 'bx-user-circle');

    // Kiểm tra biểu tượng thẻ Doanh thu
    cy.get('.card-animate').eq(2).find('.avatar-title i').should('have.class', 'bx-wallet');
  });

  // TC-TK-FILTER-01: Kiểm tra chuyển đổi giữa các tab thời gian
  it('TC-TK-FILTER-01: Kiểm tra chuyển đổi giữa các tab thời gian', () => {
    // Kiểm tra tab Theo ngày được chọn mặc định
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('be.checked');

    // Kiểm tra khi chọn tab Theo tháng
    cy.contains('label', 'Theo tháng').click();
    cy.contains('label', 'Theo tháng').find('input[type="radio"]').should('be.checked');
    cy.get('select.form-select').should('have.length', 2); // Dropdown chọn tháng và năm

    // Kiểm tra khi chọn tab Theo năm
    cy.contains('label', 'Theo năm').click();
    cy.contains('label', 'Theo năm').find('input[type="radio"]').should('be.checked');
    cy.get('select.form-select').should('have.length', 1); // Chỉ có dropdown chọn năm
  });

  // TC-TK-FILTER-02: Kiểm tra bộ lọc ngày
  it('TC-TK-FILTER-02: Kiểm tra bộ lọc ngày', () => {
    // Chọn tab Theo ngày
    cy.contains('label', 'Theo ngày').click();

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

    // Kiểm tra dropdown hiển thị đầy đủ các ngày trong tháng
    cy.get('select.form-select').eq(0).find('option').should('have.length.at.least', 28);

    // Chọn ngày khác
    cy.get('select.form-select').eq(0).select('15');

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra biểu đồ và số liệu tổng quan cập nhật
    cy.get('#container').should('be.visible');
    cy.get('.card-animate').eq(0).find('h4').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('be.visible');
  });

  // TC-TK-FILTER-03: Kiểm tra bộ lọc tháng
  it('TC-TK-FILTER-03: Kiểm tra bộ lọc tháng', () => {
    // Chọn tab Theo tháng
    cy.contains('label', 'Theo tháng').click();

    // Giả lập API doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 25000, tongDonHang: 2, tongDonHangTraLai: 0 },
          { thoiGian: 15, tongDoanhThu: 18500, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoThang');

    // Kiểm tra dropdown hiển thị đầy đủ 12 tháng
    cy.get('select.form-select').eq(0).find('option').should('have.length', 12);

    // Chọn tháng khác
    cy.get('select.form-select').eq(0).select('3');

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoThang');

    // Kiểm tra biểu đồ và số liệu tổng quan cập nhật
    cy.get('#container').should('be.visible');
    cy.get('.card-animate').eq(0).find('h4').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('be.visible');
  });

  // TC-TK-FILTER-04: Kiểm tra bộ lọc năm
  it('TC-TK-FILTER-04: Kiểm tra bộ lọc năm', () => {
    // Chọn tab Theo năm
    cy.contains('label', 'Theo năm').click();

    // Giả lập API doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 125000, tongDonHang: 5, tongDonHangTraLai: 1 },
          { thoiGian: 2, tongDoanhThu: 218500, tongDonHang: 8, tongDonHangTraLai: 0 }
        ]
      }
    }).as('getDoanhThuTheoNam');

    // Kiểm tra dropdown hiển thị các năm
    cy.get('select.form-select').eq(0).find('option').should('have.length.at.least', 1);

    // Chọn năm khác
    cy.get('select.form-select').eq(0).select('2023');

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNam');

    // Kiểm tra biểu đồ và số liệu tổng quan cập nhật
    cy.get('#container').should('be.visible');
    cy.get('.card-animate').eq(0).find('h4').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('be.visible');
  });

  // TC-TK-CHART-01: Kiểm tra hiển thị biểu đồ doanh thu theo ngày
  it('TC-TK-CHART-01: Kiểm tra hiển thị biểu đồ doanh thu theo ngày', () => {
    // Chọn tab Theo ngày
    cy.contains('label', 'Theo ngày').click();

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

    // Chọn ngày, tháng, năm cụ thể
    cy.get('select.form-select').eq(0).select('15');
    cy.get('select.form-select').eq(1).select('5');
    cy.get('select.form-select').eq(2).select('2024');

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNgay');

    // Kiểm tra biểu đồ hiển thị
    cy.get('#container').should('be.visible');
    cy.get('.highcharts-container').should('be.visible');
    cy.get('.highcharts-xaxis-labels').should('exist');
    cy.get('.highcharts-yaxis-labels').should('exist');
  });

  // TC-TK-EDGE-01: Kiểm tra hiển thị khi không có dữ liệu
  it('TC-TK-EDGE-01: Kiểm tra hiển thị khi không có dữ liệu', () => {
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

    // Kiểm tra biểu đồ vẫn hiển thị
    cy.get('#container').should('be.visible');
  });

  // TC-TK-EDGE-04: Kiểm tra hiển thị khi API trả về lỗi
  it('TC-TK-EDGE-04: Kiểm tra hiển thị khi API trả về lỗi', () => {
    // Giả lập API doanh thu theo ngày trả về lỗi
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 500,
      body: {
        status: 500,
        msg: 'Lỗi server.',
        data: null
      }
    }).as('getDoanhThuTheoNgayError');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgayError');

    // Kiểm tra hiển thị giá trị mặc định khi API lỗi
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '0');

    // Kiểm tra biểu đồ vẫn hiển thị
    cy.get('#container').should('be.visible');
  });
});
