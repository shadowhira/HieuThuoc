# TEST CASE CHO THUOCCONTROLLER

## Mô tả
File này chứa các test case cho ThuocController, bao gồm các API thêm, sửa, xóa, tìm kiếm thuốc.

## Danh sách test case

| ID | Tóm tắt | Các bước | Kết quả mong đợi | Kết quả thực tế | Ghi chú |
|----|---------|----------|------------------|-----------------|---------|
| TC_001 | Lấy danh sách thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /thuoc/getAll | Trả về status 200 và danh sách thuốc | Thành công | |
| TC_002 | Lấy thuốc theo ID thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API GET /thuoc/get | Trả về status 200 và thông tin thuốc | Thành công | |
| TC_003 | Lấy thuốc theo ID không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API GET /thuoc/get | Trả về status 404 và thông báo lỗi | Thành công | |
| TC_004 | Tìm kiếm thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /thuoc/search | Trả về status 200 và danh sách thuốc | Thành công | |
| TC_005 | Tìm kiếm thuốc không có kết quả | 1. Mock service trả về ResponseDTO với danh sách rỗng<br>2. Gọi API POST /thuoc/search | Trả về status 200 và danh sách rỗng | Thành công | |
| TC_006 | Tạo thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API POST /thuoc/create | Trả về status 201 và thông tin thuốc | Thành công | |
| TC_007 | Tạo thuốc với mã thuốc đã tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API POST /thuoc/create | Trả về status 409 và thông báo lỗi | Thành công | |
| TC_008 | Cập nhật thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API PUT /thuoc/update | Trả về status 200 và thông tin thuốc | Thành công | |
| TC_009 | Cập nhật thuốc không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API PUT /thuoc/update | Trả về status 404 và thông báo lỗi | Thành công | |
| TC_010 | Xóa thuốc thành công | 1. Mock service trả về ResponseDTO thành công<br>2. Gọi API DELETE /thuoc/delete | Trả về status 200 và thông báo thành công | Thành công | |
| TC_011 | Xóa thuốc không tồn tại | 1. Mock service trả về ResponseDTO thất bại<br>2. Gọi API DELETE /thuoc/delete | Trả về status 404 và thông báo lỗi | Thành công | |

## Chi tiết test case

### TC_001: Lấy danh sách thuốc thành công

```java
@Test
void testGetAll_Success() throws Exception {
    // Arrange
    ResponseDTO<List<Thuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", thuocList);
    when(thuocService.getAll()).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/thuoc/getAll")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(thuocList.size()));

    verify(thuocService, times(1)).getAll();
}
```

### TC_002: Lấy thuốc theo ID thành công

```java
@Test
void testGetById_Success() throws Exception {
    // Arrange
    ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>(200, "Thành công", thuoc);
    when(thuocService.getById(1)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.get("/thuoc/get")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data.id").value(1));

    verify(thuocService, times(1)).getById(1);
}
```

### TC_004: Tìm kiếm thuốc thành công

```java
@Test
void testSearch_Success() throws Exception {
    // Arrange
    SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
    searchThuocDTO.setTenThuoc("Paracetamol");
    
    ResponseDTO<List<Thuoc>> responseDTO = new ResponseDTO<>(200, "Thành công", thuocList);
    when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.post("/thuoc/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(thuocList.size()));

    verify(thuocService, times(1)).search(any(SearchThuocDTO.class));
}
```

### TC_006: Tạo thuốc thành công

```java
@Test
void testCreate_Success() throws Exception {
    // Arrange
    ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>(201, "Tạo thuốc thành công", thuoc);
    when(thuocService.create(any(ThuocDTO.class))).thenReturn(responseDTO);

    MockMultipartFile imageFile = new MockMultipartFile(
        "image", "test.jpg", "image/jpeg", "test image content".getBytes()
    );

    MockMultipartFile thuocDTOFile = new MockMultipartFile(
        "thuocDTO", "", "application/json", objectMapper.writeValueAsString(thuocDTO).getBytes()
    );

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.multipart("/thuoc/create")
            .file(thuocDTOFile)
            .file(imageFile))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.status").value(201))
            .andExpect(jsonPath("$.msg").value("Tạo thuốc thành công"))
            .andExpect(jsonPath("$.data").exists());

    verify(thuocService, times(1)).create(any(ThuocDTO.class));
}
```

### TC_008: Cập nhật thuốc thành công

```java
@Test
void testUpdate_Success() throws Exception {
    // Arrange
    ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>(200, "Cập nhật thuốc thành công", thuoc);
    when(thuocService.update(any(ThuocDTO.class))).thenReturn(responseDTO);

    MockMultipartFile imageFile = new MockMultipartFile(
        "image", "test.jpg", "image/jpeg", "test image content".getBytes()
    );

    MockMultipartFile thuocDTOFile = new MockMultipartFile(
        "thuocDTO", "", "application/json", objectMapper.writeValueAsString(thuocDTO).getBytes()
    );

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.multipart("/thuoc/update")
            .file(thuocDTOFile)
            .file(imageFile)
            .with(request -> {
                request.setMethod("PUT");
                return request;
            }))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Cập nhật thuốc thành công"))
            .andExpect(jsonPath("$.data").exists());

    verify(thuocService, times(1)).update(any(ThuocDTO.class));
}
```

### TC_010: Xóa thuốc thành công

```java
@Test
void testDelete_Success() throws Exception {
    // Arrange
    ResponseDTO<Void> responseDTO = new ResponseDTO<>(200, "Xóa thuốc thành công", null);
    when(thuocService.delete(1)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(MockMvcRequestBuilders.delete("/thuoc/delete")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Xóa thuốc thành công"))
            .andExpect(jsonPath("$.data").doesNotExist());

    verify(thuocService, times(1)).delete(1);
}
```
