# Kế hoạch kiểm thử đơn vị cho chức năng Báo cáo thống kê

## 1. Tổng quan

### 1.1. Mục đích
Tài liệu này mô tả kế hoạch kiểm thử đơn vị cho chức năng Báo cáo thống kê trong hệ thống quản lý hiệu thuốc. Mục đích của kiểm thử đơn vị là đảm bảo các thành phần riêng lẻ của chức năng Báo cáo thống kê hoạt động chính xác theo yêu cầu.

### 1.2. Phạm vi
Kiểm thử đơn vị sẽ tập trung vào các thành phần sau của chức năng Báo cáo thống kê:

**Backend:**
- BaoCaoController
- Các phương thức truy vấn báo cáo trong DonHangRepo

**Frontend:**
- BaoCaoService
- Các phương thức xử lý dữ liệu trong ThongKeComponent

### 1.3. Công cụ kiểm thử
- Backend: JUnit, Mockito
- Frontend: Jest, Angular Testing Library

## 2. Kế hoạch kiểm thử Backend

### 2.1. Kiểm thử BaoCaoController

#### 2.1.1. Phương thức doanhThuTheoNgay

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 1 | TC-BE-BC-001 | Kiểm tra phương thức trả về dữ liệu doanh thu theo ngày thành công | ngay = "2023-06-15" | ResponseDTO với status=200, msg="Thành công", data=danh sách DoanhThuDTO | Kiểm tra luồng thành công khi có dữ liệu |
| 2 | TC-BE-BC-002 | Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu | ngay = "2023-06-15" (ngày không có dữ liệu) | ResponseDTO với status=200, msg="Thành công", data=danh sách rỗng | Kiểm tra xử lý khi không có dữ liệu |
| 3 | TC-BE-BC-003 | Kiểm tra xử lý ngoại lệ khi định dạng ngày không hợp lệ | ngay = "2023/06/15" (định dạng không hợp lệ) | Ném ra ngoại lệ MethodArgumentTypeMismatchException | Kiểm tra xử lý lỗi đầu vào |

#### 2.1.2. Phương thức doanhThuTheoThang

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 4 | TC-BE-BC-004 | Kiểm tra phương thức trả về dữ liệu doanh thu theo tháng thành công | nam = 2023, thang = 6 | ResponseDTO với status=200, msg="Thành công", data=danh sách DoanhThuDTO | Kiểm tra luồng thành công khi có dữ liệu |
| 5 | TC-BE-BC-005 | Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu | nam = 2023, thang = 6 (tháng không có dữ liệu) | ResponseDTO với status=200, msg="Thành công", data=danh sách rỗng | Kiểm tra xử lý khi không có dữ liệu |
| 6 | TC-BE-BC-006 | Kiểm tra xử lý khi tham số tháng không hợp lệ | nam = 2023, thang = 13 | Ném ra ngoại lệ ConstraintViolationException | Kiểm tra xử lý lỗi đầu vào |

#### 2.1.3. Phương thức doanhThuTheoNam

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 7 | TC-BE-BC-007 | Kiểm tra phương thức trả về dữ liệu doanh thu theo năm thành công | nam = 2023 | ResponseDTO với status=200, msg="Thành công", data=danh sách DoanhThuDTO | Kiểm tra luồng thành công khi có dữ liệu |
| 8 | TC-BE-BC-008 | Kiểm tra phương thức trả về danh sách rỗng khi không có dữ liệu | nam = 2023 (năm không có dữ liệu) | ResponseDTO với status=200, msg="Thành công", data=danh sách rỗng | Kiểm tra xử lý khi không có dữ liệu |

### 2.2. Kiểm thử DonHangRepo

#### 2.2.1. Phương thức doanhThuTheoNgay

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 9 | TC-BE-REPO-001 | Kiểm tra truy vấn trả về dữ liệu doanh thu theo ngày | ngay = "2023-06-15" | Danh sách DoanhThuDTO với dữ liệu doanh thu theo giờ | Kiểm tra tích hợp với cơ sở dữ liệu |
| 10 | TC-BE-REPO-002 | Kiểm tra truy vấn trả về danh sách rỗng khi không có dữ liệu | ngay = "2023-06-15" (ngày không có dữ liệu) | Danh sách rỗng | Kiểm tra xử lý khi không có dữ liệu |

#### 2.2.2. Phương thức doanhThuTheoThang

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 11 | TC-BE-REPO-003 | Kiểm tra truy vấn trả về dữ liệu doanh thu theo tháng | nam = 2023, thang = 6 | Danh sách DoanhThuDTO với dữ liệu doanh thu theo ngày | Kiểm tra tích hợp với cơ sở dữ liệu |
| 12 | TC-BE-REPO-004 | Kiểm tra truy vấn trả về danh sách rỗng khi không có dữ liệu | nam = 2023, thang = 6 (tháng không có dữ liệu) | Danh sách rỗng | Kiểm tra xử lý khi không có dữ liệu |

#### 2.2.3. Phương thức doanhThuTheoNam

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 13 | TC-BE-REPO-005 | Kiểm tra truy vấn trả về dữ liệu doanh thu theo năm | nam = 2023 | Danh sách DoanhThuDTO với dữ liệu doanh thu theo tháng | Kiểm tra tích hợp với cơ sở dữ liệu |
| 14 | TC-BE-REPO-006 | Kiểm tra truy vấn trả về danh sách rỗng khi không có dữ liệu | nam = 2023 (năm không có dữ liệu) | Danh sách rỗng | Kiểm tra xử lý khi không có dữ liệu |

## 3. Kế hoạch kiểm thử Frontend

### 3.1. Kiểm thử BaoCaoService

#### 3.1.1. Phương thức getDoanhThuTheoNgay

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 15 | TC-FE-SV-001 | Kiểm tra phương thức gọi API với tham số đúng | ngay = "2023-06-15" | HttpClient.get được gọi với URL và tham số đúng | Kiểm tra việc gọi API |
| 16 | TC-FE-SV-002 | Kiểm tra phương thức xử lý kết quả thành công | Giả lập API trả về kết quả thành công | Observable trả về kết quả thành công | Kiểm tra xử lý kết quả |
| 17 | TC-FE-SV-003 | Kiểm tra phương thức xử lý lỗi | Giả lập API trả về lỗi | Observable trả về lỗi | Kiểm tra xử lý lỗi |

#### 3.1.2. Phương thức getDoanhThuTheoThang

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 18 | TC-FE-SV-004 | Kiểm tra phương thức gọi API với tham số đúng | request = {nam: 2023, thang: 6} | HttpClient.get được gọi với URL và tham số đúng | Kiểm tra việc gọi API |
| 19 | TC-FE-SV-005 | Kiểm tra phương thức xử lý kết quả thành công | Giả lập API trả về kết quả thành công | Observable trả về kết quả thành công | Kiểm tra xử lý kết quả |
| 20 | TC-FE-SV-006 | Kiểm tra phương thức xử lý lỗi | Giả lập API trả về lỗi | Observable trả về lỗi | Kiểm tra xử lý lỗi |

#### 3.1.3. Phương thức getDoanhThuTheoNam

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 21 | TC-FE-SV-007 | Kiểm tra phương thức gọi API với tham số đúng | nam = 2023 | HttpClient.get được gọi với URL và tham số đúng | Kiểm tra việc gọi API |
| 22 | TC-FE-SV-008 | Kiểm tra phương thức xử lý kết quả thành công | Giả lập API trả về kết quả thành công | Observable trả về kết quả thành công | Kiểm tra xử lý kết quả |
| 23 | TC-FE-SV-009 | Kiểm tra phương thức xử lý lỗi | Giả lập API trả về lỗi | Observable trả về lỗi | Kiểm tra xử lý lỗi |

### 3.2. Kiểm thử ThongKeComponent

#### 3.2.1. Phương thức getDoanhThuNgay

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 24 | TC-FE-COMP-001 | Kiểm tra phương thức gọi service với tham số đúng | ngay = 15, thang = 6, nam = 2023 | baocaoService.getDoanhThuTheoNgay được gọi với tham số "2023-06-15" | Kiểm tra việc gọi service |
| 25 | TC-FE-COMP-002 | Kiểm tra phương thức xử lý kết quả thành công | Giả lập service trả về kết quả thành công | Các biến tongDoanhThu, tongHoaDon, tongHoaDonTraLai được cập nhật đúng | Kiểm tra xử lý kết quả |
| 26 | TC-FE-COMP-003 | Kiểm tra phương thức cập nhật biểu đồ | Giả lập service trả về kết quả thành công | Highcharts.chart được gọi với tham số đúng | Kiểm tra cập nhật biểu đồ |

#### 3.2.2. Phương thức getDoanhThuThang

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 27 | TC-FE-COMP-004 | Kiểm tra phương thức gọi service với tham số đúng | thang = 6, nam = 2023 | baocaoService.getDoanhThuTheoThang được gọi với tham số {nam: 2023, thang: 6} | Kiểm tra việc gọi service |
| 28 | TC-FE-COMP-005 | Kiểm tra phương thức xử lý kết quả thành công | Giả lập service trả về kết quả thành công | Các biến tongDoanhThu, tongHoaDon, tongHoaDonTraLai được cập nhật đúng | Kiểm tra xử lý kết quả |
| 29 | TC-FE-COMP-006 | Kiểm tra phương thức cập nhật biểu đồ | Giả lập service trả về kết quả thành công | Highcharts.chart được gọi với tham số đúng | Kiểm tra cập nhật biểu đồ |

#### 3.2.3. Phương thức getDoanhThuNam

| STT | Mã kiểm thử | Mục tiêu | Input | Output mong đợi | Ghi chú |
|-----|-------------|----------|-------|----------------|---------|
| 30 | TC-FE-COMP-007 | Kiểm tra phương thức gọi service với tham số đúng | nam = 2023 | baocaoService.getDoanhThuTheoNam được gọi với tham số 2023 | Kiểm tra việc gọi service |
| 31 | TC-FE-COMP-008 | Kiểm tra phương thức xử lý kết quả thành công | Giả lập service trả về kết quả thành công | Các biến tongDoanhThu, tongHoaDon, tongHoaDonTraLai được cập nhật đúng | Kiểm tra xử lý kết quả |
| 32 | TC-FE-COMP-009 | Kiểm tra phương thức cập nhật biểu đồ | Giả lập service trả về kết quả thành công | Highcharts.chart được gọi với tham số đúng | Kiểm tra cập nhật biểu đồ |

## 4. Mẫu code kiểm thử

### 4.1. Mẫu kiểm thử Backend

```java
@RunWith(MockitoJUnitRunner.class)
public class BaoCaoControllerTest {

    @Mock
    private DonHangRepo donHangRepo;

    @InjectMocks
    private BaoCaoController baoCaoController;

    @Test
    public void testDoanhThuTheoNgay_Success() {
        // Arrange
        Date ngay = new Date();
        List<DoanhThuDTO> expectedData = Arrays.asList(
            new DoanhThuDTO(8, 25000.0, 2L, 0L),
            new DoanhThuDTO(10, 18500.0, 1L, 0L)
        );
        when(donHangRepo.doanhThuTheoNgay(ngay)).thenReturn(expectedData);
        
        // Act
        ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoNgay(ngay);
        
        // Assert
        verify(donHangRepo, times(1)).doanhThuTheoNgay(ngay);
        assertEquals(200, result.getStatus());
        assertEquals("Thành công.", result.getMsg());
        assertEquals(expectedData, result.getData());
    }
}
```

### 4.2. Mẫu kiểm thử Frontend

```typescript
describe('BaoCaoService', () => {
  let service: BaoCaoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BaoCaoService]
    });
    service = TestBed.inject(BaoCaoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should call getDoanhThuTheoNgay with correct parameters', () => {
    const ngay = '2023-06-15';
    service.getDoanhThuTheoNgay(ngay).subscribe();
    
    const req = httpMock.expectOne(request => 
      request.url.includes('/baocao/doanhthutheongay') && 
      request.params.get('ngay') === ngay
    );
    expect(req.request.method).toBe('GET');
  });
});
```

## 5. Kết luận

Kế hoạch kiểm thử đơn vị này đã xác định các test case cần thiết để đảm bảo chức năng Báo cáo thống kê hoạt động chính xác. Việc thực hiện đầy đủ các test case này sẽ giúp phát hiện và khắc phục các lỗi tiềm ẩn, đồng thời cải thiện chất lượng của hệ thống.

Độ phủ kiểm thử mục tiêu:
- Statements: > 70%
- Branches: > 65%
- Functions: > 60%
- Lines: > 70%
