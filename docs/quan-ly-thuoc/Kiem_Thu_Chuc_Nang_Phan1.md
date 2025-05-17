# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ CHỨC NĂNG (FUNCTIONAL TESTING) - PHẦN 1
## CHỨC NĂNG QUẢN LÝ THUỐC

## 1. GIỚI THIỆU

### 1.1 Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử chức năng (Functional Testing) cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

### 1.2 Phạm vi
Tài liệu bao gồm hướng dẫn kiểm thử chức năng cho:
- Chức năng thêm thuốc mới
- Chức năng cập nhật thông tin thuốc
- Chức năng xóa thuốc
- Chức năng tìm kiếm thuốc
- Chức năng quản lý loại thuốc
- Chức năng quản lý danh mục thuốc

### 1.3 Công cụ và môi trường
- Công cụ kiểm thử: Postman, Cypress, JUnit, Jest
- Ngôn ngữ lập trình: Java, JavaScript, TypeScript
- Framework: Spring Boot, Angular
- Cơ sở dữ liệu: PostgreSQL
- IDE: IntelliJ IDEA, Visual Studio Code

## 2. CHUẨN BỊ MÔI TRƯỜNG KIỂM THỬ

### 2.1 Chuẩn bị môi trường backend

#### 2.1.1 Cài đặt JDK và Maven
1. Cài đặt JDK 17 hoặc phiên bản mới hơn
2. Cài đặt Maven

#### 2.1.2 Cài đặt PostgreSQL
1. Cài đặt PostgreSQL
2. Tạo database cho môi trường kiểm thử:
```sql
CREATE DATABASE hieuthuoc_test;
```

#### 2.1.3 Cấu hình application-test.properties
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

#### 2.1.4 Chuẩn bị dữ liệu kiểm thử
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

### 2.2 Chuẩn bị môi trường frontend

#### 2.2.1 Cài đặt Node.js và npm
1. Cài đặt Node.js và npm từ trang chủ: https://nodejs.org/

#### 2.2.2 Cài đặt Angular CLI
```bash
npm install -g @angular/cli
```

#### 2.2.3 Cài đặt các dependency
```bash
cd FE
npm install
```

### 2.3 Chuẩn bị Postman Collection

#### 2.3.1 Tạo collection mới
1. Mở Postman
2. Tạo collection mới với tên "Quản lý thuốc"

#### 2.3.2 Tạo environment
1. Tạo environment mới với tên "Local"
2. Thêm các biến:
   - `baseUrl`: http://localhost:8080
   - `token`: (để trống, sẽ được cập nhật sau khi đăng nhập)

#### 2.3.3 Tạo request đăng nhập
1. Tạo request mới với tên "Đăng nhập"
2. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/api/auth/login
   - Body (raw, JSON):
     ```json
     {
       "username": "admin",
       "password": "admin123"
     }
     ```
3. Thêm script để lưu token:
   ```javascript
   var jsonData = pm.response.json();
   if (jsonData.token) {
     pm.environment.set("token", jsonData.token);
   }
   ```

## 3. KIỂM THỬ CHỨC NĂNG THÊM THUỐC MỚI

### 3.1 Kiểm thử API thêm thuốc mới bằng Postman

#### 3.1.1 Tạo request thêm thuốc mới
1. Tạo request mới với tên "Thêm thuốc mới"
2. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/thuoc/create
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (form-data):
     - thuocDTO (file): Chọn file JSON chứa thông tin thuốc
     - file (file): Chọn file hình ảnh thuốc (nếu có)

3. Tạo file JSON chứa thông tin thuốc (`thuoc_new.json`):
   ```json
   {
     "tenThuoc": "Vitamin D3 1000IU",
     "maThuoc": "VITD1000",
     "loaiThuocId": 3,
     "nhaSanXuatId": 1,
     "donVi": "Viên",
     "giaNhap": 8000,
     "giaBan": 12000,
     "soLuongTon": 100,
     "nguongCanhBao": 20,
     "congDung": "Bổ sung vitamin D3",
     "huongDanSuDung": "Uống 1 viên mỗi ngày",
     "trangThai": true
   }
   ```

#### 3.1.2 Viết test script cho request thêm thuốc mới
```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

// Kiểm tra message trong response
pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});

// Kiểm tra dữ liệu thuốc trong response
pm.test("Response data has correct thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.tenThuoc).to.eql("Vitamin D3 1000IU");
    pm.expect(jsonData.data.maThuoc).to.eql("VITD1000");
    pm.expect(jsonData.data.donVi).to.eql("Viên");
    pm.expect(jsonData.data.giaNhap).to.eql(8000);
    pm.expect(jsonData.data.giaBan).to.eql(12000);
    pm.expect(jsonData.data.soLuongTon).to.eql(100);
    pm.expect(jsonData.data.nguongCanhBao).to.eql(20);
    pm.expect(jsonData.data.congDung).to.eql("Bổ sung vitamin D3");
    pm.expect(jsonData.data.huongDanSuDung).to.eql("Uống 1 viên mỗi ngày");
    pm.expect(jsonData.data.trangThai).to.be.true;
});

// Lưu ID thuốc mới để sử dụng trong các test case khác
var jsonData = pm.response.json();
if (jsonData.data && jsonData.data.id) {
    pm.environment.set("newThuocId", jsonData.data.id);
}
```

#### 3.1.3 Tạo các test case cho các trường hợp đặc biệt

1. **Test case: Thêm thuốc với mã thuốc đã tồn tại**
   - Tạo request mới với tên "Thêm thuốc - Mã thuốc đã tồn tại"
   - Cấu hình tương tự request thêm thuốc mới, nhưng sử dụng mã thuốc đã tồn tại:
     ```json
     {
       "tenThuoc": "Vitamin E 400IU",
       "maThuoc": "PARA500",
       "loaiThuocId": 3,
       "nhaSanXuatId": 1,
       "donVi": "Viên",
       "giaNhap": 10000,
       "giaBan": 15000,
       "soLuongTon": 80,
       "nguongCanhBao": 15,
       "congDung": "Bổ sung vitamin E",
       "huongDanSuDung": "Uống 1 viên mỗi ngày",
       "trangThai": true
     }
     ```
   - Viết test script:
     ```javascript
     pm.test("Status code is 200", function () {
         pm.response.to.have.status(200);
     });
     
     pm.test("Response status is 409", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.status).to.eql(409);
     });
     
     pm.test("Response message is 'Mã thuốc đã tồn tại'", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.msg).to.eql("Mã thuốc đã tồn tại");
     });
     ```

2. **Test case: Thêm thuốc với tên thuốc đã tồn tại**
   - Tạo request mới với tên "Thêm thuốc - Tên thuốc đã tồn tại"
   - Cấu hình tương tự request thêm thuốc mới, nhưng sử dụng tên thuốc đã tồn tại:
     ```json
     {
       "tenThuoc": "Paracetamol 500mg",
       "maThuoc": "PARA600",
       "loaiThuocId": 2,
       "nhaSanXuatId": 1,
       "donVi": "Viên",
       "giaNhap": 6000,
       "giaBan": 8000,
       "soLuongTon": 120,
       "nguongCanhBao": 25,
       "congDung": "Giảm đau, hạ sốt",
       "huongDanSuDung": "Uống 1-2 viên mỗi 4-6 giờ khi cần",
       "trangThai": true
     }
     ```
   - Viết test script:
     ```javascript
     pm.test("Status code is 200", function () {
         pm.response.to.have.status(200);
     });
     
     pm.test("Response status is 409", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.status).to.eql(409);
     });
     
     pm.test("Response message is 'Tên thuốc đã tồn tại'", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.msg).to.eql("Tên thuốc đã tồn tại");
     });
     ```

3. **Test case: Thêm thuốc với loại thuốc không tồn tại**
   - Tạo request mới với tên "Thêm thuốc - Loại thuốc không tồn tại"
   - Cấu hình tương tự request thêm thuốc mới, nhưng sử dụng loại thuốc không tồn tại:
     ```json
     {
       "tenThuoc": "Vitamin B Complex",
       "maThuoc": "VITB100",
       "loaiThuocId": 999,
       "nhaSanXuatId": 1,
       "donVi": "Viên",
       "giaNhap": 7000,
       "giaBan": 10000,
       "soLuongTon": 90,
       "nguongCanhBao": 18,
       "congDung": "Bổ sung vitamin B",
       "huongDanSuDung": "Uống 1 viên mỗi ngày",
       "trangThai": true
     }
     ```
   - Viết test script:
     ```javascript
     pm.test("Status code is 200", function () {
         pm.response.to.have.status(200);
     });
     
     pm.test("Response contains error message", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.status).to.be.oneOf([400, 404, 500]);
         pm.expect(jsonData.msg).to.include("Loại thuốc không tồn tại");
     });
     ```

### 3.2 Kiểm thử chức năng thêm thuốc mới bằng JUnit

#### 3.2.1 Tạo class test cho chức năng thêm thuốc mới
Tạo file `BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceCreateTest.java`:

```java
package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.ThuocDTO;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.LoaiThuocRepo;
import com.example.hieuthuoc.repository.NhaSanXuatRepo;
import com.example.hieuthuoc.repository.ThuocRepo;

public class ThuocServiceCreateTest {

    @Mock
    private ThuocRepo thuocRepo;

    @Mock
    private LoaiThuocRepo loaiThuocRepo;

    @Mock
    private NhaSanXuatRepo nhaSanXuatRepo;

    @Mock
    private UploadImageService uploadImageService;

    @InjectMocks
    private ThuocServiceImpl thuocService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateThuoc_Success() {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setTenThuoc("Vitamin D3 1000IU");
        thuocDTO.setMaThuoc("VITD1000");
        thuocDTO.setLoaiThuocId(3);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(8000.0);
        thuocDTO.setGiaBan(12000.0);
        thuocDTO.setSoLuongTon(100);
        thuocDTO.setNguongCanhBao(20);
        thuocDTO.setCongDung("Bổ sung vitamin D3");
        thuocDTO.setHuongDanSuDung("Uống 1 viên mỗi ngày");
        thuocDTO.setTrangThai(true);

        // Mock file
        MockMultipartFile file = new MockMultipartFile(
            "file",
            "test.jpg",
            "image/jpeg",
            "test image content".getBytes()
        );
        thuocDTO.setFile(file);

        // Mock loại thuốc
        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(3);
        loaiThuoc.setTenLoai("Vitamin và khoáng chất");

        // Mock nhà sản xuất
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(1);
        nhaSanXuat.setTenNhaSanXuat("Công ty Dược phẩm ABC");

        // Mock thuốc đã lưu
        Thuoc savedThuoc = new Thuoc();
        savedThuoc.setId(3);
        savedThuoc.setTenThuoc("Vitamin D3 1000IU");
        savedThuoc.setMaThuoc("VITD1000");
        savedThuoc.setLoaiThuoc(loaiThuoc);
        savedThuoc.setNhaSanXuat(nhaSanXuat);
        savedThuoc.setDonVi("Viên");
        savedThuoc.setGiaNhap(8000.0);
        savedThuoc.setGiaBan(12000.0);
        savedThuoc.setSoLuongTon(100);
        savedThuoc.setNguongCanhBao(20);
        savedThuoc.setCongDung("Bổ sung vitamin D3");
        savedThuoc.setHuongDanSuDung("Uống 1 viên mỗi ngày");
        savedThuoc.setTrangThai(true);
        savedThuoc.setAvatar("https://example.com/images/vitamin_d3.jpg");

        // Mock các phương thức
        when(thuocRepo.existsByMaThuoc(thuocDTO.getMaThuoc())).thenReturn(false);
        when(thuocRepo.existsByTenThuoc(thuocDTO.getTenThuoc())).thenReturn(false);
        when(loaiThuocRepo.findById(thuocDTO.getLoaiThuocId())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(thuocDTO.getNhaSanXuatId())).thenReturn(Optional.of(nhaSanXuat));
        when(uploadImageService.uploadImage(any(), any())).thenReturn("https://example.com/images/vitamin_d3.jpg");
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(savedThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.create(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("Vitamin D3 1000IU", response.getData().getTenThuoc());
        assertEquals("VITD1000", response.getData().getMaThuoc());
        assertEquals("Viên", response.getData().getDonVi());
        assertEquals(8000.0, response.getData().getGiaNhap());
        assertEquals(12000.0, response.getData().getGiaBan());
        assertEquals(100, response.getData().getSoLuongTon());
        assertEquals(20, response.getData().getNguongCanhBao());
        assertEquals("Bổ sung vitamin D3", response.getData().getCongDung());
        assertEquals("Uống 1 viên mỗi ngày", response.getData().getHuongDanSuDung());
        assertTrue(response.getData().getTrangThai());
        assertEquals("https://example.com/images/vitamin_d3.jpg", response.getData().getAvatar());

        // Verify
        verify(thuocRepo, times(1)).existsByMaThuoc(thuocDTO.getMaThuoc());
        verify(thuocRepo, times(1)).existsByTenThuoc(thuocDTO.getTenThuoc());
        verify(loaiThuocRepo, times(1)).findById(thuocDTO.getLoaiThuocId());
        verify(nhaSanXuatRepo, times(1)).findById(thuocDTO.getNhaSanXuatId());
        verify(uploadImageService, times(1)).uploadImage(any(), any());
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }
}
```
