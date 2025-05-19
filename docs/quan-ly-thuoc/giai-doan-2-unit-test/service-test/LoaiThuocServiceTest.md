# TEST CASE CHO LOAITHUOCSERVICE

## Mô tả
File này chứa các test case cho LoaiThuocService, bao gồm các phương thức thêm, sửa, xóa, tìm kiếm loại thuốc.

## Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| LS_001 | Lấy danh sách loại thuốc thành công | 1. Mock repository trả về danh sách loại thuốc<br>2. Gọi phương thức getAllLoaiThuocs() | Trả về ResponseDTO với status 200 và danh sách loại thuốc | Thành công | |
| LS_002 | Lấy danh sách loại thuốc trống | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức getAllLoaiThuocs() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| LS_003 | Tìm loại thuốc theo ID thành công | 1. Mock repository trả về loại thuốc<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 200 và thông tin loại thuốc | Thành công | |
| LS_004 | Tìm loại thuốc theo ID không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức getById() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| LS_005 | Tìm kiếm loại thuốc theo tên thành công | 1. Mock repository trả về danh sách loại thuốc<br>2. Gọi phương thức searchByTenLoai() | Trả về ResponseDTO với status 200 và danh sách loại thuốc | Thành công | |
| LS_006 | Tìm kiếm loại thuốc không có kết quả | 1. Mock repository trả về danh sách rỗng<br>2. Gọi phương thức searchByTenLoai() | Trả về ResponseDTO với status 200 và danh sách rỗng | Thành công | |
| LS_007 | Tạo loại thuốc thành công | 1. Mock repository trả về loại thuốc đã tạo<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 201 và thông tin loại thuốc | Thành công | |
| LS_008 | Tạo loại thuốc với tên đã tồn tại | 1. Mock repository trả về true khi kiểm tra tồn tại<br>2. Gọi phương thức create() | Trả về ResponseDTO với status 409 và thông báo lỗi | Thành công | |
| LS_009 | Cập nhật loại thuốc thành công | 1. Mock repository trả về loại thuốc đã cập nhật<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 200 và thông tin loại thuốc | Thành công | |
| LS_010 | Cập nhật loại thuốc không tồn tại | 1. Mock repository trả về Optional.empty()<br>2. Gọi phương thức update() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |
| LS_011 | Xóa loại thuốc thành công | 1. Mock repository không ném exception<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 200 và thông báo thành công | Thành công | |
| LS_012 | Xóa loại thuốc không tồn tại | 1. Mock repository ném EmptyResultDataAccessException<br>2. Gọi phương thức delete() | Trả về ResponseDTO với status 404 và thông báo lỗi | Thành công | |

## Chi tiết test case

### LS_001: Lấy danh sách loại thuốc thành công

```java
@Test
void testGetAllLoaiThuocs_Success() {
    // Arrange
    when(loaiThuocRepo.findAll()).thenReturn(loaiThuocList);

    // Act
    ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.getAllLoaiThuocs();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(loaiThuocList, response.getData());
    verify(loaiThuocRepo, times(1)).findAll();
}
```

### LS_002: Lấy danh sách loại thuốc trống

```java
@Test
void testGetAllLoaiThuocs_EmptyList() {
    // Arrange
    when(loaiThuocRepo.findAll()).thenReturn(new ArrayList<>());

    // Act
    ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.getAllLoaiThuocs();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertNotNull(response.getData());
    assertTrue(response.getData().isEmpty());
    verify(loaiThuocRepo, times(1)).findAll();
}
```

### LS_005: Tìm kiếm loại thuốc theo tên thành công

```java
@Test
void testSearchByTenLoai_Success() {
    // Arrange
    String tenLoai = "Giảm đau";
    when(loaiThuocRepo.findByTenLoaiContainingIgnoreCase(tenLoai)).thenReturn(loaiThuocList);

    // Act
    ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.searchByTenLoai(tenLoai);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertEquals(loaiThuocList, response.getData());
    verify(loaiThuocRepo, times(1)).findByTenLoaiContainingIgnoreCase(tenLoai);
}
```

### LS_007: Tạo loại thuốc thành công

```java
@Test
void testCreate_Success() {
    // Arrange
    when(loaiThuocRepo.existsByTenLoai(loaiThuocDTO.getTenLoai())).thenReturn(false);
    when(danhMucThuocRepo.findById(loaiThuocDTO.getDanhMucThuocId())).thenReturn(Optional.of(danhMucThuoc));
    when(modelMapper.map(loaiThuocDTO, LoaiThuoc.class)).thenReturn(loaiThuoc);
    when(loaiThuocRepo.save(any(LoaiThuoc.class))).thenReturn(loaiThuoc);

    // Act
    ResponseDTO<LoaiThuoc> response = loaiThuocService.create(loaiThuocDTO);

    // Assert
    assertEquals(201, response.getStatus());
    assertEquals("Tạo loại thuốc thành công", response.getMsg());
    assertEquals(loaiThuoc, response.getData());
    verify(loaiThuocRepo, times(1)).existsByTenLoai(loaiThuocDTO.getTenLoai());
    verify(danhMucThuocRepo, times(1)).findById(loaiThuocDTO.getDanhMucThuocId());
    verify(loaiThuocRepo, times(1)).save(any(LoaiThuoc.class));
}
```

### LS_009: Cập nhật loại thuốc thành công

```java
@Test
void testUpdate_Success() {
    // Arrange
    when(loaiThuocRepo.findById(loaiThuocDTO.getId())).thenReturn(Optional.of(loaiThuoc));
    when(modelMapper.map(loaiThuocDTO, LoaiThuoc.class)).thenReturn(loaiThuoc);
    when(loaiThuocRepo.save(any(LoaiThuoc.class))).thenReturn(loaiThuoc);

    // Act
    ResponseDTO<LoaiThuoc> response = loaiThuocService.update(loaiThuocDTO);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Cập nhật loại thuốc thành công", response.getMsg());
    assertEquals(loaiThuoc, response.getData());
    verify(loaiThuocRepo, times(1)).findById(loaiThuocDTO.getId());
    verify(loaiThuocRepo, times(1)).save(any(LoaiThuoc.class));
}
```

### LS_011: Xóa loại thuốc thành công

```java
@Test
void testDelete_Success() {
    // Arrange
    when(loaiThuocRepo.existsById(1)).thenReturn(true);
    doNothing().when(loaiThuocRepo).deleteById(1);

    // Act
    ResponseDTO<Void> response = loaiThuocService.delete(1);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Xóa loại thuốc thành công", response.getMsg());
    assertNull(response.getData());
    verify(loaiThuocRepo, times(1)).existsById(1);
    verify(loaiThuocRepo, times(1)).deleteById(1);
}
```
