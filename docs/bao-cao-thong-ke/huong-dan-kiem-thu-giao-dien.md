# HƯỚNG DẪN KIỂM THỬ GIAO DIỆN CHỨC NĂNG BÁO CÁO DOANH THU

## 1. Giới thiệu

Tài liệu này cung cấp hướng dẫn chi tiết về cách thực hiện kiểm thử giao diện cho chức năng Báo cáo Doanh thu trong hệ thống quản lý hiệu thuốc. Kiểm thử sẽ được thực hiện bằng cả phương pháp thủ công và tự động với Cypress.

Lưu ý rằng ảnh màn hình được cung cấp chỉ là một ví dụ cho một trường hợp cụ thể. Kế hoạch kiểm thử này sẽ bao gồm tất cả các trường hợp có thể xảy ra trong chức năng báo cáo doanh thu, không chỉ giới hạn ở trường hợp trong ảnh.

## 2. Chuẩn bị môi trường

### 2.1. Cài đặt Cypress (cho kiểm thử tự động)

```bash
# Di chuyển đến thư mục FE
cd FE

# Cài đặt Cypress như một dev dependency
npm install cypress --save-dev

# Cài đặt plugin axe-core cho kiểm thử accessibility (tùy chọn)
npm install cypress-axe --save-dev

# Mở Cypress để khởi tạo cấu trúc thư mục
npx cypress open
```

### 2.2. Chuẩn bị tài khoản kiểm thử

- Tài khoản admin: `admin/password` (thay đổi thông tin đăng nhập phù hợp)
- Đảm bảo tài khoản có quyền truy cập vào chức năng báo cáo

### 2.3. Chuẩn bị dữ liệu kiểm thử

- Đảm bảo có dữ liệu đơn hàng trong hệ thống
- Chuẩn bị các khoảng thời gian có dữ liệu và không có dữ liệu để kiểm thử

## 3. Kiểm thử thủ công

### 3.1. Kiểm tra Dashboard tổng quan

1. **Đăng nhập và truy cập**:
   - Đăng nhập vào hệ thống với tài khoản admin
   - Truy cập vào trang Báo cáo

2. **Kiểm tra các thành phần tổng quan**:
   - Kiểm tra hiển thị số lượng hóa đơn (trong ví dụ là 7, nhưng cần kiểm tra với nhiều bộ dữ liệu khác nhau)
   - Kiểm tra hiển thị số lượng đơn hàng trả lại (trong ví dụ là 0, nhưng cần kiểm tra cả trường hợp có đơn hàng trả lại)
   - Kiểm tra hiển thị tổng doanh thu (trong ví dụ là 153,400 VND, nhưng cần kiểm tra với nhiều bộ dữ liệu khác nhau)
   - Kiểm tra màu sắc, biểu tượng và bố cục của các thành phần
   - Kiểm tra tính chính xác của dữ liệu bằng cách so sánh với dữ liệu từ cơ sở dữ liệu

3. **Ghi lại kết quả**:
   - Ghi lại kết quả vào file CSV `ket-qua-kiem-thu-giao-dien.csv`
   - Chụp ảnh màn hình nếu phát hiện lỗi

### 3.2. Kiểm tra biểu đồ doanh thu

1. **Kiểm tra hiển thị biểu đồ**:
   - Kiểm tra biểu đồ doanh thu được hiển thị dạng cột
   - Kiểm tra trục X hiển thị các ngày trong tháng
   - Kiểm tra trục Y hiển thị doanh thu (VND)
   - Kiểm tra các cột biểu đồ có màu xanh dương

2. **Kiểm tra tương tác với biểu đồ**:
   - Di chuột vào các cột và kiểm tra tooltip hiển thị chi tiết
   - Kiểm tra các tính năng tương tác khác (nếu có)

3. **Ghi lại kết quả**:
   - Ghi lại kết quả vào file CSV
   - Chụp ảnh màn hình nếu phát hiện lỗi

### 3.3. Kiểm tra bộ lọc thời gian

1. **Kiểm tra chuyển đổi loại báo cáo**:
   - Chọn loại báo cáo "Theo ngày" và kiểm tra hiển thị
   - Chọn loại báo cáo "Theo tháng" và kiểm tra hiển thị
   - Chọn loại báo cáo "Theo năm" và kiểm tra hiển thị

2. **Kiểm tra chọn thời gian**:
   - Chọn các ngày/tháng/năm khác nhau và kiểm tra hiển thị
   - Kiểm tra dữ liệu được cập nhật khi thay đổi thời gian

3. **Ghi lại kết quả**:
   - Ghi lại kết quả vào file CSV
   - Chụp ảnh màn hình nếu phát hiện lỗi

### 3.4. Kiểm tra tính responsive

1. **Kiểm tra trên màn hình desktop**:
   - Sử dụng DevTools để đặt kích thước màn hình là 1920x1080
   - Kiểm tra hiển thị của tất cả các thành phần

2. **Kiểm tra trên màn hình tablet**:
   - Sử dụng DevTools để đặt kích thước màn hình là 768x1024
   - Kiểm tra hiển thị của tất cả các thành phần

3. **Kiểm tra trên màn hình mobile**:
   - Sử dụng DevTools để đặt kích thước màn hình là 375x667
   - Kiểm tra hiển thị của tất cả các thành phần

4. **Ghi lại kết quả**:
   - Ghi lại kết quả vào file CSV
   - Chụp ảnh màn hình nếu phát hiện lỗi

### 3.5. Kiểm tra các trường hợp đặc biệt

1. **Kiểm tra khi không có dữ liệu**:
   - Chọn thời gian không có dữ liệu
   - Kiểm tra hiển thị của biểu đồ và thông báo

2. **Kiểm tra với dữ liệu lớn**:
   - Chọn thời gian có nhiều dữ liệu (ví dụ: cả năm)
   - Kiểm tra hiển thị và hiệu suất của biểu đồ

3. **Kiểm tra với dữ liệu có giá trị cực đại/cực tiểu**:
   - Chọn thời gian có doanh thu rất cao hoặc rất thấp
   - Kiểm tra hiển thị của biểu đồ và định dạng số

4. **Kiểm tra với nhiều đơn hàng trả lại**:
   - Chọn thời gian có nhiều đơn hàng trả lại
   - Kiểm tra hiển thị số lượng đơn hàng trả lại và ảnh hưởng đến tổng doanh thu

5. **Kiểm tra khả năng truy cập (accessibility)**:
   - Kiểm tra khả năng điều hướng bằng bàn phím
   - Kiểm tra độ tương phản màu sắc
   - Kiểm tra các thuộc tính alt, aria-label

6. **Ghi lại kết quả**:
   - Ghi lại kết quả vào file CSV
   - Chụp ảnh màn hình nếu phát hiện lỗi

## 4. Kiểm thử tự động với Cypress

### 4.1. Cấu trúc thư mục Cypress

```
FE/cypress/
├── e2e/
│   └── thongke-dashboard.cy.js  # File test cho dashboard
├── fixtures/
│   └── users.json               # Dữ liệu đăng nhập
└── support/
    ├── commands.js              # Custom commands
    └── e2e.js                   # Cấu hình e2e
```

### 4.2. Chạy kiểm thử tự động

```bash
# Chạy tất cả các test
npx cypress run

# Chạy test cụ thể
npx cypress run --spec "cypress/e2e/thongke-dashboard.cy.js"

# Chạy test với giao diện
npx cypress open
```

### 4.3. Phân tích kết quả

- Cypress tự động tạo video và ảnh chụp màn hình khi test thất bại
- Xem báo cáo trong thư mục `cypress/videos` và `cypress/screenshots`
- Cập nhật kết quả vào file CSV

## 5. Các thành phần UI cần kiểm tra

### 5.1. Dashboard tổng quan

- **Số lượng hóa đơn**:
  - Selector: `.hoa-don-count`
  - Giá trị mong đợi: Phải khớp với số lượng hóa đơn thực tế trong khoảng thời gian đã chọn (trong ví dụ là `7`)

- **Số lượng đơn hàng trả lại**:
  - Selector: `.don-hang-tra-lai-count`
  - Giá trị mong đợi: Phải khớp với số lượng đơn hàng trả lại thực tế trong khoảng thời gian đã chọn (trong ví dụ là `0`)

- **Tổng doanh thu**:
  - Selector: `.doanh-thu-value`
  - Giá trị mong đợi: Phải khớp với tổng doanh thu thực tế trong khoảng thời gian đã chọn (trong ví dụ là `153,400 VND`)

Lưu ý: Các giá trị mong đợi sẽ thay đổi tùy thuộc vào dữ liệu thực tế trong cơ sở dữ liệu và khoảng thời gian được chọn. Cần kiểm tra tính chính xác của dữ liệu bằng cách so sánh với dữ liệu từ cơ sở dữ liệu.

### 5.2. Biểu đồ doanh thu

- **Container biểu đồ**:
  - Selector: `#container`

- **Các cột biểu đồ**:
  - Selector: `.highcharts-column-series .highcharts-point`

- **Trục X và Y**:
  - Selector: `.highcharts-xaxis-labels`, `.highcharts-yaxis-labels`

- **Tooltip**:
  - Selector: `.highcharts-tooltip`

### 5.3. Bộ lọc thời gian

- **Tab loại báo cáo**:
  - Selector: `[data-type="NGAY"]`, `[data-type="THANG"]`, `[data-type="NAM"]`

- **Bộ chọn ngày/tháng/năm**:
  - Selector: `select.ngay-select`, `select.thang-select`, `select.nam-select`

## 6. Báo cáo lỗi

### 6.1. Mẫu báo cáo lỗi

- **ID lỗi**: BUG-XXX
- **Mô tả lỗi**: Mô tả chi tiết về lỗi
- **Bước tái hiện**: Các bước để tái hiện lỗi
- **Kết quả thực tế**: Kết quả thực tế khi thực hiện các bước
- **Kết quả mong đợi**: Kết quả mong đợi khi thực hiện các bước
- **Mức độ nghiêm trọng**: Critical/High/Medium/Low
- **Ảnh chụp màn hình**: Đính kèm ảnh chụp màn hình (nếu có)

### 6.2. Cách báo cáo lỗi

1. Ghi lại lỗi vào file CSV `ket-qua-kiem-thu-giao-dien.csv`
2. Chụp ảnh màn hình lỗi và lưu vào thư mục `docs/bao-cao-thong-ke/screenshots`
3. Tạo báo cáo lỗi chi tiết theo mẫu và lưu vào thư mục `docs/bao-cao-thong-ke/bugs`

## 7. Tổng kết

Sau khi hoàn thành kiểm thử, tổng hợp kết quả và viết báo cáo tổng kết bao gồm:

1. Tổng số test case đã thực hiện
2. Số lượng test case pass/fail
3. Danh sách lỗi đã phát hiện
4. Đánh giá chung về chất lượng giao diện
5. Đề xuất cải thiện (nếu có)

Lưu báo cáo tổng kết vào file `docs/bao-cao-thong-ke/bao-cao-tong-ket-kiem-thu-giao-dien.md`
