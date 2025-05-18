# TEST CASE CHI TIẾT: CHỨC NĂNG QUẢN LÝ SẢN PHẨM (THUỐC)

## 1. Thông tin chung

| Thông tin | Chi tiết                                  |
| --------- | ----------------------------------------- |
| Dự án     | Hệ thống web bán và quản lý hiệu thuốc    |
| Module    | Quản lý sản phẩm                          |
| Chức năng | Thêm, sửa, xóa, tìm kiếm sản phẩm (thuốc) |
| Người tạo | Nhóm SQA                                  |
| Ngày tạo  | 15/07/2024                                |
| Phiên bản | 1.0                                       |

## 2. Các test case hiển thị và tìm kiếm sản phẩm

### TC16: Hiển thị giao diện quản lý sản phẩm

| ID   | Tên test case                       | Mô tả                                | Dữ liệu đầu vào                 | Các bước thực hiện                        | Kỳ vọng                                                                                                                 |
| :--- | :---------------------------------- | :----------------------------------- | :------------------------------ | :---------------------------------------- | :---------------------------------------------------------------------------------------------------------------------- |
| TC16 | Hiển thị giao diện quản lý sản phẩm | Admin vào giao diện quản lý sản phẩm | Admin đã đăng nhập vào hệ thống | 1. Admin click vào nút "Quản lý sản phẩm" | Giao diện quản lý sản phẩm hiển thị, bao gồm: ô tìm kiếm, danh sách sản phẩm, nút thêm mới, sửa thông tin, xóa sản phẩm |

### TC17: Tìm kiếm sản phẩm thành công

| ID   | Tên test case                | Mô tả                               | Dữ liệu đầu vào                                                                 | Các bước thực hiện                                        | Kỳ vọng                                                                                 |
| :--- | :--------------------------- | :---------------------------------- | :------------------------------------------------------------------------------ | :-------------------------------------------------------- | :-------------------------------------------------------------------------------------- |
| TC17 | Tìm kiếm sản phẩm thành công | Tìm kiếm sản phẩm thỏa mãn tiêu chí | Từ khóa: Paracetamol; Loại sản phẩm: Thuốc giảm đau; Giá bán tối đa: 50.000 VND | 1. Nhập tiêu chí vào ô tìm kiếm<br>2. Nhấn nút "Tìm kiếm" | Danh sách các sản phẩm phù hợp với tiêu chí tìm kiếm hiển thị, ví dụ: Paracetamol 500mg |

### TC18: Tìm kiếm với tên thuốc chính xác

| ID   | Tên test case                    | Mô tả                                                | Dữ liệu đầu vào        | Các bước thực hiện                                                                                                                     | Kỳ vọng                                           |
| :--- | :------------------------------- | :--------------------------------------------------- | :--------------------- | :------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------ |
| TC18 | Tìm kiếm với tên thuốc chính xác | Kiểm tra khi người dùng nhập chính xác tên của thuốc | Từ khóa: "Paracetamol" | 1. Truy cập chức năng tìm kiếm<br>2. Nhập từ khóa "Paracetamol"<br>3. Nhấn nút "Tìm kiếm"<br>4. Kiểm tra danh sách thuốc hiển thị đúng | Hiển thị danh sách các thuốc có tên "Paracetamol" |

### TC19: Tìm kiếm thuốc với từ khóa không đầy đủ

| ID   | Tên test case                           | Mô tả                                                   | Dữ liệu đầu vào | Các bước thực hiện                                              | Kỳ vọng                                                                      |
| :--- | :-------------------------------------- | :------------------------------------------------------ | :-------------- | :-------------------------------------------------------------- | :--------------------------------------------------------------------------- |
| TC19 | Tìm kiếm thuốc với từ khóa không đầy đủ | Tìm kiếm thuốc bằng từ khóa không đầy đủ nhưng gần đúng | Từ khóa: Para   | 1. Nhập từ khóa "Para" vào ô tìm kiếm<br>2. Nhấn nút "Tìm kiếm" | Danh sách hiển thị các thuốc có tên chứa "Para", ví dụ: Paracetamol, Paradol |

### TC21: Tìm kiếm thuốc với từ khóa không tồn tại

| ID   | Tên test case                            | Mô tả                                                          | Dữ liệu đầu vào   | Các bước thực hiện                                                  | Kỳ vọng                                                                              |
| :--- | :--------------------------------------- | :------------------------------------------------------------- | :---------------- | :------------------------------------------------------------------ | :----------------------------------------------------------------------------------- |
| TC21 | Tìm kiếm thuốc với từ khóa không tồn tại | Tìm kiếm thuốc bằng từ khóa không khớp với bất kỳ sản phẩm nào | Từ khóa: ThuốcXYZ | 1. Nhập từ khóa "ThuốcXYZ" vào ô tìm kiếm<br>2. Nhấn nút "Tìm kiếm" | Hệ thống hiển thị thông báo: "Không tìm thấy sản phẩm phù hợp với tiêu chí tìm kiếm" |

### TC22: Tìm kiếm thuốc với ô tìm kiếm trống

| ID   | Tên test case                       | Mô tả                                           | Dữ liệu đầu vào          | Các bước thực hiện                                             | Kỳ vọng                                           |
| :--- | :---------------------------------- | :---------------------------------------------- | :----------------------- | :------------------------------------------------------------- | :------------------------------------------------ |
| TC22 | Tìm kiếm thuốc với ô tìm kiếm trống | Nhấn tìm kiếm mà không nhập bất kỳ tiêu chí nào | Không có dữ liệu đầu vào | 1. Để trống ô tìm kiếm và các bộ lọc<br>2. Nhấn nút "Tìm kiếm" | Hệ thống hiển thị toàn bộ danh sách thuốc hiện có |

### TC23: Tìm kiếm thuốc khi không có dữ liệu

| ID   | Tên test case                       | Mô tả                                  | Dữ liệu đầu vào                    | Các bước thực hiện                                                          | Kỳ vọng                                                                              |
| :--- | :---------------------------------- | :------------------------------------- | :--------------------------------- | :-------------------------------------------------------------------------- | :----------------------------------------------------------------------------------- |
| TC23 | Tìm kiếm thuốc khi không có dữ liệu | Tìm kiếm thuốc khi cơ sở dữ liệu trống | Không có thuốc trong cơ sở dữ liệu | 1. Nhập bất kỳ từ khóa hoặc tiêu chí tìm kiếm nào<br>2. Nhấn nút "Tìm kiếm" | Hệ thống hiển thị thông báo: "Không tìm thấy sản phẩm phù hợp với tiêu chí tìm kiếm" |

## 3. Các test case chỉnh sửa thông tin sản phẩm

### TC24: Hiển thị giao diện chỉnh sửa sản phẩm

| ID   | Tên test case                         | Mô tả                                           | Dữ liệu đầu vào             | Các bước thực hiện                                       | Kỳ vọng                                                                                    |
| :--- | :------------------------------------ | :---------------------------------------------- | :-------------------------- | :------------------------------------------------------- | :----------------------------------------------------------------------------------------- |
| TC24 | Hiển thị giao diện chỉnh sửa sản phẩm | Hiển thị giao diện chỉnh sửa thông tin sản phẩm | Sản phẩm: Paracetamol 500mg | 1. Admin chọn sản phẩm từ danh sách<br>2. Nhấn nút "Sửa" | Giao diện chỉnh sửa thông tin sản phẩm hiển thị đầy đủ các thông tin hiện tại của sản phẩm |

### TC25: Chỉnh sửa thông tin thành công

| ID   | Tên test case                  | Mô tả                                                | Dữ liệu đầu vào                                                                                          | Các bước thực hiện                                                                                              | Kỳ vọng                                                                                                      |
| :--- | :----------------------------- | :--------------------------------------------------- | :------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------- |
| TC25 | Chỉnh sửa thông tin thành công | Admin chỉnh sửa thông tin sản phẩm và lưu thành công | Tên sản phẩm: Paracetamol 650mg; Giá bán: 35.000 VND; Đối tượng sử dụng: Người lớn và trẻ em trên 6 tuổi | 1. Admin chọn sản phẩm từ danh sách<br>2. Nhấn nút "Sửa"<br>3. Thay đổi thông tin sản phẩm<br>4. Nhấn nút "Lưu" | Hệ thống hiển thị thông báo: "Cập nhật thông tin sản phẩm thành công." Quay lại giao diện danh sách sản phẩm |

### TC26: Lỗi khi để trống thông tin bắt buộc

| ID   | Tên test case                       | Mô tả                                                  | Dữ liệu đầu vào                            | Các bước thực hiện                                                                                                     | Kỳ vọng                                                                               |
| :--- | :---------------------------------- | :----------------------------------------------------- | :----------------------------------------- | :--------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------ |
| TC26 | Lỗi khi để trống thông tin bắt buộc | Admin để trống trường thông tin bắt buộc khi chỉnh sửa | Tên sản phẩm: (Trống); Giá bán: 35.000 VND | 1. Admin chọn sản phẩm từ danh sách<br>2. Nhấn nút "Sửa"<br>3. Để trống trường thông tin bắt buộc<br>4. Nhấn nút "Lưu" | Hệ thống hiển thị thông báo lỗi: "Vui lòng điền đầy đủ các trường thông tin bắt buộc" |

### TC27: Sản phẩm sửa không tồn tại

| ID   | Tên test case              | Mô tả                                                             | Dữ liệu đầu vào             | Các bước thực hiện                                       | Kỳ vọng                                                              |
| :--- | :------------------------- | :---------------------------------------------------------------- | :-------------------------- | :------------------------------------------------------- | :------------------------------------------------------------------- |
| TC27 | Sản phẩm sửa không tồn tại | Admin chọn sản phẩm không tồn tại trong cơ sở dữ liệu và nhấn sửa | Sản phẩm: Thuốc X đã bị xóa | 1. Admin chọn sản phẩm từ danh sách<br>2. Nhấn nút "Sửa" | Hệ thống hiển thị thông báo: "Sản phẩm đã bị xóa hoặc không tồn tại" |

## 4. Các test case thêm thuốc

### TC28: Hiển thị giao diện thêm thuốc

| ID   | Tên test case                 | Mô tả                                  | Dữ liệu đầu vào    | Các bước thực hiện                                               | Kỳ vọng                                                            |
| :--- | :---------------------------- | :------------------------------------- | :----------------- | :--------------------------------------------------------------- | :----------------------------------------------------------------- |
| TC28 | Hiển thị giao diện thêm thuốc | Kiểm tra hiển thị giao diện thêm thuốc | Admin đã đăng nhập | 1. Nhấn vào nút "Quản lý sản phẩm"<br>2. Nhấn vào nút "Thêm mới" | Giao diện thêm thuốc hiển thị đầy đủ các trường thông tin cần nhập |

### TC29: Thêm thuốc thành công

| ID   | Tên test case         | Mô tả                              | Dữ liệu đầu vào                                                                      | Các bước thực hiện                                                                                             | Kỳ vọng                                                                                          |
| :--- | :-------------------- | :--------------------------------- | :----------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------- |
| TC29 | Thêm thuốc thành công | Kiểm tra thêm thuốc mới thành công | Tên thuốc: Paracetamol 500mg<br>Loại sản phẩm: Thuốc giảm đau<br>Giá bán: 10.000 VND | 1. Nhập thông tin đầy đủ vào các trường: Tên thuốc, loại sản phẩm, giá bán, đối tượng sử dụng<br>2. Nhấn "Lưu" | Hệ thống hiển thị thông báo: "Thêm thuốc thành công." Danh sách sản phẩm cập nhật thêm thuốc mới |

### TC30: Lỗi khi để trống thông tin bắt buộc

| ID   | Tên test case                       | Mô tả                                                    | Dữ liệu đầu vào                                                            | Các bước thực hiện                                                            | Kỳ vọng                                                                               |
| :--- | :---------------------------------- | :------------------------------------------------------- | :------------------------------------------------------------------------- | :---------------------------------------------------------------------------- | :------------------------------------------------------------------------------------ |
| TC30 | Lỗi khi để trống thông tin bắt buộc | Kiểm tra hệ thống khi bỏ trống trường thông tin bắt buộc | Tên thuốc: (Trống)<br>Loại sản phẩm: Thuốc giảm đau<br>Giá bán: 10.000 VND | 1. Nhập thông tin không đầy đủ (bỏ trống trường "Tên thuốc")<br>2. Nhấn "Lưu" | Hệ thống hiển thị thông báo lỗi: "Vui lòng điền đầy đủ các trường thông tin bắt buộc" |

### TC31: Lỗi trùng tên thuốc

| ID   | Tên test case       | Mô tả                                      | Dữ liệu đầu vào                                                                      | Các bước thực hiện                                                          | Kỳ vọng                                                                         |
| :--- | :------------------ | :----------------------------------------- | :----------------------------------------------------------------------------------- | :-------------------------------------------------------------------------- | :------------------------------------------------------------------------------ |
| TC31 | Lỗi trùng tên thuốc | Kiểm tra lỗi khi nhập tên thuốc đã tồn tại | Tên thuốc: Paracetamol 500mg<br>Loại sản phẩm: Thuốc giảm đau<br>Giá bán: 10.000 VND | 1. Nhập thông tin thuốc với tên đã tồn tại trong danh sách<br>2. Nhấn "Lưu" | Hệ thống hiển thị thông báo lỗi: "Tên thuốc đã tồn tại. Vui lòng nhập tên khác" |

### TC32: Thêm thuốc với dữ liệu không hợp lệ

| ID   | Tên test case                       | Mô tả                                           | Dữ liệu đầu vào                                      | Các bước thực hiện                                       | Kỳ vọng                                                                                  |
| :--- | :---------------------------------- | :---------------------------------------------- | :--------------------------------------------------- | :------------------------------------------------------- | :--------------------------------------------------------------------------------------- |
| TC32 | Thêm thuốc với dữ liệu không hợp lệ | Kiểm tra hệ thống khi nhập dữ liệu không hợp lệ | Tên thuốc: Paracetamol 500mg<br>Giá bán: -10.000 VND | 1. Nhập giá bán âm vào trường thông tin<br>2. Nhấn "Lưu" | Hệ thống hiển thị thông báo lỗi: "Giá bán không hợp lệ. Vui lòng nhập giá trị lớn hơn 0" |

### TC33: Hủy thao tác thêm thuốc

| ID   | Tên test case           | Mô tả                                        | Dữ liệu đầu vào | Các bước thực hiện                                                                  | Kỳ vọng                                                          |
| :--- | :---------------------- | :------------------------------------------- | :-------------- | :---------------------------------------------------------------------------------- | :--------------------------------------------------------------- |
| TC33 | Hủy thao tác thêm thuốc | Kiểm tra hành vi khi hủy thao tác thêm thuốc | Không có        | 1. Nhấn vào nút "Thêm mới"<br>2. Nhập thông tin vào các trường<br>3. Nhấn nút "Hủy" | Giao diện trở về danh sách sản phẩm, không lưu thông tin đã nhập |

### TC34: Kiểm tra giao diện khi nhập dài

| ID   | Tên test case                   | Mô tả                                                  | Dữ liệu đầu vào                | Các bước thực hiện                                        | Kỳ vọng                                                                            |
| :--- | :------------------------------ | :----------------------------------------------------- | :----------------------------- | :-------------------------------------------------------- | :--------------------------------------------------------------------------------- |
| TC34 | Kiểm tra giao diện khi nhập dài | Kiểm tra giao diện khi nhập dữ liệu quá dài vào trường | Tên thuốc: Chuỗi dài 255 ký tự | 1. Nhập chuỗi dài vào trường "Tên thuốc"<br>2. Nhấn "Lưu" | Hệ thống hiển thị thông báo lỗi: "Dữ liệu quá dài. Vui lòng nhập ít hơn 255 ký tự" |

### TC35: Kiểm tra thêm thuốc nhanh

| ID   | Tên test case             | Mô tả                                          | Dữ liệu đầu vào                                     | Các bước thực hiện                                                                        | Kỳ vọng                                                                                |
| :--- | :------------------------ | :--------------------------------------------- | :-------------------------------------------------- | :---------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------- |
| TC35 | Kiểm tra thêm thuốc nhanh | Thêm thuốc mà chỉ cần nhập các trường bắt buộc | Tên thuốc: Paracetamol 500mg<br>Giá bán: 10.000 VND | 1. Nhập thông tin tối thiểu vào các trường bắt buộc (tên thuốc, giá bán)<br>2. Nhấn "Lưu" | Hệ thống hiển thị thông báo: "Thêm thuốc thành công." Danh sách sản phẩm cập nhật đúng |

## 5. Các test case xóa thuốc

### TC36: Hiển thị giao diện xóa thuốc

| ID   | Tên test case                | Mô tả                                                        | Dữ liệu đầu vào                 | Các bước thực hiện                                                         | Kỳ vọng                                                                               |
| :--- | :--------------------------- | :----------------------------------------------------------- | :------------------------------ | :------------------------------------------------------------------------- | :------------------------------------------------------------------------------------ |
| TC36 | Hiển thị giao diện xóa thuốc | Kiểm tra hiển thị giao diện danh sách thuốc để thực hiện xóa | Admin đã đăng nhập vào hệ thống | 1. Nhấn vào nút "Quản lý sản phẩm"<br>2. Hệ thống hiển thị danh sách thuốc | Giao diện danh sách thuốc hiển thị đầy đủ với các nút xóa tương ứng cho từng sản phẩm |

### TC37: Xóa thuốc thành công

| ID   | Tên test case        | Mô tả                         | Dữ liệu đầu vào             | Các bước thực hiện                                                                                        | Kỳ vọng                                                                                        |
| :--- | :------------------- | :---------------------------- | :-------------------------- | :-------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------- |
| TC37 | Xóa thuốc thành công | Kiểm tra xóa thuốc thành công | Sản phẩm: Paracetamol 500mg | 1. Chọn sản phẩm cần xóa trong danh sách<br>2. Nhấn nút "Xóa"<br>3. Xác nhận xóa trong hộp thoại xác nhận | Hệ thống hiển thị thông báo: "Xóa sản phẩm thành công." Thuốc đã xóa không còn trong danh sách |

### TC38: Hủy thao tác xóa thuốc

| ID   | Tên test case          | Mô tả                                       | Dữ liệu đầu vào             | Các bước thực hiện                                                                                      | Kỳ vọng                                                 |
| :--- | :--------------------- | :------------------------------------------ | :-------------------------- | :------------------------------------------------------------------------------------------------------ | :------------------------------------------------------ |
| TC38 | Hủy thao tác xóa thuốc | Kiểm tra hành vi khi hủy thao tác xóa thuốc | Sản phẩm: Paracetamol 500mg | 1. Chọn sản phẩm cần xóa trong danh sách<br>2. Nhấn nút "Xóa"<br>3. Nhấn "Hủy" trong hộp thoại xác nhận | Hệ thống không xóa thuốc. Danh sách sản phẩm giữ nguyên |

### TC39: Xóa thuốc không tồn tại

| ID   | Tên test case           | Mô tả                                                         | Dữ liệu đầu vào                          | Các bước thực hiện                                                                                         | Kỳ vọng                                                              |
| :--- | :---------------------- | :------------------------------------------------------------ | :--------------------------------------- | :--------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------- |
| TC39 | Xóa thuốc không tồn tại | Kiểm tra khi xóa thuốc đã bị xóa hoặc không còn trong dữ liệu | Sản phẩm: Thuốc XYZ (đã bị xóa trước đó) | 1. Chọn sản phẩm đã bị xóa trong danh sách (do hiển thị lỗi hoặc danh sách chưa cập nhật)<br>2. Nhấn "Xóa" | Hệ thống hiển thị thông báo: "Sản phẩm đã bị xóa hoặc không tồn tại" |

### TC40: Xóa thuốc khi hệ thống gặp lỗi

| ID   | Tên test case                  | Mô tả                                       | Dữ liệu đầu vào             | Các bước thực hiện                                                                                    | Kỳ vọng                                                                                         |
| :--- | :----------------------------- | :------------------------------------------ | :-------------------------- | :---------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------- |
| TC40 | Xóa thuốc khi hệ thống gặp lỗi | Kiểm tra khi xảy ra lỗi trong quá trình xóa | Sản phẩm: Paracetamol 500mg | 1. Chọn sản phẩm cần xóa trong danh sách<br>2. Nhấn nút "Xóa"<br>3. Lỗi hệ thống xảy ra khi xử lý xóa | Hệ thống hiển thị thông báo lỗi: "Không thể xóa sản phẩm do lỗi hệ thống. Vui lòng thử lại sau" |
