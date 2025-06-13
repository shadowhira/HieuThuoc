// cypress/e2e/bao-cao-thong-ke/kiem-thu-hb-thong-ke.cy.js
// Kiểm thử hộp đen cho chức năng báo cáo thống kê

describe('Kiểm thử hộp đen - Báo cáo thống kê', () => {
  beforeEach(() => {
    // Sử dụng custom command để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('HB-TK-001: Kiểm tra hiển thị tổng quan ban đầu của giao diện thống kê', () => {
    // Kiểm tra thẻ thông tin Hóa đơn
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.get('.card-animate').eq(0).find('h4').should('be.visible');
    cy.get('.card-animate').eq(0).find('.avatar-sm').should('be.visible');
    
    // Kiểm tra thẻ thông tin Đơn hàng trả lại
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4').should('be.visible');
    cy.get('.card-animate').eq(1).find('.avatar-sm').should('be.visible');
    
    // Kiểm tra thẻ thông tin Doanh thu
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4').should('contain', 'VNĐ');
    cy.get('.card-animate').eq(2).find('.avatar-sm').should('be.visible');
    
    // Kiểm tra biểu đồ doanh thu
    cy.get('#container').should('be.visible');
    
    // Kiểm tra bộ lọc thời gian
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo năm').should('be.visible');
    
    // Kiểm tra dropdown chọn thời gian
    cy.get('select.form-select').should('have.length.at.least', 1);

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-001-tong-quan');
  });

  it('HB-TK-002: Kiểm tra hiển thị dữ liệu tổng quan chính xác', () => {
    // Kiểm tra thẻ thông tin Hóa đơn có dữ liệu
    cy.get('.card-animate').eq(0).find('h4 span').should('exist');
    
    // Kiểm tra thẻ thông tin Đơn hàng trả lại có dữ liệu
    cy.get('.card-animate').eq(1).find('h4 span').should('exist');
    
    // Kiểm tra thẻ thông tin Doanh thu có dữ liệu và đơn vị VNĐ
    cy.get('.card-animate').eq(2).find('h4 span').should('exist');
    cy.get('.card-animate').eq(2).find('h4').should('contain', 'VNĐ');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-002-du-lieu-tong-quan');
  });

  it('HB-TK-003: Kiểm tra chức năng lọc theo ngày', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn ngày, tháng, năm cụ thể
    cy.get('select.form-select').eq(0).select('15');
    cy.get('select.form-select').eq(1).select('6');
    cy.get('select.form-select').eq(2).select('2023');
    
    // Đợi dữ liệu cập nhật
    cy.wait(2000);
    
    // Kiểm tra biểu đồ cập nhật
    cy.get('#container').should('be.visible');
    
    // Kiểm tra các thẻ thông tin tổng quan cập nhật
    cy.get('.card-animate').eq(0).find('h4 span').should('exist');
    cy.get('.card-animate').eq(1).find('h4 span').should('exist');
    cy.get('.card-animate').eq(2).find('h4 span').should('exist');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-003-loc-theo-ngay');
  });

  it('HB-TK-004: Kiểm tra chức năng lọc theo tháng', () => {
    // Chọn loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Chọn tháng, năm cụ thể
    cy.get('select.form-select').eq(0).select('6');
    cy.get('select.form-select').eq(1).select('2023');
    
    // Đợi dữ liệu cập nhật
    cy.wait(2000);
    
    // Kiểm tra biểu đồ cập nhật
    cy.get('#container').should('be.visible');
    
    // Kiểm tra các thẻ thông tin tổng quan cập nhật
    cy.get('.card-animate').eq(0).find('h4 span').should('exist');
    cy.get('.card-animate').eq(1).find('h4 span').should('exist');
    cy.get('.card-animate').eq(2).find('h4 span').should('exist');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-004-loc-theo-thang');
  });

  it('HB-TK-005: Kiểm tra chức năng lọc theo năm', () => {
    // Chọn loại báo cáo "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Chọn năm cụ thể
    cy.get('select.form-select').eq(0).select('2023');
    
    // Đợi dữ liệu cập nhật
    cy.wait(2000);
    
    // Kiểm tra biểu đồ cập nhật
    cy.get('#container').should('be.visible');
    
    // Kiểm tra các thẻ thông tin tổng quan cập nhật
    cy.get('.card-animate').eq(0).find('h4 span').should('exist');
    cy.get('.card-animate').eq(1).find('h4 span').should('exist');
    cy.get('.card-animate').eq(2).find('h4 span').should('exist');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-005-loc-theo-nam');
  });

  it('HB-TK-006: Kiểm tra hiển thị biểu đồ doanh thu theo ngày', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Đợi biểu đồ hiển thị
    cy.get('#container').should('be.visible');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('exist');

    // Chụp ảnh màn hình biểu đồ
    cy.get('#container').screenshot('HB-TK-006-bieu-do-theo-ngay');
  });

  it('HB-TK-007: Kiểm tra hiển thị biểu đồ doanh thu theo tháng', () => {
    // Chọn loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Đợi biểu đồ hiển thị
    cy.get('#container').should('be.visible');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('exist');

    // Chụp ảnh màn hình biểu đồ
    cy.get('#container').screenshot('HB-TK-007-bieu-do-theo-thang');
  });

  it('HB-TK-008: Kiểm tra hiển thị biểu đồ doanh thu theo năm', () => {
    // Chọn loại báo cáo "Theo năm"
    cy.contains('label', 'Theo năm').click();
    
    // Đợi biểu đồ hiển thị
    cy.get('#container').should('be.visible');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('exist');

    // Chụp ảnh màn hình biểu đồ
    cy.get('#container').screenshot('HB-TK-008-bieu-do-theo-nam');
  });

  it('HB-TK-014: Kiểm tra chuyển đổi giữa các loại báo cáo', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    cy.wait(1000);
    cy.get('#container').should('be.visible');
    
    // Chuyển sang loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    cy.wait(1000);
    cy.get('#container').should('be.visible');
    
    // Chuyển sang loại báo cáo "Theo năm"
    cy.contains('label', 'Theo năm').click();
    cy.wait(1000);
    cy.get('#container').should('be.visible');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-014-chuyen-doi-loai-bao-cao');
  });

  it('HB-TK-017: Kiểm tra hiển thị dữ liệu hôm nay và hôm qua', () => {
    // Kiểm tra hiển thị dữ liệu hôm nay
    cy.contains('p', 'Hôm nay').should('be.visible');
    cy.get('.card-animate').eq(0).find('h4 span').should('exist');
    
    // Kiểm tra hiển thị dữ liệu hôm qua
    cy.contains('p', 'Hôm qua').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4 span').should('exist');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-017-du-lieu-hom-nay-hom-qua');
  });

  it('HB-TK-018: Kiểm tra hiển thị dữ liệu tháng này và tháng trước', () => {
    // Kiểm tra hiển thị dữ liệu tháng này
    cy.contains('p', 'Tháng này').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4 span').should('exist');
    
    // Kiểm tra hiển thị dữ liệu tháng trước
    cy.contains('p', 'Tháng trước').should('be.visible');
    cy.get('.card-animate').eq(3).find('h4 span').should('exist');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-018-du-lieu-thang-nay-thang-truoc');
  });

  it('HB-TK-020: Kiểm tra truy cập trang báo cáo thống kê khi chưa đăng nhập', () => {
    // Đăng xuất
    cy.clearCookies();
    cy.clearLocalStorage();
    
    // Thử truy cập trang báo cáo thống kê khi chưa đăng nhập
    cy.visit('/sys/thongke', { failOnStatusCode: false });
    
    // Kiểm tra chuyển hướng đến trang đăng nhập
    cy.url().should('include', '/login');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('HB-TK-020-truy-cap-khi-chua-dang-nhap');
  });
});
