# Kết quả kiểm thử bảng quyết định (Decision Table Testing)

## DT_001: Kiểm thử bảng quyết định cho việc thêm thuốc

### Mô tả
Kiểm thử các trường hợp trong bảng quyết định cho việc thêm thuốc.

### Bảng quyết định

| Điều kiện | Trường hợp 1 | Trường hợp 2 | Trường hợp 3 | Trường hợp 4 |
|-----------|-------------|-------------|-------------|-------------|
| Mã thuốc đã tồn tại | F | T | F | F |
| Tên thuốc đã tồn tại | F | F | T | F |
| Dữ liệu hợp lệ | T | T | T | F |
| **Kết quả** | Thành công (201) | Lỗi (409) | Lỗi (409) | Lỗi (400) |

### Kết quả kiểm thử

| STT | Trường hợp | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|------------|------------------|-----------------|------------|
| 1 | F-F-T | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | T-F-T | Lỗi (status 409) | Lỗi (status 409) | Passed |
| 3 | F-T-T | Lỗi (status 409) | Lỗi (status 409) | Passed |
| 4 | F-F-F | Lỗi (status 400) | Lỗi (status 400) | Passed |

## DT_002: Kiểm thử bảng quyết định cho việc cập nhật thuốc

### Mô tả
Kiểm thử các trường hợp trong bảng quyết định cho việc cập nhật thuốc.

### Bảng quyết định

| Điều kiện | Trường hợp 1 | Trường hợp 2 | Trường hợp 3 | Trường hợp 4 |
|-----------|-------------|-------------|-------------|-------------|
| Thuốc tồn tại | T | F | T | T |
| Tên thuốc đã tồn tại | F | F | T | F |
| Dữ liệu hợp lệ | T | T | T | F |
| **Kết quả** | Thành công (200) | Lỗi (404) | Lỗi (409) | Lỗi (400) |

### Kết quả kiểm thử

| STT | Trường hợp | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|------------|------------------|-----------------|------------|
| 1 | T-F-T | Thành công (status 200) | Thành công (status 200) | Passed |
| 2 | F-F-T | Lỗi (status 404) | Lỗi (status 404) | Passed |
| 3 | T-T-T | Lỗi (status 409) | Lỗi (status 409) | Passed |
| 4 | T-F-F | Lỗi (status 400) | Lỗi (status 400) | Passed |

## DT_003: Kiểm thử bảng quyết định cho việc xóa thuốc

### Mô tả
Kiểm thử các trường hợp trong bảng quyết định cho việc xóa thuốc.

### Bảng quyết định

| Điều kiện | Trường hợp 1 | Trường hợp 2 | Trường hợp 3 |
|-----------|-------------|-------------|-------------|
| Thuốc tồn tại | T | F | T |
| Thuốc đang được sử dụng bởi đơn hàng | F | F | T |
| **Kết quả** | Thành công (200) | Lỗi (404) | Lỗi (400) |

### Kết quả kiểm thử

| STT | Trường hợp | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|------------|------------------|-----------------|------------|
| 1 | T-F | Thành công (status 200) | Thành công (status 200) | Passed |
| 2 | F-F | Lỗi (status 404) | Lỗi (status 404) | Passed |
| 3 | T-T | Lỗi (status 400) | Lỗi (status 400) | Passed |

## DT_004: Kiểm thử bảng quyết định cho việc tìm kiếm thuốc

### Mô tả
Kiểm thử các trường hợp trong bảng quyết định cho việc tìm kiếm thuốc.

### Bảng quyết định

| Điều kiện | Trường hợp 1 | Trường hợp 2 | Trường hợp 3 | Trường hợp 4 | Trường hợp 5 |
|-----------|-------------|-------------|-------------|-------------|-------------|
| Tìm kiếm theo tên | T | F | F | F | T |
| Tìm kiếm theo loại thuốc | F | T | F | F | T |
| Tìm kiếm theo nhà sản xuất | F | F | T | F | T |
| Tìm kiếm theo khoảng giá | F | F | F | T | T |
| **Kết quả** | Tìm theo tên | Tìm theo loại | Tìm theo NSX | Tìm theo giá | Tìm kết hợp |

### Kết quả kiểm thử

| STT | Trường hợp | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|------------|------------------|-----------------|------------|
| 1 | T-F-F-F | Tìm kiếm theo tên thành công | Tìm kiếm theo tên thành công | Passed |
| 2 | F-T-F-F | Tìm kiếm theo loại thuốc thành công | Tìm kiếm theo loại thuốc thành công | Passed |
| 3 | F-F-T-F | Tìm kiếm theo nhà sản xuất thành công | Tìm kiếm theo nhà sản xuất thành công | Passed |
| 4 | F-F-F-T | Tìm kiếm theo khoảng giá thành công | Tìm kiếm theo khoảng giá thành công | Passed |
| 5 | T-T-T-T | Tìm kiếm kết hợp thành công | Tìm kiếm kết hợp thành công | Passed |
