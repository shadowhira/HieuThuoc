# PHÂN TÍCH LỖI CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Thời gian thực hiện**: 17/05/2025 - 22/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc

## 📊 BẢNG TỔNG HỢP LỖI

| ID | Mô tả lỗi | Mức độ nghiêm trọng | Loại lỗi | Giai đoạn phát hiện | Trạng thái | Ghi chú |
|----|-----------|---------------------|----------|---------------------|------------|---------|
| BUG_001 | Lỗi trạng thái khi danh sách trống | Thấp | Chức năng | Giai đoạn 2 | Đã sửa | Trả về trạng thái 200 thay vì 409 khi danh sách trống |
| BUG_002 | Lỗi StackOverflowError do quan hệ hai chiều | Cao | Chức năng | Giai đoạn 3 | Đã sửa | Sửa bằng cách thêm @JsonIgnore |
| BUG_003 | Lỗi thông báo không khớp | Thấp | Giao diện | Giai đoạn 4 | Đã sửa | Thống nhất thông báo lỗi |
| BUG_004 | Lỗi phương thức HTTP không đúng | Trung bình | Chức năng | Giai đoạn 3 | Đã sửa | Sửa phương thức HTTP cho multipart/form-data |

## 📈 PHÂN LOẠI LỖI

### Phân loại theo mức độ nghiêm trọng

| Mức độ nghiêm trọng | Số lượng | Tỷ lệ |
|---------------------|----------|-------|
| Nghiêm trọng (Critical) | 0 | 0% |
| Cao (High) | 1 | 25% |
| Trung bình (Medium) | 1 | 25% |
| Thấp (Low) | 2 | 50% |
| **Tổng cộng** | **4** | **100%** |

### Phân loại theo loại lỗi

| Loại lỗi | Số lượng | Tỷ lệ |
|----------|----------|-------|
| Lỗi chức năng (Functional) | 3 | 75% |
| Lỗi giao diện (UI) | 1 | 25% |
| Lỗi hiệu năng (Performance) | 0 | 0% |
| Lỗi bảo mật (Security) | 0 | 0% |
| Lỗi tương thích (Compatibility) | 0 | 0% |
| Lỗi khác (Other) | 0 | 0% |
| **Tổng cộng** | **4** | **100%** |

### Phân loại theo giai đoạn phát hiện

| Giai đoạn phát hiện | Số lượng | Tỷ lệ |
|---------------------|----------|-------|
| Giai đoạn 2: Kiểm thử đơn vị | 1 | 25% |
| Giai đoạn 3: Kiểm thử tích hợp | 2 | 50% |
| Giai đoạn 4: Kiểm thử chức năng | 1 | 25% |
| Giai đoạn 5: Kiểm thử giao diện | 0 | 0% |
| Giai đoạn 6: Kiểm thử hệ thống | 0 | 0% |
| **Tổng cộng** | **4** | **100%** |

### Phân loại theo trạng thái

| Trạng thái | Số lượng | Tỷ lệ |
|------------|----------|-------|
| Đã sửa | 4 | 100% |
| Đang sửa | 0 | 0% |
| Chưa sửa | 0 | 0% |
| Không sửa | 0 | 0% |
| **Tổng cộng** | **4** | **100%** |

## 📝 CHI TIẾT LỖI

### BUG_001: Lỗi trạng thái khi danh sách trống

**Mô tả chi tiết**: Khi danh sách thuốc trống, API trả về trạng thái 409 (Conflict) thay vì 200 (OK) với danh sách rỗng. Điều này gây nhầm lẫn cho frontend vì 409 thường được sử dụng cho các trường hợp xung đột dữ liệu.

**Mức độ nghiêm trọng**: Thấp

**Loại lỗi**: Chức năng

**Giai đoạn phát hiện**: Giai đoạn 2 (Kiểm thử đơn vị)

**Tác động**: Gây nhầm lẫn cho frontend khi xử lý phản hồi từ API, có thể dẫn đến hiển thị thông báo lỗi không chính xác cho người dùng.

**Nguyên nhân**: Trong ThuocService, phương thức getAll() kiểm tra nếu danh sách thuốc trống thì trả về ResponseDTO với status 409 thay vì 200.

**Giải pháp**: Sửa lại phương thức getAll() trong ThuocService để trả về ResponseDTO với status 200 và danh sách rỗng khi không có thuốc nào.

**Trạng thái**: Đã sửa

### BUG_002: Lỗi StackOverflowError do quan hệ hai chiều

**Mô tả chi tiết**: Khi serialize đối tượng Thuoc để trả về cho frontend, xảy ra lỗi StackOverflowError do quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc. Khi Jackson serialize DanhMucThuoc, nó sẽ serialize các LoaiThuoc liên quan, và mỗi LoaiThuoc lại serialize DanhMucThuoc của nó, tạo thành vòng lặp vô hạn.

**Mức độ nghiêm trọng**: Cao

**Loại lỗi**: Chức năng

**Giai đoạn phát hiện**: Giai đoạn 3 (Kiểm thử tích hợp)

**Tác động**: Gây crash ứng dụng khi serialize đối tượng, làm API không thể trả về dữ liệu cho frontend.

**Nguyên nhân**: Quan hệ hai chiều giữa DanhMucThuoc và LoaiThuoc không được xử lý đúng cách khi serialize.

**Giải pháp**: Thêm annotation @JsonIgnore cho thuộc tính danhMucThuoc trong lớp LoaiThuoc để ngăn Jackson serialize thuộc tính này, phá vỡ vòng lặp vô hạn.

**Trạng thái**: Đã sửa

### BUG_003: Lỗi thông báo không khớp

**Mô tả chi tiết**: Thông báo lỗi khi không tìm thấy loại thuốc không nhất quán giữa backend và frontend. Backend trả về "Loại thuốc không tồn tại" nhưng frontend hiển thị "Không tìm thấy loại thuốc".

**Mức độ nghiêm trọng**: Thấp

**Loại lỗi**: Giao diện

**Giai đoạn phát hiện**: Giai đoạn 4 (Kiểm thử chức năng)

**Tác động**: Gây nhầm lẫn cho người dùng khi xem thông báo lỗi.

**Nguyên nhân**: Không có sự thống nhất về nội dung thông báo lỗi giữa backend và frontend.

**Giải pháp**: Thống nhất nội dung thông báo lỗi giữa backend và frontend, sử dụng "Không tìm thấy loại thuốc" cho cả hai.

**Trạng thái**: Đã sửa

### BUG_004: Lỗi phương thức HTTP không đúng

**Mô tả chi tiết**: API cập nhật thuốc yêu cầu sử dụng phương thức PUT cho multipart/form-data, nhưng nhiều trình duyệt không hỗ trợ gửi dữ liệu multipart/form-data với phương thức PUT.

**Mức độ nghiêm trọng**: Trung bình

**Loại lỗi**: Chức năng

**Giai đoạn phát hiện**: Giai đoạn 3 (Kiểm thử tích hợp)

**Tác động**: Không thể cập nhật thuốc có hình ảnh trên một số trình duyệt, gây lỗi 405 Method Not Allowed.

**Nguyên nhân**: Sử dụng phương thức HTTP không phù hợp cho multipart/form-data.

**Giải pháp**: Thay đổi API cập nhật thuốc để sử dụng phương thức POST thay vì PUT, và thêm tham số _method=PUT để backend hiểu đây là yêu cầu cập nhật.

**Trạng thái**: Đã sửa

## 📝 PHÂN TÍCH XU HƯỚNG LỖI

### Xu hướng theo giai đoạn phát hiện

Phần lớn lỗi (75%) được phát hiện trong giai đoạn kiểm thử đơn vị và tích hợp, điều này cho thấy tầm quan trọng của việc kiểm thử sớm trong quy trình phát triển. Không có lỗi nào được phát hiện trong giai đoạn kiểm thử giao diện và hệ thống, điều này cho thấy các lỗi đã được phát hiện và sửa chữa kịp thời trong các giai đoạn trước.

### Xu hướng theo loại lỗi

Phần lớn lỗi (75%) là lỗi chức năng, điều này cho thấy cần tập trung hơn vào việc kiểm thử chức năng trong quá trình phát triển. Chỉ có 25% là lỗi giao diện, và không có lỗi hiệu năng, bảo mật hay tương thích nào được phát hiện.

### Xu hướng theo mức độ nghiêm trọng

Phần lớn lỗi (50%) có mức độ nghiêm trọng thấp, 25% có mức độ nghiêm trọng trung bình, và 25% có mức độ nghiêm trọng cao. Không có lỗi nào có mức độ nghiêm trọng nghiêm trọng (critical), điều này cho thấy hệ thống có chất lượng tốt.

## 📝 KẾT LUẬN

Dựa trên phân tích lỗi, chức năng Quản lý thuốc có chất lượng tốt với số lượng lỗi ít và không có lỗi nghiêm trọng nào. Tất cả các lỗi đã được phát hiện và sửa chữa kịp thời trong quá trình kiểm thử.

Phần lớn lỗi được phát hiện trong giai đoạn kiểm thử đơn vị và tích hợp, điều này cho thấy tầm quan trọng của việc kiểm thử sớm trong quy trình phát triển. Phần lớn lỗi là lỗi chức năng, điều này cho thấy cần tập trung hơn vào việc kiểm thử chức năng trong quá trình phát triển.

## 📎 TÀI LIỆU LIÊN QUAN

- [Báo cáo tiến độ giai đoạn 2](../../../giai-doan-2-unit-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_2.md)
- [Báo cáo tiến độ giai đoạn 3](../../../giai-doan-3-integration-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_3.md)
- [Báo cáo tiến độ giai đoạn 4](../../../giai-doan-4-functional-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_4.md)
- [Báo cáo tiến độ giai đoạn 5](../../../giai-doan-5-ui-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_5.md)
- [Báo cáo tiến độ giai đoạn 6](../../../giai-doan-6-system-test/bao-cao/Bao_Cao_Tien_Do_Giai_Doan_6.md)
