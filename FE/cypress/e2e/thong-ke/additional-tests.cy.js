// cypress/e2e/thong-ke/additional-tests.cy.js
// Test kiểm thử bổ sung cho trang báo cáo thống kê

describe('Kiểm thử bổ sung cho báo cáo thống kê', () => {
  beforeEach(() => {
    // Đăng nhập và truy cập trang thống kê
    cy.visitThongKe();
  });

  it('UI-17: Kiểm tra hiển thị với các trình duyệt khác nhau', () => {
    // Kiểm tra hiển thị các thành phần chính
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('highcharts-chart').should('be.visible');

    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('browser-compatibility-test');
  });

  it('UI-18: Kiểm tra hiển thị với tháng có 28/29/30/31 ngày', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Kiểm tra tháng 2 (28 hoặc 29 ngày)
    cy.get('select.form-select').eq(0).select('2');
    cy.get('select.form-select').eq(1).select('2024'); // 2024 là năm nhuận
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('february-leap-year');

    // Kiểm tra tháng 4 (30 ngày)
    cy.get('select.form-select').eq(0).select('4');
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('april-30-days');

    // Kiểm tra tháng 5 (31 ngày)
    cy.get('select.form-select').eq(0).select('5');
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('may-31-days');
  });

  it('UI-19: Kiểm tra hiển thị khi chuyển đổi giữa các năm nhuận và không nhuận', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Chọn tháng 2 năm 2024 (năm nhuận)
    cy.get('select.form-select').eq(0).select('2');
    cy.get('select.form-select').eq(1).select('2024');
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('february-2024-leap-year');

    // Chọn tháng 2 năm 2023 (năm không nhuận)
    cy.get('select.form-select').eq(1).select('2023');
    cy.wait(1000);
    cy.get('highcharts-chart').should('be.visible');
    cy.screenshot('february-2023-non-leap-year');
  });

  it('UI-21: Kiểm tra hiển thị khi chọn ngày trong tương lai', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Lấy ngày hiện tại
    const today = new Date();
    const currentDay = today.getDate();
    const currentMonth = today.getMonth() + 1;
    const currentYear = today.getFullYear();

    // Chọn ngày trong tương lai (ngày mai)
    const tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    const tomorrowDay = tomorrow.getDate().toString();

    // Chọn ngày mai
    cy.get('select.form-select').eq(0).select(tomorrowDay);
    cy.wait(1000);

    // Kiểm tra hiển thị biểu đồ
    cy.get('highcharts-chart').should('be.visible');

    // Kiểm tra dữ liệu hiển thị (có thể là 0 hoặc không có dữ liệu)
    cy.get('.card-animate').eq(0).find('h4 span').should('be.visible');
    cy.get('.card-animate').eq(1).find('h4 span').should('be.visible');
    cy.get('.card-animate').eq(2).find('h4 span').should('be.visible');
  });

  it('UI-22: Kiểm tra hiển thị khi chọn ngày không hợp lệ', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn tháng 2
    cy.get('select.form-select').eq(1).select('2');
    
    // Chọn năm 2023 (không phải năm nhuận)
    cy.get('select.form-select').eq(2).select('2023');
    
    // Kiểm tra không có ngày 29, 30, 31 trong dropdown
    cy.get('select.form-select').eq(0).find('option').should('have.length', 28);
    
    // Chọn năm 2024 (năm nhuận)
    cy.get('select.form-select').eq(2).select('2024');
    
    // Kiểm tra có ngày 29 trong dropdown
    cy.get('select.form-select').eq(0).find('option').should('have.length', 29);
  });

  it('UI-23: Kiểm tra hiển thị khi chuyển đổi nhanh giữa các bộ lọc', () => {
    // Chuyển đổi nhanh giữa các tab
    cy.contains('label', 'Theo ngày').click();
    cy.wait(500);
    cy.contains('label', 'Theo tháng').click();
    cy.wait(500);
    cy.contains('label', 'Theo năm').click();
    cy.wait(500);
    cy.contains('label', 'Theo ngày').click();
    
    // Kiểm tra biểu đồ vẫn hiển thị sau khi chuyển đổi nhanh
    cy.get('highcharts-chart').should('be.visible');
    
    // Chuyển đổi nhanh giữa các tháng
    cy.contains('label', 'Theo tháng').click();
    cy.get('select.form-select').eq(0).select('1');
    cy.wait(300);
    cy.get('select.form-select').eq(0).select('2');
    cy.wait(300);
    cy.get('select.form-select').eq(0).select('3');
    
    // Kiểm tra biểu đồ vẫn hiển thị sau khi chuyển đổi nhanh
    cy.get('highcharts-chart').should('be.visible');
  });

  it('UI-25: Kiểm tra hiển thị khi mất kết nối internet', () => {
    // Giả lập mất kết nối internet bằng cách chặn tất cả các request API
    cy.intercept('GET', '**/baocao/**', {
      statusCode: 0,
      body: 'Failed to connect',
      forceNetworkError: true
    }).as('networkError');
    
    // Tải lại trang
    cy.reload();
    
    // Kiểm tra giao diện vẫn hiển thị
    cy.contains('h4', 'Doanh thu').should('be.visible');
    
    // Kiểm tra các thẻ thông tin vẫn hiển thị (có thể không có dữ liệu)
    cy.get('.card-animate').should('have.length', 3);
  });

  it('UI-27: Kiểm tra hiển thị khi thay đổi kích thước font của trình duyệt', () => {
    // Thay đổi kích thước font bằng cách thay đổi zoom của trang
    cy.viewport(1280, 720);
    cy.get('html').invoke('attr', 'style', 'font-size: 120%');
    
    // Kiểm tra các thành phần vẫn hiển thị đúng
    cy.contains('p', 'Hóa đơn').should('be.visible');
    cy.contains('p', 'Đơn hàng trả lại').should('be.visible');
    cy.contains('p', 'Doanh thu').should('be.visible');
    cy.get('highcharts-chart').should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('font-size-increased');
    
    // Khôi phục kích thước font
    cy.get('html').invoke('attr', 'style', 'font-size: 100%');
  });

  it('UI-28: Kiểm tra hiển thị khi chọn nhiều bộ lọc cùng lúc', () => {
    // Chọn tab "Theo ngày"
    cy.contains('label', 'Theo ngày').click();
    
    // Chọn nhiều bộ lọc cùng lúc
    cy.get('select.form-select').eq(0).select('15');
    cy.get('select.form-select').eq(1).select('5');
    cy.get('select.form-select').eq(2).select('2024');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Chụp ảnh màn hình để kiểm tra trực quan
    cy.screenshot('multiple-filters');
  });

  it('UI-32: Kiểm tra hiển thị khi phóng to/thu nhỏ trang (zoom)', () => {
    // Kiểm tra với các mức zoom khác nhau
    // Zoom 75%
    cy.viewport(1280 * 0.75, 720 * 0.75);
    cy.wait(1000);
    cy.screenshot('zoom-75-percent');
    
    // Zoom 100%
    cy.viewport(1280, 720);
    cy.wait(1000);
    cy.screenshot('zoom-100-percent');
    
    // Zoom 125%
    cy.viewport(1280 * 1.25, 720 * 1.25);
    cy.wait(1000);
    cy.screenshot('zoom-125-percent');
    
    // Kiểm tra biểu đồ vẫn hiển thị ở tất cả các mức zoom
    cy.get('highcharts-chart').should('be.visible');
  });

  it('UI-34: Kiểm tra hiển thị khi có dữ liệu rất nhỏ', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Tạo dữ liệu có giá trị rất nhỏ
    const smallData = [
      { thoiGian: 1, tongDoanhThu: 100, tongDonHang: 1, tongDonHangTraLai: 0 },
      { thoiGian: 5, tongDoanhThu: 50, tongDonHang: 1, tongDonHangTraLai: 0 },
      { thoiGian: 10, tongDoanhThu: 75, tongDonHang: 1, tongDonHangTraLai: 0 }
    ];
    
    // Giả lập API doanh thu theo tháng với dữ liệu nhỏ
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: smallData
      }
    }).as('getDoanhThuTheoThangSmall');
    
    // Chọn tháng có dữ liệu nhỏ
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThangSmall');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra tổng doanh thu nhỏ
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', '225');
  });

  it('UI-35: Kiểm tra hiển thị khi có dữ liệu rất lớn', () => {
    // Chọn tab "Theo tháng"
    cy.contains('label', 'Theo tháng').click();
    
    // Tạo dữ liệu có giá trị rất lớn
    const largeData = [
      { thoiGian: 1, tongDoanhThu: 9999999999, tongDonHang: 1000, tongDonHangTraLai: 0 },
      { thoiGian: 5, tongDoanhThu: 8888888888, tongDonHang: 900, tongDonHangTraLai: 0 },
      { thoiGian: 10, tongDoanhThu: 7777777777, tongDonHang: 800, tongDonHangTraLai: 0 }
    ];
    
    // Giả lập API doanh thu theo tháng với dữ liệu lớn
    cy.intercept('GET', '**/baocao/doanhthutheothang*', {
      statusCode: 200,
      body: {
        status: 200,
        msg: 'Thành công.',
        data: largeData
      }
    }).as('getDoanhThuTheoThangLarge');
    
    // Chọn tháng có dữ liệu lớn
    cy.get('select.form-select').eq(0).select('5');
    cy.get('select.form-select').eq(1).select('2025');
    cy.wait('@getDoanhThuTheoThangLarge');
    
    // Kiểm tra biểu đồ hiển thị
    cy.get('highcharts-chart').should('be.visible');
    
    // Kiểm tra tổng doanh thu lớn
    cy.get('.card-animate').eq(2).find('h4 span').should('be.visible');
  });
});
