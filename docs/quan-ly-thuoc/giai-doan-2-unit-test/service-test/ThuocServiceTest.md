# TEST CASE CHO THUOCSERVICE

## Mô tả
File này chứa các test case cho ThuocService, bao gồm các phương thức thêm, sửa, xóa, tìm kiếm thuốc.

## Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| TS_001 | Lấy danh sách thuốc thành công | 1. Mock repository trả về danh sách thuốc<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách thuốc | Thành công | |
| TS_002 | Lấy danh sách thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| TS_003 | Tìm thuốc theo ID thành công | 1. Mock repository trả về thuốc<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 200 và thông tin thuốc | Thành công | |
| TS_004 | Tìm thuốc theo ID không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| TS_005 | Tìm kiếm thuốc theo tên thành công | 1. Mock repository trả về danh sách thuốc<br>2. Gọi phương thức search() | Trả về ResponseDTO với status 200 và danh sách thuốc | Thành công | |
| TS_006 | Tìm kiếm thuốc không có kết quả | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức search() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| TS_007 | Tạo thuốc thành công | 1. Mock repository trả về thuốc đã tạo<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 201 và thông tin thuốc | Thành công | |
| TS_008 | Tạo thuốc với mã thuốc đã tồn tại | 1. Mock repository trả về true khi kiểm tra tồn tại<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 409 và thông báo lỗi | Thành công | |
| TS_009 | Cập nhật thuốc thành công | 1. Mock repository trả về thuốc đã cập nhật<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 200 và thông tin thuốc | Thành công | |
| TS_010 | Cập nhật thuốc không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| TS_011 | Xóa thuốc thành công | 1. Mock repository không ném exception<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 200 và thông báo thành công | Thành công | |
| TS_012 | Xóa thuốc không tồn tại | 1. Mock repository ném EmptyResultDataAccessException<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |

## Chi tiết test case

### TS_001: Lấy danh sách thuốc thành công

```java
@Test
void testGetAll_Success() {
    // Arrange
    when(thuocRepo.findAll()).thenReturn(thuocList);

    // Act
    ResponseDTO<List<Thuoc>> response = thuocService.getAll();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(thuocList, response.getData());
    verify(thuocRepo, times(1)).findAll();
}
```

### TS_003: Tìm thuốc theo ID thành công

```java
@Test
void testGetById_Success() {
    // Arrange
    when(thuocRepo.findById(1)).thenReturn(Optional.of(thuoc));

    // Act
    ResponseDTO<Thuoc> response = thuocService.getById(1);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(thuoc, response.getData());
    verify(thuocRepo, times(1)).findById(1);
}
```

### TS_007: Tạo thuốc thành công

```java
@Test
void testCreate_Success() {
    // Arrange
    when(thuocRepo.existsByMaThuoc(thuocDTO.getMaThuoc())).thenReturn(false);
    when(modelMapper.map(thuocDTO, Thuoc.class)).thenReturn(thuoc);
    when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuoc);

    // Act
    ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

    // Assert
    assertEquals(201, response.getStatus());
    assertEquals("Tạo thuốc thành công", response.getMsg());
    assertEquals(thuoc, response.getData());
    verify(thuocRepo, times(1)).existsByMaThuoc(thuocDTO.getMaThuoc());
    verify(thuocRepo, times(1)).save(any(Thuoc.class));
}
```

### TS_009: Cập nhật thuốc thành công

```java
@Test
void testUpdate_Success() {
    // Arrange
    when(thuocRepo.findById(thuocDTO.getId())).thenReturn(Optional.of(thuoc));
    when(modelMapper.map(thuocDTO, Thuoc.class)).thenReturn(thuoc);
    when(thuocRepo.save(any(Thuoc.class))).thenReturn(thuoc);

    // Act
    ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Cập nhật thuốc thành công", response.getMsg());
    assertEquals(thuoc, response.getData());
    verify(thuocRepo, times(1)).findById(thuocDTO.getId());
    verify(thuocRepo, times(1)).save(any(Thuoc.class));
}
```

### TS_011: Xóa thuốc thành công

```java
@Test
void testDelete_Success() {
    // Arrange
    when(thuocRepo.existsById(1)).thenReturn(true);
    doNothing().when(thuocRepo).deleteById(1);

    // Act
    ResponseDTO<Void> response = thuocService.delete(1);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Xóa thuốc thành công", response.getMsg());
    assertNull(response.getData());
    verify(thuocRepo, times(1)).existsById(1);
    verify(thuocRepo, times(1)).deleteById(1);
}
```
