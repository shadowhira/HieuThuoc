# Test Case Phân hệ Báo cáo và Thống kê

## 1. Kiểm thử giao diện (UI Testing)

### 1.1. Kiểm thử giao diện báo cáo doanh thu

#### TC-UI-001: Kiểm tra hiển thị giao diện báo cáo doanh thu theo ngày

- **Mô tả**: Kiểm tra hiển thị giao diện báo cáo doanh thu theo ngày
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong ngày cần báo cáo
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo ngày"
  3. Chọn ngày cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo giờ trong ngày
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Giờ, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong ngày
  4. Biểu đồ và bảng dữ liệu được hiển thị đúng với dữ liệu từ backend
  5. Giao diện responsive, hiển thị tốt trên các thiết bị desktop, tablet, mobile

#### TC-UI-002: Kiểm tra hiển thị giao diện báo cáo doanh thu theo tháng

- **Mô tả**: Kiểm tra hiển thị giao diện báo cáo doanh thu theo tháng
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong tháng cần báo cáo
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo tháng"
  3. Chọn tháng và năm cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo ngày trong tháng
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Ngày, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong tháng
  4. Biểu đồ và bảng dữ liệu được hiển thị đúng với dữ liệu từ backend
  5. Giao diện responsive, hiển thị tốt trên các thiết bị desktop, tablet, mobile

#### TC-UI-003: Kiểm tra hiển thị giao diện báo cáo doanh thu theo năm

- **Mô tả**: Kiểm tra hiển thị giao diện báo cáo doanh thu theo năm
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong năm cần báo cáo
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo năm"
  3. Chọn năm cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo tháng trong năm
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Tháng, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong năm
  4. Biểu đồ và bảng dữ liệu được hiển thị đúng với dữ liệu từ backend
  5. Giao diện responsive, hiển thị tốt trên các thiết bị desktop, tablet, mobile

### 1.2. Kiểm thử giao diện báo cáo tồn kho

#### TC-UI-004: Kiểm tra hiển thị giao diện báo cáo tồn kho

- **Mô tả**: Kiểm tra hiển thị giao diện báo cáo tồn kho
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Có dữ liệu tồn kho
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Tồn kho"
  2. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị bảng dữ liệu tồn kho với các cột: Mã thuốc, Tên thuốc, Số lượng tồn, Đơn vị, Hạn sử dụng, Trạng thái
  2. Các thuốc sắp hết hàng (số lượng dưới ngưỡng cảnh báo) được đánh dấu màu vàng
  3. Các thuốc sắp hết hạn (trong vòng thời gian cảnh báo) được đánh dấu màu đỏ
  4. Bảng dữ liệu được hiển thị đúng với dữ liệu từ backend
  5. Giao diện responsive, hiển thị tốt trên các thiết bị desktop, tablet, mobile

### 1.3. Kiểm thử giao diện báo cáo thuốc bán chạy

#### TC-UI-005: Kiểm tra hiển thị giao diện báo cáo thuốc bán chạy

- **Mô tả**: Kiểm tra hiển thị giao diện báo cáo thuốc bán chạy
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Có dữ liệu đơn hàng
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Thuốc bán chạy"
  2. Chọn khoảng thời gian cần báo cáo
  3. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ top 10 thuốc bán chạy nhất
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Mã thuốc, Tên thuốc, Số lượng bán, Doanh thu
  3. Danh sách được sắp xếp theo thứ tự giảm dần về số lượng bán
  4. Biểu đồ và bảng dữ liệu được hiển thị đúng với dữ liệu từ backend
  5. Giao diện responsive, hiển thị tốt trên các thiết bị desktop, tablet, mobile

## 2. Kiểm thử đơn vị (Unit Testing)

### 2.1. Kiểm thử đơn vị BaoCaoController

#### TC-UT-001: Kiểm thử phương thức doanhThuTheoNgay

- **Mô tả**: Kiểm thử phương thức doanhThuTheoNgay trong BaoCaoController
- **Điều kiện tiên quyết**: Không có
- **Các bước thực hiện**:
  1. Tạo mock object cho DonHangRepo
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức doanhThuTheoNgay với tham số ngày
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. Phương thức donHangRepo.doanhThuTheoNgay được gọi đúng 1 lần với tham số ngày
  2. Kết quả trả về là ResponseDTO với status 200, message "Thành công." và data là danh sách DoanhThuDTO

```java
@Test
public void testDoanhThuTheoNgay() {
    // Arrange
    Date ngay = new Date();
    List<DoanhThuDTO> expectedData = Arrays.asList(new DoanhThuDTO(1, 1000000.0, 10, 2));
    when(donHangRepo.doanhThuTheoNgay(ngay)).thenReturn(expectedData);
    
    // Act
    ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoNgay(ngay);
    
    // Assert
    verify(donHangRepo, times(1)).doanhThuTheoNgay(ngay);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công.", result.getMsg());
    assertEquals(expectedData, result.getData());
}
```

#### TC-UT-002: Kiểm thử phương thức doanhThuTheoThang

- **Mô tả**: Kiểm thử phương thức doanhThuTheoThang trong BaoCaoController
- **Điều kiện tiên quyết**: Không có
- **Các bước thực hiện**:
  1. Tạo mock object cho DonHangRepo
  2. Thiết lập hành vi mong đợi cho mock object
  3. Gọi phương thức doanhThuTheoThang với tham số năm và tháng
  4. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. Phương thức donHangRepo.doanhThuTheoThang được gọi đúng 1 lần với tham số năm và tháng
  2. Kết quả trả về là ResponseDTO với status 200, message "Thành công." và data là danh sách DoanhThuDTO

```java
@Test
public void testDoanhThuTheoThang() {
    // Arrange
    int nam = 2023;
    int thang = 6;
    List<DoanhThuDTO> expectedData = Arrays.asList(new DoanhThuDTO(1, 1000000.0, 10, 2));
    when(donHangRepo.doanhThuTheoThang(nam, thang)).thenReturn(expectedData);
    
    // Act
    ResponseDTO<List<DoanhThuDTO>> result = baoCaoController.doanhThuTheoThang(nam, thang);
    
    // Assert
    verify(donHangRepo, times(1)).doanhThuTheoThang(nam, thang);
    assertEquals(200, result.getStatus());
    assertEquals("Thành công.", result.getMsg());
    assertEquals(expectedData, result.getData());
}
```

### 2.2. Kiểm thử đơn vị DonHangRepo

#### TC-UT-003: Kiểm thử query doanhThuTheoNgay

- **Mô tả**: Kiểm thử query doanhThuTheoNgay trong DonHangRepo
- **Điều kiện tiên quyết**: Có dữ liệu đơn hàng trong cơ sở dữ liệu
- **Các bước thực hiện**:
  1. Tạo dữ liệu test trong cơ sở dữ liệu
  2. Gọi phương thức doanhThuTheoNgay với tham số ngày
  3. Kiểm tra kết quả trả về
- **Kết quả mong đợi**:
  1. Kết quả trả về là danh sách DoanhThuDTO
  2. Danh sách có số lượng phần tử đúng với số giờ có đơn hàng trong ngày
  3. Mỗi phần tử trong danh sách có thông tin đúng về giờ, tổng doanh thu, tổng số đơn hàng, tổng số đơn hàng trả lại

## 3. Kiểm thử hộp đen (Black Box Testing)

### 3.1. Kiểm thử chức năng báo cáo doanh thu

#### TC-BB-001: Kiểm thử báo cáo doanh thu theo ngày

- **Mô tả**: Kiểm thử chức năng báo cáo doanh thu theo ngày
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Có dữ liệu đơn hàng trong ngày cần báo cáo
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo ngày"
  3. Chọn ngày cần báo cáo
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ doanh thu theo giờ trong ngày
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Giờ, Doanh thu, Số đơn hàng, Số đơn trả lại
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại trong ngày
  4. Dữ liệu hiển thị chính xác với dữ liệu trong cơ sở dữ liệu

#### TC-BB-002: Kiểm thử báo cáo doanh thu với ngày không có dữ liệu

- **Mô tả**: Kiểm thử chức năng báo cáo doanh thu với ngày không có dữ liệu
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin hoặc Manager
  - Không có dữ liệu đơn hàng trong ngày cần báo cáo
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Doanh thu"
  2. Chọn tab "Theo ngày"
  3. Chọn ngày không có dữ liệu
  4. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ trống hoặc với giá trị 0
  2. Hiển thị bảng dữ liệu trống hoặc với giá trị 0
  3. Hiển thị tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại là 0
  4. Không hiển thị thông báo lỗi

### 3.2. Kiểm thử chức năng báo cáo tồn kho

#### TC-BB-003: Kiểm thử báo cáo tồn kho

- **Mô tả**: Kiểm thử chức năng báo cáo tồn kho
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Có dữ liệu tồn kho
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Tồn kho"
  2. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị bảng dữ liệu tồn kho với các cột: Mã thuốc, Tên thuốc, Số lượng tồn, Đơn vị, Hạn sử dụng, Trạng thái
  2. Các thuốc sắp hết hàng (số lượng dưới ngưỡng cảnh báo) được đánh dấu màu vàng
  3. Các thuốc sắp hết hạn (trong vòng thời gian cảnh báo) được đánh dấu màu đỏ
  4. Dữ liệu hiển thị chính xác với dữ liệu trong cơ sở dữ liệu

### 3.3. Kiểm thử chức năng báo cáo thuốc bán chạy

#### TC-BB-004: Kiểm thử báo cáo thuốc bán chạy

- **Mô tả**: Kiểm thử chức năng báo cáo thuốc bán chạy
- **Điều kiện tiên quyết**: 
  - Đã đăng nhập với quyền Admin, Manager hoặc Pharmacist
  - Có dữ liệu đơn hàng
- **Các bước thực hiện**:
  1. Truy cập menu "Báo cáo" > "Thuốc bán chạy"
  2. Chọn khoảng thời gian cần báo cáo
  3. Nhấn nút "Xem báo cáo"
- **Kết quả mong đợi**:
  1. Hiển thị biểu đồ top 10 thuốc bán chạy nhất
  2. Hiển thị bảng dữ liệu chi tiết với các cột: Mã thuốc, Tên thuốc, Số lượng bán, Doanh thu
  3. Danh sách được sắp xếp theo thứ tự giảm dần về số lượng bán
  4. Dữ liệu hiển thị chính xác với dữ liệu trong cơ sở dữ liệu
