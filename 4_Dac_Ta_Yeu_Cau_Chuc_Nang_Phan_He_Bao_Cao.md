# 4. ĐẶC TẢ YÊU CẦU CHỨC NĂNG

## 4.1. Phân hệ báo cáo và thống kê

### 4.1.1. SREQ001 - Báo cáo doanh thu (UR001)

#### 1. Mô tả nghiệp vụ
Chức năng báo cáo doanh thu cho phép người dùng xem và phân tích doanh thu của hiệu thuốc theo các khoảng thời gian khác nhau (ngày, tháng, năm). Người dùng có thể xem doanh thu dưới dạng biểu đồ trực quan hoặc bảng dữ liệu chi tiết, đồng thời có thể xuất báo cáo ra các định dạng phổ biến để lưu trữ hoặc chia sẻ.

#### 2. Yêu cầu chức năng

##### Dữ liệu đầu vào
- Khoảng thời gian báo cáo: ngày cụ thể, tháng/năm, hoặc năm
- Loại báo cáo: theo giờ (cho báo cáo ngày), theo ngày (cho báo cáo tháng), theo tháng (cho báo cáo năm)
- Định dạng xuất báo cáo: PDF, Excel

##### Yêu cầu xử lý
- Hệ thống tính toán tổng doanh thu dựa trên các đơn hàng đã thanh toán và không bị trả lại trong khoảng thời gian được chọn
- Hệ thống tính toán số lượng đơn hàng thành công và số lượng đơn hàng bị trả lại
- Hệ thống hiển thị dữ liệu doanh thu theo đơn vị thời gian phù hợp:
  - Theo giờ trong ngày (cho báo cáo ngày)
  - Theo ngày trong tháng (cho báo cáo tháng)
  - Theo tháng trong năm (cho báo cáo năm)
- Hệ thống tạo biểu đồ trực quan (cột, đường) để thể hiện xu hướng doanh thu
- Hệ thống cho phép xuất báo cáo ra file PDF hoặc Excel với đầy đủ thông tin và định dạng phù hợp

##### Các yêu cầu đặc biệt
- Chỉ người dùng có quyền Admin hoặc Manager mới có thể truy cập chức năng này
- Thời gian tạo báo cáo không quá 5 giây cho báo cáo đơn giản, không quá 10 giây cho báo cáo phức tạp
- Hệ thống cho phép so sánh doanh thu giữa các khoảng thời gian (ví dụ: so sánh doanh thu tháng này với tháng trước)

##### Yêu cầu phi chức năng
- Độ chính xác: Dữ liệu báo cáo phải chính xác 100% so với dữ liệu gốc
- Hiệu năng: Thời gian phản hồi khi tạo báo cáo không quá 5 giây
- Bảo mật: Dữ liệu báo cáo phải được bảo mật và chỉ hiển thị cho người dùng có quyền truy cập

### 4.1.2. SREQ002 - Báo cáo tồn kho (UR002)

#### 1. Mô tả nghiệp vụ
Chức năng báo cáo tồn kho cho phép người dùng xem thông tin về số lượng thuốc còn trong kho, bao gồm các thuốc sắp hết hàng hoặc sắp hết hạn sử dụng. Báo cáo này giúp quản lý hiệu quả việc nhập hàng và đảm bảo luôn có đủ thuốc để bán.

#### 2. Yêu cầu chức năng

##### Dữ liệu đầu vào
- Ngày báo cáo (mặc định là ngày hiện tại)
- Bộ lọc: tên thuốc, loại thuốc, nhà sản xuất
- Ngưỡng cảnh báo: số lượng tối thiểu để cảnh báo sắp hết hàng
- Thời gian cảnh báo hết hạn: số ngày trước khi thuốc hết hạn để cảnh báo
- Định dạng xuất báo cáo: PDF, Excel

##### Yêu cầu xử lý
- Hệ thống truy xuất thông tin tồn kho của tất cả các thuốc tại thời điểm báo cáo
- Hệ thống đánh dấu các thuốc có số lượng tồn dưới ngưỡng cảnh báo
- Hệ thống đánh dấu các thuốc sắp hết hạn sử dụng (trong vòng thời gian cảnh báo)
- Hệ thống tính toán tổng giá trị hàng tồn kho
- Hệ thống cho phép lọc danh sách theo tên thuốc, loại thuốc, nhà sản xuất
- Hệ thống cho phép xuất báo cáo ra file PDF hoặc Excel với đầy đủ thông tin và định dạng phù hợp

##### Các yêu cầu đặc biệt
- Người dùng có quyền Admin, Manager hoặc Pharmacist mới có thể truy cập chức năng này
- Báo cáo phải hiển thị rõ ràng các cảnh báo về thuốc sắp hết hàng hoặc sắp hết hạn
- Hệ thống cho phép sắp xếp danh sách theo nhiều tiêu chí khác nhau (tên thuốc, số lượng tồn, ngày hết hạn)

##### Yêu cầu phi chức năng
- Độ chính xác: Dữ liệu báo cáo phải chính xác 100% so với dữ liệu gốc
- Hiệu năng: Thời gian phản hồi khi tạo báo cáo không quá 3 giây
- Khả năng sử dụng: Giao diện báo cáo phải trực quan, dễ đọc, với các cảnh báo được làm nổi bật

### 4.1.3. SREQ003 - Báo cáo thuốc bán chạy (UR003)

#### 1. Mô tả nghiệp vụ
Chức năng báo cáo thuốc bán chạy cho phép người dùng xem thông tin về các thuốc được bán nhiều nhất trong một khoảng thời gian. Báo cáo này giúp phân tích xu hướng tiêu dùng và hỗ trợ việc lập kế hoạch nhập hàng, khuyến mãi.

#### 2. Yêu cầu chức năng

##### Dữ liệu đầu vào
- Khoảng thời gian báo cáo: ngày, tuần, tháng, năm
- Số lượng thuốc hiển thị (top 5, top 10, top 20...)
- Bộ lọc: loại thuốc, nhà sản xuất
- Định dạng xuất báo cáo: PDF, Excel

##### Yêu cầu xử lý
- Hệ thống tính toán số lượng bán ra của từng loại thuốc trong khoảng thời gian được chọn
- Hệ thống sắp xếp danh sách thuốc theo thứ tự giảm dần về số lượng bán ra
- Hệ thống hiển thị danh sách các thuốc bán chạy nhất theo số lượng đã chọn
- Hệ thống tạo biểu đồ trực quan (cột, bánh) để thể hiện tỷ lệ bán ra của các thuốc
- Hệ thống cho phép lọc danh sách theo loại thuốc, nhà sản xuất
- Hệ thống cho phép xuất báo cáo ra file PDF hoặc Excel với đầy đủ thông tin và định dạng phù hợp

##### Các yêu cầu đặc biệt
- Người dùng có quyền Admin, Manager hoặc Pharmacist mới có thể truy cập chức năng này
- Báo cáo phải hiển thị thông tin chi tiết về từng thuốc (tên, mã, loại, nhà sản xuất, số lượng bán, doanh thu)
- Hệ thống cho phép so sánh dữ liệu giữa các khoảng thời gian (ví dụ: so sánh thuốc bán chạy tháng này với tháng trước)

##### Yêu cầu phi chức năng
- Độ chính xác: Dữ liệu báo cáo phải chính xác 100% so với dữ liệu gốc
- Hiệu năng: Thời gian phản hồi khi tạo báo cáo không quá 5 giây
- Trực quan: Biểu đồ phải rõ ràng, dễ hiểu và có màu sắc phân biệt

### 4.1.4. SREQ004 - Xuất báo cáo (UR004)

#### 1. Mô tả nghiệp vụ
Chức năng xuất báo cáo cho phép người dùng xuất các báo cáo đã tạo ra các định dạng phổ biến như PDF, Excel để lưu trữ, in ấn hoặc chia sẻ. Chức năng này áp dụng cho tất cả các loại báo cáo trong hệ thống.

#### 2. Yêu cầu chức năng

##### Dữ liệu đầu vào
- Loại báo cáo cần xuất (doanh thu, tồn kho, thuốc bán chạy)
- Định dạng xuất báo cáo: PDF, Excel
- Tùy chọn bao gồm/loại trừ biểu đồ trong báo cáo xuất
- Tùy chọn bao gồm/loại trừ dữ liệu chi tiết trong báo cáo xuất

##### Yêu cầu xử lý
- Hệ thống tạo file báo cáo theo định dạng đã chọn với đầy đủ thông tin và định dạng phù hợp
- Hệ thống đảm bảo file xuất ra có tiêu đề, ngày tạo báo cáo, và thông tin người tạo
- Hệ thống đảm bảo file Excel có các cột và định dạng dữ liệu phù hợp
- Hệ thống đảm bảo file PDF có bố cục rõ ràng, dễ đọc
- Hệ thống cho phép tải xuống file báo cáo sau khi tạo xong

##### Các yêu cầu đặc biệt
- Người dùng có quyền truy cập báo cáo nào thì mới có thể xuất báo cáo đó
- File xuất ra phải có tiêu đề rõ ràng, bao gồm loại báo cáo và khoảng thời gian
- File Excel phải có định dạng cột và ô phù hợp, với các công thức tính toán tổng, trung bình nếu cần
- File PDF phải có header, footer với thông tin công ty, ngày tạo báo cáo

##### Yêu cầu phi chức năng
- Hiệu năng: Thời gian tạo và xuất báo cáo không quá 10 giây
- Bảo mật: File xuất ra phải được bảo vệ để tránh chỉnh sửa trái phép
- Tương thích: File xuất ra phải tương thích với các phiên bản phổ biến của Microsoft Excel, Adobe Reader
