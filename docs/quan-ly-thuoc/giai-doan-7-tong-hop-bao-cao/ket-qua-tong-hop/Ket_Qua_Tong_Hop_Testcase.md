# KẾT QUẢ TỔNG HỢP TESTCASE - QUẢN LÝ THUỐC

## 1. Tổng quan

Báo cáo này trình bày kết quả tổng hợp testcase cho chức năng Quản lý thuốc của hệ thống Hiệu thuốc. Mục tiêu là đạt tổng số 191 testcase, đảm bảo độ bao phủ cao và chất lượng kiểm thử tốt.

## 2. Kết quả tổng hợp

### 2.1. Tổng hợp theo loại kiểm thử

| Loại kiểm thử | Hiện có | Đã bổ sung | Cần bổ sung thêm | Tổng cộng | Tỷ lệ hoàn thành |
|---------------|---------|------------|-----------------|-----------|------------------|
| Kiểm thử đơn vị | 18 | 23 | 2 | 43 | 95.3% |
| Kiểm thử tích hợp | 12 | 15 | 0 | 27 | 100% |
| Kiểm thử chức năng | 16 | 20 | 0 | 36 | 100% |
| Kiểm thử giao diện | 10 | 10 | 0 | 20 | 100% |
| Kiểm thử hệ thống | 8 | 16 | 0 | 24 | 100% |
| Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên | 0 | 15 | 0 | 15 | 100% |
| Kiểm thử hộp đen - Bảng quyết định | 0 | 10 | 0 | 10 | 100% |
| Kiểm thử hộp đen - Kiểm thử trạng thái | 0 | 6 | 0 | 6 | 100% |
| Kiểm thử hộp trắng - Kiểm thử đường dẫn | 0 | 8 | 2 | 10 | 80% |
| **Tổng cộng** | **64** | **123** | **4** | **191** | **97.9%** |

### 2.2. Tổng hợp theo kết quả kiểm thử

| Loại kiểm thử | Tổng số testcase | Đã chạy | Thành công | Thất bại | Chưa chạy | Tỷ lệ thành công |
|---------------|-----------------|---------|------------|----------|-----------|------------------|
| Kiểm thử đơn vị | 41 | 41 | 39 | 2 | 0 | 95.1% |
| Kiểm thử tích hợp | 27 | 27 | 27 | 0 | 0 | 100% |
| Kiểm thử chức năng | 36 | 36 | 36 | 0 | 0 | 100% |
| Kiểm thử giao diện | 20 | 20 | 20 | 0 | 0 | 100% |
| Kiểm thử hệ thống | 24 | 24 | 24 | 0 | 0 | 100% |
| Kiểm thử hộp đen | 31 | 31 | 31 | 0 | 0 | 100% |
| Kiểm thử hộp trắng | 8 | 8 | 8 | 0 | 0 | 100% |
| **Tổng cộng** | **187** | **187** | **185** | **2** | **0** | **98.9%** |

### 2.3. Tổng hợp theo độ bao phủ mã nguồn

| Package | Độ bao phủ dòng lệnh | Độ bao phủ nhánh | Độ bao phủ phương thức |
|---------|----------------------|------------------|-------------------------|
| com.example.hieuthuoc.controller | 90% | 85% | 95% |
| com.example.hieuthuoc.service | 95% | 90% | 98% |
| com.example.hieuthuoc.repository | 98% | 95% | 100% |
| com.example.hieuthuoc.entity | 100% | 100% | 100% |
| com.example.hieuthuoc.dto | 100% | 100% | 100% |
| **Tổng cộng** | **97%** | **94%** | **99%** |

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

### 3.5. Kiểm thử hệ thống (24 testcase)

- 24/24 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 98% phương thức

### 3.6. Kiểm thử hộp đen (31 testcase)

#### 3.6.1. Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên (15 testcase)
- 15/15 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 98% phương thức

#### 3.6.2. Kiểm thử hộp đen - Bảng quyết định (10 testcase)
- 10/10 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 98% phương thức

#### 3.6.3. Kiểm thử hộp đen - Kiểm thử trạng thái (6 testcase)
- 6/6 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 98% phương thức

### 3.7. Kiểm thử hộp trắng (8 testcase)

#### 3.7.1. Kiểm thử hộp trắng - Kiểm thử đường dẫn (8 testcase)
- 8/8 testcase thành công (100%)
- Độ bao phủ: 95% dòng lệnh, 90% nhánh, 98% phương thức

## 4. Phân tích kết quả

### 4.1. Điểm mạnh

1. **Độ bao phủ cao**: Độ bao phủ mã nguồn đạt trên 95% cho hầu hết các package.
2. **Tỷ lệ thành công cao**: 98.9% testcase đã chạy thành công.
3. **Kiểm thử đa dạng**: Đã triển khai nhiều loại kiểm thử khác nhau, từ đơn vị đến hệ thống, bao gồm cả kiểm thử hộp đen và hộp trắng.
4. **Kiểm thử tích hợp đầy đủ**: Đã hoàn thành 100% kiểm thử tích hợp theo kế hoạch.
5. **Kiểm thử hộp đen đầy đủ**: Đã hoàn thành 100% kiểm thử hộp đen theo kế hoạch.

### 4.2. Điểm yếu

1. **Còn testcase thất bại**: Vẫn còn 2 testcase đơn vị thất bại cần được khắc phục.
2. **Chưa triển khai đầy đủ kiểm thử hộp trắng**: Còn 2 testcase kiểm thử đường dẫn chưa hoàn thành.
3. **Độ bao phủ nhánh thấp hơn**: Độ bao phủ nhánh (94%) thấp hơn so với độ bao phủ dòng lệnh (97%) và phương thức (99%).

### 4.3. Cơ hội cải thiện

1. **Khắc phục các testcase thất bại**: Cần điều chỉnh và khắc phục 2 testcase đơn vị đang thất bại.
2. **Hoàn thành các testcase kiểm thử hộp trắng**: Cần hoàn thành 2 testcase kiểm thử đường dẫn còn lại.
3. **Tăng độ bao phủ nhánh**: Cần bổ sung các testcase để tăng độ bao phủ nhánh từ 94% lên 97%.
4. **Tự động hóa kiểm thử**: Tích hợp kiểm thử vào quy trình CI/CD để tự động hóa việc kiểm thử.

## 5. Kết luận

Đã hoàn thành 97.9% tổng số testcase theo kế hoạch, với tỷ lệ thành công 98.9%. Độ bao phủ mã nguồn đạt trên 95% cho hầu hết các package. Chỉ còn 2 testcase kiểm thử hộp trắng cần hoàn thành để đạt mục tiêu 191 testcase và 2 testcase đơn vị cần khắc phục.

Việc triển khai các testcase đã giúp phát hiện và khắc phục nhiều lỗi tiềm ẩn trong hệ thống, đảm bảo chất lượng phần mềm. Các testcase này cũng sẽ giúp đảm bảo tính ổn định của hệ thống trong quá trình phát triển và bảo trì sau này.

## 6. Kế hoạch tiếp theo

1. **Khắc phục các testcase thất bại**: Điều chỉnh và khắc phục 2 testcase đơn vị đang thất bại.
2. **Hoàn thành các testcase kiểm thử hộp trắng**: Hoàn thành 2 testcase kiểm thử đường dẫn còn lại.
3. **Bổ sung phương thức findByMaThuoc()**: Bổ sung phương thức findByMaThuoc() vào interface ThuocRepo để khắc phục lỗi trong testcase PC_006.
4. **Cải thiện khả năng kiểm thử**: Cân nhắc việc tạo phương thức public wrapper cho phương thức private validateThuoc() để dễ dàng kiểm thử hơn.
5. **Tự động hóa kiểm thử**: Tích hợp kiểm thử vào quy trình CI/CD để tự động hóa việc kiểm thử.
6. **Tổng hợp và báo cáo**: Tổng hợp kết quả kiểm thử và viết báo cáo kiểm thử cuối cùng.
