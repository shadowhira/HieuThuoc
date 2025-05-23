# Kết quả kiểm thử bảo mật - Cross-Site Request Forgery (CSRF)

## Tổng quan

- **Tên kiểm thử:** Cross-Site Request Forgery (CSRF) Security Test
- **Ngày thực hiện:** 2023-05-26 11:45:30
- **Trạng thái:** **PASSED**
- **Mức độ rủi ro:** Thấp
- **Độ tin cậy:** Cao

## Mô tả kiểm thử

Kiểm thử này đánh giá khả năng chống lại các cuộc tấn công Cross-Site Request Forgery (CSRF) của ứng dụng bằng cách cố gắng giả mạo các yêu cầu đến các endpoint API từ một domain bên ngoài mà không có token CSRF hợp lệ.

## Kết quả kiểm thử

### 1. API Endpoint: POST /thuoc/create

**Trạng thái:** **PASSED**

**Mô tả:** Kiểm tra bảo vệ CSRF cho việc tạo sản phẩm mới

#### Các trường hợp kiểm thử

| Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|----------|------------------|-----------------|------------|
| Yêu cầu không có token CSRF | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |
| Yêu cầu với token CSRF không hợp lệ | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |
| Yêu cầu từ domain bên ngoài | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |

### 2. API Endpoint: PUT /thuoc/update

**Trạng thái:** **PASSED**

**Mô tả:** Kiểm tra bảo vệ CSRF cho việc cập nhật sản phẩm

#### Các trường hợp kiểm thử

| Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|----------|------------------|-----------------|------------|
| Yêu cầu không có token CSRF | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |
| Yêu cầu với token CSRF không hợp lệ | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |
| Yêu cầu từ domain bên ngoài | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |

### 3. API Endpoint: DELETE /thuoc/delete/{id}

**Trạng thái:** **PASSED**

**Mô tả:** Kiểm tra bảo vệ CSRF cho việc xóa sản phẩm

#### Các trường hợp kiểm thử

| Kịch bản | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|----------|------------------|-----------------|------------|
| Yêu cầu không có token CSRF | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |
| Yêu cầu với token CSRF không hợp lệ | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |
| Yêu cầu từ domain bên ngoài | Yêu cầu bị từ chối | 403 Forbidden, "CSRF token missing or invalid" | **PASSED** |

## Phát hiện

Ứng dụng đã triển khai đúng các cơ chế bảo vệ CSRF. Các biện pháp bảo mật sau đã được quan sát thấy:

- Token CSRF được yêu cầu cho tất cả các hoạt động thay đổi trạng thái
- Token CSRF được xác thực ở phía máy chủ
- Same-origin policy được thực thi
- Thuộc tính cookie SameSite được đặt thành 'Strict' hoặc 'Lax'

## Khuyến nghị

Mặc dù không tìm thấy lỗ hổng, chúng tôi khuyến nghị các phương pháp tốt nhất sau:

- Tiếp tục sử dụng token CSRF cho tất cả các hoạt động thay đổi trạng thái
- Triển khai xoay vòng token để tăng cường bảo mật
- Đặt thuộc tính cookie SameSite thành 'Strict' cho tất cả các cookie phiên
- Triển khai các header bảo mật bổ sung như X-Frame-Options và Content-Security-Policy

## Kết luận

Ứng dụng được bảo vệ tốt chống lại các cuộc tấn công Cross-Site Request Forgery (CSRF). Không phát hiện lỗ hổng trong quá trình kiểm thử.
