# Kết quả kiểm thử giao diện "Báo cáo doanh thu theo ngày"

## Thông tin chung
- **Chức năng kiểm thử**: Báo cáo doanh thu theo ngày
- **Người thực hiện**: [Tên người thực hiện]
- **Ngày thực hiện**: [Ngày thực hiện]
- **Môi trường kiểm thử**: 
  - Hệ điều hành: Windows 11
  - Trình duyệt: Chrome 114.0.5735.199
  - Độ phân giải màn hình: 1920x1080

## Kết quả kiểm thử

### I. Kiểm tra giao diện màn hình "Báo cáo doanh thu theo ngày"

#### BC_001: Kiểm tra hiển thị mặc định của màn hình "Báo cáo doanh thu theo ngày"
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Tiêu đề "Báo cáo doanh thu theo ngày" hiển thị đúng
  - Phần chọn ngày hiển thị với giá trị mặc định là ngày hiện tại
  - Nút "Xem báo cáo" hiển thị đúng
  - Biểu đồ doanh thu theo giờ trong ngày hiển thị đúng
  - Bảng dữ liệu chi tiết hiển thị đầy đủ các cột: Giờ, Doanh thu, Số đơn hàng, Số đơn trả lại
  - Thông tin tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại hiển thị đúng
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_002: Kiểm tra font chữ và màu sắc của màn hình "Báo cáo doanh thu theo ngày"
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Font chữ tiêu đề là Arial, cỡ chữ 20px, màu xanh đậm
  - Font chữ nội dung là Arial, cỡ chữ 14px, màu đen
  - Màu nền của biểu đồ là trắng
  - Màu của các cột trong biểu đồ là xanh dương
  - Màu nền của bảng dữ liệu là trắng, với các dòng xen kẽ màu xám nhạt
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_003: Kiểm tra bố cục của màn hình "Báo cáo doanh thu theo ngày"
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Tiêu đề nằm ở phía trên cùng của màn hình
  - Phần chọn ngày và nút "Xem báo cáo" nằm dưới tiêu đề
  - Biểu đồ doanh thu nằm dưới phần chọn ngày, chiếm khoảng 50% chiều cao màn hình
  - Bảng dữ liệu chi tiết nằm dưới biểu đồ
  - Thông tin tổng hợp nằm bên cạnh biểu đồ
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_004: Kiểm tra tính responsive của màn hình "Báo cáo doanh thu theo ngày" trên desktop
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Giao diện hiển thị đầy đủ và cân đối trên các độ phân giải desktop 1920x1080 và 1366x768
  - Không có thanh cuộn ngang
  - Biểu đồ và bảng dữ liệu tự động điều chỉnh kích thước phù hợp
  - Tất cả các thành phần dễ đọc và dễ sử dụng
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_005: Kiểm tra tính responsive của màn hình "Báo cáo doanh thu theo ngày" trên tablet và mobile
- **Kết quả**: Failed
- **Mô tả kết quả thực tế**:
  - Giao diện tự động điều chỉnh trên tablet (768x1024) nhưng không tối ưu trên mobile (375x667)
  - Bảng dữ liệu không hiển thị tốt trên màn hình mobile, cần phải cuộn ngang để xem đầy đủ thông tin
  - Biểu đồ bị thu nhỏ quá mức trên mobile, khó đọc thông tin
  - Menu được thu gọn thành nút hamburger đúng như mong đợi
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]
- **Lỗi phát hiện**: Bảng dữ liệu không responsive trên màn hình mobile, cần phải cuộn ngang để xem đầy đủ thông tin

### II. Kiểm tra chức năng của màn hình "Báo cáo doanh thu theo ngày"

#### BC_006: Kiểm tra chức năng chọn ngày trên màn hình "Báo cáo doanh thu theo ngày"
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Lịch hiển thị khi nhấp vào ô chọn ngày
  - Có thể chọn ngày từ lịch
  - Ngày đã chọn được hiển thị trong ô chọn ngày theo định dạng DD/MM/YYYY
  - Có thể chọn ngày trong quá khứ
  - Không thể chọn ngày trong tương lai
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_007: Kiểm tra chức năng "Xem báo cáo" với ngày có dữ liệu
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Biểu đồ doanh thu theo giờ được cập nhật với dữ liệu của ngày đã chọn
  - Bảng dữ liệu chi tiết được cập nhật với dữ liệu của ngày đã chọn
  - Tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại được cập nhật chính xác
  - Dữ liệu hiển thị khớp với dữ liệu từ backend
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_008: Kiểm tra chức năng "Xem báo cáo" với ngày không có dữ liệu
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Biểu đồ doanh thu theo giờ hiển thị với giá trị 0 cho tất cả các giờ
  - Bảng dữ liệu chi tiết hiển thị với giá trị 0 cho tất cả các giờ
  - Tổng doanh thu, tổng số đơn hàng, tổng số đơn trả lại hiển thị giá trị 0
  - Không có thông báo lỗi
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_009: Kiểm tra hiển thị biểu đồ doanh thu theo giờ
- **Kết quả**: Passed
- **Mô tả kết quả thực tế**:
  - Biểu đồ dạng cột hiển thị doanh thu theo từng giờ trong ngày (0-23)
  - Trục X hiển thị các giờ từ 0 đến 23
  - Trục Y hiển thị doanh thu
  - Có tiêu đề biểu đồ "Doanh thu theo giờ"
  - Có chú thích cho biểu đồ
  - Khi di chuột qua mỗi cột, hiển thị tooltip với thông tin chi tiết về doanh thu tại giờ đó
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]

#### BC_010: Kiểm tra chức năng xuất báo cáo ra file
- **Kết quả**: Failed
- **Mô tả kết quả thực tế**:
  - Không tìm thấy nút "Xuất Excel" hoặc "Xuất PDF" trên giao diện
  - Chức năng xuất báo cáo ra file chưa được triển khai
- **Ảnh chụp màn hình**: [Đính kèm ảnh chụp màn hình]
- **Lỗi phát hiện**: Chức năng xuất báo cáo ra file chưa được triển khai mặc dù đã được đặc tả trong tài liệu yêu cầu

## Tổng hợp kết quả

| Loại test case | Số lượng | Passed | Failed | Pass rate |
|----------------|----------|--------|--------|-----------|
| Kiểm thử giao diện | 5 | 4 | 1 | 80% |
| Kiểm thử chức năng | 5 | 4 | 1 | 80% |
| **Tổng cộng** | **10** | **8** | **2** | **80%** |

## Các lỗi phát hiện

1. **BC_005: Tính responsive trên mobile**
   - **Mô tả lỗi**: Bảng dữ liệu không hiển thị tốt trên màn hình mobile, cần phải cuộn ngang để xem đầy đủ thông tin
   - **Mức độ nghiêm trọng**: Medium
   - **Nguyên nhân**: Thiếu CSS responsive cho bảng dữ liệu trên màn hình nhỏ
   - **Đề xuất khắc phục**: Thêm CSS để bảng dữ liệu hiển thị dạng card thay vì dạng bảng trên màn hình mobile

2. **BC_010: Chức năng xuất báo cáo ra file**
   - **Mô tả lỗi**: Chức năng xuất báo cáo ra file chưa được triển khai
   - **Mức độ nghiêm trọng**: High
   - **Nguyên nhân**: Chức năng chưa được phát triển mặc dù đã có trong tài liệu đặc tả
   - **Đề xuất khắc phục**: Triển khai chức năng xuất báo cáo ra file Excel và PDF theo yêu cầu đặc tả

## Kết luận và đề xuất

Giao diện "Báo cáo doanh thu theo ngày" đã đáp ứng được phần lớn các yêu cầu về hiển thị và chức năng cơ bản. Tuy nhiên, còn một số vấn đề cần được khắc phục:

1. **Cải thiện tính responsive trên mobile**:
   - Thiết kế lại bảng dữ liệu để hiển thị tốt hơn trên màn hình nhỏ
   - Có thể chuyển đổi từ dạng bảng sang dạng card trên mobile
   - Điều chỉnh kích thước biểu đồ để dễ đọc hơn trên màn hình nhỏ

2. **Triển khai chức năng xuất báo cáo**:
   - Thêm nút "Xuất Excel" và "Xuất PDF" trên giao diện
   - Triển khai chức năng xuất báo cáo ra file Excel sử dụng thư viện xlsx
   - Triển khai chức năng xuất báo cáo ra file PDF sử dụng thư viện jspdf và html2canvas

3. **Cải thiện trải nghiệm người dùng**:
   - Thêm animation khi chuyển đổi giữa các tab báo cáo
   - Thêm tính năng so sánh doanh thu giữa các ngày
   - Thêm bộ lọc để xem doanh thu theo khoảng giờ cụ thể
