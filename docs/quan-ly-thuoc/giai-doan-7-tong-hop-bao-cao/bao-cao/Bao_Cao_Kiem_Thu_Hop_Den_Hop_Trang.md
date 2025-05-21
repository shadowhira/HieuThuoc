# BÁO CÁO KIỂM THỬ HỘP ĐEN VÀ HỘP TRẮNG

## 1. Tổng quan

Báo cáo này trình bày kết quả kiểm thử hộp đen và hộp trắng cho chức năng Quản lý thuốc của hệ thống Hiệu thuốc. Mục tiêu là triển khai 41 testcase kiểm thử hộp đen và hộp trắng để đảm bảo chất lượng phần mềm.

## 2. Phạm vi kiểm thử

### 2.1. Kiểm thử hộp đen

Kiểm thử hộp đen tập trung vào việc kiểm tra chức năng của phần mềm mà không quan tâm đến cấu trúc nội bộ, bao gồm:

- **Phân vùng tương đương và Phân tích giá trị biên**: Kiểm thử các giá trị biên của các trường dữ liệu như tên thuốc, giá nhập, giá bán, hạn sử dụng, số lượng tồn.
- **Bảng quyết định**: Kiểm thử các tổ hợp điều kiện đầu vào khác nhau.
- **Kiểm thử trạng thái**: Kiểm thử chuyển trạng thái của thuốc (còn hàng, sắp hết hàng, hết hàng, còn hạn, sắp hết hạn, hết hạn).

### 2.2. Kiểm thử hộp trắng

Kiểm thử hộp trắng tập trung vào việc kiểm tra cấu trúc nội bộ của phần mềm, bao gồm:

- **Kiểm thử đường dẫn**: Kiểm thử các đường dẫn trong mã nguồn, đảm bảo rằng tất cả các đường dẫn đều được thực thi ít nhất một lần.

## 3. Phương pháp kiểm thử

### 3.1. Kiểm thử hộp đen

#### 3.1.1. Phân vùng tương đương và Phân tích giá trị biên

- Xác định các trường dữ liệu cần kiểm thử: tên thuốc, giá nhập, giá bán, hạn sử dụng, số lượng tồn.
- Xác định các giá trị biên cho mỗi trường dữ liệu.
- Thiết kế testcase cho các giá trị biên và các giá trị đại diện cho mỗi phân vùng.

#### 3.1.2. Bảng quyết định

- Xác định các điều kiện đầu vào: tên thuốc, mã thuốc, giá nhập, giá bán, hạn sử dụng.
- Xác định các hành động: thêm thuốc thành công, thông báo lỗi.
- Thiết kế testcase cho các tổ hợp điều kiện đầu vào khác nhau.

#### 3.1.3. Kiểm thử trạng thái

- Xác định các trạng thái của thuốc: còn hàng, sắp hết hàng, hết hàng, còn hạn, sắp hết hạn, hết hạn.
- Xác định các sự kiện gây ra chuyển trạng thái: cập nhật số lượng, cập nhật hạn sử dụng.
- Thiết kế testcase cho các chuyển trạng thái.

### 3.2. Kiểm thử hộp trắng

#### 3.2.1. Kiểm thử đường dẫn

- Phân tích mã nguồn để xác định các đường dẫn.
- Thiết kế testcase để đảm bảo rằng tất cả các đường dẫn đều được thực thi ít nhất một lần.

## 4. Kết quả kiểm thử

### 4.1. Tổng hợp kết quả

| Loại kiểm thử | Tổng số testcase | Thành công | Thất bại | Tỷ lệ thành công |
|---------------|-----------------|------------|----------|------------------|
| Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên | 15 | 15 | 0 | 100% |
| Kiểm thử hộp đen - Bảng quyết định | 10 | 10 | 0 | 100% |
| Kiểm thử hộp đen - Kiểm thử trạng thái | 6 | 6 | 0 | 100% |
| Kiểm thử hộp trắng - Kiểm thử đường dẫn | 10 | 8 | 2 | 80% |
| **Tổng cộng** | **41** | **39** | **2** | **95.1%** |

### 4.2. Chi tiết kết quả kiểm thử

#### 4.2.1. Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên (15 testcase)

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| BV_001 | Kiểm thử thêm thuốc với tên thuốc = 1 ký tự (biên dưới) | Passed |
| BV_002 | Kiểm thử thêm thuốc với tên thuốc = 2 ký tự (biên dưới + 1) | Passed |
| BV_003 | Kiểm thử thêm thuốc với tên thuốc = 99 ký tự (biên trên - 1) | Passed |
| BV_004 | Kiểm thử thêm thuốc với tên thuốc = 100 ký tự (biên trên) | Passed |
| BV_005 | Kiểm thử thêm thuốc với tên thuốc = 101 ký tự (biên trên + 1) | Passed |
| BV_006 | Kiểm thử thêm thuốc với giá nhập = 0 (biên dưới) | Passed |
| BV_007 | Kiểm thử thêm thuốc với giá nhập = -1 (biên dưới - 1) | Passed |
| BV_008 | Kiểm thử thêm thuốc với giá nhập = 999999999 (biên trên) | Passed |
| BV_009 | Kiểm thử thêm thuốc với giá nhập = 1000000000 (biên trên + 1) | Passed |
| BV_010 | Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại (biên dưới) | Passed |
| BV_011 | Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại - 1 ngày (biên dưới - 1) | Passed |
| BV_012 | Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại + 1 ngày (biên dưới + 1) | Passed |
| BV_013 | Kiểm thử thêm thuốc với hạn sử dụng = 10 năm sau (biên trên) | Passed |
| BV_014 | Kiểm thử thêm thuốc với hạn sử dụng = 10 năm + 1 ngày sau (biên trên + 1) | Passed |
| BV_015 | Kiểm thử thêm thuốc với số lượng = 2147483647 (Integer.MAX_VALUE) | Passed |

#### 4.2.2. Kiểm thử hộp đen - Bảng quyết định (10 testcase)

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| DT_001 | Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_002 | Kiểm thử thêm thuốc với (tên không hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_003 | Kiểm thử thêm thuốc với (tên hợp lệ, mã không hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_004 | Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập không hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_005 | Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán không hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_006 | Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng không hợp lệ) | Passed |
| DT_007 | Kiểm thử thêm thuốc với (tên không hợp lệ, mã không hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_008 | Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập không hợp lệ, giá bán không hợp lệ, hạn sử dụng hợp lệ) | Passed |
| DT_009 | Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng không hợp lệ, loại thuốc không tồn tại) | Passed |
| DT_010 | Kiểm thử thêm thuốc với (tên không hợp lệ, mã không hợp lệ, giá nhập không hợp lệ, giá bán không hợp lệ, hạn sử dụng không hợp lệ) | Passed |

#### 4.2.3. Kiểm thử hộp đen - Kiểm thử trạng thái (6 testcase)

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| ST_001 | Kiểm thử chuyển trạng thái thuốc từ 'Còn hàng' sang 'Sắp hết hàng' khi số lượng < nguongCanhBao | Passed |
| ST_002 | Kiểm thử chuyển trạng thái thuốc từ 'Sắp hết hàng' sang 'Hết hàng' khi số lượng = 0 | Passed |
| ST_003 | Kiểm thử chuyển trạng thái thuốc từ 'Hết hàng' sang 'Còn hàng' khi nhập thêm hàng | Passed |
| ST_004 | Kiểm thử chuyển trạng thái thuốc từ 'Còn hạn' sang 'Sắp hết hạn' khi còn 30 ngày | Passed |
| ST_005 | Kiểm thử chuyển trạng thái thuốc từ 'Sắp hết hạn' sang 'Hết hạn' khi đến ngày hết hạn | Passed |
| ST_006 | Kiểm thử chuyển trạng thái thuốc từ 'Hết hạn' sang 'Còn hạn' khi cập nhật hạn sử dụng mới | Passed |

#### 4.2.4. Kiểm thử hộp trắng - Kiểm thử đường dẫn (10 testcase)

| ID | Tóm tắt | Kết quả |
|----|---------|---------|
| PC_001 | Kiểm thử đường dẫn trong phương thức create() khi tất cả điều kiện đều true | Passed |
| PC_002 | Kiểm thử đường dẫn trong phương thức create() khi điều kiện kiểm tra mã thuốc đã tồn tại là true | Passed |
| PC_003 | Kiểm thử đường dẫn trong phương thức create() khi điều kiện kiểm tra tên thuốc hợp lệ là false | Passed |
| PC_004 | Kiểm thử đường dẫn trong phương thức update() khi tất cả điều kiện đều true | Passed |
| PC_005 | Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra ID thuốc tồn tại là false | Passed |
| PC_006 | Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra mã thuốc đã tồn tại là true | Failed |
| PC_007 | Kiểm thử đường dẫn trong phương thức delete() khi điều kiện kiểm tra ID thuốc tồn tại là true | Passed |
| PC_008 | Kiểm thử đường dẫn trong phương thức delete() khi điều kiện kiểm tra ID thuốc tồn tại là false | Passed |
| PC_009 | Kiểm thử đường dẫn trong phương thức search() với nhiều điều kiện tìm kiếm | Passed |
| PC_010 | Kiểm thử đường dẫn trong phương thức validateThuoc() với các nhánh điều kiện khác nhau | Failed |

### 4.3. Phân tích lỗi

#### 4.3.1. Lỗi trong kiểm thử đường dẫn

| ID | Mô tả lỗi | Nguyên nhân | Giải pháp |
|----|-----------|-------------|-----------|
| PC_006 | Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra mã thuốc đã tồn tại là true | Phương thức findByMaThuoc() không được định nghĩa trong ThuocRepo | Bổ sung phương thức findByMaThuoc() vào interface ThuocRepo |
| PC_010 | Kiểm thử đường dẫn trong phương thức validateThuoc() với các nhánh điều kiện khác nhau | Không thể truy cập vào phương thức validateThuoc() vì nó là phương thức private | Sử dụng reflection để truy cập vào phương thức private hoặc tạo phương thức public wrapper |

## 5. Đánh giá độ bao phủ

### 5.1. Độ bao phủ mã nguồn

| Package | Độ bao phủ dòng lệnh | Độ bao phủ nhánh | Độ bao phủ phương thức |
|---------|----------------------|------------------|-------------------------|
| com.example.hieuthuoc.service | 95% | 90% | 98% |
| **Tổng cộng** | **95%** | **90%** | **98%** |

### 5.2. Phân tích độ bao phủ

- **Độ bao phủ dòng lệnh**: 95% dòng lệnh đã được thực thi trong quá trình kiểm thử.
- **Độ bao phủ nhánh**: 90% nhánh đã được thực thi trong quá trình kiểm thử.
- **Độ bao phủ phương thức**: 98% phương thức đã được thực thi trong quá trình kiểm thử.

## 6. Kết luận

### 6.1. Tổng kết

Đã triển khai 41 testcase kiểm thử hộp đen và hộp trắng, với tỷ lệ thành công 95.1%. Độ bao phủ mã nguồn đạt trên 90% cho tất cả các loại độ bao phủ. Có 2 testcase thất bại do vấn đề về phương thức findByMaThuoc() không được định nghĩa và không thể truy cập vào phương thức private validateThuoc().

### 6.2. Đề xuất cải tiến

1. **Bổ sung phương thức findByMaThuoc()**: Bổ sung phương thức findByMaThuoc() vào interface ThuocRepo để khắc phục lỗi trong testcase PC_006.
2. **Cải thiện khả năng kiểm thử**: Cân nhắc việc tạo phương thức public wrapper cho phương thức private validateThuoc() để dễ dàng kiểm thử hơn.
3. **Tăng độ bao phủ nhánh**: Bổ sung thêm testcase để tăng độ bao phủ nhánh từ 90% lên 95%.
4. **Tự động hóa kiểm thử**: Tích hợp kiểm thử vào quy trình CI/CD để tự động hóa việc kiểm thử.

## 7. Tài liệu tham khảo

1. **Tài liệu dự án**:
   - [Tài liệu đặc tả yêu cầu](../../../docs/Yeu_Cau_He_Thong.md)
   - [Tài liệu thiết kế](../../../docs/Thiet_Ke_He_Thong.md)

2. **Tài liệu kiểm thử**:
   - [Kế hoạch triển khai kiểm thử](../../Ke_Hoach_Trien_Khai_Kiem_Thu.md)
   - [Tài liệu kiểm thử tổng hợp](../../Tai_Lieu_Kiem_Thu_Tong_Hop.md)
   - [Kế hoạch bổ sung testcase](../Ke_Hoach_Bo_Sung_Testcase.md)

3. **Tài liệu công cụ kiểm thử**:
   - [Tài liệu JUnit](https://junit.org/junit5/docs/current/user-guide/)
   - [Tài liệu Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
