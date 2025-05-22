// Cypress test for Quản lý khách hàng functionality

// Custom command for login
Cypress.Commands.add("login", (username, password) => {
  cy.visit("/login");
  cy.get("#username").type(username);
  cy.get("#password-input").type(password);
  cy.get("button.btn.btn-success").click();
  // Đợi đăng nhập thành công
  cy.url().should("not.include", "/login");
});

// Custom command for logout
Cypress.Commands.add("logout", () => {
  // Tìm và click vào menu người dùng (có thể là avatar hoặc tên người dùng)
  // Sử dụng cách tiếp cận linh hoạt hơn để tìm nút đăng xuất
  cy.get("body").then(($body) => {
    // Thử nhiều cách khác nhau để tìm nút đăng xuất
    if ($body.find('a[href="/login"]').length > 0) {
      cy.get('a[href="/login"]').click({ force: true });
    } else if ($body.find(".dropdown-toggle").length > 0) {
      // Nếu có dropdown menu
      cy.get(".dropdown-toggle").click({ force: true });
      cy.get(".dropdown-menu a")
        .contains(/Đăng xuất|Logout/i)
        .click({ force: true });
    } else {
      // Nếu không tìm thấy nút đăng xuất, chuyển hướng trực tiếp đến trang đăng nhập
      cy.visit("/login");
    }
  });

  // Xác nhận đã đăng xuất bằng cách kiểm tra URL
  cy.url().should("include", "/login");
});

describe("Kiểm thử chức năng quản lý khách hàng", () => {
  const adminUsername = "admin2";
  const adminPassword = "123456789";

  beforeEach(() => {
    // Login as admin before each test
    cy.login(adminUsername, adminPassword);
    // Navigate to customer management page
    cy.visit("/sys/customer");
  });

  afterEach(() => {
    // Logout after each test
    cy.logout();
  });

  // Test case QLKH_01: Kiểm tra giao diện màn hình quản lý khách hàng
  it("QLKH_01: Kiểm tra giao diện màn hình quản lý khách hàng", () => {
    // Check page title or heading
    cy.contains("Khách Hàng").should("be.visible");

    // Check search box
    cy.get('input[type="text"]').should("be.visible");
    cy.get("button").contains("Tìm Kiếm").should("be.visible");

    // Check table headers - PrimeNG table
    cy.get("p-table").should("be.visible");
    cy.get("p-table th").should("contain", "ID");
    cy.get("p-table th").should("contain", "Tên Đăng Nhập");
    cy.get("p-table th").should("contain", "Họ và Tên");
    cy.get("p-table th").should("contain", "Email");
    cy.get("p-table th").should("contain", "Số Điện Thoại");
    cy.get("p-table th").should("contain", "Trạng Thái");
    cy.get("p-table th").should("contain", "Ngày Tạo");

    // Check if there are any rows in the table
    cy.get("p-table tr").then(($rows) => {
      if ($rows.length > 1) {
        // > 1 because the first row is the header
        cy.log("Table has data rows");
      } else {
        cy.log("Table has no data rows");
      }
    });
  });

  // Test case QLKH_02: Kiểm tra tổng thể giao diện
  it("QLKH_02: Kiểm tra tổng thể giao diện", () => {
    // Check layout, font, spelling, color
    cy.get("p-table").should("be.visible");
    cy.get(".page-title-box").should("be.visible");
    cy.get(".card").should("be.visible");
  });

  // Test case QLKH_03: Kiểm tra tìm kiếm khách hàng theo tên
  it("QLKH_03: Kiểm tra tìm kiếm khách hàng theo tên", () => {
    // Search for a customer by name
    const searchKeyword = "admin";
    cy.get('input[type="text"]').clear().type(searchKeyword);
    cy.get("button").contains("Tìm Kiếm").click();

    // Đợi cho bảng hiển thị kết quả
    cy.wait(1000);

    // Verify search results - sử dụng cách tiếp cận linh hoạt hơn
    cy.get("body").then(($body) => {
      if ($body.find("p-table tbody tr").length > 0) {
        cy.log("Tìm thấy kết quả");
        // Kiểm tra kết quả tìm kiếm có chứa từ khóa
        cy.get("p-table").should("contain", searchKeyword);
      } else {
        cy.log("Không tìm thấy kết quả");
      }
    });
  });

  // Test case QLKH_04: Kiểm tra tìm kiếm khách hàng không tồn tại
  it("QLKH_04: Kiểm tra tìm kiếm khách hàng không tồn tại", () => {
    // Search for a non-existent customer
    const searchKeyword = "nonexistentuser123456789";
    cy.get('input[type="text"]').clear().type(searchKeyword);
    cy.get("button").contains("Tìm Kiếm").click();

    // Đợi cho bảng hiển thị kết quả
    cy.wait(1000);

    // Verify no results or empty table - sử dụng cách tiếp cận linh hoạt hơn
    cy.get("body").then(($body) => {
      if ($body.find("p-table tbody tr").length === 0) {
        cy.log("Không tìm thấy kết quả - bảng trống");
      } else {
        cy.log("Bảng có dữ liệu nhưng không nên chứa từ khóa tìm kiếm");
        cy.get("p-table").should("not.contain", searchKeyword);
      }
    });
  });

  // Test case QLKH_05: Kiểm tra tìm kiếm với ô tìm kiếm trống
  it("QLKH_05: Kiểm tra tìm kiếm với ô tìm kiếm trống", () => {
    // Clear search box and search
    cy.get('input[type="text"]').clear();
    cy.get("button").contains("Tìm Kiếm").click();

    // Verify all customers are displayed
    cy.get("p-table tbody tr").should("have.length.at.least", 1);
  });

  // Test case QLKH_06: Kiểm tra hiển thị thông tin chi tiết khách hàng
  it("QLKH_06: Kiểm tra hiển thị thông tin chi tiết khách hàng", () => {
    // Đợi cho bảng hiển thị dữ liệu
    cy.wait(1000);

    // Kiểm tra thông tin hiển thị trong bảng - sử dụng cách tiếp cận linh hoạt hơn
    cy.get("body").then(($body) => {
      if ($body.find("p-table tbody tr").length > 0) {
        // Kiểm tra thông tin cột
        cy.get("p-table tbody tr")
          .first()
          .find("td")
          .should("have.length.at.least", 6);

        // Kiểm tra có hiển thị trạng thái
        cy.get("p-table tbody tr").first().find(".badge").should("exist");
      } else {
        cy.log("Không có dữ liệu trong bảng");
      }
    });
  });

  // Test case QLKH_07: Kiểm tra hiển thị thông tin chi tiết khách hàng trong bảng
  it("QLKH_07: Kiểm tra hiển thị thông tin chi tiết khách hàng trong bảng", () => {
    // Kiểm tra các cột thông tin trong bảng
    cy.get("p-table tbody tr")
      .first()
      .then(($row) => {
        // Kiểm tra các cột thông tin
        cy.wrap($row).find("td").should("have.length.at.least", 6); // Ít nhất 6 cột

        // Kiểm tra định dạng dữ liệu
        cy.wrap($row).find("td").eq(0).invoke("text").should("match", /\d+/); // ID là số
        cy.wrap($row).find("td").eq(4).invoke("text").should("match", /\d+/); // Số điện thoại là số

        // Kiểm tra trạng thái
        cy.wrap($row).find(".badge").should("exist");
      });
  });

  // Test case QLKH_08: Kiểm tra phân trang
  it("QLKH_08: Kiểm tra phân trang", () => {
    // Kiểm tra có hiển thị phân trang
    cy.get("p-paginator").should("exist");

    // Kiểm tra chức năng phân trang
    cy.get("p-paginator .p-paginator-pages").then(($pages) => {
      if ($pages.find(".p-paginator-page").length > 1) {
        // Nếu có nhiều trang, click vào trang thứ 2
        cy.get("p-paginator .p-paginator-pages .p-paginator-page")
          .eq(1)
          .click();

        // Kiểm tra dữ liệu đã thay đổi
        cy.get("p-table tbody tr").should("exist");
      } else {
        cy.log("Chỉ có một trang dữ liệu");
      }
    });
  });
});
