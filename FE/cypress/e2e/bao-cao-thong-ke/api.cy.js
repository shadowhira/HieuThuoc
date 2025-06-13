// cypress/e2e/bao-cao-thong-ke/api.cy.js
// Test kiểm tra các API của trang báo cáo thống kê

describe('Báo cáo thống kê - API', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('Gọi API doanh thu theo ngày đúng endpoint và tham số', () => {
    // Giả lập API doanh thu theo ngày
    cy.intercept('GET', '**/baocao/doanhthutheongay*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: []
      }
    }).as('getDoanhThuTheoNgay');

    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNgay').then((interception) => {
      // Kiểm tra URL chứa endpoint đúng
      expect(interception.request.url).to.include('/baocao/doanhthutheongay');

      // Kiểm tra URL chứa tham số ngày
      expect(interception.request.url).to.include('ngay=');
    });
  });

  it('Gọi API doanh thu theo tháng đúng endpoint và tham số', () => {
    // Giả lập API doanh thu theo tháng
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: []
      }
    }).as('getDoanhThuTheoThang');

    // Chọn loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoThang').then((interception) => {
      // Kiểm tra URL chứa endpoint đúng
      expect(interception.request.url).to.include('/baocao/doanhthutheothang');

      // Kiểm tra URL chứa tham số tháng và năm
      expect(interception.request.url).to.include('thang=');
      expect(interception.request.url).to.include('nam=');
    });
  });

  it('Gọi API doanh thu theo năm đúng endpoint và tham số', () => {
    // Giả lập API doanh thu theo năm
    cy.intercept('GET', '**/baocao/doanhthutheonam*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: []
      }
    }).as('getDoanhThuTheoNam');

    // Chọn loại báo cáo "Theo năm"
    cy.contains('label', 'Theo năm').click();

    // Đợi API được gọi
    cy.wait('@getDoanhThuTheoNam').then((interception) => {
      // Kiểm tra URL chứa endpoint đúng
      expect(interception.request.url).to.include('/baocao/doanhthutheonam');

      // Kiểm tra URL chứa tham số năm
      expect(interception.request.url).to.include('nam=');
    });
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
});
