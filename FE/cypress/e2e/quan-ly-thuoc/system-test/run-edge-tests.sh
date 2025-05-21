#!/bin/bash
# Script để chạy tất cả các test case trên trình duyệt Edge

# Di chuyển đến thư mục gốc của dự án
cd ../../../../

# Chạy tất cả các test case End-to-End trên Edge
echo "Đang chạy test case End-to-End trên Edge..."
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/system-test/e2e-*.cy.js" --browser edge

# Chạy tất cả các test case UI trên Edge
echo "Đang chạy test case UI trên Edge..."
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/*-ui-test.cy.js" --browser edge

echo "Hoàn thành chạy test trên Edge!"
