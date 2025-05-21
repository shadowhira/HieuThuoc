#!/bin/bash
# Script để chạy tất cả các test case kiểm thử hệ thống

# Chạy tất cả các test case End-to-End
echo "Đang chạy test case End-to-End..."
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/e2e-*.cy.js" --browser chrome

# Chạy tất cả các test case bảo mật
echo "Đang chạy test case bảo mật..."
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/security-test.cy.js" --browser chrome

# Chạy tất cả các test case khả năng chịu lỗi
echo "Đang chạy test case khả năng chịu lỗi..."
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/fault-tolerance-test.cy.js" --browser chrome

# Chạy tất cả các test case tương thích trên Chrome
echo "Đang chạy test case tương thích trên Chrome..."
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/compatibility-test.cy.js" --browser chrome

# Chạy tất cả các test case tương thích trên Firefox (nếu đã cài đặt)
if [ -x "$(command -v firefox)" ]; then
  echo "Đang chạy test case tương thích trên Firefox..."
  npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/compatibility-test.cy.js" --browser firefox
else
  echo "Firefox không được cài đặt, bỏ qua test case tương thích trên Firefox."
fi

echo "Hoàn thành chạy tất cả các test case!"
