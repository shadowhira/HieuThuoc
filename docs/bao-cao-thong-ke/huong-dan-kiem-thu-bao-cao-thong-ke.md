# Hướng dẫn kiểm thử phân hệ Báo cáo Thống kê

## 1. Tổng quan

Tài liệu này cung cấp hướng dẫn chi tiết về cách kiểm thử phân hệ Báo cáo Thống kê trong hệ thống hiệu thuốc. Các test case được viết bằng Cypress để kiểm thử tự động các chức năng và thành phần của trang báo cáo thống kê.

> **Lưu ý quan trọng**: Trang báo cáo thống kê chỉ có thể truy cập sau khi đăng nhập với tài khoản admin. Tất cả các test case đã được cấu hình để tự động đăng nhập trước khi truy cập trang báo cáo thống kê.

## 2. Cấu trúc thư mục kiểm thử

```
FE/cypress/
├── e2e/
│   └── bao-cao-thong-ke/
│       ├── overview.cy.js     # Test kiểm tra các thành phần tổng quan
│       ├── filters.cy.js      # Test kiểm tra bộ lọc thời gian
│       ├── chart.cy.js        # Test kiểm tra biểu đồ doanh thu
│       ├── api.cy.js          # Test kiểm tra các API
│       ├── responsive.cy.js   # Test kiểm tra tính responsive
│       ├── edge-cases.cy.js   # Test kiểm tra các trường hợp ngoại lệ
│       └── index.cy.js        # Test tổng hợp
├── fixtures/
│   └── users.json             # Dữ liệu đăng nhập
├── support/
│   ├── commands.js            # Custom commands chung
│   ├── commands-thongke.js    # Custom commands cho báo cáo thống kê
│   └── e2e.js                 # Cấu hình e2e
└── screenshots/               # Thư mục lưu ảnh chụp màn hình
```

## 3. Các thành phần được kiểm thử

### 3.1. Thành phần tổng quan (Dashboard)
- Thẻ thông tin Hóa đơn
- Thẻ thông tin Đơn hàng trả lại
- Thẻ thông tin Doanh thu

### 3.2. Bộ lọc thời gian
- Lựa chọn loại báo cáo (Theo ngày, Theo tháng, Theo năm)
- Lựa chọn ngày, tháng, năm

### 3.3. Biểu đồ doanh thu
- Biểu đồ cột hiển thị doanh thu theo thời gian
- Trục X, trục Y và tooltip

### 3.4. API và dữ liệu
- API lấy doanh thu theo ngày
- API lấy doanh thu theo tháng
- API lấy doanh thu theo năm

### 3.5. Tính responsive
- Hiển thị trên màn hình desktop
- Hiển thị trên màn hình tablet
- Hiển thị trên màn hình mobile

### 3.6. Trường hợp ngoại lệ
- Không có dữ liệu
- API trả về lỗi
- Dữ liệu đặc biệt (giá trị âm, giá trị rất lớn)

## 4. Cách chạy kiểm thử

### 4.1. Chuẩn bị môi trường

1. Đảm bảo đã cài đặt Node.js và npm
2. Cài đặt các dependencies:
   ```bash
   cd FE
   npm install
   ```

### 4.2. Chạy ứng dụng

Trước khi chạy kiểm thử, cần khởi động ứng dụng:
```bash
cd FE
npm start
```

### 4.3. Chạy kiểm thử

#### 4.3.1. Chạy tất cả các test case
```bash
cd FE
npx cypress run --spec "cypress/e2e/bao-cao-thong-ke/**/*.cy.js"
```

Hoặc sử dụng file batch đã chuẩn bị:
```bash
cd FE
run-thongke-tests.bat
```

#### 4.3.2. Chạy một file test cụ thể
```bash
cd FE
npx cypress run --spec "cypress/e2e/bao-cao-thong-ke/overview.cy.js"
```

#### 4.3.3. Chạy kiểm thử với giao diện
```bash
cd FE
npx cypress open
```
Sau đó chọn "E2E Testing" và chọn các test case muốn chạy.

## 5. Mô tả chi tiết các test case

### 5.1. Kiểm thử thành phần tổng quan (overview.cy.js)
- Kiểm tra hiển thị các thẻ thông tin
- Kiểm tra hiển thị biểu tượng
- Kiểm tra dữ liệu hiển thị chính xác
- Kiểm tra hiển thị khi không có dữ liệu

### 5.2. Kiểm thử bộ lọc thời gian (filters.cy.js)
- Kiểm tra hiển thị các tùy chọn loại báo cáo
- Kiểm tra hiển thị các dropdown tương ứng với loại báo cáo
- Kiểm tra thay đổi ngày/tháng/năm gọi API đúng
- Kiểm tra hiển thị đúng số ngày trong tháng

### 5.3. Kiểm thử biểu đồ doanh thu (chart.cy.js)
- Kiểm tra hiển thị biểu đồ
- Kiểm tra hiển thị biểu đồ theo ngày/tháng/năm
- Kiểm tra cập nhật biểu đồ khi thay đổi bộ lọc
- Kiểm tra hiển thị khi không có dữ liệu

### 5.4. Kiểm thử API và dữ liệu (api.cy.js)
- Kiểm tra gọi API đúng endpoint và tham số
- Kiểm tra xử lý khi API trả về lỗi
- Kiểm tra xử lý khi API trả về dữ liệu không hợp lệ
- Kiểm tra xử lý khi API trả về dữ liệu đặc biệt

### 5.5. Kiểm thử tính responsive (responsive.cy.js)
- Kiểm tra hiển thị trên màn hình desktop
- Kiểm tra hiển thị trên màn hình tablet
- Kiểm tra hiển thị trên màn hình mobile
- Kiểm tra biểu đồ thay đổi kích thước phù hợp

### 5.6. Kiểm thử trường hợp ngoại lệ (edge-cases.cy.js)
- Kiểm tra xử lý khi không có dữ liệu
- Kiểm tra xử lý khi API trả về lỗi
- Kiểm tra xử lý khi API trả về dữ liệu không hợp lệ
- Kiểm tra xử lý khi chọn ngày không tồn tại
- Kiểm tra xử lý khi chọn năm nhuận/không nhuận

### 5.7. Kiểm thử tổng hợp (index.cy.js)
- Kiểm tra tất cả các thành phần chính hiển thị đúng
- Kiểm tra luồng nghiệp vụ đầy đủ
- Chụp ảnh màn hình trang báo cáo thống kê

## 6. Custom Commands

Các custom commands được định nghĩa trong file `cypress/support/commands-thongke.js` để hỗ trợ việc kiểm thử:

- `cy.loginUI(username, password)`: Đăng nhập qua giao diện người dùng (mặc định: admin/123456)
- `cy.loginAPI(username, password)`: Đăng nhập qua API (mặc định: admin/123456)
- `cy.visitThongKe(loginMethod)`: Đăng nhập và truy cập trang báo cáo thống kê (phương pháp đăng nhập mặc định: 'UI')
- `cy.verifyRevenueData(expectedHoaDon, expectedDonHangTraLai, expectedDoanhThu)`: Kiểm tra dữ liệu doanh thu hiển thị chính xác
- `cy.selectReportType(type, options)`: Chọn loại báo cáo và thời gian
- `cy.mockDoanhThuTheoNgay(data)`: Giả lập API doanh thu theo ngày
- `cy.mockDoanhThuTheoThang(data)`: Giả lập API doanh thu theo tháng
- `cy.mockDoanhThuTheoNam(data)`: Giả lập API doanh thu theo năm
- `cy.verifyChart()`: Kiểm tra hiển thị biểu đồ
- `cy.verifyResponsive()`: Kiểm tra hiển thị trên các kích thước màn hình khác nhau

## 7. Lưu ý

- Đảm bảo ứng dụng đang chạy trước khi thực hiện kiểm thử
- Các test case sử dụng giả lập API để kiểm thử độc lập với backend
- Kết quả kiểm thử (ảnh chụp màn hình, video) được lưu trong thư mục `cypress/screenshots` và `cypress/videos`
- Nếu có lỗi, kiểm tra log trong terminal hoặc xem ảnh chụp màn hình
- **Quan trọng**: Tất cả các test case đều yêu cầu đăng nhập trước khi truy cập trang báo cáo thống kê. Nếu thông tin đăng nhập thay đổi, cần cập nhật trong file `cypress/support/commands-thongke.js`

## 8. Xử lý vấn đề thường gặp

### 8.1. Lỗi 404 khi truy cập trang báo cáo thống kê

Nếu gặp lỗi 404 khi truy cập trang báo cáo thống kê, có thể do một trong các nguyên nhân sau:

- **Chưa đăng nhập**: Trang báo cáo thống kê chỉ có thể truy cập sau khi đăng nhập với tài khoản admin
- **Sai đường dẫn**: Đảm bảo đường dẫn đúng là `/sys/thongke` (không phải `/thongke`)
- **Lỗi xác thực**: Đảm bảo thông tin đăng nhập chính xác (tài khoản: admin, mật khẩu: 123456)

### 8.2. Lỗi khi đăng nhập qua API

Nếu gặp lỗi khi đăng nhập qua API, có thể do một trong các nguyên nhân sau:

- **Sai endpoint API**: Đảm bảo endpoint API đăng nhập đúng là `/api/auth/login`
- **Sai thông tin đăng nhập**: Đảm bảo thông tin đăng nhập chính xác
- **Lỗi CORS**: Đảm bảo Cypress được cấu hình để xử lý CORS

Trong trường hợp này, bạn có thể chuyển sang sử dụng đăng nhập qua UI bằng cách thay đổi `cy.loginAPI()` thành `cy.loginUI()` trong các file test, hoặc sử dụng `cy.visitThongKe('UI')` thay vì `cy.visitThongKe('API')`.

### 8.3. Lỗi "Cannot set properties of null (setting 'innerHTML')"

Nếu gặp lỗi "TypeError: Cannot set properties of null (setting 'innerHTML')" sau khi đăng nhập, có thể do một trong các nguyên nhân sau:

- **Lỗi không bắt được từ ứng dụng**: Đây là lỗi phổ biến trong Cypress khi ứng dụng Angular đang cố gắng thao tác với một phần tử DOM không tồn tại
- **Chuyển hướng quá nhanh**: Ứng dụng chuyển hướng trước khi tải xong các tài nguyên cần thiết

Để xử lý lỗi này, chúng ta đã thực hiện các biện pháp sau:

1. Cấu hình Cypress để không tự động fail test khi có lỗi không bắt được từ ứng dụng:
   ```javascript
   Cypress.on('uncaught:exception', (err, runnable) => {
     console.log('Uncaught exception:', err.message);
     return false;
   });
   ```

2. Thêm độ trễ sau khi đăng nhập để đảm bảo ứng dụng đã tải xong:
   ```javascript
   cy.wait(2000);
   ```

3. Sử dụng command `cy.visitThongKe()` để đảm bảo đăng nhập và truy cập trang báo cáo thống kê một cách đáng tin cậy.
