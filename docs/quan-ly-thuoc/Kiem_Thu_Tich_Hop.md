# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ TÍCH HỢP (INTEGRATION TESTING)
## CHỨC NĂNG QUẢN LÝ THUỐC

## 1. GIỚI THIỆU

### 1.1 Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử tích hợp cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

### 1.2 Phạm vi
Tài liệu bao gồm hướng dẫn kiểm thử tích hợp cho:
- Tích hợp giữa các thành phần backend (Controller, Service, Repository)
- Tích hợp giữa frontend và backend thông qua API
- Tích hợp với các dịch vụ liên quan (UploadImageService, ChiTietDonHangService, v.v.)

### 1.3 Công cụ và môi trường
- Backend: Spring Boot Test, TestRestTemplate, MockMvc
- Frontend: Angular HttpClientTestingModule, Jasmine, Karma
- API Testing: Postman, REST Assured
- Cơ sở dữ liệu: H2 Database (in-memory database)
- IDE: IntelliJ IDEA, Visual Studio Code

## 2. KIỂM THỬ TÍCH HỢP BACKEND

### 2.1 Cấu trúc thư mục kiểm thử
```
BE/src/test/java/com/example/hieuthuoc/
├── integration/
│   ├── ThuocIntegrationTest.java
│   ├── LoaiThuocIntegrationTest.java
│   └── DanhMucThuocIntegrationTest.java
└── resources/
    ├── application-test.properties
    └── data-test.sql
```

### 2.2 Cấu hình môi trường kiểm thử

#### 2.2.1 Cấu hình application-test.properties
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

#### 2.2.2 Chuẩn bị dữ liệu kiểm thử (data-test.sql)
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

### 2.3 Kiểm thử tích hợp Controller-Service-Repository

#### 2.3.1 Tạo class kiểm thử tích hợp
```java
package com.example.hieuthuoc.integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.ThuocRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    
    // Các phương thức test
}
```

#### 2.3.2 Viết test case cho các API
1. Test API getById:
```java
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
```

2. Test API search:
```java
@Test
public void testSearch_Success() throws Exception {
    // Arrange
    SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
    searchThuocDTO.setKeyWord("Paracetamol");
    searchThuocDTO.setCurrentPage(0);
    searchThuocDTO.setSize(10);
    
    // Act & Assert
    mockMvc.perform(post("/thuoc/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data.data[0].tenThuoc").value("Paracetamol 500mg"));
}
```

3. Test API create:
```java
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
```

4. Test API update:
```java
@Test
public void testUpdate_Success() throws Exception {
    // Arrange
    ThuocDTO thuocDTO = new ThuocDTO();
    thuocDTO.setId(1);
    thuocDTO.setTenThuoc("Paracetamol 500mg Updated");
    thuocDTO.setMaThuoc("PARA500");
    thuocDTO.setLoaiThuocId(2);
    thuocDTO.setNhaSanXuatId(1);
    thuocDTO.setDonVi("Viên");
    thuocDTO.setGiaNhap(6000.0);
    thuocDTO.setGiaBan(9000.0);
    thuocDTO.setSoLuongTon(150);
    thuocDTO.setNguongCanhBao(25);
    thuocDTO.setTrangThai(true);
    
    // Act & Assert
    mockMvc.perform(put("/thuoc/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(thuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data.tenThuoc").value("Paracetamol 500mg Updated"));
    
    // Verify
    Thuoc updatedThuoc = thuocRepo.findById(1).orElse(null);
    assertNotNull(updatedThuoc);
    assertEquals("Paracetamol 500mg Updated", updatedThuoc.getTenThuoc());
    assertEquals(9000.0, updatedThuoc.getGiaBan());
}
```

5. Test API delete:
```java
@Test
public void testDelete_Success() throws Exception {
    // Act & Assert
    mockMvc.perform(delete("/thuoc/delete")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"));
    
    // Verify
    assertFalse(thuocRepo.existsById(1));
}
```

### 2.4 Kiểm thử tích hợp với các dịch vụ liên quan

#### 2.4.1 Kiểm thử tích hợp với UploadImageService
```java
@Test
public void testCreateWithImage_Success() throws Exception {
    // Arrange
    MockMultipartFile file = new MockMultipartFile(
        "file", 
        "test-image.jpg",
        MediaType.IMAGE_JPEG_VALUE,
        "test image content".getBytes()
    );
    
    MockMultipartFile thuocDTOPart = new MockMultipartFile(
        "thuocDTO",
        "",
        MediaType.APPLICATION_JSON_VALUE,
        objectMapper.writeValueAsString(createSampleThuocDTO()).getBytes()
    );
    
    // Act & Assert
    mockMvc.perform(multipart("/thuoc/create")
            .file(file)
            .file(thuocDTOPart))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data.avatar").isNotEmpty());
    
    // Verify
    Thuoc savedThuoc = thuocRepo.findByMaThuoc("VITC1000");
    assertNotNull(savedThuoc);
    assertNotNull(savedThuoc.getAvatar());
}

private ThuocDTO createSampleThuocDTO() {
    ThuocDTO thuocDTO = new ThuocDTO();
    thuocDTO.setTenThuoc("Vitamin C 1000mg");
    thuocDTO.setMaThuoc("VITC1000");
    // Set các thuộc tính khác
    return thuocDTO;
}
```

#### 2.4.2 Kiểm thử tích hợp với ChiTietDonHangService
```java
@Test
public void testDeleteThuocInDonHang_Failure() throws Exception {
    // Arrange
    // Tạo đơn hàng và chi tiết đơn hàng có chứa thuốc ID = 1
    // ...
    
    // Act & Assert
    mockMvc.perform(delete("/thuoc/delete")
            .param("id", "1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.msg").value("Không thể xóa thuốc đã có trong đơn hàng"));
    
    // Verify
    assertTrue(thuocRepo.existsById(1));
}
```

### 2.5 Chạy kiểm thử
1. Chạy kiểm thử bằng Maven:
```bash
cd BE
./mvnw test -Dtest=ThuocIntegrationTest
```

2. Chạy kiểm thử trong IDE:
   - IntelliJ IDEA: Chuột phải vào class test > Run 'ThuocIntegrationTest'
   - Eclipse: Chuột phải vào class test > Run As > JUnit Test

## 3. KIỂM THỬ TÍCH HỢP FRONTEND-BACKEND

### 3.1 Kiểm thử API bằng Postman

#### 3.1.1 Chuẩn bị collection Postman
1. Tạo collection mới "Quản lý thuốc"
2. Tạo các request:
   - GET /thuoc/get
   - POST /thuoc/search
   - POST /thuoc/create
   - PUT /thuoc/update
   - DELETE /thuoc/delete
   - POST /thuoc/get_thuoc_ban_chay

#### 3.1.2 Viết test script cho các request
1. Test script cho GET /thuoc/get:
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

2. Test script cho POST /thuoc/search:
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response has correct data structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('data');
    pm.expect(jsonData.data).to.have.property('totalElements');
    pm.expect(jsonData.data).to.have.property('totalPages');
    pm.expect(jsonData.data).to.have.property('currentPage');
});

pm.test("Response data is an array", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data.data).to.be.an('array');
});
```

#### 3.1.3 Chạy kiểm thử Postman
1. Chạy từng request riêng lẻ
2. Chạy toàn bộ collection
3. Xuất báo cáo kiểm thử

### 3.2 Kiểm thử tích hợp Frontend-Backend

#### 3.2.1 Tạo class kiểm thử tích hợp
```typescript
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { environment } from 'src/environments/environment';

import { ThuocComponent } from './thuoc.component';
import { ThuocService } from 'src/app/_service/thuoc.service';
// Import các service và component cần thiết khác

describe('ThuocComponent Integration Test', () => {
  let component: ThuocComponent;
  let fixture: ComponentFixture<ThuocComponent>;
  let httpMock: HttpTestingController;
  
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ThuocComponent],
      imports: [
        HttpClientTestingModule,
        FormsModule,
        RouterTestingModule
      ],
      providers: [
        ThuocService
        // Provide các service khác
      ]
    }).compileComponents();
    
    fixture = TestBed.createComponent(ThuocComponent);
    component = fixture.componentInstance;
    httpMock = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });
  
  afterEach(() => {
    httpMock.verify();
  });
  
  // Các phương thức test
});
```

#### 3.2.2 Viết test case cho các API call
1. Test API getProductLst:
```typescript
it('should fetch thuoc list from API', () => {
  // Arrange
  const mockResponse = {
    status: '200',
    msg: 'Thành công',
    data: {
      data: [
        { id: '1', tenThuoc: 'Paracetamol 500mg', maThuoc: 'PARA500' },
        { id: '2', tenThuoc: 'Vitamin C 500mg', maThuoc: 'VITC500' }
      ],
      totalElements: 2,
      totalPages: 1,
      currentPage: 0
    }
  };
  
  // Act
  component.getData();
  
  // Assert
  const req = httpMock.expectOne(`${environment.backApiUrl}/thuoc/search`);
  expect(req.request.method).toBe('POST');
  req.flush(mockResponse);
  
  expect(component.productLst.length).toBe(2);
  expect(component.productLst[0].tenThuoc).toBe('Paracetamol 500mg');
  expect(component.totalRows).toBe(2);
});
```

2. Test API deleteProduct:
```typescript
it('should delete thuoc via API', () => {
  // Arrange
  const thuoc = { id: '1', tenThuoc: 'Paracetamol 500mg' };
  const mockResponse = {
    status: '200',
    msg: 'Thành công'
  };
  spyOn(window, 'confirm').and.returnValue(true);
  
  // Act
  component.delete(thuoc);
  
  // Assert
  const req = httpMock.expectOne(`${environment.backApiUrl}/thuoc/delete?id=${thuoc.id}`);
  expect(req.request.method).toBe('DELETE');
  req.flush(mockResponse);
  
  // Verify that getData is called after successful delete
  const searchReq = httpMock.expectOne(`${environment.backApiUrl}/thuoc/search`);
  expect(searchReq.request.method).toBe('POST');
});
```

### 3.3 Chạy kiểm thử
1. Chạy kiểm thử bằng Angular CLI:
```bash
cd FE
ng test --include=src/app/ptit/sys/product/thuoc.component.integration.spec.ts
```

2. Chạy kiểm thử Postman:
   - Mở Postman
   - Chọn collection "Quản lý thuốc"
   - Nhấn "Run collection"

## 4. THỰC HÀNH KIỂM THỬ TÍCH HỢP

### 4.1 Bài tập thực hành
1. Viết kiểm thử tích hợp cho luồng tạo thuốc mới từ frontend đến backend
2. Viết kiểm thử tích hợp cho luồng tìm kiếm thuốc theo nhiều tiêu chí
3. Viết kiểm thử tích hợp cho luồng xóa thuốc đã có trong đơn hàng

### 4.2 Checklist kiểm thử tích hợp
- [ ] Đã kiểm thử tích hợp tất cả các API trong ThuocController
- [ ] Đã kiểm thử tích hợp giữa ThuocController và ThuocService
- [ ] Đã kiểm thử tích hợp giữa ThuocService và ThuocRepo
- [ ] Đã kiểm thử tích hợp với các dịch vụ liên quan (UploadImageService, ChiTietDonHangService)
- [ ] Đã kiểm thử tích hợp giữa frontend và backend
- [ ] Đã kiểm thử các trường hợp thành công
- [ ] Đã kiểm thử các trường hợp thất bại
- [ ] Đã kiểm thử các trường hợp ngoại lệ

## 5. KẾT LUẬN

Kiểm thử tích hợp là bước quan trọng để đảm bảo các thành phần khác nhau của hệ thống hoạt động đúng khi kết hợp với nhau. Việc triển khai kiểm thử tích hợp cho chức năng Quản lý thuốc giúp phát hiện các vấn đề về tương tác giữa các thành phần, đảm bảo luồng dữ liệu chính xác từ frontend đến backend và ngược lại.

Tài liệu này đã cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử tích hợp cho chức năng Quản lý thuốc, bao gồm kiểm thử tích hợp backend và kiểm thử tích hợp frontend-backend. Bằng cách tuân theo hướng dẫn này, bạn có thể đảm bảo rằng các thành phần của chức năng Quản lý thuốc hoạt động đúng khi tích hợp với nhau.
