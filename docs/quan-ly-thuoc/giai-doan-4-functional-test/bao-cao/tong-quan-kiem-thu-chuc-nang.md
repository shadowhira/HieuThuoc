# Báo cáo tổng quan kiểm thử chức năng - Quản lý thuốc

## 1. Giới thiệu

Báo cáo này trình bày tổng quan về quá trình kiểm thử chức năng (Functional Testing) cho module Quản lý thuốc của hệ thống Hiệu thuốc. Kiểm thử chức năng là giai đoạn 4 trong quy trình kiểm thử tổng thể, tập trung vào việc kiểm tra các chức năng của hệ thống có hoạt động đúng theo yêu cầu hay không.

## 2. Phạm vi kiểm thử

Kiểm thử chức năng tập trung vào các chức năng chính của module Quản lý thuốc:

1. **Thêm thuốc mới**
   - Thêm thuốc với dữ liệu hợp lệ
   - Kiểm tra xử lý lỗi khi thêm thuốc với mã trùng
   - Kiểm tra xử lý lỗi khi thêm thuốc với dữ liệu không hợp lệ (giá trị âm)

2. **Xóa thuốc**
   - Xóa thuốc thành công
   - Hủy xóa thuốc
   - Xóa thuốc đã có trong đơn hàng

3. **Tìm kiếm thuốc**
   - Tìm kiếm thuốc theo tên
   - Tìm kiếm thuốc không có kết quả
   - Tìm kiếm thuốc theo các tiêu chí khác

4. **Cập nhật thuốc**
   - Cập nhật thuốc với dữ liệu hợp lệ
   - Kiểm tra xử lý lỗi khi cập nhật thuốc với dữ liệu không hợp lệ
   - Hủy cập nhật thuốc

## 3. Công cụ kiểm thử

Trong giai đoạn kiểm thử chức năng, chúng tôi đã sử dụng các công cụ sau:

1. **Cypress**: Kiểm thử tự động giao diện người dùng (UI) và tương tác giữa frontend và backend
   - Mô phỏng hành vi người dùng thực tế
   - Kiểm tra luồng làm việc end-to-end
   - Chụp ảnh và quay video quá trình kiểm thử

2. **Postman**: Kiểm thử API
   - Kiểm tra các endpoint API của module Quản lý thuốc
   - Xác minh dữ liệu trả về từ API
   - Kiểm tra xử lý lỗi của API

## 4. Kết quả kiểm thử

### 4.1. Kiểm thử Cypress

| Loại test | Số lượng test case | Số lượng pass | Số lượng fail | Tỷ lệ pass |
|-----------|-------------------|--------------|--------------|-----------|
| Thêm thuốc | 3 | 3 | 0 | 100% |
| Xóa thuốc | 3 | 3 | 0 | 100% |
| Tìm kiếm thuốc | 5 | 5 | 0 | 100% |
| Cập nhật thuốc | 4 | 4 | 0 | 100% |
| **Tổng cộng** | **15** | **15** | **0** | **100%** |

Chi tiết kết quả kiểm thử Cypress có thể xem trong báo cáo [kết quả kiểm thử Cypress](../cypress-test/ket-qua-kiem-thu-cypress.md).

### 4.2. Kiểm thử Postman

Kết quả kiểm thử Postman sẽ được cập nhật sau khi hoàn thành.

## 5. Vấn đề phát hiện

Trong quá trình kiểm thử, chúng tôi đã phát hiện và khắc phục một số vấn đề:

1. **Giao diện người dùng thay đổi**: Một số selector trong các test Cypress không còn chính xác do giao diện người dùng đã thay đổi. Chúng tôi đã cập nhật các selector để phù hợp với giao diện hiện tại.

2. **Xử lý bất đồng bộ**: Một số test thất bại do không đợi đủ thời gian để trang web tải xong. Chúng tôi đã thêm các lệnh đợi (wait) để đảm bảo các phần tử đã hiển thị trước khi tương tác.

3. **Phần tử bị ẩn**: Một số phần tử bị ẩn bởi transform, gây khó khăn cho việc tương tác. Chúng tôi đã sử dụng tùy chọn `{force: true}` để tương tác với các phần tử này.

## 6. Kết luận và đề xuất

### 6.1. Kết luận

Dựa trên kết quả kiểm thử, module Quản lý thuốc đã đáp ứng được các yêu cầu chức năng cơ bản. Tất cả các test case Cypress đều đã pass, cho thấy các chức năng CRUD (Create, Read, Update, Delete) hoạt động đúng như mong đợi.

### 6.2. Đề xuất

1. **Cải thiện độ ổn định của test**: Một số test còn phụ thuộc vào cấu trúc DOM cụ thể, có thể dễ bị ảnh hưởng khi giao diện thay đổi. Nên sử dụng các thuộc tính data-* hoặc ID để tăng tính ổn định của test.

2. **Mở rộng phạm vi kiểm thử**: Nên bổ sung thêm các test case cho các tình huống biên và xử lý lỗi.

3. **Tích hợp CI/CD**: Nên tích hợp các test tự động vào quy trình CI/CD để phát hiện sớm các vấn đề.

## 7. Phụ lục

### 7.1. Danh sách các file test

#### 7.1.1. Cypress

- `create-thuoc-functional.cy.js`: Test chức năng thêm thuốc
- `delete-thuoc-functional.cy.js`: Test chức năng xóa thuốc
- `search-thuoc-functional.cy.js`: Test chức năng tìm kiếm thuốc
- `update-thuoc-functional.cy.js`: Test chức năng cập nhật thuốc

#### 7.1.2. Postman

Danh sách các collection Postman sẽ được cập nhật sau.

### 7.2. Hướng dẫn chạy test

#### 7.2.1. Cypress

1. Di chuyển đến thư mục FE:
   ```bash
   cd FE
   ```

2. Chạy tất cả các test Cypress:
   ```bash
   npx cypress run --spec "cypress/e2e/thuoc/*-functional.cy.js"
   ```

3. Chạy một test cụ thể:
   ```bash
   npx cypress run --spec "cypress/e2e/thuoc/create-thuoc-functional.cy.js"
   ```

4. Chạy Cypress trong chế độ tương tác:
   ```bash
   npx cypress open
   ```

#### 7.2.2. Postman

Hướng dẫn chạy test Postman sẽ được cập nhật sau.
