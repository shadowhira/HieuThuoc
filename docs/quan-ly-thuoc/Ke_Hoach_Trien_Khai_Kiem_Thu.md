# KẾ HOẠCH TRIỂN KHAI KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## 1. TỔNG QUAN

### 1.1 Mục đích
Tài liệu này cung cấp kế hoạch triển khai chi tiết cho việc kiểm thử chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc. Kế hoạch này bao gồm các loại kiểm thử khác nhau, lịch trình thực hiện, phân công nhiệm vụ và các tài nguyên cần thiết.

### 1.2 Phạm vi
Kế hoạch kiểm thử bao gồm:
- Kiểm thử đơn vị (Unit Testing)
- Kiểm thử tích hợp (Integration Testing)
- Kiểm thử hệ thống (System Testing)
- Kiểm thử giao diện (UI Testing)
- Kiểm thử chức năng (Functional Testing)

### 1.3 Tài liệu tham khảo
- Tài liệu đặc tả yêu cầu phần mềm
- Tài liệu thiết kế hệ thống
- Tài liệu kiểm thử đơn vị
- Tài liệu kiểm thử tích hợp
- Tài liệu kiểm thử hệ thống
- Tài liệu kiểm thử giao diện
- Tài liệu kiểm thử chức năng

## 2. CHIẾN LƯỢC KIỂM THỬ

### 2.1 Kiểm thử đơn vị (Unit Testing)
- **Mục tiêu**: Kiểm thử các thành phần nhỏ nhất của hệ thống một cách độc lập
- **Phạm vi**: Service, Controller, Repository, Component
- **Công cụ**: JUnit, Mockito, Jest, Jasmine
- **Người thực hiện**: Lập trình viên
- **Tài liệu tham khảo**: [Kiểm thử đơn vị](./Kiem_Thu_Don_Vi.md)

### 2.2 Kiểm thử tích hợp (Integration Testing)
- **Mục tiêu**: Kiểm thử sự tương tác giữa các thành phần trong hệ thống
- **Phạm vi**: Tích hợp giữa các thành phần backend, tích hợp frontend-backend
- **Công cụ**: Spring Boot Test, TestRestTemplate, MockMvc, Angular HttpClientTestingModule
- **Người thực hiện**: Lập trình viên, Tester
- **Tài liệu tham khảo**: [Kiểm thử tích hợp](./Kiem_Thu_Tich_Hop.md)

### 2.3 Kiểm thử hệ thống (System Testing)
- **Mục tiêu**: Kiểm thử toàn bộ hệ thống từ đầu đến cuối
- **Phạm vi**: Luồng nghiệp vụ, hiệu năng, tương thích
- **Công cụ**: Selenium, Cypress, JMeter
- **Người thực hiện**: Tester
- **Tài liệu tham khảo**: [Kiểm thử hệ thống](./Kiem_Thu_He_Thong.md)

### 2.4 Kiểm thử giao diện (UI Testing)
- **Mục tiêu**: Kiểm thử giao diện người dùng
- **Phạm vi**: Giao diện danh sách, thêm/sửa, chi tiết, tìm kiếm, responsive
- **Công cụ**: Cypress, Selenium
- **Người thực hiện**: Tester
- **Tài liệu tham khảo**: [Kiểm thử giao diện - Phần 1](./Kiem_Thu_Giao_Dien_Phan1.md), [Kiểm thử giao diện - Phần 2](./Kiem_Thu_Giao_Dien_Phan2.md)

### 2.5 Kiểm thử chức năng (Functional Testing)
- **Mục tiêu**: Kiểm thử các chức năng của hệ thống
- **Phạm vi**: Thêm, sửa, xóa, tìm kiếm thuốc
- **Công cụ**: Postman, JUnit, Cypress
- **Người thực hiện**: Tester
- **Tài liệu tham khảo**: [Kiểm thử chức năng - Phần 1](./Kiem_Thu_Chuc_Nang_Phan1.md), [Kiểm thử chức năng - Phần 2](./Kiem_Thu_Chuc_Nang_Phan2.md), [Kiểm thử chức năng - Phần 3](./Kiem_Thu_Chuc_Nang_Phan3.md)

## 3. LỊCH TRÌNH THỰC HIỆN

### 3.1 Giai đoạn 1: Chuẩn bị (Ngày 1)
- Chuẩn bị môi trường kiểm thử
- Chuẩn bị dữ liệu kiểm thử
- Chuẩn bị các công cụ kiểm thử
- Phân công nhiệm vụ

### 3.2 Giai đoạn 2: Kiểm thử đơn vị (Ngày 1-2)
- Viết test case cho các service
- Viết test case cho các controller
- Viết test case cho các component
- Chạy kiểm thử và sửa lỗi

### 3.3 Giai đoạn 3: Kiểm thử tích hợp (Ngày 2-3)
- Viết test case cho tích hợp backend
- Viết test case cho tích hợp frontend-backend
- Chạy kiểm thử và sửa lỗi

### 3.4 Giai đoạn 4: Kiểm thử chức năng (Ngày 3-4)
- Viết test case cho chức năng thêm thuốc
- Viết test case cho chức năng sửa thuốc
- Viết test case cho chức năng xóa thuốc
- Viết test case cho chức năng tìm kiếm thuốc
- Chạy kiểm thử và sửa lỗi

### 3.5 Giai đoạn 5: Kiểm thử giao diện (Ngày 4-5)
- Viết test case cho giao diện danh sách thuốc
- Viết test case cho giao diện thêm/sửa thuốc
- Viết test case cho giao diện chi tiết thuốc
- Viết test case cho giao diện tìm kiếm thuốc
- Chạy kiểm thử và sửa lỗi

### 3.6 Giai đoạn 6: Kiểm thử hệ thống (Ngày 5)
- Viết test case cho luồng nghiệp vụ từ đầu đến cuối
- Viết test case cho hiệu năng
- Viết test case cho tương thích
- Chạy kiểm thử và sửa lỗi

### 3.7 Giai đoạn 7: Tổng hợp và báo cáo (Ngày 6)
- Tổng hợp kết quả kiểm thử
- Phân tích lỗi
- Viết báo cáo kiểm thử
- Đề xuất cải tiến

## 4. PHÂN CÔNG NHIỆM VỤ

### 4.1 Lập trình viên
- Viết và chạy kiểm thử đơn vị
- Viết và chạy kiểm thử tích hợp backend
- Sửa lỗi phát hiện trong quá trình kiểm thử

### 4.2 Tester
- Viết và chạy kiểm thử tích hợp frontend-backend
- Viết và chạy kiểm thử chức năng
- Viết và chạy kiểm thử giao diện
- Viết và chạy kiểm thử hệ thống
- Tổng hợp kết quả kiểm thử
- Viết báo cáo kiểm thử

## 5. TÀI NGUYÊN CẦN THIẾT

### 5.1 Phần cứng
- Máy tính phát triển: Laptop hoặc PC với cấu hình đủ để chạy các công cụ kiểm thử
- Máy chủ kiểm thử: Máy chủ để triển khai môi trường kiểm thử

### 5.2 Phần mềm
- IDE: IntelliJ IDEA, Visual Studio Code
- Công cụ kiểm thử: JUnit, Mockito, Jest, Jasmine, Cypress, Selenium, JMeter, Postman
- Công cụ quản lý phiên bản: Git
- Công cụ quản lý dự án: Jira, Trello

### 5.3 Dữ liệu kiểm thử
- Dữ liệu mẫu cho thuốc, loại thuốc, danh mục thuốc, nhà sản xuất
- Dữ liệu mẫu cho đơn hàng, chi tiết đơn hàng
- Hình ảnh mẫu cho thuốc

## 6. QUẢN LÝ RỦI RO

### 6.1 Rủi ro và biện pháp giảm thiểu

| Rủi ro | Mức độ ảnh hưởng | Khả năng xảy ra | Biện pháp giảm thiểu |
|--------|-----------------|-----------------|----------------------|
| Thiếu thời gian kiểm thử | Cao | Trung bình | Ưu tiên kiểm thử các chức năng quan trọng, tự động hóa kiểm thử |
| Thiếu dữ liệu kiểm thử | Trung bình | Thấp | Chuẩn bị dữ liệu kiểm thử trước, sử dụng công cụ tạo dữ liệu mẫu |
| Lỗi môi trường kiểm thử | Cao | Thấp | Chuẩn bị môi trường dự phòng, sao lưu dữ liệu kiểm thử |
| Thay đổi yêu cầu | Trung bình | Trung bình | Quản lý thay đổi, cập nhật kế hoạch kiểm thử khi có thay đổi |
| Thiếu nhân lực | Cao | Thấp | Phân công nhiệm vụ hợp lý, ưu tiên kiểm thử các chức năng quan trọng |

## 7. BÁO CÁO VÀ THEO DÕI

### 7.1 Báo cáo kiểm thử
- Báo cáo hàng ngày: Tổng hợp kết quả kiểm thử trong ngày, các vấn đề phát hiện
- Báo cáo cuối giai đoạn: Tổng hợp kết quả kiểm thử của giai đoạn, các vấn đề phát hiện, đề xuất cải tiến
- Báo cáo cuối dự án: Tổng hợp kết quả kiểm thử của dự án, các vấn đề phát hiện, đề xuất cải tiến

### 7.2 Theo dõi lỗi
- Sử dụng công cụ quản lý lỗi (Jira, Trello) để theo dõi các lỗi phát hiện
- Phân loại lỗi theo mức độ nghiêm trọng
- Gán lỗi cho người phụ trách
- Theo dõi trạng thái xử lý lỗi

## 8. TIÊU CHÍ HOÀN THÀNH

### 8.1 Tiêu chí hoàn thành kiểm thử
- Tất cả các test case đã được thực hiện
- Tất cả các lỗi nghiêm trọng đã được sửa
- Độ bao phủ code đạt tối thiểu 80%
- Báo cáo kiểm thử đã được hoàn thành

### 8.2 Tiêu chí chấp nhận
- Tất cả các chức năng hoạt động đúng theo yêu cầu
- Giao diện người dùng thân thiện và dễ sử dụng
- Hiệu năng đáp ứng yêu cầu
- Tương thích với các trình duyệt phổ biến

## 9. KẾT LUẬN

Kế hoạch triển khai kiểm thử này cung cấp một cách tiếp cận có hệ thống để kiểm thử chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc. Bằng cách tuân theo kế hoạch này, chúng ta có thể đảm bảo rằng chức năng Quản lý thuốc hoạt động đúng, đáp ứng các yêu cầu về chức năng, hiệu năng và trải nghiệm người dùng.

Việc kết hợp các loại kiểm thử khác nhau (đơn vị, tích hợp, hệ thống, giao diện, chức năng) sẽ giúp phát hiện và khắc phục các lỗi ở nhiều cấp độ khác nhau, từ đó nâng cao chất lượng tổng thể của phần mềm.

Để đảm bảo hiệu quả của quá trình kiểm thử, cần tuân thủ lịch trình, phân công nhiệm vụ hợp lý, chuẩn bị đầy đủ tài nguyên cần thiết và quản lý rủi ro một cách chủ động.
