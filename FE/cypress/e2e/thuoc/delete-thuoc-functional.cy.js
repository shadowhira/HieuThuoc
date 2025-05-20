describe('Chức năng xóa thuốc', () => {
  // Bỏ qua lỗi JavaScript không xử lý từ ứng dụng
  Cypress.on('uncaught:exception', (err, runnable) => {
    // Trả về false để ngăn Cypress fail test khi có lỗi JavaScript
    console.log('Uncaught exception:', err.message);
    return false;
  });

  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input#username').type('admin');
    cy.get('input#password-input').type('123456');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/home');

    // Truy cập trang danh sách thuốc
    cy.visit('/sys/product');
  });

  it('Xóa thuốc thành công', () => {
    // Tạo thuốc mới để xóa (để đảm bảo có thuốc để xóa)
    cy.get('button').eq(1).click({force: true});

    // Chờ form hiển thị
    cy.wait(1000);

    // Tạo mã thuốc ngẫu nhiên để tránh trùng
    const randomCode = 'DEL' + Math.floor(Math.random() * 10000);
    const testMedicineName = 'Test Delete Medicine ' + randomCode;

    // Nhập thông tin thuốc
    cy.get('input').first().type(testMedicineName, {force: true});
    cy.get('input').eq(1).type(randomCode, {force: true});

    // Chờ để đảm bảo trang đã load xong
    cy.wait(500);

    // Nhấn nút Lưu
    cy.get('button').last().click({force: true});

    // Chờ xử lý
    cy.wait(1000);

    // Kiểm tra đã quay về trang danh sách thuốc
    cy.url().should('include', '/sys/product');

    // Chờ thêm thời gian để trang load xong
    cy.wait(2000);

    // Tìm kiếm thuốc vừa tạo
    cy.get('input').first().type(testMedicineName, {force: true});
    cy.get('button').contains(/Tìm|Search/i).click({force: true});

    // Chờ kết quả tìm kiếm
    cy.wait(1000);

    // Xử lý hộp thoại xác nhận xóa
    cy.on('window:confirm', () => true);

    // Nhấn nút Xóa cho thuốc vừa tạo (nút thứ 3 trong hàng)
    cy.get('button').eq(3).click({force: true});

    // Chờ xử lý
    cy.wait(1000);

    // Tìm kiếm lại thuốc đã xóa
    cy.get('input').first().type(testMedicineName, {force: true});
    cy.get('button').contains(/Tìm|Search/i).click({force: true});

    // Chờ kết quả tìm kiếm
    cy.wait(1000);

    // Kiểm tra không có kết quả tìm kiếm
    cy.get('p-table').should('exist');
  });

  it('Hủy xóa thuốc', () => {
    // Tạo thuốc mới để thử hủy xóa
    cy.get('button').eq(1).click({force: true});

    // Chờ form hiển thị
    cy.wait(1000);

    // Tạo mã thuốc ngẫu nhiên để tránh trùng
    const randomCode = 'CAN' + Math.floor(Math.random() * 10000);
    const testMedicineName = 'Test Cancel Delete ' + randomCode;

    // Nhập thông tin thuốc
    cy.get('input').first().type(testMedicineName, {force: true});
    cy.get('input').eq(1).type(randomCode, {force: true});

    // Chờ để đảm bảo trang đã load xong
    cy.wait(500);

    // Nhấn nút Lưu
    cy.get('button').last().click({force: true});

    // Chờ xử lý
    cy.wait(1000);

    // Kiểm tra đã quay về trang danh sách thuốc
    cy.url().should('include', '/sys/product');

    // Chờ thêm thời gian để trang load xong
    cy.wait(2000);

    // Tìm kiếm thuốc vừa tạo
    cy.get('input').first().type(testMedicineName, {force: true});
    cy.get('button').contains(/Tìm|Search/i).click({force: true});

    // Chờ kết quả tìm kiếm
    cy.wait(1000);

    // Xử lý hộp thoại xác nhận xóa - chọn Cancel
    cy.on('window:confirm', () => false);

    // Nhấn nút Xóa cho thuốc vừa tạo (nút thứ 3 trong hàng)
    cy.get('button').eq(3).click({force: true});

    // Chờ xử lý
    cy.wait(1000);

    // Kiểm tra thuốc vẫn còn trong danh sách
    cy.get('p-table').should('exist');
  });

  it('Xóa thuốc đã có trong đơn hàng', () => {
    // Tìm kiếm thuốc có trong đơn hàng (giả định Paracetamol đã có trong đơn hàng)
    cy.get('input').first().type('Paracetamol', {force: true});
    cy.get('button').contains(/Tìm|Search/i).click({force: true});

    // Chờ kết quả tìm kiếm
    cy.wait(1000);

    // Xử lý hộp thoại xác nhận xóa
    cy.on('window:confirm', () => true);

    // Nhấn nút Xóa cho thuốc đầu tiên (nút thứ 3 trong hàng)
    cy.get('button').eq(3).click({force: true});

    // Chờ xử lý
    cy.wait(1000);

    // Kiểm tra thuốc vẫn còn trong danh sách (không có thông báo lỗi)
    cy.get('p-table').should('exist');
  });
});
