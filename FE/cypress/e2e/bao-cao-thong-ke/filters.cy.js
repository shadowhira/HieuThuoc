// cypress/e2e/bao-cao-thong-ke/filters.cy.js
// Test kiểm tra các bộ lọc thời gian của trang báo cáo thống kê

describe('Báo cáo thống kê - Bộ lọc thời gian', () => {
  beforeEach(() => {
    // Sử dụng command mới để đăng nhập và truy cập trang báo cáo thống kê
    cy.visitThongKe();
  });

  it('Hiển thị đúng các tùy chọn loại báo cáo', () => {
    // Kiểm tra hiển thị tùy chọn "Theo ngày"
    cy.contains('label', 'Theo ngày').should('be.visible');
    cy.contains('label', 'Theo ngày').find('input[type="radio"]').should('exist');

    // Kiểm tra hiển thị tùy chọn "Theo tháng"
    cy.contains('label', 'Theo tháng').should('be.visible');
    cy.contains('label', 'Theo tháng').find('input[type="radio"]').should('exist');

    // Kiểm tra hiển thị tùy chọn "Theo năm"
    cy.contains('label', 'Theo năm').should('be.visible');
    cy.contains('label', 'Theo năm').find('input[type="radio"]').should('exist');
  });

  it('Chọn loại báo cáo "Theo ngày" hiển thị đúng các dropdown', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Kiểm tra hiển thị dropdown chọn ngày
    cy.get('select.form-select').eq(0).should('be.visible');

    // Kiểm tra hiển thị dropdown chọn tháng
    cy.get('select.form-select').eq(1).should('be.visible');

    // Kiểm tra hiển thị dropdown chọn năm
    cy.get('select.form-select').eq(2).should('be.visible');
  });

  it('Chọn loại báo cáo "Theo tháng" hiển thị đúng các dropdown', () => {
    // Chọn loại báo cáo "Theo tháng"
    cy.contains('label', 'Theo tháng').click();

    // Kiểm tra không hiển thị dropdown chọn ngày
    cy.get('select.form-select').should('have.length', 2);

    // Kiểm tra hiển thị dropdown chọn tháng
    cy.get('select.form-select').eq(0).should('be.visible');

    // Kiểm tra hiển thị dropdown chọn năm
    cy.get('select.form-select').eq(1).should('be.visible');
  });

  it('Chọn loại báo cáo "Theo năm" hiển thị đúng các dropdown', () => {
    // Chọn loại báo cáo "Theo năm"
    cy.contains('label', 'Theo năm').click();

    // Kiểm tra không hiển thị dropdown chọn ngày và tháng
    cy.get('select.form-select').should('have.length', 1);

    // Kiểm tra hiển thị dropdown chọn năm
    cy.get('select.form-select').eq(0).should('be.visible');
  });

  it('Thay đổi ngày trong báo cáo "Theo ngày" gọi API đúng', () => {
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

    // Chọn ngày 15
    cy.get('select.form-select').eq(0).select('15');

    // Kiểm tra API được gọi với tham số đúng
    cy.wait('@getDoanhThuTheoNgay').its('request.url').should('include', 'ngay=');
  });

  it('Thay đổi tháng trong báo cáo "Theo tháng" gọi API đúng', () => {
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

    // Chọn tháng 3
    cy.get('select.form-select').eq(0).select('3');

    // Kiểm tra API được gọi với tham số đúng
    cy.wait('@getDoanhThuTheoThang').its('request.url').should('include', 'thang=');
  });

  it('Thay đổi năm trong báo cáo "Theo năm" gọi API đúng', () => {
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

    // Chọn năm 2023
    cy.get('select.form-select').eq(0).select('2023');

    // Kiểm tra API được gọi với tham số đúng
    cy.wait('@getDoanhThuTheoNam').its('request.url').should('include', 'nam=');
  });

  it('Hiển thị đúng số ngày trong tháng khi chọn tháng khác nhau', () => {
    // Chọn loại báo cáo "Theo ngày"
    cy.contains('label', 'Theo ngày').click();

    // Chọn tháng 2 năm 2024 (tháng 2 năm nhuận có 29 ngày)
    cy.get('select.form-select').eq(1).select('2');
    cy.get('select.form-select').eq(2).select('2024');

    // Kiểm tra dropdown ngày có 29 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 29);

    // Chọn tháng 4 năm 2024 (tháng 4 có 30 ngày)
    cy.get('select.form-select').eq(1).select('4');

    // Kiểm tra dropdown ngày có 30 tùy chọn
    cy.get('select.form-select').eq(0).find('option').should('have.length', 30);
  });
});
