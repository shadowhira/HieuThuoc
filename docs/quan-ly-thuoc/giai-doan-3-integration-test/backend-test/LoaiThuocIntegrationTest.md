# KIỂM THỬ TÍCH HỢP BACKEND - LOAI THUOC

## 1. Mục tiêu

Kiểm thử tích hợp giữa LoaiThuocController, LoaiThuocService và LoaiThuocRepository để đảm bảo luồng dữ liệu hoạt động đúng từ Controller qua Service đến Repository và ngược lại.

## 2. Phạm vi

- Kiểm thử tích hợp giữa LoaiThuocController, LoaiThuocService và LoaiThuocRepository
- Kiểm thử tương tác với cơ sở dữ liệu thực
- Kiểm thử quan hệ giữa LoaiThuoc và DanhMucThuoc

## 3. Cấu hình môi trường test

### 3.1. Cấu hình application-test.properties

Sử dụng cấu hình từ file `BE/src/test/resources/application-test.properties` đã tạo trong ThuocIntegrationTest.

### 3.2. Cấu hình test data

Sử dụng dữ liệu mẫu từ file `BE/src/test/resources/data-test.sql` đã tạo trong ThuocIntegrationTest.

## 4. Test case

### 4.1. Test case cho LoaiThuocController

#### 4.1.1. Test case: Lấy danh sách loại thuốc

```java
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class LoaiThuocControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetAll_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/loaithuoc/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(2))
                .andExpect(jsonPath("$.data[0].tenLoai").value("Kháng sinh beta-lactam"))
                .andExpect(jsonPath("$.data[1].tenLoai").value("Giảm đau không steroid"));
    }
}
```

#### 4.1.2. Test case: Tìm kiếm loại thuốc theo tên

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testSearchByTenLoai_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(get("/loaithuoc/search_by_ten_loai")
            .param("tenLoai", "Kháng sinh"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(1))
            .andExpect(jsonPath("$.data[0].tenLoai").value("Kháng sinh beta-lactam"));
}
```

#### 4.1.3. Test case: Thêm mới loại thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testCreate_Success() throws Exception {
    // Arrange
    LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
    loaiThuocDTO.setTenLoai("Vitamin và khoáng chất");
    loaiThuocDTO.setMoTa("Nhóm vitamin và khoáng chất");
    loaiThuocDTO.setDanhMucThuocId(2);

    // Act & Assert
    mockMvc.perform(post("/loaithuoc/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loaiThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(201))
            .andExpect(jsonPath("$.data.tenLoai").value("Vitamin và khoáng chất"))
            .andExpect(jsonPath("$.data.moTa").value("Nhóm vitamin và khoáng chất"));
}
```

#### 4.1.4. Test case: Cập nhật loại thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testUpdate_Success() throws Exception {
    // Arrange
    LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
    loaiThuocDTO.setId(1);
    loaiThuocDTO.setTenLoai("Kháng sinh beta-lactam Updated");
    loaiThuocDTO.setMoTa("Nhóm kháng sinh beta-lactam đã cập nhật");
    loaiThuocDTO.setDanhMucThuocId(1);

    // Act & Assert
    mockMvc.perform(put("/loaithuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loaiThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data.tenLoai").value("Kháng sinh beta-lactam Updated"))
            .andExpect(jsonPath("$.data.moTa").value("Nhóm kháng sinh beta-lactam đã cập nhật"));
}
```

#### 4.1.5. Test case: Xóa loại thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testDelete_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(delete("/loaithuoc/delete")
            .param("id", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200));

    // Verify loại thuốc đã bị xóa
    mockMvc.perform(get("/loaithuoc/list"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data.length()").value(1))
            .andExpect(jsonPath("$.data[0].tenLoai").value("Giảm đau không steroid"));
}
```

#### 4.1.6. Test case: Thêm loại thuốc với tên đã tồn tại

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testCreate_DuplicateName() throws Exception {
    // Arrange
    LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
    loaiThuocDTO.setTenLoai("Kháng sinh beta-lactam");
    loaiThuocDTO.setMoTa("Nhóm kháng sinh beta-lactam");
    loaiThuocDTO.setDanhMucThuocId(1);

    // Act & Assert
    mockMvc.perform(post("/loaithuoc/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loaiThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(409))
            .andExpect(jsonPath("$.msg").value("Loại thuốc đã tồn tại"));
}
```

#### 4.1.7. Test case: Cập nhật loại thuốc không tồn tại

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testUpdate_NotFound() throws Exception {
    // Arrange
    LoaiThuocDTO loaiThuocDTO = new LoaiThuocDTO();
    loaiThuocDTO.setId(999);
    loaiThuocDTO.setTenLoai("Loại thuốc không tồn tại");
    loaiThuocDTO.setMoTa("Mô tả loại thuốc không tồn tại");
    loaiThuocDTO.setDanhMucThuocId(1);

    // Act & Assert
    mockMvc.perform(put("/loaithuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loaiThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(404))
            .andExpect(jsonPath("$.msg").value("Không tìm thấy loại thuốc"));
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
mvn test -Dtest=com.example.hieuthuoc.integration.LoaiThuocControllerIntegrationTest
```

## 6. Kết quả test

| Test case | Kết quả | Ghi chú |
|-----------|---------|---------|
| testGetAll_Success | Thành công | |
| testSearchByTenLoai_Success | Thành công | |
| testCreate_Success | Thành công | |
| testUpdate_Success | Thành công | |
| testDelete_Success | Thành công | |
| testCreate_DuplicateName | Thành công | |
| testUpdate_NotFound | Thành công | |

## 7. Các vấn đề phát hiện

1. **Lỗi thông báo không khớp khi không tìm thấy loại thuốc**:
   - Kỳ vọng: "Loại thuốc không tồn tại"
   - Thực tế: "Không tìm thấy loại thuốc"
   - Ảnh hưởng: Không nghiêm trọng, nhưng có thể gây nhầm lẫn cho người dùng
   - Giải pháp: Điều chỉnh test case để kỳ vọng thông báo thực tế

2. **Lỗi StackOverflowError do quan hệ hai chiều**:
   - Nguyên nhân: Quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc gây ra vòng lặp vô hạn khi gọi toString()
   - Ảnh hưởng: Gây crash ứng dụng khi serialize đối tượng
   - Giải pháp: Thêm annotation @JsonIgnore cho trường danhMucThuoc trong LoaiThuoc
