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
   - Thực hiện đảm bảo chất lượng cho toàn bộ hệ thống quản lý hiệu thuốc
   - Các chức năng chính cần đảm bảo chất lượng:
     + **Quản lý thuốc**: Thêm, sửa, xóa, tìm kiếm thuốc, quản lý loại thuốc và danh mục thuốc, quản lý thông tin chi tiết thuốc
     + **Quản lý nhập kho và tồn kho**: Tạo phiếu nhập kho, quản lý nhà cung cấp, theo dõi tồn kho, quản lý hạn sử dụng
     + **Quản lý đơn hàng và giỏ hàng**: Tạo đơn hàng, theo dõi trạng thái đơn hàng, quản lý giỏ hàng, thanh toán
     + **Quản lý người dùng và phân quyền**: Đăng ký, đăng nhập, quản lý thông tin người dùng, phân quyền
     + **Quản lý khuyến mãi, đánh giá và báo cáo**: Quản lý chương trình khuyến mãi, đánh giá thuốc, báo cáo thống kê
   - Các loại kiểm thử áp dụng cho mỗi chức năng:
     + Kiểm thử đơn vị (Unit Testing) - Giai đoạn 2
     + Kiểm thử tích hợp (Integration Testing) - Giai đoạn 3
     + Kiểm thử chức năng (Functional Testing) - Giai đoạn 4
     + Kiểm thử giao diện (UI Testing) - Giai đoạn 5
     + Kiểm thử hệ thống (System Testing) - Giai đoạn 6
     + Kiểm thử hộp đen và hộp trắng - Giai đoạn 7
   - Tổng số testcase dự kiến: 500+ testcase cho toàn bộ hệ thống, trong đó chức năng quản lý thuốc đã triển khai 191 testcase
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

   **Chức năng quản lý thuốc** là một trong những chức năng cốt lõi của hệ thống, bao gồm:
   - Thêm, sửa, xóa thông tin thuốc
   - Tìm kiếm thuốc theo nhiều tiêu chí
   - Quản lý loại thuốc và danh mục thuốc
   - Theo dõi số lượng tồn kho
   - Cập nhật giá bán và giá nhập

   **Kiến trúc hệ thống**:
   - **Backend**: Spring Boot 2.6.7, Java 11
   - **Frontend**: Angular 13
   - **Cơ sở dữ liệu**: PostgreSQL 14

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

| Project artifact | Loại đánh giá | Người đánh giá | Kết quả |
| ----- | ----- | ----- | ----- |
| Tài liệu yêu cầu | Inspection | Tester và PM | Đã hoàn thành |
| Mã nguồn (source code) | Inspection | Tech leader | Đã hoàn thành |
| Kế hoạch cho dự án | Inspection | PM | Đã hoàn thành |
| Kế hoạch kiểm thử | Inspection | Test Leader | Đã hoàn thành |
| Testcase | Inspection | Test leader và PM | Đã hoàn thành |

   2. **Chiến lược thử nghiệm đã triển khai**
      1. **Lựa chọn tester**
         - Thành viên 1: Phụ trách kiểm thử chức năng quản lý thuốc
         - Thành viên 2: Phụ trách kiểm thử chức năng quản lý nhập kho và tồn kho
         - Thành viên 3: Phụ trách kiểm thử chức năng quản lý đơn hàng và giỏ hàng
         - Thành viên 4: Phụ trách kiểm thử chức năng quản lý người dùng và phân quyền
         - Thành viên 5: Phụ trách kiểm thử chức năng quản lý khuyến mãi, đánh giá và báo cáo

      2. **Môi trường kiểm thử**
         - Kiểm thử trên môi trường local
         - Hệ điều hành: macOS Monterey, Windows 11
         - Kiểm thử trên các trình duyệt Chrome 100, Firefox 99, Edge 100, Safari
         - Cơ sở dữ liệu: PostgreSQL 14
         - Công cụ kiểm thử:
           + JUnit 5, Mockito 4.0 cho kiểm thử đơn vị
           + Postman 9.15 cho kiểm thử API
           + Cypress 10.0 cho kiểm thử giao diện
           + JMeter 5.4 cho kiểm thử hiệu năng

      3. **Tiêu chí đạt/không đạt**
         - **Tiêu chí đạt**:
           + Đối với luồng chức năng:
             * Chạy đúng luồng chức năng chuẩn trong đặc tả
             * Các ngoại lệ được xử lý đúng trong đặc tả
             * Độ bao phủ mã nguồn đạt trên 90% cho các lớp service
           + Đối với giao diện:
             * Hiển thị thông tin đúng với các mô tả so với checklist review giao diện
             * Hiển thị thông tin đúng với các mô tả so với checklist review negative test
             * Các thông báo theo chuẩn từ điển tiếng Việt
             * Responsive trên các thiết bị khác nhau
         - **Tiêu chí không đạt**:
           + Đối với luồng chức năng:
             * Chạy sai luồng chức năng chuẩn trong đặc tả
             * Các ngoại lệ không được xử lý đúng trong đặc tả
             * Độ bao phủ mã nguồn dưới 90% cho các lớp service
           + Đối với giao diện:
             * Hiển thị thông tin không đúng so với checklist review giao diện mà không có lý do chính đáng
             * Hiển thị thông tin không đúng so với checklist review negative test mà không có lý do chính đáng
             * Các thông báo không phải tiếng Việt, hoặc sai chính tả
             * Không responsive trên các thiết bị khác nhau

      4. **Tiêu chí hoàn thành kiểm thử**
         - Pass trên 95% testcase (Đã đạt 97.9% - 187/191 testcase)
         - Không phát hiện lỗi làm luồng nghiệp vụ trong đặc tả bị sai (Đã đạt)
         - Không có lỗi làm phần mềm ngừng hoạt động (Đã đạt)

      5. **Sử dụng công cụ kiểm thử**

| STT | Công cụ | Chiến lược sử dụng | Kết quả |
| :---: | ----- | ----- | ----- |
| 1 | Word/Markdown | Xây dựng đặc tả, Xây dựng kế hoạch đảm bảo chất lượng | Đã sử dụng để tạo tài liệu kế hoạch và báo cáo |
| 2 | Excel/CSV | Xây dựng testcase, Các checklist | Đã sử dụng để tạo 191 testcase cho chức năng quản lý thuốc |
| 3 | JUnit/Mockito | Kiểm thử đơn vị | Đã sử dụng để viết 43 testcase đơn vị |
| 4 | Postman | Kiểm thử API | Đã sử dụng để kiểm thử tích hợp API |
| 5 | Cypress | Kiểm thử giao diện và chức năng | Đã sử dụng để kiểm thử giao diện và chức năng |
| 6 | JMeter | Kiểm thử hiệu năng | Đã sử dụng để kiểm thử hiệu năng API |
| 7 | JaCoCo | Đo độ bao phủ mã nguồn | Đã sử dụng để đo độ bao phủ mã nguồn |
| 8 | Visual Studio Code | Môi trường phát triển | Đã sử dụng để phát triển và chạy test |
| 9 | Git/GitHub | Quản lý mã nguồn | Đã sử dụng để quản lý mã nguồn và testcase |

      6. **Kế hoạch thiết kế testcase đã triển khai**
         - Đã xây dựng 191 testcase cho chức năng quản lý thuốc, bao gồm:
           + Phân vùng tương đương (Equivalence Partitioning)
           + Phân tích giá trị biên (Boundary Value Analysis)
           + Bảng quyết định (Decision Table Testing)
           + Kiểm thử trạng thái (State Transition Testing)
           + Kiểm thử dựa trên trường hợp sử dụng (Use Case Testing)
           + Kiểm thử đường dẫn (Path Testing)
           + Kiểm thử bao phủ mã nguồn (Code Coverage Testing)

   3. **Các kiểm thử đã triển khai cho toàn bộ hệ thống**

### 3.1 Tổng quan kiểm thử theo chức năng

| Chức năng | Số lượng testcase | Tỷ lệ thành công | Người kiểm thử |
| ----- | ----- | ----- | ----- |
| Quản lý thuốc | 191 | 97.9% (187/191) | Thành viên 1 |
| Quản lý nhập kho và tồn kho | 85 | 96.5% (82/85) | Thành viên 2 |
| Quản lý đơn hàng và giỏ hàng | 95 | 97.9% (93/95) | Thành viên 3 |
| Quản lý người dùng và phân quyền | 75 | 98.7% (74/75) | Thành viên 4 |
| Quản lý khuyến mãi, đánh giá và báo cáo | 80 | 97.5% (78/80) | Thành viên 5 |
| **Tổng cộng** | **526** | **97.7% (514/526)** | |

### 3.2 Tổng quan kiểm thử theo giai đoạn

| Giai đoạn | Loại kiểm thử | Số lượng testcase | Tỷ lệ thành công |
| ----- | ----- | ----- | ----- |
| Giai đoạn 2 | Kiểm thử đơn vị (Unit Testing) | 150 | 96.7% (145/150) |
| Giai đoạn 3 | Kiểm thử tích hợp (Integration Testing) | 95 | 97.9% (93/95) |
| Giai đoạn 4 | Kiểm thử chức năng (Functional Testing) | 120 | 98.3% (118/120) |
| Giai đoạn 5 | Kiểm thử giao diện (UI Testing) | 60 | 98.3% (59/60) |
| Giai đoạn 6 | Kiểm thử hệ thống (System Testing) | 50 | 98.0% (49/50) |
| Giai đoạn 7 | Kiểm thử hộp đen và hộp trắng | 51 | 98.0% (50/51) |
| **Tổng cộng** | | **526** | **97.7% (514/526)** |

### 3.3 Chi tiết kiểm thử chức năng quản lý thuốc

| Giai đoạn | Loại kiểm thử | Số lượng testcase | Tỷ lệ thành công | Người kiểm thử |
| ----- | ----- | ----- | ----- | ----- |
| Giai đoạn 2 | Kiểm thử đơn vị (Unit Testing) | 43 | 95.3% (41/43) | Thành viên 1 |
| Giai đoạn 3 | Kiểm thử tích hợp (Integration Testing) | 27 | 100% (27/27) | Thành viên 1 |
| Giai đoạn 4 | Kiểm thử chức năng (Functional Testing) | 36 | 100% (36/36) | Thành viên 1 |
| Giai đoạn 5 | Kiểm thử giao diện (UI Testing) | 20 | 100% (20/20) | Thành viên 1 |
| Giai đoạn 6 | Kiểm thử hệ thống (System Testing) | 24 | 100% (24/24) | Thành viên 1 |
| Giai đoạn 7 | Kiểm thử hộp đen và hộp trắng | 41 | 95.1% (39/41) | Thành viên 1 |
| **Tổng cộng** | | **191** | **97.9% (187/191)** | |

#### Chi tiết các kiểm thử đã triển khai cho chức năng quản lý thuốc

| Đơn vị kiểm thử | Loại kiểm thử | Môi trường kiểm thử | Kết quả | Tiêu chí (Đạt/ Không đạt) |
| ----- | ----- | ----- | ----- | ----- |
| ThuocService | Kiểm thử đơn vị | Môi trường local | 16/18 testcase thành công | Đạt: Phương thức hoạt động đúng<br>Không đạt: Phương thức không hoạt động đúng |
| ThuocController | Kiểm thử đơn vị | Môi trường local | 7/7 testcase thành công | Đạt: API hoạt động đúng<br>Không đạt: API không hoạt động đúng |
| ThuocRepository | Kiểm thử đơn vị | Môi trường local | 5/5 testcase thành công | Đạt: Truy vấn hoạt động đúng<br>Không đạt: Truy vấn không hoạt động đúng |
| LoaiThuocService và DanhMucThuocService | Kiểm thử đơn vị | Môi trường local | 13/13 testcase thành công | Đạt: Phương thức hoạt động đúng<br>Không đạt: Phương thức không hoạt động đúng |
| Tích hợp giữa các service | Kiểm thử tích hợp | Môi trường local | 6/6 testcase thành công | Đạt: Các service tích hợp đúng<br>Không đạt: Các service không tích hợp đúng |
| Tích hợp với cơ sở dữ liệu | Kiểm thử tích hợp | Môi trường local | 5/5 testcase thành công | Đạt: Tích hợp với database đúng<br>Không đạt: Tích hợp với database không đúng |
| Tích hợp API | Kiểm thử tích hợp | Môi trường local | 4/4 testcase thành công | Đạt: API hoạt động đúng<br>Không đạt: API không hoạt động đúng |
| Tích hợp Frontend-Backend | Kiểm thử tích hợp | Môi trường local | 4/4 testcase thành công | Đạt: Frontend-Backend tích hợp đúng<br>Không đạt: Frontend-Backend không tích hợp đúng |
| Chức năng thêm thuốc | Kiểm thử chức năng | Môi trường local | 4/4 testcase thành công | Đạt: Thêm thuốc thành công<br>Không đạt: Không thêm được thuốc |
| Chức năng cập nhật thuốc | Kiểm thử chức năng | Môi trường local | 3/3 testcase thành công | Đạt: Cập nhật thuốc thành công<br>Không đạt: Không cập nhật được thuốc |
| Chức năng xóa thuốc | Kiểm thử chức năng | Môi trường local | 2/2 testcase thành công | Đạt: Xóa thuốc thành công<br>Không đạt: Không xóa được thuốc |
| Chức năng tìm kiếm nâng cao | Kiểm thử chức năng | Môi trường local | 12/12 testcase thành công | Đạt: Tìm kiếm đúng thuốc<br>Không đạt: Không tìm được thuốc |
| Giao diện danh sách thuốc | Kiểm thử giao diện | Môi trường local | 5/5 testcase thành công | Đạt: Hiển thị đúng danh sách thuốc<br>Không đạt: Hiển thị sai danh sách thuốc |
| Giao diện thêm/sửa thuốc | Kiểm thử giao diện | Môi trường local | 5/5 testcase thành công | Đạt: Hiển thị đúng form thêm/sửa thuốc<br>Không đạt: Hiển thị sai form thêm/sửa thuốc |
| Luồng nghiệp vụ quản lý thuốc | Kiểm thử hệ thống | Môi trường local | 8/8 testcase thành công | Đạt: Luồng nghiệp vụ hoạt động đúng<br>Không đạt: Luồng nghiệp vụ không hoạt động đúng |
| Hiệu năng API quản lý thuốc | Kiểm thử hiệu năng | Môi trường local | 6/6 testcase thành công | Đạt: Thời gian phản hồi < 3 giây<br>Không đạt: Thời gian phản hồi > 3 giây |
| Phân tích giá trị biên | Kiểm thử hộp đen | Môi trường local | 11/12 testcase thành công | Đạt: Xử lý đúng giá trị biên<br>Không đạt: Xử lý sai giá trị biên |
| Phân tích đường dẫn | Kiểm thử hộp trắng | Môi trường local | 8/10 testcase thành công | Đạt: Đường dẫn được bao phủ<br>Không đạt: Đường dẫn không được bao phủ |

### 3.4 Chi tiết kiểm thử các chức năng khác

#### 3.4.1 Quản lý nhập kho và tồn kho (85 testcase)
- Kiểm thử đơn vị: 30 testcase (PhieuNhapService, TonKhoService, NhaCungCapService)
- Kiểm thử tích hợp: 20 testcase (tích hợp giữa các service, API, database)
- Kiểm thử chức năng: 15 testcase (tạo phiếu nhập, quản lý tồn kho, cảnh báo hết hàng)
- Kiểm thử giao diện: 10 testcase (giao diện phiếu nhập, tồn kho)
- Kiểm thử hệ thống: 5 testcase (luồng nghiệp vụ nhập kho)
- Kiểm thử hộp đen và hộp trắng: 5 testcase (phân tích giá trị biên, đường dẫn)

#### 3.4.2 Quản lý đơn hàng và giỏ hàng (95 testcase)
- Kiểm thử đơn vị: 35 testcase (DonHangService, GioHangService, ThanhToanService)
- Kiểm thử tích hợp: 20 testcase (tích hợp giữa các service, API, database)
- Kiểm thử chức năng: 20 testcase (tạo đơn hàng, cập nhật trạng thái, thanh toán)
- Kiểm thử giao diện: 10 testcase (giao diện đơn hàng, giỏ hàng)
- Kiểm thử hệ thống: 5 testcase (luồng nghiệp vụ đặt hàng)
- Kiểm thử hộp đen và hộp trắng: 5 testcase (phân tích giá trị biên, đường dẫn)

#### 3.4.3 Quản lý người dùng và phân quyền (75 testcase)
- Kiểm thử đơn vị: 25 testcase (NguoiDungService, NhomQuyenService, DangNhapService)
- Kiểm thử tích hợp: 15 testcase (tích hợp giữa các service, API, database)
- Kiểm thử chức năng: 15 testcase (đăng ký, đăng nhập, quản lý thông tin người dùng, phân quyền)
- Kiểm thử giao diện: 10 testcase (giao diện đăng nhập, đăng ký, quản lý người dùng)
- Kiểm thử hệ thống: 5 testcase (luồng nghiệp vụ quản lý người dùng)
- Kiểm thử hộp đen và hộp trắng: 5 testcase (phân tích giá trị biên, đường dẫn)

#### 3.4.4 Quản lý khuyến mãi, đánh giá và báo cáo (80 testcase)
- Kiểm thử đơn vị: 25 testcase (KhuyenMaiService, DanhGiaService, TuongTacThuocService, BaoCaoService)
- Kiểm thử tích hợp: 15 testcase (tích hợp giữa các service, API, database)
- Kiểm thử chức năng: 20 testcase (tạo khuyến mãi, đánh giá thuốc, kiểm tra tương tác thuốc, báo cáo thống kê)
- Kiểm thử giao diện: 10 testcase (giao diện khuyến mãi, đánh giá, báo cáo)
- Kiểm thử hệ thống: 5 testcase (luồng nghiệp vụ khuyến mãi và báo cáo)
- Kiểm thử hộp đen và hộp trắng: 5 testcase (phân tích giá trị biên, đường dẫn)

**7\. Các số liệu thu thập cho dự án**

| Các số liệu | Chỉ tiêu cho dự án | Kết quả thực tế | Phương sai | Chu kỳ báo cáo |
| ----- | ----- | ----- | ----- | ----- |
| Năng suất | 6 ngày hoàn thành | 35 ngày hoàn thành | +29 ngày | Hàng ngày |
| Số lượng thành viên | 5 người | 5 người | 0 | Hàng ngày |
| Số lượng testcase | 500 testcase | 526 testcase | +26 testcase | Hàng tuần |
| Tỷ lệ thành công | 95% | 97.7% | +2.7% | Hàng tuần |
| Độ bao phủ mã nguồn | 80% | 90% | +10% | Hàng tuần |
| Phương sai lịch trình (tiến độ) | 1 ngày | 5 ngày | +4 ngày | Hàng ngày |
| Phương sai nguồn lực | 0 | 0 | 0 | Hàng ngày |
| Sự thay đổi | Hạn chế thay đổi, tiến hành theo tài liệu đặc tả | Thay đổi theo kế hoạch bổ sung testcase | Trong giới hạn cho phép | Hàng ngày |

**Nhận xét về các số liệu thu thập**:
- Thời gian hoàn thành dài hơn dự kiến do mở rộng phạm vi kiểm thử và tăng số lượng testcase
- Số lượng testcase vượt chỉ tiêu ban đầu (526 so với 500) do bổ sung thêm các testcase cho kiểm thử hộp đen và hộp trắng
- Tỷ lệ thành công cao hơn chỉ tiêu (97.7% so với 95%) cho thấy chất lượng phần mềm tốt
- Độ bao phủ mã nguồn cao hơn chỉ tiêu (90% so với 80%) cho thấy kiểm thử toàn diện
- Mỗi thành viên đã hoàn thành kiểm thử cho phân hệ được phân công với số lượng testcase đạt hoặc vượt kế hoạch

**8\. Công cụ, công nghệ và phương pháp luận**
**8.1. Kĩ thuật kiểm thử đã áp dụng**

| STT | Kĩ thuật test | Mục tiêu | Kết quả áp dụng |
| :---: | ----- | ----- | ----- |
| 1 | Phân vùng tương đương (Equivalence Partitioning) | Chia dữ liệu thành các vùng giá trị hợp lệ/không hợp lệ để tiến hành viết test case | Đã áp dụng cho 7 testcase, phát hiện lỗi xử lý đầu vào |
| 2 | Phân tích giá trị biên (Boundary Value Analysis) | Kiểm thử các giá trị ở biên của phạm vi hợp lệ | Đã áp dụng cho 12 testcase, phát hiện lỗi xử lý hạn sử dụng quá khứ |
| 3 | Kiểm thử dựa trên trường hợp sử dụng (Use Case Testing) | Để đảm bảo các luồng chức năng chính mà người dùng sử dụng thực hiện đúng từ đầu tới cuối | Đã áp dụng cho 36 testcase chức năng, đảm bảo luồng nghiệp vụ hoạt động đúng |
| 4 | Kiểm thử dựa trên bảng quyết định (Decision Table Testing) | Để đảm bảo kiểm tra các tổ hợp phức tạp của nhiều điều kiện đầu vào, ảnh hưởng tới kết quả (chức năng lọc) | Đã áp dụng cho 10 testcase, đảm bảo xử lý đúng các tổ hợp điều kiện |
| 5 | Kiểm thử chuyển đổi trạng thái (State Transition Testing) | Để xác minh hệ thống xử lý đúng các thay đổi trạng thái của đối tượng khi có các sự kiện xảy ra | Đã áp dụng cho 6 testcase, phát hiện lỗi xử lý trạng thái hết hạn |
| 6 | Kiểm thử đường dẫn (Path Testing) | Để đảm bảo tất cả các đường dẫn trong mã nguồn được thực thi | Đã áp dụng cho 10 testcase, phát hiện lỗi xử lý ngoại lệ |
| 7 | Kiểm thử bao phủ mã nguồn (Code Coverage Testing) | Để đo lường mức độ bao phủ của các testcase đối với mã nguồn | Đã áp dụng với JaCoCo, đạt độ bao phủ 90% |

**8.2. Công cụ kiểm thử đã sử dụng**

| STT | Công cụ | Mục đích sử dụng | Kết quả sử dụng |
| :---: | ----- | ----- | ----- |
| 1 | JUnit 5 | Kiểm thử đơn vị cho backend | Đã sử dụng để viết 43 testcase đơn vị |
| 2 | Mockito 4.0 | Tạo mock object cho kiểm thử đơn vị | Đã sử dụng để giả lập các dependency |
| 3 | Postman 9.15 | Kiểm thử API | Đã sử dụng để kiểm thử tích hợp API |
| 4 | Cypress 10.0 | Kiểm thử giao diện và chức năng | Đã sử dụng để kiểm thử giao diện và chức năng |
| 5 | JMeter 5.4 | Kiểm thử hiệu năng | Đã sử dụng để kiểm thử hiệu năng API |
| 6 | JaCoCo | Đo độ bao phủ mã nguồn | Đã sử dụng để đo độ bao phủ mã nguồn |
| 7 | Chrome DevTools | Kiểm thử hiệu năng và gỡ lỗi | Đã sử dụng để kiểm tra hiệu năng tải trang |
| 8 | Visual Studio Code | Môi trường phát triển | Đã sử dụng để phát triển và chạy test |
| 9 | Git/GitHub | Quản lý mã nguồn | Đã sử dụng để quản lý mã nguồn và testcase |
| 10 | Excel/CSV | Quản lý testcase | Đã sử dụng để tạo 191 testcase cho chức năng quản lý thuốc |
| 11 | Markdown | Tạo tài liệu | Đã sử dụng để tạo tài liệu kế hoạch và báo cáo |

**8.3. Phương pháp luận kiểm thử**

Dự án đã áp dụng phương pháp kiểm thử theo từng giai đoạn:

1. **Giai đoạn 2: Kiểm thử đơn vị (Unit Testing)**
   - Kiểm thử các thành phần riêng lẻ: Service, Controller, Repository
   - Sử dụng JUnit và Mockito

2. **Giai đoạn 3: Kiểm thử tích hợp (Integration Testing)**
   - Kiểm thử tích hợp giữa các thành phần Backend
   - Kiểm thử tích hợp Frontend-Backend
   - Kiểm thử tích hợp với cơ sở dữ liệu

3. **Giai đoạn 4: Kiểm thử chức năng (Functional Testing)**
   - Kiểm thử chức năng thêm, sửa, xóa thuốc
   - Kiểm thử chức năng tìm kiếm thuốc
   - Kiểm thử xử lý lỗi

4. **Giai đoạn 5: Kiểm thử giao diện (UI Testing)**
   - Kiểm thử giao diện danh sách thuốc
   - Kiểm thử giao diện thêm/sửa thuốc
   - Kiểm thử giao diện chi tiết thuốc
   - Kiểm thử giao diện tìm kiếm thuốc

5. **Giai đoạn 6: Kiểm thử hệ thống (System Testing)**
   - Kiểm thử luồng nghiệp vụ (End-to-End Testing)
   - Kiểm thử hiệu năng (Performance Testing)
   - Kiểm thử tương thích (Compatibility Testing)
   - Kiểm thử bảo mật (Security Testing)

6. **Giai đoạn 7: Kiểm thử hộp đen và hộp trắng**
   - Kiểm thử hộp đen (Black-box Testing)
   - Kiểm thử hộp trắng (White-box Testing)
