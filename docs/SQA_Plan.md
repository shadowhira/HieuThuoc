**HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG**
**KHOA CÔNG NGHỆ THÔNG TIN**

**ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM**

**SQA PLAN**
**TÊN DỰ ÁN: HỆ THỐNG QUẢN LÝ HIỆU THUỐC**

**Giảng viên hướng dẫn:** Đỗ Thị Bích Ngọc
**Nhóm lớp học:** 		05
**Nhóm bài tập lớn:** 	08
**Danh sách thành viên:**

1. Thành viên 1
2. Thành viên 2
3. Thành viên 3
4. Thành viên 4
5. Thành viên 5

**Hà Nội \- 7/2024**

**1\. Giới thiệu**

1. **Phạm vi**
   - Thực hiện đảm bảo chất lượng cho hệ thống quản lý hiệu thuốc
   - Hoạt động cần thực hiện đảm bảo chất lượng:
     + Kiểm thử giao diện (GUI)
     + Kiểm thử chức năng
     + Kiểm thử độ chính xác dữ liệu
     + Kiểm thử hiệu năng
     + Kiểm thử tương tác thuốc
   - Hệ thống không bao gồm kiểm thử bảo mật chuyên sâu

2. **Mục tiêu**

   Tài liệu này nhằm mục đích lên kế hoạch đảm bảo chất lượng cho dự án phần mềm. Cụ thể:

   - Giúp việc quản lý quá trình kiểm thử phần mềm một cách có hiệu quả.
   - Giúp kiểm thử viên xác định được kế hoạch kiểm thử bao gồm: phạm vi kiểm thử của dự án.
   - Giúp quản lý dự án xác định được kế hoạch kiểm thử của đội kiểm thử nhằm ra quyết định cho các kế hoạch cho các công việc khác trong toàn bộ dự án.

3. **Tổng quan**
   - Hỗ trợ khách hàng tìm kiếm thuốc, xem thông tin chi tiết thuốc, thêm vào giỏ hàng, tạo và thanh toán đơn hàng; xem lịch sử đơn hàng.
   - Hỗ trợ người quản trị quản lý thuốc, loại thuốc, danh mục thuốc, nhà sản xuất, nhà cung cấp, đơn hàng, phiếu nhập, tồn kho.
   - Hỗ trợ người quản trị quản lý người dùng, phân quyền, xem thống kê về đơn hàng, sản phẩm, nhà cung cấp.
   - Cung cấp chức năng kiểm tra tương tác thuốc giữa các hoạt chất.
   - Quản lý khuyến mãi, đánh giá thuốc và báo cáo thống kê.

**2\. Tài liệu tham khảo**

| Tham khảo | Nguồn gốc | Nhận xét |
| ----- | ----- | ----- |
| Tài liệu đặc tả | Nhóm bài tập lớn |  |
| Tài liệu mô tả tiêu chí McCall | Book: Mastering Software Quality Assurance |  |
| Template SQA plan | Template SQA plan (Mastering Software Quality Assurance) |  |
| Template Test plan | Template Test plan (Mastering Software Quality Assurance) |  |
| Checklist review giao diện (GUI) | GUIDELINES FOR GRAPHICAL USER INTERFACE QUALITY CONFORMANCE |  |
| Checklist review negative test | GUIDELINES FOR NEGATIVE TESTING |  |
| Checklist review code | Checklist for code review |  |
| Checklist cho test plan và test case | Book: Mastering Software Quality Assurance |  |
| Checklist cho Web test | https://www.browserstack.com/guide/web-application-testing-checklist |  |
| Checklist cho System test | https://www.browserstack.com/guide/web-application-testing-checklist |  |

**3\. Định nghĩa và từ viết tắt**

| Từ viết tắt | Ý nghĩa |
| ----- | ----- |
| SQA | Đảm bảo chất lượng phần mềm (Software Quality Assurance) |
| SQA plan | Kế hoạch đảm bảo chất lượng phần mềm |
| Test plan | Kế hoạch kiểm thử phần mềm |
| Testcase | Tài liệu dùng để mô tả: dữ liệu đầu vào, hành động, kết quả mong đợi để xác định một chức năng của ứng dụng có hoạt động đúng hay không |
| Checklist | Danh sách các yêu cầu để kiểm tra |
| GUI | Giao diện đồ họa người dùng (Graphical User Interface) |
| PM | Quản lý dự án (Project Manager) |
| API | Giao diện lập trình ứng dụng (Application Programming Interface) |
| BE | Backend - Phần xử lý phía máy chủ |
| FE | Frontend - Phần giao diện người dùng |

**4\. Vai trò và trách nhiệm thực hiện hoạt động đảm bảo**

| STT | Thành viên | Nhiệm vụ |
| ----- | ----- | ----- |
| 1 | Thành viên 1 | - Kiểm thử chức năng quản lý thuốc<br>- Xây dựng SQA plan<br>- Xây dựng Test plan<br>- Xây dựng các checklist test plan, test case<br>- Viết Unit test cho ThuocController, ThuocService<br>- Xây dựng testcase<br>- Quản lý lỗi |
| 2 | Thành viên 2 | - Kiểm thử chức năng quản lý nhập kho và tồn kho<br>- Xây dựng đặc tả<br>- Xây dựng checklist code<br>- Viết Unit test cho PhieuNhapController, TonKhoController, NhaCungCapController<br>- Xây dựng testcase<br>- Quản lý lỗi<br>- Kiểm thử hiệu năng |
| 3 | Thành viên 3 | - Kiểm thử chức năng quản lý đơn hàng và giỏ hàng<br>- Xây dựng đặc tả<br>- Viết Unit test cho DonHangController, GioHangController, ThanhToanController<br>- Xây dựng testcase<br>- Quản lý lỗi<br>- Kiểm thử API |
| 4 | Thành viên 4 | - Kiểm thử chức năng quản lý người dùng và phân quyền<br>- Xây dựng các checklist GUI, web test<br>- Viết Unit test cho NguoiDungController, NhomQuyenController, DangNhapController<br>- Xây dựng testcase<br>- Quản lý lỗi<br>- Kiểm thử API |
| 5 | Thành viên 5 | - Kiểm thử chức năng quản lý khuyến mãi, đánh giá và báo cáo<br>- Xây dựng các checklist GUI, web test<br>- Viết Unit test cho KhuyenMaiController, DanhGiaController, TuongTacThuocController, BaoCaoController<br>- Xây dựng testcase<br>- Quản lý lỗi<br>- Kiểm thử API |

**5\. Tiêu chuẩn và hướng dẫn**

| Project area | Tiêu chuẩn và hướng dẫn tương ứng |
| ----- | ----- |
| Xây dựng SQA plan | Template SQA plan (Mastering Software Quality Assurance) |
| Xây dựng Test plan | Template Test plan (Mastering Software Quality Assurance) |
| Checklist review giao diện (GUI) | GUIDELINES FOR GRAPHICAL USER INTERFACE QUALITY CONFORMANCE |
| Checklist review negative test | GUIDELINES FOR NEGATIVE TESTING |
| Checklist review code | Checklist for code review |
| Checklist cho test plan và test case | Book: Mastering Software Quality Assurance |
| Checklist cho Web test | https://www.browserstack.com/guide/web-application-testing-checklist |
| Checklist cho System test | https://www.browserstack.com/guide/web-application-testing-checklist |

**6\. Hoạt động đảm bảo chất lượng**
   1. **Hoạt động rà soát dự án**

| Project artifact | Loại đánh giá | Người đánh giá |
| ----- | ----- | ----- |
| Tài liệu yêu cầu | Inspection | Tester và PM |
| Mã nguồn (source code) | Inspection | Tech leader |
| Kế hoạch cho dự án | Inspection | PM |
| Kế hoạch kiểm thử | Inspection | Test Leader |
| Testcase | Inspection | Test leader và PM |

   2. **Chiến lược thử nghiệm được đề xuất**
      1. **Lựa chọn tester**
         - Thành viên 1
         - Thành viên 2
         - Thành viên 3
         - Thành viên 4
         - Thành viên 5

      2. **Môi trường kiểm thử**
         - Kiểm thử trên môi trường local
         - Hệ điều hành: macOS, Windows 11
         - Kiểm thử trên các trình duyệt Chrome, Firefox, Edge, Safari
         - Cơ sở dữ liệu: PostgreSQL

      3. **Tiêu chí đạt/không đạt**
         - **Tiêu chí đạt**:
           + Đối với luồng chức năng:
             * Chạy đúng luồng chức năng chuẩn trong đặc tả
             * Các ngoại lệ được xử lý đúng trong đặc tả
           + Đối với giao diện:
             * Hiển thị thông tin đúng với các mô tả so với checklist review giao diện
             * Hiển thị thông tin đúng với các mô tả so với checklist review negative test
             * Các thông báo theo chuẩn từ điển tiếng Việt
         - **Tiêu chí không đạt**:
           + Đối với luồng chức năng:
             * Chạy sai luồng chức năng chuẩn trong đặc tả
             * Các ngoại lệ không được xử lý đúng trong đặc tả
           + Đối với giao diện:
             * Hiển thị thông tin không đúng so với checklist review giao diện mà không có lý do chính đáng
             * Hiển thị thông tin không đúng so với checklist review negative test mà không có lý do chính đáng
             * Các thông báo không phải tiếng Việt, hoặc sai chính tả

      4. **Tiêu chí hoàn thành kiểm thử**
         - Pass trên 95% testcase
         - Không phát hiện lỗi làm luồng nghiệp vụ trong đặc tả bị sai
         - Không có lỗi làm phần mềm ngừng hoạt động

      5. **Sử dụng công cụ kiểm thử**

| STT | Công cụ | Chiến lược sử dụng |
| :---: | ----- | ----- |
| 1 | Word/Markdown | Xây dựng đặc tả, Xây dựng kế hoạch đảm bảo chất lượng |
| 2 | Excel/CSV | Xây dựng testcase, Các checklist |
| 3 | JUnit/Jest | Kiểm thử đơn vị |
| 4 | Postman | Kiểm thử API |
| 5 | Chrome DevTools | Kiểm thử hiệu năng |
| 6 | Visual Studio Code | Môi trường phát triển |
| 7 | Git/GitHub | Quản lý mã nguồn |

      6. **Kế hoạch thiết kế testcase**
         - Xây dựng testcase bằng các phương pháp kiểm thử hộp đen, bao gồm:
           + Phân lớp tương đương
           + Phân tích giá trị biên
           + Bảng quyết định
           + Kiểm thử chuyển đổi trạng thái
           + Kiểm thử dựa trên trường hợp sử dụng

   3. **Các kiểm thử được đề xuất cho dự án**

| Đơn vị kiểm thử dự án | Loại kiểm thử được đề xuất | Môi trường kiểm thử | Người kiểm thử | Tiêu chí (Đạt/ Không đạt) |
| ----- | ----- | ----- | ----- | ----- |
| Validate các trường thông tin thuốc | Kiểm thử giao diện (Interface Testing) | Môi trường local | Thành viên 1 | Đạt: Hiển thị đúng thông báo lỗi khi nhập sai<br>Không đạt: Không hiển thị thông báo hoặc cho phép nhập sai |
| Kiểm tra tính chính xác của dữ liệu thuốc | Kiểm thử giao diện (Interface Testing) | Môi trường local | Thành viên 1 | Đạt: Hiển thị đúng thông tin thuốc<br>Không đạt: Hiển thị sai thông tin |
| Kiểm tra trường bắt buộc nhập dữ liệu | Kiểm thử giao diện (Interface Testing) | Môi trường local | Thành viên 1 | Đạt: Không cho phép bỏ trống trường bắt buộc<br>Không đạt: Cho phép bỏ trống |
| Kiểm tra bảo mật về mật khẩu | Kiểm thử giao diện (Interface Testing) | Môi trường local | Thành viên 4 | Đạt: Mật khẩu được mã hóa<br>Không đạt: Mật khẩu không được mã hóa |
| Kiểm tra khi nhập các ký tự đặc biệt vào trường mật khẩu | Kiểm thử giao diện (Interface Testing) | Môi trường local | Thành viên 4 | Đạt: Xử lý đúng các ký tự đặc biệt<br>Không đạt: Xử lý sai |
| Kiểm tra hiển thị mật khẩu bị mã hoá | Kiểm thử giao diện (Interface Testing) | Môi trường local | Thành viên 4 | Đạt: Mật khẩu hiển thị dạng ẩn<br>Không đạt: Mật khẩu hiển thị dạng văn bản |
| Đăng nhập thành công | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 4 | Đạt: Đăng nhập thành công với tài khoản hợp lệ<br>Không đạt: Không đăng nhập được |
| Đăng nhập thất bại | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 4 | Đạt: Hiển thị thông báo lỗi khi đăng nhập sai<br>Không đạt: Không hiển thị thông báo |
| Luồng tạo phiếu nhập | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 2 | Đạt: Tạo phiếu nhập thành công<br>Không đạt: Không tạo được phiếu nhập |
| Luồng kiểm tra tồn kho | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 2 | Đạt: Hiển thị đúng số lượng tồn kho<br>Không đạt: Hiển thị sai số lượng |
| Luồng Đặt hàng | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 3 | Đạt: Đặt hàng thành công<br>Không đạt: Không đặt được hàng |
| Luồng xem giỏ hàng | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 3 | Đạt: Hiển thị đúng giỏ hàng<br>Không đạt: Hiển thị sai giỏ hàng |
| Luồng Huỷ đơn hàng | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 3 | Đạt: Hủy đơn hàng thành công<br>Không đạt: Không hủy được đơn hàng |
| Luồng tìm kiếm thuốc | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 1 | Đạt: Tìm kiếm đúng thuốc<br>Không đạt: Không tìm được thuốc |
| Luồng xem/sửa/xoá/thêm người dùng | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 4 | Đạt: Thực hiện đúng chức năng<br>Không đạt: Không thực hiện được |
| Luồng xem/sửa/xoá/thêm thuốc | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 1 | Đạt: Thực hiện đúng chức năng<br>Không đạt: Không thực hiện được |
| Luồng cập nhật trạng thái đơn hàng | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 3 | Đạt: Cập nhật đúng trạng thái<br>Không đạt: Không cập nhật được |
| Luồng thống kê đơn hàng | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 5 | Đạt: Hiển thị đúng thống kê<br>Không đạt: Hiển thị sai thống kê |
| Luồng thêm/sửa/xoá/xem danh mục thuốc | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 1 | Đạt: Thực hiện đúng chức năng<br>Không đạt: Không thực hiện được |
| Luồng thêm/sửa/xoá/xem nhà cung cấp | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 2 | Đạt: Thực hiện đúng chức năng<br>Không đạt: Không thực hiện được |
| Kiểm tra tương tác thuốc | Kiểm thử chức năng (Functional Testing) | Môi trường local | Thành viên 5 | Đạt: Hiển thị đúng thông tin tương tác<br>Không đạt: Hiển thị sai thông tin |
| Kiểm tra hiệu năng tìm kiếm thuốc | Kiểm thử hiệu năng (Performance Testing) | Môi trường local | Thành viên 2 | Đạt: Thời gian phản hồi < 3 giây<br>Không đạt: Thời gian phản hồi > 3 giây |
| Kiểm tra hiệu năng tải trang chủ | Kiểm thử hiệu năng (Performance Testing) | Môi trường local | Thành viên 2 | Đạt: Thời gian tải < 3 giây<br>Không đạt: Thời gian tải > 3 giây |

**7\. Các số liệu đề xuất thu thập cho dự án**

| Các số liệu | Chỉ tiêu cho dự án | Phương sai cho phép | Chu kỳ báo cáo |
| ----- | ----- | ----- | ----- |
| Năng suất | 6 ngày hoàn thành | 1 ngày | Hàng ngày |
| Số lượng thành viên | 5 người | N/A | Hàng ngày |
| Phương sai lịch trình (tiến độ) | 1 ngày | 1-2 ngày | Hàng ngày |
| Phương sai nguồn lực | 0 | 0 | Hàng ngày |
| Sự thay đổi | Hạn chế thay đổi, tiến hành theo tài liệu đặc tả | Sai sót ở mỗi pha sửa trong vòng 1 ngày | Hàng ngày |

**8\. Công cụ, công nghệ và phương pháp luận**
**8.1. Kĩ thuật kiểm thử**

| STT | Kĩ thuật test | Mục tiêu |
| :---: | ----- | ----- |
| 1 | Phân vùng tương đương | Chia dữ liệu thành các vùng giá trị hợp lệ/không hợp lệ để tiến hành viết test case |
| 2 | Kiểm thử biên | Xác định điểm biên |
| 3 | Kiểm thử dựa trên trường hợp sử dụng | Để đảm bảo các luồng chức năng chính mà người dùng sử dụng thực hiện đúng từ đầu tới cuối |
| 4 | Kiểm thử dựa trên bảng quyết định | Để đảm bảo kiểm tra các tổ hợp phức tạp của nhiều điều kiện đầu vào, ảnh hưởng tới kết quả (chức năng lọc) |
| 5 | Kiểm thử chuyển đổi trạng thái | Để xác minh hệ thống xử lý đúng các thay đổi trạng thái của đối tượng khi có các sự kiện xảy ra |

**8.2. Công cụ kiểm thử**

| STT | Công cụ | Tài liệu hướng dẫn |
| :---: | ----- | ----- |
| 1 | Word/Markdown | Microsoft word product guide - Microsoft |
| 2 | Excel/CSV | Microsoft excel product guide - Microsoft |
| 3 | JUnit/Jest | Jest Documentation |
| 4 | Postman | Postman Quick Reference Guide Documentation |
| 5 | Chrome DevTools | Chrome DevTools Documentation |
| 6 | Visual Studio Code | Visual Studio Code Documentation |
| 7 | Git/GitHub | Git Documentation |
