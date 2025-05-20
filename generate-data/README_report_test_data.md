# Dữ liệu kiểm thử cho chức năng báo cáo thống kê

## Giới thiệu

Thư mục này chứa các script SQL để tạo dữ liệu mẫu phục vụ kiểm thử chức năng báo cáo và thống kê trong hệ thống quản lý hiệu thuốc. Dữ liệu được thiết kế để bổ sung vào dữ liệu hiện có trong file `seat.sql` mà không sửa đổi các thuộc tính trong file đó.

## Cấu trúc dữ liệu

Dữ liệu mẫu được chia thành các file sau:

1. `seat.sql`: File dữ liệu gốc (không được sửa đổi)
2. `report_test_data.sql`: Dữ liệu bổ sung cho các báo cáo thống kê

## Các loại dữ liệu mẫu

### 1. Dữ liệu đơn hàng theo ngày
- Đơn hàng hôm nay
- Đơn hàng hôm qua
- Chi tiết đơn hàng tương ứng

### 2. Dữ liệu đơn hàng theo giờ
- Đơn hàng sáng sớm (6-8h)
- Đơn hàng buổi sáng (9-11h)
- Đơn hàng buổi trưa (12-14h)
- Đơn hàng buổi chiều (15-17h)
- Đơn hàng buổi tối (18-22h)
- Chi tiết đơn hàng tương ứng

### 3. Dữ liệu đơn hàng theo tháng
- Đơn hàng tháng 1
- Đơn hàng tháng 2
- Đơn hàng tháng 3
- Chi tiết đơn hàng tương ứng

### 4. Dữ liệu tồn kho
- Thuốc sắp hết hạn (trong vòng 1 tháng)
- Thuốc có số lượng dưới ngưỡng cảnh báo

### 5. Dữ liệu đánh giá
- Đánh giá của người dùng cho các thuốc khác nhau
- Đánh giá với số sao và nội dung khác nhau

### 6. Dữ liệu nhập kho
- Phiếu nhập trong tháng hiện tại
- Chi tiết phiếu nhập

### 7. Dữ liệu khuyến mãi
- Khuyến mãi tháng 4/2024
- Khuyến mãi tháng 5/2024
- Chi tiết khuyến mãi

### 8. Dữ liệu đơn hàng trả lại
- Đơn hàng trả lại
- Chi tiết đơn hàng trả lại

## Cách sử dụng

1. Đảm bảo đã có cơ sở dữ liệu và các bảng đã được tạo
2. Chạy file `seat.sql` để tạo dữ liệu cơ bản (nếu chưa chạy)
3. Chạy file `report_test_data.sql` để tạo dữ liệu bổ sung cho báo cáo thống kê
4. Kiểm tra dữ liệu đã được tạo thành công
5. Thực hiện kiểm thử các chức năng báo cáo và thống kê

## Lưu ý

- Một số câu lệnh sử dụng hàm `CURRENT_DATE`, `CURRENT_TIMESTAMP`, `INTERVAL` để tạo dữ liệu động theo thời gian hiện tại
- Đảm bảo các khóa ngoại đã tồn tại trước khi chạy script

## Các loại báo cáo có thể kiểm thử

1. **Báo cáo doanh thu**
   - Doanh thu theo ngày
   - Doanh thu theo giờ trong ngày
   - Doanh thu theo tháng
   - Doanh thu theo năm

2. **Báo cáo sản phẩm**
   - Sản phẩm bán chạy
   - Sản phẩm tồn kho
   - Sản phẩm sắp hết hạn

3. **Báo cáo tồn kho**
   - Tồn kho theo sản phẩm
   - Tồn kho dưới ngưỡng cảnh báo
   - Tồn kho sắp hết hạn

4. **Báo cáo đánh giá**
   - Đánh giá sản phẩm
   - Sản phẩm được đánh giá cao nhất

5. **Báo cáo nhập kho**
   - Nhập kho theo tháng
   - Chi tiết nhập kho theo sản phẩm

6. **Báo cáo khuyến mãi**
   - Khuyến mãi theo tháng
   - Hiệu quả của các chương trình khuyến mãi

7. **Báo cáo đơn hàng trả lại**
   - Đơn hàng trả lại theo thời gian
   - Lý do trả hàng
