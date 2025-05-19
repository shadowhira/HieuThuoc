# TEST CASE CHO DANHMUCTHUOCSERVICE

## Mô tả
File này chứa các test case cho DanhMucThuocService, bao gồm các phương thức thêm, sửa, xóa, tìm kiếm danh mục thuốc.

## Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| DS_001 | Lấy danh sách danh mục thuốc thành công | 1. Mock repository trả về danh sách danh mục thuốc<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách danh mục thuốc | Thành công | |
| DS_002 | Lấy danh sách danh mục thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getAll() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| DS_003 | Lấy danh mục thuốc kèm loại thuốc thành công | 1. Mock repository trả về danh sách danh mục thuốc<br>2. Gọi phương thức getDanhMucAnhLoaiThuoc() | Trả về ResponseDTO với status 200 và danh sách danh mục thuốc | Thành công | |
| DS_004 | Lấy danh mục thuốc kèm loại thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getDanhMucAnhLoaiThuoc() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| DS_005 | Tìm danh mục thuốc theo ID thành công | 1. Mock repository trả về danh mục thuốc<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 200 và thông tin danh mục thuốc | Thành công | |
| DS_006 | Tìm danh mục thuốc theo ID không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| DS_007 | Tìm kiếm danh mục thuốc theo tên thành công | 1. Mock repository trả về danh sách danh mục thuốc<br>2. Gọi phương thức searchByTenDanhMuc() | Trả về ResponseDTO với status 200 và danh sách danh mục thuốc | Thành công | |
| DS_008 | Tìm kiếm danh mục thuốc không có kết quả | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức searchByTenDanhMuc() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| DS_009 | Tạo danh mục thuốc thành công | 1. Mock repository trả về danh mục thuốc đã tạo<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 201 và thông tin danh mục thuốc | Thành công | |
| DS_010 | Tạo danh mục thuốc với tên đã tồn tại | 1. Mock repository trả về true khi kiểm tra tồn tại<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 409 và thông báo lỗi | Thành công | |
| DS_011 | Cập nhật danh mục thuốc thành công | 1. Mock repository trả về danh mục thuốc đã cập nhật<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 200 và thông tin danh mục thuốc | Thành công | |
| DS_012 | Cập nhật danh mục thuốc không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| DS_013 | Xóa danh mục thuốc thành công | 1. Mock repository không ném exception<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 200 và thông báo thành công | Thành công | |
| DS_014 | Xóa danh mục thuốc không tồn tại | 1. Mock repository ném EmptyResultDataAccessException<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |

## Chi tiết test case

### DS_001: Lấy danh sách danh mục thuốc thành công

```java
@Test
void testGetAll_Success() {
    // Arrange
    when(danhMucThuocRepo.findAll()).thenReturn(danhMucThuocList);

    // Act
    ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getAll();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(danhMucThuocList, response.getData());
    verify(danhMucThuocRepo, times(1)).findAll();
}
```

### DS_002: Lấy danh sách danh mục thuốc trống

```java
@Test
void testGetAll_EmptyList() {
    // Arrange
    when(danhMucThuocRepo.findAll()).thenReturn(new ArrayList<>());

    // Act
    ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getAll();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertNotNull(response.getData());
    assertTrue(response.getData().isEmpty());
    verify(danhMucThuocRepo, times(1)).findAll();
}
```

### DS_003: Lấy danh mục thuốc kèm loại thuốc thành công

```java
@Test
void testGetDanhMucAnhLoaiThuoc_Success() {
    // Arrange
    when(danhMucThuocRepo.findAllWithLoaiThuocs()).thenReturn(danhMucThuocList);

    // Act
    ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.getDanhMucAnhLoaiThuoc();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(danhMucThuocList, response.getData());
    verify(danhMucThuocRepo, times(1)).findAllWithLoaiThuocs();
}
```

### DS_007: Tìm kiếm danh mục thuốc theo tên thành công

```java
@Test
void testSearchByTenDanhMuc_Success() {
    // Arrange
    String tenDanhMuc = "Thuốc giảm đau";
    when(danhMucThuocRepo.findByTenDanhMucContainingIgnoreCase(tenDanhMuc)).thenReturn(danhMucThuocList);

    // Act
    ResponseDTO<List<DanhMucThuoc>> response = danhMucThuocService.searchByTenDanhMuc(tenDanhMuc);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(danhMucThuocList, response.getData());
    verify(danhMucThuocRepo, times(1)).findByTenDanhMucContainingIgnoreCase(tenDanhMuc);
}
```

### DS_009: Tạo danh mục thuốc thành công

```java
@Test
void testCreate_Success() {
    // Arrange
    when(danhMucThuocRepo.existsByTenDanhMuc(danhMucThuocDTO.getTenDanhMuc())).thenReturn(false);
    when(modelMapper.map(danhMucThuocDTO, DanhMucThuoc.class)).thenReturn(danhMucThuoc);
    when(danhMucThuocRepo.save(any(DanhMucThuoc.class))).thenReturn(danhMucThuoc);

    // Act
    ResponseDTO<DanhMucThuoc> response = danhMucThuocService.create(danhMucThuocDTO);

    // Assert
    assertEquals(201, response.getStatus());
    assertEquals("Tạo danh mục thuốc thành công", response.getMsg());
    assertEquals(danhMucThuoc, response.getData());
    verify(danhMucThuocRepo, times(1)).existsByTenDanhMuc(danhMucThuocDTO.getTenDanhMuc());
    verify(danhMucThuocRepo, times(1)).save(any(DanhMucThuoc.class));
}
```

### DS_011: Cập nhật danh mục thuốc thành công

```java
@Test
void testUpdate_Success() {
    // Arrange
    when(danhMucThuocRepo.findById(danhMucThuocDTO.getId())).thenReturn(Optional.of(danhMucThuoc));
    when(modelMapper.map(danhMucThuocDTO, DanhMucThuoc.class)).thenReturn(danhMucThuoc);
    when(danhMucThuocRepo.save(any(DanhMucThuoc.class))).thenReturn(danhMucThuoc);

    // Act
    ResponseDTO<DanhMucThuoc> response = danhMucThuocService.update(danhMucThuocDTO);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Cập nhật danh mục thuốc thành công", response.getMsg());
    assertEquals(danhMucThuoc, response.getData());
    verify(danhMucThuocRepo, times(1)).findById(danhMucThuocDTO.getId());
    verify(danhMucThuocRepo, times(1)).save(any(DanhMucThuoc.class));
}
```

### DS_013: Xóa danh mục thuốc thành công

```java
@Test
void testDelete_Success() {
    // Arrange
    when(danhMucThuocRepo.existsById(1)).thenReturn(true);
    doNothing().when(danhMucThuocRepo).deleteById(1);

    // Act
    ResponseDTO<Void> response = danhMucThuocService.delete(1);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Xóa danh mục thuốc thành công", response.getMsg());
    assertNull(response.getData());
    verify(danhMucThuocRepo, times(1)).existsById(1);
    verify(danhMucThuocRepo, times(1)).deleteById(1);
}
```
