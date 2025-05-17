# HƯỚNG DẪN KIỂM THỬ CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 TỔNG QUAN

Tài liệu này cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử cho chức năng Quản lý thuốc trong hệ thống web bán và quản lý hiệu thuốc. Tài liệu được tổ chức theo quy trình kiểm thử, từ lập kế hoạch đến triển khai và báo cáo kết quả.

## 🗂️ CẤU TRÚC TÀI LIỆU

- **[Tai_Lieu_Kiem_Thu_Tong_Hop.md](./Tai_Lieu_Kiem_Thu_Tong_Hop.md)**: Tài liệu tổng hợp đầy đủ về kiểm thử chức năng Quản lý thuốc
- **[Ke_Hoach_Trien_Khai_Kiem_Thu.md](./Ke_Hoach_Trien_Khai_Kiem_Thu.md)**: Kế hoạch triển khai kiểm thử chi tiết
- **[Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)**: Hướng dẫn kiểm thử chức năng thêm thuốc
- **[Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)**: Hướng dẫn kiểm thử chức năng cập nhật và xóa thuốc
- **[Kiem_Thu_Chuc_Nang_Phan3.md](./Kiem_Thu_Chuc_Nang_Phan3.md)**: Hướng dẫn kiểm thử chức năng tìm kiếm thuốc

## 🚀 QUY TRÌNH TRIỂN KHAI KIỂM THỬ

### Giai đoạn 1: Chuẩn bị (Ngày 1)
- [x] **Đọc tài liệu**: Đọc [Tai_Lieu_Kiem_Thu_Tong_Hop.md](./Tai_Lieu_Kiem_Thu_Tong_Hop.md) (Phần 1-2) để hiểu tổng quan
- [x] **Chuẩn bị môi trường**:
  - [x] Cài đặt JUnit, Mockito cho kiểm thử Backend
  - [x] Cài đặt Cypress cho kiểm thử Frontend
  - [x] Cài đặt Postman cho kiểm thử API
  - [x] Chuẩn bị dữ liệu kiểm thử theo [Ke_Hoach_Trien_Khai_Kiem_Thu.md](./Ke_Hoach_Trien_Khai_Kiem_Thu.md)

### Giai đoạn 2: Kiểm thử đơn vị (Ngày 1-2)
- [ ] **Kiểm thử Service**:
  - [ ] ThuocService: Thêm, sửa, xóa, tìm kiếm
  - [ ] LoaiThuocService: Thêm, sửa, xóa, tìm kiếm
  - [ ] DanhMucThuocService: Thêm, sửa, xóa, tìm kiếm
- [ ] **Kiểm thử Controller**:
  - [ ] ThuocController: Thêm, sửa, xóa, tìm kiếm
  - [ ] LoaiThuocController: Thêm, sửa, xóa, tìm kiếm
  - [ ] DanhMucThuocController: Thêm, sửa, xóa, tìm kiếm
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử đơn vị

### Giai đoạn 3: Kiểm thử tích hợp (Ngày 2-3)
- [ ] **Kiểm thử tích hợp Backend**:
  - [ ] Kiểm thử tích hợp giữa các thành phần Backend
  - [ ] Kiểm thử API bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)
- [ ] **Kiểm thử tích hợp Frontend-Backend**:
  - [ ] Kiểm thử tích hợp giữa Frontend và Backend
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử tích hợp

### Giai đoạn 4: Kiểm thử chức năng (Ngày 3-4)
- [ ] **Kiểm thử chức năng thêm thuốc**:
  - [ ] Kiểm thử API thêm thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan1.md](./Kiem_Thu_Chuc_Nang_Phan1.md)
  - [ ] Kiểm thử chức năng thêm thuốc bằng Cypress
- [ ] **Kiểm thử chức năng cập nhật thuốc**:
  - [ ] Kiểm thử API cập nhật thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)
  - [ ] Kiểm thử chức năng cập nhật thuốc bằng Cypress
- [ ] **Kiểm thử chức năng xóa thuốc**:
  - [ ] Kiểm thử API xóa thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan2.md](./Kiem_Thu_Chuc_Nang_Phan2.md)
  - [ ] Kiểm thử chức năng xóa thuốc bằng Cypress
- [ ] **Kiểm thử chức năng tìm kiếm thuốc**:
  - [ ] Kiểm thử API tìm kiếm thuốc bằng Postman theo [Kiem_Thu_Chuc_Nang_Phan3.md](./Kiem_Thu_Chuc_Nang_Phan3.md)
  - [ ] Kiểm thử chức năng tìm kiếm thuốc bằng Cypress
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử chức năng

### Giai đoạn 5: Kiểm thử giao diện (Ngày 4-5)
- [ ] **Kiểm thử giao diện danh sách thuốc**
- [ ] **Kiểm thử giao diện thêm/sửa thuốc**
- [ ] **Kiểm thử giao diện chi tiết thuốc**
- [ ] **Kiểm thử giao diện tìm kiếm thuốc**
- [ ] **Kiểm thử tính responsive**
- [ ] **Sửa lỗi**: Sửa các lỗi phát hiện trong quá trình kiểm thử giao diện

### Giai đoạn 6: Kiểm thử hệ thống (Ngày 5)
- [ ] **Kiểm thử luồng nghiệp vụ (End-to-End Testing)**:
  - [ ] Luồng thêm thuốc mới
  - [ ] Luồng sửa thông tin thuốc
  - [ ] Luồng xóa thuốc
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
| Giai đoạn 1: Chuẩn bị | 100% | 17/05/2025 |
| Giai đoạn 2: Kiểm thử đơn vị | 0% | |
| Giai đoạn 3: Kiểm thử tích hợp | 0% | |
| Giai đoạn 4: Kiểm thử chức năng | 0% | |
| Giai đoạn 5: Kiểm thử giao diện | 0% | |
| Giai đoạn 6: Kiểm thử hệ thống | 0% | |
| Giai đoạn 7: Tổng hợp và báo cáo | 0% | |

## 🔍 TEST CASE QUAN TRỌNG

Dưới đây là danh sách các test case quan trọng cần ưu tiên thực hiện:

### Thêm thuốc
- TC_ADD_THUOC_001: Thêm thuốc với đầy đủ thông tin hợp lệ
- TC_ADD_THUOC_002: Thêm thuốc với mã thuốc đã tồn tại
- TC_ADD_THUOC_003: Thêm thuốc với tên thuốc đã tồn tại

### Cập nhật thuốc
- TC_UPDATE_THUOC_001: Cập nhật thuốc với đầy đủ thông tin hợp lệ
- TC_UPDATE_THUOC_002: Cập nhật thuốc với mã thuốc đã tồn tại

### Xóa thuốc
- TC_DELETE_THUOC_001: Xóa thuốc tồn tại
- TC_DELETE_THUOC_003: Xóa thuốc đã có trong đơn hàng

### Tìm kiếm thuốc
- TC_SEARCH_THUOC_001: Tìm kiếm thuốc theo tên
- TC_SEARCH_THUOC_003: Tìm kiếm thuốc theo loại thuốc

## 📝 LƯU Ý QUAN TRỌNG

1. **Ưu tiên theo chức năng**: Nếu thời gian hạn chế, hãy ưu tiên kiểm thử các chức năng quan trọng nhất (thêm, sửa, xóa, tìm kiếm thuốc) trước.

2. **Tự động hóa**: Tự động hóa càng nhiều kiểm thử càng tốt để tiết kiệm thời gian và đảm bảo tính nhất quán.

3. **Phát hiện lỗi sớm**: Cố gắng phát hiện lỗi càng sớm càng tốt trong quy trình kiểm thử, vì chi phí sửa lỗi sẽ tăng theo thời gian.

4. **Theo dõi lỗi**: Sử dụng công cụ quản lý lỗi để theo dõi các lỗi phát hiện và trạng thái xử lý.

5. **Cập nhật tài liệu**: Cập nhật tài liệu kiểm thử khi có thay đổi trong yêu cầu hoặc thiết kế.

## 📞 HỖ TRỢ

Nếu bạn gặp khó khăn trong quá trình triển khai kiểm thử, hãy liên hệ với:
- **Người phụ trách kiểm thử**: [Tên người phụ trách]
- **Email**: [Email người phụ trách]
- **Số điện thoại**: [Số điện thoại người phụ trách]
