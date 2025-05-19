# 3. ĐẠC TẢ YÊU CẦU CHO TỪNG THÀNH PHẦN HỆ THỐNG

Dựa trên system concept và mô hình triển khai của hệ thống, các thành phần cần có của hệ thống quản lý hiệu thuốc được xác định như sau:

## 3.1. Yêu cầu đối với Database Server

- **Lưu trữ dữ liệu**: Lưu trữ toàn bộ dữ liệu của hệ thống hiệu thuốc, bao gồm thông tin về thuốc, đơn hàng, khách hàng, nhân viên, và các dữ liệu nghiệp vụ khác.
- **Hiệu năng**: Đảm bảo thời gian trả lời cho các giao dịch không quá 3 giây.
- **Khả năng xử lý đồng thời**: Hỗ trợ tối thiểu 100 kết nối đồng thời.
- **Throughput**: Khả năng xử lý tối thiểu 1000 giao dịch/phút.
- **Sao lưu và phục hồi**: Sao lưu tự động hàng ngày và khả năng phục hồi dữ liệu trong vòng 4 giờ.
- **Hệ quản trị CSDL**: PostgreSQL 14.x hoặc cao hơn.
- **Dung lượng lưu trữ**: Tối thiểu 50GB, có khả năng mở rộng khi cần thiết.
- **Bảo mật**: Mã hóa dữ liệu nhạy cảm, kiểm soát truy cập chặt chẽ.

## 3.2. Yêu cầu đối với Application Server

- **Xử lý nghiệp vụ**: Xử lý toàn bộ logic nghiệp vụ và cung cấp API cho client.
- **Hiệu năng API**: Thời gian phản hồi API đơn giản dưới 200ms, API phức tạp dưới 2 giây.
- **Khả năng xử lý**: Xử lý tối thiểu 50 request/giây.
- **Khả năng phục vụ đồng thời**: Hỗ trợ tối thiểu 500 người dùng đồng thời.
- **Bảo mật**: Đảm bảo bảo mật thông tin với JWT và HTTPS.
- **Môi trường runtime**: Java 17 hoặc cao hơn, Spring Boot framework.
- **Tài nguyên phần cứng**: 
  - CPU: Tối thiểu 4 cores
  - RAM: Tối thiểu 8GB
  - Ổ cứng: SSD tối thiểu 20GB
- **Khả năng mở rộng**: Có khả năng scale theo chiều ngang khi cần thiết.
- **Xử lý lỗi**: Có cơ chế ghi log, theo dõi và xử lý lỗi hiệu quả.

## 3.3. Yêu cầu đối với Web Server

- **Phục vụ giao diện**: Phục vụ giao diện người dùng và xử lý các yêu cầu HTTP từ người dùng.
- **Hiệu năng**: Thời gian phản hồi dưới 100ms.
- **Throughput**: Tối thiểu 1000 request/giây.
- **Kết nối đồng thời**: Hỗ trợ tối thiểu 1000 kết nối đồng thời.
- **Bảo mật**: Đảm bảo bảo mật với chứng chỉ SSL/TLS.
- **Cấu hình**: Hỗ trợ cấu hình load balancing và caching.
- **Tài nguyên phần cứng**:
  - CPU: Tối thiểu 2 cores
  - RAM: Tối thiểu 4GB
  - Ổ cứng: SSD tối thiểu 10GB
- **Khả năng nén**: Hỗ trợ nén dữ liệu (GZIP, Brotli) để tối ưu băng thông.

## 3.4. Yêu cầu đối với Frontend Client

- **Giao diện người dùng**: Giao diện thân thiện, dễ sử dụng, responsive trên các thiết bị.
- **Hiệu năng**: Thời gian tải trang lần đầu dưới 3 giây, sau khi cache dưới 1 giây.
- **Tương thích**: Tương thích với các trình duyệt phổ biến: Chrome, Firefox, Safari, Edge.
- **Công nghệ**: Angular framework, TypeScript, HTML5, CSS3.
- **Tài nguyên phần cứng (máy khách)**:
  - CPU: Intel Core i3 / AMD Ryzen 3 trở lên
  - RAM: Tối thiểu 4GB
  - Ổ cứng: Tối thiểu 5GB trống
- **Kết nối mạng**: Tối thiểu 1Mbps.
- **Tối ưu hóa**: Lazy loading, code splitting để tối ưu thời gian tải.

## 3.5. Yêu cầu đối với Hệ thống Email

- **Chức năng**: Gửi email thông báo, xác nhận đơn hàng, đặt lại mật khẩu.
- **Hiệu năng**: Thời gian gửi email không quá 30 giây.
- **Khả năng xử lý**: Xử lý tối thiểu 100 email/phút.
- **Độ tin cậy**: Tỷ lệ gửi thành công tối thiểu 99%.
- **Bảo mật**: Hỗ trợ TLS/SSL cho kết nối SMTP.
- **Dịch vụ email**: Sử dụng SMTP của Gmail hoặc dịch vụ email chuyên dụng.

## 3.6. Yêu cầu đối với Hệ thống Lưu trữ File

- **Chức năng**: Lưu trữ hình ảnh thuốc, tài liệu, và các file đính kèm.
- **Dung lượng**: Hỗ trợ lưu trữ tối thiểu 50GB dữ liệu.
- **Hiệu năng**: Thời gian tải lên/tải xuống file không quá 5 giây cho file dưới 5MB.
- **Định dạng hỗ trợ**: JPEG, PNG, PDF, DOCX, XLSX.
- **Bảo mật**: Kiểm soát truy cập, quét virus/malware.
- **Dịch vụ**: Sử dụng Cloudinary hoặc dịch vụ lưu trữ file tương tự.

## 3.7. Yêu cầu đối với Hệ thống Báo cáo và Thống kê

- **Chức năng**: Tạo báo cáo doanh thu, tồn kho, thuốc bán chạy.
- **Hiệu năng**: Thời gian tạo báo cáo không quá 10 giây cho báo cáo đơn giản, không quá 30 giây cho báo cáo phức tạp.
- **Định dạng xuất**: PDF, Excel, CSV.
- **Trực quan hóa**: Hỗ trợ biểu đồ, đồ thị để trực quan hóa dữ liệu.
- **Lập lịch**: Hỗ trợ lập lịch tạo báo cáo tự động (hàng ngày, hàng tuần, hàng tháng).

## 3.8. Yêu cầu đối với Hệ thống Thanh toán

- **Phương thức thanh toán**: Hỗ trợ thanh toán tiền mặt, chuyển khoản, thẻ ngân hàng.
- **Hiệu năng**: Thời gian xử lý thanh toán không quá 5 giây.
- **Bảo mật**: Tuân thủ tiêu chuẩn bảo mật PCI DSS.
- **Xác thực**: Hỗ trợ xác thực hai yếu tố cho các giao dịch lớn.
- **Thông báo**: Gửi thông báo xác nhận thanh toán qua email/SMS.
