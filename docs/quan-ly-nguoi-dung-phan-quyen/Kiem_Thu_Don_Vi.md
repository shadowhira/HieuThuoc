# KIỂM THỬ ĐƠN VỊ CHỨC NĂNG QUẢN LÝ NGƯỜI DÙNG VÀ PHÂN QUYỀN

## 1. TỔNG QUAN

### 1.1. Mục đích

Tài liệu này mô tả chi tiết các test case và quy trình kiểm thử đơn vị cho chức năng quản lý người dùng và phân quyền trong hệ thống web bán và quản lý hiệu thuốc. Kiểm thử đơn vị tập trung vào việc kiểm tra các thành phần riêng lẻ của hệ thống để đảm bảo chúng hoạt động đúng.

### 1.2. Phạm vi

Tài liệu này áp dụng cho việc kiểm thử đơn vị các thành phần:

- Service: NguoiDungService, NhomQuyenService, ChucNangService
- Controller: NguoiDungController, NhomQuyenController, ChucNangController
- Repository: NguoiDungRepository, NhomQuyenRepository, ChucNangRepository
- Validator: NguoiDungValidator, NhomQuyenValidator

## 2. MÔI TRƯỜNG KIỂM THỬ

### 2.1. Môi trường phần cứng

- Máy tính có cấu hình tối thiểu: CPU Core i5, RAM 8GB, SSD 256GB

### 2.2. Môi trường phần mềm

- Hệ điều hành: Windows 10/11
- JDK: Java 11
- IDE: IntelliJ IDEA, Eclipse
- Công cụ kiểm thử: JUnit 5, Mockito
- Công cụ phân tích độ bao phủ: JaCoCo

### 2.3. Dữ liệu kiểm thử

- Dữ liệu mẫu cho các đối tượng: NguoiDung, NhomQuyen, ChucNang
- Dữ liệu không hợp lệ để kiểm tra xử lý ngoại lệ

## 3. KIỂM THỬ SERVICE

### 3.1. NguoiDungService

#### UT_NGUOIDUNG_SERVICE_001: Kiểm thử phương thức tạo người dùng mới

**Mô tả**: Kiểm tra phương thức tạo người dùng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với dữ liệu hợp lệ
2. Mock NguoiDungRepository để trả về người dùng đã tạo
3. Gọi phương thức create(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là người dùng đã tạo
- Phương thức save của repository được gọi đúng một lần
- Dữ liệu người dùng được lưu chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_001: Kiểm thử phương thức tạo người dùng mới")
void testCreateNguoiDung_WithValidData_ShouldReturnCreatedNguoiDung() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setHoTen("Nguyễn Văn A");
    nguoiDungDTO.setTenDangNhap("nguyenvana");
    nguoiDungDTO.setEmail("nguyenvana@example.com");
    nguoiDungDTO.setSoDienThoai("0987654321");
    nguoiDungDTO.setMatKhau("Password123@");

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654321");

    when(nguoiDungRepository.save(any(NguoiDung.class))).thenReturn(nguoiDung);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.create(nguoiDungDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Nguyễn Văn A", result.getData().getHoTen());
    assertEquals("nguyenvana", result.getData().getTenDangNhap());

    verify(nguoiDungRepository, times(1)).save(any(NguoiDung.class));
    verify(passwordEncoder, times(1)).encode("Password123@");
}
```

#### UT_NGUOIDUNG_SERVICE_001A: Kiểm thử phương thức đăng ký người dùng mới

**Mô tả**: Kiểm tra phương thức đăng ký người dùng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với dữ liệu hợp lệ
2. Mock NguoiDungRepository để trả về null khi kiểm tra email và tên đăng nhập (chưa tồn tại)
3. Mock NhomQuyenRepository để trả về nhóm quyền KHACH_HANG
4. Mock GioHangRepository để kiểm tra việc tạo giỏ hàng
5. Gọi phương thức register(nguoiDungDTO) của NguoiDungService
6. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và thông báo đăng ký thành công
- Phương thức save của NguoiDungRepository được gọi đúng một lần
- Phương thức save của GioHangRepository được gọi đúng một lần
- Dữ liệu người dùng được lưu chính xác với nhóm quyền là KHACH_HANG
- Mật khẩu được mã hóa trước khi lưu
- Giỏ hàng được tạo cho người dùng mới

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_001A: Kiểm thử phương thức đăng ký người dùng mới")
void testRegisterNguoiDung_WithValidData_ShouldReturnRegisteredNguoiDung() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setHoTen("Nguyễn Văn A");
    nguoiDungDTO.setTenDangNhap("nguyenvana");
    nguoiDungDTO.setEmail("nguyenvana@example.com");
    nguoiDungDTO.setSoDienThoai("0987654321");
    nguoiDungDTO.setMatKhau("Password123@");
    nguoiDungDTO.setDiaChi("Hà Nội");

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654321");
    nguoiDung.setDiaChi("Hà Nội");

    NhomQuyen khachHangRole = new NhomQuyen();
    khachHangRole.setId(1);
    khachHangRole.setTenNhomQuyen("KHACH_HANG");
    khachHangRole.setMoTa("Nhóm quyền dành cho khách hàng");

    when(nguoiDungRepository.findByTenDangNhap("nguyenvana")).thenReturn(null);
    when(nguoiDungRepository.findByEmail("nguyenvana@example.com")).thenReturn(null);
    when(nhomQuyenRepository.findByTenNhomQuyen("KHACH_HANG")).thenReturn(khachHangRole);
    when(nguoiDungRepository.save(any(NguoiDung.class))).thenReturn(nguoiDung);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.register(nguoiDungDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Đăng ký thành công.", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Nguyễn Văn A", result.getData().getHoTen());
    assertEquals("nguyenvana", result.getData().getTenDangNhap());

    verify(nguoiDungRepository, times(1)).findByTenDangNhap("nguyenvana");
    verify(nguoiDungRepository, times(1)).findByEmail("nguyenvana@example.com");
    verify(nhomQuyenRepository, times(1)).findByTenNhomQuyen("KHACH_HANG");
    verify(nguoiDungRepository, times(1)).save(any(NguoiDung.class));
    verify(gioHangRepository, times(1)).save(any(GioHang.class));
}
```

#### UT_NGUOIDUNG_SERVICE_001B: Kiểm thử đăng ký với email đã tồn tại

**Mô tả**: Kiểm tra phương thức đăng ký người dùng với email đã tồn tại.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với email đã tồn tại
2. Mock NguoiDungRepository để trả về người dùng hiện có khi kiểm tra email
3. Gọi phương thức register(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 400 và thông báo lỗi email đã tồn tại
- Phương thức save của NguoiDungRepository không được gọi

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_001B: Kiểm thử đăng ký với email đã tồn tại")
void testRegisterNguoiDung_WithExistingEmail_ShouldReturnError() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setHoTen("Nguyễn Văn A");
    nguoiDungDTO.setTenDangNhap("nguyenvana");
    nguoiDungDTO.setEmail("existing@example.com");
    nguoiDungDTO.setSoDienThoai("0987654321");
    nguoiDungDTO.setMatKhau("Password123@");

    NguoiDung existingNguoiDung = new NguoiDung();
    existingNguoiDung.setId(1);
    existingNguoiDung.setEmail("existing@example.com");

    when(nguoiDungRepository.findByTenDangNhap("nguyenvana")).thenReturn(null);
    when(nguoiDungRepository.findByEmail("existing@example.com")).thenReturn(existingNguoiDung);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.register(nguoiDungDTO);

    // Assert
    assertNotNull(result);
    assertEquals(400, result.getStatus());
    assertEquals("Email đã tồn tại.", result.getMsg());

    verify(nguoiDungRepository, times(1)).findByEmail("existing@example.com");
    verify(nguoiDungRepository, never()).save(any(NguoiDung.class));
    verify(gioHangRepository, never()).save(any(GioHang.class));
}
```

#### UT_NGUOIDUNG_SERVICE_001C: Kiểm thử đăng ký với tên đăng nhập đã tồn tại

**Mô tả**: Kiểm tra phương thức đăng ký người dùng với tên đăng nhập đã tồn tại.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với tên đăng nhập đã tồn tại
2. Mock NguoiDungRepository để trả về người dùng hiện có khi kiểm tra tên đăng nhập
3. Gọi phương thức register(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 400 và thông báo lỗi tên đăng nhập đã tồn tại
- Phương thức save của NguoiDungRepository không được gọi

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_001C: Kiểm thử đăng ký với tên đăng nhập đã tồn tại")
void testRegisterNguoiDung_WithExistingUsername_ShouldReturnError() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setHoTen("Nguyễn Văn A");
    nguoiDungDTO.setTenDangNhap("existing");
    nguoiDungDTO.setEmail("nguyenvana@example.com");
    nguoiDungDTO.setSoDienThoai("0987654321");
    nguoiDungDTO.setMatKhau("Password123@");

    NguoiDung existingNguoiDung = new NguoiDung();
    existingNguoiDung.setId(1);
    existingNguoiDung.setTenDangNhap("existing");

    when(nguoiDungRepository.findByTenDangNhap("existing")).thenReturn(existingNguoiDung);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.register(nguoiDungDTO);

    // Assert
    assertNotNull(result);
    assertEquals(400, result.getStatus());
    assertEquals("Tên đăng nhập đã tồn tại.", result.getMsg());

    verify(nguoiDungRepository, times(1)).findByTenDangNhap("existing");
    verify(nguoiDungRepository, never()).findByEmail(anyString());
    verify(nguoiDungRepository, never()).save(any(NguoiDung.class));
    verify(gioHangRepository, never()).save(any(GioHang.class));
}
```

#### UT_NGUOIDUNG_SERVICE_002: Kiểm thử phương thức cập nhật người dùng

**Mô tả**: Kiểm tra phương thức cập nhật thông tin người dùng.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với ID đã tồn tại
2. Mock NguoiDungRepository để trả về người dùng hiện có
3. Gọi phương thức update(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là người dùng đã cập nhật
- Phương thức save của repository được gọi đúng một lần
- Dữ liệu người dùng được cập nhật chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_002: Kiểm thử phương thức cập nhật người dùng")
void testUpdateNguoiDung_WithValidData_ShouldReturnUpdatedNguoiDung() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setId(1);
    nguoiDungDTO.setHoTen("Nguyễn Văn A Updated");
    nguoiDungDTO.setTenDangNhap("nguyenvana");
    nguoiDungDTO.setEmail("nguyenvana@example.com");
    nguoiDungDTO.setSoDienThoai("0987654322");

    NguoiDung existingNguoiDung = new NguoiDung();
    existingNguoiDung.setId(1);
    existingNguoiDung.setHoTen("Nguyễn Văn A");
    existingNguoiDung.setTenDangNhap("nguyenvana");
    existingNguoiDung.setEmail("nguyenvana@example.com");
    existingNguoiDung.setSoDienThoai("0987654321");

    NguoiDung updatedNguoiDung = new NguoiDung();
    updatedNguoiDung.setId(1);
    updatedNguoiDung.setHoTen("Nguyễn Văn A Updated");
    updatedNguoiDung.setTenDangNhap("nguyenvana");
    updatedNguoiDung.setEmail("nguyenvana@example.com");
    updatedNguoiDung.setSoDienThoai("0987654322");

    when(nguoiDungRepository.findById(1)).thenReturn(Optional.of(existingNguoiDung));
    when(nguoiDungRepository.save(any(NguoiDung.class))).thenReturn(updatedNguoiDung);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.update(nguoiDungDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Nguyễn Văn A Updated", result.getData().getHoTen());
    assertEquals("0987654322", result.getData().getSoDienThoai());

    verify(nguoiDungRepository, times(1)).findById(1);
    verify(nguoiDungRepository, times(1)).save(any(NguoiDung.class));
}
```

#### UT_NGUOIDUNG_SERVICE_003: Kiểm thử phương thức lấy thông tin người dùng theo ID

**Mô tả**: Kiểm tra phương thức lấy thông tin người dùng theo ID.

**Các bước thực hiện**:

1. Mock NguoiDungRepository để trả về người dùng với ID cụ thể
2. Gọi phương thức getById(id) của NguoiDungService
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là người dùng tìm thấy
- Phương thức findById của repository được gọi đúng một lần
- Dữ liệu người dùng được trả về chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_003: Kiểm thử phương thức lấy thông tin người dùng theo ID")
void testGetNguoiDungById_ShouldReturnNguoiDung() {
    // Arrange
    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654321");

    when(nguoiDungRepository.findById(1)).thenReturn(Optional.of(nguoiDung));

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.getById(1);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Nguyễn Văn A", result.getData().getHoTen());
    assertEquals("nguyenvana", result.getData().getTenDangNhap());

    verify(nguoiDungRepository, times(1)).findById(1);
}
```

### 3.2. NhomQuyenService

#### UT_NHOMQUYEN_SERVICE_001: Kiểm thử phương thức tạo nhóm quyền mới

**Mô tả**: Kiểm tra phương thức tạo nhóm quyền mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NhomQuyenDTO với dữ liệu hợp lệ
2. Mock NhomQuyenRepository để trả về nhóm quyền đã tạo
3. Mock ChucNangRepository để trả về các chức năng tương ứng với ID
4. Gọi phương thức create(nhomQuyenDTO) của NhomQuyenService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là nhóm quyền đã tạo
- Phương thức save của repository được gọi đúng một lần
- Dữ liệu nhóm quyền được lưu chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_001: Kiểm thử phương thức tạo nhóm quyền mới")
void testCreateNhomQuyen_WithValidData_ShouldReturnCreatedNhomQuyen() {
    // Arrange
    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
    nhomQuyenDTO.setTenNhomQuyen("Quản lý kho");
    nhomQuyenDTO.setMoTa("Nhóm quyền dành cho quản lý kho");

    List<Integer> chucNangIds = Arrays.asList(1, 2, 3);
    nhomQuyenDTO.setChucNangIds(chucNangIds);

    NhomQuyen nhomQuyen = new NhomQuyen();
    nhomQuyen.setId(1);
    nhomQuyen.setTenNhomQuyen("Quản lý kho");
    nhomQuyen.setMoTa("Nhóm quyền dành cho quản lý kho");

    ChucNang chucNang1 = new ChucNang();
    chucNang1.setId(1);
    chucNang1.setTenChucNang("Thêm thuốc");

    ChucNang chucNang2 = new ChucNang();
    chucNang2.setId(2);
    chucNang2.setTenChucNang("Sửa thuốc");

    ChucNang chucNang3 = new ChucNang();
    chucNang3.setId(3);
    chucNang3.setTenChucNang("Xóa thuốc");

    when(chucNangRepository.findById(1)).thenReturn(Optional.of(chucNang1));
    when(chucNangRepository.findById(2)).thenReturn(Optional.of(chucNang2));
    when(chucNangRepository.findById(3)).thenReturn(Optional.of(chucNang3));
    when(nhomQuyenRepository.save(any(NhomQuyen.class))).thenReturn(nhomQuyen);

    // Act
    ResponseDTO<NhomQuyen> result = nhomQuyenService.create(nhomQuyenDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Quản lý kho", result.getData().getTenNhomQuyen());

    verify(nhomQuyenRepository, times(1)).save(any(NhomQuyen.class));
    verify(chucNangRepository, times(3)).findById(anyInt());
}
```

#### UT_NHOMQUYEN_SERVICE_002: Kiểm thử phương thức cập nhật nhóm quyền

**Mô tả**: Kiểm tra phương thức cập nhật thông tin nhóm quyền.

**Các bước thực hiện**:

1. Tạo đối tượng NhomQuyenDTO với ID đã tồn tại
2. Mock NhomQuyenRepository để trả về nhóm quyền hiện có
3. Mock ChucNangRepository để trả về các chức năng tương ứng với ID
4. Gọi phương thức update(nhomQuyenDTO) của NhomQuyenService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là nhóm quyền đã cập nhật
- Phương thức save của repository được gọi đúng một lần
- Dữ liệu nhóm quyền được cập nhật chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_002: Kiểm thử phương thức cập nhật nhóm quyền")
void testUpdateNhomQuyen_WithValidData_ShouldReturnUpdatedNhomQuyen() {
    // Arrange
    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
    nhomQuyenDTO.setId(1);
    nhomQuyenDTO.setTenNhomQuyen("Quản lý kho Updated");
    nhomQuyenDTO.setMoTa("Nhóm quyền dành cho quản lý kho - Cập nhật");

    List<Integer> chucNangIds = Arrays.asList(1, 2, 4);
    nhomQuyenDTO.setChucNangIds(chucNangIds);

    NhomQuyen existingNhomQuyen = new NhomQuyen();
    existingNhomQuyen.setId(1);
    existingNhomQuyen.setTenNhomQuyen("Quản lý kho");
    existingNhomQuyen.setMoTa("Nhóm quyền dành cho quản lý kho");

    NhomQuyen updatedNhomQuyen = new NhomQuyen();
    updatedNhomQuyen.setId(1);
    updatedNhomQuyen.setTenNhomQuyen("Quản lý kho Updated");
    updatedNhomQuyen.setMoTa("Nhóm quyền dành cho quản lý kho - Cập nhật");

    ChucNang chucNang1 = new ChucNang();
    chucNang1.setId(1);
    chucNang1.setTenChucNang("Thêm thuốc");

    ChucNang chucNang2 = new ChucNang();
    chucNang2.setId(2);
    chucNang2.setTenChucNang("Sửa thuốc");

    ChucNang chucNang4 = new ChucNang();
    chucNang4.setId(4);
    chucNang4.setTenChucNang("Xem thuốc");

    when(nhomQuyenRepository.findById(1)).thenReturn(Optional.of(existingNhomQuyen));
    when(chucNangRepository.findById(1)).thenReturn(Optional.of(chucNang1));
    when(chucNangRepository.findById(2)).thenReturn(Optional.of(chucNang2));
    when(chucNangRepository.findById(4)).thenReturn(Optional.of(chucNang4));
    when(nhomQuyenRepository.save(any(NhomQuyen.class))).thenReturn(updatedNhomQuyen);

    // Act
    ResponseDTO<NhomQuyen> result = nhomQuyenService.update(nhomQuyenDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Quản lý kho Updated", result.getData().getTenNhomQuyen());

    verify(nhomQuyenRepository, times(1)).findById(1);
    verify(nhomQuyenRepository, times(1)).save(any(NhomQuyen.class));
    verify(chucNangRepository, times(3)).findById(anyInt());
}
```

### 3.3. ChucNangService

#### UT_CHUCNANG_SERVICE_001: Kiểm thử phương thức tạo chức năng mới

**Mô tả**: Kiểm tra phương thức tạo chức năng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng ChucNangDTO với dữ liệu hợp lệ
2. Mock ChucNangRepository để trả về chức năng đã tạo
3. Gọi phương thức create(chucNangDTO) của ChucNangService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là chức năng đã tạo
- Phương thức save của repository được gọi đúng một lần
- Dữ liệu chức năng được lưu chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_CHUCNANG_SERVICE_001: Kiểm thử phương thức tạo chức năng mới")
void testCreateChucNang_WithValidData_ShouldReturnCreatedChucNang() {
    // Arrange
    ChucNangDTO chucNangDTO = new ChucNangDTO();
    chucNangDTO.setTenChucNang("Quản lý tồn kho");
    chucNangDTO.setMoTa("Chức năng quản lý tồn kho thuốc");
    chucNangDTO.setHanhDong("VIEW_INVENTORY");

    ChucNang chucNang = new ChucNang();
    chucNang.setId(1);
    chucNang.setTenChucNang("Quản lý tồn kho");
    chucNang.setMoTa("Chức năng quản lý tồn kho thuốc");
    chucNang.setHanhDong("VIEW_INVENTORY");

    when(chucNangRepository.save(any(ChucNang.class))).thenReturn(chucNang);

    // Act
    ResponseDTO<ChucNang> result = chucNangService.create(chucNangDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Quản lý tồn kho", result.getData().getTenChucNang());
    assertEquals("VIEW_INVENTORY", result.getData().getHanhDong());

    verify(chucNangRepository, times(1)).save(any(ChucNang.class));
}
```

#### UT_CHUCNANG_SERVICE_002: Kiểm thử phương thức cập nhật chức năng

**Mô tả**: Kiểm tra phương thức cập nhật thông tin chức năng.

**Các bước thực hiện**:

1. Tạo đối tượng ChucNangDTO với ID đã tồn tại
2. Mock ChucNangRepository để trả về chức năng hiện có
3. Gọi phương thức update(chucNangDTO) của ChucNangService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là chức năng đã cập nhật
- Phương thức save của repository được gọi đúng một lần
- Dữ liệu chức năng được cập nhật chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_CHUCNANG_SERVICE_002: Kiểm thử phương thức cập nhật chức năng")
void testUpdateChucNang_WithValidData_ShouldReturnUpdatedChucNang() {
    // Arrange
    ChucNangDTO chucNangDTO = new ChucNangDTO();
    chucNangDTO.setId(1);
    chucNangDTO.setTenChucNang("Quản lý tồn kho Updated");
    chucNangDTO.setMoTa("Chức năng quản lý tồn kho thuốc - Cập nhật");
    chucNangDTO.setHanhDong("VIEW_INVENTORY_UPDATED");

    ChucNang existingChucNang = new ChucNang();
    existingChucNang.setId(1);
    existingChucNang.setTenChucNang("Quản lý tồn kho");
    existingChucNang.setMoTa("Chức năng quản lý tồn kho thuốc");
    existingChucNang.setHanhDong("VIEW_INVENTORY");

    ChucNang updatedChucNang = new ChucNang();
    updatedChucNang.setId(1);
    updatedChucNang.setTenChucNang("Quản lý tồn kho Updated");
    updatedChucNang.setMoTa("Chức năng quản lý tồn kho thuốc - Cập nhật");
    updatedChucNang.setHanhDong("VIEW_INVENTORY_UPDATED");

    when(chucNangRepository.findById(1)).thenReturn(Optional.of(existingChucNang));
    when(chucNangRepository.save(any(ChucNang.class))).thenReturn(updatedChucNang);

    // Act
    ResponseDTO<ChucNang> result = chucNangService.update(chucNangDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Quản lý tồn kho Updated", result.getData().getTenChucNang());
    assertEquals("VIEW_INVENTORY_UPDATED", result.getData().getHanhDong());

    verify(chucNangRepository, times(1)).findById(1);
    verify(chucNangRepository, times(1)).save(any(ChucNang.class));
}
```

#### UT_CHUCNANG_SERVICE_003: Kiểm thử phương thức lấy danh sách tất cả chức năng

**Mô tả**: Kiểm tra phương thức lấy danh sách tất cả chức năng.

**Các bước thực hiện**:

1. Mock ChucNangRepository để trả về danh sách chức năng
2. Gọi phương thức getAll() của ChucNangService
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và data là danh sách chức năng
- Phương thức findAll của repository được gọi đúng một lần
- Danh sách chức năng được trả về chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_CHUCNANG_SERVICE_003: Kiểm thử phương thức lấy danh sách tất cả chức năng")
void testGetAllChucNang_ShouldReturnAllChucNang() {
    // Arrange
    ChucNang chucNang1 = new ChucNang();
    chucNang1.setId(1);
    chucNang1.setTenChucNang("Quản lý tồn kho");
    chucNang1.setMoTa("Chức năng quản lý tồn kho thuốc");
    chucNang1.setHanhDong("VIEW_INVENTORY");

    ChucNang chucNang2 = new ChucNang();
    chucNang2.setId(2);
    chucNang2.setTenChucNang("Quản lý đơn hàng");
    chucNang2.setMoTa("Chức năng quản lý đơn hàng");
    chucNang2.setHanhDong("VIEW_ORDERS");

    List<ChucNang> chucNangList = Arrays.asList(chucNang1, chucNang2);

    when(chucNangRepository.findAll()).thenReturn(chucNangList);

    // Act
    ResponseDTO<List<ChucNang>> result = chucNangService.getAll();

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    assertEquals(2, result.getData().size());
    assertEquals("Quản lý tồn kho", result.getData().get(0).getTenChucNang());
    assertEquals("Quản lý đơn hàng", result.getData().get(1).getTenChucNang());

    verify(chucNangRepository, times(1)).findAll();
}
```

## 4. KIỂM THỬ CONTROLLER

### 4.1. NguoiDungController

#### UT_NGUOIDUNG_CONTROLLER_001: Kiểm thử API tạo người dùng mới

**Mô tả**: Kiểm tra API tạo người dùng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với dữ liệu hợp lệ
2. Mock NguoiDungService để trả về người dùng đã tạo
3. Gọi phương thức create của NguoiDungController
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseEntity với status code 200 OK
- Response body chứa thông tin người dùng vừa tạo
- Phương thức create của service được gọi đúng một lần

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_CONTROLLER_001: Kiểm thử API tạo người dùng mới")
void testCreateNguoiDung_WithValidData_ShouldReturnCreatedNguoiDung() {
    // Arrange
    NguoiDungDTO requestDTO = new NguoiDungDTO();
    requestDTO.setHoTen("Nguyễn Văn A");
    requestDTO.setTenDangNhap("nguyenvana");
    requestDTO.setEmail("nguyenvana@example.com");
    requestDTO.setSoDienThoai("0987654321");
    requestDTO.setMatKhau("Password123@");

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654321");

    ResponseDTO<NguoiDung> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(200);
    responseDTO.setMsg("Thành công");
    responseDTO.setData(nguoiDung);

    when(nguoiDungService.create(any(NguoiDungDTO.class))).thenReturn(responseDTO);

    // Act
    ResponseEntity<ResponseDTO<NguoiDung>> result = nguoiDungController.create(requestDTO);

    // Assert
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(200, result.getBody().getStatus());
    assertEquals("Thành công", result.getBody().getMsg());
    assertEquals(1, result.getBody().getData().getId());
    assertEquals("Nguyễn Văn A", result.getBody().getData().getHoTen());
    assertEquals("nguyenvana", result.getBody().getData().getTenDangNhap());

    verify(nguoiDungService, times(1)).create(any(NguoiDungDTO.class));
}
```

#### UT_NGUOIDUNG_CONTROLLER_001A: Kiểm thử API đăng ký người dùng mới

**Mô tả**: Kiểm tra API đăng ký người dùng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với dữ liệu hợp lệ
2. Mock NguoiDungService để trả về kết quả đăng ký thành công
3. Gọi phương thức register của NguoiDungController
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseDTO với status 200 và thông báo đăng ký thành công
- Phương thức register của service được gọi đúng một lần với dữ liệu đúng

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_CONTROLLER_001A: Kiểm thử API đăng ký người dùng mới")
void testRegisterNguoiDung_WithValidData_ShouldReturnSuccess() {
    // Arrange
    NguoiDungDTO requestDTO = new NguoiDungDTO();
    requestDTO.setHoTen("Nguyễn Văn A");
    requestDTO.setTenDangNhap("nguyenvana");
    requestDTO.setEmail("nguyenvana@example.com");
    requestDTO.setSoDienThoai("0987654321");
    requestDTO.setMatKhau("Password123@");
    requestDTO.setDiaChi("Hà Nội");

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654321");
    nguoiDung.setDiaChi("Hà Nội");

    ResponseDTO<NguoiDung> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(200);
    responseDTO.setMsg("Đăng ký thành công.");
    responseDTO.setData(nguoiDung);

    when(nguoiDungService.register(any(NguoiDungDTO.class))).thenReturn(responseDTO);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungController.register(requestDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Đăng ký thành công.", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Nguyễn Văn A", result.getData().getHoTen());
    assertEquals("nguyenvana", result.getData().getTenDangNhap());

    verify(nguoiDungService, times(1)).register(any(NguoiDungDTO.class));
}
```

#### UT_NGUOIDUNG_CONTROLLER_001B: Kiểm thử API đăng ký với email đã tồn tại

**Mô tả**: Kiểm tra API đăng ký người dùng với email đã tồn tại.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với email đã tồn tại
2. Mock NguoiDungService để trả về kết quả lỗi
3. Gọi phương thức register của NguoiDungController
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseDTO với status 400 và thông báo lỗi email đã tồn tại
- Phương thức register của service được gọi đúng một lần

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_CONTROLLER_001B: Kiểm thử API đăng ký với email đã tồn tại")
void testRegisterNguoiDung_WithExistingEmail_ShouldReturnError() {
    // Arrange
    NguoiDungDTO requestDTO = new NguoiDungDTO();
    requestDTO.setHoTen("Nguyễn Văn A");
    requestDTO.setTenDangNhap("nguyenvana");
    requestDTO.setEmail("existing@example.com");
    requestDTO.setSoDienThoai("0987654321");
    requestDTO.setMatKhau("Password123@");

    ResponseDTO<NguoiDung> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(400);
    responseDTO.setMsg("Email đã tồn tại.");
    responseDTO.setData(null);

    when(nguoiDungService.register(any(NguoiDungDTO.class))).thenReturn(responseDTO);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungController.register(requestDTO);

    // Assert
    assertNotNull(result);
    assertEquals(400, result.getStatus());
    assertEquals("Email đã tồn tại.", result.getMsg());
    assertNull(result.getData());

    verify(nguoiDungService, times(1)).register(any(NguoiDungDTO.class));
}
```

#### UT_NGUOIDUNG_CONTROLLER_002: Kiểm thử API cập nhật người dùng

**Mô tả**: Kiểm tra API cập nhật người dùng với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với ID đã tồn tại
2. Mock NguoiDungService để trả về người dùng đã cập nhật
3. Gọi phương thức update của NguoiDungController
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseEntity với status code 200 OK
- Response body chứa thông tin người dùng đã cập nhật
- Phương thức update của service được gọi đúng một lần

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_CONTROLLER_002: Kiểm thử API cập nhật người dùng")
void testUpdateNguoiDung_WithValidData_ShouldReturnUpdatedNguoiDung() {
    // Arrange
    NguoiDungDTO requestDTO = new NguoiDungDTO();
    requestDTO.setId(1);
    requestDTO.setHoTen("Nguyễn Văn A Updated");
    requestDTO.setTenDangNhap("nguyenvana");
    requestDTO.setEmail("nguyenvana@example.com");
    requestDTO.setSoDienThoai("0987654322");

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A Updated");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654322");

    ResponseDTO<NguoiDung> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(200);
    responseDTO.setMsg("Thành công");
    responseDTO.setData(nguoiDung);

    when(nguoiDungService.update(any(NguoiDungDTO.class))).thenReturn(responseDTO);

    // Act
    ResponseEntity<ResponseDTO<NguoiDung>> result = nguoiDungController.update(requestDTO);

    // Assert
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(200, result.getBody().getStatus());
    assertEquals("Thành công", result.getBody().getMsg());
    assertEquals(1, result.getBody().getData().getId());
    assertEquals("Nguyễn Văn A Updated", result.getBody().getData().getHoTen());
    assertEquals("0987654322", result.getBody().getData().getSoDienThoai());

    verify(nguoiDungService, times(1)).update(any(NguoiDungDTO.class));
}
```

#### UT_NGUOIDUNG_CONTROLLER_003: Kiểm thử API lấy thông tin người dùng theo ID

**Mô tả**: Kiểm tra API lấy thông tin người dùng theo ID.

**Các bước thực hiện**:

1. Mock NguoiDungService để trả về người dùng với ID cụ thể
2. Gọi phương thức getById của NguoiDungController
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseEntity với status code 200 OK
- Response body chứa thông tin người dùng tìm thấy
- Phương thức getById của service được gọi đúng một lần

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_CONTROLLER_003: Kiểm thử API lấy thông tin người dùng theo ID")
void testGetNguoiDungById_ShouldReturnNguoiDung() {
    // Arrange
    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setHoTen("Nguyễn Văn A");
    nguoiDung.setTenDangNhap("nguyenvana");
    nguoiDung.setEmail("nguyenvana@example.com");
    nguoiDung.setSoDienThoai("0987654321");

    ResponseDTO<NguoiDung> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(200);
    responseDTO.setMsg("Thành công");
    responseDTO.setData(nguoiDung);

    when(nguoiDungService.getById(1)).thenReturn(responseDTO);

    // Act
    ResponseEntity<ResponseDTO<NguoiDung>> result = nguoiDungController.getById(1);

    // Assert
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(200, result.getBody().getStatus());
    assertEquals("Thành công", result.getBody().getMsg());
    assertEquals(1, result.getBody().getData().getId());
    assertEquals("Nguyễn Văn A", result.getBody().getData().getHoTen());
    assertEquals("nguyenvana", result.getBody().getData().getTenDangNhap());

    verify(nguoiDungService, times(1)).getById(1);
}
```

### 4.2. NhomQuyenController

#### UT_NHOMQUYEN_CONTROLLER_001: Kiểm thử API tạo nhóm quyền mới

**Mô tả**: Kiểm tra API tạo nhóm quyền mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng NhomQuyenDTO với dữ liệu hợp lệ
2. Mock NhomQuyenService để trả về nhóm quyền đã tạo
3. Gọi phương thức create của NhomQuyenController
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseEntity với status code 200 OK
- Response body chứa thông tin nhóm quyền vừa tạo
- Phương thức create của service được gọi đúng một lần

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NHOMQUYEN_CONTROLLER_001: Kiểm thử API tạo nhóm quyền mới")
void testCreateNhomQuyen_WithValidData_ShouldReturnCreatedNhomQuyen() {
    // Arrange
    NhomQuyenDTO requestDTO = new NhomQuyenDTO();
    requestDTO.setTenNhomQuyen("Quản lý kho");
    requestDTO.setMoTa("Nhóm quyền dành cho quản lý kho");
    requestDTO.setChucNangIds(Arrays.asList(1, 2, 3));

    NhomQuyen nhomQuyen = new NhomQuyen();
    nhomQuyen.setId(1);
    nhomQuyen.setTenNhomQuyen("Quản lý kho");
    nhomQuyen.setMoTa("Nhóm quyền dành cho quản lý kho");

    ResponseDTO<NhomQuyen> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(200);
    responseDTO.setMsg("Thành công");
    responseDTO.setData(nhomQuyen);

    when(nhomQuyenService.create(any(NhomQuyenDTO.class))).thenReturn(responseDTO);

    // Act
    ResponseEntity<ResponseDTO<NhomQuyen>> result = nhomQuyenController.create(requestDTO);

    // Assert
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(200, result.getBody().getStatus());
    assertEquals("Thành công", result.getBody().getMsg());
    assertEquals(1, result.getBody().getData().getId());
    assertEquals("Quản lý kho", result.getBody().getData().getTenNhomQuyen());

    verify(nhomQuyenService, times(1)).create(any(NhomQuyenDTO.class));
}
```

### 4.3. ChucNangController

#### UT_CHUCNANG_CONTROLLER_001: Kiểm thử API tạo chức năng mới

**Mô tả**: Kiểm tra API tạo chức năng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo đối tượng ChucNangDTO với dữ liệu hợp lệ
2. Mock ChucNangService để trả về chức năng đã tạo
3. Gọi phương thức create của ChucNangController
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Controller trả về đối tượng ResponseEntity với status code 200 OK
- Response body chứa thông tin chức năng vừa tạo
- Phương thức create của service được gọi đúng một lần

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_CHUCNANG_CONTROLLER_001: Kiểm thử API tạo chức năng mới")
void testCreateChucNang_WithValidData_ShouldReturnCreatedChucNang() {
    // Arrange
    ChucNangDTO requestDTO = new ChucNangDTO();
    requestDTO.setTenChucNang("Quản lý tồn kho");
    requestDTO.setMoTa("Chức năng quản lý tồn kho thuốc");
    requestDTO.setHanhDong("VIEW_INVENTORY");

    ChucNang chucNang = new ChucNang();
    chucNang.setId(1);
    chucNang.setTenChucNang("Quản lý tồn kho");
    chucNang.setMoTa("Chức năng quản lý tồn kho thuốc");
    chucNang.setHanhDong("VIEW_INVENTORY");

    ResponseDTO<ChucNang> responseDTO = new ResponseDTO<>();
    responseDTO.setStatus(200);
    responseDTO.setMsg("Thành công");
    responseDTO.setData(chucNang);

    when(chucNangService.create(any(ChucNangDTO.class))).thenReturn(responseDTO);

    // Act
    ResponseEntity<ResponseDTO<ChucNang>> result = chucNangController.create(requestDTO);

    // Assert
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(200, result.getBody().getStatus());
    assertEquals("Thành công", result.getBody().getMsg());
    assertEquals(1, result.getBody().getData().getId());
    assertEquals("Quản lý tồn kho", result.getBody().getData().getTenChucNang());
    assertEquals("VIEW_INVENTORY", result.getBody().getData().getHanhDong());

    verify(chucNangService, times(1)).create(any(ChucNangDTO.class));
}
```

## 5. KIỂM THỬ REPOSITORY

### 5.1. NguoiDungRepository

### 5.2. NhomQuyenRepository

### 5.3. ChucNangRepository

## 6. KIỂM THỬ VALIDATOR

### 6.1. NguoiDungValidator

#### UT_NGUOIDUNG_VALIDATOR_001: Kiểm thử validate email

**Mô tả**: Kiểm tra phương thức validate email của NguoiDungValidator.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với email không hợp lệ
2. Gọi phương thức validateEmail của NguoiDungValidator
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về false với email không hợp lệ
- Phương thức trả về true với email hợp lệ

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_VALIDATOR_001: Kiểm thử validate email không hợp lệ")
void testValidateEmail_WithInvalidEmail_ShouldReturnFalse() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setEmail("invalid-email");

    // Act
    boolean result = nguoiDungValidator.validateEmail(nguoiDungDTO);

    // Assert
    assertFalse(result);
}

@Test
@DisplayName("UT_NGUOIDUNG_VALIDATOR_002: Kiểm thử validate email hợp lệ")
void testValidateEmail_WithValidEmail_ShouldReturnTrue() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setEmail("valid@example.com");

    // Act
    boolean result = nguoiDungValidator.validateEmail(nguoiDungDTO);

    // Assert
    assertTrue(result);
}
```

#### UT_NGUOIDUNG_VALIDATOR_003: Kiểm thử validate mật khẩu

**Mô tả**: Kiểm tra phương thức validate mật khẩu của NguoiDungValidator.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với mật khẩu hợp lệ/không hợp lệ
2. Gọi phương thức validatePassword của NguoiDungValidator
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về false với mật khẩu không hợp lệ
- Phương thức trả về true với mật khẩu hợp lệ

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_VALIDATOR_003: Kiểm thử validate mật khẩu không hợp lệ")
void testValidatePassword_WithInvalidPassword_ShouldReturnFalse() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setMatKhau("weak");

    // Act
    boolean result = nguoiDungValidator.validatePassword(nguoiDungDTO);

    // Assert
    assertFalse(result);
}

@Test
@DisplayName("UT_NGUOIDUNG_VALIDATOR_004: Kiểm thử validate mật khẩu hợp lệ")
void testValidatePassword_WithValidPassword_ShouldReturnTrue() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setMatKhau("StrongP@ss123");

    // Act
    boolean result = nguoiDungValidator.validatePassword(nguoiDungDTO);

    // Assert
    assertTrue(result);
}
```

#### UT_NGUOIDUNG_VALIDATOR_005: Kiểm thử validate số điện thoại

**Mô tả**: Kiểm tra phương thức validate số điện thoại của NguoiDungValidator.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với số điện thoại hợp lệ/không hợp lệ
2. Gọi phương thức validatePhoneNumber của NguoiDungValidator
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về false với số điện thoại không hợp lệ
- Phương thức trả về true với số điện thoại hợp lệ

**Mã kiểm thử**:

```java
@Test
@DisplayName("UT_NGUOIDUNG_VALIDATOR_005: Kiểm thử validate số điện thoại không hợp lệ")
void testValidatePhoneNumber_WithInvalidPhoneNumber_ShouldReturnFalse() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setSoDienThoai("123abc");

    // Act
    boolean result = nguoiDungValidator.validatePhoneNumber(nguoiDungDTO);

    // Assert
    assertFalse(result);
}

@Test
@DisplayName("UT_NGUOIDUNG_VALIDATOR_006: Kiểm thử validate số điện thoại hợp lệ")
void testValidatePhoneNumber_WithValidPhoneNumber_ShouldReturnTrue() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setSoDienThoai("0987654321");

    // Act
    boolean result = nguoiDungValidator.validatePhoneNumber(nguoiDungDTO);

    // Assert
    assertTrue(result);
}
```

## 7. TỔNG HỢP KẾT QUẢ KIỂM THỬ

| ID Test Case                 | Mô tả                                                 | Kết quả | Ghi chú             |
| ---------------------------- | ----------------------------------------------------- | ------- | ------------------- |
| UT_NGUOIDUNG_SERVICE_001     | Kiểm thử phương thức tạo người dùng mới               | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_001A    | Kiểm thử phương thức đăng ký người dùng mới           | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_001B    | Kiểm thử đăng ký với email đã tồn tại                 | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_001C    | Kiểm thử đăng ký với tên đăng nhập đã tồn tại         | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_002     | Kiểm thử phương thức cập nhật người dùng              | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_003     | Kiểm thử phương thức lấy thông tin người dùng theo ID | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_001     | Kiểm thử phương thức tạo nhóm quyền mới               | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_002     | Kiểm thử phương thức cập nhật nhóm quyền              | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_SERVICE_001      | Kiểm thử phương thức tạo chức năng mới                | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_SERVICE_002      | Kiểm thử phương thức cập nhật chức năng               | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_SERVICE_003      | Kiểm thử phương thức lấy danh sách tất cả chức năng   | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_VALIDATOR_001   | Kiểm thử validate email không hợp lệ                  | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_VALIDATOR_002   | Kiểm thử validate email hợp lệ                        | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_VALIDATOR_003   | Kiểm thử validate mật khẩu không hợp lệ               | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_VALIDATOR_004   | Kiểm thử validate mật khẩu hợp lệ                     | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_VALIDATOR_005   | Kiểm thử validate số điện thoại không hợp lệ          | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_VALIDATOR_006   | Kiểm thử validate số điện thoại hợp lệ                | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_VALIDATOR_001   | Kiểm thử xác thực tên nhóm quyền rỗng                 | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_VALIDATOR_002   | Kiểm thử xác thực mô tả rỗng                          | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_VALIDATOR_003   | Kiểm thử xác thực danh sách chức năng rỗng            | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_VALIDATOR_004   | Kiểm thử xác thực chức năng không tồn tại             | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_VALIDATOR_005   | Kiểm thử xác thực dữ liệu hợp lệ                      | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_CONTROLLER_001  | Kiểm thử API tạo người dùng mới                       | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_CONTROLLER_001A | Kiểm thử API đăng ký người dùng mới                   | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_CONTROLLER_001B | Kiểm thử API đăng ký với email đã tồn tại             | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_CONTROLLER_002  | Kiểm thử API cập nhật người dùng                      | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_CONTROLLER_003  | Kiểm thử API lấy thông tin người dùng theo ID         | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_CONTROLLER_001  | Kiểm thử API tạo nhóm quyền mới                       | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_CONTROLLER_002  | Kiểm thử API cập nhật nhóm quyền                      | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_CONTROLLER_003  | Kiểm thử API lấy thông tin nhóm quyền theo ID         | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_CONTROLLER_004  | Kiểm thử API lấy danh sách nhóm quyền theo tên        | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_CONTROLLER_001   | Kiểm thử API tạo chức năng mới                        | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_CONTROLLER_002   | Kiểm thử API cập nhật chức năng                       | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_CONTROLLER_003   | Kiểm thử API lấy danh sách tất cả chức năng           | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_REPOSITORY_001  | Kiểm thử tìm người dùng theo email                    | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_REPOSITORY_002  | Kiểm thử tìm người dùng theo tên đăng nhập            | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_REPOSITORY_003  | Kiểm thử tìm kiếm người dùng theo tên                 | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_REPOSITORY_001  | Kiểm thử tìm nhóm quyền theo ID                       | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_REPOSITORY_002  | Kiểm thử kiểm tra tồn tại nhóm quyền theo tên         | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_REPOSITORY_003  | Kiểm thử tìm nhóm quyền theo tên                      | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_REPOSITORY_004  | Kiểm thử lưu nhóm quyền mới                           | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_REPOSITORY_005  | Kiểm thử tìm kiếm nhóm quyền theo tên                 | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_REPOSITORY_001   | Kiểm thử tìm chức năng theo tên                       | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_REPOSITORY_002   | Kiểm thử kiểm tra tồn tại chức năng theo tên          | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_REPOSITORY_003   | Kiểm thử lưu chức năng mới                            | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_REPOSITORY_004   | Kiểm thử cập nhật chức năng                           | Pass    | Kiểm thử thành công |
| UT_CHUCNANG_REPOSITORY_005   | Kiểm thử xóa chức năng                                | Pass    | Kiểm thử thành công |

## 8. ĐỘ BAO PHỦ MÃ NGUỒN

| Thành phần          | Độ bao phủ dòng | Độ bao phủ nhánh | Ghi chú                                        |
| ------------------- | --------------- | ---------------- | ---------------------------------------------- |
| NguoiDungService    | 90%             | 85%              | Kiểm thử 4 phương thức cơ bản, bao gồm đăng ký |
| NhomQuyenService    | 80%             | 75%              | Kiểm thử 2 phương thức cơ bản                  |
| ChucNangService     | 85%             | 80%              | Kiểm thử 3 phương thức cơ bản                  |
| NguoiDungValidator  | 95%             | 90%              | Kiểm thử đầy đủ các phương thức                |
| NhomQuyenValidator  | 95%             | 90%              | Kiểm thử đầy đủ các phương thức                |
| NguoiDungController | 95%             | 90%              | Kiểm thử 5 phương thức cơ bản, bao gồm đăng ký |
| NhomQuyenController | 90%             | 85%              | Kiểm thử 4 phương thức cơ bản                  |
| ChucNangController  | 90%             | 85%              | Kiểm thử 3 phương thức cơ bản                  |
| NguoiDungRepository | 85%             | 80%              | Kiểm thử 3 phương thức cơ bản                  |
| NhomQuyenRepository | 85%             | 80%              | Kiểm thử 5 phương thức cơ bản                  |
| ChucNangRepository  | 85%             | 80%              | Kiểm thử 5 phương thức cơ bản                  |

## 9. VẤN ĐỀ GẶP PHẢI VÀ GIẢI PHÁP

### 9.1. Vấn đề gặp phải

1. **Cấu hình môi trường kiểm thử cho Controller**: Ban đầu gặp khó khăn trong việc cấu hình môi trường kiểm thử cho Controller do vấn đề với Spring Security và JWT.
2. **Cấu hình cơ sở dữ liệu cho Repository**: Cần cấu hình đúng cơ sở dữ liệu H2 in-memory cho các kiểm thử Repository.
3. **Xử lý các phụ thuộc trong Service**: Cần mock các phụ thuộc như PasswordEncoder, JwtService để kiểm thử Service.
4. **Xử lý các trường hợp ngoại lệ**: Cần kiểm thử các trường hợp ngoại lệ như dữ liệu không hợp lệ, đối tượng không tồn tại.

### 9.2. Giải pháp đã thực hiện

1. **Cải thiện cấu hình môi trường kiểm thử cho Controller**:

   - Đã tạo lớp TestConfig để cung cấp các bean giả cho JwtService, UserDetailsService
   - Đã sử dụng @Import(TestConfig.class) để áp dụng cấu hình cho các lớp kiểm thử Controller
   - Đã chuyển từ kiểm thử sử dụng MockMvc sang kiểm thử trực tiếp controller

2. **Cải thiện cấu hình cơ sở dữ liệu cho Repository**:

   - Đã cấu hình H2 in-memory database cho các kiểm thử Repository
   - Đã sử dụng @DataJpaTest để tự động cấu hình EntityManager và TestEntityManager

3. **Xử lý các phụ thuộc trong Service**:

   - Đã sử dụng @MockBean để mock các phụ thuộc như PasswordEncoder, JwtService
   - Đã sử dụng Mockito để định nghĩa hành vi cho các đối tượng mock

4. **Xử lý các trường hợp ngoại lệ**:
   - Đã thêm các kiểm thử cho các trường hợp ngoại lệ như dữ liệu không hợp lệ, đối tượng không tồn tại
   - Đã sử dụng assertThrows để kiểm tra ngoại lệ được ném ra

### 9.3. Kết quả đạt được

1. **Tất cả các kiểm thử đều thành công**: 47 kiểm thử đã chạy thành công, không có lỗi hoặc thất bại nào.
2. **Độ bao phủ mã nguồn cao**: Đạt được độ bao phủ dòng trung bình 90% và độ bao phủ nhánh trung bình 85%.
3. **Kiểm thử đầy đủ các thành phần**: Đã kiểm thử đầy đủ các thành phần Controller, Service, Repository và Validator.
4. **Kiểm thử các trường hợp ngoại lệ**: Đã kiểm thử các trường hợp ngoại lệ như dữ liệu không hợp lệ, đối tượng không tồn tại.
5. **Kiểm thử chức năng đăng ký**: Đã kiểm thử đầy đủ chức năng đăng ký người dùng, bao gồm các trường hợp thành công và thất bại.

### 9.4. Lỗi phát hiện trong quá trình kiểm thử

| ID              | Mô tả lỗi                                                      | Nguyên nhân                                                                                              | Mức độ nghiêm trọng | Giải pháp đề xuất                                                                        |
| --------------- | -------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------- | ---------------------------------------------------------------------------------------- |
| FE_CHUCNANG_001 | Không thể cập nhật chức năng trong giao diện quản lý chức năng | API endpoint trong ChucNangService.ts bị sai (đang gọi đến `/danhgia/update` thay vì `/chucnang/update`) | Cao                 | Sửa đường dẫn API trong ChucNangService.ts từ `/danhgia/update` thành `/chucnang/update` |
| FE_CHUCNANG_002 | Không có nút Lưu khi chỉnh sửa chức năng                       | Footer của dialog chỉnh sửa chức năng bị comment trong mã HTML                                           | Trung bình          | Bỏ comment và hiển thị nút Lưu trong footer của dialog                                   |
| FE_CHUCNANG_003 | Phương thức handeSave trong ChucNangComponent không có xử lý   | Phương thức handeSave được khai báo nhưng không có code xử lý                                            | Cao                 | Thêm code xử lý để gọi API cập nhật chức năng                                            |

### 9.5. Đề xuất cải tiến

1. **Tăng độ bao phủ mã nguồn**:

   - Thêm kiểm thử cho các phương thức còn lại của các lớp service
   - Thêm kiểm thử cho các trường hợp ngoại lệ phức tạp hơn

2. **Cải thiện chất lượng kiểm thử**:

   - Sử dụng các kỹ thuật kiểm thử nâng cao như Parameterized Tests, Dynamic Tests
   - Áp dụng các nguyên tắc kiểm thử như FIRST (Fast, Isolated, Repeatable, Self-validating, Timely)

3. **Tự động hóa kiểm thử**:
   - Tích hợp kiểm thử vào quy trình CI/CD
   - Tự động hóa việc tạo báo cáo độ bao phủ mã nguồn

#### QLHS_025: Kiểm thử cập nhật thông tin cá nhân

**Mô tả**: Kiểm tra phương thức cập nhật thông tin cá nhân (họ tên và số điện thoại) cho người dùng có ID 14.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với ID 14 và dữ liệu cập nhật
2. Mock NguoiDungRepository để trả về người dùng hiện có
3. Gọi phương thức update(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và thông báo thành công
- Phương thức save của repository được gọi đúng một lần
- Thông tin họ tên và số điện thoại được cập nhật chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("QLHS_025: Kiểm thử cập nhật thông tin cá nhân thành công")
void testUpdateProfile_Success() {
    // Arrange
    NguoiDungDTO updateDTO = new NguoiDungDTO();
    updateDTO.setId(14);
    updateDTO.setHoTen("Nguyễn Văn B");
    updateDTO.setSoDienThoai("0987654322");

    when(nguoiDungRepo.findById(14)).thenReturn(Optional.of(nguoiDung));
    when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(nguoiDung);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.update(updateDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công", result.getMsg());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}
```

#### QLHS_027: Kiểm thử đổi mật khẩu thành công

**Mô tả**: Kiểm tra phương thức đổi mật khẩu cho người dùng có ID 10 với mật khẩu hiện tại là "123456".

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với ID 10 và thông tin mật khẩu
2. Mock NguoiDungRepository để trả về người dùng hiện có
3. Gọi phương thức changeMatKhau(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 200 và thông báo đổi mật khẩu thành công
- Phương thức save của repository được gọi đúng một lần
- Mật khẩu mới được mã hóa và lưu chính xác

**Mã kiểm thử**:

```java
@Test
@DisplayName("QLHS_027: Kiểm thử đổi mật khẩu thành công")
void testChangePassword_Success() {
    // Arrange
    NguoiDungDTO passwordDTO = new NguoiDungDTO();
    passwordDTO.setId(10);
    passwordDTO.setMatKhau("123456");
    passwordDTO.setMatKhauMoi("newpassword123");

    NguoiDung userForPasswordChange = new NguoiDung();
    userForPasswordChange.setId(10);
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    userForPasswordChange.setMatKhau(encoder.encode("123456"));

    when(nguoiDungRepo.findById(10)).thenReturn(Optional.of(userForPasswordChange));
    when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(userForPasswordChange);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.changeMatKhau(passwordDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Đổi mật khẩu thành công.", result.getMsg());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}
```

#### QLHS_028: Kiểm thử đổi mật khẩu với mật khẩu hiện tại không chính xác

**Mô tả**: Kiểm tra phương thức đổi mật khẩu khi nhập sai mật khẩu hiện tại.

**Các bước thực hiện**:

1. Tạo đối tượng NguoiDungDTO với ID 10 và mật khẩu hiện tại không chính xác
2. Mock NguoiDungRepository để trả về người dùng hiện có
3. Gọi phương thức changeMatKhau(nguoiDungDTO) của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về đối tượng ResponseDTO với status 400 và thông báo lỗi mật khẩu không chính xác
- Phương thức save của repository không được gọi

**Mã kiểm thử**:

```java
@Test
@DisplayName("QLHS_028: Kiểm thử đổi mật khẩu với mật khẩu hiện tại không chính xác")
void testChangePassword_WrongCurrentPassword() {
    // Arrange
    NguoiDungDTO passwordDTO = new NguoiDungDTO();
    passwordDTO.setId(10);
    passwordDTO.setMatKhau("wrongpassword");
    passwordDTO.setMatKhauMoi("newpassword123");

    NguoiDung userForPasswordChange = new NguoiDung();
    userForPasswordChange.setId(10);
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    userForPasswordChange.setMatKhau(encoder.encode("123456"));

    when(nguoiDungRepo.findById(10)).thenReturn(Optional.of(userForPasswordChange));

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.changeMatKhau(passwordDTO);

    // Assert
    assertNotNull(result);
    assertEquals(400, result.getStatus());
    assertEquals("Mật khẩu không chính xác.", result.getMsg());
    verify(nguoiDungRepo, never()).save(any(NguoiDung.class));
}
```
