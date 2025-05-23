# Kết quả kiểm thử phân tích giá trị biên (Boundary Value Analysis)

## BB_001: Kiểm thử phân tích giá trị biên - Giá nhập

### Mô tả
Kiểm thử các giá trị biên của trường giá nhập trong thuốc.

### Kết quả kiểm thử

| STT | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------------|------------------|-----------------|------------|
| 1 | Giá nhập = 0 (biên dưới) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Giá nhập = 1 (biên dưới + 1) | Thành công (status 201) | Thành công (status 201) | Passed |
| 3 | Giá nhập = 999999999 (biên trên) | Thành công (status 201) | Thành công (status 201) | Passed |
| 4 | Giá nhập = -1 (dưới biên dưới) | Lỗi (status 400) | Lỗi (status 400) | Passed |

## BB_002: Kiểm thử phân tích giá trị biên - Giá bán

### Mô tả
Kiểm thử các giá trị biên của trường giá bán trong thuốc.

### Kết quả kiểm thử

| STT | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------------|------------------|-----------------|------------|
| 1 | Giá bán = 0 (biên dưới) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Giá bán = 1 (biên dưới + 1) | Thành công (status 201) | Thành công (status 201) | Passed |
| 3 | Giá bán = 999999999 (biên trên) | Thành công (status 201) | Thành công (status 201) | Passed |
| 4 | Giá bán = -1 (dưới biên dưới) | Lỗi (status 400) | Lỗi (status 400) | Passed |

## BB_003: Kiểm thử phân tích giá trị biên - Số lượng

### Mô tả
Kiểm thử các giá trị biên của trường số lượng trong thuốc.

### Kết quả kiểm thử

| STT | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------------|------------------|-----------------|------------|
| 1 | Số lượng = 0 (biên dưới) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Số lượng = 1 (biên dưới + 1) | Thành công (status 201) | Thành công (status 201) | Passed |
| 3 | Số lượng = 999999 (biên trên) | Thành công (status 201) | Thành công (status 201) | Passed |
| 4 | Số lượng = -1 (dưới biên dưới) | Lỗi (status 400) | Lỗi (status 400) | Passed |

## BB_004: Kiểm thử phân tích giá trị biên - Hạn sử dụng

### Mô tả
Kiểm thử các giá trị biên của trường hạn sử dụng trong thuốc.

### Kết quả kiểm thử

| STT | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------------|------------------|-----------------|------------|
| 1 | Hạn sử dụng = ngày hiện tại (biên dưới) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Hạn sử dụng = ngày hiện tại + 1 ngày (biên dưới + 1) | Thành công (status 201) | Thành công (status 201) | Passed |
| 3 | Hạn sử dụng = ngày hiện tại + 10 năm (biên trên) | Thành công (status 201) | Thành công (status 201) | Passed |
| 4 | Hạn sử dụng = ngày hiện tại - 1 ngày (dưới biên dưới) | Lỗi (status 400) | Lỗi (status 400) | Passed |

## BB_005: Kiểm thử phân tích giá trị biên - Độ tuổi sử dụng

### Mô tả
Kiểm thử các giá trị biên của trường độ tuổi sử dụng trong thuốc.

### Kết quả kiểm thử

| STT | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------------|------------------|-----------------|------------|
| 1 | Độ tuổi = 0 (biên dưới) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Độ tuổi = 1 (biên dưới + 1) | Thành công (status 201) | Thành công (status 201) | Passed |
| 3 | Độ tuổi = 100 (biên trên) | Thành công (status 201) | Thành công (status 201) | Passed |
| 4 | Độ tuổi = -1 (dưới biên dưới) | Lỗi (status 400) | Lỗi (status 400) | Passed |

## BB_006: Kiểm thử phân tích giá trị biên - Liều lượng

### Mô tả
Kiểm thử các giá trị biên của trường liều lượng trong thuốc.

### Kết quả kiểm thử

| STT | Giá trị kiểm thử | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------------|------------------|-----------------|------------|
| 1 | Liều lượng = 0 (biên dưới) | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Liều lượng = 0.1 (biên dưới + 0.1) | Thành công (status 201) | Thành công (status 201) | Passed |
| 3 | Liều lượng = 1000 (biên trên) | Thành công (status 201) | Thành công (status 201) | Passed |
| 4 | Liều lượng = -0.1 (dưới biên dưới) | Lỗi (status 400) | Lỗi (status 400) | Passed |
