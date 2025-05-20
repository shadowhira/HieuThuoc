# Hướng dẫn kiểm thử chức năng báo cáo thống kê

## 1. Chuẩn bị môi trường

### 1.1. Yêu cầu hệ thống
- PostgreSQL đã được cài đặt và đang chạy
- Cơ sở dữ liệu của ứng dụng đã được tạo
- Các bảng đã được tạo theo cấu trúc của ứng dụng

### 1.2. Công cụ cần thiết
- pgAdmin hoặc công cụ quản lý PostgreSQL khác
- Hoặc sử dụng terminal/command line để chạy script SQL

## 2. Các bước thực hiện

### 2.1. Tạo dữ liệu cơ bản

1. Mở pgAdmin hoặc công cụ quản lý PostgreSQL
2. Kết nối đến cơ sở dữ liệu của ứng dụng
3. Mở file `seat.sql` và thực thi script (nếu chưa chạy)
4. Kiểm tra dữ liệu đã được tạo thành công bằng cách truy vấn các bảng:
   ```sql
   SELECT * FROM thuoc;
   SELECT * FROM loai_thuoc;
   SELECT * FROM nha_san_xuat;
   SELECT * FROM nguoi_dung;
   ```

### 2.2. Tạo dữ liệu bổ sung cho báo cáo thống kê

1. Sau khi đã tạo dữ liệu cơ bản, mở file `report_test_data.sql` và thực thi script
2. Kiểm tra dữ liệu đã được tạo thành công bằng cách truy vấn các bảng:
   ```sql
   SELECT * FROM don_hang WHERE created_at >= CURRENT_DATE;
   SELECT * FROM chi_tiet_don_hang WHERE don_hang_id IN (SELECT id FROM don_hang WHERE created_at >= CURRENT_DATE);
   SELECT * FROM ton_kho WHERE han_su_dung <= CURRENT_DATE + INTERVAL '1 month';
   SELECT * FROM danh_gia WHERE created_at >= CURRENT_DATE - INTERVAL '10 days';
   ```

### 2.3. Sử dụng dữ liệu để kiểm thử

#### 2.3.1. Kiểm thử báo cáo doanh thu theo ngày

1. Đăng nhập vào hệ thống với tài khoản có quyền xem báo cáo
2. Truy cập menu "Báo cáo" > "Doanh thu"
3. Chọn tab "Theo ngày"
4. Chọn ngày hiện tại
5. Nhấn nút "Xem báo cáo"
6. Kiểm tra biểu đồ và bảng dữ liệu hiển thị đúng với dữ liệu đã tạo
7. Kiểm tra tổng doanh thu ngày hiện tại phải bằng tổng giá trị các đơn hàng đã tạo trong ngày hiện tại

#### 2.3.2. Kiểm thử báo cáo doanh thu theo giờ

1. Đăng nhập vào hệ thống với tài khoản có quyền xem báo cáo
2. Truy cập menu "Báo cáo" > "Doanh thu"
3. Chọn tab "Theo giờ" (nếu có)
4. Chọn ngày hiện tại
5. Nhấn nút "Xem báo cáo"
6. Kiểm tra biểu đồ và bảng dữ liệu hiển thị đúng với dữ liệu đã tạo
7. Kiểm tra doanh thu theo từng khung giờ:
   - Sáng sớm (6-8h): 9,000
   - Buổi sáng (9-11h): 10,000
   - Buổi trưa (12-14h): 12,000
   - Buổi chiều (15-17h): 15,000
   - Buổi tối (18-22h): 18,000

#### 2.3.3. Kiểm thử báo cáo doanh thu theo tháng

1. Đăng nhập vào hệ thống với tài khoản có quyền xem báo cáo
2. Truy cập menu "Báo cáo" > "Doanh thu"
3. Chọn tab "Theo tháng"
4. Chọn năm 2024
5. Nhấn nút "Xem báo cáo"
6. Kiểm tra biểu đồ và bảng dữ liệu hiển thị đúng với dữ liệu đã tạo
7. Kiểm tra doanh thu theo từng tháng:
   - Tháng 1: 25,000
   - Tháng 2: 30,000
   - Tháng 3: 35,000

#### 2.3.4. Kiểm thử báo cáo sản phẩm bán chạy

1. Đăng nhập vào hệ thống với tài khoản có quyền xem báo cáo
2. Truy cập menu "Báo cáo" > "Sản phẩm"
3. Chọn tab "Sản phẩm bán chạy"
4. Chọn khoảng thời gian (ví dụ: tháng hiện tại)
5. Nhấn nút "Xem báo cáo"
6. Kiểm tra biểu đồ và bảng dữ liệu hiển thị đúng với dữ liệu đã tạo
7. Kiểm tra danh sách sản phẩm bán chạy phải sắp xếp theo số lượng bán từ cao đến thấp

#### 2.3.5. Kiểm thử báo cáo tồn kho

1. Đăng nhập vào hệ thống với tài khoản có quyền xem báo cáo
2. Truy cập menu "Báo cáo" > "Tồn kho"
3. Nhấn nút "Xem báo cáo"
4. Kiểm tra bảng dữ liệu hiển thị đúng với dữ liệu đã tạo
5. Kiểm tra danh sách thuốc sắp hết hạn (trong vòng 1 tháng) phải bao gồm:
   - Azithromycin 500mg (LO047)
   - Cefixime 200mg (LO048)
   - Levofloxacin 500mg (LO049)
6. Kiểm tra danh sách thuốc có số lượng dưới ngưỡng cảnh báo phải bao gồm:
   - Diclofenac 50mg (số lượng: 25, ngưỡng: 30)
   - Pantoprazole 40mg (số lượng: 15, ngưỡng: 20)
   - Metformin 500mg (số lượng: 10, ngưỡng: 15)

#### 2.3.6. Kiểm thử báo cáo đánh giá sản phẩm

1. Đăng nhập vào hệ thống với tài khoản có quyền xem báo cáo
2. Truy cập menu "Báo cáo" > "Đánh giá"
3. Nhấn nút "Xem báo cáo"
4. Kiểm tra bảng dữ liệu hiển thị đúng với dữ liệu đã tạo
5. Kiểm tra danh sách sản phẩm được đánh giá cao nhất phải sắp xếp theo điểm đánh giá trung bình từ cao đến thấp

## 3. Xử lý sự cố

### 3.1. Lỗi khi chạy script

- **Lỗi khóa ngoại**: Đảm bảo các bảng cha đã có dữ liệu trước khi thêm dữ liệu vào bảng con
- **Lỗi trùng khóa chính**: Xóa dữ liệu cũ trước khi thêm mới hoặc sử dụng `ON CONFLICT DO NOTHING`
- **Lỗi cú pháp SQL**: Kiểm tra cú pháp SQL trong file script

### 3.2. Lỗi khi kiểm thử

- **Không hiển thị dữ liệu**: Kiểm tra xem dữ liệu đã được tạo thành công chưa
- **Dữ liệu không đúng**: Kiểm tra lại các câu lệnh SQL và dữ liệu đã tạo
- **Lỗi kết nối cơ sở dữ liệu**: Kiểm tra kết nối đến cơ sở dữ liệu

## 4. Dọn dẹp dữ liệu

Sau khi hoàn thành kiểm thử, bạn có thể muốn dọn dẹp dữ liệu mẫu. Sử dụng các câu lệnh sau:

```sql
-- Xóa dữ liệu từ các bảng con trước
DELETE FROM chi_tiet_don_hang WHERE don_hang_id IN (SELECT id FROM don_hang WHERE created_at >= CURRENT_DATE - INTERVAL '10 days');
DELETE FROM don_hang WHERE created_at >= CURRENT_DATE - INTERVAL '10 days';
DELETE FROM ton_kho WHERE han_su_dung <= CURRENT_DATE + INTERVAL '1 month' AND han_su_dung > CURRENT_DATE;
DELETE FROM danh_gia WHERE created_at >= CURRENT_DATE - INTERVAL '10 days';
DELETE FROM chi_tiet_phieu_nhap WHERE phieu_nhap_id IN (SELECT id FROM phieu_nhap WHERE created_at >= CURRENT_DATE - INTERVAL '10 days');
DELETE FROM phieu_nhap WHERE created_at >= CURRENT_DATE - INTERVAL '10 days';
```

## 5. Tài liệu tham khảo

- [Tài liệu PostgreSQL](https://www.postgresql.org/docs/)
- [Tài liệu pgAdmin](https://www.pgadmin.org/docs/)
- [Tài liệu SQL](https://www.w3schools.com/sql/)
