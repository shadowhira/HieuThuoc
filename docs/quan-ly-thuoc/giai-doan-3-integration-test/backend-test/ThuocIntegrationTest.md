# KIỂM THỬ TÍCH HỢP BACKEND - THUOC

## 1. Mục tiêu

Kiểm thử tích hợp giữa ThuocController, ThuocService và ThuocRepository để đảm bảo luồng dữ liệu hoạt động đúng từ Controller qua Service đến Repository và ngược lại.

## 2. Phạm vi

- Kiểm thử tích hợp giữa ThuocController, ThuocService và ThuocRepository
- Kiểm thử tương tác với cơ sở dữ liệu thực
- Kiểm thử xử lý upload file

## 3. Cấu hình môi trường test

### 3.1. Cấu hình application-test.properties

Tạo file `BE/src/test/resources/application-test.properties`:

```properties
# Cấu hình kết nối database
spring.datasource.url=jdbc:postgresql://localhost:5432/hieuthuoc_test
spring.datasource.username=postgres
spring.datasource.password=G@con123123
spring.datasource.driver-class-name=org.postgresql.Driver

# Cấu hình Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Cấu hình đường dẫn upload file
app.upload.dir=./uploads/test
```

### 3.2. Cấu hình test data

Tạo file `BE/src/test/resources/data-test.sql`:

```sql
-- Dữ liệu mẫu cho danh_muc_thuoc
INSERT INTO danh_muc_thuoc (id, ten_danh_muc, mo_ta) VALUES
(1, 'Thuốc kháng sinh', 'Các loại thuốc kháng sinh'),
(2, 'Thuốc giảm đau', 'Các loại thuốc giảm đau');

-- Dữ liệu mẫu cho loai_thuoc
INSERT INTO loai_thuoc (id, ten_loai, mo_ta, danh_muc_thuoc_id) VALUES
(1, 'Kháng sinh beta-lactam', 'Nhóm kháng sinh beta-lactam', 1),
(2, 'Giảm đau không steroid', 'Nhóm giảm đau không steroid', 2);

-- Dữ liệu mẫu cho nha_san_xuat
INSERT INTO nha_san_xuat (id, ten_nha_san_xuat, dia_chi, so_dien_thoai, email) VALUES
(1, 'Công ty Dược phẩm ABC', 'Hà Nội', '0123456789', 'abc@example.com'),
(2, 'Công ty Dược phẩm XYZ', 'TP.HCM', '0987654321', 'xyz@example.com');

-- Dữ liệu mẫu cho thuoc
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, loai_thuoc_id, nha_san_xuat_id, don_vi, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, trang_thai) VALUES
(1, 'Paracetamol 500mg', 'PARA500', 2, 1, 'Viên', 5000, 7000, 100, 20, true),
(2, 'Amoxicillin 500mg', 'AMOX500', 1, 2, 'Viên', 8000, 12000, 50, 10, true);
```

## 4. Test case

### 4.1. Test case cho ThuocController

#### 4.1.1. Test case: Lấy danh sách thuốc

```java
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = "/data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ThuocControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSearch_Success() throws Exception {
        // Arrange
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);

        // Act & Assert
        mockMvc.perform(post("/thuoc/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchThuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data.data").isArray())
                .andExpect(jsonPath("$.data.data.length()").value(2))
                .andExpect(jsonPath("$.data.data[0].tenThuoc").value("Paracetamol 500mg"))
                .andExpect(jsonPath("$.data.data[1].tenThuoc").value("Amoxicillin 500mg"));
    }
}
```

#### 4.1.2. Test case: Lấy thuốc theo ID

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testGetById_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(get("/thuoc/get")
            .param("id", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data.id").value(1))
            .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"))
            .andExpect(jsonPath("$.data.maThuoc").value("PARA500"));
}
```

#### 4.1.3. Test case: Thêm mới thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testCreate_Success() throws Exception {
    // Arrange
    ThuocDTO thuocDTO = new ThuocDTO();
    thuocDTO.setTenThuoc("Vitamin C 500mg");
    thuocDTO.setMaThuoc("VITC500");
    thuocDTO.setLoaiThuocId(2);
    thuocDTO.setNhaSanXuatId(1);
    thuocDTO.setDonVi("Viên");
    thuocDTO.setGiaNhap(6000.0);
    thuocDTO.setGiaBan(9000.0);
    thuocDTO.setSoLuongTon(80);
    thuocDTO.setNguongCanhBao(15);
    thuocDTO.setCongDung("Bổ sung vitamin C");
    thuocDTO.setHuongDanSuDung("Uống 1 viên mỗi ngày");
    thuocDTO.setTrangThai(true);

    MockMultipartFile thuocDTOFile = new MockMultipartFile(
            "thuocDTO",
            "",
            "application/json",
            objectMapper.writeValueAsString(thuocDTO).getBytes()
    );

    MockMultipartFile imageFile = new MockMultipartFile(
            "file",
            "test.jpg",
            "image/jpeg",
            "test image content".getBytes()
    );

    // Act & Assert
    mockMvc.perform(multipart("/thuoc/create")
            .file(thuocDTOFile)
            .file(imageFile))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data.tenThuoc").value("Vitamin C 500mg"))
            .andExpect(jsonPath("$.data.maThuoc").value("VITC500"));
}
```

#### 4.1.4. Test case: Cập nhật thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testUpdate_Success() throws Exception {
    // Arrange
    ThuocDTO thuocDTO = new ThuocDTO();
    thuocDTO.setId(1);
    thuocDTO.setTenThuoc("Paracetamol 500mg Updated");
    thuocDTO.setMaThuoc("PARA500");
    thuocDTO.setLoaiThuocId(2);
    thuocDTO.setNhaSanXuatId(1);
    thuocDTO.setDonVi("Viên");
    thuocDTO.setGiaNhap(5500.0);
    thuocDTO.setGiaBan(7500.0);
    thuocDTO.setSoLuongTon(120);
    thuocDTO.setNguongCanhBao(25);
    thuocDTO.setCongDung("Giảm đau, hạ sốt");
    thuocDTO.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
    thuocDTO.setTrangThai(true);

    MockMultipartFile thuocDTOFile = new MockMultipartFile(
            "thuocDTO",
            "",
            "application/json",
            objectMapper.writeValueAsString(thuocDTO).getBytes()
    );

    // Act & Assert
    mockMvc.perform(multipart("/thuoc/update")
            .file(thuocDTOFile)
            .with(request -> {
                request.setMethod("PUT");
                return request;
            }))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg Updated"));
}
```

#### 4.1.5. Test case: Xóa thuốc

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testDelete_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(delete("/thuoc/delete")
            .param("id", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200));

    // Verify thuốc đã bị xóa
    mockMvc.perform(get("/thuoc/get")
            .param("id", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(404));
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
mvn test -Dtest=com.example.hieuthuoc.integration.ThuocControllerIntegrationTest
```

## 6. Kết quả test

| Test case | Kết quả | Ghi chú |
|-----------|---------|---------|
| testSearch_Success | Thành công | |
| testGetById_Success | Thành công | |
| testCreate_Success | Thành công | |
| testUpdate_Success | Thành công | |
| testDelete_Success | Thành công | |

## 7. Các vấn đề phát hiện

1. **Lỗi xử lý upload file khi thêm mới thuốc**:
   - Nguyên nhân: Đường dẫn lưu file không tồn tại
   - Ảnh hưởng: Không thể upload file hình ảnh thuốc
   - Giải pháp: Tạo thư mục uploads/test trước khi chạy test

2. **Lỗi xử lý quan hệ giữa Thuoc và LoaiThuoc khi cập nhật**:
   - Nguyên nhân: Không tìm thấy LoaiThuoc khi cập nhật Thuoc
   - Ảnh hưởng: Không thể cập nhật thuốc
   - Giải pháp: Đảm bảo LoaiThuoc tồn tại trong cơ sở dữ liệu trước khi cập nhật Thuoc
