**HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG**  
**KHOA CÔNG NGHỆ THÔNG TIN 1**

**ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM**

**SQA PLAN**  
**TÊN DỰ ÁN: HỆ THỐNG BÁN THỨC ĂN CHĂN NUÔI**

**Giảng viên hướng dẫn:** Đỗ Thị Bích Ngọc  
**Nhóm lớp học:** 		05  
**Nhóm bài tập lớn:** 	08  
**Danh sách thành viên:**

1. Kiều Linh Trang 		\- B21DCCN716  
2. Nguyễn Hoàng Mạnh 	\- B21DCCN514  
3. Đỗ Hoành Thông 		\- B21DCCN116  
4. Trần Hoàng Tuấn Vũ 	\- B21DCCN800

**Hà Nội \- 5/2024**  
**1\. Giới thiệu**

1. **Phạm vi**  
- Thực hiện đảm bảo chất lượng cho hệ thống kinh doanh thức ăn chăn nuôi  
- Hoạt động cần thực hiện đảm bảo chất lượng:   
+ Kiểm thử giao diện (GUI)  
+ Kiểm thử chức năng   
+ Kiểm thử độ chính xác dữ liệu  
+ Kiểm thử hiệu năng  
- Hệ thống không bao gồm kiểm thử bảo mật  
  2. **Mục tiêu**

Tài liệu này nhằm mục đích lên kế hoạch đảm bảo chất lượng cho dự án phần mềm. Cụ thể:

- Giúp việc quản lý quá trình kiểm thử phần mềm một cách có hiệu quả.  
-  Giúp kiểm thử viên xác định được kế hoạch kiểm thử bao gồm: phạm vi kiểm thử của dự án.  
- Giúp quản lý dự án xác định được kế hoạch kiểm thử của đội kiểm thử nhằm ra quyết định cho các kế hoạch cho các công việc khác trong toàn bộ dự án.  
  3. **Tổng quan**  
- Hỗ trợ khách hàng chọn sản phẩm, tạo và thanh toán đơn hàng; xem lịch sử đơn hàng.  
- Hỗ trợ người quản trị quản lý người dùng, sản phẩm, đơn hàng, xem thống kê về đơn hàng, sản phẩm, nhà cung cấp.  
- Cung cấp danh sách các sản phẩm, thông tin chi tiết từng sản phẩm.  
    
2. **Tài liệu tham khảo**

| Tham khảo | Nguồn gốc | Nhận xét |
| ----- | ----- | ----- |
| Tài liệu đặc tả | Nhóm bài tập lớn 08 |  |
| Tài liệu mô tả tiêu chí McCall | Book:  Mastering Software Quality Assurance |  |
| Template SQA plan | Template SQA plan  (Mastering Software Quality Assurance) |  |
|  Template Test plan | Template Test plan  (Mastering Software Quality Assurance) |  |
| Checklist review giao diện (GUI) | GUIDELINES FOR GRAPHICAL USER INTERFACE QUALITY CONFORMANCE (Mastering Software Quality Assurance) |  |
| Checklist review negative test | GUIDELINES FOR NEGATIVE TESTING  (Mastering Software Quality Assurance) |  |
| Checklist review code | Checklist for code review  (Mastering Software Quality Assurance) |  |
| Checklist cho test plan và test case | Book:  Mastering Software Quality Assurance |  |
| Checklist cho Web test | [https://www.browserstack.com/guide/web-application-testing-checklist](https://www.browserstack.com/guide/web-application-testing-checklist) |  |
| Checklist cho System test | [https://www.browserstack.com/guide/web-application-testing-checklist](https://www.browserstack.com/guide/web-application-testing-checklist) |  |

3. **Định nghĩa và từ viết tắt**

| Từ viết tắt | Ý nghĩa |
| ----- | ----- |
| SQA | Đảm bảo chất lượng phần mềm |
| SQA plan | Kế hoạch đảm bảo chất lượng phần mềm |
| Test plan | Kế hoạch kiểm thử phần mềm |
| Testcase | Tài liệu dùng để mô tả : dữ liệu đầu vào, hành động, kết quả mong đợi để xác định một chức năng của ứng dụng có hoạt động đúng hay không |
| Checklist | Danh sách các yêu cầu để kiểm tra |
| GUI | Giao diện đồ họa người dùng |
| PM | Quản lý dự án (Project manager) |

4. **Vai trò và trách nhiệm thực hiện hoạt động đảm bảo**

| STT | Họ và tên | Nhiệm vụ |
| ----- | ----- | ----- |
| 1 | Kiều Linh Trang | \- Thực hiện phân công nhiệm vụ \- Xây dựng SQA plan \- Xây dựng Test plan \- Xây dựng các checklist test plan, test case, negative, system test \- Viết Unit test \- Xây dựng testcase \- Quản lý lỗi bằng Jira  |
| 2 | Nguyễn Hoàng Mạnh | \- Xây dựng đặc tả \- Xây dựng checklist user requirement \- Xây dựng checklist code \- Viết Unit test \- Xây dựng testcase \- Quản lý lỗi bằng Jira  \- Kiểm thử hiệu năng bằng Jmeter |
| 3 | Đỗ Hoành Thông | \- Xây dựng đặc tả \- Viết Unit test \- Xây dựng checklist code \- Viết Unit test \- Xây dựng testcase \- Quản lý lỗi bằng Jira \- Kiểm thử API bằng Postman |
| 4 | Trần Hoàng Tuấn Vũ | \- Xây dựng các checklist GUI, web test \- Viết Unit test \- Xây dựng testcase \- Quản lý lỗi bằng Jira  \- Kiểm thử API bằng Postman |

5. **Tiêu chuẩn và hướng dẫn**

| Project area | Tiêu chuẩn và hướng dẫn tương ứng |
| ----- | ----- |
| Xây dựng SQA plan | Template SQA plan  (Mastering Software Quality Assurance) |
| Xây dựng Test plan | Template Test plan  (Mastering Software Quality Assurance) |
| Checklist review giao diện (GUI) | Template Test plan  (Mastering Software Quality Assurance) |
| Checklist review negative test | GUIDELINES FOR GRAPHICAL USER INTERFACE QUALITY CONFORMANCE (Mastering Software Quality Assurance) |
| Checklist review code | GUIDELINES FOR NEGATIVE TESTING  (Mastering Software Quality Assurance) |
| Checklist cho test plan và test case | Checklist for code review  (Mastering Software Quality Assurance) |
| Checklist cho Web test | [https://www.browserstack.com/guide/web-application-testing-checklist](https://www.browserstack.com/guide/web-application-testing-checklist) |
| Checklist cho System test | [https://www.browserstack.com/guide/web-application-testing-checklist](https://www.browserstack.com/guide/web-application-testing-checklist) |

6. **Hoạt động đảm bảo chất lượng**  
   1. **Hoạt động rà soát dự án**

| Project artifact  | Loại đánh giá | Người đánh giá |
| ----- | ----- | ----- |
| Tài liệu yêu cầu | Inspection | Tester và PM |
| Mã nguồn (source code) | Inspection | Tech leader |
| Kế hoạch cho dự án | Inspection | PM |
| Kế hoạch kiểm thử | Inspection | Test Leader |
| Testcase | Inspection | Test leader và PM |

   2. **Chiến lược thử nghiệm được đề xuất**  
      1. Lựa chọn tester  
- Kiều Linh Trang  
- Trần Hoàng Tuấn Vũ  
- Nguyễn Hoàng Mạnh  
- Đỗ Hoành Thông  
    
  2. Môi trường kiểm thử  
- Kiểm thử trên môi trường phát triển phần mềm  
- Kiểm thử trên các trình duyệt Chrome  
    
  3. Tiêu chí đạt/không đạt  
- Tiêu chí đạt:   
+ Đối với luồng chức năng:   
* Chạy đúng luồng chức năng chuẩn trong đặc tả  
* Các ngoại lệ được xử lý đúng trong đặc tả  
+ Đối với giao diện:   
* Hiển thị thông tin đúng với các mô tả so với checklist review giao diện  
* Hiển thị thông tin đúng với các mô tả so với  checklist review negative test  
* Các thông báo theo chuẩn từ điển tiếng Việt  
- Tiêu chí không đạt:   
+ Đối với luồng chức năng:   
* Chạy sai luồng chức năng chuẩn trong đặc tả  
* Các ngoại lệ không được xử lý đúng trong đặc tả  
+ Đối với giao diện:   
* Hiển thị thông tin không đúng so với checklist review giao diện mà không có lý do chính đáng  
* Hiển thị thông tin không đúng so với checklist review negative test mà không có lý do chính đáng  
* Các thông báo không phải tiếng Việt, hoặc sai chính tả  
    
  4. Tiêu chí hoàn thành kiểm thử  
- Pass trên 95% testcase  
- Không phát hiện lỗi làm luồng nghiệp vụ trong đặc tả bị sai  
- Không có lỗi làm phần mềm ngừng hoạt động  
    
  5. Sử dụng công cụ kiểm thử

| STT | Công cụ | Chiến lược sử dụng |
| :---: | ----- | ----- |
| 1 | Word | Xây dựng đặc tả Xây dựng kế hoạch đảm bảo chất lượng |
| 2 | Excel | Xây dựng testcase Các checklist |
| 3 | JEST | Kiểm thử đơn vị |
| 4 | Postman | Kiểm thử API |
| 5 | Jmeter | Kiểm thử hiệu năng |

     6. Kế hoạch thiết kế testcase   
- Xây dựng testcase bằng các phương pháp kiểm thử hộp đen, bao gồm:  
+ Phân lớp tương đương  
+ Phân tích giá trị biên  
+ Bảng quyết định  
+ Kiểm thử chuyển đổi trạng thái  
+ Kiểm thử dựa trên trường hợp sử dụng  
    
  3. **Các kiểm thử được đề xuất cho dự án**

| Đơn vị  kiểm thử dự án | Loại kiểm thử được đề xuất | Môi trường kiểm thử | Người  kiểm thử | Tiêu chí (Đạt/ Không đạt) |
| ----- | ----- | ----- | ----- | ----- |
| Validate các trường thông tin | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra tính chính xác của dữ liệu | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra trường bắt buộc nhập dữ liệu | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra bảo mật về mật khẩu | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra khi nhập các ký tự số, chữ hoa, chữ thường, ký tự đặc biệt vào trường mật khẩu | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra hiển thị mật khẩu bị mã hoá | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra độ dài của tên đăng nhập, mật khẩu | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra hành động nhập tài khoản, mật khẩu | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Kiểm tra space đầu cuối dữ liệu trường tên đăng nhập | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Đăng nhập thành công | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Đăng nhập thất bại | Kiểm thử giao diện (Interface Testing)  | Môi trường phát triển phần mềm | Tester |  |
| Luồng Đặt hàng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng Đánh giá phản hồi | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng xem giỏ hàng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng thay đổi thông tin nhận hàng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng Huỷ đơn hàng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng tìm kiếm sản phẩm | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng xem/sửa/ xoá/ thêm người dùng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng xem/ sửa/ xoá/ thêm sản phẩm | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng cập nhật trạng thái đơn hàng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng thống kê đơn hàng | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng thêm/ sửa/ xoá/ xem danh mục | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| Luồng thêm/ sửa/ xoá/ xem nhà cung cấp | Kiểm thử chức năng (Functional Testing) | Môi trường phát triển phần mềm | Tester |  |
| … |  |  |  |  |


7. **Các số liệu đề xuất thu thập cho dự án**

| Các số liệu | Chỉ tiêu cho dự án | Phương sai cho phép | Chu kỳ báo cáo |
| ----- | ----- | ----- | ----- |
| Năng suất | 2 tháng hoàn thành | 1 tuần | Hàng tuần |
| Số lượng thành viên | 4 người | N/A | Hàng tuần |
| Phương sai lịch trình (tiến độ) | 1 tuần | 1-1.5 tuần | Hàng tuần |
| Phương sai nguồn lực  | 0 | 0 | Hàng tuần |
| Sự thay đổi | Hạn chế thay đổi, tiến hành theo tài liệu đặc tả | Sai sót ở mỗi pha sửa trong vòng 1 ngày | Hàng tuần |

**8\. Công cụ, công nghệ và phương pháp luận**  
**8.1. Kĩ thuật kiểm thử**

| STT | Kĩ thuật test | Mục tiêu |
| :---: | ----- | ----- |
| 1 | Phân vùng tương đương | Chia dữ liệu thành các vùng giá trị hợp lệ/ không hợp lệ để tiến hành viết test case |
| 2 | Kiểm thử biên | Xác định điểm biên |
| 3 | Kiểm thử dựa trên trường hợp sử dụng | Để đảm bảo các luồng chức năng chính mà người dùng sử dụng thực hiện đúng từ đầu tới cuối |
| 4 | Kiểm thử dựa trên bảng quyết định | Để đảm bảo kiểm tra các tổ hợp phức tạp của nhiều điều kiện đầu vào, ảnh hưởng tới kết quả (chức năng lọc) |
| 5 | Kiểm thử chuyển đổi trạng thái | Để xác minh hệ thống xử lý đúng các thay đổi trạng thái của đối tượng khi có các sự kiện xảy ra |

**8.2. Công cụ kiểm thử**

| STT | Công cụ | Tài liệu hướng dẫn |
| :---: | ----- | ----- |
| 1 | Word | Microsoft word product guide \- Microsoft |
| 2 | Excel | Microsoft excel product guide \- Microsoft |
| 3 | Jest |  |
| 4 | Postman | Postman Quick Reference Guide Documentation \- Valentin Despa |
| 5 | JMeter | Apache JMeter \- Emily H.Halili |

