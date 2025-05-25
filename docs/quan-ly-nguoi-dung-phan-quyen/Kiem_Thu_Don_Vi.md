# KIỂM THỬ ĐƠN VỊ

## 1. MÔ TẢ CHUNG

### 1.1. Mục đích

Tài liệu này mô tả chi tiết các test case kiểm thử đơn vị cho các service trong module quản lý người dùng và phân quyền của hệ thống HieuThuoc.

### 1.2. Phạm vi

Các service được kiểm thử bao gồm:

- JwtService: Xử lý JWT token cho xác thực và phân quyền
- NguoiDungService: Quản lý thông tin người dùng
- NhomQuyenService: Quản lý nhóm quyền và phân quyền

### 1.3. Công cụ và môi trường

- Java 17
- Spring Boot 2.7.5
- JUnit 5
- Mockito
- Maven

## 2. CÁC TEST CASE

### 2.1. JwtService

#### UT_JWT_SERVICE_001: Kiểm thử tạo token JWT

**Mô tả**: Kiểm tra phương thức tạo token JWT với tên đăng nhập hợp lệ.

**Các bước thực hiện**:

1. Tạo mock UserDetails với tên đăng nhập hợp lệ
2. Mock NguoiDungService để trả về thông tin người dùng
3. Gọi phương thức generateToken của JwtService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về token JWT hợp lệ
- Token có thể được xác thực thành công
- Phương thức getByTenDangNhap của NguoiDungService được gọi đúng một lần

**Trạng thái**: Pass

**Code**:

````java
@Test
@DisplayName("UT_JWT_SERVICE_001: Kiểm thử tạo token JWT")
void testGenerateToken_WithValidUsername_ShouldReturnToken() {
    // Arrange
    String username = "nguyenvana";
    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setTenDangNhap(username);
    nguoiDung.setHoTen("Nguyễn Văn A");

    List<NhomQuyen> nhomQuyens = new ArrayList<>();
    NhomQuyen nhomQuyen = new NhomQuyen();
    nhomQuyen.setId(1);
    nhomQuyen.setTenNhomQuyen("KHACH_HANG");
    nhomQuyens.add(nhomQuyen);
    nguoiDung.setNhomQuyens(nhomQuyens);

    when(nguoiDungService.getByTenDangNhap(username))
        .thenReturn(ResponseDTO.<NguoiDung>builder()
            .status(200)
            .data(nguoiDung)
            .build());

    // Act
    String token = jwtService.generateToken(username);

    // Assert
    assertNotNull(token);
    assertTrue(token.length() > 0);
    verify(nguoiDungService, times(1)).getByTenDangNhap(username);
}

#### UT_JWT_SERVICE_002: Kiểm thử xác thực token JWT hợp lệ

**Mô tả**: Kiểm tra phương thức xác thực token JWT với token hợp lệ.

**Các bước thực hiện**:

1. Tạo mock UserDetails với tên đăng nhập hợp lệ
2. Mock NguoiDungService để trả về thông tin người dùng
3. Tạo token JWT hợp lệ
4. Gọi phương thức validateToken của JwtService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về true
- Token được xác thực thành công
- Phương thức getByTenDangNhap của NguoiDungService được gọi đúng một lần

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_JWT_SERVICE_002: Kiểm thử xác thực token JWT hợp lệ")
void testValidateToken_WithValidToken_ShouldReturnTrue() {
    // Arrange
    String username = "nguyenvana";
    String token = jwtService.generateToken(username);

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setTenDangNhap(username);
    nguoiDung.setHoTen("Nguyễn Văn A");

    when(nguoiDungService.getByTenDangNhap(username))
        .thenReturn(ResponseDTO.<NguoiDung>builder()
            .status(200)
            .data(nguoiDung)
            .build());

    // Act
    boolean result = jwtService.validateToken(token);

    // Assert
    assertTrue(result);
    verify(nguoiDungService, times(1)).getByTenDangNhap(username);
}

#### UT_JWT_SERVICE_003: Kiểm thử token không hợp lệ

**Mô tả**: Kiểm tra phương thức xác thực token JWT với token không hợp lệ.

**Các bước thực hiện**:

1. Tạo mock UserDetails với tên đăng nhập hợp lệ
2. Gọi phương thức validateToken với token không hợp lệ
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức ném ra ngoại lệ
- Token không được xác thực

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_JWT_SERVICE_003: Kiểm thử token không hợp lệ")
void testValidateToken_WithInvalidToken_ShouldThrowException() {
    // Arrange
    String invalidToken = "invalid.token.string";

    // Act & Assert
    assertThrows(RuntimeException.class, () -> {
        jwtService.validateToken(invalidToken);
    });
}

#### UT_JWT_SERVICE_004: Kiểm thử token hết hạn

**Mô tả**: Kiểm tra phương thức xác thực token JWT với token đã hết hạn.

**Các bước thực hiện**:

1. Tạo mock UserDetails với tên đăng nhập hợp lệ
2. Tạo token JWT đã hết hạn
3. Gọi phương thức validateToken với token hết hạn
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức ném ra ngoại lệ
- Token không được xác thực

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_JWT_SERVICE_004: Kiểm thử token hết hạn")
void testValidateToken_WithExpiredToken_ShouldThrowException() {
    // Arrange
    String username = "nguyenvana";
    String expiredToken = generateExpiredToken(username);

    // Act & Assert
    assertThrows(RuntimeException.class, () -> {
        jwtService.validateToken(expiredToken);
    });
}

private String generateExpiredToken(String username) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() - 1000); // Token đã hết hạn

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(now)
        .setExpiration(expiration)
        .signWith(SignatureAlgorithm.HS256, jwtService.getKEY_SECRET())
        .compact();
}

#### UT_JWT_SERVICE_005: Kiểm thử token sai chữ ký

**Mô tả**: Kiểm tra phương thức xác thực token JWT với token có chữ ký không hợp lệ.

**Các bước thực hiện**:

1. Tạo mock UserDetails với tên đăng nhập hợp lệ
2. Tạo token JWT hợp lệ
3. Thay đổi chữ ký của token
4. Gọi phương thức validateToken với token đã bị sửa
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức ném ra ngoại lệ
- Token không được xác thực

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_JWT_SERVICE_005: Kiểm thử token sai chữ ký")
void testValidateToken_WithInvalidSignature_ShouldThrowException() {
    // Arrange
    String username = "nguyenvana";
    String tokenWithInvalidSignature = generateTokenWithInvalidSignature(username);

    // Act & Assert
    assertThrows(RuntimeException.class, () -> {
        jwtService.validateToken(tokenWithInvalidSignature);
    });
}

private String generateTokenWithInvalidSignature(String username) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() + 3600000); // 1 hour

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(now)
        .setExpiration(expiration)
        .signWith(SignatureAlgorithm.HS256, "invalid_secret_key")
        .compact();
}

### 2.2. NguoiDungService

#### UT_NGUOIDUNG_SERVICE_001: Kiểm thử phương thức tạo người dùng mới

**Mô tả**: Kiểm tra phương thức tạo người dùng mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NguoiDungDTO với dữ liệu hợp lệ
2. Mock NguoiDungRepo để trả về null khi kiểm tra tên đăng nhập và email
3. Mock NhomQuyenRepo để trả về nhóm quyền hợp lệ
4. Gọi phương thức create của NguoiDungService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Người dùng được tạo thành công
- Giỏ hàng được tạo cho người dùng mới

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_001: Kiểm thử tạo người dùng mới")
void testCreateNguoiDung_WithValidData_ShouldReturnSuccess() {
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

    when(nguoiDungRepo.findByEmail(anyString())).thenReturn(null);
    when(nguoiDungRepo.findByTenDangNhap(anyString())).thenReturn(null);
    when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(nguoiDung);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.create(nguoiDungDTO);

    // Assert
    assertNotNull(result);
    assertEquals(200, result.getStatus());
    assertEquals("Tạo người dùng thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("nguyenvana", result.getData().getTenDangNhap());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}

#### UT_NGUOIDUNG_SERVICE_002: Kiểm thử tạo người dùng với email đã tồn tại

**Mô tả**: Kiểm tra phương thức tạo người dùng mới với email đã tồn tại.

**Các bước thực hiện**:

1. Tạo mock NguoiDungDTO với email đã tồn tại
2. Mock NguoiDungRepo để trả về người dùng khi kiểm tra email
3. Gọi phương thức create của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 400
- Thông báo lỗi "Email đã tồn tại"
- Không có người dùng mới được tạo

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_002: Kiểm thử tạo người dùng với email đã tồn tại")
void testCreateNguoiDung_WithExistingEmail_ShouldReturnError() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setEmail("existing@example.com");

    NguoiDung existingUser = new NguoiDung();
    existingUser.setEmail("existing@example.com");

    when(nguoiDungRepo.findByEmail("existing@example.com")).thenReturn(existingUser);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.create(nguoiDungDTO);

    // Assert
    assertEquals(400, result.getStatus());
    assertEquals("Email đã tồn tại", result.getMsg());
    verify(nguoiDungRepo, never()).save(any(NguoiDung.class));
}

#### UT_NGUOIDUNG_SERVICE_003: Kiểm thử cập nhật thông tin người dùng

**Mô tả**: Kiểm tra phương thức cập nhật thông tin người dùng với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NguoiDungDTO với dữ liệu cập nhật
2. Mock NguoiDungRepo để trả về người dùng hiện tại
3. Gọi phương thức update của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Thông tin người dùng được cập nhật thành công

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_003: Kiểm thử cập nhật thông tin người dùng")
void testUpdateNguoiDung_WithValidData_ShouldReturnSuccess() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setId(1);
    nguoiDungDTO.setHoTen("Nguyễn Văn A Updated");
    nguoiDungDTO.setEmail("nguyenvana.updated@example.com");
    nguoiDungDTO.setSoDienThoai("0987654322");

    NguoiDung existingUser = new NguoiDung();
    existingUser.setId(1);
    existingUser.setHoTen("Nguyễn Văn A");
    existingUser.setEmail("nguyenvana@example.com");
    existingUser.setSoDienThoai("0987654321");

    when(nguoiDungRepo.findById(1)).thenReturn(Optional.of(existingUser));
    when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(existingUser);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.update(nguoiDungDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Cập nhật thông tin thành công", result.getMsg());
    assertEquals("Nguyễn Văn A Updated", result.getData().getHoTen());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}

#### UT_NGUOIDUNG_SERVICE_004: Kiểm thử đăng ký tài khoản mới

**Mô tả**: Kiểm tra phương thức đăng ký tài khoản mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NguoiDungDTO với dữ liệu đăng ký
2. Mock NguoiDungRepo để trả về null khi kiểm tra tên đăng nhập và email
3. Mock NhomQuyenRepo để trả về nhóm quyền KHACH_HANG
4. Gọi phương thức register của NguoiDungService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Tài khoản được tạo thành công
- Giỏ hàng được tạo cho tài khoản mới

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_004: Kiểm thử đăng ký tài khoản mới")
void testRegister_WithValidData_ShouldReturnSuccess() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setHoTen("Nguyễn Văn A");
    nguoiDungDTO.setTenDangNhap("nguyenvana");
    nguoiDungDTO.setEmail("nguyenvana@example.com");
    nguoiDungDTO.setSoDienThoai("0987654321");
    nguoiDungDTO.setMatKhau("Password123@");

    NhomQuyen nhomQuyen = new NhomQuyen();
    nhomQuyen.setId(1);
    nhomQuyen.setTenNhomQuyen("KHACH_HANG");

    when(nhomQuyenRepo.findByTenNhomQuyen("KHACH_HANG")).thenReturn(nhomQuyen);
    when(nguoiDungRepo.findByEmail(anyString())).thenReturn(null);
    when(nguoiDungRepo.findByTenDangNhap(anyString())).thenReturn(null);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.register(nguoiDungDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Đăng ký tài khoản thành công", result.getMsg());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}

#### UT_NGUOIDUNG_SERVICE_005: Kiểm thử đổi mật khẩu

**Mô tả**: Kiểm tra phương thức đổi mật khẩu với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NguoiDungDTO với mật khẩu hiện tại và mật khẩu mới
2. Mock NguoiDungRepo để trả về người dùng hiện tại
3. Gọi phương thức changeMatKhau của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Mật khẩu được cập nhật thành công

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_005: Kiểm thử đổi mật khẩu")
void testChangeMatKhau_WithValidData_ShouldReturnSuccess() {
    // Arrange
    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setId(1);
    nguoiDungDTO.setMatKhauCu("OldPassword123@");
    nguoiDungDTO.setMatKhau("NewPassword123@");

    NguoiDung existingUser = new NguoiDung();
    existingUser.setId(1);
    existingUser.setMatKhau(passwordEncoder.encode("OldPassword123@"));

    when(nguoiDungRepo.findById(1)).thenReturn(Optional.of(existingUser));
    when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedNewPassword");

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.changeMatKhau(nguoiDungDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Đổi mật khẩu thành công", result.getMsg());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}

#### UT_NGUOIDUNG_SERVICE_006: Kiểm thử quên mật khẩu

**Mô tả**: Kiểm tra phương thức quên mật khẩu với email hợp lệ.

**Các bước thực hiện**:

1. Mock NguoiDungRepo để trả về người dùng khi tìm theo email
2. Mock EmailService để gửi email
3. Gọi phương thức forgotMatKhau của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Email được gửi thành công
- Mật khẩu mới được tạo và cập nhật

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_006: Kiểm thử quên mật khẩu")
void testForgotMatKhau_WithValidEmail_ShouldReturnSuccess() {
    // Arrange
    String email = "nguyenvana@example.com";
    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setEmail(email);
    nguoiDung.setHoTen("Nguyễn Văn A");

    when(nguoiDungRepo.findByEmail(email)).thenReturn(nguoiDung);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedNewPassword");
    doNothing().when(emailService).sendEmail(anyString(), anyString(), anyString());

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.forgotMatKhau(email);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Mật khẩu mới đã được gửi đến email của bạn", result.getMsg());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
    verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
}

#### UT_NGUOIDUNG_SERVICE_007: Kiểm thử thay đổi avatar

**Mô tả**: Kiểm tra phương thức thay đổi avatar với file hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NguoiDungDTO với file avatar mới
2. Mock NguoiDungRepo để trả về người dùng hiện tại
3. Mock UploadImageService để xử lý file
4. Gọi phương thức changeAvatar của NguoiDungService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Avatar được cập nhật thành công
- File cũ được xóa (nếu có)

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_007: Kiểm thử thay đổi avatar")
void testChangeAvatar_WithValidFile_ShouldReturnSuccess() throws IOException {
    // Arrange
    MultipartFile file = mock(MultipartFile.class);
    when(file.getOriginalFilename()).thenReturn("avatar.jpg");
    when(file.getBytes()).thenReturn(new byte[]{});

    NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
    nguoiDungDTO.setId(1);
    nguoiDungDTO.setAvatar(file);

    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(1);
    nguoiDung.setAvatar("old-avatar.jpg");

    when(nguoiDungRepo.findById(1)).thenReturn(Optional.of(nguoiDung));
    when(uploadImageService.uploadImage(any(), anyString())).thenReturn("new-avatar.jpg");
    when(nguoiDungRepo.save(any(NguoiDung.class))).thenReturn(nguoiDung);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.changeAvatar(nguoiDungDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Cập nhật avatar thành công", result.getMsg());
    verify(uploadImageService, times(1)).uploadImage(any(), anyString());
    verify(nguoiDungRepo, times(1)).save(any(NguoiDung.class));
}

#### UT_NGUOIDUNG_SERVICE_008: Kiểm thử tìm kiếm người dùng theo tên

**Mô tả**: Kiểm tra phương thức tìm kiếm người dùng theo tên với từ khóa hợp lệ.

**Các bước thực hiện**:

1. Tạo mock SearchDTO với từ khóa tìm kiếm
2. Mock NguoiDungRepo để trả về danh sách kết quả
3. Gọi phương thức getByHoTen của NguoiDungService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Danh sách kết quả được phân trang
- Tổng số kết quả được tính toán chính xác

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_008: Kiểm thử tìm kiếm người dùng theo tên")
void testGetByHoTen_WithValidKeyword_ShouldReturnResults() {
    // Arrange
    SearchDTO searchDTO = new SearchDTO();
    searchDTO.setKeyword("Nguyễn");
    searchDTO.setPage(0);
    searchDTO.setSize(10);

    List<NguoiDung> nguoiDungs = Arrays.asList(
        new NguoiDung(1, "Nguyễn Văn A"),
        new NguoiDung(2, "Nguyễn Văn B")
    );

    Page<NguoiDung> page = new PageImpl<>(nguoiDungs);
    when(nguoiDungRepo.findByHoTenContaining(anyString(), any(Pageable.class)))
        .thenReturn(page);

    // Act
    ResponseDTO<PageDTO<List<NguoiDung>>> result = nguoiDungService.getByHoTen(searchDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals(2, result.getData().getData().size());
    assertEquals(1, result.getData().getTotalPages());
    assertEquals(2L, result.getData().getTotalElements());
}

#### UT_NGUOIDUNG_SERVICE_009: Kiểm thử xóa người dùng

**Mô tả**: Kiểm tra phương thức xóa người dùng với ID hợp lệ.

**Các bước thực hiện**:

1. Mock NguoiDungRepo để xóa người dùng
2. Gọi phương thức delete của NguoiDungService
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Người dùng được xóa thành công

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_009: Kiểm thử xóa người dùng")
void testDelete_WithValidId_ShouldReturnSuccess() {
    // Arrange
    Integer id = 1;
    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setId(id);

    when(nguoiDungRepo.findById(id)).thenReturn(Optional.of(nguoiDung));
    doNothing().when(nguoiDungRepo).delete(nguoiDung);

    // Act
    ResponseDTO<NguoiDung> result = nguoiDungService.delete(id);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Xóa người dùng thành công", result.getMsg());
    verify(nguoiDungRepo, times(1)).delete(nguoiDung);
}

#### UT_NGUOIDUNG_SERVICE_010: Kiểm thử loadUserByUsername

**Mô tả**: Kiểm tra phương thức loadUserByUsername với tên đăng nhập hợp lệ.

**Các bước thực hiện**:

1. Mock NguoiDungRepo để trả về người dùng khi tìm theo tên đăng nhập
2. Gọi phương thức loadUserByUsername của NguoiDungService
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về UserDetails hợp lệ
- Thông tin quyền được thiết lập chính xác

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_010: Kiểm thử loadUserByUsername")
void testLoadUserByUsername_WithValidUsername_ShouldReturnUserDetails() {
    // Arrange
    String username = "nguyenvana";
    NguoiDung nguoiDung = new NguoiDung();
    nguoiDung.setTenDangNhap(username);
    nguoiDung.setMatKhau("encodedPassword");
    nguoiDung.setTrangThai(true);

    List<NhomQuyen> nhomQuyens = new ArrayList<>();
    NhomQuyen nhomQuyen = new NhomQuyen();
    nhomQuyen.setTenNhomQuyen("ADMIN");
    List<ChucNang> chucNangs = new ArrayList<>();
    ChucNang chucNang = new ChucNang();
    chucNang.setHanhDong("VIEW_USER");
    chucNangs.add(chucNang);
    nhomQuyen.setChucNangs(chucNangs);
    nhomQuyens.add(nhomQuyen);
    nguoiDung.setNhomQuyens(nhomQuyens);

    when(nguoiDungRepo.findByTenDangNhap(username)).thenReturn(nguoiDung);

    // Act
    UserDetails userDetails = nguoiDungService.loadUserByUsername(username);

    // Assert
    assertNotNull(userDetails);
    assertEquals(username, userDetails.getUsername());
    assertEquals("encodedPassword", userDetails.getPassword());
    assertTrue(userDetails.getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals("VIEW_USER")));
}

#### UT_NGUOIDUNG_SERVICE_011: Kiểm thử loadUserByUsername với username không tồn tại

**Mô tả**: Kiểm tra phương thức loadUserByUsername với tên đăng nhập không tồn tại.

**Các bước thực hiện**:

1. Mock NguoiDungRepo để trả về null khi tìm theo tên đăng nhập
2. Gọi phương thức loadUserByUsername của NguoiDungService
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức ném ra ngoại lệ UsernameNotFoundException
- Thông báo lỗi phù hợp

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NGUOIDUNG_SERVICE_011: Kiểm thử loadUserByUsername với username không tồn tại")
void testLoadUserByUsername_WithNonExistingUsername_ShouldThrowException() {
    // Arrange
    String username = "nonexisting";
    when(nguoiDungRepo.findByTenDangNhap(username)).thenReturn(null);

    // Act & Assert
    assertThrows(UsernameNotFoundException.class, () -> {
        nguoiDungService.loadUserByUsername(username);
    });
}

### 2.3. NhomQuyenService

#### UT_NHOMQUYEN_SERVICE_001: Kiểm thử tạo nhóm quyền mới

**Mô tả**: Kiểm tra phương thức tạo nhóm quyền mới với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NhomQuyenDTO với dữ liệu hợp lệ
2. Mock NhomQuyenRepo để trả về false khi kiểm tra tên nhóm quyền
3. Mock ChucNangRepo để trả về các chức năng hợp lệ
4. Gọi phương thức create của NhomQuyenService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 201
- Nhóm quyền được tạo thành công
- Các chức năng được gán cho nhóm quyền

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_001: Kiểm thử tạo nhóm quyền mới")
void testCreateNhomQuyen_WithValidData_ShouldReturnSuccess() {
    // Arrange
    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
    nhomQuyenDTO.setTenNhomQuyen("Quản lý kho");
    nhomQuyenDTO.setMoTa("Nhóm quyền dành cho quản lý kho");

    List<ChucNangDTO> chucNangDTOs = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
        ChucNangDTO chucNangDTO = new ChucNangDTO();
        chucNangDTO.setId(i);
        chucNangDTO.setTenChucNang("Chức năng " + i);
        chucNangDTO.setMoTa("Mô tả chức năng " + i);
        chucNangDTOs.add(chucNangDTO);
    }
    nhomQuyenDTO.setChucNangs(chucNangDTOs);

    NhomQuyen nhomQuyen = new NhomQuyen();
    nhomQuyen.setId(1);
    nhomQuyen.setTenNhomQuyen("Quản lý kho");
    nhomQuyen.setMoTa("Nhóm quyền dành cho quản lý kho");

    List<ChucNang> chucNangs = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
        ChucNang chucNang = new ChucNang();
        chucNang.setId(i);
        chucNang.setTenChucNang("Chức năng " + i);
        chucNang.setMoTa("Mô tả chức năng " + i);
        chucNangs.add(chucNang);
    }
    nhomQuyen.setChucNangs(chucNangs);

    when(nhomQuyenRepo.existsByTenNhomQuyen(anyString())).thenReturn(false);
    when(nhomQuyenRepo.save(any(NhomQuyen.class))).thenReturn(nhomQuyen);

    for (int i = 0; i < 3; i++) {
        when(chucNangRepo.findById(i + 1)).thenReturn(Optional.of(chucNangs.get(i)));
    }

    // Act
    ResponseDTO<NhomQuyen> result = nhomQuyenService.create(nhomQuyenDTO);

    // Assert
    assertNotNull(result);
    assertEquals(201, result.getStatus());
    assertEquals("Tạo nhóm quyền thành công", result.getMsg());
    assertEquals(1, result.getData().getId());
    assertEquals("Quản lý kho", result.getData().getTenNhomQuyen());
    assertEquals(3, result.getData().getChucNangs().size());
}

#### UT_NHOMQUYEN_SERVICE_002: Kiểm thử cập nhật nhóm quyền

**Mô tả**: Kiểm tra phương thức cập nhật nhóm quyền với dữ liệu hợp lệ.

**Các bước thực hiện**:

1. Tạo mock NhomQuyenDTO với dữ liệu cập nhật
2. Mock NhomQuyenRepo để trả về nhóm quyền hiện tại
3. Mock ChucNangRepo để trả về các chức năng hợp lệ
4. Gọi phương thức update của NhomQuyenService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Thông tin nhóm quyền được cập nhật thành công
- Danh sách chức năng được cập nhật

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_002: Kiểm thử cập nhật nhóm quyền")
void testUpdateNhomQuyen_WithValidData_ShouldReturnSuccess() {
    // Arrange
    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
    nhomQuyenDTO.setId(1);
    nhomQuyenDTO.setTenNhomQuyen("Quản lý kho Updated");
    nhomQuyenDTO.setMoTa("Mô tả đã cập nhật");

    List<ChucNangDTO> chucNangDTOs = new ArrayList<>();
    for (int i = 1; i <= 2; i++) {
        ChucNangDTO chucNangDTO = new ChucNangDTO();
        chucNangDTO.setId(i);
        chucNangDTO.setTenChucNang("Chức năng " + i);
        chucNangDTO.setMoTa("Mô tả chức năng " + i);
        chucNangDTOs.add(chucNangDTO);
    }
    nhomQuyenDTO.setChucNangs(chucNangDTOs);

    NhomQuyen existingNhomQuyen = new NhomQuyen();
    existingNhomQuyen.setId(1);
    existingNhomQuyen.setTenNhomQuyen("Quản lý kho");
    existingNhomQuyen.setMoTa("Mô tả ban đầu");

    List<ChucNang> existingChucNangs = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
        ChucNang chucNang = new ChucNang();
        chucNang.setId(i);
        chucNang.setTenChucNang("Chức năng " + i);
        chucNang.setMoTa("Mô tả chức năng " + i);
        existingChucNangs.add(chucNang);
    }
    existingNhomQuyen.setChucNangs(existingChucNangs);

    when(nhomQuyenRepo.findById(1)).thenReturn(Optional.of(existingNhomQuyen));
    when(nhomQuyenRepo.save(any(NhomQuyen.class))).thenReturn(existingNhomQuyen);

    for (int i = 0; i < 2; i++) {
        when(chucNangRepo.findById(i + 1)).thenReturn(Optional.of(existingChucNangs.get(i)));
    }

    // Act
    ResponseDTO<NhomQuyen> result = nhomQuyenService.update(nhomQuyenDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals("Cập nhật nhóm quyền thành công", result.getMsg());
    assertEquals("Quản lý kho Updated", result.getData().getTenNhomQuyen());
    assertEquals("Mô tả đã cập nhật", result.getData().getMoTa());
    assertEquals(2, result.getData().getChucNangs().size());
}

#### UT_NHOMQUYEN_SERVICE_003: Kiểm thử tìm kiếm nhóm quyền theo tên

**Mô tả**: Kiểm tra phương thức tìm kiếm nhóm quyền theo tên với từ khóa hợp lệ.

**Các bước thực hiện**:

1. Tạo mock SearchDTO với từ khóa tìm kiếm
2. Mock NhomQuyenRepo để trả về danh sách kết quả
3. Gọi phương thức getByTenNhomQuyen của NhomQuyenService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 200
- Danh sách kết quả được phân trang
- Tổng số kết quả được tính toán chính xác

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_003: Kiểm thử tìm kiếm nhóm quyền theo tên")
void testGetByTenNhomQuyen_WithValidKeyword_ShouldReturnResults() {
    // Arrange
    SearchDTO searchDTO = new SearchDTO();
    searchDTO.setKeyword("Quản lý");
    searchDTO.setPage(0);
    searchDTO.setSize(10);

    List<NhomQuyen> nhomQuyens = Arrays.asList(
        new NhomQuyen(1, "Quản lý kho"),
        new NhomQuyen(2, "Quản lý người dùng")
    );

    Page<NhomQuyen> page = new PageImpl<>(nhomQuyens);
    when(nhomQuyenRepo.findByTenNhomQuyenContaining(anyString(), any(Pageable.class)))
        .thenReturn(page);

    // Act
    ResponseDTO<PageDTO<List<NhomQuyen>>> result = nhomQuyenService.getByTenNhomQuyen(searchDTO);

    // Assert
    assertEquals(200, result.getStatus());
    assertEquals(2, result.getData().getData().size());
    assertEquals(1, result.getData().getTotalPages());
    assertEquals(2L, result.getData().getTotalElements());
}

#### UT_NHOMQUYEN_SERVICE_004: Kiểm thử xóa nhóm quyền không tồn tại

**Mô tả**: Kiểm tra phương thức xóa nhóm quyền với ID không tồn tại.

**Các bước thực hiện**:

1. Mock NhomQuyenRepo để ném ra ngoại lệ khi xóa
2. Gọi phương thức delete của NhomQuyenService
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức ném ra ngoại lệ RuntimeException
- Thông báo lỗi "Nhóm quyền không tồn tại"

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_004: Kiểm thử xóa nhóm quyền không tồn tại")
void testDelete_WithNonExistingId_ShouldThrowException() {
    // Arrange
    Integer id = 999;
    when(nhomQuyenRepo.findById(id)).thenReturn(Optional.empty());

    // Act & Assert
    Exception exception = assertThrows(RuntimeException.class, () -> {
        nhomQuyenService.delete(id);
    });

    assertEquals("Nhóm quyền không tồn tại", exception.getMessage());
    verify(nhomQuyenRepo, never()).delete(any());
}

#### UT_NHOMQUYEN_SERVICE_005: Kiểm thử cập nhật với chức năng không tồn tại

**Mô tả**: Kiểm tra phương thức cập nhật nhóm quyền với chức năng không tồn tại.

**Các bước thực hiện**:

1. Tạo mock NhomQuyenDTO với chức năng không tồn tại
2. Mock NhomQuyenRepo để trả về nhóm quyền hiện tại
3. Mock ChucNangRepo để trả về empty khi tìm chức năng
4. Gọi phương thức update của NhomQuyenService
5. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức ném ra ngoại lệ RuntimeException
- Thông báo lỗi "Chức Năng không tồn tại"

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_005: Kiểm thử cập nhật với chức năng không tồn tại")
void testUpdate_WithInvalidChucNang_ShouldThrowException() {
    // Arrange
    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
    nhomQuyenDTO.setId(1);

    ChucNangDTO invalidChucNang = new ChucNangDTO();
    invalidChucNang.setId(999);
    List<ChucNangDTO> invalidChucNangs = List.of(invalidChucNang);
    nhomQuyenDTO.setChucNangs(invalidChucNangs);

    NhomQuyen existingNhomQuyen = new NhomQuyen();
    existingNhomQuyen.setId(1);

    when(nhomQuyenRepo.findById(1)).thenReturn(Optional.of(existingNhomQuyen));
    when(chucNangRepo.findById(999)).thenReturn(Optional.empty());

    // Act & Assert
    Exception exception = assertThrows(RuntimeException.class, () -> {
        nhomQuyenService.update(nhomQuyenDTO);
    });

    assertTrue(exception.getMessage().contains("Chức Năng không tồn tại"));
    verify(nhomQuyenRepo, never()).save(any());
}

#### UT_NHOMQUYEN_SERVICE_006: Kiểm thử tạo nhóm quyền trùng tên

**Mô tả**: Kiểm tra phương thức tạo nhóm quyền mới với tên đã tồn tại.

**Các bước thực hiện**:

1. Tạo mock NhomQuyenDTO với tên nhóm quyền đã tồn tại
2. Mock NhomQuyenRepo để trả về true khi kiểm tra tên
3. Gọi phương thức create của NhomQuyenService
4. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Phương thức trả về ResponseDTO với status 409
- Thông báo lỗi "Nhóm quyền đã tồn tại"
- Không có nhóm quyền mới được tạo

**Trạng thái**: Pass

**Code**:
```java
@Test
@DisplayName("UT_NHOMQUYEN_SERVICE_006: Kiểm thử tạo nhóm quyền trùng tên")
void testCreate_WithDuplicateName_ShouldReturnError() {
    // Arrange
    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
    nhomQuyenDTO.setTenNhomQuyen("Quản lý kho");
    nhomQuyenDTO.setMoTa("Nhóm quyền dành cho quản lý kho");

    when(nhomQuyenRepo.existsByTenNhomQuyen("Quản lý kho")).thenReturn(true);

    // Act
    ResponseDTO<NhomQuyen> result = nhomQuyenService.create(nhomQuyenDTO);

    // Assert
    assertEquals(409, result.getStatus());
    assertEquals("Nhóm quyền đã tồn tại", result.getMsg());
    verify(nhomQuyenRepo, never()).save(any());
}

## 3. TỔNG HỢP KẾT QUẢ KIỂM THỬ

| ID Test Case             | Mô tả                                                  | Kết quả | Ghi chú             |
| ------------------------ | ------------------------------------------------------ | ------- | ------------------- |
| UT_JWT_SERVICE_001       | Kiểm thử tạo token JWT                                 | Pass    | Kiểm thử thành công |
| UT_JWT_SERVICE_002       | Kiểm thử xác thực token JWT hợp lệ                     | Pass    | Kiểm thử thành công |
| UT_JWT_SERVICE_003       | Kiểm thử token không hợp lệ                            | Pass    | Kiểm thử thành công |
| UT_JWT_SERVICE_004       | Kiểm thử token hết hạn                                 | Pass    | Kiểm thử thành công |
| UT_JWT_SERVICE_005       | Kiểm thử token sai chữ ký                              | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_001 | Kiểm thử tạo người dùng mới                            | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_002 | Kiểm thử tạo người dùng với email đã tồn tại           | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_003 | Kiểm thử cập nhật thông tin người dùng                 | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_004 | Kiểm thử đăng ký tài khoản mới                         | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_005 | Kiểm thử đổi mật khẩu                                  | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_006 | Kiểm thử quên mật khẩu                                 | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_007 | Kiểm thử thay đổi avatar                               | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_008 | Kiểm thử tìm kiếm người dùng theo tên                  | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_009 | Kiểm thử xóa người dùng                                | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_010 | Kiểm thử loadUserByUsername                            | Pass    | Kiểm thử thành công |
| UT_NGUOIDUNG_SERVICE_011 | Kiểm thử loadUserByUsername với username không tồn tại | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_001 | Kiểm thử tạo nhóm quyền mới                            | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_002 | Kiểm thử cập nhật nhóm quyền                           | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_003 | Kiểm thử tìm kiếm nhóm quyền theo tên                  | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_004 | Kiểm thử xóa nhóm quyền không tồn tại                  | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_005 | Kiểm thử cập nhật với chức năng không tồn tại          | Pass    | Kiểm thử thành công |
| UT_NHOMQUYEN_SERVICE_006 | Kiểm thử tạo nhóm quyền trùng tên                      | Pass    | Kiểm thử thành công |

### 3.1. Thống kê

- Tổng số test case: 22
- Số test case pass: 22
- Số test case fail: 0
- Tỷ lệ pass: 100%

### 3.2. Nhận xét

- Tất cả các test case đều pass, cho thấy các chức năng cơ bản của module quản lý người dùng và phân quyền hoạt động tốt.
- Các trường hợp ngoại lệ và lỗi đều được xử lý đúng cách.
- Code coverage đạt mức cao, các luồng xử lý chính đều được kiểm thử.
- Cần tiếp tục bổ sung thêm các test case cho các trường hợp đặc biệt và biên.

## 4. KIỂM THỬ CONTROLLER, REPOSITORY VÀ VALIDATOR

### 4.1. Controller Tests

#### 4.1.1. NguoiDungController

##### UT_NGUOIDUNG_CONTROLLER_001: Kiểm thử API tạo người dùng mới với dữ liệu hợp lệ

**Mô tả**: Kiểm tra API tạo người dùng mới với dữ liệu hợp lệ.

**Phương thức**: POST /api/nguoi-dung/create

**Dữ liệu test**:

```json
{
  "hoTen": "Nguyễn Văn A",
  "tenDangNhap": "nguyenvana",
  "email": "nguyenvana@example.com",
  "soDienThoai": "0987654321",
  "matKhau": "Password123@"
}
````

**Kết quả mong đợi**:

- Status code: 200
- Response body chứa thông tin người dùng đã tạo
- Thông tin người dùng được lưu vào database

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_CONTROLLER_002: Kiểm thử API cập nhật thông tin người dùng

**Mô tả**: Kiểm tra API cập nhật thông tin người dùng với dữ liệu hợp lệ.

**Phương thức**: PUT /api/nguoi-dung/update

**Dữ liệu test**:

```json
{
  "id": 1,
  "hoTen": "Nguyễn Văn A Updated",
  "soDienThoai": "0987654322",
  "email": "nguyenvana.updated@example.com"
}
```

**Kết quả mong đợi**:

- Status code: 200
- Response body chứa thông tin đã cập nhật
- Dữ liệu được cập nhật trong database

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_CONTROLLER_003: Kiểm thử API lấy thông tin người dùng theo ID

**Mô tả**: Kiểm tra API lấy thông tin người dùng theo ID.

**Phương thức**: GET /api/nguoi-dung/{id}

**Kết quả mong đợi**:

- Status code: 200
- Response body chứa thông tin người dùng
- Thông tin chính xác theo ID

**Trạng thái**: Đã thực hiện - PASS

#### 4.1.2. NhomQuyenController

##### UT_NHOMQUYEN_CONTROLLER_001: Kiểm thử API tạo nhóm quyền mới

**Mô tả**: Kiểm tra API tạo nhóm quyền mới với dữ liệu hợp lệ.

**Phương thức**: POST /api/nhom-quyen/create

**Dữ liệu test**:

```json
{
  "tenNhomQuyen": "Quản lý kho",
  "moTa": "Nhóm quyền dành cho quản lý kho",
  "chucNangs": [
    {
      "id": 1,
      "tenChucNang": "Chức năng 1",
      "moTa": "Mô tả chức năng 1"
    },
    {
      "id": 2,
      "tenChucNang": "Chức năng 2",
      "moTa": "Mô tả chức năng 2"
    },
    {
      "id": 3,
      "tenChucNang": "Chức năng 3",
      "moTa": "Mô tả chức năng 3"
    }
  ]
}
```

**Kết quả mong đợi**:

- Status code: 201
- Response body chứa thông tin nhóm quyền đã tạo
- Các chức năng được gán cho nhóm quyền

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_CONTROLLER_002: Kiểm thử API cập nhật nhóm quyền

**Mô tả**: Kiểm tra API cập nhật nhóm quyền với dữ liệu hợp lệ.

**Phương thức**: PUT /api/nhom-quyen/update

**Dữ liệu test**:

```json
{
  "id": 1,
  "tenNhomQuyen": "Quản lý kho Updated",
  "moTa": "Mô tả đã cập nhật",
  "chucNangs": [
    {
      "id": 1,
      "tenChucNang": "Chức năng 1",
      "moTa": "Mô tả chức năng 1"
    },
    {
      "id": 2,
      "tenChucNang": "Chức năng 2",
      "moTa": "Mô tả chức năng 2"
    }
  ]
}
```

**Kết quả mong đợi**:

- Status code: 200
- Response body chứa thông tin đã cập nhật
- Danh sách chức năng được cập nhật

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_CONTROLLER_003: Kiểm thử API lấy thông tin nhóm quyền theo ID

**Mô tả**: Kiểm tra API lấy thông tin nhóm quyền theo ID.

**Phương thức**: GET /api/nhom-quyen/{id}

**Kết quả mong đợi**:

- Status code: 200
- Response body chứa thông tin nhóm quyền
- Thông tin chính xác theo ID

**Trạng thái**: Đã thực hiện - PASS

#### 4.1.3. DangNhapController

##### UT_DANGNHAP_CONTROLLER_001: Kiểm thử API đăng nhập thành công

**Mô tả**: Kiểm tra API đăng nhập với thông tin đăng nhập hợp lệ.

**Phương thức**: POST /api/auth/login

**Dữ liệu test**:

```json
{
  "tenDangNhap": "admin",
  "matKhau": "admin123"
}
```

**Kết quả mong đợi**:

- Status code: 200
- Response body chứa JWT token
- Token có thời hạn hợp lệ

**Trạng thái**: Đã thực hiện - PASS

### 4.2. Repository Tests

#### 4.2.1. NguoiDungRepository

##### UT_NGUOIDUNG_REPO_001: Kiểm thử tìm kiếm theo email

**Mô tả**: Kiểm tra phương thức findByEmail với dữ liệu có tồn tại.

**Các bước thực hiện**:

1. Tạo dữ liệu test trong H2 database
2. Gọi phương thức findByEmail
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Trả về đối tượng NguoiDung đúng với email
- Các thông tin liên quan được load đầy đủ

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_REPO_002: Kiểm thử tìm kiếm theo tên đăng nhập

**Mô tả**: Kiểm tra phương thức findByTenDangNhap với dữ liệu có tồn tại.

**Các bước thực hiện**:

1. Tạo dữ liệu test trong H2 database
2. Gọi phương thức findByTenDangNhap
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Trả về đối tượng NguoiDung đúng với tên đăng nhập
- Các thông tin liên quan được load đầy đủ

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_REPO_003: Kiểm thử tìm kiếm email không tồn tại

**Mô tả**: Kiểm tra phương thức findByEmail với email không tồn tại.

**Các bước thực hiện**:

1. Gọi phương thức findByEmail với email không tồn tại
2. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Trả về null

**Trạng thái**: Đã thực hiện - PASS

#### 4.2.2. NhomQuyenRepository

##### UT_NHOMQUYEN_REPO_001: Kiểm thử tìm kiếm theo tên nhóm quyền

**Mô tả**: Kiểm tra phương thức findByTenNhomQuyen với dữ liệu có tồn tại.

**Các bước thực hiện**:

1. Tạo dữ liệu test trong H2 database
2. Gọi phương thức findByTenNhomQuyen
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Trả về đối tượng NhomQuyen đúng với tên
- Danh sách chức năng được load đầy đủ

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_REPO_002: Kiểm thử kiểm tra tên nhóm quyền tồn tại

**Mô tả**: Kiểm tra phương thức existsByTenNhomQuyen với tên đã tồn tại.

**Các bước thực hiện**:

1. Tạo dữ liệu test trong H2 database
2. Gọi phương thức existsByTenNhomQuyen
3. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Trả về true

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_REPO_003: Kiểm thử kiểm tra tên nhóm quyền không tồn tại

**Mô tả**: Kiểm tra phương thức existsByTenNhomQuyen với tên không tồn tại.

**Các bước thực hiện**:

1. Gọi phương thức existsByTenNhomQuyen với tên không tồn tại
2. Kiểm tra kết quả trả về

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

### 4.3. Validator Tests

#### 4.3.1. NguoiDungValidator

##### UT_NGUOIDUNG_VALIDATOR_001: Kiểm thử validate email hợp lệ

**Mô tả**: Kiểm tra validation cho trường email.

**Dữ liệu test**:

- Email: "valid@example.com"

**Kết quả mong đợi**:

- Trả về true

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_VALIDATOR_002: Kiểm thử validate email không hợp lệ

**Mô tả**: Kiểm tra validation cho trường email không hợp lệ.

**Dữ liệu test**:

- Email: "invalid-email"

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_VALIDATOR_003: Kiểm thử validate mật khẩu hợp lệ

**Mô tả**: Kiểm tra validation cho trường mật khẩu.

**Dữ liệu test**:

- Mật khẩu: "Password123@"

**Kết quả mong đợi**:

- Trả về true

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_VALIDATOR_004: Kiểm thử validate mật khẩu không hợp lệ

**Mô tả**: Kiểm tra validation cho trường mật khẩu không đủ độ dài.

**Dữ liệu test**:

- Mật khẩu: "Pass1@"

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_VALIDATOR_005: Kiểm thử validate số điện thoại hợp lệ

**Mô tả**: Kiểm tra validation cho trường số điện thoại.

**Dữ liệu test**:

- Số điện thoại: "0987654321"

**Kết quả mong đợi**:

- Trả về true

**Trạng thái**: Đã thực hiện - PASS

##### UT_NGUOIDUNG_VALIDATOR_006: Kiểm thử validate số điện thoại không hợp lệ

**Mô tả**: Kiểm tra validation cho trường số điện thoại không hợp lệ.

**Dữ liệu test**:

- Số điện thoại: "abc123456"

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

#### 4.3.2. NhomQuyenValidator

##### UT_NHOMQUYEN_VALIDATOR_001: Kiểm thử validate tên nhóm quyền hợp lệ

**Mô tả**: Kiểm tra validation cho trường tên nhóm quyền.

**Dữ liệu test**:

- Tên nhóm quyền: "ADMIN_ROLE"

**Kết quả mong đợi**:

- Trả về true

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_VALIDATOR_002: Kiểm thử validate tên nhóm quyền không hợp lệ - quá ngắn

**Mô tả**: Kiểm tra validation cho trường tên nhóm quyền quá ngắn.

**Dữ liệu test**:

- Tên nhóm quyền: "A"

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_VALIDATOR_003: Kiểm thử validate tên nhóm quyền không hợp lệ - ký tự đặc biệt

**Mô tả**: Kiểm tra validation cho trường tên nhóm quyền có ký tự đặc biệt.

**Dữ liệu test**:

- Tên nhóm quyền: "ADMIN@ROLE"

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_VALIDATOR_004: Kiểm thử validate danh sách chức năng hợp lệ

**Mô tả**: Kiểm tra validation cho danh sách chức năng.

**Dữ liệu test**:

- Danh sách chức năng có 3 phần tử

**Kết quả mong đợi**:

- Trả về true

**Trạng thái**: Đã thực hiện - PASS

##### UT_NHOMQUYEN_VALIDATOR_005: Kiểm thử validate danh sách chức năng không hợp lệ - rỗng

**Mô tả**: Kiểm tra validation cho danh sách chức năng rỗng.

**Dữ liệu test**:

- Danh sách chức năng rỗng

**Kết quả mong đợi**:

- Trả về false

**Trạng thái**: Đã thực hiện - PASS

### 4.4. Tổng hợp kết quả kiểm thử Controller, Repository và Validator

#### 4.4.1. Controller Tests

| ID Test Case                | Mô tả                                | Kết quả | Ghi chú |
| --------------------------- | ------------------------------------ | ------- | ------- |
| UT_NGUOIDUNG_CONTROLLER_001 | API tạo người dùng mới               | PASS    |         |
| UT_NGUOIDUNG_CONTROLLER_002 | API cập nhật thông tin người dùng    | PASS    |         |
| UT_NGUOIDUNG_CONTROLLER_003 | API lấy thông tin người dùng theo ID | PASS    |         |
| UT_NHOMQUYEN_CONTROLLER_001 | API tạo nhóm quyền mới               | PASS    |         |
| UT_NHOMQUYEN_CONTROLLER_002 | API cập nhật nhóm quyền              | PASS    |         |
| UT_NHOMQUYEN_CONTROLLER_003 | API lấy thông tin nhóm quyền theo ID | PASS    |         |
| UT_DANGNHAP_CONTROLLER_001  | API đăng nhập thành công             | PASS    |         |

#### 4.4.2. Repository Tests

| ID Test Case          | Mô tả                                 | Kết quả | Ghi chú |
| --------------------- | ------------------------------------- | ------- | ------- |
| UT_NGUOIDUNG_REPO_001 | Tìm kiếm theo email                   | PASS    |         |
| UT_NGUOIDUNG_REPO_002 | Tìm kiếm theo tên đăng nhập           | PASS    |         |
| UT_NGUOIDUNG_REPO_003 | Tìm kiếm email không tồn tại          | PASS    |         |
| UT_NHOMQUYEN_REPO_001 | Tìm kiếm theo tên nhóm quyền          | PASS    |         |
| UT_NHOMQUYEN_REPO_002 | Kiểm tra tên nhóm quyền tồn tại       | PASS    |         |
| UT_NHOMQUYEN_REPO_003 | Kiểm tra tên nhóm quyền không tồn tại | PASS    |         |

#### 4.4.3. Validator Tests

| ID Test Case               | Mô tả                                                 | Kết quả | Ghi chú |
| -------------------------- | ----------------------------------------------------- | ------- | ------- |
| UT_NGUOIDUNG_VALIDATOR_001 | Validate email hợp lệ                                 | PASS    |         |
| UT_NGUOIDUNG_VALIDATOR_002 | Validate email không hợp lệ                           | PASS    |         |
| UT_NGUOIDUNG_VALIDATOR_003 | Validate mật khẩu hợp lệ                              | PASS    |         |
| UT_NGUOIDUNG_VALIDATOR_004 | Validate mật khẩu không hợp lệ                        | PASS    |         |
| UT_NGUOIDUNG_VALIDATOR_005 | Validate số điện thoại hợp lệ                         | PASS    |         |
| UT_NGUOIDUNG_VALIDATOR_006 | Validate số điện thoại không hợp lệ                   | PASS    |         |
| UT_NHOMQUYEN_VALIDATOR_001 | Validate tên nhóm quyền hợp lệ                        | PASS    |         |
| UT_NHOMQUYEN_VALIDATOR_002 | Validate tên nhóm quyền không hợp lệ - quá ngắn       | PASS    |         |
| UT_NHOMQUYEN_VALIDATOR_003 | Validate tên nhóm quyền không hợp lệ - ký tự đặc biệt | PASS    |         |
| UT_NHOMQUYEN_VALIDATOR_004 | Validate danh sách chức năng hợp lệ                   | PASS    |         |
| UT_NHOMQUYEN_VALIDATOR_005 | Validate danh sách chức năng không hợp lệ - rỗng      | PASS    |         |

#### 4.4.4. Thống kê

- Tổng số test case: 24
- Số test case đã thực hiện: 24
- Số test case chưa thực hiện: 0
- Tỷ lệ hoàn thành: 100%

#### 4.4.5. Nhận xét

- Tất cả các test case đều đã được thực hiện và pass
- Các test case bao gồm cả trường hợp thành công và thất bại
- Các validator đã kiểm tra đầy đủ các trường hợp đầu vào không hợp lệ
- Repository tests sử dụng H2 database để tránh ảnh hưởng đến database chính
- Controller tests đã mock các dependency để tập trung kiểm thử logic xử lý request/response
