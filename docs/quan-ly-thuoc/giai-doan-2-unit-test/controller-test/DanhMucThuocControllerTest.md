# TEST CASE CHO DANHMUCTHUOCCONTROLLER

## Mô tả
File này chứa các test case cho DanhMucThuocController, bao gồm các API thêm, sửa, xóa, tìm kiếm danh mục thuốc.

## Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| DC_001 | Lấy danh sách danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /danh-muc-thuoc/getAll | Trả về status 200 và danh sách danh mục thuốc | Thành công | |
| DC_002 | Lấy danh mục thuốc kèm loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /danh-muc-thuoc/getDanhMucAnhLoaiThuoc | Trả về status 200 và danh sách danh mục thuốc | Thành công | |
| DC_003 | Lấy danh mục thuốc theo ID thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /danh-muc-thuoc/get | Trả về status 200 và thông tin danh mục thuốc | Thành công | |
| DC_004 | Lấy danh mục thuốc theo ID không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API GET /danh-muc-thuoc/get | Trả về status 404 và thông báo lỗi | Thành công | |
| DC_005 | Tìm kiếm danh mục thuốc theo tên thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /danh-muc-thuoc/search | Trả về status 200 và danh sách danh mục thuốc | Thành công | |
| DC_006 | Tìm kiếm danh mục thuốc không có kết quả | 1. Mock service trả về ResponseDTO với danh sách rỗng<br>2. Gọi API GET /danh-muc-thuoc/search | Trả về status 200 và danh sách rỗng | Thành công | |
| DC_007 | Tạo danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /danh-muc-thuoc/create | Trả về status 201 và thông tin danh mục thuốc | Thành công | |
| DC_008 | Tạo danh mục thuốc với tên đã tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API POST /danh-muc-thuoc/create | Trả về status 409 và thông báo lỗi | Thành công | |
| DC_009 | Cập nhật danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API PUT /danh-muc-thuoc/update | Trả về status 200 và thông tin danh mục thuốc | Thành công | |
| DC_010 | Cập nhật danh mục thuốc không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API PUT /danh-muc-thuoc/update | Trả về status 404 và thông báo lỗi | Thành công | |
| DC_011 | Xóa danh mục thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API DELETE /danh-muc-thuoc/delete | Trả về status 200 và thông báo thành công | Thành công | |
| DC_012 | Xóa danh mục thuốc không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API DELETE /danh-muc-thuoc/delete | Trả về status 404 và thông báo lỗi | Thành công | |

## Chi tiết test case

### DC_001: Lấy danh sách danh mục thuốc thành công

```java
@Test
void testGetAll_Success() throws Exception {
    // Arrange
    ResponseDTO<List<DanhMucThuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", danhMucThuocList);
    when(danhMucThuocService.getAll()).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/danh-muc-thuoc/getAll")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(danhMucThuocList.size()));

    verify(danhMucThuocService, times(1)).getAll();
}
```

### DC_002: Lấy danh mục thuốc kèm loại thuốc thành công

```java
@Test
void testGetDanhMucAnhLoaiThuoc_Success() throws Exception {
    // Arrange
    ResponseDTO<List<DanhMucThuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", danhMucThuocList);
    when(danhMucThuocService.getDanhMucAnhLoaiThuoc()).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/danh-muc-thuoc/getDanhMucAnhLoaiThuoc")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(danhMucThuocList.size()));

    verify(danhMucThuocService, times(1)).getDanhMucAnhLoaiThuoc();
}
```

### DC_003: Lấy danh mục thuốc theo ID thành công

```java
@Test
void testGetById_Success() throws Exception {
    // Arrange
    ResponseDTO<DanhMucThuoc> responseDTO = new ResponseDTO<>(200, "Thành công", danhMucThuoc);
    when(danhMucThuocService.getById(1)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/danh-muc-thuoc/get")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data.id").value(1));

    verify(danhMucThuocService, times(1)).getById(1);
}
```

### DC_005: Tìm kiếm danh mục thuốc theo tên thành công

```java
@Test
void testSearchByTenDanhMuc_Success() throws Exception {
    // Arrange
    String tenDanhMuc = "Thuốc giảm đau";
    ResponseDTO<List<DanhMucThuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", danhMucThuocList);
    when(danhMucThuocService.searchByTenDanhMuc(tenDanhMuc)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/danh-muc-thuoc/search")
            .param("tenDanhMuc", tenDanhMuc)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(danhMucThuocList.size()));

    verify(danhMucThuocService, times(1)).searchByTenDanhMuc(tenDanhMuc);
}
```

### DC_007: Tạo danh mục thuốc thành công

```java
@Test
void testCreate_Success() throws Exception {
    // Arrange
    ResponseDTO<DanhMucThuoc> responseDTO = new ResponseDTO<>(201, "Tạo danh mục thuốc thành công", danhMucThuoc);
    when(danhMucThuocService.create(any(DanhMucThuocDTO.class))).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.post("/danh-muc-thuoc/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.status").value(201))
            .andExpect(jsonPath("$.msg").value("Tạo danh mục thuốc thành công"))
            .andExpect(jsonPath("$.data").exists());

    verify(danhMucThuocService, times(1)).create(any(DanhMucThuocDTO.class));
}
```

### DC_009: Cập nhật danh mục thuốc thành công

```java
@Test
void testUpdate_Success() throws Exception {
    // Arrange
    ResponseDTO<DanhMucThuoc> responseDTO = new ResponseDTO<>(200, "Cập nhật danh mục thuốc thành công", danhMucThuoc);
    when(danhMucThuocService.update(any(DanhMucThuocDTO.class))).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.put("/danh-muc-thuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Cập nhật danh mục thuốc thành công"))
            .andExpect(jsonPath("$.data").exists());

    verify(danhMucThuocService, times(1)).update(any(DanhMucThuocDTO.class));
}
```

### DC_011: Xóa danh mục thuốc thành công

```java
@Test
void testDelete_Success() throws Exception {
    // Arrange
    ResponseDTO<Void> responseDTO = new ResponseDTO<>(200, "Xóa danh mục thuốc thành công", null);
    when(danhMucThuocService.delete(1)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.delete("/danh-muc-thuoc/delete")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Xóa danh mục thuốc thành công"))
            .andExpect(jsonPath("$.data").doesNotExist());

    verify(danhMucThuocService, times(1)).delete(1);
}
```
