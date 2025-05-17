# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ ĐƠN VỊ (UNIT TESTING)
## CHỨC NĂNG QUẢN LÝ THUỐC

## 1. GIỚI THIỆU

### 1.1 Mục đích
Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử đơn vị cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc.

### 1.2 Phạm vi
Tài liệu bao gồm hướng dẫn kiểm thử đơn vị cho:
- Backend: Service và Controller
- Frontend: Component và Service

### 1.3 Công cụ và môi trường
- Backend: JUnit 5, Mockito
- Frontend: Jasmine, Karma
- IDE: IntelliJ IDEA, Visual Studio Code

## 2. KIỂM THỬ ĐƠN VỊ BACKEND

### 2.1 Cấu trúc thư mục kiểm thử
```
BE/src/test/java/com/example/hieuthuoc/
├── service/
│   └── ThuocServiceTest.java
├── controller/
│   └── ThuocControllerTest.java
└── repository/
    └── ThuocRepoTest.java
```

### 2.2 Kiểm thử Service

#### 2.2.1 Chuẩn bị môi trường
1. Tạo class test cho ThuocService:
```java
package com.example.hieuthuoc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.hieuthuoc.repository.ThuocRepo;
// Import các class cần thiết khác

public class ThuocServiceTest {

    @Mock
    private ThuocRepo thuocRepo;
    
    // Mock các dependency khác
    
    @InjectMocks
    private ThuocServiceImpl thuocService;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    // Các phương thức test
}
```

#### 2.2.2 Viết test case cho các phương thức
1. Test phương thức create:
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

2. Test phương thức update:
```java
@Test
public void testUpdateThuoc_Success() {
    // Arrange
    ThuocDTO thuocDTO = new ThuocDTO();
    thuocDTO.setId(1);
    thuocDTO.setTenThuoc("Paracetamol 500mg Updated");
    // Set các thuộc tính khác
    
    Thuoc existingThuoc = new Thuoc();
    existingThuoc.setId(1);
    existingThuoc.setTenThuoc("Paracetamol 500mg");
    // Set các thuộc tính khác
    
    when(thuocRepo.findById(thuocDTO.getId())).thenReturn(Optional.of(existingThuoc));
    // Mock các phương thức khác
    
    // Act
    ResponseDTO<Thuoc> response = thuocService.update(thuocDTO);
    
    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    // Kiểm tra các thuộc tính khác
    
    // Verify
    verify(thuocRepo, times(1)).save(any(Thuoc.class));
}
```

3. Test phương thức delete:
```java
@Test
public void testDeleteThuoc_Success() {
    // Arrange
    Integer thuocId = 1;
    
    // Act
    ResponseDTO<Void> response = thuocService.delete(thuocId);
    
    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    
    // Verify
    verify(thuocRepo, times(1)).deleteById(thuocId);
}
```

4. Test phương thức getById:
```java
@Test
public void testGetById_Success() {
    // Arrange
    Integer thuocId = 1;
    
    Thuoc thuoc = new Thuoc();
    thuoc.setId(thuocId);
    thuoc.setTenThuoc("Paracetamol 500mg");
    // Set các thuộc tính khác
    
    when(thuocRepo.findById(thuocId)).thenReturn(Optional.of(thuoc));
    
    // Act
    ResponseDTO<Thuoc> response = thuocService.getById(thuocId);
    
    // Assert
    assertEquals(200, response.getStatus());
    assertEquals("Thành công", response.getMsg());
    assertNotNull(response.getData());
    assertEquals(thuocId, response.getData().getId());
    // Kiểm tra các thuộc tính khác
    
    // Verify
    verify(thuocRepo, times(1)).findById(thuocId);
}
```

5. Test phương thức search:
```java
@Test
public void testSearch_Success() {
    // Arrange
    SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
    searchThuocDTO.setKeyWord("Paracetamol");
    searchThuocDTO.setCurrentPage(0);
    searchThuocDTO.setSize(10);
    
    List<Thuoc> thuocList = new ArrayList<>();
    // Thêm các thuốc vào danh sách
    
    Page<Thuoc> page = new PageImpl<>(thuocList);
    
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
    // Kiểm tra các thuộc tính khác
}
```

### 2.3 Kiểm thử Controller

#### 2.3.1 Chuẩn bị môi trường
1. Tạo class test cho ThuocController:
```java
package com.example.hieuthuoc.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.hieuthuoc.service.ThuocService;
import com.fasterxml.jackson.databind.ObjectMapper;
// Import các class cần thiết khác

public class ThuocControllerTest {

    private MockMvc mockMvc;
    
    @Mock
    private ThuocService thuocService;
    
    @InjectMocks
    private ThuocController thuocController;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(thuocController).build();
    }
    
    // Các phương thức test
}
```

#### 2.3.2 Viết test case cho các API
1. Test API getById:
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

2. Test API search:
```java
@Test
public void testSearch_Success() throws Exception {
    // Arrange
    SearchThuocDTO searchThuocDTO = new SearchThuocDTO();
    searchThuocDTO.setKeyWord("Paracetamol");
    searchThuocDTO.setCurrentPage(0);
    searchThuocDTO.setSize(10);
    
    List<Thuoc> thuocList = new ArrayList<>();
    // Thêm các thuốc vào danh sách
    
    PageDTO<List<Thuoc>> pageDTO = new PageDTO<>();
    pageDTO.setData(thuocList);
    pageDTO.setTotalElements(thuocList.size());
    pageDTO.setTotalPages(1);
    pageDTO.setCurrentPage(0);
    
    ResponseDTO<PageDTO<List<Thuoc>>> responseDTO = ResponseDTO.<PageDTO<List<Thuoc>>>builder()
            .status(200)
            .msg("Thành công")
            .data(pageDTO)
            .build();
    
    when(thuocService.search(any(SearchThuocDTO.class))).thenReturn(responseDTO);
    
    // Act & Assert
    mockMvc.perform(post("/thuoc/search")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchThuocDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.msg").value("Thành công"))
            .andExpect(jsonPath("$.data").exists());
}
```

### 2.4 Chạy kiểm thử
1. Chạy kiểm thử bằng Maven:
```bash
cd BE
./mvnw test -Dtest=ThuocServiceTest,ThuocControllerTest
```

2. Chạy kiểm thử trong IDE:
   - IntelliJ IDEA: Chuột phải vào class test > Run 'ThuocServiceTest'
   - Eclipse: Chuột phải vào class test > Run As > JUnit Test

## 3. KIỂM THỬ ĐƠN VỊ FRONTEND

### 3.1 Cấu trúc thư mục kiểm thử
```
FE/src/app/ptit/sys/product/
└── thuoc.component.spec.ts
```

### 3.2 Kiểm thử Component

#### 3.2.1 Chuẩn bị môi trường
1. Tạo file test cho ThuocComponent:
```typescript
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { ThuocComponent } from './thuoc.component';
import { ThuocService } from 'src/app/_service/thuoc.service';
// Import các service và component cần thiết khác

describe('ThuocComponent', () => {
  let component: ThuocComponent;
  let fixture: ComponentFixture<ThuocComponent>;
  let thuocService: ThuocService;
  
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ThuocComponent],
      imports: [
        HttpClientTestingModule,
        FormsModule,
        RouterTestingModule
      ],
      providers: [
        {
          provide: ThuocService,
          useValue: {
            getProductLst: jasmine.createSpy('getProductLst').and.returnValue(of({
              status: '200',
              data: {
                data: [
                  { id: '1', tenThuoc: 'Paracetamol 500mg' },
                  { id: '2', tenThuoc: 'Vitamin C 500mg' }
                ],
                totalElements: 2
              }
            })),
            // Mock các phương thức khác
          }
        },
        // Provide các service khác
      ]
    }).compileComponents();
    
    fixture = TestBed.createComponent(ThuocComponent);
    component = fixture.componentInstance;
    thuocService = TestBed.inject(ThuocService);
    fixture.detectChanges();
  });
  
  // Các phương thức test
});
```

#### 3.2.2 Viết test case cho các phương thức
1. Test khởi tạo component:
```typescript
it('should create', () => {
  expect(component).toBeTruthy();
});
```

2. Test phương thức ngOnInit:
```typescript
it('should load thuoc list on init', () => {
  component.ngOnInit();
  expect(thuocService.getProductLst).toHaveBeenCalled();
  expect(component.productLst.length).toBe(2);
  expect(component.productLst[0].tenThuoc).toBe('Paracetamol 500mg');
  expect(component.productLst[1].tenThuoc).toBe('Vitamin C 500mg');
});
```

3. Test phương thức search:
```typescript
it('should search thuoc', () => {
  component.modelSearch.keyWord = 'Paracetamol';
  component.search();
  expect(thuocService.getProductLst).toHaveBeenCalledWith(component.modelSearch);
});
```

4. Test phương thức delete:
```typescript
it('should delete thuoc successfully', () => {
  const thuoc = { id: '1', tenThuoc: 'Paracetamol 500mg' };
  spyOn(window, 'confirm').and.returnValue(true);
  (thuocService.deleteProduct as jasmine.Spy).and.returnValue(of({
    status: '200',
    msg: 'Xóa thành công'
  }));
  
  component.delete(thuoc);
  
  expect(thuocService.deleteProduct).toHaveBeenCalledWith(thuoc.id);
  expect(thuocService.getProductLst).toHaveBeenCalled(); // Should reload data after delete
});
```

### 3.3 Chạy kiểm thử
1. Chạy kiểm thử bằng Angular CLI:
```bash
cd FE
ng test --include=src/app/ptit/sys/product/thuoc.component.spec.ts
```

2. Chạy kiểm thử trong IDE:
   - Visual Studio Code: Sử dụng extension Jest Runner hoặc Karma Runner
   - WebStorm: Chuột phải vào file test > Run 'thuoc.component.spec.ts'

## 4. THỰC HÀNH KIỂM THỬ ĐƠN VỊ

### 4.1 Bài tập thực hành
1. Viết test case cho phương thức `getThuocBanChay` trong ThuocService
2. Viết test case cho phương thức `create` trong ThuocController
3. Viết test case cho phương thức `onCategoryChange` trong ThuocComponent

### 4.2 Checklist kiểm thử đơn vị
- [ ] Đã kiểm thử tất cả các phương thức public trong ThuocService
- [ ] Đã kiểm thử tất cả các API trong ThuocController
- [ ] Đã kiểm thử tất cả các phương thức trong ThuocComponent
- [ ] Đã kiểm thử các trường hợp thành công
- [ ] Đã kiểm thử các trường hợp thất bại
- [ ] Đã kiểm thử các trường hợp ngoại lệ
- [ ] Đã đạt độ bao phủ code tối thiểu 80%

## 5. KẾT LUẬN

Kiểm thử đơn vị là bước đầu tiên và quan trọng trong quy trình đảm bảo chất lượng phần mềm. Việc triển khai kiểm thử đơn vị cho chức năng Quản lý thuốc giúp phát hiện sớm các lỗi, đảm bảo các thành phần hoạt động đúng như mong đợi, và tạo nền tảng vững chắc cho các loại kiểm thử khác.

Tài liệu này đã cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử đơn vị cho cả backend và frontend của chức năng Quản lý thuốc. Bằng cách tuân theo hướng dẫn này, bạn có thể đảm bảo rằng các thành phần cốt lõi của chức năng Quản lý thuốc hoạt động chính xác và đáng tin cậy.
