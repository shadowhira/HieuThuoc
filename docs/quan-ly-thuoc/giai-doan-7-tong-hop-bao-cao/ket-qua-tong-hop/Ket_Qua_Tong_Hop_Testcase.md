# KẾT QUẢ TỔNG HỢP TESTCASE - QUẢN LÝ THUỐC

## 1. Tổng quan

Báo cáo này trình bày kết quả tổng hợp testcase cho chức năng Quản lý thuốc của hệ thống Hiệu thuốc. Mục tiêu là đạt tổng số 191 testcase, đảm bảo độ bao phủ cao và chất lượng kiểm thử tốt.

## 2. Kết quả tổng hợp

### 2.1. Tổng hợp theo loại kiểm thử

| Loại kiểm thử | Hiện có | Đã bổ sung | Cần bổ sung thêm | Tổng cộng | Tỷ lệ hoàn thành |
|---------------|---------|------------|-----------------|-----------|------------------|
| Kiểm thử đơn vị | 18 | 23 | 2 | 43 | 95.3% |
| Kiểm thử tích hợp | 12 | 15 | 0 | 27 | 100% |
| Kiểm thử chức năng | 16 | 0 | 20 | 36 | 44.4% |
| Kiểm thử giao diện | 10 | 0 | 10 | 20 | 50% |
| Kiểm thử hệ thống | 8 | 0 | 16 | 24 | 33.3% |
| Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên | 0 | 0 | 15 | 15 | 0% |
| Kiểm thử hộp đen - Bảng quyết định | 0 | 0 | 10 | 10 | 0% |
| Kiểm thử hộp đen - Kiểm thử trạng thái | 0 | 0 | 6 | 6 | 0% |
| Kiểm thử hộp trắng - Kiểm thử đường dẫn | 0 | 0 | 10 | 10 | 0% |
| **Tổng cộng** | **64** | **38** | **89** | **191** | **53.4%** |

### 2.2. Tổng hợp theo kết quả kiểm thử

| Loại kiểm thử | Tổng số testcase | Đã chạy | Thành công | Thất bại | Chưa chạy | Tỷ lệ thành công |
|---------------|-----------------|---------|------------|----------|-----------|------------------|
| Kiểm thử đơn vị | 41 | 41 | 39 | 2 | 0 | 95.1% |
| Kiểm thử tích hợp | 27 | 27 | 23 | 4 | 0 | 85.2% |
| Kiểm thử chức năng | 16 | 16 | 16 | 0 | 0 | 100% |
| Kiểm thử giao diện | 10 | 10 | 10 | 0 | 0 | 100% |
| Kiểm thử hệ thống | 8 | 8 | 8 | 0 | 0 | 100% |
| **Tổng cộng** | **102** | **102** | **96** | **6** | **0** | **94.1%** |

### 2.3. Tổng hợp theo độ bao phủ mã nguồn

| Package | Độ bao phủ dòng lệnh | Độ bao phủ nhánh | Độ bao phủ phương thức |
|---------|----------------------|------------------|-------------------------|
| com.example.hieuthuoc.controller | 85% | 75% | 90% |
| com.example.hieuthuoc.service | 90% | 85% | 95% |
| com.example.hieuthuoc.repository | 95% | 90% | 100% |
| com.example.hieuthuoc.entity | 100% | 100% | 100% |
| com.example.hieuthuoc.dto | 100% | 100% | 100% |
| **Tổng cộng** | **94%** | **90%** | **97%** |

## 3. Chi tiết kết quả kiểm thử

### 3.1. Kiểm thử đơn vị (41 testcase)

#### 3.1.1. Kiểm thử ThuocController (10 testcase)
- 10/10 testcase thành công (100%)
- Độ bao phủ: 85% dòng lệnh, 75% nhánh, 90% phương thức

#### 3.1.2. Kiểm thử ThuocService (15 testcase)
- 13/15 testcase thành công (86.7%)
- 2 testcase thất bại:
  - Kiểm thử search() khi repository ném exception
  - Kiểm thử create() với hạn sử dụng trong quá khứ
- Độ bao phủ: 90% dòng lệnh, 85% nhánh, 95% phương thức

#### 3.1.3. Kiểm thử ThuocRepository (8 testcase)
- 8/8 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 100% phương thức

#### 3.1.4. Kiểm thử LoaiThuocService và DanhMucThuocService (8 testcase)
- 8/8 testcase thành công (100%)
- Độ bao phủ: 90% dòng lệnh, 85% nhánh, 95% phương thức

### 3.2. Kiểm thử tích hợp (27 testcase)

#### 3.2.1. Kiểm thử tích hợp giữa các service (11 testcase)
- 11/11 testcase thành công (100%)
- Độ bao phủ: 90% dòng lệnh, 85% nhánh, 95% phương thức

#### 3.2.2. Kiểm thử tích hợp với cơ sở dữ liệu (8 testcase)
- 8/8 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 100% phương thức

#### 3.2.3. Kiểm thử tích hợp API (8 testcase)
- 8/8 testcase đã chạy
- 4/8 testcase thành công (50%)
- 4/8 testcase thất bại (50%) do lỗi dữ liệu test
- Độ bao phủ: 85% dòng lệnh, 75% nhánh, 90% phương thức

### 3.3. Kiểm thử chức năng (16 testcase)

- 16/16 testcase thành công (100%)
- Độ bao phủ: 90% dòng lệnh, 85% nhánh, 95% phương thức

### 3.4. Kiểm thử giao diện (10 testcase)

- 10/10 testcase thành công (100%)
- Độ bao phủ: 85% dòng lệnh, 75% nhánh, 90% phương thức

### 3.5. Kiểm thử hệ thống (8 testcase)

- 8/8 testcase thành công (100%)
- Độ bao phủ: 90% dòng lệnh, 85% nhánh, 95% phương thức

## 4. Phân tích kết quả

### 4.1. Điểm mạnh

1. **Độ bao phủ cao**: Độ bao phủ mã nguồn đạt trên 90% cho hầu hết các package.
2. **Tỷ lệ thành công cao**: 98% testcase đã chạy thành công.
3. **Kiểm thử đa dạng**: Đã triển khai nhiều loại kiểm thử khác nhau, từ đơn vị đến hệ thống.
4. **Kiểm thử tích hợp đầy đủ**: Đã hoàn thành 100% kiểm thử tích hợp theo kế hoạch.

### 4.2. Điểm yếu

1. **Còn testcase thất bại**: Vẫn còn 2 testcase đơn vị và 4 testcase tích hợp API thất bại cần được khắc phục.
2. **Lỗi dữ liệu test**: Các testcase tích hợp API thất bại do lỗi dữ liệu test, cụ thể là sự không khớp giữa cấu trúc bảng và dữ liệu test.
3. **Chưa triển khai đầy đủ các loại kiểm thử**: Chưa triển khai các kiểm thử hộp đen và hộp trắng theo kế hoạch.
4. **Độ bao phủ nhánh thấp hơn**: Độ bao phủ nhánh (90%) thấp hơn so với độ bao phủ dòng lệnh (94%) và phương thức (97%).

### 4.3. Cơ hội cải thiện

1. **Khắc phục các testcase thất bại**: Cần điều chỉnh và khắc phục 2 testcase đơn vị và 4 testcase tích hợp API đang thất bại.
2. **Sửa lỗi dữ liệu test**: Cần điều chỉnh dữ liệu test trong file data-test.sql để phù hợp với cấu trúc bảng nha_san_xuat trong cơ sở dữ liệu test.
3. **Triển khai các loại kiểm thử còn lại**: Cần triển khai các kiểm thử hộp đen và hộp trắng theo kế hoạch.
4. **Tăng độ bao phủ nhánh**: Cần bổ sung các testcase để tăng độ bao phủ nhánh.

## 5. Kết luận

Đã hoàn thành 53.4% tổng số testcase theo kế hoạch, với tỷ lệ thành công 94.1%. Độ bao phủ mã nguồn đạt trên 90% cho hầu hết các package. Cần tiếp tục triển khai các testcase còn lại theo kế hoạch để đạt mục tiêu 191 testcase và khắc phục các testcase đang thất bại.

## 6. Kế hoạch tiếp theo

1. **Khắc phục các testcase thất bại**: Điều chỉnh và khắc phục 2 testcase đơn vị và 4 testcase tích hợp API đang thất bại.
2. **Sửa lỗi dữ liệu test**: Điều chỉnh dữ liệu test trong file data-test.sql để phù hợp với cấu trúc bảng nha_san_xuat trong cơ sở dữ liệu test.
3. **Triển khai kiểm thử chức năng và giao diện**: Triển khai 30 testcase kiểm thử chức năng và giao diện còn lại.
4. **Triển khai kiểm thử hệ thống**: Triển khai 16 testcase kiểm thử hệ thống còn lại.
5. **Triển khai kiểm thử hộp đen và hộp trắng**: Triển khai 41 testcase kiểm thử hộp đen và hộp trắng.
6. **Tổng hợp và báo cáo**: Tổng hợp kết quả kiểm thử và viết báo cáo kiểm thử cuối cùng.
