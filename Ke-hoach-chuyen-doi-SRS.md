# KẾ HOẠCH CHUYỂN ĐỔI TÀI LIỆU THIẾT KẾ SANG TÀI LIỆU ĐẶC TẢ YÊU CẦU PHẦN MỀM (SRS)

## 1. GIỚI THIỆU

### 1.1 Mục đích của kế hoạch
Tài liệu này trình bày kế hoạch chi tiết về cách chuyển đổi thông tin từ tài liệu thiết kế "Kien - Quang - Ky _ DATN _ Final.docx.md" sang tài liệu đặc tả yêu cầu phần mềm (SRS) theo template "1.Template SRS.md" cho hệ thống hiệu thuốc.

### 1.2 Phạm vi
Kế hoạch này bao gồm:
- Phân tích cấu trúc của template SRS
- Xác định các thông tin cần trích xuất từ tài liệu thiết kế
- Lập kế hoạch chuyển đổi thông tin
- Xác định các thông tin cần bổ sung
- Dự kiến các thách thức và giải pháp

## 2. PHÂN TÍCH CẤU TRÚC TEMPLATE SRS

Template SRS có cấu trúc chính như sau:

1. **Thông tin chung**: Mã dự án, tên dự án, ngày tạo
2. **Nội dung sửa đổi**: Bảng theo dõi các thay đổi của tài liệu
3. **Trang ký**: Thông tin người lập, kiểm tra, phê duyệt
4. **Mục lục**
5. **Giới thiệu**:
   - Mục đích tài liệu
   - Phạm vi hệ thống
   - Định nghĩa thuật ngữ viết tắt
   - Tài liệu tham khảo
   - Mô tả tài liệu
6. **Tổng quan hệ thống**:
   - Phát biểu bài toán
   - Mục tiêu hệ thống
   - Người sử dụng hệ thống
7. **Đặc tả yêu cầu chức năng**:
   - Mô tả chi tiết từng chức năng
8. **Các yêu cầu phi chức năng**:
   - Yêu cầu bảo mật
   - Yêu cầu sao lưu
   - Yêu cầu về tính sử dụng
   - Yêu cầu về tính ổn định
   - Yêu cầu về hiệu năng
   - Yêu cầu về tính hỗ trợ
   - Các ràng buộc thiết kế
   - Yêu cầu về giao tiếp
   - Các yêu cầu khác

## 3. THÔNG TIN CẦN TRÍCH XUẤT TỪ TÀI LIỆU THIẾT KẾ

Từ tài liệu thiết kế, cần trích xuất các thông tin sau:

### 3.1 Thông tin chung
- Tên dự án: "XÂY DỰNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC"
- Thông tin về nhóm phát triển

### 3.2 Thông tin cho phần Giới thiệu
- Mục đích của hệ thống (từ phần Mở đầu và Chương I)
- Phạm vi hệ thống (từ phần 1.2 Thực trạng hiện nay và 1.3 Mục tiêu của đồ án)
- Thuật ngữ và viết tắt (từ phần Bảng viết tắt và thuật ngữ)

### 3.3 Thông tin cho phần Tổng quan hệ thống
- Phát biểu bài toán (từ phần 1.1 Giới thiệu bài toán)
- Mục tiêu hệ thống (từ phần 1.3 Mục tiêu của đồ án)
- Người sử dụng hệ thống (từ phần 3.2 Hoạt động nghiệp vụ các chức năng hệ thống)

### 3.4 Thông tin cho phần Đặc tả yêu cầu chức năng
- Các chức năng chính (từ phần 3.1 Mô tả yêu cầu)
- Chi tiết từng chức năng (từ phần 3.4 Kịch bản chuẩn và ngoại lệ)

### 3.5 Thông tin cho phần Các yêu cầu phi chức năng
- Yêu cầu về công nghệ (từ phần 2.3 Ngôn ngữ sử dụng và 2.4 Framework đồ án áp dụng)
- Yêu cầu về hiệu năng (từ phần 4.6 Nhận xét đánh giá)
- Yêu cầu về bảo mật (từ phần 2.2.3 Thanh toán qua VnPay)

## 4. KẾ HOẠCH CHUYỂN ĐỔI THÔNG TIN

### 4.1 Phần thông tin chung
- Điền mã dự án (cần tạo mã dự án mới)
- Điền tên dự án: "XÂY DỰNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC"
- Điền ngày tạo tài liệu

### 4.2 Phần Giới thiệu
- **Mục đích tài liệu**: Viết mục đích của tài liệu SRS dựa trên thông tin từ phần Mở đầu
- **Phạm vi hệ thống**: Trích xuất từ phần 1.2 và 1.3 của tài liệu thiết kế
- **Định nghĩa thuật ngữ viết tắt**: Sử dụng thông tin từ phần "Bảng viết tắt và thuật ngữ"
- **Tài liệu tham khảo**: Liệt kê các tài liệu tham khảo từ tài liệu thiết kế
- **Mô tả tài liệu**: Tạo mô tả cấu trúc của tài liệu SRS

### 4.3 Phần Tổng quan hệ thống
- **Phát biểu bài toán**: Trích xuất từ phần 1.1 "Giới thiệu bài toán"
- **Mục tiêu hệ thống**: Trích xuất từ phần 1.3 "Mục tiêu của đồ án"
- **Người sử dụng hệ thống**: Trích xuất từ phần 3.2 "Hoạt động nghiệp vụ các chức năng hệ thống"

### 4.4 Phần Đặc tả yêu cầu chức năng
Tổ chức theo các phân hệ chính:

1. **Phân hệ Quản lý Người Dùng**:
   - Đăng ký và đăng nhập
   - Quản lý tài khoản cá nhân
   - Phân quyền người dùng

2. **Phân hệ Quản lý Sản Phẩm (Thuốc)**:
   - Tìm kiếm và xem chi tiết sản phẩm
   - Quản lý danh mục sản phẩm
   - Quản lý số lượng hàng tồn kho

3. **Phân hệ Đặt Hàng và Thanh Toán**:
   - Giỏ hàng
   - Đặt hàng và thanh toán
   - Theo dõi tình trạng đơn hàng

4. **Phân hệ Quản lý Đơn Hàng**:
   - Xử lý đơn hàng
   - Quản lý lịch sử giao dịch
   - Quản lý trả hàng

5. **Phân hệ Quản lý Kho và Báo Cáo**:
   - Quản lý kho
   - Báo cáo doanh thu và thống kê

6. **Phân hệ Hỗ Trợ và Tư Vấn Trực Tuyến**:
   - Tư vấn trực tuyến
   - Chatbot hỗ trợ tự động

7. **Phân hệ Quản lý Tương Tác Thuốc**:
   - Cảnh báo tương tác thuốc
   - Thông tin chi tiết về tương tác thuốc

Cho mỗi chức năng, sẽ trích xuất thông tin từ phần 3.4 "Kịch bản chuẩn và ngoại lệ" để mô tả chi tiết.

### 4.5 Phần Các yêu cầu phi chức năng
- **Yêu cầu bảo mật**: Trích xuất từ phần 2.2.3 "Thanh toán qua VnPay"
- **Yêu cầu sao lưu**: Bổ sung dựa trên thông tin từ phần 4.6 "Nhận xét đánh giá"
- **Yêu cầu về tính sử dụng**: Trích xuất từ phần 4.6 "Nhận xét đánh giá"
- **Yêu cầu về tính ổn định**: Bổ sung dựa trên thông tin từ phần 4.6 "Nhận xét đánh giá"
- **Yêu cầu về hiệu năng**: Trích xuất từ phần 4.6 "Nhận xét đánh giá"
- **Yêu cầu về tính hỗ trợ**: Bổ sung dựa trên thông tin từ phần 4.6 "Nhận xét đánh giá"
- **Các ràng buộc thiết kế**: Trích xuất từ phần 2.3 "Ngôn ngữ sử dụng" và 2.4 "Framework đồ án áp dụng"
- **Yêu cầu về giao tiếp**: Trích xuất từ phần 2.4.3 "RESTful API"

## 5. THÔNG TIN CẦN BỔ SUNG

Một số thông tin không có trong tài liệu thiết kế nhưng cần bổ sung cho tài liệu SRS:

1. **Mã dự án và mã tài liệu**: Cần tạo mã dự án và mã tài liệu mới
2. **Thông tin người lập, kiểm tra, phê duyệt**: Cần bổ sung
3. **Chi tiết về yêu cầu sao lưu**: Cần bổ sung dựa trên kinh nghiệm và thực tiễn
4. **Chi tiết về yêu cầu bảo mật**: Cần bổ sung thêm các yêu cầu bảo mật cụ thể
5. **Chi tiết về yêu cầu hiệu năng**: Cần bổ sung các chỉ số cụ thể về hiệu năng
6. **Chi tiết về các tiêu chuẩn áp dụng**: Cần bổ sung các tiêu chuẩn ngành dược phẩm

## 6. THÁCH THỨC VÀ GIẢI PHÁP

### 6.1 Thách thức
1. **Thiếu thông tin chi tiết**: Một số phần trong template SRS yêu cầu thông tin chi tiết hơn so với tài liệu thiết kế
2. **Sự khác biệt về cấu trúc**: Cấu trúc của tài liệu thiết kế khác với cấu trúc của template SRS
3. **Thông tin kỹ thuật**: Một số thông tin kỹ thuật trong tài liệu thiết kế cần được chuyển đổi sang ngôn ngữ yêu cầu

### 6.2 Giải pháp
1. **Bổ sung thông tin**: Dựa trên kinh nghiệm và thực tiễn để bổ sung các thông tin còn thiếu
2. **Tái cấu trúc thông tin**: Sắp xếp lại thông tin từ tài liệu thiết kế để phù hợp với cấu trúc của template SRS
3. **Chuyển đổi ngôn ngữ**: Chuyển đổi thông tin kỹ thuật sang ngôn ngữ yêu cầu, tập trung vào "cái gì" thay vì "như thế nào"

## 7. KẾT LUẬN

Kế hoạch này đã trình bày chi tiết cách chuyển đổi thông tin từ tài liệu thiết kế sang tài liệu đặc tả yêu cầu phần mềm (SRS) theo template. Việc thực hiện theo kế hoạch này sẽ giúp tạo ra một tài liệu SRS đầy đủ và chất lượng cho hệ thống hiệu thuốc, đáp ứng yêu cầu của bài tập nhóm về kiểm định.
