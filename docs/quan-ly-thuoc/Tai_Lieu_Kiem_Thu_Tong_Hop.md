# TÀI LIỆU KIỂM THỬ TỔNG HỢP CHỨC NĂNG QUẢN LÝ THUỐC

## MỤC LỤC

1. [GIỚI THIỆU](#1-giới-thiệu)
   1. [Mục đích](#11-mục-đích)
   2. [Phạm vi](#12-phạm-vi)
   3. [Tài liệu tham khảo](#13-tài-liệu-tham-khảo)

2. [KẾ HOẠCH KIỂM THỬ](#2-kế-hoạch-kiểm-thử)
   1. [Chiến lược kiểm thử](#21-chiến-lược-kiểm-thử)
   2. [Lịch trình thực hiện](#22-lịch-trình-thực-hiện)
   3. [Phân công nhiệm vụ](#23-phân-công-nhiệm-vụ)
   4. [Tài nguyên cần thiết](#24-tài-nguyên-cần-thiết)
   5. [Quản lý rủi ro](#25-quản-lý-rủi-ro)

3. [KIỂM THỬ ĐƠN VỊ (UNIT TESTING)](#3-kiểm-thử-đơn-vị-unit-testing)
   1. [Chuẩn bị môi trường](#31-chuẩn-bị-môi-trường)
   2. [Kiểm thử Service](#32-kiểm-thử-service)
   3. [Kiểm thử Controller](#33-kiểm-thử-controller)
   4. [Kiểm thử Component](#34-kiểm-thử-component)
   5. [Chạy kiểm thử](#35-chạy-kiểm-thử)

4. [KIỂM THỬ TÍCH HỢP (INTEGRATION TESTING)](#4-kiểm-thử-tích-hợp-integration-testing)
   1. [Chuẩn bị môi trường](#41-chuẩn-bị-môi-trường)
   2. [Kiểm thử tích hợp Backend](#42-kiểm-thử-tích-hợp-backend)
   3. [Kiểm thử tích hợp Frontend-Backend](#43-kiểm-thử-tích-hợp-frontend-backend)
   4. [Chạy kiểm thử](#44-chạy-kiểm-thử)

5. [KIỂM THỬ HỆ THỐNG (SYSTEM TESTING)](#5-kiểm-thử-hệ-thống-system-testing)
   1. [Kiểm thử luồng nghiệp vụ (End-to-End Testing)](#51-kiểm-thử-luồng-nghiệp-vụ-end-to-end-testing)
   2. [Kiểm thử hiệu năng (Performance Testing)](#52-kiểm-thử-hiệu-năng-performance-testing)
   3. [Kiểm thử tương thích (Compatibility Testing)](#53-kiểm-thử-tương-thích-compatibility-testing)

6. [KIỂM THỬ GIAO DIỆN (UI TESTING)](#6-kiểm-thử-giao-diện-ui-testing)
   1. [Kiểm thử giao diện danh sách thuốc](#61-kiểm-thử-giao-diện-danh-sách-thuốc)
   2. [Kiểm thử giao diện thêm/sửa thuốc](#62-kiểm-thử-giao-diện-thêmsửa-thuốc)
   3. [Kiểm thử giao diện chi tiết thuốc](#63-kiểm-thử-giao-diện-chi-tiết-thuốc)
   4. [Kiểm thử giao diện tìm kiếm thuốc](#64-kiểm-thử-giao-diện-tìm-kiếm-thuốc)
   5. [Kiểm thử tính responsive](#65-kiểm-thử-tính-responsive)

7. [KIỂM THỬ CHỨC NĂNG (FUNCTIONAL TESTING)](#7-kiểm-thử-chức-năng-functional-testing)
   1. [Kiểm thử chức năng thêm thuốc](#71-kiểm-thử-chức-năng-thêm-thuốc)
   2. [Kiểm thử chức năng cập nhật thuốc](#72-kiểm-thử-chức-năng-cập-nhật-thuốc)
   3. [Kiểm thử chức năng xóa thuốc](#73-kiểm-thử-chức-năng-xóa-thuốc)
   4. [Kiểm thử chức năng tìm kiếm thuốc](#74-kiểm-thử-chức-năng-tìm-kiếm-thuốc)

8. [TEST CASE CHI TIẾT](#8-test-case-chi-tiết)
   1. [Test case thêm thuốc](#81-test-case-thêm-thuốc)
   2. [Test case sửa thuốc](#82-test-case-sửa-thuốc)
   3. [Test case xóa thuốc](#83-test-case-xóa-thuốc)
   4. [Test case tìm kiếm thuốc](#84-test-case-tìm-kiếm-thuốc)
   5. [Test case quản lý loại thuốc](#85-test-case-quản-lý-loại-thuốc)
   6. [Test case quản lý danh mục thuốc](#86-test-case-quản-lý-danh-mục-thuốc)

9. [BÁO CÁO KẾT QUẢ KIỂM THỬ](#9-báo-cáo-kết-quả-kiểm-thử)
   1. [Tổng hợp kết quả](#91-tổng-hợp-kết-quả)
   2. [Phân tích lỗi](#92-phân-tích-lỗi)
   3. [Đề xuất cải tiến](#93-đề-xuất-cải-tiến)

10. [KẾT LUẬN](#10-kết-luận)

## 1. GIỚI THIỆU

### 1.1 Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc. Tài liệu bao gồm các loại kiểm thử khác nhau, từ kiểm thử đơn vị đến kiểm thử hệ thống, nhằm đảm bảo chất lượng của chức năng Quản lý thuốc.

### 1.2 Phạm vi
Tài liệu bao gồm hướng dẫn kiểm thử cho:
- Chức năng thêm thuốc mới
- Chức năng cập nhật thông tin thuốc
- Chức năng xóa thuốc
- Chức năng tìm kiếm thuốc
- Chức năng quản lý loại thuốc
- Chức năng quản lý danh mục thuốc
- Giao diện người dùng của các chức năng trên

### 1.3 Tài liệu tham khảo
- Tài liệu đặc tả yêu cầu phần mềm
- Tài liệu thiết kế hệ thống
- Tài liệu hướng dẫn sử dụng JUnit, Mockito, Cypress, Selenium, JMeter, Postman

## 2. KẾ HOẠCH KIỂM THỬ

### 2.1 Chiến lược kiểm thử
Chiến lược kiểm thử cho chức năng Quản lý thuốc bao gồm các loại kiểm thử sau:

#### 2.1.1 Kiểm thử đơn vị (Unit Testing)
- **Mục tiêu**: Kiểm thử các thành phần nhỏ nhất của hệ thống một cách độc lập
- **Phạm vi**: Service, Controller, Repository, Component
- **Công cụ**: JUnit, Mockito, Jest, Jasmine
- **Người thực hiện**: Lập trình viên

#### 2.1.2 Kiểm thử tích hợp (Integration Testing)
- **Mục tiêu**: Kiểm thử sự tương tác giữa các thành phần trong hệ thống
- **Phạm vi**: Tích hợp giữa các thành phần backend, tích hợp frontend-backend
- **Công cụ**: Spring Boot Test, TestRestTemplate, MockMvc, Angular HttpClientTestingModule
- **Người thực hiện**: Lập trình viên, Tester

#### 2.1.3 Kiểm thử hệ thống (System Testing)
- **Mục tiêu**: Kiểm thử toàn bộ hệ thống từ đầu đến cuối
- **Phạm vi**: Luồng nghiệp vụ, hiệu năng, tương thích
- **Công cụ**: Selenium, Cypress, JMeter
- **Người thực hiện**: Tester

#### 2.1.4 Kiểm thử giao diện (UI Testing)
- **Mục tiêu**: Kiểm thử giao diện người dùng
- **Phạm vi**: Giao diện danh sách, thêm/sửa, chi tiết, tìm kiếm, responsive
- **Công cụ**: Cypress, Selenium
- **Người thực hiện**: Tester

#### 2.1.5 Kiểm thử chức năng (Functional Testing)
- **Mục tiêu**: Kiểm thử các chức năng của hệ thống
- **Phạm vi**: Thêm, sửa, xóa, tìm kiếm thuốc
- **Công cụ**: Postman, JUnit, Cypress
- **Người thực hiện**: Tester

### 2.2 Lịch trình thực hiện

| Giai đoạn | Công việc | Thời gian | Người thực hiện |
|-----------|-----------|-----------|-----------------|
| 1 | Chuẩn bị môi trường kiểm thử | Ngày 1 | Lập trình viên, Tester |
| 2 | Kiểm thử đơn vị | Ngày 1-2 | Lập trình viên |
| 3 | Kiểm thử tích hợp | Ngày 2-3 | Lập trình viên, Tester |
| 4 | Kiểm thử chức năng | Ngày 3-4 | Tester |
| 5 | Kiểm thử giao diện | Ngày 4-5 | Tester |
| 6 | Kiểm thử hệ thống | Ngày 5 | Tester |
| 7 | Tổng hợp và báo cáo | Ngày 6 | Tester |

### 2.3 Phân công nhiệm vụ

#### 2.3.1 Lập trình viên
- Viết và chạy kiểm thử đơn vị
- Viết và chạy kiểm thử tích hợp backend
- Sửa lỗi phát hiện trong quá trình kiểm thử

#### 2.3.2 Tester
- Viết và chạy kiểm thử tích hợp frontend-backend
- Viết và chạy kiểm thử chức năng
- Viết và chạy kiểm thử giao diện
- Viết và chạy kiểm thử hệ thống
- Tổng hợp kết quả kiểm thử
- Viết báo cáo kiểm thử

### 2.4 Tài nguyên cần thiết

#### 2.4.1 Phần cứng
- Máy tính phát triển: Laptop hoặc PC với cấu hình đủ để chạy các công cụ kiểm thử
- Máy chủ kiểm thử: Máy chủ để triển khai môi trường kiểm thử

#### 2.4.2 Phần mềm
- IDE: IntelliJ IDEA, Visual Studio Code
- Công cụ kiểm thử: JUnit, Mockito, Jest, Jasmine, Cypress, Selenium, JMeter, Postman
- Công cụ quản lý phiên bản: Git
- Công cụ quản lý dự án: Jira, Trello

#### 2.4.3 Dữ liệu kiểm thử
- Dữ liệu mẫu cho thuốc, loại thuốc, danh mục thuốc, nhà sản xuất
- Dữ liệu mẫu cho đơn hàng, chi tiết đơn hàng
- Hình ảnh mẫu cho thuốc

### 2.5 Quản lý rủi ro

| Rủi ro | Mức độ ảnh hưởng | Khả năng xảy ra | Biện pháp giảm thiểu |
|--------|-----------------|-----------------|----------------------|
| Thiếu thời gian kiểm thử | Cao | Trung bình | Ưu tiên kiểm thử các chức năng quan trọng, tự động hóa kiểm thử |
| Thiếu dữ liệu kiểm thử | Trung bình | Thấp | Chuẩn bị dữ liệu kiểm thử trước, sử dụng công cụ tạo dữ liệu mẫu |
| Lỗi môi trường kiểm thử | Cao | Thấp | Chuẩn bị môi trường dự phòng, sao lưu dữ liệu kiểm thử |
| Thay đổi yêu cầu | Trung bình | Trung bình | Quản lý thay đổi, cập nhật kế hoạch kiểm thử khi có thay đổi |
| Thiếu nhân lực | Cao | Thấp | Phân công nhiệm vụ hợp lý, ưu tiên kiểm thử các chức năng quan trọng |

## 3. KIỂM THỬ ĐƠN VỊ (UNIT TESTING)

### 3.1 Chuẩn bị môi trường

#### 3.1.1 Cài đặt JUnit và Mockito
```xml
<!-- pom.xml -->
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>4.5.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>4.5.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### 3.1.2 Cài đặt Jest và Jasmine
```bash
# Cài đặt Jest
npm install --save-dev jest @types/jest

# Cài đặt Jasmine
npm install --save-dev jasmine @types/jasmine
```

### 3.2 Kiểm thử Service

#### 3.2.1 Kiểm thử ThuocService
```java
@Test
public void testCreateThuoc_Success() {
    // Arrange
    ThuocDTO thuocDTO = new ThuocDTO();
    thuocDTO.setTenThuoc("Paracetamol 500mg");
    thuocDTO.setMaThuoc("PARA500");
    // Set các thuộc tính khác

    when(thuocRepo.existsByMaThuoc(thuocDTO.getMaThuoc())).thenReturn(false);
    when(thuocRepo.existsByTenThuoc(thuocDTO.getTenThuoc())).thenReturn(false);
    // Mock các phương thức khác

    // Act
    ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertNotNull(response.getData());
    // Kiểm tra các thuộc tính khác

    // Verify
    verify(thuocRepo, times(1)).save(any(Thuoc.class));
}
```

#### 3.2.2 Kiểm thử LoaiThuocService
```java
@Test
public void testGetAllLoaiThuocs_Success() {
    // Arrange
    List<LoaiThuoc> loaiThuocList = new ArrayList<>();
    // Thêm các loại thuốc vào danh sách

    when(loaiThuocRepo.findAll()).thenReturn(loaiThuocList);

    // Act
    ResponseDTO<List<LoaiThuoc>> response = loaiThuocService.getAllLoaiThuocs();

    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertNotNull(response.getData());
    assertEquals(loaiThuocList.size(), response.getData().size());

    // Verify
    verify(loaiThuocRepo, times(1)).findAll();
}
```

### 3.3 Kiểm thử Controller

#### 3.3.1 Kiểm thử ThuocController
```java
@Test
public void testGetById_Success() throws Exception {
    // Arrange
    Integer thuocId = 1;

    Thuoc thuoc = new Thuoc();
    thuoc.setId(thuocId);
    thuoc.setTenThuoc("Paracetamol 500mg");
    // Set các thuộc tính khác

    ResponseDTO<Thuoc> responseDTO = ResponseDTO.<Thuoc>builder()
            .status(200)
            .msg("Thành công")
            .data(thuoc)
            .build();

    when(thuocService.getById(thuocId)).thenReturn(responseDTO);

    // Act & Assert
    mockMvc.perform(get("/thuoc/get")
            .param("id", thuocId.toString())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data.id").value(thuocId))
            .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"));
}
```

### 3.4 Kiểm thử Component

#### 3.4.1 Kiểm thử ThuocComponent
```typescript
it('should load thuoc list on init', () => {
  component.ngOnInit();
  expect(thuocService.getProductLst).toHaveBeenCalled();
  expect(component.productLst.length).toBe(2);
  expect(component.productLst[0].tenThuoc).toBe('Paracetamol 500mg');
  expect(component.productLst[1].tenThuoc).toBe('Vitamin C 500mg');
  expect(component.totalRows).toBe(2);
});
```

### 3.5 Chạy kiểm thử

#### 3.5.1 Chạy kiểm thử Backend
```bash
cd BE
./mvnw test
```

#### 3.5.2 Chạy kiểm thử Frontend
```bash
cd FE
npm test
```

## 4. KIỂM THỬ TÍCH HỢP (INTEGRATION TESTING)

### 4.1 Chuẩn bị môi trường

#### 4.1.1 Cấu hình application-test.properties
```properties
# Cấu hình H2 Database
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Cấu hình Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Cấu hình đường dẫn upload file
app.upload.dir=./uploads/test
```

#### 4.1.2 Chuẩn bị dữ liệu kiểm thử
```sql
-- Dữ liệu mẫu cho danh_muc_thuoc
INSERT INTO danh_muc_thuoc (id, ten_danh_muc, mo_ta) VALUES
(1, 'Thuốc kháng sinh', 'Các loại thuốc kháng sinh'),
(2, 'Thuốc giảm đau', 'Các loại thuốc giảm đau');

-- Dữ liệu mẫu cho loai_thuoc
INSERT INTO loai_thuoc (id, ten_loai, mo_ta, danh_muc_thuoc_id) VALUES
(1, 'Kháng sinh beta-lactam', 'Nhóm kháng sinh beta-lactam', 1),
(2, 'Giảm đau không steroid', 'Nhóm giảm đau không steroid', 2);

-- Dữ liệu mẫu cho thuoc
INSERT INTO thuoc (id, ten_thuoc, ma_thuoc, loai_thuoc_id, nha_san_xuat_id, don_vi, gia_nhap, gia_ban, so_luong_ton, nguong_canh_bao, trang_thai) VALUES
(1, 'Paracetamol 500mg', 'PARA500', 2, 1, 'Viên', 5000, 7000, 100, 20, true),
(2, 'Amoxicillin 500mg', 'AMOX500', 1, 2, 'Viên', 8000, 12000, 50, 10, true);
```

### 4.2 Kiểm thử tích hợp Backend

#### 4.2.1 Tạo class kiểm thử tích hợp
```java
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class ThuocIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ThuocRepo thuocRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetById_Success() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/thuoc/get")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg"))
                .andExpect(jsonPath("$.data.maThuoc").value("PARA500"));
    }

    @Test
    public void testCreate_Success() throws Exception {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setTenThuoc("Vitamin C 1000mg");
        thuocDTO.setMaThuoc("VITC1000");
        thuocDTO.setLoaiThuocId(2);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(10000.0);
        thuocDTO.setGiaBan(15000.0);
        thuocDTO.setSoLuongTon(200);
        thuocDTO.setNguongCanhBao(30);
        thuocDTO.setTrangThai(true);

        // Act & Assert
        mockMvc.perform(post("/thuoc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(thuocDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("Thành công"))
                .andExpect(jsonPath("$.data.tenThuoc").value("Vitamin C 1000mg"))
                .andExpect(jsonPath("$.data.maThuoc").value("VITC1000"));

        // Verify
        Thuoc savedThuoc = thuocRepo.findByMaThuoc("VITC1000");
        assertNotNull(savedThuoc);
        assertEquals("Vitamin C 1000mg", savedThuoc.getTenThuoc());
    }
}
```

### 4.3 Kiểm thử tích hợp Frontend-Backend

#### 4.3.1 Kiểm thử API bằng Postman
1. Tạo collection mới "Quản lý thuốc"
2. Tạo các request:
   - GET /thuoc/get
   - POST /thuoc/search
   - POST /thuoc/create
   - PUT /thuoc/update
   - DELETE /thuoc/delete

3. Viết test script cho request GET /thuoc/get:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response has correct data", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data).to.have.property('tenThuoc');
    pm.expect(jsonData.data).to.have.property('maThuoc');
});
```

#### 4.3.2 Kiểm thử tích hợp Frontend-Backend bằng Cypress
```typescript
describe('Kiểm thử tích hợp Frontend-Backend', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();

    // Chuyển đến trang quản lý thuốc
    cy.visit('/admin/thuoc');
  });

  it('Hiển thị danh sách thuốc từ API', () => {
    // Kiểm tra API được gọi
    cy.intercept('POST', '**/thuoc/search').as('searchThuoc');
    cy.wait('@searchThuoc');

    // Kiểm tra dữ liệu hiển thị
    cy.get('table tbody tr').should('have.length.at.least', 1);
    cy.contains('Paracetamol 500mg').should('be.visible');
  });

  it('Thêm thuốc mới thông qua API', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();

    // Điền thông tin thuốc
    cy.get('input[name="tenThuoc"]').type('Vitamin D3 1000IU');
    cy.get('input[name="maThuoc"]').type('VITD1000');
    // Điền các thông tin khác

    // Intercept API call
    cy.intercept('POST', '**/thuoc/create').as('createThuoc');

    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();

    // Đợi API call hoàn thành
    cy.wait('@createThuoc').then((interception) => {
      expect(interception.response.statusCode).to.equal(200);
      expect(interception.response.body.status).to.equal(200);
      expect(interception.response.body.msg).to.equal('Thành công');
    });

    // Kiểm tra thuốc mới đã được thêm vào danh sách
    cy.contains('Vitamin D3 1000IU').should('be.visible');
  });
});
```

### 4.4 Chạy kiểm thử

#### 4.4.1 Chạy kiểm thử tích hợp Backend
```bash
cd BE
./mvnw test -Dtest=ThuocIntegrationTest
```

#### 4.4.2 Chạy kiểm thử Postman
1. Mở Postman
2. Chọn collection "Quản lý thuốc"
3. Nhấn "Run collection"

#### 4.4.3 Chạy kiểm thử Cypress
```bash
cd FE
npx cypress run --spec "cypress/e2e/integration/*.cy.js"
```

## 5. KIỂM THỬ HỆ THỐNG (SYSTEM TESTING)

### 5.1 Kiểm thử luồng nghiệp vụ (End-to-End Testing)

#### 5.1.1 Luồng thêm thuốc mới
```javascript
describe('Thêm thuốc mới', () => {
  beforeEach(() => {
    // Đăng nhập
    cy.visit('/login');
    cy.get('input[name="username"]').type('admin');
    cy.get('input[name="password"]').type('admin123');
    cy.get('button[type="submit"]').click();

    // Chuyển đến trang quản lý thuốc
    cy.visit('/admin/thuoc');
  });

  it('Thêm thuốc mới thành công', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();

    // Điền thông tin thuốc
    cy.get('input[name="tenThuoc"]').type('Vitamin D3 1000IU');
    cy.get('input[name="maThuoc"]').type('VITD1000');

    // Chọn loại thuốc
    cy.get('select[name="loaiThuocId"]').select('Vitamin và khoáng chất');

    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuatId"]').select('Công ty Dược phẩm ABC');

    // Điền các thông tin khác
    cy.get('input[name="donVi"]').type('Viên');
    cy.get('input[name="giaNhap"]').type('8000');
    cy.get('input[name="giaBan"]').type('12000');
    cy.get('input[name="soLuongTon"]').type('100');
    cy.get('input[name="nguongCanhBao"]').type('20');

    // Điền thông tin mô tả
    cy.get('textarea[name="congDung"]').type('Bổ sung vitamin D3');
    cy.get('textarea[name="huongDanSuDung"]').type('Uống 1 viên mỗi ngày');

    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();

    // Kiểm tra thông báo thành công
    cy.contains('Thành công').should('be.visible');

    // Kiểm tra thuốc mới đã được thêm vào danh sách
    cy.get('input[placeholder="Tìm kiếm..."]').type('Vitamin D3');
    cy.get('button').contains('Tìm kiếm').click();
    cy.contains('Vitamin D3 1000IU').should('be.visible');
  });
});
```

#### 5.1.2 Luồng sửa thông tin thuốc
```javascript
describe('Sửa thông tin thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.visit('/admin/thuoc');
  });

  it('Sửa thông tin thuốc thành công', () => {
    // Tìm kiếm thuốc cần sửa
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();

    // Nhấn nút sửa
    cy.get('button[title="Sửa"]').first().click();

    // Sửa thông tin thuốc
    cy.get('input[name="giaBan"]').clear().type('8000');
    cy.get('textarea[name="congDung"]').clear().type('Giảm đau, hạ sốt, giảm viêm');

    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();

    // Kiểm tra thông báo thành công
    cy.contains('Thành công').should('be.visible');

    // Kiểm tra thông tin đã được cập nhật
    cy.get('button[title="Xem chi tiết"]').first().click();
    cy.contains('8,000đ').should('be.visible');
    cy.contains('Giảm đau, hạ sốt, giảm viêm').should('be.visible');
  });
});
```

#### 5.1.3 Luồng xóa thuốc
```javascript
describe('Xóa thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.visit('/admin/thuoc');
  });

  it('Xóa thuốc thành công', () => {
    // Tìm kiếm thuốc cần xóa
    cy.get('input[placeholder="Tìm kiếm..."]').type('Vitamin D3');
    cy.get('button').contains('Tìm kiếm').click();

    // Lưu số lượng thuốc ban đầu
    cy.get('table tbody tr').then(($rows) => {
      const initialCount = $rows.length;

      // Nhấn nút xóa
      cy.get('button[title="Xóa"]').first().click();

      // Xác nhận xóa
      cy.get('button').contains('Có').click();

      // Kiểm tra thông báo thành công
      cy.contains('Xóa thành công').should('be.visible');

      // Kiểm tra số lượng thuốc đã giảm
      cy.get('table tbody tr').should('have.length', initialCount - 1);
    });
  });
});
```

### 5.2 Kiểm thử hiệu năng (Performance Testing)

#### 5.2.1 Chuẩn bị JMeter Test Plan
1. Tạo Thread Group:
   - Number of Threads (users): 10
   - Ramp-up period (seconds): 5
   - Loop Count: 5

2. Thêm HTTP Request cho API đăng nhập:
   - Method: POST
   - Path: /api/auth/login
   - Body Data: `{"username":"admin","password":"admin123"}`

3. Thêm JSON Extractor để lấy token:
   - Names of created variables: token
   - JSON Path expressions: $.token

4. Thêm HTTP Request cho API lấy danh sách thuốc:
   - Method: POST
   - Path: /thuoc/search
   - Body Data: `{"keyWord":"","currentPage":0,"size":10}`
   - Header: Authorization: Bearer ${token}

5. Thêm Summary Report và View Results Tree

#### 5.2.2 Chạy kiểm thử hiệu năng
1. Chạy JMeter Test Plan
2. Phân tích kết quả:
   - Thời gian phản hồi trung bình
   - Thông lượng (Throughput)
   - Tỷ lệ lỗi (Error Rate)

### 5.3 Kiểm thử tương thích (Compatibility Testing)

#### 5.3.1 Kiểm thử trên các trình duyệt khác nhau
1. Cấu hình BrowserStack:
```json
{
  "browsers": [
    {
      "browser": "chrome",
      "os": "Windows 10",
      "versions": ["latest", "latest-1"]
    },
    {
      "browser": "firefox",
      "os": "Windows 10",
      "versions": ["latest"]
    },
    {
      "browser": "edge",
      "os": "Windows 10",
      "versions": ["latest"]
    },
    {
      "browser": "safari",
      "os": "OS X Monterey",
      "versions": ["latest"]
    }
  ]
}
```

2. Chạy kiểm thử trên các trình duyệt:
```bash
browserstack-cypress run
```

## 6. KIỂM THỬ GIAO DIỆN (UI TESTING)

### 6.1 Kiểm thử giao diện danh sách thuốc

#### 6.1.1 Tạo test case cho giao diện danh sách thuốc
```javascript
describe('Kiểm thử giao diện danh sách thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Hiển thị đúng tiêu đề trang', () => {
    cy.get('h1').should('contain', 'Quản lý thuốc');
  });

  it('Hiển thị đúng các thành phần tìm kiếm', () => {
    // Kiểm tra ô tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').should('be.visible');

    // Kiểm tra dropdown loại thuốc
    cy.get('select[name="loaiThuoc"]').should('be.visible');

    // Kiểm tra dropdown nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').should('be.visible');

    // Kiểm tra nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').should('be.visible');

    // Kiểm tra nút thêm mới
    cy.get('button').contains('Thêm mới').should('be.visible');
  });

  it('Hiển thị đúng cấu trúc bảng danh sách thuốc', () => {
    // Kiểm tra tiêu đề các cột
    cy.get('table thead th').should('have.length.at.least', 6);
    cy.get('table thead th').eq(0).should('contain', 'STT');
    cy.get('table thead th').eq(1).should('contain', 'Mã thuốc');
    cy.get('table thead th').eq(2).should('contain', 'Tên thuốc');
    cy.get('table thead th').eq(3).should('contain', 'Loại thuốc');
    cy.get('table thead th').eq(4).should('contain', 'Giá bán');
    cy.get('table thead th').eq(5).should('contain', 'Số lượng tồn');
    cy.get('table thead th').eq(6).should('contain', 'Thao tác');
  });
});
```

### 6.2 Kiểm thử giao diện thêm/sửa thuốc

#### 6.2.1 Tạo test case cho giao diện thêm/sửa thuốc
```javascript
describe('Kiểm thử giao diện thêm/sửa thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Hiển thị đúng form thêm thuốc', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();

    // Kiểm tra tiêu đề form
    cy.get('.p-dialog-title').should('contain', 'Thêm mới thuốc');

    // Kiểm tra các trường nhập liệu
    cy.get('input[name="tenThuoc"]').should('be.visible').and('be.empty');
    cy.get('input[name="maThuoc"]').should('be.visible').and('be.empty');
    cy.get('select[name="loaiThuocId"]').should('be.visible');
    cy.get('select[name="nhaSanXuatId"]').should('be.visible');
    cy.get('input[name="donVi"]').should('be.visible').and('be.empty');
    cy.get('input[name="giaNhap"]').should('be.visible').and('be.empty');
    cy.get('input[name="giaBan"]').should('be.visible').and('be.empty');
    cy.get('input[name="soLuongTon"]').should('be.visible').and('be.empty');
    cy.get('input[name="nguongCanhBao"]').should('be.visible').and('be.empty');

    // Kiểm tra các nút
    cy.get('button').contains('Lưu').should('be.visible');
    cy.get('button').contains('Hủy').should('be.visible');
  });
});
```

### 6.3 Kiểm thử giao diện chi tiết thuốc

#### 6.3.1 Tạo test case cho giao diện chi tiết thuốc
```javascript
describe('Kiểm thử giao diện chi tiết thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Hiển thị đúng giao diện chi tiết thuốc', () => {
    // Tìm kiếm thuốc
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();

    // Nhấn nút xem chi tiết thuốc đầu tiên
    cy.get('button[title="Xem chi tiết"]').first().click();

    // Kiểm tra tiêu đề dialog
    cy.get('.p-dialog-title').should('contain', 'Chi tiết thuốc');

    // Kiểm tra thông tin cơ bản
    cy.contains('Tên thuốc:').next().should('contain', 'Paracetamol 500mg');
    cy.contains('Mã thuốc:').next().should('contain', 'PARA500');
    cy.contains('Loại thuốc:').next().should('contain', 'Giảm đau không steroid');
    cy.contains('Giá bán:').next().should('contain', '7,000');

    // Kiểm tra nút đóng
    cy.get('button').contains('Đóng').should('be.visible');
  });
});
```

### 6.4 Kiểm thử giao diện tìm kiếm thuốc

#### 6.4.1 Tạo test case cho giao diện tìm kiếm thuốc
```javascript
describe('Kiểm thử giao diện tìm kiếm thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Tìm kiếm thuốc theo tên', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder="Tìm kiếm..."]').clear().type('Paracetamol');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length.at.least', 1);
    cy.contains('Paracetamol 500mg').should('be.visible');
  });

  it('Tìm kiếm thuốc theo loại thuốc', () => {
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length.at.least', 1);
    cy.contains('Giảm đau không steroid').should('be.visible');
  });
});
```

### 6.5 Kiểm thử tính responsive

#### 6.5.1 Tạo test case cho tính responsive
```javascript
describe('Kiểm thử tính responsive của giao diện', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Hiển thị đúng trên màn hình desktop', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);

    // Kiểm tra hiển thị của các thành phần
    cy.get('.search-container').should('be.visible');
    cy.get('table').should('be.visible');
    cy.get('.p-paginator').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình tablet', () => {
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);

    // Kiểm tra hiển thị của các thành phần
    cy.get('.search-container').should('be.visible');
    cy.get('table').should('be.visible');
    cy.get('.p-paginator').should('be.visible');
  });

  it('Hiển thị đúng trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);

    // Kiểm tra hiển thị của các thành phần
    cy.get('.search-container').should('be.visible');
    cy.get('table').should('be.visible');
    cy.get('.p-paginator').should('be.visible');
  });
});
```

## 7. KIỂM THỬ CHỨC NĂNG (FUNCTIONAL TESTING)

### 7.1 Kiểm thử chức năng thêm thuốc

#### 7.1.1 Kiểm thử API thêm thuốc bằng Postman
1. Tạo request thêm thuốc mới:
   - Method: POST
   - URL: {{baseUrl}}/thuoc/create
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (form-data):
     - thuocDTO (file): Chọn file JSON chứa thông tin thuốc
     - file (file): Chọn file hình ảnh thuốc (nếu có)

2. Viết test script:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});

pm.test("Response data has correct thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.tenThuoc).to.eql("Vitamin D3 1000IU");
    pm.expect(jsonData.data.maThuoc).to.eql("VITD1000");
});
```

#### 7.1.2 Kiểm thử chức năng thêm thuốc bằng Cypress
```javascript
describe('Kiểm thử chức năng thêm thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Thêm thuốc mới thành công', () => {
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();

    // Điền thông tin thuốc
    cy.get('input[name="tenThuoc"]').type('Vitamin D3 1000IU');
    cy.get('input[name="maThuoc"]').type('VITD1000');
    cy.get('select[name="loaiThuocId"]').select('Vitamin và khoáng chất');
    cy.get('select[name="nhaSanXuatId"]').select('Công ty Dược phẩm ABC');
    cy.get('input[name="donVi"]').type('Viên');
    cy.get('input[name="giaNhap"]').type('8000');
    cy.get('input[name="giaBan"]').type('12000');
    cy.get('input[name="soLuongTon"]').type('100');
    cy.get('input[name="nguongCanhBao"]').type('20');
    cy.get('textarea[name="congDung"]').type('Bổ sung vitamin D3');
    cy.get('textarea[name="huongDanSuDung"]').type('Uống 1 viên mỗi ngày');

    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();

    // Kiểm tra thông báo thành công
    cy.contains('Thành công').should('be.visible');

    // Kiểm tra thuốc mới đã được thêm vào danh sách
    cy.get('input[placeholder="Tìm kiếm..."]').type('Vitamin D3');
    cy.get('button').contains('Tìm kiếm').click();
    cy.contains('Vitamin D3 1000IU').should('be.visible');
  });
});

### 7.2 Kiểm thử chức năng cập nhật thuốc

#### 7.2.1 Kiểm thử API cập nhật thuốc bằng Postman
1. Tạo request cập nhật thuốc:
   - Method: PUT
   - URL: {{baseUrl}}/thuoc/update
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (form-data):
     - thuocDTO (file): Chọn file JSON chứa thông tin thuốc cần cập nhật
     - file (file): Chọn file hình ảnh thuốc (nếu có)

2. Viết test script:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});

pm.test("Response data has updated thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.giaBan).to.eql(8000);
    pm.expect(jsonData.data.congDung).to.eql("Giảm đau, hạ sốt, giảm viêm");
});
```

#### 7.2.2 Kiểm thử chức năng cập nhật thuốc bằng Cypress
```javascript
describe('Kiểm thử chức năng cập nhật thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Cập nhật thuốc thành công', () => {
    // Tìm kiếm thuốc cần sửa
    cy.get('input[placeholder="Tìm kiếm..."]').type('Paracetamol');
    cy.get('button').contains('Tìm kiếm').click();

    // Nhấn nút sửa
    cy.get('button[title="Sửa"]').first().click();

    // Sửa thông tin thuốc
    cy.get('input[name="giaBan"]').clear().type('8000');
    cy.get('textarea[name="congDung"]').clear().type('Giảm đau, hạ sốt, giảm viêm');

    // Intercept API call
    cy.intercept('PUT', '**/thuoc/update').as('updateThuoc');

    // Nhấn nút lưu
    cy.get('button').contains('Lưu').click();

    // Đợi API call hoàn thành
    cy.wait('@updateThuoc').then((interception) => {
      expect(interception.response.statusCode).to.equal(200);
      expect(interception.response.body.status).to.equal(200);
      expect(interception.response.body.msg).to.equal('Thành công');
    });

    // Kiểm tra thông báo thành công
    cy.contains('Thành công').should('be.visible');

    // Kiểm tra thông tin đã được cập nhật
    cy.get('button[title="Xem chi tiết"]').first().click();
    cy.contains('8,000đ').should('be.visible');
    cy.contains('Giảm đau, hạ sốt, giảm viêm').should('be.visible');
  });
});
```

### 7.3 Kiểm thử chức năng xóa thuốc

#### 7.3.1 Kiểm thử API xóa thuốc bằng Postman
1. Tạo request xóa thuốc:
   - Method: DELETE
   - URL: {{baseUrl}}/thuoc/delete?id={{thuocId}}
   - Headers:
     - Authorization: Bearer {{token}}

2. Viết test script:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});
```

#### 7.3.2 Kiểm thử chức năng xóa thuốc bằng Cypress
```javascript
describe('Kiểm thử chức năng xóa thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Xóa thuốc thành công', () => {
    // Tìm kiếm thuốc cần xóa
    cy.get('input[placeholder="Tìm kiếm..."]').type('Vitamin D3');
    cy.get('button').contains('Tìm kiếm').click();

    // Lưu số lượng thuốc ban đầu
    cy.get('table tbody tr').then(($rows) => {
      const initialCount = $rows.length;

      // Intercept API call
      cy.intercept('DELETE', '**/thuoc/delete*').as('deleteThuoc');

      // Nhấn nút xóa
      cy.get('button[title="Xóa"]').first().click();

      // Xác nhận xóa
      cy.get('button').contains('Có').click();

      // Đợi API call hoàn thành
      cy.wait('@deleteThuoc').then((interception) => {
        expect(interception.response.statusCode).to.equal(200);
        expect(interception.response.body.status).to.equal(200);
        expect(interception.response.body.msg).to.equal('Thành công');
      });

      // Kiểm tra thông báo thành công
      cy.contains('Xóa thành công').should('be.visible');

      // Kiểm tra số lượng thuốc đã giảm
      cy.get('table tbody tr').should('have.length', initialCount - 1);
    });
  });
});
```

### 7.4 Kiểm thử chức năng tìm kiếm thuốc

#### 7.4.1 Kiểm thử API tìm kiếm thuốc bằng Postman
1. Tạo request tìm kiếm thuốc:
   - Method: POST
   - URL: {{baseUrl}}/thuoc/search
   - Headers:
     - Authorization: Bearer {{token}}
     - Content-Type: application/json
   - Body (raw, JSON):
     ```json
     {
       "keyWord": "Paracetamol",
       "loaiThuoc": "",
       "nhaSanXuat": "",
       "danhMucThuoc": "",
       "minGiaBan": null,
       "maxGiaBan": null,
       "tenDoiTuong": null,
       "trangThai": true,
       "currentPage": 0,
       "size": 10,
       "sortedField": "id"
     }
     ```

2. Viết test script:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});

pm.test("Response contains thuoc with name 'Paracetamol'", function () {
    var jsonData = pm.response.json();
    var found = false;

    if (jsonData.data.data.length > 0) {
        for (var i = 0; i < jsonData.data.data.length; i++) {
            if (jsonData.data.data[i].tenThuoc.includes("Paracetamol")) {
                found = true;
                break;
            }
        }
    }

    pm.expect(found).to.be.true;
});
```

#### 7.4.2 Kiểm thử chức năng tìm kiếm thuốc bằng Cypress
```javascript
describe('Kiểm thử chức năng tìm kiếm thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
  });

  it('Tìm kiếm thuốc theo tên', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder="Tìm kiếm..."]').clear().type('Paracetamol');

    // Intercept API call
    cy.intercept('POST', '**/thuoc/search').as('searchThuoc');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Đợi API call hoàn thành
    cy.wait('@searchThuoc').then((interception) => {
      expect(interception.response.statusCode).to.equal(200);
      expect(interception.response.body.status).to.equal(200);
    });

    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length.at.least', 1);
    cy.contains('Paracetamol 500mg').should('be.visible');
  });

  it('Tìm kiếm thuốc theo loại thuốc', () => {
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');

    // Intercept API call
    cy.intercept('POST', '**/thuoc/search').as('searchThuoc');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Đợi API call hoàn thành
    cy.wait('@searchThuoc');

    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length.at.least', 1);
    cy.contains('Giảm đau không steroid').should('be.visible');
  });

  it('Tìm kiếm thuốc với nhiều tiêu chí', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder="Tìm kiếm..."]').clear().type('Paracetamol');

    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');

    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').select('Công ty Dược phẩm ABC');

    // Intercept API call
    cy.intercept('POST', '**/thuoc/search').as('searchThuoc');

    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();

    // Đợi API call hoàn thành
    cy.wait('@searchThuoc');

    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length.at.least', 1);
    cy.contains('Paracetamol 500mg').should('be.visible');
    cy.contains('Giảm đau không steroid').should('be.visible');
    cy.contains('Công ty Dược phẩm ABC').should('be.visible');
  });
});
```

## 8. TEST CASE CHI TIẾT

### 8.1 Test case thêm thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_ADD_THUOC_001 | Thêm thuốc với đầy đủ thông tin hợp lệ | Kiểm tra chức năng thêm thuốc với đầy đủ thông tin hợp lệ | Đã đăng nhập với quyền admin | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập đầy đủ thông tin hợp lệ<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Thuốc mới được thêm vào danh sách |
| TC_ADD_THUOC_002 | Thêm thuốc với mã thuốc đã tồn tại | Kiểm tra validation khi thêm thuốc với mã thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có mã "PARA500" | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập mã thuốc "PARA500"<br>4. Nhập các thông tin khác hợp lệ<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Mã thuốc đã tồn tại"<br>2. Không thêm thuốc mới vào danh sách |
| TC_ADD_THUOC_003 | Thêm thuốc với tên thuốc đã tồn tại | Kiểm tra validation khi thêm thuốc với tên thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có tên "Paracetamol 500mg" | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập tên thuốc "Paracetamol 500mg"<br>4. Nhập các thông tin khác hợp lệ<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Tên thuốc đã tồn tại"<br>2. Không thêm thuốc mới vào danh sách |
| TC_ADD_THUOC_004 | Thêm thuốc với thông tin bắt buộc bị thiếu | Kiểm tra validation khi thêm thuốc với thông tin bắt buộc bị thiếu | Đã đăng nhập với quyền admin | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Bỏ trống một số trường bắt buộc<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi cho các trường bắt buộc bị thiếu<br>2. Không thêm thuốc mới vào danh sách |
| TC_ADD_THUOC_005 | Thêm thuốc với giá bán nhỏ hơn giá nhập | Kiểm tra validation khi thêm thuốc với giá bán nhỏ hơn giá nhập | Đã đăng nhập với quyền admin | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập giá nhập > giá bán<br>4. Nhập các thông tin khác hợp lệ<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Giá bán phải lớn hơn hoặc bằng giá nhập"<br>2. Không thêm thuốc mới vào danh sách |

### 8.2 Test case sửa thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_UPDATE_THUOC_001 | Cập nhật thuốc với đầy đủ thông tin hợp lệ | Kiểm tra chức năng cập nhật thuốc với đầy đủ thông tin hợp lệ | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Thông tin thuốc được cập nhật trong danh sách |
| TC_UPDATE_THUOC_002 | Cập nhật thuốc với mã thuốc đã tồn tại | Kiểm tra validation khi cập nhật thuốc với mã thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật<br>Đã tồn tại thuốc khác có mã "AMOX500" | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật mã thuốc thành "AMOX500"<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Mã thuốc đã tồn tại"<br>2. Thông tin thuốc không được cập nhật |
| TC_UPDATE_THUOC_003 | Cập nhật thuốc với tên thuốc đã tồn tại | Kiểm tra validation khi cập nhật thuốc với tên thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật<br>Đã tồn tại thuốc khác có tên "Amoxicillin 500mg" | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật tên thuốc thành "Amoxicillin 500mg"<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Tên thuốc đã tồn tại"<br>2. Thông tin thuốc không được cập nhật |
| TC_UPDATE_THUOC_004 | Cập nhật thuốc với thông tin bắt buộc bị thiếu | Kiểm tra validation khi cập nhật thuốc với thông tin bắt buộc bị thiếu | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Xóa thông tin ở một số trường bắt buộc<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi cho các trường bắt buộc bị thiếu<br>2. Thông tin thuốc không được cập nhật |
| TC_UPDATE_THUOC_005 | Cập nhật thuốc không tồn tại | Kiểm tra xử lý khi cập nhật thuốc không tồn tại | Đã đăng nhập với quyền admin | 1. Gửi request API cập nhật thuốc với ID không tồn tại | 1. Nhận response với status 404<br>2. Thông báo "Không tìm thấy thuốc" |

### 8.3 Test case xóa thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_DELETE_THUOC_001 | Xóa thuốc tồn tại | Kiểm tra chức năng xóa thuốc tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần xóa | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo "Xóa thành công"<br>2. Thuốc bị xóa khỏi danh sách |
| TC_DELETE_THUOC_002 | Xóa thuốc không tồn tại | Kiểm tra xử lý khi xóa thuốc không tồn tại | Đã đăng nhập với quyền admin | 1. Gửi request API xóa thuốc với ID không tồn tại | 1. Nhận response với status 200<br>2. Thông báo "Thành công" |
| TC_DELETE_THUOC_003 | Xóa thuốc đã có trong đơn hàng | Kiểm tra xử lý khi xóa thuốc đã có trong đơn hàng | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần xóa<br>Thuốc đã có trong đơn hàng | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo lỗi "Không thể xóa thuốc đã có trong đơn hàng"<br>2. Thuốc không bị xóa khỏi danh sách |

### 8.4 Test case tìm kiếm thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_SEARCH_THUOC_001 | Tìm kiếm thuốc theo tên | Kiểm tra chức năng tìm kiếm thuốc theo tên | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có tên chứa "Paracetamol" | 1. Mở trang quản lý thuốc<br>2. Nhập "Paracetamol" vào ô tìm kiếm<br>3. Nhấn nút "Tìm kiếm" | 1. Hiển thị danh sách thuốc có tên chứa "Paracetamol"<br>2. Không hiển thị các thuốc khác |
| TC_SEARCH_THUOC_002 | Tìm kiếm thuốc theo mã | Kiểm tra chức năng tìm kiếm thuốc theo mã | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có mã "PARA500" | 1. Mở trang quản lý thuốc<br>2. Nhập "PARA500" vào ô tìm kiếm<br>3. Nhấn nút "Tìm kiếm" | 1. Hiển thị thuốc có mã "PARA500"<br>2. Không hiển thị các thuốc khác |
| TC_SEARCH_THUOC_003 | Tìm kiếm thuốc theo loại thuốc | Kiểm tra chức năng tìm kiếm thuốc theo loại thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc thuộc loại "Giảm đau không steroid" | 1. Mở trang quản lý thuốc<br>2. Chọn "Giảm đau không steroid" trong dropdown loại thuốc<br>3. Nhấn nút "Tìm kiếm" | 1. Hiển thị danh sách thuốc thuộc loại "Giảm đau không steroid"<br>2. Không hiển thị các thuốc khác |
| TC_SEARCH_THUOC_004 | Tìm kiếm thuốc theo nhà sản xuất | Kiểm tra chức năng tìm kiếm thuốc theo nhà sản xuất | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc của nhà sản xuất "Công ty Dược phẩm ABC" | 1. Mở trang quản lý thuốc<br>2. Chọn "Công ty Dược phẩm ABC" trong dropdown nhà sản xuất<br>3. Nhấn nút "Tìm kiếm" | 1. Hiển thị danh sách thuốc của nhà sản xuất "Công ty Dược phẩm ABC"<br>2. Không hiển thị các thuốc khác |
| TC_SEARCH_THUOC_005 | Tìm kiếm thuốc theo khoảng giá | Kiểm tra chức năng tìm kiếm thuốc theo khoảng giá | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có giá bán từ 5000 đến 10000 | 1. Mở trang quản lý thuốc<br>2. Nhập "5000" vào ô giá bán từ<br>3. Nhập "10000" vào ô giá bán đến<br>4. Nhấn nút "Tìm kiếm" | 1. Hiển thị danh sách thuốc có giá bán từ 5000 đến 10000<br>2. Không hiển thị các thuốc khác |

### 8.5 Test case quản lý loại thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_LOAI_THUOC_001 | Thêm loại thuốc mới | Kiểm tra chức năng thêm loại thuốc mới | Đã đăng nhập với quyền admin | 1. Mở trang quản lý loại thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập thông tin loại thuốc<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Loại thuốc mới được thêm vào danh sách |
| TC_LOAI_THUOC_002 | Sửa loại thuốc | Kiểm tra chức năng sửa loại thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại loại thuốc cần sửa | 1. Mở trang quản lý loại thuốc<br>2. Tìm kiếm loại thuốc cần sửa<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Thông tin loại thuốc được cập nhật trong danh sách |
| TC_LOAI_THUOC_003 | Xóa loại thuốc | Kiểm tra chức năng xóa loại thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại loại thuốc cần xóa<br>Loại thuốc chưa được sử dụng | 1. Mở trang quản lý loại thuốc<br>2. Tìm kiếm loại thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo "Xóa thành công"<br>2. Loại thuốc bị xóa khỏi danh sách |
| TC_LOAI_THUOC_004 | Xóa loại thuốc đã được sử dụng | Kiểm tra xử lý khi xóa loại thuốc đã được sử dụng | Đã đăng nhập với quyền admin<br>Đã tồn tại loại thuốc cần xóa<br>Loại thuốc đã được sử dụng | 1. Mở trang quản lý loại thuốc<br>2. Tìm kiếm loại thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo lỗi "Không thể xóa loại thuốc đã được sử dụng"<br>2. Loại thuốc không bị xóa khỏi danh sách |
| TC_LOAI_THUOC_005 | Tìm kiếm loại thuốc | Kiểm tra chức năng tìm kiếm loại thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại loại thuốc cần tìm | 1. Mở trang quản lý loại thuốc<br>2. Nhập từ khóa tìm kiếm<br>3. Nhấn nút "Tìm kiếm" | 1. Hiển thị danh sách loại thuốc phù hợp với từ khóa<br>2. Không hiển thị các loại thuốc khác |

### 8.6 Test case quản lý danh mục thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_DANH_MUC_THUOC_001 | Thêm danh mục thuốc mới | Kiểm tra chức năng thêm danh mục thuốc mới | Đã đăng nhập với quyền admin | 1. Mở trang quản lý danh mục thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập thông tin danh mục thuốc<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Danh mục thuốc mới được thêm vào danh sách |
| TC_DANH_MUC_THUOC_002 | Sửa danh mục thuốc | Kiểm tra chức năng sửa danh mục thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại danh mục thuốc cần sửa | 1. Mở trang quản lý danh mục thuốc<br>2. Tìm kiếm danh mục thuốc cần sửa<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Thông tin danh mục thuốc được cập nhật trong danh sách |
| TC_DANH_MUC_THUOC_003 | Xóa danh mục thuốc | Kiểm tra chức năng xóa danh mục thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại danh mục thuốc cần xóa<br>Danh mục thuốc chưa được sử dụng | 1. Mở trang quản lý danh mục thuốc<br>2. Tìm kiếm danh mục thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo "Xóa thành công"<br>2. Danh mục thuốc bị xóa khỏi danh sách |
| TC_DANH_MUC_THUOC_004 | Xóa danh mục thuốc đã được sử dụng | Kiểm tra xử lý khi xóa danh mục thuốc đã được sử dụng | Đã đăng nhập với quyền admin<br>Đã tồn tại danh mục thuốc cần xóa<br>Danh mục thuốc đã được sử dụng | 1. Mở trang quản lý danh mục thuốc<br>2. Tìm kiếm danh mục thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo lỗi "Không thể xóa danh mục thuốc đã được sử dụng"<br>2. Danh mục thuốc không bị xóa khỏi danh sách |
| TC_DANH_MUC_THUOC_005 | Tìm kiếm danh mục thuốc | Kiểm tra chức năng tìm kiếm danh mục thuốc | Đã đăng nhập với quyền admin<br>Đã tồn tại danh mục thuốc cần tìm | 1. Mở trang quản lý danh mục thuốc<br>2. Nhập từ khóa tìm kiếm<br>3. Nhấn nút "Tìm kiếm" | 1. Hiển thị danh sách danh mục thuốc phù hợp với từ khóa<br>2. Không hiển thị các danh mục thuốc khác |

## 9. BÁO CÁO KẾT QUẢ KIỂM THỬ

### 9.1 Tổng hợp kết quả

| Loại kiểm thử | Số lượng test case | Số lượng pass | Số lượng fail | Tỷ lệ pass |
|---------------|-------------------|--------------|--------------|------------|
| Kiểm thử đơn vị | 15 | 15 | 0 | 100% |
| Kiểm thử tích hợp | 10 | 9 | 1 | 90% |
| Kiểm thử giao diện | 8 | 7 | 1 | 87.5% |
| Kiểm thử chức năng | 20 | 18 | 2 | 90% |
| **Tổng cộng** | **53** | **49** | **4** | **92.5%** |

### 9.2 Phân tích lỗi

| ID | Mô tả lỗi | Nguyên nhân | Mức độ nghiêm trọng | Giải pháp đề xuất |
|----|-----------|------------|---------------------|-------------------|
| IT_010 | Lỗi khi xóa thuốc đã có trong đơn hàng | Chưa kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa | Cao | Thêm kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa và hiển thị thông báo phù hợp |
| UI_008 | Giao diện bị lỗi trên mobile | Chưa tối ưu hóa responsive cho màn hình nhỏ | Trung bình | Cập nhật CSS để tối ưu hóa hiển thị trên màn hình nhỏ |
| TC_DELETE_THUOC_003 | Lỗi khi xóa thuốc đã có trong đơn hàng | Chưa kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa | Cao | Thêm kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa và hiển thị thông báo phù hợp |
| TC_SEARCH_THUOC_007 | Hiển thị thông báo không phù hợp khi không tìm thấy kết quả | Chưa xử lý trường hợp không tìm thấy kết quả | Thấp | Cập nhật hiển thị thông báo phù hợp khi không tìm thấy kết quả |

### 9.3 Đề xuất cải tiến

#### 9.3.1 Cải tiến chức năng

1. **Xử lý xóa thuốc đã có trong đơn hàng**:
   - Thêm kiểm tra thuốc có tồn tại trong đơn hàng trước khi xóa
   - Hiển thị thông báo phù hợp khi không thể xóa thuốc đã có trong đơn hàng
   - Cân nhắc thêm chức năng vô hiệu hóa thuốc thay vì xóa hoàn toàn

2. **Cải thiện tìm kiếm thuốc**:
   - Thêm tìm kiếm theo thành phần thuốc
   - Thêm tìm kiếm theo công dụng
   - Cải thiện hiển thị kết quả tìm kiếm khi không tìm thấy

3. **Thêm chức năng quản lý thuốc hết hạn**:
   - Thêm cảnh báo thuốc sắp hết hạn
   - Thêm danh sách thuốc đã hết hạn
   - Thêm chức năng xử lý thuốc hết hạn

#### 9.3.2 Cải tiến giao diện

1. **Tối ưu hóa responsive**:
   - Cập nhật CSS để tối ưu hóa hiển thị trên màn hình nhỏ
   - Thêm chế độ xem compact cho màn hình nhỏ

2. **Cải thiện trải nghiệm người dùng**:
   - Thêm preview hình ảnh thuốc khi thêm/sửa
   - Cải thiện form thêm/sửa thuốc với các trường thông tin được nhóm lại
   - Thêm chức năng drag-and-drop để upload hình ảnh

#### 9.3.3 Cải tiến kiểm thử

1. **Tăng độ bao phủ kiểm thử**:
   - Thêm kiểm thử cho các trường hợp ngoại lệ
   - Thêm kiểm thử cho các trường hợp biên

2. **Tự động hóa kiểm thử**:
   - Tích hợp kiểm thử tự động vào quy trình CI/CD
   - Thêm kiểm thử end-to-end với Cypress hoặc Selenium

## 10. KẾT LUẬN

Qua quá trình kiểm thử chức năng Quản lý thuốc, chúng tôi đã phát hiện và ghi nhận 4 lỗi trong tổng số 53 test case, đạt tỷ lệ pass là 92.5%. Các lỗi chủ yếu liên quan đến việc xóa thuốc đã có trong đơn hàng và hiển thị giao diện trên thiết bị di động.

Chức năng Quản lý thuốc đã đáp ứng được hầu hết các yêu cầu đề ra, tuy nhiên vẫn cần cải tiến một số điểm để tăng tính ổn định và trải nghiệm người dùng. Các đề xuất cải tiến đã được nêu trong báo cáo này.

Chúng tôi đề xuất tiếp tục phát triển và cải tiến chức năng Quản lý thuốc theo các đề xuất đã nêu, đồng thời tăng cường kiểm thử tự động để đảm bảo chất lượng phần mềm.

Việc triển khai đầy đủ các loại kiểm thử (đơn vị, tích hợp, hệ thống, giao diện, chức năng) đã giúp phát hiện và khắc phục các lỗi ở nhiều cấp độ khác nhau, từ đó nâng cao chất lượng tổng thể của chức năng Quản lý thuốc.

### 8.1 Test case thêm thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_ADD_THUOC_001 | Thêm thuốc với đầy đủ thông tin hợp lệ | Kiểm tra chức năng thêm thuốc với đầy đủ thông tin hợp lệ | Đã đăng nhập với quyền admin | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập đầy đủ thông tin hợp lệ<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Thuốc mới được thêm vào danh sách |
| TC_ADD_THUOC_002 | Thêm thuốc với mã thuốc đã tồn tại | Kiểm tra validation khi thêm thuốc với mã thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có mã "PARA500" | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập mã thuốc "PARA500"<br>4. Nhập các thông tin khác hợp lệ<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Mã thuốc đã tồn tại"<br>2. Không thêm thuốc mới vào danh sách |
| TC_ADD_THUOC_003 | Thêm thuốc với tên thuốc đã tồn tại | Kiểm tra validation khi thêm thuốc với tên thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc có tên "Paracetamol 500mg" | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập tên thuốc "Paracetamol 500mg"<br>4. Nhập các thông tin khác hợp lệ<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Tên thuốc đã tồn tại"<br>2. Không thêm thuốc mới vào danh sách |
| TC_ADD_THUOC_004 | Thêm thuốc với thông tin bắt buộc bị thiếu | Kiểm tra validation khi thêm thuốc với thông tin bắt buộc bị thiếu | Đã đăng nhập với quyền admin | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Bỏ trống một số trường bắt buộc<br>4. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi cho các trường bắt buộc bị thiếu<br>2. Không thêm thuốc mới vào danh sách |
| TC_ADD_THUOC_005 | Thêm thuốc với giá bán nhỏ hơn giá nhập | Kiểm tra validation khi thêm thuốc với giá bán nhỏ hơn giá nhập | Đã đăng nhập với quyền admin | 1. Mở trang quản lý thuốc<br>2. Nhấn nút "Thêm mới"<br>3. Nhập giá nhập > giá bán<br>4. Nhập các thông tin khác hợp lệ<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Giá bán phải lớn hơn hoặc bằng giá nhập"<br>2. Không thêm thuốc mới vào danh sách |

### 8.2 Test case sửa thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_UPDATE_THUOC_001 | Cập nhật thuốc với đầy đủ thông tin hợp lệ | Kiểm tra chức năng cập nhật thuốc với đầy đủ thông tin hợp lệ | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật thông tin<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo "Thành công"<br>2. Thông tin thuốc được cập nhật trong danh sách |
| TC_UPDATE_THUOC_002 | Cập nhật thuốc với mã thuốc đã tồn tại | Kiểm tra validation khi cập nhật thuốc với mã thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật<br>Đã tồn tại thuốc khác có mã "AMOX500" | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật mã thuốc thành "AMOX500"<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Mã thuốc đã tồn tại"<br>2. Thông tin thuốc không được cập nhật |
| TC_UPDATE_THUOC_003 | Cập nhật thuốc với tên thuốc đã tồn tại | Kiểm tra validation khi cập nhật thuốc với tên thuốc đã tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật<br>Đã tồn tại thuốc khác có tên "Amoxicillin 500mg" | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Cập nhật tên thuốc thành "Amoxicillin 500mg"<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi "Tên thuốc đã tồn tại"<br>2. Thông tin thuốc không được cập nhật |
| TC_UPDATE_THUOC_004 | Cập nhật thuốc với thông tin bắt buộc bị thiếu | Kiểm tra validation khi cập nhật thuốc với thông tin bắt buộc bị thiếu | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần cập nhật | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần cập nhật<br>3. Nhấn nút "Sửa"<br>4. Xóa thông tin ở một số trường bắt buộc<br>5. Nhấn nút "Lưu" | 1. Hiển thị thông báo lỗi cho các trường bắt buộc bị thiếu<br>2. Thông tin thuốc không được cập nhật |
| TC_UPDATE_THUOC_005 | Cập nhật thuốc không tồn tại | Kiểm tra xử lý khi cập nhật thuốc không tồn tại | Đã đăng nhập với quyền admin | 1. Gửi request API cập nhật thuốc với ID không tồn tại | 1. Nhận response với status 404<br>2. Thông báo "Không tìm thấy thuốc" |

### 8.3 Test case xóa thuốc

| ID | Tên test case | Mô tả | Điều kiện tiên quyết | Các bước thực hiện | Kết quả mong đợi |
|----|--------------|-------|---------------------|-------------------|------------------|
| TC_DELETE_THUOC_001 | Xóa thuốc tồn tại | Kiểm tra chức năng xóa thuốc tồn tại | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần xóa | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo "Xóa thành công"<br>2. Thuốc bị xóa khỏi danh sách |
| TC_DELETE_THUOC_002 | Xóa thuốc không tồn tại | Kiểm tra xử lý khi xóa thuốc không tồn tại | Đã đăng nhập với quyền admin | 1. Gửi request API xóa thuốc với ID không tồn tại | 1. Nhận response với status 200<br>2. Thông báo "Thành công" |
| TC_DELETE_THUOC_003 | Xóa thuốc đã có trong đơn hàng | Kiểm tra xử lý khi xóa thuốc đã có trong đơn hàng | Đã đăng nhập với quyền admin<br>Đã tồn tại thuốc cần xóa<br>Thuốc đã có trong đơn hàng | 1. Mở trang quản lý thuốc<br>2. Tìm kiếm thuốc cần xóa<br>3. Nhấn nút "Xóa"<br>4. Xác nhận xóa | 1. Hiển thị thông báo lỗi "Không thể xóa thuốc đã có trong đơn hàng"<br>2. Thuốc không bị xóa khỏi danh sách |
