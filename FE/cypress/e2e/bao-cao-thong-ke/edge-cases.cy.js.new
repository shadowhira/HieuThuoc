// cypress/e2e/bao-cao-thong-ke/edge-cases.cy.js
// Test kiểm tra các trường hợp ngoại lệ của trang báo cáo thống kê

describe('Báo cáo thống kê - Trường hợp ngoại lệ', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('Xử lý đúng khi không có dữ liệu', () => {
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

  it('Xử lý đúng khi API trả về lỗi', () => {
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

  it('Xử lý đúng khi API trả về dữ liệu không hợp lệ', () => {
    // Giả lập API doanh thu theo ngày trả về dữ liệu không hợp lệ
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: null // Dữ liệu null thay vì mảng
      }
    }).as('getDoanhThuTheoNgayInvalid');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgayInvalid');

    // Kiểm tra hiển thị giá trị mặc định khi dữ liệu không hợp lệ
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', '0');
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '0');

    // Kiểm tra biểu đồ vẫn hiển thị
    cy.get('#container').should('be.visible');
  });

  it('Xử lý đúng khi API trả về dữ liệu đặc biệt', () => {
    // Giả lập API doanh thu theo ngày trả về dữ liệu đặc biệt (giá trị âm, giá trị rất lớn)
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: -25000, tongDonHang: -2, tongDonHangTraLai: -1 }, // Giá trị âm
          { thoiGian: 10, tongDoanhThu: 9999999999, tongDonHang: 9999, tongDonHangTraLai: 9999 } // Giá trị rất lớn
        ]
      }
    }).as('getDoanhThuTheoNgaySpecial');

    // Tải lại trang để áp dụng giả lập API
    cy.visit('/sys/thongke');
    cy.wait('@getDoanhThuTheoNgaySpecial');

    // Kiểm tra biểu đồ vẫn hiển thị
    cy.get('#container').should('be.visible');
  });

  it('Xử lý đúng khi chọn ngày không tồn tại (31/02)', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn tháng 2
    cy.get('select.form-select').eq(1).select('2');

    // Kiểm tra dropdown ngày không có tùy chọn 31
    cy.get('select.form-select').eq(0).find('option').should('not.contain', '31');
  });

  it('Xử lý đúng khi chọn năm nhuận (29/02/2024)', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn tháng 2 năm 2024 (năm nhuận)
    cy.get('select.form-select').eq(1).select('2');
    cy.get('select.form-select').eq(2).select('2024');

    // Kiểm tra dropdown ngày có tùy chọn 29
    cy.get('select.form-select').eq(0).find('option').should('contain', '29');
  });

  it('Xử lý đúng khi chọn năm không nhuận (28/02/2023)', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn tháng 2 năm 2023 (năm không nhuận)
    cy.get('select.form-select').eq(1).select('2');
    cy.get('select.form-select').eq(2).select('2023');

    // Kiểm tra dropdown ngày không có tùy chọn 29
    cy.get('select.form-select').eq(0).find('option').should('not.contain', '29');
  });
});
