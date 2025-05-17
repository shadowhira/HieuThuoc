# Tài liệu hệ thống phân quyền - Pharmacy Management System

## Mục lục

1. [Giới thiệu](#giới-thiệu)
2. [Cấu trúc phân quyền](#cấu-trúc-phân-quyền)
3. [Các vai trò trong hệ thống](#các-vai-trò-trong-hệ-thống)
4. [Chi tiết quyền truy cập](#chi-tiết-quyền-truy-cập)
5. [Cơ chế xác thực và phân quyền](#cơ-chế-xác-thực-và-phân-quyền)
6. [Hướng dẫn sử dụng](#hướng-dẫn-sử-dụng)
7. [Xử lý lỗi phân quyền](#xử-lý-lỗi-phân-quyền)

## Giới thiệu

Hệ thống quản lý hiệu thuốc sử dụng cơ chế phân quyền dựa trên vai trò (Role-Based Access Control - RBAC) để kiểm soát quyền truy cập vào các chức năng và tài nguyên của hệ thống. Tài liệu này mô tả chi tiết về cấu trúc phân quyền, các vai trò, quyền truy cập và cách sử dụng hệ thống phân quyền.

## Cấu trúc phân quyền

Hệ thống phân quyền được xây dựng dựa trên các thành phần sau:

1. **Người dùng (NguoiDung)**: Đại diện cho người sử dụng hệ thống
2. **Nhóm quyền (NhomQuyen)**: Đại diện cho vai trò của người dùng trong hệ thống
3. **Chức năng (ChucNang)**: Đại diện cho các hành động có thể thực hiện trong hệ thống
4. **Chi tiết nhóm quyền (ChiTietNhomQuyen)**: Liên kết giữa người dùng và nhóm quyền
5. **Chi tiết chức năng (ChiTietChucNang)**: Liên kết giữa nhóm quyền và chức năng

### Mối quan hệ giữa các thành phần

- Một người dùng có thể thuộc nhiều nhóm quyền
- Một nhóm quyền có thể có nhiều chức năng
- Quyền truy cập của người dùng được xác định dựa trên tổng hợp các chức năng từ tất cả các nhóm quyền mà người dùng thuộc về

## Các vai trò trong hệ thống

Hệ thống có 5 vai trò chính:

### 1. ADMIN (ID: 1)
- **Mô tả**: Quản trị viên hệ thống
- **Tài khoản mẫu**: admin/123456
- **Đặc điểm**: Có toàn quyền trên hệ thống

### 2. MANAGER (ID: 2)
- **Mô tả**: Quản lý cửa hàng
- **Tài khoản mẫu**: manager/123456
- **Đặc điểm**: Có hầu hết các quyền giống Admin, ngoại trừ xóa người dùng

### 3. PHARMACIST (ID: 3)
- **Mô tả**: Dược sĩ
- **Tài khoản mẫu**: pharmacist1/123456
- **Đặc điểm**: Có quyền quản lý thuốc và nhập kho

### 4. CASHIER (ID: 4)
- **Mô tả**: Thu ngân
- **Tài khoản mẫu**: cashier1/123456
- **Đặc điểm**: Có quyền quản lý đơn hàng

### 5. CUSTOMER (ID: 5)
- **Mô tả**: Khách hàng
- **Tài khoản mẫu**: customer1/123456
- **Đặc điểm**: Có quyền xem thuốc và đặt hàng

## Chi tiết quyền truy cập

### Chức năng trong hệ thống

Hệ thống có các nhóm chức năng sau:

#### 1. Quản lý người dùng
- **VIEW_USER**: Xem danh sách người dùng
- **CREATE_USER**: Tạo mới người dùng
- **UPDATE_USER**: Cập nhật thông tin người dùng
- **DELETE_USER**: Xóa người dùng (chỉ ADMIN có quyền này)

#### 2. Quản lý thuốc
- **VIEW_MEDICINE**: Xem danh sách thuốc
- **CREATE_MEDICINE**: Tạo mới thuốc
- **UPDATE_MEDICINE**: Cập nhật thông tin thuốc
- **DELETE_MEDICINE**: Xóa thuốc

#### 3. Quản lý đơn hàng
- **VIEW_ORDER**: Xem danh sách đơn hàng
- **CREATE_ORDER**: Tạo mới đơn hàng
- **UPDATE_ORDER**: Cập nhật thông tin đơn hàng
- **DELETE_ORDER**: Xóa đơn hàng

#### 4. Quản lý nhập kho
- **VIEW_IMPORT**: Xem danh sách phiếu nhập
- **CREATE_IMPORT**: Tạo mới phiếu nhập
- **UPDATE_IMPORT**: Cập nhật thông tin phiếu nhập
- **DELETE_IMPORT**: Xóa phiếu nhập

#### 5. Quản lý khuyến mãi
- **VIEW_PROMOTION**: Xem danh sách khuyến mãi
- **CREATE_PROMOTION**: Tạo mới khuyến mãi
- **UPDATE_PROMOTION**: Cập nhật thông tin khuyến mãi
- **DELETE_PROMOTION**: Xóa khuyến mãi

### Phân bổ quyền theo vai trò

#### ADMIN
- Có tất cả các chức năng trong hệ thống

#### MANAGER
- Tất cả các chức năng ngoại trừ DELETE_USER

#### PHARMACIST
- Tất cả các chức năng liên quan đến thuốc và nhập kho:
  - VIEW_MEDICINE, CREATE_MEDICINE, UPDATE_MEDICINE, DELETE_MEDICINE
  - VIEW_IMPORT, CREATE_IMPORT, UPDATE_IMPORT, DELETE_IMPORT

#### CASHIER
- Tất cả các chức năng liên quan đến đơn hàng:
  - VIEW_ORDER, CREATE_ORDER, UPDATE_ORDER, DELETE_ORDER

#### CUSTOMER
- Chỉ có quyền xem thuốc và tạo đơn hàng:
  - VIEW_MEDICINE
  - CREATE_ORDER

## Quyền truy cập các trang trong hệ thống

### Trang quản trị (sys)

| Đường dẫn | Mô tả | Vai trò được phép |
|-----------|-------|-------------------|
| /sys/product | Quản lý thuốc | ADMIN, MANAGER |
| /sys/customer | Quản lý khách hàng | ADMIN, MANAGER |
| /sys/product-create | Tạo mới thuốc | ADMIN, MANAGER |
| /sys/ncc | Quản lý nhà cung cấp | ADMIN, MANAGER |
| /sys/nsx | Quản lý nhà sản xuất | ADMIN, MANAGER |
| /sys/donhang | Quản lý đơn hàng | ADMIN, MANAGER |
| /sys/donhang-create | Tạo mới đơn hàng | ADMIN, MANAGER |
| /sys/loaithuoc | Quản lý loại thuốc | ADMIN, MANAGER |
| /sys/danhmucThuoc | Quản lý danh mục thuốc | ADMIN, MANAGER |
| /sys/doituong | Quản lý đối tượng | ADMIN, MANAGER |
| /sys/chucnang | Quản lý chức năng | ADMIN, MANAGER |
| /sys/phieunhap | Quản lý phiếu nhập | ADMIN, MANAGER |
| /sys/phieunhap-create | Tạo mới phiếu nhập | ADMIN, MANAGER |
| /sys/chitiet-donhang/:id | Chi tiết đơn hàng | ADMIN, MANAGER |
| /sys/thongke | Thống kê | ADMIN, MANAGER |
| /sys/thongbao | Thông báo | ADMIN, MANAGER |
| /sys/tonkho | Tồn kho | ADMIN, MANAGER |

### Trang người dùng (user)

| Đường dẫn | Mô tả | Vai trò được phép |
|-----------|-------|-------------------|
| /user/home | Trang chủ | Tất cả người dùng đã đăng nhập |
| /user/profile | Thông tin cá nhân | CUSTOMER, ADMIN, MANAGER |
| /user/giohang | Giỏ hàng | CUSTOMER |
| /user/checkout | Thanh toán | CUSTOMER |
| /user/donmua | Đơn mua | CUSTOMER |
| /user/thongbao | Thông báo | CUSTOMER |
| /user/donmua-chitiet/:id | Chi tiết đơn mua | CUSTOMER |

### Trang công khai (public)

| Đường dẫn | Mô tả | Vai trò được phép |
|-----------|-------|-------------------|
| /login | Đăng nhập | Tất cả |
| /signup | Đăng ký | Tất cả |
| /home | Trang chủ | Tất cả |
| /product/:id | Chi tiết sản phẩm | Tất cả |
| /products | Danh sách sản phẩm | Tất cả |

## Cơ chế xác thực và phân quyền

### Backend

#### JWT (JSON Web Token)
- Hệ thống sử dụng JWT để xác thực người dùng
- Token chứa thông tin về người dùng và các quyền của họ
- Thời gian sống của token là 5 giờ
- Được cấu hình trong class `JwtService`

#### Cấu trúc JWT
- **Header**: Chứa thông tin về thuật toán mã hóa (HS256)
- **Payload**: Chứa thông tin về người dùng và quyền, bao gồm:
  - `id`: ID của người dùng
  - `lastName`: Họ tên của người dùng
  - `nhomQuyens`: Danh sách các nhóm quyền và chức năng của người dùng
  - `sub`: Tên đăng nhập của người dùng
  - `iat`: Thời gian tạo token
  - `exp`: Thời gian hết hạn token
- **Signature**: Chữ ký để xác thực token, được tạo bằng thuật toán HS256 với secret key

#### Ví dụ về Payload của JWT
```json
{
  "id": 1,
  "lastName": "Admin System",
  "nhomQuyens": [
    {
      "nhomQuyen": "ADMIN",
      "chucNangs": [
        "VIEW_USER",
        "CREATE_USER",
        "UPDATE_USER",
        "DELETE_USER",
        "VIEW_MEDICINE",
        "CREATE_MEDICINE",
        "UPDATE_MEDICINE",
        "DELETE_MEDICINE",
        "VIEW_ORDER",
        "CREATE_ORDER",
        "UPDATE_ORDER",
        "DELETE_ORDER",
        "VIEW_IMPORT",
        "CREATE_IMPORT",
        "UPDATE_IMPORT",
        "DELETE_IMPORT",
        "VIEW_PROMOTION",
        "CREATE_PROMOTION",
        "UPDATE_PROMOTION",
        "DELETE_PROMOTION"
      ]
    }
  ],
  "sub": "admin",
  "iat": 1635739200,
  "exp": 1635757200
}
```

#### Xác thực API
- Mỗi request đến API đều được kiểm tra token trong header Authorization
- `JwtFilter` sẽ kiểm tra tính hợp lệ của token và trích xuất thông tin người dùng
- `SecurityContextHolder` sẽ lưu trữ thông tin xác thực để sử dụng trong quá trình xử lý request
- Quá trình xác thực được thực hiện trong phương thức `doFilterInternal` của `JwtFilter`

#### Cấu hình bảo mật
- Cấu hình bảo mật được định nghĩa trong class `SecurityConfiguration`
- Sử dụng `BCryptPasswordEncoder` để mã hóa mật khẩu
- Cấu hình CORS để cho phép các request từ frontend
- Cấu hình các endpoint công khai và các endpoint yêu cầu xác thực

### Frontend

#### Lưu trữ token
- Token được lưu trong cookie với key `ACCESS_TOKEN_KEY`
- Thời gian sống của cookie là 1 ngày
- Được cấu hình trong class `AuthConstant`

```typescript
// Lưu token vào cookie
Cookie.set(
  AuthConstant.ACCESS_TOKEN_KEY,
  _token,
  AuthConstant.TOKEN_EXPIRE,
  "/"
);
```

#### Giải mã token
- Token được giải mã bằng thư viện `jwt-decode`
- Thông tin người dùng và quyền được trích xuất từ token

```typescript
const _token = Cookie.get(AuthConstant.ACCESS_TOKEN_KEY);
const userInfo = jwtDecode(_token) as NguoiDung;
```

#### Kiểm tra quyền truy cập
- **AuthGuard**: Kiểm tra xem người dùng đã đăng nhập hay chưa
  - Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
  - Được cấu hình trong class `AuthGuard`

```typescript
canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
  return this.authService.checkAuthen();
}
```

- **RoleGuard**: Kiểm tra xem người dùng có quyền truy cập vào trang hay không
  - Lấy danh sách vai trò được phép từ route data
  - Kiểm tra xem người dùng có vai trò nào trong danh sách đó không
  - Nếu không có quyền, chuyển hướng đến trang lỗi 403
  - Được cấu hình trong class `RoleGuard`

```typescript
async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
  let isPermission: boolean = false;
  const roles = route.data["guards"];
  let isAuthenticate: boolean = false;
  if (Cookie.check(AuthConstant.ACCESS_TOKEN_KEY)) {
    isAuthenticate = true;
  }
  if (isAuthenticate) {
    const _token = Cookie.get(AuthConstant.ACCESS_TOKEN_KEY);
    const userInfo = jwtDecode(_token) as NguoiDung;
    if (userInfo.id) {
      await lastValueFrom(this.authService.get(userInfo.id))
        .then((resp: any) => {
          if (CommonConstant.STATUS_OK_200 == resp.status) {
            let temp: any = resp.data.nhomQuyens;
            let roleStr: string[] = [...temp].map((role: Quyen) => role.id);
            isPermission = roleStr.some((role: string) =>
              roles.includes(role)
            );
          }
        })
        .catch((err: any) => {});
    }
  }
  if (!isPermission) {
    this.router.navigate(["/error/403"]);
  }
  return isPermission;
}
```

#### Xử lý lỗi phân quyền
- Nếu người dùng không có quyền truy cập, họ sẽ được chuyển hướng đến trang lỗi 403
- Trang lỗi 403 hiển thị thông báo "Forbidden" và hướng dẫn người dùng quay lại trang chủ

## Hướng dẫn sử dụng

### Đăng nhập hệ thống

1. Truy cập trang đăng nhập: `/login`
2. Nhập tên đăng nhập và mật khẩu
3. Sau khi đăng nhập thành công, hệ thống sẽ chuyển hướng đến trang phù hợp với vai trò của người dùng:
   - ADMIN, MANAGER: `/sys`
   - CUSTOMER: `/user`

### Kiểm tra quyền của người dùng

Trong frontend, bạn có thể kiểm tra quyền của người dùng bằng cách sử dụng RoleService:

```typescript
import { RoleService } from 'src/app/_service/auth/role.service';

constructor(private roleService: RoleService) {}

// Kiểm tra xem người dùng có vai trò ADMIN hay không
if (this.roleService.hasRole(AuthConstant.ROLE_ADMIN.toString())) {
  // Người dùng có vai trò ADMIN
}
```

### Bảo vệ route với RoleGuard

Để bảo vệ một route, bạn cần cấu hình trong file routing module:

```typescript
{
  path: 'product',
  component: ThuocComponent,
  canActivate: [RoleGuard],
  data: {
    guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
  },
}
```

## Quyền truy cập API

Hệ thống cung cấp nhiều API để tương tác với dữ liệu. Dưới đây là danh sách các API chính và quyền truy cập tương ứng:

### API Quản lý người dùng

| Phương thức | Endpoint | Mô tả | Vai trò được phép |
|-------------|----------|-------|-------------------|
| POST | /dangnhap | Đăng nhập hệ thống | Tất cả |
| POST | /nguoidung/dangky | Đăng ký tài khoản mới | Tất cả |
| GET | /nguoidung/get | Lấy thông tin người dùng theo ID | Tất cả |
| PUT | /nguoidung/update | Cập nhật thông tin người dùng | Người dùng hiện tại, ADMIN, MANAGER |
| POST | /nguoidung/list | Tìm kiếm người dùng | ADMIN, MANAGER |
| PUT | /nguoidung/change_matkhau | Thay đổi mật khẩu | Người dùng hiện tại, ADMIN |
| PUT | /nguoidung/forgot_matkhau | Quên mật khẩu | Tất cả |
| PUT | /nguoidung/change_avatar | Thay đổi avatar | Người dùng hiện tại, ADMIN, MANAGER |

### API Quản lý thuốc

| Phương thức | Endpoint | Mô tả | Vai trò được phép |
|-------------|----------|-------|-------------------|
| GET | /thuoc/get | Lấy thông tin thuốc theo ID | Tất cả |
| POST | /thuoc/list | Tìm kiếm thuốc | Tất cả |
| POST | /thuoc/create | Tạo mới thuốc | ADMIN, MANAGER, PHARMACIST |
| PUT | /thuoc/update | Cập nhật thông tin thuốc | ADMIN, MANAGER, PHARMACIST |
| DELETE | /thuoc/delete | Xóa thuốc | ADMIN, MANAGER, PHARMACIST |

### API Quản lý đơn hàng

| Phương thức | Endpoint | Mô tả | Vai trò được phép |
|-------------|----------|-------|-------------------|
| GET | /donhang/get | Lấy thông tin đơn hàng theo ID | ADMIN, MANAGER, CASHIER, Người dùng sở hữu đơn hàng |
| POST | /donhang/list | Tìm kiếm đơn hàng | ADMIN, MANAGER, CASHIER |
| POST | /donhang/create | Tạo mới đơn hàng | Tất cả người dùng đã đăng nhập |
| PUT | /donhang/update | Cập nhật thông tin đơn hàng | ADMIN, MANAGER, CASHIER |
| DELETE | /donhang/delete | Xóa đơn hàng | ADMIN, MANAGER |
| GET | /donhang/by-user | Lấy đơn hàng theo người dùng | ADMIN, MANAGER, Người dùng sở hữu đơn hàng |

### API Quản lý nhập kho

| Phương thức | Endpoint | Mô tả | Vai trò được phép |
|-------------|----------|-------|-------------------|
| GET | /phieunhap/get | Lấy thông tin phiếu nhập theo ID | ADMIN, MANAGER, PHARMACIST |
| POST | /phieunhap/list | Tìm kiếm phiếu nhập | ADMIN, MANAGER, PHARMACIST |
| POST | /phieunhap/create | Tạo mới phiếu nhập | ADMIN, MANAGER, PHARMACIST |
| PUT | /phieunhap/update | Cập nhật thông tin phiếu nhập | ADMIN, MANAGER, PHARMACIST |
| DELETE | /phieunhap/delete | Xóa phiếu nhập | ADMIN, MANAGER |

### API Quản lý khuyến mãi

| Phương thức | Endpoint | Mô tả | Vai trò được phép |
|-------------|----------|-------|-------------------|
| GET | /khuyenmai/get | Lấy thông tin khuyến mãi theo ID | Tất cả |
| POST | /khuyenmai/list | Tìm kiếm khuyến mãi | Tất cả |
| POST | /khuyenmai/create | Tạo mới khuyến mãi | ADMIN, MANAGER |
| PUT | /khuyenmai/update | Cập nhật thông tin khuyến mãi | ADMIN, MANAGER |
| DELETE | /khuyenmai/delete | Xóa khuyến mãi | ADMIN, MANAGER |

## Xử lý lỗi phân quyền

### Lỗi 403 (Forbidden)

Lỗi 403 xảy ra khi người dùng không có quyền truy cập vào trang hoặc API. Có một số nguyên nhân có thể gây ra lỗi này:

1. **Người dùng chưa đăng nhập hoặc token đã hết hạn**
   - Giải pháp: Đăng nhập lại để lấy token mới

2. **Người dùng không có quyền truy cập**
   - Giải pháp: Sử dụng tài khoản có đủ quyền truy cập

3. **Vấn đề với cấu hình phân quyền**
   - Giải pháp: Kiểm tra cấu hình phân quyền trong hệ thống

4. **Vấn đề với JWT Filter**
   - Giải pháp: Kiểm tra log của backend để xem lỗi cụ thể

### Các bước xử lý lỗi phân quyền

1. Kiểm tra xem người dùng đã đăng nhập hay chưa
2. Kiểm tra xem token có hợp lệ hay không
3. Kiểm tra xem người dùng có quyền truy cập vào trang hay không
4. Nếu vẫn gặp lỗi, đăng nhập lại với tài khoản có đủ quyền (như admin/123456)
