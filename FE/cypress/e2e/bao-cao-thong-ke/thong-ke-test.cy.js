// cypress/e2e/bao-cao-thong-ke/thong-ke-test.cy.js
// Test kiểm thử hộp đen cho chức năng báo cáo thống kê

describe('Báo cáo thống kê - Kiểm thử hộp đen', () => {
  beforeEach(() => {
    // Sử dụng command để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();

    // Đợi cho trang tải xong
    cy.get('.page-content').should('be.visible');
  });

  describe('Kiểm tra giao diện chung', () => {
    it('Kiểm tra tổng thể giao diện màn hình Báo cáo thống kê (TC-TK-0001)', () => {
      // Kiểm tra các thành phần chính của giao diện
      cy.get('.page-content').should('be.visible');
      cy.get('.card-animate').should('have.length', 3);
      cy.get('#container').should('be.visible');
      
      // Kiểm tra font chữ và màu sắc
      cy.get('.text-uppercase.fw-medium.text-muted.mb-0').should('have.css', 'font-family');
      cy.get('.card-animate').should('have.css', 'background-color');
    });

    it('Kiểm tra bố cục giao diện màn hình Báo cáo thống kê (TC-TK-0002)', () => {
      // Kiểm tra tiêu đề
      cy.get('.card-title').should('contain', 'Doanh thu');
      
      // Kiểm tra thẻ thông tin
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

    it('Kiểm tra thứ tự di chuyển trỏ trên màn hình khi nhấn phím Tab (TC-TK-0003)', () => {
      // Kiểm tra thứ tự di chuyển trỏ khi nhấn Tab
      cy.contains('label', 'Theo ngày').find('input[type="radio"]').focus();
      cy.tab();
      cy.focused().should('contain', 'Theo tháng');
      cy.tab();
      cy.focused().should('contain', 'Theo năm');
    });

    it('Kiểm tra giao diện khi thu nhỏ, phóng to (TC-TK-0005)', () => {
      // Kiểm tra khi thu nhỏ
      cy.viewport(800, 600);
      cy.get('.page-content').should('be.visible');
      cy.get('.card-animate').should('have.length', 3);
      
      // Kiểm tra khi phóng to
      cy.viewport(1920, 1080);
      cy.get('.page-content').should('be.visible');
      cy.get('.card-animate').should('have.length', 3);
    });
  });

  describe('Kiểm tra hiển thị thông tin tổng quan', () => {
    it('Kiểm tra hiển thị thẻ thông tin Hóa đơn (TC-TK-0007)', () => {
      // Kiểm tra thẻ thông tin Hóa đơn
      cy.contains('p', 'Hóa đơn').should('be.visible');
      cy.get('.card-animate').eq(0).find('h4').should('be.visible');
      cy.get('.card-animate').eq(0).find('.avatar-sm').should('be.visible');
    });

    it('Kiểm tra hiển thị thẻ thông tin Đơn hàng trả lại (TC-TK-0008)', () => {
      // Kiểm tra thẻ thông tin Đơn hàng trả lại
      cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
      cy.get('.card-animate').eq(1).find('h4').should('be.visible');
      cy.get('.card-animate').eq(1).find('.avatar-sm').should('be.visible');
    });

    it('Kiểm tra hiển thị thẻ thông tin Doanh thu (TC-TK-0009)', () => {
      // Kiểm tra thẻ thông tin Doanh thu
      cy.contains('p', 'Doanh thu').should('be.visible');
      cy.get('.card-animate').eq(2).find('h4').should('be.visible');
      cy.get('.card-animate').eq(2).find('h4 span').should('contain', 'VNĐ');
      cy.get('.card-animate').eq(2).find('.avatar-sm').should('be.visible');
    });

    it('Kiểm tra định dạng số và đơn vị tiền tệ (TC-TK-0010)', () => {
      // Giả lập API doanh thu theo ngày
      cy.intercept('GET', '**/baocao/doanhthutheongay*', {
        statusCode: 200,
        body: {
          status: 200,
          msg: 'Thành công.',
          data: [
            { thoiGian: 8, tongDoanhThu: 1234567, tongDonHang: 2, tongDonHangTraLai: 1 }
          ]
        }
      }).as('getDoanhThuTheoNgay');
      
      // Tải lại trang để áp dụng giả lập API
      cy.visit('/sys/thongke');
      cy.wait('@getDoanhThuTheoNgay');
      
      // Kiểm tra định dạng số và đơn vị tiền tệ
      cy.get('.card-animate').eq(2).find('h4 span').should('contain', '1,234,567');
      cy.get('.card-animate').eq(2).find('h4 span').should('contain', 'VNĐ');
    });
  });

  describe('Kiểm tra hiển thị biểu đồ', () => {
    it('Kiểm tra hiển thị container biểu đồ (TC-TK-0011)', () => {
      // Kiểm tra container biểu đồ
      cy.get('#container').should('be.visible');
      cy.get('.highcharts-container').should('be.visible');
    });

    it('Kiểm tra hiển thị trục X và trục Y (TC-TK-0012)', () => {
      // Kiểm tra trục X và trục Y
      cy.get('.highcharts-xaxis-labels').should('be.visible');
      cy.get('.highcharts-yaxis-labels').should('be.visible');
    });
  });

  describe('Kiểm thử bộ lọc thời gian', () => {
    it('Kiểm tra hiển thị tùy chọn loại báo cáo (TC-TK-0014)', () => {
      // Kiểm tra hiển thị tùy chọn loại báo cáo
      cy.contains('label', 'Theo ngày').should('be.visible');
      cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('exist');
      
      cy.contains('label', 'Theo tháng').should('be.visible');
      cy.contains('label', 'Theo tháng').find('input[type="radio"]').should('exist');
      
      cy.contains('label', 'Theo năm').should('be.visible');
      cy.contains('label', 'Theo năm').find('input[type="radio"]').should('exist');
    });

    it('Kiểm tra chọn loại báo cáo "Theo ngày" (TC-TK-0016)', () => {
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
      cy.wait('@getDoanhThuTheoNgay');
      
      // Kiểm tra hiển thị dropdown
      cy.get('select.form-select').should('have.length.at.least', 3);
    });

    it('Kiểm tra chọn loại báo cáo "Theo tháng" (TC-TK-0017)', () => {
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
      cy.wait('@getDoanhThuTheoThang');
      
      // Kiểm tra hiển thị dropdown
      cy.get('select.form-select').should('have.length.at.least', 2);
    });

    it('Kiểm tra chọn loại báo cáo "Theo năm" (TC-TK-0018)', () => {
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
      cy.wait('@getDoanhThuTheoNam');
      
      // Kiểm tra hiển thị dropdown
      cy.get('select.form-select').should('have.length', 1);
    });
  });

  describe('Kiểm thử trường hợp đặc biệt và ngoại lệ', () => {
    it('Kiểm tra hiển thị khi không có dữ liệu doanh thu theo ngày (TC-TK-0032)', () => {
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

    it('Kiểm tra xử lý khi API doanh thu theo ngày trả về lỗi (TC-TK-0033)', () => {
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

    it('Kiểm tra xử lý khi dữ liệu có giá trị rất lớn (TC-TK-0035)', () => {
      // Giả lập API doanh thu theo ngày trả về dữ liệu có giá trị rất lớn
      cy.intercept('GET', '**/baocao/doanhthutheongay*', {
        statusCode: 200,
        body: {
          status: 200,
          msg: 'Thành công.',
          data: [
            { thoiGian: 8, tongDoanhThu: 9999999999, tongDonHang: 9999, tongDonHangTraLai: 9999 }
          ]
        }
      }).as('getDoanhThuTheoNgayLarge');
      
      // Tải lại trang để áp dụng giả lập API
      cy.visit('/sys/thongke');
      cy.wait('@getDoanhThuTheoNgayLarge');
      
      // Kiểm tra hiển thị giá trị lớn
      cy.get('.card-animate').eq(0).find('h4 span').should('contain', '9999');
      cy.get('.card-animate').eq(1).find('h4 span').should('contain', '9999');
      cy.get('.card-animate').eq(2).find('h4 span').should('contain', '9,999,999,999');
      
      // Kiểm tra biểu đồ vẫn hiển thị
      cy.get('#container').should('be.visible');
    });
  });

  // Chụp ảnh màn hình để kiểm tra trực quan
  it('Chụp ảnh màn hình trang báo cáo thống kê (TC-TK-0038)', () => {
    // Chụp ảnh màn hình toàn bộ trang
    cy.screenshot('bao-cao-thong-ke-full');
    
    // Chụp ảnh màn hình phần biểu đồ
    cy.get('#container').screenshot('bao-cao-thong-ke-chart');
  });
});
