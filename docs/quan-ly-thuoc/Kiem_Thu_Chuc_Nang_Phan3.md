# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ CHỨC NĂNG (FUNCTIONAL TESTING) - PHẦN 3
## CHỨC NĂNG QUẢN LÝ THUỐC

## 6. KIỂM THỬ CHỨC NĂNG TÌM KIẾM THUỐC

### 6.1 Kiểm thử API tìm kiếm thuốc bằng Postman

#### 6.1.1 Tạo request tìm kiếm thuốc
1. Tạo request mới với tên "Tìm kiếm thuốc"
2. Cấu hình request:
   - Method: POST
   - URL: {{baseUrl}}/thuoc/search
   - Headers:
     - Authorization: Bearer {{token}}
     - Content-Type: application/json
   - Body (raw, JSON):
     ```json
     {
       "keyWord": "",
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

#### 6.1.2 Viết test script cho request tìm kiếm thuốc
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

// Kiểm tra cấu trúc dữ liệu phân trang
pm.test("Response data has pagination structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('data');
    pm.expect(jsonData.data).to.have.property('totalElements');
    pm.expect(jsonData.data).to.have.property('totalPages');
    pm.expect(jsonData.data).to.have.property('currentPage');
});

// Kiểm tra dữ liệu thuốc trong response
pm.test("Response data contains thuoc list", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data.data).to.be.an('array');
    
    // Nếu có dữ liệu, kiểm tra cấu trúc của thuốc đầu tiên
    if (jsonData.data.data.length > 0) {
        var firstThuoc = jsonData.data.data[0];
        pm.expect(firstThuoc).to.have.property('id');
        pm.expect(firstThuoc).to.have.property('tenThuoc');
        pm.expect(firstThuoc).to.have.property('maThuoc');
        pm.expect(firstThuoc).to.have.property('loaiThuoc');
        pm.expect(firstThuoc).to.have.property('nhaSanXuat');
        pm.expect(firstThuoc).to.have.property('donVi');
        pm.expect(firstThuoc).to.have.property('giaBan');
        pm.expect(firstThuoc).to.have.property('soLuongTon');
    }
});
```

#### 6.1.3 Tạo các test case cho các trường hợp tìm kiếm khác nhau

1. **Test case: Tìm kiếm thuốc theo tên**
   - Tạo request mới với tên "Tìm kiếm thuốc theo tên"
   - Cấu hình tương tự request tìm kiếm thuốc, nhưng thay đổi body:
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
   - Viết test script:
     ```javascript
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

2. **Test case: Tìm kiếm thuốc theo loại thuốc**
   - Tạo request mới với tên "Tìm kiếm thuốc theo loại thuốc"
   - Cấu hình tương tự request tìm kiếm thuốc, nhưng thay đổi body:
     ```json
     {
       "keyWord": "",
       "loaiThuoc": "Giảm đau không steroid",
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
   - Viết test script:
     ```javascript
     pm.test("Response contains thuoc with loaiThuoc 'Giảm đau không steroid'", function () {
         var jsonData = pm.response.json();
         var found = false;
         
         if (jsonData.data.data.length > 0) {
             for (var i = 0; i < jsonData.data.data.length; i++) {
                 if (jsonData.data.data[i].loaiThuoc && 
                     jsonData.data.data[i].loaiThuoc.tenLoai === "Giảm đau không steroid") {
                     found = true;
                     break;
                 }
             }
         }
         
         pm.expect(found).to.be.true;
     });
     ```

3. **Test case: Tìm kiếm thuốc theo nhà sản xuất**
   - Tạo request mới với tên "Tìm kiếm thuốc theo nhà sản xuất"
   - Cấu hình tương tự request tìm kiếm thuốc, nhưng thay đổi body:
     ```json
     {
       "keyWord": "",
       "loaiThuoc": "",
       "nhaSanXuat": "Công ty Dược phẩm ABC",
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
   - Viết test script:
     ```javascript
     pm.test("Response contains thuoc with nhaSanXuat 'Công ty Dược phẩm ABC'", function () {
         var jsonData = pm.response.json();
         var found = false;
         
         if (jsonData.data.data.length > 0) {
             for (var i = 0; i < jsonData.data.data.length; i++) {
                 if (jsonData.data.data[i].nhaSanXuat && 
                     jsonData.data.data[i].nhaSanXuat.tenNhaSanXuat === "Công ty Dược phẩm ABC") {
                     found = true;
                     break;
                 }
             }
         }
         
         pm.expect(found).to.be.true;
     });
     ```

4. **Test case: Tìm kiếm thuốc theo khoảng giá**
   - Tạo request mới với tên "Tìm kiếm thuốc theo khoảng giá"
   - Cấu hình tương tự request tìm kiếm thuốc, nhưng thay đổi body:
     ```json
     {
       "keyWord": "",
       "loaiThuoc": "",
       "nhaSanXuat": "",
       "danhMucThuoc": "",
       "minGiaBan": 5000,
       "maxGiaBan": 10000,
       "tenDoiTuong": null,
       "trangThai": true,
       "currentPage": 0,
       "size": 10,
       "sortedField": "id"
     }
     ```
   - Viết test script:
     ```javascript
     pm.test("Response contains thuoc with price between 5000 and 10000", function () {
         var jsonData = pm.response.json();
         var allInRange = true;
         
         if (jsonData.data.data.length > 0) {
             for (var i = 0; i < jsonData.data.data.length; i++) {
                 var price = jsonData.data.data[i].giaBan;
                 if (price < 5000 || price > 10000) {
                     allInRange = false;
                     break;
                 }
             }
         }
         
         pm.expect(allInRange).to.be.true;
     });
     ```

5. **Test case: Tìm kiếm thuốc với nhiều tiêu chí**
   - Tạo request mới với tên "Tìm kiếm thuốc với nhiều tiêu chí"
   - Cấu hình tương tự request tìm kiếm thuốc, nhưng thay đổi body:
     ```json
     {
       "keyWord": "Paracetamol",
       "loaiThuoc": "Giảm đau không steroid",
       "nhaSanXuat": "Công ty Dược phẩm ABC",
       "danhMucThuoc": "",
       "minGiaBan": 5000,
       "maxGiaBan": 10000,
       "tenDoiTuong": null,
       "trangThai": true,
       "currentPage": 0,
       "size": 10,
       "sortedField": "id"
     }
     ```
   - Viết test script:
     ```javascript
     pm.test("Response contains thuoc matching all criteria", function () {
         var jsonData = pm.response.json();
         var allMatch = true;
         
         if (jsonData.data.data.length > 0) {
             for (var i = 0; i < jsonData.data.data.length; i++) {
                 var thuoc = jsonData.data.data[i];
                 
                 // Kiểm tra tên thuốc
                 if (!thuoc.tenThuoc.includes("Paracetamol")) {
                     allMatch = false;
                     break;
                 }
                 
                 // Kiểm tra loại thuốc
                 if (!thuoc.loaiThuoc || thuoc.loaiThuoc.tenLoai !== "Giảm đau không steroid") {
                     allMatch = false;
                     break;
                 }
                 
                 // Kiểm tra nhà sản xuất
                 if (!thuoc.nhaSanXuat || thuoc.nhaSanXuat.tenNhaSanXuat !== "Công ty Dược phẩm ABC") {
                     allMatch = false;
                     break;
                 }
                 
                 // Kiểm tra giá bán
                 if (thuoc.giaBan < 5000 || thuoc.giaBan > 10000) {
                     allMatch = false;
                     break;
                 }
             }
         }
         
         pm.expect(allMatch).to.be.true;
     });
     ```

### 6.2 Kiểm thử chức năng tìm kiếm thuốc bằng JUnit

#### 6.2.1 Tạo class test cho chức năng tìm kiếm thuốc
Tạo file `BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceSearchTest.java`:

```java
package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.hieuthuoc.dto.PageDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.dto.SearchThuocDTO;
import com.example.hieuthuoc.entity.LoaiThuoc;
import com.example.hieuthuoc.entity.NhaSanXuat;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.repository.ThuocRepo;

public class ThuocServiceSearchTest {

    @Mock
    private ThuocRepo thuocRepo;

    @InjectMocks
    private ThuocServiceImpl thuocService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearch_Success() {
        // Arrange
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("");
        searchThuocDTO.setLoaiThuoc("");
        searchThuocDTO.setNhaSanXuat("");
        searchThuocDTO.setDanhMucThuoc("");
        searchThuocDTO.setMinGiaBan(null);
        searchThuocDTO.setMaxGiaBan(null);
        searchThuocDTO.setTenDoiTuong(null);
        searchThuocDTO.setTrangThai(true);
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);
        searchThuocDTO.setSortedField("id");

        // Tạo danh sách thuốc mẫu
        List<Thuoc> thuocList = new ArrayList<>();
        
        // Thuốc 1
        Thuoc thuoc1 = new Thuoc();
        thuoc1.setId(1);
        thuoc1.setTenThuoc("Paracetamol 500mg");
        thuoc1.setMaThuoc("PARA500");
        
        LoaiThuoc loaiThuoc1 = new LoaiThuoc();
        loaiThuoc1.setId(2);
        loaiThuoc1.setTenLoai("Giảm đau không steroid");
        thuoc1.setLoaiThuoc(loaiThuoc1);
        
        NhaSanXuat nhaSanXuat1 = new NhaSanXuat();
        nhaSanXuat1.setId(1);
        nhaSanXuat1.setTenNhaSanXuat("Công ty Dược phẩm ABC");
        thuoc1.setNhaSanXuat(nhaSanXuat1);
        
        thuoc1.setDonVi("Viên");
        thuoc1.setGiaNhap(5000.0);
        thuoc1.setGiaBan(7000.0);
        thuoc1.setSoLuongTon(100);
        thuoc1.setTrangThai(true);
        
        thuocList.add(thuoc1);
        
        // Thuốc 2
        Thuoc thuoc2 = new Thuoc();
        thuoc2.setId(2);
        thuoc2.setTenThuoc("Amoxicillin 500mg");
        thuoc2.setMaThuoc("AMOX500");
        
        LoaiThuoc loaiThuoc2 = new LoaiThuoc();
        loaiThuoc2.setId(1);
        loaiThuoc2.setTenLoai("Kháng sinh");
        thuoc2.setLoaiThuoc(loaiThuoc2);
        
        NhaSanXuat nhaSanXuat2 = new NhaSanXuat();
        nhaSanXuat2.setId(2);
        nhaSanXuat2.setTenNhaSanXuat("Công ty Dược phẩm XYZ");
        thuoc2.setNhaSanXuat(nhaSanXuat2);
        
        thuoc2.setDonVi("Viên");
        thuoc2.setGiaNhap(8000.0);
        thuoc2.setGiaBan(12000.0);
        thuoc2.setSoLuongTon(50);
        thuoc2.setTrangThai(true);
        
        thuocList.add(thuoc2);

        // Tạo Page từ danh sách thuốc
        Page<Thuoc> page = new PageImpl<>(thuocList, PageRequest.of(0, 10, Sort.by("id")), thuocList.size());

        // Mock phương thức search của thuocRepo
        when(thuocRepo.search(
            eq(searchThuocDTO.getKeyWord()),
            eq(searchThuocDTO.getLoaiThuoc()),
            eq(searchThuocDTO.getNhaSanXuat()),
            eq(searchThuocDTO.getDanhMucThuoc()),
            eq(searchThuocDTO.getMinGiaBan()),
            eq(searchThuocDTO.getMaxGiaBan()),
            eq(searchThuocDTO.getTenDoiTuong()),
            eq(searchThuocDTO.getTrangThai()),
            any(Pageable.class)
        )).thenReturn(page);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.search(searchThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(2, response.getData().getData().size());
        assertEquals(2, response.getData().getTotalElements());
        assertEquals(1, response.getData().getTotalPages());
        assertEquals(0, response.getData().getCurrentPage());

        // Verify
        verify(thuocRepo, times(1)).search(
            eq(searchThuocDTO.getKeyWord()),
            eq(searchThuocDTO.getLoaiThuoc()),
            eq(searchThuocDTO.getNhaSanXuat()),
            eq(searchThuocDTO.getDanhMucThuoc()),
            eq(searchThuocDTO.getMinGiaBan()),
            eq(searchThuocDTO.getMaxGiaBan()),
            eq(searchThuocDTO.getTenDoiTuong()),
            eq(searchThuocDTO.getTrangThai()),
            any(Pageable.class)
        );
    }

    @Test
    public void testSearch_ByKeyword() {
        // Arrange
        SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
        searchThuocDTO.setKeyWord("Paracetamol");
        searchThuocDTO.setCurrentPage(0);
        searchThuocDTO.setSize(10);
        searchThuocDTO.setSortedField("id");

        // Tạo danh sách thuốc mẫu
        List<Thuoc> thuocList = new ArrayList<>();
        
        // Thuốc 1
        Thuoc thuoc1 = new Thuoc();
        thuoc1.setId(1);
        thuoc1.setTenThuoc("Paracetamol 500mg");
        thuoc1.setMaThuoc("PARA500");
        // Set các thuộc tính khác
        
        thuocList.add(thuoc1);

        // Tạo Page từ danh sách thuốc
        Page<Thuoc> page = new PageImpl<>(thuocList, PageRequest.of(0, 10, Sort.by("id")), thuocList.size());

        // Mock phương thức search của thuocRepo
        when(thuocRepo.search(
            eq("Paracetamol"),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            any(Pageable.class)
        )).thenReturn(page);

        // Act
        ResponseDTO<PageDTO<List<Thuoc>>> response = thuocService.search(searchThuocDTO);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("Thành công", response.getMsg());
        assertNotNull(response.getData());
        assertEquals(1, response.getData().getData().size());
        assertEquals("Paracetamol 500mg", response.getData().getData().get(0).getTenThuoc());
    }
}
```

## 7. THỰC HÀNH KIỂM THỬ CHỨC NĂNG

### 7.1 Bài tập thực hành
1. Viết test case cho API lấy thuốc bán chạy (`/thuoc/get_thuoc_ban_chay`)
2. Viết test case cho chức năng quản lý loại thuốc (thêm, sửa, xóa, tìm kiếm)
3. Viết test case cho chức năng quản lý danh mục thuốc (thêm, sửa, xóa, tìm kiếm)
4. Viết test case cho việc xử lý upload hình ảnh thuốc

### 7.2 Checklist kiểm thử chức năng
- [ ] Đã kiểm thử chức năng thêm thuốc mới
- [ ] Đã kiểm thử chức năng cập nhật thông tin thuốc
- [ ] Đã kiểm thử chức năng xóa thuốc
- [ ] Đã kiểm thử chức năng tìm kiếm thuốc
- [ ] Đã kiểm thử chức năng lấy thuốc bán chạy
- [ ] Đã kiểm thử chức năng quản lý loại thuốc
- [ ] Đã kiểm thử chức năng quản lý danh mục thuốc
- [ ] Đã kiểm thử xử lý upload hình ảnh thuốc
- [ ] Đã kiểm thử các trường hợp thành công
- [ ] Đã kiểm thử các trường hợp thất bại
- [ ] Đã kiểm thử các trường hợp ngoại lệ

## 8. KẾT LUẬN

Kiểm thử chức năng là một phần quan trọng trong quy trình đảm bảo chất lượng phần mềm. Việc triển khai kiểm thử chức năng cho chức năng Quản lý thuốc giúp đảm bảo rằng các chức năng hoạt động đúng theo yêu cầu, xử lý đúng các trường hợp đặc biệt và ngoại lệ.

Tài liệu này đã cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử chức năng cho chức năng Quản lý thuốc, bao gồm kiểm thử API bằng Postman và kiểm thử service bằng JUnit. Bằng cách tuân theo hướng dẫn này, bạn có thể đảm bảo rằng chức năng Quản lý thuốc hoạt động đúng và đáp ứng các yêu cầu về chức năng.

Để đảm bảo chất lượng tốt nhất, nên kết hợp kiểm thử chức năng với các loại kiểm thử khác như kiểm thử đơn vị, kiểm thử tích hợp, kiểm thử giao diện và kiểm thử hệ thống. Điều này sẽ giúp phát hiện và khắc phục các lỗi ở nhiều cấp độ khác nhau, từ đó nâng cao chất lượng tổng thể của phần mềm.
