# HƯỚNG DẪN IMPORT DỮ LIỆU MẪU

## Mục lục

1. [Giới thiệu](#1-giới-thiệu)
2. [Chuẩn bị môi trường](#2-chuẩn-bị-môi-trường)
3. [Tạo dữ liệu mẫu](#3-tạo-dữ-liệu-mẫu)
4. [Import dữ liệu mẫu vào PostgreSQL](#4-import-dữ-liệu-mẫu-vào-postgresql)
5. [Kiểm tra dữ liệu đã import](#5-kiểm-tra-dữ-liệu-đã-import)
6. [Xử lý sự cố](#6-xử-lý-sự-cố)

## 1. Giới thiệu

Tài liệu này hướng dẫn cách tạo và import dữ liệu mẫu vào cơ sở dữ liệu PostgreSQL cho hệ thống quản lý hiệu thuốc. Dữ liệu mẫu bao gồm các thông tin về thuốc, nhà sản xuất, nhà cung cấp, đơn hàng, khuyến mãi, người dùng và các dữ liệu liên quan khác.

## 2. Chuẩn bị môi trường

### 2.1. Yêu cầu hệ thống

- PostgreSQL 14.x hoặc cao hơn đã được cài đặt
- Node.js 16.x hoặc cao hơn (để chạy script tạo dữ liệu mẫu)
- Cơ sở dữ liệu `test_hieu_thuoc` đã được tạo

### 2.2. Kiểm tra PostgreSQL

1. Mở terminal hoặc command prompt
2. Kiểm tra PostgreSQL đã được cài đặt:

```bash
psql --version
```

3. Kết quả mong đợi: `psql (PostgreSQL) 14.x` hoặc cao hơn

### 2.3. Kiểm tra Node.js

1. Mở terminal hoặc command prompt
2. Kiểm tra Node.js đã được cài đặt:

```bash
node --version
```

3. Kết quả mong đợi: `v16.x.x` hoặc cao hơn

## 3. Tạo dữ liệu mẫu

### 3.1. Sử dụng script có sẵn

1. Di chuyển đến thư mục gốc của dự án
2. Chạy script tạo dữ liệu mẫu:

```bash
# Trên Windows
generate-data\generate-data.bat

# Trên Linux/Mac
bash generate-data/generate-data.sh
```

3. Script sẽ tạo ra file `seat.sql` và `seat.txt` trong thư mục `generate-data` chứa các câu lệnh SQL để tạo dữ liệu mẫu

### 3.2. Tùy chỉnh dữ liệu mẫu (nếu cần)

Nếu bạn muốn tùy chỉnh dữ liệu mẫu, bạn có thể chỉnh sửa file `generate-data/generate.js` trước khi chạy:

1. Mở file `generate-data/generate.js` bằng trình soạn thảo văn bản
2. Tìm và chỉnh sửa các phần dữ liệu mẫu theo nhu cầu
3. Lưu file và chạy lại script như bước 3.1

## 4. Import dữ liệu mẫu vào PostgreSQL

### 4.1. Sử dụng script tự động

1. Dữ liệu mẫu sẽ được tự động import khi bạn chạy script tạo dữ liệu mẫu. Nếu bạn chỉ muốn import dữ liệu mà không tạo lại, bạn có thể chạy:

```bash
# Trên Windows
psql -U postgres -d test_hieu_thuoc -f generate-data\seat.sql

# Trên Linux/Mac
psql -U postgres -d test_hieu_thuoc -f generate-data/seat.sql
```

2. Khi được hỏi, nhập thông tin kết nối PostgreSQL:
   - Database: test_hieu_thuoc
   - Username: postgres (hoặc username bạn đã tạo)
   - Password: G@con123123 (hoặc password bạn đã đặt)

3. Script sẽ tự động import dữ liệu mẫu vào cơ sở dữ liệu

### 4.2. Import thủ công

Nếu script tự động không hoạt động, bạn có thể import thủ công:

#### 4.2.1. Sử dụng psql command line

1. Mở terminal hoặc command prompt
2. Chạy lệnh sau để import dữ liệu:

```bash
cd generate-data
psql -U postgres -d test_hieu_thuoc -f seat.sql
```

3. Nhập mật khẩu khi được yêu cầu

#### 4.2.2. Sử dụng pgAdmin

1. Mở pgAdmin
2. Kết nối đến server PostgreSQL
3. Chọn cơ sở dữ liệu `test_hieu_thuoc`
4. Nhấn chuột phải và chọn "Query Tool"
5. Nhấn nút "Open File" và chọn file `seat.sql` trong thư mục `generate-data`
6. Nhấn nút "Execute" để chạy script

## 5. Kiểm tra dữ liệu đã import

### 5.1. Kiểm tra bằng psql

1. Mở terminal hoặc command prompt
2. Kết nối đến cơ sở dữ liệu:

```bash
psql -U postgres -d test_hieu_thuoc
```

3. Chạy các câu lệnh SQL để kiểm tra dữ liệu:

```sql
-- Kiểm tra dữ liệu thuốc
SELECT COUNT(*) FROM thuoc;

-- Kiểm tra dữ liệu người dùng
SELECT COUNT(*) FROM nguoi_dung;

-- Kiểm tra dữ liệu đơn hàng
SELECT COUNT(*) FROM don_hang;

-- Kiểm tra dữ liệu khuyến mãi
SELECT COUNT(*) FROM khuyen_mai;
```

### 5.2. Kiểm tra bằng pgAdmin

1. Mở pgAdmin
2. Kết nối đến server PostgreSQL
3. Chọn cơ sở dữ liệu `test_hieu_thuoc`
4. Mở các bảng để xem dữ liệu:
   - thuoc
   - nguoi_dung
   - don_hang
   - khuyen_mai
   - ...

### 5.3. Kiểm tra thông qua ứng dụng

1. Khởi động backend và frontend như hướng dẫn trong tài liệu cài đặt
2. Đăng nhập vào hệ thống với tài khoản admin (username: admin, password: 123456)
3. Truy cập các trang quản lý để xem dữ liệu:
   - Quản lý thuốc
   - Quản lý người dùng
   - Quản lý đơn hàng
   - Quản lý khuyến mãi
   - ...

## 6. Xử lý sự cố

### 6.1. Lỗi kết nối PostgreSQL

**Vấn đề**: Không thể kết nối đến PostgreSQL

**Giải pháp**:
- Kiểm tra PostgreSQL đã được khởi động chưa
- Kiểm tra thông tin kết nối (username, password, database) đã chính xác chưa
- Kiểm tra cổng PostgreSQL (mặc định là 5432) không bị chặn bởi tường lửa

### 6.2. Lỗi import dữ liệu

**Vấn đề**: Gặp lỗi khi import dữ liệu

**Giải pháp**:
- Kiểm tra file `seat.sql` trong thư mục `generate-data` đã được tạo đúng chưa
- Kiểm tra cơ sở dữ liệu `test_hieu_thuoc` đã được tạo chưa
- Kiểm tra người dùng PostgreSQL có quyền ghi vào cơ sở dữ liệu không
- Xem log lỗi và sửa lỗi cú pháp SQL nếu có

### 6.3. Lỗi tham chiếu khóa ngoại

**Vấn đề**: Gặp lỗi về tham chiếu khóa ngoại khi import dữ liệu

**Giải pháp**:
- Kiểm tra thứ tự import dữ liệu (các bảng cha phải được import trước các bảng con)
- Kiểm tra các ID tham chiếu đã tồn tại chưa
- Sửa file `seat.sql` trong thư mục `generate-data` để đảm bảo thứ tự import đúng

### 6.4. Lỗi trùng lặp dữ liệu

**Vấn đề**: Gặp lỗi trùng lặp dữ liệu khi import nhiều lần

**Giải pháp**:
- Xóa dữ liệu cũ trước khi import lại:

```sql
-- Xóa dữ liệu từ các bảng con trước
DELETE FROM chi_tiet_don_hang;
DELETE FROM chi_tiet_phieu_nhap;
DELETE FROM chi_tiet_khuyen_mai;
DELETE FROM nguoi_nhan_thong_bao;
DELETE FROM danh_gia;

-- Sau đó xóa dữ liệu từ các bảng cha
DELETE FROM don_hang;
DELETE FROM phieu_nhap;
DELETE FROM khuyen_mai;
DELETE FROM thong_bao;
DELETE FROM thuoc;
DELETE FROM nguoi_dung WHERE username != 'admin';
```

- Hoặc tạo lại cơ sở dữ liệu:

```sql
DROP DATABASE test_hieu_thuoc;
CREATE DATABASE test_hieu_thuoc;
```

### 6.5. Lỗi Node.js

**Vấn đề**: Không thể chạy script `generate.js` trong thư mục `generate-data`

**Giải pháp**:
- Kiểm tra Node.js đã được cài đặt đúng phiên bản chưa
- Cài đặt các gói phụ thuộc nếu cần:

```bash
npm install fs path
```

- Kiểm tra quyền truy cập file và thư mục
