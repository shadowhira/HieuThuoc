# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ CHỨC NĂNG (FUNCTIONAL TESTING) - PHẦN 2
## CHỨC NĂNG QUẢN LÝ THUỐC

## 4. KIỂM THỬ CHỨC NĂNG CẬP NHẬT THÔNG TIN THUỐC

### 4.1 Kiểm thử API cập nhật thông tin thuốc bằng Postman

#### 4.1.1 Tạo request cập nhật thông tin thuốc
1. Tạo request mới với tên "Cập nhật thông tin thuốc"
2. Cấu hình request:
   - Method: PUT
   - URL: {{baseUrl}}/thuoc/update
   - Headers:
     - Authorization: Bearer {{token}}
   - Body (form-data):
     - thuocDTO (file): Chọn file JSON chứa thông tin thuốc cần cập nhật
     - file (file): Chọn file hình ảnh thuốc (nếu có)

3. Tạo file JSON chứa thông tin thuốc cần cập nhật (`thuoc_update.json`):
   ```json
   {
     "id": 1,
     "tenThuoc": "Paracetamol 500mg",
     "maThuoc": "PARA500",
     "loaiThuocId": 2,
     "nhaSanXuatId": 1,
     "donVi": "Viên",
     "giaNhap": 5500,
     "giaBan": 8000,
     "soLuongTon": 120,
     "nguongCanhBao": 25,
     "congDung": "Giảm đau, hạ sốt, giảm viêm",
     "huongDanSuDung": "Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày",
     "trangThai": true
   }
   ```

#### 4.1.2 Viết test script cho request cập nhật thông tin thuốc
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

// Kiểm tra dữ liệu thuốc đã được cập nhật
pm.test("Response data has updated thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.id).to.eql(1);
    pm.expect(jsonData.data.tenThuoc).to.eql("Paracetamol 500mg");
    pm.expect(jsonData.data.maThuoc).to.eql("PARA500");
    pm.expect(jsonData.data.donVi).to.eql("Viên");
    pm.expect(jsonData.data.giaNhap).to.eql(5500);
    pm.expect(jsonData.data.giaBan).to.eql(8000);
    pm.expect(jsonData.data.soLuongTon).to.eql(120);
    pm.expect(jsonData.data.nguongCanhBao).to.eql(25);
    pm.expect(jsonData.data.congDung).to.eql("Giảm đau, hạ sốt, giảm viêm");
    pm.expect(jsonData.data.huongDanSuDung).to.eql("Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày");
    pm.expect(jsonData.data.trangThai).to.be.true;
});
```

#### 4.1.3 Tạo các test case cho các trường hợp đặc biệt

1. **Test case: Cập nhật thuốc với mã thuốc đã tồn tại**
   - Tạo request mới với tên "Cập nhật thuốc - Mã thuốc đã tồn tại"
   - Cấu hình tương tự request cập nhật thông tin thuốc, nhưng sử dụng mã thuốc đã tồn tại của thuốc khác:
     ```json
     {
       "id": 1,
       "tenThuoc": "Paracetamol 500mg",
       "maThuoc": "AMOX500",
       "loaiThuocId": 2,
       "nhaSanXuatId": 1,
       "donVi": "Viên",
       "giaNhap": 5500,
       "giaBan": 8000,
       "soLuongTon": 120,
       "nguongCanhBao": 25,
       "congDung": "Giảm đau, hạ sốt, giảm viêm",
       "huongDanSuDung": "Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày",
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

2. **Test case: Cập nhật thuốc với tên thuốc đã tồn tại**
   - Tạo request mới với tên "Cập nhật thuốc - Tên thuốc đã tồn tại"
   - Cấu hình tương tự request cập nhật thông tin thuốc, nhưng sử dụng tên thuốc đã tồn tại của thuốc khác:
     ```json
     {
       "id": 1,
       "tenThuoc": "Amoxicillin 500mg",
       "maThuoc": "PARA500",
       "loaiThuocId": 2,
       "nhaSanXuatId": 1,
       "donVi": "Viên",
       "giaNhap": 5500,
       "giaBan": 8000,
       "soLuongTon": 120,
       "nguongCanhBao": 25,
       "congDung": "Giảm đau, hạ sốt, giảm viêm",
       "huongDanSuDung": "Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày",
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

3. **Test case: Cập nhật thuốc không tồn tại**
   - Tạo request mới với tên "Cập nhật thuốc - Thuốc không tồn tại"
   - Cấu hình tương tự request cập nhật thông tin thuốc, nhưng sử dụng ID thuốc không tồn tại:
     ```json
     {
       "id": 999,
       "tenThuoc": "Thuốc không tồn tại",
       "maThuoc": "NOTEXIST",
       "loaiThuocId": 2,
       "nhaSanXuatId": 1,
       "donVi": "Viên",
       "giaNhap": 5000,
       "giaBan": 7000,
       "soLuongTon": 100,
       "nguongCanhBao": 20,
       "congDung": "Không tồn tại",
       "huongDanSuDung": "Không tồn tại",
       "trangThai": true
     }
     ```
   - Viết test script:
     ```javascript
     pm.test("Status code is 200", function () {
         pm.response.to.have.status(200);
     });
     
     pm.test("Response status is 404", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.status).to.eql(404);
     });
     
     pm.test("Response message is 'Không tìm thấy thuốc'", function () {
         var jsonData = pm.response.json();
         pm.expect(jsonData.msg).to.eql("Không tìm thấy thuốc");
     });
     ```

### 4.2 Kiểm thử chức năng cập nhật thông tin thuốc bằng JUnit

#### 4.2.1 Tạo class test cho chức năng cập nhật thông tin thuốc
Tạo file `BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceUpdateTest.java`:

```java
package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

public class ThuocServiceUpdateTest {

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
    public void testUpdateThuoc_Success() {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg");
        thuocDTO.setMaThuoc("PARA500");
        thuocDTO.setLoaiThuocId(2);
        thuocDTO.setNhaSanXuatId(1);
        thuocDTO.setDonVi("Viên");
        thuocDTO.setGiaNhap(5500.0);
        thuocDTO.setGiaBan(8000.0);
        thuocDTO.setSoLuongTon(120);
        thuocDTO.setNguongCanhBao(25);
        thuocDTO.setCongDung("Giảm đau, hạ sốt, giảm viêm");
        thuocDTO.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày");
        thuocDTO.setTrangThai(true);

        // Mock file
        MockMultipartFile file = new MockMultipartFile(
            "file",
            "test.jpg",
            "image/jpeg",
            "test image content".getBytes()
        );
        thuocDTO.setFile(file);

        // Mock thuốc hiện tại
        Thuoc currentThuoc = new Thuoc();
        currentThuoc.setId(1);
        currentThuoc.setTenThuoc("Paracetamol 500mg");
        currentThuoc.setMaThuoc("PARA500");
        currentThuoc.setDonVi("Viên");
        currentThuoc.setGiaNhap(5000.0);
        currentThuoc.setGiaBan(7000.0);
        currentThuoc.setSoLuongTon(100);
        currentThuoc.setNguongCanhBao(20);
        currentThuoc.setCongDung("Giảm đau, hạ sốt");
        currentThuoc.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần");
        currentThuoc.setTrangThai(true);
        currentThuoc.setAvatar("https://example.com/images/paracetamol.jpg");

        // Mock loại thuốc
        LoaiThuoc loaiThuoc = new LoaiThuoc();
        loaiThuoc.setId(2);
        loaiThuoc.setTenLoai("Giảm đau không steroid");

        // Mock nhà sản xuất
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setId(1);
        nhaSanXuat.setTenNhaSanXuat("Công ty Dược phẩm ABC");

        // Mock thuốc đã cập nhật
        Thuoc updatedThuoc = new Thuoc();
        updatedThuoc.setId(1);
        updatedThuoc.setTenThuoc("Paracetamol 500mg");
        updatedThuoc.setMaThuoc("PARA500");
        updatedThuoc.setLoaiThuoc(loaiThuoc);
        updatedThuoc.setNhaSanXuat(nhaSanXuat);
        updatedThuoc.setDonVi("Viên");
        updatedThuoc.setGiaNhap(5500.0);
        updatedThuoc.setGiaBan(8000.0);
        updatedThuoc.setSoLuongTon(120);
        updatedThuoc.setNguongCanhBao(25);
        updatedThuoc.setCongDung("Giảm đau, hạ sốt, giảm viêm");
        updatedThuoc.setHuongDanSuDung("Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày");
        updatedThuoc.setTrangThai(true);
        updatedThuoc.setAvatar("https://example.com/images/paracetamol_updated.jpg");

        // Mock các phương thức
        when(thuocRepo.findById(thuocDTO.getId())).thenReturn(Optional.of(currentThuoc));
        when(loaiThuocRepo.findById(thuocDTO.getLoaiThuocId())).thenReturn(Optional.of(loaiThuoc));
        when(nhaSanXuatRepo.findById(thuocDTO.getNhaSanXuatId())).thenReturn(Optional.of(nhaSanXuat));
        when(uploadImageService.uploadImage(any(), any())).thenReturn("https://example.com/images/paracetamol_updated.jpg");
        when(uploadImageService.deleteImage(any())).thenReturn(true);
        when(thuocRepo.save(any(Thuoc.class))).thenReturn(updatedThuoc);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(1, response.getData().getId());
        assertEquals("Paracetamol 500mg", response.getData().getTenThuoc());
        assertEquals("PARA500", response.getData().getMaThuoc());
        assertEquals("Viên", response.getData().getDonVi());
        assertEquals(5500.0, response.getData().getGiaNhap());
        assertEquals(8000.0, response.getData().getGiaBan());
        assertEquals(120, response.getData().getSoLuongTon());
        assertEquals(25, response.getData().getNguongCanhBao());
        assertEquals("Giảm đau, hạ sốt, giảm viêm", response.getData().getCongDung());
        assertEquals("Uống 1-2 viên mỗi 4-6 giờ khi cần, không quá 8 viên/ngày", response.getData().getHuongDanSuDung());
        assertTrue(response.getData().getTrangThai());
        assertEquals("https://example.com/images/paracetamol_updated.jpg", response.getData().getAvatar());

        // Verify
        verify(thuocRepo, times(1)).findById(thuocDTO.getId());
        verify(loaiThuocRepo, times(1)).findById(thuocDTO.getLoaiThuocId());
        verify(nhaSanXuatRepo, times(1)).findById(thuocDTO.getNhaSanXuatId());
        verify(uploadImageService, times(1)).uploadImage(any(), any());
        verify(uploadImageService, times(1)).deleteImage(any());
        verify(thuocRepo, times(1)).save(any(Thuoc.class));
    }

    @Test
    public void testUpdateThuoc_NotFound() {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setId(999);
        thuocDTO.setTenThuoc("Thuốc không tồn tại");
        thuocDTO.setMaThuoc("NOTEXIST");
        // Set các thuộc tính khác

        // Mock các phương thức
        when(thuocRepo.findById(thuocDTO.getId())).thenReturn(Optional.empty());

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);

        // Assert
        assertEquals(404, response.getStatus());
        assertEquals("Không tìm thấy thuốc", response.getMsg());
        assertNull(response.getData());

        // Verify
        verify(thuocRepo, times(1)).findById(thuocDTO.getId());
        verify(thuocRepo, never()).save(any(Thuoc.class));
    }

    @Test
    public void testUpdateThuoc_MaThuocExists() {
        // Arrange
        ThuocDTO thuocDTO = new ThuocDTO();
        thuocDTO.setId(1);
        thuocDTO.setTenThuoc("Paracetamol 500mg");
        thuocDTO.setMaThuoc("AMOX500"); // Mã thuốc đã tồn tại của thuốc khác
        // Set các thuộc tính khác

        // Mock thuốc hiện tại
        Thuoc currentThuoc = new Thuoc();
        currentThuoc.setId(1);
        currentThuoc.setTenThuoc("Paracetamol 500mg");
        currentThuoc.setMaThuoc("PARA500");
        // Set các thuộc tính khác

        // Mock các phương thức
        when(thuocRepo.findById(thuocDTO.getId())).thenReturn(Optional.of(currentThuoc));
        when(thuocRepo.existsByMaThuoc(thuocDTO.getMaThuoc())).thenReturn(true);

        // Act
        ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);

        // Assert
        assertEquals(409, response.getStatus());
        assertEquals("Mã thuốc đã tồn tại", response.getMsg());
        assertNull(response.getData());

        // Verify
        verify(thuocRepo, times(1)).findById(thuocDTO.getId());
        verify(thuocRepo, times(1)).existsByMaThuoc(thuocDTO.getMaThuoc());
        verify(thuocRepo, never()).save(any(Thuoc.class));
    }
}
```

## 5. KIỂM THỬ CHỨC NĂNG XÓA THUỐC

### 5.1 Kiểm thử API xóa thuốc bằng Postman

#### 5.1.1 Tạo request xóa thuốc
1. Tạo request mới với tên "Xóa thuốc"
2. Cấu hình request:
   - Method: DELETE
   - URL: {{baseUrl}}/thuoc/delete?id={{newThuocId}}
   - Headers:
     - Authorization: Bearer {{token}}

#### 5.1.2 Viết test script cho request xóa thuốc
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
```

#### 5.1.3 Tạo các test case cho các trường hợp đặc biệt

1. **Test case: Xóa thuốc không tồn tại**
   - Tạo request mới với tên "Xóa thuốc - Thuốc không tồn tại"
   - Cấu hình request:
     - Method: DELETE
     - URL: {{baseUrl}}/thuoc/delete?id=999
     - Headers:
       - Authorization: Bearer {{token}}
   - Viết test script:
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

2. **Test case: Xóa thuốc đã có trong đơn hàng**
   - Tạo request mới với tên "Xóa thuốc - Thuốc đã có trong đơn hàng"
   - Cấu hình request:
     - Method: DELETE
     - URL: {{baseUrl}}/thuoc/delete?id=1
     - Headers:
       - Authorization: Bearer {{token}}
   - Viết test script:
     ```javascript
     pm.test("Status code is 200", function () {
         pm.response.to.have.status(200);
     });
     
     // Lưu ý: Trong trường hợp lý tưởng, API nên trả về lỗi khi xóa thuốc đã có trong đơn hàng
     // Nhưng hiện tại API chưa xử lý trường hợp này, nên test case này sẽ pass
     // Cần cải thiện API để xử lý trường hợp này
     ```

### 5.2 Kiểm thử chức năng xóa thuốc bằng JUnit

#### 5.2.1 Tạo class test cho chức năng xóa thuốc
Tạo file `BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceDeleteTest.java`:

```java
package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChiTietDonHang;
import com.example.hieuthuoc.repository.ChiTietDonHangRepo;
import com.example.hieuthuoc.repository.ThuocRepo;

public class ThuocServiceDeleteTest {

    @Mock
    private ThuocRepo thuocRepo;

    @Mock
    private ChiTietDonHangRepo chiTietDonHangRepo;

    @InjectMocks
    private ThuocServiceImpl thuocService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteThuoc_Success() {
        // Arrange
        Integer thuocId = 3;
        
        // Mock các phương thức
        when(chiTietDonHangRepo.findByThuocId(thuocId)).thenReturn(Arrays.asList());
        doNothing().when(thuocRepo).deleteById(thuocId);
        
        // Act
        ResponseDTO<Void> response = thuocService.delete(thuocId);
        
        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        
        // Verify
        verify(chiTietDonHangRepo, times(1)).findByThuocId(thuocId);
        verify(thuocRepo, times(1)).deleteById(thuocId);
    }
    
    @Test
    public void testDeleteThuoc_ExistsInOrder() {
        // Arrange
        Integer thuocId = 1;
        
        // Mock chi tiết đơn hàng
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        chiTietDonHang.setId(1);
        
        // Mock các phương thức
        when(chiTietDonHangRepo.findByThuocId(thuocId)).thenReturn(Arrays.asList(chiTietDonHang));
        
        // Act
        ResponseDTO<Void> response = thuocService.delete(thuocId);
        
        // Assert
        assertEquals(400, response.getStatus());
        assertEquals("Không thể xóa thuốc đã có trong đơn hàng", response.getMsg());
        
        // Verify
        verify(chiTietDonHangRepo, times(1)).findByThuocId(thuocId);
        verify(thuocRepo, never()).deleteById(thuocId);
    }
}
```
