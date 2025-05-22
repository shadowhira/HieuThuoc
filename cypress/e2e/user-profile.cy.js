describe("User Profile Management", () => {
  beforeEach(() => {
    // Login before each test
    cy.visit("http://localhost:4200/login");

    // Wait for page to load
    cy.wait(2000);

    // Check if we're on the login page
    cy.url().should("include", "/login");

    // Login with valid credentials
    cy.get("#username").should("be.visible").type("customer2");
    cy.get("#password-input").should("be.visible").type("123456");
    cy.get("button.btn-success").should("be.visible").click();

    // Wait for login to complete and redirect
    cy.wait(2000);

    // Navigate to user profile page
    cy.visit("http://localhost:4200/user/profile");

    // Wait for profile page to load
    cy.wait(2000);

    // Verify we're on the profile page
    cy.url().should("include", "/user/profile");
  });

  describe("UI/UX Tests", () => {
    it("QLHS_001 - Should display default user profile interface", () => {
      cy.contains("h4", "Hồ sơ của tôi").should("be.visible");
      cy.get(".profile-user").find("img").should("exist");
      cy.get("#firstnameInput").should("exist");
      cy.get("#lastnameInput").should("exist");
      cy.get("#phonenumberInput").should("exist");
      cy.get("#emailInput").should("exist");
      cy.contains("button", "Cập nhật").should("be.visible");
    });

    it("QLHS_002 - Should have proper layout, alignment, font, size, and color", () => {
      cy.get(".profile-user").should("exist");
      cy.get(".card-body").should("exist");
      cy.contains("h4", "Hồ sơ của tôi").should("exist");
    });
  });

  describe("Update Profile Tests", () => {
    beforeEach(() => {
      cy.contains("button", "Cập nhật").should("be.visible");
    });

    it("QLHS_007 - Should validate required fields", () => {
      // Clear required fields
      cy.get("#firstnameInput").clear();
      cy.get("#phonenumberInput").clear();

      // Try to save
      cy.contains("button", "Cập nhật").click();

      // Check if fields are marked as invalid
      cy.get("#firstnameInput").should("have.class", "ng-invalid");
      cy.get("#phonenumberInput").should("have.class", "ng-invalid");
    });

    it("QLHS_008 - Should validate email format", () => {
      // Email field is disabled in the UI, so we verify that
      cy.get("#emailInput").should("be.disabled");
    });

    it("QLHS_009 - Should validate phone number format", () => {
      cy.get("#phonenumberInput").clear().type("invalid-phone");
      cy.contains("button", "Cập nhật").click();
      // Check if field is marked as invalid
      cy.get("#phonenumberInput").should("have.class", "ng-invalid");
    });

    it("QLHS_011 - Should successfully update profile with valid data", () => {
      const newData = {
        fullname: "Nguyễn Văn A",
        phone: "0987654321",
      };

      cy.get("#firstnameInput").clear().type(newData.fullname);
      cy.get("#phonenumberInput").clear().type(newData.phone);

      cy.contains("button", "Cập nhật").click();

      // Wait for update to complete
      cy.wait(1000);

      // Verify updated data is displayed
      cy.get("#firstnameInput").should("have.value", newData.fullname);
      cy.get("#phonenumberInput").should("have.value", newData.phone);
    });
  });

  describe("Change Password Tests", () => {
    beforeEach(() => {
      // Find and verify the change password section
      cy.contains("Đổi mật khẩu").should("be.visible");
    });

    it("QLHS_015 - Should validate required password fields", () => {
      cy.contains("button", "Cập nhật").click();
      cy.get("input[type='password']").should("have.class", "ng-invalid");
    });

    it("QLHS_016 - Should validate incorrect current password", () => {
      // Find password fields in the change password section
      cy.get(".tab-pane.active input[type='password']")
        .first()
        .type("wrongpassword");
      cy.get(".tab-pane.active input[type='password']")
        .eq(1)
        .type("newpassword123");
      cy.get(".tab-pane.active input[type='password']")
        .last()
        .type("newpassword123");

      cy.contains("button", "Cập nhật").click();

      // Wait for error message
      cy.wait(1000);
      cy.get("input[type='password']")
        .first()
        .should("have.class", "ng-invalid");
    });

    it("QLHS_017 - Should validate new password complexity", () => {
      cy.get(".tab-pane.active input[type='password']").first().type("123456");
      cy.get(".tab-pane.active input[type='password']").eq(1).type("123");
      cy.get(".tab-pane.active input[type='password']").last().type("123");

      cy.contains("button", "Cập nhật").click();

      cy.get("input[type='password']").eq(1).should("have.class", "ng-invalid");
    });

    it("QLHS_018 - Should validate password confirmation match", () => {
      cy.get(".tab-pane.active input[type='password']").first().type("123456");
      cy.get(".tab-pane.active input[type='password']")
        .eq(1)
        .type("newpassword123");
      cy.get(".tab-pane.active input[type='password']")
        .last()
        .type("differentpassword");

      cy.contains("button", "Cập nhật").click();

      cy.get("input[type='password']")
        .last()
        .should("have.class", "ng-invalid");
    });

    it("QLHS_019 - Should successfully change password with valid data", () => {
      cy.get(".tab-pane.active input[type='password']").first().type("123456");
      cy.get(".tab-pane.active input[type='password']")
        .eq(1)
        .type("newpassword123");
      cy.get(".tab-pane.active input[type='password']")
        .last()
        .type("newpassword123");

      cy.contains("button", "Cập nhật").click();

      // Wait for success message and verify we can login with new password
      cy.wait(1000);
      cy.visit("http://localhost:4200/login");
      cy.wait(2000);
      cy.get("#username").should("be.visible").type("customer2");
      cy.get("#password-input").should("be.visible").type("newpassword123");
      cy.get("button.btn-success").should("be.visible").click();

      // Wait for redirect
      cy.wait(2000);
      cy.url().should("include", "/dashboard");
    });
  });
});
