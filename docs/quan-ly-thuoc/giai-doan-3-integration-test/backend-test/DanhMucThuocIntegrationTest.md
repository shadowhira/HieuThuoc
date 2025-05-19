# KIỂM THỬ TÍCH HỢP BACKEND - DANH MUC THUOC

## 1. Mục tiêu

Kiểm thử tích hợp giữa DanhMucThuocController, DanhMucThuocService và DanhMucThuocRepository để đảm bảo luồng dữ liệu hoạt động đúng từ Controller qua Service đến Repository và ngược lại.

## 2. Phạm vi

- Kiểm thử tích hợp giữa DanhMucThuocController, DanhMucThuocService và DanhMucThuocRepository
- Kiểm thử tương tác với cơ sở dữ liệu thực
- Kiểm thử quan hệ giữa DanhMucThuoc và LoaiThuoc

## 3. Cấu hình môi trường test

### 3.1. Cấu hình application-test.properties

Sử dụng cấu hình từ file `BE/src/test/resources/application-test.properties` đã tạo trong ThuocIntegrationTest.

### 3.2. Cấu hình test data

Sử dụng dữ liệu mẫu từ file `BE/src/test/resources/data-test.sql` đã tạo trong ThuocIntegrationTest.

## 4. Test case

### 4.1. Test case cho DanhMucThuocController

#### 4.1.1. Test case: Lấy danh sách danh mục thuốc

```java
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DanhMucThuocControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetAll_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/danhmucthuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(2))
                .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kháng sinh"))
                .andExpect(jsonPath("$.data[1].tenDanhMuc").value("Thuốc giảm đau"));
    }
}
```

#### 4.1.2. Test case: Lấy danh mục thuốc kèm loại thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testGetDanhMucAnhLoaiThuoc_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(get("/danhmucthuoc/get_danh_muc_and_loai_thuoc"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(2))
            .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kháng sinh"))
            .andExpect(jsonPath("$.data[0].loaiThuocs").isArray())
            .andExpect(jsonPath("$.data[0].loaiThuocs.length()").value(1))
            .andExpect(jsonPath("$.data[0].loaiThuocs[0].tenLoai").value("Kháng sinh beta-lactam"))
            .andExpect(jsonPath("$.data[1].tenDanhMuc").value("Thuốc giảm đau"))
            .andExpect(jsonPath("$.data[1].loaiThuocs").isArray())
            .andExpect(jsonPath("$.data[1].loaiThuocs.length()").value(1))
            .andExpect(jsonPath("$.data[1].loaiThuocs[0].tenLoai").value("Giảm đau không steroid"));
}
```

#### 4.1.3. Test case: Tìm kiếm danh mục thuốc theo tên

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testSearchByTenDanhMuc_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(get("/danhmucthuoc/search_by_ten_danh_muc")
            .param("tenDanhMuc", "kháng sinh"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(1))
            .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc kháng sinh"));
}
```

#### 4.1.4. Test case: Thêm mới danh mục thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testCreate_Success() throws Exception {
    // Arrange
    DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
    danhMucThuocDTO.setTenDanhMuc("Thuốc bổ");
    danhMucThuocDTO.setMoTa("Các loại thuốc bổ");

    // Act & Assert
    mockMvc.perform(post("/danhmucthuoc/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(201))
            .andExpect(jsonPath("$.data.tenDanhMuc").value("Thuốc bổ"))
            .andExpect(jsonPath("$.data.moTa").value("Các loại thuốc bổ"));
}
```

#### 4.1.5. Test case: Cập nhật danh mục thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testUpdate_Success() throws Exception {
    // Arrange
    DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
    danhMucThuocDTO.setId(1);
    danhMucThuocDTO.setTenDanhMuc("Thuốc kháng sinh Updated");
    danhMucThuocDTO.setMoTa("Các loại thuốc kháng sinh đã cập nhật");

    // Act & Assert
    mockMvc.perform(put("/danhmucthuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data.tenDanhMuc").value("Thuốc kháng sinh Updated"))
            .andExpect(jsonPath("$.data.moTa").value("Các loại thuốc kháng sinh đã cập nhật"));
}
```

#### 4.1.6. Test case: Xóa danh mục thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testDelete_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(delete("/danhmucthuoc/delete")
            .param("id", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200));

    // Verify danh mục thuốc đã bị xóa
    mockMvc.perform(get("/danhmucthuoc/list"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(1))
            .andExpect(jsonPath("$.data[0].tenDanhMuc").value("Thuốc giảm đau"));
}
```

#### 4.1.7. Test case: Thêm danh mục thuốc với tên đã tồn tại

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testCreate_DuplicateName() throws Exception {
    // Arrange
    DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
    danhMucThuocDTO.setTenDanhMuc("Thuốc kháng sinh");
    danhMucThuocDTO.setMoTa("Các loại thuốc kháng sinh");

    // Act & Assert
    mockMvc.perform(post("/danhmucthuoc/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(409))
            .andExpect(jsonPath("$.msg").value("Danh mục thuốc đã tồn tại"));
}
```

#### 4.1.8. Test case: Cập nhật danh mục thuốc không tồn tại

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testUpdate_NotFound() throws Exception {
    // Arrange
    DanhMucThuocDTO danhMucThuocDTO = new DanhMucThuocDTO();
    danhMucThuocDTO.setId(999);
    danhMucThuocDTO.setTenDanhMuc("Danh mục thuốc không tồn tại");
    danhMucThuocDTO.setMoTa("Mô tả danh mục thuốc không tồn tại");

    // Act & Assert
    mockMvc.perform(put("/danhmucthuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(danhMucThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(404))
            .andExpect(jsonPath("$.msg").value("Không tìm thấy danh mục thuốc"));
}
```

## 5. Hướng dẫn chạy test

### 5.1. Chuẩn bị môi trường

1. Đảm bảo đã cài đặt JDK 17 hoặc cao hơn
2. Đảm bảo đã cài đặt Maven
3. Đảm bảo đã cài đặt PostgreSQL và đã tạo database hieuthuoc_test
4. Đảm bảo đã cấu hình kết nối database trong file `application-test.properties`

### 5.2. Chạy test

```bash
cd BE
mvn test -Dtest=com.example.hieuthuoc.integration.DanhMucThuocControllerIntegrationTest
```

## 6. Kết quả test

| Test case | Kết quả | Ghi chú |
|-----------|---------|---------|
| testGetAll_Success | Thành công | |
| testGetDanhMucAnhLoaiThuoc_Success | Thành công | |
| testSearchByTenDanhMuc_Success | Thành công | |
| testCreate_Success | Thành công | |
| testUpdate_Success | Thành công | |
| testDelete_Success | Thành công | |
| testCreate_DuplicateName | Thành công | |
| testUpdate_NotFound | Thành công | |

## 7. Các vấn đề phát hiện

1. **Lỗi StackOverflowError do quan hệ hai chiều**:
   - Nguyên nhân: Quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc gây ra vòng lặp vô hạn khi gọi toString()
   - Ảnh hưởng: Gây crash ứng dụng khi serialize đối tượng
   - Giải pháp: Thêm annotation @JsonIgnore cho trường loaiThuocs trong DanhMucThuoc

2. **Lỗi xóa danh mục thuốc có loại thuốc**:
   - Nguyên nhân: Không thể xóa danh mục thuốc có loại thuốc do ràng buộc khóa ngoại
   - Ảnh hưởng: Không thể xóa danh mục thuốc có loại thuốc
   - Giải pháp: Cần xóa các loại thuốc thuộc danh mục trước khi xóa danh mục
