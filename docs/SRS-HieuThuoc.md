HT-2024: Tài liệu đặc tả yêu cầu phần mềm
|||
| :- | - |

**XÂY DỰNG WEB BÁN VÀ QUẢN LÝ HIỆU THUỐC**

**_Tài liệu đặc tả yêu cầu phần mềm_**

|  **Mã dự án**   | **HT-2024**           |
| :-------------: | :-------------------- |
| **Mã tài liệu** | **HT-SRS-001_v1.0.0** |
|    **Ngày**     | **15/12/2024**        |

**Hà Nội, ngày 15 tháng 12 năm 2024**

**NỘI DUNG SỬA ĐỔI**

\*M- Mới S – Sửa X - Xóa

|  **Ngày**  | **Mục sửa đổi**  | **M\*<br>S, X** | **Nội dung sửa đổi** | **Người sửa đổi** | **Lần sửa đổi** |
| :--------: | :--------------: | :-------------: | :------------------: | :---------------: | :-------------: |
| 15/07/2023 | Toàn bộ tài liệu |        M        |   Tạo mới tài liệu   | Nguyễn Trung Kiên |        1        |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |
|            |                  |                 |                      |                   |                 |

**TRANG KÝ**

**NGƯỜI LẬP:** Nguyễn Trung Kiên 15/12/2024

`	`Trưởng nhóm phát triển

**NGƯỜI KIỂM TRA:** Trần Minh Quang 15/12/2024

`	`Thành viên nhóm phát triển

**NGƯỜI PHÊ DUYỆT:** Viên Ngọc Kỳ 15/12/2024

`	`Thành viên nhóm phát triển

**MỤC LỤC**

[1. GIỚI THIỆU 3](#_toc299715318)

[1.1. Mục đích tài liệu 3](#_toc299715319)

[1.2. Phạm vi hệ thống 3](#_toc299715320)

[1.3. Định nghĩa thuật ngữ viết tắt 3](#_toc299715321)

[1.4. Tài liệu tham khảo 3](#_toc299715322)

[1.5. Mô tả tài liệu 3](#_toc299715323)

[2. TỔNG QUAN HỆ THỐNG 3](#_toc299715324)

[2.1. Phát biểu bài toán 3](#_toc299715325)

[2.2. Mục tiêu hệ thống 3](#_toc299715326)

[2.3. Người sử dụng hệ thống 3](#_toc299715327)

[3. ĐẶC TẢ YÊU CẦU CHỨC NĂNG 3](#_toc299715328)

[3.1. Phân hệ quản lý thuốc 3](#_toc299715329)

[3.2. Phân hệ quản lý kho 3](#_toc299715330)

[3.3. Phân hệ quản lý đơn hàng 3](#_toc299715331)

[3.4. Phân hệ quản lý khuyến mãi 3](#_toc299715332)

[3.5. Phân hệ quản lý người dùng 3](#_toc299715333)

[3.6. Phân hệ báo cáo và thống kê 3](#_toc299715334)

[4. CÁC YÊU CẦU PHI CHỨC NĂNG 3](#_toc299715335)

[4.1. Yêu cầu bảo mật 3](#_toc299715336)

[4.2. Yêu cầu sao lưu 3](#_toc299715337)

[4.3. Yêu cầu về tính sử dụng 3](#_toc299715338)

[4.4. Yêu cầu về tính ổn định 3](#_toc299715339)

[4.5. Yêu cầu về hiệu năng 3](#_toc299715340)

[4.6. Yêu cầu về tính hỗ trợ 3](#_toc299715341)

[4.7. Các ràng buộc thiết kế 3](#_toc299715342)

[4.8. Yêu cầu về Giao tiếp 3](#_toc299715343)

[4.9. Các yêu cầu khác 3](#_toc299715344)

1. # **GIỚI THIỆU**
   1. ## **_Mục đích tài liệu_**

- Tài liệu này được xây dựng nhằm mục đích phân tích các yêu cầu cho dự án "Hệ thống quản lý hiệu thuốc", đồng thời là cơ sở để đàm phán với khách hàng về phạm vi của dự án.
- Tài liệu này được dùng làm đầu vào cho các quá trình thiết kế, xây dựng usecase, lập trình, kiểm thử của việc xây dựng hệ thống.

  1.  ## **_Phạm vi hệ thống_**

Tài liệu đặc tả các chức năng cần thiết của hệ thống quản lý hiệu thuốc. Hệ thống gồm 2 phân hệ:

- Phân hệ Frontend: Giao diện người dùng cho khách hàng và nhân viên quản lý
- Phân hệ Backend: Xử lý nghiệp vụ và quản lý dữ liệu

  1.  ## **_Định nghĩa thuật ngữ viết tắt_**

| **STT** | **Nội dung** | **Ý nghĩa**                                                      |
| ------- | ------------ | ---------------------------------------------------------------- |
| 1       | SRS          | Software Requirements Specification - Đặc tả yêu cầu phần mềm    |
| 2       | RBAC         | Role-Based Access Control - Kiểm soát truy cập dựa trên vai trò  |
| 3       | JWT          | JSON Web Token - Chuẩn mở để truyền thông tin an toàn            |
| 4       | API          | Application Programming Interface - Giao diện lập trình ứng dụng |
| 5       | UI           | User Interface - Giao diện người dùng                            |
| 6       | CRUD         | Create, Read, Update, Delete - Tạo, Đọc, Cập nhật, Xóa           |
| 7       | JDK          | Java Development Kit - Bộ công cụ phát triển Java                |

1.  ## **_Tài liệu tham khảo_**

#### **Tài liệu, giáo trình:**

1. PGS.TS Trần Đình Quế, Phân tích và thiết kế hệ thống thông tin hiện đại, Học viện Công nghệ Bưu chính Viễn thông, Tái bản lần thứ 2, 2022.

2. TS Nguyễn Đình Hóa, Slide môn cơ sở dữ liệu, Học viện Công nghệ Bưu chính Viễn thông.

3. Aho, Hopcroft & Ullman, Data Structures and Algorithms Addison Wesley, 2001.

#### **Trang web:**

1. [https://viblo.asia/p/gioi-thieu-va-lam-quen-voi-react-native-naQZRG6Glvx/](https://viblo.asia/p/gioi-thieu-va-lam-quen-voi-react-native-naQZRG6Glvx/)

2. [https://viblo.asia/p/nodejs-voi-express-framework-rQOvPKVgkYj/](https://viblo.asia/p/nodejs-voi-express-framework-rQOvPKVgkYj/)

3. [https://viblo.asia/p/tong-quan-ve-mongodb-EoDkQoxqGbV/](https://viblo.asia/p/tong-quan-ve-mongodb-EoDkQoxqGbV/)

4. [https://phamanhduc.com/tich-hop-vnpay-vao-ung-dung-spring-boot/](https://phamanhduc.com/tich-hop-vnpay-vao-ung-dung-spring-boot/)

5. Klaus Olsen (chair), Tauhida Parveen (vice chair), Rex Black (project manager), Debra Friedenberg, Matthias Hamburg, Judy McKay, Certified Tester Foundation Level (CTFL) Syllabus, 2018, 2005, p. 34

   1. ## **_Mô tả tài liệu_**

Nội dung tài liệu này bao gồm các phần:

1. Giới thiệu: Mô tả mục đích, phạm vi, định nghĩa, tài liệu tham khảo và cấu trúc của tài liệu
2. Tổng quan hệ thống: Mô tả bài toán, mục tiêu và người sử dụng hệ thống
3. Đặc tả yêu cầu chức năng: Chi tiết các chức năng của từng phân hệ trong hệ thống, bao gồm quản lý thuốc, quản lý kho, quản lý đơn hàng, quản lý khuyến mãi, quản lý người dùng, quản lý tương tác thuốc, và báo cáo thống kê
4. Các yêu cầu phi chức năng: Mô tả các yêu cầu về bảo mật, hiệu năng, sao lưu, tính sử dụng, tính ổn định, tính hỗ trợ, các ràng buộc thiết kế, yêu cầu về giao tiếp và các yêu cầu khác

5. # **TỔNG QUAN HỆ THỐNG**
   1. ## **_Phát biểu bài toán_**

Hiện nay, các hiệu thuốc đang ngày càng cần thiết phải hiện đại hóa các phương thức quản lý và bán hàng để nâng cao hiệu quả kinh doanh cũng như đáp ứng nhu cầu của khách hàng. Đối với nhiều hiệu thuốc, việc quản lý kho hàng, đơn hàng, và thông tin khách hàng thường gặp nhiều khó khăn.

Hiện trạng quản lý hiệu thuốc truyền thống gặp nhiều khó khăn trong việc:

- Khó khăn trong việc quản lý số lượng lớn các sản phẩm dược phẩm với nhiều loại thuốc, hạn sử dụng, và các yêu cầu bảo quản khác nhau
- Tốn nhiều thời gian cho việc xử lý đơn hàng và quản lý tồn kho
- Hạn chế trong việc tích hợp giữa bán hàng truyền thống và bán hàng trực tuyến, dẫn đến khó khăn trong theo dõi và quản lý

Trong bối cảnh này, việc xây dựng một hệ thống quản lý hiệu thuốc trên nền web sẽ giúp cải thiện đáng kể hoạt động của hiệu thuốc. Hệ thống sẽ không chỉ hỗ trợ quản lý kho và đơn hàng mà còn tích hợp các tính năng bán hàng trực tuyến, mang đến cho khách hàng sự tiện lợi trong việc tra cứu và mua sắm thuốc từ xa.

1.  ## **_Mục tiêu hệ thống_**

Đồ án này hướng đến việc xây dựng một hệ thống web bán và quản lý hiệu thuốc với những mục tiêu cụ thể sau:

- **Tạo nền tảng bán thuốc trực tuyến dễ sử dụng**: Xây dựng một website và ứng dụng thân thiện với người dùng, tích hợp tính năng tìm kiếm, tra cứu và đặt mua thuốc một cách đơn giản và hiệu quả. Giao diện được thiết kế thân thiện và dễ dàng điều hướng để mọi người dùng đều có thể sử dụng dễ dàng.
- **Quản lý kho và bán hàng thông minh**: Cung cấp các tính năng quản lý kho hàng, cập nhật số lượng thuốc trong kho, theo dõi các lô thuốc hết hạn, và kiểm soát tình trạng tồn kho hiệu quả, giảm thiểu tình trạng hết hàng và nâng cao hiệu suất kinh doanh.
- **Tích hợp tư vấn và gợi ý cá nhân hóa**: Hệ thống sẽ bao gồm tính năng tư vấn sức khỏe và gợi ý sản phẩm cá nhân hóa dựa trên lịch sử mua hàng, độ tuổi, và các yếu tố sức khỏe khác của người dùng, tạo trải nghiệm tốt hơn cho khách hàng.
- **Quản lý tương tác thuốc và cảnh báo an toàn**: Xây dựng tính năng kiểm tra và cảnh báo các tương tác thuốc nguy hiểm có thể xảy ra khi người dùng mua nhiều loại thuốc cùng lúc. Hệ thống sẽ cung cấp thông tin về các tương tác thuốc phổ biến và cảnh báo người dùng nếu có nguy cơ gây hại từ việc kết hợp thuốc.
- **Tuân thủ quy định pháp lý**: Đảm bảo hệ thống tuân thủ các quy định pháp lý về kinh doanh dược phẩm trực tuyến tại Việt Nam, bao gồm quy trình kiểm duyệt đơn thuốc đối với các loại thuốc kê toa, giúp người dùng mua thuốc an toàn và đúng quy định.

  1.  ## **_Người sử dụng hệ thống_**

Dưới đây là mô tả ngắn gọn về nghiệp vụ của từng tác nhân chính trong hệ thống:

| **Người sử dụng**         | **Mô tả**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| ------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Khách hàng**            | • Đăng ký, đăng nhập và quản lý tài khoản: Khách hàng có thể tạo tài khoản mới, đăng nhập và quản lý thông tin cá nhân.<br>• Tìm kiếm và xem thông tin thuốc: Khách hàng có thể tìm kiếm thuốc theo tên, công dụng hoặc thành phần và xem chi tiết sản phẩm.<br>• Thêm vào giỏ hàng và đặt hàng: Khách hàng chọn sản phẩm, thêm vào giỏ hàng, cập nhật số lượng và tiến hành thanh toán.<br>• Theo dõi đơn hàng: Khách hàng có thể kiểm tra trạng thái đơn hàng từ khi đặt hàng cho đến khi nhận hàng.<br>• Yêu cầu hỗ trợ: Khách hàng có thể yêu cầu tư vấn thuốc qua chat hoặc gọi điện để được hỗ trợ.<br>• Khách hàng trả hàng.                               |
| **Quản trị viên (Admin)** | • Quản lý khách hàng: Quản trị viên có thể tạo, xóa và phân quyền cho các tài khoản (như khách hàng, nhân viên, quản trị viên khác).<br>• Quản lý sản phẩm và kho: Quản trị viên cập nhật danh mục sản phẩm, kiểm soát số lượng tồn kho và theo dõi tình trạng kho để tránh thiếu hụt.<br>• Quản lý đơn hàng: Quản trị viên theo dõi, xử lý đơn hàng, xem lịch sử giao dịch và xử lý các yêu cầu trả hàng từ khách hàng.<br>• Xem và lập báo cáo: Quản trị viên tạo các báo cáo thống kê về doanh thu, tồn kho, sản phẩm bán chạy và tình trạng đơn hàng.<br>• Bảo mật và an ninh: Quản lý hệ thống bảo mật, bao gồm xác thực hai lớp và mã hóa dữ liệu nhạy cảm. |
| **Nhân viên**             | • Quản lý kho: Nhân viên kiểm tra tình trạng kho và cập nhật thông tin sản phẩm để đảm bảo hàng luôn sẵn có.<br>• Tư vấn thuốc: Nhân viên hỗ trợ khách hàng qua chat hoặc điện thoại về các sản phẩm thuốc, giúp chọn lựa phù hợp.<br>• Cảnh báo và tư vấn tương tác thuốc: Nhân viên theo dõi cảnh báo về tương tác thuốc và tư vấn khách hàng về các sản phẩm thay thế nếu cần thiết.<br>• Hỗ trợ quản lý đơn hàng: Nhân viên cũng có thể hỗ trợ xử lý các đơn hàng liên quan đến thuốc và đảm bảo giao đúng sản phẩm, khách hàng trả hàng.                                                                                                                     |

1. ## **_Mô hình phân rã chức năng của hệ thống_**

Dưới đây là mô hình phân rã các chức năng của hệ thống, thể hiện các phân hệ lớn, phân hệ con và các chức năng trong từng phân hệ:

1. **Phân hệ quản lý thuốc**

   - Quản lý danh sách thuốc
   - Quản lý loại thuốc
   - Quản lý nhà sản xuất và nhà cung cấp

2. **Phân hệ quản lý kho**

   - Quản lý nhập kho
   - Quản lý tồn kho
   - Kiểm kê kho
   - Cảnh báo hàng sắp hết, hàng sắp hết hạn

3. **Phân hệ quản lý đơn hàng**

   - Quản lý đơn hàng
   - Bán hàng tại quầy
   - Đặt hàng trực tuyến
   - Theo dõi trạng thái đơn hàng
   - Quản lý trả hàng

4. **Phân hệ quản lý khuyến mãi**

   - Quản lý chương trình khuyến mãi
   - Áp dụng khuyến mãi cho đơn hàng

5. **Phân hệ quản lý người dùng**

   - Quản lý người dùng
   - Đăng nhập và xác thực
   - Phân quyền người dùng
   - Quản lý thông tin cá nhân

6. **Phân hệ quản lý tương tác thuốc**

   - Quản lý cơ sở dữ liệu tương tác thuốc
   - Kiểm tra và cảnh báo tương tác thuốc
   - Tư vấn thay thế thuốc

7. **Phân hệ báo cáo và thống kê**

   - Báo cáo doanh thu
   - Báo cáo tồn kho
   - Báo cáo thuốc bán chạy
   - Xuất báo cáo

8. # **ĐẶC TẢ YÊU CẦU CHỨC NĂNG**

Hệ thống web bán và quản lý hiệu thuốc được thiết kế nhằm cung cấp một nền tảng tiện lợi, bảo mật và dễ dàng sử dụng cho các đối tượng người dùng khác nhau, bao gồm khách hàng, dược sĩ và quản trị viên. Các chức năng chính của hệ thống được phân chia rõ ràng, bao gồm các công cụ hỗ trợ tìm kiếm, đặt hàng thuốc, quản lý kho, theo dõi đơn hàng, và nhiều tính năng khác nhằm tối ưu hóa trải nghiệm người dùng. Dưới đây là mô tả chi tiết các chức năng chính của hệ thống:

1. **Chức Năng Quản Lý Người Dùng**

   - **Đăng ký và đăng nhập:** Người dùng có thể dễ dàng đăng ký tài khoản bằng email và mật khẩu. Hệ thống hỗ trợ chức năng đăng nhập bảo mật, bảo vệ thông tin người dùng qua mã hóa mật khẩu và cơ chế xác thực phiên đăng nhập.
   - **Quản lý tài khoản cá nhân:** Người dùng có thể chỉnh sửa thông tin cá nhân, bao gồm địa chỉ giao hàng, số điện thoại, và lịch sử mua hàng để thuận tiện cho các giao dịch sau này.
   - **Phân quyền người dùng:** Hệ thống phân quyền cho các loại người dùng khác nhau, bao gồm khách hàng (chỉ có quyền mua hàng), dược sĩ (có thể xử lý đơn hàng và quản lý kho), và quản trị viên (quản lý tất cả các chức năng của hệ thống).

2. **Chức Năng Quản Lý Sản Phẩm (Thuốc)**

   - **Tìm kiếm và xem chi tiết sản phẩm:** Người dùng có thể tìm kiếm thuốc theo tên, nhóm thuốc, công dụng, và xem các thông tin chi tiết như thành phần, công dụng, hướng dẫn sử dụng và giá cả của từng sản phẩm.
   - **Quản lý danh mục sản phẩm:** Quản trị viên có thể thêm mới, chỉnh sửa hoặc xóa sản phẩm trong danh mục, giúp hệ thống luôn cập nhật những loại thuốc mới hoặc thay đổi về thông tin thuốc (như giá cả, công dụng).
   - **Quản lý số lượng hàng tồn kho:** Hệ thống tự động cập nhật số lượng hàng tồn kho sau mỗi giao dịch thành công, giúp quản trị viên theo dõi và điều chỉnh tình trạng kho hiệu quả.

3. **Chức Năng Đặt Hàng và Thanh Toán**

   - **Giỏ hàng**: Khách hàng có thể thêm thuốc vào giỏ hàng và chỉnh sửa số lượng sản phẩm trước khi tiến hành thanh toán.
   - **Đặt hàng và thanh toán:** Khách hàng có thể lựa chọn các phương thức thanh toán trực tuyến như thẻ ngân hàng, ví điện tử, hoặc thanh toán khi nhận hàng (COD). Sau khi thanh toán thành công, hệ thống xác nhận đơn hàng và chuyển trạng thái đơn hàng sang "đang xử lý".
   - **Theo dõi tình trạng đơn hàng:** Khách hàng có thể theo dõi quá trình xử lý đơn hàng từ lúc đặt hàng đến khi nhận được sản phẩm. Các trạng thái đơn hàng bao gồm "đang xử lý", "đang giao", và "đã giao".

4. **Chức Năng Quản Lý Đơn Hàng**

   - **Xử lý đơn hàng:** Sau khi khách hàng đặt hàng, hệ thống sẽ thông báo cho dược sĩ và nhân viên kho để kiểm tra tình trạng hàng hóa và đóng gói. Nếu sản phẩm không có sẵn, hệ thống sẽ thông báo cho khách hàng.
   - **Quản lý lịch sử giao dịch:** Quản trị viên và khách hàng có thể xem lại lịch sử các giao dịch đã thực hiện, giúp theo dõi các đơn hàng trước đó và thuận tiện cho các lần mua sau.
   - **Quản lý trả hàng:** Trong trường hợp khách hàng muốn trả lại sản phẩm, hệ thống hỗ trợ xử lý các yêu cầu trả hàng và hoàn tiền nếu đáp ứng các điều kiện trả hàng.

5. **Chức Năng Quản Lý Kho và Báo Cáo**

   - **Quản lý kho:** Quản trị viên và dược sĩ có thể kiểm tra và quản lý hàng tồn kho, thêm mới hoặc xóa sản phẩm trong kho, nhập hàng vào kho đồng thời theo dõi tình trạng kho để tránh thiếu hụt hàng.
   - **Báo cáo doanh thu và thống kê:** Hệ thống cung cấp báo cáo doanh thu theo ngày, tháng, và năm, giúp quản trị viên dễ dàng theo dõi hoạt động kinh doanh. Thêm vào đó, các thống kê về sản phẩm bán chạy và tình trạng kho giúp đưa ra quyết định nhập hàng hiệu quả.

6. **Chức Năng Hỗ Trợ và Tư Vấn Trực Tuyến**

   - **Tư vấn trực tuyến**: Hệ thống hỗ trợ tư vấn trực tuyến với dược sĩ để khách hàng có thể hỏi đáp về các loại thuốc, cách sử dụng, và các vấn đề sức khỏe liên quan.
   - **Chatbot hỗ trợ tự động:** Chatbot tích hợp trong hệ thống giúp trả lời các câu hỏi thường gặp của khách hàng, giải đáp nhanh chóng các vấn đề cơ bản về thuốc và các dịch vụ của hiệu thuốc.

7. **Chức Năng Quản Lý Tương Tác Thuốc**

   - **Cảnh báo tương tác thuốc:** Hệ thống tự động kiểm tra các tương tác thuốc có thể xảy ra khi người dùng chọn mua nhiều sản phẩm, và cảnh báo kịp thời về các rủi ro có thể xảy ra giữa các thuốc này.
   - **Thông tin chi tiết về tương tác thuốc**: Người dùng sẽ nhận được thông tin về các tương tác thuốc có thể xảy ra, giúp họ hiểu rõ về những rủi ro liên quan đến việc sử dụng nhiều loại thuốc cùng lúc.

   1. ## **_Phân hệ quản lý thuốc_**
      1. ### **SREQ001 – Quản lý danh sách thuốc**

**1. Mô tả nghiệp vụ**

Chức năng quản lý danh sách thuốc cho phép người dùng có quyền (Admin, Manager, Pharmacist) xem, thêm, sửa, xóa và tìm kiếm thông tin thuốc trong hệ thống.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem danh sách thuốc với các thông tin: mã thuốc, tên thuốc, loại thuốc, nhà sản xuất, giá bán, đơn vị tính, số lượng tồn kho, hạn sử dụng.
- Hệ thống cho phép thêm mới thuốc với các thông tin: tên thuốc, loại thuốc, nhà sản xuất, giá bán, đơn vị tính, số lượng, hạn sử dụng, mô tả, hình ảnh, thành phần, chỉ định, chống chỉ định, liều dùng, tác dụng phụ, lưu ý.
- Hệ thống cho phép cập nhật thông tin thuốc đã có trong hệ thống.
- Hệ thống cho phép xóa thuốc khỏi hệ thống (xóa logic, không xóa vật lý).
- Hệ thống cho phép tìm kiếm thuốc theo tên, mã, loại thuốc, nhà sản xuất.
- Hệ thống cho phép lọc thuốc theo loại thuốc, nhà sản xuất, khoảng giá, tình trạng tồn kho.
- Hệ thống cho phép xuất danh sách thuốc ra file Excel.

      1. ### **SREQ002 – Quản lý loại thuốc**

**1. Mô tả nghiệp vụ**

Chức năng quản lý loại thuốc cho phép người dùng có quyền (Admin, Manager, Pharmacist) xem, thêm, sửa, xóa và tìm kiếm thông tin loại thuốc trong hệ thống.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem danh sách loại thuốc với các thông tin: mã loại thuốc, tên loại thuốc, mô tả.
- Hệ thống cho phép thêm mới loại thuốc với các thông tin: tên loại thuốc, mô tả.
- Hệ thống cho phép cập nhật thông tin loại thuốc đã có trong hệ thống.
- Hệ thống cho phép xóa loại thuốc khỏi hệ thống (chỉ xóa được khi không có thuốc nào thuộc loại đó).
- Hệ thống cho phép tìm kiếm loại thuốc theo tên, mã.

      1. ### **SREQ003 – Quản lý nhà sản xuất và nhà cung cấp**

**1. Mô tả nghiệp vụ**

Chức năng quản lý nhà sản xuất và nhà cung cấp cho phép người dùng có quyền (Admin, Manager) xem, thêm, sửa, xóa và tìm kiếm thông tin nhà sản xuất và nhà cung cấp trong hệ thống.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem danh sách nhà sản xuất và nhà cung cấp với các thông tin: mã, tên, địa chỉ, số điện thoại, email, người liên hệ.
- Hệ thống cho phép thêm mới nhà sản xuất và nhà cung cấp với các thông tin: tên, địa chỉ, số điện thoại, email, người liên hệ.
- Hệ thống cho phép cập nhật thông tin nhà sản xuất và nhà cung cấp đã có trong hệ thống.
- Hệ thống cho phép xóa nhà sản xuất và nhà cung cấp khỏi hệ thống (chỉ xóa được khi không có thuốc nào liên quan).
- Hệ thống cho phép tìm kiếm nhà sản xuất và nhà cung cấp theo tên, mã, địa chỉ, số điện thoại.

  1.  ## **_Phân hệ quản lý kho_**
      1. ### **SREQ004 – Quản lý nhập kho**

**1. Mô tả nghiệp vụ**

Chức năng quản lý nhập kho cho phép người dùng có quyền (Admin, Manager) tạo phiếu nhập kho, xem danh sách phiếu nhập kho, chi tiết phiếu nhập kho và cập nhật trạng thái phiếu nhập kho.

**2. Yêu cầu chức năng**

- Hệ thống cho phép tạo phiếu nhập kho với các thông tin: mã phiếu, ngày nhập, nhà cung cấp, người nhập, ghi chú.
- Hệ thống cho phép thêm chi tiết phiếu nhập kho với các thông tin: thuốc, số lượng, đơn giá, thành tiền, hạn sử dụng.
- Hệ thống tự động tính tổng tiền phiếu nhập kho.
- Hệ thống cho phép xem danh sách phiếu nhập kho với các thông tin: mã phiếu, ngày nhập, nhà cung cấp, người nhập, tổng tiền, trạng thái.
- Hệ thống cho phép xem chi tiết phiếu nhập kho.
- Hệ thống cho phép cập nhật trạng thái phiếu nhập kho (Đang xử lý, Đã nhập kho, Đã hủy).
- Hệ thống tự động cập nhật số lượng tồn kho khi phiếu nhập kho có trạng thái "Đã nhập kho".
- Hệ thống cho phép tìm kiếm phiếu nhập kho theo mã phiếu, ngày nhập, nhà cung cấp, trạng thái.
- Hệ thống cho phép xuất phiếu nhập kho ra file PDF.

      1. ### **SREQ005 – Quản lý tồn kho**

**1. Mô tả nghiệp vụ**

Chức năng quản lý tồn kho cho phép người dùng có quyền (Admin, Manager, Pharmacist) xem thông tin tồn kho, kiểm kê kho và nhận cảnh báo hàng sắp hết, hàng sắp hết hạn.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem thông tin tồn kho với các thông tin: mã thuốc, tên thuốc, loại thuốc, số lượng tồn kho, đơn vị tính, hạn sử dụng.
- Hệ thống cho phép lọc thông tin tồn kho theo loại thuốc, nhà sản xuất, tình trạng tồn kho (còn hàng, sắp hết, hết hàng), tình trạng hạn sử dụng (còn hạn, sắp hết hạn, hết hạn).
- Hệ thống tự động cảnh báo khi thuốc sắp hết hàng (số lượng tồn kho dưới ngưỡng cảnh báo).
- Hệ thống tự động cảnh báo khi thuốc sắp hết hạn (thời gian còn lại dưới ngưỡng cảnh báo).
- Hệ thống cho phép kiểm kê kho: so sánh số lượng thực tế với số lượng trong hệ thống, cập nhật số lượng thực tế.
- Hệ thống cho phép xuất báo cáo tồn kho ra file Excel.

  1.  ## **_Phân hệ quản lý đơn hàng_**
      1. ### **SREQ006 – Quản lý đơn hàng**

**1. Mô tả nghiệp vụ**

Chức năng quản lý đơn hàng cho phép người dùng có quyền (Admin, Manager, Cashier) xem danh sách đơn hàng, chi tiết đơn hàng, cập nhật trạng thái đơn hàng và tìm kiếm đơn hàng.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem danh sách đơn hàng với các thông tin: mã đơn hàng, ngày đặt, khách hàng, tổng tiền, trạng thái.
- Hệ thống cho phép xem chi tiết đơn hàng với các thông tin: mã đơn hàng, ngày đặt, khách hàng, địa chỉ giao hàng, số điện thoại, email, phương thức thanh toán, ghi chú, danh sách thuốc (tên thuốc, số lượng, đơn giá, thành tiền), tổng tiền, trạng thái.
- Hệ thống cho phép cập nhật trạng thái đơn hàng (Đang xử lý, Đã xác nhận, Đang giao hàng, Đã giao hàng, Đã hủy).
- Hệ thống cho phép tìm kiếm đơn hàng theo mã đơn hàng, ngày đặt, khách hàng, trạng thái.
- Hệ thống cho phép lọc đơn hàng theo khoảng thời gian, trạng thái.
- Hệ thống cho phép xuất đơn hàng ra file PDF.
- Hệ thống tự động cập nhật số lượng tồn kho khi đơn hàng có trạng thái "Đã xác nhận".
- Hệ thống tự động gửi email thông báo cho khách hàng khi trạng thái đơn hàng thay đổi.

      1. ### **SREQ007 – Bán hàng tại quầy**

**1. Mô tả nghiệp vụ**

Chức năng bán hàng tại quầy cho phép người dùng có quyền (Admin, Manager, Cashier) tạo đơn hàng mới, thêm thuốc vào đơn hàng, áp dụng khuyến mãi, thanh toán và in hóa đơn.

**2. Yêu cầu chức năng**

- Hệ thống cho phép tạo đơn hàng mới với các thông tin: khách hàng (có thể là khách vãng lai), ngày đặt, ghi chú.
- Hệ thống cho phép thêm thuốc vào đơn hàng với các thông tin: thuốc, số lượng, đơn giá, thành tiền.
- Hệ thống tự động tính tổng tiền đơn hàng.
- Hệ thống cho phép áp dụng khuyến mãi cho đơn hàng (nếu có).
- Hệ thống cho phép thanh toán đơn hàng với các phương thức: tiền mặt, chuyển khoản, thẻ tín dụng.
- Hệ thống cho phép in hóa đơn sau khi thanh toán.
- Hệ thống tự động cập nhật số lượng tồn kho sau khi thanh toán.
- Hệ thống cho phép hủy đơn hàng trước khi thanh toán.
- Hệ thống cho phép tìm kiếm thuốc theo tên, mã, loại thuốc khi thêm thuốc vào đơn hàng.

      1. ### **SREQ008 – Đặt hàng trực tuyến**

**1. Mô tả nghiệp vụ**

Chức năng đặt hàng trực tuyến cho phép khách hàng (Customer) xem danh sách thuốc, thêm thuốc vào giỏ hàng, đặt hàng và thanh toán trực tuyến.

**2. Yêu cầu chức năng**

- Hệ thống cho phép khách hàng xem danh sách thuốc với các thông tin: tên thuốc, loại thuốc, nhà sản xuất, giá bán, hình ảnh, mô tả.
- Hệ thống cho phép khách hàng tìm kiếm thuốc theo tên, loại thuốc, nhà sản xuất.
- Hệ thống cho phép khách hàng lọc thuốc theo loại thuốc, nhà sản xuất, khoảng giá.
- Hệ thống cho phép khách hàng xem chi tiết thuốc với các thông tin: tên thuốc, loại thuốc, nhà sản xuất, giá bán, hình ảnh, mô tả, thành phần, chỉ định, chống chỉ định, liều dùng, tác dụng phụ, lưu ý.
- Hệ thống cho phép khách hàng thêm thuốc vào giỏ hàng với số lượng tùy chọn.
- Hệ thống cho phép khách hàng xem giỏ hàng với các thông tin: danh sách thuốc (tên thuốc, số lượng, đơn giá, thành tiền), tổng tiền.
- Hệ thống cho phép khách hàng cập nhật số lượng thuốc trong giỏ hàng hoặc xóa thuốc khỏi giỏ hàng.
- Hệ thống cho phép khách hàng đặt hàng với các thông tin: địa chỉ giao hàng, số điện thoại, email, phương thức thanh toán, ghi chú.
- Hệ thống cho phép khách hàng thanh toán trực tuyến với các phương thức: chuyển khoản, thẻ tín dụng.
- Hệ thống tự động gửi email xác nhận đơn hàng cho khách hàng sau khi đặt hàng thành công.
- Hệ thống cho phép khách hàng xem lịch sử đơn hàng và trạng thái đơn hàng.

  1.  ## **_Phân hệ quản lý khuyến mãi_**
      1. ### **SREQ009 – Quản lý chương trình khuyến mãi**

**1. Mô tả nghiệp vụ**

Chức năng quản lý chương trình khuyến mãi cho phép người dùng có quyền (Admin, Manager) xem, thêm, sửa, xóa và tìm kiếm thông tin chương trình khuyến mãi trong hệ thống.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem danh sách chương trình khuyến mãi với các thông tin: mã chương trình, tên chương trình, loại khuyến mãi (giảm giá theo phần trăm, giảm giá theo số tiền, tặng quà), giá trị khuyến mãi, ngày bắt đầu, ngày kết thúc, trạng thái.
- Hệ thống cho phép thêm mới chương trình khuyến mãi với các thông tin: tên chương trình, loại khuyến mãi, giá trị khuyến mãi, ngày bắt đầu, ngày kết thúc, điều kiện áp dụng (tổng tiền đơn hàng, số lượng sản phẩm), danh sách thuốc áp dụng.
- Hệ thống cho phép cập nhật thông tin chương trình khuyến mãi đã có trong hệ thống.
- Hệ thống cho phép xóa chương trình khuyến mãi khỏi hệ thống.
- Hệ thống cho phép tìm kiếm chương trình khuyến mãi theo tên, mã, loại khuyến mãi, trạng thái.
- Hệ thống tự động cập nhật trạng thái chương trình khuyến mãi dựa trên ngày bắt đầu và ngày kết thúc.
- Hệ thống tự động áp dụng khuyến mãi cho đơn hàng khi thỏa mãn điều kiện.

  1.  ## **_Phân hệ quản lý người dùng_**
      1. ### **SREQ010 – Quản lý người dùng**

**1. Mô tả nghiệp vụ**

Chức năng quản lý người dùng cho phép người dùng có quyền (Admin) xem, thêm, sửa, xóa và tìm kiếm thông tin người dùng trong hệ thống.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem danh sách người dùng với các thông tin: mã người dùng, tên đăng nhập, họ tên, email, số điện thoại, vai trò, trạng thái.
- Hệ thống cho phép thêm mới người dùng với các thông tin: tên đăng nhập, mật khẩu, họ tên, email, số điện thoại, địa chỉ, vai trò, trạng thái.
- Hệ thống cho phép cập nhật thông tin người dùng đã có trong hệ thống.
- Hệ thống cho phép xóa người dùng khỏi hệ thống (xóa logic, không xóa vật lý).
- Hệ thống cho phép tìm kiếm người dùng theo tên đăng nhập, họ tên, email, số điện thoại, vai trò, trạng thái.
- Hệ thống cho phép phân quyền cho người dùng theo vai trò (Admin, Manager, Pharmacist, Cashier, Customer).
- Hệ thống cho phép khóa/mở khóa tài khoản người dùng.
- Hệ thống cho phép đặt lại mật khẩu cho người dùng.

      1. ### **SREQ011 – Đăng nhập và xác thực**

**1. Mô tả nghiệp vụ**

Chức năng đăng nhập và xác thực cho phép người dùng đăng nhập vào hệ thống, đăng ký tài khoản mới, khôi phục mật khẩu và quản lý thông tin cá nhân.

**2. Yêu cầu chức năng**

- Hệ thống cho phép người dùng đăng nhập với tên đăng nhập và mật khẩu.
- Hệ thống sử dụng JWT (JSON Web Token) để xác thực người dùng.
- Hệ thống cho phép người dùng đăng ký tài khoản mới với các thông tin: tên đăng nhập, mật khẩu, họ tên, email, số điện thoại, địa chỉ.
- Hệ thống tự động gán vai trò Customer cho người dùng mới đăng ký.
- Hệ thống cho phép người dùng khôi phục mật khẩu thông qua email.
- Hệ thống cho phép người dùng đã đăng nhập xem và cập nhật thông tin cá nhân.
- Hệ thống cho phép người dùng đã đăng nhập thay đổi mật khẩu.
- Hệ thống tự động đăng xuất người dùng sau một khoảng thời gian không hoạt động.
- Hệ thống ghi lại lịch sử đăng nhập của người dùng.

  1.  ## **_Phân hệ quản lý tương tác thuốc_**
      1. ### **SREQ012 – Quản lý tương tác thuốc**

**1. Mô tả nghiệp vụ**

Chức năng quản lý tương tác thuốc cho phép hệ thống tự động kiểm tra và cảnh báo về các tương tác có thể xảy ra giữa các loại thuốc khi khách hàng thêm nhiều thuốc vào giỏ hàng hoặc khi nhân viên tạo đơn hàng.

**2. Yêu cầu chức năng**

- Hệ thống cho phép quản trị viên quản lý cơ sở dữ liệu về tương tác thuốc, bao gồm thêm, sửa, xóa các cặp tương tác thuốc.
- Hệ thống tự động kiểm tra tương tác thuốc khi khách hàng thêm thuốc vào giỏ hàng hoặc khi nhân viên tạo đơn hàng.
- Khi phát hiện tương tác thuốc nguy hiểm, hệ thống hiển thị cảnh báo với mức độ nghiêm trọng và mô tả chi tiết về tương tác.
- Hệ thống cho phép người dùng xem thông tin chi tiết về tương tác thuốc, bao gồm mô tả tương tác, mức độ nghiêm trọng, và các khuyến nghị.
- Hệ thống lưu lại lịch sử các cảnh báo tương tác thuốc đã hiển thị cho người dùng.
- Hệ thống cho phép tìm kiếm thông tin tương tác thuốc theo tên thuốc hoặc hoạt chất.
- Hệ thống hỗ trợ xuất báo cáo về các tương tác thuốc phổ biến trong một khoảng thời gian.

  1.  ## **_Phân hệ báo cáo và thống kê_**
      1. ### **SREQ013 – Báo cáo doanh thu**

**1. Mô tả nghiệp vụ**

Chức năng báo cáo doanh thu cho phép người dùng có quyền (Admin, Manager) xem báo cáo doanh thu theo ngày, tháng, quý, năm và xuất báo cáo ra file Excel.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem báo cáo doanh thu theo ngày, tháng, quý, năm với các thông tin: doanh thu, số lượng đơn hàng, số lượng thuốc bán ra, lợi nhuận.
- Hệ thống cho phép lọc báo cáo doanh thu theo khoảng thời gian, loại thuốc, nhà sản xuất.
- Hệ thống cho phép xem biểu đồ doanh thu theo thời gian.
- Hệ thống cho phép xuất báo cáo doanh thu ra file Excel.
- Hệ thống cho phép so sánh doanh thu giữa các khoảng thời gian.

      1. ### **SREQ014 – Báo cáo tồn kho**

**1. Mô tả nghiệp vụ**

Chức năng báo cáo tồn kho cho phép người dùng có quyền (Admin, Manager, Pharmacist) xem báo cáo tồn kho, báo cáo thuốc sắp hết hàng, báo cáo thuốc sắp hết hạn và xuất báo cáo ra file Excel.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem báo cáo tồn kho với các thông tin: mã thuốc, tên thuốc, loại thuốc, số lượng tồn kho, đơn vị tính, hạn sử dụng.
- Hệ thống cho phép lọc báo cáo tồn kho theo loại thuốc, nhà sản xuất, tình trạng tồn kho (còn hàng, sắp hết, hết hàng), tình trạng hạn sử dụng (còn hạn, sắp hết hạn, hết hạn).
- Hệ thống cho phép xem báo cáo thuốc sắp hết hàng (số lượng tồn kho dưới ngưỡng cảnh báo).
- Hệ thống cho phép xem báo cáo thuốc sắp hết hạn (thời gian còn lại dưới ngưỡng cảnh báo).
- Hệ thống cho phép xuất báo cáo tồn kho ra file Excel.

      1. ### **SREQ015 – Báo cáo thuốc bán chạy**

**1. Mô tả nghiệp vụ**

Chức năng báo cáo thuốc bán chạy cho phép người dùng có quyền (Admin, Manager) xem báo cáo thuốc bán chạy theo ngày, tháng, quý, năm và xuất báo cáo ra file Excel.

**2. Yêu cầu chức năng**

- Hệ thống cho phép xem báo cáo thuốc bán chạy theo ngày, tháng, quý, năm với các thông tin: mã thuốc, tên thuốc, loại thuốc, số lượng bán ra, doanh thu, lợi nhuận.
- Hệ thống cho phép lọc báo cáo thuốc bán chạy theo khoảng thời gian, loại thuốc, nhà sản xuất.
- Hệ thống cho phép xem biểu đồ thuốc bán chạy theo thời gian.
- Hệ thống cho phép xuất báo cáo thuốc bán chạy ra file Excel.

1. # **CÁC YÊU CẦU PHI CHỨC NĂNG**
   1. ## **_Yêu cầu bảo mật_**

- Hệ thống sử dụng JWT (JSON Web Token) để xác thực người dùng.
- Mật khẩu người dùng được mã hóa bằng thuật toán BCrypt trước khi lưu vào cơ sở dữ liệu.
- Hệ thống áp dụng cơ chế phân quyền dựa trên vai trò (RBAC) để kiểm soát quyền truy cập vào các chức năng và tài nguyên.
- Hệ thống sử dụng HTTPS để mã hóa dữ liệu truyền tải giữa client và server.
- Hệ thống ghi lại lịch sử truy cập và các hoạt động quan trọng của người dùng.
- Hệ thống tự động đăng xuất người dùng sau 30 phút không hoạt động.
- Hệ thống giới hạn số lần đăng nhập thất bại liên tiếp (tối đa 5 lần) trước khi tạm khóa tài khoản.
- Hệ thống bảo vệ chống lại các cuộc tấn công phổ biến như SQL Injection, XSS, CSRF.

  1.  ## **_Yêu cầu sao lưu_**

- Hệ thống tự động sao lưu cơ sở dữ liệu hàng ngày vào lúc 2:00 AM.
- Dữ liệu sao lưu được lưu trữ trong ít nhất 30 ngày trước khi bị xóa.
- Hệ thống cho phép người quản trị (Admin) thực hiện sao lưu thủ công khi cần thiết.
- Hệ thống cho phép người quản trị (Admin) khôi phục dữ liệu từ bản sao lưu.
- Quá trình sao lưu không làm gián đoạn hoạt động của hệ thống.
- Hệ thống gửi thông báo cho người quản trị khi quá trình sao lưu thất bại.

  1.  ## **_Yêu cầu về tính sử dụng_**

- Giao diện người dùng thân thiện, dễ sử dụng, phù hợp với cả người dùng mới và người dùng có kinh nghiệm.
- Hệ thống hỗ trợ đa ngôn ngữ (Tiếng Việt và Tiếng Anh).
- Hệ thống cung cấp hướng dẫn sử dụng trực tuyến cho từng chức năng.
- Hệ thống hiển thị thông báo lỗi rõ ràng, dễ hiểu và gợi ý cách khắc phục.
- Hệ thống hỗ trợ các phím tắt để tăng tốc độ thao tác.
- Hệ thống tự động lưu các thao tác đang thực hiện để tránh mất dữ liệu khi gặp sự cố.
- Giao diện người dùng đáp ứng (responsive) trên các thiết bị khác nhau (máy tính, máy tính bảng, điện thoại).
- Thời gian đào tạo sử dụng hệ thống không quá 4 giờ đối với nhân viên và 1 giờ đối với khách hàng.

  1.  ## **_Yêu cầu về tính ổn định_**

- Hệ thống có tính sẵn sàng cao (99.9% uptime), hoạt động 24/7.
- Thời gian trung bình giữa hai sự cố (MTBF) tối thiểu là 720 giờ (30 ngày).
- Thời gian trung bình để khắc phục sự cố (MTTR) không quá 4 giờ.
- Hệ thống có khả năng tự phục hồi sau khi gặp sự cố.
- Hệ thống có cơ chế xử lý lỗi graceful, không làm crash toàn bộ hệ thống khi một phần gặp sự cố.
- Hệ thống có khả năng phát hiện và cảnh báo sớm các vấn đề tiềm ẩn.

  1.  ## **_Yêu cầu về hiệu năng_**

- Thời gian phản hồi trung bình của hệ thống không quá 2 giây cho các thao tác thông thường.
- Thời gian phản hồi tối đa không quá 5 giây cho các thao tác phức tạp (báo cáo, thống kê).
- Hệ thống có khả năng xử lý đồng thời ít nhất 100 người dùng.
- Hệ thống có khả năng xử lý ít nhất 1000 giao dịch mỗi giờ.
- Hệ thống có khả năng mở rộng để đáp ứng nhu cầu tăng trưởng trong tương lai.
- Thời gian khởi động hệ thống không quá 2 phút.
- Thời gian tạo báo cáo không quá 10 giây.

  1.  ## **_Yêu cầu về tính hỗ trợ_**

- Hệ thống được hỗ trợ 24/7 trong vòng 1 năm sau khi triển khai.
- Thời gian phản hồi hỗ trợ không quá 4 giờ làm việc đối với sự cố nghiêm trọng và 24 giờ làm việc đối với sự cố thông thường.
- Hệ thống cung cấp tài liệu hướng dẫn sử dụng đầy đủ và cập nhật.
- Hệ thống cung cấp tài liệu hướng dẫn cài đặt và cấu hình.
- Hệ thống cung cấp tài liệu hướng dẫn xử lý sự cố thường gặp.
- Hệ thống cung cấp cơ chế báo cáo lỗi tự động.

  1.  ## **_Các ràng buộc thiết kế_**

- Hệ thống được phát triển trên nền tảng web.
- Backend sử dụng ASP.NET Core.
- Frontend sử dụng ReactJS.
- Cơ sở dữ liệu sử dụng SQL Server.
- Hệ thống tuân thủ kiến trúc MVC (Model-View-Controller).
- Hệ thống sử dụng RESTful API để giao tiếp giữa client và server.
- Hệ thống sử dụng Entity Framework Core để tương tác với cơ sở dữ liệu.
- Hệ thống tuân thủ các nguyên tắc thiết kế SOLID.
- Mã nguồn được quản lý bằng Git.
- Hệ thống sử dụng JWT (JSON Web Token) để xác thực và phân quyền người dùng.

  1.  ## **_Yêu cầu về Giao tiếp_**

- Hệ thống hỗ trợ các trình duyệt phổ biến: Chrome, Firefox, Safari, Edge (phiên bản mới nhất và phiên bản trước đó).
- Hệ thống hỗ trợ các thiết bị có độ phân giải màn hình tối thiểu 320x568 (iPhone 5) trở lên.
- Hệ thống hỗ trợ giao tiếp với các hệ thống thanh toán trực tuyến thông qua API.
- Hệ thống hỗ trợ giao tiếp với các dịch vụ gửi email thông qua SMTP.
- Hệ thống hỗ trợ xuất dữ liệu ra các định dạng phổ biến: PDF, Excel, CSV.
- Hệ thống hỗ trợ nhập dữ liệu từ các định dạng phổ biến: Excel, CSV.

  1.  ## **_Các yêu cầu khác_**

- Hệ thống tuân thủ các quy định về dược phẩm và bảo vệ dữ liệu cá nhân.
- Hệ thống có khả năng tích hợp với các hệ thống khác trong tương lai.
- Hệ thống có khả năng nâng cấp và mở rộng mà không làm gián đoạn hoạt động.
- Hệ thống có khả năng hoạt động trong môi trường không có kết nối internet (offline mode) với một số chức năng cơ bản.
- Hệ thống có khả năng đồng bộ hóa dữ liệu khi kết nối internet được khôi phục.
