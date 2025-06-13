@echo off
echo ===================================================
echo Chay kiem thu tu dong cho phan he Bao cao Thong ke
echo ===================================================
echo Luu y: Tat ca cac test case deu yeu cau dang nhap
echo Tai khoan: admin, Mat khau: 123456
echo ===================================================

echo.
echo Dang chay test tong quan...
npx cypress run --spec "cypress/e2e/thong-ke/tong-quan.cy.js"

echo.
echo Dang chay test bieu do...
npx cypress run --spec "cypress/e2e/thong-ke/bieu-do.cy.js"

echo.
echo Dang chay test bo loc...
npx cypress run --spec "cypress/e2e/thong-ke/bo-loc.cy.js"

echo.
echo Dang chay test responsive...
npx cypress run --spec "cypress/e2e/thong-ke/responsive-tests.cy.js"

echo.
echo Dang chay test filter...
npx cypress run --spec "cypress/e2e/thong-ke/filter-tests.cy.js"

echo.
echo Dang chay test bo sung...
npx cypress run --spec "cypress/e2e/thong-ke/additional-tests.cy.js"

echo.
echo Dang chay test tong hop...
npx cypress run --spec "cypress/e2e/thong-ke/all-tests.cy.js"

echo.
echo Kiem thu hoan tat!
pause
