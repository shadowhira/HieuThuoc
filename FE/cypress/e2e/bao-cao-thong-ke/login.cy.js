// cypress/e2e/bao-cao-thong-ke/login.cy.js
// Test kiểm tra chức năng đăng nhập và truy cập trang báo cáo thống kê

describe('Đăng nhập và truy cập trang báo cáo thống kê', () => {
  beforeEach(() => {
    // Xóa cookies và localStorage trước mỗi test
    cy.clearCookies();
    cy.clearLocalStorage();

    // Truy cập trang đăng nhập
    cy.visit('/login');

    // Đợi cho trang đăng nhập tải xong
    cy.get('#username').should('be.visible');
  });

  it('Đăng nhập thành công và truy cập trang báo cáo thống kê', () => {
    // Nhập thông tin đăng nhập
    cy.get('#username').should('be.visible').clear().type('admin');
    cy.get('#password-input').should('be.visible').clear().type('123456');

    // Nhấn nút đăng nhập
    cy.get('button.btn-success').contains('Đăng nhập').should('be.visible').click();

    // Đợi đăng nhập thành công và chuyển hướng
    cy.url().should('not.include', '/login');

    // Thêm độ trễ để đảm bảo ứng dụng đã tải xong
    cy.wait(2000);

    // Truy cập trang báo cáo thống kê
    cy.visit('/sys/thongke', { timeout: 10000 });

    // Đợi cho trang tải xong
    cy.get('.page-content', { timeout: 10000 }).should('be.visible');

    // Kiểm tra tiêu đề trang
    cy.contains('h4', 'Doanh thu').should('be.visible');

    // Chụp ảnh màn hình trang báo cáo thống kê
    cy.screenshot('bao-cao-thong-ke-after-login');
  });

  it('Đăng nhập thất bại không thể truy cập trang báo cáo thống kê', () => {
    // Nhập thông tin đăng nhập sai
    cy.get('#username').clear().type('admin');
    cy.get('#password-input').clear().type('wrong_password');

    // Nhấn nút đăng nhập
    cy.get('button.btn-success').contains('Đăng nhập').click();

    // Kiểm tra vẫn ở trang đăng nhập
    cy.url().should('include', '/login');

    // Thử truy cập trang báo cáo thống kê
    cy.visit('/sys/thongke', { failOnStatusCode: false });

    // Kiểm tra chuyển hướng đến trang lỗi hoặc trang đăng nhập
    cy.url().should('not.include', '/sys/thongke');
  });

  it('Truy cập trang báo cáo thống kê khi chưa đăng nhập', () => {
    // Thử truy cập trang báo cáo thống kê khi chưa đăng nhập
    cy.visit('/sys/thongke', { failOnStatusCode: false });

    // Kiểm tra chuyển hướng đến trang lỗi hoặc trang đăng nhập
    cy.url().should('not.include', '/sys/thongke');
  });

  it('Sử dụng custom command loginUI để đăng nhập', () => {
    // Sử dụng custom command để đăng nhập
    cy.loginUI();

    // Truy cập trang báo cáo thống kê
    cy.visit('/sys/thongke');

    // Đợi cho trang tải xong
    cy.get('.page-content').should('be.visible');

    // Kiểm tra tiêu đề trang
    cy.contains('h4', 'Doanh thu').should('be.visible');
  });
});
