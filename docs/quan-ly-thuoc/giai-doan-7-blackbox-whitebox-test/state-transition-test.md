# Kết quả kiểm thử trạng thái (State Transition Testing)

## ST_001: Kiểm thử trạng thái của thuốc (Còn hàng, Sắp hết hàng, Hết hàng)

### Mô tả
Kiểm thử các chuyển đổi trạng thái của thuốc dựa trên số lượng tồn kho.

### Sơ đồ trạng thái

```
+-------------+     Số lượng <= ngưỡng cảnh báo     +----------------+
|             | ---------------------------------->  |                |
|  Còn hàng   |                                      |  Sắp hết hàng  |
|             |  <----------------------------------  |                |
+-------------+     Số lượng > ngưỡng cảnh báo      +----------------+
      ^                                                      |
      |                                                      |
      |                                                      |
      |                                                      |
      |                Số lượng > 0                          |
      |                                                      |
      |                                                      v
      |                                              +----------------+
      |                                              |                |
      +----------------------------------------------+   Hết hàng     |
                    Số lượng = 0                     |                |
                                                     +----------------+
```

### Kết quả kiểm thử

| STT | Chuyển đổi trạng thái | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------|------------------|-----------------|------------|
| 1 | Còn hàng -> Sắp hết hàng | Số lượng giảm xuống dưới ngưỡng cảnh báo | Trạng thái chuyển thành "Sắp hết hàng" | Trạng thái chuyển thành "Sắp hết hàng" | Passed |
| 2 | Sắp hết hàng -> Hết hàng | Số lượng giảm xuống 0 | Trạng thái chuyển thành "Hết hàng" | Trạng thái chuyển thành "Hết hàng" | Passed |
| 3 | Hết hàng -> Còn hàng | Nhập thêm thuốc với số lượng > ngưỡng cảnh báo | Trạng thái chuyển thành "Còn hàng" | Trạng thái chuyển thành "Còn hàng" | Passed |
| 4 | Sắp hết hàng -> Còn hàng | Nhập thêm thuốc với số lượng > ngưỡng cảnh báo | Trạng thái chuyển thành "Còn hàng" | Trạng thái chuyển thành "Còn hàng" | Passed |

## ST_002: Kiểm thử trạng thái của thuốc (Còn hạn, Sắp hết hạn, Hết hạn)

### Mô tả
Kiểm thử các chuyển đổi trạng thái của thuốc dựa trên hạn sử dụng.

### Sơ đồ trạng thái

```
+-------------+     Hạn sử dụng <= ngày hiện tại + 30 ngày     +----------------+
|             | --------------------------------------------->  |                |
|  Còn hạn    |                                                 |  Sắp hết hạn   |
|             |  <---------------------------------------------  |                |
+-------------+     Hạn sử dụng > ngày hiện tại + 30 ngày      +----------------+
      ^                                                                 |
      |                                                                 |
      |                                                                 |
      |                                                                 |
      |                Hạn sử dụng > ngày hiện tại                     |
      |                                                                 |
      |                                                                 v
      |                                                         +----------------+
      |                                                         |                |
      +---------------------------------------------------------+   Hết hạn      |
                    Hạn sử dụng <= ngày hiện tại               |                |
                                                               +----------------+
```

### Kết quả kiểm thử

| STT | Chuyển đổi trạng thái | Điều kiện | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----|----------------------|-----------|------------------|-----------------|------------|
| 1 | Còn hạn -> Sắp hết hạn | Hạn sử dụng còn dưới 30 ngày | Trạng thái chuyển thành "Sắp hết hạn" | Trạng thái chuyển thành "Sắp hết hạn" | Passed |
| 2 | Sắp hết hạn -> Hết hạn | Hạn sử dụng đã qua | Trạng thái chuyển thành "Hết hạn" | Trạng thái chuyển thành "Hết hạn" | Passed |
| 3 | Hết hạn -> Còn hạn | Cập nhật hạn sử dụng mới > ngày hiện tại + 30 ngày | Trạng thái chuyển thành "Còn hạn" | Trạng thái chuyển thành "Còn hạn" | Passed |
| 4 | Sắp hết hạn -> Còn hạn | Cập nhật hạn sử dụng mới > ngày hiện tại + 30 ngày | Trạng thái chuyển thành "Còn hạn" | Trạng thái chuyển thành "Còn hạn" | Passed |
