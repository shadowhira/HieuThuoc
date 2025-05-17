**HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG**  
**KHOA CÔNG NGHỆ THÔNG TIN 1**

**ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM**

**TEST PLAN**  
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
**KẾ HOẠCH KIỂM THỬ DỰ ÁN**

**Project ID:** 08\_SQA

**Lịch sử sửa đổi test plan**

| Version | Mô tả bản phát hành và sửa đổi | Người chuẩn bị | Người phê duyệt | Ngày phê duyệt |
| :---: | ----- | ----- | ----- | ----- |
| v1.0 | Phiên bản test plan đầu tiên | Kiều Linh Trang | Trần Hoàng Tuấn Vũ |  |

**Tài liệu tham khảo**

| STT | Tài liệu tham khảo | Nguồn gốc | Ghi chú |
| ----- | ----- | ----- | ----- |
| 1 | Đặc tả yêu cầu dự án | Nhóm dự án |  |
| 2 | Template Test plan | Template Test plan \- Mastering Software Quality Assurance \- Trang 150 |  |
| 3 | Template System Test | [https://youtu.be/M2wdI8QIABE?feature=shared](https://youtu.be/M2wdI8QIABE?feature=shared) |  |

**Môi trường kiểm thử phần mềm**

- Môi trường server  
+ Hệ điều hành: Ubuntu 22.04 LTS  
+ RAM: 8 GB  
+ Vi xử lý: Intel Xeon / AMD Ryzen 5 trở lên  
+ Bộ nhớ: SSD 100 GB trở lên  
- Môi trường client  
+ Hệ điều hành: Windows 10 / 11 hoặc macOS  
+ RAM: 8 GB  
+ Vi xử lý: Intel Core i5 / Apple M1 trở lên  
+ Bộ nhớ: SSD 50 GB trở lên  
- Hệ quản trị cơ sở dữ liệu: MySQL Workbench  
- Trình duyệt: Chrome

**Mục tiêu kiểm thử phần mềm:** 

- Đối với chức năng luồng nghiệp vụ:  
+ Chạy đúng luồng chức năng chuẩn trong đặc tả  
+ Các ngoại lệ được xử lý đúng trong đặc tả  
- Đối với giao diện:  
+ Hiển thị thông tin đúng với các mô tả so với checklist review giao diện  
+ Hiển thị thông tin đúng với các mô tả so với  checklist review negative test  
+ Các thông báo theo chuẩn từ điển tiếng Việt


**Chuẩn bị Testcase**

| Test | Người chịu trách nhiệm chuẩn bị | Người thực hiện review | Lịch hoàn thành |
| ----- | ----- | ----- | ----- |
| Unit Test | Nhóm 8 | Trần Hoàng Tuấn Vũ | 11/4/2025 |
| Integration test | Nhóm 8 | Nguyễn Hoàng Mạnh | 18/4/2025 |
| System test | Nhóm 8 | Kiều Linh Trang | 24/4/2025 |
| Acceptance testing | Nhóm 8 | Đỗ Hoành Thông | 9/5/2025 |

**Các loại kiểm thử được tiến hành cho dự án**

| Test | Người thực hiện kiểm thử | Mục tiêu kiểm thử | Cách kiểm thử | Tiêu chí hoàn thành |
| ----- | ----- | ----- | ----- | ----- |
| Unit Test | Nhóm 8 | Kiểm tra, ghi nhận và phân tích kết quả của những vùng được cô lập, nhanh chóng rà soát được nguyên nhân của lỗi | Sử dụng testcase và kiểm thử hộp trắng được cung cấp bởi IDE |  |
| Integration test | Nhóm 8 | Đảm bảo module vẫn hoạt động bình thường khi được tích hợp | Tại mọi thời điểm, các unit tích hợp với nhau không bị lỗi khi thực hiện kiểm thử black box hoặc testcase   | Pass trên 95% các testcase được đưa ra |
| System test | Nhóm 8 | Đảm bảo chương trình vẫn hoạt động bình thường trên các môi trường khác nhau | Sử dụng các system test testcase | Pass trên 95% tiêu chí được đưa ra trong check list system test |

**Công cụ hỗ trợ kiểm thử**

| Công cụ | Mục đích | Người sử dụng | Tài liệu tham khảo |
| ----- | ----- | ----- | ----- |
| Word | Xây dựng test plan Xây dựng đặc tả | Kiều Linh Trang Đỗ Hoành Thông Nguyễn Hoàng Mạnh | Microsoft word product guide \- Microsoft |
| Excel  | Xây dựng checklist review giao diện (GUI) Xây dựng checklist negative test Xây dựng checklist review code Xây dựng checklist cho testplan và testcase Xây dựng checklist cho Web test Xây dựng checklist cho system test Xây dựng testcase | Nhóm 8 | Microsoft excel product guide \- Microsoft |
| Jest | Kiểm thử đơn vị | Nhóm 8 |  |
| Postman | Kiểm thử API | Trần Hoàng Tuấn Vũ Đỗ Hoành Thông  | Postman Quick Reference Guide Documentation \- Valentin Despa |
| Jmeter | Kiểm thử hiệu năng | Nguyễn Hoàng Mạnh | Apache JMeter \- Emily H.Halili |

**Những rủi ro được xác định**

| STT | Mô tả rủi ro | Xác suất xảy ra | Kế hoạch khắc phục |
| ----- | ----- | ----- | ----- |
| 1 | Testcase chưa bao phủ hết các lỗi | 17% \- 20% | Tester và người thực hiện review testcase xem xét lại testcase của dự án |
| 2 | Unit test chưa đảm bảo độ bao phủ | 30% \- 35% | Backend developer và người thực hiện review unit test cần kiểm tra lại các unit test để tăng độ phủ |
| 3 | Cơ sở hạ tầng không đầy đủ | 45% \- 50% | Đề nghị và thương lượng đầu tư tài chính cho cơ sở hạ tầng |

**Danh sách miễn trừ:**

1. Không thực hiện review phân tích thiết kế do không có tài liệu phân tích thiết kế  
2. Không thực hiện kiểm thử bảo mật do không được yêu cầu

