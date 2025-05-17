@echo off
setlocal

REM Tạo dữ liệu mẫu bằng Node.js
echo Đang tạo dữ liệu mẫu...
cd generate-data
node generate.js

REM Kiểm tra xem file SQL đã được tạo chưa
if not exist seat.sql (
    echo Lỗi: Không thể tạo file SQL
    exit /b 1
)

echo Đã tạo file SQL thành công

REM Hỏi người dùng có muốn thực thi SQL không
set /p execute_sql="Bạn có muốn thực thi SQL vào PostgreSQL không? (y/n): "

if /i "%execute_sql%"=="y" (
    REM Hỏi thông tin kết nối PostgreSQL
    set /p db_name="Nhập tên database (mặc định: test_hieu_thuoc): "
    if "%db_name%"=="" set db_name=test_hieu_thuoc
    
    set /p db_user="Nhập username (mặc định: postgres): "
    if "%db_user%"=="" set db_user=postgres
    
    set /p db_password="Nhập password: "
    
    REM Thực thi SQL
    echo Đang thực thi SQL vào database %db_name%...
    set PGPASSWORD=%db_password%
    psql -h localhost -U %db_user% -d %db_name% -f seat.sql
    
    if %ERRORLEVEL% EQU 0 (
        echo Thực thi SQL thành công!
    ) else (
        echo Lỗi: Không thể thực thi SQL
        exit /b 1
    )
) else (
    echo Bỏ qua thực thi SQL
)

echo Hoàn thành!
cd ..
endlocal
