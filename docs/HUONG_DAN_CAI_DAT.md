# HƯỚNG DẪN CÀI ĐẶT VÀ SỬ DỤNG HỆ THỐNG QUẢN LÝ HIỆU THUỐC

## Mục lục

1. [Yêu cầu hệ thống](#1-yêu-cầu-hệ-thống)
2. [Cài đặt và cấu hình cơ sở dữ liệu](#2-cài-đặt-và-cấu-hình-cơ-sở-dữ-liệu)
3. [Cài đặt và chạy Backend](#3-cài-đặt-và-chạy-backend)
4. [Cài đặt và chạy Frontend](#4-cài-đặt-và-chạy-frontend)
5. [Nhập dữ liệu mẫu](#5-nhập-dữ-liệu-mẫu)
6. [Đăng nhập và sử dụng hệ thống](#6-đăng-nhập-và-sử-dụng-hệ-thống)
7. [Các chức năng chính của hệ thống](#7-các-chức-năng-chính-của-hệ-thống)
8. [Xử lý sự cố thường gặp](#8-xử-lý-sự-cố-thường-gặp)

## 1. Yêu cầu hệ thống

### Backend
- Java Development Kit (JDK) 17 hoặc cao hơn
- Maven 3.8.x hoặc cao hơn
- PostgreSQL 14.x hoặc cao hơn

### Frontend
- Node.js 16.x hoặc cao hơn
- npm 8.x hoặc cao hơn (hoặc pnpm)
- Angular CLI 14.x

## 2. Cài đặt và cấu hình cơ sở dữ liệu

### 2.1. Cài đặt PostgreSQL

1. Tải và cài đặt PostgreSQL từ [trang chủ PostgreSQL](https://www.postgresql.org/download/)
2. Trong quá trình cài đặt, hãy ghi nhớ mật khẩu cho tài khoản `postgres`

### 2.2. Tạo cơ sở dữ liệu

1. Mở PostgreSQL command line (psql) hoặc sử dụng công cụ quản lý như pgAdmin
2. Tạo cơ sở dữ liệu mới:

```sql
CREATE DATABASE test_hieu_thuoc;
```

3. Nếu bạn muốn tạo người dùng mới (không bắt buộc):

```sql
CREATE USER your_username WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE test_hieu_thuoc TO your_username;
```

4. Nếu sử dụng người dùng mới, hãy cập nhật thông tin kết nối trong file `application.properties`

## 3. Cài đặt và chạy Backend

### 3.1. Clone dự án (nếu chưa có)

```bash
git clone <repository_url>
cd HieuThuoc
```

### 3.2. Cấu hình kết nối cơ sở dữ liệu

1. Mở file `BE/src/main/resources/application.properties`
2. Kiểm tra và cập nhật thông tin kết nối cơ sở dữ liệu nếu cần:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/test_hieu_thuoc
spring.datasource.username=postgres
spring.datasource.password=G@con123123
```

3. Nếu bạn đã tạo người dùng mới ở bước 2.2, hãy cập nhật `username` và `password` tương ứng

### 3.3. Biên dịch và chạy ứng dụng Backend

1. Di chuyển đến thư mục backend:

```bash
cd BE
```

2. Biên dịch và chạy ứng dụng:

```bash
# Trên Windows
mvnw.cmd clean install
mvnw.cmd spring-boot:run

# Trên Linux/Mac
chmod +x ./mvnw
./mvnw clean install
./mvnw spring-boot:run
```

3. Backend sẽ chạy tại địa chỉ: http://localhost:8888/hieuthuoc

## 4. Cài đặt và chạy Frontend

### 4.1. Cài đặt các gói phụ thuộc

1. Di chuyển đến thư mục frontend:

```bash
cd FE
```

2. Cài đặt các gói phụ thuộc:

```bash
# Sử dụng npm
npm install

# Hoặc sử dụng pnpm
pnpm install
```

### 4.2. Cấu hình URL API (nếu cần)

1. Mở file `FE/src/environments/environment.ts`
2. Kiểm tra và cập nhật URL API nếu cần:

```typescript
export const environment = {
  production: false,
  backApiUrl: "http://localhost:8888/hieuthuoc",
};
```

### 4.3. Chạy ứng dụng Frontend

```bash
# Sử dụng npm
npm start

# Hoặc sử dụng Angular CLI
ng serve
```

Frontend sẽ chạy tại địa chỉ: http://localhost:4200

## 5. Nhập dữ liệu mẫu

### 5.1. Sử dụng script tạo dữ liệu mẫu

1. Đảm bảo rằng backend đã được khởi động và cơ sở dữ liệu đã được tạo
2. Di chuyển đến thư mục gốc của dự án
3. Chạy script tạo dữ liệu mẫu:

```bash
# Trên Windows
generate-data\generate-data.bat

# Trên Linux/Mac
bash generate-data/generate-data.sh
```

4. Khi được hỏi, nhập thông tin kết nối PostgreSQL:
   - Database: test_hieu_thuoc
   - Username: postgres (hoặc username bạn đã tạo)
   - Password: G@con123123 (hoặc password bạn đã đặt)

### 5.2. Nhập dữ liệu mẫu thủ công

Nếu script không hoạt động, bạn có thể nhập dữ liệu mẫu thủ công:

1. Mở file `generate-data/seat.sql` trong thư mục dự án
2. Sử dụng công cụ quản lý PostgreSQL (như pgAdmin) để thực thi script SQL này

## 6. Đăng nhập và sử dụng hệ thống

### 6.1. Tài khoản mặc định

Hệ thống có các tài khoản mặc định cho các vai trò khác nhau:

- **Admin** (Quản trị viên):
  - Tên đăng nhập: admin
  - Mật khẩu: 123123
  - Có toàn quyền trên hệ thống

- **Manager** (Quản lý):
  - Tên đăng nhập: manager
  - Mật khẩu: 123123
  - Có quyền quản lý hầu hết các chức năng

- **Pharmacist** (Dược sĩ):
  - Tên đăng nhập: pharmacist1
  - Mật khẩu: 123123
  - Có quyền quản lý thuốc, tư vấn

- **Cashier** (Thu ngân):
  - Tên đăng nhập: cashier1
  - Mật khẩu: 123123
  - Có quyền quản lý đơn hàng, bán hàng

- **Customer** (Khách hàng):
  - Tên đăng nhập: customer1
  - Mật khẩu: 123123
  - Có quyền xem thuốc, đặt hàng

### 6.2. Đăng nhập hệ thống

1. Mở trình duyệt và truy cập: http://localhost:4200
2. Nhập tên đăng nhập và mật khẩu tương ứng với vai trò bạn muốn sử dụng
3. Nhấn nút "Đăng nhập"

## 7. Các chức năng chính của hệ thống

### 7.1. Quản lý thuốc

- **Xem danh sách thuốc**: Truy cập menu "Thuốc" > "Danh sách thuốc"
- **Thêm thuốc mới**: Nhấn nút "Thêm mới" trên trang danh sách thuốc
- **Sửa thông tin thuốc**: Nhấn nút "Sửa" bên cạnh thuốc cần sửa
- **Xóa thuốc**: Nhấn nút "Xóa" bên cạnh thuốc cần xóa

### 7.2. Quản lý kho

- **Xem tồn kho**: Truy cập menu "Kho" > "Tồn kho"
- **Nhập kho**: Truy cập menu "Kho" > "Phiếu nhập" > "Thêm mới"
- **Xem lịch sử nhập kho**: Truy cập menu "Kho" > "Phiếu nhập"

### 7.3. Quản lý đơn hàng

- **Xem danh sách đơn hàng**: Truy cập menu "Đơn hàng" > "Danh sách đơn hàng"
- **Tạo đơn hàng mới**: Nhấn nút "Thêm mới" trên trang danh sách đơn hàng
- **Xem chi tiết đơn hàng**: Nhấn vào ID đơn hàng để xem chi tiết
- **Cập nhật trạng thái đơn hàng**: Nhấn nút "Cập nhật" trên trang chi tiết đơn hàng

### 7.4. Quản lý khuyến mãi

- **Xem danh sách khuyến mãi**: Truy cập menu "Khuyến mãi" > "Danh sách khuyến mãi"
- **Thêm khuyến mãi mới**: Nhấn nút "Thêm mới" trên trang danh sách khuyến mãi
- **Sửa thông tin khuyến mãi**: Nhấn nút "Sửa" bên cạnh khuyến mãi cần sửa
- **Xóa khuyến mãi**: Nhấn nút "Xóa" bên cạnh khuyến mãi cần xóa

### 7.5. Báo cáo và thống kê

- **Báo cáo doanh thu**: Truy cập menu "Báo cáo" > "Doanh thu"
- **Báo cáo tồn kho**: Truy cập menu "Báo cáo" > "Tồn kho"
- **Báo cáo thuốc bán chạy**: Truy cập menu "Báo cáo" > "Thuốc bán chạy"

## 8. Xử lý sự cố thường gặp

### 8.1. Không thể kết nối đến cơ sở dữ liệu

- Kiểm tra PostgreSQL đã được khởi động chưa
- Kiểm tra thông tin kết nối trong file `application.properties`
- Kiểm tra cơ sở dữ liệu `test_hieu_thuoc` đã được tạo chưa

### 8.2. Lỗi khi chạy Backend

- Kiểm tra JDK đã được cài đặt đúng phiên bản chưa (JDK 17+)
- Kiểm tra Maven đã được cài đặt chưa
- Xem log lỗi trong terminal hoặc file `myapp.log`

### 8.3. Lỗi khi chạy Frontend

- Kiểm tra Node.js đã được cài đặt đúng phiên bản chưa (Node.js 16+)
- Kiểm tra các gói phụ thuộc đã được cài đặt chưa (`npm install`)
- Kiểm tra Angular CLI đã được cài đặt chưa (`npm install -g @angular/cli`)

### 8.4. Lỗi CORS

- Đảm bảo Backend đang chạy trên cổng 8888
- Kiểm tra cấu hình CORS trong Backend
- Kiểm tra URL API trong file `environment.ts`
