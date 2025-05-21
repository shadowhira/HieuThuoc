# BÁO CÁO KIỂM THỬ ĐƠN VỊ BỔ SUNG
## CHỨC NĂNG QUẢN LÝ THUỐC

### 1. Tổng quan

#### 1.1. Mục tiêu
- Bổ sung các testcase kiểm thử đơn vị cho chức năng quản lý thuốc theo kế hoạch
- Đảm bảo các phương thức hoạt động đúng với các đầu vào khác nhau
- Phát hiện lỗi sớm trong quá trình phát triển
- Tăng độ bao phủ code và chất lượng kiểm thử

#### 1.2. Phạm vi
- Kiểm thử các lớp Repository: ThuocRepo, LoaiThuocRepo, DanhMucThuocRepo
- Kiểm thử các lớp Service: ThuocService, LoaiThuocService, DanhMucThuocService
- Tập trung vào các phương thức CRUD, tìm kiếm, xử lý đầu vào và xử lý ngoại lệ

#### 1.3. Công cụ và môi trường
- Ngôn ngữ: Java
- Framework kiểm thử: JUnit 5
- Framework mock: Mockito
- Môi trường: Spring Boot Test

### 2. Kết quả kiểm thử

#### 2.1. Tổng hợp kết quả

| Loại test | Số lượng testcase | Số testcase Pass | Số testcase Fail | Tỷ lệ Pass |
|-----------|-------------------|------------------|------------------|------------|
| ThuocRepo | 5 | 5 | 0 | 100% |
| ThuocService | 5 | 5 | 0 | 100% |
| ThuocService - Xử lý đầu vào | 4 | 0 | 4 | 0% |
| ThuocService - Xử lý ngoại lệ | 4 | 3 | 1 | 75% |
| LoaiThuocService | 3 | 2 | 1 | 66.7% |
| DanhMucThuocService | 2 | 2 | 0 | 100% |
| **Tổng cộng** | **23** | **17** | **6** | **73.9%** |

#### 2.2. Chi tiết kết quả theo nhóm

##### 2.2.1. ThuocRepo
- Tất cả 5 testcase đều Pass (100%)
- Các phương thức đã kiểm thử: findByTenThuoc(), existsByMaThuoc(), existsByTenThuoc(), search()
- Không phát hiện lỗi

##### 2.2.2. ThuocService
- Tất cả 5 testcase đều Pass (100%)
- Các phương thức đã kiểm thử: getById(), search(), delete()
- Không phát hiện lỗi

##### 2.2.3. ThuocService - Xử lý đầu vào
- Tất cả 4 testcase đều Fail (0%)
- Các testcase: create() với tên thuốc trống, mã thuốc trống, danh sách thành phần thuốc rỗng, danh sách đối tượng sử dụng rỗng
- Nguyên nhân: Code hiện tại chưa có kiểm tra đầu vào đầy đủ

##### 2.2.4. ThuocService - Xử lý ngoại lệ
- 3/4 testcase Pass (75%)
- Testcase Fail: search_WhenRepositoryThrowsException
- Nguyên nhân: Cách xử lý ngoại lệ trong phương thức search() chưa đúng

##### 2.2.5. LoaiThuocService
- 2/3 testcase Pass (66.7%)
- Testcase Fail: create_DanhMucThuocNotFound
- Nguyên nhân: Cách xử lý ngoại lệ khi danh mục thuốc không tồn tại chưa đúng

##### 2.2.6. DanhMucThuocService
- Tất cả 2 testcase đều Pass (100%)
- Các phương thức đã kiểm thử: update(), delete()
- Không phát hiện lỗi

### 3. Phân tích lỗi

#### 3.1. Lỗi xử lý đầu vào trong ThuocService
- **Mô tả**: ThuocService không kiểm tra đầu vào như tên thuốc trống, mã thuốc trống, danh sách thành phần thuốc rỗng, danh sách đối tượng sử dụng rỗng
- **Ảnh hưởng**: Có thể tạo thuốc với dữ liệu không hợp lệ
- **Đề xuất**: Bổ sung kiểm tra đầu vào trong phương thức create() và update()

#### 3.2. Lỗi xử lý ngoại lệ trong ThuocService.search()
- **Mô tả**: Phương thức search() không xử lý ngoại lệ khi repository ném ngoại lệ
- **Ảnh hưởng**: Có thể gây crash ứng dụng khi có lỗi từ database
- **Đề xuất**: Bổ sung try-catch trong phương thức search()

#### 3.3. Lỗi xử lý ngoại lệ trong LoaiThuocService.create()
- **Mô tả**: Phương thức create() ném ngoại lệ RuntimeException khi danh mục thuốc không tồn tại
- **Ảnh hưởng**: Có thể gây crash ứng dụng khi danh mục thuốc không tồn tại
- **Đề xuất**: Thay đổi cách xử lý để trả về ResponseDTO với status 404 thay vì ném ngoại lệ

### 4. Đề xuất cải tiến

#### 4.1. Cải tiến code
- Bổ sung kiểm tra đầu vào trong ThuocService:
  ```java
  if (thuocDTO.getTenThuoc() == null || thuocDTO.getTenThuoc().trim().isEmpty()) {
      return ResponseDTO.<Thuoc>builder()
              .status(400)
              .msg("Tên thuốc không hợp lệ")
              .build();
  }
  
  if (thuocDTO.getMaThuoc() == null || thuocDTO.getMaThuoc().trim().isEmpty()) {
      return ResponseDTO.<Thuoc>builder()
              .status(400)
              .msg("Mã thuốc không hợp lệ")
              .build();
  }
  
  if (thuocDTO.getThanhPhanThuocs() == null || thuocDTO.getThanhPhanThuocs().isEmpty()) {
      return ResponseDTO.<Thuoc>builder()
              .status(400)
              .msg("Danh sách thành phần thuốc không hợp lệ")
              .build();
  }
  
  if (thuocDTO.getDoiTuongs() == null || thuocDTO.getDoiTuongs().isEmpty()) {
      return ResponseDTO.<Thuoc>builder()
              .status(400)
              .msg("Danh sách đối tượng sử dụng không hợp lệ")
              .build();
  }
  ```
- Bổ sung xử lý ngoại lệ trong phương thức search():
  ```java
  try {
      Page<Thuoc> page = thuocRepo.search(
          searchThuocDTO.getKeyWord(),
          searchThuocDTO.getLoaiThuoc(),
          searchThuocDTO.getNhaSanXuat(),
          searchThuocDTO.getDanhMucThuoc(),
          searchThuocDTO.getMinGiaBan(),
          searchThuocDTO.getMaxGiaBan(),
          searchThuocDTO.getTenDoiTuong(),
          searchThuocDTO.getTrangThai(),
          pageable
      );
      
      // Xử lý kết quả
      
  } catch (Exception e) {
      return ResponseDTO.<PageDTO<List<Thuoc>>>builder()
              .status(500)
              .msg("Lỗi hệ thống: " + e.getMessage())
              .build();
  }
  ```
- Thay đổi cách xử lý trong LoaiThuocService.create():
  ```java
  Optional<DanhMucThuoc> danhMucThuocOpt = danhMucThuocRepo.findById(loaiThuocDTO.getDanhMucThuocId());
  if (danhMucThuocOpt.isEmpty()) {
      return ResponseDTO.<LoaiThuoc>builder()
              .status(404)
              .msg("Không tìm thấy danh mục thuốc")
              .build();
  }
  ```

#### 4.2. Cải tiến kiểm thử
- Bổ sung thêm testcase cho các trường hợp đặc biệt
- Sử dụng @ParameterizedTest để kiểm thử với nhiều bộ dữ liệu
- Tăng độ phủ code (code coverage)
- Tổ chức lại cấu trúc testcase để dễ bảo trì

### 5. Kết luận

Qua quá trình bổ sung kiểm thử đơn vị cho chức năng quản lý thuốc, chúng tôi đã phát hiện một số lỗi liên quan đến xử lý đầu vào và xử lý ngoại lệ. Tỷ lệ testcase Pass là 73.9%, cho thấy cần cải tiến code để đảm bảo chất lượng phần mềm.

Các lỗi chính tập trung vào việc thiếu kiểm tra đầu vào và xử lý ngoại lệ chưa đúng cách. Việc sửa các lỗi này sẽ giúp tăng độ tin cậy của hệ thống và giảm thiểu rủi ro khi triển khai.

Chúng tôi đã bổ sung thành công 23 testcase theo kế hoạch, đạt 92% so với mục tiêu ban đầu (25 testcase). Các testcase còn lại sẽ được bổ sung trong các giai đoạn tiếp theo.

### 6. Phụ lục

#### 6.1. Danh sách testcase
Xem chi tiết tại file: `docs/quan-ly-thuoc/giai-doan-2-unit-test/testcase/ThuocTestCase_BoSung.csv`

#### 6.2. Mã nguồn kiểm thử
- ThuocRepoTest2.java
- ThuocServiceTest.java
- ThuocServiceInputTest.java
- ThuocServiceExceptionTest.java
- LoaiThuocServiceTest.java
- DanhMucThuocServiceTest.java
