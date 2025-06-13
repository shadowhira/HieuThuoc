# Dữ liệu kiểm thử cho chức năng báo cáo thống kê

## Giới thiệu

File `statistics_test_data.sql` chứa dữ liệu mẫu đa dạng để kiểm thử chức năng báo cáo thống kê trong hệ thống quản lý hiệu thuốc. Dữ liệu được thiết kế để bổ sung vào dữ liệu hiện có mà không sửa đổi các thuộc tính trong các file dữ liệu khác.

## Đặc điểm dữ liệu

### 1. Phân bố theo thời gian
- **Đa dạng về năm**: Dữ liệu trải dài từ 2022 đến 2025 (năm hiện tại trong hệ thống)
- **Đa dạng theo tháng**: Mỗi năm đều có dữ liệu cho tất cả các tháng
- **Đa dạng theo quý**: Dữ liệu được phân bố đều trong các quý của mỗi năm
- **Dữ liệu ngày hiện tại**: Có dữ liệu cho ngày hiện tại để kiểm thử báo cáo theo ngày

### 2. Đa dạng về giá trị
- **Hóa đơn với nhiều mức giá trị khác nhau**:
  - Giá trị thấp: 8,000đ - 20,000đ
  - Giá trị trung bình: 20,000đ - 40,000đ
  - Giá trị cao: 40,000đ - 80,000đ
- **Đơn hàng trả lại**: Có nhiều đơn hàng với trạng thái `TRA_HANG` phân bố trong các tháng khác nhau
- **Doanh thu biến động**: Có tháng cao, có tháng thấp để kiểm thử biểu đồ doanh thu

### 3. Đa dạng về trạng thái
- **Trạng thái giao hàng**: `DANG_XU_LY`, `DANG_GIAO`, `DA_GIAO`, `TRA_HANG`
- **Trạng thái thanh toán**: `CHUA_THANH_TOAN`, `DA_THANH_TOAN`
- **Phương thức thanh toán**: `TIEN_MAT`, `CHUYEN_KHOAN`, `THE_NGAN_HANG`, `VI_DIEN_TU`

### 4. Dữ liệu sản phẩm bán chạy
- Có 3 sản phẩm được thiết lập là bán chạy nhất:
  - Thuốc ID 9 (Azithromycin)
  - Thuốc ID 11 (Levofloxacin)
  - Thuốc ID 16 (Atorvastatin)

## Cấu trúc dữ liệu

File SQL được tổ chức thành các phần:

1. **Đơn hàng năm 2022**: Dữ liệu lịch sử từ 2 năm trước
2. **Đơn hàng năm 2023**: Dữ liệu từ năm trước
3. **Đơn hàng năm 2024**: Dữ liệu từ năm hiện tại (Q1-Q2)
4. **Chi tiết đơn hàng**: Chi tiết cho tất cả các đơn hàng
5. **Đơn hàng năm 2025**: Dữ liệu cho năm hiện tại trong hệ thống
6. **Dữ liệu bổ sung**: Dữ liệu cho các trường hợp kiểm thử cụ thể
7. **Đơn hàng trả lại**: Dữ liệu đơn hàng trả lại để kiểm thử báo cáo trả hàng
8. **Dữ liệu sản phẩm bán chạy**: Dữ liệu bổ sung để tạo ra các sản phẩm bán chạy rõ ràng

## Hỗ trợ kiểm thử các chức năng

Dữ liệu được thiết kế để hỗ trợ kiểm thử đầy đủ các chức năng:

### 1. Lọc theo thời gian
- Lọc theo ngày
- Lọc theo tháng
- Lọc theo năm
- Lọc theo quý
- Lọc theo khoảng thời gian tùy chọn

### 2. Hiển thị dữ liệu
- Hiển thị tổng số hóa đơn
- Hiển thị đơn hàng trả lại
- Hiển thị tổng doanh thu
- Hiển thị biểu đồ doanh thu theo thời gian
- Hiển thị sản phẩm bán chạy

### 3. Báo cáo thống kê
- Báo cáo doanh thu theo ngày
- Báo cáo doanh thu theo tháng
- Báo cáo doanh thu theo năm
- Báo cáo sản phẩm bán chạy
- Báo cáo đơn hàng trả lại

## Cách sử dụng

1. Đảm bảo đã có cơ sở dữ liệu và các bảng đã được tạo
2. Chạy file `statistics_test_data.sql` để tạo dữ liệu mẫu
3. Kiểm tra dữ liệu đã được tạo thành công
4. Thực hiện kiểm thử các chức năng báo cáo và thống kê

## Lưu ý

- Một số câu lệnh sử dụng hàm `CURRENT_DATE` để tạo dữ liệu động theo thời gian hiện tại
- ID của các bản ghi được thiết kế để không xung đột với dữ liệu hiện có
- Dữ liệu chỉ sử dụng các thuốc có ID từ 9-16 theo yêu cầu
- Tổng tiền của đơn hàng đã được cập nhật để phản ánh chính xác tổng giá trị của các sản phẩm trong đơn hàng
