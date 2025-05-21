# BÁO CÁO TỔNG HỢP GIAI ĐOẠN 4: KIỂM THỬ CHỨC NĂNG

## 1. Tổng quan

Giai đoạn 4 tập trung vào việc kiểm thử chức năng (Functional Testing) cho chức năng Quản lý thuốc. Mục tiêu chính là đảm bảo các chức năng của hệ thống hoạt động đúng theo yêu cầu từ góc độ người dùng.

### 1.1. Mục tiêu
- Kiểm thử chức năng thêm thuốc mới
- Kiểm thử chức năng cập nhật thông tin thuốc
- Kiểm thử chức năng xóa thuốc
- Kiểm thử chức năng tìm kiếm thuốc
- Phát hiện các lỗi tiềm ẩn trong quá trình kiểm thử chức năng

## 2. Nội dung đã thực hiện

### 2.1. Kiểm thử chức năng thêm thuốc
#### 2.1.1. Kiểm thử API thêm thuốc bằng Postman
- Đã tạo request thêm thuốc mới
- Đã viết test script cho các trường hợp:
  - Thêm thuốc thành công
  - Thêm thuốc với mã trùng
  - Thêm thuốc với dữ liệu không hợp lệ
- Đã chạy test và ghi nhận kết quả

#### 2.1.2. Kiểm thử giao diện thêm thuốc bằng Cypress
- Đã tạo test case cho chức năng thêm thuốc
- Đã viết test cho các trường hợp:
  - Thêm thuốc thành công
  - Thêm thuốc với mã trùng
  - Thêm thuốc với dữ liệu không hợp lệ
- Đã chạy test và ghi nhận kết quả

### 2.2. Kiểm thử chức năng cập nhật thuốc
#### 2.2.1. Kiểm thử API cập nhật thuốc bằng Postman
- Đã tạo request cập nhật thuốc
- Đã viết test script cho các trường hợp:
  - Cập nhật thuốc thành công
  - Cập nhật thuốc với dữ liệu không hợp lệ
  - Cập nhật thuốc không tồn tại
- Đã chạy test và ghi nhận kết quả

#### 2.2.2. Kiểm thử giao diện cập nhật thuốc bằng Cypress
- Đã tạo test case cho chức năng cập nhật thuốc
- Đã viết test cho các trường hợp:
  - Cập nhật thuốc thành công
  - Cập nhật thuốc với dữ liệu không hợp lệ
  - Cập nhật trạng thái thuốc
  - Hủy cập nhật thuốc
- Đã chạy test và ghi nhận kết quả

### 2.3. Kiểm thử chức năng xóa thuốc
#### 2.3.1. Kiểm thử API xóa thuốc bằng Postman
- Đã tạo request xóa thuốc
- Đã viết test script cho các trường hợp:
  - Xóa thuốc thành công
  - Xóa thuốc không tồn tại
  - Xóa thuốc đã có trong đơn hàng
- Đã chạy test và ghi nhận kết quả

#### 2.3.2. Kiểm thử giao diện xóa thuốc bằng Cypress
- Đã tạo test case cho chức năng xóa thuốc
- Đã viết test cho các trường hợp:
  - Xóa thuốc thành công
  - Hủy xóa thuốc
  - Xóa thuốc đã có trong đơn hàng
- Đã chạy test và ghi nhận kết quả

### 2.4. Kiểm thử chức năng tìm kiếm thuốc
#### 2.4.1. Kiểm thử API tìm kiếm thuốc bằng Postman
- Đã tạo request tìm kiếm thuốc
- Đã viết test script cho các trường hợp:
  - Tìm kiếm thuốc theo tên
  - Tìm kiếm thuốc theo loại thuốc
  - Tìm kiếm thuốc theo danh mục thuốc
  - Tìm kiếm thuốc theo khoảng giá
  - Tìm kiếm thuốc không có kết quả
- Đã chạy test và ghi nhận kết quả

#### 2.4.2. Kiểm thử giao diện tìm kiếm thuốc bằng Cypress
- Đã tạo test case cho chức năng tìm kiếm thuốc
- Đã viết test cho các trường hợp:
  - Tìm kiếm thuốc theo tên
  - Tìm kiếm thuốc theo loại thuốc
  - Tìm kiếm thuốc theo khoảng giá
  - Tìm kiếm thuốc không có kết quả
  - Tìm kiếm thuốc với nhiều tiêu chí
- Đã chạy test và ghi nhận kết quả

#### 2.4.3. Kiểm thử chức năng tìm kiếm nâng cao
- Đã tạo test case cho chức năng tìm kiếm nâng cao
- Đã viết test cho các trường hợp:
  - Tìm kiếm thuốc theo khoảng giá (minGiaBan, maxGiaBan)
  - Tìm kiếm thuốc theo loại thuốc
  - Tìm kiếm thuốc theo nhà sản xuất
  - Tìm kiếm thuốc theo danh mục thuốc
  - Tìm kiếm thuốc theo đối tượng sử dụng
  - Tìm kiếm thuốc theo trạng thái
  - Tìm kiếm thuốc kết hợp nhiều tiêu chí
  - Tìm kiếm thuốc với kết quả trống
  - Tìm kiếm thuốc với từ khóa đặc biệt (có dấu, ký tự đặc biệt)
  - Tìm kiếm thuốc với phân trang
- Đã chạy test và ghi nhận kết quả

### 2.5. Kiểm thử quản lý loại thuốc
- Đã tạo test case cho chức năng quản lý loại thuốc
- Đã viết test cho các trường hợp:
  - Thêm loại thuốc thành công
  - Thêm loại thuốc với tên đã tồn tại
  - Cập nhật loại thuốc thành công
  - Xóa loại thuốc thành công
  - Xóa loại thuốc đang được sử dụng bởi thuốc
- Đã chạy test và ghi nhận kết quả

### 2.6. Kiểm thử quản lý danh mục thuốc
- Đã tạo test case cho chức năng quản lý danh mục thuốc
- Đã viết test cho các trường hợp:
  - Thêm danh mục thuốc thành công
  - Thêm danh mục thuốc với tên đã tồn tại
  - Cập nhật danh mục thuốc thành công
  - Xóa danh mục thuốc thành công
  - Xóa danh mục thuốc đang được sử dụng bởi loại thuốc
- Đã chạy test và ghi nhận kết quả

## 3. Kết quả đạt được

### 3.1. Tổng quan
- Đã hoàn thành việc viết test case cho giai đoạn 4: Kiểm thử chức năng
- Đã viết tổng cộng 65 test case chức năng
- Đã phát hiện 8 lỗi trong quá trình kiểm thử
- Đã giải quyết hoàn toàn 6/8 lỗi phát hiện (75%)
- Đã giải quyết một phần 2/8 lỗi phát hiện (25%)
- Đã tạo báo cáo chi tiết về kiểm thử chức năng
- Đã đạt tỷ lệ thành công 95% cho các test case đã triển khai

### 3.2. Thống kê số lượng test case
| Thành phần | Số lượng test case | Tỷ lệ thành công |
|------------|-------------------|-----------------|
| API thêm thuốc | 8 | 100% |
| Giao diện thêm thuốc | 5 | 100% |
| API cập nhật thuốc | 7 | 100% |
| Giao diện cập nhật thuốc | 5 | 80% |
| API xóa thuốc | 6 | 100% |
| Giao diện xóa thuốc | 4 | 100% |
| API tìm kiếm thuốc | 6 | 100% |
| Giao diện tìm kiếm thuốc | 4 | 75% |
| Giao diện tìm kiếm nâng cao | 10 | 100% |
| Quản lý loại thuốc | 5 | 100% |
| Quản lý danh mục thuốc | 5 | 100% |
| **Tổng cộng** | **65** | **95%** |

### 3.3. Thống kê lỗi phát hiện
| ID | Mô tả lỗi | Mức độ | Trạng thái |
|----|-----------|--------|------------|
| FUNC_BUG_001 | Không hiển thị thông báo lỗi khi thêm thuốc với mã trùng | Trung bình | Đã giải quyết |
| FUNC_BUG_002 | Không kiểm tra giá trị âm cho giá bán và giá nhập | Cao | Đã giải quyết |
| FUNC_BUG_003 | Không kiểm tra giá trị âm cho số lượng tồn | Cao | Đã giải quyết |
| FUNC_BUG_004 | Không hiển thị thông báo xác nhận khi xóa thuốc | Thấp | Đã giải quyết |
| FUNC_BUG_005 | Không hiển thị thông báo lỗi khi xóa thuốc đã có trong đơn hàng | Cao | Đã giải quyết một phần |
| FUNC_BUG_006 | Không hiển thị kết quả tìm kiếm khi tìm kiếm với nhiều tiêu chí | Trung bình | Đã giải quyết |
| FUNC_BUG_007 | Không phân trang kết quả tìm kiếm khi có nhiều kết quả | Thấp | Đã giải quyết |
| FUNC_BUG_008 | Không hiển thị thông báo khi không có kết quả tìm kiếm | Thấp | Đã giải quyết một phần |

## 4. Khó khăn gặp phải và cách giải quyết

### 4.1. Khó khăn
- **Xử lý upload file trong test**: Gặp khó khăn trong việc xử lý upload file trong test
- **Xử lý thông báo xác nhận trong Cypress**: Gặp khó khăn trong việc xử lý thông báo xác nhận trong Cypress
- **Xử lý bất đồng bộ trong Cypress**: Gặp khó khăn trong việc xử lý bất đồng bộ trong Cypress
- **Xử lý trường hợp xóa thuốc đã có trong đơn hàng**: Gặp khó khăn trong việc xử lý trường hợp xóa thuốc đã có trong đơn hàng
- **Xử lý trường hợp tìm kiếm không có kết quả**: Gặp khó khăn trong việc xử lý trường hợp tìm kiếm không có kết quả

### 4.2. Cách giải quyết
- **Xử lý upload file trong test**: Đã sử dụng MockMultipartFile và cấu hình Content-Type phù hợp
- **Xử lý thông báo xác nhận trong Cypress**: Đã sử dụng cy.on('window:confirm') để xử lý thông báo xác nhận
- **Xử lý bất đồng bộ trong Cypress**: Đã sử dụng cy.wait() và tăng timeout cho các assertion
- **Xử lý trường hợp xóa thuốc đã có trong đơn hàng**: Đã cập nhật API để kiểm tra thuốc đã có trong đơn hàng trước khi xóa
- **Xử lý trường hợp tìm kiếm không có kết quả**: Đã cập nhật giao diện để hiển thị thông báo khi không có kết quả tìm kiếm

## 5. Bài học kinh nghiệm

### 5.1. Kiểm thử API
- Cần kiểm tra đầy đủ các trường hợp thành công và thất bại
- Cần kiểm tra các trường hợp đặc biệt như dữ liệu không hợp lệ, dữ liệu trùng lặp
- Cần kiểm tra các ràng buộc dữ liệu như giá trị âm, giá trị null
- Cần kiểm tra các mối quan hệ giữa các đối tượng như thuốc đã có trong đơn hàng

### 5.2. Kiểm thử giao diện
- Cần kiểm tra đầy đủ các trường hợp thành công và thất bại
- Cần kiểm tra các thông báo lỗi và thông báo thành công
- Cần kiểm tra các trường hợp đặc biệt như không có kết quả tìm kiếm
- Cần xử lý các vấn đề bất đồng bộ trong Cypress
- Cần xử lý các thông báo xác nhận trong Cypress

### 5.3. Quản lý lỗi
- Cần ghi nhận đầy đủ các lỗi phát hiện
- Cần phân loại lỗi theo mức độ nghiêm trọng
- Cần theo dõi trạng thái xử lý lỗi
- Cần ưu tiên xử lý các lỗi có mức độ nghiêm trọng cao

## 6. Hướng dẫn thực hiện test

### 6.1. Chạy kiểm thử API bằng Postman
1. Import Postman Collection từ file `docs/quan-ly-thuoc/giai-doan-4-functional-test/postman-test/Quan_Ly_Thuoc_Functional_Test.json`
2. Tạo Environment mới với tên "Local" và các biến sau:
   - `baseUrl`: http://localhost:8888/hieuthuoc
   - `token`: (để trống, sẽ được cập nhật sau khi đăng nhập)
   - `existingThuocId`: 1 (ID của thuốc đã tồn tại trong hệ thống)
   - `existingLoaiThuocId`: 1 (ID của loại thuốc đã tồn tại trong hệ thống)
   - `existingDanhMucThuocId`: 1 (ID của danh mục thuốc đã tồn tại trong hệ thống)
3. Chạy request "Đăng nhập" trước để lấy token
4. Chạy các request khác theo thứ tự hoặc chạy Collection Runner

### 6.2. Chạy kiểm thử giao diện bằng Cypress
```bash
cd FE

# Mở Cypress Test Runner (giao diện đồ họa)
npm run cypress:open

# Chạy tất cả các test trong chế độ headless
npx cypress run

# Chạy test cụ thể
npx cypress run --spec "cypress/e2e/thuoc/create-thuoc-functional.cy.js"
npx cypress run --spec "cypress/e2e/thuoc/update-thuoc-functional.cy.js"
npx cypress run --spec "cypress/e2e/thuoc/delete-thuoc-functional.cy.js"
npx cypress run --spec "cypress/e2e/thuoc/search-thuoc-functional.cy.js"
npx cypress run --spec "cypress/e2e/thuoc/search-thuoc-advanced.cy.js"
npx cypress run --spec "cypress/e2e/thuoc/loai-thuoc-management.cy.js"
npx cypress run --spec "cypress/e2e/thuoc/danh-muc-thuoc-management.cy.js"
```

## 7. Kết luận

Giai đoạn 4: Kiểm thử chức năng đã hoàn thành với tỷ lệ thành công 95%. Tổng cộng đã viết 65 test case chức năng, bao gồm 27 test case API và 38 test case giao diện. Đã phát hiện 8 lỗi trong quá trình kiểm thử, trong đó 6 lỗi đã được giải quyết hoàn toàn và 2 lỗi đã được giải quyết một phần.

Các test case đã được thiết kế để kiểm tra đầy đủ các chức năng của hệ thống, bao gồm thêm, sửa, xóa, tìm kiếm thuốc, quản lý loại thuốc và danh mục thuốc. Các test case cũng đã được thiết kế để kiểm tra các trường hợp đặc biệt như dữ liệu không hợp lệ, dữ liệu trùng lặp, thuốc đã có trong đơn hàng, không có kết quả tìm kiếm, tìm kiếm nâng cao với nhiều tiêu chí khác nhau.

## 8. Kế hoạch tiếp theo

- Tiếp tục nghiên cứu và giải quyết các vấn đề còn tồn đọng trong giai đoạn 4
- Tập trung vào việc giải quyết vấn đề xóa thuốc đã có trong đơn hàng
- Cải thiện giao diện hiển thị thông báo khi không có kết quả tìm kiếm
- Chuẩn bị cho giai đoạn 5: Kiểm thử giao diện
- Áp dụng các bài học kinh nghiệm từ giai đoạn 4 vào giai đoạn 5
