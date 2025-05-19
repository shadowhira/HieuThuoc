# TEST CASE CHO LOAITHUOCCONTROLLER

## Mô tả
File này chứa các test case cho LoaiThuocController, bao gồm các API thêm, sửa, xóa, tìm kiếm loại thuốc.

## Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| LC_001 | Lấy danh sách loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /loai-thuoc/getAll | Trả về status 200 và danh sách loại thuốc | Thành công | |
| LC_002 | Lấy loại thuốc theo ID thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /loai-thuoc/get | Trả về status 200 và thông tin loại thuốc | Thành công | |
| LC_003 | Lấy loại thuốc theo ID không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API GET /loai-thuoc/get | Trả về status 404 và thông báo lỗi | Thành công | |
| LC_004 | Tìm kiếm loại thuốc theo tên thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /loai-thuoc/search | Trả về status 200 và danh sách loại thuốc | Thành công | |
| LC_005 | Tìm kiếm loại thuốc không có kết quả | 1. Mock service trả về ResponseDTO với danh sách rỗng<br>2. Gọi API GET /loai-thuoc/search | Trả về status 200 và danh sách rỗng | Thành công | |
| LC_006 | Tạo loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /loai-thuoc/create | Trả về status 201 và thông tin loại thuốc | Thành công | |
| LC_007 | Tạo loại thuốc với tên đã tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API POST /loai-thuoc/create | Trả về status 409 và thông báo lỗi | Thành công | |
| LC_008 | Cập nhật loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API PUT /loai-thuoc/update | Trả về status 200 và thông tin loại thuốc | Thành công | |
| LC_009 | Cập nhật loại thuốc không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API PUT /loai-thuoc/update | Trả về status 404 và thông báo lỗi | Thành công | |
| LC_010 | Xóa loại thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API DELETE /loai-thuoc/delete | Trả về status 200 và thông báo thành công | Thành công | |
| LC_011 | Xóa loại thuốc không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API DELETE /loai-thuoc/delete | Trả về status 404 và thông báo lỗi | Thành công | |

## Chi tiết test case

### LC_001: Lấy danh sách loại thuốc thành công

```java
@Test
void testGetAllLoaiThuocs_Success() throws Exception {
    // Arrange
    ResponseDTO<List<LoaiThuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", loaiThuocList);
    when(loaiThuocService.getAllLoaiThuocs()).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/loai-thuoc/getAll")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(loaiThuocList.size()));

    verify(loaiThuocService, times(1)).getAllLoaiThuocs();
}
```

### LC_002: Lấy loại thuốc theo ID thành công

```java
@Test
void testGetById_Success() throws Exception {
    // Arrange
    ResponseDTO<LoaiThuoc> responseDTO = new ResponseDTO<>(200, "Thành công", loaiThuoc);
    when(loaiThuocService.getById(1)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/loai-thuoc/get")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data.id").value(1));

    verify(loaiThuocService, times(1)).getById(1);
}
```

### LC_004: Tìm kiếm loại thuốc theo tên thành công

```java
@Test
void testSearchByTenLoai_Success() throws Exception {
    // Arrange
    String tenLoai = "Giảm đau";
    ResponseDTO<List<LoaiThuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", loaiThuocList);
    when(loaiThuocService.searchByTenLoai(tenLoai)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/loai-thuoc/search")
            .param("tenLoai", tenLoai)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(loaiThuocList.size()));

    verify(loaiThuocService, times(1)).searchByTenLoai(tenLoai);
}
```

### LC_006: Tạo loại thuốc thành công

```java
@Test
void testCreate_Success() throws Exception {
    // Arrange
    ResponseDTO<LoaiThuoc> responseDTO = new ResponseDTO<>(201, "Tạo loại thuốc thành công", loaiThuoc);
    when(loaiThuocService.create(any(LoaiThuocDTO.class))).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.post("/loai-thuoc/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loaiThuocDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.status").value(201))
            .andExpect(jsonPath("$.msg").value("Tạo loại thuốc thành công"))
            .andExpect(jsonPath("$.data").exists());

    verify(loaiThuocService, times(1)).create(any(LoaiThuocDTO.class));
}
```

### LC_008: Cập nhật loại thuốc thành công

```java
@Test
void testUpdate_Success() throws Exception {
    // Arrange
    ResponseDTO<LoaiThuoc> responseDTO = new ResponseDTO<>(200, "Cập nhật loại thuốc thành công", loaiThuoc);
    when(loaiThuocService.update(any(LoaiThuocDTO.class))).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.put("/loai-thuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loaiThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Cập nhật loại thuốc thành công"))
            .andExpect(jsonPath("$.data").exists());

    verify(loaiThuocService, times(1)).update(any(LoaiThuocDTO.class));
}
```

### LC_010: Xóa loại thuốc thành công

```java
@Test
void testDelete_Success() throws Exception {
    // Arrange
    ResponseDTO<Void> responseDTO = new ResponseDTO<>(200, "Xóa loại thuốc thành công", null);
    when(loaiThuocService.delete(1)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.delete("/loai-thuoc/delete")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Xóa loại thuốc thành công"))
            .andExpect(jsonPath("$.data").doesNotExist());

    verify(loaiThuocService, times(1)).delete(1);
}
```
