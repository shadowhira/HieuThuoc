# HƯỚNG DẪN KIỂM THỬ CHỨC NĂNG QUẢN LÝ NGƯỜI DÙNG VÀ PHÂN QUYỀN

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử cho chức năng Quản lý người dùng và phân quyền trong hệ thống web bán và quản lý hiệu thuốc. Tài liệu được tổ chức theo quy trình kiểm thử, từ lập kế hoạch đến triển khai và báo cáo kết quả.

## 🗂️ CẤU TRÚC TÀI LIỆU

- **[Tai_Lieu_Kiem_Thu_Tong_Hop.md](./Tai_Lieu_Kiem_Thu_Tong_Hop.md)**: Tài liệu tổng hợp đầy đủ về kiểm thử chức năng Quản lý người dùng và phân quyền
- **[Ke_Hoach_Trien_Khai_Kiem_Thu.md](./Ke_Hoach_Trien_Khai_Kiem_Thu.md)**: Kế hoạch triển khai kiểm thử chi tiết
- **[Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)**: Hướng dẫn kiểm thử chức năng quản lý người dùng
- **[Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)**: Hướng dẫn kiểm thử chức năng quản lý nhóm quyền
- **[Kiem_Thu_Chuc_Nang_Phan3.md](./Kiem_Thu_Chuc_Nang_Phan3.md)**: Hướng dẫn kiểm thử chức năng phân quyền người dùng

## 🚀 QUY TRÌNH TRIỂN KHAI KIỂM THỬ

### Giai đoạn 1: Chuẩn bị (Ngày 1)
- [x] **Đọc tài liệu**: Đọc [Tai_Lieu_Kiem_Thu_Tong_Hop.md](./Tai_Lieu_Kiem_Thu_Tong_Hop.md) (Phần 1-2) để hiểu tổng quan
- [ ] **Chuẩn bị môi trường**:
  - [ ] Cài đặt JUnit, Mockito cho kiểm thử Backend
  - [ ] Cài đặt Cypress cho kiểm thử Frontend
  - [ ] Cài đặt Postman cho kiểm thử API
  - [ ] Chuẩn bị dữ liệu kiểm thử theo [Ke_Hoach_Trien_Khai_Kiem_Thu.md](./Ke_Hoach_Trien_Khai_Kiem_Thu.md)

### Giai đoạn 2: Kiểm thử đơn vị (Ngày 1-2)
- [ ] **Kiểm thử Service**:
  - [ ] NguoiDungService: Thêm, sửa, xóa, tìm kiếm
  - [ ] NhomQuyenService: Thêm, sửa, xóa, tìm kiếm
  - [ ] ChucNangService: Thêm, sửa, xóa, tìm kiếm
- [ ] **Kiểm thử Controller**:
  - [ ] NguoiDungController: Thêm, sửa, xóa, tìm kiếm
  - [ ] NhomQuyenController: Thêm, sửa, xóa, tìm kiếm
  - [ ] ChucNangController: Thêm, sửa, xóa, tìm kiếm
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử đơn vị

### Giai đoạn 3: Kiểm thử tích hợp (Ngày 2-3)
- [ ] **Kiểm thử tích hợp Backend**:
  - [ ] Kiểm thử tích hợp giữa các thành phần Backend
  - [ ] Kiểm thử API bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)
- [ ] **Kiểm thử tích hợp Frontend-Backend**:
  - [ ] Kiểm thử tích hợp giữa Frontend và Backend
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử tích hợp

### Giai đoạn 4: Kiểm thử chức năng (Ngày 3-4)
- [ ] **Kiểm thử chức năng quản lý người dùng**:
  - [ ] Kiểm thử API quản lý người dùng bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)
  - [ ] Kiểm thử chức năng quản lý người dùng bằng Cypress
- [ ] **Kiểm thử chức năng quản lý nhóm quyền**:
  - [ ] Kiểm thử API quản lý nhóm quyền bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)
  - [ ] Kiểm thử chức năng quản lý nhóm quyền bằng Cypress
- [ ] **Kiểm thử chức năng phân quyền người dùng**:
  - [ ] Kiểm thử API phân quyền người dùng bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan3.md](./Kiem_Thu_Chuc_Nang_Phan3.md)
  - [ ] Kiểm thử chức năng phân quyền người dùng bằng Cypress
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử chức năng

### Giai đoạn 5: Kiểm thử giao diện (Ngày 4-5)
- [ ] **Kiểm thử giao diện danh sách người dùng**
- [ ] **Kiểm thử giao diện thêm/sửa người dùng**
- [ ] **Kiểm thử giao diện danh sách nhóm quyền**
- [ ] **Kiểm thử giao diện phân quyền**
- [ ] **Kiểm thử tính responsive**
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử giao diện

### Giai đoạn 6: Kiểm thử hệ thống (Ngày 5)
- [ ] **Kiểm thử luồng nghiệp vụ (End-to-End Testing)**:
  - [ ] Luồng thêm người dùng mới
  - [ ] Luồng phân quyền cho người dùng
  - [ ] Luồng kiểm tra quyền truy cập
- [ ] **Kiểm thử hiệu năng (Performance Testing)**:
  - [ ] Chuẩn bị JMeter Test Plan
  - [ ] Chạy kiểm thử hiệu năng
- [ ] **Kiểm thử tương thích (Compatibility Testing)**:
  - [ ] Kiểm thử trên các trình duyệt khác nhau
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử hệ thống

### Giai đoạn 7: Tổng hợp và báo cáo (Ngày 6)
- [ ] **Tổng hợp kết quả kiểm thử**
- [ ] **Phân tích lỗi**
- [ ] **Đề xuất cải tiến**
- [ ] **Viết báo cáo kiểm thử**

## 📊 THEO DÕI TIẾN ĐỘ

| Giai đoạn | Tiến độ | Ngày hoàn thành |
|-----------|---------|-----------------|
| Giai đoạn 1: Chuẩn bị | 0% | |
| Giai đoạn 2: Kiểm thử đơn vị | 0% | |
| Giai đoạn 3: Kiểm thử tích hợp | 0% | |
| Giai đoạn 4: Kiểm thử chức năng | 0% | |
| Giai đoạn 5: Kiểm thử giao diện | 0% | |
| Giai đoạn 6: Kiểm thử hệ thống | 0% | |
| Giai đoạn 7: Tổng hợp và báo cáo | 0% | |

## 🔍 TEST CASE QUAN TRỌNG

Dưới đây là danh sách các test case quan trọng cần ưu tiên thực hiện:

### Quản lý người dùng
- TC_ADD_USER_001: Thêm người dùng với đầy đủ thông tin hợp lệ
- TC_ADD_USER_002: Thêm người dùng với email đã tồn tại
- TC_ADD_USER_003: Thêm người dùng với username đã tồn tại

### Quản lý nhóm quyền
- TC_ADD_ROLE_001: Thêm nhóm quyền mới
- TC_UPDATE_ROLE_001: Cập nhật quyền cho nhóm quyền
- TC_DELETE_ROLE_001: Xóa nhóm quyền

### Phân quyền người dùng
- TC_ASSIGN_ROLE_001: Gán nhóm quyền cho người dùng
- TC_REVOKE_ROLE_001: Thu hồi quyền từ người dùng
- TC_CHECK_PERMISSION_001: Kiểm tra quyền truy cập chức năng

## 📝 LƯU Ý QUAN TRỌNG

1. **Ưu tiên theo chức năng**: Nếu thời gian hạn chế, hãy ưu tiên kiểm thử các chức năng quan trọng nhất (quản lý người dùng, phân quyền) trước.

2. **Tự động hóa**: Tự động hóa càng nhiều kiểm thử càng tốt để tiết kiệm thời gian và đảm bảo tính nhất quán.

3. **Phát hiện lỗi sớm**: Cố gắng phát hiện lỗi càng sớm càng tốt trong quy trình kiểm thử, vì chi phí sửa lỗi sẽ tăng theo thời gian.

4. **Theo dõi lỗi**: Sử dụng công cụ quản lý lỗi để theo dõi các lỗi phát hiện và trạng thái xử lý.

5. **Cập nhật tài liệu**: Cập nhật tài liệu kiểm thử khi có thay đổi trong yêu cầu hoặc thiết kế.

## 📞 HỖ TRỢ

Nếu bạn gặp khó khăn trong quá trình triển khai kiểm thử, hãy liên hệ với:
- **Người phụ trách kiểm thử**: [Tên người phụ trách]
- **Email**: [Email người phụ trách]
- **Số điện thoại**: [Số điện thoại người phụ trách]
