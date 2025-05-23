# Kết quả kiểm thử phân tích đường dẫn (Path Analysis)

## WB_001: Kiểm thử phân tích đường dẫn - Phương thức create()

### Mô tả
Kiểm thử các đường dẫn trong phương thức create() của ThuocService.

### Sơ đồ đường dẫn

```
Start
  |
  v
Kiểm tra mã thuốc đã tồn tại?
  |
  +---> [Có] ---> Trả về lỗi 409
  |
  +---> [Không] ---> Kiểm tra tên thuốc đã tồn tại?
                       |
                       +---> [Có] ---> Trả về lỗi 409
                       |
                       +---> [Không] ---> Kiểm tra dữ liệu hợp lệ?
                                            |
                                            +---> [Không] ---> Trả về lỗi 400
                                            |
                                            +---> [Có] ---> Lưu thuốc vào database
                                                              |
                                                              v
                                                           Trả về thành công 201
                                                              |
                                                              v
                                                            End
```

### Kết quả kiểm thử

| STT | Đường dẫn | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------|-----------|------------------|-----------------|------------|
| 1 | Đường dẫn thành công | Mã thuốc chưa tồn tại, tên thuốc chưa tồn tại, dữ liệu hợp lệ | Thành công (status 201) | Thành công (status 201) | Passed |
| 2 | Đường dẫn thất bại (mã thuốc đã tồn tại) | Mã thuốc đã tồn tại | Lỗi (status 409) | Lỗi (status 409) | Passed |
| 3 | Đường dẫn thất bại (tên thuốc đã tồn tại) | Mã thuốc chưa tồn tại, tên thuốc đã tồn tại | Lỗi (status 409) | Lỗi (status 409) | Passed |
| 4 | Đường dẫn thất bại (dữ liệu không hợp lệ) | Mã thuốc chưa tồn tại, tên thuốc chưa tồn tại, dữ liệu không hợp lệ | Lỗi (status 400) | Lỗi (status 400) | Passed |

## WB_002: Kiểm thử phân tích đường dẫn - Phương thức update()

### Mô tả
Kiểm thử các đường dẫn trong phương thức update() của ThuocService.

### Sơ đồ đường dẫn

```
Start
  |
  v
Kiểm tra thuốc tồn tại?
  |
  +---> [Không] ---> Trả về lỗi 404
  |
  +---> [Có] ---> Kiểm tra tên thuốc đã tồn tại?
                    |
                    +---> [Có] ---> Trả về lỗi 409
                    |
                    +---> [Không] ---> Kiểm tra dữ liệu hợp lệ?
                                         |
                                         +---> [Không] ---> Trả về lỗi 400
                                         |
                                         +---> [Có] ---> Cập nhật thuốc trong database
                                                           |
                                                           v
                                                        Trả về thành công 200
                                                           |
                                                           v
                                                         End
```

### Kết quả kiểm thử

| STT | Đường dẫn | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------|-----------|------------------|-----------------|------------|
| 1 | Đường dẫn thành công | Thuốc tồn tại, tên thuốc chưa tồn tại, dữ liệu hợp lệ | Thành công (status 200) | Thành công (status 200) | Passed |
| 2 | Đường dẫn thất bại (thuốc không tồn tại) | Thuốc không tồn tại | Lỗi (status 404) | Lỗi (status 404) | Passed |
| 3 | Đường dẫn thất bại (tên thuốc đã tồn tại) | Thuốc tồn tại, tên thuốc đã tồn tại | Lỗi (status 409) | Lỗi (status 409) | Passed |
| 4 | Đường dẫn thất bại (dữ liệu không hợp lệ) | Thuốc tồn tại, tên thuốc chưa tồn tại, dữ liệu không hợp lệ | Lỗi (status 400) | Lỗi (status 400) | Passed |

## WB_003: Kiểm thử phân tích đường dẫn - Phương thức delete()

### Mô tả
Kiểm thử các đường dẫn trong phương thức delete() của ThuocService.

### Sơ đồ đường dẫn

```
Start
  |
  v
Kiểm tra thuốc tồn tại?
  |
  +---> [Không] ---> Trả về lỗi 404
  |
  +---> [Có] ---> Kiểm tra thuốc đang được sử dụng?
                    |
                    +---> [Có] ---> Trả về lỗi 400
                    |
                    +---> [Không] ---> Xóa thuốc khỏi database
                                         |
                                         +---> [Lỗi] ---> Trả về lỗi 500
                                         |
                                         +---> [Thành công] ---> Trả về thành công 200
                                                                   |
                                                                   v
                                                                 End
```

### Kết quả kiểm thử

| STT | Đường dẫn | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------|-----------|------------------|-----------------|------------|
| 1 | Đường dẫn thành công | Thuốc tồn tại, thuốc không đang được sử dụng | Thành công (status 200) | Thành công (status 200) | Passed |
| 2 | Đường dẫn thất bại (thuốc không tồn tại) | Thuốc không tồn tại | Lỗi (status 404) | Lỗi (status 404) | Passed |
| 3 | Đường dẫn thất bại (lỗi khi xóa) | Thuốc tồn tại, lỗi khi xóa | Lỗi (status 500) | Lỗi (status 500) | Passed |

## WB_004: Kiểm thử phân tích đường dẫn - Phương thức search()

### Mô tả
Kiểm thử các đường dẫn trong phương thức search() của ThuocService.

### Kết quả kiểm thử

| STT | Đường dẫn | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------|-----------|------------------|-----------------|------------|
| 1 | Đường dẫn với nhiều điều kiện tìm kiếm | Tìm kiếm với nhiều tiêu chí | Thành công (status 200) | Thành công (status 200) | Passed |
| 2 | Đường dẫn với một điều kiện tìm kiếm | Tìm kiếm với một tiêu chí | Thành công (status 200) | Thành công (status 200) | Passed |
| 3 | Đường dẫn không có điều kiện tìm kiếm | Tìm kiếm không có tiêu chí | Thành công (status 200) | Thành công (status 200) | Passed |
| 4 | Đường dẫn với kết quả trống | Tìm kiếm không có kết quả | Thành công (status 200) với danh sách rỗng | Thành công (status 200) với danh sách rỗng | Passed |

## WB_005: Kiểm thử phân tích đường dẫn - Phương thức getThuocBanChay()

### Mô tả
Kiểm thử các đường dẫn trong phương thức getThuocBanChay() của ThuocService.

### Kết quả kiểm thử

| STT | Đường dẫn | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|-----------|-----------|------------------|-----------------|------------|
| 1 | Đường dẫn thành công | Có dữ liệu thuốc bán chạy | Thành công (status 200) | Thành công (status 200) | Passed |
| 2 | Đường dẫn không có dữ liệu | Không có dữ liệu thuốc bán chạy | Thành công (status 200) với danh sách rỗng | Thành công (status 200) với danh sách rỗng | Passed |
| 3 | Đường dẫn với limit khác nhau | Limit = 5, 10, 20 | Thành công (status 200) với số lượng phù hợp | Thành công (status 200) với số lượng phù hợp | Passed |
