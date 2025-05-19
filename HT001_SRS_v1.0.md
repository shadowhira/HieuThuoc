HT001: Tài liệu đặc tả yêu cầu phần mềm
|||
| :- | - |



**HỆ THỐNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC**

***Tài liệu đặc tả yêu cầu phần mềm***

|**Mã dự án**|**HT001**|
| :-: | :- |
|**Mã tài liệu**|**HT001_SRS_v1.0**|
|**Ngày**|**15/05/2024**|







**Hà Nội, ngày 15 tháng 05 năm 2024**

**NỘI DUNG SỬA ĐỔI**

\*M- Mới S – Sửa X - Xóa

|**Ngày**|**Mục sửa đổi**|**M\*<br>S, X**|**Nội dung sửa đổi**|**Người sửa đổi**|**Lần sửa đổi**|
| :-: | :-: | :-: | :-: | :-: | :-: |
|15/05/2024|Toàn bộ tài liệu|M|Tạo mới tài liệu|Nhóm SQA|1|
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||
|||||||

**TRANG KÝ**


**NGƯỜI LẬP:**		Nhóm SQA		           	15/05/2024

`	`Sinh viên

**NGƯỜI KIỂM TRA:**	Giảng viên		           	15/05/2024

`	`Giảng viên

**NGƯỜI PHÊ DUYỆT:**	Giảng viên		           	15/05/2024

`	`Giảng viên


**MỤC LỤC**

[1.	GIỚI THIỆU	3](#_toc299715318)

[1.1.	Mục đích tài liệu	3](#_toc299715319)

[1.2.	Phạm vi hệ thống	3](#_toc299715320)

[1.3.	Định nghĩa thuật ngữ viết tắt	3](#_toc299715321)

[1.4.	Tài liệu tham khảo	3](#_toc299715322)

[1.5.	Mô tả tài liệu	3](#_toc299715323)

[2.	TỔNG QUAN HỆ THỐNG	3](#_toc299715324)

[2.1.	Phát biểu bài toán	3](#_toc299715325)

[2.2.	Mục tiêu hệ thống	3](#_toc299715326)

[2.3.	Người sử dụng hệ thống	3](#_toc299715327)

[3.	ĐẶC TẢ YÊU CẦU CHỨC NĂNG	3](#_toc299715328)

[3.1.	Phân hệ Quản lý Người Dùng	3](#_toc299715329)

[3.2.	Phân hệ Quản lý Sản Phẩm (Thuốc)	3](#_toc299715329)

[3.3.	Phân hệ Đặt Hàng và Thanh Toán	3](#_toc299715329)

[3.4.	Phân hệ Quản lý Đơn Hàng	3](#_toc299715329)

[3.5.	Phân hệ Quản lý Kho và Báo Cáo	3](#_toc299715329)

[3.6.	Phân hệ Báo cáo và Thống kê	3](#_toc299715330)

[3.7.	Phân hệ Hỗ Trợ và Tư Vấn Trực Tuyến	3](#_toc299715331)

[3.8.	Phân hệ Quản lý Tương Tác Thuốc	3](#_toc299715332)

[4.	CÁC YÊU CẦU PHI CHỨC NĂNG	3](#_toc299715330)

[4.1.	Yêu cầu bảo mật	3](#_toc299715331)

[4.2.	Yêu cầu sao lưu	3](#_toc299715332)

[4.3.	Yêu cầu về tính sử dụng	3](#_toc299715333)

[4.4.	Yêu cầu về tính ổn định	3](#_toc299715334)

[4.5.	Yêu cầu về hiệu năng	3](#_toc299715335)

[4.6.	Yêu cầu về tính hỗ trợ	3](#_toc299715336)

[4.7.	Các ràng buộc thiết kế	3](#_toc299715337)

[4.8.	Yêu cầu về Giao tiếp	3](#_toc299715338)

[4.9.	Các yêu cầu tài liệu người dùng và hỗ trợ trực tuyến	3](#_toc299715339)

[4.10.	Các thành phần mua ngoài	3](#_toc299715340)

[4.11.	Các yêu cầu pháp lý, bản quyền và những ghi chú khác	3](#_toc299715341)

[4.12.	Các tiêu chuẩn áp dụng	3](#_toc299715342)

[4.13.	Các yêu cầu khác	3](#_toc299715343)

[5.	ĐẶC TẢ YÊU CẦU CHO TỪNG THÀNH PHẦN HỆ THỐNG	3](#_toc299715344)

[5.1.	Database Server	3](#_toc299715345)

[5.2.	Application Server	3](#_toc299715346)

[5.3.	Web Server	3](#_toc299715347)

[5.4.	Frontend Client	3](#_toc299715348)

[5.5.	Payment Gateway Integration	3](#_toc299715349)

[5.6.	Email Service	3](#_toc299715350)

[5.7.	File Storage Service	3](#_toc299715351)

[5.8.	Reporting and Analytics Service	3](#_toc299715352)




1. # **GIỚI THIỆU**
   1. ## ***Mục đích tài liệu***

- Tài liệu này được xây dựng nhằm mục đích phân tích và đặc tả các yêu cầu cho dự án "Xây dựng Web bán và quản lý hiệu thuốc", đồng thời là cơ sở để đàm phán với khách hàng về phạm vi của dự án.
- Tài liệu này được dùng làm đầu vào cho các quá trình thiết kế, xây dựng usecase, lập trình, và kiểm thử hệ thống.
- Tài liệu cũng là cơ sở để thực hiện việc đảm bảo chất lượng phần mềm trong quá trình phát triển.

   2. ## ***Phạm vi hệ thống***

Tài liệu đặc tả các chức năng cần thiết của hệ thống web bán và quản lý hiệu thuốc. Hệ thống gồm 2 phân hệ chính:

- Phân hệ Frontend: Giao diện người dùng cho khách hàng và nhân viên
- Phân hệ Backend: Xử lý nghiệp vụ và quản lý dữ liệu

Hệ thống cung cấp các chức năng quản lý người dùng, quản lý sản phẩm (thuốc), đặt hàng và thanh toán, quản lý đơn hàng, quản lý kho và báo cáo, hỗ trợ và tư vấn trực tuyến, và quản lý tương tác thuốc.

   3. ## ***Định nghĩa thuật ngữ viết tắt***

|**STT**|**Nội dung**|**Ý nghĩa**|
| - | - | - |
|1|API|Application Programming Interface - Giao diện lập trình ứng dụng|
|2|CSDL|Cơ sở dữ liệu|
|3|UI|User Interface - Giao diện người dùng|
|4|UC|Use case - Trường hợp sử dụng|
|5|SRS|Software Requirements Specification - Đặc tả yêu cầu phần mềm|
|6|Frontend|Thành phần của trang web tương tác với người dùng|
|7|Backend|Thành phần của trang web xử lý dữ liệu|
|8|RESTful API|Representational State Transfer API - Kiểu thiết kế API sử dụng giao thức HTTP|
|9|COD|Cash On Delivery - Thanh toán khi nhận hàng|

   4. ## ***Tài liệu tham khảo***

|**STT**|**Tên tài liệu**|
| - | - |
|1|Kien - Quang - Ky _ DATN _ Final.docx.md|
|2|Template SRS.md|

   5. ## ***Mô tả tài liệu***

Nội dung tài liệu này bao gồm các phần:

1. Giới thiệu
2. Tổng quan hệ thống
3. Đặc tả yêu cầu chức năng
4. Các yêu cầu phi chức năng

1. # **TỔNG QUAN HỆ THỐNG**
   1. ## ***Phát biểu bài toán***

Hiện nay, các hiệu thuốc đang ngày càng cần thiết phải hiện đại hóa các phương thức quản lý và bán hàng để nâng cao hiệu quả kinh doanh cũng như đáp ứng nhu cầu của khách hàng. Đối với nhiều hiệu thuốc, việc quản lý kho hàng, đơn hàng, và thông tin khách hàng thường gặp nhiều khó khăn. Một số thách thức phổ biến bao gồm:

* Khó khăn trong việc quản lý số lượng lớn các sản phẩm dược phẩm với nhiều loại thuốc, hạn sử dụng, và các yêu cầu bảo quản khác nhau.
* Tốn nhiều thời gian cho việc xử lý đơn hàng và quản lý tồn kho.
* Hạn chế trong việc tích hợp giữa bán hàng truyền thống và bán hàng trực tuyến, dẫn đến khó khăn trong theo dõi và quản lý.

Trong bối cảnh này, việc xây dựng một hệ thống quản lý hiệu thuốc trên nền web sẽ giúp cải thiện đáng kể hoạt động của hiệu thuốc. Hệ thống sẽ không chỉ hỗ trợ quản lý kho và đơn hàng mà còn tích hợp các tính năng bán hàng trực tuyến, mang đến cho khách hàng sự tiện lợi trong việc tra cứu và mua sắm thuốc từ xa.

   2. ## ***Mục tiêu hệ thống***

Đồ án này hướng đến việc xây dựng một hệ thống web bán và quản lý hiệu thuốc với những mục tiêu cụ thể sau:

* **Tạo nền tảng bán thuốc trực tuyến dễ sử dụng**: Xây dựng một website thân thiện với người dùng, tích hợp tính năng tìm kiếm, tra cứu và đặt mua thuốc một cách đơn giản và hiệu quả. Giao diện được thiết kế thân thiện và dễ dàng điều hướng để mọi người dùng đều có thể sử dụng dễ dàng.

* **Quản lý kho và bán hàng thông minh**: Cung cấp các tính năng quản lý kho hàng, cập nhật số lượng thuốc trong kho, theo dõi các lô thuốc hết hạn, và kiểm soát tình trạng tồn kho hiệu quả, giảm thiểu tình trạng hết hàng và nâng cao hiệu suất kinh doanh.

* **Tích hợp tư vấn và gợi ý cá nhân hóa**: Hệ thống sẽ bao gồm tính năng tư vấn sức khỏe và gợi ý sản phẩm cá nhân hóa dựa trên lịch sử mua hàng, độ tuổi, và các yếu tố sức khỏe khác của người dùng, tạo trải nghiệm tốt hơn cho khách hàng.

* **Quản lý tương tác thuốc và cảnh báo an toàn**: Xây dựng tính năng kiểm tra và cảnh báo các tương tác thuốc nguy hiểm có thể xảy ra khi người dùng mua nhiều loại thuốc cùng lúc. Hệ thống sẽ cung cấp thông tin về các tương tác thuốc phổ biến và cảnh báo người dùng nếu có nguy cơ gây hại từ việc kết hợp thuốc.

* **Tuân thủ quy định pháp lý:** Đảm bảo hệ thống tuân thủ các quy định pháp lý về kinh doanh dược phẩm trực tuyến tại Việt Nam, bao gồm quy trình kiểm duyệt đơn thuốc đối với các loại thuốc kê toa, giúp người dùng mua thuốc an toàn và đúng quy định.

   3. ## ***Người sử dụng hệ thống***

|**Người sử dụng**|**Mô tả**|
| - | - |
|Khách hàng|Người dùng có thể đăng ký tài khoản, tìm kiếm và mua thuốc, theo dõi đơn hàng, và nhận tư vấn về thuốc.|
|Nhân viên|Người dùng có quyền quản lý kho, tư vấn khách hàng, xử lý đơn hàng, và hỗ trợ các hoạt động bán hàng.|
|Admin|Người dùng có toàn quyền quản lý hệ thống, bao gồm quản lý người dùng, sản phẩm, đơn hàng, báo cáo, và cấu hình hệ thống.|

1. # **ĐẶC TẢ YÊU CẦU CHỨC NĂNG**

Dựa trên phân tích yêu cầu và thiết kế hệ thống, các chức năng của hệ thống web bán và quản lý hiệu thuốc được chia thành các phân hệ chính như sau:

   1. ## ***Phân hệ Quản lý Thuốc***

### **SREQ001 – Quản lý thông tin thuốc**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý thông tin thuốc cho phép Admin và nhân viên thêm mới, cập nhật, xóa và tìm kiếm thông tin thuốc trong hệ thống.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép thêm mới thông tin thuốc với các thông tin: mã thuốc, tên thuốc, thành phần, công dụng, liều dùng, chống chỉ định, giá bán, số lượng, hạn sử dụng, nhà sản xuất, loại thuốc, danh mục thuốc.
   - Hệ thống cho phép cập nhật thông tin thuốc đã có trong cơ sở dữ liệu.
   - Hệ thống cho phép xóa thông tin thuốc (xóa logic, không xóa vật lý).
   - Hệ thống cho phép tìm kiếm thuốc theo nhiều tiêu chí: mã thuốc, tên thuốc, loại thuốc, danh mục thuốc.
   - Hệ thống hiển thị danh sách thuốc với các thông tin cơ bản và cho phép xem chi tiết từng thuốc.

### **SREQ002 – Quản lý loại thuốc**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý loại thuốc cho phép Admin và nhân viên thêm mới, cập nhật, xóa và tìm kiếm thông tin loại thuốc trong hệ thống.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép thêm mới loại thuốc với các thông tin: mã loại thuốc, tên loại thuốc, mô tả.
   - Hệ thống cho phép cập nhật thông tin loại thuốc đã có trong cơ sở dữ liệu.
   - Hệ thống cho phép xóa thông tin loại thuốc (chỉ khi không có thuốc nào thuộc loại đó).
   - Hệ thống cho phép tìm kiếm loại thuốc theo mã hoặc tên.
   - Hệ thống hiển thị danh sách loại thuốc với các thông tin cơ bản.

### **SREQ003 – Quản lý danh mục thuốc**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý danh mục thuốc cho phép Admin và nhân viên thêm mới, cập nhật, xóa và tìm kiếm thông tin danh mục thuốc trong hệ thống.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép thêm mới danh mục thuốc với các thông tin: mã danh mục, tên danh mục, mô tả.
   - Hệ thống cho phép cập nhật thông tin danh mục thuốc đã có trong cơ sở dữ liệu.
   - Hệ thống cho phép xóa thông tin danh mục thuốc (chỉ khi không có thuốc nào thuộc danh mục đó).
   - Hệ thống cho phép tìm kiếm danh mục thuốc theo mã hoặc tên.
   - Hệ thống hiển thị danh sách danh mục thuốc với các thông tin cơ bản.

   2. ## ***Phân hệ Quản lý Nhập kho và Tồn kho***

### **SREQ004 – Tạo phiếu nhập kho**

1. **Mô tả nghiệp vụ**

   Chức năng tạo phiếu nhập kho cho phép nhân viên tạo phiếu nhập thuốc từ nhà cung cấp vào kho.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép tạo phiếu nhập kho với các thông tin: mã phiếu nhập, ngày nhập, nhà cung cấp, người nhập, ghi chú.
   - Hệ thống cho phép thêm nhiều thuốc vào một phiếu nhập với các thông tin: mã thuốc, tên thuốc, số lượng, đơn giá, hạn sử dụng, thành tiền.
   - Hệ thống tự động tính tổng tiền của phiếu nhập.
   - Hệ thống tự động cập nhật số lượng tồn kho của thuốc sau khi phiếu nhập được xác nhận.
   - Hệ thống cho phép in phiếu nhập kho.

### **SREQ005 – Quản lý tồn kho**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý tồn kho cho phép nhân viên theo dõi số lượng thuốc trong kho, kiểm tra hạn sử dụng và xuất báo cáo tồn kho.

2. **Yêu cầu chức năng**

   - Hệ thống hiển thị danh sách thuốc trong kho với các thông tin: mã thuốc, tên thuốc, số lượng tồn, hạn sử dụng.
   - Hệ thống cho phép lọc danh sách thuốc theo các tiêu chí: sắp hết hàng, sắp hết hạn, hết hạn.
   - Hệ thống cảnh báo khi thuốc sắp hết hàng (số lượng dưới ngưỡng tối thiểu) hoặc sắp hết hạn (trong vòng 30 ngày).
   - Hệ thống cho phép xuất báo cáo tồn kho theo thời gian.
   - Hệ thống cho phép kiểm kê kho (đối chiếu số lượng thực tế với số lượng trong hệ thống).

### **SREQ006 – Quản lý nhà cung cấp**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý nhà cung cấp cho phép Admin và nhân viên thêm mới, cập nhật, xóa và tìm kiếm thông tin nhà cung cấp trong hệ thống.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép thêm mới nhà cung cấp với các thông tin: mã nhà cung cấp, tên nhà cung cấp, địa chỉ, số điện thoại, email, người liên hệ.
   - Hệ thống cho phép cập nhật thông tin nhà cung cấp đã có trong cơ sở dữ liệu.
   - Hệ thống cho phép xóa thông tin nhà cung cấp (xóa logic, không xóa vật lý).
   - Hệ thống cho phép tìm kiếm nhà cung cấp theo mã hoặc tên.
   - Hệ thống hiển thị danh sách nhà cung cấp với các thông tin cơ bản.

   3. ## ***Phân hệ Quản lý Đơn hàng và Giỏ hàng***

### **SREQ007 – Tạo đơn hàng**

1. **Mô tả nghiệp vụ**

   Chức năng tạo đơn hàng cho phép nhân viên tạo đơn hàng mới cho khách hàng mua tại quầy hoặc khách hàng tự tạo đơn hàng trực tuyến.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép tạo đơn hàng với các thông tin: mã đơn hàng, ngày đặt, khách hàng, địa chỉ giao hàng, phương thức thanh toán, trạng thái đơn hàng.
   - Hệ thống cho phép thêm nhiều thuốc vào một đơn hàng với các thông tin: mã thuốc, tên thuốc, số lượng, đơn giá, thành tiền.
   - Hệ thống tự động tính tổng tiền của đơn hàng.
   - Hệ thống tự động cập nhật số lượng tồn kho của thuốc sau khi đơn hàng được xác nhận.
   - Hệ thống cho phép in hóa đơn.

### **SREQ008 – Quản lý chi tiết đơn hàng**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý chi tiết đơn hàng cho phép nhân viên và khách hàng xem chi tiết đơn hàng, cập nhật trạng thái đơn hàng.

2. **Yêu cầu chức năng**

   - Hệ thống hiển thị chi tiết đơn hàng với các thông tin: mã đơn hàng, ngày đặt, khách hàng, địa chỉ giao hàng, phương thức thanh toán, trạng thái đơn hàng, danh sách thuốc.
   - Hệ thống cho phép cập nhật trạng thái đơn hàng: đang xử lý, đã xác nhận, đang giao hàng, đã giao hàng, đã hủy.
   - Hệ thống cho phép gửi thông báo cho khách hàng khi trạng thái đơn hàng thay đổi.
   - Hệ thống cho phép khách hàng hủy đơn hàng (chỉ khi đơn hàng chưa được xác nhận).
   - Hệ thống cho phép nhân viên ghi chú thêm thông tin về đơn hàng.

### **SREQ009 – Quản lý giỏ hàng**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý giỏ hàng cho phép khách hàng thêm thuốc vào giỏ hàng, cập nhật số lượng, xóa thuốc khỏi giỏ hàng và tiến hành thanh toán.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép khách hàng thêm thuốc vào giỏ hàng với số lượng mong muốn.
   - Hệ thống cho phép khách hàng cập nhật số lượng thuốc trong giỏ hàng.
   - Hệ thống cho phép khách hàng xóa thuốc khỏi giỏ hàng.
   - Hệ thống tự động tính tổng tiền của giỏ hàng.
   - Hệ thống cho phép khách hàng tiến hành thanh toán giỏ hàng để tạo đơn hàng mới.
   - Hệ thống lưu giỏ hàng của khách hàng ngay cả khi khách hàng đăng xuất và đăng nhập lại.

### **SREQ010 – Thanh toán**

1. **Mô tả nghiệp vụ**

   Chức năng thanh toán cho phép khách hàng thanh toán đơn hàng bằng nhiều phương thức khác nhau.

2. **Yêu cầu chức năng**

   - Hệ thống hỗ trợ các phương thức thanh toán: tiền mặt, chuyển khoản ngân hàng, thanh toán qua VNPay.
   - Hệ thống hiển thị tổng tiền cần thanh toán và cho phép khách hàng chọn phương thức thanh toán.
   - Đối với thanh toán qua VNPay, hệ thống chuyển hướng khách hàng đến cổng thanh toán VNPay và xử lý kết quả thanh toán.
   - Hệ thống cập nhật trạng thái đơn hàng sau khi thanh toán thành công.
   - Hệ thống gửi email xác nhận thanh toán cho khách hàng.

   4. ## ***Phân hệ Quản lý Người dùng và Phân quyền***

### **SREQ011 – Đăng ký tài khoản**

1. **Mô tả nghiệp vụ**

   Chức năng đăng ký tài khoản cho phép khách hàng tạo tài khoản mới để sử dụng hệ thống.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép khách hàng đăng ký tài khoản với các thông tin: họ tên, email, số điện thoại, mật khẩu.
   - Hệ thống kiểm tra tính hợp lệ của thông tin đăng ký: email không trùng lặp, mật khẩu đủ mạnh.
   - Hệ thống gửi email xác nhận đăng ký cho khách hàng.
   - Hệ thống yêu cầu khách hàng xác nhận email trước khi có thể đăng nhập.
   - Hệ thống tự động gán vai trò "Khách hàng" cho tài khoản mới đăng ký.

### **SREQ012 – Đăng nhập**

1. **Mô tả nghiệp vụ**

   Chức năng đăng nhập cho phép người dùng đăng nhập vào hệ thống bằng tài khoản đã đăng ký.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép người dùng đăng nhập bằng email và mật khẩu.
   - Hệ thống kiểm tra tính hợp lệ của thông tin đăng nhập.
   - Hệ thống hiển thị thông báo lỗi nếu thông tin đăng nhập không chính xác.
   - Hệ thống chuyển hướng người dùng đến trang phù hợp với vai trò sau khi đăng nhập thành công.
   - Hệ thống lưu phiên đăng nhập của người dùng để không phải đăng nhập lại trong một khoảng thời gian nhất định.

### **SREQ013 – Quản lý thông tin người dùng**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý thông tin người dùng cho phép người dùng xem và cập nhật thông tin cá nhân, và cho phép Admin quản lý thông tin của tất cả người dùng.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép người dùng xem thông tin cá nhân: họ tên, email, số điện thoại, địa chỉ.
   - Hệ thống cho phép người dùng cập nhật thông tin cá nhân.
   - Hệ thống cho phép người dùng đổi mật khẩu.
   - Hệ thống cho phép Admin xem danh sách tất cả người dùng.
   - Hệ thống cho phép Admin thêm mới, cập nhật, và vô hiệu hóa tài khoản người dùng.

### **SREQ014 – Phân quyền**

1. **Mô tả nghiệp vụ**

   Chức năng phân quyền cho phép Admin quản lý vai trò và quyền hạn của người dùng trong hệ thống.

2. **Yêu cầu chức năng**

   - Hệ thống hỗ trợ các vai trò: Admin, Nhân viên, Khách hàng.
   - Hệ thống cho phép Admin gán vai trò cho người dùng.
   - Hệ thống cho phép Admin tạo và quản lý nhóm quyền.
   - Hệ thống cho phép Admin gán quyền cụ thể cho từng vai trò.
   - Hệ thống kiểm tra quyền của người dùng trước khi cho phép truy cập vào các chức năng của hệ thống.

   5. ## ***Phân hệ Quản lý Khuyến mãi và Đánh giá***

### **SREQ015 – Quản lý khuyến mãi**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý khuyến mãi cho phép Admin và nhân viên tạo và quản lý các chương trình khuyến mãi.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép tạo chương trình khuyến mãi với các thông tin: mã khuyến mãi, tên chương trình, mô tả, loại khuyến mãi (giảm giá theo %, giảm giá theo số tiền), giá trị khuyến mãi, ngày bắt đầu, ngày kết thúc, điều kiện áp dụng.
   - Hệ thống cho phép cập nhật thông tin chương trình khuyến mãi.
   - Hệ thống cho phép vô hiệu hóa chương trình khuyến mãi.
   - Hệ thống tự động áp dụng khuyến mãi cho đơn hàng thỏa mãn điều kiện.
   - Hệ thống hiển thị thông tin khuyến mãi cho khách hàng khi mua hàng.

### **SREQ016 – Đánh giá thuốc**

1. **Mô tả nghiệp vụ**

   Chức năng đánh giá thuốc cho phép khách hàng đánh giá và nhận xét về thuốc đã mua.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép khách hàng đánh giá thuốc với số sao (1-5) và nhận xét.
   - Hệ thống chỉ cho phép khách hàng đánh giá thuốc đã mua.
   - Hệ thống hiển thị đánh giá trung bình và số lượng đánh giá cho mỗi thuốc.
   - Hệ thống hiển thị danh sách nhận xét của khách hàng cho mỗi thuốc.
   - Hệ thống cho phép Admin quản lý (duyệt, ẩn) các đánh giá không phù hợp.

### **SREQ017 – Quản lý tương tác thuốc**

1. **Mô tả nghiệp vụ**

   Chức năng quản lý tương tác thuốc cho phép Admin và nhân viên quản lý thông tin về tương tác giữa các loại thuốc.

2. **Yêu cầu chức năng**

   - Hệ thống cho phép thêm thông tin tương tác giữa hai loại thuốc với các thông tin: thuốc 1, thuốc 2, mức độ tương tác (nhẹ, trung bình, nghiêm trọng), mô tả tương tác, khuyến nghị.
   - Hệ thống cho phép cập nhật thông tin tương tác thuốc.
   - Hệ thống cho phép xóa thông tin tương tác thuốc.
   - Hệ thống tự động kiểm tra và cảnh báo tương tác thuốc khi khách hàng thêm nhiều loại thuốc vào giỏ hàng.
   - Hệ thống hiển thị thông tin chi tiết về tương tác thuốc và khuyến nghị cho khách hàng.

   6. ## ***Phân hệ Báo cáo và Thống kê***

### **SREQ018 – Báo cáo doanh thu (UR018)**

1. **Mô tả nghiệp vụ**

   Chức năng báo cáo doanh thu cho phép người dùng xem và phân tích doanh thu của hiệu thuốc theo các khoảng thời gian khác nhau (ngày, tháng, năm). Người dùng có thể xem doanh thu dưới dạng biểu đồ trực quan hoặc bảng dữ liệu chi tiết, đồng thời có thể xuất báo cáo ra các định dạng phổ biến để lưu trữ hoặc chia sẻ.

2. **Yêu cầu chức năng**

   - **Dữ liệu đầu vào**:
     - Khoảng thời gian báo cáo: ngày cụ thể, tháng/năm, hoặc năm
     - Loại báo cáo: theo giờ (cho báo cáo ngày), theo ngày (cho báo cáo tháng), theo tháng (cho báo cáo năm)
     - Định dạng xuất báo cáo: PDF, Excel

   - **Yêu cầu xử lý**:
     - Hệ thống tính toán tổng doanh thu dựa trên các đơn hàng đã thanh toán và không bị trả lại trong khoảng thời gian được chọn
     - Hệ thống tính toán số lượng đơn hàng thành công và số lượng đơn hàng bị trả lại
     - Hệ thống hiển thị dữ liệu doanh thu theo đơn vị thời gian phù hợp:
       - Theo giờ trong ngày (cho báo cáo ngày)
       - Theo ngày trong tháng (cho báo cáo tháng)
       - Theo tháng trong năm (cho báo cáo năm)
     - Hệ thống tạo biểu đồ trực quan (cột, đường) để thể hiện xu hướng doanh thu
     - Hệ thống cho phép xuất báo cáo ra file PDF hoặc Excel với đầy đủ thông tin và định dạng phù hợp

   - **Các yêu cầu đặc biệt**:
     - Chỉ người dùng có quyền Admin hoặc Manager mới có thể truy cập chức năng này
     - Thời gian tạo báo cáo không quá 5 giây cho báo cáo đơn giản, không quá 10 giây cho báo cáo phức tạp
     - Hệ thống cho phép so sánh doanh thu giữa các khoảng thời gian (ví dụ: so sánh doanh thu tháng này với tháng trước)

### **SREQ019 – Báo cáo tồn kho (UR019)**

1. **Mô tả nghiệp vụ**

   Chức năng báo cáo tồn kho cho phép người dùng xem thông tin về số lượng thuốc còn trong kho, bao gồm các thuốc sắp hết hàng hoặc sắp hết hạn sử dụng. Báo cáo này giúp quản lý hiệu quả việc nhập hàng và đảm bảo luôn có đủ thuốc để bán.

2. **Yêu cầu chức năng**

   - **Dữ liệu đầu vào**:
     - Ngày báo cáo (mặc định là ngày hiện tại)
     - Bộ lọc: tên thuốc, loại thuốc, nhà sản xuất
     - Ngưỡng cảnh báo: số lượng tối thiểu để cảnh báo sắp hết hàng
     - Thời gian cảnh báo hết hạn: số ngày trước khi thuốc hết hạn để cảnh báo
     - Định dạng xuất báo cáo: PDF, Excel

   - **Yêu cầu xử lý**:
     - Hệ thống truy xuất thông tin tồn kho của tất cả các thuốc tại thời điểm báo cáo
     - Hệ thống đánh dấu các thuốc có số lượng tồn dưới ngưỡng cảnh báo
     - Hệ thống đánh dấu các thuốc sắp hết hạn sử dụng (trong vòng thời gian cảnh báo)
     - Hệ thống tính toán tổng giá trị hàng tồn kho
     - Hệ thống cho phép lọc danh sách theo tên thuốc, loại thuốc, nhà sản xuất
     - Hệ thống cho phép xuất báo cáo ra file PDF hoặc Excel với đầy đủ thông tin và định dạng phù hợp

   - **Các yêu cầu đặc biệt**:
     - Người dùng có quyền Admin, Manager hoặc Pharmacist mới có thể truy cập chức năng này
     - Báo cáo phải hiển thị rõ ràng các cảnh báo về thuốc sắp hết hàng hoặc sắp hết hạn
     - Hệ thống cho phép sắp xếp danh sách theo nhiều tiêu chí khác nhau (tên thuốc, số lượng tồn, ngày hết hạn)

### **SREQ020 – Báo cáo thuốc bán chạy (UR020)**

1. **Mô tả nghiệp vụ**

   Chức năng báo cáo thuốc bán chạy cho phép người dùng xem thông tin về các thuốc được bán nhiều nhất trong một khoảng thời gian. Báo cáo này giúp phân tích xu hướng tiêu dùng và hỗ trợ việc lập kế hoạch nhập hàng, khuyến mãi.

2. **Yêu cầu chức năng**

   - **Dữ liệu đầu vào**:
     - Khoảng thời gian báo cáo: ngày, tuần, tháng, năm
     - Số lượng thuốc hiển thị (top 5, top 10, top 20...)
     - Bộ lọc: loại thuốc, nhà sản xuất
     - Định dạng xuất báo cáo: PDF, Excel

   - **Yêu cầu xử lý**:
     - Hệ thống tính toán số lượng bán ra của từng loại thuốc trong khoảng thời gian được chọn
     - Hệ thống sắp xếp danh sách thuốc theo thứ tự giảm dần về số lượng bán ra
     - Hệ thống hiển thị danh sách các thuốc bán chạy nhất theo số lượng đã chọn
     - Hệ thống tạo biểu đồ trực quan (cột, bánh) để thể hiện tỷ lệ bán ra của các thuốc
     - Hệ thống cho phép lọc danh sách theo loại thuốc, nhà sản xuất
     - Hệ thống cho phép xuất báo cáo ra file PDF hoặc Excel với đầy đủ thông tin và định dạng phù hợp

   - **Các yêu cầu đặc biệt**:
     - Người dùng có quyền Admin, Manager hoặc Pharmacist mới có thể truy cập chức năng này
     - Báo cáo phải hiển thị thông tin chi tiết về từng thuốc (tên, mã, loại, nhà sản xuất, số lượng bán, doanh thu)
     - Hệ thống cho phép so sánh dữ liệu giữa các khoảng thời gian (ví dụ: so sánh thuốc bán chạy tháng này với tháng trước)

### **SREQ021 – Xuất báo cáo (UR021)**

1. **Mô tả nghiệp vụ**

   Chức năng xuất báo cáo cho phép người dùng xuất các báo cáo đã tạo ra các định dạng phổ biến như PDF, Excel để lưu trữ, in ấn hoặc chia sẻ. Chức năng này áp dụng cho tất cả các loại báo cáo trong hệ thống.

2. **Yêu cầu chức năng**

   - **Dữ liệu đầu vào**:
     - Loại báo cáo cần xuất (doanh thu, tồn kho, thuốc bán chạy)
     - Định dạng xuất báo cáo: PDF, Excel
     - Tùy chọn bao gồm/loại trừ biểu đồ trong báo cáo xuất
     - Tùy chọn bao gồm/loại trừ dữ liệu chi tiết trong báo cáo xuất

   - **Yêu cầu xử lý**:
     - Hệ thống tạo file báo cáo theo định dạng đã chọn với đầy đủ thông tin và định dạng phù hợp
     - Hệ thống đảm bảo file xuất ra có tiêu đề, ngày tạo báo cáo, và thông tin người tạo
     - Hệ thống đảm bảo file Excel có các cột và định dạng dữ liệu phù hợp
     - Hệ thống đảm bảo file PDF có bố cục rõ ràng, dễ đọc
     - Hệ thống cho phép tải xuống file báo cáo sau khi tạo xong

   - **Các yêu cầu đặc biệt**:
     - Người dùng có quyền truy cập báo cáo nào thì mới có thể xuất báo cáo đó
     - File xuất ra phải có tiêu đề rõ ràng, bao gồm loại báo cáo và khoảng thời gian
     - File Excel phải có định dạng cột và ô phù hợp, với các công thức tính toán tổng, trung bình nếu cần
     - File PDF phải có header, footer với thông tin công ty, ngày tạo báo cáo

1. # **CÁC YÊU CẦU PHI CHỨC NĂNG**
   1. ## ***Yêu cầu bảo mật***

- **Xác thực và phân quyền**: Hệ thống phải thực hiện xác thực người dùng và phân quyền truy cập dựa trên vai trò. Mỗi người dùng chỉ được phép truy cập vào các chức năng phù hợp với vai trò của mình.

- **Bảo mật mật khẩu**: Mật khẩu người dùng phải được mã hóa bằng thuật toán bcrypt hoặc tương đương trước khi lưu vào cơ sở dữ liệu. Hệ thống yêu cầu mật khẩu có độ phức tạp tối thiểu (ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt).

- **Bảo mật giao dịch**: Các giao dịch thanh toán phải được mã hóa bằng HTTPS. Đối với thanh toán qua VNPay, hệ thống sử dụng HMAC SHA-512 để ký dữ liệu, đảm bảo tính toàn vẹn của dữ liệu giao dịch.

- **Bảo vệ dữ liệu cá nhân**: Thông tin cá nhân của khách hàng phải được bảo vệ theo quy định về bảo vệ dữ liệu cá nhân. Hệ thống chỉ thu thập những thông tin cần thiết và có cơ chế xóa dữ liệu khi được yêu cầu.

- **Phòng chống tấn công**: Hệ thống phải có cơ chế phòng chống các loại tấn công phổ biến như SQL Injection, Cross-Site Scripting (XSS), Cross-Site Request Forgery (CSRF).

   2. ## ***Yêu cầu sao lưu***

- **Sao lưu tự động**: Hệ thống phải thực hiện sao lưu dữ liệu tự động hàng ngày vào thời điểm ít người sử dụng (ví dụ: 2h sáng).

- **Sao lưu theo yêu cầu**: Hệ thống cho phép Admin thực hiện sao lưu dữ liệu theo yêu cầu trước khi thực hiện các thay đổi lớn.

- **Phục hồi dữ liệu**: Hệ thống phải có khả năng phục hồi dữ liệu từ bản sao lưu trong trường hợp xảy ra sự cố.

- **Lưu trữ bản sao lưu**: Các bản sao lưu phải được lưu trữ ở nhiều vị trí khác nhau (ví dụ: máy chủ cục bộ và dịch vụ đám mây) để đảm bảo an toàn dữ liệu.

- **Thời gian lưu trữ**: Hệ thống lưu trữ các bản sao lưu trong thời gian tối thiểu 1 năm.

   3. ## ***Yêu cầu về tính sử dụng***

- **Giao diện thân thiện**: Giao diện người dùng phải trực quan, dễ sử dụng, và phù hợp với cả người dùng mới và người dùng có kinh nghiệm.

- **Tính nhất quán**: Giao diện người dùng phải nhất quán về màu sắc, bố cục, và cách thức tương tác trên toàn bộ hệ thống.

- **Hỗ trợ đa ngôn ngữ**: Hệ thống hỗ trợ ít nhất hai ngôn ngữ: Tiếng Việt và Tiếng Anh.

- **Tương thích đa thiết bị**: Giao diện người dùng phải tương thích với nhiều loại thiết bị và kích thước màn hình (responsive design).

- **Thời gian đào tạo**: Người dùng mới có thể sử dụng được các chức năng cơ bản của hệ thống sau không quá 1 giờ đào tạo.

- **Hỗ trợ người dùng**: Hệ thống cung cấp hướng dẫn sử dụng, tooltip, và thông báo lỗi rõ ràng để hỗ trợ người dùng.

   4. ## ***Yêu cầu về tính ổn định***

- **Thời gian hoạt động**: Hệ thống phải đảm bảo thời gian hoạt động (uptime) tối thiểu 99.5% trong năm.

- **Khả năng phục hồi**: Trong trường hợp xảy ra sự cố, hệ thống phải có khả năng phục hồi trong vòng 4 giờ.

- **Xử lý lỗi**: Hệ thống phải có cơ chế xử lý lỗi graceful, không làm crash toàn bộ hệ thống khi một phần gặp sự cố.

- **Giám sát hệ thống**: Hệ thống phải có cơ chế giám sát để phát hiện và cảnh báo sớm các vấn đề tiềm ẩn.

- **Kiểm thử tự động**: Hệ thống phải được kiểm thử tự động trước khi triển khai các phiên bản mới để đảm bảo tính ổn định.

   5. ## ***Yêu cầu về hiệu năng***

- **Thời gian phản hồi**: Thời gian phản hồi trung bình của hệ thống không quá 2 giây cho các thao tác thông thường và không quá 5 giây cho các thao tác phức tạp (như tạo báo cáo).

- **Khả năng xử lý**: Hệ thống phải hỗ trợ ít nhất 100 người dùng đồng thời mà không ảnh hưởng đến hiệu năng.

- **Tối ưu hóa cơ sở dữ liệu**: Các truy vấn cơ sở dữ liệu phải được tối ưu hóa để đảm bảo thời gian phản hồi nhanh.

- **Tối ưu hóa tài nguyên**: Hệ thống phải sử dụng tài nguyên (CPU, RAM, băng thông) một cách hiệu quả.

- **Khả năng mở rộng**: Hệ thống phải có khả năng mở rộng để đáp ứng nhu cầu tăng trưởng trong tương lai.

   6. ## ***Yêu cầu về tính hỗ trợ***

- **Tài liệu hướng dẫn**: Hệ thống phải cung cấp tài liệu hướng dẫn sử dụng đầy đủ cho từng loại người dùng.

- **Hỗ trợ kỹ thuật**: Nhà phát triển phải cung cấp hỗ trợ kỹ thuật trong thời gian tối thiểu 1 năm sau khi triển khai.

- **Cập nhật và bảo trì**: Hệ thống phải được cập nhật và bảo trì định kỳ để đảm bảo an toàn và hiệu năng.

- **Khả năng nâng cấp**: Hệ thống phải có khả năng nâng cấp mà không ảnh hưởng đến dữ liệu hiện có.

- **Khả năng tùy biến**: Hệ thống cho phép tùy biến một số tính năng để đáp ứng nhu cầu cụ thể của hiệu thuốc.

   7. ## ***Các ràng buộc thiết kế***

- **Kiến trúc hệ thống**: Hệ thống được thiết kế theo kiến trúc 3 lớp (Three-tier) bao gồm: lớp giao diện (Frontend), lớp xử lý nghiệp vụ (Backend), và lớp cơ sở dữ liệu (Database).

- **Công nghệ Frontend**: Sử dụng Angular framework để phát triển giao diện người dùng.

- **Công nghệ Backend**: Sử dụng Java với Spring Boot framework để phát triển các dịch vụ backend.

- **Cơ sở dữ liệu**: Sử dụng MySQL làm hệ quản trị cơ sở dữ liệu.

- **API**: Sử dụng RESTful API để giao tiếp giữa Frontend và Backend.

- **Mã nguồn**: Mã nguồn phải được tổ chức theo cấu trúc rõ ràng, tuân thủ các quy tắc lập trình và được ghi chú đầy đủ.

   8. ## ***Yêu cầu về Giao tiếp***

- **Giao tiếp người dùng**: Giao diện người dùng phải hỗ trợ tiếng Việt, sử dụng font Unicode, và có khả năng hiển thị tốt trên các trình duyệt phổ biến (Chrome, Firefox, Safari, Edge).

- **Giao tiếp hệ thống**: Hệ thống sử dụng RESTful API với định dạng dữ liệu JSON để giao tiếp giữa Frontend và Backend.

- **Giao tiếp với hệ thống thanh toán**: Hệ thống tích hợp với cổng thanh toán VNPay thông qua API được cung cấp bởi VNPay.

- **Giao tiếp email**: Hệ thống sử dụng SMTP để gửi email thông báo và xác nhận đến người dùng.

- **Giao tiếp mạng**: Hệ thống sử dụng giao thức HTTPS để đảm bảo an toàn trong quá trình truyền tải dữ liệu.

   9. ## ***Các yêu cầu tài liệu người dùng và hỗ trợ trực tuyến***

- **Tài liệu hướng dẫn sử dụng**: Hệ thống cung cấp tài liệu hướng dẫn sử dụng chi tiết cho từng loại người dùng (Khách hàng, Nhân viên, Admin).

- **Hướng dẫn trực tuyến**: Hệ thống cung cấp hướng dẫn trực tuyến (online help) cho các chức năng phức tạp.

- **Video hướng dẫn**: Hệ thống cung cấp video hướng dẫn sử dụng các chức năng chính.

- **FAQ**: Hệ thống cung cấp danh sách các câu hỏi thường gặp và câu trả lời.

- **Hỗ trợ trực tuyến**: Hệ thống cung cấp chức năng chat trực tuyến để hỗ trợ khách hàng trong quá trình sử dụng.

   10. ## ***Các thành phần mua ngoài***

- **Cổng thanh toán VNPay**: Sử dụng dịch vụ thanh toán trực tuyến của VNPay để xử lý các giao dịch thanh toán.

- **Dịch vụ gửi email**: Sử dụng dịch vụ gửi email như SendGrid hoặc Mailgun để gửi email thông báo và xác nhận.

- **Dịch vụ lưu trữ đám mây**: Sử dụng dịch vụ lưu trữ đám mây như Amazon S3 hoặc Google Cloud Storage để lưu trữ hình ảnh và tài liệu.

- **Thư viện biểu đồ**: Sử dụng thư viện biểu đồ như Chart.js hoặc D3.js để hiển thị biểu đồ trong báo cáo.

- **Thư viện PDF**: Sử dụng thư viện như PDFBox hoặc iText để tạo và xuất file PDF.

   11. ## ***Các yêu cầu pháp lý, bản quyền và những ghi chú khác***

- **Tuân thủ quy định về kinh doanh dược phẩm**: Hệ thống phải tuân thủ các quy định pháp lý về kinh doanh dược phẩm tại Việt Nam, bao gồm việc kiểm soát thuốc kê đơn và thuốc không kê đơn.

- **Bảo vệ dữ liệu cá nhân**: Hệ thống phải tuân thủ các quy định về bảo vệ dữ liệu cá nhân, bao gồm việc thu thập, lưu trữ, và xử lý thông tin cá nhân của khách hàng.

- **Bản quyền phần mềm**: Hệ thống phải sử dụng các thành phần phần mềm có bản quyền hợp pháp hoặc mã nguồn mở với giấy phép phù hợp.

- **Điều khoản sử dụng**: Hệ thống phải có điều khoản sử dụng rõ ràng và yêu cầu người dùng đồng ý trước khi sử dụng.

- **Chính sách bảo mật**: Hệ thống phải có chính sách bảo mật rõ ràng và công khai cho người dùng.

   12. ## ***Các tiêu chuẩn áp dụng***

- **Tiêu chuẩn phát triển phần mềm**: Áp dụng các tiêu chuẩn phát triển phần mềm như SOLID, Clean Code, và Design Patterns.

- **Tiêu chuẩn bảo mật**: Áp dụng các tiêu chuẩn bảo mật như OWASP Top 10 để phòng chống các lỗ hổng bảo mật phổ biến.

- **Tiêu chuẩn giao diện người dùng**: Áp dụng các tiêu chuẩn về thiết kế giao diện người dùng như Material Design hoặc Bootstrap.

- **Tiêu chuẩn API**: Áp dụng các tiêu chuẩn về thiết kế API như RESTful API Design.

- **Tiêu chuẩn kiểm thử**: Áp dụng các tiêu chuẩn về kiểm thử phần mềm như Unit Testing, Integration Testing, và End-to-End Testing.

   13. ## ***Các yêu cầu khác***

- **Khả năng tích hợp**: Hệ thống phải có khả năng tích hợp với các hệ thống khác trong tương lai, như hệ thống quản lý kho, hệ thống kế toán, hoặc hệ thống CRM.

- **Khả năng mở rộng**: Hệ thống phải có khả năng mở rộng để đáp ứng nhu cầu tăng trưởng trong tương lai, như tăng số lượng người dùng, tăng số lượng sản phẩm, hoặc thêm các chức năng mới.

- **Khả năng cá nhân hóa**: Hệ thống cho phép cá nhân hóa một số tính năng để đáp ứng nhu cầu cụ thể của từng hiệu thuốc.

- **Khả năng xuất nhập dữ liệu**: Hệ thống cho phép xuất nhập dữ liệu từ/vào các định dạng phổ biến như Excel, CSV để thuận tiện cho việc di chuyển dữ liệu.

- **Khả năng theo dõi và phân tích**: Hệ thống có khả năng theo dõi và phân tích hành vi người dùng để cải thiện trải nghiệm và tối ưu hóa hiệu suất.

5. # **ĐẶC TẢ YÊU CẦU CHO TỪNG THÀNH PHẦN HỆ THỐNG**

Dựa trên system concept và mô hình triển khai của hệ thống, các thành phần cần có của hệ thống hiệu thuốc được xác định như sau:

## Yêu cầu đối với Database Server

Lưu trữ toàn bộ dữ liệu của hệ thống hiệu thuốc, bao gồm thông tin về thuốc, đơn hàng, khách hàng, nhân viên, và các dữ liệu nghiệp vụ khác.

Đảm bảo thời gian trả lời cho các giao dịch không quá 3 giây.

Hỗ trợ tối thiểu 100 kết nối đồng thời.

Khả năng xử lý tối thiểu 1000 giao dịch/phút.

Sao lưu tự động hàng ngày và khả năng phục hồi dữ liệu trong vòng 4 giờ.

## Yêu cầu đối với Application Server

Xử lý logic nghiệp vụ và cung cấp API cho client.

Thời gian phản hồi API đơn giản dưới 200ms, API phức tạp dưới 2 giây.

Xử lý tối thiểu 50 request/giây.

Hỗ trợ tối thiểu 500 người dùng đồng thời.

Đảm bảo bảo mật thông tin với JWT và HTTPS.

## Yêu cầu đối với Web Server

Phục vụ giao diện người dùng và xử lý các yêu cầu HTTP từ người dùng.

Thời gian phản hồi dưới 100ms.

Throughput tối thiểu 1000 request/giây.

Hỗ trợ tối thiểu 1000 kết nối đồng thời.

Đảm bảo bảo mật với chứng chỉ SSL/TLS.

## Yêu cầu đối với Frontend Client

Giao diện người dùng thân thiện, dễ sử dụng.

Thời gian tải trang lần đầu dưới 3 giây, sau khi cache dưới 1 giây.

Tương thích với các trình duyệt phổ biến: Chrome, Firefox, Safari, Edge.

Thiết kế responsive cho nhiều loại thiết bị.

Hỗ trợ đa ngôn ngữ (tiếng Việt, tiếng Anh).

## Yêu cầu đối với Payment Gateway

Tích hợp với VNPay API để xử lý các giao dịch thanh toán trực tuyến.

Thời gian xử lý giao dịch dưới 5 giây.

Tỷ lệ thành công giao dịch tối thiểu 99%.

Đảm bảo bảo mật thông tin giao dịch với mã hóa và xác thực.

## Yêu cầu đối với Email Service

Gửi email thông báo, xác nhận đơn hàng, và các thông tin khác cho người dùng.

Thời gian gửi email dưới 1 phút.

Tỷ lệ gửi thành công tối thiểu 98%.

## Yêu cầu đối với Reporting System

Tạo báo cáo doanh thu, bán hàng, tồn kho theo các tiêu chí khác nhau.

Thời gian tạo báo cáo đơn giản dưới 3 giây, báo cáo phức tạp dưới 30 giây.

Hỗ trợ xuất báo cáo ra các định dạng: PDF, Excel.

Phân quyền truy cập báo cáo theo vai trò người dùng.
