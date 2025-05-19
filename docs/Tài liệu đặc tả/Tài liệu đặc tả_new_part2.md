## 3.2. Phân hệ quản lý kho

### 3.2.1. SREQ004 - Quản lý nhập kho

1. **Mô tả nghiệp vụ**

   Chức năng quản lý nhập kho cho phép người dùng quản lý việc nhập thuốc vào kho, bao gồm tạo phiếu nhập, cập nhật và tìm kiếm phiếu nhập.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép tạo phiếu nhập kho với các thông tin: mã phiếu nhập, ngày nhập, nhà cung cấp, người nhập, ghi chú, trạng thái.
   - Hệ thống cho phép thêm chi tiết phiếu nhập với các thông tin: thuốc, số lượng, đơn giá, hạn sử dụng, số lô.
   - Hệ thống cho phép cập nhật thông tin phiếu nhập kho.
   - Hệ thống cho phép hủy phiếu nhập kho.
   - Hệ thống cho phép tìm kiếm phiếu nhập kho theo mã, ngày nhập, nhà cung cấp.
   - Hệ thống hiển thị danh sách phiếu nhập kho với phân trang.
   - Hệ thống tự động cập nhật số lượng tồn kho khi phiếu nhập được xác nhận.

### 3.2.2. SREQ005 - Quản lý tồn kho

1. **Mô tả nghiệp vụ**

   Chức năng quản lý tồn kho cho phép người dùng theo dõi số lượng thuốc trong kho, kiểm tra hạn sử dụng và cảnh báo hết hàng.

2. **Yêu cầu chức năng**
   - Hệ thống hiển thị danh sách thuốc trong kho với thông tin: mã thuốc, tên thuốc, số lượng tồn, đơn vị tính, hạn sử dụng, số lô.
   - Hệ thống cho phép tìm kiếm thuốc trong kho theo tên, mã, danh mục.
   - Hệ thống cảnh báo khi thuốc sắp hết hàng (dưới ngưỡng tối thiểu).
   - Hệ thống cảnh báo khi thuốc sắp hết hạn sử dụng.
   - Hệ thống cho phép xuất báo cáo tồn kho theo thời gian.
   - Hệ thống cho phép kiểm kê kho định kỳ.

### 3.2.3. SREQ006 - Quản lý nhà cung cấp

1. **Mô tả nghiệp vụ**

   Chức năng quản lý nhà cung cấp cho phép người dùng quản lý thông tin nhà cung cấp thuốc trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép thêm mới nhà cung cấp với các thông tin: mã nhà cung cấp, tên nhà cung cấp, địa chỉ, số điện thoại, email, người liên hệ, trạng thái.
   - Hệ thống cho phép cập nhật thông tin nhà cung cấp.
   - Hệ thống cho phép xóa nhà cung cấp (xóa logic).
   - Hệ thống cho phép tìm kiếm nhà cung cấp theo tên, mã.
   - Hệ thống hiển thị danh sách nhà cung cấp với phân trang.

## 3.3. Phân hệ quản lý đơn hàng

### 3.3.1. SREQ007 - Quản lý đơn hàng

1. **Mô tả nghiệp vụ**

   Chức năng quản lý đơn hàng cho phép người dùng quản lý các đơn hàng trong hệ thống, bao gồm tạo đơn hàng, cập nhật trạng thái và tìm kiếm đơn hàng.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép tạo đơn hàng mới với các thông tin: mã đơn hàng, ngày đặt, khách hàng, nhân viên bán hàng, tổng tiền, giảm giá, thanh toán, trạng thái.
   - Hệ thống cho phép thêm chi tiết đơn hàng với các thông tin: thuốc, số lượng, đơn giá, thành tiền.
   - Hệ thống cho phép cập nhật trạng thái đơn hàng (đang xử lý, đã xác nhận, đang giao hàng, đã giao hàng, đã hủy).
   - Hệ thống cho phép hủy đơn hàng.
   - Hệ thống cho phép tìm kiếm đơn hàng theo mã, ngày đặt, khách hàng, trạng thái.
   - Hệ thống hiển thị danh sách đơn hàng với phân trang.
   - Hệ thống tự động cập nhật số lượng tồn kho khi đơn hàng được xác nhận.
   - Hệ thống cho phép in hóa đơn đơn hàng.

### 3.3.2. SREQ008 - Quản lý giỏ hàng

1. **Mô tả nghiệp vụ**

   Chức năng quản lý giỏ hàng cho phép khách hàng thêm thuốc vào giỏ hàng, cập nhật số lượng và thanh toán.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép khách hàng thêm thuốc vào giỏ hàng.
   - Hệ thống cho phép khách hàng cập nhật số lượng thuốc trong giỏ hàng.
   - Hệ thống cho phép khách hàng xóa thuốc khỏi giỏ hàng.
   - Hệ thống hiển thị tổng tiền giỏ hàng.
   - Hệ thống cho phép khách hàng thanh toán giỏ hàng.
   - Hệ thống lưu giỏ hàng của khách hàng khi đăng nhập và đăng xuất.

### 3.3.3. SREQ009 - Quản lý thanh toán

1. **Mô tả nghiệp vụ**

   Chức năng quản lý thanh toán cho phép khách hàng thanh toán đơn hàng bằng nhiều phương thức khác nhau.

2. **Yêu cầu chức năng**
   - Hệ thống hỗ trợ các phương thức thanh toán: tiền mặt, chuyển khoản, thanh toán online.
   - Hệ thống cho phép khách hàng chọn phương thức thanh toán khi đặt hàng.
   - Hệ thống cập nhật trạng thái thanh toán của đơn hàng.
   - Hệ thống gửi thông báo xác nhận thanh toán cho khách hàng.
   - Hệ thống cho phép quản lý xem lịch sử thanh toán của đơn hàng.

## 3.4. Phân hệ quản lý khuyến mãi

### 3.4.1. SREQ010 - Quản lý chương trình khuyến mãi

1. **Mô tả nghiệp vụ**

   Chức năng quản lý chương trình khuyến mãi cho phép người dùng quản lý các chương trình khuyến mãi trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép tạo chương trình khuyến mãi với các thông tin: mã khuyến mãi, tên khuyến mãi, loại khuyến mãi (giảm giá theo %, giảm giá theo số tiền), giá trị khuyến mãi, ngày bắt đầu, ngày kết thúc, điều kiện áp dụng, trạng thái.
   - Hệ thống cho phép cập nhật thông tin chương trình khuyến mãi.
   - Hệ thống cho phép hủy chương trình khuyến mãi.
   - Hệ thống cho phép tìm kiếm chương trình khuyến mãi theo tên, mã, trạng thái.
   - Hệ thống hiển thị danh sách chương trình khuyến mãi với phân trang.
   - Hệ thống tự động áp dụng khuyến mãi cho đơn hàng thỏa mãn điều kiện.

### 3.4.2. SREQ011 - Quản lý mã giảm giá

1. **Mô tả nghiệp vụ**

   Chức năng quản lý mã giảm giá cho phép người dùng quản lý các mã giảm giá trong hệ thống.

2. **Yêu cầu chức năng**
   - Hệ thống cho phép tạo mã giảm giá với các thông tin: mã giảm giá, tên mã giảm giá, loại giảm giá (giảm giá theo %, giảm giá theo số tiền), giá trị giảm giá, ngày bắt đầu, ngày kết thúc, số lượng sử dụng tối đa, trạng thái.
   - Hệ thống cho phép cập nhật thông tin mã giảm giá.
   - Hệ thống cho phép hủy mã giảm giá.
   - Hệ thống cho phép tìm kiếm mã giảm giá theo tên, mã, trạng thái.
   - Hệ thống hiển thị danh sách mã giảm giá với phân trang.
   - Hệ thống cho phép khách hàng nhập mã giảm giá khi thanh toán.
   - Hệ thống kiểm tra tính hợp lệ của mã giảm giá khi khách hàng sử dụng.
