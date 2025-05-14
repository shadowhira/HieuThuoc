#!/bin/bash

# Tạo dữ liệu mẫu bằng Node.js
echo "Đang tạo dữ liệu mẫu..."
node generate.js

# Kiểm tra xem file SQL đã được tạo chưa
if [ ! -f seat.sql ]; then
    echo "Lỗi: Không thể tạo file SQL"
    exit 1
fi

echo "Đã tạo file SQL thành công"

# Hỏi người dùng có muốn thực thi SQL không
read -p "Bạn có muốn thực thi SQL vào PostgreSQL không? (y/n): " execute_sql

if [ "$execute_sql" = "y" ] || [ "$execute_sql" = "Y" ]; then
    # Hỏi thông tin kết nối PostgreSQL
    read -p "Nhập tên database (mặc định: test_hieu_thuoc): " db_name
    db_name=${db_name:-test_hieu_thuoc}
    
    read -p "Nhập username (mặc định: postgres): " db_user
    db_user=${db_user:-postgres}
    
    read -p "Nhập password: " db_password
    
    # Thực thi SQL
    echo "Đang thực thi SQL vào database $db_name..."
    PGPASSWORD=$db_password psql -h localhost -U $db_user -d $db_name -f seat.sql
    
    if [ $? -eq 0 ]; then
        echo "Thực thi SQL thành công!"
    else
        echo "Lỗi: Không thể thực thi SQL"
        exit 1
    fi
else
    echo "Bỏ qua thực thi SQL"
fi

echo "Hoàn thành!"
