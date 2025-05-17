# MedicineShop - Hệ thống quản lý hiệu thuốc

MedicineShop là một hệ thống quản lý hiệu thuốc toàn diện, bao gồm các chức năng quản lý thuốc, bán hàng, quản lý kho, quản lý người dùng và nhiều tính năng khác.

## Mục lục

1. [Tài liệu hướng dẫn](#tài-liệu-hướng-dẫn)
2. [Hướng dẫn cài đặt và chạy](#hướng-dẫn-cài-đặt-và-chạy)
3. [Tài liệu API](#tài-liệu-api)
4. [Tài liệu giao diện](#tài-liệu-giao-diện)
5. [Tài liệu kiểm thử](#tài-liệu-kiểm-thử)

## Tài liệu hướng dẫn

Hệ thống cung cấp các tài liệu hướng dẫn chi tiết trong thư mục `docs`:

1. [Hướng dẫn cài đặt](docs/HUONG_DAN_CAI_DAT.md) - Hướng dẫn chi tiết về cách cài đặt và cấu hình hệ thống
2. [Hướng dẫn import dữ liệu mẫu](docs/HUONG_DAN_IMPORT_DU_LIEU.md) - Hướng dẫn cách tạo và import dữ liệu mẫu vào cơ sở dữ liệu
3. [Hướng dẫn sử dụng](docs/HUONG_DAN_SU_DUNG.md) - Hướng dẫn cách sử dụng các chức năng của hệ thống
4. [Hướng dẫn chi tiết các chức năng](docs/HUONG_DAN_CHUC_NANG.md) - Mô tả chi tiết về các chức năng của hệ thống

## Hướng dẫn cài đặt và chạy

### Yêu cầu hệ thống

#### Backend
- Java Development Kit (JDK) 17 hoặc cao hơn
- Maven 3.8.x hoặc cao hơn
- PostgreSQL 14.x hoặc cao hơn

#### Frontend
- Node.js 16.x hoặc cao hơn
- npm 8.x hoặc cao hơn
- Angular CLI 15.x hoặc cao hơn

### Cài đặt và cấu hình cơ sở dữ liệu

1. Cài đặt PostgreSQL từ [trang chủ PostgreSQL](https://www.postgresql.org/download/)
2. Tạo cơ sở dữ liệu mới:
   ```sql
   CREATE DATABASE test_hieu_thuoc;
   ```
3. Tạo người dùng và cấp quyền:
   ```sql
   CREATE USER postgres WITH PASSWORD 'G@con123123';
   GRANT ALL PRIVILEGES ON DATABASE test_hieu_thuoc TO postgres;
   ```
4. Chạy script khởi tạo cơ sở dữ liệu từ thư mục `generate-data` (xem [Hướng dẫn import dữ liệu mẫu](docs/HUONG_DAN_IMPORT_DU_LIEU.md))

### Cài đặt và chạy Backend

1. Di chuyển đến thư mục backend:
   ```bash
   cd NguyenTrungKien_B20DCCN358/BE/hieuthuoc
   ```

2. Cấu hình kết nối cơ sở dữ liệu trong file `src/main/resources/application.properties` (nếu cần):
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/test_hieu_thuoc
   spring.datasource.username=postgres
   spring.datasource.password=G@con123123
   ```

3. Biên dịch và chạy ứng dụng:
   ```bash
   chmod +x ./mvnw
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. Backend sẽ chạy tại địa chỉ: http://localhost:8888/hieuthuoc

### Cài đặt và chạy Frontend

1. Di chuyển đến thư mục frontend:
   ```bash
   cd NguyenTrungKien_B20DCCN358/front
   ```

2. Cài đặt các gói phụ thuộc:
   ```bash
   npm install
   ```

3. Cấu hình URL API trong file môi trường (nếu cần):
   ```bash
   # Chỉnh sửa file src/environments/environment.ts
   ```

4. Chạy ứng dụng:
   ```bash
   ng serve
   ```

5. Frontend sẽ chạy tại địa chỉ: http://localhost:4200

### Tài khoản mặc định

Hệ thống có các tài khoản mặc định cho các vai trò khác nhau:

- **Admin** (Quản trị viên):
  - Tên đăng nhập: admin
  - Mật khẩu: 123456
  - Có toàn quyền trên hệ thống

- **Manager** (Quản lý):
  - Tên đăng nhập: manager
  - Mật khẩu: 123456
  - Có hầu hết các quyền giống Admin, ngoại trừ xóa người dùng

- **Pharmacist** (Dược sĩ):
  - Tên đăng nhập: pharmacist1
  - Mật khẩu: 123456
  - Có quyền quản lý thuốc và nhập kho

- **Cashier** (Thu ngân):
  - Tên đăng nhập: cashier1
  - Mật khẩu: 123456
  - Có quyền quản lý đơn hàng

- **Customer** (Khách hàng):
  - Tên đăng nhập: customer1
  - Mật khẩu: 123456
  - Có quyền xem thuốc và đặt hàng

## Tài liệu API

### Cấu trúc API

Tất cả các API đều có tiền tố `/hieuthuoc` và tuân theo cấu trúc RESTful. Các phản hồi đều có định dạng JSON với cấu trúc:

```json
{
  "status": 200,
  "msg": "Thành công",
  "data": { ... }
}
```

### Xác thực và Phân quyền

- Hệ thống sử dụng JWT (JSON Web Token) để xác thực
- Token được gửi trong header `Authorization` với tiền tố `Bearer`
- Thời gian sống của token: 5 giờ
- Hệ thống có 5 vai trò chính: ADMIN, MANAGER, PHARMACIST, CASHIER, CUSTOMER
- Chi tiết về phân quyền xem tại [Hướng dẫn về hệ thống phân quyền](README-phan-quyen.md)

### Danh sách API chính

#### Quản lý người dùng

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| POST | /dangnhap/login | Đăng nhập hệ thống |
| POST | /dangnhap/register | Đăng ký tài khoản mới |
| GET | /nguoidung/get | Lấy thông tin người dùng theo ID |
| PUT | /nguoidung/update | Cập nhật thông tin người dùng |
| POST | /nguoidung/search | Tìm kiếm người dùng |

#### Quản lý thuốc

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| POST | /thuoc/search | Tìm kiếm thuốc |
| GET | /thuoc/get | Lấy thông tin thuốc theo ID |
| POST | /thuoc/create | Thêm thuốc mới |
| PUT | /thuoc/update | Cập nhật thông tin thuốc |
| DELETE | /thuoc/delete | Xóa thuốc |
| POST | /thuoc/get_thuoc_ban_chay | Lấy danh sách thuốc bán chạy |

#### Quản lý đơn hàng

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| GET | /donhang/get | Lấy thông tin đơn hàng theo ID |
| POST | /donhang/list | Lấy danh sách đơn hàng theo trạng thái |
| POST | /donhang/create | Tạo đơn hàng mới |
| PUT | /donhang/update | Cập nhật đơn hàng |
| DELETE | /donhang/delete | Xóa đơn hàng |
| POST | /donhang/changTrangThaiGiaoHang | Thay đổi trạng thái giao hàng |
| POST | /donhang/changTrangThaiThanhToan | Thay đổi trạng thái thanh toán |

#### Quản lý giỏ hàng

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| GET | /giohang/get | Lấy thông tin giỏ hàng theo ID người dùng |
| POST | /giohang/create | Thêm sản phẩm vào giỏ hàng |
| PUT | /giohang/update | Cập nhật số lượng sản phẩm trong giỏ hàng |
| DELETE | /giohang/delete | Xóa sản phẩm khỏi giỏ hàng |

#### Thanh toán

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| POST | /vnpay/create | Tạo yêu cầu thanh toán qua VNPay |
| GET | /vnpay/return | Xử lý kết quả thanh toán từ VNPay |

#### Quản lý kho

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| POST | /phieunhap/create | Tạo phiếu nhập kho |
| GET | /phieunhap/get | Lấy thông tin phiếu nhập theo ID |
| POST | /phieunhap/search | Tìm kiếm phiếu nhập |
| GET | /tonkho/get | Lấy thông tin tồn kho theo ID thuốc |
| POST | /tonkho/search | Tìm kiếm tồn kho |

#### Báo cáo và thống kê

| Phương thức | Endpoint | Mô tả |
|-------------|----------|-------|
| POST | /baocao/doanh-thu | Báo cáo doanh thu |
| POST | /baocao/ton-kho | Báo cáo tồn kho |
| POST | /baocao/thuoc-ban-chay | Báo cáo thuốc bán chạy |

## Tài liệu giao diện

### Cấu trúc giao diện

Giao diện của MedicineShop được chia thành hai phần chính:
1. **Giao diện quản trị (Admin/Sys)**: Dành cho quản trị viên, quản lý, dược sĩ, thu ngân để quản lý thuốc, đơn hàng, người dùng, kho...
2. **Giao diện người dùng (User)**: Dành cho khách hàng và các vai trò khác để xem thuốc, đặt hàng, quản lý giỏ hàng...

Chi tiết về các luồng sử dụng theo từng vai trò xem tại [Hướng dẫn luồng sử dụng hệ thống](README-luong-su-dung.md)

### Giao diện quản trị (Admin)

#### Đăng nhập
- Đường dẫn: `/login`
- Chức năng: Đăng nhập vào hệ thống với quyền quản trị

#### Trang chủ quản trị
- Đường dẫn: `/admin/dashboard`
- Chức năng: Hiển thị tổng quan về hệ thống, thống kê, báo cáo

#### Quản lý thuốc
- Đường dẫn: `/admin/thuoc`
- Chức năng: Thêm, sửa, xóa, tìm kiếm thuốc

#### Quản lý đơn hàng
- Đường dẫn: `/admin/donhang`
- Chức năng: Xem, cập nhật trạng thái đơn hàng

#### Quản lý người dùng
- Đường dẫn: `/admin/nguoidung`
- Chức năng: Thêm, sửa, xóa, phân quyền người dùng

#### Quản lý kho
- Đường dẫn: `/admin/kho`
- Chức năng: Nhập kho, xuất kho, kiểm kê

#### Báo cáo
- Đường dẫn: `/admin/baocao`
- Chức năng: Xem các báo cáo doanh thu, tồn kho...

### Giao diện người dùng (User)

#### Trang chủ
- Đường dẫn: `/`
- Chức năng: Hiển thị thuốc nổi bật, thuốc mới, thuốc bán chạy

#### Danh sách thuốc
- Đường dẫn: `/thuoc`
- Chức năng: Hiển thị danh sách thuốc, tìm kiếm, lọc

#### Chi tiết thuốc
- Đường dẫn: `/thuoc/:id`
- Chức năng: Hiển thị thông tin chi tiết về thuốc

#### Giỏ hàng
- Đường dẫn: `/giohang`
- Chức năng: Quản lý giỏ hàng, cập nhật số lượng

#### Thanh toán
- Đường dẫn: `/checkout`
- Chức năng: Thanh toán đơn hàng

#### Đơn hàng của tôi
- Đường dẫn: `/donhang`
- Chức năng: Xem lịch sử đơn hàng, trạng thái đơn hàng

#### Thông tin cá nhân
- Đường dẫn: `/profile`
- Chức năng: Xem, cập nhật thông tin cá nhân

## Tài liệu kiểm thử

Hệ thống MedicineShop được chia thành 5 phần để kiểm thử, mỗi phần sẽ do một thành viên trong nhóm đảm nhiệm.

### Tài liệu hướng dẫn

Hệ thống cung cấp các tài liệu hướng dẫn chi tiết:

- [Hướng dẫn tạo dữ liệu mẫu](docs/HUONG_DAN_IMPORT_DU_LIEU.md) - Chi tiết về cách tạo và sử dụng dữ liệu mẫu
- [Hướng dẫn sử dụng hệ thống](docs/HUONG_DAN_SU_DUNG.md) - Mô tả chi tiết về cách sử dụng hệ thống
- [Hướng dẫn chi tiết các chức năng](docs/HUONG_DAN_CHUC_NANG.md) - Mô tả chi tiết các chức năng của hệ thống

Dữ liệu mẫu bao gồm các loại dữ liệu sau:

1. **Quản lý thuốc** - Dữ liệu thuốc, thành phần, đối tượng sử dụng, tồn kho
2. **Quản lý nhập kho** - Phiếu nhập, chi tiết phiếu nhập
3. **Quản lý khuyến mãi** - Chương trình khuyến mãi, chi tiết khuyến mãi
4. **Quản lý đơn hàng** - Đơn hàng, chi tiết đơn hàng
5. **Quản lý đánh giá và tương tác thuốc** - Đánh giá thuốc, tương tác thuốc

### Phần 1: Quản lý người dùng và phân quyền

**Phạm vi kiểm thử:**
- Đăng ký, đăng nhập, đăng xuất
- Quản lý thông tin người dùng
- Phân quyền và kiểm soát truy cập
- Quản lý nhóm quyền

**Các API cần kiểm thử:**
- `/dangnhap/*`
- `/nguoidung/*`
- `/nhomquyen/*`

**Các thành phần cần kiểm thử:**
- Controller: `DangNhapController`, `NguoiDungController`, `NhomQuyenController`
- Service: `DangNhapService`, `NguoiDungService`, `NhomQuyenService`
- Entity: `NguoiDung`, `NhomQuyen`, `ChiTietNhomQuyen`

**Loại kiểm thử:**
- Unit Testing
- Integration Testing
- Security Testing
- UI Testing

### Phần 2: Quản lý thuốc và danh mục

**Phạm vi kiểm thử:**
- Quản lý thuốc (thêm, sửa, xóa, tìm kiếm)
- Quản lý loại thuốc
- Quản lý danh mục thuốc
- Quản lý nhà sản xuất, nhà cung cấp
- Quản lý đối tượng sử dụng thuốc

**Các API cần kiểm thử:**
- `/thuoc/*`
- `/loaithuoc/*`
- `/danhmucthuoc/*`
- `/nhasanxuat/*`
- `/nhacungcap/*`
- `/doituong/*`

**Các thành phần cần kiểm thử:**
- Controller: `ThuocController`, `LoaiThuocController`, `DanhMucThuocController`, `NhaSanXuatController`, `NhaCungCapController`, `DoiTuongController`
- Service: `ThuocService`, `LoaiThuocService`, `DanhMucThuocService`, `NhaSanXuatService`, `NhaCungCapService`, `DoiTuongService`
- Entity: `Thuoc`, `LoaiThuoc`, `DanhMucThuoc`, `NhaSanXuat`, `NhaCungCap`, `DoiTuong`, `ThanhPhanThuoc`

**Loại kiểm thử:**
- Unit Testing
- Integration Testing
- Functional Testing
- UI Testing

### Phần 3: Quản lý giỏ hàng và đơn hàng

**Phạm vi kiểm thử:**
- Quản lý giỏ hàng (thêm, sửa, xóa)
- Quản lý đơn hàng (tạo, cập nhật trạng thái)
- Quản lý chi tiết đơn hàng
- Xử lý thanh toán

**Các API cần kiểm thử:**
- `/giohang/*`
- `/donhang/*`
- `/vnpay/*`

**Các thành phần cần kiểm thử:**
- Controller: `GioHangController`, `DonHangController`, `VNPayController`
- Service: `GioHangService`, `DonHangService`, `VNPayService`
- Entity: `GioHang`, `ChiTietGioHang`, `DonHang`, `ChiTietDonHang`

**Loại kiểm thử:**
- Unit Testing
- Integration Testing
- End-to-End Testing
- Payment Testing
- UI Testing

### Phần 4: Quản lý kho và báo cáo

**Phạm vi kiểm thử:**
- Quản lý phiếu nhập kho
- Quản lý tồn kho
- Báo cáo doanh thu
- Báo cáo tồn kho
- Báo cáo thuốc bán chạy

**Các API cần kiểm thử:**
- `/phieunhap/*`
- `/tonkho/*`
- `/baocao/*`

**Các thành phần cần kiểm thử:**
- Controller: `PhieuNhapController`, `TonKhoController`, `BaoCaoController`
- Service: `PhieuNhapService`, `TonKhoService`, `BaoCaoService`
- Entity: `PhieuNhap`, `ChiTietPhieuNhap`, `TonKho`

**Loại kiểm thử:**
- Unit Testing
- Integration Testing
- Reporting Testing
- UI Testing

### Phần 5: Tương tác người dùng và tính năng bổ sung

**Phạm vi kiểm thử:**
- Đánh giá sản phẩm
- Thông báo
- Tương tác thuốc
- Lịch sử hoạt động
- Khuyến mãi

**Các API cần kiểm thử:**
- `/danhgia/*`
- `/thongbao/*`
- `/tuongtacthuoc/*`
- `/lichsuhoatdong/*`
- `/khuyenmai/*`

**Các thành phần cần kiểm thử:**
- Controller: `DanhGiaController`, `ThongBaoController`, `TuongTacThuocController`, `LichSuHoatDongController`, `KhuyenMaiController`
- Service: `DanhGiaService`, `ThongBaoService`, `TuongTacThuocService`, `LichSuHoatDongService`, `KhuyenMaiService`
- Entity: `DanhGia`, `ThongBao`, `TuongTacThuoc`, `LichSuHoatDong`, `KhuyenMai`, `ChiTietKhuyenMai`

**Loại kiểm thử:**
- Unit Testing
- Integration Testing
- Notification Testing
- UI Testing

### Hướng dẫn thực hiện kiểm thử

#### Công cụ kiểm thử

1. **Backend Testing**
   - JUnit 5: Unit testing
   - Mockito: Mock objects
   - RestAssured: API testing
   - Spring Test: Integration testing

2. **Frontend Testing**
   - Jasmine/Karma: Unit testing
   - Protractor: E2E testing
   - Cypress: Modern E2E testing

3. **Database Testing**
   - H2: In-memory database
   - TestContainers: Docker containers for testing

4. **Công cụ khác**
   - Postman: API testing
   - SonarQube: Code quality
   - JaCoCo: Code coverage

#### Quy trình kiểm thử

1. **Lập kế hoạch kiểm thử**
   - Xác định phạm vi kiểm thử
   - Xác định các test case
   - Xác định các test data

2. **Thiết kế test case**
   - Mô tả các bước thực hiện
   - Xác định đầu vào
   - Xác định kết quả mong đợi

3. **Thực hiện kiểm thử**
   - Thực hiện các test case
   - Ghi lại kết quả
   - So sánh với kết quả mong đợi

4. **Báo cáo lỗi**
   - Mô tả lỗi
   - Các bước tái hiện lỗi
   - Mức độ nghiêm trọng

5. **Kiểm thử lại**
   - Kiểm tra lại sau khi sửa lỗi
   - Kiểm thử hồi quy

#### Mẫu test case

```
Test Case ID: TC001
Tên test case: Đăng nhập thành công
Mô tả: Kiểm tra chức năng đăng nhập với tài khoản hợp lệ
Điều kiện tiên quyết: Người dùng đã được tạo trong hệ thống
Các bước thực hiện:
1. Truy cập trang đăng nhập
2. Nhập tên đăng nhập: "admin"
3. Nhập mật khẩu: "123456"
4. Nhấn nút "Đăng nhập"
Kết quả mong đợi:
1. Người dùng được chuyển đến trang chủ
2. Hiển thị thông báo "Đăng nhập thành công"
3. Hiển thị tên người dùng ở góc trên bên phải
```

#### Báo cáo kiểm thử

Mỗi thành viên trong nhóm cần chuẩn bị báo cáo kiểm thử cho phần mình phụ trách, bao gồm:
1. Tổng quan về phần kiểm thử
2. Danh sách test case
3. Kết quả kiểm thử
4. Các lỗi phát hiện
5. Đề xuất cải tiến
