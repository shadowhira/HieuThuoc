// cypress/support/commands-thongke.js
// Custom commands cho trang báo cáo thống kê

// Custom command để đăng nhập qua UI
Cypress.Commands.add('loginUI', (username = 'admin', password = '123456') => {
  cy.visit('/login');

  // Kiểm tra xem đã ở trang đăng nhập chưa
  cy.url().should('include', '/login');

  // Đợi cho trang đăng nhập tải xong
  cy.get('#username').should('be.visible');
  cy.get('#password-input').should('be.visible');

  // Nhập thông tin đăng nhập
  cy.get('#username').clear().type(username);
  cy.get('#password-input').clear().type(password);

  // Nhấn nút đăng nhập
  cy.get('button.btn-success').contains('Đăng nhập').should('be.visible').click();

  // Đợi đăng nhập thành công và chuyển hướng
  cy.url({ timeout: 10000 }).should('not.include', '/login');

  // Thêm độ trễ để đảm bảo ứng dụng đã tải xong
  cy.wait(2000);
});

// Custom command để đăng nhập qua API (hiệu quả hơn)
Cypress.Commands.add('loginAPI', (username = 'admin', password = '123456') => {
  // Xử lý lỗi nếu API không khả dụng
  cy.request({
    method: 'POST',
    url: '/hieuthuoc/api/auth/dangnhap',
    failOnStatusCode: false,
    body: {
      tenDangNhap: username,
      matKhau: password
    }
  }).then((response) => {
    // Kiểm tra response status
    if (response.status === 200 && response.body.data) {
      // Lưu token vào localStorage
      const token = response.body.data;
      window.localStorage.setItem('ACCESS_TOKEN', token);

      // Truy cập trang chủ sau khi đăng nhập
      cy.visit('/');

      // Thêm độ trễ để đảm bảo ứng dụng đã tải xong
      cy.wait(2000);
    } else {
      // Nếu API đăng nhập thất bại, sử dụng đăng nhập qua UI
      cy.log('API login failed, falling back to UI login');
      cy.loginUI(username, password);
    }
  }).catch((err) => {
    // Nếu có lỗi khi gọi API, sử dụng đăng nhập qua UI
    cy.log('API login error, falling back to UI login');
    cy.loginUI(username, password);
  });
});

// Custom command để truy cập trang báo cáo thống kê sau khi đăng nhập
Cypress.Commands.add('visitThongKe', (loginMethod = 'UI') => {
  // Đăng nhập trước khi truy cập trang báo cáo thống kê
  if (loginMethod === 'API') {
    cy.loginAPI();
  } else {
    cy.loginUI();
  }

  // Truy cập trang báo cáo thống kê
  cy.visit('/sys/thongke', { timeout: 10000 });

  // Đợi cho trang tải xong
  cy.get('.page-content', { timeout: 10000 }).should('be.visible');

  // Thêm độ trễ để đảm bảo trang đã tải hoàn toàn
  cy.wait(1000);
});

// Custom command để kiểm tra tính chính xác của dữ liệu
Cypress.Commands.add('verifyRevenueData', (expectedHoaDon, expectedDonHangTraLai, expectedDoanhThu) => {
  // Kiểm tra số lượng hóa đơn
  if (expectedHoaDon !== null) {
    cy.get('.card-animate').eq(0).find('h4 span').should('contain', expectedHoaDon);
  }

  // Kiểm tra số lượng đơn hàng trả lại
  if (expectedDonHangTraLai !== null) {
    cy.get('.card-animate').eq(1).find('h4 span').should('contain', expectedDonHangTraLai);
  }

  // Kiểm tra tổng doanh thu
  if (expectedDoanhThu !== null) {
    cy.get('.card-animate').eq(2).find('h4 span').should('contain', expectedDoanhThu);
  }
});

// Custom command để chọn loại báo cáo và thời gian
Cypress.Commands.add('selectReportType', (type, options = {}) => {
  // Chọn loại báo cáo (NGAY, THANG, NAM)
  if (type === 'NGAY') {
    cy.contains('label', 'Theo ngày').click();
  } else if (type === 'THANG') {
    cy.contains('label', 'Theo tháng').click();
  } else if (type === 'NAM') {
    cy.contains('label', 'Theo năm').click();
  }

  // Chọn ngày nếu có
  if (options.ngay && type === 'NGAY') {
    cy.get('select.form-select').eq(0).select(options.ngay.toString());
  }

  // Chọn tháng nếu có
  if (options.thang && (type === 'NGAY' || type === 'THANG')) {
    const thangIndex = type === 'NGAY' ? 1 : 0;
    cy.get('select.form-select').eq(thangIndex).select(options.thang.toString());
  }

  // Chọn năm nếu có
  if (options.nam) {
    const namIndex = type === 'NGAY' ? 2 : (type === 'THANG' ? 1 : 0);
    cy.get('select.form-select').eq(namIndex).select(options.nam.toString());
  }
});

// Custom command để giả lập API doanh thu theo ngày
Cypress.Commands.add('mockDoanhThuTheoNgay', (data) => {
  cy.intercept('GET', '**/baocao/doanhthutheongay*', {
    statusCode: 200,
    body: {
      status: 200,
      msg: 'Thành công.',
      data: data
    }
  }).as('getDoanhThuTheoNgay');
});

// Custom command để giả lập API doanh thu theo tháng
Cypress.Commands.add('mockDoanhThuTheoThang', (data) => {
  cy.intercept('GET', '**/baocao/doanhthutheothang*', {
    statusCode: 200,
    body: {
      status: 200,
      msg: 'Thành công.',
      data: data
    }
  }).as('getDoanhThuTheoThang');
});

// Custom command để giả lập API doanh thu theo năm
Cypress.Commands.add('mockDoanhThuTheoNam', (data) => {
  cy.intercept('GET', '**/baocao/doanhthutheonam*', {
    statusCode: 200,
    body: {
      status: 200,
      msg: 'Thành công.',
      data: data
    }
  }).as('getDoanhThuTheoNam');
});

// Custom command để kiểm tra hiển thị biểu đồ
Cypress.Commands.add('verifyChart', () => {
  // Kiểm tra container biểu đồ hiển thị
  cy.get('#container').should('be.visible');

  // Kiểm tra component highcharts-chart hiển thị
  cy.get('highcharts-chart').should('be.visible');
});

// Custom command để kiểm tra hiển thị trên các kích thước màn hình khác nhau
Cypress.Commands.add('verifyResponsive', () => {
  // Kiểm tra trên desktop
  cy.viewport(1920, 1080);
  cy.get('#container').should('be.visible');
  cy.screenshot('desktop-view');

  // Kiểm tra trên tablet
  cy.viewport(768, 1024);
  cy.get('#container').should('be.visible');
  cy.screenshot('tablet-view');

  // Kiểm tra trên mobile
  cy.viewport(375, 667);
  cy.get('#container').should('be.visible');
  cy.screenshot('mobile-view');
});
