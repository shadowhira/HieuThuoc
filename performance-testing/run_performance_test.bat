@echo off
echo ========================================
echo KIEM THU HIEN NANG CHUC NANG BAO CAO DOANH THU
echo ========================================

echo.
echo Kiem tra Python...
python --version
if %errorlevel% neq 0 (
    echo Loi: Python khong duoc cai dat hoac khong co trong PATH
    pause
    exit /b 1
)

echo.
echo Cai dat cac thu vien can thiet...
pip install -r requirements.txt

echo.
echo Chay kiem thu hien nang...
python run_performance_test.py

echo.
echo Hoan thanh kiem thu hien nang!
echo Cac file CSV da duoc tao trong thu muc hien tai.
echo.
pause 