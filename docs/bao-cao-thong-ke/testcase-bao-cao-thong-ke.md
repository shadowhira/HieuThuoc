# Testcase cho Chức năng Báo cáo và Thống kê

## 1. Kiểm tra Hiển thị Cơ bản của Báo cáo

### TC-REP-001: Kiểm tra Các Thành phần Cơ bản của Dashboard
**Mô tả:** Kiểm tra tất cả các thành phần cơ bản của dashboard báo cáo được hiển thị chính xác.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Quan sát các thành phần của dashboard

**Dữ liệu đầu vào:** Thông tin đăng nhập hợp lệ của admin
**Kết quả mong đợi:**
- Số lượng "Hóa đơn" được hiển thị
- Số lượng "Đơn hàng trả lại" được hiển thị
- Tổng "Doanh thu" được hiển thị
- Biểu đồ doanh thu được hiển thị với nhãn ngày chính xác
- Bộ lọc thời gian (Theo ngày/tháng/năm) có sẵn

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Người dùng có quyền truy cập báo cáo
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-002: Kiểm tra Tính toán Tổng Doanh thu
**Mô tả:** Kiểm tra tổng doanh thu hiển thị khớp với tổng của tất cả giao dịch trong khoảng thời gian đã chọn.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian cụ thể
4. So sánh tổng hiển thị với tổng dự kiến

**Dữ liệu đầu vào:** Khoảng thời gian với dữ liệu giao dịch đã biết
**Kết quả mong đợi:** Tổng doanh thu hiển thị (153,400 VND trong ví dụ) khớp với tổng của tất cả giao dịch đã hoàn thành trong khoảng thời gian đã chọn.

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Dữ liệu giao dịch hiện có trong hệ thống
**Trạng thái kiểm thử:** Chưa thực hiện

## 2. Kiểm tra Bộ lọc Thời gian

### TC-REP-003: Báo cáo Doanh thu Theo Ngày
**Mô tả:** Kiểm tra báo cáo doanh thu theo ngày hiển thị dữ liệu chính xác khi chọn "Theo ngày".
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn bộ lọc "Theo ngày"
4. Chọn một ngày cụ thể có giao dịch đã biết

**Dữ liệu đầu vào:** Ngày có dữ liệu giao dịch đã biết (ví dụ: ngày "5" từ biểu đồ)
**Kết quả mong đợi:**
- Biểu đồ hiển thị các cột doanh thu cho mỗi ngày trong tháng
- Số tiền doanh thu cho ngày đã chọn khớp với tổng của tất cả giao dịch trong ngày đó
- Số lượng hóa đơn phản ánh số lượng hóa đơn cho ngày đã chọn

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Dữ liệu giao dịch trải dài nhiều ngày
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-004: Báo cáo Doanh thu Theo Tháng
**Mô tả:** Kiểm tra báo cáo doanh thu theo tháng hiển thị dữ liệu chính xác khi chọn "Theo tháng".
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn bộ lọc "Theo tháng"
4. Chọn một tháng cụ thể có giao dịch đã biết

**Dữ liệu đầu vào:** Tháng có dữ liệu giao dịch đã biết
**Kết quả mong đợi:**
- Biểu đồ hiển thị các cột doanh thu cho mỗi tháng trong năm
- Số tiền doanh thu cho tháng đã chọn khớp với tổng của tất cả giao dịch trong tháng đó
- Số lượng hóa đơn phản ánh số lượng hóa đơn cho tháng đã chọn

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Dữ liệu giao dịch trải dài nhiều tháng
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-005: Báo cáo Doanh thu Theo Năm
**Mô tả:** Kiểm tra báo cáo doanh thu theo năm hiển thị dữ liệu chính xác khi chọn "Theo năm".
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn bộ lọc "Theo năm"
4. Chọn một năm cụ thể có giao dịch đã biết

**Dữ liệu đầu vào:** Năm có dữ liệu giao dịch đã biết (ví dụ: 2024)
**Kết quả mong đợi:**
- Biểu đồ hiển thị các cột doanh thu cho mỗi năm trong bộ dữ liệu
- Số tiền doanh thu cho năm đã chọn khớp với tổng của tất cả giao dịch trong năm đó
- Số lượng hóa đơn phản ánh số lượng hóa đơn cho năm đã chọn

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Dữ liệu giao dịch trải dài nhiều năm
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-006: Lựa chọn Khoảng Thời gian
**Mô tả:** Kiểm tra khả năng chọn khoảng thời gian cụ thể cho các báo cáo tùy chỉnh.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một tháng/ngày/năm cụ thể từ dropdown
4. Quan sát báo cáo được cập nhật

**Dữ liệu đầu vào:** Lựa chọn tháng (1) và năm (2024) cụ thể
**Kết quả mong đợi:**
- Biểu đồ cập nhật để hiển thị dữ liệu cho khoảng thời gian đã chọn
- Tổng doanh thu cập nhật để phản ánh khoảng thời gian đã chọn
- Số lượng hóa đơn cập nhật để phản ánh khoảng thời gian đã chọn

**Mức độ ưu tiên:** Trung bình
**Điều kiện tiên quyết:** Dữ liệu giao dịch trải dài nhiều khoảng thời gian
**Trạng thái kiểm thử:** Chưa thực hiện

## 3. Kiểm tra Số lượng Hóa đơn và Đơn hàng

### TC-REP-007: Xác minh Số lượng Hóa đơn
**Mô tả:** Kiểm tra số lượng hóa đơn (Hóa đơn) hiển thị chính xác số lượng hóa đơn cho khoảng thời gian đã chọn.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian cụ thể
4. So sánh số lượng hóa đơn hiển thị với số lượng dự kiến

**Dữ liệu đầu vào:** Khoảng thời gian với số lượng hóa đơn đã biết
**Kết quả mong đợi:** Số lượng hóa đơn hiển thị (7 trong ví dụ) khớp với số lượng thực tế của hóa đơn trong khoảng thời gian đã chọn.

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Dữ liệu hóa đơn hiện có trong hệ thống
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-008: Xác minh Số lượng Đơn hàng Trả lại
**Mô tả:** Kiểm tra số lượng đơn hàng trả lại (Đơn hàng trả lại) hiển thị chính xác số lượng đơn hàng trả lại cho khoảng thời gian đã chọn.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian cụ thể
4. So sánh số lượng đơn hàng trả lại hiển thị với số lượng dự kiến

**Dữ liệu đầu vào:** Khoảng thời gian với số lượng đơn hàng trả lại đã biết
**Kết quả mong đợi:** Số lượng đơn hàng trả lại hiển thị (0 trong ví dụ) khớp với số lượng thực tế của đơn hàng trả lại trong khoảng thời gian đã chọn.

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Dữ liệu đơn hàng trả lại hiện có trong hệ thống
**Trạng thái kiểm thử:** Chưa thực hiện

## 4. Kiểm tra Hiển thị Biểu đồ

### TC-REP-009: Hiển thị Biểu đồ Doanh thu Theo Ngày
**Mô tả:** Kiểm tra biểu đồ doanh thu theo ngày hiển thị chính xác dữ liệu doanh thu cho mỗi ngày.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn bộ lọc "Theo ngày"
4. Quan sát hiển thị biểu đồ

**Dữ liệu đầu vào:** Tháng với dữ liệu doanh thu theo ngày đa dạng
**Kết quả mong đợi:**
- Biểu đồ hiển thị các cột cho các ngày có giao dịch
- Chiều cao cột tương ứng với số tiền doanh thu
- Trục X hiển thị các ngày trong tháng (1-31)
- Trục Y hiển thị số tiền doanh thu bằng VND
- Các ngày có doanh thu cao hơn có cột cao hơn

**Mức độ ưu tiên:** Trung bình
**Điều kiện tiên quyết:** Dữ liệu giao dịch với doanh thu theo ngày đa dạng
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-010: Độ chính xác của Dữ liệu Biểu đồ
**Mô tả:** Kiểm tra các điểm dữ liệu trên biểu đồ khớp với dữ liệu giao dịch thực tế trong cơ sở dữ liệu.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian cụ thể
4. So sánh các điểm dữ liệu trên biểu đồ với bản ghi cơ sở dữ liệu

**Dữ liệu đầu vào:** Khoảng thời gian với dữ liệu giao dịch đã biết
**Kết quả mong đợi:** Mỗi điểm dữ liệu trên biểu đồ tương ứng với số tiền doanh thu chính xác từ cơ sở dữ liệu cho khoảng thời gian cụ thể đó.

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Truy cập vào bản ghi giao dịch trong cơ sở dữ liệu
**Trạng thái kiểm thử:** Chưa thực hiện

## 5. Kiểm tra Lọc Dữ liệu và Trường hợp Đặc biệt

### TC-REP-011: Báo cáo Không có Dữ liệu
**Mô tả:** Kiểm tra hệ thống báo cáo xử lý thích hợp các khoảng thời gian không có dữ liệu giao dịch.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian không có giao dịch

**Dữ liệu đầu vào:** Khoảng thời gian không có dữ liệu giao dịch
**Kết quả mong đợi:**
- Biểu đồ hiển thị giá trị trống hoặc bằng không
- Tổng doanh thu hiển thị 0 VND
- Số lượng hóa đơn hiển thị 0
- Số lượng đơn hàng trả lại hiển thị 0
- Không có thông báo lỗi nào được hiển thị

**Mức độ ưu tiên:** Trung bình
**Điều kiện tiên quyết:** Hệ thống có các khoảng thời gian không có dữ liệu giao dịch
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-012: Báo cáo với Doanh thu Cực cao
**Mô tả:** Kiểm tra hệ thống báo cáo xử lý chính xác các khoảng thời gian có doanh thu bất thường cao.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian có giao dịch doanh thu cực cao

**Dữ liệu đầu vào:** Khoảng thời gian có giao dịch giá trị cao
**Kết quả mong đợi:**
- Biểu đồ tỷ lệ thích hợp để hiển thị các giá trị cao
- Tổng doanh thu hiển thị chính xác số tiền lớn
- Không xảy ra lỗi hiển thị hoặc tính toán

**Mức độ ưu tiên:** Trung bình
**Điều kiện tiên quyết:** Dữ liệu kiểm thử với các giao dịch giá trị cao
**Trạng thái kiểm thử:** Chưa thực hiện

## 6. Kiểm tra Chức năng Xuất và In

### TC-REP-013: Xuất Báo cáo Doanh thu
**Mô tả:** Kiểm tra khả năng xuất báo cáo doanh thu sang các định dạng khác nhau.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian cụ thể
4. Nhấp vào nút xuất (biểu tượng tài liệu)
5. Chọn một định dạng xuất

**Dữ liệu đầu vào:** Khoảng thời gian với dữ liệu giao dịch đã biết
**Kết quả mong đợi:**
- Các tùy chọn xuất được hiển thị (PDF, Excel, v.v.)
- Tệp xuất chứa dữ liệu doanh thu chính xác
- Tệp xuất bao gồm hiển thị biểu đồ
- Tệp xuất bao gồm thống kê tóm tắt

**Mức độ ưu tiên:** Trung bình
**Điều kiện tiên quyết:** Dữ liệu giao dịch và chức năng xuất
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-014: In Báo cáo Doanh thu
**Mô tả:** Kiểm tra khả năng in báo cáo doanh thu.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian cụ thể
4. Nhấp vào nút in
5. Xác minh bản xem trước in

**Dữ liệu đầu vào:** Khoảng thời gian với dữ liệu giao dịch đã biết
**Kết quả mong đợi:**
- Bản xem trước in hiển thị chính xác
- Đầu ra in bao gồm tất cả dữ liệu liên quan
- Đầu ra in bao gồm hiển thị biểu đồ
- Đầu ra in bao gồm thống kê tóm tắt

**Mức độ ưu tiên:** Thấp
**Điều kiện tiên quyết:** Dữ liệu giao dịch và chức năng in
**Trạng thái kiểm thử:** Chưa thực hiện

## 7. Kiểm tra Hiệu suất và Bảo mật

### TC-REP-015: Hiệu suất Tạo Báo cáo
**Mô tả:** Kiểm tra hiệu suất của việc tạo báo cáo cho bộ dữ liệu lớn.
**Các bước thực hiện:**
1. Đăng nhập với tài khoản admin/quản lý
2. Điều hướng đến phần báo cáo
3. Chọn một khoảng thời gian có khối lượng giao dịch lớn
4. Đo thời gian cần thiết để tạo báo cáo

**Dữ liệu đầu vào:** Khoảng thời gian với khối lượng lớn dữ liệu giao dịch
**Kết quả mong đợi:**
- Báo cáo được tạo trong giới hạn thời gian chấp nhận được (dưới 5 giây)
- Không xảy ra lỗi hết thời gian
- Tất cả dữ liệu được hiển thị chính xác

**Mức độ ưu tiên:** Trung bình
**Điều kiện tiên quyết:** Khối lượng lớn dữ liệu giao dịch kiểm thử
**Trạng thái kiểm thử:** Chưa thực hiện

### TC-REP-016: Quyền Truy cập Báo cáo
**Mô tả:** Kiểm tra rằng chỉ người dùng được ủy quyền mới có thể truy cập báo cáo doanh thu.
**Các bước thực hiện:**
1. Đăng nhập với các vai trò người dùng khác nhau (admin, quản lý, thu ngân, khách hàng)
2. Cố gắng điều hướng đến phần báo cáo

**Dữ liệu đầu vào:** Thông tin đăng nhập của các người dùng khác nhau
**Kết quả mong đợi:**
- Vai trò admin và quản lý có thể truy cập đầy đủ báo cáo
- Vai trò thu ngân có quyền truy cập hạn chế hoặc không có quyền truy cập vào báo cáo
- Vai trò khách hàng không thể truy cập báo cáo
- Thông báo lỗi quyền thích hợp được hiển thị cho truy cập trái phép

**Mức độ ưu tiên:** Cao
**Điều kiện tiên quyết:** Tài khoản người dùng với các cấp quyền khác nhau
**Trạng thái kiểm thử:** Chưa thực hiện
