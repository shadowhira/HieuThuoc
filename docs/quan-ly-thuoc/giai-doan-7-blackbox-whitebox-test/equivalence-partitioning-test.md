# Kết quả kiểm thử phân vùng tương đương (Equivalence Partitioning)

## EP_001: Kiểm thử phân vùng tương đương - Tên thuốc

### Mô tả
Kiểm thử các phân vùng tương đương của trường tên thuốc.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Tên thuốc hợp lệ | "Paracetamol 500mg" | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Tên thuốc rỗng | "" | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Tên thuốc quá dài | Chuỗi 256 ký tự | Lỗi (status 400) | Lỗi (status 400) | Passed |

## EP_002: Kiểm thử phân vùng tương đương - Mã thuốc

### Mô tả
Kiểm thử các phân vùng tương đương của trường mã thuốc.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Mã thuốc hợp lệ | "PARA500" | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Mã thuốc rỗng | "" | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Mã thuốc quá dài | Chuỗi 51 ký tự | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 4 | Mã thuốc đã tồn tại | "PARA500" (đã tồn tại) | Lỗi (status 409) | Lỗi (status 409) | Passed |

## EP_003: Kiểm thử phân vùng tương đương - Loại thuốc

### Mô tả
Kiểm thử các phân vùng tương đương của trường loại thuốc.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Loại thuốc hợp lệ | ID = 1 (tồn tại) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Loại thuốc không hợp lệ | ID = 999 (không tồn tại) | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Loại thuốc null | null | Lỗi (status 400) | Lỗi (status 400) | Passed |

## EP_004: Kiểm thử phân vùng tương đương - Danh mục thuốc

### Mô tả
Kiểm thử các phân vùng tương đương của trường danh mục thuốc.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Danh mục thuốc hợp lệ | ID = 1 (tồn tại) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Danh mục thuốc không hợp lệ | ID = 999 (không tồn tại) | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Danh mục thuốc null | null | Lỗi (status 400) | Lỗi (status 400) | Passed |

## EP_005: Kiểm thử phân vùng tương đương - Nhà sản xuất

### Mô tả
Kiểm thử các phân vùng tương đương của trường nhà sản xuất.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Nhà sản xuất hợp lệ | ID = 1 (tồn tại) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Nhà sản xuất không hợp lệ | ID = 999 (không tồn tại) | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Nhà sản xuất null | null | Lỗi (status 400) | Lỗi (status 400) | Passed |

## EP_006: Kiểm thử phân vùng tương đương - Đơn vị tính

### Mô tả
Kiểm thử các phân vùng tương đương của trường đơn vị tính.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Đơn vị tính hợp lệ | "Viên" | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Đơn vị tính rỗng | "" | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Đơn vị tính quá dài | Chuỗi 51 ký tự | Lỗi (status 400) | Lỗi (status 400) | Passed |

## EP_007: Kiểm thử phân vùng tương đương - Hàm lượng

### Mô tả
Kiểm thử các phân vùng tương đương của trường hàm lượng.

### Kết quả kiểm thử

| STT | Phân vùng tương đương | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------------|------------------|-----------------|------------|
| 1 | Hàm lượng hợp lệ | "500mg" | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Hàm lượng rỗng | "" | Lỗi (status 400) | Lỗi (status 400) | Passed |
| 3 | Hàm lượng quá dài | Chuỗi 51 ký tự | Lỗi (status 400) | Lỗi (status 400) | Passed |
