# Tạo dữ liệu mẫu cho hệ thống quản lý hiệu thuốc

Thư mục này chứa các script để tạo dữ liệu mẫu cho hệ thống quản lý hiệu thuốc.

## Cấu trúc thư mục

- `generate.js`: Script Node.js để tạo dữ liệu mẫu
- `generate-data.sh`: Script Bash để chạy trên Linux/Mac
- `generate-data.bat`: Script Batch để chạy trên Windows
- `seat.sql`: File SQL chứa dữ liệu mẫu (được tạo ra sau khi chạy script)
- `seat.txt`: File text chứa dữ liệu mẫu (được tạo ra sau khi chạy script)

## Yêu cầu

- Node.js 16.x hoặc cao hơn
- PostgreSQL 14.x hoặc cao hơn
- Cơ sở dữ liệu `test_hieu_thuoc` đã được tạo

## Cách sử dụng

### Trên Linux/Mac

1. Mở terminal
2. Di chuyển đến thư mục gốc của dự án
3. Chạy script:

```bash
bash generate-data/generate-data.sh
```

### Trên Windows

1. Mở Command Prompt hoặc PowerShell
2. Di chuyển đến thư mục gốc của dự án
3. Chạy script:

```cmd
generate-data\generate-data.bat
```

## Dữ liệu mẫu được tạo ra

Script sẽ tạo ra dữ liệu mẫu cho các bảng sau:

1. **Thuốc**: Thêm 8 loại thuốc mới với đầy đủ thông tin
2. **Thành phần thuốc**: Thêm thành phần cho 8 loại thuốc mới
3. **Đối tượng sử dụng thuốc**: Thêm đối tượng sử dụng cho 8 loại thuốc mới
4. **Tồn kho**: Thêm thông tin tồn kho cho 8 loại thuốc mới
5. **Phiếu nhập**: Thêm 5 phiếu nhập mới
6. **Chi tiết phiếu nhập**: Thêm chi tiết cho 5 phiếu nhập mới
7. **Khuyến mãi**: Thêm 2 chương trình khuyến mãi mới
8. **Chi tiết khuyến mãi**: Thêm chi tiết cho 2 chương trình khuyến mãi mới
9. **Đơn hàng**: Thêm 7 đơn hàng mới
10. **Chi tiết đơn hàng**: Thêm chi tiết cho 7 đơn hàng mới
11. **Đánh giá**: Thêm 5 đánh giá mới và 5 phản hồi đánh giá
12. **Tương tác thuốc**: Thêm 5 tương tác thuốc mới
13. **Thông báo**: Thêm 3 thông báo mới
14. **Người nhận thông báo**: Thêm người nhận cho 3 thông báo mới
15. **Lịch sử hoạt động**: Thêm 12 hoạt động mới

## Tùy chỉnh dữ liệu mẫu

Nếu bạn muốn tùy chỉnh dữ liệu mẫu, bạn có thể chỉnh sửa file `generate.js`. File này chứa các hàm để tạo dữ liệu mẫu cho từng bảng. Mỗi hàm trả về một chuỗi SQL chứa các câu lệnh INSERT.

Ví dụ, để thêm một loại thuốc mới, bạn có thể thêm một đối tượng vào mảng `medicines` trong hàm `generateMedicineData()`.

## Lưu ý

- Script sẽ tạo ra file `seat.sql` và `seat.txt` trong thư mục `generate-data`
- Nếu bạn chọn thực thi SQL, script sẽ hỏi thông tin kết nối PostgreSQL
- Đảm bảo rằng PostgreSQL đã được cài đặt và cơ sở dữ liệu `test_hieu_thuoc` đã được tạo
- Đảm bảo rằng người dùng PostgreSQL có quyền ghi vào cơ sở dữ liệu
