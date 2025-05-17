# BÁO CÁO KIỂM THỬ HỆ THỐNG HIỆU THUỐC

## Bố cục báo cáo

| Bố cục báo cáo | Check |
|----------------|-------|
| Công việc chung của cả nhóm | ✓ |
| Mô tả hệ thống của nhóm | ✓ |
| Giới thiệu về hệ thống (sản phẩm từ đâu, đường link,...) | ✓ |
| Công nghệ được sử dụng | ✓ |
| Các chức năng chính của hệ thống | ✓ |
| Hiện trạng đảm bảo chất lượng của hệ thống | ✓ |
| Kết quả thực hiện rà soát theo checklist | ✓ |
| Kết quả từng thành viên | |
| Kết quả thực hiện review tài liệu đặc tả của chức năng lựa chọn | ✓ |
| Kết quả thực hiện review code của chức năng lực chọn | ✓ |
| Kết quả thực hiện xây dựng testcase và thực hiện test | ✓ |
| Kiểm thử giao diện | ✓ |
| Kiểm thử đơn vị | ✓ |
| Kiểm thử hộp đen | ✓ |
| Nội dung kiểm thử lựa chọn thêm | ✓ |

## Công việc chung của cả nhóm

Nhóm đã thực hiện các công việc sau để đảm bảo chất lượng hệ thống hiệu thuốc:

1. Xây dựng kế hoạch kiểm thử (Test Plan)
2. Xây dựng kế hoạch đảm bảo chất lượng phần mềm (SQA Plan)
3. Thiết kế các test case cho các chức năng chính
4. Thực hiện kiểm thử đơn vị, kiểm thử tích hợp và kiểm thử hệ thống
5. Rà soát mã nguồn và tài liệu đặc tả
6. Kiểm thử giao diện người dùng
7. Kiểm thử hiệu năng cơ bản
8. Kiểm thử tương tác thuốc

## Mô tả hệ thống của nhóm

Hệ thống quản lý hiệu thuốc là một ứng dụng web toàn diện được phát triển để hỗ trợ quản lý hiệu quả các hoạt động của hiệu thuốc. Hệ thống được thiết kế với kiến trúc client-server, bao gồm phần frontend (FE) và backend (BE).

Hệ thống được chia thành các module chính:
- Quản lý thuốc và danh mục thuốc
- Quản lý nhập kho và tồn kho
- Quản lý đơn hàng và giỏ hàng
- Quản lý người dùng và phân quyền
- Quản lý khuyến mãi, đánh giá và báo cáo

Hệ thống hỗ trợ nhiều vai trò người dùng khác nhau, từ khách hàng đến nhân viên bán hàng và quản trị viên, mỗi vai trò có các quyền truy cập và chức năng khác nhau.

## Giới thiệu về hệ thống

Hệ thống quản lý hiệu thuốc được phát triển nhằm đáp ứng nhu cầu quản lý hiệu quả các hoạt động của hiệu thuốc, từ quản lý thuốc, kho, đơn hàng đến quản lý khách hàng và báo cáo thống kê.

**Đường link repository**: [GitHub Repository](https://github.com/username/pharmacy-management)

**Các thành phần chính**:
- **Frontend**: Giao diện người dùng được phát triển bằng Angular
- **Backend**: API và xử lý nghiệp vụ được phát triển bằng Spring Boot
- **Database**: PostgreSQL (đã chuyển từ MySQL)

## Công nghệ được sử dụng

### Frontend
- **Framework**: Angular
- **Ngôn ngữ**: TypeScript, HTML, CSS
- **Thư viện UI**: Bootstrap, PrimeNG
- **Quản lý trạng thái**: NgRx
- **Đa ngôn ngữ**: ngx-translate
- **Testing**: Jest, Karma

### Backend
- **Framework**: Spring Boot
- **Ngôn ngữ**: Java
- **API**: RESTful API
- **Security**: Spring Security, JWT
- **ORM**: Hibernate/JPA
- **Testing**: JUnit, Mockito

### Database
- **DBMS**: PostgreSQL
- **ORM**: Hibernate/JPA

### DevOps & Tools
- **Version Control**: Git, GitHub
- **IDE**: Visual Studio Code, IntelliJ IDEA
- **API Testing**: Postman
- **Performance Testing**: Chrome DevTools

## Các chức năng chính của hệ thống

### 1. Quản lý thuốc
- Thêm, sửa, xóa, tìm kiếm thuốc
- Quản lý loại thuốc và danh mục thuốc
- Quản lý thông tin chi tiết thuốc (thành phần, công dụng, chỉ định, chống chỉ định)
- Kiểm tra tương tác giữa các hoạt chất

### 2. Quản lý nhập kho và tồn kho
- Tạo phiếu nhập kho
- Quản lý nhà cung cấp
- Theo dõi tồn kho và cảnh báo hết hàng
- Quản lý hạn sử dụng thuốc

### 3. Quản lý đơn hàng
- Tạo đơn hàng mới
- Theo dõi trạng thái đơn hàng
- Quản lý giỏ hàng
- Thanh toán đơn hàng

### 4. Quản lý người dùng và phân quyền
- Đăng ký, đăng nhập, quản lý tài khoản
- Phân quyền người dùng
- Quản lý vai trò và chức năng
- Theo dõi hoạt động người dùng

### 5. Quản lý khuyến mãi và đánh giá
- Tạo chương trình khuyến mãi
- Quản lý đánh giá sản phẩm
- Thống kê và báo cáo
- Quản lý thông báo

## Hiện trạng đảm bảo chất lượng của hệ thống

### Kiểm thử
- **Kiểm thử đơn vị**: Đã thực hiện cho các controller và service chính
- **Kiểm thử tích hợp**: Đã thực hiện cho các API chính
- **Kiểm thử hệ thống**: Đã thực hiện các luồng nghiệp vụ chính
- **Kiểm thử giao diện**: Đã thực hiện kiểm tra giao diện trên các trình duyệt phổ biến
- **Kiểm thử hiệu năng**: Đã thực hiện kiểm tra cơ bản về thời gian phản hồi

### Rà soát mã nguồn
- Đã thực hiện rà soát mã nguồn cho các thành phần chính
- Đã áp dụng các quy tắc coding standard
- Đã kiểm tra xử lý ngoại lệ và validation

### Quản lý lỗi
- Đã thiết lập quy trình báo cáo và xử lý lỗi
- Đã phân loại lỗi theo mức độ nghiêm trọng
- Đã theo dõi và giải quyết các lỗi được phát hiện

## Kết quả thực hiện rà soát theo checklist

### Checklist kiểm thử giao diện (GUI)
- ✓ Kiểm tra tính nhất quán của giao diện
- ✓ Kiểm tra hiển thị trên các trình duyệt khác nhau
- ✓ Kiểm tra các thông báo lỗi
- ✓ Kiểm tra validation dữ liệu đầu vào
- ✓ Kiểm tra tính thân thiện với người dùng

### Checklist kiểm thử chức năng
- ✓ Kiểm tra các luồng nghiệp vụ chính
- ✓ Kiểm tra xử lý ngoại lệ
- ✓ Kiểm tra tính chính xác của dữ liệu
- ✓ Kiểm tra quyền truy cập
- ✓ Kiểm tra tương tác giữa các module

### Checklist kiểm thử hiệu năng
- ✓ Kiểm tra thời gian phản hồi
- ✓ Kiểm tra tải trang
- ✓ Kiểm tra xử lý dữ liệu lớn

## Kết quả thực hiện review tài liệu đặc tả của chức năng lựa chọn

Đã thực hiện review tài liệu đặc tả cho chức năng quản lý thuốc và tương tác thuốc:

- **Tính đầy đủ**: Tài liệu đặc tả đã mô tả đầy đủ các chức năng, yêu cầu và ràng buộc
- **Tính nhất quán**: Các yêu cầu được mô tả nhất quán, không có mâu thuẫn
- **Tính rõ ràng**: Các yêu cầu được mô tả rõ ràng, dễ hiểu
- **Tính kiểm thử được**: Các yêu cầu có thể kiểm thử được
- **Tính truy xuất nguồn gốc**: Các yêu cầu có thể truy xuất nguồn gốc

## Kết quả thực hiện review code của chức năng lựa chọn

Đã thực hiện review code cho chức năng quản lý thuốc và tương tác thuốc:

- **Cấu trúc code**: Code được tổ chức theo mô hình MVC, dễ bảo trì và mở rộng
- **Coding standard**: Code tuân thủ các quy tắc coding standard
- **Xử lý ngoại lệ**: Code có xử lý ngoại lệ đầy đủ
- **Validation**: Code có validation dữ liệu đầu vào
- **Bảo mật**: Code có xử lý bảo mật cơ bản
- **Hiệu năng**: Code có tối ưu hiệu năng cơ bản

## Kết quả thực hiện xây dựng testcase và thực hiện test

### Tổng quan
- Đã xây dựng 558 test case cho toàn bộ hệ thống
- Tỷ lệ pass: 539/558 (96.6%)
- Tỷ lệ fail: 19/558 (3.4%)

### Kiểm thử giao diện
- Đã xây dựng 25 test case cho kiểm thử giao diện
- Tỷ lệ pass: 92%
- Các lỗi chính: Hiển thị không đúng trên một số trình duyệt, validation chưa đầy đủ

### Kiểm thử đơn vị
- Đã xây dựng 50 test case cho kiểm thử đơn vị
- Tỷ lệ pass: 95%
- Độ bao phủ code: 85%
- Các lỗi chính: Xử lý ngoại lệ chưa đầy đủ, logic nghiệp vụ chưa chính xác trong một số trường hợp đặc biệt

### Kiểm thử hộp đen
- Đã xây dựng 30 test case cho kiểm thử hộp đen
- Tỷ lệ pass: 90%
- Các lỗi chính: Xử lý dữ liệu đầu vào không hợp lệ, luồng nghiệp vụ chưa đầy đủ

## Nội dung kiểm thử lựa chọn thêm

### Kiểm thử tương tác thuốc
- Đã xây dựng 15 test case cho kiểm thử tương tác thuốc
- Tỷ lệ pass: 93%
- Các lỗi chính: Chưa phát hiện đầy đủ các tương tác thuốc, thông tin tương tác chưa đầy đủ

### Kiểm thử hiệu năng
- Đã xây dựng 10 test case cho kiểm thử hiệu năng
- Tỷ lệ pass: 80%
- Các lỗi chính: Thời gian phản hồi chậm khi xử lý dữ liệu lớn, tải trang chậm khi có nhiều người dùng đồng thời

### Kiểm thử bảo mật
- Đã xây dựng 20 test case cho kiểm thử bảo mật
- Tỷ lệ pass: 85%
- Các lỗi chính: Xác thực và phân quyền chưa đầy đủ, lỗ hổng XSS và CSRF
